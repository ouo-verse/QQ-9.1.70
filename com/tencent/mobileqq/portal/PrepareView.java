package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PrepareView extends BasePrepareView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Context f259325d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f259326e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f259327f;

    /* renamed from: h, reason: collision with root package name */
    private CountDownTimer f259328h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f259329i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f259330m;

    /* loaded from: classes16.dex */
    class a extends CountDownTimer {
        static IPatchRedirector $redirector_;

        a(long j3, long j16) {
            super(j3, j16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PrepareView.this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                PrepareView.this.e();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                int i3 = (int) (j3 / 1000);
                PrepareView.this.f259327f.setText(String.format(Locale.CHINA, "\u8fd8\u9700\u7b49\u5f85  %02d : %02d", Integer.valueOf(i3 / 60), Integer.valueOf(i3 % 60)));
            }
        }
    }

    public PrepareView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f259330m = false;
        this.f259325d = context;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Drawable drawable, Drawable drawable2, Typeface typeface) {
        this.f259326e.setBackground(drawable);
        if (!this.f259330m) {
            this.f259329i.setImageDrawable(drawable2);
        }
        this.f259327f.setTypeface(typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        SpringRes a16 = s.a("spring_shua_avoid_peak_text_bg.png");
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        final Drawable i3 = a16.i(colorDrawable, new Bundle());
        final Drawable i16 = s.a("spring_shua_avoid_peak_bg.png").i(colorDrawable, new Bundle());
        final Typeface createFromAsset = Typeface.createFromAsset(applicationContext.getAssets(), "fonts/FZ_PANGWA_SIMPLIFIED.ttf");
        post(new Runnable() { // from class: com.tencent.mobileqq.portal.q
            @Override // java.lang.Runnable
            public final void run() {
                PrepareView.this.j(i3, i16, createFromAsset);
            }
        });
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f259329i.setImageDrawable(null);
        }
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PrepareView", 2, "startTimeDown time = " + j3);
        }
        this.f259326e.setVisibility(0);
        CountDownTimer countDownTimer = this.f259328h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        a aVar = new a(j3, 1000L);
        this.f259328h = aVar;
        aVar.start();
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        CountDownTimer countDownTimer = this.f259328h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f259328h = null;
        }
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        e();
        removeAllViews();
        LayoutInflater.from(this.f259325d).inflate(R.layout.av_, (ViewGroup) this, true);
        this.f259329i = (ImageView) findViewById(R.id.f97245jv);
        this.f259326e = (RelativeLayout) findViewById(R.id.jlk);
        this.f259327f = (TextView) findViewById(R.id.jlh);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.portal.p
            @Override // java.lang.Runnable
            public final void run() {
                PrepareView.this.k();
            }
        }, 64, null, false);
        return true;
    }

    @Override // com.tencent.mobileqq.portal.BasePrepareView
    public void setBackground(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
            return;
        }
        try {
            this.f259330m = true;
            if (bitmap != null) {
                Drawable background = getBackground();
                if (!(background instanceof BitmapDrawable) || ((BitmapDrawable) background).getBitmap() != bitmap) {
                    this.f259329i.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
                }
            } else {
                this.f259329i.setImageDrawable(s.a("spring_shua_avoid_peak_bg.png").i(ApngOptions.TRANSPARENT, new Bundle()));
            }
        } catch (Throwable th5) {
            QLog.e("PrepareView", 1, th5, new Object[0]);
        }
    }
}
