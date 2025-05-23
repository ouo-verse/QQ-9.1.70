package com.tencent.biz.qqcircle.immersive.views.live;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLiveAvatarAnimView extends FrameLayout {
    private static final float[] C = {1.0f, 0.9f, 1.0f};
    private static final float[] D = {1.28f, 1.0f, 1.28f, 1.0f};
    private static final float[] E = {0.36f, 0.0f, 0.33f, 1.0f};

    /* renamed from: d, reason: collision with root package name */
    private ImageView f90803d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90804e;

    /* renamed from: f, reason: collision with root package name */
    private RoundImageView f90805f;

    /* renamed from: h, reason: collision with root package name */
    private AnimatorSet f90806h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f90807i;

    /* renamed from: m, reason: collision with root package name */
    private float f90808m;

    public QFSLiveAvatarAnimView(@NonNull Context context) {
        this(context, null);
    }

    private ObjectAnimator b(View view) {
        return ObjectAnimator.ofFloat(view, c.f123400v, E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f90806h = new AnimatorSet();
        this.f90806h.playTogether(i(e(this.f90805f)), i(f(this.f90805f)), i(g(this.f90804e)), i(h(this.f90804e)), i(b(this.f90804e)));
        this.f90806h.start();
    }

    private void d() {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        float f16 = this.f90808m;
        int i3 = (int) (measuredHeight / f16);
        int i16 = (int) (measuredWidth / f16);
        ViewGroup.LayoutParams layoutParams = this.f90803d.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f90804e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.f90805f.getLayoutParams();
        layoutParams.width = i16;
        layoutParams.height = i3;
        layoutParams2.width = i16;
        layoutParams2.height = i3;
        layoutParams3.width = i16;
        layoutParams3.height = i3;
        this.f90803d.setLayoutParams(layoutParams);
        this.f90804e.setLayoutParams(layoutParams2);
        this.f90805f.setLayoutParams(layoutParams3);
        this.f90805f.setmRadius(i16 / 2, false);
    }

    private ObjectAnimator e(View view) {
        return ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, C);
    }

    private ObjectAnimator f(View view) {
        return ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, C);
    }

    private ObjectAnimator g(View view) {
        return ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, D);
    }

    private ObjectAnimator h(View view) {
        return ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, D);
    }

    private ObjectAnimator i(ObjectAnimator objectAnimator) {
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setRepeatMode(2);
            objectAnimator.setDuration(1000L);
        }
        return objectAnimator;
    }

    public void j() {
        if (!this.f90807i) {
            k();
        } else if (this.f90806h == null) {
            post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.live.a
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLiveAvatarAnimView.this.c();
                }
            });
        }
    }

    public void k() {
        RoundImageView roundImageView = this.f90805f;
        if (roundImageView != null) {
            roundImageView.clearAnimation();
        }
        ImageView imageView = this.f90803d;
        if (imageView != null) {
            imageView.clearAnimation();
        }
        ImageView imageView2 = this.f90804e;
        if (imageView2 != null) {
            imageView2.clearAnimation();
        }
        AnimatorSet animatorSet = this.f90806h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f90806h = null;
        QLog.i("QFSLiveAvatarAnimView", 1, "stopPlay()");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("QFSLiveAvatarAnimView", 1, "onDetachedFromWindow(),stopPlay");
        k();
    }

    public void setAvatarDrawable(Drawable drawable) {
        this.f90805f.setImageDrawable(drawable);
    }

    public void setAvatarVisible(boolean z16) {
        int i3;
        RoundImageView roundImageView = this.f90805f;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        roundImageView.setVisibility(i3);
    }

    public void setEnablePlay(boolean z16) {
        QLog.i("QFSLiveAvatarAnimView", 1, "setEnablePlay =" + z16);
        this.f90807i = z16;
        if (z16) {
            j();
        } else {
            k();
        }
    }

    public QFSLiveAvatarAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLiveAvatarAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90808m = 1.56f;
        View.inflate(context, R.layout.gtt, this);
        this.f90803d = (ImageView) findViewById(R.id.ykx);
        this.f90804e = (ImageView) findViewById(R.id.ykw);
        this.f90805f = (RoundImageView) findViewById(R.id.ykv);
    }
}
