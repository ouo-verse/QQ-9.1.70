package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.aelight.camera.ae.MaterialDownloadState;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListPageAdapter;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicLyricEvent;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicRetryRecommendRequestEvent;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.wink.editor.music.ui.WinkMusicButton;
import com.tencent.mobileqq.wink.editor.music.view.WinkMusicTab;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.request.QQWinkGetSmartMaterialMusicReq;
import com.tencent.mobileqq.wink.schema.SchemaHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import qqcircle.QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0092\u0001B%\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u0005H\u0014J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\u0012\u0010,\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0004000/j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000400`1H\u0016R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010AR\u0016\u0010J\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u00109R\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010[R\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010iR\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000f0k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010lR\u0016\u0010p\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0016\u0010z\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010oR\u0016\u0010{\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010uR\u001a\u0010\u007f\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b|\u0010u\u001a\u0004\b}\u0010~R\u001c\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u0016\u0010\u008a\u0001\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\bT\u0010\u0089\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMusicPartV2;", "Llq/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", ExifInterface.LATITUDE_SOUTH, "O", "x0", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "v0", "title", "o0", "P", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N", "T", "M", "V", "view", "z0", "A0", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "currentMusic", "J", "t0", "v", "", ViewStickEventHelper.IS_SHOW, "u0", "Landroid/content/Intent;", "K", "n0", "r0", "", "position", "s0", "q0", "e", "j", tl.h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.ON_CLICK, "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "unit", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/constraintlayout/widget/ConstraintLayout;", "winkMusicPanelLl", "Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "D", "Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "tabLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "winkMusicLibraryIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "winkMusicLibraryTv", "G", "winkMusicSearchIv", "H", "winkMusicSearchTv", "Landroidx/viewpager/widget/ViewPager;", "I", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "winkMusicPanelBottomSheetCl", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dj;", "L", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dj;", "musicViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "captureViewModel", "Lcom/tencent/aelight/camera/ae/part/a;", "Lcom/tencent/aelight/camera/ae/part/a;", "stateViewModel", "Lcom/tencent/aelight/camera/ae/e;", "Lcom/tencent/aelight/camera/ae/e;", "mMaterialViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "musicPlayerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "U", "Z", "isMaterialPanelOpen", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "musicListPageAdapter", "W", "Ljava/lang/String;", "tongKuanMusicMid", "X", "tongkuanMeterialid", "Y", "hasChangeMeterialid", "loadingMusicTitle", "a0", "getKEY_ATTRS", "()Ljava/lang/String;", "KEY_ATTRS", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton;", "b0", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton;", "musicButton", "c0", "Landroid/view/View$OnClickListener;", "flashButtonClickListener", "d0", "closeButtonListener", "()Z", "needMaterialMusic", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Llq/b;", "partManager", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "e0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMusicPartV2 extends lq.a implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ConstraintLayout winkMusicPanelLl;

    /* renamed from: D, reason: from kotlin metadata */
    private WinkMusicTab tabLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView winkMusicLibraryIv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView winkMusicLibraryTv;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView winkMusicSearchIv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView winkMusicSearchTv;

    /* renamed from: I, reason: from kotlin metadata */
    private ViewPager viewPager;

    /* renamed from: J, reason: from kotlin metadata */
    private ConstraintLayout winkMusicPanelBottomSheetCl;

    /* renamed from: K, reason: from kotlin metadata */
    private AEFlashShowBottomPanelViewModel bottomPanelViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private dj musicViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private ab captureViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.aelight.camera.ae.part.a stateViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    private com.tencent.aelight.camera.ae.e mMaterialViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a musicPlayerViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private MusicSourceViewModel musicSourceViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private MusicVolumeControlViewModel musicVolumeViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private BottomSheetBehavior<View> behavior;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isMaterialPanelOpen;

    /* renamed from: V, reason: from kotlin metadata */
    private WinkMusicListPageAdapter musicListPageAdapter;

    /* renamed from: W, reason: from kotlin metadata */
    private String tongKuanMusicMid;

    /* renamed from: X, reason: from kotlin metadata */
    private String tongkuanMeterialid;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean hasChangeMeterialid;

    /* renamed from: Z, reason: from kotlin metadata */
    private String loadingMusicTitle;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final String KEY_ATTRS;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private WinkMusicButton musicButton;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener flashButtonClickListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener closeButtonListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowCameraUnit unit;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMusicPartV2$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 1) {
                w53.b.a("AEFlashShowMusicPartV2", "STATE_DRAGGING");
                return;
            }
            if (newState == 2) {
                w53.b.a("AEFlashShowMusicPartV2", "STATE_SETTLING");
                return;
            }
            if (newState == 3) {
                w53.b.a("AEFlashShowMusicPartV2", "STATE_EXPANDED");
                return;
            }
            if (newState != 4) {
                if (newState != 5) {
                    return;
                }
                w53.b.a("AEFlashShowMusicPartV2", "STATE_HIDDEN");
            } else {
                w53.b.a("AEFlashShowMusicPartV2", "STATE_COLLAPSED");
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = AEFlashShowMusicPartV2.this.bottomPanelViewModel;
                if (aEFlashShowBottomPanelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                    aEFlashShowBottomPanelViewModel = null;
                }
                aEFlashShowBottomPanelViewModel.k2().postValue(Boolean.FALSE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMusicPartV2(Activity activity, View rootView, lq.b partManager) {
        super(activity, rootView, partManager);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        Object b16 = partManager.b(65537, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(b16, "partManager.get(VSCaptur\u2026.MANAGER_GET_ACTION_UNIT)");
        this.unit = (AEFlashShowCameraUnit) b16;
        this.loadingMusicTitle = "\u914d\u4e50\u52a0\u8f7d\u4e2d";
        this.KEY_ATTRS = "key_attrs";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.k2().getValue(), java.lang.Boolean.TRUE) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0() {
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        com.tencent.aelight.camera.ae.part.a aVar = null;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        Pair<PanelTag, Boolean> value = aEFlashShowBottomPanelViewModel.e2().getValue();
        boolean z16 = true;
        if (value != null && value.getSecond().booleanValue()) {
            if (L()) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.bottomPanelViewModel;
                if (aEFlashShowBottomPanelViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                    aEFlashShowBottomPanelViewModel2 = null;
                }
                Pair<PanelTag, Boolean> value2 = aEFlashShowBottomPanelViewModel2.e2().getValue();
                if ((value2 != null ? value2.getFirst() : null) == PanelTag.MATERIAL_PANEL) {
                    AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel3 = this.bottomPanelViewModel;
                    if (aEFlashShowBottomPanelViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                        aEFlashShowBottomPanelViewModel3 = null;
                    }
                }
            }
            z16 = false;
        }
        ab abVar = this.captureViewModel;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
            abVar = null;
        }
        if (abVar.L1().getValue() != AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
            z16 = false;
        }
        com.tencent.aelight.camera.ae.part.a aVar2 = this.stateViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
        } else {
            aVar = aVar2;
        }
        if (!Intrinsics.areEqual(aVar.M1().getValue(), Boolean.TRUE)) {
            z16 = false;
        }
        WinkMusicButton winkMusicButton = this.musicButton;
        if (winkMusicButton == null) {
            return;
        }
        winkMusicButton.setVisibility(z16 ? 0 : 8);
    }

    private final void J(WinkEditorMusicInfo currentMusic) {
        boolean z16;
        String p16;
        if (o83.b.f422214a.a()) {
            String str = this.tongKuanMusicMid;
            if (str != null) {
                if (str.length() > 0) {
                    z16 = true;
                    if (z16 || currentMusic == null || (p16 = currentMusic.p()) == null) {
                        return;
                    }
                    if (!(p16.length() > 0) || Intrinsics.areEqual(p16, this.tongKuanMusicMid)) {
                        return;
                    }
                    com.tencent.aelight.camera.ae.flashshow.util.u uVar = com.tencent.aelight.camera.ae.flashshow.util.u.f65126a;
                    String string = BaseApplication.getContext().getString(R.string.y0o);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext()\n           \u2026nd_other_music_recommend)");
                    uVar.a(string, 0);
                    return;
                }
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    private final Intent K() {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        QZoneHelper.addSource(intent);
        MusicSourceViewModel musicSourceViewModel = this.musicSourceViewModel;
        if (musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        }
        intent.putExtra("videoclipduration", (int) musicSourceViewModel.getVideoDurationMs());
        intent.putExtra("videofrom", "fromqqwink");
        if (n0()) {
            intent.putExtra("type", "photo");
        } else {
            intent.putExtra("type", "notphoto");
        }
        return intent;
    }

    private final boolean L() {
        if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
            ab abVar = this.captureViewModel;
            if (abVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
                abVar = null;
            }
            if (abVar.L1().getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
                return true;
            }
        }
        return false;
    }

    private final void M() {
        ConstraintLayout constraintLayout = this.winkMusicPanelLl;
        BottomSheetBehavior<View> bottomSheetBehavior = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelLl");
            constraintLayout = null;
        }
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(from, "from(winkMusicPanelLl)");
        this.behavior = from;
        if (from == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
            from = null;
        }
        from.addBottomSheetCallback(new b());
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.behavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
            bottomSheetBehavior2 = null;
        }
        bottomSheetBehavior2.setPeekHeight(0);
        BottomSheetBehavior<View> bottomSheetBehavior3 = this.behavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
        } else {
            bottomSheetBehavior = bottomSheetBehavior3;
        }
        bottomSheetBehavior.setState(5);
    }

    private final void O() {
        Activity A = this.unit.A();
        FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        Intent intent = fragmentActivity.getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(this.KEY_ATTRS);
            HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
            if (hashMap != null) {
                this.tongKuanMusicMid = (String) hashMap.get("music");
                this.tongkuanMeterialid = (String) hashMap.get("meterial");
                String str = (String) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_LOADING_TITLE);
                if (str != null) {
                    this.loadingMusicTitle = str;
                }
            }
        }
        w53.b.f("AEFlashShowMusicPartV2", "initFromIntent... tongKuanMusicMid:" + this.tongKuanMusicMid);
        x0();
    }

    private final void P() {
        this.musicButton = (WinkMusicButton) this.f415376e.findViewById(R.id.rtx);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.da
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowMusicPartV2.Q(AEFlashShowMusicPartV2.this, view);
            }
        };
        this.closeButtonListener = onClickListener;
        WinkMusicButton winkMusicButton = this.musicButton;
        if (winkMusicButton != null) {
            Intrinsics.checkNotNull(onClickListener);
            winkMusicButton.setCloseButtonListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.db
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowMusicPartV2.R(AEFlashShowMusicPartV2.this, view);
            }
        };
        this.flashButtonClickListener = onClickListener2;
        WinkMusicButton winkMusicButton2 = this.musicButton;
        if (winkMusicButton2 != null) {
            winkMusicButton2.setOnClickListener(onClickListener2);
        }
        WinkMusicButton winkMusicButton3 = this.musicButton;
        if (winkMusicButton3 != null) {
            VideoReport.setElementId(winkMusicButton3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
            VideoReport.setElementParams(winkMusicButton3, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AEFlashShowMusicPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
        if (musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        }
        musicSourceViewModel.y2();
        WinkMusicButton winkMusicButton = this$0.musicButton;
        if (winkMusicButton != null) {
            WinkMusicButton.f(winkMusicButton, null, 1, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AEFlashShowMusicPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
        MusicSourceViewModel musicSourceViewModel2 = null;
        if (musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        }
        musicSourceViewModel.E3();
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this$0.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        ds value = aEFlashShowBottomPanelViewModel.j2().getValue();
        boolean z16 = false;
        if (value != null && value.getShow()) {
            z16 = true;
        }
        this$0.isMaterialPanelOpen = z16;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this$0.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel2 = null;
        }
        aEFlashShowBottomPanelViewModel2.k2().postValue(Boolean.TRUE);
        MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel3 = null;
        }
        if (musicSourceViewModel3.getCurrentMusic() == null) {
            MusicSourceViewModel musicSourceViewModel4 = this$0.musicSourceViewModel;
            if (musicSourceViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            } else {
                musicSourceViewModel2 = musicSourceViewModel4;
            }
            musicSourceViewModel2.i4();
        }
        this$0.t0();
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("xsp_xsj_fabuqi_qukushiyongxintuijian");
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_fabuqi_yinyuejieruqyinresou");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S() {
        View findViewById = this.f415376e.findViewById(R.id.rxi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.musicMenuViewStubV2)");
        ViewStub viewStub = (ViewStub) findViewById;
        if (viewStub.getParent() == null) {
            return;
        }
        View rootView = viewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        N(rootView);
        T(rootView);
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(String[] tabTitles, AEFlashShowMusicPartV2 this$0, int i3, boolean z16) {
        Map<String, ? extends Object> mapOf;
        WinkMusicListFragment.MusicRequestType musicRequestType;
        Intrinsics.checkNotNullParameter(tabTitles, "$tabTitles");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("AEFlashShowMusicPartV2", "[onTabChange] pos:" + i3 + " fromUserClick:" + z16);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, tabTitles[i3]));
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CATEGORY_NEW, "ev_xsj_abnormal_clck", WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE, mapOf);
        WinkMusicListPageAdapter winkMusicListPageAdapter = this$0.musicListPageAdapter;
        if (winkMusicListPageAdapter != null) {
            if (i3 == 0) {
                musicRequestType = WinkMusicListFragment.MusicRequestType.RECOMMEND;
            } else {
                musicRequestType = WinkMusicListFragment.MusicRequestType.COLLECTION;
            }
            winkMusicListPageAdapter.j(musicRequestType);
        }
        MusicSourceViewModel musicSourceViewModel = null;
        if (i3 == 0) {
            MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
            if (musicSourceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            } else {
                musicSourceViewModel = musicSourceViewModel2;
            }
            com.tencent.mobileqq.wink.editor.music.ax RECOMM_CATEGORY_INFO = com.tencent.mobileqq.wink.editor.music.ax.f320778e;
            Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
            musicSourceViewModel.G3(RECOMM_CATEGORY_INFO);
            return;
        }
        if (i3 != 1) {
            return;
        }
        MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        } else {
            musicSourceViewModel = musicSourceViewModel3;
        }
        com.tencent.mobileqq.wink.editor.music.ax COLLECTION_CATEGORY_INFO = com.tencent.mobileqq.wink.editor.music.ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        musicSourceViewModel.G3(COLLECTION_CATEGORY_INFO);
    }

    private final void V() {
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(this.unit).get(AEFlashShowBottomPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(unit).get(AEFlashShow\u2026nelViewModel::class.java)");
        this.bottomPanelViewModel = (AEFlashShowBottomPanelViewModel) viewModel;
        ViewModel viewModel2 = com.tencent.aelight.camera.ae.n.a(this.unit).get(dj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "of(unit).get(AEFlashShow\u2026sicViewModel::class.java)");
        this.musicViewModel = (dj) viewModel2;
        ViewModel viewModel3 = com.tencent.aelight.camera.ae.n.a(this.unit).get(ab.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "of(unit).get(AEFlashShow\u2026odeViewModel::class.java)");
        this.captureViewModel = (ab) viewModel3;
        ViewModel viewModel4 = com.tencent.aelight.camera.ae.n.a(this.unit).get(com.tencent.aelight.camera.ae.part.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "of(unit).get(AEVideoStor\u2026ateViewModel::class.java)");
        this.stateViewModel = (com.tencent.aelight.camera.ae.part.a) viewModel4;
        ViewModel viewModel5 = com.tencent.aelight.camera.ae.n.a(this.unit).get(com.tencent.aelight.camera.ae.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "of(unit).get(AEMaterialViewModel::class.java)");
        this.mMaterialViewModel = (com.tencent.aelight.camera.ae.e) viewModel5;
        Activity A = this.unit.A();
        MusicSourceViewModel musicSourceViewModel = null;
        final FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        ViewModel viewModel6 = new ViewModelProvider(fragmentActivity).get(MusicSourceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel6, "ViewModelProvider(activi\u2026rceViewModel::class.java)");
        this.musicSourceViewModel = (MusicSourceViewModel) viewModel6;
        ViewModel viewModel7 = new ViewModelProvider(fragmentActivity).get(MusicVolumeControlViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel7, "ViewModelProvider(activi\u2026rolViewModel::class.java)");
        this.musicVolumeViewModel = (MusicVolumeControlViewModel) viewModel7;
        Object systemService = this.f415377f.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ViewModel viewModel8 = new ViewModelProvider(fragmentActivity, new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) systemService, Scene.CAMERA)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel8, "ViewModelProvider(activi\u2026yerViewModel::class.java)");
        this.musicPlayerViewModel = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) viewModel8;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        MediatorLiveData<Pair<PanelTag, Boolean>> e26 = aEFlashShowBottomPanelViewModel.e2();
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.unit;
        final Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit> function1 = new Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMusicPartV2$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PanelTag, ? extends Boolean> pair) {
                invoke2((Pair<? extends PanelTag, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends PanelTag, Boolean> pair) {
                AEFlashShowMusicPartV2.this.A0();
            }
        };
        e26.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.W(Function1.this, obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel2 = this.musicSourceViewModel;
        if (musicSourceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel2 = null;
        }
        musicSourceViewModel2.P2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.co
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.X(AEFlashShowMusicPartV2.this, fragmentActivity, (WinkEditorMusicInfo) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel3 = this.musicSourceViewModel;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel3 = null;
        }
        musicSourceViewModel3.I2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cp
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.Y(AEFlashShowMusicPartV2.this, (Boolean) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel4 = this.musicSourceViewModel;
        if (musicSourceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel4 = null;
        }
        musicSourceViewModel4.b3().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.Z(AEFlashShowMusicPartV2.this, (Boolean) obj);
            }
        });
        com.tencent.aelight.camera.ae.e eVar = this.mMaterialViewModel;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
            eVar = null;
        }
        eVar.N1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cr
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.a0(AEFlashShowMusicPartV2.this, (MaterialDownloadState) obj);
            }
        });
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel2 = null;
        }
        aEFlashShowBottomPanelViewModel2.k2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.b0(AEFlashShowMusicPartV2.this, (Boolean) obj);
            }
        });
        dj djVar = this.musicViewModel;
        if (djVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            djVar = null;
        }
        djVar.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ct
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.c0(AEFlashShowMusicPartV2.this, (AEFlashShowMusicState) obj);
            }
        });
        ab abVar = this.captureViewModel;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
            abVar = null;
        }
        abVar.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cu
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.e0(AEFlashShowMusicPartV2.this, (AEFlashCameraCaptureButtonLayout.Style) obj);
            }
        });
        com.tencent.aelight.camera.ae.part.a aVar = this.stateViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar = null;
        }
        aVar.M1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cv
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.f0(AEFlashShowMusicPartV2.this, (Boolean) obj);
            }
        });
        com.tencent.aelight.camera.ae.e eVar2 = this.mMaterialViewModel;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
            eVar2 = null;
        }
        eVar2.P1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.g0(AEFlashShowMusicPartV2.this, (com.tencent.aelight.camera.ae.r) obj);
            }
        });
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = this.musicPlayerViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar2 = null;
        }
        aVar2.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.i0((Integer) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel5 = this.musicSourceViewModel;
        if (musicSourceViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel5 = null;
        }
        musicSourceViewModel5.D2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.de
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.j0(AEFlashShowMusicPartV2.this, (MusicInfoWrapper) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel6 = this.musicSourceViewModel;
        if (musicSourceViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel6 = null;
        }
        musicSourceViewModel6.j3().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.df
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.k0(AEFlashShowMusicPartV2.this, (List) obj);
            }
        });
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel3 = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel3 = null;
        }
        aEFlashShowBottomPanelViewModel3.f2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.l0(AEFlashShowMusicPartV2.this, (Boolean) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel7 = this.musicSourceViewModel;
        if (musicSourceViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        } else {
            musicSourceViewModel = musicSourceViewModel7;
        }
        musicSourceViewModel.M2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.dh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPartV2.m0(AEFlashShowMusicPartV2.this, (com.tencent.mobileqq.wink.editor.music.ax) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(AEFlashShowMusicPartV2 this$0, FragmentActivity activity, WinkEditorMusicInfo winkEditorMusicInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        w53.b.f("AEFlashShowMusicPartV2", "[observe]currentMusicLiveData hasMusic:" + winkEditorMusicInfo);
        GLSurfaceView F = this$0.unit.F();
        LSCameraGLSurfaceView lSCameraGLSurfaceView = F instanceof LSCameraGLSurfaceView ? (LSCameraGLSurfaceView) F : null;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.setMusic(winkEditorMusicInfo != null);
        }
        SchemaHelper.f326270a.e(activity, winkEditorMusicInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(AEFlashShowMusicPartV2 this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("AEFlashShowMusicPartV2", "[observe]checkRecommendMusicLiveData " + bool);
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            this$0.J(musicSourceViewModel.P2().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AEFlashShowMusicPartV2 this$0, Boolean bool) {
        AEMaterialMetaData aEMaterialMetaData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.L()) {
            com.tencent.aelight.camera.ae.e eVar = this$0.mMaterialViewModel;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                eVar = null;
            }
            com.tencent.aelight.camera.ae.r value = eVar.P1().getValue();
            if (!TextUtils.isEmpty((value == null || (aEMaterialMetaData = value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) == null) ? null : aEMaterialMetaData.f69050id)) {
                this$0.o0("\u63a8\u8350\u914d\u4e50\u4e2d");
                return;
            }
        }
        p0(this$0, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if ((r2.length() <= 0) != true) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a0(AEFlashShowMusicPartV2 this$0, MaterialDownloadState materialDownloadState) {
        boolean z16;
        WinkMusicButton winkMusicButton;
        AEMaterialMetaData aEMaterialMetaData;
        AEMaterialMetaData aEMaterialMetaData2;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.L()) {
            boolean z17 = true;
            if (materialDownloadState != null && (aEMaterialMetaData2 = materialDownloadState.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null && (str = aEMaterialMetaData2.f69050id) != null) {
                if (str.length() > 0) {
                    z16 = true;
                    if (!z16 && materialDownloadState.getDownloadState() == MaterialDownloadState.DownLoadState.DOWN_LOADING) {
                        this$0.o0("\u63a8\u8350\u914d\u4e50\u4e2d");
                        return;
                    }
                    if (materialDownloadState != null && (aEMaterialMetaData = materialDownloadState.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null && (r2 = aEMaterialMetaData.f69050id) != null) {
                    }
                    z17 = false;
                    if (z17 || materialDownloadState.getDownloadState() != MaterialDownloadState.DownLoadState.ERROR_BREAK || (winkMusicButton = this$0.musicButton) == null) {
                        return;
                    }
                    winkMusicButton.setMusicOff();
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
            if (materialDownloadState != null) {
            }
            z17 = false;
            if (z17) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AEFlashShowMusicPartV2 this$0, Boolean show) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("AEFlashShowMusicPartV2", "[observe]musicPanelShowLiveData show:" + show);
        Intrinsics.checkNotNullExpressionValue(show, "show");
        ConstraintLayout constraintLayout = null;
        if (show.booleanValue()) {
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this$0.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                aEFlashShowBottomPanelViewModel = null;
            }
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this$0.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                aEFlashShowBottomPanelViewModel2 = null;
            }
            aEFlashShowBottomPanelViewModel.p2(aEFlashShowBottomPanelViewModel2.k2());
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this$0.musicPlayerViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
                aVar = null;
            }
            aVar.O1();
        } else {
            if (this$0.L() && this$0.isMaterialPanelOpen) {
                com.tencent.aelight.camera.ae.e eVar = this$0.mMaterialViewModel;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                    eVar = null;
                }
                com.tencent.aelight.camera.ae.r value = eVar.P1().getValue();
                if ((value != null ? value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null) == null) {
                    this$0.q0();
                }
            }
            this$0.isMaterialPanelOpen = false;
        }
        BottomSheetBehavior<View> bottomSheetBehavior = this$0.behavior;
        if (bottomSheetBehavior != null) {
            if (bottomSheetBehavior == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
                bottomSheetBehavior = null;
            }
            bottomSheetBehavior.setState(show.booleanValue() ? 3 : 5);
            ConstraintLayout constraintLayout2 = this$0.winkMusicPanelLl;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelLl");
            } else {
                constraintLayout = constraintLayout2;
            }
            this$0.u0(constraintLayout, show.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final AEFlashShowMusicPartV2 this$0, AEFlashShowMusicState aEFlashShowMusicState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("AEFlashShowMusicPartV2", "[observe]musicState:" + aEFlashShowMusicState);
        if (aEFlashShowMusicState.getMusicOn()) {
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_music_name", aEFlashShowMusicState.getTitle());
            HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params2, "params");
            params2.put("xsj_music_id", aEFlashShowMusicState.getMid());
            WinkMusicButton winkMusicButton = this$0.musicButton;
            if (winkMusicButton != null) {
                String title = aEFlashShowMusicState.getTitle();
                if (title == null) {
                    title = "\u64ad\u653e\u97f3\u4e50";
                }
                winkMusicButton.setMusicOn(title, aEFlashShowMusicState.getAlbumUrl());
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cz
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowMusicPartV2.d0(AEFlashShowMusicPartV2.this);
                }
            });
            return;
        }
        WinkMusicButton winkMusicButton2 = this$0.musicButton;
        if (winkMusicButton2 != null) {
            winkMusicButton2.setMusicOff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(AEFlashShowMusicPartV2 this$0) {
        AEMaterialMetaData aEMaterialMetaData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.L()) {
            com.tencent.aelight.camera.ae.e eVar = this$0.mMaterialViewModel;
            String str = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                eVar = null;
            }
            com.tencent.aelight.camera.ae.r value = eVar.P1().getValue();
            if (value != null && (aEMaterialMetaData = value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null) {
                str = aEMaterialMetaData.f69050id;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
            if (arVar.c("material_recommend_key" + MobileQQ.sMobileQQ.getLastLoginUin(), true)) {
                WinkMusicButton winkMusicButton = this$0.musicButton;
                if (winkMusicButton != null) {
                    this$0.z0(winkMusicButton);
                }
                arVar.m("material_recommend_key" + MobileQQ.sMobileQQ.getLastLoginUin(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(AEFlashShowMusicPartV2 this$0, AEFlashCameraCaptureButtonLayout.Style style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AEFlashShowMusicPartV2 this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AEFlashShowMusicPartV2 this$0, com.tencent.aelight.camera.ae.r rVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.L()) {
            MusicSourceViewModel musicSourceViewModel = null;
            if ((rVar != null ? rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null) == null) {
                MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
                if (musicSourceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                } else {
                    musicSourceViewModel = musicSourceViewModel2;
                }
                musicSourceViewModel.y2();
                return;
            }
            String str = rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f69050id;
            if (str != null) {
                if (Intrinsics.areEqual(str, this$0.tongkuanMeterialid)) {
                    String str2 = this$0.tongKuanMusicMid;
                    if (!(str2 == null || str2.length() == 0) && !this$0.hasChangeMeterialid) {
                        return;
                    }
                }
                this$0.hasChangeMeterialid = true;
                this$0.v0(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(AEFlashShowMusicPartV2 this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this$0.musicPlayerViewModel;
        dj djVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(musicInfoWrapper, "musicInfoWrapper");
        aVar.Q1(musicInfoWrapper);
        MusicVolumeControlViewModel musicVolumeControlViewModel = this$0.musicVolumeViewModel;
        if (musicVolumeControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel = null;
        }
        musicVolumeControlViewModel.n2(musicInfoWrapper.getMusicInfo() != null, false);
        if (musicInfoWrapper.getMusicInfo() == null) {
            dj djVar2 = this$0.musicViewModel;
            if (djVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            } else {
                djVar = djVar2;
            }
            djVar.L1().postValue(new AEFlashShowMusicState(false, null, null, null, 14, null));
            return;
        }
        dj djVar3 = this$0.musicViewModel;
        if (djVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            djVar3 = null;
        }
        MutableLiveData<AEFlashShowMusicState> L1 = djVar3.L1();
        WinkEditorMusicInfo musicInfo = musicInfoWrapper.getMusicInfo();
        String p16 = musicInfo != null ? musicInfo.p() : null;
        WinkEditorMusicInfo musicInfo2 = musicInfoWrapper.getMusicInfo();
        String q16 = musicInfo2 != null ? musicInfo2.q() : null;
        WinkEditorMusicInfo musicInfo3 = musicInfoWrapper.getMusicInfo();
        L1.postValue(new AEFlashShowMusicState(true, p16, q16, musicInfo3 != null ? musicInfo3.c() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AEFlashShowMusicPartV2 this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aelight.camera.ae.part.a aVar = this$0.stateViewModel;
        MusicSourceViewModel musicSourceViewModel = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar = null;
        }
        w53.b.f("AEFlashShowMusicPartV2", "[observe] capturingLiveData:" + aVar.N1().getValue());
        com.tencent.aelight.camera.ae.part.a aVar2 = this$0.stateViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar2 = null;
        }
        if (Intrinsics.areEqual(aVar2.N1().getValue(), Boolean.TRUE)) {
            WinkMusicButton winkMusicButton = this$0.musicButton;
            if (winkMusicButton != null) {
                winkMusicButton.setMusicOff();
                return;
            }
            return;
        }
        MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
        if (musicSourceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        } else {
            musicSourceViewModel = musicSourceViewModel2;
        }
        musicSourceViewModel.f4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(AEFlashShowMusicPartV2 this$0, Boolean bool) {
        WinkMusicButton winkMusicButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() || (winkMusicButton = this$0.musicButton) == null) {
            return;
        }
        winkMusicButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(AEFlashShowMusicPartV2 this$0, com.tencent.mobileqq.wink.editor.music.ax axVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("AEFlashShowMusicPartV2", "[observe] curCategoryLiveData:" + axVar);
        ViewPager viewPager = null;
        if (Intrinsics.areEqual(axVar, com.tencent.mobileqq.wink.editor.music.ax.f320779f)) {
            ViewPager viewPager2 = this$0.viewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager = viewPager2;
            }
            viewPager.setCurrentItem(1, false);
            return;
        }
        ViewPager viewPager3 = this$0.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager = viewPager3;
        }
        viewPager.setCurrentItem(0, false);
    }

    private final boolean n0() {
        MusicSourceViewModel musicSourceViewModel = this.musicSourceViewModel;
        if (musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        }
        return musicSourceViewModel.getEditMode() == WinkEditorViewModel.EditMode.Image;
    }

    private final void o0(String title) {
        WinkMusicButton winkMusicButton;
        if (TextUtils.isEmpty(title)) {
            title = this.loadingMusicTitle;
            if (!(!TextUtils.isEmpty(title))) {
                title = null;
            }
            if (title == null) {
                title = "\u914d\u4e50\u52a0\u8f7d\u4e2d";
            }
        }
        if (title == null || (winkMusicButton = this.musicButton) == null) {
            return;
        }
        winkMusicButton.n(title);
    }

    private final void q0() {
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        MutableLiveData<ds> j26 = aEFlashShowBottomPanelViewModel.j2();
        com.tencent.aelight.camera.ae.e eVar = this.mMaterialViewModel;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
            eVar = null;
        }
        AEMaterialMetaData M1 = eVar.M1(4);
        j26.postValue(new ds(true, M1 != null ? M1.f69050id : null, null));
    }

    private final void r0() {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.musicPlayerViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        aVar.P1();
    }

    private final void s0(int position) {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.musicPlayerViewModel;
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        aVar.N1(position);
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar3 = this.musicPlayerViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.O1();
    }

    private final void t0() {
        WinkMusicButton winkMusicButton = this.musicButton;
        if (winkMusicButton == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", winkMusicButton, null);
    }

    private final void u0(View v3, boolean isShow) {
        String str;
        HashMap<String, Object> e16 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
        Intrinsics.checkNotNullExpressionValue(e16, "g().generateElementParams()");
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_PANEL);
        if (isShow) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        VideoReport.reportEvent(str, v3, e16);
    }

    private final void v0(String materialId) {
        o0("\u63a8\u8350\u914d\u4e50\u4e2d");
        QQWinkGetSmartMaterialMusicReq qQWinkGetSmartMaterialMusicReq = new QQWinkGetSmartMaterialMusicReq(materialId);
        final long currentTimeMillis = System.currentTimeMillis();
        VSNetworkHelper.getInstance().sendRequest(qQWinkGetSmartMaterialMusicReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cx
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                AEFlashShowMusicPartV2.w0(currentTimeMillis, this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(long j3, AEFlashShowMusicPartV2 this$0, BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        List<QQCircleSmartMatchMusic$MusicInfo> list;
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField2;
        List<QQCircleSmartMatchMusic$MusicInfo> list2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis() - j3;
        MusicSourceViewModel musicSourceViewModel = null;
        QLog.i("AEFlashShowMusicPartV2", 1, "requestMaterialMusic isSuccess: +" + z16 + " +retCode: +" + j16 + " +errMsg: " + str + "cost time " + currentTimeMillis + "rsp.musics size: +" + ((qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp == null || (pBRepeatMessageField2 = qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics) == null || (list2 = pBRepeatMessageField2.get()) == null) ? null : Integer.valueOf(list2.size())));
        if (this$0.L() && j16 == 0 && z16) {
            boolean z17 = false;
            if ((qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp == null || (pBRepeatMessageField = qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics) == null || (list = pBRepeatMessageField.get()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
                if (musicSourceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    musicSourceViewModel2 = null;
                }
                if (musicSourceViewModel2.j3().getValue() != null && (!r7.isEmpty())) {
                    z17 = true;
                }
                if (z17) {
                    List<WinkEditorMusicInfo> queriedMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
                    QLog.i("AEFlashShowMusicPartV2", 1, "requestMaterialMusic setMaterialReCommendMusic size" + queriedMusicList.size());
                    MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
                    if (musicSourceViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    } else {
                        musicSourceViewModel = musicSourceViewModel3;
                    }
                    Intrinsics.checkNotNullExpressionValue(queriedMusicList, "queriedMusicList");
                    musicSourceViewModel.s4(queriedMusicList);
                    return;
                }
                return;
            }
        }
        WinkMusicButton winkMusicButton = this$0.musicButton;
        if (winkMusicButton != null) {
            winkMusicButton.setMusicOff();
        }
    }

    private final void x0() {
        MusicSourceViewModel musicSourceViewModel;
        List emptyList;
        w53.b.f("AEFlashShowMusicPartV2", "requestMusic... tongKuanMusicMid:" + this.tongKuanMusicMid);
        if (!TextUtils.isEmpty(this.tongKuanMusicMid)) {
            MusicSourceViewModel musicSourceViewModel2 = this.musicSourceViewModel;
            if (musicSourceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel2 = null;
            }
            musicSourceViewModel2.u4(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.tongKuanMusicMid);
            WinkEditorMusicHelper.D(arrayList, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cn
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    AEFlashShowMusicPartV2.y0(AEFlashShowMusicPartV2.this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                }
            });
            p0(this, null, 1, null);
            return;
        }
        MusicSourceViewModel musicSourceViewModel3 = this.musicSourceViewModel;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        } else {
            musicSourceViewModel = musicSourceViewModel3;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MusicSourceViewModel.q3(musicSourceViewModel, emptyList, null, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(AEFlashShowMusicPartV2 this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        List emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            List<WinkEditorMusicInfo> j16 = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
            MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            MusicSourceViewModel.q3(musicSourceViewModel, emptyList, j16, false, 4, null);
        }
    }

    private final void z0(View view) {
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(this.f415377f);
        r16.o0("\u5df2\u6839\u636e\u9053\u5177\u63a8\u8350\u97f3\u4e50");
        r16.m0(3);
        r16.k0(1);
        r16.R(0);
        r16.S(view);
        r16.n0(16);
        r16.s0();
    }

    @Override // lq.a
    protected void e() {
        P();
        S();
        V();
        O();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkMusicRetryRecommendRequestEvent.class);
        arrayList.add(WinkMusicLyricEvent.class);
        return arrayList;
    }

    @Override // lq.a
    public void h() {
        super.h();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // lq.a
    public void j() {
        super.j();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        boolean z16 = true;
        if ((valueOf != null && valueOf.intValue() == R.id.f123697hc) || (valueOf != null && valueOf.intValue() == R.id.f123707hd)) {
            Intent K = K();
            Activity A = this.unit.A();
            if (A != null) {
                WinkEditorMusicHelper.J(A, K, Boolean.valueOf(n0()));
            }
            r0();
            s0(0);
            com.tencent.mobileqq.wink.report.a.b(com.tencent.mobileqq.wink.report.a.f326259a, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_LIBRARY, "ev_xsj_camera_action", WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE, null, 8, null);
        } else {
            if ((valueOf == null || valueOf.intValue() != R.id.f123827hp) && (valueOf == null || valueOf.intValue() != R.id.f123837hq)) {
                z16 = false;
            }
            if (z16) {
                Intent K2 = K();
                Activity A2 = this.unit.A();
                if (A2 != null) {
                    WinkEditorMusicHelper.K(A2, K2, Boolean.valueOf(n0()));
                }
                r0();
                s0(0);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // lq.a
    public void onDestroy() {
        super.onDestroy();
        try {
            ViewPager viewPager = this.viewPager;
            if (viewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager = null;
            }
            viewPager.setAdapter(null);
        } catch (Exception e16) {
            ms.a.d("AEFlashShowMusicPartV2", "onDestroy viewPager setAdapter exception", e16);
        }
        this.flashButtonClickListener = null;
        this.closeButtonListener = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof WinkMusicRetryRecommendRequestEvent) {
            x0();
            return;
        }
        if (simpleBaseEvent instanceof WinkMusicLyricEvent) {
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                aEFlashShowBottomPanelViewModel = null;
            }
            aEFlashShowBottomPanelViewModel.k2().postValue(Boolean.FALSE);
        }
    }

    private final void N(View rootView) {
        View findViewById = rootView.findViewById(R.id.f123807hn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026R.id.wink_music_panel_ll)");
        this.winkMusicPanelLl = (ConstraintLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f123697hc);
        ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Im\u2026AEFlashShowMusicPartV2) }");
        this.winkMusicLibraryIv = imageView;
        View findViewById3 = rootView.findViewById(R.id.f123707hd);
        TextView textView = (TextView) findViewById3;
        textView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026AEFlashShowMusicPartV2) }");
        this.winkMusicLibraryTv = textView;
        View findViewById4 = rootView.findViewById(R.id.f123827hp);
        ImageView imageView2 = (ImageView) findViewById4;
        imageView2.setOnClickListener(this);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        Intrinsics.checkNotNullExpressionValue(imageView2, "this");
        com.tencent.mobileqq.wink.report.a.d(aVar, imageView2, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_SEARCH_ENTRANCE_BUTTON, null, null, null, null, null, 124, null);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026BUTTON)\n                }");
        this.winkMusicSearchIv = imageView2;
        View findViewById5 = rootView.findViewById(R.id.f123837hq);
        TextView textView2 = (TextView) findViewById5;
        textView2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(textView2, "this");
        com.tencent.mobileqq.wink.report.a.d(aVar, textView2, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_SEARCH_ENTRANCE_BUTTON, null, ExposurePolicy.REPORT_NONE, null, null, null, 116, null);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<Te\u2026      )\n                }");
        this.winkMusicSearchTv = textView2;
        View findViewById6 = rootView.findViewById(R.id.f123787hl);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById6;
        constraintLayout.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Co\u2026ONE\n                    }");
        this.winkMusicPanelBottomSheetCl = constraintLayout;
    }

    private final void T(View rootView) {
        View findViewById = rootView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026eqq.wink.R.id.view_pager)");
        this.viewPager = (ViewPager) findViewById;
        Activity A = this.unit.A();
        WinkMusicTab winkMusicTab = null;
        FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        this.musicListPageAdapter = new WinkMusicListPageAdapter(supportFragmentManager, fragmentActivity, false, null, WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE, 12, null);
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager = null;
        }
        viewPager.setAdapter(this.musicListPageAdapter);
        final String[] strArr = {"\u63a8\u8350", "\u6536\u85cf"};
        View findViewById2 = rootView.findViewById(R.id.j_o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026eqq.wink.R.id.tab_layout)");
        WinkMusicTab winkMusicTab2 = (WinkMusicTab) findViewById2;
        this.tabLayout = winkMusicTab2;
        if (winkMusicTab2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            winkMusicTab2 = null;
        }
        winkMusicTab2.setTabData(strArr);
        WinkMusicTab winkMusicTab3 = this.tabLayout;
        if (winkMusicTab3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            winkMusicTab3 = null;
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        winkMusicTab3.setViewPager(viewPager2);
        WinkMusicTab winkMusicTab4 = this.tabLayout;
        if (winkMusicTab4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            winkMusicTab = winkMusicTab4;
        }
        winkMusicTab.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cy
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                AEFlashShowMusicPartV2.U(strArr, this, i3, z16);
            }
        });
    }

    static /* synthetic */ void p0(AEFlashShowMusicPartV2 aEFlashShowMusicPartV2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        aEFlashShowMusicPartV2.o0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Integer num) {
    }
}
