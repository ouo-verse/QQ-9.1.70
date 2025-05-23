package com.tencent.mobileqq.zplan.minixwconnected.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerBasicInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUiData;
import com.tencent.filament.zplan.scene.xwconnect.data.ScreenCoord;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.manager.GiveLikeType;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedFragment;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$factory$2;
import com.tencent.mobileqq.zplan.minixwconnected.data.StartUpParams;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFunctionBtnComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.d;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.AppSetting;
import com.tencent.util.QQToastUtil;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import mqq.util.WeakReference;
import ri3.FlowerOpRsp;
import ri3.MapModeInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00aa\u00012\u00020\u0001:\u0001LB\u0019\u0012\u0006\u0010P\u001a\u00020K\u0012\u0006\u0010V\u001a\u00020Q\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$J\u000e\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020$J\u000e\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020$J\u0006\u0010*\u001a\u00020\bJ$\u0010/\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010+J\u000e\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020+J\u0006\u00102\u001a\u00020\bJ\b\u00104\u001a\u0004\u0018\u000103J\u001f\u00108\u001a\u00020\b2\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b8\u00109J\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020\bJ\u001a\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@J#\u0010F\u001a\u00020\b2\u0006\u0010'\u001a\u00020$2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C\u00a2\u0006\u0004\bF\u0010GJ\u000e\u0010H\u001a\u00020\b2\u0006\u0010'\u001a\u00020$J\b\u0010J\u001a\u0004\u0018\u00010IR\u0017\u0010P\u001a\u00020K8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010V\u001a\u00020Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001b\u0010\\\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010Y\u001a\u0004\b_\u0010`R\u001b\u0010f\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010eR\u001b\u0010k\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010Y\u001a\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010Y\u001a\u0004\bn\u0010oR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010Y\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010Y\u001a\u0004\bx\u0010yR!\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00010{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010Y\u001a\u0004\b}\u0010~R \u0010\u0084\u0001\u001a\u00030\u0080\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0081\u0001\u0010Y\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0089\u0001\u001a\u00030\u0085\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0086\u0001\u0010Y\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R \u0010\u008e\u0001\u001a\u00030\u008a\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008b\u0001\u0010Y\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u0010\u0092\u0001\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008f\u0001\u0010Y\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u0098\u0001R\u0017\u0010\u009c\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010JR\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R0\u0010\u00a7\u0001\u001a\u0005\u0018\u00010\u00a1\u00012\n\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u00a1\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u00a8\u0006\u00ab\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/zplan/minihome/MapMode;", ExifInterface.LATITUDE_SOUTH, "", "haveFlower", "", "h0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lri3/b;", "mapModeInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "modeInfo", "B", "", "param", OperateCustomButton.OPERATE_CREATE, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "X", "resume", "pause", "destroy", "d0", "a0", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lle3/b;", "actionConfig", "Lkotlinx/coroutines/Deferred;", "Z", "", "actionId", "c0", "", "refreshBlockUin", "b0", "uin", "f0", "j0", HippyTKDListViewAdapter.X, "", "topMaskUrl", "bottomUrl", "bottomFocusUrl", "e0", "friendUin", "g0", "k0", "Landroidx/lifecycle/LifecycleOwner;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/manager/GiveLikeType;", "giveLikeType", "peerUin", "Y", "(Lcom/tencent/mobileqq/zplan/manager/GiveLikeType;Ljava/lang/Long;)V", "i0", "E", "y", "r", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "opType", "", "opData", "v", "", "Lp55/h;", "flowerViewDataList", BdhLogUtil.LogTag.Tag_Conn, "(J[Lp55/h;)V", "D", "Lcom/tencent/filament/zplan/scene/xwconnect/data/b;", "J", "Landroid/content/Context;", "a", "Landroid/content/Context;", "I", "()Landroid/content/Context;", "context", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "N", "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectMapComponent;", "c", "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectMapComponent;", "mapComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent;", "d", "V", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent;", "selfFocusComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectActionFocusComponent;", "e", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectActionFocusComponent;", "actionFocusComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFunctionBtnComponent;", "f", "G", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFunctionBtnComponent;", "bigMapFunctionComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/d;", "g", "P", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/d;", "inviteNeighborComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectStrangerComponent;", h.F, "W", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectStrangerComponent;", "strangerVisitComponent", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent;", "i", "O", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent;", "friendFocusComponent", "", "j", "H", "()Ljava/util/List;", "componentList", "Lri3/c;", "k", "T", "()Lri3/c;", "mapModeInfoViewModel", "Lcom/tencent/mobileqq/zplan/minixwconnected/report/ZPlanMiniHomeConnectReporter;", "l", "U", "()Lcom/tencent/mobileqq/zplan/minixwconnected/report/ZPlanMiniHomeConnectReporter;", "reporter", "Landroidx/lifecycle/ViewModelProvider$Factory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", DomainData.DOMAIN_NAME, "L", "()Z", "enableHuaTeng", "Lcom/tencent/mobileqq/zplan/minixwconnected/data/c;", "o", "Lcom/tencent/mobileqq/zplan/minixwconnected/data/c;", "startUpParams", "p", "Ljava/lang/String;", "bottomMaskGlobalUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "bottomMaskFocusUrl", "curFocusUin", "Lx45/h;", ReportConstant.COSTREPORT_PREFIX, "Lx45/h;", "currRecommendUserInfo", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "<set-?>", "t", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "K", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "curScreenCoord", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;)V", "u", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedController implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Fragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy mapComponent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy selfFocusComponent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy actionFocusComponent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy bigMapFunctionComponent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy inviteNeighborComponent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy strangerVisitComponent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy friendFocusComponent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy componentList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy mapModeInfoViewModel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy reporter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy factory;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableHuaTeng;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private StartUpParams startUpParams;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String bottomMaskGlobalUrl;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String bottomMaskFocusUrl;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long curFocusUin;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private x45.h currRecommendUserInfo;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ScreenCoord curScreenCoord;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334475a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f334476b;

        static {
            int[] iArr = new int[MapMode.values().length];
            try {
                iArr[MapMode.GLOBAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapMode.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapMode.ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MapMode.FOCUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MapMode.STRANGER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f334475a = iArr;
            int[] iArr2 = new int[GiveLikeType.values().length];
            try {
                iArr2[GiveLikeType.FRIEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GiveLikeType.STRANGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            f334476b = iArr2;
        }
    }

    public MiniHomeConnectedController(Context context, Fragment fragment) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.context = context;
        this.fragment = fragment;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectMapComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$mapComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectMapComponent invoke() {
                ri3.c T;
                Context context2 = MiniHomeConnectedController.this.getContext();
                T = MiniHomeConnectedController.this.T();
                return new MiniHomeConnectMapComponent(context2, T, MiniHomeConnectedController.this);
            }
        });
        this.mapComponent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectSelfFocusComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$selfFocusComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectSelfFocusComponent invoke() {
                return new MiniHomeConnectSelfFocusComponent(MiniHomeConnectedController.this.getContext(), LifecycleOwnerKt.getLifecycleScope(MiniHomeConnectedController.this.getFragment()), new WeakReference(MiniHomeConnectedController.this));
            }
        });
        this.selfFocusComponent = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectActionFocusComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$actionFocusComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectActionFocusComponent invoke() {
                return new MiniHomeConnectActionFocusComponent(MiniHomeConnectedController.this.getContext(), LifecycleOwnerKt.getLifecycleScope(MiniHomeConnectedController.this.getFragment()), MiniHomeConnectedController.this);
            }
        });
        this.actionFocusComponent = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectFunctionBtnComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$bigMapFunctionComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectFunctionBtnComponent invoke() {
                return new MiniHomeConnectFunctionBtnComponent(MiniHomeConnectedController.this.getContext(), new WeakReference(MiniHomeConnectedController.this));
            }
        });
        this.bigMapFunctionComponent = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$inviteNeighborComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d(MiniHomeConnectedController.this.getContext(), LifecycleOwnerKt.getLifecycleScope(MiniHomeConnectedController.this.getFragment()), MiniHomeConnectedController.this);
            }
        });
        this.inviteNeighborComponent = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectStrangerComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$strangerVisitComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectStrangerComponent invoke() {
                return new MiniHomeConnectStrangerComponent(MiniHomeConnectedController.this.getContext(), LifecycleOwnerKt.getLifecycleScope(MiniHomeConnectedController.this.getFragment()), MiniHomeConnectedController.this);
            }
        });
        this.strangerVisitComponent = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectFriendFocusComponent>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$friendFocusComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectFriendFocusComponent invoke() {
                return new MiniHomeConnectFriendFocusComponent(MiniHomeConnectedController.this.getContext(), LifecycleOwnerKt.getLifecycleScope(MiniHomeConnectedController.this.getFragment()), new WeakReference(MiniHomeConnectedController.this));
            }
        });
        this.friendFocusComponent = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends com.tencent.mobileqq.zplan.minixwconnected.c>>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$componentList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends com.tencent.mobileqq.zplan.minixwconnected.c> invoke() {
                MiniHomeConnectMapComponent R;
                MiniHomeConnectSelfFocusComponent V;
                MiniHomeConnectActionFocusComponent F;
                MiniHomeConnectFunctionBtnComponent G;
                d P;
                MiniHomeConnectStrangerComponent W;
                MiniHomeConnectFriendFocusComponent O;
                List<? extends com.tencent.mobileqq.zplan.minixwconnected.c> listOf;
                R = MiniHomeConnectedController.this.R();
                V = MiniHomeConnectedController.this.V();
                F = MiniHomeConnectedController.this.F();
                G = MiniHomeConnectedController.this.G();
                P = MiniHomeConnectedController.this.P();
                W = MiniHomeConnectedController.this.W();
                O = MiniHomeConnectedController.this.O();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.zplan.minixwconnected.c[]{R, V, F, G, P, W, O});
                return listOf;
            }
        });
        this.componentList = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<ri3.c>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$mapModeInfoViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ri3.c invoke() {
                ViewModel viewModel = new ViewModelProvider(MiniHomeConnectedController.this.getFragment(), MiniHomeConnectedController.this.M()).get(ri3.c.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026tedViewModel::class.java)");
                return (ri3.c) viewModel;
            }
        });
        this.mapModeInfoViewModel = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMiniHomeConnectReporter>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$reporter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanMiniHomeConnectReporter invoke() {
                return new ZPlanMiniHomeConnectReporter(MiniHomeConnectedController.this.getFragment(), MiniHomeConnectedController.this.M());
            }
        });
        this.reporter = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectedController$factory$2.a>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$factory$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController$factory$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements ViewModelProvider.Factory {
                a() {
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    return new ri3.c();
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.factory = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$enableHuaTeng$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableZPlanXwConnectHuaTeng());
            }
        });
        this.enableHuaTeng = lazy12;
        this.startUpParams = new StartUpParams(null, null, null, null, null, false, 63, null);
        this.curFocusUin = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        V().w();
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.pi(null, this.bottomMaskGlobalUrl);
        }
        Fragment fragment2 = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = fragment2 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment2 : null;
        if (zPlanMiniHomeConnectedFragment2 != null) {
            MapModeInfo value = T().O1().getValue();
            MapMode mode = value != null ? value.getMode() : null;
            View f16 = G().f();
            if (f16 != null) {
                f16.setVisibility(0);
            }
            Unit unit = Unit.INSTANCE;
            zPlanMiniHomeConnectedFragment2.ri(mode, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(MapModeInfo modeInfo) {
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.pi(null, this.bottomMaskFocusUrl);
        }
        W().r(modeInfo);
        x45.h hVar = this.currRecommendUserInfo;
        x45.h hVar2 = Intrinsics.areEqual(hVar != null ? Long.valueOf(hVar.f447212a) : null, modeInfo.getHostUin()) ? this.currRecommendUserInfo : null;
        Fragment fragment2 = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = fragment2 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment2 : null;
        if (zPlanMiniHomeConnectedFragment2 != null) {
            zPlanMiniHomeConnectedFragment2.ui(W().n(), hVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectActionFocusComponent F() {
        return (MiniHomeConnectActionFocusComponent) this.actionFocusComponent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectFunctionBtnComponent G() {
        return (MiniHomeConnectFunctionBtnComponent) this.bigMapFunctionComponent.getValue();
    }

    private final List<com.tencent.mobileqq.zplan.minixwconnected.c> H() {
        return (List) this.componentList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectFriendFocusComponent O() {
        return (MiniHomeConnectFriendFocusComponent) this.friendFocusComponent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d P() {
        return (d) this.inviteNeighborComponent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectMapComponent R() {
        return (MiniHomeConnectMapComponent) this.mapComponent.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MapMode S(Intent intent) {
        int value;
        Integer intOrNull;
        String stringExtra = intent.getStringExtra("mode");
        if (stringExtra != null && intOrNull != null) {
            value = intOrNull.intValue();
        } else {
            value = MapMode.GLOBAL.getValue();
        }
        return MapMode.INSTANCE.a(value, MapMode.GLOBAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ri3.c T() {
        return (ri3.c) this.mapModeInfoViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectSelfFocusComponent V() {
        return (MiniHomeConnectSelfFocusComponent) this.selfFocusComponent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectStrangerComponent W() {
        return (MiniHomeConnectStrangerComponent) this.strangerVisitComponent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(MapModeInfo mapModeInfo) {
        Long hostUin;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment;
        Long hostUin2 = mapModeInfo.getHostUin();
        this.curFocusUin = hostUin2 != null ? hostUin2.longValue() : -1L;
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment2 != null) {
            zPlanMiniHomeConnectedFragment2.pi(null, this.bottomMaskFocusUrl);
        }
        Long hostUin3 = mapModeInfo.getHostUin();
        String l3 = hostUin3 != null ? hostUin3.toString() : null;
        if (l3 == null || l3.length() == 0) {
            QLog.e("MiniHomeConnectedController", 1, "doOnStateFocus failed, hostUin empty.");
            return;
        }
        if (Intrinsics.areEqual(l3, bb.f335811a.e())) {
            V().O(mapModeInfo);
            Fragment fragment2 = this.fragment;
            zPlanMiniHomeConnectedFragment = fragment2 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment2 : null;
            if (zPlanMiniHomeConnectedFragment != null) {
                View E = V().E();
                E.setVisibility(0);
                zPlanMiniHomeConnectedFragment.ti(E);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(mapModeInfo.getHostHaveOwnRoom(), Boolean.TRUE)) {
            MapModeInfo value = T().O1().getValue();
            if (value != null) {
                Long hostUin4 = value.getHostUin();
                if (hostUin4 != null) {
                    R().z(MapMode.FOCUS, hostUin4.longValue());
                }
                T().R1(new MapModeInfo(MapMode.FOCUS, value.getHostUin(), value.getHostHaveOwnRoom(), value.getHostName()));
            }
            O().D(mapModeInfo);
            Fragment fragment3 = this.fragment;
            zPlanMiniHomeConnectedFragment = fragment3 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment3 : null;
            if (zPlanMiniHomeConnectedFragment != null) {
                View w3 = O().w();
                w3.setVisibility(0);
                zPlanMiniHomeConnectedFragment.si(w3, l3, mapModeInfo.getHostName());
                return;
            }
            return;
        }
        MapModeInfo value2 = T().O1().getValue();
        if (value2 == null || (hostUin = value2.getHostUin()) == null) {
            return;
        }
        long longValue = hostUin.longValue();
        Fragment fragment4 = this.fragment;
        zPlanMiniHomeConnectedFragment = fragment4 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment4 : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.oi();
            P().a(zPlanMiniHomeConnectedFragment.di(), longValue);
        }
    }

    public final void C(long uin, p55.h[] flowerViewDataList) {
        Intrinsics.checkNotNullParameter(flowerViewDataList, "flowerViewDataList");
        R().u(uin, flowerViewDataList);
    }

    public final void D(long uin) {
        R().v(uin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E() {
        Long longOrNull;
        String e16 = bb.f335811a.e();
        long longValue = (e16 == null || longOrNull == null) ? 0L : longOrNull.longValue();
        V().P(0);
        MiniHomeConnectMapComponent R = R();
        MapMode mapMode = MapMode.FOCUS;
        R.z(mapMode, longValue);
        T().R1(new MapModeInfo(mapMode, Long.valueOf(longValue), null, null, 12, null));
    }

    /* renamed from: I, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final FlowerData J() {
        return T().L1().getValue();
    }

    /* renamed from: K, reason: from getter */
    public final ScreenCoord getCurScreenCoord() {
        return this.curScreenCoord;
    }

    public final boolean L() {
        return ((Boolean) this.enableHuaTeng.getValue()).booleanValue();
    }

    public final ViewModelProvider.Factory M() {
        return (ViewModelProvider.Factory) this.factory.getValue();
    }

    /* renamed from: N, reason: from getter */
    public final Fragment getFragment() {
        return this.fragment;
    }

    public final LifecycleOwner Q() {
        try {
            return this.fragment.getViewLifecycleOwner();
        } catch (Exception unused) {
            return null;
        }
    }

    public final ZPlanMiniHomeConnectReporter U() {
        return (ZPlanMiniHomeConnectReporter) this.reporter.getValue();
    }

    public final void Y(GiveLikeType giveLikeType, Long peerUin) {
        Intrinsics.checkNotNullParameter(giveLikeType, "giveLikeType");
        if (peerUin == null) {
            return;
        }
        int i3 = b.f334476b[giveLikeType.ordinal()];
        if (i3 == 1) {
            R().A(BaseConstants.ERR_SVR_COMM_SDKAPPID_FORBIDDEN, BaseConstants.ERR_SVR_COMM_REQ_FORBIDDEN, peerUin.longValue(), false);
            O().x(peerUin.longValue());
        } else {
            if (i3 != 2) {
                return;
            }
            R().A(BaseConstants.ERR_SVR_COMM_SDKAPPID_FORBIDDEN, BaseConstants.ERR_SVR_COMM_REQ_FORBIDDEN, peerUin.longValue(), false);
            W().o(peerUin.longValue());
        }
    }

    public final Deferred<Boolean> Z(CoroutineScope scope, le3.b actionConfig) {
        Deferred<Boolean> async$default;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(actionConfig, "actionConfig");
        async$default = BuildersKt__Builders_commonKt.async$default(scope, null, null, new MiniHomeConnectedController$handleClickCoupleAction$1(this, actionConfig, null), 3, null);
        return async$default;
    }

    public final void a0() {
        MapMode mode;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment;
        MapModeInfo value = T().O1().getValue();
        if (value == null || (mode = value.getMode()) == null) {
            return;
        }
        QLog.i("MiniHomeConnectedController", 1, "onBackEvent, currMapMode: " + mode);
        if (this.startUpParams.getDirectExit()) {
            Fragment fragment = this.fragment;
            zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
            if (zPlanMiniHomeConnectedFragment != null) {
                zPlanMiniHomeConnectedFragment.Rh();
                return;
            }
            return;
        }
        int i3 = b.f334475a[mode.ordinal()];
        if (i3 == 1 || i3 == 2) {
            Fragment fragment2 = this.fragment;
            zPlanMiniHomeConnectedFragment = fragment2 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment2 : null;
            if (zPlanMiniHomeConnectedFragment != null) {
                zPlanMiniHomeConnectedFragment.Rh();
                return;
            }
            return;
        }
        if (i3 == 3) {
            r();
        } else if (i3 == 4 || i3 == 5) {
            d0();
        }
    }

    public final void b0(long refreshBlockUin) {
        R().C(refreshBlockUin);
    }

    public final void c0(int actionId) {
        QLog.i("MiniHomeConnectedController", 1, "refreshPanelLoadingWithPlayRsp, id: " + actionId);
        F().l(actionId, false);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object param) {
        StartUpParams startUpParams;
        QLog.i("MiniHomeConnectedController", 1, OperateCustomButton.OPERATE_CREATE);
        FragmentActivity activity = this.fragment.getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            QLog.i("MiniHomeConnectedController", 1, "create, intent null.");
            startUpParams = new StartUpParams(null, null, null, null, null, false, 63, null);
        } else {
            String stringExtra = intent.getStringExtra("uin");
            String stringExtra2 = intent.getStringExtra(ISchemeApi.KEY_REFERER);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            String str = stringExtra2;
            String stringExtra3 = intent.getStringExtra("subReferer");
            MapMode S = S(intent);
            String stringExtra4 = intent.getStringExtra(ISchemeApi.KEY_PAGE_DATA);
            startUpParams = new StartUpParams(str, stringExtra3, stringExtra, S, stringExtra4 != null ? URLDecoder.decode(stringExtra4, "UTF-8") : null, Intrinsics.areEqual(intent.getStringExtra("direct_exit"), "1"));
        }
        QLog.i("MiniHomeConnectedController", 1, String.valueOf(startUpParams));
        this.startUpParams = startUpParams;
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.zplan.minixwconnected.c) it.next()).create(startUpParams);
        }
        W().p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0() {
        Long longOrNull;
        String e16 = bb.f335811a.e();
        long longValue = (e16 == null || longOrNull == null) ? 0L : longOrNull.longValue();
        MiniHomeConnectMapComponent R = R();
        MapMode mapMode = MapMode.GLOBAL;
        R.z(mapMode, longValue);
        T().R1(new MapModeInfo(mapMode, null, null, null, 14, null));
        A();
    }

    public final void e0(String topMaskUrl, String bottomUrl, String bottomFocusUrl) {
        this.bottomMaskGlobalUrl = bottomUrl;
        this.bottomMaskFocusUrl = bottomFocusUrl;
        MapModeInfo value = T().O1().getValue();
        MapMode mode = value != null ? value.getMode() : null;
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            if (mode != MapMode.GLOBAL) {
                bottomUrl = bottomFocusUrl;
            }
            zPlanMiniHomeConnectedFragment.pi(topMaskUrl, bottomUrl);
        }
    }

    public final void f0(long uin) {
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.ii(uin);
        }
    }

    public final void g0(String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        MapModeInfo value = T().O1().getValue();
        MapMode mode = value != null ? value.getMode() : null;
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.ji(friendUin, mode);
        }
    }

    public final void i0() {
        O().F();
        W().s();
    }

    public final void k0() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            return;
        }
        x45.h recommendUserInfo = W().getRecommendUserInfo();
        this.currRecommendUserInfo = recommendUserInfo;
        if (recommendUserInfo != null) {
            R().H(recommendUserInfo);
        }
        W().p();
    }

    public final void r() {
        MapModeInfo value = T().O1().getValue();
        if (value != null) {
            z(value);
        }
    }

    public final void v(FlowerOpType opType, byte[] opData) {
        Intrinsics.checkNotNullParameter(opType, "opType");
        R().m(this.curFocusUin, opType, opData);
    }

    public final void x() {
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.ni();
        }
    }

    public final void y() {
        View f16 = G().f();
        if (f16 != null) {
            f16.setVisibility(8);
        }
        View E = V().E();
        if (E != null) {
            E.setVisibility(8);
        }
        MapModeInfo value = T().O1().getValue();
        if (value != null) {
            Long hostUin = value.getHostUin();
            if (hostUin != null) {
                R().z(MapMode.ACTION, hostUin.longValue());
            }
            T().R1(new MapModeInfo(MapMode.ACTION, value.getHostUin(), value.getHostHaveOwnRoom(), value.getHostName()));
        }
        Fragment fragment = this.fragment;
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.qi(F().k());
        }
    }

    public View X() {
        QLog.i("MiniHomeConnectedController", 1, "getTextureView");
        return R().w();
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectedController", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.zplan.minixwconnected.c) it.next()).createView();
        }
        LiveData<MapModeInfo> O1 = T().O1();
        LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        final Function1<MapModeInfo, Unit> function1 = new Function1<MapModeInfo, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$createView$2

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes34.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f334477a;

                static {
                    int[] iArr = new int[MapMode.values().length];
                    try {
                        iArr[MapMode.GLOBAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MapMode.FOCUS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MapMode.ACTION.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MapMode.STRANGER.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f334477a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapModeInfo mapModeInfo) {
                invoke2(mapModeInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MapModeInfo modeInfo) {
                QLog.i("MiniHomeConnectedController", 1, "mapModeViewModel observe, modeInfo: " + modeInfo + ".");
                int i3 = a.f334477a[modeInfo.getMode().ordinal()];
                if (i3 == 1) {
                    MiniHomeConnectedController.this.A();
                    return;
                }
                if (i3 == 2) {
                    MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectedController.this;
                    Intrinsics.checkNotNullExpressionValue(modeInfo, "modeInfo");
                    miniHomeConnectedController.z(modeInfo);
                } else {
                    if (i3 == 3) {
                        MiniHomeConnectedController.this.y();
                        return;
                    }
                    if (i3 != 4) {
                        QLog.e("MiniHomeConnectedController", 1, "mapModeInfo.observe error, mode: " + modeInfo.getMode());
                        return;
                    }
                    MiniHomeConnectedController miniHomeConnectedController2 = MiniHomeConnectedController.this;
                    Intrinsics.checkNotNullExpressionValue(modeInfo, "modeInfo");
                    miniHomeConnectedController2.B(modeInfo);
                }
            }
        };
        O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniHomeConnectedController.s(Function1.this, obj);
            }
        });
        LiveData<FlowerUiData> N1 = T().N1();
        LifecycleOwner viewLifecycleOwner2 = this.fragment.getViewLifecycleOwner();
        final Function1<FlowerUiData, Unit> function12 = new Function1<FlowerUiData, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$createView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FlowerUiData flowerUiData) {
                invoke2(flowerUiData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FlowerUiData flowerUiData) {
                MiniHomeConnectFriendFocusComponent O;
                MiniHomeConnectSelfFocusComponent V;
                FlowerBasicInfo basicInfo;
                Long hostUin = flowerUiData.getHostUin();
                String e16 = bb.f335811a.e();
                boolean areEqual = Intrinsics.areEqual(hostUin, e16 != null ? StringsKt__StringNumberConversionsKt.toLongOrNull(e16) : null);
                MiniHomeConnectedController.this.curScreenCoord = flowerUiData.getScreenCoord();
                if (areEqual) {
                    V = MiniHomeConnectedController.this.V();
                    Intrinsics.checkNotNullExpressionValue(flowerUiData, "flowerUiData");
                    V.F(flowerUiData);
                    MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectedController.this;
                    boolean z16 = false;
                    if (Intrinsics.areEqual(flowerUiData.getHostHaveFlower(), Boolean.TRUE)) {
                        FlowerData flowerData = flowerUiData.getFlowerData();
                        if (!((flowerData == null || (basicInfo = flowerData.getBasicInfo()) == null || basicInfo.getFlowerId() != 0) ? false : true)) {
                            z16 = true;
                        }
                    }
                    miniHomeConnectedController.h0(z16);
                } else {
                    O = MiniHomeConnectedController.this.O();
                    Intrinsics.checkNotNullExpressionValue(flowerUiData, "flowerUiData");
                    O.y(flowerUiData);
                }
                QLog.i("MiniHomeConnectedController", 1, "mapModeViewModel observe, flowerUiData: " + flowerUiData + ".");
            }
        };
        N1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniHomeConnectedController.t(Function1.this, obj);
            }
        });
        LiveData<FlowerOpRsp> M1 = T().M1();
        LifecycleOwner viewLifecycleOwner3 = this.fragment.getViewLifecycleOwner();
        final Function1<FlowerOpRsp, Unit> function13 = new Function1<FlowerOpRsp, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$createView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FlowerOpRsp flowerOpRsp) {
                invoke2(flowerOpRsp);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(FlowerOpRsp flowerOpRsp) {
                boolean z16;
                MiniHomeConnectFriendFocusComponent O;
                MiniHomeConnectSelfFocusComponent V;
                FlowerBasicInfo basicInfo;
                long j3;
                Long longOrNull;
                QLog.i("MiniHomeConnectedController", 1, "mapModeViewModel observe, flowerOpResult: " + flowerOpRsp + ".");
                FlowerOpRspData data = flowerOpRsp.getData();
                if (data == null) {
                    return;
                }
                String opMsg = data.getOpMsg();
                boolean z17 = false;
                if (!(opMsg == null || opMsg.length() == 0)) {
                    QLog.i("MiniHomeConnectedController", 1, "showQQToastInUiThread " + data.getOpMsg());
                    QQToastUtil.showQQToastInUiThread(data.getResult() ? 2 : 0, data.getOpMsg());
                    Fragment fragment = MiniHomeConnectedController.this.getFragment();
                    ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
                    if (zPlanMiniHomeConnectedFragment != null) {
                        zPlanMiniHomeConnectedFragment.hi(data);
                    }
                }
                if (!data.getResult()) {
                    if (AppSetting.isDebugVersion()) {
                        QQToastUtil.showQQToastInUiThread(1, "\u540e\u53f0\u5931\u8d25\uff0c\u4e0d\u5237UI");
                    }
                    QLog.e("MiniHomeConnectedController", 1, "\u540e\u53f0\u5931\u8d25\uff0c\u4e0d\u5237UI");
                    return;
                }
                String e16 = bb.f335811a.e();
                if (e16 != null) {
                    j3 = MiniHomeConnectedController.this.curFocusUin;
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(e16);
                    if (longOrNull != null && j3 == longOrNull.longValue()) {
                        z16 = true;
                        if (!z16) {
                            V = MiniHomeConnectedController.this.V();
                            Intrinsics.checkNotNullExpressionValue(flowerOpRsp, "flowerOpRsp");
                            V.G(flowerOpRsp);
                            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectedController.this;
                            FlowerData flowerData = data.getFlowerData();
                            if (flowerData != null && (basicInfo = flowerData.getBasicInfo()) != null && basicInfo.getFlowerId() == 0) {
                                z17 = true;
                            }
                            miniHomeConnectedController.h0(!z17);
                            return;
                        }
                        O = MiniHomeConnectedController.this.O();
                        Intrinsics.checkNotNullExpressionValue(flowerOpRsp, "flowerOpRsp");
                        O.z(flowerOpRsp);
                        return;
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
        };
        M1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zplan.minixwconnected.controller.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniHomeConnectedController.u(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        QLog.i("MiniHomeConnectedController", 1, "destroy");
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.zplan.minixwconnected.c) it.next()).destroy();
        }
    }

    public final void j0(long uin) {
        QLog.i("MiniHomeConnectedController", 1, "visitNeighbor");
        R().G(uin);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        QLog.i("MiniHomeConnectedController", 1, "pause");
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.zplan.minixwconnected.c) it.next()).pause();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        QLog.i("MiniHomeConnectedController", 1, "resume");
        Iterator<T> it = H().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.zplan.minixwconnected.c) it.next()).resume();
        }
        MapModeInfo value = T().O1().getValue();
        if (value != null) {
            if (value.getMode() == MapMode.STRANGER) {
                W().r(value);
                return;
            }
            if (value.getMode() == MapMode.FOCUS) {
                Long hostUin = value.getHostUin();
                String e16 = bb.f335811a.e();
                if (Intrinsics.areEqual(hostUin, e16 != null ? StringsKt__StringNumberConversionsKt.toLongOrNull(e16) : null)) {
                    return;
                }
                O().D(value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(boolean haveFlower) {
        ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment;
        if (haveFlower) {
            Fragment fragment = this.fragment;
            zPlanMiniHomeConnectedFragment = fragment instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment : null;
            if (zPlanMiniHomeConnectedFragment != null) {
                zPlanMiniHomeConnectedFragment.mi();
                return;
            }
            return;
        }
        Fragment fragment2 = this.fragment;
        zPlanMiniHomeConnectedFragment = fragment2 instanceof ZPlanMiniHomeConnectedFragment ? (ZPlanMiniHomeConnectedFragment) fragment2 : null;
        if (zPlanMiniHomeConnectedFragment != null) {
            zPlanMiniHomeConnectedFragment.ci();
        }
    }

    public static /* synthetic */ void w(MiniHomeConnectedController miniHomeConnectedController, FlowerOpType flowerOpType, byte[] bArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bArr = null;
        }
        miniHomeConnectedController.v(flowerOpType, bArr);
    }
}
