package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* loaded from: classes6.dex */
public final class GdtDanmakuPresenter extends RelativeLayout {

    @NonNull
    private String C;

    @NonNull
    private String D;
    private int E;
    private int F;
    private int G;
    private Context H;

    @NonNull
    private com.tencent.gdtad.views.canvas.components.danmaku.a I;
    private DanmakuRunnable[] J;
    private boolean K;
    private Pools.SimplePool<GdtDanmakuItemView> L;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f109604d;

    /* renamed from: e, reason: collision with root package name */
    private int f109605e;

    /* renamed from: f, reason: collision with root package name */
    private int f109606f;

    /* renamed from: h, reason: collision with root package name */
    private int f109607h;

    /* renamed from: i, reason: collision with root package name */
    private float f109608i;

    /* renamed from: m, reason: collision with root package name */
    private int f109609m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class DanmakuRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f109610d;

        public DanmakuRunnable(int i3) {
            this.f109610d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            AdLog.i("GdtDanmakuPresenter", "create new danmaku item in row " + this.f109610d);
            GdtDanmakuItemView h16 = GdtDanmakuPresenter.this.h();
            DanmakuRunnable[] danmakuRunnableArr = GdtDanmakuPresenter.this.J;
            if (h16 != null && danmakuRunnableArr != null && (i3 = this.f109610d) <= danmakuRunnableArr.length && i3 >= 0) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                h16.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = h16.getMeasuredWidth();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h16.getLayoutParams();
                layoutParams.topMargin = this.f109610d * (h16.getMeasuredHeight() + AdUIUtils.dp2px(GdtDanmakuPresenter.this.f109606f, GdtDanmakuPresenter.this.getResources()));
                h16.setLayoutParams(layoutParams);
                GdtDanmakuPresenter.this.addView(h16);
                h16.c();
                GdtDanmakuPresenter.this.f109604d.postDelayed(danmakuRunnableArr[this.f109610d], (int) ((GdtDanmakuPresenter.this.f109607h + AdUIUtils.px2dp(GdtDanmakuPresenter.this.getContext(), measuredWidth)) / GdtDanmakuPresenter.this.f109608i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GdtDanmakuItemView f109611d;

        a(GdtDanmakuItemView gdtDanmakuItemView) {
            this.f109611d = gdtDanmakuItemView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GdtDanmakuPresenter.this.i(this.f109611d);
            GdtDanmakuPresenter.this.removeView(this.f109611d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public GdtDanmakuPresenter(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public GdtDanmakuItemView h() {
        GdtDanmakuItemView gdtDanmakuItemView;
        Pools.SimplePool<GdtDanmakuItemView> simplePool = this.L;
        if (simplePool != null) {
            gdtDanmakuItemView = simplePool.acquire();
        } else {
            gdtDanmakuItemView = null;
        }
        if (gdtDanmakuItemView == null) {
            gdtDanmakuItemView = new GdtDanmakuItemView(this.H);
        }
        gdtDanmakuItemView.setTextSize(this.f109609m);
        gdtDanmakuItemView.setClickable(false);
        GradientDrawable gradientDrawable = (GradientDrawable) gdtDanmakuItemView.getBackground();
        gradientDrawable.setColor(Color.parseColor(this.D));
        gdtDanmakuItemView.setBackground(gradientDrawable);
        gdtDanmakuItemView.setTextColor(Color.parseColor(this.C));
        String a16 = this.I.a();
        if (TextUtils.isEmpty(a16)) {
            return gdtDanmakuItemView;
        }
        if (a16.length() > this.E) {
            a16 = a16.substring(0, this.E) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        gdtDanmakuItemView.setText(a16);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        gdtDanmakuItemView.measure(makeMeasureSpec, makeMeasureSpec);
        int dp2px = AdUIUtils.dp2px(this.G, getResources()) + gdtDanmakuItemView.getMeasuredWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gdtDanmakuItemView, "translationX", AdUIUtils.dp2px(this.G, getResources()), -r2);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new a(gdtDanmakuItemView));
        ofFloat.setDuration((int) (AdUIUtils.px2dp(getContext(), dp2px) / this.f109608i));
        gdtDanmakuItemView.b(ofFloat);
        return gdtDanmakuItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GdtDanmakuItemView gdtDanmakuItemView) {
        try {
            this.L.release(gdtDanmakuItemView);
        } catch (IllegalStateException unused) {
        }
    }

    private void l() {
        DanmakuRunnable[] danmakuRunnableArr = this.J;
        if (danmakuRunnableArr != null) {
            for (DanmakuRunnable danmakuRunnable : danmakuRunnableArr) {
                this.f109604d.removeCallbacks(danmakuRunnable);
            }
        }
        removeAllViews();
        clearDisappearingChildren();
    }

    @NonNull
    public GdtDanmakuPresenter j(int i3, String[] strArr) {
        this.I.d(strArr);
        this.G = AdUIUtils.px2dp(getContext(), i3);
        return this;
    }

    public boolean k() {
        return this.K;
    }

    public boolean m() {
        l();
        this.K = false;
        if (this.I.b() || this.G == -1) {
            return false;
        }
        if (this.L == null) {
            this.L = new Pools.SimplePool<>(this.F);
        }
        DanmakuRunnable[] danmakuRunnableArr = this.J;
        if (danmakuRunnableArr != null) {
            for (DanmakuRunnable danmakuRunnable : danmakuRunnableArr) {
                this.f109604d.removeCallbacks(danmakuRunnable);
            }
        }
        this.J = new DanmakuRunnable[this.f109605e];
        for (int i3 = 0; i3 < this.f109605e; i3++) {
            this.J[i3] = new DanmakuRunnable(i3);
            this.f109604d.postDelayed(this.J[i3], i3 * 600);
        }
        this.K = true;
        AdLog.i("GdtDanmakuPresenter", "danmaku start");
        return true;
    }

    public void n() {
        l();
        this.K = false;
        this.I.c();
        AdLog.i("GdtDanmakuPresenter", "danmaku is stopped");
    }

    public GdtDanmakuPresenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f109604d = new Handler(Looper.getMainLooper());
        this.f109605e = 2;
        this.f109606f = 10;
        this.f109607h = 20;
        this.f109608i = 0.1f;
        this.f109609m = 14;
        this.C = "#FFFFFFFF";
        this.D = "#993C3C3C";
        this.E = 10;
        this.F = 10;
        this.G = -1;
        this.I = new com.tencent.gdtad.views.canvas.components.danmaku.a();
        this.H = context;
    }
}
