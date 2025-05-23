package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static ReflectJavaAnnotation findAnnotation(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, @NotNull FqName fqName) {
            Annotation[] declaredAnnotations;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element != null && (declaredAnnotations = element.getDeclaredAnnotations()) != null) {
                return ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
            }
            return null;
        }

        @NotNull
        public static List<ReflectJavaAnnotation> getAnnotations(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            List<ReflectJavaAnnotation> emptyList;
            Annotation[] declaredAnnotations;
            List<ReflectJavaAnnotation> annotations;
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (annotations = ReflectJavaAnnotationOwnerKt.getAnnotations(declaredAnnotations)) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return annotations;
        }

        public static boolean isDeprecatedInJavaDoc(@NotNull ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            return false;
        }
    }

    @Nullable
    AnnotatedElement getElement();
}
