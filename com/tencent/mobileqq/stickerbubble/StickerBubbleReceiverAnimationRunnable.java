package com.tencent.mobileqq.stickerbubble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StickerBubbleReceiverAnimationRunnable implements Runnable, StickerBubbleAnimationView.a {
    static IPatchRedirector $redirector_;
    private String C;
    private boolean D;
    private int[] E;
    private boolean F;
    private boolean G;
    private Runnable H;

    /* renamed from: d, reason: collision with root package name */
    private Context f290223d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f290224e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f290225f;

    /* renamed from: h, reason: collision with root package name */
    private View f290226h;

    /* renamed from: i, reason: collision with root package name */
    private int f290227i;

    /* renamed from: m, reason: collision with root package name */
    private int f290228m;

    public StickerBubbleReceiverAnimationRunnable(AppInterface appInterface, int i3, @NonNull View view, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, Integer.valueOf(i3), view, str);
            return;
        }
        this.D = false;
        this.F = false;
        this.H = new Runnable() { // from class: com.tencent.mobileqq.stickerbubble.StickerBubbleReceiverAnimationRunnable.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerBubbleReceiverAnimationRunnable.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (StickerBubbleReceiverAnimationRunnable.this.G) {
                    StickerBubbleReceiverAnimationRunnable stickerBubbleReceiverAnimationRunnable = StickerBubbleReceiverAnimationRunnable.this;
                    a.a(stickerBubbleReceiverAnimationRunnable, stickerBubbleReceiverAnimationRunnable.f290226h);
                    StickerBubbleReceiverAnimationRunnable.this.G = false;
                }
            }
        };
        this.f290223d = appInterface.getApp().getApplicationContext();
        this.f290224e = appInterface;
        this.f290227i = i3;
        this.f290225f = new Handler(Looper.getMainLooper());
        this.f290226h = view;
        this.C = str;
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.g(this);
    }

    @NonNull
    private int[] f() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (this.f290227i * 80 < 5000) {
            return a.e(appInterface);
        }
        int i3 = 0;
        int i16 = 0;
        for (int i17 : a.e(appInterface)) {
            if (i17 <= this.f290227i) {
                i16++;
            }
        }
        int[] iArr = new int[i16];
        int i18 = 62 / i16;
        while (i3 < i16) {
            int i19 = i3 + 1;
            iArr[i3] = i18 * i19;
            i3 = i19;
        }
        return iArr;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f290225f.removeCallbacksAndMessages(null);
        a.a(this, this.f290226h);
        this.D = true;
        com.tencent.mobileqq.poke.utils.a.f259088a.c(0);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a
    public void h(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        com.tencent.mobileqq.poke.utils.a aVar = com.tencent.mobileqq.poke.utils.a.f259088a;
        int b16 = aVar.b();
        if (b16 > 0) {
            aVar.c(b16 - 1);
        }
        com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.r(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.D) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleRunnable", 2, "showReceiveAnimationView from runnable");
        }
        StickerBubbleAnimationView t16 = com.tencent.mobileqq.stickerbubble.viewholder.b.f290239a.t((ViewGroup) this.f290226h);
        if (!this.F) {
            t16.bringToFront();
            this.F = true;
        }
        if (this.E == null) {
            this.E = f();
        }
        int i3 = this.f290228m + 1;
        this.f290228m = i3;
        if (i3 <= this.f290227i && i3 * 80 <= 5000) {
            if (i3 == 2) {
                a.i(this, this.f290226h);
                this.G = false;
            }
            t16.d(a.b(this.f290223d.getResources().getDisplayMetrics().widthPixels, this.C, this.f290228m, this.E));
            this.f290225f.postDelayed(this, 80L);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleRunnable", 2, "Sticker bubble receiver animation sending finished " + this);
        }
        this.G = true;
        this.f290225f.postDelayed(this.H, 3000L);
    }
}
