package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AllMembersSupplier extends ParameterSupplier {
    private final TestClass clazz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MethodParameterValue extends PotentialAssignment {
        private final FrameworkMethod method;

        @Override // org.junit.experimental.theories.PotentialAssignment
        public String getDescription() throws PotentialAssignment.CouldNotGenerateValueException {
            return this.method.getName();
        }

        @Override // org.junit.experimental.theories.PotentialAssignment
        public Object getValue() throws PotentialAssignment.CouldNotGenerateValueException {
            boolean z16 = false;
            try {
                return this.method.invokeExplosively(null, new Object[0]);
            } catch (IllegalAccessException unused) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (IllegalArgumentException unused2) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (Throwable th5) {
                DataPoint dataPoint = (DataPoint) this.method.getAnnotation(DataPoint.class);
                if (dataPoint == null || !AllMembersSupplier.isAssignableToAnyOf(dataPoint.ignoredExceptions(), th5)) {
                    z16 = true;
                }
                Assume.assumeTrue(z16);
                throw new PotentialAssignment.CouldNotGenerateValueException(th5);
            }
        }

        MethodParameterValue(FrameworkMethod frameworkMethod) {
            this.method = frameworkMethod;
        }
    }

    public AllMembersSupplier(TestClass testClass) {
        this.clazz = testClass;
    }

    private void addArrayValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        for (int i3 = 0; i3 < Array.getLength(obj); i3++) {
            Object obj2 = Array.get(obj, i3);
            if (parameterSignature.canAcceptValue(obj2)) {
                list.add(PotentialAssignment.forValue(str + "[" + i3 + "]", obj2));
            }
        }
    }

    private void addDataPointsValues(Class<?> cls, ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        if (cls.isArray()) {
            addArrayValues(parameterSignature, str, list, obj);
        } else if (Iterable.class.isAssignableFrom(cls)) {
            addIterableValues(parameterSignature, str, list, (Iterable) obj);
        }
    }

    private void addIterableValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Iterable<?> iterable) {
        int i3 = 0;
        for (Object obj : iterable) {
            if (parameterSignature.canAcceptValue(obj)) {
                list.add(PotentialAssignment.forValue(str + "[" + i3 + "]", obj));
            }
            i3++;
        }
    }

    private void addMultiPointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field field : getDataPointsFields(parameterSignature)) {
            addDataPointsValues(field.getType(), parameterSignature, field.getName(), list, getStaticFieldValue(field));
        }
    }

    private void addMultiPointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) throws Throwable {
        for (FrameworkMethod frameworkMethod : getDataPointsMethods(parameterSignature)) {
            Class<?> returnType = frameworkMethod.getReturnType();
            if ((returnType.isArray() && parameterSignature.canPotentiallyAcceptType(returnType.getComponentType())) || Iterable.class.isAssignableFrom(returnType)) {
                try {
                    addDataPointsValues(returnType, parameterSignature, frameworkMethod.getName(), list, frameworkMethod.invokeExplosively(null, new Object[0]));
                } catch (Throwable th5) {
                    DataPoints dataPoints = (DataPoints) frameworkMethod.getAnnotation(DataPoints.class);
                    if (dataPoints != null && isAssignableToAnyOf(dataPoints.ignoredExceptions(), th5)) {
                        return;
                    } else {
                        throw th5;
                    }
                }
            }
        }
    }

    private void addSinglePointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field field : getSingleDataPointFields(parameterSignature)) {
            Object staticFieldValue = getStaticFieldValue(field);
            if (parameterSignature.canAcceptValue(staticFieldValue)) {
                list.add(PotentialAssignment.forValue(field.getName(), staticFieldValue));
            }
        }
    }

    private void addSinglePointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (FrameworkMethod frameworkMethod : getSingleDataPointMethods(parameterSignature)) {
            if (parameterSignature.canAcceptType(frameworkMethod.getType())) {
                list.add(new MethodParameterValue(frameworkMethod));
            }
        }
    }

    private Object getStaticFieldValue(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        } catch (IllegalArgumentException unused2) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAssignableToAnyOf(Class<?>[] clsArr, Object obj) {
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<Field> getDataPointsFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoints.class);
        ArrayList arrayList = new ArrayList();
        Iterator<FrameworkField> it = annotatedFields.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getField());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoints.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<Field> getSingleDataPointFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoint.class);
        ArrayList arrayList = new ArrayList();
        Iterator<FrameworkField> it = annotatedFields.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getField());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoint.class);
    }

    @Override // org.junit.experimental.theories.ParameterSupplier
    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) throws Throwable {
        ArrayList arrayList = new ArrayList();
        addSinglePointFields(parameterSignature, arrayList);
        addMultiPointFields(parameterSignature, arrayList);
        addSinglePointMethods(parameterSignature, arrayList);
        addMultiPointMethods(parameterSignature, arrayList);
        return arrayList;
    }
}
