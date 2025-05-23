package com.tencent.qqnt.aio.gallery.part;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerBottomOperatePart;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u0017\u0010\u001d\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010'\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001aR\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R!\u00104\u001a\b\u0012\u0004\u0012\u00020/0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerBottomOperatePart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "Lev3/a;", "", "E9", "A9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "B9", "", NodeProps.VISIBLE, "D9", "updateLayerState", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "isVisible", "onVisibleChange", "d7", "longPress", "r9", "d", "Z", "getNeedImmersiveNavigationBar", "()Z", "needImmersiveNavigationBar", "e", "Landroid/view/View;", "mFooterView", "f", "mImageButtonLayout", tl.h.F, "mOriginPicLayout", "i", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mPreSelectedItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isLongPress", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "mHideControlRunnable", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "D", "Lkotlin/Lazy;", "z9", "()Landroidx/lifecycle/Observer;", "mVideoLoadStateObserver", "<init>", "(Z)V", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class NTAIOLayerBottomOperatePart extends NTAIOLayerBasePart implements IVideoControlLayoutChangeListener, ev3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable mHideControlRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mVideoLoadStateObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean needImmersiveNavigationBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mFooterView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mImageButtonLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mOriginPicLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWLayerItemMediaInfo mPreSelectedItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLongPress;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerBottomOperatePart$a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "videoLoadState", "", "a", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerBottomOperatePart;)V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a implements Observer<RFWLayerVideoLoadState> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTAIOLayerBottomOperatePart.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerVideoLoadState videoLoadState) {
            RFWLayerFileDownloadState.FileState fileState;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) videoLoadState);
                return;
            }
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
                    NTAIOLayerBottomOperatePart.this.D9(false);
                    return;
                }
            }
            if (videoLoadState.getCurrentPlayState() == playState) {
                RFWLayerFileDownloadState fileDownloadState2 = videoLoadState.getFileDownloadState();
                if (fileDownloadState2 != null) {
                    fileState2 = fileDownloadState2.getFileState();
                }
                if (fileState2 == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                    NTAIOLayerBottomOperatePart.this.D9(true);
                }
            }
        }
    }

    public NTAIOLayerBottomOperatePart(boolean z16) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.needImmersiveNavigationBar = z16;
        this.mHideControlRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.a
            @Override // java.lang.Runnable
            public final void run() {
                NTAIOLayerBottomOperatePart.C9(NTAIOLayerBottomOperatePart.this);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerBottomOperatePart$mVideoLoadStateObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTAIOLayerBottomOperatePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NTAIOLayerBottomOperatePart.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new NTAIOLayerBottomOperatePart.a() : (NTAIOLayerBottomOperatePart.a) iPatchRedirector2.redirect((short) 2, (Object) this);
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
    public static final void C9(NTAIOLayerBottomOperatePart this$0) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View view2 = null;
        this.mFooterView = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f168348fq0, (ViewGroup) null);
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
        if (this.needImmersiveNavigationBar) {
            com.tencent.mobileqq.qui.b.f276860a.a(this.mFooterView, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        }
        com.tencent.mobileqq.qui.b.f276860a.a(this.mFooterView, RFWNavigationBarImmersiveHelper.ImmersiveType.SIDES);
    }

    public final void D9(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, visible);
        } else if (visible) {
            E9();
        } else {
            A9();
        }
    }

    @Override // ev3.a
    public void d7(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, visible);
        } else {
            D9(visible);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        B9(rootView);
        RFWLayerIOCUtil.registerControlVisibleChangeListener(rootView, this);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, ev3.a.class);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    public void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        if (!Intrinsics.areEqual(this.mPreSelectedItem, layerState.getSelectedItemMedia())) {
            this.mPreSelectedItem = layerState.getSelectedItemMedia();
            D9(true);
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener
    public void onVisibleChange(@NotNull RFWLayerItemMediaInfo itemInfo, boolean isVisible) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, itemInfo, Boolean.valueOf(isVisible));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, longPress);
        } else {
            this.isLongPress = longPress;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerVideoLoadState.class, rFWLayerItemMediaInfo.getMediaId(), z9());
        }
    }

    public /* synthetic */ NTAIOLayerBottomOperatePart(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
