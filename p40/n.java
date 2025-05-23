package p40;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import p40.f;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: f, reason: collision with root package name */
    private static volatile n f425299f;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f425300a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private boolean f425301b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f425302c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f425303d = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f425304e = false;

    n() {
        QLog.d("QFP-QFSFloatingStrategy", 1, "[QFSFloatingStrategy init] expName:", com.tencent.biz.qqcircle.utils.l.b(f()));
    }

    private static void b(f.d dVar) {
        if (dVar != null) {
            dVar.a();
        }
    }

    public static n e() {
        if (f425299f == null) {
            synchronized (n.class) {
                if (f425299f == null) {
                    f425299f = new n();
                }
            }
        }
        return f425299f;
    }

    private String f() {
        return "exp_xsj_xiaochuang_exp_3";
    }

    private String g() {
        return "exp_xsj_xiaochuang_exp_3_B";
    }

    private String h() {
        return "exp_xsj_xiaochuang_exp_3_C";
    }

    private boolean l() {
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_FLOATING, 0) || uq3.o.C()) {
            return true;
        }
        String b16 = com.tencent.biz.qqcircle.utils.l.b(f());
        s(b16);
        return g().equals(b16);
    }

    private boolean o(String str) {
        if (!TextUtils.equals(str, "share_layer_page") && !TextUtils.equals(str, "auto_layer_page") && !TextUtils.equals(str, "top_entrance")) {
            return false;
        }
        return true;
    }

    private boolean r() {
        return ((IFloatingState) QRoute.api(IFloatingState.class)).getFloating().contains("com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper");
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str) || !uq3.o.L0() || this.f425304e) {
            return;
        }
        this.f425304e = true;
        com.tencent.biz.qqcircle.utils.l.i(f());
    }

    public void a() {
        this.f425304e = false;
    }

    public boolean c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !com.tencent.biz.qqcircle.immersive.adapter.n.l(feedCloudMeta$StFeed) || QCircleVideoDeviceInfoUtils.isLowDevice() || ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        if (!e().l() && !e().k()) {
            return false;
        }
        return true;
    }

    public void d() {
        if (this.f425302c && !this.f425303d) {
            this.f425303d = true;
            QLog.d("QFP-QFSFloatingStrategy", 1, "countPlayVV return by red point");
            return;
        }
        QLog.d("QFP-QFSFloatingStrategy", 1, "countPlayVV:" + this.f425300a.incrementAndGet());
    }

    public int i() {
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_FLOATING, 0)) {
            return 2;
        }
        if (uq3.o.f()) {
            int E0 = uq3.o.E0();
            QLog.d("QFP-QFSFloatingStrategy", 1, "getSessionVV from ser:" + E0);
            return E0;
        }
        Map<String, String> c16 = com.tencent.biz.qqcircle.utils.l.c(f());
        if (c16 != null && c16.containsKey("sessionVV")) {
            int parseInt = Integer.parseInt(c16.get("sessionVV"));
            QLog.d("QFP-QFSFloatingStrategy", 1, "getSessionVV:" + parseInt);
            return parseInt;
        }
        QLog.d("QFP-QFSFloatingStrategy", 1, "getSessionVV no params");
        return Integer.MAX_VALUE;
    }

    public boolean j() {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ);
    }

    public boolean k() {
        if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_FLOATING, 0)) {
            return true;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() || QCircleVideoDeviceInfoUtils.isLowDevice()) {
            return false;
        }
        if (uq3.o.f()) {
            return true;
        }
        String b16 = com.tencent.biz.qqcircle.utils.l.b(f());
        s(b16);
        return h().equals(b16);
    }

    public boolean m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (!com.tencent.biz.qqcircle.immersive.adapter.n.l(feedCloudMeta$StFeed)) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "[hitSmallWindowEnter] current feed item not is video type.");
            return false;
        }
        if (QCircleVideoDeviceInfoUtils.isLowDevice()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "[setIsAllowEnterFloatingWindow] Low Device.");
            return false;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "[setIsAllowEnterFloatingWindow] teen mode.");
            return false;
        }
        if (e().l() || e().k()) {
            return true;
        }
        QLog.d("QFP-QFSFloatingStrategy", 1, "[setIsAllowEnterFloatingWindow] not hit exp.");
        return false;
    }

    public boolean n() {
        return this.f425301b;
    }

    public void p(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, int i3, f.d dVar) {
        String str;
        int i16 = this.f425300a.get();
        this.f425300a.set(1);
        QLog.d("QFP-QFSFloatingStrategy", 1, " onExitRecommend reset:" + i16);
        int i17 = i();
        if (i16 < i17 && !this.f425301b) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "onExitQCircle :sessionVV not enable:" + i16 + "|" + i17 + "|" + this.f425301b);
            b(dVar);
            return;
        }
        if (i16 < i17) {
            str = "main_tab_enlarge_exit";
        } else {
            str = "auto";
        }
        q(context, feedCloudMeta$StFeed, str, i3, dVar);
        if (z16 && j()) {
            u.H().B();
        }
    }

    public void q(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, int i3, f.d dVar) {
        Activity activity;
        if (u.H().j0()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "onExitQCircle :is on floating");
            b(dVar);
            return;
        }
        if (!TextUtils.equals(str, "flyer_enlarge_close") && !TextUtils.equals(str, "main_tab_enlarge_exit") && !o(str) && !k()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "onExitQCircle :not hit exp");
            b(dVar);
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "onExitQCircle not find feed ");
            b(dVar);
            return;
        }
        if (!j()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "onExitQCircle no permission ");
            b(dVar);
            return;
        }
        if (r()) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "QQVideoLiveExit return ");
            b(dVar);
            return;
        }
        if (com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed) != 1003) {
            QLog.d("QFP-QFSFloatingStrategy", 1, "not feed video return ");
            b(dVar);
            return;
        }
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null) {
            RFWPlayerReuseUtils.prepareToReusePlayer(weakReference.get());
            QLog.d("QFP-QFSFloatingStrategy", 1, "re use player when exit layer page ");
        }
        u H = u.H();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        H.I0(feedCloudMeta$StFeed, activity, str, i3, dVar);
    }

    public void t(boolean z16) {
        this.f425301b = z16;
        QLog.d("QFP-QFSFloatingStrategy", 1, "resetEnterFlag:" + z16);
    }

    public void u(boolean z16, boolean z17) {
        this.f425301b = z16;
        this.f425302c = z17;
        this.f425303d = false;
        QLog.d("QFP-QFSFloatingStrategy", 1, "enterByAni:" + z16 + ",| hasRedPoint:" + z17);
    }
}
