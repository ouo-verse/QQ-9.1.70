package com.tencent.mobileqq.popanim;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PopOutEmoticonReceive implements Runnable, StickerBubbleAnimationView.a {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private int[] E;
    private int F;
    private boolean G;
    private Runnable H;

    /* renamed from: d, reason: collision with root package name */
    private Handler f259102d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f259103e;

    /* renamed from: f, reason: collision with root package name */
    private PopOutAnimConfig f259104f;

    /* renamed from: h, reason: collision with root package name */
    private int f259105h;

    /* renamed from: i, reason: collision with root package name */
    private int f259106i;

    /* renamed from: m, reason: collision with root package name */
    private AppRuntime f259107m;

    public PopOutEmoticonReceive(ViewGroup viewGroup, PopOutAnimConfig popOutAnimConfig, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewGroup, popOutAnimConfig, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.H = new Runnable() { // from class: com.tencent.mobileqq.popanim.PopOutEmoticonReceive.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PopOutEmoticonReceive.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (PopOutEmoticonReceive.this.G) {
                    PopOutEmoticonReceive.this.f259104f.stopShakeAnimation();
                    PopOutEmoticonReceive.this.G = false;
                }
            }
        };
        this.f259107m = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f259102d = ThreadManagerV2.getUIHandlerV2();
        this.f259103e = viewGroup;
        this.f259104f = popOutAnimConfig;
        this.f259105h = QQSysFaceUtil.convertToLocal(i3);
        this.f259106i = i16;
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.f(this, false);
    }

    @NonNull
    private int[] f() {
        int[] iArr = this.f259104f.itemCountRecShowAppear;
        if (this.f259106i * 80 < 5000) {
            return iArr;
        }
        int i3 = 0;
        int i16 = 0;
        for (int i17 : iArr) {
            if (i17 <= this.f259106i) {
                i16++;
            }
        }
        int[] iArr2 = new int[i16];
        int i18 = 62 / i16;
        while (i3 < i16) {
            int i19 = i3 + 1;
            iArr2[i3] = i18 * i19;
            i3 = i19;
        }
        return iArr2;
    }

    private void stop() {
        this.C = true;
        this.f259102d.removeCallbacksAndMessages(null);
        this.f259104f.stopShakeAnimation();
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.r(this);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            stop();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void h(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            stop();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PopOutEmoticonReceive", 2, "showReceiveAnimationView from runnable");
        }
        if (this.C) {
            return;
        }
        StickerBubbleAnimationView t16 = com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.t(this.f259103e);
        if (!this.D) {
            t16.bringToFront();
            this.D = true;
        }
        int i3 = this.F + 1;
        this.F = i3;
        if (i3 <= this.f259106i && i3 * 80 <= 5000) {
            if (i3 == 2) {
                this.f259104f.startShakeAnimation();
                this.G = false;
            }
            if (this.E == null) {
                this.E = f();
            }
            t16.d(com.tencent.mobileqq.popanim.view.a.a(this.f259103e.getResources().getDisplayMetrics().widthPixels, com.tencent.mobileqq.popanim.util.a.a(this.f259105h, this.f259104f.apngSoLoaded), com.tencent.mobileqq.popanim.util.a.e(this.F, this.E)));
            this.f259102d.postDelayed(this, 80L);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PopOutEmoticonReceive", 2, "receiver animation sending finished ");
        }
        this.G = true;
        this.f259102d.postDelayed(this.H, 3000L);
    }
}
