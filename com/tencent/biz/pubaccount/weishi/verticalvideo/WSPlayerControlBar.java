package com.tencent.biz.pubaccount.weishi.verticalvideo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.RotationSeekBar;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class WSPlayerControlBar extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f81806d;

    /* renamed from: e, reason: collision with root package name */
    private RotationSeekBar f81807e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f81808f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f81809h;

    public WSPlayerControlBar(Context context) {
        super(context);
        this.f81806d = 1;
        e(context);
    }

    private void d(Context context, View view) {
        this.f81807e = new RotationSeekBar(context, null, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14);
        this.f81807e.setMinimumHeight(2);
        this.f81807e.setLayoutParams(layoutParams);
        this.f81807e.setPadding(0, 0, 0, 0);
        this.f81807e.setProgress(0);
        this.f81807e.setMax(1000);
        this.f81807e.setProgressDrawable(context.getResources().getDrawable(R.drawable.f161255k83));
        this.f81807e.setThumb(context.getResources().getDrawable(R.drawable.n5t));
        this.f81807e.setThumbOffset(0);
        ((RelativeLayout) view.findViewById(R.id.f759740e)).addView(this.f81807e);
    }

    private void e(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fwz, (ViewGroup) null);
        this.f81808f = (ImageView) inflate.findViewById(R.id.f1177472_);
        d(context, inflate);
        addView(inflate);
    }

    public void a(MotionEvent motionEvent) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.dispatchTouchEvent(motionEvent);
        }
    }

    public void b(Rect rect) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.getGlobalVisibleRect(rect);
        }
    }

    public void c() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WSPlayerControlBar hideLoadingProgressBar() mProgressLoading:");
        sb5.append(this.f81808f);
        sb5.append(", getVisibility():");
        ImageView imageView = this.f81808f;
        if (imageView != null) {
            obj = Integer.valueOf(imageView.getVisibility());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        x.b("WS_VIDEO_ProgressBar", sb5.toString());
        if (this.f81808f != null) {
            x.b("WS_VIDEO_ProgressBar", "WSPlayerControlBar hideLoadingProgressBar() hide");
            h();
            this.f81808f.setVisibility(8);
        }
    }

    public void f(Runnable runnable) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.removeCallbacks(runnable);
        }
    }

    public void g() {
        ImageView imageView = this.f81808f;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (this.f81808f.getBackground() == null) {
                try {
                    this.f81808f.setBackgroundResource(R.drawable.k86);
                } catch (OutOfMemoryError e16) {
                    x.f("WS_VIDEO_seekBar", "showLoadingProgressBar error:" + e16);
                }
            }
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f81808f.getBackground();
            if (animationDrawable != null) {
                animationDrawable.setVisible(true, true);
                animationDrawable.setOneShot(false);
                animationDrawable.start();
            }
        }
    }

    public void h() {
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f81808f.getBackground();
        if (animationDrawable == null || !animationDrawable.isRunning()) {
            return;
        }
        animationDrawable.setOneShot(true);
        animationDrawable.stop();
    }

    public void setNeedDeepClearScreen(boolean z16) {
        this.f81809h = z16;
    }

    public void setProgress(float f16) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.setProgress((int) (f16 * 1000.0f));
        }
    }

    public void setSeekBarActivated(boolean z16) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.setActivated(z16);
        }
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.f81807e.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    public void setThumb(Drawable drawable) {
        RotationSeekBar rotationSeekBar = this.f81807e;
        if (rotationSeekBar != null) {
            rotationSeekBar.setThumb(drawable);
        }
    }

    public WSPlayerControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f81806d = 1;
        e(context);
    }

    public WSPlayerControlBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f81806d = 1;
        e(context);
    }
}
