package com.tencent.richframework.gallery.item.section;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProviderKt;
import com.tencent.richframework.gallery.delegate.outer.InnerErrorInfo;
import com.tencent.richframework.gallery.event.RFWEnterAnimStateEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.matrix.OnDoubleTapListener;
import com.tencent.richframework.widget.matrix.OnScaleEndListener;
import com.tencent.richframework.widget.matrix.OnViewTapListener;
import com.tencent.richframework.widget.matrix.RFWMatrixImageView;
import com.tencent.richframework.widget.subscaleview.ImageSource;
import com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r01.c;

@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 r2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00020\b0\u0007:\u0001rB\u0007\u00a2\u0006\u0004\bp\u0010qJ\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J&\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0014J \u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'`(H\u0016J\u0012\u0010,\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\u000fH\u0002J\u0010\u00106\u001a\u00020\r2\u0006\u00105\u001a\u000204H\u0002J\u0010\u00109\u001a\u00020\r2\u0006\u00108\u001a\u000207H\u0002J\b\u0010:\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\rH\u0002J\u0012\u0010>\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010?\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010<H\u0002J\b\u0010@\u001a\u00020\u000fH\u0002R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010IR\u0018\u0010N\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001d\u0010X\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010cR\u0016\u0010g\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010cR\u001d\u0010l\u001a\u0004\u0018\u00010h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010U\u001a\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010o\u00a8\u0006s"}, d2 = {"Lcom/tencent/richframework/gallery/item/section/RFWLayerPicControlSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lcom/tencent/richframework/widget/matrix/OnViewTapListener;", "Lcom/tencent/richframework/widget/matrix/OnScaleEndListener;", "Lcom/tencent/richframework/widget/matrix/OnDoubleTapListener;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", "onViewRecycled", "data", "", "position", "", "", "payload", "onBindData", "view", "", HippyTKDListViewAdapter.X, "y", "onViewTap", "scaleFactor", "onScaleEnd", "onDoubleTap", "v", NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "picInfo", "existFile", "loadThumbOption", "loadCurrentPic", "Lcom/tencent/libra/request/Option;", "option", "isNeedToChangeRegionScale", "show", "showLoadingView", "Landroid/graphics/drawable/Animatable;", "animate", "setAnimate", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "modifyMaxScale", "magnifyMatrixViewIfNeeded", "magnifyRegionScaleViewIfNeeded", "", "enterPicId", "enterAnimStart", "enterAnimFinish", "preventMagnifySmallPicInfo", "Lcom/tencent/richframework/widget/matrix/RFWMatrixImageView;", "mIvPic", "Lcom/tencent/richframework/widget/matrix/RFWMatrixImageView;", "Lcom/tencent/richframework/widget/subscaleview/SubsamplingScaleImageView;", "mIvRegionScale", "Lcom/tencent/richframework/widget/subscaleview/SubsamplingScaleImageView;", "Landroid/widget/ImageView;", "mErrorPic", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "mTvErrorTip", "Landroid/widget/TextView;", "mLoadingIv", "mCurrentAnimate", "Landroid/graphics/drawable/Animatable;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Lcom/tencent/libra/IPicLoader;", "mPicLoader$delegate", "Lkotlin/Lazy;", "getMPicLoader", "()Lcom/tencent/libra/IPicLoader;", "mPicLoader", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "mMediaProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "mLayerPicOperationListener", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "mMediaShowStrategyProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "mIsEnterAnimStart", "Z", "mIsEnterAnimFinish", "mNeedZoomMatrixAfterAnimEnd", "mIsNeedToTryRegionScale", "mIsVisible", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "mLayerPicOperationInterceptor$delegate", "getMLayerPicOperationInterceptor", "()Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "mLayerPicOperationInterceptor", "Ljava/lang/Runnable;", "mShowErrorToastTask", "Ljava/lang/Runnable;", "<init>", "()V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerPicControlSection extends Section<RFWLayerItemMediaInfo> implements OnViewTapListener, OnScaleEndListener, OnDoubleTapListener, View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {
    private Animatable mCurrentAnimate;
    private ImageView mErrorPic;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsEnterAnimFinish;
    private boolean mIsEnterAnimStart;
    private boolean mIsNeedToTryRegionScale;
    private boolean mIsVisible;
    private RFWMatrixImageView mIvPic;
    private SubsamplingScaleImageView mIvRegionScale;

    /* renamed from: mLayerPicOperationInterceptor$delegate, reason: from kotlin metadata */
    private final Lazy mLayerPicOperationInterceptor;
    private ILayerOperationListener mLayerPicOperationListener;
    private ImageView mLoadingIv;
    private IMediaProvider mMediaProvider;
    private IMediaShowStrategyProvider mMediaShowStrategyProvider;
    private boolean mNeedZoomMatrixAfterAnimEnd;

    /* renamed from: mPicLoader$delegate, reason: from kotlin metadata */
    private final Lazy mPicLoader;
    private final Runnable mShowErrorToastTask;
    private TextView mTvErrorTip;

    public RFWLayerPicControlSection() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$mPicLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IPicLoader invoke() {
                View mRootView;
                mRootView = ((Section) RFWLayerPicControlSection.this).mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                return RFWLayerIOCUtil.getPicLoaderFromView(mRootView);
            }
        });
        this.mPicLoader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ILayerOperationInterceptor>() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$mLayerPicOperationInterceptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ILayerOperationInterceptor invoke() {
                View rootView = RFWLayerPicControlSection.this.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                return RFWLayerIOCUtil.getLayerOperationInterceptor(rootView);
            }
        });
        this.mLayerPicOperationInterceptor = lazy2;
        this.mShowErrorToastTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$mShowErrorToastTask$1
            @Override // java.lang.Runnable
            public final void run() {
                IMediaShowStrategyProvider iMediaShowStrategyProvider;
                iMediaShowStrategyProvider = RFWLayerPicControlSection.this.mMediaShowStrategyProvider;
                if (iMediaShowStrategyProvider != null) {
                    RFWLayerItemMediaInfo mData = RFWLayerPicControlSection.access$getMData$p(RFWLayerPicControlSection.this);
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    iMediaShowStrategyProvider.doOnVisible(mData);
                }
                RFWLayerPicControlSection.this.showLoadingView(false);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RFWLayerItemMediaInfo access$getMData$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        return (RFWLayerItemMediaInfo) rFWLayerPicControlSection.mData;
    }

    public static final /* synthetic */ ImageView access$getMErrorPic$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        ImageView imageView = rFWLayerPicControlSection.mErrorPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
        }
        return imageView;
    }

    public static final /* synthetic */ RFWMatrixImageView access$getMIvPic$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        RFWMatrixImageView rFWMatrixImageView = rFWLayerPicControlSection.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        return rFWMatrixImageView;
    }

    public static final /* synthetic */ SubsamplingScaleImageView access$getMIvRegionScale$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        SubsamplingScaleImageView subsamplingScaleImageView = rFWLayerPicControlSection.mIvRegionScale;
        if (subsamplingScaleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
        }
        return subsamplingScaleImageView;
    }

    public static final /* synthetic */ ImageView access$getMLoadingIv$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        ImageView imageView = rFWLayerPicControlSection.mLoadingIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIv");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView access$getMTvErrorTip$p(RFWLayerPicControlSection rFWLayerPicControlSection) {
        TextView textView = rFWLayerPicControlSection.mTvErrorTip;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvErrorTip");
        }
        return textView;
    }

    private final void enterAnimFinish(String enterPicId) {
        this.mIsEnterAnimFinish = true;
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.getIsSupportMagnifyLongPic()) {
            if (this.mIsNeedToTryRegionScale) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "still need to try region scale");
                    return;
                }
                return;
            }
            if (preventMagnifySmallPicInfo()) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "[enterAnimFinish] small pic info, no need to magnify");
                }
            } else if (!this.mNeedZoomMatrixAfterAnimEnd) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "mNeedZoomMatrixAfterAnimEnd is false");
                }
            } else {
                this.mNeedZoomMatrixAfterAnimEnd = false;
                RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
                if (rFWMatrixImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                rFWMatrixImageView.tryMagnifyLongPic(this.mIsVisible);
            }
        }
    }

    private final void enterAnimStart(String enterPicId) {
        this.mIsEnterAnimStart = true;
    }

    private final boolean existFile(RFWLayerPicInfo.RFWPicInfo picInfo) {
        if (picInfo != null && RFWFileUtils.fileExists(picInfo.getLocalPath())) {
            return true;
        }
        return false;
    }

    private final ILayerOperationInterceptor getMLayerPicOperationInterceptor() {
        return (ILayerOperationInterceptor) this.mLayerPicOperationInterceptor.getValue();
    }

    private final IPicLoader getMPicLoader() {
        return (IPicLoader) this.mPicLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isNeedToChangeRegionScale(Option option, RFWLayerItemMediaInfo data) {
        IMediaShowStrategyProvider iMediaShowStrategyProvider;
        boolean z16 = false;
        this.mIsNeedToTryRegionScale = false;
        if (option.getResultBitMap() == null) {
            return this.mIsNeedToTryRegionScale;
        }
        if (option.getResultBitMap() != null && (iMediaShowStrategyProvider = this.mMediaShowStrategyProvider) != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            if (iMediaShowStrategyProvider.isSupportRegionScale(option, (RFWLayerItemMediaInfo) mData)) {
                z16 = true;
            }
        }
        this.mIsNeedToTryRegionScale = z16;
        return z16;
    }

    private final void loadCurrentPic(final RFWLayerItemMediaInfo data) {
        SizeFormat sizeFormat;
        RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        final Option reqOption = RFWLayerImageLoader.getReqOption(data, rFWMatrixImageView, IMediaShowStrategyProviderKt.getPicShowDecodeFormat(this.mMediaShowStrategyProvider));
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.disableRotate(data)) {
            reqOption.disableRotate();
        }
        IMediaShowStrategyProvider iMediaShowStrategyProvider2 = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider2 != null && (sizeFormat = iMediaShowStrategyProvider2.getSizeFormat()) != null) {
            reqOption.setSizeFormat(sizeFormat);
        }
        SubsamplingScaleImageView subsamplingScaleImageView = this.mIvRegionScale;
        if (subsamplingScaleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
        }
        subsamplingScaleImageView.setVisibility(8);
        IPicLoader mPicLoader = getMPicLoader();
        if (mPicLoader != null) {
            mPicLoader.loadImage(reqOption, new IPicLoadStateListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$loadCurrentPic$2
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(@NotNull LoadState state, @NotNull final Option option) {
                    String tag;
                    IMediaShowStrategyProvider iMediaShowStrategyProvider3;
                    ErrorUIConfig needShowErrorUI;
                    boolean z16;
                    String tag2;
                    boolean z17;
                    Handler handler;
                    Runnable runnable;
                    String tag3;
                    boolean isNeedToChangeRegionScale;
                    IMediaShowStrategyProvider iMediaShowStrategyProvider4;
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(option, "option");
                    if (state.isFinish()) {
                        RFWLayerPicControlSection.this.showLoadingView(false);
                    }
                    if (state.isFinishSuccess()) {
                        isNeedToChangeRegionScale = RFWLayerPicControlSection.this.isNeedToChangeRegionScale(option, data);
                        if (reqOption.getAnimatable() != null) {
                            RFWLayerPicControlSection rFWLayerPicControlSection = RFWLayerPicControlSection.this;
                            Animatable animatable = reqOption.getAnimatable();
                            Intrinsics.checkNotNullExpressionValue(animatable, "reqOption.animatable");
                            rFWLayerPicControlSection.setAnimate(animatable);
                        } else if (reqOption.getResultBitMap() != null) {
                            RFWLayerPicControlSection rFWLayerPicControlSection2 = RFWLayerPicControlSection.this;
                            Bitmap resultBitMap = reqOption.getResultBitMap();
                            Intrinsics.checkNotNullExpressionValue(resultBitMap, "reqOption.resultBitMap");
                            rFWLayerPicControlSection2.modifyMaxScale(resultBitMap);
                        }
                        ImageSource uri = ImageSource.uri(option.getLocalPath());
                        Intrinsics.checkNotNullExpressionValue(uri, "ImageSource.uri(option.localPath)");
                        boolean isLoadSameImage = RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).isLoadSameImage(uri);
                        if (RFWLog.isColorLevel()) {
                            RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "loadSameImage is " + isLoadSameImage + ", needToChangeRegionScale is " + isNeedToChangeRegionScale + ", isReady " + RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).isReady());
                        }
                        if (isLoadSameImage && isNeedToChangeRegionScale && RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).isReady()) {
                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(0);
                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(8);
                            RFWLayerPicControlSection.this.magnifyRegionScaleViewIfNeeded();
                        } else if (isNeedToChangeRegionScale) {
                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setScaleLockState(true);
                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(0);
                            iMediaShowStrategyProvider4 = RFWLayerPicControlSection.this.mMediaShowStrategyProvider;
                            if (iMediaShowStrategyProvider4 != null) {
                                RFWLayerItemMediaInfo mData = RFWLayerPicControlSection.access$getMData$p(RFWLayerPicControlSection.this);
                                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                                if (iMediaShowStrategyProvider4.disableRotate(mData)) {
                                    RFWLog.i("RFWLayerPicControlSection", RFWLog.USR, "business config not rotate pic");
                                    RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setOrientationConfig(0);
                                    RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setOnImageEventListener(new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$loadCurrentPic$2.2
                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onImageLoadError(@NotNull Exception e16) {
                                            String str;
                                            Intrinsics.checkNotNullParameter(e16, "e");
                                            int i3 = RFWLog.USR;
                                            Object[] objArr = new Object[1];
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("not support region decode, exception is ");
                                            sb5.append(e16);
                                            sb5.append(", seq = ");
                                            sb5.append(option.getSeq());
                                            sb5.append(", picId = ");
                                            RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
                                            if (layerPicInfo == null || (str = layerPicInfo.getPicId()) == null) {
                                                str = "";
                                            }
                                            sb5.append(str);
                                            sb5.append(", file type = ");
                                            sb5.append(RFWFileUtils.getFileType(option.getLocalPath()));
                                            objArr[0] = sb5.toString();
                                            RFWLog.e("RFWLayerPicControlSection", i3, objArr);
                                            RFWLayerPicControlSection.this.mIsNeedToTryRegionScale = false;
                                            RFWLayerPicControlSection.this.magnifyMatrixViewIfNeeded();
                                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(0);
                                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setScaleLockState(false);
                                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(8);
                                        }

                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onPreviewLoadError(@NotNull Exception e16) {
                                            Intrinsics.checkNotNullParameter(e16, "e");
                                        }

                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onReady() {
                                            RFWLog.i("RFWLayerPicControlSection", RFWLog.USR, "seq = " + option.getSeq() + " onReady");
                                            RFWLayerPicControlSection.this.magnifyRegionScaleViewIfNeeded();
                                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(8);
                                            RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setScaleLockState(false);
                                        }

                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onTileLoadError(@NotNull Exception e16) {
                                            Intrinsics.checkNotNullParameter(e16, "e");
                                        }

                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onImageLoaded() {
                                        }

                                        @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                        public void onPreviewReleased() {
                                        }
                                    });
                                    SubsamplingScaleImageView access$getMIvRegionScale$p = RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this);
                                    Bitmap resultBitMap2 = option.getResultBitMap();
                                    Intrinsics.checkNotNullExpressionValue(resultBitMap2, "option.resultBitMap");
                                    int width = resultBitMap2.getWidth();
                                    Bitmap resultBitMap3 = option.getResultBitMap();
                                    Intrinsics.checkNotNullExpressionValue(resultBitMap3, "option.resultBitMap");
                                    access$getMIvRegionScale$p.setImage(uri.dimensions(width, resultBitMap3.getHeight()));
                                }
                            }
                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setOrientationConfig(-1);
                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setOnImageEventListener(new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$loadCurrentPic$2.2
                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onImageLoadError(@NotNull Exception e16) {
                                    String str;
                                    Intrinsics.checkNotNullParameter(e16, "e");
                                    int i3 = RFWLog.USR;
                                    Object[] objArr = new Object[1];
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("not support region decode, exception is ");
                                    sb5.append(e16);
                                    sb5.append(", seq = ");
                                    sb5.append(option.getSeq());
                                    sb5.append(", picId = ");
                                    RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
                                    if (layerPicInfo == null || (str = layerPicInfo.getPicId()) == null) {
                                        str = "";
                                    }
                                    sb5.append(str);
                                    sb5.append(", file type = ");
                                    sb5.append(RFWFileUtils.getFileType(option.getLocalPath()));
                                    objArr[0] = sb5.toString();
                                    RFWLog.e("RFWLayerPicControlSection", i3, objArr);
                                    RFWLayerPicControlSection.this.mIsNeedToTryRegionScale = false;
                                    RFWLayerPicControlSection.this.magnifyMatrixViewIfNeeded();
                                    RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(0);
                                    RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setScaleLockState(false);
                                    RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(8);
                                }

                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onPreviewLoadError(@NotNull Exception e16) {
                                    Intrinsics.checkNotNullParameter(e16, "e");
                                }

                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onReady() {
                                    RFWLog.i("RFWLayerPicControlSection", RFWLog.USR, "seq = " + option.getSeq() + " onReady");
                                    RFWLayerPicControlSection.this.magnifyRegionScaleViewIfNeeded();
                                    RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(8);
                                    RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setScaleLockState(false);
                                }

                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onTileLoadError(@NotNull Exception e16) {
                                    Intrinsics.checkNotNullParameter(e16, "e");
                                }

                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onImageLoaded() {
                                }

                                @Override // com.tencent.richframework.widget.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                                public void onPreviewReleased() {
                                }
                            });
                            SubsamplingScaleImageView access$getMIvRegionScale$p2 = RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this);
                            Bitmap resultBitMap22 = option.getResultBitMap();
                            Intrinsics.checkNotNullExpressionValue(resultBitMap22, "option.resultBitMap");
                            int width2 = resultBitMap22.getWidth();
                            Bitmap resultBitMap32 = option.getResultBitMap();
                            Intrinsics.checkNotNullExpressionValue(resultBitMap32, "option.resultBitMap");
                            access$getMIvRegionScale$p2.setImage(uri.dimensions(width2, resultBitMap32.getHeight()));
                        } else {
                            RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(8);
                        }
                    } else if (state.isFinishError()) {
                        tag = RFWLayerPicControlSection.this.getTAG();
                        RFWLog.e(tag, RFWLog.USR, "finishError: hashCode:" + RFWLayerPicControlSection.this.hashCode());
                        RFWLayerPicControlSection.access$getMIvRegionScale$p(RFWLayerPicControlSection.this).setVisibility(8);
                        iMediaShowStrategyProvider3 = RFWLayerPicControlSection.this.mMediaShowStrategyProvider;
                        if (iMediaShowStrategyProvider3 != null && (needShowErrorUI = iMediaShowStrategyProvider3.needShowErrorUI(data, new InnerErrorInfo(-1))) != null) {
                            if (RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).getDrawable() != null) {
                                z16 = RFWLayerPicControlSection.this.mIsVisible;
                                if (z16) {
                                    handler = RFWLayerPicControlSection.this.mHandler;
                                    runnable = RFWLayerPicControlSection.this.mShowErrorToastTask;
                                    handler.post(runnable);
                                }
                                tag2 = RFWLayerPicControlSection.this.getTAG();
                                int i3 = RFWLog.USR;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("IvPic src is not empty, ");
                                sb5.append("showError toast if visible:");
                                z17 = RFWLayerPicControlSection.this.mIsVisible;
                                sb5.append(z17);
                                RFWLog.e(tag2, i3, sb5.toString());
                            } else {
                                RFWLayerPicControlSection.access$getMErrorPic$p(RFWLayerPicControlSection.this).setImageDrawable(needShowErrorUI.getErrorDrawable());
                                RFWLayerPicControlSection.access$getMTvErrorTip$p(RFWLayerPicControlSection.this).setText(needShowErrorUI.getErrorTip());
                                RFWLayerPicControlSection.access$getMErrorPic$p(RFWLayerPicControlSection.this).setVisibility(0);
                                RFWLayerPicControlSection.access$getMTvErrorTip$p(RFWLayerPicControlSection.this).setVisibility(0);
                                RFWLayerPicControlSection.access$getMIvPic$p(RFWLayerPicControlSection.this).setVisibility(8);
                                tag3 = RFWLayerPicControlSection.this.getTAG();
                                RFWLog.e(tag3, RFWLog.USR, "IvPic src is empty, showErrorUI");
                            }
                        }
                    }
                    RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo);
                    if (!TextUtils.isEmpty(layerPicInfo.getPicId())) {
                        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                        RFWLayerPicInfo layerPicInfo2 = data.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo2);
                        String picId = layerPicInfo2.getPicId();
                        Intrinsics.checkNotNull(picId);
                        RFWLayerPicInfo layerPicInfo3 = data.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo3);
                        rFWLayerDataCenter.initOrUpdateGlobalState((RFWLayerDataCenter) new RFWLayerPicLoadState(picId, layerPicInfo3.getCurrentPicInfo(), state), true);
                    }
                }
            });
        }
    }

    private final void loadThumbOption(RFWLayerItemMediaInfo data) {
        String existSaveOrEditPath = data.getExistSaveOrEditPath();
        if (existSaveOrEditPath != null) {
            Option needShowLoadingDrawable = Option.obtain().setUrl(existSaveOrEditPath).setLocalPath(existSaveOrEditPath).setNeedShowLoadingDrawable(false);
            RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
            if (rFWMatrixImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            Option cacheKey = needShowLoadingDrawable.setTargetView(rFWMatrixImageView).setPreferDecodeFormat(IMediaShowStrategyProviderKt.getPicShowDecodeFormat(this.mMediaShowStrategyProvider)).setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(existSaveOrEditPath)).build());
            IPicLoader mPicLoader = getMPicLoader();
            if (mPicLoader != null) {
                mPicLoader.loadImage(cacheKey, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void magnifyMatrixViewIfNeeded() {
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.getIsSupportMagnifyLongPic()) {
            if (preventMagnifySmallPicInfo()) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "small pic info, no need to magnify");
                    return;
                }
                return;
            }
            if (RFWLog.isColorLevel()) {
                RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "hashCode: " + hashCode() + " mIsEnterAnimStart: " + this.mIsEnterAnimStart + " mIsEnterAnimFinish:" + this.mIsEnterAnimFinish);
            }
            if (this.mIsEnterAnimStart && !this.mIsEnterAnimFinish) {
                this.mNeedZoomMatrixAfterAnimEnd = true;
                return;
            }
            this.mNeedZoomMatrixAfterAnimEnd = false;
            RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
            if (rFWMatrixImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            rFWMatrixImageView.tryMagnifyLongPic(this.mIsVisible);
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "magnify long pic switch is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void magnifyRegionScaleViewIfNeeded() {
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.getIsSupportMagnifyLongPic()) {
            if (preventMagnifySmallPicInfo()) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "small pic info, no need to magnify");
                    return;
                }
                return;
            }
            if (RFWLog.isColorLevel()) {
                RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "magnifyRegionScaleView now  " + hashCode());
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.mIvRegionScale;
            if (subsamplingScaleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
            }
            subsamplingScaleImageView.tryMagnifyLongPic(this.mIsVisible);
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "magnify long pic switch is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void modifyMaxScale(Bitmap bitmap) {
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            float screenWidth = ImmersiveUtils.getScreenWidth() / (((ImmersiveUtils.getScreenHeight() * 1.0f) / bitmap.getHeight()) * bitmap.getWidth());
            float f16 = 0.618f * screenWidth;
            if (f16 > 1) {
                RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
                if (rFWMatrixImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                rFWMatrixImageView.setScaleLevels(1.0f, f16, screenWidth);
            } else {
                RFWMatrixImageView rFWMatrixImageView2 = this.mIvPic;
                if (rFWMatrixImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                rFWMatrixImageView2.setScaleLevels(1.0f, 1.75f, 3.5f);
            }
            if (this.mIsNeedToTryRegionScale) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "need to try region scale");
                }
            } else {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("RFWLayerPicControlSection", RFWLog.CLR, "modifyMaxScale, magnifyMatrixViewIfNeeded");
                }
                magnifyMatrixViewIfNeeded();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean preventMagnifySmallPicInfo() {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2;
        IMediaShowStrategyProvider iMediaShowStrategyProvider;
        RFWLayerPicInfo layerPicInfo = ((RFWLayerItemMediaInfo) this.mData).getLayerPicInfo();
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = null;
        if (layerPicInfo != null) {
            rFWPicInfo = layerPicInfo.getCurrentPicInfo();
        } else {
            rFWPicInfo = null;
        }
        RFWLayerPicInfo layerPicInfo2 = ((RFWLayerItemMediaInfo) this.mData).getLayerPicInfo();
        if (layerPicInfo2 != null) {
            rFWPicInfo2 = layerPicInfo2.getSmallPicInfo();
        } else {
            rFWPicInfo2 = null;
        }
        if (Intrinsics.areEqual(rFWPicInfo, rFWPicInfo2)) {
            RFWLayerPicInfo layerPicInfo3 = ((RFWLayerItemMediaInfo) this.mData).getLayerPicInfo();
            if (layerPicInfo3 != null) {
                rFWPicInfo3 = layerPicInfo3.getBigPicInfo();
            }
            if (rFWPicInfo3 == null && ((iMediaShowStrategyProvider = this.mMediaShowStrategyProvider) == null || !iMediaShowStrategyProvider.enableAutoMagnifyExternalSmallPic())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimate(Animatable animate) {
        this.mCurrentAnimate = animate;
        RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView.setScaleLevels(1.0f, 1.5f, 2.0f);
        Animatable animatable = this.mCurrentAnimate;
        if (animatable instanceof c) {
            if (animatable != null) {
                ((c) animatable).setLoopCount(32767);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.libra.base.LibraAnimatable");
            }
        }
        Animatable animatable2 = this.mCurrentAnimate;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingView(final boolean show) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerPicControlSection$showLoadingView$1
            @Override // java.lang.Runnable
            public final void run() {
                IMediaShowStrategyProvider iMediaShowStrategyProvider;
                IMediaShowStrategyProvider iMediaShowStrategyProvider2;
                Drawable drawable;
                if (!show) {
                    RFWLayerPicControlSection.access$getMLoadingIv$p(RFWLayerPicControlSection.this).setVisibility(8);
                    return;
                }
                if (RFWLayerPicControlSection.access$getMLoadingIv$p(RFWLayerPicControlSection.this).getDrawable() == null) {
                    iMediaShowStrategyProvider = RFWLayerPicControlSection.this.mMediaShowStrategyProvider;
                    if (iMediaShowStrategyProvider != null) {
                        ImageView access$getMLoadingIv$p = RFWLayerPicControlSection.access$getMLoadingIv$p(RFWLayerPicControlSection.this);
                        iMediaShowStrategyProvider2 = RFWLayerPicControlSection.this.mMediaShowStrategyProvider;
                        if (iMediaShowStrategyProvider2 != null) {
                            drawable = iMediaShowStrategyProvider2.getLoadingDrawable();
                        } else {
                            drawable = null;
                        }
                        access$getMLoadingIv$p.setImageDrawable(drawable);
                    }
                }
                RFWLayerPicControlSection.access$getMLoadingIv$p(RFWLayerPicControlSection.this).setVisibility(0);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RFWEnterAnimStateEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<? extends Object>) list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        IMediaShowStrategyProvider iMediaShowStrategyProvider;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f73993v2 && (iMediaShowStrategyProvider = this.mMediaShowStrategyProvider) != null && iMediaShowStrategyProvider.clickPicCloseHost()) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.mIvRegionScale;
            if (subsamplingScaleImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
            }
            subsamplingScaleImageView.resetScaleAndCenter();
            Context context = v3.getContext();
            if (!(context instanceof ComponentActivity)) {
                context = null;
            }
            ComponentActivity componentActivity = (ComponentActivity) context;
            if (componentActivity != null) {
                componentActivity.onBackPressed();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.richframework.widget.matrix.OnDoubleTapListener
    public void onDoubleTap() {
        ILayerOperationInterceptor mLayerPicOperationInterceptor = getMLayerPicOperationInterceptor();
        if (mLayerPicOperationInterceptor != null && mLayerPicOperationInterceptor.canDoubleClick()) {
            return;
        }
        RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView.setIsAutoMagnified(false);
        ILayerOperationListener iLayerOperationListener = this.mLayerPicOperationListener;
        if (iLayerOperationListener != null) {
            iLayerOperationListener.onDoubleClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        SimpleEventBus.getInstance().registerReceiver(this);
        View findViewById = containerView.findViewById(R.id.f73983v1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.rfw_layer_iv_pic)");
        this.mIvPic = (RFWMatrixImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f73993v2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026R.id.rfw_layer_iv_region)");
        this.mIvRegionScale = (SubsamplingScaleImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f73973v0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026(R.id.rfw_layer_iv_error)");
        this.mErrorPic = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f74013v4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026(R.id.rfw_layer_tv_error)");
        this.mTvErrorTip = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f74003v3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.id.rfw_layer_loading_iv)");
        this.mLoadingIv = (ImageView) findViewById5;
        RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView imageView = this.mLoadingIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingIv");
        }
        imageView.setVisibility(8);
        RFWMatrixImageView rFWMatrixImageView2 = this.mIvPic;
        if (rFWMatrixImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView2.setOnViewTapListener(this);
        SubsamplingScaleImageView subsamplingScaleImageView = this.mIvRegionScale;
        if (subsamplingScaleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
        }
        subsamplingScaleImageView.setOnClickListener(this);
        SubsamplingScaleImageView subsamplingScaleImageView2 = this.mIvRegionScale;
        if (subsamplingScaleImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
        }
        subsamplingScaleImageView2.setDoubleTapZoomScale(1.0f);
        SubsamplingScaleImageView subsamplingScaleImageView3 = this.mIvRegionScale;
        if (subsamplingScaleImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvRegionScale");
        }
        subsamplingScaleImageView3.setImportantForAccessibility(2);
        IMediaShowStrategyProvider picShowStrategy = RFWLayerIOCUtil.getPicShowStrategy(containerView);
        this.mMediaShowStrategyProvider = picShowStrategy;
        if (Build.VERSION.SDK_INT < 24) {
            SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.ARGB_8888);
        } else {
            DecodeFormat picShowDecodeFormat = IMediaShowStrategyProviderKt.getPicShowDecodeFormat(picShowStrategy);
            if (picShowDecodeFormat == DecodeFormat.PREFER_RGB_565) {
                SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.RGB_565);
            } else if (picShowDecodeFormat == DecodeFormat.PREFER_ARGB_8888) {
                SubsamplingScaleImageView.setPreferredBitmapConfig(Bitmap.Config.ARGB_8888);
            }
        }
        this.mMediaProvider = RFWLayerIOCUtil.getMediaProvider(containerView);
        this.mLayerPicOperationListener = RFWLayerIOCUtil.getLayerOperationListener(containerView);
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.useSoftLayerType()) {
            RFWMatrixImageView rFWMatrixImageView3 = this.mIvPic;
            if (rFWMatrixImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            rFWMatrixImageView3.setLayerType(1, null);
        }
        RFWMatrixImageView rFWMatrixImageView4 = this.mIvPic;
        if (rFWMatrixImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView4.setOnScaleEndListener(this);
        RFWMatrixImageView rFWMatrixImageView5 = this.mIvPic;
        if (rFWMatrixImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView5.setOnDoubleTapListener(this);
        IMediaShowStrategyProvider iMediaShowStrategyProvider2 = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider2 != null && iMediaShowStrategyProvider2.getAddWhiteColorFilter()) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.DST_ATOP);
            RFWMatrixImageView rFWMatrixImageView6 = this.mIvPic;
            if (rFWMatrixImageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            rFWMatrixImageView6.setColorFilter(porterDuffColorFilter);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RFWEnterAnimStateEvent) {
            RFWEnterAnimStateEvent rFWEnterAnimStateEvent = (RFWEnterAnimStateEvent) event;
            if (rFWEnterAnimStateEvent.isStart()) {
                enterAnimStart(rFWEnterAnimStateEvent.getPicId());
            } else {
                enterAnimFinish(rFWEnterAnimStateEvent.getPicId());
            }
        }
    }

    @Override // com.tencent.richframework.widget.matrix.OnScaleEndListener
    public void onScaleEnd(float scaleFactor) {
        ILayerOperationListener iLayerOperationListener = this.mLayerPicOperationListener;
        if (iLayerOperationListener != null) {
            iLayerOperationListener.onZoomScaleChangeEnd();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onViewRecycled() {
        RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
        if (rFWMatrixImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView.setImageDrawable(null);
        ImageView imageView = this.mErrorPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
        }
        imageView.setImageDrawable(null);
        ImageView imageView2 = this.mErrorPic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
        }
        imageView2.setVisibility(8);
    }

    @Override // com.tencent.richframework.widget.matrix.OnViewTapListener
    public void onViewTap(@NotNull View view, float x16, float y16) {
        Intrinsics.checkNotNullParameter(view, "view");
        RFWLayerIOCUtil rFWLayerIOCUtil = RFWLayerIOCUtil.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Context activityContext = rFWLayerIOCUtil.getActivityContext(context);
        if (activityContext instanceof Activity) {
            ILayerOperationInterceptor mLayerPicOperationInterceptor = getMLayerPicOperationInterceptor();
            if (mLayerPicOperationInterceptor != null && mLayerPicOperationInterceptor.canSingleClick()) {
                return;
            }
            if (this.mIvPic == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            BigDecimal valueOf = BigDecimal.valueOf(r5.getScale());
            if (this.mIvPic == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            if (!Intrinsics.areEqual(valueOf, BigDecimal.valueOf(r1.getMinimumScale()))) {
                RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
                if (rFWMatrixImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                if (!rFWMatrixImageView.isAutoMagnified()) {
                    ILayerOperationListener iLayerOperationListener = this.mLayerPicOperationListener;
                    if (iLayerOperationListener != null) {
                        iLayerOperationListener.onSingleClick(false);
                    }
                    RFWMatrixImageView rFWMatrixImageView2 = this.mIvPic;
                    if (rFWMatrixImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                    }
                    RFWMatrixImageView rFWMatrixImageView3 = this.mIvPic;
                    if (rFWMatrixImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                    }
                    rFWMatrixImageView2.setScale(rFWMatrixImageView3.getMinimumScale(), true);
                    return;
                }
            }
            ILayerOperationListener iLayerOperationListener2 = this.mLayerPicOperationListener;
            if (iLayerOperationListener2 != null) {
                iLayerOperationListener2.onSingleClick(true);
            }
            IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
            if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.clickPicCloseHost()) {
                if (!(activityContext instanceof ComponentActivity)) {
                    activityContext = null;
                }
                ComponentActivity componentActivity = (ComponentActivity) activityContext;
                if (componentActivity != null) {
                    componentActivity.onBackPressed();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        this.mIsVisible = visible;
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        ErrorUIConfig errorUIConfig = null;
        if (iMediaShowStrategyProvider != null) {
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            errorUIConfig = iMediaShowStrategyProvider.needShowErrorUI((RFWLayerItemMediaInfo) mData, null);
        }
        if (errorUIConfig != null) {
            this.mHandler.removeCallbacks(this.mShowErrorToastTask);
            if (visible) {
                this.mHandler.postDelayed(this.mShowErrorToastTask, 500L);
                return;
            }
            return;
        }
        Animatable animatable = this.mCurrentAnimate;
        if (animatable != null) {
            if (visible && !animatable.isRunning()) {
                animatable.start();
            } else if (!visible && animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(@NotNull RFWLayerItemMediaInfo data, int position, @NotNull List<? extends Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payload, "payload");
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        ErrorUIConfig needShowErrorUI = iMediaShowStrategyProvider != null ? iMediaShowStrategyProvider.needShowErrorUI(data, null) : null;
        if (needShowErrorUI != null) {
            RFWMatrixImageView rFWMatrixImageView = this.mIvPic;
            if (rFWMatrixImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            rFWMatrixImageView.setVisibility(8);
            needShowErrorUI.getErrorDrawable();
            ImageView imageView = this.mErrorPic;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
            }
            imageView.setImageDrawable(needShowErrorUI.getErrorDrawable());
            ImageView imageView2 = this.mErrorPic;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
            }
            imageView2.setVisibility(0);
            if (!TextUtils.isEmpty(needShowErrorUI.getErrorTip())) {
                TextView textView = this.mTvErrorTip;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvErrorTip");
                }
                textView.setText(needShowErrorUI.getErrorTip());
                TextView textView2 = this.mTvErrorTip;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvErrorTip");
                }
                textView2.setVisibility(0);
                return;
            }
            TextView textView3 = this.mTvErrorTip;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvErrorTip");
            }
            textView3.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.mErrorPic;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorPic");
        }
        imageView3.setVisibility(8);
        TextView textView4 = this.mTvErrorTip;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvErrorTip");
        }
        textView4.setVisibility(8);
        RFWMatrixImageView rFWMatrixImageView2 = this.mIvPic;
        if (rFWMatrixImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView2.setVisibility(0);
        RFWMatrixImageView rFWMatrixImageView3 = this.mIvPic;
        if (rFWMatrixImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView3.setContentDescription('\u7b2c' + (position + 1) + "\u6761\uff0c\u7c7b\u578b\u662f\u56fe\u7247");
        RFWMatrixImageView rFWMatrixImageView4 = this.mIvPic;
        if (rFWMatrixImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        rFWMatrixImageView4.setScaleLockState(false);
        this.mCurrentAnimate = null;
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        Intrinsics.checkNotNull(layerPicInfo);
        if (existFile(layerPicInfo.getCurrentPicInfo())) {
            RFWLog.i("RFWLayerPicControlSection", RFWLog.USR, "current url:" + RFWUrlUtils.encodeString(layerPicInfo.getCurrentPicInfo().getLocalPath()) + " hash:" + hashCode());
            loadCurrentPic(data);
            return;
        }
        showLoadingView(true);
        IMediaProvider iMediaProvider = this.mMediaProvider;
        if (iMediaProvider != null) {
            if (iMediaProvider.downloadPic(data, data.isShowOriginPic() ? RFWLayerPicInfo.PicType.ORIGIN : RFWLayerPicInfo.PicType.LARGE)) {
                RFWMatrixImageView rFWMatrixImageView5 = this.mIvPic;
                if (rFWMatrixImageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                if (rFWMatrixImageView5.getDrawable() == null && existFile(layerPicInfo.getSmallPicInfo())) {
                    loadThumbOption(data);
                    return;
                }
                return;
            }
        }
        loadCurrentPic(data);
    }
}
