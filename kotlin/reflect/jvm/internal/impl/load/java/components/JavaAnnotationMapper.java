package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaAnnotationMapper {

    @NotNull
    private static final Name DEPRECATED_ANNOTATION_MESSAGE;

    @NotNull
    public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();

    @NotNull
    private static final Name RETENTION_ANNOTATION_VALUE;

    @NotNull
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;

    @NotNull
    private static final Map<FqName, FqName> kotlinToJavaNameMap;

    static {
        Map<FqName, FqName> mapOf;
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"message\")");
        DEPRECATED_ANNOTATION_MESSAGE = identifier;
        Name identifier2 = Name.identifier("allowedTargets");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"allowedTargets\")");
        TARGET_ANNOTATION_ALLOWED_TARGETS = identifier2;
        Name identifier3 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"value\")");
        RETENTION_ANNOTATION_VALUE = identifier3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(StandardNames.FqNames.target, JvmAnnotationNames.TARGET_ANNOTATION), TuplesKt.to(StandardNames.FqNames.retention, JvmAnnotationNames.RETENTION_ANNOTATION), TuplesKt.to(StandardNames.FqNames.mustBeDocumented, JvmAnnotationNames.DOCUMENTED_ANNOTATION));
        kotlinToJavaNameMap = mapOf;
    }

    JavaAnnotationMapper() {
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper javaAnnotationMapper, JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaResolverContext, z16);
    }

    @Nullable
    public final AnnotationDescriptor findMappedJavaAnnotation(@NotNull FqName kotlinName, @NotNull JavaAnnotationOwner annotationOwner, @NotNull LazyJavaResolverContext c16) {
        JavaAnnotation findAnnotation;
        Intrinsics.checkNotNullParameter(kotlinName, "kotlinName");
        Intrinsics.checkNotNullParameter(annotationOwner, "annotationOwner");
        Intrinsics.checkNotNullParameter(c16, "c");
        if (Intrinsics.areEqual(kotlinName, StandardNames.FqNames.deprecated)) {
            FqName DEPRECATED_ANNOTATION = JvmAnnotationNames.DEPRECATED_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            JavaAnnotation findAnnotation2 = annotationOwner.findAnnotation(DEPRECATED_ANNOTATION);
            if (findAnnotation2 != null || annotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(findAnnotation2, c16);
            }
        }
        FqName fqName = kotlinToJavaNameMap.get(kotlinName);
        if (fqName == null || (findAnnotation = annotationOwner.findAnnotation(fqName)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(INSTANCE, findAnnotation, c16, false, 4, null);
    }

    @NotNull
    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    @NotNull
    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    @NotNull
    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    @Nullable
    public final AnnotationDescriptor mapOrResolveJavaAnnotation(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c16, boolean z16) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(c16, "c");
        ClassId classId = annotation.getClassId();
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.TARGET_ANNOTATION))) {
            return new JavaTargetAnnotationDescriptor(annotation, c16);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.RETENTION_ANNOTATION))) {
            return new JavaRetentionAnnotationDescriptor(annotation, c16);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.DOCUMENTED_ANNOTATION))) {
            return new JavaAnnotationDescriptor(c16, annotation, StandardNames.FqNames.mustBeDocumented);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(c16, annotation, z16);
    }
}
