package np;

import android.app.Activity;
import android.app.Application;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import op.AppStateInfo;
import op.Config;
import op.d;
import op.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0007R\u001a\u0010\u001c\u001a\u00020\u00178FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lnp/a;", "", "Landroid/app/Application;", "application", "Lop/b;", DownloadInfo.spKey_Config, "", "b", "", "message", "", "throwable", "f", "componentName", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "type", "c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "e", "Lop/a;", "a", "()Lop/a;", "appStateInfo$annotations", "()V", "appStateInfo", "<init>", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f420637a = new a();

    a() {
    }

    @NotNull
    public static final AppStateInfo a() {
        return d.c(d.f423287g, false, false, 1, null);
    }

    @JvmStatic
    public static final void b(@NotNull Application application, @NotNull Config config) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(config, "config");
        d.f423287g.l(application, config);
    }

    @JvmStatic
    public static final void c(@Nullable Activity activity, int type) {
        d.f423287g.n(activity, type);
    }

    @JvmStatic
    public static final void d(@NotNull String componentName) {
        Intrinsics.checkParameterIsNotNull(componentName, "componentName");
        d.f423287g.p(componentName);
    }

    @JvmStatic
    public static final void e(@NotNull Application.ActivityLifecycleCallbacks callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        h.f423289b.j(callback);
    }

    @JvmStatic
    public static final void f(@NotNull String message, @NotNull Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        d.f423287g.i().a();
    }
}
