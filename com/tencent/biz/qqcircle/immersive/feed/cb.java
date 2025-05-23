package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cb extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements ScaleGestureDetector.OnScaleGestureListener {
    private float I;
    private float J;
    QFSGestureDetectorView K;
    private boolean L;
    private boolean M;
    private QFSVideoView N;

    private void g1(com.tencent.biz.qqcircle.immersive.feed.event.r rVar) {
        if (rVar.a() == 2) {
            this.L = rVar.b();
        } else if (rVar.a() == 1) {
            this.M = rVar.b();
        }
    }

    private boolean h1() {
        if (!this.M && !this.L) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.r) {
            g1((com.tencent.biz.qqcircle.immersive.feed.event.r) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        return com.tencent.biz.qqcircle.utils.ce.c(m0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.N = (QFSVideoView) view.findViewById(R.id.f74163vi);
        QFSGestureDetectorView qFSGestureDetectorView = (QFSGestureDetectorView) view.findViewById(R.id.f45131r2);
        this.K = qFSGestureDetectorView;
        qFSGestureDetectorView.setDetector(new ScaleGestureDetector(view.getContext(), this));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int hashCode;
        super.L0(feedCloudMeta$StFeed, i3);
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
        if (n0() != null && !h1()) {
            QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleBegin");
            this.I = scaleGestureDetector.getFocusX();
            this.J = scaleGestureDetector.getFocusY();
            QFSFeedItemScaleGestureEvent feed = new QFSFeedItemScaleGestureEvent(scaleGestureDetector.getScaleFactor(), 1).setFeed(n0());
            if (m0() != null) {
                i3 = m0().hashCode();
            }
            feed.mHashCode = i3;
            SimpleEventBus.getInstance().dispatchEvent(feed);
            return true;
        }
        QLog.d("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleBegin feed is null. isTopViewFeed: " + h1());
        return false;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        int hashCode;
        if (this.N == null) {
            QLog.e("QFSFeedChildVideoScaleGesturePresenter", 1, "onScaleEnd: playView is null. ");
            return;
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
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildVideoScaleGesturePresenter";
    }
}
