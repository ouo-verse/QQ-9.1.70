package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.gallery.anim.TransitionAnimUtil;
import com.tencent.richframework.gallery.anim.TransitionAnimator;
import com.tencent.richframework.gallery.anim.TransitionInitData;
import com.tencent.richframework.gallery.anim.TransitionManager;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.event.RFWEnterAnimStateEvent;
import com.tencent.richframework.gallery.event.RFWExitAnimStateEvent;
import com.tencent.richframework.gallery.event.RFWFinishHostEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import com.tencent.richframework.widget.matrix.RFWMatrixImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001&\u0018\u0000 z2\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002:\u0001zB\u0005\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010C\u001a\u00020\u00172\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EH\u0002J\b\u0010G\u001a\u00020\u0017H\u0002J\u0018\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020\u0017H\u0002J\u0010\u0010K\u001a\u00020I2\u0006\u0010L\u001a\u00020MH\u0002J\u0012\u0010N\u001a\u00020I2\b\u0010O\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010P\u001a\u00020IH\u0002J\b\u0010Q\u001a\u00020IH\u0002J$\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020\u00172\u0006\u0010W\u001a\u00020\u0017H\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Y\u001a\u000209H\u0002J\b\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u000fH\u0002J\b\u0010^\u001a\u00020\u0013H\u0016J\b\u0010_\u001a\u00020IH\u0002J\u0010\u0010`\u001a\u00020I2\u0006\u0010]\u001a\u00020\u000fH\u0002J\u0010\u0010a\u001a\u00020I2\u0006\u0010]\u001a\u00020\u000fH\u0002J\b\u0010b\u001a\u00020\u0017H\u0002J\b\u0010c\u001a\u00020\u0017H\u0016J\u0016\u0010d\u001a\u00020I2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010f\u001a\u00020I2\u0006\u0010g\u001a\u00020\u001bH\u0016J\u0012\u0010h\u001a\u00020I2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\b\u0010k\u001a\u00020IH\u0002J\b\u0010l\u001a\u00020IH\u0002J\u0010\u0010m\u001a\u00020I2\u0006\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u00020IH\u0002J\u0018\u0010p\u001a\u00020I2\u0006\u0010V\u001a\u00020\u00172\u0006\u0010q\u001a\u00020\u0017H\u0002J\u0010\u0010r\u001a\u00020I2\u0006\u0010L\u001a\u000209H\u0002J\u0010\u0010s\u001a\u00020I2\u0006\u0010n\u001a\u00020\u0017H\u0002J\u0010\u0010t\u001a\u00020I2\u0006\u0010n\u001a\u00020\u0017H\u0002J\u0012\u0010u\u001a\u00020I2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J \u0010v\u001a\u00020I2\u0006\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020\u00132\u0006\u0010y\u001a\u00020\u0017H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010'R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u0002098BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006{"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWLayerAnimPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "()V", "animBean", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "animCreator", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "getAnimCreator", "()Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "animRootLayout", "Landroid/widget/FrameLayout;", "currentPicView", "Landroid/widget/ImageView;", "dragLayout", "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "enterMediaId", "", "enterMediaInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "hasInformedFinish", "", "hasInit", "hideView", "", "Landroid/view/View;", "initBean", "Lcom/tencent/richframework/gallery/bean/RFWLayerInitBean;", "isAfterPreDraw", "isCarvedAnimOpen", "isInExitAnim", "isSameEnterAndExist", "()Z", "loadTimeoutTask", "Ljava/lang/Runnable;", "onBackPressedCallback", "com/tencent/richframework/gallery/part/RFWLayerAnimPart$onBackPressedCallback$1", "Lcom/tencent/richframework/gallery/part/RFWLayerAnimPart$onBackPressedCallback$1;", "operationInterceptor", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "getOperationInterceptor", "()Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "operationInterceptor$delegate", "Lkotlin/Lazy;", "operationListener", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "getOperationListener", "()Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "operationListener$delegate", "picLoader", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "()Lcom/tencent/libra/IPicLoader;", "picLoader$delegate", "realScreenHeight", "", "getRealScreenHeight", "()I", "tempImageView", "tranUUID", "Ljava/util/UUID;", "transitionManager", "Lcom/tencent/richframework/gallery/anim/TransitionManager;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "canFinishActivityAfterFragmentFinish", "fragmentList", "", "Landroidx/fragment/app/Fragment;", "canShowExitAnim", "changeAllViewPagerContentVisibility", "", "isVisible", "changeIgnoreViewAlpha", c.f123400v, "", "collectIgnoreViewExcludeTarget", "targetView", "finishActivity", "finishHost", "getAdjustPicInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "picInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "hasCut", "isEmptyEnter", "getCurrentImageView", "position", "getCurrentMediaPicId", "getCurrentPicViewRect", "Landroid/graphics/RectF;", "imageView", "getLogTag", "initAndStartAnim", "initDragFrameLayout", "initStartAnim", "isOpenByActivity", "onBackEvent", "onChanged", "uiStateData", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onPartDestroy", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "resetVisibleAndBg", "sendFinishHostEvent", "showExitAnim", "needUpdateRect", "showIgnoreView", "startAnimWithLoadImage", "isEmpty", "updateBackgroundAlpha", "updateCurrentPicView", "updateEnd", "updateEnterRect", "updateOriginImageViewVisibility", "uuid", "id", ViewStickEventHelper.IS_SHOW, "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerAnimPart extends RFWLayerBasePart {
    private volatile RFWTransAnimBean animBean;
    private FrameLayout animRootLayout;
    private ImageView currentPicView;
    private RFWDragLayout dragLayout;
    private String enterMediaId;
    private RFWLayerItemMediaInfo enterMediaInfo;
    private boolean hasInformedFinish;
    private boolean hasInit;
    private final List<View> hideView = new ArrayList();
    private RFWLayerInitBean initBean;
    private boolean isAfterPreDraw;
    private boolean isCarvedAnimOpen;
    private boolean isInExitAnim;
    private final Runnable loadTimeoutTask;
    private final RFWLayerAnimPart$onBackPressedCallback$1 onBackPressedCallback;

    /* renamed from: operationInterceptor$delegate, reason: from kotlin metadata */
    private final Lazy operationInterceptor;

    /* renamed from: operationListener$delegate, reason: from kotlin metadata */
    private final Lazy operationListener;

    /* renamed from: picLoader$delegate, reason: from kotlin metadata */
    private final Lazy picLoader;
    private ImageView tempImageView;
    private volatile UUID tranUUID;
    private TransitionManager transitionManager;
    private ViewPager2 viewPager;

    /* JADX WARN: Type inference failed for: r0v7, types: [com.tencent.richframework.gallery.part.RFWLayerAnimPart$onBackPressedCallback$1] */
    public RFWLayerAnimPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$picLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IPicLoader invoke() {
                View rootView = RFWLayerAnimPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getPicLoaderFromView(rootView);
            }
        });
        this.picLoader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ILayerOperationListener>() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$operationListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ILayerOperationListener invoke() {
                View rootView = RFWLayerAnimPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getLayerOperationListener(rootView);
            }
        });
        this.operationListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ILayerOperationInterceptor>() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$operationInterceptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ILayerOperationInterceptor invoke() {
                View rootView = RFWLayerAnimPart.this.getPartRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getLayerOperationInterceptor(rootView);
            }
        });
        this.operationInterceptor = lazy3;
        final boolean z16 = true;
        this.onBackPressedCallback = new OnBackPressedCallback(z16) { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onBackPressedCallback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                RFWLayerAnimPart.this.onBackEvent();
            }
        };
        this.loadTimeoutTask = new Runnable() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$loadTimeoutTask$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "load timeout reset");
                RFWLayerAnimPart.this.resetVisibleAndBg();
            }
        };
    }

    public static final /* synthetic */ RFWDragLayout access$getDragLayout$p(RFWLayerAnimPart rFWLayerAnimPart) {
        RFWDragLayout rFWDragLayout = rFWLayerAnimPart.dragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        }
        return rFWDragLayout;
    }

    public static final /* synthetic */ RFWLayerItemMediaInfo access$getEnterMediaInfo$p(RFWLayerAnimPart rFWLayerAnimPart) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = rFWLayerAnimPart.enterMediaInfo;
        if (rFWLayerItemMediaInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterMediaInfo");
        }
        return rFWLayerItemMediaInfo;
    }

    public static final /* synthetic */ RFWLayerInitBean access$getInitBean$p(RFWLayerAnimPart rFWLayerAnimPart) {
        RFWLayerInitBean rFWLayerInitBean = rFWLayerAnimPart.initBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        }
        return rFWLayerInitBean;
    }

    public static final /* synthetic */ ImageView access$getTempImageView$p(RFWLayerAnimPart rFWLayerAnimPart) {
        ImageView imageView = rFWLayerAnimPart.tempImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempImageView");
        }
        return imageView;
    }

    public static final /* synthetic */ UUID access$getTranUUID$p(RFWLayerAnimPart rFWLayerAnimPart) {
        UUID uuid = rFWLayerAnimPart.tranUUID;
        if (uuid == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
        }
        return uuid;
    }

    public static final /* synthetic */ ViewPager2 access$getViewPager$p(RFWLayerAnimPart rFWLayerAnimPart) {
        ViewPager2 viewPager2 = rFWLayerAnimPart.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    private final boolean canFinishActivityAfterFragmentFinish(List<? extends Fragment> fragmentList) {
        for (Fragment fragment : fragmentList) {
            if ((true ^ Intrinsics.areEqual(fragment, getPartHost())) && fragment.getView() != null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowExitAnim() {
        if (this.transitionManager == null || this.mCurrentSelectedItem == null || this.isInExitAnim) {
            return false;
        }
        boolean isSameEnterAndExist = isSameEnterAndExist();
        if (isSameEnterAndExist) {
            TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
            UUID uuid = this.tranUUID;
            if (uuid == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
            }
            ImageView enterImageView = transitionAnimUtil.getTransViewAndDrawable(uuid).getEnterImageView();
            if (enterImageView != null) {
                UUID uuid2 = this.tranUUID;
                if (uuid2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
                }
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
                this.animBean = RFWLayerLaunchUtil.getTransAnimBean(uuid2, enterImageView, rFWLayerItemMediaInfo.getLayerPicInfo(), true);
            }
            if (this.animBean != null) {
                updateEnterRect(this.animBean);
            }
        }
        if (this.animBean == null) {
            return false;
        }
        RFWTransAnimBean rFWTransAnimBean = this.animBean;
        Intrinsics.checkNotNull(rFWTransAnimBean);
        if (!rFWTransAnimBean.getIsBackTransition()) {
            return false;
        }
        if (getAnimCreator() == null && !isSameEnterAndExist) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeAllViewPagerContentVisibility(ViewPager2 viewPager, boolean isVisible) {
        int i3;
        View childAt = viewPager.getChildAt(0);
        if (childAt != null) {
            ViewGroup viewGroup = (ViewGroup) childAt;
            int childCount = viewGroup.getChildCount();
            ArrayList arrayList = new ArrayList(childCount);
            for (int i16 = 0; i16 < childCount; i16++) {
                arrayList.add(viewGroup.getChildAt(i16));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                View findViewById = ((View) it.next()).findViewById(R.id.f73963uz);
                if (findViewById != null) {
                    if (isVisible) {
                        i3 = 0;
                    } else {
                        i3 = 4;
                    }
                    findViewById.setVisibility(i3);
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeIgnoreViewAlpha(float alpha) {
        Iterator<View> it = this.hideView.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void collectIgnoreViewExcludeTarget(View targetView) {
        if (targetView != null && (targetView.getParent() instanceof ViewGroup) && targetView != getPartRootView()) {
            ViewParent parent = targetView.getParent();
            if (parent != null) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childView = viewGroup.getChildAt(i3);
                    if (childView != targetView) {
                        FrameLayout frameLayout = this.animRootLayout;
                        if (frameLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
                        }
                        if (childView != frameLayout) {
                            Intrinsics.checkNotNullExpressionValue(childView, "childView");
                            if (childView.getVisibility() == 0) {
                                this.hideView.add(childView);
                            }
                        }
                    }
                }
                if (targetView.getParent() instanceof View) {
                    Object parent2 = targetView.getParent();
                    if (parent2 != null) {
                        collectIgnoreViewExcludeTarget((View) parent2);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    private final void finishActivity() {
        RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "finishActivity");
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishHost() {
        RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "finishHost");
        sendFinishHostEvent();
        if (getPartHost() instanceof Fragment) {
            Object partHost = getPartHost();
            if (partHost != null) {
                Fragment fragment = (Fragment) partHost;
                if (!fragment.isAdded()) {
                    RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "hostFragment is not add");
                    return;
                }
                FragmentTransaction beginTransaction = fragment.getParentFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "hostFragment.parentFragm\u2026anager.beginTransaction()");
                beginTransaction.remove(fragment);
                beginTransaction.commitAllowingStateLoss();
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "hostFragment.parentFragmentManager");
                List<Fragment> fragments = parentFragmentManager.getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "hostFragment.parentFragmentManager.fragments");
                if (canFinishActivityAfterFragmentFinish(fragments)) {
                    finishActivity();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }
        if (getPartHost() instanceof Activity) {
            finishActivity();
        } else {
            RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "unKnown partHost");
        }
    }

    private final RFWLayerPicInfo.RFWPicInfo getAdjustPicInfo(RFWLayerPicInfo picInfo, boolean hasCut, boolean isEmptyEnter) {
        RFWLayerPicInfo.RFWPicInfo smallPicInfo;
        if (hasCut) {
            if (picInfo == null) {
                return null;
            }
            return picInfo.getCurrentPicInfo();
        }
        if (isEmptyEnter) {
            if (picInfo != null && (smallPicInfo = picInfo.getSmallPicInfo()) != null) {
                return smallPicInfo;
            }
            if (picInfo == null) {
                return null;
            }
            return picInfo.getCurrentPicInfo();
        }
        if (picInfo == null) {
            return null;
        }
        return picInfo.getCurrentPicInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RFWTransitionHelper.TransAnimCreator getAnimCreator() {
        RFWLayerInitBean rFWLayerInitBean = this.initBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        }
        int mTransAnimBeanCreatorId = rFWLayerInitBean.getMTransAnimBeanCreatorId();
        if (mTransAnimBeanCreatorId != 0) {
            return RFWTransitionHelper.INSTANCE.getTransitionBeanCreator(mTransAnimBeanCreatorId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getCurrentImageView(int position) {
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        if (viewPager2.getAdapter() instanceof RFWConcatAdapter) {
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            RecyclerView.Adapter adapter = viewPager22.getAdapter();
            if (adapter != null) {
                for (RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter2 : ((RFWConcatAdapter) adapter).getAdapters()) {
                    if (adapter2 instanceof RFWLayerGalleryAdapter) {
                        return ((RFWLayerGalleryAdapter) adapter2).getCurrentImageView(position);
                    }
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        if (viewPager23.getAdapter() instanceof RFWLayerGalleryAdapter) {
            ViewPager2 viewPager24 = this.viewPager;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            RecyclerView.Adapter adapter3 = viewPager24.getAdapter();
            if (adapter3 != null) {
                return ((RFWLayerGalleryAdapter) adapter3).getCurrentImageView(position);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.gallery.adapter.RFWLayerGalleryAdapter");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentMediaPicId() {
        RFWLayerPicInfo layerPicInfo;
        String picId;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (picId = layerPicInfo.getPicId()) == null) {
            return "";
        }
        return picId;
    }

    private final RectF getCurrentPicViewRect(ImageView imageView) {
        return new RectF(RFWImageUtil.getImageVisibleRect(imageView, imageView.getScaleType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILayerOperationInterceptor getOperationInterceptor() {
        return (ILayerOperationInterceptor) this.operationInterceptor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILayerOperationListener getOperationListener() {
        return (ILayerOperationListener) this.operationListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicLoader getPicLoader() {
        return (IPicLoader) this.picLoader.getValue();
    }

    private final int getRealScreenHeight() {
        boolean isInMultiWindowMode;
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(getContext()) + DisplayUtil.getTopHeight(getContext());
        if (getActivity() != null && Build.VERSION.SDK_INT >= 24) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return instantScreenHeight - DisplayUtil.getTopHeight(getContext());
            }
            return instantScreenHeight;
        }
        return instantScreenHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initAndStartAnim() {
        if (!this.hasInit) {
            ImageView imageView = this.tempImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tempImageView");
            }
            initDragFrameLayout(imageView);
            this.hasInit = true;
        }
        TransitionManager transitionManager = this.transitionManager;
        if (transitionManager == null) {
            resetVisibleAndBg();
            RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "not show anim");
        } else if (transitionManager != null) {
            transitionManager.startEnterAnim(new TransitionAnimator.OnAnimCallback() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$initAndStartAnim$1
                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimaUpdate(float value) {
                    RFWLayerAnimPart.this.updateBackgroundAlpha((int) (255 * value));
                    RFWLayerAnimPart.this.changeIgnoreViewAlpha(value);
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationCancel() {
                    RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "onAnimationEnd");
                    RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart.this;
                    rFWLayerAnimPart.changeAllViewPagerContentVisibility(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart), true);
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationEnd() {
                    String currentMediaPicId;
                    RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "onAnimationEnd");
                    RFWLayerAnimPart.this.resetVisibleAndBg();
                    RFWLayerAnimPart.this.showIgnoreView();
                    RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart.this;
                    UUID access$getTranUUID$p = RFWLayerAnimPart.access$getTranUUID$p(rFWLayerAnimPart);
                    currentMediaPicId = RFWLayerAnimPart.this.getCurrentMediaPicId();
                    rFWLayerAnimPart.updateOriginImageViewVisibility(access$getTranUUID$p, currentMediaPicId, false);
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationStart() {
                    String currentMediaPicId;
                    RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "onAnimationStart");
                    RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart.this;
                    rFWLayerAnimPart.changeAllViewPagerContentVisibility(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart), false);
                    RFWLayerAnimPart rFWLayerAnimPart2 = RFWLayerAnimPart.this;
                    rFWLayerAnimPart2.collectIgnoreViewExcludeTarget(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart2));
                    RFWLayerAnimPart.this.changeIgnoreViewAlpha(0.0f);
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    currentMediaPicId = RFWLayerAnimPart.this.getCurrentMediaPicId();
                    simpleEventBus.dispatchEvent(new RFWEnterAnimStateEvent(true, currentMediaPicId));
                }
            });
        }
    }

    private final void initDragFrameLayout(ImageView imageView) {
        boolean z16;
        RFWLayerInitBean rFWLayerInitBean = this.initBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        }
        this.animBean = rFWLayerInitBean.getTransitionBean();
        RFWTransAnimBean rFWTransAnimBean = this.animBean;
        if (rFWTransAnimBean != null) {
            z16 = rFWTransAnimBean.getIsCarvedAnimOpen();
        } else {
            z16 = false;
        }
        this.isCarvedAnimOpen = z16;
        if (this.animBean == null) {
            RFWLog.w(getTAG(), RFWLog.USR, "initDragFrameLayout mAnimBean == null, no open anim");
        } else {
            this.transitionManager = new TransitionManager();
            initStartAnim(imageView);
        }
    }

    private final void initStartAnim(ImageView imageView) {
        int measuredWidth;
        int measuredHeight;
        if (this.animBean == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "initStartAnim params error");
            return;
        }
        TransitionInitData transitionInitData = new TransitionInitData();
        TransitionAnimUtil transitionAnimUtil = TransitionAnimUtil.INSTANCE;
        UUID uuid = this.tranUUID;
        if (uuid == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
        }
        transitionInitData.setCoverDrawable(transitionAnimUtil.getTransViewAndDrawable(uuid).getCoverDrawable());
        RFWTransAnimBean rFWTransAnimBean = this.animBean;
        if (rFWTransAnimBean != null) {
            transitionInitData.setLayoutStartRect(new RectF(rFWTransAnimBean.getLayoutRect().getLeft(), rFWTransAnimBean.getLayoutRect().getTop(), rFWTransAnimBean.getLayoutRect().getRight(), rFWTransAnimBean.getLayoutRect().getBottom()));
            if (rFWTransAnimBean.getImageRect() != null) {
                transitionInitData.setImageStartRect(new RectF(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom()));
            }
            transitionInitData.setImageEndRect(getCurrentPicViewRect(imageView));
            transitionInitData.setFadeCoverTimeMs(rFWTransAnimBean.getFadeCoverTimeMs());
            transitionInitData.setTransitionDelayTimeMs(rFWTransAnimBean.getTransitionDelayTimeMs());
            transitionInitData.setTransitionAniDurationMs(rFWTransAnimBean.getTransitionDuration());
            transitionInitData.setStartScaleType(rFWTransAnimBean.getScaleType());
            transitionInitData.setBackgroundColor(-16777216);
            FrameLayout frameLayout = this.animRootLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
            }
            if (frameLayout.getMeasuredWidth() == 0) {
                measuredWidth = DisplayUtil.getInstantScreenWidth(getContext());
            } else {
                RFWDragLayout rFWDragLayout = this.dragLayout;
                if (rFWDragLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
                }
                measuredWidth = rFWDragLayout.getMeasuredWidth();
            }
            FrameLayout frameLayout2 = this.animRootLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
            }
            if (frameLayout2.getMeasuredHeight() == 0) {
                measuredHeight = getRealScreenHeight();
            } else {
                FrameLayout frameLayout3 = this.animRootLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
                }
                measuredHeight = frameLayout3.getMeasuredHeight();
            }
            int[] iArr = new int[2];
            FrameLayout frameLayout4 = this.animRootLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
            }
            frameLayout4.getLocationOnScreen(iArr);
            transitionInitData.setLayoutEndRect(new RectF(iArr[0], iArr[1], measuredWidth, measuredHeight));
            TransitionManager transitionManager = this.transitionManager;
            if (transitionManager != null) {
                FrameLayout frameLayout5 = this.animRootLayout;
                if (frameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
                }
                transitionManager.initCoverViewAndData(frameLayout5, transitionInitData);
            }
        }
    }

    private final boolean isOpenByActivity() {
        if (!(getActivity() instanceof CompatPublicActivity) && (getActivity() instanceof ComponentActivity)) {
            return true;
        }
        return false;
    }

    private final boolean isSameEnterAndExist() {
        String str;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            String str2 = this.enterMediaId;
            if (rFWLayerItemMediaInfo != null) {
                str = rFWLayerItemMediaInfo.getMediaId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetVisibleAndBg() {
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        changeAllViewPagerContentVisibility(viewPager2, true);
        updateBackgroundAlpha(255);
        SimpleEventBus.getInstance().dispatchEvent(new RFWEnterAnimStateEvent(false, getCurrentMediaPicId()));
    }

    private final void sendFinishHostEvent() {
        if (this.hasInformedFinish) {
            return;
        }
        this.hasInformedFinish = true;
        SimpleEventBus.getInstance().dispatchEvent(new RFWFinishHostEvent());
        UUID uuid = this.tranUUID;
        if (uuid == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
        }
        updateOriginImageViewVisibility(uuid, getCurrentMediaPicId(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExitAnim(final boolean needUpdateRect) {
        updateEnd(needUpdateRect);
        this.isInExitAnim = true;
        RFWDragLayout rFWDragLayout = this.dragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        }
        View targetDragView = rFWDragLayout.getTargetDragView();
        Intrinsics.checkNotNullExpressionValue(targetDragView, "dragLayout.targetDragView");
        final float scaleX = targetDragView.getScaleX();
        TransitionManager transitionManager = this.transitionManager;
        if (transitionManager != null) {
            transitionManager.startExitAnim(new TransitionAnimator.OnAnimCallback() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$showExitAnim$1
                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimaUpdate(float value) {
                    String currentMediaPicId;
                    if (value <= 0.01f) {
                        RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart.this;
                        UUID access$getTranUUID$p = RFWLayerAnimPart.access$getTranUUID$p(rFWLayerAnimPart);
                        currentMediaPicId = RFWLayerAnimPart.this.getCurrentMediaPicId();
                        rFWLayerAnimPart.updateOriginImageViewVisibility(access$getTranUUID$p, currentMediaPicId, true);
                    }
                    RFWLayerAnimPart.this.updateBackgroundAlpha((int) (255 * value * scaleX));
                    if (needUpdateRect) {
                        RFWLayerAnimPart.this.changeIgnoreViewAlpha(value * scaleX);
                    }
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationEnd() {
                    SimpleEventBus.getInstance().dispatchEvent(new RFWExitAnimStateEvent(false));
                    RFWLayerAnimPart.this.finishHost();
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationStart() {
                    SimpleEventBus.getInstance().dispatchEvent(new RFWExitAnimStateEvent(true));
                    if (needUpdateRect) {
                        RFWLayerAnimPart rFWLayerAnimPart = RFWLayerAnimPart.this;
                        rFWLayerAnimPart.collectIgnoreViewExcludeTarget(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart));
                    }
                    MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = RFWLayerAnimPart.this.getMLayerViewModel().mRichMediaInfo;
                    IPartHost partHost = RFWLayerAnimPart.this.getPartHost();
                    Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                    mutableLiveData.removeObservers(partHost.getLifecycleOwner());
                    RFWLayerAnimPart rFWLayerAnimPart2 = RFWLayerAnimPart.this;
                    rFWLayerAnimPart2.changeAllViewPagerContentVisibility(RFWLayerAnimPart.access$getViewPager$p(rFWLayerAnimPart2), false);
                }

                @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                public void onAnimationCancel() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showIgnoreView() {
        changeIgnoreViewAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimWithLoadImage(boolean hasCut, boolean isEmpty) {
        RFWLayerPicInfo rFWLayerPicInfo;
        String str;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo layerPicInfo2;
        RFWLayerInitBean rFWLayerInitBean = this.initBean;
        if (rFWLayerInitBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initBean");
        }
        RFWTransAnimBean transitionBean = rFWLayerInitBean.getTransitionBean();
        String str2 = null;
        if (transitionBean != null) {
            rFWLayerPicInfo = transitionBean.getLayerPicInfo();
        } else {
            rFWLayerPicInfo = null;
        }
        RFWLayerPicInfo.RFWPicInfo adjustPicInfo = getAdjustPicInfo(rFWLayerPicInfo, hasCut, isEmpty);
        if (adjustPicInfo == null) {
            resetVisibleAndBg();
            return;
        }
        Option cacheKey = Option.obtain().setUrl(adjustPicInfo.getUrl()).setLocalPath(adjustPicInfo.getLocalPath()).setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(adjustPicInfo.getLocalPath())).build());
        ImageView imageView = this.currentPicView;
        Intrinsics.checkNotNull(imageView);
        Option requestWidth = cacheKey.setRequestWidth(imageView.getWidth());
        ImageView imageView2 = this.currentPicView;
        Intrinsics.checkNotNull(imageView2);
        Option preferDecodeFormat = requestWidth.setRequestHeight(imageView2.getHeight()).setSizeFormat(SizeFormat.LE).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        Option extraData = preferDecodeFormat.setExtraData(RFWLayerImageLoader.getExtraData(rFWLayerItemMediaInfo, RFWLayerPicInfo.PicType.LARGE));
        ImageView imageView3 = this.tempImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tempImageView");
        }
        Option option = extraData.setTargetView(imageView3).setNeedShowLoadingDrawable(false);
        option.disableHardwareDecode();
        if (!hasCut) {
            RFWLayerInitBean rFWLayerInitBean2 = this.initBean;
            if (rFWLayerInitBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
            }
            RFWTransAnimBean transitionBean2 = rFWLayerInitBean2.getTransitionBean();
            if (transitionBean2 != null && (layerPicInfo2 = transitionBean2.getLayerPicInfo()) != null) {
                str = layerPicInfo2.getPicId();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNullExpressionValue(option, "option");
                RFWLayerInitBean rFWLayerInitBean3 = this.initBean;
                if (rFWLayerInitBean3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("initBean");
                }
                RFWTransAnimBean transitionBean3 = rFWLayerInitBean3.getTransitionBean();
                if (transitionBean3 != null && (layerPicInfo = transitionBean3.getLayerPicInfo()) != null) {
                    str2 = layerPicInfo.getPicId();
                }
                option.setGroupKey(new LibraGroupKey(str2));
            }
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        changeAllViewPagerContentVisibility(viewPager2, false);
        updateBackgroundAlpha(0);
        RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "start loadImage");
        IPicLoader picLoader = getPicLoader();
        if (picLoader != null) {
            picLoader.loadImage(option, new IPicLoadStateListener() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$startAnimWithLoadImage$1
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(@NotNull LoadState state, @NotNull Option option1) {
                    Runnable runnable;
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(option1, "option1");
                    RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "loadImage1 seq:" + option1.getSeq() + " state:" + state);
                    if (state.isFinish()) {
                        Handler mainHandler = RFWLayerAnimPart.this.getMainHandler();
                        runnable = RFWLayerAnimPart.this.loadTimeoutTask;
                        mainHandler.removeCallbacks(runnable);
                    }
                    if (state.isFinishSuccess()) {
                        RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "startAnim");
                        TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(RFWLayerAnimPart.access$getTranUUID$p(RFWLayerAnimPart.this)).saveCoverDrawable(RFWLayerAnimPart.access$getTempImageView$p(RFWLayerAnimPart.this).getDrawable());
                        RFWLayerAnimPart.this.initAndStartAnim();
                    } else if (state.isFinishError()) {
                        RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "isFinishError");
                        RFWLayerAnimPart.this.resetVisibleAndBg();
                    }
                }
            });
        }
        getMainHandler().postDelayed(this.loadTimeoutTask, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackgroundAlpha(int alpha) {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        Drawable background = rootView.getBackground();
        if (background != null) {
            background.setAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCurrentPicView(boolean needUpdateRect) {
        TransitionManager transitionManager;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        ImageView currentImageView = getCurrentImageView(viewPager2.getCurrentItem());
        this.currentPicView = currentImageView;
        if (currentImageView != null && (transitionManager = this.transitionManager) != null) {
            Intrinsics.checkNotNull(transitionManager);
            ImageView imageView = this.currentPicView;
            Intrinsics.checkNotNull(imageView);
            transitionManager.setCoverDrawable(imageView.getDrawable());
            if (needUpdateRect) {
                Rect rect = new Rect();
                ImageView imageView2 = this.currentPicView;
                Intrinsics.checkNotNull(imageView2);
                imageView2.getGlobalVisibleRect(rect);
                ImageView imageView3 = this.currentPicView;
                Intrinsics.checkNotNull(imageView3);
                RectF rectF = new RectF(RFWImageUtil.getImageVisibleRect(imageView3, imageView3.getScaleType()));
                TransitionManager transitionManager2 = this.transitionManager;
                Intrinsics.checkNotNull(transitionManager2);
                transitionManager2.updateEndAnimRect(rectF);
                return;
            }
            return;
        }
        RFWLog.e("RFWLayerAnimPart", RFWLog.USR, "updateCurrentPicView but current picView is null");
    }

    private final void updateEnd(boolean needUpdateRect) {
        updateCurrentPicView(needUpdateRect);
        if (this.currentPicView == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "updateEnd: mCurrentPicView is null");
            return;
        }
        if (this.transitionManager == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "updateEnd: mTransitionManager is null");
            return;
        }
        RFWDragLayout rFWDragLayout = this.dragLayout;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        }
        float scaleX = rFWDragLayout.getScaleX();
        ImageView imageView = this.currentPicView;
        Intrinsics.checkNotNull(imageView);
        imageView.getLocationInWindow(new int[2]);
        TransitionManager transitionManager = this.transitionManager;
        Intrinsics.checkNotNull(transitionManager);
        TransitionInitData transitionInitData = transitionManager.getTransitionInitData();
        Intrinsics.checkNotNull(transitionInitData);
        RectF rectF = new RectF(transitionInitData.getImageEndRect());
        float f16 = 2;
        float width = (rectF.width() / f16) + rectF.left;
        float height = (rectF.height() / f16) + rectF.top;
        RectF rectF2 = new RectF(width - ((rectF.width() / f16) * scaleX), height - ((rectF.height() / f16) * scaleX), width + ((rectF.width() / f16) * scaleX), height + ((rectF.height() / f16) * scaleX));
        RFWDragLayout rFWDragLayout2 = this.dragLayout;
        if (rFWDragLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        }
        float translationX = rFWDragLayout2.getTranslationX();
        RFWDragLayout rFWDragLayout3 = this.dragLayout;
        if (rFWDragLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        }
        rectF2.offset(translationX, rFWDragLayout3.getTranslationY());
        TransitionManager transitionManager2 = this.transitionManager;
        Intrinsics.checkNotNull(transitionManager2);
        transitionManager2.updateEndAnimRect(rectF2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void updateEnterRect(RFWTransAnimBean animBean) {
        RFWTransAnimBean.SourceRect imageRect;
        if (animBean != null && this.transitionManager != null && (imageRect = animBean.getImageRect()) != null) {
            RectF rectF = new RectF(imageRect.getLeft(), imageRect.getTop(), imageRect.getRight(), imageRect.getBottom());
            TransitionManager transitionManager = this.transitionManager;
            if (transitionManager != null) {
                transitionManager.updateStartAnimRect(rectF, rectF, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOriginImageViewVisibility(final UUID uuid, final String id5, final boolean isShow) {
        if (!this.isCarvedAnimOpen) {
            RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "carved anim is closed");
        } else {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$updateOriginImageViewVisibility$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i3;
                    RFWTransitionHelper.TransAnimCreator animCreator;
                    ImageView imageView;
                    if (isShow) {
                        i3 = 0;
                    } else {
                        i3 = 4;
                    }
                    WeakReference<ImageView> mWrfImageView = TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(RFWLayerAnimPart.access$getTranUUID$p(RFWLayerAnimPart.this)).getMWrfImageView();
                    if (mWrfImageView != null && (imageView = mWrfImageView.get()) != null) {
                        imageView.setVisibility(i3);
                    }
                    animCreator = RFWLayerAnimPart.this.getAnimCreator();
                    if (animCreator != null) {
                        animCreator.updateOriginContainer(uuid, id5, isShow);
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RFWLayerAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean onBackEvent = super.onBackEvent();
        if (!onBackEvent && canShowExitAnim()) {
            updateCurrentPicView(true);
            ImageView imageView = this.currentPicView;
            if (imageView instanceof RFWMatrixImageView) {
                if (imageView != null) {
                    if (Math.abs(((RFWMatrixImageView) imageView).getScale() - 1.0f) > 0.001f) {
                        ImageView imageView2 = this.currentPicView;
                        if (imageView2 != null) {
                            if (!((RFWMatrixImageView) imageView2).isAutoMagnified()) {
                                ImageView imageView3 = this.currentPicView;
                                if (imageView3 != null) {
                                    RFWMatrixImageView rFWMatrixImageView = (RFWMatrixImageView) imageView3;
                                    if (imageView3 != null) {
                                        rFWMatrixImageView.setScale(((RFWMatrixImageView) imageView3).getMinimumScale(), true);
                                        return true;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.matrix.RFWMatrixImageView");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.matrix.RFWMatrixImageView");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.matrix.RFWMatrixImageView");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.widget.matrix.RFWMatrixImageView");
                }
            }
            showExitAnim(true);
            return true;
        }
        if (this.mCurrentSelectedItem != null) {
            finishHost();
        }
        return onBackEvent;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        UUID randomUUID;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        Activity hostActivity = partHost.getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "partHost.hostActivity");
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) hostActivity.getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        if (rFWLayerInitBean != null) {
            this.initBean = rFWLayerInitBean;
            RFWTransAnimBean transitionBean = rFWLayerInitBean.getTransitionBean();
            if (transitionBean == null || (randomUUID = transitionBean.getUUid()) == null) {
                randomUUID = UUID.randomUUID();
                Intrinsics.checkNotNullExpressionValue(randomUUID, "UUID.randomUUID()");
            }
            this.tranUUID = randomUUID;
            RFWLayerInitBean rFWLayerInitBean2 = this.initBean;
            if (rFWLayerInitBean2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("initBean");
            }
            List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerInitBean2.getRichMediaDataList();
            if (richMediaDataList != null) {
                RFWLayerInitBean rFWLayerInitBean3 = this.initBean;
                if (rFWLayerInitBean3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("initBean");
                }
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = richMediaDataList.get(rFWLayerInitBean3.getEnterPos());
                if (rFWLayerItemMediaInfo != null) {
                    this.enterMediaInfo = rFWLayerItemMediaInfo;
                    this.enterMediaId = rFWLayerItemMediaInfo.getMediaId();
                    ViewGroup viewGroup = (ViewGroup) rootView;
                    View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169067hn4, viewGroup, false);
                    if (inflate != null) {
                        FrameLayout frameLayout = (FrameLayout) inflate;
                        this.animRootLayout = frameLayout;
                        View findViewById = frameLayout.findViewById(R.id.y9r);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "animRootLayout.findViewById(R.id.iv_temp)");
                        ImageView imageView = (ImageView) findViewById;
                        this.tempImageView = imageView;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tempImageView");
                        }
                        imageView.setLayerType(1, null);
                        FrameLayout frameLayout2 = this.animRootLayout;
                        if (frameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("animRootLayout");
                        }
                        viewGroup.addView(frameLayout2);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(new RFWLayerAnimPart$onInitView$1(this, rootView));
                        if (isOpenByActivity()) {
                            Activity activity = getActivity();
                            if (activity != null) {
                                OnBackPressedDispatcher onBackPressedDispatcher = ((ComponentActivity) activity).getOnBackPressedDispatcher();
                                IPartHost partHost2 = getPartHost();
                                Intrinsics.checkNotNullExpressionValue(partHost2, "partHost");
                                onBackPressedDispatcher.addCallback(partHost2.getLifecycleOwner(), this.onBackPressedCallback);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type androidx.activity.ComponentActivity");
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        sendFinishHostEvent();
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, androidx.lifecycle.Observer
    public void onChanged(@NotNull UIStateData<RFWLayerState> uiStateData) {
        final RFWTransitionHelper.TransAnimCreator animCreator;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.onChanged(uiStateData);
        if (uiStateData.getLatestModifyRecord() != null) {
            UIStateData.ModifyListRecord latestModifyRecord = uiStateData.getLatestModifyRecord();
            Intrinsics.checkNotNullExpressionValue(latestModifyRecord, "uiStateData.latestModifyRecord");
            if (latestModifyRecord.getModifyType() == 4 && this.isAfterPreDraw) {
                ViewPager2 viewPager2 = this.viewPager;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                }
                if (viewPager2.getVisibility() == 0 && (animCreator = getAnimCreator()) != null) {
                    RFWLayerItemMediaInfo selectedItemMedia = uiStateData.getData().getSelectedItemMedia();
                    if (selectedItemMedia == null) {
                        this.animBean = null;
                        RFWDragLayout rFWDragLayout = this.dragLayout;
                        if (rFWDragLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
                        }
                        rFWDragLayout.setFeatureEnable(false);
                        return;
                    }
                    this.mCurrentSelectedItem = selectedItemMedia;
                    RFWDragLayout rFWDragLayout2 = this.dragLayout;
                    if (rFWDragLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
                    }
                    ILayerOperationInterceptor operationInterceptor = getOperationInterceptor();
                    rFWDragLayout2.setFeatureEnable(operationInterceptor != null ? operationInterceptor.canDragClose() : true);
                    final RFWLayerPicInfo layerPicInfo = selectedItemMedia.getLayerPicInfo();
                    if (layerPicInfo != null) {
                        this.animBean = null;
                        UUID uuid = this.tranUUID;
                        if (uuid == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tranUUID");
                        }
                        String picId = layerPicInfo.getPicId();
                        if (picId == null) {
                            picId = "";
                        }
                        updateOriginImageViewVisibility(uuid, picId, true);
                        if (TextUtils.isEmpty(layerPicInfo.getPicId())) {
                            return;
                        }
                        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onChanged$$inlined$let$lambda$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                RFWLayerAnimPart rFWLayerAnimPart = this;
                                RFWTransitionHelper.TransAnimCreator transAnimCreator = animCreator;
                                UUID access$getTranUUID$p = RFWLayerAnimPart.access$getTranUUID$p(rFWLayerAnimPart);
                                String picId2 = RFWLayerPicInfo.this.getPicId();
                                Intrinsics.checkNotNull(picId2);
                                rFWLayerAnimPart.animBean = transAnimCreator.generateTransAnimBean(access$getTranUUID$p, picId2);
                                this.getMainHandler().post(new Runnable() { // from class: com.tencent.richframework.gallery.part.RFWLayerAnimPart$onChanged$$inlined$let$lambda$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        RFWTransAnimBean rFWTransAnimBean;
                                        RFWTransAnimBean rFWTransAnimBean2;
                                        RFWTransAnimBean rFWTransAnimBean3;
                                        rFWTransAnimBean = this.animBean;
                                        if (rFWTransAnimBean == null) {
                                            RFWLog.i("RFWLayerAnimPart", RFWLog.USR, "can't find mAnimBean");
                                        }
                                        rFWTransAnimBean2 = this.animBean;
                                        if (rFWTransAnimBean2 != null) {
                                            RFWLayerAnimPart rFWLayerAnimPart2 = this;
                                            UUID access$getTranUUID$p2 = RFWLayerAnimPart.access$getTranUUID$p(rFWLayerAnimPart2);
                                            String picId3 = RFWLayerPicInfo.this.getPicId();
                                            if (picId3 == null) {
                                                picId3 = "";
                                            }
                                            rFWLayerAnimPart2.updateOriginImageViewVisibility(access$getTranUUID$p2, picId3, false);
                                            RFWLayerAnimPart rFWLayerAnimPart3 = this;
                                            rFWTransAnimBean3 = rFWLayerAnimPart3.animBean;
                                            rFWLayerAnimPart3.updateEnterRect(rFWTransAnimBean3);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }
            }
        }
    }
}
