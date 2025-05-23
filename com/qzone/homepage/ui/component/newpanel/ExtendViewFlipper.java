package com.qzone.homepage.ui.component.newpanel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ViewAnimator;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ExtendViewFlipper extends ViewAnimator {
    private static String H = "ExtendViewFlipper";
    private int C;
    private boolean D;
    private final BroadcastReceiver E;
    private final int F;
    private final Handler G;

    /* renamed from: d, reason: collision with root package name */
    private int f47716d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f47717e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f47718f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47719h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f47720i;

    /* renamed from: m, reason: collision with root package name */
    private int f47721m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                ExtendViewFlipper.this.f47720i = false;
                ExtendViewFlipper.this.k();
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                ExtendViewFlipper.this.f47720i = true;
                ExtendViewFlipper.this.l(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && ExtendViewFlipper.this.f47718f) {
                ExtendViewFlipper.this.showNext();
                sendMessageDelayed(obtainMessage(1), ExtendViewFlipper.this.f47716d);
            }
        }
    }

    public ExtendViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47716d = 4000;
        this.f47717e = false;
        this.f47718f = false;
        this.f47719h = false;
        this.f47720i = false;
        this.f47721m = R.anim.f155006gh;
        this.C = R.anim.f155007gi;
        this.D = false;
        this.E = new a();
        this.F = 1;
        this.G = new b();
        f();
    }

    private void f() {
        setInAnimation(getContext(), this.f47721m);
        setOutAnimation(getContext(), this.C);
        setFlipInterval(this.f47716d);
    }

    private void h() {
        this.G.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z16) {
        boolean z17 = this.f47720i && this.f47719h;
        if (z17 != this.f47718f) {
            if (z17) {
                this.G.sendMessageDelayed(this.G.obtainMessage(1), this.f47716d);
            } else {
                this.G.removeMessages(1);
            }
            this.f47718f = z17;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (!this.D) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                getContext().registerReceiver(this.E, intentFilter);
                this.D = true;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (this.f47717e) {
            i();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        this.f47720i = i3 == 0;
        l(false);
    }

    public void setAutoStart(boolean z16) {
        this.f47717e = z16;
    }

    public void setFlipInterval(int i3) {
        this.f47716d = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        l(true);
    }

    public void g() {
        this.f47720i = false;
        try {
            if (this.D) {
                getContext().unregisterReceiver(this.E);
                this.D = false;
            }
            k();
            h();
        } catch (Exception e16) {
            QLog.e(H, 1, e16, new Object[0]);
        }
    }

    public void i() {
        this.f47719h = true;
        k();
    }

    public void j() {
        this.f47719h = false;
        k();
    }
}
