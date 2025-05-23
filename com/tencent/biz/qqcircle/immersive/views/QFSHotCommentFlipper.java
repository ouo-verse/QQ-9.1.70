package com.tencent.biz.qqcircle.immersive.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StComment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSHotCommentFlipper extends FrameLayout implements View.OnClickListener, SimpleEventReceiver {
    private static final Interpolator G = PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f);
    private int C;
    private b D;
    private QFSHotCommentFlipperTask E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAsyncTextView f90347d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90348e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90349f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f90350h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90351i;

    /* renamed from: m, reason: collision with root package name */
    private final List<FeedCloudMeta$StComment> f90352m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static final class QFSHotCommentFlipperTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QFSHotCommentFlipper> f90353d;

        public QFSHotCommentFlipperTask(QFSHotCommentFlipper qFSHotCommentFlipper) {
            this.f90353d = new WeakReference<>(qFSHotCommentFlipper);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSHotCommentFlipper qFSHotCommentFlipper;
            WeakReference<QFSHotCommentFlipper> weakReference = this.f90353d;
            if (weakReference == null) {
                qFSHotCommentFlipper = null;
            } else {
                qFSHotCommentFlipper = weakReference.get();
            }
            if (qFSHotCommentFlipper != null) {
                qFSHotCommentFlipper.l();
            } else {
                QLog.e("QFSHotCommentFlipper", 1, "[run] flipper should not be null.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        boolean f90354d = false;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f90355e;

        a(AnimatorSet animatorSet) {
            this.f90355e = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f90354d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f90355e.removeListener(this);
            if (!this.f90354d) {
                QFSHotCommentFlipper.this.d();
                this.f90355e.start();
                QFSHotCommentFlipper.this.f90347d.setTag(this.f90355e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, FeedCloudMeta$StComment feedCloudMeta$StComment);

        void b(View view, FeedCloudMeta$StComment feedCloudMeta$StComment);

        void c(View view, FeedCloudMeta$StComment feedCloudMeta$StComment);
    }

    public QFSHotCommentFlipper(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        FeedCloudMeta$StComment f16 = f();
        if (f16 == null) {
            QLog.e("QFSHotCommentFlipper", 1, "[bindData] comment should not be null.");
        } else if (i(f16)) {
            q(f16);
        } else {
            r(f16);
        }
    }

    private void e(View view) {
        b bVar = this.D;
        if (bVar != null) {
            bVar.c(view, f());
        }
        t();
    }

    private void h(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        FeedCloudMeta$StComment f16 = f();
        if (f16 != null && QFSCommentHelper.L().y()) {
            if (qCircleCommentPraiseUpdateEvent.mType == 1 && TextUtils.equals(qCircleCommentPraiseUpdateEvent.mCommentId, f16.f398447id.get())) {
                f16.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                f16.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                s(f16);
                return;
            }
            return;
        }
        QLog.e("QFSHotCommentFlipper", 1, "[handlePraiseUpdateEvent] currentHotComment = null or not exp");
    }

    private boolean i(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null || feedCloudMeta$StComment.sourceType.get() != 4) {
            return false;
        }
        return true;
    }

    private boolean k() {
        int size = this.f90352m.size();
        if (size <= 1) {
            return false;
        }
        int i3 = this.C + 1;
        this.C = i3;
        this.C = i3 % size;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f90347d, "translationY", 0.0f, -cx.a(36.0f));
        ofFloat.setDuration(500L);
        Interpolator interpolator = G;
        ofFloat.setInterpolator(interpolator);
        animatorSet.playTogether(ofFloat);
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f90347d, "translationY", cx.a(36.0f), 0.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(interpolator);
        animatorSet2.playTogether(ofFloat2);
        animatorSet.start();
        this.f90347d.setTag(animatorSet);
        animatorSet.addListener(new a(animatorSet2));
        if (this.C == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.E == null) {
            QLog.d("QFSHotCommentFlipper", 1, "[nextCommentExecute] comment flipper task should not be null.");
        } else if (k()) {
            RFWThreadManager.getUIHandler().postDelayed(this.E, 7000L);
        } else {
            QLog.d("QFSHotCommentFlipper", 1, "[nextCommentExecute] play hot list round, end next hot flow.");
        }
    }

    private void n() {
        this.f90347d.setTranslationY(0.0f);
    }

    private void q(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return;
        }
        QLog.d("QFSHotCommentFlipper", 1, "[updateHotCommentGuideUI] comment: " + feedCloudMeta$StComment.content.get());
        u(this.f90348e, 8);
        this.f90347d.setText(feedCloudMeta$StComment.content.get());
    }

    private void r(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        u(this.f90348e, 0);
        this.f90347d.setText(feedCloudMeta$StComment.content.get());
        if (QFSCommentHelper.L().y() && this.f90349f != null) {
            if (!TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get())) {
                this.f90349f.setVisibility(0);
            } else if (!TextUtils.isEmpty(feedCloudMeta$StComment.expressionInfo.expressionURL.get())) {
                this.f90349f.setText(R.string.f182983hy);
                this.f90349f.setVisibility(0);
            } else {
                this.f90349f.setVisibility(8);
            }
            s(feedCloudMeta$StComment);
        }
    }

    private void s(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        boolean z16;
        Drawable drawable;
        if (feedCloudMeta$StComment.likeInfo.status.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            drawable = getContext().getDrawable(R.drawable.qui_like_secondary);
        } else {
            drawable = getContext().getDrawable(R.drawable.os6);
        }
        if (z16) {
            drawable.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_allwhite_tertiary), PorterDuff.Mode.SRC_IN));
        }
        this.f90350h.setImageDrawable(drawable);
        this.f90351i.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(feedCloudMeta$StComment.likeInfo.count.get()));
    }

    private void t() {
        int size;
        List<FeedCloudMeta$StComment> list = this.f90352m;
        if (list == null || (size = list.size()) <= 1) {
            return;
        }
        int i3 = this.C + 1;
        this.C = i3;
        this.C = i3 % size;
        d();
        p();
    }

    private void u(View view, int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    public FeedCloudMeta$StComment f() {
        if (this.C < this.f90352m.size()) {
            return this.f90352m.get(this.C);
        }
        return null;
    }

    public int g() {
        if (i(f())) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        return arrayList;
    }

    public boolean j() {
        return this.F;
    }

    public void m() {
        this.C = 0;
        d();
    }

    public void o() {
        this.F = true;
        if (this.E != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.E);
        }
        this.E = new QFSHotCommentFlipperTask(this);
        RFWThreadManager.getUIHandler().postDelayed(this.E, 6000L);
        QLog.d("QFSHotCommentFlipper", 1, "[start] hot comment flipper start, hashCode: " + hashCode());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedCloudMeta$StComment f16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.D != null && (f16 = f()) != null) {
            if (view.getId() != R.id.xb7 && view.getId() != R.id.f108716dv) {
                if (view.getId() == R.id.f165944dw3 || view.getId() == R.id.f109666gf) {
                    p();
                    this.D.a(view, f16);
                }
            } else if (i(f16)) {
                e(view);
            } else {
                p();
                this.D.b(view, f16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
        this.f90348e = (ImageView) findViewById(R.id.f31040pz);
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) findViewById(R.id.f108716dv);
        this.f90347d = qCircleAsyncTextView;
        qCircleAsyncTextView.setSpecialClickAreaColor(R.color.f158017al3);
        this.f90347d.setNeedSpecialAreaBold(true);
        this.f90347d.setOnClickListener(this);
        if (QFSCommentHelper.L().y()) {
            this.f90348e.setImageResource(R.drawable.f162044oo4);
            this.f90348e.getLayoutParams().width = cx.a(30.0f);
            this.f90349f = (TextView) findViewById(R.id.f111796m7);
            this.f90350h = (ImageView) findViewById(R.id.f165944dw3);
            this.f90351i = (TextView) findViewById(R.id.f109666gf);
            this.f90350h.setVisibility(0);
            this.f90351i.setVisibility(0);
            this.f90350h.setOnClickListener(this);
            this.f90351i.setOnClickListener(this);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            h((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        }
    }

    public void p() {
        this.F = false;
        if (this.E != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.E);
        }
        Object tag = this.f90347d.getTag();
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
            this.f90347d.setTag(null);
        }
        n();
        QLog.d("QFSHotCommentFlipper", 1, "[stop] hot comment flipper stop, hashCode: " + hashCode());
    }

    public void setHotCommentList(List<FeedCloudMeta$StComment> list) {
        if (list != null && !list.isEmpty()) {
            this.f90352m.clear();
            this.f90352m.addAll(list);
            m();
        }
    }

    public void setOnClickListener(b bVar) {
        this.D = bVar;
    }

    public QFSHotCommentFlipper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSHotCommentFlipper(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90352m = new ArrayList();
        this.C = 0;
        this.F = false;
    }
}
