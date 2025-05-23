package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.image.e;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.image.imageloader.c;
import com.tencent.mobileqq.widget.f;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ZImageView extends ImageView {
    static int FADE_DURATION = 200;
    private boolean hasSetAlphaBgDrawable;
    private boolean isRound;
    private ValueAnimator mAlphaAnimator;
    private Drawable mBackgroundDrawableTemp;
    public com.tencent.mobileqq.kandian.base.image.imageloader.b mController;
    private URL mUrl;
    private Drawable sColorDrawable;
    private boolean startAplhaOnce;
    private String tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ZImageView.this.resetBgDrawable();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ZImageView.this.resetBgDrawable();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ZImageView.this.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public ZImageView(Context context) {
        super(context);
        this.sColorDrawable = new ColorDrawable(-1);
        this.tag = "zimage.ZImageView.v" + hashCode();
        this.mBackgroundDrawableTemp = null;
        this.hasSetAlphaBgDrawable = false;
        this.startAplhaOnce = false;
        init();
    }

    private void init() {
        this.mController = new com.tencent.mobileqq.kandian.base.image.imageloader.b(this.sColorDrawable, this);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        this.mAlphaAnimator = ofInt;
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAlphaAnimator.setDuration(FADE_DURATION);
        this.mAlphaAnimator.addListener(new a());
        this.mAlphaAnimator.addUpdateListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBgDrawable() {
        if (this.hasSetAlphaBgDrawable) {
            setBackgroundDrawable(this.mBackgroundDrawableTemp);
            this.hasSetAlphaBgDrawable = false;
            if (QLog.isColorLevel()) {
                c.e(this.tag, "cancel alpha bg drawable !");
            }
        }
    }

    private void setBgDrawable() {
        if (!this.hasSetAlphaBgDrawable && this.mController.f239059c != this.sColorDrawable) {
            this.mBackgroundDrawableTemp = getBackground();
            setBackgroundDrawable(this.mController.f239059c);
            this.hasSetAlphaBgDrawable = true;
            if (QLog.isColorLevel()) {
                c.e(this.tag, "set alpha bg drawable !");
            }
        }
    }

    public void doAlphaAnimationInNextDraw() {
        this.startAplhaOnce = true;
        this.mAlphaAnimator.cancel();
    }

    public URL getUrl() {
        return this.mUrl;
    }

    @Deprecated
    public boolean isRound() {
        return this.isRound;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        if (QLog.isColorLevel()) {
            ViewParent parent = getParent();
            if (parent != null) {
                str = parent.getClass().getName();
            } else {
                str = null;
            }
            c.e(this.tag, "onAttachedToWindow, parent: " + str);
        }
        this.mController.e(NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (QLog.isColorLevel()) {
            c.e(this.tag, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        this.mController.f(NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mUrl != null) {
            if (QLog.isColorLevel()) {
                c.e(this.tag, "onDraw dispatch load image");
            }
            com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
            e.f239030a.a(bVar, this.mUrl.toString());
            bVar.f239005b = getWidth();
            bVar.f239006c = getHeight();
            RIJImageOptReport.f(1, bVar);
            this.mController.l(bVar);
            this.mUrl = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (QLog.isColorLevel()) {
            c.e(this.tag, "onFinishTemporaryDetach");
        }
        this.mController.e("onFinishTemporaryDetach");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        String str;
        super.onStartTemporaryDetach();
        if (QLog.isColorLevel()) {
            ViewParent parent = getParent();
            if (parent != null) {
                str = parent.getClass().getName();
            } else {
                str = null;
            }
            c.e(this.tag, "onStartTemporaryDetach, parent: " + str);
        }
        this.mController.f("onStartTemporaryDetach");
    }

    public ZImageView setImage(URL url) {
        TraceUtils.traceBegin("ZImageView.setImage");
        if (url == null) {
            TraceUtils.traceEnd();
            return this;
        }
        URL url2 = this.mUrl;
        if (url2 != null && url2.getPath().equals(url.getPath())) {
            QLog.d("ZImageView", 2, "setImage | same");
        }
        this.mUrl = null;
        if (QLog.isColorLevel()) {
            boolean isAttachedToWindow = isAttachedToWindow();
            c.e(this.tag, "setImage " + url + " width " + getWidth() + " isAttach " + isAttachedToWindow);
        }
        if (getWidth() > 0) {
            TraceUtils.traceBegin("ZImageView.newImageRequest");
            com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
            e.f239030a.a(bVar, url.toString());
            bVar.f239005b = getWidth();
            bVar.f239006c = getHeight();
            RIJImageOptReport.f(1, bVar);
            this.mController.l(bVar);
            TraceUtils.traceEnd();
        } else {
            this.mUrl = url;
        }
        TraceUtils.traceEnd();
        return this;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public ZImageView setImageForImageCollection(com.tencent.mobileqq.kandian.base.image.b bVar, iy.a aVar) {
        URL url;
        if (bVar != null && (url = bVar.f239004a) != null) {
            e.f239030a.a(bVar, url.toString());
            if (aVar != null) {
                this.mController.n(aVar);
            }
            this.mUrl = null;
            if (QLog.isColorLevel()) {
                QLog.d(this.tag, 2, "setImageForImageCollection url = " + bVar.f239004a + " reqWidth = " + bVar.f239005b + " reqHeight = " + bVar.f239006c);
            }
            this.mController.l(bVar);
        }
        return this;
    }

    public ZImageView setImagePlaceHolder(Drawable drawable) {
        this.mUrl = null;
        this.mController.m(drawable);
        return this;
    }

    public void setPublicAccountImageDownListener(iy.a aVar) {
        if (aVar != null) {
            this.mController.n(aVar);
        }
    }

    @Deprecated
    public void setRound(boolean z16) {
        this.isRound = z16;
    }

    public void setImageDrawable(Drawable drawable, boolean z16) {
        if (z16) {
            this.mAlphaAnimator.cancel();
            setBgDrawable();
            setImageDrawable(drawable);
            this.mAlphaAnimator.start();
            return;
        }
        setImageDrawable(drawable);
    }

    public ZImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sColorDrawable = new ColorDrawable(-1);
        this.tag = "zimage.ZImageView.v" + hashCode();
        this.mBackgroundDrawableTemp = null;
        this.hasSetAlphaBgDrawable = false;
        this.startAplhaOnce = false;
        init();
    }

    public ZImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.sColorDrawable = new ColorDrawable(-1);
        this.tag = "zimage.ZImageView.v" + hashCode();
        this.mBackgroundDrawableTemp = null;
        this.hasSetAlphaBgDrawable = false;
        this.startAplhaOnce = false;
        init();
    }
}
