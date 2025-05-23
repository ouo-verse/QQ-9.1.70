package com.tencent.gamecenter.wadl.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.gamecenter.wadl.api.widget.FloatBallView;
import com.tencent.gamecenter.wadl.api.widget.FloatCompleteView;
import com.tencent.gamecenter.wadl.api.widget.FloatInstallView;
import com.tencent.gamecenter.wadl.api.widget.FloatKeepLiveView;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import tencent.im.qqgame.QQGameIntercept$GetFloatingWindowResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlDLFloatWnd extends BroadcastReceiver implements ll0.a, Handler.Callback {
    private FloatKeepLiveView C;
    private boolean H;
    private QQGameIntercept$GetFloatingWindowResponse I;
    private String J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private Handler T;
    private boolean U;
    private boolean V;
    private long W;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f106931d;

    /* renamed from: h, reason: collision with root package name */
    private FloatBallView f106934h;

    /* renamed from: i, reason: collision with root package name */
    private FloatCompleteView f106935i;

    /* renamed from: m, reason: collision with root package name */
    private FloatInstallView f106936m;

    /* renamed from: e, reason: collision with root package name */
    private int f106932e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f106933f = 0;
    private AtomicBoolean D = new AtomicBoolean(false);
    private ArrayList<WadlResult> E = new ArrayList<>();
    private HashSet<String> F = new HashSet<>();
    private HashSet<String> G = new HashSet<>();
    private final Runnable X = new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlDLFloatWnd.2
        @Override // java.lang.Runnable
        public void run() {
            WadlDLFloatWnd.this.f(true);
        }
    };
    private final Runnable Y = new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlDLFloatWnd.3
        @Override // java.lang.Runnable
        public void run() {
            WadlDLFloatWnd.this.b();
        }
    };

    public WadlDLFloatWnd(boolean z16, boolean z17, int i3) {
        this.U = z16;
        this.V = z17;
        this.W = i3 * 86400000;
        this.H = ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).getIntOutAccount(WadlProxyConsts.KEY_FLOAT_WND_TOGGLE, 1) == 0;
        this.T = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper(), this);
        this.f106931d = (WindowManager) MobileQQ.sMobileQQ.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f106931d.getDefaultDisplay().getRealMetrics(displayMetrics);
        z();
        float f16 = displayMetrics.density;
        int i16 = (int) ((48.0f * f16) + 0.5f);
        this.K = i16;
        int i17 = (int) ((354.0f * f16) + 0.5f);
        this.L = i17;
        this.N = (int) ((227.0f * f16) + 0.5f);
        int i18 = (int) ((f16 * 278.0f) + 0.5f);
        this.M = i18;
        this.P = (i18 / 2) - i16;
        this.Q = (i17 / 2) - i16;
        this.R = i17 - i16;
        this.S = i18 - i16;
        QLog.d("WadlFloat_WadlDLFloatWnd", 2, "[newInstance] screenWidth:" + this.f106932e + ",screenHeight:" + this.f106933f);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
            intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
            MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(this, intentFilter);
        } catch (Exception e16) {
            QLog.e("WadlFloat_WadlDLFloatWnd", 2, "[newInstance] registerReceiver exception", e16);
        }
    }

    private void A() {
        try {
            QLog.i("WadlFloat_WadlDLFloatWnd", 1, "removeKeepLiveWindow");
            FloatKeepLiveView floatKeepLiveView = this.C;
            if (floatKeepLiveView != null) {
                floatKeepLiveView.a();
                B(this.C);
                this.C = null;
            }
        } catch (Throwable th5) {
            QLog.e("WadlFloat_WadlDLFloatWnd", 1, th5, new Object[0]);
        }
    }

    private boolean B(View view) {
        if (this.f106931d != null && view != null) {
            try {
            } catch (Throwable th5) {
                QLog.e("WadlFloat_WadlDLFloatWnd", 1, "removeView has exception: " + th5);
            }
            if (view.isAttachedToWindow()) {
                this.f106931d.removeView(view);
                return true;
            }
            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "removeView not attached window");
            return true;
        }
        return false;
    }

    private synchronized int C(String str) {
        Iterator<WadlResult> it = this.E.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            i3++;
            if (str.equals(it.next().wadlParams.appId)) {
                it.remove();
                this.F.remove(str);
                return i3;
            }
        }
        return -1;
    }

    private void D(WadlResult wadlResult, boolean z16) {
        Message obtainMessage = this.T.obtainMessage(1);
        obtainMessage.obj = wadlResult;
        obtainMessage.arg1 = z16 ? 1 : 0;
        obtainMessage.sendToTarget();
    }

    private void F() {
        FloatBallView floatBallView;
        int i3;
        int i16;
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow showIntallDialog=" + this.V + ",lastInstallWNDResp=" + this.I + ",lastInstallWNDAppId=" + this.J);
        if (this.V && this.I != null && !TextUtils.isEmpty(this.J) && this.f106936m == null && (floatBallView = this.f106934h) != null) {
            WadlResult g16 = floatBallView.g();
            if (g16 != null && g16.wadlParams.appId.equals(this.J)) {
                try {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f106934h.getLayoutParams();
                    int i17 = layoutParams.y;
                    int i18 = this.Q;
                    int i19 = 0;
                    if (i17 < i18) {
                        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow limit top");
                        i3 = 0;
                    } else {
                        i3 = i17 - i18;
                        int i26 = this.f106933f;
                        int i27 = this.L;
                        if (i3 > i26 - i27) {
                            i3 = i26 - i27;
                            QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow limit bottom");
                        }
                    }
                    int i28 = layoutParams.y - i3;
                    FloatInstallView floatInstallView = new FloatInstallView(BaseApplication.getContext());
                    this.f106936m = floatInstallView;
                    floatInstallView.setFloatWndListener(this);
                    this.f106936m.a(this.J, this.I);
                    WindowManager.LayoutParams a16 = f.a();
                    if (this.f106934h.m()) {
                        i16 = 5;
                    } else {
                        i16 = 3;
                    }
                    a16.gravity = i16 | 48;
                    a16.y = i3;
                    if (i28 >= 0 && i28 <= (i19 = this.R)) {
                        i19 = i28;
                    }
                    QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow floatBallParams.y=" + layoutParams.y + ",viewParams.y=" + a16.y + ",translationY=" + i19 + ",installViewHalfHeight=" + this.Q + ",screenHeight=" + this.f106933f);
                    this.f106936m.c(this.f106934h.m(), i19);
                    if (!k(this.f106936m, a16)) {
                        return;
                    }
                    this.T.postDelayed(this.X, this.I.timeout.get() * 1000);
                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId("915167").setExt(1, "817120").setGameAppId(this.J).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(4, "8").report();
                    return;
                } catch (Throwable th5) {
                    QLog.e("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow has exception: " + th5);
                    return;
                }
            }
            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "showInstallWindow break, showResult=" + g16 + ", lastInstallWNDAppId=" + this.J);
        }
    }

    private void H() {
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showKeepLiveWindow mFloatKeepLiveView=" + this.C);
        if (this.C == null) {
            QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showKeepLiveWindow init view");
            this.C = new FloatKeepLiveView(BaseApplication.getContext());
            WindowManager.LayoutParams a16 = f.a();
            a16.gravity = 51;
            a16.width = 200;
            a16.height = 200;
            a16.y = 0;
            a16.x = 0;
            a16.flags |= 16;
            a16.alpha = 0.8f;
            k(this.C, a16);
        }
    }

    private void I() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.b
            @Override // java.lang.Runnable
            public final void run() {
                WadlDLFloatWnd.this.q();
            }
        }, 16, null, true);
    }

    private void J(WadlResult wadlResult) {
        if (wadlResult != null && !this.H) {
            if (this.f106934h == null) {
                QLog.d("WadlFloat_WadlDLFloatWnd", 1, "updateFloatView init view");
                this.f106934h = new FloatBallView(BaseApplication.getContext(), this, this.f106932e, this.f106933f);
                WindowManager.LayoutParams a16 = f.a();
                a16.gravity = 51;
                int i3 = FloatBallView.f106668g0;
                int i16 = i3 - (i3 - FloatBallView.f106669h0);
                a16.width = i16;
                a16.y = this.f106933f / 3;
                a16.x = this.f106932e - i16;
                QLog.d("WadlFloat_WadlDLFloatWnd", 1, "updateFloatBallView move to right x:" + a16.x);
                k(this.f106934h, a16);
            }
            this.f106934h.A(wadlResult);
            return;
        }
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "updateFloatView mToggleClose=" + this.H);
    }

    private synchronized void K(WadlResult wadlResult) {
        boolean z16;
        if (wadlResult == null) {
            return;
        }
        Iterator<WadlResult> it = this.E.iterator();
        while (true) {
            if (it.hasNext()) {
                WadlResult next = it.next();
                if (wadlResult.wadlParams.appId.equals(next.wadlParams.appId)) {
                    next.update(wadlResult);
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            if (wadlResult.isDownloadComplete()) {
                this.E.add(0, wadlResult);
            } else {
                this.E.add(wadlResult);
            }
            this.F.add(wadlResult.wadlParams.appId);
        }
    }

    private boolean L(WadlResult wadlResult) {
        WadlParams wadlParams;
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null && !TextUtils.isEmpty(wadlParams.appName) && !TextUtils.isEmpty(wadlResult.wadlParams.appId) && wadlResult.wadlParams.getFlagEnable(4)) {
            return true;
        }
        QLog.w("WadlFloat_WadlDLFloatWnd", 1, "validParams fail, wadlResult=" + wadlResult);
        return false;
    }

    private boolean k(View view, WindowManager.LayoutParams layoutParams) {
        if (this.f106931d != null && view != null && layoutParams != null) {
            try {
                if (com.tencent.gamecenter.wadl.util.i.b()) {
                    this.f106931d.addView(view, layoutParams);
                    return true;
                }
                QLog.w("WadlFloat_WadlDLFloatWnd", 1, "addView no permission");
            } catch (Throwable th5) {
                QLog.e("WadlFloat_WadlDLFloatWnd", 1, "addView has exception: " + th5);
            }
        }
        return false;
    }

    private void l(String str, String str2) {
        if (this.G.size() > 0 && this.G.contains(str)) {
            synchronized (this.G) {
                this.G.remove(str);
            }
            QLog.d("WadlFloat_WadlDLFloatWnd", 1, "clearTempCloseFloatData from=" + str2 + ", appId=" + str + " success");
        }
    }

    private void n() {
        FloatBallView floatBallView = this.f106934h;
        if (floatBallView != null) {
            floatBallView.p();
            B(this.f106934h);
            this.f106934h = null;
        }
        f(false);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        WadlResult b16 = f.b(this.E, false);
        if (b16 != null) {
            D(b16, false);
        }
    }

    private void r(String str) {
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "notifyWadlResultDelete appId=" + str);
        Message obtainMessage = this.T.obtainMessage(2);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    private void s() {
        int z16 = z();
        FloatBallView floatBallView = this.f106934h;
        if (floatBallView != null) {
            floatBallView.r(this.f106932e, this.f106933f, z16);
        }
        f(true);
        b();
    }

    private void v() {
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onQQForeground");
        if (!this.H) {
            I();
        }
    }

    private int z() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f106931d.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i3 = MobileQQ.sMobileQQ.getResources().getConfiguration().orientation;
        if (i3 == 2) {
            int i16 = displayMetrics.widthPixels;
            int i17 = displayMetrics.heightPixels;
            if (i16 < i17) {
                this.f106932e = i17;
                this.f106933f = i16;
            } else {
                this.f106932e = i16;
                this.f106933f = i17;
            }
        } else if (i3 == 1) {
            int i18 = displayMetrics.widthPixels;
            int i19 = displayMetrics.heightPixels;
            if (i18 < i19) {
                this.f106932e = i18;
                this.f106933f = i19;
            } else {
                this.f106932e = i19;
                this.f106933f = i18;
            }
        }
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "refreshScreenParams screenWidth=" + this.f106932e + ",screenHeight=" + this.f106933f + ",screenOrientation=" + i3);
        return i3;
    }

    public void E() {
        FloatBallView floatBallView;
        int i3;
        int i16;
        if (this.U && this.f106935i == null && (floatBallView = this.f106934h) != null) {
            try {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) floatBallView.getLayoutParams();
                int i17 = layoutParams.y;
                int i18 = this.P;
                int i19 = 0;
                if (i17 < i18) {
                    QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showCompleteFloatWindow limit top");
                    i3 = 0;
                } else {
                    i3 = i17 - i18;
                    int i26 = this.f106933f;
                    int i27 = this.M;
                    if (i3 > i26 - i27) {
                        i3 = i26 - i27;
                        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showCompleteFloatWindow limit bottom");
                    }
                }
                int i28 = layoutParams.y - i3;
                FloatCompleteView floatCompleteView = new FloatCompleteView(BaseApplication.getContext());
                this.f106935i = floatCompleteView;
                floatCompleteView.setFloatWndListener(this);
                WindowManager.LayoutParams a16 = f.a();
                if (this.f106934h.m()) {
                    i16 = 5;
                } else {
                    i16 = 3;
                }
                a16.gravity = i16 | 48;
                a16.y = i3;
                if (i28 >= 0 && i28 <= (i19 = this.S)) {
                    i19 = i28;
                }
                QLog.d("WadlFloat_WadlDLFloatWnd", 1, "showCompleteFloatWindow floatBallParams.y=" + layoutParams.y + ",viewParams.y=" + a16.y + ",translationY=" + i19 + ",completeViewHalfHeight=" + this.P + ",screenHeight=" + this.f106933f);
                this.f106935i.c(this.f106934h.m(), i19);
                if (this.f106935i.b()) {
                    if (!k(this.f106935i, a16)) {
                        return;
                    }
                    this.T.postDelayed(this.Y, 7000L);
                    return;
                }
                b();
                return;
            } catch (Throwable th5) {
                QLog.e("WadlFloat_WadlDLFloatWnd", 1, "showCompleteFloatWindow has exception: " + th5);
                return;
            }
        }
        QLog.w("WadlFloat_WadlDLFloatWnd", 1, "showCompleteFloatWindow cancel,showCompleteDialog=" + this.U + ",mFloatBallView=" + this.U);
    }

    public void G(long j3) {
        this.T.removeMessages(5);
        this.T.sendEmptyMessage(5);
        o(j3);
    }

    @Override // ll0.a
    public boolean a(View view, WindowManager.LayoutParams layoutParams) {
        if (this.f106931d != null && view != null && layoutParams != null) {
            try {
                if (com.tencent.gamecenter.wadl.util.i.b()) {
                    if (view.isAttachedToWindow()) {
                        this.f106931d.updateViewLayout(view, layoutParams);
                    }
                    return true;
                }
                QLog.w("WadlFloat_WadlDLFloatWnd", 1, "updateView no permission");
            } catch (Throwable th5) {
                QLog.e("WadlFloat_WadlDLFloatWnd", 1, "updateView has exception: " + th5);
            }
        }
        return false;
    }

    @Override // ll0.a
    public void b() {
        this.T.removeCallbacks(this.Y);
        try {
            QLog.i("WadlFloat_WadlDLFloatWnd", 1, "hideCompleteFloatWindow");
            FloatCompleteView floatCompleteView = this.f106935i;
            if (floatCompleteView != null) {
                B(floatCompleteView);
                this.f106935i.setFloatWndListener(null);
                this.f106935i = null;
            }
        } catch (Throwable th5) {
            QLog.e("WadlFloat_WadlDLFloatWnd", 1, th5, new Object[0]);
        }
    }

    @Override // ll0.a
    public void c() {
        this.T.removeMessages(4);
        this.T.sendEmptyMessage(4);
    }

    @Override // ll0.a
    public void d() {
        synchronized (this.G) {
            this.G.clear();
            this.G.addAll(this.F);
        }
        if (com.tencent.gamecenter.wadl.util.i.i()) {
            QQToast.makeText(BaseApplication.getContext(), -1, "\u4e0b\u6b21\u6253\u5f00QQ\u5c06\u7ee7\u7eed\u5c55\u793a\u60ac\u6d6e\u7a97\u54e6\uff5e", 1).show();
            FloatBallView floatBallView = this.f106934h;
            if (floatBallView != null) {
                floatBallView.v();
            }
            com.tencent.gamecenter.wadl.util.i.n();
        }
        Iterator<WadlResult> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().wadlParams.setFlags(131072);
        }
        ArrayList<WadlResult> arrayList = new ArrayList<>();
        arrayList.addAll(this.E);
        WadlProxyServiceUtil.getProxyService().syncTaskData(arrayList);
        synchronized (this.E) {
            this.E.clear();
        }
        this.F.clear();
        m("onFloatClose");
    }

    @Override // ll0.a
    public List<WadlResult> e() {
        return this.E;
    }

    @Override // ll0.a
    public void f(boolean z16) {
        this.T.removeMessages(4);
        this.T.removeCallbacks(this.X);
        try {
            QLog.i("WadlFloat_WadlDLFloatWnd", 1, "hideInstallFloatWnd isTempHide=" + z16 + ",mFloatInstallView=" + this.f106936m);
            FloatInstallView floatInstallView = this.f106936m;
            if (floatInstallView != null) {
                B(floatInstallView);
                this.f106936m.setFloatWndListener(null);
                this.f106936m = null;
            }
            if (!z16) {
                this.I = null;
                this.J = null;
            }
        } catch (Throwable th5) {
            QLog.e("WadlFloat_WadlDLFloatWnd", 1, th5, new Object[0]);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        FloatBallView floatBallView;
        switch (message.what) {
            case 1:
                Object obj = message.obj;
                if (!(obj instanceof WadlResult)) {
                    return false;
                }
                WadlResult wadlResult = (WadlResult) obj;
                J(wadlResult);
                if (message.arg1 == 1 && wadlResult.isDownloadComplete() && !GameCenterUtil.checkInstallPermission() && (floatBallView = this.f106934h) != null) {
                    floatBallView.x(0);
                    E();
                }
                return false;
            case 2:
                Object obj2 = message.obj;
                if (!(obj2 instanceof String)) {
                    return false;
                }
                String str = (String) obj2;
                if (str.equals(this.J)) {
                    f(false);
                }
                FloatBallView floatBallView2 = this.f106934h;
                if (floatBallView2 != null) {
                    floatBallView2.t(str);
                }
                WadlResult b16 = f.b(this.E, false);
                if (b16 == null) {
                    m("removeWadlResult");
                } else {
                    D(b16, true);
                }
                return false;
            case 3:
                n();
                return false;
            case 4:
                F();
                return false;
            case 5:
                H();
                return false;
            case 6:
                A();
                return false;
            default:
                return false;
        }
    }

    public void m(String str) {
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "dismiss remove float view from=" + str);
        this.T.removeCallbacksAndMessages(null);
        this.T.obtainMessage(3).sendToTarget();
    }

    public void o(long j3) {
        this.T.removeMessages(6);
        this.T.sendEmptyMessageDelayed(6, j3);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
            s();
        } else if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action)) {
            v();
        }
    }

    public boolean p() {
        if (this.C != null) {
            return true;
        }
        return false;
    }

    public void t() {
        try {
            MobileQQ.sMobileQQ.getApplicationContext().unregisterReceiver(this);
        } catch (Exception e16) {
            QLog.e("WadlFloat_WadlDLFloatWnd", 2, "onDestroy unregisterReceiver exception", e16);
        }
        synchronized (this.E) {
            this.E.clear();
        }
        this.F.clear();
        this.G.clear();
        m(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        o(0L);
    }

    public void u(final String str, final QQGameIntercept$GetFloatingWindowResponse qQGameIntercept$GetFloatingWindowResponse) {
        WadlResult wadlResult;
        QLog.i("WadlFloat_WadlDLFloatWnd", 1, "onGetFloatWindowResp mToggleClose=" + this.H + ", icon=" + qQGameIntercept$GetFloatingWindowResponse.icon.get() + ",timeout=" + qQGameIntercept$GetFloatingWindowResponse.timeout.get() + JefsClass.INDEX_URL + qQGameIntercept$GetFloatingWindowResponse.url.get() + ",ok=" + qQGameIntercept$GetFloatingWindowResponse.f436036ok.get());
        if (!this.H && !TextUtils.isEmpty(str)) {
            if (this.f106936m != null && str.equals(this.J)) {
                QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onGetFloatWindowResp is same appId=" + str);
                return;
            }
            FloatBallView floatBallView = this.f106934h;
            if (floatBallView != null) {
                wadlResult = floatBallView.g();
            } else {
                wadlResult = null;
            }
            QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onGetFloatWindowResp mFloatBallView getCurrentData=" + wadlResult + ", appId=" + str);
            if (wadlResult == null) {
                wadlResult = f.b(this.E, false);
            }
            if (wadlResult != null && wadlResult.wadlParams.appId.equals(str)) {
                f(false);
                b();
                D(wadlResult, false);
                this.T.post(new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlDLFloatWnd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WadlDLFloatWnd.this.I = qQGameIntercept$GetFloatingWindowResponse;
                        WadlDLFloatWnd.this.J = str;
                        if (WadlDLFloatWnd.this.f106934h != null) {
                            WadlDLFloatWnd.this.f106934h.x(0);
                        }
                        WadlDLFloatWnd.this.c();
                    }
                });
                return;
            }
            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onGetFloatWindowResp break, appId=" + str);
            return;
        }
        QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onGetFloatWindowResp break,mToggleClose=" + this.H + ", appId=" + str);
    }

    public void w(ArrayList<WadlResult> arrayList) {
        if (this.D.getAndSet(true)) {
            return;
        }
        if (arrayList == null) {
            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback wadlResultList is null");
            return;
        }
        int size = arrayList.size();
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback wadlResultList size=" + size);
        if (size > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.W;
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                if (L(next)) {
                    if (!next.wadlParams.getFlagEnable(131072) && !next.wadlParams.getFlagEnable(262144)) {
                        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback appId=" + next.wadlParams.appId + ",frontTime=" + this.W + ",beginTime=" + currentTimeMillis + ",wadlResult.createTime=" + next.createTime);
                        if (next.createTime < currentTimeMillis) {
                            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback is history task, appId=" + next.wadlParams.appId);
                        } else {
                            K(next);
                        }
                    } else {
                        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback appid=" + next.wadlParams.appId + " isFloatCloase");
                    }
                }
            }
            synchronized (this.E) {
                WadlResult b16 = f.b(this.E, false);
                if (b16 != null) {
                    QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onQueryCallback get first showResult=" + b16);
                    D(b16, false);
                }
            }
        }
    }

    public void x(int i3) {
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onToggleChange toggle=" + i3);
        if (i3 == 1) {
            this.H = false;
            I();
        } else {
            this.H = true;
            m("onToggleChange");
        }
    }

    public void y(WadlResult wadlResult) {
        if (!L(wadlResult)) {
            return;
        }
        int i3 = wadlResult.taskStatus;
        if (i3 != 12 && i3 != 9) {
            if (i3 == 2 || i3 == 5 || i3 == 6) {
                l(wadlResult.wadlParams.appId, "reset");
            }
            if (!wadlResult.wadlParams.getFlagEnable(131072) && !wadlResult.wadlParams.getFlagEnable(262144)) {
                if (this.G.size() > 0) {
                    synchronized (this.G) {
                        if (this.G.contains(wadlResult.wadlParams.appId)) {
                            QLog.w("WadlFloat_WadlDLFloatWnd", 1, "onWadlTaskStatusChanged isFloatClose, appId=" + wadlResult.wadlParams.appId);
                            return;
                        }
                    }
                }
                K(wadlResult);
                WadlResult b16 = f.b(this.E, false);
                if (b16 != null) {
                    D(b16, true);
                    return;
                }
                return;
            }
            l(wadlResult.wadlParams.appId, WadlProxyConsts.FLAGS);
            return;
        }
        l(wadlResult.wadlParams.appId, "remove");
        int C = C(wadlResult.wadlParams.appId);
        QLog.d("WadlFloat_WadlDLFloatWnd", 1, "onWadlTaskStatusChanged removeWadlResultByAppId appId=" + wadlResult.wadlParams.appId + ", pos=" + C);
        if (C > -1) {
            r(wadlResult.wadlParams.appId);
        }
    }
}
