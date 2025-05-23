package com.tencent.av.ui.notdisturb;

import android.graphics.Bitmap;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class BaseGaInviteFloatBarUICtr {

    /* renamed from: p, reason: collision with root package name */
    public static int f76126p = 60000;

    /* renamed from: q, reason: collision with root package name */
    private static String f76127q = "BaseGaInviteFloatBarUICtr";

    /* renamed from: m, reason: collision with root package name */
    GaInviteFloatBar f76140m;

    /* renamed from: n, reason: collision with root package name */
    long f76141n;

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f76128a = null;

    /* renamed from: b, reason: collision with root package name */
    long f76129b = 0;

    /* renamed from: c, reason: collision with root package name */
    String f76130c = null;

    /* renamed from: d, reason: collision with root package name */
    String f76131d = null;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f76132e = null;

    /* renamed from: f, reason: collision with root package name */
    int f76133f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f76134g = 0;

    /* renamed from: h, reason: collision with root package name */
    long f76135h = 0;

    /* renamed from: i, reason: collision with root package name */
    long[] f76136i = null;

    /* renamed from: j, reason: collision with root package name */
    SessionInfo f76137j = null;

    /* renamed from: k, reason: collision with root package name */
    String f76138k = null;

    /* renamed from: l, reason: collision with root package name */
    String f76139l = null;

    /* renamed from: o, reason: collision with root package name */
    Runnable f76142o = new Runnable() { // from class: com.tencent.av.ui.notdisturb.BaseGaInviteFloatBarUICtr.1
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(BaseGaInviteFloatBarUICtr.f76127q, 2, "timeout~ mPeerUin:" + BaseGaInviteFloatBarUICtr.this.f76138k);
            }
            BaseGaInviteFloatBarUICtr.this.d();
        }
    };

    public BaseGaInviteFloatBarUICtr() {
        f76127q = getClass().getSimpleName() + "_" + e.d();
    }

    void b() {
        if (this.f76142o != null) {
            this.f76128a.M().removeCallbacks(this.f76142o);
            this.f76142o = null;
        }
    }

    public void c() {
        QLog.d(f76127q, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).stopRefreshGaFaceUI();
        GaInviteFloatBar gaInviteFloatBar = this.f76140m;
        if (gaInviteFloatBar != null) {
            gaInviteFloatBar.x();
            this.f76140m = null;
        }
        b();
    }

    abstract void d();

    public void e() {
        this.f76131d = this.f76128a.G(this.f76133f, String.valueOf(this.f76129b), null);
        int f16 = AVUtil.f(this.f76134g);
        this.f76130c = this.f76128a.G(f16, String.valueOf(this.f76135h), String.valueOf(this.f76129b));
        this.f76132e = this.f76128a.J(f16, String.valueOf(this.f76135h), null, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (QLog.isColorLevel()) {
            QLog.w(f76127q, 1, "refreshUI, isMultiCall[" + AVUtil.o(this.f76133f) + "], mUinType[" + this.f76133f + "]");
        }
        if (AVUtil.o(this.f76133f)) {
            e();
        } else {
            this.f76132e = this.f76128a.J(this.f76133f, this.f76138k, this.f76139l, true, true);
            this.f76130c = this.f76128a.G(this.f76133f, this.f76138k, this.f76139l);
        }
        if (this.f76140m == null) {
            GaInviteFloatBar gaInviteFloatBar = new GaInviteFloatBar(this.f76128a.getApp().getApplicationContext());
            this.f76140m = gaInviteFloatBar;
            gaInviteFloatBar.C(this.f76132e, this.f76130c, this.f76131d);
            this.f76140m.E();
            if (AVUtil.o(this.f76133f)) {
                this.f76128a.M().postDelayed(this.f76142o, f76126p);
            }
            this.f76141n = System.currentTimeMillis();
        }
    }
}
