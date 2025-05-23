package com.tencent.mobileqq.zplan.minixwconnected;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.ScreenCoord;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeSource;
import com.tencent.mobileqq.zplan.minihome.GiftPopSource;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GuidanceSource;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoData;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedNeighborFragment;
import com.tencent.mobileqq.zplan.minixwconnected.c;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectInviteView;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.QzoneIPCModule;
import fi3.bi;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b*\u0002sx\u0018\u0000 \u0090\u00012\u00020\u0001:\u0002\u0091\u0001B\t\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016J\u0012\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J$\u0010-\u001a\u00020\u00132\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020.H\u0016J\b\u00106\u001a\u00020.H\u0016J\b\u00107\u001a\u00020.H\u0016J\"\u0010;\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010=\u001a\u00020\u00022\b\u0010<\u001a\u0004\u0018\u00010\u0013J\u0006\u0010>\u001a\u00020\u0002J\u001a\u0010B\u001a\u00020\u00022\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010\u0013J$\u0010F\u001a\u00020\u00022\b\u0010C\u001a\u0004\u0018\u00010\u00132\b\u0010D\u001a\u0004\u0018\u00010\u00052\b\u0010E\u001a\u0004\u0018\u00010\u0005J\u0010\u0010H\u001a\u00020\u00022\b\u0010G\u001a\u0004\u0018\u00010\u0013J\u0006\u0010I\u001a\u00020\u0002J\u001a\u0010M\u001a\u00020\u00022\b\u0010J\u001a\u0004\u0018\u00010\u00132\b\u0010L\u001a\u0004\u0018\u00010KJ\u0006\u0010O\u001a\u00020NJ\u000e\u0010P\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010S\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010\u00052\b\u0010R\u001a\u0004\u0018\u00010\u0005J\u0006\u0010T\u001a\u00020\u0002J\u0018\u0010V\u001a\u00020\u00022\u0006\u0010U\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010?R\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010bR\u0018\u0010i\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010bR\u0018\u0010k\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010bR\u0016\u0010n\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001b\u0010r\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010Y\u001a\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010Y\u001a\u0004\bu\u0010vR\u001b\u0010|\u001a\u00020x8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\by\u0010Y\u001a\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR \u0010\u0085\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0082\u0001\u0010Y\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0089\u0001\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0086\u0001\u0010Y\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Sh", "Qh", "", "url", "Lcom/tencent/mobileqq/zplan/minixwconnected/MaskLayerType;", "type", "li", "", "uin", "vi", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Th", "mainSource", "Vh", "wi", "Landroid/view/View;", "iconView", "Uh", "peerUin", "ei", "anchorView", "ki", "msg", "", "iconType", UIJsPlugin.EVENT_SHOW_TOAST, "mi", "Lcom/tencent/filament/zplan/scene/xwconnect/data/c;", "data", "hi", "ci", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "", "onBackEvent", "onDestroyView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetach", "isWrapContent", "needStatusTrans", "needImmersive", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "focusUI", "ti", "ni", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "mapMode", "btn", "ri", "part", "hostUin", "hostName", "si", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "qi", "oi", "strangerIcon", "Lx45/h;", "currRecommendInfo", SensorJsPlugin.SENSOR_INTERVAL_UI, "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectInviteView;", "di", "ii", "topMaskUrl", "bottomMaskUrl", "pi", "Rh", "friendUin", WidgetCacheLunarData.JI, "Lfi3/bi;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Xh", "()Lfi3/bi;", "binding", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "D", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "controller", "E", "Landroid/view/View;", "coupleActionPanel", UserInfo.SEX_FEMALE, "globalFunctionBtn", "G", "strangerPart", "H", "friendFocusPart", "I", "selfFocusUI", "J", "Z", "isFrinedMiniHomeConnected", "K", "Yh", "()Z", "destroyWhenJumpOutFromWowo", "com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2$a", "L", "Wh", "()Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2$a;", "appearanceKeyChangeObserver", "com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2$a", "M", "Zh", "()Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2$a;", "miniHomeInfoObserver", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "N", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "removeConfirmDialog", "Landroid/widget/ImageView;", "P", "ai", "()Landroid/widget/ImageView;", "removeImageButton", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "bi", "()I", "visitStrangerTimeThreshold", "Ljava/util/concurrent/atomic/AtomicInteger;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/concurrent/atomic/AtomicInteger;", "visitedTime", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectedFragment extends QPublicBaseFragment {

    /* renamed from: S, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean T;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy binding;

    /* renamed from: D, reason: from kotlin metadata */
    private MiniHomeConnectedController controller;

    /* renamed from: E, reason: from kotlin metadata */
    private View coupleActionPanel;

    /* renamed from: F, reason: from kotlin metadata */
    private View globalFunctionBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private View strangerPart;

    /* renamed from: H, reason: from kotlin metadata */
    private View friendFocusPart;

    /* renamed from: I, reason: from kotlin metadata */
    private View selfFocusUI;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isFrinedMiniHomeConnected;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy destroyWhenJumpOutFromWowo;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy appearanceKeyChangeObserver;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy miniHomeInfoObserver;

    /* renamed from: N, reason: from kotlin metadata */
    private QQCustomDialog removeConfirmDialog;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy removeImageButton;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy visitStrangerTimeThreshold;

    /* renamed from: R, reason: from kotlin metadata */
    private final AtomicInteger visitedTime;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "pageBundle", "", "c", "", "isExist", "Z", "a", "()Z", "b", "(Z)V", "", "ADD_FRIEND_GUIDE_BUBBLE_MMKV_KEY", "Ljava/lang/String;", "", "BOTTOM_CONTAINER_HEIGHT_RATE", UserInfo.SEX_FEMALE, "REMOVE_BUTTON_DISTANCE_TO_SCREEN_COORD_RATE", "", "START_VISIT_NEIGHBOR", "I", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ZPlanMiniHomeConnectedFragment.T;
        }

        public final void b(boolean z16) {
            ZPlanMiniHomeConnectedFragment.T = z16;
        }

        public final void c(final Context context, ZootopiaSource source, final Bundle pageBundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(pageBundle, "pageBundle");
            MiniHomeConnectedPermissions.f334440a.a(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$Companion$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (!z16) {
                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, MiniHomeConnectedTipPage.f334441a.a());
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(pageBundle);
                    ZPlanMiniHomeConnectedFragment.Companion companion = ZPlanMiniHomeConnectedFragment.INSTANCE;
                    if (companion.a()) {
                        intent.addFlags(131072);
                    } else {
                        intent.addFlags(268435456);
                    }
                    companion.b(true);
                    QPublicFragmentActivity.start(context, intent, ZPlanMiniHomeConnectedFragment.class);
                }
            });
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$a", "Lcom/tencent/mobileqq/zplan/minihome/api/IMiniHomeHelper$c;", "", "result", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements IMiniHomeHelper.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f334447b;

        a(long j3) {
            this.f334447b = j3;
        }

        @Override // com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.c
        public void onResult(boolean result) {
            QLog.i("ZPlanMiniHomeConnectedFragment", 1, "ShowGuidanceDialogCallback result: " + result + ".");
            if (result) {
                IMiniHomeHelper iMiniHomeHelper = (IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class);
                QBaseActivity qBaseActivity = ZPlanMiniHomeConnectedFragment.this.getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                iMiniHomeHelper.startCreateMiniHomePage(qBaseActivity, String.valueOf(this.f334447b), CreateMiniHomeSource.MINI_CONNECT);
                if (ZPlanMiniHomeConnectedFragment.this.Yh()) {
                    ZPlanMiniHomeConnectedFragment.this.Rh();
                }
                QLog.i("ZPlanMiniHomeConnectedFragment", 1, "startCreateMiniHomePage showGuidanceDialog cancel.");
            }
        }
    }

    public ZPlanMiniHomeConnectedFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<bi>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bi invoke() {
                return bi.g(LayoutInflater.from(ZPlanMiniHomeConnectedFragment.this.getContext()));
            }
        });
        this.binding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$destroyWhenJumpOutFromWowo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.destroyMiniConnectWhenJumpOut());
            }
        });
        this.destroyWhenJumpOutFromWowo = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2.a>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2

            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2$a", "Lcom/tencent/mobileqq/zplan/servlet/m;", "", "success", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a extends com.tencent.mobileqq.zplan.servlet.m {

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ZPlanMiniHomeConnectedFragment f334448e;

                a(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment) {
                    this.f334448e = zPlanMiniHomeConnectedFragment;
                }

                @Override // com.tencent.mobileqq.zplan.servlet.m
                public void a(boolean success, List<String> uinList) {
                    Intrinsics.checkNotNullParameter(uinList, "uinList");
                    super.a(success, uinList);
                    this.f334448e.Th(uinList);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZPlanMiniHomeConnectedFragment.this);
            }
        });
        this.appearanceKeyChangeObserver = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2.a>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2$a", "Lcom/tencent/mobileqq/zplan/utils/j;", "Lcom/tencent/mobileqq/zplan/minihome/ah;", "data", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zplan.utils.j<MiniHomeInfoData> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZPlanMiniHomeConnectedFragment f334449a;

                a(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment) {
                    this.f334449a = zPlanMiniHomeConnectedFragment;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
                
                    r4 = r3.f334449a.controller;
                 */
                @Override // com.tencent.mobileqq.zplan.utils.j
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(MiniHomeInfoData data) {
                    MiniHomeConnectedController miniHomeConnectedController;
                    Intrinsics.checkNotNullParameter(data, "data");
                    QLog.i("ZPlanMiniHomeConnectedFragment", 1, "miniHomeInfoObserver update : " + data.getUin());
                    String e16 = bb.f335811a.e();
                    if (e16 == null || !Intrinsics.areEqual(data.getUin(), e16) || miniHomeConnectedController == null) {
                        return;
                    }
                    miniHomeConnectedController.b0(Long.parseLong(e16));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZPlanMiniHomeConnectedFragment.this);
            }
        });
        this.miniHomeInfoObserver = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new ZPlanMiniHomeConnectedFragment$removeImageButton$2(this));
        this.removeImageButton = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$visitStrangerTimeThreshold$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZPlanQQMC.INSTANCE.getMiniHomeConnectVisitStrangerTimeThreshold());
            }
        });
        this.visitStrangerTimeThreshold = lazy6;
        this.visitedTime = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        View view = this.coupleActionPanel;
        RelativeLayout relativeLayout = view instanceof RelativeLayout ? (RelativeLayout) view : null;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setTranslationY(relativeLayout.getResources().getDisplayMetrics().heightPixels);
        relativeLayout.animate().translationY(0.0f).setDuration(500L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        QQCustomDialog qQCustomDialog = this.removeConfirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.removeConfirmDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(List<String> uinList) {
        MiniHomeConnectedController miniHomeConnectedController;
        String e16 = bb.f335811a.e();
        if (e16 == null || !uinList.contains(e16) || (miniHomeConnectedController = this.controller) == null) {
            return;
        }
        miniHomeConnectedController.b0(Long.parseLong(e16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(View iconView) {
        ZPlanMiniHomeConnectReporter U;
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToBigMap, neighborBtn clicked, currUin: " + e16 + ", try start neighbor panel.");
        if (getActivity() == null) {
            return;
        }
        ZPlanMiniHomeConnectedNeighborFragment.Companion companion = ZPlanMiniHomeConnectedNeighborFragment.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.a(requireActivity, 1002, null);
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController == null || (U = miniHomeConnectedController.U()) == null) {
            return;
        }
        ZPlanMiniHomeConnectReporter.f(U, iconView, "em_zplan_neighbour", "dt_clck", null, false, false, 40, null);
    }

    private final ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2.a Wh() {
        return (ZPlanMiniHomeConnectedFragment$appearanceKeyChangeObserver$2.a) this.appearanceKeyChangeObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final bi Xh() {
        return (bi) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Yh() {
        return ((Boolean) this.destroyWhenJumpOutFromWowo.getValue()).booleanValue();
    }

    private final ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2.a Zh() {
        return (ZPlanMiniHomeConnectedFragment$miniHomeInfoObserver$2.a) this.miniHomeInfoObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView ai() {
        return (ImageView) this.removeImageButton.getValue();
    }

    private final int bi() {
        return ((Number) this.visitStrangerTimeThreshold.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(ZPlanMiniHomeConnectedFragment this$0, View it) {
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "titleBackButton clicked.");
        MiniHomeConnectedController miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_back", "dt_clck", null, false, false, 56, null);
        }
        this$0.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(ZPlanMiniHomeConnectedFragment this$0, View it) {
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "resetBtn clicked.");
        MiniHomeConnectedController miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_reset_btn", "dt_clck", null, false, false, 40, null);
        }
        MiniHomeConnectedController miniHomeConnectedController2 = this$0.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(View anchorView) {
        if (((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("wowo_add_friend_guide_bubble_mmkv_key", false)) {
            return;
        }
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "showGuideBubble.");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("wowo_add_friend_guide_bubble_mmkv_key", true);
        QUIDefaultBubbleTip.r(getContext()).S(anchorView).k0(0).R(0).o0("\u52a0\u4e2a\u597d\u53cb\uff0c\n\u4e00\u8d77\u6765\u73a9\u8ff7\u4f60\u7a9d").m0(3).j0(10.0f, 8.0f, 10.0f, 8.0f).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003c, code lost:
    
        if ((r5.length() > 0) == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void li(String url, MaskLayerType type) {
        boolean z16 = true;
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "showMaskLayer, url: " + url + ", type: " + type.name());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        if (url != null) {
        }
        z16 = false;
        URLDrawable drawable2 = z16 ? URLDrawable.getDrawable(url, obtain) : null;
        if (drawable2 != null) {
            if (type == MaskLayerType.TOP_MASK_LAYER) {
                Xh().f399105h.setBackground(drawable2);
            } else {
                Xh().f399099b.setBackground(drawable2);
            }
        }
    }

    private final void showToast(final String msg2, final int iconType) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$showToast$1
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
                QQToast.makeText(BaseApplication.getContext(), iconType, msg2, 0).show();
            }
        });
    }

    private final void vi(long uin) {
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.j0(uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi() {
        if (bi() == 0) {
            MiniHomeConnectedController miniHomeConnectedController = this.controller;
            if (miniHomeConnectedController != null) {
                miniHomeConnectedController.k0();
                return;
            }
            return;
        }
        if (bi() > 0 && this.visitedTime.get() < bi()) {
            QLog.i("ZPlanMiniHomeConnectedFragment", 1, "start visitStranger, visitStrangerTimeThreshold: " + bi() + ", visitedTime: " + this.visitedTime);
            this.visitedTime.incrementAndGet();
            MiniHomeConnectedController miniHomeConnectedController2 = this.controller;
            if (miniHomeConnectedController2 != null) {
                miniHomeConnectedController2.k0();
                return;
            }
            return;
        }
        showToast("\u5207\u6362\u5f97\u592a\u5feb\u4e86\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1);
    }

    public final void ci() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$hideRemoveImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ImageView ai5;
                ai5 = ZPlanMiniHomeConnectedFragment.this.ai();
                ai5.setVisibility(8);
            }
        });
    }

    public final MiniHomeConnectInviteView di() {
        MiniHomeConnectInviteView miniHomeConnectInviteView = Xh().f399101d;
        Intrinsics.checkNotNullExpressionValue(miniHomeConnectInviteView, "binding.inviteViewContent");
        return miniHomeConnectInviteView;
    }

    public final void hi(FlowerOpRspData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        linkedHashMap.put("zplan_current_page", "pg_zplan_xiaowo_link_map");
        String opMsg = data.getOpMsg();
        if (opMsg != null) {
            linkedHashMap.put("zplan_error_code", opMsg);
        }
        VideoReport.reportEvent("ev_zplan_error_toast_imp", linkedHashMap);
    }

    public final void ii(long uin) {
        final a aVar = new a(uin);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$showCreateGuidanceDialog$1
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
                Intent intent;
                FragmentActivity activity = ZPlanMiniHomeConnectedFragment.this.getActivity();
                String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(ISchemeApi.KEY_REFERER);
                Context context = ZPlanMiniHomeConnectedFragment.this.getContext();
                if (context != null) {
                    ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).showGuidanceDialog(context, stringExtra, GuidanceSource.SOURCE_MINI_HOME_CONNECT, aVar);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    public final void ji(final String friendUin, final MapMode mapMode) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$showGiftDialog$1
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
                Context context = ZPlanMiniHomeConnectedFragment.this.getContext();
                if (context != null) {
                    ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).askShowGiftRewardDialog(context, friendUin, new GiftReportInfo(GiftPopSource.MINI_CONNECT, mapMode), ZPlanMiniHomeConnectedFragment.this.getActivity());
                }
            }
        });
    }

    public final void mi() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$showRemoveImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MiniHomeConnectedController miniHomeConnectedController;
                ImageView ai5;
                ScreenCoord curScreenCoord;
                ImageView ai6;
                miniHomeConnectedController = ZPlanMiniHomeConnectedFragment.this.controller;
                if (miniHomeConnectedController != null && (curScreenCoord = miniHomeConnectedController.getCurScreenCoord()) != null) {
                    ai6 = ZPlanMiniHomeConnectedFragment.this.ai();
                    ViewGroup.LayoutParams layoutParams = ai6.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) ((ViewUtils.getScreenHeight() * 0.99f) - curScreenCoord.getY());
                }
                ai5 = ZPlanMiniHomeConnectedFragment.this.ai();
                ai5.setVisibility(0);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    public final void ni() {
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        String str = e16;
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToSelfFocus, editMiniHomeBtn clicked, currUin: " + str + ", try start editMiniHome.");
        IMiniHomeHelper iMiniHomeHelper = (IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class);
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        iMiniHomeHelper.startEditMiniHomeFragment(qBaseActivity, str, str, "", EditMiniHomeSource.MINI_CONNECT);
        if (Yh()) {
            Rh();
        }
    }

    public final void oi() {
        Xh().f399103f.setVisibility(8);
        Xh().f399106i.setVisibility(8);
        Xh().f399100c.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002 && resultCode == -1) {
            long j3 = (data == null || (extras = data.getExtras()) == null) ? 0L : extras.getLong("uin");
            if (j3 != 0) {
                vi(j3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.controller = new MiniHomeConnectedController(context, this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController == null) {
            return true;
        }
        miniHomeConnectedController.a0();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        ZPlanMiniHomeConnectReporter U;
        String str2;
        Map<String, ? extends Object> mapOf;
        Intent intent;
        Intent intent2;
        super.onCreate(savedInstanceState);
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        String str3 = null;
        if (miniHomeConnectedController != null) {
            c.a.b(miniHomeConnectedController, null, 1, null);
        }
        MiniHomeInfoObserver.f334284c.b(Zh());
        FragmentActivity activity = getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null || (str = intent2.getStringExtra(ISchemeApi.KEY_REFERER)) == null) {
            str = "";
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str3 = intent.getStringExtra("uin");
        }
        this.isFrinedMiniHomeConnected = !Intrinsics.areEqual(bb.f335811a.e(), str3);
        MiniHomeConnectedController miniHomeConnectedController2 = this.controller;
        if (miniHomeConnectedController2 != null && (U = miniHomeConnectedController2.U()) != null) {
            ConstraintLayout root = Xh().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, str);
            if (this.isFrinedMiniHomeConnected) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            pairArr[1] = TuplesKt.to("zplan_zhutai_ketai", str2);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            U.h(root, "pg_zplan_xiaowo_link_map", "dt_pgin", mapOf);
        }
        Vh(str);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View X;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "onCreateView");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
        }
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.createView();
        }
        RelativeLayout relativeLayout = Xh().f399102e;
        MiniHomeConnectedController miniHomeConnectedController2 = this.controller;
        if (miniHomeConnectedController2 != null && (X = miniHomeConnectedController2.X()) != null) {
            relativeLayout.addView(X, new RelativeLayout.LayoutParams(-1, -1));
            QLog.i("ZPlanMiniHomeConnectedFragment", 1, "add textureView");
        }
        RelativeLayout relativeLayout2 = Xh().f399099b;
        ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (ViewUtils.getScreenHeight() * 0.46f);
        relativeLayout2.setLayoutParams(layoutParams2);
        Xh().f399104g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeConnectedFragment.fi(ZPlanMiniHomeConnectedFragment.this, view);
            }
        });
        Xh().f399103f.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_reset_position, R.color.qui_common_icon_nav_secondary, 1001));
        Xh().f399103f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeConnectedFragment.gi(ZPlanMiniHomeConnectedFragment.this, view);
            }
        });
        ConstraintLayout root = Xh().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        String str;
        ZPlanMiniHomeConnectReporter U;
        String str2;
        Map<String, ? extends Object> mapOf;
        Intent intent;
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "onDestroyView");
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra(ISchemeApi.KEY_REFERER)) == null) {
            str = "";
        }
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            ConstraintLayout root = Xh().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, str);
            if (this.isFrinedMiniHomeConnected) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            pairArr[1] = TuplesKt.to("zplan_zhutai_ketai", str2);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            U.h(root, "pg_zplan_xiaowo_link_map", "dt_pgout", mapOf);
        }
        MiniHomeConnectedController miniHomeConnectedController2 = this.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.destroy();
        }
        this.controller = null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.controller = null;
    }

    public final void pi(final String topMaskUrl, final String bottomMaskUrl) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$updateMaskLayer$1
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
                boolean z16 = true;
                QLog.i("ZPlanMiniHomeConnectedFragment", 1, "topMaskUrl: " + topMaskUrl + ", bottomMaskUrl: " + bottomMaskUrl);
                String str = topMaskUrl;
                if (!(str == null || str.length() == 0)) {
                    this.li(topMaskUrl, MaskLayerType.TOP_MASK_LAYER);
                }
                String str2 = bottomMaskUrl;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                this.li(bottomMaskUrl, MaskLayerType.BOTTOM_MASK_LAYER);
            }
        });
    }

    public final void qi(final View panel) {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToActionFocus, view: " + panel + ".");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment$updateToActionFocus$1
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
                bi Xh;
                View view;
                bi Xh2;
                View view2;
                bi Xh3;
                Xh = ZPlanMiniHomeConnectedFragment.this.Xh();
                Xh.f399103f.setVisibility(8);
                view = ZPlanMiniHomeConnectedFragment.this.coupleActionPanel;
                if (view == null) {
                    ZPlanMiniHomeConnectedFragment.this.coupleActionPanel = panel;
                }
                Xh2 = ZPlanMiniHomeConnectedFragment.this.Xh();
                Xh2.f399099b.removeAllViews();
                ZPlanMiniHomeConnectedFragment.this.ci();
                view2 = ZPlanMiniHomeConnectedFragment.this.coupleActionPanel;
                if (view2 != null) {
                    ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = ZPlanMiniHomeConnectedFragment.this;
                    ViewParent parent = view2.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(view2);
                    }
                    Xh3 = zPlanMiniHomeConnectedFragment.Xh();
                    Xh3.getRoot().addView(view2);
                    zPlanMiniHomeConnectedFragment.Qh();
                }
            }
        });
    }

    public final void ri(MapMode mapMode, View btn) {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToBigMap, input neighborBth: " + btn);
        CommonExKt.j(new ZPlanMiniHomeConnectedFragment$updateToBigMap$1(this, btn, mapMode));
    }

    public final void si(View part, String hostUin, String hostName) {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToFriendFocus, view: " + part + ".");
        CommonExKt.j(new ZPlanMiniHomeConnectedFragment$updateToFriendFocus$1(this, part, hostUin, hostName));
    }

    public final void ti(View focusUI) {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToSelfFocus, view: " + focusUI + ".");
        CommonExKt.j(new ZPlanMiniHomeConnectedFragment$updateToSelfFocus$1(this, focusUI));
    }

    public final void ui(View strangerIcon, x45.h currRecommendInfo) {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToStrangerVisit, strangerIcon: " + strangerIcon + ".");
        if (currRecommendInfo == null) {
            return;
        }
        CommonExKt.j(new ZPlanMiniHomeConnectedFragment$updateToStrangerVisit$1(this, strangerIcon, currRecommendInfo));
    }

    private final void Vh(String mainSource) {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_SOURCE, mainSource), TuplesKt.to("event", "pg_in"));
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportToBeacon("0AND0YAG6R40RLM6", "zplanMiniHomeConnect", hashMapOf);
    }

    public final void Rh() {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "destroyEngineAndFinish");
        requireActivity().finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        T = false;
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.removeObserver(Wh());
        }
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.destroy();
        }
        MiniHomeInfoObserver.f334284c.c(Zh());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.pause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "onResume");
        super.onResume();
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.addObserver(Wh());
        }
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(String peerUin) {
        if (peerUin == null || peerUin.length() == 0) {
            QLog.e("ZPlanMiniHomeConnectedFragment", 1, "jumpToProfileCard failed, peerUin null or empty.");
            return;
        }
        MiniHomeConnectedController miniHomeConnectedController = this.controller;
        if (miniHomeConnectedController != null) {
            miniHomeConnectedController.i0();
        }
        String str = "mqqapi://card/show_pslcard?src_type=internal&source=zplanMiniConnect&version=1&uin=" + peerUin;
        Context context = getContext();
        if (context != null) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(context, str);
        }
    }
}
