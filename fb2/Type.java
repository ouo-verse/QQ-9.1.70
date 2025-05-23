package fb2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n\u0012\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR!\u0010\u0013\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lfb2/c;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "clz", "Lfb2/a;", "b", "Lfb2/a;", "()Lfb2/a;", "delegate", "<init>", "(Ljava/lang/Class;Lfb2/a;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fb2.c, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class Type<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Class<? extends T> clz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a<T, ?> delegate;

    public Type(@NotNull Class<? extends T> clz, @NotNull a<T, ?> delegate) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.clz = clz;
        this.delegate = delegate;
    }

    @NotNull
    public final Class<? extends T> a() {
        return this.clz;
    }

    @NotNull
    public final a<T, ?> b() {
        return this.delegate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Type)) {
            return false;
        }
        Type type = (Type) other;
        if (Intrinsics.areEqual(this.clz, type.clz) && Intrinsics.areEqual(this.delegate, type.delegate)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.clz.hashCode() * 31) + this.delegate.hashCode();
    }

    @NotNull
    public String toString() {
        return "Type(clz=" + this.clz + ", delegate=" + this.delegate + ")";
    }
}
