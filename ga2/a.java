package ga2;

import com.tencent.mobileqq.nearbypro.base.ILog;
import com.tencent.mobileqq.nearbypro.base.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J#\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0003\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0013"}, d2 = {"Lga2/a;", "Lcom/tencent/mobileqq/nearbypro/base/ILog;", "", "e", "", "a", "", "isColorLevel", "tag", "Lcom/tencent/mobileqq/nearbypro/base/ILog$Level;", "level", "message", "", "b", "c", "f", "d", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements ILog {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f401619b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ILog f401620a = i.f253231a.a().getLog();

    a() {
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    @Nullable
    public String a(@NotNull Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        return this.f401620a.a(e16);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    public void b(@NotNull String tag, @NotNull ILog.Level level, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        this.f401620a.b(tag, level, message);
    }

    public final void c(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        b(tag, ILog.Level.DEBUG, message);
    }

    public final void d(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        b(tag, ILog.Level.ERROR, message);
    }

    public final void e(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        b(tag, ILog.Level.INFO, message);
    }

    public final void f(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        b(tag, ILog.Level.WARN, message);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    public boolean isColorLevel() {
        return this.f401620a.isColorLevel();
    }
}
