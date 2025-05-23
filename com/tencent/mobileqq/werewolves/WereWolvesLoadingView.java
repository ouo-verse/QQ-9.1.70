package com.tencent.mobileqq.werewolves;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WereWolvesLoadingView extends FrameLayout {
    static IPatchRedirector $redirector_;
    int C;
    Runnable D;
    Runnable E;
    boolean F;

    /* renamed from: d, reason: collision with root package name */
    View f315322d;

    /* renamed from: e, reason: collision with root package name */
    int f315323e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f315324f;

    /* renamed from: h, reason: collision with root package name */
    TextView f315325h;

    /* renamed from: i, reason: collision with root package name */
    boolean f315326i;

    /* renamed from: m, reason: collision with root package name */
    Handler f315327m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public WereWolvesLoadingView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f315324f = null;
        this.f315327m = new Handler(Looper.getMainLooper());
        this.C = 0;
        this.D = new Runnable() { // from class: com.tencent.mobileqq.werewolves.WereWolvesLoadingView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WereWolvesLoadingView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                WereWolvesLoadingView wereWolvesLoadingView = WereWolvesLoadingView.this;
                int i3 = wereWolvesLoadingView.C;
                if (i3 >= 100) {
                    wereWolvesLoadingView.setProgress(100);
                    WereWolvesLoadingView.this.f315327m.removeCallbacks(this);
                    return;
                }
                int i16 = i3 + 3;
                wereWolvesLoadingView.C = i16;
                if (i16 > 100) {
                    wereWolvesLoadingView.C = 100;
                }
                wereWolvesLoadingView.setProgress(wereWolvesLoadingView.C);
                WereWolvesLoadingView wereWolvesLoadingView2 = WereWolvesLoadingView.this;
                wereWolvesLoadingView2.f315327m.postDelayed(wereWolvesLoadingView2.D, 40L);
            }
        };
        this.E = new Runnable() { // from class: com.tencent.mobileqq.werewolves.WereWolvesLoadingView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WereWolvesLoadingView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                WereWolvesLoadingView wereWolvesLoadingView = WereWolvesLoadingView.this;
                int i3 = wereWolvesLoadingView.C;
                if (i3 <= 90 && !wereWolvesLoadingView.F) {
                    int i16 = i3 + 1;
                    wereWolvesLoadingView.C = i16 + 1;
                    wereWolvesLoadingView.setProgress(i16);
                    WereWolvesLoadingView.this.f315327m.postDelayed(this, (int) ((r0.C * 2.2222223f) + 100.0f));
                }
            }
        };
        this.F = false;
        a();
    }

    public void setComplete(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        this.F = true;
        this.f315327m.removeCallbacks(this.E);
        this.f315327m.post(this.D);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 100) {
            i3 = 100;
        }
        int i16 = (this.f315323e * i3) / 100;
        if (i16 != 0) {
            ViewGroup.LayoutParams layoutParams = this.f315322d.getLayoutParams();
            layoutParams.width = i16;
            this.f315322d.setVisibility(0);
            this.f315322d.setLayoutParams(layoutParams);
        } else {
            this.f315322d.setVisibility(8);
        }
        this.C = i3;
        this.f315325h.setText(String.format("%d%%", Integer.valueOf(i3)));
        if (this.C < 100) {
            this.f315326i = false;
        }
    }

    public void setTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f315324f.setText(str);
        }
    }

    public WereWolvesLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f315324f = null;
        this.f315327m = new Handler(Looper.getMainLooper());
        this.C = 0;
        this.D = new Runnable() { // from class: com.tencent.mobileqq.werewolves.WereWolvesLoadingView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WereWolvesLoadingView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                WereWolvesLoadingView wereWolvesLoadingView = WereWolvesLoadingView.this;
                int i3 = wereWolvesLoadingView.C;
                if (i3 >= 100) {
                    wereWolvesLoadingView.setProgress(100);
                    WereWolvesLoadingView.this.f315327m.removeCallbacks(this);
                    return;
                }
                int i16 = i3 + 3;
                wereWolvesLoadingView.C = i16;
                if (i16 > 100) {
                    wereWolvesLoadingView.C = 100;
                }
                wereWolvesLoadingView.setProgress(wereWolvesLoadingView.C);
                WereWolvesLoadingView wereWolvesLoadingView2 = WereWolvesLoadingView.this;
                wereWolvesLoadingView2.f315327m.postDelayed(wereWolvesLoadingView2.D, 40L);
            }
        };
        this.E = new Runnable() { // from class: com.tencent.mobileqq.werewolves.WereWolvesLoadingView.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WereWolvesLoadingView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                WereWolvesLoadingView wereWolvesLoadingView = WereWolvesLoadingView.this;
                int i3 = wereWolvesLoadingView.C;
                if (i3 <= 90 && !wereWolvesLoadingView.F) {
                    int i16 = i3 + 1;
                    wereWolvesLoadingView.C = i16 + 1;
                    wereWolvesLoadingView.setProgress(i16);
                    WereWolvesLoadingView.this.f315327m.postDelayed(this, (int) ((r0.C * 2.2222223f) + 100.0f));
                }
            }
        };
        this.F = false;
        a();
    }

    void a() {
    }
}
