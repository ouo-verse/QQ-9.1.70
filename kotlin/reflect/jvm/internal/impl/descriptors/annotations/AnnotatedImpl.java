package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 1) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 1) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i3 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i3 != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i3 != 1) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public AnnotatedImpl(@NotNull Annotations annotations) {
        if (annotations == null) {
            $$$reportNull$$$0(0);
        }
        this.annotations = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.annotations;
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        return annotations;
    }
}
