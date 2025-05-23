package g22;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lg22/a;", "Lj32/a;", "", "tag", "str", "", "i", "w", "<init>", "()V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements j32.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f401117a = new a();

    a() {
    }

    @Override // j32.a
    public void i(@NotNull String tag, @NotNull String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(str, "str");
        QLog.i(tag, 1, str);
    }

    @Override // j32.a
    public void w(@NotNull String tag, @NotNull String str) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(str, "str");
        QLog.w(tag, 1, str);
    }
}
