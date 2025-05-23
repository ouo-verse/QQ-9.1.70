package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemTouchEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class av extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements ScaleGestureDetector.OnScaleGestureListener, QFSGestureDetectorView.a {
    private float I;
    private float J;
    QFSGestureDetectorView K;
    private boolean L;
    private boolean M;
    private QFSImageBanner N;
    private boolean P;
    private boolean Q = false;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);

        void b();

        boolean isPlaying();
    }

    private int g1() {
        if (m0() == null) {
            return 0;
        }
        return m0().hashCode();
    }

    private void h1(com.tencent.biz.qqcircle.immersive.feed.event.r rVar) {
        if (rVar.a() == 2) {
            this.L = rVar.b();
        } else if (rVar.a() == 1) {
            this.M = rVar.b();
        }
    }

    private boolean i1() {
        if (!this.M && !this.L) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.r) {
            h1((com.tencent.biz.qqcircle.immersive.feed.event.r) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        return com.tencent.biz.qqcircle.utils.ce.c(m0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.N = (QFSImageBanner) view.findViewById(R.id.f43991nz);
        this.K = (QFSGestureDetectorView) view.findViewById(R.id.f45131r2);
        boolean a16 = ac0.c.a();
        this.P = a16;
        if (a16) {
            this.K.setVisibility(0);
            this.K.setDetector(new ScaleGestureDetector(view.getContext(), this));
            this.K.setTouchEventDirector(this);
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView.a
    public boolean Q(MotionEvent motionEvent, float f16, float f17) {
        boolean z16;
        boolean z17;
        QFSImageBanner qFSImageBanner = this.N;
        if (qFSImageBanner == null || qFSImageBanner.T() <= 1) {
            return false;
        }
        if (Math.abs(f16) >= Math.abs(f17)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (qFSImageBanner.h0()) {
            return true;
        }
        if (f16 > 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        int S = qFSImageBanner.S();
        if (qFSImageBanner.T() == S + 1 && !z17) {
            return false;
        }
        if (S == 0 && z17) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView.a
    public void b(MotionEvent motionEvent, boolean z16) {
        if (z16) {
            return;
        }
        QFSFeedItemTouchEvent qFSFeedItemTouchEvent = new QFSFeedItemTouchEvent(motionEvent);
        qFSFeedItemTouchEvent.mHashCode = g1();
        SimpleEventBus.getInstance().dispatchEvent(qFSFeedItemTouchEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int hashCode;
        super.L0(feedCloudMeta$StFeed, i3);
        if (!this.P) {
            return;
        }
        QFSGestureDetectorView qFSGestureDetectorView = this.K;
        if (qFSGestureDetectorView != null) {
            qFSGestureDetectorView.setFeed(n0());
        }
        if (com.tencent.biz.qqcircle.utils.ce.c(m0())) {
            QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "exit clear screen if refresh data.");
            QFSFeedItemScaleGestureEvent feed = new QFSFeedItemScaleGestureEvent(1.0f, 3).setFeed(feedCloudMeta$StFeed);
            if (m0() == null) {
                hashCode = 0;
            } else {
                hashCode = m0().hashCode();
            }
            feed.mHashCode = hashCode;
            SimpleEventBus.getInstance().dispatchEvent(feed);
        }
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.N == null) {
            QLog.e("QFSFeedChildVideoScaleGesturePresenter", 1, "onScale: playView is null. ");
            return false;
        }
        QLog.d("QFSFeedChildVideoScaleGesturePresenter", 4, "onScale");
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        float f16 = focusX - this.I;
        float f17 = focusY - this.J;
        this.N.setTranslationX(f16);
        this.N.setTranslationY(f17);
        this.N.setScaleX(scaleFactor);
        this.N.setScaleY(scaleFactor);
        return false;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        int i3 = 0;
        if (n0() != null && !i1()) {
            QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleBegin");
            QFSImageBanner qFSImageBanner = this.N;
            if (qFSImageBanner != null) {
                this.Q = qFSImageBanner.l0();
                this.N.y0();
            }
            this.I = scaleGestureDetector.getFocusX();
            this.J = scaleGestureDetector.getFocusY();
            QFSFeedItemScaleGestureEvent detectorView = new QFSFeedItemScaleGestureEvent(scaleGestureDetector.getScaleFactor(), 1).setFeed(n0()).setDetectorView(this.N);
            if (m0() != null) {
                i3 = m0().hashCode();
            }
            detectorView.mHashCode = i3;
            SimpleEventBus.getInstance().dispatchEvent(detectorView);
            return true;
        }
        QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleBegin feed is null. isTopViewFeed: " + i1());
        return false;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        int hashCode;
        QFSImageBanner qFSImageBanner = this.N;
        if (qFSImageBanner == null) {
            QLog.e("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleEnd: playView is null. ");
            return;
        }
        if (this.Q) {
            qFSImageBanner.v0();
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleEnd. scale: " + scaleFactor + ", is NaN: " + Float.isNaN(scaleFactor));
        QFSFeedItemScaleGestureEvent feed = new QFSFeedItemScaleGestureEvent(scaleFactor, 2).setFeed(n0());
        if (m0() == null) {
            hashCode = 0;
        } else {
            hashCode = m0().hashCode();
        }
        feed.mHashCode = hashCode;
        SimpleEventBus.getInstance().dispatchEvent(feed);
        float translationX = this.N.getTranslationX();
        float translationY = this.N.getTranslationY();
        if (Float.isNaN(scaleFactor)) {
            scaleFactor = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.N, BasicAnimation.KeyPath.SCALE_X, scaleFactor, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.N, BasicAnimation.KeyPath.SCALE_Y, scaleFactor, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.N, "TranslationX", translationX, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.N, "TranslationY", translationY, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        animatorSet.setDuration(250L);
        animatorSet.start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public String w0() {
        return "QFSFeedChildVideoScaleGesturePresenter";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView.a
    public boolean x(boolean z16) {
        if (z16) {
            return true;
        }
        return false;
    }
}
