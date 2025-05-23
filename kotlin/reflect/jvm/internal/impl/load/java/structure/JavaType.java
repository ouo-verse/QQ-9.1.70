package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.ListBasedJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaType extends ListBasedJavaAnnotationOwner {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static JavaAnnotation findAnnotation(@NotNull JavaType javaType, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            return ListBasedJavaAnnotationOwner.DefaultImpls.findAnnotation(javaType, fqName);
        }
    }
}
