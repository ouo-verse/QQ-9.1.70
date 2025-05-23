package f10;

import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001fR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#\u00a8\u0006'"}, d2 = {"Lf10/b;", "", "", "from", "", "c", "", "b", "", "action", "p", DomainData.DOMAIN_NAME, "f", "", "duration", h.F, "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "g", "j", "reason", "d", "o", "a", "e", "Z", "isPauseWhenFetching", "isHandledData", "isStartLoadPic", "I", "Ljava/lang/String;", "switchReason", "Lf10/a;", "Lf10/a;", "launchDeltaTimeCalculator", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isPauseWhenFetching;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isHandledData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isStartLoadPic;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static a launchDeltaTimeCalculator;

    /* renamed from: a, reason: collision with root package name */
    public static final b f397582a = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int action = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String switchReason = "";

    b() {
    }

    private final boolean b() {
        return action == -1 && launchDeltaTimeCalculator != null;
    }

    private final void c(String from) {
        launchDeltaTimeCalculator = new a(from);
    }

    private final int p(int action2) {
        if (isStartLoadPic) {
            return 1;
        }
        if (isHandledData) {
            return 0;
        }
        return action2;
    }

    public final void a() {
        if (b()) {
            action = p(4);
            a aVar = launchDeltaTimeCalculator;
            if (aVar != null) {
                aVar.n();
            }
        }
        x.j("WSLaunchDeltaTimeManager", "backgroundGzh action:" + action);
        a aVar2 = launchDeltaTimeCalculator;
        if (aVar2 != null) {
            g.d().g(aVar2, action, switchReason, isPauseWhenFetching);
        }
        n();
    }

    public final void d(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        x.j("WSLaunchDeltaTimeManager", "enterVerticalPage reason:" + reason);
        if (b()) {
            switchReason = reason;
            action = p(2);
            a aVar = launchDeltaTimeCalculator;
            if (aVar != null) {
                aVar.n();
            }
        }
        x.j("WSLaunchDeltaTimeManager", "action:" + action);
    }

    public final void e() {
        if (b()) {
            action = p(3);
            a aVar = launchDeltaTimeCalculator;
            if (aVar != null) {
                aVar.n();
            }
        }
        x.j("WSLaunchDeltaTimeManager", "exitGzh action:" + action);
        a aVar2 = launchDeltaTimeCalculator;
        if (aVar2 != null) {
            g.d().g(aVar2, action, switchReason, isPauseWhenFetching);
        }
        n();
    }

    public final void f(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        c(from);
        a aVar = launchDeltaTimeCalculator;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void g() {
        a aVar = launchDeltaTimeCalculator;
        if (aVar == null) {
            return;
        }
        isStartLoadPic = true;
        aVar.k();
    }

    public final void h(long duration) {
        a aVar = launchDeltaTimeCalculator;
        if (aVar != null) {
            aVar.l(duration);
        }
    }

    public final void i(long duration) {
        a aVar = launchDeltaTimeCalculator;
        if (aVar != null) {
            aVar.m(duration);
        }
    }

    public final void j() {
        x.j("WSLaunchDeltaTimeManager", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        if (isHandledData || !b()) {
            return;
        }
        isPauseWhenFetching = true;
    }

    public final void k() {
        a aVar = launchDeltaTimeCalculator;
        if (aVar != null) {
            aVar.p();
        }
    }

    public final void l() {
        a aVar = launchDeltaTimeCalculator;
        if (aVar == null) {
            return;
        }
        isHandledData = true;
        if (action == -1) {
            action = 0;
        }
        aVar.o();
    }

    public final void m() {
        a aVar = launchDeltaTimeCalculator;
        if (aVar != null) {
            aVar.q();
        }
    }

    public final void o() {
        if (b()) {
            action = p(5);
            a aVar = launchDeltaTimeCalculator;
            if (aVar != null) {
                aVar.n();
            }
        }
        x.j("WSLaunchDeltaTimeManager", "switchToFollowTab action:" + action);
    }

    public final void n() {
        action = -1;
        launchDeltaTimeCalculator = null;
        isHandledData = false;
        isStartLoadPic = false;
        switchReason = "";
    }
}
