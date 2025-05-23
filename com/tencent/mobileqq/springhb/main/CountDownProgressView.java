package com.tencent.mobileqq.springhb.main;

import android.content.Context;
import android.graphics.Typeface;
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
public class CountDownProgressView extends BaseCountDownProgressView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final ProgressViewRed f289337d;

    /* renamed from: e, reason: collision with root package name */
    private final int f289338e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f289339f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f289340h;

    /* renamed from: i, reason: collision with root package name */
    private long f289341i;

    /* renamed from: m, reason: collision with root package name */
    private long f289342m;

    public CountDownProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        int dpToPx = ImmersiveUtils.dpToPx(66.0f);
        this.f289338e = dpToPx;
        boolean a16 = HongbaoView.c.a();
        this.f289339f = a16;
        this.f289340h = null;
        this.f289341i = 0L;
        this.f289342m = 0L;
        ProgressViewRed progressViewRed = new ProgressViewRed(context);
        this.f289337d = progressViewRed;
        float dimension = context.getResources().getDimension(R.dimen.afs);
        progressViewRed.setTextSize(0, dimension);
        progressViewRed.setAlpha(255);
        addView(progressViewRed, -1, -1);
        if (!a16) {
            TextView textView = new TextView(context);
            textView.setBackgroundColor(0);
            textView.setText("\u9000\u51fa");
            textView.setGravity(17);
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/DS-DIGIB.TTF"));
            textView.setTextColor(-1);
            textView.setTextSize(0, dimension);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, -1);
            layoutParams.addRule(11);
            addView(textView, layoutParams);
        }
    }

    private boolean e(float f16, float f17) {
        int[] iArr = {0, 0};
        getLocationOnScreen(iArr);
        int width = iArr[0] + getWidth();
        int height = iArr[1] + getHeight();
        if (f16 < width - this.f289338e || f16 >= width || f17 < iArr[1] || f17 >= height) {
            return false;
        }
        return true;
    }

    private void f() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f289341i < 1000) {
            return;
        }
        this.f289341i = uptimeMillis;
        Runnable runnable = this.f289340h;
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
        if (!this.f289339f && getVisibility() == 0) {
            if (e(motionEvent.getRawX(), motionEvent.getRawY())) {
                j3 = SystemClock.uptimeMillis();
            } else {
                j3 = 0;
            }
            this.f289342m = j3;
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void c(@Nullable MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.f289339f && getVisibility() == 0 && motionEvent != null && SystemClock.uptimeMillis() - this.f289342m <= 300 && e(motionEvent.getRawX(), motionEvent.getRawY())) {
            f();
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void d(long j3, long j16, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16), charSequence);
        } else {
            this.f289337d.b(j3, j16, charSequence);
        }
    }

    @Override // com.tencent.mobileqq.springhb.main.BaseCountDownProgressView
    public void setOnQuitClickListener(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            if (this.f289339f) {
                return;
            }
            this.f289340h = runnable;
        }
    }
}
