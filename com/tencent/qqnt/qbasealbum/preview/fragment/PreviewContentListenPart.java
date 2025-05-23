package com.tencent.qqnt.qbasealbum.preview.fragment;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.event.PreviewEnterEvent;
import com.tencent.qqnt.qbasealbum.event.PreviewExitEvent;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.ktx.ListExKt;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import com.tencent.qqnt.qbasealbum.preview.viewmodel.PreviewMediaViewModel;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.qqnt.qbasealbum.query.ScrollDirection;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.qqnt.qbasealbum.utils.UriUtil;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.InnerErrorInfo;
import com.tencent.richframework.gallery.event.RFWEnterAnimStateEvent;
import com.tencent.richframework.gallery.event.RFWFinishHostEvent;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.video.SwitchUrlType;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0007\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020#H\u0016J\u001a\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0014J\u0012\u00100\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u000e\u00102\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u000201J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J$\u00107\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030504j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000305`6H\u0016J\u0012\u0010:\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010;\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010<\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u000108H\u0016J,\u0010B\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u0001082\b\u0010>\u001a\u0004\u0018\u0001082\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?H\u0016J\u0012\u0010C\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0016J,\u0010F\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u0001082\b\u0010>\u001a\u0004\u0018\u0001082\u0006\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020?H\u0016J\u0018\u0010I\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u000fH\u0016J\u0012\u0010J\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/preview/fragment/PreviewContentListenPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "", "initData", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "data", "Lkotlin/Pair;", "", "D9", "", "scrollDown", "H9", "", "list", "start", "end", "Lcom/tencent/qqnt/qbasealbum/query/ScrollDirection;", "scrollDirection", "I9", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", "action", "K9", "Lcom/tencent/qqnt/qbasealbum/datahub/p;", "event", "E9", "(Lcom/tencent/qqnt/qbasealbum/datahub/p;)Lkotlin/Unit;", "Lcom/tencent/qqnt/qbasealbum/datahub/q;", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "F9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "onPartResume", "Lcom/tencent/qqnt/qbasealbum/datahub/a;", "G9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/MotionEvent;", "e", "onDown", "onShowPress", "onSingleTapUp", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "itemInfo", "isVisible", "onVisibleChange", "onPartDestroy", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "d", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/preview/viewmodel/PreviewMediaViewModel;", "mediaPreviewViewModel", "Lcom/tencent/qqnt/qbasealbum/share/a;", "f", "Lcom/tencent/qqnt/qbasealbum/share/a;", "shareDataViewModel", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", tl.h.F, "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "queryViewModel", "i", "I", "curPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "curPicInfo", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PreviewContentListenPart extends RFWLayerBasePart implements SimpleEventReceiver<SimpleBaseEvent>, GestureDetector.OnGestureListener, IVideoControlLayoutChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SelectedMediaViewModel selectedMediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PreviewMediaViewModel mediaPreviewViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.qbasealbum.share.a shareDataViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QueryViewModel queryViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWLayerItemMediaInfo curPicInfo;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/PreviewContentListenPart$a", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "", "text", "", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.qqnt.qbasealbum.preview.fragment.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreviewContentListenPart.this);
            }
        }

        @Override // com.tencent.qqnt.qbasealbum.preview.fragment.a
        public void a(@Nullable String text) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) text);
            } else if (text != null) {
                com.tencent.qqnt.qbasealbum.share.a aVar = PreviewContentListenPart.this.shareDataViewModel;
                Intrinsics.checkNotNull(aVar);
                aVar.R1(text);
            }
        }
    }

    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/PreviewContentListenPart$b", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemInfo", "", "doOnVisible", "Landroid/graphics/drawable/ColorDrawable;", "a", "Lcom/tencent/richframework/video/SwitchUrlType;", "getSwitchUrlType", "", "isSupportMagnifyLongPic", "Lcom/tencent/libra/request/Option;", "option", "isSupportRegionScale", "Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "innerErrorInfo", "Lcom/tencent/richframework/gallery/delegate/outer/ErrorUIConfig;", "needShowErrorUI", "useSoftLayerType", "clickPicCloseHost", "Lcom/tencent/libra/request/SizeFormat;", "getSizeFormat", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IMediaShowStrategyProvider {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreviewContentListenPart.this);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorDrawable getLoadingDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ColorDrawable) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new ColorDrawable(-16777216);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        /* renamed from: addWhiteColorFilter */
        public /* synthetic */ boolean getAddWhiteColorFilter() {
            return yz3.a.a(this);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public boolean clickPicCloseHost() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            IPartHost partHost = PreviewContentListenPart.this.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.part.BasePartFragment");
            PreviewUserInteractionPart previewUserInteractionPart = (PreviewUserInteractionPart) com.tencent.qqnt.qbasealbum.ktx.a.a((BasePartFragment) partHost, PreviewUserInteractionPart.class);
            if (previewUserInteractionPart != null) {
                previewUserInteractionPart.da();
                return false;
            }
            return false;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public /* synthetic */ boolean disableRotate(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
            return yz3.a.c(this, rFWLayerItemMediaInfo);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public void doOnVisible(@NotNull RFWLayerItemMediaInfo itemInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemInfo);
            } else {
                Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public /* synthetic */ boolean enableAutoMagnifyExternalSmallPic() {
            return yz3.a.d(this);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        @NotNull
        public SizeFormat getSizeFormat() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (SizeFormat) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return SizeFormat.LE;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        @NotNull
        public SwitchUrlType getSwitchUrlType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (SwitchUrlType) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return SwitchUrlType.IMMEDIATELY;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        /* renamed from: isSupportMagnifyLongPic */
        public boolean getIsSupportMagnifyLongPic() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return com.tencent.qqnt.qbasealbum.inject.g.f361234b.isSupportMagnifyLongPic();
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public boolean isSupportRegionScale(@NotNull Option option, @NotNull RFWLayerItemMediaInfo itemInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) option, (Object) itemInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(option, "option");
            Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
            Pair D9 = PreviewContentListenPart.this.D9(option, itemInfo);
            if (((Number) D9.getFirst()).intValue() <= ImmersiveUtils.getScreenWidth() * 1.2f && ((Number) D9.getSecond()).intValue() <= ImmersiveUtils.getScreenHeight() * 1.2f) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 || Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        @Nullable
        public ErrorUIConfig needShowErrorUI(@NotNull RFWLayerItemMediaInfo itemInfo, @Nullable InnerErrorInfo innerErrorInfo) {
            Drawable j3;
            RFWLayerPicInfo.RFWPicInfo currentPicInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ErrorUIConfig) iPatchRedirector.redirect((short) 7, (Object) this, (Object) itemInfo, (Object) innerErrorInfo);
            }
            Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
            if (itemInfo.isVideo()) {
                return null;
            }
            RFWLayerPicInfo layerPicInfo = itemInfo.getLayerPicInfo();
            boolean z16 = false;
            if (layerPicInfo != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && currentPicInfo.getSize() == 0) {
                z16 = true;
            }
            if (!z16 || (j3 = com.tencent.qqnt.qbasealbum.inject.g.f361234b.j()) == null) {
                return null;
            }
            String string = PreviewContentListenPart.this.getActivity().getResources().getString(R.string.f1769832q);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026.qalbum_image_show_error)");
            return new ErrorUIConfig(j3, string);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        /* renamed from: useBitmapConfig8888 */
        public /* synthetic */ boolean getUseRGB8888() {
            return yz3.a.e(this);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
        public boolean useSoftLayerType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (Build.VERSION.SDK_INT < 26) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/PreviewContentListenPart$c", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "continuePlay", "isAutoPlayWhenVisible", "isLoopPlay", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements IVideoPlayStrategyProvider {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
        public boolean continuePlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            return false;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
        public boolean enableDispatchFileDownloadState(@NotNull RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rFWLayerItemMediaInfo)).booleanValue();
            }
            return IVideoPlayStrategyProvider.DefaultImpls.enableDispatchFileDownloadState(this, rFWLayerItemMediaInfo);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
        public /* synthetic */ long getMinBufferingPacketDurationMs(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
            return yz3.b.a(this, rFWLayerItemMediaInfo);
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
        public boolean isAutoPlayWhenVisible(@NotNull RFWLayerItemMediaInfo mediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mediaInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            return false;
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
        public boolean isLoopPlay(@NotNull RFWLayerItemMediaInfo mediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qbasealbum/preview/fragment/PreviewContentListenPart$d", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "", "onDoubleClick", "", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "onDragClose", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements ILayerOperationListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
        public void onDoubleClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
        public void onDragClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
        public void onSingleClick(boolean isClickToExit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, isClickToExit);
            }
        }

        @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
        public void onZoomScaleChangeEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    public PreviewContentListenPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.curPosition = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> D9(Option option, RFWLayerItemMediaInfo data) {
        int i3;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo2;
        Pair<Integer, Integer> g16 = com.tencent.libra.util.a.f118813a.g(option);
        if (g16.getFirst().intValue() != 0 && g16.getSecond().intValue() != 0) {
            return g16;
        }
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        int i16 = 0;
        if (layerPicInfo != null && (originPicInfo2 = layerPicInfo.getOriginPicInfo()) != null) {
            i3 = originPicInfo2.getWidth();
        } else {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i3);
        RFWLayerPicInfo layerPicInfo2 = data.getLayerPicInfo();
        if (layerPicInfo2 != null && (originPicInfo = layerPicInfo2.getOriginPicInfo()) != null) {
            i16 = originPicInfo.getHeight();
        }
        return new Pair<>(valueOf, Integer.valueOf(i16));
    }

    private final Unit E9(com.tencent.qqnt.qbasealbum.datahub.p event) {
        int i3;
        List<? extends RFWLayerItemMediaInfo> mutableList;
        List<? extends RFWLayerItemMediaInfo> mutableList2;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        String str = null;
        if (value == null) {
            return null;
        }
        String valueOf = String.valueOf(event.a().get_id());
        RFWLayerItemMediaInfo selectedItemMedia = value.getData().getSelectedItemMedia();
        if (selectedItemMedia != null) {
            str = selectedItemMedia.getMediaId();
        }
        if (Intrinsics.areEqual(valueOf, str)) {
            RFWLayerState data = value.getData();
            List<RFWLayerItemMediaInfo> richMediaDataList = value.getData().getRichMediaDataList();
            Intrinsics.checkNotNull(richMediaDataList);
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) richMediaDataList);
            TypeIntrinsics.asMutableCollection(mutableList2).remove(value.getData().getSelectedItemMedia());
            data.setRichMediaDataList(mutableList2);
            int selectedPosition = value.getData().getSelectedPosition();
            List<RFWLayerItemMediaInfo> richMediaDataList2 = value.getData().getRichMediaDataList();
            Intrinsics.checkNotNull(richMediaDataList2);
            i3 = RangesKt___RangesKt.coerceAtMost(selectedPosition, richMediaDataList2.size());
        } else {
            List<RFWLayerItemMediaInfo> richMediaDataList3 = value.getData().getRichMediaDataList();
            Intrinsics.checkNotNull(richMediaDataList3);
            Iterator<RFWLayerItemMediaInfo> it = richMediaDataList3.iterator();
            int i16 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(String.valueOf(event.a().get_id()), it.next().getMediaId())) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                RFWLayerState data2 = value.getData();
                List<RFWLayerItemMediaInfo> richMediaDataList4 = value.getData().getRichMediaDataList();
                Intrinsics.checkNotNull(richMediaDataList4);
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) richMediaDataList4);
                mutableList.remove(i3);
                data2.setRichMediaDataList(mutableList);
                if (i3 < value.getData().getSelectedPosition()) {
                    RFWLayerState data3 = value.getData();
                    data3.setSelectedPosition(data3.getSelectedPosition() - 1);
                }
            }
            return Unit.INSTANCE;
        }
        value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyItemRangeRemoved(i3, 1));
        getMLayerViewModel().mRichMediaInfo.postValue(value);
        return Unit.INSTANCE;
    }

    private final PreviewMediaViewModel F9(final com.tencent.qqnt.qbasealbum.datahub.q event) {
        String str;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerVideoInfo layerVideoInfo;
        PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
        Boolean bool = null;
        if (previewMediaViewModel == null) {
            return null;
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null) {
            ox3.a.c(previewMediaViewModel.getTAG(), new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$handleMediaReplace$1$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.datahub.q.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "handleMediaReplace replace path: " + com.tencent.qqnt.qbasealbum.datahub.q.this.a().getPath();
                }
            });
            RFWLayerItemMediaInfo selectedItemMedia = value.getData().getSelectedItemMedia();
            if (selectedItemMedia != null) {
                str = selectedItemMedia.getMediaId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, String.valueOf(event.a().get_id()))) {
                RFWLayerItemMediaInfo selectedItemMedia2 = value.getData().getSelectedItemMedia();
                if (selectedItemMedia2 != null) {
                    bool = Boolean.valueOf(selectedItemMedia2.isVideo());
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    RFWLayerItemMediaInfo selectedItemMedia3 = value.getData().getSelectedItemMedia();
                    if (selectedItemMedia3 != null && (layerVideoInfo = selectedItemMedia3.getLayerVideoInfo()) != null && !Intrinsics.areEqual(layerVideoInfo.getLocalPath(), event.a().getPath())) {
                        layerVideoInfo.setLocalPath(event.a().getPath());
                        layerVideoInfo.setCurrentVideoUrl(UriUtil.f361640a.c(event.a(), true));
                        String path = event.a().getPath();
                        if (path == null) {
                            path = "";
                        }
                        layerVideoInfo.setFileId(path);
                    }
                } else {
                    RFWLayerItemMediaInfo selectedItemMedia4 = value.getData().getSelectedItemMedia();
                    if (selectedItemMedia4 != null && (layerPicInfo = selectedItemMedia4.getLayerPicInfo()) != null && !Intrinsics.areEqual(layerPicInfo.getCurrentPicInfo().getLocalPath(), event.a().getPath())) {
                        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                        layerPicInfo.setPicId(event.a().getPath());
                        rFWPicInfo.setLocalPath(event.a().getPath());
                        rFWPicInfo.setWidth(event.a().getMediaWidth());
                        rFWPicInfo.setHeight(event.a().getMediaHeight());
                        rFWPicInfo.setSize(event.a().getFileSize());
                        rFWPicInfo.setUrl(UriUtil.f361640a.c(event.a(), true));
                        layerPicInfo.setCurrentPicInfo(rFWPicInfo);
                    }
                }
                value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(value.getPos(), 1));
                getMLayerViewModel().mRichMediaInfo.postValue(value);
                return previewMediaViewModel;
            }
            return previewMediaViewModel;
        }
        return previewMediaViewModel;
    }

    private final void H9(boolean scrollDown) {
        com.tencent.qqnt.qbasealbum.query.a Z1;
        List<RFWLayerItemMediaInfo> list;
        int i3;
        int coerceAtMost;
        int coerceAtMost2;
        int coerceAtLeast;
        RFWLayerState data;
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null && (Z1 = queryViewModel.Z1()) != null) {
            final int b16 = Z1.b();
            final int a16 = Z1.a();
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null && (data = value.getData()) != null) {
                list = data.getRichMediaDataList();
            } else {
                list = null;
            }
            int i16 = 0;
            if (this.curPosition - b16 <= 200 && !scrollDown) {
                ox3.a.c(getTAG(), new Function0<String>(b16, a16) { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$loadMedia$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $curEndPos;
                    final /* synthetic */ int $curStartPos;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$curStartPos = b16;
                        this.$curEndPos = a16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, PreviewContentListenPart.this, Integer.valueOf(b16), Integer.valueOf(a16));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        int i17;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        i17 = PreviewContentListenPart.this.curPosition;
                        return "scroll up curPosition:" + i17 + " curStartPos:" + this.$curStartPos + " curEndPos: " + this.$curEndPos;
                    }
                });
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.curPosition + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT, 0);
                I9(list, coerceAtLeast, this.curPosition, ScrollDirection.UP);
            }
            if (a16 - this.curPosition <= 200 && scrollDown) {
                ox3.a.c(getTAG(), new Function0<String>(b16, a16) { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$loadMedia$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $curEndPos;
                    final /* synthetic */ int $curStartPos;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$curStartPos = b16;
                        this.$curEndPos = a16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, PreviewContentListenPart.this, Integer.valueOf(b16), Integer.valueOf(a16));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        int i17;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        i17 = PreviewContentListenPart.this.curPosition;
                        return "scroll down curPosition:" + i17 + " curStartPos:" + this.$curStartPos + " curEndPos:" + this.$curEndPos;
                    }
                });
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
                int i17 = this.curPosition + 1;
                if (i3 != 0) {
                    i16 = i3 - 1;
                }
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i17, i16);
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.curPosition + 500, i3);
                I9(list, coerceAtMost, coerceAtMost2, ScrollDirection.DOWN);
            }
        }
    }

    private final void I9(List<? extends RFWLayerItemMediaInfo> list, int start, int end, ScrollDirection scrollDirection) {
        List<? extends RFWLayerItemMediaInfo> list2;
        QueryViewModel queryViewModel;
        if (list != null) {
            list2 = ListExKt.a(list, start, end);
        } else {
            list2 = null;
        }
        if (list2 != null && (queryViewModel = this.queryViewModel) != null) {
            queryViewModel.c2(start, end, list2, scrollDirection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(final com.tencent.qqnt.qbasealbum.select.model.a action) {
        List<LocalMediaInfo> list;
        com.tencent.qqnt.qbasealbum.customization.picker.b bVar;
        int collectionSizeOrDefault;
        PreviewInitBean N1;
        if (action instanceof com.tencent.qqnt.qbasealbum.select.model.j) {
            ox3.a.c(getTAG(), new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$updatePreviewData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.select.model.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "updatePreviewData start: " + ((com.tencent.qqnt.qbasealbum.select.model.j) com.tencent.qqnt.qbasealbum.select.model.a.this).b() + " end: " + ((com.tencent.qqnt.qbasealbum.select.model.j) com.tencent.qqnt.qbasealbum.select.model.a.this).a();
                }
            });
            com.tencent.qqnt.qbasealbum.share.a aVar = this.shareDataViewModel;
            ArrayList arrayList = null;
            if (aVar == null || (N1 = aVar.N1()) == null || (list = N1.a()) == null) {
                AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
                if (b16 != null && (bVar = b16.pickerData) != null) {
                    list = bVar.a();
                } else {
                    list = null;
                }
            }
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null) {
                RFWLayerState data = value.getData();
                if (list != null) {
                    List<LocalMediaInfo> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.tencent.qqnt.qbasealbum.ktx.b.u((LocalMediaInfo) it.next()));
                    }
                }
                data.setRichMediaDataList(arrayList);
                com.tencent.qqnt.qbasealbum.select.model.j jVar = (com.tencent.qqnt.qbasealbum.select.model.j) action;
                value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(jVar.b(), jVar.a() - jVar.b()));
                getMLayerViewModel().mRichMediaInfo.postValue(value);
            }
        }
    }

    private final void initData() {
        boolean z16;
        List<LocalMediaInfo> list;
        com.tencent.qqnt.qbasealbum.customization.picker.b bVar;
        com.tencent.qqnt.qbasealbum.customization.picker.b bVar2;
        int collectionSizeOrDefault;
        PreviewInitBean N1;
        PreviewInitBean N12;
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Bundle arguments = ((Fragment) partHost).getArguments();
        boolean z17 = true;
        int i3 = 0;
        if (arguments != null && arguments.getBoolean("FROM_PICKER_PREVIEW_BTN")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Object partHost2 = getPartHost();
            Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Bundle arguments2 = ((Fragment) partHost2).getArguments();
            if (arguments2 == null || !arguments2.getBoolean("FROM_PICKER_EDIT")) {
                z17 = false;
            }
            if (!z17) {
                com.tencent.qqnt.qbasealbum.share.a aVar = this.shareDataViewModel;
                ArrayList arrayList = null;
                if (aVar == null || (N12 = aVar.N1()) == null || (list = N12.a()) == null) {
                    AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
                    if (b16 != null && (bVar = b16.pickerData) != null) {
                        list = bVar.a();
                    } else {
                        list = null;
                    }
                }
                com.tencent.qqnt.qbasealbum.share.a aVar2 = this.shareDataViewModel;
                if (aVar2 != null && (N1 = aVar2.N1()) != null) {
                    i3 = N1.c();
                } else {
                    AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b17 = CustomizationFacade.f361084a.b();
                    if (b17 != null && (bVar2 = b17.pickerData) != null) {
                        i3 = bVar2.b();
                    }
                }
                final UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
                if (value != null) {
                    RFWLayerState data = value.getData();
                    if (list != null) {
                        List<LocalMediaInfo> list2 = list;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(com.tencent.qqnt.qbasealbum.ktx.b.u((LocalMediaInfo) it.next()));
                        }
                    }
                    data.setRichMediaDataList(arrayList);
                    ox3.a.c(getTAG(), new Function0<String>(value) { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$initData$2$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ UIStateData<RFWLayerState> $state;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$state = value;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) value);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            List<RFWLayerItemMediaInfo> richMediaDataList = this.$state.getData().getRichMediaDataList();
                            return "enter preview size: " + (richMediaDataList != null ? Integer.valueOf(richMediaDataList.size()) : null);
                        }
                    });
                    value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                    value.getData().setSelectedPosition(i3);
                    getMLayerViewModel().mRichMediaInfo.postValue(value);
                    return;
                }
                return;
            }
        }
        ox3.a.c(getTAG(), PreviewContentListenPart$initData$1.INSTANCE);
    }

    public final void G9(@NotNull final com.tencent.qqnt.qbasealbum.datahub.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.qqnt.qbasealbum.datahub.p) {
            ox3.a.c(getTAG(), new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$handleMediaUpdateEvent$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.datahub.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "MediaRemoveEvent " + ((com.tencent.qqnt.qbasealbum.datahub.p) com.tencent.qqnt.qbasealbum.datahub.a.this).a().getPath();
                }
            });
            E9((com.tencent.qqnt.qbasealbum.datahub.p) event);
        } else if (event instanceof com.tencent.qqnt.qbasealbum.datahub.q) {
            ox3.a.c(getTAG(), new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$handleMediaUpdateEvent$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.datahub.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "MediaReplaceEvent " + ((com.tencent.qqnt.qbasealbum.datahub.q) com.tencent.qqnt.qbasealbum.datahub.a.this).a().getPath();
                }
            });
            F9((com.tencent.qqnt.qbasealbum.datahub.q) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RFWFinishHostEvent.class, RFWEnterAnimStateEvent.class);
            Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PreviewContentListenPart";
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        if (e16 == null || e26 == null || QAlbumPickerContext.f361201a.l() == null) {
            return false;
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = CustomizationFacade.f361084a.c();
        if (c16 != null && !c16.needGestureUp()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        float x16 = e16.getX() - e26.getX();
        float y16 = e16.getY() - e26.getY();
        if (e16.getPointerCount() == 1 && e26.getPointerCount() == 1 && e16.getY() - e26.getY() > 0.0f && Math.abs(x16) < y16) {
            ox3.a.c(getTAG(), PreviewContentListenPart$onFling$1.INSTANCE);
            a aVar = new a();
            com.tencent.qqnt.qbasealbum.inject.g gVar = com.tencent.qqnt.qbasealbum.inject.g.f361234b;
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            FragmentActivity requireActivity = ((Fragment) partHost).requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
            com.tencent.qqnt.qbasealbum.share.a aVar2 = this.shareDataViewModel;
            Intrinsics.checkNotNull(aVar2);
            gVar.h(requireActivity, aVar2.L1(), aVar);
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView);
        RFWLayerIOCUtil.registerPicShowStrategyProvider(rootView, new b());
        IPicLoader picLoader = com.tencent.qqnt.qbasealbum.inject.g.f361234b.getPicLoader();
        if (picLoader != null) {
            RFWLayerIOCUtil.registerPicLoader(rootView, picLoader);
        }
        RFWLayerIOCUtil.registerVideoPlayStrategyProvider(rootView, new c());
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, new d());
        RFWLayerIOCUtil.registerControlVisibleChangeListener(rootView, this);
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity = ((Fragment) partHost).requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
        this.selectedMediaViewModel = com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment");
        PreviewMediaViewModel c16 = com.tencent.qqnt.qbasealbum.album.b.c((QAlbumBaseFragment) partHost2);
        this.mediaPreviewViewModel = c16;
        Intrinsics.checkNotNull(c16);
        c16.R1(this.selectedMediaViewModel);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) e16);
        }
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        LiveData<com.tencent.qqnt.qbasealbum.select.model.a> X1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity = ((Fragment) partHost).requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "partHost as Fragment).requireActivity()");
        this.shareDataViewModel = com.tencent.qqnt.qbasealbum.album.b.h(requireActivity);
        Object partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentActivity requireActivity2 = ((Fragment) partHost2).requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "partHost as Fragment).requireActivity()");
        QueryViewModel f16 = com.tencent.qqnt.qbasealbum.album.b.f(requireActivity2);
        this.queryViewModel = f16;
        if (f16 != null && (X1 = f16.X1()) != null) {
            Object partHost3 = getPartHost();
            Intrinsics.checkNotNull(partHost3, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            LifecycleOwner viewLifecycleOwner = ((Fragment) partHost3).getViewLifecycleOwner();
            final Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.select.model.a, Unit>() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.PreviewContentListenPart$onPartCreate$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PreviewContentListenPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.select.model.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.qqnt.qbasealbum.select.model.a action) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) action);
                        return;
                    }
                    PreviewContentListenPart previewContentListenPart = PreviewContentListenPart.this;
                    Intrinsics.checkNotNullExpressionValue(action, "action");
                    previewContentListenPart.K9(action);
                }
            };
            X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.qbasealbum.preview.fragment.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PreviewContentListenPart.J9(Function1.this, obj);
                }
            });
        }
        initData();
        SimpleEventBus.getInstance().dispatchEvent(new PreviewEnterEvent());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().dispatchEvent(new PreviewExitEvent());
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWIocAbilityProvider.g().unregisterGlobalIoc(activity, IVideoControlLayoutChangeListener.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        RFWDragLayout dragLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        IGalleryPageProvider galleryPageProvider = RFWLayerIOCUtil.getGalleryPageProvider(rootView);
        if (galleryPageProvider != null && (dragLayout = galleryPageProvider.getDragLayout()) != null) {
            dragLayout.setGestureListener(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RFWFinishHostEvent) {
            if (getPartHost() instanceof QAlbumPreviewMainFragment) {
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment");
                QAlbumPreviewMainFragment qAlbumPreviewMainFragment = (QAlbumPreviewMainFragment) partHost;
                if (qAlbumPreviewMainFragment.isAdded()) {
                    qAlbumPreviewMainFragment.onBackEvent();
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof RFWEnterAnimStateEvent) {
            Activity activity = getActivity();
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            QUIImmersiveHelper.u(window, true, false);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 13, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) e16);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@Nullable MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) e16)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener
    public void onVisibleChange(@NotNull RFWLayerItemMediaInfo itemInfo, boolean isVisible) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, itemInfo, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.curPicInfo;
        if (rFWLayerItemMediaInfo != null) {
            str = rFWLayerItemMediaInfo.getMediaId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, itemInfo.getMediaId())) {
            return;
        }
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.part.BasePartFragment");
        PreviewUserInteractionPart previewUserInteractionPart = (PreviewUserInteractionPart) com.tencent.qqnt.qbasealbum.ktx.a.a((BasePartFragment) partHost, PreviewUserInteractionPart.class);
        if (previewUserInteractionPart != null) {
            previewUserInteractionPart.va(isVisible);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        Boolean bool;
        RFWLayerVideoInfo layerVideoInfo;
        String localPath;
        boolean z16;
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String localPath2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) layerState);
            return;
        }
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        this.curPicInfo = layerState.getSelectedItemMedia();
        RFWLayerItemMediaInfo selectedItemMedia = layerState.getSelectedItemMedia();
        LocalMediaInfo localMediaInfo = null;
        if (selectedItemMedia != null) {
            bool = Boolean.valueOf(selectedItemMedia.isVideo());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            RFWLayerItemMediaInfo selectedItemMedia2 = layerState.getSelectedItemMedia();
            if (selectedItemMedia2 != null && (layerPicInfo = selectedItemMedia2.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (localPath2 = currentPicInfo.getLocalPath()) != null) {
                localMediaInfo = LocalMediaDataHub.INSTANCE.a().T(localPath2);
            }
        } else {
            RFWLayerItemMediaInfo selectedItemMedia3 = layerState.getSelectedItemMedia();
            if (selectedItemMedia3 != null && (layerVideoInfo = selectedItemMedia3.getLayerVideoInfo()) != null && (localPath = layerVideoInfo.getLocalPath()) != null) {
                localMediaInfo = LocalMediaDataHub.INSTANCE.a().T(localPath);
            }
        }
        int selectedPosition = layerState.getSelectedPosition();
        if (this.curPosition != selectedPosition) {
            PreviewMediaViewModel previewMediaViewModel = this.mediaPreviewViewModel;
            if (previewMediaViewModel != null) {
                previewMediaViewModel.L1(selectedPosition, localMediaInfo);
            }
            if (localMediaInfo != null && (c16 = CustomizationFacade.f361084a.c()) != null) {
                c16.onGalleryItemSelected(localMediaInfo, selectedPosition);
            }
            if (selectedPosition - this.curPosition > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            H9(z16);
            this.curPosition = selectedPosition;
        }
    }
}
