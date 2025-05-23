package com.tencent.biz.qqcircle.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.events.QFSFloatEndCaptureEvent;
import com.tencent.biz.qqcircle.immersive.utils.be;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ab {

    /* renamed from: q, reason: collision with root package name */
    private static final boolean f84588q = uq3.c.n6();

    /* renamed from: a, reason: collision with root package name */
    private final List<View> f84589a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final View f84590b;

    /* renamed from: c, reason: collision with root package name */
    private QFSVideoView f84591c;

    /* renamed from: d, reason: collision with root package name */
    private View f84592d;

    /* renamed from: e, reason: collision with root package name */
    private int f84593e;

    /* renamed from: f, reason: collision with root package name */
    private int f84594f;

    /* renamed from: g, reason: collision with root package name */
    private int f84595g;

    /* renamed from: h, reason: collision with root package name */
    private int f84596h;

    /* renamed from: i, reason: collision with root package name */
    private int f84597i;

    /* renamed from: j, reason: collision with root package name */
    private int f84598j;

    /* renamed from: k, reason: collision with root package name */
    private int f84599k;

    /* renamed from: l, reason: collision with root package name */
    private long f84600l;

    /* renamed from: m, reason: collision with root package name */
    private long f84601m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f84602n;

    /* renamed from: o, reason: collision with root package name */
    private ValueAnimator f84603o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f84604p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ab.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Iterator it = ab.this.f84589a.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    public ab(View view) {
        this.f84590b = view;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.helpers.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ab.this.i(valueAnimator);
            }
        };
        h(animatorUpdateListener);
        g(animatorUpdateListener);
    }

    private long e() {
        long j3 = this.f84600l;
        if (j3 != 0 && f84588q) {
            return j3;
        }
        return this.f84597i;
    }

    private void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.f84603o = duration;
        duration.addListener(new b());
        this.f84603o.addUpdateListener(animatorUpdateListener);
    }

    private void h(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.f84602n = duration;
        duration.addListener(new a());
        this.f84602n.addUpdateListener(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f84589a.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Pair pair) {
        SimpleEventBus.getInstance().dispatchEvent(new QFSFloatEndCaptureEvent((String) pair.first, (Bitmap) pair.second));
        View view = this.f84592d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void m(QFSVideoView qFSVideoView) {
        this.f84604p = true;
        this.f84595g = qFSVideoView.getLayoutParams().height;
        this.f84596h = qFSVideoView.getLayoutParams().width;
        this.f84597i = qFSVideoView.getHeight();
        this.f84598j = qFSVideoView.getWidth();
        this.f84599k = qFSVideoView.getTop();
        this.f84600l = 0L;
        this.f84601m = 0L;
        if (!f84588q) {
            QLog.i("QFSVideoSlideAnimHelper", 1, "not open recognize content");
            return;
        }
        FeedCloudMeta$StFeed data = this.f84591c.getData();
        if (data == null) {
            QLog.i("QFSVideoSlideAnimHelper", 1, "recordViewParams mFeedInfo == null");
            return;
        }
        if (data.yuhengContentInfos.has() && data.yuhengContentInfos.vertices.has()) {
            long j3 = data.yuhengContentInfos.vertices.height.get();
            List<Long> list = data.yuhengContentInfos.vertices.coordinate.get();
            if (j3 != 0 && list.size() == 4) {
                float f16 = (float) j3;
                this.f84600l = ((((float) (list.get(3).longValue() - list.get(1).longValue())) * 1.0f) / f16) * this.f84597i;
                this.f84601m = ((((float) list.get(1).longValue()) * 1.0f) / f16) * this.f84597i;
                return;
            } else {
                QLog.i("QFSVideoSlideAnimHelper", 1, "recordViewParams yuhengContentInfos invalid, mFeedInfo=" + data.f398449id.get());
                return;
            }
        }
        QLog.i("QFSVideoSlideAnimHelper", 1, "recordViewParams not yuhengContentInfos.vertices, mFeedInfo=" + data.f398449id.get());
    }

    private void o() {
        if (!this.f84604p) {
            QLog.e("QFSVideoSlideAnimHelper", 1, "resetLinkView mEnable = false");
            return;
        }
        this.f84604p = false;
        if (this.f84591c == null) {
            QLog.e("QFSVideoSlideAnimHelper", 1, "resetLinkView mVideoView == null");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f84596h, this.f84595g);
        layoutParams.gravity = 17;
        this.f84591c.setLayoutParams(layoutParams);
        View view = this.f84592d;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    private void r(boolean z16) {
        if (z16) {
            w();
            u();
        } else {
            v();
        }
    }

    private void u() {
        if (this.f84602n.isRunning()) {
            this.f84602n.cancel();
        }
        this.f84603o.start();
    }

    private void v() {
        if (this.f84603o.isRunning()) {
            this.f84603o.cancel();
        }
        this.f84602n.start();
    }

    private void w() {
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            QLog.e("QFSVideoSlideAnimHelper", 1, "videoView isn't exist");
            return;
        }
        QFSVideoView qFSVideoView = weakReference.get();
        this.f84591c = qFSVideoView;
        if (qFSVideoView != null && qFSVideoView.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.f84591c.getLocationInWindow(iArr);
            if (iArr[0] == 0 && iArr[1] == 0) {
                QLog.e("QFSVideoSlideAnimHelper", 1, "showVideoViewOnly but video view isn't in window");
                return;
            } else {
                m(this.f84591c);
                f(this.f84591c);
                return;
            }
        }
        QLog.e("QFSVideoSlideAnimHelper", 1, "videoView is null or is not visible");
    }

    public void d() {
        QLog.d("QFSVideoSlideAnimHelper", 1, "dismiss ani part" + hashCode());
        r(false);
        o();
        p();
    }

    public void f(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != this.f84590b) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view) {
                    if (childAt.getId() == R.id.v_z) {
                        this.f84592d = childAt;
                    } else if (childAt.getVisibility() == 0) {
                        this.f84589a.add(childAt);
                    }
                }
            }
            if (view.getParent() instanceof View) {
                f((View) view.getParent());
            }
        }
    }

    public void k(float f16) {
        float f17;
        if (!this.f84604p) {
            QLog.e("QFSVideoSlideAnimHelper", 1, "onScrollChanged mEnable = false");
            return;
        }
        QFSVideoView qFSVideoView = this.f84591c;
        if (qFSVideoView != null && qFSVideoView.getLayoutParams() != null) {
            float f18 = f16 / this.f84593e;
            float e16 = this.f84594f / ((float) e());
            if (e16 > 1.0f) {
                f17 = (float) (this.f84594f - e());
                e16 = 1.0f;
            } else {
                f17 = 0.0f;
            }
            float f19 = 1.0f - ((1.0f - e16) * f18);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f84591c.getLayoutParams();
            layoutParams.height = (int) (this.f84597i * f19);
            layoutParams.width = (int) (this.f84598j * f19);
            layoutParams.topMargin = (int) (((this.f84599k * (1.0f - f18)) + f17) - ((f18 * ((float) this.f84601m)) * e16));
            layoutParams.gravity = 49;
            this.f84591c.setLayoutParams(layoutParams);
            View view = this.f84592d;
            if (view != null) {
                view.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        QLog.e("QFSVideoSlideAnimHelper", 1, "slideView is gone, still receive onScrollChange or mTopLinkView is null");
    }

    public void l(boolean z16) {
        QFSVideoView qFSVideoView = this.f84591c;
        if (qFSVideoView != null && qFSVideoView.getVisibility() == 0) {
            if (z16) {
                QLog.d("QFSVideoSlideAnimHelper", 1, "[pauseVideo] crop video cover");
                be c16 = be.c();
                QFSVideoView qFSVideoView2 = this.f84591c;
                c16.h(qFSVideoView2, qFSVideoView2.getData(), new bi.a() { // from class: com.tencent.biz.qqcircle.helpers.aa
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        ab.this.j(pair);
                    }
                });
            }
            this.f84591c.pause();
            return;
        }
        QLog.e("QFSVideoSlideAnimHelper", 1, "videoView is null or is not visible");
    }

    public void n() {
        Iterator<View> it = this.f84589a.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    public void p() {
        this.f84591c = null;
        this.f84592d = null;
    }

    public void q(int i3) {
        this.f84593e = i3;
    }

    public void s(int i3) {
        this.f84594f = i3;
    }

    public void t() {
        QLog.d("QFSVideoSlideAnimHelper", 1, "show ani part" + hashCode());
        if (this.f84604p) {
            QLog.d("QFSVideoSlideAnimHelper", 1, "onShow return: isEnableSlide: true");
        } else {
            r(true);
        }
    }
}
