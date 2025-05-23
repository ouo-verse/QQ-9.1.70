package com.tencent.luggage.wxa.an;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.bn.d;
import com.tencent.luggage.wxa.np.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.bn.c f121599a;

    /* renamed from: b, reason: collision with root package name */
    public d f121600b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f121601c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f121602d;

    /* renamed from: e, reason: collision with root package name */
    public int f121603e = -1;

    /* renamed from: f, reason: collision with root package name */
    public a f121604f = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(k kVar);
    }

    public c(WeakReference weakReference, com.tencent.luggage.wxa.bn.c cVar, d dVar, Handler handler) {
        this.f121599a = cVar;
        this.f121600b = dVar;
        this.f121601c = weakReference;
        this.f121602d = handler;
    }

    public abstract void a(int i3, String[] strArr, int[] iArr);

    public abstract void a(Bundle bundle);

    public void a(com.tencent.luggage.wxa.wp.c cVar) {
    }

    public com.tencent.luggage.wxa.wp.c b() {
        return null;
    }

    public com.tencent.luggage.wxa.wp.c c() {
        return null;
    }

    public int d() {
        return this.f121603e;
    }

    public void e() {
        if (this.f121602d != null) {
            f();
            this.f121602d.obtainMessage(1, this.f121600b).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    public void f() {
        Handler handler = this.f121602d;
        if (handler != null) {
            handler.obtainMessage(5).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    public void g() {
        if (this.f121602d != null) {
            f();
            this.f121602d.obtainMessage(2, this.f121600b).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    public void h() {
        if (this.f121602d != null) {
            f();
            this.f121602d.obtainMessage(0, this.f121600b).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    public void i() {
        Handler handler = this.f121602d;
        if (handler != null) {
            handler.obtainMessage(4).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public void a(int i3) {
        this.f121603e = i3;
    }

    public void b(com.tencent.luggage.wxa.wp.c cVar) {
    }

    public void a(a aVar) {
        this.f121604f = aVar;
    }

    public a a() {
        return this.f121604f;
    }

    public void a(String[] strArr, int i3) {
        Handler handler = this.f121602d;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(3);
            Bundle bundle = new Bundle();
            bundle.putStringArray("permissions", strArr);
            bundle.putInt(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, i3);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    public void a(MMAlertDialog mMAlertDialog) {
        if (mMAlertDialog == null) {
            w.b("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (this.f121602d != null) {
            f();
            this.f121602d.obtainMessage(6, mMAlertDialog).sendToTarget();
        } else {
            w.b("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
