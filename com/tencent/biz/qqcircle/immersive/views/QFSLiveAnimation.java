package com.tencent.biz.qqcircle.immersive.views;

import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLiveAnimation {

    /* renamed from: a, reason: collision with root package name */
    private String f90391a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f90392b;

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    volatile QQAnimationDrawable f90393c;

    /* renamed from: f, reason: collision with root package name */
    private IAegisLogApi f90396f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f90394d = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f90395e = false;

    /* renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    final AnimCreateListener f90397g = new AnimCreateListener(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class AnimCreateListener implements AnimationDrawableFactory.CreateResultListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSLiveAnimation> f90398d;

        AnimCreateListener(QFSLiveAnimation qFSLiveAnimation) {
            this.f90398d = new WeakReference<>(qFSLiveAnimation);
        }

        @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
        public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
            QFSLiveAnimation qFSLiveAnimation = this.f90398d.get();
            if (qFSLiveAnimation != null) {
                qFSLiveAnimation.f90395e = false;
                if (z16 && qQAnimationDrawable != null) {
                    if (qFSLiveAnimation.f90396f != null) {
                        qFSLiveAnimation.f90396f.i("QFSLiveAnimation", 1, "fetch live AnimDrawable success! url=" + qFSLiveAnimation.f90391a);
                    }
                    qQAnimationDrawable.setOneShot(false);
                    qFSLiveAnimation.f90393c = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSLiveAnimation.AnimCreateListener.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            QFSLiveAnimation qFSLiveAnimation2 = (QFSLiveAnimation) AnimCreateListener.this.f90398d.get();
                            if (qFSLiveAnimation2 != null) {
                                qFSLiveAnimation2.g();
                            }
                        }
                    });
                    return;
                }
                if (qFSLiveAnimation.f90396f != null) {
                    qFSLiveAnimation.f90396f.e("QFSLiveAnimation", 1, "fetch live AnimDrawable fail! url=" + qFSLiveAnimation.f90391a);
                }
            }
        }
    }

    public QFSLiveAnimation(ImageView imageView, String str, IAegisLogApi iAegisLogApi) {
        this.f90392b = imageView;
        this.f90391a = str;
        this.f90396f = iAegisLogApi;
        e();
    }

    private void e() {
        AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder(this.f90391a);
        defaultBuilder.setFrameDuration(67);
        defaultBuilder.setCreateTimeOut(TTL.MAX_VALUE);
        q50.a.a(hashCode(), defaultBuilder.build(), this.f90397g);
        this.f90395e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f90394d) {
            IAegisLogApi iAegisLogApi = this.f90396f;
            if (iAegisLogApi != null) {
                iAegisLogApi.e("QFSLiveAnimation", 1, "live AnimDrawable cannot play, url=" + this.f90391a);
                return;
            }
            return;
        }
        if (this.f90393c == null) {
            IAegisLogApi iAegisLogApi2 = this.f90396f;
            if (iAegisLogApi2 != null) {
                iAegisLogApi2.e("QFSLiveAnimation", 1, "live AnimDrawable is empty, url=" + this.f90391a);
                return;
            }
            return;
        }
        ImageView imageView = this.f90392b;
        if (imageView == null) {
            IAegisLogApi iAegisLogApi3 = this.f90396f;
            if (iAegisLogApi3 != null) {
                iAegisLogApi3.e("QFSLiveAnimation", 1, "image view is empty, url=" + this.f90391a);
                return;
            }
            return;
        }
        imageView.setImageDrawable(this.f90393c);
        this.f90393c.start();
    }

    public void f() {
        IAegisLogApi iAegisLogApi = this.f90396f;
        if (iAegisLogApi != null) {
            iAegisLogApi.i("QFSLiveAnimation", 1, "play live AnimDrawable, url=" + this.f90391a);
        }
        this.f90394d = true;
        ImageView imageView = this.f90392b;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (this.f90393c != null) {
                g();
            } else if (!this.f90395e) {
                e();
            }
        }
    }

    public void h() {
        IAegisLogApi iAegisLogApi = this.f90396f;
        if (iAegisLogApi != null) {
            iAegisLogApi.i("QFSLiveAnimation", 1, "stop live AnimDrawable, url=" + this.f90391a);
        }
        this.f90394d = false;
        if (this.f90393c != null) {
            this.f90393c.stop();
        }
        ImageView imageView = this.f90392b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
