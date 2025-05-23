package j32;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lj32/b;", "Lj32/a;", "proxy", "", "a", "", "tag", "str", "i", "w", "b", "Lj32/a;", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f409197a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a proxy;

    b() {
    }

    public final void a(@NotNull a proxy2) {
        Intrinsics.checkNotNullParameter(proxy2, "proxy");
        proxy = proxy2;
    }

    @Override // j32.a
    public void i(@NotNull String tag, @NotNull String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(str, "str");
        a aVar = proxy;
        if (aVar != null) {
            aVar.i(tag, str);
        }
    }

    @Override // j32.a
    public void w(@NotNull String tag, @NotNull String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(str, "str");
        a aVar = proxy;
        if (aVar != null) {
            aVar.w(tag, str);
        }
    }
}
