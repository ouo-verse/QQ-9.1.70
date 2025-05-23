package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplateViewModel;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.utils.ag;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.events.QZoneUploadPhotoPageFinishEvent;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.media.QUIPlayIconView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnClipAssetListener;

@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u008a\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u008b\u0001B\t\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003000/H\u0016R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u0016\u0010H\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010J\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010?R\u0016\u0010L\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010CR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR*\u0010]\u001a\u0016\u0012\u0004\u0012\u00020Y\u0018\u00010/j\n\u0012\u0004\u0012\u00020Y\u0018\u0001`Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010WR\u0018\u0010a\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010WR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020U0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010u\u001a\u00020p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010r\u001a\u0004\bx\u0010yR\u001b\u0010\u007f\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010r\u001a\u0004\b}\u0010~R\u0017\u0010\u0082\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bj\u0010\u0081\u0001R \u0010\u0087\u0001\u001a\u00030\u0083\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0084\u0001\u0010r\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplatePreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Ph", "ei", "Jh", "Zh", "bi", "ai", "Rh", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$a;", "data", "Hh", "Lcom/tencent/qzonehub/api/events/QZoneUploadPhotoPageFinishEvent;", "event", "Oh", "", "getContentLayoutId", "getStatusBarColor", "", "needAdjustImmersive", "needSupportFullScreen", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Intent;", "newIntent", "onNewIntent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "reportImpl", "initView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/wink/editor/dr;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/dr;", "mVideoCut", "Landroidx/constraintlayout/widget/ConstraintLayout;", "D", "Landroidx/constraintlayout/widget/ConstraintLayout;", "playerFrame", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "back", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "changePic", "H", "changeVolume", "I", "changeVolumeImg", "J", "changeEdit", "K", "coverImage", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "L", "Lcom/tencent/biz/qui/quibutton/QUIButton;", InnerWebView.API_UPLOAD_IMAGE, "Lcom/tencent/widget/media/QUIPlayIconView;", "M", "Lcom/tencent/widget/media/QUIPlayIconView;", "playIcon", "", "N", "Ljava/lang/String;", "templateId", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "P", "Ljava/util/ArrayList;", "inputMedia", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "selectTemplateId", BdhLogUtil.LogTag.Tag_Req, "coverImagePath", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "T", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel$a;", "mPreviewData", "U", "Z", "isStandalone", "", "V", "[Ljava/lang/String;", "SUPPORTED_TABS", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel;", "W", "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplateViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/editor/export/u;", "X", "Nh", "()Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "Y", "Kh", "()Lcom/tencent/mobileqq/wink/editor/cover/WinkExtractCoverViewModel;", "mWinkExtractCoverViewModel", "Lorg/light/listener/OnClipAssetListener;", "Lorg/light/listener/OnClipAssetListener;", "onClipAssetListener", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "a0", "Lh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "<init>", "()V", "b0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPhotoTemplatePreviewFragment extends ImmersivePartFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private dr mVideoCut;

    /* renamed from: D, reason: from kotlin metadata */
    private ConstraintLayout playerFrame;

    /* renamed from: E, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout back;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView changePic;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout changeVolume;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView changeVolumeImg;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout changeEdit;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView coverImage;

    /* renamed from: L, reason: from kotlin metadata */
    private QUIButton uploadImage;

    /* renamed from: M, reason: from kotlin metadata */
    private QUIPlayIconView playIcon;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> inputMedia;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String selectTemplateId;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String coverImagePath;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private WinkPhotoTemplateViewModel.a mPreviewData;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isStandalone;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkExportViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWinkExtractCoverViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final OnClipAssetListener onClipAssetListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String templateId = "";

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final String[] SUPPORTED_TABS = {QQWinkConstants.HOME_SHOW_CAPTURE_TAB, QQWinkConstants.HOME_SHOW_PICKER_TAB, QQWinkConstants.HOME_SHOW_TEMPLATE_TAB};

    public WinkPhotoTemplatePreviewFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkPhotoTemplateViewModel>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkPhotoTemplateViewModel invoke() {
                return (WinkPhotoTemplateViewModel) WinkPhotoTemplatePreviewFragment.this.getViewModel(WinkPhotoTemplateViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.export.u>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment$winkExportViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.export.u invoke() {
                return (com.tencent.mobileqq.wink.editor.export.u) WinkPhotoTemplatePreviewFragment.this.getViewModel(com.tencent.mobileqq.wink.editor.export.u.class);
            }
        });
        this.winkExportViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkExtractCoverViewModel>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment$mWinkExtractCoverViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkExtractCoverViewModel invoke() {
                return (WinkExtractCoverViewModel) WinkPhotoTemplatePreviewFragment.this.getViewModel(WinkExtractCoverViewModel.class);
            }
        });
        this.mWinkExtractCoverViewModel = lazy3;
        this.onClipAssetListener = new OnClipAssetListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.c
            @Override // org.light.listener.OnClipAssetListener
            public final void OnLoadClipError(int i3, String str) {
                WinkPhotoTemplatePreviewFragment.ci(i3, str);
            }
        };
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkPhotoTemplatePreviewFragment.this).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026rceViewModel::class.java]");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(WinkPhotoTemplateViewModel.a data) {
        w53.b.f(getTAG(), "buildPreview ");
        this.mPreviewData = data;
        WinkEditorResourceManager.a1().i0(data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        WinkPlayerContainerView winkPlayerContainerView = new WinkPlayerContainerView(requireContext);
        ConstraintLayout constraintLayout = this.playerFrame;
        WinkVideoTavCut winkVideoTavCut = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
            constraintLayout = null;
        }
        constraintLayout.addView(winkPlayerContainerView);
        final WinkVideoTavCut f16 = WinkPlayerContainerView.f(winkPlayerContainerView, data.getWinkTavCutParams(), null, null, false, this.onClipAssetListener, 14, null);
        this.mVideoCut = f16;
        if (f16 != null) {
            f16.setAutoPlay(false);
            if (f16 instanceof WinkVideoTavCut) {
                winkVideoTavCut = f16;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(ar.f326685a.c("switch_qzone_volume", true));
            }
            winkPlayerContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkPhotoTemplatePreviewFragment.Ih(dr.this, this, view);
                }
            });
            f16.Q2(new b());
        }
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            drVar.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(dr cut, WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(cut, "$cut");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIPlayIconView qUIPlayIconView = null;
        if (cut.isPlaying()) {
            cut.pause();
            QUIPlayIconView qUIPlayIconView2 = this$0.playIcon;
            if (qUIPlayIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            } else {
                qUIPlayIconView = qUIPlayIconView2;
            }
            qUIPlayIconView.setVisibility(0);
        } else {
            cut.play();
            QUIPlayIconView qUIPlayIconView3 = this$0.playIcon;
            if (qUIPlayIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            } else {
                qUIPlayIconView = qUIPlayIconView3;
            }
            qUIPlayIconView.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Jh() {
        int i3;
        boolean c16 = ar.f326685a.c("switch_qzone_volume", true);
        ImageView imageView = this.changeVolumeImg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeVolumeImg");
            imageView = null;
        }
        if (c16) {
            i3 = R.drawable.qui_voice_high_icon_white;
        } else {
            i3 = R.drawable.qui_voice_mute_icon_white;
        }
        imageView.setImageResource(i3);
    }

    private final WinkExtractCoverViewModel Kh() {
        Object value = this.mWinkExtractCoverViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkExtractCoverViewModel>(...)");
        return (WinkExtractCoverViewModel) value;
    }

    private final WinkPhotoTemplateViewModel Mh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkPhotoTemplateViewModel) value;
    }

    private final com.tencent.mobileqq.wink.editor.export.u Nh() {
        Object value = this.winkExportViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkExportViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.export.u) value;
    }

    private final void Oh(QZoneUploadPhotoPageFinishEvent event) {
        FragmentActivity activity;
        QLog.d(getTAG(), 1, "[handleUploadPhotoPageFinishEvent] clickUpload= " + event.isClickUpload() + ", comeFrom=" + event.getComeFrom());
        if (event.isClickUpload() && event.getComeFrom() == 1 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    private final void Ph() {
        Kh().m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkPhotoTemplatePreviewFragment.Qh(WinkPhotoTemplatePreviewFragment.this, (WinkExtractCoverViewModel.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(WinkPhotoTemplatePreviewFragment this$0, WinkExtractCoverViewModel.c cVar) {
        Intent intent;
        FragmentActivity activity;
        Intent intent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar.b() == 0) {
            dr drVar = this$0.mVideoCut;
            if (drVar != null) {
                drVar.pause();
                return;
            }
            return;
        }
        String str = null;
        if (cVar.b() == 2) {
            Context context = this$0.getContext();
            Context context2 = this$0.getContext();
            if (context2 != null) {
                str = context2.getString(R.string.f239337m7);
            }
            QQToast.makeText(context, -1, str, 0).show();
            return;
        }
        if (cVar.b() == 1 || cVar.b() == 4) {
            this$0.Nh().D2(false);
            if (this$0.isStandalone && (activity = this$0.getActivity()) != null && (intent2 = activity.getIntent()) != null) {
                intent2.putExtra("needRemoveAllLocalPathWhenExport", false);
            }
            com.tencent.mobileqq.wink.editor.export.u Nh = this$0.Nh();
            dr drVar2 = this$0.mVideoCut;
            ArrayList<LocalMediaInfo> a16 = cVar.a();
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            }
            Nh.J2(this$0, drVar2, true, a16, str, WinkContext.INSTANCE.d().k().a(), false, false, this$0.Lh());
        }
    }

    private final void Rh() {
        LiveData<Result<WinkPhotoTemplateViewModel.a>> Z1 = Mh().Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends WinkPhotoTemplateViewModel.a>, Unit> function1 = new Function1<Result<? extends WinkPhotoTemplateViewModel.a>, Unit>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplatePreviewFragment$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WinkPhotoTemplateViewModel.a> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends WinkPhotoTemplateViewModel.a> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean m483isSuccessimpl = Result.m483isSuccessimpl(it.getValue());
                w53.b.f(WinkPhotoTemplatePreviewFragment.this.getTAG(), "prepared  observe " + m483isSuccessimpl);
                if (!m483isSuccessimpl) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        WinkPhotoTemplatePreviewFragment winkPhotoTemplatePreviewFragment = WinkPhotoTemplatePreviewFragment.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = winkPhotoTemplatePreviewFragment.loadingDialog;
                        if (qCircleCommonLoadingDialog != null) {
                            qCircleCommonLoadingDialog.dismiss();
                        }
                        w53.b.d(winkPhotoTemplatePreviewFragment.getTAG(), "observa video prepare fail", m479exceptionOrNullimpl);
                        return;
                    }
                    return;
                }
                WinkPhotoTemplatePreviewFragment winkPhotoTemplatePreviewFragment2 = WinkPhotoTemplatePreviewFragment.this;
                Object value = it.getValue();
                ResultKt.throwOnFailure(value);
                winkPhotoTemplatePreviewFragment2.Hh((WinkPhotoTemplateViewModel.a) value);
                WinkPhotoTemplatePreviewFragment winkPhotoTemplatePreviewFragment3 = WinkPhotoTemplatePreviewFragment.this;
                Object value2 = it.getValue();
                ResultKt.throwOnFailure(value2);
                winkPhotoTemplatePreviewFragment3.templateId = ((WinkPhotoTemplateViewModel.a) value2).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f30533id;
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkPhotoTemplatePreviewFragment.Sh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "uploadImage click");
        this$0.bi();
        WinkPhotoTemplateViewModel Mh = this$0.Mh();
        QUIButton qUIButton = this$0.uploadImage;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException(InnerWebView.API_UPLOAD_IMAGE);
            qUIButton = null;
        }
        WinkPhotoTemplateViewModel.S1(Mh, qUIButton, WinkDaTongReportConstant.ElementId.EM_XSJ_QZONE_UPLOAD_ALBUM, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai();
        WinkPhotoTemplateViewModel Mh = this$0.Mh();
        FrameLayout frameLayout = this$0.changeEdit;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeEdit");
            frameLayout = null;
        }
        WinkPhotoTemplateViewModel.S1(Mh, frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_EDIT, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.mVideoCut;
        if (drVar != null) {
            if (drVar.isPlaying()) {
                drVar.pause();
            } else {
                drVar.play();
            }
        }
        QUIPlayIconView qUIPlayIconView = this$0.playIcon;
        if (qUIPlayIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            qUIPlayIconView = null;
        }
        qUIPlayIconView.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "back");
        WinkPhotoTemplateViewModel Mh = this$0.Mh();
        FrameLayout frameLayout = this$0.back;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
            frameLayout = null;
        }
        WinkPhotoTemplateViewModel.S1(Mh, frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, 4, null);
        this$0.requireActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Zh();
        WinkPhotoTemplateViewModel Mh = this$0.Mh();
        ImageView imageView = this$0.changePic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePic");
            imageView = null;
        }
        WinkPhotoTemplateViewModel.S1(Mh, imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_MAP_CONVERSION, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(WinkPhotoTemplatePreviewFragment this$0, View view) {
        WinkVideoTavCut winkVideoTavCut;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a(this$0.getTAG(), "changeVolume click");
        ar arVar = ar.f326685a;
        boolean c16 = arVar.c("switch_qzone_volume", true);
        dr drVar = this$0.mVideoCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.W2(!c16);
        }
        arVar.m("switch_qzone_volume", true ^ c16);
        this$0.Jh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Zh() {
        String str;
        List<MediaInfo> list;
        Intent intent;
        MetaMaterial metaMaterial;
        Bundle bundle = new Bundle();
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putString("keyAction", "actionSelectPicture");
        ArrayList arrayList = new ArrayList();
        ArrayList<LocalMediaInfo> arrayList2 = this.inputMedia;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                String str2 = ((LocalMediaInfo) it.next()).path;
                if (str2 != null) {
                    MediaType mediaType = MediaType.LOCAL_IMAGE;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.path");
                    arrayList.add(new MediaInfo(mediaType, null, 0, 0, str2, null, null, 0, 0, null, null, 0L, 4078, null));
                }
            }
        }
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(false, 0, 500, false, 0, 500, 0, false, null, true, false, false, false, 7635, null));
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_RECOMMEND);
        bundle.putString(QQWinkConstants.QZONE_RECOMMEND_TEMPLATE_ID, this.selectTemplateId);
        WinkPhotoTemplateViewModel.a aVar = this.mPreviewData;
        Bundle bundle2 = null;
        if (aVar != null && (metaMaterial = aVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        bundle.putString("lib_template_id", str);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_RECOMMEND);
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", true);
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.i(TabType.ONLY_IMAGE);
        aVar2.j(500);
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        aVar2.c(list);
        Unit unit = Unit.INSTANCE;
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", aVar2.a());
        for (String str3 : this.SUPPORTED_TABS) {
            if (str3.equals(QQWinkConstants.HOME_SHOW_PICKER_TAB)) {
                bundle.putBoolean(str3, true);
            } else {
                bundle.putBoolean(str3, false);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle2 = intent.getExtras();
        }
        bundle.putAll(bundle2);
        com.tencent.mobileqq.wink.g gVar = com.tencent.mobileqq.wink.g.f322861a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        gVar.d(requireContext, bundle);
    }

    private final void ai() {
        String str;
        String str2;
        Intent intent;
        Bundle extras;
        Intent intent2;
        Bundle extras2;
        MetaMaterial metaMaterial;
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString("app_key", "0AND0MWZXR4U3RVU");
        bundle.putBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, true);
        bundle.putBoolean(QQWinkConstants.IS_IMAGE_MODEL, true);
        bundle.putBoolean(QQWinkConstants.IS_EDIT_TEXT, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, false);
        bundle.putSerializable(QQWinkConstants.INPUT_MEDIA, this.inputMedia);
        WinkPhotoTemplateViewModel.a aVar = this.mPreviewData;
        String str3 = null;
        if (aVar != null && (metaMaterial = aVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        bundle.putString("lib_template_id", str);
        bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_RECOMMEND);
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", true);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_RECOMMEND);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QZoneHelper.UPLOAD_PHOTO);
        if (this.isStandalone) {
            bundle.putBoolean(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE, true);
            FragmentActivity activity = getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null && (extras2 = intent2.getExtras()) != null) {
                str2 = extras2.getString("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            } else {
                str2 = null;
            }
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
                str3 = extras.getString(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
            }
            bundle.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, str3);
            bundle.putBoolean("needRemoveAllLocalPathWhenExport", false);
        }
        bundle.putString("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 2L);
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(getContext(), bundle);
    }

    private final void bi() {
        String str;
        Intent intent;
        WinkPhotoTemplateViewModel.a aVar = this.mPreviewData;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            WinkEditDataWrapper winkEditDataWrapper = aVar.getWinkEditDataWrapper();
            winkEditDataWrapper.setBgmVolumeType(MusicVolumeControlViewModel.VolumeType.TEMPLATE);
            winkEditDataWrapper.setBgmVolume(1.0f);
            winkEditDataWrapper.setOriginVolume(0.0f);
            winkEditDataWrapper.setMusicId(WinkEditorMusicInfo.H);
            winkEditDataWrapper.setSelectMusicMid("fakeMid_template_bgm");
            Nh().I2(winkEditDataWrapper);
            com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
            com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
            WinkExtractCoverViewModel Kh = Kh();
            dr drVar = this.mVideoCut;
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            } else {
                str = null;
            }
            Kh.d2(this, drVar, winkEditDataWrapper, str, true, winkEditDataWrapper.getBusinessName(), Boolean.FALSE, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(int i3, String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.n
            @Override // java.lang.Runnable
            public final void run() {
                WinkPhotoTemplatePreviewFragment.di();
            }
        });
        w53.b.c("WinkTemplateShareDataSource", "\u5a92\u4f53\u8bfb\u53d6\u5931\u8d25" + i3 + ",path=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di() {
        QQToast.makeText(BaseApplication.getContext(), "\u7167\u7247\u5df2\u5220\u9664\uff0c\u8bfb\u53d6\u5931\u8d25\uff0c\u8bf7\u5237\u65b0\u4e00\u4e0b", 0).show();
    }

    private final void ei() {
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkPhotoTemplatePreviewFragment.fi(WinkPhotoTemplatePreviewFragment.this, view);
            }
        }).p(getString(R.string.f216385y6)).a();
        this.loadingDialog = a16;
        if (a16 != null && !a16.isShowing()) {
            a16.show();
        }
        String str = this.selectTemplateId;
        if (str != null) {
            Mh().b2(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(WinkPhotoTemplatePreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final MusicSourceViewModel Lh() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169198i74;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneUploadPhotoPageFinishEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return -16777216;
    }

    public final void initView() {
        Intent intent;
        Bundle extras;
        boolean z16;
        View view = this.rootView;
        FrameLayout frameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f25850by);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.player_frame)");
        this.playerFrame = (ConstraintLayout) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f164921bb4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.cover_image)");
        this.coverImage = (ImageView) findViewById2;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.f794349r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.save_share)");
        this.uploadImage = (QUIButton) findViewById3;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            this.isStandalone = extras.getBoolean(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE);
            String name = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName();
            if (!Intrinsics.areEqual(extras.getString(PeakConstants.DEST_ACTIVITY_CLASS_NAME), name) && !Intrinsics.areEqual(extras.getString("PhotoConst.INIT_ACTIVITY_CLASS_NAME"), name)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (this.isStandalone && z16) {
                QUIButton qUIButton = this.uploadImage;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(InnerWebView.API_UPLOAD_IMAGE);
                    qUIButton = null;
                }
                qUIButton.setText("\u53d1\u8bf4\u8bf4");
            }
        }
        ConstraintLayout constraintLayout = this.playerFrame;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        ImageView imageView = this.coverImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverImage");
            imageView = null;
        }
        imageView.setVisibility(8);
        String str = this.coverImagePath;
        if (str != null) {
            try {
                Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
                ImageView imageView2 = this.coverImage;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView2 = null;
                }
                imageView2.setImageBitmap(decodeFile);
                ImageView imageView3 = this.coverImage;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView3 = null;
                }
                imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView imageView4 = this.coverImage;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
            } catch (Throwable th5) {
                w53.b.c("WinkTemplateShareDataSource", "e " + th5.getMessage());
                ImageView imageView5 = this.coverImage;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView5 = null;
                }
                imageView5.setVisibility(8);
            }
        }
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f164559a43);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.back)");
        this.back = (FrameLayout) findViewById4;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.trj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.change_mute)");
        this.changeVolume = (FrameLayout) findViewById5;
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.trk);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.change_mute_src)");
        this.changeVolumeImg = (ImageView) findViewById6;
        Jh();
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.tr9);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.change_back)");
        ImageView imageView6 = (ImageView) findViewById7;
        this.changePic = imageView6;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePic");
            imageView6 = null;
        }
        imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                WinkPhotoTemplatePreviewFragment.Xh(WinkPhotoTemplatePreviewFragment.this, view8);
            }
        });
        FrameLayout frameLayout2 = this.changeVolume;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeVolume");
            frameLayout2 = null;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                WinkPhotoTemplatePreviewFragment.Yh(WinkPhotoTemplatePreviewFragment.this, view8);
            }
        });
        QUIButton qUIButton2 = this.uploadImage;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(InnerWebView.API_UPLOAD_IMAGE);
            qUIButton2 = null;
        }
        qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view8) {
                WinkPhotoTemplatePreviewFragment.Th(WinkPhotoTemplatePreviewFragment.this, view8);
            }
        });
        View view8 = this.rootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.trc);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.change_edit)");
        FrameLayout frameLayout3 = (FrameLayout) findViewById8;
        this.changeEdit = frameLayout3;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeEdit");
            frameLayout3 = null;
        }
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view9) {
                WinkPhotoTemplatePreviewFragment.Uh(WinkPhotoTemplatePreviewFragment.this, view9);
            }
        });
        View view9 = this.rootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.f66333ac);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.qui_play_icon_view)");
        QUIPlayIconView qUIPlayIconView = (QUIPlayIconView) findViewById9;
        this.playIcon = qUIPlayIconView;
        if (qUIPlayIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playIcon");
            qUIPlayIconView = null;
        }
        qUIPlayIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view10) {
                WinkPhotoTemplatePreviewFragment.Vh(WinkPhotoTemplatePreviewFragment.this, view10);
            }
        });
        FrameLayout frameLayout4 = this.back;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
        } else {
            frameLayout = frameLayout4;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view10) {
                WinkPhotoTemplatePreviewFragment.Wh(WinkPhotoTemplatePreviewFragment.this, view10);
            }
        });
        WinkPhotoTemplateViewModel Mh = Mh();
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Mh.c2(oVar.c(requireContext) + ImmersiveUtils.statusHeight);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        super.onCreate(savedInstanceState);
        w53.b.c("WinkTemplateShareDataSource", "[WinkPhotoTemplatePreviewFragment] onCreate");
        ImmersiveUtils.setWindowImmersive(requireActivity().getWindow());
        SimpleEventBus.getInstance().registerReceiver(this);
        Intent intent = requireActivity().getIntent();
        if (intent != null) {
            this.inputMedia = intent.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            String stringExtra = intent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE);
            this.selectTemplateId = intent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_ID);
            this.coverImagePath = intent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_RECOMMEND);
            ArrayList<LocalMediaInfo> arrayList = this.inputMedia;
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            w53.b.a("WinkTemplateShareDataSource", "fromType " + stringExtra + ",  " + num + " " + this.selectTemplateId);
        }
        Mh().d2(this.inputMedia);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ImmersiveUtils.setWindowImmersive(requireActivity().getWindow());
        w53.b.c("WinkTemplateShareDataSource", " [WinkPhotoTemplatePreviewFragment] onCreateView ");
        View view = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f169198i74, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026o_template_preview, null)");
        this.rootView = inflate;
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        if (TextUtils.isEmpty(this.selectTemplateId)) {
            this.selectTemplateId = "dapian_qingxukadian";
        }
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, this.selectTemplateId);
        WinkHomeReportHelper winkHomeReportHelper = WinkHomeReportHelper.f326257a;
        FragmentActivity activity = getActivity();
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        winkHomeReportHelper.c(activity, view2, WinkDaTongReportConstant.PageId.PG_QZ_VIDEO_PREVIEW, extParams);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view3;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            drVar.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent newIntent) {
        Integer num;
        super.onNewIntent(newIntent);
        w53.b.c("WinkTemplateShareDataSource", "onNewIntent ");
        ImageView imageView = null;
        if (newIntent != null) {
            this.inputMedia = newIntent.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            String stringExtra = newIntent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE);
            this.selectTemplateId = newIntent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_ID);
            this.coverImagePath = newIntent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_RECOMMEND);
            ArrayList<LocalMediaInfo> arrayList = this.inputMedia;
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            w53.b.a("WinkTemplateShareDataSource", "fromType " + stringExtra + ",  " + num + " " + this.selectTemplateId);
        }
        Mh().d2(this.inputMedia);
        String str = this.coverImagePath;
        if (str != null) {
            try {
                Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
                ImageView imageView2 = this.coverImage;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView2 = null;
                }
                imageView2.setImageBitmap(decodeFile);
                ImageView imageView3 = this.coverImage;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView3 = null;
                }
                imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageView imageView4 = this.coverImage;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
            } catch (Throwable th5) {
                w53.b.c("WinkTemplateShareDataSource", "e " + th5.getMessage());
                ImageView imageView5 = this.coverImage;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                } else {
                    imageView = imageView5;
                }
                imageView.setVisibility(8);
            }
        }
        ei();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            drVar.pause();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.d(getTAG(), 1, "[onReceiveEvent]");
        if (event != null && (event instanceof QZoneUploadPhotoPageFinishEvent)) {
            Oh((QZoneUploadPhotoPageFinishEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        WinkVideoTavCut winkVideoTavCut;
        super.onResume();
        reportImpl();
        dr drVar = this.mVideoCut;
        if (drVar != null) {
            if (drVar.isPlaying()) {
                drVar.pause();
                return;
            }
            drVar.play();
            dr drVar2 = this.mVideoCut;
            if (drVar2 instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar2;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(ar.f326685a.c("switch_qzone_volume", true));
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        Rh();
        ei();
        Ph();
        w53.b.c("WinkTemplateShareDataSource", "onViewCreated bundlesExists " + ag.f326666a.a());
    }

    public final void reportImpl() {
        QUIButton qUIButton;
        FrameLayout frameLayout;
        WinkPhotoTemplateViewModel Mh = Mh();
        ImageView imageView = this.changePic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changePic");
            imageView = null;
        }
        WinkPhotoTemplateViewModel.U1(Mh, imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_MAP_CONVERSION, null, 4, null);
        WinkPhotoTemplateViewModel Mh2 = Mh();
        QUIButton qUIButton2 = this.uploadImage;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(InnerWebView.API_UPLOAD_IMAGE);
            qUIButton = null;
        } else {
            qUIButton = qUIButton2;
        }
        WinkPhotoTemplateViewModel.U1(Mh2, qUIButton, WinkDaTongReportConstant.ElementId.EM_XSJ_QZONE_UPLOAD_ALBUM, null, 4, null);
        WinkPhotoTemplateViewModel Mh3 = Mh();
        FrameLayout frameLayout2 = this.changeEdit;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeEdit");
            frameLayout2 = null;
        }
        WinkPhotoTemplateViewModel.U1(Mh3, frameLayout2, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_EDIT, null, 4, null);
        WinkPhotoTemplateViewModel Mh4 = Mh();
        FrameLayout frameLayout3 = this.back;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("back");
            frameLayout = null;
        } else {
            frameLayout = frameLayout3;
        }
        WinkPhotoTemplateViewModel.U1(Mh4, frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, 4, null);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkPhotoTemplatePreviewFragment$b", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "", "a", "I", "firstTimes", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int firstTimes;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkPhotoTemplatePreviewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ImageView imageView = this$0.coverImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coverImage");
                imageView = null;
            }
            imageView.setVisibility(8);
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
            WinkVideoTavCut winkVideoTavCut;
            if (this.firstTimes > 1) {
                return;
            }
            w53.b.c(WinkPhotoTemplatePreviewFragment.this.getTAG(), "onFirstFrameTimeFinish");
            this.firstTimes++;
            dr drVar = WinkPhotoTemplatePreviewFragment.this.mVideoCut;
            if (drVar instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) drVar;
            } else {
                winkVideoTavCut = null;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.W2(ar.f326685a.c("switch_qzone_volume", true));
            }
            dr drVar2 = WinkPhotoTemplatePreviewFragment.this.mVideoCut;
            if (drVar2 != null) {
                drVar2.play();
            }
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = WinkPhotoTemplatePreviewFragment.this.loadingDialog;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
            Handler d16 = com.tencent.qav.thread.a.d();
            final WinkPhotoTemplatePreviewFragment winkPhotoTemplatePreviewFragment = WinkPhotoTemplatePreviewFragment.this;
            d16.post(new Runnable() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.o
                @Override // java.lang.Runnable
                public final void run() {
                    WinkPhotoTemplatePreviewFragment.b.b(WinkPhotoTemplatePreviewFragment.this);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
