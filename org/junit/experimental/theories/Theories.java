package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Theories extends BlockJUnit4ClassRunner {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TheoryAnchor extends Statement {
        private final TestClass testClass;
        private final FrameworkMethod testMethod;
        private int successes = 0;
        private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();

        public TheoryAnchor(FrameworkMethod frameworkMethod, TestClass testClass) {
            this.testMethod = frameworkMethod;
            this.testClass = testClass;
        }

        private TestClass getTestClass() {
            return this.testClass;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Statement methodCompletesWithParameters(final FrameworkMethod frameworkMethod, final Assignments assignments, final Object obj) {
            return new Statement() { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.2
                @Override // org.junit.runners.model.Statement
                public void evaluate() throws Throwable {
                    Object[] methodArguments = assignments.getMethodArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(methodArguments);
                    }
                    frameworkMethod.invokeExplosively(obj, methodArguments);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean nullsOk() {
            Theory theory = (Theory) this.testMethod.getMethod().getAnnotation(Theory.class);
            if (theory == null) {
                return false;
            }
            return theory.nullsAccepted();
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            boolean z16;
            runWithAssignment(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
            if (this.testMethod.getAnnotation(Theory.class) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.successes == 0 && z16) {
                Assert.fail("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.fInvalidParameters);
            }
        }

        protected void handleAssumptionViolation(AssumptionViolatedException assumptionViolatedException) {
            this.fInvalidParameters.add(assumptionViolatedException);
        }

        protected void handleDataPointSuccess() {
            this.successes++;
        }

        protected void reportParameterizedError(Throwable th5, Object... objArr) throws Throwable {
            if (objArr.length == 0) {
                throw th5;
            }
            throw new ParameterizedAssertionError(th5, this.testMethod.getName(), objArr);
        }

        protected void runWithAssignment(Assignments assignments) throws Throwable {
            if (!assignments.isComplete()) {
                runWithIncompleteAssignment(assignments);
            } else {
                runWithCompleteAssignment(assignments);
            }
        }

        protected void runWithCompleteAssignment(final Assignments assignments) throws Throwable {
            new BlockJUnit4ClassRunner(getTestClass().getJavaClass()) { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.1
                @Override // org.junit.runners.BlockJUnit4ClassRunner
                public Object createTest() throws Exception {
                    Object[] constructorArguments = assignments.getConstructorArguments();
                    if (!TheoryAnchor.this.nullsOk()) {
                        Assume.assumeNotNull(constructorArguments);
                    }
                    return getTestClass().getOnlyConstructor().newInstance(constructorArguments);
                }

                @Override // org.junit.runners.BlockJUnit4ClassRunner
                public Statement methodBlock(FrameworkMethod frameworkMethod) {
                    final Statement methodBlock = super.methodBlock(frameworkMethod);
                    return new Statement() { // from class: org.junit.experimental.theories.Theories.TheoryAnchor.1.1
                        @Override // org.junit.runners.model.Statement
                        public void evaluate() throws Throwable {
                            try {
                                methodBlock.evaluate();
                                TheoryAnchor.this.handleDataPointSuccess();
                            } catch (AssumptionViolatedException e16) {
                                TheoryAnchor.this.handleAssumptionViolation(e16);
                            } catch (Throwable th5) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                TheoryAnchor theoryAnchor = TheoryAnchor.this;
                                theoryAnchor.reportParameterizedError(th5, assignments.getArgumentStrings(theoryAnchor.nullsOk()));
                            }
                        }
                    };
                }

                @Override // org.junit.runners.BlockJUnit4ClassRunner
                protected Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
                    return TheoryAnchor.this.methodCompletesWithParameters(frameworkMethod, assignments, obj);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
                public void collectInitializationErrors(List<Throwable> list) {
                }
            }.methodBlock(this.testMethod).evaluate();
        }

        protected void runWithIncompleteAssignment(Assignments assignments) throws Throwable {
            Iterator<PotentialAssignment> it = assignments.potentialsForNextUnassigned().iterator();
            while (it.hasNext()) {
                runWithAssignment(assignments.assignNext(it.next()));
            }
        }
    }

    public Theories(Class<?> cls) throws InitializationError {
        super(cls);
    }

    private void validateDataPointFields(List<Throwable> list) {
        for (Field field : getTestClass().getJavaClass().getDeclaredFields()) {
            if (field.getAnnotation(DataPoint.class) != null || field.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void validateDataPointMethods(List<Throwable> list) {
        for (Method method : getTestClass().getJavaClass().getDeclaredMethods()) {
            if (method.getAnnotation(DataPoint.class) != null || method.getAnnotation(DataPoints.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    private void validateParameterSupplier(Class<? extends ParameterSupplier> cls, List<Throwable> list) {
        Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class<?>[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length != 0 && !parameterTypes[0].equals(TestClass.class)) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.BlockJUnit4ClassRunner, org.junit.runners.ParentRunner
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        validateDataPointFields(list);
        validateDataPointMethods(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public List<FrameworkMethod> computeTestMethods() {
        ArrayList arrayList = new ArrayList(super.computeTestMethods());
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Theory.class);
        arrayList.removeAll(annotatedMethods);
        arrayList.addAll(annotatedMethods);
        return arrayList;
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        return new TheoryAnchor(frameworkMethod, getTestClass());
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected void validateTestMethods(List<Throwable> list) {
        for (FrameworkMethod frameworkMethod : computeTestMethods()) {
            if (frameworkMethod.getAnnotation(Theory.class) != null) {
                frameworkMethod.validatePublicVoid(false, list);
                frameworkMethod.validateNoTypeParametersOnArgs(list);
            } else {
                frameworkMethod.validatePublicVoidNoArg(false, list);
            }
            Iterator<ParameterSignature> it = ParameterSignature.signatures(frameworkMethod.getMethod()).iterator();
            while (it.hasNext()) {
                ParametersSuppliedBy parametersSuppliedBy = (ParametersSuppliedBy) it.next().findDeepAnnotation(ParametersSuppliedBy.class);
                if (parametersSuppliedBy != null) {
                    validateParameterSupplier(parametersSuppliedBy.value(), list);
                }
            }
        }
    }
}
