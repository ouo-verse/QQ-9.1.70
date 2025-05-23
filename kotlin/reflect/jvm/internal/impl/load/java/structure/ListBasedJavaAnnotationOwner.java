package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        @Nullable
        public static JavaAnnotation findAnnotation(@NotNull ListBasedJavaAnnotationOwner listBasedJavaAnnotationOwner, @NotNull FqName fqName) {
            Object obj;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator<T> it = listBasedJavaAnnotationOwner.getAnnotations().iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassId classId = ((JavaAnnotation) next).getClassId();
                if (classId != null) {
                    obj = classId.asSingleFqName();
                }
                if (Intrinsics.areEqual(obj, fqName)) {
                    obj = next;
                    break;
                }
            }
            return (JavaAnnotation) obj;
        }
    }
}
