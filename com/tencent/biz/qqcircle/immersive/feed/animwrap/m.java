package com.tencent.biz.qqcircle.immersive.feed.animwrap;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.feed.ad.s;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.ak;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \b2\u00020\u0001:\u0001\u0019B%\u0012\b\u0010P\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010Q\u001a\u0004\u0018\u00010\n\u0012\b\u0010R\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010\u001aR$\u0010;\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`88\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0014\u0010C\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010GR\u0018\u0010J\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010IR\u0018\u0010K\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010IR\u0018\u0010L\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010IR\u0018\u0010O\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006U"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/m;", "", "", "H", "I", "G", "v", "r", "t", "E", "Landroid/view/View;", "view", "Lkotlin/Pair;", "", "o", "fraction", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "D", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/s$b;", "callback", UserInfo.SEX_FEMALE, "a", "Landroid/view/View;", "mAdBoxLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "b", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mAdTipLayout", "Lcom/tencent/gdtad/aditem/GdtAd;", "c", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Landroid/widget/ProgressBar;", "d", "Landroid/widget/ProgressBar;", "mProgressBar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mTipImage", "f", "mBoxImage", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "mBoxDesc", tl.h.F, "mBoxDescBottom", "i", "mBoxProgressBg", "Ljava/util/HashSet;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/HashSet;", "j", "Ljava/util/HashSet;", "mAnimators", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "mCurrentAnimatorRunnable", "l", "mBoxShowRunnable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mHideBoxRunnable", DomainData.DOMAIN_NAME, "mMotiveProgressRunnable", "", "Z", "mIsAttach", "Landroid/animation/ValueAnimator;", "mShowBoxAnimator", "mHideBoxAnimator", "mProgressBarAnimator", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/qqcircle/immersive/feed/ad/s$b;", "mSendEventCallback", "adTipLayout", "adBoxLayout", "ad", "<init>", "(Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/view/View;Lcom/tencent/gdtad/aditem/GdtAd;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class m {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final a f85930t = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View mAdBoxLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ConstraintLayout mAdTipLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GdtAd mAd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ProgressBar mProgressBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView mTipImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ImageView mBoxImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView mBoxDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView mBoxDescBottom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View mBoxProgressBg;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<ValueAnimator> mAnimators;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable mCurrentAnimatorRunnable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mBoxShowRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mHideBoxRunnable;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mMotiveProgressRunnable;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAttach;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mShowBoxAnimator;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mHideBoxAnimator;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mProgressBarAnimator;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s.b mSendEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/m$a;", "", "", "BIG_BOX_SIZE", UserInfo.SEX_FEMALE, "", "BOX_ANIMATION_DELAY", "J", "", "BOX_LAYOUT_SHOW_PROGRESS", "D", "BOX_MOVE_DURATION", "DEFAULT_ANIMATION_INTERNAL", "PROGRESS_DURATION", "", "TAG", "Ljava/lang/String;", "TIP_LAYOUT_HIDE_PROGRESS", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/m$b", "Lcom/tencent/mobileqq/widget/ak;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends ak {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            m.this.mCurrentAnimatorRunnable = null;
            ConstraintLayout constraintLayout = m.this.mAdTipLayout;
            if (constraintLayout != null) {
                constraintLayout.setAlpha(1.0f);
            }
            ImageView imageView = m.this.mTipImage;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            m.this.mBoxImage.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            s.b bVar = m.this.mSendEventCallback;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/m$c", "Lcom/tencent/mobileqq/widget/ak;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends ak {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            m.this.mCurrentAnimatorRunnable = null;
            m.this.G();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ProgressBar progressBar = m.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/animwrap/m$d", "Lcom/tencent/mobileqq/widget/ak;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends ak {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            m.this.mCurrentAnimatorRunnable = null;
            m.this.H();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ImageView imageView = m.this.mTipImage;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }
    }

    public m(@Nullable ConstraintLayout constraintLayout, @Nullable View view, @Nullable GdtAd gdtAd) {
        ProgressBar progressBar;
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        TextView textView2;
        this.mAdBoxLayout = view;
        this.mAdTipLayout = constraintLayout;
        this.mAd = gdtAd;
        if (view != null) {
            progressBar = (ProgressBar) view.findViewById(R.id.f33340w7);
        } else {
            progressBar = null;
        }
        this.mProgressBar = progressBar;
        if (constraintLayout != null) {
            imageView = (ImageView) constraintLayout.findViewById(R.id.f38961ad);
        } else {
            imageView = null;
        }
        this.mTipImage = imageView;
        if (view != null) {
            imageView2 = (ImageView) view.findViewById(R.id.f378518d);
        } else {
            imageView2 = null;
        }
        this.mBoxImage = imageView2;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.f378318b);
        } else {
            textView = null;
        }
        this.mBoxDesc = textView;
        if (view != null) {
            textView2 = (TextView) view.findViewById(R.id.f378418c);
        } else {
            textView2 = null;
        }
        this.mBoxDescBottom = textView2;
        this.mBoxProgressBg = view != null ? view.findViewById(R.id.f378218a) : null;
        this.mAnimators = new HashSet<>();
        this.mBoxShowRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.g
            @Override // java.lang.Runnable
            public final void run() {
                m.x(m.this);
            }
        };
        this.mHideBoxRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.h
            @Override // java.lang.Runnable
            public final void run() {
                m.y(m.this);
            }
        };
        this.mMotiveProgressRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.i
            @Override // java.lang.Runnable
            public final void run() {
                m.z(m.this);
            }
        };
    }

    private final void E() {
        ConstraintLayout constraintLayout = this.mAdTipLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.mAdTipLayout;
        if (constraintLayout2 != null) {
            constraintLayout2.setAlpha(1.0f);
        }
        ImageView imageView = this.mTipImage;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        View view = this.mAdBoxLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        ProgressBar progressBar2 = this.mProgressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        TextView textView = this.mBoxDesc;
        if (textView != null) {
            textView.setVisibility(8);
            textView.setAlpha(0.0f);
        }
        TextView textView2 = this.mBoxDescBottom;
        if (textView2 != null) {
            textView2.setVisibility(8);
            textView2.setAlpha(0.0f);
        }
        View view2 = this.mBoxProgressBg;
        if (view2 != null) {
            view2.setVisibility(4);
            view2.setAlpha(0.0f);
        }
        ImageView imageView2 = this.mBoxImage;
        if (imageView2 != null) {
            imageView2.setScaleX(1.0f);
        }
        ImageView imageView3 = this.mBoxImage;
        if (imageView3 != null) {
            imageView3.setScaleY(1.0f);
        }
        ImageView imageView4 = this.mBoxImage;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        if (!this.mIsAttach) {
            return;
        }
        Runnable runnable = this.mHideBoxRunnable;
        this.mCurrentAnimatorRunnable = runnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
            RFWThreadManager.getUIHandler().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        if (!this.mIsAttach) {
            return;
        }
        Runnable runnable = this.mMotiveProgressRunnable;
        this.mCurrentAnimatorRunnable = runnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
            RFWThreadManager.getUIHandler().post(runnable);
        }
    }

    private final void I() {
        long j3;
        if (!this.mIsAttach) {
            return;
        }
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null && gdtAd.getMotivePupInfo() != null && gdtAd.getMotivePupInfo().appear_time.get() > 0) {
            j3 = gdtAd.getMotivePupInfo().appear_time.get();
        } else {
            j3 = 0;
        }
        Runnable runnable = this.mBoxShowRunnable;
        this.mCurrentAnimatorRunnable = runnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
            Handler uIHandler = RFWThreadManager.getUIHandler();
            if (j3 == 0) {
                j3 = 3000;
            }
            uIHandler.postDelayed(runnable, j3);
        }
    }

    private final Pair<Float, Float> o(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return new Pair<>(Float.valueOf(iArr[0]), Float.valueOf(iArr[1]));
    }

    private final void p(View view, float fraction) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (fraction > 0.15d) {
            view.setVisibility(4);
        } else {
            view.setAlpha(1 - fraction);
        }
    }

    private final void q(View view, float fraction) {
        if (view != null) {
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
            view.setAlpha((float) (fraction + 0.15d));
        }
    }

    private final void r() {
        View view;
        if (this.mBoxImage != null && (view = this.mAdBoxLayout) != null && this.mBoxProgressBg != null) {
            Pair<Float, Float> o16 = o(view);
            Pair<Float, Float> o17 = o(this.mTipImage);
            Pair pair = new Pair(Float.valueOf((this.mBoxProgressBg.getX() + (this.mBoxProgressBg.getWidth() / 2)) - cx.a(16.0f)), Float.valueOf((this.mBoxProgressBg.getY() + (this.mBoxProgressBg.getHeight() / 2)) - cx.a(48.0f)));
            Pair pair2 = new Pair(Float.valueOf(o17.getFirst().floatValue() - o16.getFirst().floatValue()), Float.valueOf(o17.getSecond().floatValue() - o16.getSecond().floatValue()));
            Path path = new Path();
            path.moveTo(((Number) pair.getFirst()).floatValue(), ((Number) pair.getSecond()).floatValue());
            path.quadTo(((Number) pair.getFirst()).floatValue() * 0.2f, (float) (((Number) pair.getSecond()).doubleValue() - ((((Number) pair.getSecond()).floatValue() - ((Number) pair2.getSecond()).floatValue()) * 0.2d)), ((Number) pair2.getFirst()).floatValue(), ((Number) pair2.getSecond()).floatValue());
            final PathMeasure pathMeasure = new PathMeasure();
            pathMeasure.setPath(path, false);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1000L);
            final float[] fArr = new float[2];
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    m.s(pathMeasure, fArr, this, valueAnimator);
                }
            });
            ofFloat.addListener(new b());
            this.mHideBoxAnimator = ofFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(PathMeasure pathMeasure, float[] currentPos, m this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(pathMeasure, "$pathMeasure");
        Intrinsics.checkNotNullParameter(currentPos, "$currentPos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        pathMeasure.getPosTan(((Float) animatedValue).floatValue(), currentPos, null);
        this$0.mBoxImage.setX(currentPos[0]);
        this$0.mBoxImage.setY(currentPos[1]);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        if (animatedFraction > 0.025d) {
            if (this$0.mBoxImage.getVisibility() == 8) {
                this$0.mBoxImage.setVisibility(0);
            }
            float animatedFraction2 = 3.2f - (valueAnimator.getAnimatedFraction() * 2.0f);
            this$0.mBoxImage.setScaleX(animatedFraction2);
            this$0.mBoxImage.setScaleY(animatedFraction2);
        }
        this$0.p(this$0.mBoxProgressBg, animatedFraction);
        this$0.p(this$0.mProgressBar, animatedFraction);
        this$0.p(this$0.mBoxDesc, animatedFraction);
        this$0.p(this$0.mBoxDescBottom, animatedFraction);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void t() {
        long j3;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        GdtAd gdtAd = this.mAd;
        long j16 = 1000;
        if (gdtAd != null && gdtAd.getMotivePupInfo() != null) {
            long j17 = gdtAd.getMotivePupInfo().disappear_time.get() - gdtAd.getMotivePupInfo().appear_time.get();
            if (j17 > 2000) {
                j3 = j17 - 1000;
                if (j3 > 0) {
                    j16 = j3;
                }
                ofInt.setDuration(j16);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.l
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        m.u(m.this, valueAnimator);
                    }
                });
                ofInt.addListener(new c());
                this.mProgressBarAnimator = ofInt;
            }
        }
        j3 = 0;
        if (j3 > 0) {
        }
        ofInt.setDuration(j16);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                m.u(m.this, valueAnimator);
            }
        });
        ofInt.addListener(new c());
        this.mProgressBarAnimator = ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(m this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ProgressBar progressBar = this$0.mProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(intValue);
        }
    }

    private final void v() {
        View view;
        if (this.mBoxImage != null && (view = this.mAdBoxLayout) != null && this.mBoxProgressBg != null) {
            Pair<Float, Float> o16 = o(view);
            Pair<Float, Float> o17 = o(this.mTipImage);
            this.mBoxImage.setX(o17.getFirst().floatValue() - o16.getFirst().floatValue());
            this.mBoxImage.setY(o17.getSecond().floatValue() - o16.getSecond().floatValue());
            Pair pair = new Pair(Float.valueOf((this.mBoxProgressBg.getX() + (this.mBoxProgressBg.getWidth() / 2)) - cx.a(16.0f)), Float.valueOf((this.mBoxProgressBg.getY() + (this.mBoxProgressBg.getHeight() / 2)) - cx.a(48.0f)));
            Path path = new Path();
            path.moveTo(this.mBoxImage.getX(), this.mBoxImage.getY());
            path.quadTo(((Number) pair.getFirst()).floatValue() * 0.2f, (float) (((Number) pair.getSecond()).doubleValue() - ((((Number) pair.getSecond()).floatValue() - this.mBoxImage.getY()) * 0.2d)), ((Number) pair.getFirst()).floatValue(), ((Number) pair.getSecond()).floatValue());
            final PathMeasure pathMeasure = new PathMeasure();
            pathMeasure.setPath(path, false);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1000L);
            final float[] fArr = new float[2];
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.animwrap.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    m.w(pathMeasure, fArr, this, valueAnimator);
                }
            });
            ofFloat.addListener(new d());
            this.mShowBoxAnimator = ofFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PathMeasure pathMeasure, float[] currentPos, m this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(pathMeasure, "$pathMeasure");
        Intrinsics.checkNotNullParameter(currentPos, "$currentPos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        pathMeasure.getPosTan(((Float) animatedValue).floatValue(), currentPos, null);
        this$0.mBoxImage.setX(currentPos[0]);
        this$0.mBoxImage.setY(currentPos[1]);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        double d16 = animatedFraction;
        if (d16 > 0.025d) {
            if (this$0.mBoxImage.getVisibility() == 8) {
                this$0.mBoxImage.setVisibility(0);
            }
            float animatedFraction2 = 1 + (valueAnimator.getAnimatedFraction() * 2.2f);
            this$0.mBoxImage.setScaleX(animatedFraction2);
            this$0.mBoxImage.setScaleY(animatedFraction2);
        }
        if (d16 > 0.89d) {
            this$0.q(this$0.mBoxProgressBg, animatedFraction);
            this$0.q(this$0.mBoxDesc, animatedFraction);
            this$0.q(this$0.mBoxDescBottom, animatedFraction);
        }
        ConstraintLayout constraintLayout = this$0.mAdTipLayout;
        if (constraintLayout != null) {
            constraintLayout.setAlpha(1 - valueAnimator.getAnimatedFraction());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mBoxImage == null) {
            return;
        }
        if (this$0.mShowBoxAnimator == null) {
            this$0.v();
        }
        if (this$0.mHideBoxAnimator == null) {
            this$0.r();
        }
        ValueAnimator valueAnimator = this$0.mShowBoxAnimator;
        if (valueAnimator != null) {
            this$0.mAnimators.add(valueAnimator);
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(m this$0) {
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mBoxImage != null && (valueAnimator = this$0.mHideBoxAnimator) != null) {
            this$0.mAnimators.add(valueAnimator);
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mProgressBar == null) {
            return;
        }
        if (this$0.mProgressBarAnimator == null) {
            this$0.t();
        }
        ValueAnimator valueAnimator = this$0.mProgressBarAnimator;
        if (valueAnimator != null) {
            this$0.mAnimators.add(valueAnimator);
            valueAnimator.start();
        }
    }

    public final void A() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdMotiveAnimWrap", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
        this.mIsAttach = true;
        Runnable runnable = this.mCurrentAnimatorRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        I();
        E();
    }

    public final void B() {
        if (QLog.isColorLevel()) {
            QLog.d("QFSFeedAdMotiveAnimWrap", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        }
        this.mIsAttach = false;
        ConstraintLayout constraintLayout = this.mAdTipLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        View view = this.mAdBoxLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        Runnable runnable = this.mCurrentAnimatorRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        this.mCurrentAnimatorRunnable = null;
        Iterator<ValueAnimator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public final void C() {
        Iterator<ValueAnimator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isRunning()) {
                next.pause();
                return;
            }
        }
        Runnable runnable = this.mCurrentAnimatorRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
    }

    public final void D() {
        Iterator<ValueAnimator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            ValueAnimator next = it.next();
            if (next.isPaused()) {
                next.resume();
                return;
            }
        }
        Runnable runnable = this.mCurrentAnimatorRunnable;
        if (runnable != null) {
            RFWThreadManager.getUIHandler().postDelayed(runnable, 0L);
        }
    }

    public final void F(@Nullable s.b callback) {
        this.mSendEventCallback = callback;
    }
}
