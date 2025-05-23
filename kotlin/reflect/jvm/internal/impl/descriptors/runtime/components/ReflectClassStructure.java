package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
final class ReflectClassStructure {

    @NotNull
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i3 = 0;
        while (cls.isArray()) {
            i3++;
            cls = cls.getComponentType();
            Intrinsics.checkNotNullExpressionValue(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (Intrinsics.areEqual(cls, Void.TYPE)) {
                ClassId classId = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
                Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.unit.toSafe())");
                return new ClassLiteralValue(classId, i3);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "get(currentClass.name).primitiveType");
            if (i3 > 0) {
                ClassId classId2 = ClassId.topLevel(primitiveType.getArrayTypeFqName());
                Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(primitiveType.arrayTypeFqName)");
                return new ClassLiteralValue(classId2, i3 - 1);
            }
            ClassId classId3 = ClassId.topLevel(primitiveType.getTypeFqName());
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(primitiveType.typeFqName)");
            return new ClassLiteralValue(classId3, i3);
        }
        ClassId classId4 = ReflectClassUtilKt.getClassId(cls);
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqName asSingleFqName = classId4.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "javaClassId.asSingleFqName()");
        ClassId mapJavaToKotlin = javaToKotlinClassMap.mapJavaToKotlin(asSingleFqName);
        if (mapJavaToKotlin != null) {
            classId4 = mapJavaToKotlin;
        }
        return new ClassLiteralValue(classId4, i3);
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        boolean z16;
        Constructor<?>[] constructorArr;
        int i3;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i16 = 0;
        while (i16 < length) {
            Constructor<?> constructor = declaredConstructors[i16];
            Name name = SpecialNames.INIT;
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(name, signatureSerializer.constructorDesc(constructor));
            if (visitMethod == null) {
                constructorArr = declaredConstructors;
                i3 = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "constructor.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "parameterAnnotations");
                if (parameterAnnotations.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i17 = 0; i17 < length3; i17++) {
                        Annotation[] annotations = parameterAnnotations[i17];
                        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
                        int length4 = annotations.length;
                        int i18 = 0;
                        while (i18 < length4) {
                            Annotation annotation2 = annotations[i18];
                            Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i19 = length;
                            ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                            int i26 = length2;
                            Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i17 + length2, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                            }
                            i18++;
                            declaredConstructors = constructorArr2;
                            length = i19;
                            length2 = i26;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i3 = length;
                visitMethod.visitEnd();
            }
            i16++;
            declaredConstructors = constructorArr;
            length = i3;
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(field.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(field, "field");
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), null);
            if (visitField != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "field.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i3 = 0;
        while (i3 < length) {
            Method method = declaredMethods[i3];
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(method, "method");
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitMethod == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length2 = annotationArr.length;
                for (int i16 = 0; i16 < length2; i16++) {
                    Annotation[] annotations = annotationArr[i16];
                    Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
                    int length3 = annotations.length;
                    int i17 = 0;
                    while (i17 < length3) {
                        Annotation annotation2 = annotations[i17];
                        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Method[] methodArr2 = declaredMethods;
                        Intrinsics.checkNotNullExpressionValue(annotation2, "annotation");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i16, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                        i17++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                visitMethod.visitEnd();
            }
            i3++;
            declaredMethods = methodArr;
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            INSTANCE.processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name, Object obj) {
        Set set;
        Object single;
        Class<?> cls = obj.getClass();
        if (!Intrinsics.areEqual(cls, Class.class)) {
            set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
            if (set.contains(cls)) {
                annotationArgumentVisitor.visit(name, obj);
                return;
            }
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                Intrinsics.checkNotNullExpressionValue(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                ClassId classId = ReflectClassUtilKt.getClassId(cls);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                Name identifier = Name.identifier(((Enum) obj).name());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier((value as Enum<*>).name)");
                annotationArgumentVisitor.visitEnum(name, classId, identifier);
                return;
            }
            if (Annotation.class.isAssignableFrom(cls)) {
                Class<?>[] interfaces = cls.getInterfaces();
                Intrinsics.checkNotNullExpressionValue(interfaces, "clazz.interfaces");
                single = ArraysKt___ArraysKt.single(interfaces);
                Class<?> annotationClass = (Class) single;
                Intrinsics.checkNotNullExpressionValue(annotationClass, "annotationClass");
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(annotationClass));
                if (visitAnnotation == null) {
                    return;
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Annotation");
                processAnnotationArguments(visitAnnotation, (Annotation) obj, annotationClass);
                return;
            }
            if (cls.isArray()) {
                KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name);
                if (visitArray == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i3 = 0;
                if (componentType.isEnum()) {
                    Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                    ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i3 < length) {
                        Object obj2 = objArr[i3];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        Name identifier2 = Name.identifier(((Enum) obj2).name());
                        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier((element as Enum<*>).name)");
                        visitArray.visitEnum(classId2, identifier2);
                        i3++;
                    }
                } else if (Intrinsics.areEqual(componentType, Class.class)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i3 < length2) {
                        Object obj3 = objArr2[i3];
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                        i3++;
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i3 < length3) {
                        Object obj4 = objArr3[i3];
                        Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation2 = visitArray.visitAnnotation(ReflectClassUtilKt.getClassId(componentType));
                        if (visitAnnotation2 != null) {
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            processAnnotationArguments(visitAnnotation2, (Annotation) obj4, componentType);
                        }
                        i3++;
                    }
                } else {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i3 < length4) {
                        visitArray.visit(objArr4[i3]);
                        i3++;
                    }
                }
                visitArray.visitEnd();
                return;
            }
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Class<*>");
        annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((Class) obj));
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                Intrinsics.checkNotNull(invoke);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(method.name)");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void loadClassAnnotations(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.AnnotationVisitor visitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            Intrinsics.checkNotNullExpressionValue(annotation, "annotation");
            processAnnotation(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void visitMembers(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        loadMethodAnnotations(klass, memberVisitor);
        loadConstructorAnnotations(klass, memberVisitor);
        loadFieldAnnotations(klass, memberVisitor);
    }
}
