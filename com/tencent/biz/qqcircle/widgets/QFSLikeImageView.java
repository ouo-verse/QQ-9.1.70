package com.tencent.biz.qqcircle.widgets;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.photoplus.sticker.Sticker;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Arrays;
import java.util.List;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSLikeImageView extends FrameLayout implements View.OnClickListener {
    protected String C;
    protected String D;
    protected String E;
    protected String F;
    protected long G;
    protected long H;
    private Drawable I;
    private Drawable J;
    private QFSPagAnimView K;
    private LottieAnimationView L;
    private boolean M;
    private final Animator.AnimatorListener N;

    /* renamed from: d, reason: collision with root package name */
    private d f93292d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f93293e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93294f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93295h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93296i;

    /* renamed from: m, reason: collision with root package name */
    private int f93297m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends QFSPagAnimView {
        a(Context context) {
            super(context);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
        public void F() {
            super.F();
            QLog.d("PL-QFSLikeImageView", 2, "onAnimationCancel");
            QFSLikeImageView.this.f93295h = false;
            QFSLikeImageView.this.setDrawableAndPadding();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
        public void G() {
            super.G();
            QLog.d("PL-QFSLikeImageView", 1, "onPagAnimationEnd");
            QFSLikeImageView.this.f93295h = false;
            QFSLikeImageView.this.setDrawableAndPadding();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
        public void I() {
            super.I();
            QLog.d("PL-QFSLikeImageView", 1, "onPagAnimationStart");
            QFSLikeImageView.this.setPadding(0, 0, 0, 0);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
        public void K(String str) {
            super.K(str);
            if (com.tencent.biz.qqcircle.helpers.w.a().f()) {
                QLog.d("PL-QFSLikeImageView", 2, "onPagPlayError\uff1a" + str + ", reset success");
            } else {
                QLog.d("PL-QFSLikeImageView", 2, "onPagPlayError\uff1a" + str);
            }
            QFSLikeImageView.this.f93295h = false;
            QFSLikeImageView.this.setDrawableAndPadding();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(QFSLikeImageView.this.f93294f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e extends QCirclePicStateListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_URL_ILLEGAL && com.tencent.biz.qqcircle.helpers.w.a().f()) {
                QLog.e("PL-QFSLikeImageView", 1, "[onStateChange] url illegal, reset success");
            }
        }
    }

    public QFSLikeImageView(Context context) {
        this(context, null);
    }

    private void c() {
        setImportantForAccessibility(1);
        setAccessibilityDelegate(new b());
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str) && str.endsWith(Sticker.JSON_SUFFIX)) {
            return true;
        }
        return false;
    }

    private void h() {
        this.C = com.tencent.biz.qqcircle.k.e();
        this.D = com.tencent.biz.qqcircle.k.d();
        this.E = "";
        this.F = "";
        this.G = 400L;
        this.H = 400L;
    }

    private void i() {
        this.C = com.tencent.biz.qqcircle.k.m();
        this.D = com.tencent.biz.qqcircle.k.l();
        this.E = com.tencent.biz.qqcircle.k.n();
        this.F = com.tencent.biz.qqcircle.k.o();
        this.G = 400L;
        this.H = 400L;
    }

    private void k() {
        QLog.d("PL-QFSLikeImageView", 1, "[startLikeAnimation] isLiked " + this.f93294f + " | feed id: " + com.tencent.biz.qqcircle.utils.bj.g(this.f93293e));
        this.f93295h = true;
        if (d(this.C)) {
            this.L.setVisibility(0);
            this.K.setVisibility(8);
            this.L.setAnimationFromUrl(this.C);
            this.L.playAnimation();
            return;
        }
        this.L.setVisibility(8);
        this.K.setVisibility(0);
        this.K.N(this.C, 1, this.G);
    }

    private void l() {
        QLog.d("PL-QFSLikeImageView", 1, "[startUnlikeAnimation] isLiked " + this.f93294f + " | feed id: " + com.tencent.biz.qqcircle.utils.bj.g(this.f93293e));
        this.f93295h = true;
        if (d(this.D)) {
            this.L.setVisibility(0);
            this.K.setVisibility(8);
            this.L.setAnimationFromUrl(this.D);
            this.L.playAnimation();
            return;
        }
        this.L.setVisibility(8);
        this.K.setVisibility(0);
        this.K.N(this.D, 1, this.H);
    }

    private void m(Context context, @Nullable AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.O6);
            this.f93297m = (int) obtainStyledAttributes.getDimension(y91.a.P6, this.f93297m);
            obtainStyledAttributes.recycle();
        } catch (Throwable th5) {
            QLog.e("PL-QFSLikeImageView", 1, "error: ", th5);
        }
    }

    public void e(View view) {
        QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(List<QQCircleTianShu$MapEntry> list) {
        boolean z16 = false;
        if (list != null && !list.isEmpty()) {
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                if ("like_resource".equals(qQCircleTianShu$MapEntry.key.get())) {
                    this.C = qQCircleTianShu$MapEntry.value.get();
                } else if ("cancel_like_resource".equals(qQCircleTianShu$MapEntry.key.get())) {
                    this.D = qQCircleTianShu$MapEntry.value.get();
                } else if ("normal_like_icon".equals(qQCircleTianShu$MapEntry.key.get())) {
                    this.E = qQCircleTianShu$MapEntry.value.get();
                } else if ("selected_like_icon".equals(qQCircleTianShu$MapEntry.key.get())) {
                    this.F = qQCircleTianShu$MapEntry.value.get();
                } else if ("like_duration".equals(qQCircleTianShu$MapEntry.key.get())) {
                    try {
                        this.G = Long.parseLong(qQCircleTianShu$MapEntry.value.get());
                    } catch (NumberFormatException e16) {
                        QLog.e("PL-QFSLikeImageView", 1, "parse like duration error! ", e16);
                    }
                } else if ("cancel_like_duration".equals(qQCircleTianShu$MapEntry.key.get())) {
                    try {
                        this.H = Long.parseLong(qQCircleTianShu$MapEntry.value.get());
                    } catch (NumberFormatException e17) {
                        QLog.e("PL-QFSLikeImageView", 1, "parse cancel like duration error! ", e17);
                    }
                }
                z16 = true;
            }
        }
        return z16;
    }

    protected void g(List<QQCircleTianShu$MapEntry> list) {
        if (list != null && list.size() != 0) {
            f(list);
        } else if (com.tencent.biz.qqcircle.helpers.w.a().g()) {
            i();
        } else {
            h();
        }
    }

    public void j() {
        if (this.f93294f) {
            l();
        } else {
            k();
        }
    }

    public void n(boolean z16) {
        this.f93294f = z16;
        if (this.f93295h) {
            QLog.d("PL-QFSLikeImageView", 1, "[updateLikeStatus] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(this.f93293e) + " isLiked: " + this.f93294f);
            return;
        }
        setDrawableAndPadding();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.immersive.utils.az.b(com.tencent.biz.qqcircle.immersive.utils.r.L(this.f93293e, 1050), 101);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            e(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f93295h = false;
        int i3 = this.f93297m;
        setPadding(i3, i3, i3, i3);
    }

    public void setAnimationUrls(String str, String str2) {
        this.C = str;
        this.D = str2;
        if (d(str)) {
            try {
                LottieCompositionFactory.fromUrl(getContext(), this.C);
                LottieCompositionFactory.fromUrl(getContext(), this.D);
                return;
            } catch (OutOfMemoryError e16) {
                QLog.e("PL-QFSLikeImageView", 1, "setAnimationUrls out of memory" + e16);
                return;
            }
        }
        this.K.setResUrl(Arrays.asList(str, str2, this.F, this.E));
    }

    public void setData(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<QQCircleTianShu$MapEntry> list;
        QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L(feedCloudMeta$StFeed, 1050);
        if (L != null) {
            list = L.argList.get();
        } else {
            list = null;
        }
        g(list);
        setAnimationUrls(this.C, this.D);
    }

    public void setDisplayDrawables(Drawable drawable, Drawable drawable2) {
        this.I = drawable;
        this.J = drawable2;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void setDrawableAndPadding() {
        String str;
        String str2;
        Drawable drawable;
        int i3 = this.f93297m;
        setPadding(i3, i3, i3, i3);
        boolean z16 = this.f93294f;
        if (z16) {
            str = this.F;
        } else {
            str = this.E;
        }
        if (this.M != z16) {
            QLog.d("PL-QFSLikeImageView", 1, "[updateFeedLike] feed id: " + com.tencent.biz.qqcircle.utils.bj.g(this.f93293e) + " isLiked: " + this.f93294f + " url: " + str + " mSelectedLikeUrl: " + this.F + " mNormalLikeUrl: " + this.E);
            this.M = this.f93294f;
        }
        if (TextUtils.isEmpty(str)) {
            this.L.setVisibility(0);
            this.K.setVisibility(8);
            LottieAnimationView lottieAnimationView = this.L;
            if (this.f93294f) {
                drawable = this.I;
            } else {
                drawable = this.J;
            }
            lottieAnimationView.setImageDrawable(drawable);
            return;
        }
        this.L.setVisibility(8);
        this.K.setVisibility(0);
        QFSPagAnimView qFSPagAnimView = this.K;
        if (this.f93294f) {
            str2 = this.F;
        } else {
            str2 = this.E;
        }
        qFSPagAnimView.S(str2, new e());
    }

    public void setDrawablePadding(int i3) {
        this.f93297m = i3;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f93293e = feedCloudMeta$StFeed;
    }

    public void setItemPreClickListener(d dVar) {
        this.f93292d = dVar;
    }

    public void setNeedInterceptClick(boolean z16) {
        this.f93296i = z16;
    }

    public QFSLikeImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLikeImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93297m = ViewUtils.dpToPx(9.0f);
        this.C = com.tencent.biz.qqcircle.k.e();
        this.D = com.tencent.biz.qqcircle.k.d();
        this.G = 400L;
        this.H = 400L;
        this.I = getResources().getDrawable(com.tencent.biz.qqcircle.k.f());
        this.J = getResources().getDrawable(com.tencent.biz.qqcircle.k.g());
        c cVar = new c();
        this.N = cVar;
        this.K = new a(context);
        addView(this.K, new FrameLayout.LayoutParams(-1, -1));
        this.K.setRepeatTimes(1);
        this.L = new LottieAnimationView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.L.addAnimatorListener(cVar);
        addView(this.L, layoutParams);
        this.K.setRepeatTimes(1);
        setOnClickListener(this);
        c();
        m(context, attributeSet);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("PL-QFSLikeImageView", 1, "lottie onAnimationCancel");
            QFSLikeImageView.this.f93295h = false;
            QFSLikeImageView.this.setDrawableAndPadding();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSLikeImageView.this.f93295h = false;
            QLog.d("PL-QFSLikeImageView", 1, "lottie onAnimationEnd");
            QFSLikeImageView.this.setDrawableAndPadding();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSLikeImageView.this.setPadding(0, 0, 0, 0);
            QLog.d("PL-QFSLikeImageView", 1, "lottie onAnimationStart");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
