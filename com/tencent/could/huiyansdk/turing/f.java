package com.tencent.could.huiyansdk.turing;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.callback.g;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.enums.AuthState;
import com.tencent.could.huiyansdk.manager.c;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.manager.l;
import com.tencent.could.huiyansdk.turingmodule.TuringSdkImp;
import com.tencent.could.huiyansdk.view.CameraDateGatherView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f100272a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f100273b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f100274c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f100275d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f100276e;

    /* renamed from: f, reason: collision with root package name */
    public TuringResultCacheEntity f100277f;

    /* renamed from: g, reason: collision with root package name */
    public volatile b f100278g;

    /* renamed from: h, reason: collision with root package name */
    public l f100279h;

    /* renamed from: i, reason: collision with root package name */
    public g f100280i;

    /* renamed from: j, reason: collision with root package name */
    public WeakReference<View> f100281j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f100282k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f100283l;

    /* renamed from: m, reason: collision with root package name */
    public HandlerThread f100284m;

    /* renamed from: n, reason: collision with root package name */
    public volatile Handler f100285n;

    /* renamed from: o, reason: collision with root package name */
    public long f100286o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f100287p;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final f f100288a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14107);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100288a = new f();
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100272a = 3000L;
        this.f100273b = false;
        this.f100274c = false;
        this.f100275d = false;
        this.f100276e = false;
        this.f100282k = false;
        this.f100283l = false;
        this.f100287p = false;
    }

    public static void b(f fVar) {
        fVar.getClass();
        if (a.C1019a.f100038a.f100034c) {
            return;
        }
        c.b.f100154a.a(AuthState.START_GET_LIVE_TYPE, (Object) null);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f100278g = (b) TuringSdkImp.class.newInstance();
        this.f100282k = true;
        k kVar = k.a.f100197a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("real init turing: ");
        sb5.append(this.f100282k);
        sb5.append(", ");
        sb5.append(this.f100278g == null);
        sb5.append(", [turing version]: ");
        sb5.append(a());
        kVar.a(1, "TuringSdkHelper", sb5.toString());
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f100282k && this.f100278g != null) {
            return this.f100278g.c();
        }
        k.a.f100197a.a(2, "TuringSdkHelper", "get version, turing is not create!");
        return "";
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        k.a.f100197a.a(2, "TuringSdkHelper", "get turing face result and remove time out event!");
        if (this.f100285n != null) {
            this.f100285n.removeMessages(5);
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        TuringResultCacheEntity turingResultCacheEntity = this.f100277f;
        if (turingResultCacheEntity != null) {
            turingResultCacheEntity.setFrameParam(str);
        }
        if (this.f100282k && this.f100278g != null) {
            this.f100278g.a(str);
            if (TextUtils.isEmpty(str)) {
                HuiYanSdkImp.getInstance().sendOperateInfo("StartTuringStreamCheck", 1, 0L, "");
                return;
            } else {
                HuiYanSdkImp.getInstance().sendOperateInfo("StartTuringStreamCheck", 1, 1L, "");
                return;
            }
        }
        k.a.f100197a.a(2, "TuringSdkHelper", "need turing frame check, turing is not create!");
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f100285n == null) {
            return;
        }
        this.f100285n.removeMessages(3);
        this.f100285n.removeMessages(5);
        this.f100285n.removeMessages(3);
        this.f100285n.removeMessages(4);
        this.f100285n = null;
        HandlerThread handlerThread = this.f100284m;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.f100284m.quitSafely();
    }

    public static void c(f fVar, boolean z16) {
        fVar.d();
        long currentTimeMillis = System.currentTimeMillis() - fVar.f100286o;
        if (z16) {
            HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "GetTuringTokenTimeOut", "" + currentTimeMillis);
            return;
        }
        HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "GetTuringTokenSuccess", "" + currentTimeMillis);
    }

    public static com.tencent.could.huiyansdk.turing.a a(f fVar) {
        WeakReference<View> weakReference = fVar.f100281j;
        if (weakReference != null) {
            KeyEvent.Callback callback = (View) weakReference.get();
            if (callback instanceof CameraDateGatherView) {
                return (com.tencent.could.huiyansdk.turing.a) callback;
            }
            if (callback instanceof com.tencent.could.huiyansdk.view.a) {
                return (com.tencent.could.huiyansdk.turing.a) callback;
            }
        }
        return null;
    }
}
