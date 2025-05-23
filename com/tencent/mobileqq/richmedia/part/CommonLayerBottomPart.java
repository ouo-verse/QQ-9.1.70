package com.tencent.mobileqq.richmedia.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedia.part.CommonLayerBottomPart;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000bH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R!\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/CommonLayerBottomPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "Lev3/a;", "", "E9", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "B9", "", NodeProps.VISIBLE, "D9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "isVisible", "onVisibleChange", "d7", "longPress", "r9", "d", "Landroid/view/View;", "mFooterView", "e", "mImageButtonLayout", "f", "mOriginPicLayout", tl.h.F, "Z", "isLongPress", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "mHideControlRunnable", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "z9", "()Landroidx/lifecycle/Observer;", "mVideoLoadStateObserver", "<init>", "()V", "a", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class CommonLayerBottomPart extends RFWLayerBasePart implements IVideoControlLayoutChangeListener, ev3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mFooterView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mImageButtonLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mOriginPicLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLongPress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mHideControlRunnable = new Runnable() { // from class: com.tencent.mobileqq.richmedia.part.a
        @Override // java.lang.Runnable
        public final void run() {
            CommonLayerBottomPart.C9(CommonLayerBottomPart.this);
        }
    };

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mVideoLoadStateObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/CommonLayerBottomPart$a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "videoLoadState", "", "a", "<init>", "(Lcom/tencent/mobileqq/richmedia/part/CommonLayerBottomPart;)V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class a implements Observer<RFWLayerVideoLoadState> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerVideoLoadState videoLoadState) {
            RFWLayerFileDownloadState.FileState fileState;
            Intrinsics.checkNotNullParameter(videoLoadState, "videoLoadState");
            RFWLayerVideoLoadState.PlayState currentPlayState = videoLoadState.getCurrentPlayState();
            RFWLayerVideoLoadState.PlayState playState = RFWLayerVideoLoadState.PlayState.PLAYING;
            RFWLayerFileDownloadState.FileState fileState2 = null;
            if (currentPlayState != playState) {
                RFWLayerFileDownloadState fileDownloadState = videoLoadState.getFileDownloadState();
                if (fileDownloadState != null) {
                    fileState = fileDownloadState.getFileState();
                } else {
                    fileState = null;
                }
                if (fileState == RFWLayerFileDownloadState.FileState.DOWNLOADING) {
                    CommonLayerBottomPart.this.D9(false);
                    return;
                }
            }
            if (videoLoadState.getCurrentPlayState() == playState) {
                RFWLayerFileDownloadState fileDownloadState2 = videoLoadState.getFileDownloadState();
                if (fileDownloadState2 != null) {
                    fileState2 = fileDownloadState2.getFileState();
                }
                if (fileState2 == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                    CommonLayerBottomPart.this.D9(true);
                }
            }
        }
    }

    public CommonLayerBottomPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.richmedia.part.CommonLayerBottomPart$mVideoLoadStateObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommonLayerBottomPart.a invoke() {
                return new CommonLayerBottomPart.a();
            }
        });
        this.mVideoLoadStateObserver = lazy;
    }

    private final void A9() {
        if (!this.isLongPress) {
            this.mHideControlRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(CommonLayerBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mImageButtonLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this$0.mOriginPicLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void E9() {
        View view = this.mImageButtonLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mOriginPicLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        getMainHandler().removeCallbacks(this.mHideControlRunnable);
        if (!this.isLongPress) {
            getMainHandler().postDelayed(this.mHideControlRunnable, 5000L);
        }
    }

    private final Observer<RFWLayerVideoLoadState> z9() {
        return (Observer) this.mVideoLoadStateObserver.getValue();
    }

    public final void B9(@NotNull View rootView) {
        View view;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View view2 = null;
        this.mFooterView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.e3f, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(110.0f));
        layoutParams.gravity = 80;
        View view3 = this.mFooterView;
        if (view3 != null) {
            view3.setClickable(false);
        }
        ((ViewGroup) rootView).addView(this.mFooterView, layoutParams);
        View view4 = this.mFooterView;
        if (view4 != null) {
            view = view4.findViewById(R.id.avb);
        } else {
            view = null;
        }
        this.mImageButtonLayout = view;
        View view5 = this.mFooterView;
        if (view5 != null) {
            view2 = view5.findViewById(R.id.zvf);
        }
        this.mOriginPicLayout = view2;
        com.tencent.mobileqq.qui.b.f276860a.a(this.mFooterView, RFWNavigationBarImmersiveHelper.ImmersiveType.SIDES);
    }

    public final void D9(boolean visible) {
        if (visible) {
            E9();
        } else {
            A9();
        }
    }

    @Override // ev3.a
    public void d7(boolean visible) {
        D9(visible);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        B9(rootView);
        RFWLayerIOCUtil.registerControlVisibleChangeListener(rootView, this);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, ev3.a.class);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener
    public void onVisibleChange(@NotNull RFWLayerItemMediaInfo itemInfo, boolean isVisible) {
        String str;
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        String mediaId = itemInfo.getMediaId();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            str = rFWLayerItemMediaInfo.getMediaId();
        } else {
            str = null;
        }
        if (TextUtils.equals(mediaId, str)) {
            D9(isVisible);
        }
    }

    @Override // ev3.a
    public void r9(boolean longPress) {
        this.isLongPress = longPress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerVideoLoadState.class, rFWLayerItemMediaInfo.getMediaId(), z9());
        }
    }
}
