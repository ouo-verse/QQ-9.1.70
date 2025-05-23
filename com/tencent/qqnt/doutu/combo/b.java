package com.tencent.qqnt.doutu.combo;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.g;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes24.dex */
public class b implements Handler.Callback, View.OnTouchListener {
    static IPatchRedirector $redirector_;
    Handler C;
    RelativeLayout D;
    ComboNavigateBar E;
    ComboMasterView F;
    ComboEggView G;
    public g H;

    /* renamed from: d, reason: collision with root package name */
    private a f356084d;

    /* renamed from: e, reason: collision with root package name */
    private int f356085e;

    /* renamed from: f, reason: collision with root package name */
    public BaseQQAppInterface f356086f;

    /* renamed from: h, reason: collision with root package name */
    public Activity f356087h;

    /* renamed from: i, reason: collision with root package name */
    public ViewGroup f356088i;

    /* renamed from: m, reason: collision with root package name */
    Context f356089m;

    public b(BaseQQAppInterface baseQQAppInterface, Activity activity, g gVar, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, activity, gVar, viewGroup);
            return;
        }
        this.f356085e = 0;
        this.C = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f356086f = baseQQAppInterface;
        this.f356087h = activity;
        this.f356088i = viewGroup;
        this.f356089m = viewGroup.getContext();
        this.H = gVar;
    }

    private boolean d() {
        boolean z16;
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        long maxMemory = runtime.maxMemory() / 1048576;
        long j3 = maxMemory - freeMemory;
        if (j3 < 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, " hasOOMDanger: " + z16 + " availHeapSizeInMB:" + j3 + " maxHeapSizeInMB:" + maxMemory + " usedMemInMB:" + freeMemory);
        }
        StatisticCollector.d(BaseApplication.getContext()).c(null, "ComboEggOOM", !z16, j3, freeMemory, null, "");
        return z16;
    }

    private void e() {
        if (this.D == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f356089m);
            this.D = relativeLayout;
            relativeLayout.setOnTouchListener(this);
        }
        FrameLayout frameLayout = (FrameLayout) this.f356087h.getWindow().getDecorView();
        if (frameLayout.indexOfChild(this.D) == -1) {
            frameLayout.addView(this.D, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private ComboEggView k(a aVar) {
        e();
        ComboEggView comboEggView = (ComboEggView) LayoutInflater.from(this.f356089m).inflate(R.layout.fpp, (ViewGroup) null);
        comboEggView.d(this, this.f356086f);
        if (comboEggView.e(aVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.D.addView(comboEggView, layoutParams);
            comboEggView.a();
            return comboEggView;
        }
        o(aVar);
        return null;
    }

    private ComboMasterView l(a aVar) {
        e();
        ComboMasterView comboMasterView = (ComboMasterView) LayoutInflater.from(this.f356089m).inflate(R.layout.fpq, (ViewGroup) null);
        comboMasterView.e(this);
        if (comboMasterView.g(aVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.D.addView(comboMasterView, layoutParams);
            comboMasterView.a();
            return comboMasterView;
        }
        o(aVar);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o(a aVar) {
        ConstraintLayout.LayoutParams layoutParams = null;
        if (this.E == null) {
            ComboNavigateBar comboNavigateBar = (ComboNavigateBar) LayoutInflater.from(this.f356089m).inflate(R.layout.fpr, (ViewGroup) null);
            this.E = comboNavigateBar;
            comboNavigateBar.c(this.f356086f);
        }
        if (this.f356088i.indexOfChild(this.E) == -1) {
            ViewGroup viewGroup = this.f356088i;
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(32.0f));
                layoutParams2.addRule(11);
                layoutParams = layoutParams2;
            } else if (viewGroup instanceof ConstraintLayout) {
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, ViewUtils.dip2px(32.0f));
                layoutParams3.rightToRight = 0;
                layoutParams3.topToTop = 0;
                layoutParams = layoutParams3;
            }
            if (layoutParams == null) {
                QLog.e("ComboUIManager", 1, "updateNavigateBar error, invalid content view!");
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dip2px(22.0f);
                this.f356088i.addView(this.E, layoutParams);
                this.f356088i.setVisibility(0);
            }
        }
        this.E.setInfo(aVar);
    }

    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ComboMasterView comboMasterView = this.F;
        if (comboMasterView != null) {
            comboMasterView.b(this.D);
            a aVar = this.F.f356052e;
            a aVar2 = new a(aVar.f356080a, aVar.f356083d, aVar.f356081b);
            this.F = null;
            return aVar2;
        }
        ComboEggView comboEggView = this.G;
        if (comboEggView == null) {
            return null;
        }
        comboEggView.c(this.D);
        a aVar3 = this.G.C;
        a aVar4 = new a(aVar3.f356080a, aVar3.f356083d, aVar3.f356081b);
        this.G = null;
        return aVar4;
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.C.sendEmptyMessageDelayed(12, j3);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.D != null) {
            FrameLayout frameLayout = (FrameLayout) this.f356087h.getWindow().getDecorView();
            a();
            frameLayout.removeView(this.D);
            this.D = null;
        }
        ComboResource.a();
        ComboNavigateBar comboNavigateBar = this.E;
        if (comboNavigateBar != null) {
            ViewGroup viewGroup = this.f356088i;
            if (viewGroup != null) {
                viewGroup.removeView(comboNavigateBar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, "clearViews, set mComboNavigateBar null");
            }
            this.E = null;
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        a a16 = a();
        if (a16 != null) {
            o(a16);
        }
    }

    public void g(Animator animator, ComboMasterView comboMasterView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) animator, (Object) comboMasterView);
            return;
        }
        if (this.D != null) {
            a aVar = comboMasterView.f356052e;
            if (aVar != null && this.f356084d.f356081b == aVar.f356081b) {
                o(aVar);
            }
            this.D.removeView(comboMasterView);
        }
        g gVar = this.H;
        if (gVar != null) {
            gVar.b();
        }
        this.F = null;
    }

    public void h(ComboEggView comboEggView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) comboEggView);
            return;
        }
        if (this.D != null) {
            a aVar = comboEggView.C;
            if (aVar != null && this.f356084d.f356081b == aVar.f356081b) {
                o(aVar);
            }
            this.D.removeView(comboEggView);
        }
        g gVar = this.H;
        if (gVar != null) {
            gVar.b();
        }
        this.G = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        a aVar = (a) message.obj;
        a a16 = a();
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 11) {
                    if (i3 == 12) {
                        ComboNavigateBar comboNavigateBar = this.E;
                        if (comboNavigateBar != null) {
                            comboNavigateBar.b();
                        }
                        this.f356084d = null;
                        c();
                    }
                } else {
                    c();
                }
            } else {
                if (aVar.f356081b > 999) {
                    aVar.f356081b = 999;
                }
                g gVar = this.H;
                if (gVar != null && !gVar.d()) {
                    o(aVar);
                } else {
                    if (a16 != null) {
                        o(a16);
                    }
                    g gVar2 = this.H;
                    if (gVar2 != null) {
                        gVar2.c();
                    }
                    if (message.what == 2) {
                        this.F = l(aVar);
                    } else {
                        com.tencent.mobileqq.temp.report.a.a(this.f356086f, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
                        if (d()) {
                            if (TextUtils.equals(aVar.f356083d.toString(), this.f356086f.getCurrentAccountUin())) {
                                this.F = l(aVar);
                            } else {
                                o(aVar);
                            }
                        } else {
                            ComboEggView k3 = k(aVar);
                            this.G = k3;
                            if (k3 == null) {
                                o(aVar);
                            }
                        }
                    }
                }
            }
        } else {
            if (aVar.f356081b > 999) {
                aVar.f356081b = 999;
            }
            o(aVar);
        }
        return true;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.C.removeMessages(12);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "removeListener");
        }
        this.H = null;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "uninit");
        }
        this.C.removeCallbacksAndMessages(null);
        c();
        j();
    }

    public synchronized void n(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        a aVar2 = this.f356084d;
        if (aVar2 != null && aVar2.f356081b >= aVar.f356081b) {
            return;
        }
        this.f356084d = aVar;
        boolean z16 = true;
        Message obtainMessage = this.C.obtainMessage(1);
        obtainMessage.obj = aVar;
        if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "update  msg what:" + obtainMessage.what + " " + aVar);
        }
        if (!aVar.f356082c) {
            obtainMessage.what = 1;
        } else if (ComboEggView.b(aVar.f356081b)) {
            obtainMessage.what = 3;
        } else if (TextUtils.equals(aVar.f356083d.toString(), this.f356086f.getCurrentUin())) {
            obtainMessage.what = 2;
        } else {
            obtainMessage.what = 1;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("update, mDoutuListener == null : ");
            if (this.H != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("ComboUIManager", 2, sb5.toString());
        }
        g gVar = this.H;
        if (gVar != null && !gVar.e() && obtainMessage.what < 11) {
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, "isTroopAioTipsShown");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, "update sendMessage");
            }
            this.C.sendMessageDelayed(obtainMessage, 0L);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (this.F == null && this.G == null) {
            return false;
        }
        f();
        g gVar = this.H;
        if (gVar != null) {
            gVar.b();
            return true;
        }
        return true;
    }
}
