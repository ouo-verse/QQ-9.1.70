package com.tencent.richframework.gallery.item.section;

import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWUrlUtils;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProviderKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0002J&\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0014J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020+H\u0014J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/richframework/gallery/item/section/RFWLayerCardControlSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Landroid/view/View$OnClickListener;", "()V", "mCurrentAnimate", "Landroid/graphics/drawable/Animatable;", "mHandler", "Landroid/os/Handler;", "mIsVisible", "", "mIvPic", "Landroid/widget/ImageView;", "mLayerPicOperationListener", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "mMediaProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "mMediaShowStrategyProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "mPicLoader", "Lcom/tencent/libra/IPicLoader;", "getMPicLoader", "()Lcom/tencent/libra/IPicLoader;", "mPicLoader$delegate", "Lkotlin/Lazy;", "mShowErrorToastTask", "Ljava/lang/Runnable;", "existFile", "picInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "getViewStubLayoutId", "", "loadCurrentPic", "", "data", "onBindData", "position", "", "payload", "", "", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onInitView", "containerView", "onVisibleChanged", NodeProps.VISIBLE, "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerCardControlSection extends Section<RFWLayerItemMediaInfo> implements View.OnClickListener {
    private Animatable mCurrentAnimate;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsVisible;
    private ImageView mIvPic;
    private ILayerOperationListener mLayerPicOperationListener;
    private IMediaProvider mMediaProvider;
    private IMediaShowStrategyProvider mMediaShowStrategyProvider;

    /* renamed from: mPicLoader$delegate, reason: from kotlin metadata */
    private final Lazy mPicLoader;
    private final Runnable mShowErrorToastTask;

    public RFWLayerCardControlSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerCardControlSection$mPicLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IPicLoader invoke() {
                View mRootView;
                mRootView = ((Section) RFWLayerCardControlSection.this).mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                return RFWLayerIOCUtil.getPicLoaderFromView(mRootView);
            }
        });
        this.mPicLoader = lazy;
        this.mShowErrorToastTask = new Runnable() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerCardControlSection$mShowErrorToastTask$1
            @Override // java.lang.Runnable
            public final void run() {
                IMediaShowStrategyProvider iMediaShowStrategyProvider;
                iMediaShowStrategyProvider = RFWLayerCardControlSection.this.mMediaShowStrategyProvider;
                if (iMediaShowStrategyProvider != null) {
                    RFWLayerItemMediaInfo mData = RFWLayerCardControlSection.access$getMData$p(RFWLayerCardControlSection.this);
                    Intrinsics.checkNotNullExpressionValue(mData, "mData");
                    iMediaShowStrategyProvider.doOnVisible(mData);
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RFWLayerItemMediaInfo access$getMData$p(RFWLayerCardControlSection rFWLayerCardControlSection) {
        return (RFWLayerItemMediaInfo) rFWLayerCardControlSection.mData;
    }

    private final boolean existFile(RFWLayerPicInfo.RFWPicInfo picInfo) {
        if (picInfo != null && RFWFileUtils.fileExists(picInfo.getLocalPath())) {
            return true;
        }
        return false;
    }

    private final IPicLoader getMPicLoader() {
        return (IPicLoader) this.mPicLoader.getValue();
    }

    private final void loadCurrentPic(RFWLayerItemMediaInfo data) {
        SizeFormat sizeFormat;
        ImageView imageView = this.mIvPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        Option reqOption = RFWLayerImageLoader.getReqOption(data, imageView, IMediaShowStrategyProviderKt.getPicShowDecodeFormat(this.mMediaShowStrategyProvider));
        reqOption.setRequestWidth((int) (ImmersiveUtils.getScreenWidth() * 0.686f));
        reqOption.setRequestHeight(ImmersiveUtils.getScreenHeight());
        IMediaShowStrategyProvider iMediaShowStrategyProvider = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider != null && iMediaShowStrategyProvider.disableRotate(data)) {
            reqOption.disableRotate();
        }
        IMediaShowStrategyProvider iMediaShowStrategyProvider2 = this.mMediaShowStrategyProvider;
        if (iMediaShowStrategyProvider2 != null && (sizeFormat = iMediaShowStrategyProvider2.getSizeFormat()) != null) {
            reqOption.setSizeFormat(sizeFormat);
        }
        IPicLoader mPicLoader = getMPicLoader();
        if (mPicLoader != null) {
            mPicLoader.loadImage(reqOption, new IPicLoadStateListener() { // from class: com.tencent.richframework.gallery.item.section.RFWLayerCardControlSection$loadCurrentPic$2
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(@NotNull LoadState state, @NotNull Option option) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    Intrinsics.checkNotNullParameter(option, "option");
                    state.isFinish();
                }
            });
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        ImageView imageView = this.mIvPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
        }
        if (Intrinsics.areEqual(v3, imageView)) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            T mData = this.mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            simpleEventBus.dispatchEvent(new ClickPicEvent((RFWLayerItemMediaInfo) mData, (ImageView) v3));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = (int) (ImmersiveUtils.getScreenWidth() * 0.686f);
            marginLayoutParams.height = -1;
            Unit unit = Unit.INSTANCE;
            containerView.setLayoutParams(marginLayoutParams);
            View findViewById = containerView.findViewById(R.id.f73983v1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.rfw_layer_iv_pic)");
            ImageView imageView = (ImageView) findViewById;
            this.mIvPic = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageView imageView2 = this.mIvPic;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.mIvPic;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            imageView3.setOnClickListener(this);
            this.mMediaProvider = RFWLayerIOCUtil.getMediaProvider(containerView);
            this.mLayerPicOperationListener = RFWLayerIOCUtil.getLayerOperationListener(containerView);
            IMediaShowStrategyProvider picShowStrategy = RFWLayerIOCUtil.getPicShowStrategy(containerView);
            this.mMediaShowStrategyProvider = picShowStrategy;
            if (picShowStrategy != null && picShowStrategy.useSoftLayerType()) {
                ImageView imageView4 = this.mIvPic;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
                }
                imageView4.setLayerType(1, null);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
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
        this.mCurrentAnimate = null;
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        Intrinsics.checkNotNull(layerPicInfo);
        if (existFile(layerPicInfo.getCurrentPicInfo())) {
            RFWLog.i("RFWLayerCardControlSection", RFWLog.USR, "current url:" + RFWUrlUtils.encodeString(layerPicInfo.getCurrentPicInfo().getLocalPath()) + " hash:" + hashCode());
            loadCurrentPic(data);
            return;
        }
        if (!existFile(layerPicInfo.getSmallPicInfo())) {
            ImageView imageView = this.mIvPic;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPic");
            }
            imageView.setImageDrawable(null);
        }
        loadCurrentPic(data);
    }
}
