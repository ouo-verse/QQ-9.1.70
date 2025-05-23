package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* loaded from: classes32.dex */
public class AECircleCaptureProgressView extends FrameLayout {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f65834d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f65835e;

    /* renamed from: f, reason: collision with root package name */
    private AnimationQIMCircleProgress f65836f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f65837h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f65838i;

    /* renamed from: m, reason: collision with root package name */
    private int f65839m;

    public AECircleCaptureProgressView(Context context) {
        this(context, null);
    }

    private void f(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.dl8, (ViewGroup) this, true);
        this.f65834d = (ImageView) findViewById(R.id.rvu);
        this.f65835e = (ImageView) findViewById(R.id.rvx);
        this.f65836f = (AnimationQIMCircleProgress) findViewById(R.id.roa);
    }

    public void b(boolean z16, b bVar) {
        ImageView imageView = this.f65834d;
        if (imageView != null) {
            imageView.setImageResource(bVar.f65905b);
        }
        ImageView imageView2 = this.f65835e;
        if (imageView2 != null) {
            imageView2.setImageResource(bVar.f65908e);
        }
        this.f65838i = bVar.f65911h;
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.a(z16, bVar);
            this.f65836f.setAlpha(this.f65838i[0]);
        }
    }

    public void c(boolean z16) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.b(z16);
        }
    }

    public void d(int i3) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.changeMode(i3);
        }
    }

    public int e() {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            return animationQIMCircleProgress.getMode();
        }
        return 0;
    }

    public void g(float f16) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = animationQIMCircleProgress.getLayoutParams();
        int i3 = this.C;
        layoutParams.width = (int) (i3 * f16);
        layoutParams.height = (int) (i3 * f16);
        this.f65836f.setLayoutParams(layoutParams);
        this.f65836f.setAlpha(a(b.a(f16), this.f65838i));
    }

    public void setCenterScaleValue(float f16) {
        ImageView imageView = this.f65834d;
        if (imageView == null) {
            return;
        }
        imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams = this.f65835e.getLayoutParams();
        int i3 = this.f65839m;
        layoutParams.width = (int) (i3 * f16);
        layoutParams.height = (int) (i3 * f16);
        this.f65835e.setLayoutParams(layoutParams);
        float a16 = a(b.b(f16), this.f65837h);
        this.f65834d.setAlpha(a16);
        this.f65835e.setAlpha(1.0f - a16);
    }

    public void setCenterView() {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.setCenterView();
        }
    }

    public void setProgress(float f16) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.setProgress(f16);
        }
    }

    public void setStrokeWidth(float f16) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.f65836f;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.setStrokeWidth(f16);
        }
    }

    public AECircleCaptureProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float a(float f16, float[] fArr) {
        float f17 = fArr[0];
        return f17 + (f16 * (fArr[1] - f17));
    }

    public AECircleCaptureProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65837h = new float[]{0.0f, 1.0f};
        this.f65838i = new float[]{0.0f, 1.0f};
        this.f65839m = BaseAIOUtils.f(98.0f, getResources());
        this.C = BaseAIOUtils.f(98.0f, getResources());
        f(context, attributeSet);
    }
}
