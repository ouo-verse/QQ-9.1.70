package com.tencent.mobileqq.ad.troopad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopAdBannerView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private final View.OnClickListener C;
    private final View.OnClickListener D;

    /* renamed from: d, reason: collision with root package name */
    private final Context f186957d;

    /* renamed from: e, reason: collision with root package name */
    private View f186958e;

    /* renamed from: f, reason: collision with root package name */
    private PopupWindow f186959f;

    /* renamed from: h, reason: collision with root package name */
    private int f186960h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f186961i;

    /* renamed from: m, reason: collision with root package name */
    private final List<ValueAnimator> f186962m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ad.troopad.views.TroopAdBannerView$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopAdBannerView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdBannerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAdBannerView.this.c(view);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdBannerView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopAdBannerView.this.d(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopAdBannerView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f186960h = 0;
        this.f186962m = Collections.synchronizedList(new ArrayList());
        this.C = new a();
        this.D = new b();
        this.f186957d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        QLog.d("TroopAdBannerView", 1, "handleAdClick");
        com.tencent.mobileqq.ad.troopad.util.b bVar = com.tencent.mobileqq.ad.troopad.util.b.f186956a;
        throw null;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        for (ValueAnimator valueAnimator : this.f186962m) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.f186962m.clear();
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        QLog.d("TroopAdBannerView", 1, "handleAdClose isUserClick:", Boolean.valueOf(z16));
        this.f186958e.setVisibility(8);
        this.f186959f.dismiss();
        e();
        b();
        if (!z16) {
            return;
        }
        com.tencent.mobileqq.ad.troopad.util.a aVar = com.tencent.mobileqq.ad.troopad.util.a.f186952a;
        throw null;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        throw null;
    }

    public void f(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        LinearLayout linearLayout = this.f186961i;
        if (linearLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
    }
}
