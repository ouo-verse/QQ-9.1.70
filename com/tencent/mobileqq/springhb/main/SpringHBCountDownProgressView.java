package com.tencent.mobileqq.springhb.main;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.portal.HongbaoView;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes18.dex */
public class SpringHBCountDownProgressView extends BaseCountDownProgressView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ProgressViewRed f289343d;

    /* renamed from: e, reason: collision with root package name */
    private final int f289344e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f289345f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f289346h;

    /* renamed from: i, reason: collision with root package name */
    private long f289347i;

    /* renamed from: m, reason: collision with root package name */
    private long f289348m;

    public SpringHBCountDownProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f289344e = ImmersiveUtils.dpToPx(44.0f);
        boolean a16 = HongbaoView.c.a();
        this.f289345f = a16;
        this.f289346h = null;
        this.f289347i = 0L;
        this.f289348m = 0L;
        e(context);
        if (!a16) {
            f(context);
        }
    }

    private void e(Context context) {
        this.f289343d = new ProgressViewRed(context);
        ColorDrawable colorDrawable = new ColorDrawable(-5690567);
        this.f289343d.setDrawables(context.getDrawable(R.drawable.lno), colorDrawable);
        this.f289343d.setTextSize(1, 12.0f);
        this.f289343d.setAlpha(255);
        this.f289343d.setTextColor(-1);
        this.f289343d.setBoldTextStyle();
        addView(this.f289343d, -1, -1);
    }

    private void f(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundColor(0);
        textView.setText(R.string.g3l);
        textView.setGravity(17);
        textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/DS-DIGIB.TTF"), 1);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f289344e, -1);
        layoutParams.addRule(11);
        addView(textView, layoutParams);
    }

    private boolean g(float f16, float f17) {
        int[] iArr = {0, 0};
        getLocationOnScreen(iArr);
        int width = iArr[0] + getWidth();
        int height = iArr[1] + getHeight();
        if (f16 < width - this.f289344e || f16 >= width || f17 < iArr[1] || f17 >= height) {
            return false;
        }
        return true;
    }

    private void h() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f289347i < 1000) {
            return;
        }
        this.f289347i = uptimeMillis;
        Runnable runnable = this.f289346h;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return getAlpha();
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void b(@NonNull MotionEvent motionEvent) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.f289345f && getVisibility() == 0) {
            if (g(motionEvent.getRawX(), motionEvent.getRawY())) {
                j3 = SystemClock.uptimeMillis();
            } else {
                j3 = 0;
            }
            this.f289348m = j3;
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void c(@Nullable MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.f289345f && getVisibility() == 0 && motionEvent != null && SystemClock.uptimeMillis() - this.f289348m <= 300 && g(motionEvent.getRawX(), motionEvent.getRawY())) {
            h();
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void d(long j3, long j16, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16), charSequence);
        } else {
            this.f289343d.b(j3, j16, charSequence);
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void setOnQuitClickListener(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            if (this.f289345f) {
                return;
            }
            this.f289346h = runnable;
        }
    }
}
