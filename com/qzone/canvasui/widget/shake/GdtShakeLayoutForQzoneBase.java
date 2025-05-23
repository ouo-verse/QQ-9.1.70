package com.qzone.canvasui.widget.shake;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class GdtShakeLayoutForQzoneBase extends FrameLayout {
    private static final String TAG = "GdtShakeLayoutForQzoneBase";
    private boolean isRunning;
    protected final Runnable mAnimationRunnable;
    protected final GdtShakeIconView.OnAnimationListener mListener;
    protected final GdtShakeIconView mShakeIconView;
    protected final GdtShakeSensor mShakeSensor;

    public GdtShakeLayoutForQzoneBase(Context context) {
        this(context, null);
    }

    private GdtShakeIconView.OnAnimationListener createOnAnimationListener() {
        return new GdtShakeIconView.OnAnimationListener() { // from class: com.qzone.canvasui.widget.shake.GdtShakeLayoutForQzoneBase.2
            @Override // com.tencent.gdtad.views.shake.GdtShakeIconView.OnAnimationListener
            public void onAnimationEnd() {
                if (GdtShakeLayoutForQzoneBase.this.isRunning) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(GdtShakeLayoutForQzoneBase.this.mAnimationRunnable, 5000L);
                }
            }

            @Override // com.tencent.gdtad.views.shake.GdtShakeIconView.OnAnimationListener
            public void onAnimationRepeat(int i3) {
            }

            @Override // com.tencent.gdtad.views.shake.GdtShakeIconView.OnAnimationListener
            public void onAnimationStart() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimationInternal() {
        this.mShakeIconView.startAnimation(1, 260);
        this.isRunning = true;
    }

    public void init(GdtShakeSensor.Params params) {
        this.mShakeSensor.setShakeFactor(params);
        this.mShakeIconView.setImageResource();
    }

    public void recycle() {
        stop();
        this.mShakeIconView.resetImageResource();
    }

    public void resetShakeSensor() {
        this.mShakeSensor.reset();
    }

    public void setShakeListener(WeakReference<GdtShakeSensor.OnShakeListener> weakReference) {
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.setShakeListener(weakReference);
        }
    }

    public void setShakeWithValueListener(WeakReference<GdtShakeSensor.OnShakeWithValueListener> weakReference) {
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.setShakeWithValueListener(weakReference);
        }
    }

    public void start() {
        if (QZoneAdFeedUtils.f55717a.U() && !this.isRunning) {
            this.mShakeIconView.setOnAnimationListener(new WeakReference<>(this.mListener));
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAnimationRunnable);
            ThreadManagerV2.getUIHandlerV2().post(this.mAnimationRunnable);
            this.mShakeSensor.register(getContext());
        }
    }

    public GdtShakeLayoutForQzoneBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListener = createOnAnimationListener();
        this.mAnimationRunnable = new Runnable() { // from class: com.qzone.canvasui.widget.shake.GdtShakeLayoutForQzoneBase.1
            @Override // java.lang.Runnable
            public void run() {
                GdtShakeLayoutForQzoneBase.this.startAnimationInternal();
            }
        };
        this.isRunning = false;
        this.mShakeIconView = new GdtShakeIconView(getContext());
        this.mShakeSensor = new GdtShakeSensor();
    }

    public void stop() {
        this.isRunning = false;
        this.mShakeIconView.stop();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAnimationRunnable);
        this.mShakeSensor.unregister(getContext());
    }
}
