package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ExcludedTypeAnnotations {

    @NotNull
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();

    @NotNull
    private static final Set<FqName> internalAnnotationsForResolve;

    static {
        Set<FqName> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});
        internalAnnotationsForResolve = of5;
    }

    ExcludedTypeAnnotations() {
    }

    @NotNull
    public final Set<FqName> getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }
}
