package com.tencent.mobileqq.aio.animation.business;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u001a\u0003B\u0017\u0012\u0006\u0010>\u001a\u00020+\u0012\u0006\u0010?\u001a\u00020.\u00a2\u0006\u0004\b@\u0010AJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00102R\u0014\u00105\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00102R\u0018\u00107\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/c;", "", "Landroid/view/View;", "b", "Landroid/graphics/drawable/Drawable;", "drawable", "e", "", "d", "f", "", "progress", "p", "Landroid/graphics/Point;", "point", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "listener", "j", "Lcom/tencent/mobileqq/aio/animation/business/c$b;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "k", "i", DomainData.DOMAIN_NAME, "o", "", "a", "J", "c", "()J", "l", "(J)V", PreloadTRTCPlayerParams.KEY_SIG, "", "<set-?>", "Z", tl.h.F, "()Z", "isAnimating", "Landroid/view/View;", "mEggsView", "Landroid/graphics/drawable/Drawable;", "mEggsDrawable", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "mContainer", "Lcom/tencent/mobileqq/aio/animation/data/a;", "Lcom/tencent/mobileqq/aio/animation/data/a;", "mListView", "g", "Landroid/graphics/Point;", "mStartPoint", "mCurPosition", "mScreenBoundary", "Lcom/tencent/mobileqq/aio/animation/business/c$b;", "mPathStrategy", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mAnimator", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mUpdateListener", ParseCommon.CONTAINER, "listview", "<init>", "(Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long sig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimating;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mEggsView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mEggsDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOAnimationContainer mContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.animation.data.a mListView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Point mStartPoint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Point mCurPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Point mScreenBoundary;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mPathStrategy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mAnimator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.business.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/c$b;", "", "Landroid/graphics/Point;", "screenBoundaryPoint", "c", "Landroid/animation/ValueAnimator;", "animator", "", "a", "startPoint", "", "progress", "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void a(@NotNull ValueAnimator animator);

        @NotNull
        Point b(@NotNull Point startPoint, @NotNull Point screenBoundaryPoint, float progress);

        @NotNull
        Point c(@NotNull Point screenBoundaryPoint);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container, (Object) listview);
            return;
        }
        this.mContainer = container;
        this.mListView = listview;
        ViewUtils viewUtils = ViewUtils.f352270a;
        this.mScreenBoundary = new Point(viewUtils.e(), viewUtils.d());
    }

    private final View b() {
        if (this.mEggsView == null) {
            Drawable drawable = this.mEggsDrawable;
            if (drawable == null) {
                QLog.e("BusinessEggsElement", 1, "[createEggsView] drawable is null, cannot create view");
                return null;
            }
            Intrinsics.checkNotNull(drawable);
            this.mEggsView = e(drawable);
        }
        View view = this.mEggsView;
        Intrinsics.checkNotNull(view);
        view.setClickable(false);
        return this.mEggsView;
    }

    private final void d() {
        if (this.mAnimator == null) {
            this.mAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            f();
            ValueAnimator valueAnimator = this.mAnimator;
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.addUpdateListener(this.mUpdateListener);
        }
    }

    private final View e(Drawable drawable) {
        View view = new View(this.mListView.getContext());
        view.setBackgroundDrawable(drawable);
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        if (bounds.isEmpty()) {
            view.layout(0, 0, drawable.getIntrinsicWidth() / 2, drawable.getIntrinsicHeight() / 2);
        } else {
            view.layout(0, 0, bounds.width() / 2, bounds.height() / 2);
        }
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setLayerType(2, null);
        return view;
    }

    private final void f() {
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.animation.business.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.g(c.this, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(c this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.p(((Float) animatedValue).floatValue());
    }

    private final void m(Point point) {
        View view = this.mEggsView;
        if (view != null && point != null) {
            Intrinsics.checkNotNull(view);
            int left = view.getLeft();
            View view2 = this.mEggsView;
            Intrinsics.checkNotNull(view2);
            int width = left + (view2.getWidth() / 2);
            View view3 = this.mEggsView;
            Intrinsics.checkNotNull(view3);
            int bottom = view3.getBottom();
            View view4 = this.mEggsView;
            Intrinsics.checkNotNull(view4);
            view4.offsetTopAndBottom(point.y - bottom);
            View view5 = this.mEggsView;
            Intrinsics.checkNotNull(view5);
            view5.offsetLeftAndRight(point.x - width);
        }
    }

    private final void p(float progress) {
        b bVar = this.mPathStrategy;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            Point point = this.mStartPoint;
            Intrinsics.checkNotNull(point);
            Point b16 = bVar.b(point, this.mScreenBoundary, progress);
            this.mCurPosition = b16;
            m(b16);
        }
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.sig;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isAnimating;
    }

    public final void i(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
            return;
        }
        this.mEggsDrawable = drawable;
        d();
        this.mEggsView = b();
    }

    public final void j(@Nullable View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        View view = this.mEggsView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setOnClickListener(listener);
        }
    }

    public final void k(@Nullable b strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) strategy);
        } else {
            this.mPathStrategy = strategy;
        }
    }

    public final void l(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.sig = j3;
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.isAnimating) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessEggsElement", 2, "[start] eggs animating, return");
                return;
            }
            return;
        }
        if (this.mPathStrategy == null && !(!com.tencent.qqnt.util.b.f362976b.isDebugVersion())) {
            throw new IllegalStateException("IPathStrategy has not been initialized".toString());
        }
        View view = this.mEggsView;
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessEggsElement", 2, "[start] mEggsView is null");
                return;
            }
            return;
        }
        AIOAnimationContainer aIOAnimationContainer = this.mContainer;
        Intrinsics.checkNotNull(view);
        aIOAnimationContainer.addView(view, -1, AIOAnimationContainer.INSTANCE.a());
        b bVar = this.mPathStrategy;
        Intrinsics.checkNotNull(bVar);
        ValueAnimator valueAnimator = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        bVar.a(valueAnimator);
        b bVar2 = this.mPathStrategy;
        Intrinsics.checkNotNull(bVar2);
        this.mStartPoint = bVar2.c(this.mScreenBoundary);
        ValueAnimator valueAnimator2 = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.start();
        this.isAnimating = true;
        if (QLog.isColorLevel()) {
            QLog.d("BusinessEggsElement", 2, "[start] start eggs: " + this.sig);
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.isAnimating = false;
        this.mContainer.removeViewInLayout(this.mEggsView);
        ValueAnimator valueAnimator = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.removeAllListeners();
        ValueAnimator valueAnimator2 = this.mAnimator;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.removeAllUpdateListeners();
        this.mEggsView = null;
        this.mEggsDrawable = null;
        if (QLog.isColorLevel()) {
            QLog.d("BusinessEggsElement", 2, "[stop] stop eggs: " + this.sig);
        }
    }
}
