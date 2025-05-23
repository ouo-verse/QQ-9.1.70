package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001=B\u0017\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\"\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0007H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR$\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftBannerContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/b;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "originalNum", HippyTKDListViewAdapter.X, "r", "", "path", "D", "E", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "giftAnimData", "t", "", "u", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/d;", "listener", "setBannerListener", "", "v", "w", "I", "G", WidgetCacheConstellationData.NUM, "J", "y", tl.h.F, "currentNum", "g", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;", "d", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;", "resManager", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BaseBannerView;", "e", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BaseBannerView;", "playBanner", "f", "playStatus", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "setCurData", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;)V", "curData", "i", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;)V", "a", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes20.dex */
public final class QQLiveGiftBannerContainer extends FrameLayout implements com.tencent.mobileqq.vasgift.mvvm.business.banner.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BannerResManager resManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseBannerView playBanner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int playStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.a curData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.vasgift.mvvm.business.banner.d listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftBannerContainer$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            HitNumberView hitNumberView;
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object obj = QQLiveGiftBannerContainer.this.lock;
            QQLiveGiftBannerContainer qQLiveGiftBannerContainer = QQLiveGiftBannerContainer.this;
            synchronized (obj) {
                QLog.i("QQLiveGiftBannerContainer", 1, "banner dismissed");
                int i3 = 0;
                qQLiveGiftBannerContainer.playStatus = 0;
                BaseBannerView baseBannerView = qQLiveGiftBannerContainer.playBanner;
                if (baseBannerView != null) {
                    baseBannerView.o();
                }
                BaseBannerView baseBannerView2 = qQLiveGiftBannerContainer.playBanner;
                if (baseBannerView2 != null) {
                    baseBannerView2.setVisibility(4);
                }
                com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = qQLiveGiftBannerContainer.listener;
                if (dVar != null) {
                    dVar.j();
                }
                com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar2 = qQLiveGiftBannerContainer.listener;
                if (dVar2 != null) {
                    com.tencent.mobileqq.qqgift.mvvm.business.anim.a curData = qQLiveGiftBannerContainer.getCurData();
                    BaseBannerView baseBannerView3 = qQLiveGiftBannerContainer.playBanner;
                    if (baseBannerView3 != null && (hitNumberView = baseBannerView3.f311739d) != null) {
                        i3 = hitNumberView.k();
                    }
                    dVar2.g(curData, i3);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationStart(animation);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftBannerContainer$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311781e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f311782f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f311783h;

        c(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, String str, int i3) {
            this.f311781e = aVar;
            this.f311782f = str;
            this.f311783h = i3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            QQLiveGiftBannerContainer.this.E(this.f311781e, this.f311782f, this.f311783h);
            BaseBannerView baseBannerView = QQLiveGiftBannerContainer.this.playBanner;
            if (baseBannerView != null) {
                viewTreeObserver = baseBannerView.getViewTreeObserver();
            } else {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftBannerContainer$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.mvvm.business.anim.a f311784d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f311785e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQLiveGiftBannerContainer f311786f;

        d(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar, int i3, QQLiveGiftBannerContainer qQLiveGiftBannerContainer) {
            this.f311784d = aVar;
            this.f311785e = i3;
            this.f311786f = qQLiveGiftBannerContainer;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.f311784d.a()) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                int i3 = this.f311785e;
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311784d;
                companion.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "onAnimationCancel", "originalNum=" + i3 + ", giftId=" + aVar.f264910a + ", giftName=" + aVar.f264913d, true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation, boolean isReverse) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationStart(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object obj = this.f311786f.lock;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311784d;
            int i3 = this.f311785e;
            QQLiveGiftBannerContainer qQLiveGiftBannerContainer = this.f311786f;
            synchronized (obj) {
                QLog.i("QQLiveGiftBannerContainer", 1, "banner showed");
                if (aVar.a()) {
                    AegisLogger.INSTANCE.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "onAnimationEnd", "originalNum=" + i3 + ", giftId=" + aVar.f264910a + ", giftName=" + aVar.f264913d, true);
                }
                qQLiveGiftBannerContainer.playStatus = 2;
                BaseBannerView baseBannerView = qQLiveGiftBannerContainer.playBanner;
                if (baseBannerView != null) {
                    baseBannerView.setAnimationListener(qQLiveGiftBannerContainer);
                }
                BaseBannerView baseBannerView2 = qQLiveGiftBannerContainer.playBanner;
                if (baseBannerView2 != null) {
                    baseBannerView2.n(aVar.f264926q);
                }
                VasPerfReportUtils.report(VasPerfReportUtils.BANNER_PLAY_END, "", "", "", 0L);
                VasLogReporter.INSTANCE.getVasGift().report("bannerAnimation playAnimation:" + aVar, VasLogReportProxy.LEVEL.HIGHEST);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.f311784d.a()) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                int i3 = this.f311785e;
                com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311784d;
                companion.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "onAnimationStart", "originalNum=" + i3 + ", giftId=" + aVar.f264910a + ", giftName=" + aVar.f264913d, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveGiftBannerContainer(@NotNull Context context, @NotNull BannerResManager resManager) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resManager, "resManager");
        this.resManager = resManager;
        this.lock = new Object();
        QQLiveBannerView qQLiveBannerView = new QQLiveBannerView(context, resManager);
        this.playBanner = qQLiveBannerView;
        addView(qQLiveBannerView);
        BaseBannerView baseBannerView = this.playBanner;
        if (baseBannerView != null) {
            baseBannerView.setVisibility(4);
        }
    }

    private final void A() {
        synchronized (this.lock) {
            this.playStatus = 3;
            BaseBannerView baseBannerView = this.playBanner;
            Intrinsics.checkNotNull(baseBannerView);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, -baseBannerView.getWidth());
            ofInt.setDuration(200L);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QQLiveGiftBannerContainer.B(QQLiveGiftBannerContainer.this, valueAnimator);
                }
            });
            ofInt.addListener(new b());
            ofInt.start();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QQLiveGiftBannerContainer this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        BaseBannerView baseBannerView = this$0.playBanner;
        if (baseBannerView != null) {
            baseBannerView.setTranslationX(intValue);
        }
    }

    private final void C() {
        int i3;
        synchronized (this.lock) {
            QLog.i("QQLiveGiftBannerContainer", 1, "stop playStatus is " + this.playStatus);
            BaseBannerView baseBannerView = this.playBanner;
            if (baseBannerView != null && (i3 = this.playStatus) != 0 && i3 != 3) {
                if (baseBannerView != null) {
                    baseBannerView.o();
                }
                BaseBannerView baseBannerView2 = this.playBanner;
                if (baseBannerView2 != null) {
                    baseBannerView2.clearAnimation();
                }
                this.playStatus = 2;
                p();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void D(com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, String path, int originalNum) {
        ViewTreeObserver viewTreeObserver;
        if (data.a()) {
            AegisLogger.INSTANCE.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "showBanner", "", true);
        }
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.listener;
        if (dVar != null) {
            dVar.a();
        }
        BaseBannerView baseBannerView = this.playBanner;
        if (baseBannerView != null) {
            baseBannerView.setVisibility(0);
        }
        BaseBannerView baseBannerView2 = this.playBanner;
        if (baseBannerView2 != null) {
            baseBannerView2.i(data, path);
        }
        BaseBannerView baseBannerView3 = this.playBanner;
        if (baseBannerView3 != null) {
            baseBannerView3.setNum(originalNum);
        }
        BaseBannerView baseBannerView4 = this.playBanner;
        if (baseBannerView4 != null) {
            viewTreeObserver = baseBannerView4.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new c(data, path, originalNum));
            Unit unit = Unit.INSTANCE;
            E(data, path, originalNum);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, String path, int originalNum) {
        if (data.a()) {
            AegisLogger.INSTANCE.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "showBannerAnimInner", "playAnim, originalNum=" + originalNum + ", giftId=" + data.f264910a + ", giftName=" + data.f264913d, true);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getWidth(), 0);
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QQLiveGiftBannerContainer.F(QQLiveGiftBannerContainer.this, valueAnimator);
            }
        });
        ofInt.addListener(new d(data, originalNum, this));
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QQLiveGiftBannerContainer this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        BaseBannerView baseBannerView = this$0.playBanner;
        if (baseBannerView != null) {
            baseBannerView.setTranslationX(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(QQLiveGiftBannerContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QQLiveGiftBannerContainer this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseBannerView baseBannerView = this$0.playBanner;
        if (baseBannerView != null) {
            baseBannerView.n(i3);
        }
    }

    private final void p() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            A();
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGiftBannerContainer.q(QQLiveGiftBannerContainer.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QQLiveGiftBannerContainer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    private final void r(com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        if (data.a()) {
            AegisLogger.INSTANCE.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "download", "downloadAnimationRes, materialId=" + data.f264914e, true);
        }
        this.resManager.l(data.f264914e, null);
    }

    private final String t(com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData) {
        if (giftAnimData == null) {
            return null;
        }
        long j3 = giftAnimData.f264918i;
        long j16 = giftAnimData.f264920k;
        long j17 = giftAnimData.f264925p;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        sb5.append(j16);
        sb5.append(j17);
        return sb5.toString();
    }

    private final void x(com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, int originalNum) {
        String str;
        synchronized (this.lock) {
            this.curData = data;
            boolean E = this.resManager.E(data.f264914e);
            QLog.i("QQLiveGiftBannerContainer", 1, "play isResExit " + E + " pagIsLoad:" + QQGiftPAGAnimationViewImpl.f311895g.a());
            if (data.a()) {
                AegisLogger.INSTANCE.i("Recv_Gift_Monitor|QQLiveGiftBannerContainer", "play", "originalNum=" + originalNum + ", giftId=" + data.f264910a + ", giftName=" + data.f264913d, true);
            }
            if (E) {
                str = "cache";
            } else {
                str = "noCache";
            }
            VasPerfReportUtils.report(VasPerfReportUtils.BANNER_PLAY_START, str, "", String.valueOf(QQGiftPAGAnimationViewImpl.f311895g.a()), 0L);
            VasLogReporter.INSTANCE.getVasGift().report("bannerAnimation isResExit " + E + " pagIsLoad:" + QQGiftPAGAnimationViewImpl.f311895g.a(), VasLogReportProxy.LEVEL.HIGHEST);
            if (!E) {
                r(data);
            }
            String n3 = this.resManager.n(data.f264914e);
            Intrinsics.checkNotNullExpressionValue(n3, "resManager.getBannerAnim\u2026nResPath(data.materialId)");
            D(data, n3, originalNum);
            this.playStatus = 1;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QQLiveGiftBannerContainer this$0, com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.x(data, data.f264928s);
    }

    public final void G() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            C();
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGiftBannerContainer.H(QQLiveGiftBannerContainer.this);
                }
            });
        }
    }

    public final boolean I(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData) {
        int i3 = 0;
        if (giftAnimData == null || !w(giftAnimData)) {
            return false;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.curData;
        if (aVar != null) {
            i3 = aVar.f264926q;
        }
        int i16 = giftAnimData.f264926q;
        if (i16 > i3) {
            return J(i16);
        }
        return true;
    }

    public final boolean J(final int num) {
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar;
        synchronized (this.lock) {
            QLog.i("QQLiveGiftBannerContainer", 1, "updateCurrentTargetNum " + num + " playStatus is " + this.playStatus);
            int i3 = this.playStatus;
            if (i3 != 3 && (aVar = this.curData) != null) {
                if (aVar != null) {
                    aVar.f264926q = num;
                }
                if (i3 == 2) {
                    post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQLiveGiftBannerContainer.K(QQLiveGiftBannerContainer.this, num);
                        }
                    });
                } else {
                    QLog.e("QQLiveGiftBannerContainer", 1, "updateCurrentTargetNum \u6ca1\u6709\u6b63\u5728\u64ad\u653e\u4e86,\u65e0\u6cd5\u76f4\u63a5\u66f4\u65b0");
                }
                return true;
            }
            QLog.e("QQLiveGiftBannerContainer", 1, "updateCurrentTargetNum \u6ed1\u51fa\u53bb\u7684\u65f6\u5019\u4e0d\u5141\u8bb8\u66f4\u65b0\u8fde\u51fb\u6570\u4e86");
            return false;
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void g(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, int currentNum) {
        if (data != this.curData) {
            QLog.e("QQLiveGiftBannerContainer", 1, "banner animation end but not match");
        } else {
            QLog.i("QQLiveGiftBannerContainer", 1, "banner animation end");
            p();
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.b
    public void h(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        if (data != this.curData) {
            QLog.e("QQLiveGiftBannerContainer", 1, "banner animation start but not match");
            return;
        }
        QLog.i("QQLiveGiftBannerContainer", 1, "banner animation start");
        com.tencent.mobileqq.vasgift.mvvm.business.banner.d dVar = this.listener;
        if (dVar != null) {
            dVar.h(data);
        }
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final com.tencent.mobileqq.qqgift.mvvm.business.anim.a getCurData() {
        return this.curData;
    }

    public final void setBannerListener(@Nullable com.tencent.mobileqq.vasgift.mvvm.business.banner.d listener) {
        this.listener = listener;
    }

    public final void setCurData(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        this.curData = aVar;
    }

    public final long u() {
        QQLiveBannerView qQLiveBannerView = (QQLiveBannerView) this.playBanner;
        if (qQLiveBannerView != null) {
            return qQLiveBannerView.t();
        }
        return 0L;
    }

    public final boolean v() {
        if (this.playStatus == 0) {
            return true;
        }
        return false;
    }

    public final boolean w(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a giftAnimData) {
        boolean z16;
        int i3 = this.playStatus;
        if (i3 != 1 && i3 != 2) {
            return false;
        }
        String t16 = t(this.curData);
        if (t16 != null) {
            z16 = t16.equals(t(giftAnimData));
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final void y(@NotNull final com.tencent.mobileqq.qqgift.mvvm.business.anim.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            x(data, data.f264928s);
        } else {
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.o
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGiftBannerContainer.z(QQLiveGiftBannerContainer.this, data);
                }
            });
        }
    }
}
