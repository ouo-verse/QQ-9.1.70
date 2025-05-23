package com.tencent.av.zplan.avatar.manager;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieResult;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.zplan.avatar.utils.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.avatar.AvatarAIInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J$\u0010\u0019\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0006J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R'\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00102R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010&\u001a\u0004\bA\u0010BR'\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010&\u001a\u0004\bE\u0010BR\u0014\u0010I\u001a\u00020*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010H\u00a8\u0006P"}, d2 = {"Lcom/tencent/av/zplan/avatar/manager/AVChatAvatarEasterEggManager;", "Landroid/animation/Animator$AnimatorListener;", "", "isLocal", "Lcom/tencent/av/zplan/avatar/manager/b;", "composition", "", AdMetricTag.EVENT_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "event", DomainData.DOMAIN_NAME, "u", "isDefault", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "Lorg/light/avatar/AvatarAIInfo;", "avatarAIInfo", "y", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "leftView", "rightView", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "file", HippyTKDListViewAdapter.X, "Landroid/animation/Animator;", "animation", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/concurrent/ConcurrentHashMap;", "mCompositionCache", "Lcom/airbnb/lottie/LottieDrawable;", "e", "Lcom/airbnb/lottie/LottieDrawable;", "mLottieDrawableLeft", "f", "mLottieDrawableRight", "Lmqq/util/WeakReference;", h.F, "Lmqq/util/WeakReference;", "mLottieRootViewRef", "i", "mLottieViewLeftRef", "mLottieViewRightRef", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsAnimating", "", "D", "I", "mAnimatingCount", "", "E", "r", "()Ljava/util/Map;", "mOneHandMap", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "mReportMap", "o", "()Lcom/airbnb/lottie/LottieDrawable;", "lottieDrawableLeft", "p", "lottieDrawableRight", "<init>", "()V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AVChatAvatarEasterEggManager implements Animator.AnimatorListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mIsAnimating;

    /* renamed from: D, reason: from kotlin metadata */
    private int mAnimatingCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mOneHandMap;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mReportMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mCompositionCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawableLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawableRight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mLottieRootViewRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<ImageView> mLottieViewLeftRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<ImageView> mLottieViewRightRef;

    public AVChatAvatarEasterEggManager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, b>>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$mCompositionCache$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<String, b> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.mCompositionCache = lazy;
        this.mIsAnimating = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$mOneHandMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends String> invoke() {
                Map<String, ? extends String> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("4", "love"), TuplesKt.to("2", "heart"), TuplesKt.to("3", "paper"));
                return mapOf;
            }
        });
        this.mOneHandMap = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$mReportMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends String> invoke() {
                Map<String, ? extends String> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("love", "1"), TuplesKt.to("heart", "2"), TuplesKt.to("paper", "3"));
                return mapOf;
            }
        });
        this.mReportMap = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean isDefault) {
        View view;
        WeakReference<ImageView> weakReference;
        ImageView imageView;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<View> weakReference2 = this.mLottieRootViewRef;
        if (weakReference2 != null && (view = weakReference2.get()) != null && (weakReference = this.mLottieViewLeftRef) != null && (imageView = weakReference.get()) != null) {
            int i16 = 0;
            if (isDefault) {
                i3 = ViewUtils.dip2px(51.0f);
            } else {
                i3 = 0;
            }
            if (isDefault) {
                i16 = ViewUtils.dip2px(29.5f);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null && marginLayoutParams.topMargin != i3) {
                marginLayoutParams.topMargin = i3;
                view.setLayoutParams(marginLayoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            }
            if (marginLayoutParams2 != null && marginLayoutParams2.topMargin != i16) {
                marginLayoutParams2.topMargin = i16;
                imageView.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    private final String n(String event) {
        if (event == null) {
            return null;
        }
        return r().get(event);
    }

    private final LottieDrawable o() {
        if (this.mLottieDrawableLeft == null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawableLeft = lottieDrawable;
            lottieDrawable.addAnimatorListener(this);
            LottieDrawable lottieDrawable2 = this.mLottieDrawableLeft;
            if (lottieDrawable2 != null) {
                lottieDrawable2.setRepeatCount(0);
            }
        }
        LottieDrawable lottieDrawable3 = this.mLottieDrawableLeft;
        Intrinsics.checkNotNull(lottieDrawable3);
        return lottieDrawable3;
    }

    private final LottieDrawable p() {
        if (this.mLottieDrawableRight == null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawableRight = lottieDrawable;
            lottieDrawable.addAnimatorListener(this);
            LottieDrawable lottieDrawable2 = this.mLottieDrawableRight;
            if (lottieDrawable2 != null) {
                lottieDrawable2.setRepeatCount(0);
            }
        }
        LottieDrawable lottieDrawable3 = this.mLottieDrawableRight;
        Intrinsics.checkNotNull(lottieDrawable3);
        return lottieDrawable3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, b> q() {
        return (ConcurrentHashMap) this.mCompositionCache.getValue();
    }

    private final Map<String, String> r() {
        return (Map) this.mOneHandMap.getValue();
    }

    private final Map<String, String> s() {
        return (Map) this.mReportMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(String eventName) {
        String str = s().get(eventName);
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u() {
        VideoAppInterface videoAppInterface;
        com.tencent.av.business.manager.a aVar;
        ku.b bVar;
        ku.a aVar2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof VideoAppInterface) {
            videoAppInterface = (VideoAppInterface) peekAppRuntime;
        } else {
            videoAppInterface = null;
        }
        if (videoAppInterface != null) {
            aVar = videoAppInterface.B(19);
        } else {
            aVar = null;
        }
        if (aVar instanceof ku.b) {
            bVar = (ku.b) aVar;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            aVar2 = bVar.w("video_zplan_eggs_animation");
        } else {
            aVar2 = null;
        }
        if (aVar2 == null || !aVar2.isUsable()) {
            return null;
        }
        return bVar.y(aVar2) + "video_zplan_eggs_animation";
    }

    private final void v() {
        View view;
        ImageView imageView;
        ImageView imageView2;
        WeakReference<View> weakReference = this.mLottieRootViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ImageView> weakReference2 = this.mLottieViewLeftRef;
        if (weakReference2 != null && (imageView2 = weakReference2.get()) != null) {
            imageView2.setImageDrawable(null);
        }
        WeakReference<ImageView> weakReference3 = this.mLottieViewRightRef;
        if (weakReference3 != null && (imageView = weakReference3.get()) != null) {
            imageView.setImageDrawable(null);
        }
        this.mIsAnimating.compareAndSet(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean isLocal, b composition, final String eventName) {
        String imageAssets = composition.getImageAssets();
        o().setImagesAssetsFolder(imageAssets);
        p().setImagesAssetsFolder(imageAssets);
        c cVar = new c(imageAssets);
        o().setImageAssetDelegate(cVar);
        p().setImageAssetDelegate(cVar);
        o().setComposition(composition.getComposition());
        p().setComposition(composition.getComposition());
        QLog.d("AVChatAvatarEasterEggManager", 1, "startLottieAnimation isLocal: " + isLocal + " eventName: " + eventName);
        f.h(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$startLottieAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                WeakReference weakReference2;
                LottieDrawable lottieDrawable;
                LottieDrawable lottieDrawable2;
                String t16;
                LottieDrawable lottieDrawable3;
                AVChatAvatarEasterEggManager.this.A(!Intrinsics.areEqual(eventName, "paper"));
                weakReference = AVChatAvatarEasterEggManager.this.mLottieRootViewRef;
                View view = weakReference != null ? (View) weakReference.get() : null;
                weakReference2 = AVChatAvatarEasterEggManager.this.mLottieViewLeftRef;
                ImageView imageView = weakReference2 != null ? (ImageView) weakReference2.get() : null;
                if (view != null) {
                    view.setVisibility(0);
                }
                if (imageView != null) {
                    lottieDrawable3 = AVChatAvatarEasterEggManager.this.mLottieDrawableLeft;
                    imageView.setImageDrawable(lottieDrawable3);
                }
                lottieDrawable = AVChatAvatarEasterEggManager.this.mLottieDrawableLeft;
                if (lottieDrawable != null) {
                    lottieDrawable.setProgress(0.0f);
                }
                lottieDrawable2 = AVChatAvatarEasterEggManager.this.mLottieDrawableLeft;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.playAnimation();
                }
                t16 = AVChatAvatarEasterEggManager.this.t(eventName);
                ReportController.o(null, "dc00898", "", "", "0X800C466", "0X800C466", 0, 0, t16, "", "", "");
            }
        });
        f.g(1000L, new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$startLottieAnimation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                LottieDrawable lottieDrawable;
                LottieDrawable lottieDrawable2;
                LottieDrawable lottieDrawable3;
                weakReference = AVChatAvatarEasterEggManager.this.mLottieViewRightRef;
                ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
                if (imageView != null) {
                    lottieDrawable3 = AVChatAvatarEasterEggManager.this.mLottieDrawableRight;
                    imageView.setImageDrawable(lottieDrawable3);
                }
                lottieDrawable = AVChatAvatarEasterEggManager.this.mLottieDrawableRight;
                if (lottieDrawable != null) {
                    lottieDrawable.setProgress(0.0f);
                }
                lottieDrawable2 = AVChatAvatarEasterEggManager.this.mLottieDrawableRight;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.playAnimation();
                }
            }
        });
    }

    public final void l(@Nullable View rootView, @Nullable ImageView leftView, @Nullable ImageView rightView) {
        this.mLottieRootViewRef = new WeakReference<>(rootView);
        this.mLottieViewLeftRef = new WeakReference<>(leftView);
        this.mLottieViewRightRef = new WeakReference<>(rightView);
    }

    public final void m() {
        QLog.d("AVChatAvatarEasterEggManager", 1, "detachView");
        this.mLottieRootViewRef = null;
        this.mLottieViewLeftRef = null;
        this.mLottieViewRightRef = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animation) {
        int i3 = this.mAnimatingCount - 1;
        this.mAnimatingCount = i3;
        if (i3 <= 0) {
            v();
        }
        if (this.mAnimatingCount < 0) {
            this.mAnimatingCount = 0;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animation) {
        int i3 = this.mAnimatingCount - 1;
        this.mAnimatingCount = i3;
        if (i3 <= 0) {
            v();
        }
        if (this.mAnimatingCount < 0) {
            this.mAnimatingCount = 0;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animation) {
        this.mAnimatingCount++;
    }

    public final void w() {
        View view;
        LottieDrawable lottieDrawable = this.mLottieDrawableLeft;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
        }
        LottieDrawable lottieDrawable2 = this.mLottieDrawableLeft;
        if (lottieDrawable2 != null) {
            lottieDrawable2.setProgress(0.0f);
        }
        LottieDrawable lottieDrawable3 = this.mLottieDrawableLeft;
        if (lottieDrawable3 != null) {
            lottieDrawable3.removeAnimatorListener(this);
        }
        LottieDrawable lottieDrawable4 = this.mLottieDrawableRight;
        if (lottieDrawable4 != null) {
            lottieDrawable4.cancelAnimation();
        }
        LottieDrawable lottieDrawable5 = this.mLottieDrawableRight;
        if (lottieDrawable5 != null) {
            lottieDrawable5.setProgress(0.0f);
        }
        LottieDrawable lottieDrawable6 = this.mLottieDrawableRight;
        if (lottieDrawable6 != null) {
            lottieDrawable6.removeAnimatorListener(this);
        }
        this.mIsAnimating.compareAndSet(true, false);
        WeakReference<View> weakReference = this.mLottieRootViewRef;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        this.mLottieDrawableLeft = null;
        this.mLottieDrawableRight = null;
        this.mAnimatingCount = 0;
    }

    public final void x(final boolean isLocal, @NotNull final String file) {
        View view;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(file, "file");
        WeakReference<View> weakReference = this.mLottieRootViewRef;
        ImageView imageView2 = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            WeakReference<ImageView> weakReference2 = this.mLottieViewLeftRef;
            if (weakReference2 != null) {
                imageView = weakReference2.get();
            } else {
                imageView = null;
            }
            if (imageView != null) {
                WeakReference<ImageView> weakReference3 = this.mLottieViewRightRef;
                if (weakReference3 != null) {
                    imageView2 = weakReference3.get();
                }
                if (imageView2 != null) {
                    if (!this.mIsAnimating.compareAndSet(false, true)) {
                        QLog.e("AVChatAvatarEasterEggManager", 1, "compare and set failed!");
                        return;
                    }
                    b bVar = q().get(file);
                    if (bVar != null) {
                        z(isLocal, bVar, file);
                    } else {
                        f.d(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager$playAnimation$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                String u16;
                                FileInputStream fileInputStream;
                                ConcurrentHashMap q16;
                                LottieDrawable lottieDrawable;
                                AtomicBoolean atomicBoolean;
                                AtomicBoolean atomicBoolean2;
                                AtomicBoolean atomicBoolean3;
                                AtomicBoolean atomicBoolean4;
                                u16 = AVChatAvatarEasterEggManager.this.u();
                                if (u16 == null || u16.length() == 0) {
                                    QLog.e("AVChatAvatarEasterEggManager", 1, "res is not ready!!!");
                                    atomicBoolean4 = AVChatAvatarEasterEggManager.this.mIsAnimating;
                                    atomicBoolean4.compareAndSet(true, false);
                                    return;
                                }
                                String str = File.separator;
                                String str2 = u16 + str + file + str;
                                String str3 = str2 + LottieLoader.FILE_DATA_JSON;
                                if (!new File(str3).exists()) {
                                    QLog.e("AVChatAvatarEasterEggManager", 1, str3 + " not found!!!");
                                    atomicBoolean3 = AVChatAvatarEasterEggManager.this.mIsAnimating;
                                    atomicBoolean3.compareAndSet(true, false);
                                    return;
                                }
                                try {
                                    QLog.d("AVChatAvatarEasterEggManager", 1, "isLocal: " + isLocal + " load file: " + str3);
                                    fileInputStream = new FileInputStream(str3);
                                } catch (Exception e16) {
                                    QLog.e("AVChatAvatarEasterEggManager", 1, "open file failed\n", e16);
                                    fileInputStream = null;
                                }
                                if (fileInputStream == null) {
                                    atomicBoolean2 = AVChatAvatarEasterEggManager.this.mIsAnimating;
                                    atomicBoolean2.compareAndSet(true, false);
                                    return;
                                }
                                LottieResult<LottieComposition> fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(fileInputStream, file);
                                if (fromJsonInputStreamSync.getValue() == null) {
                                    QLog.e("AVChatAvatarEasterEggManager", 1, "load lottie failed!\n", fromJsonInputStreamSync.getException());
                                    atomicBoolean = AVChatAvatarEasterEggManager.this.mIsAnimating;
                                    atomicBoolean.compareAndSet(true, false);
                                    return;
                                }
                                LottieComposition value = fromJsonInputStreamSync.getValue();
                                Intrinsics.checkNotNull(value);
                                b bVar2 = new b(value, str2 + "images");
                                q16 = AVChatAvatarEasterEggManager.this.q();
                                q16.put(file, bVar2);
                                lottieDrawable = AVChatAvatarEasterEggManager.this.mLottieDrawableLeft;
                                if (lottieDrawable != null) {
                                    lottieDrawable.getImageAssetsFolder();
                                }
                                AVChatAvatarEasterEggManager.this.z(isLocal, bVar2, file);
                            }
                        });
                    }
                }
            }
        }
    }

    public final void y(boolean isLocal, @Nullable AvatarAIInfo avatarAIInfo) {
        if (avatarAIInfo == null || this.mIsAnimating.get()) {
            return;
        }
        String n3 = n(avatarAIInfo.events.get("l_h"));
        if (n3 == null) {
            n3 = n(avatarAIInfo.events.get("r_h"));
        }
        if (n3 == null) {
            return;
        }
        x(isLocal, n3);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@Nullable Animator animation) {
    }
}
