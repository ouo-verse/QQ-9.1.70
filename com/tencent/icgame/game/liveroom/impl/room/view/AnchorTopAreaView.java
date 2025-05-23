package com.tencent.icgame.game.liveroom.impl.room.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView;
import com.tencent.icgame.game.ui.widget.RoundCornerImageView;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.icgame.trpc.yes.common.PendantOuterClass$PendantMsg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.o;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qn4.BlockOptConfig;
import ru0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0002:\u0006\u0097\u0001\u0098\u0001MPB,\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\f\b\u0002\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001\u0012\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0007\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(J\u000e\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0013J\u0010\u0010/\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010-J\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u000202J\"\u00108\u001a\u00020\u00032\u0006\u00105\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0010\u00109\u001a\u00020\u00032\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u0010:\u001a\u00020\u00032\u0006\u00105\u001a\u00020\rH\u0016J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010<\u001a\u00020\u0003J\u000e\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0013J\u000e\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0007J\u0018\u0010A\u001a\u00020\u00032\u0006\u00105\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010B\u001a\u00020\u00032\u0006\u00105\u001a\u00020\rH\u0016J\u000e\u0010D\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0013J\u0006\u0010E\u001a\u00020\u0003J\b\u0010F\u001a\u00020\u0003H\u0014J\u0006\u0010G\u001a\u00020\u0003J\u0006\u0010H\u001a\u00020\u0003J\u0016\u0010L\u001a\u00020\u00032\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IR\u0018\u0010O\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\u0012R\u0016\u0010W\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010\u0012R\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010VR\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010VR\u0016\u0010_\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010cR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010gR\u0016\u0010k\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010jR\u0016\u0010l\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010VR$\u0010t\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0018\u0010w\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010aR\u0016\u0010z\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010VR\u0016\u0010&\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010VR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0004\u0010\u0082\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u008a\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u0089\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView;", "Landroid/widget/FrameLayout;", "", "", "T", "K", "G", "", "roomType", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "t", "r", "u", "", "anchorUid", HippyTKDListViewAdapter.X, "H", "I", "J", "", "y", "N", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "v", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "isAnchor", "setIsAnchor", "setAnchorTopHeadViewModel", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "l", "setListener", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "listener", "setUIVisibleChangedListener", "fromFloatWindow", "setFromFloatWindow", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "setLiveExtraInfo", MiniChatConstants.MINI_APP_LANDSCAPE, BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "setActivityContext", "isQQLive", "setQQLive", "Lpv0/a;", "audienceViewModel", "setAudienceViewModel", "roomId", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, UserInfo.SEX_FEMALE, "D", "E", "setLiveRoomInfo", "Y", "likeEnable", "X", VirtualAppProxy.KEY_GAME_ID, "setGameId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", NodeProps.VISIBLE, "setShowFansGroup", "V", NodeProps.ON_DETACHED_FROM_WINDOW, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "W", "", "Lcom/tencent/icgame/trpc/yes/common/PendantOuterClass$PendantMsg;", "mutableList", "w", "d", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "mListener", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "mUIVisibleChangedListener", "f", "mRoomId", tl.h.F, "Z", "mIsAnchor", "i", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "mHintView", "isDetachedFromWindow", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "mLiveRoomExtraInfo", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPermissionDelayTask", "Landroid/content/Context;", "mActivityContext", "mGameId", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "timiCmdListener", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "mPip", "Landroid/view/View$OnClickListener;", "L", "Landroid/view/View$OnClickListener;", "getMoreLivingClickListener", "()Landroid/view/View$OnClickListener;", "setMoreLivingClickListener", "(Landroid/view/View$OnClickListener;)V", "moreLivingClickListener", "M", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "fetchOperationAdsTaskForCancel", "P", "hasClickRequestPermission", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netEventHandler", "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/icgame/game/ui/widget/RoundCornerImageView;", "collapseIgv", "minimizeRoomBtn", "Lcom/tencent/icgame/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "U", "Lcom/tencent/icgame/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "topHeadView", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/e;", "headViewModel", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "moreLivingShowListener", "Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "getMoreLivingShowListener", "()Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "setMoreLivingShowListener", "(Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$e;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class AnchorTopAreaView extends FrameLayout {

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Integer> f115719a0;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<TianShuAdPosItemData> f115720b0;

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final Lazy<BlockOptConfig> f115721c0;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDetachedFromWindow;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private LiveRoomExtraInfo mLiveRoomExtraInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Runnable mPermissionDelayTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Context mActivityContext;

    /* renamed from: H, reason: from kotlin metadata */
    private int mGameId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IQQCmdPushCallback timiCmdListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mPip;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener moreLivingClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Runnable fetchOperationAdsTaskForCancel;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasClickRequestPermission;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean fromFloatWindow;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final INetEventHandler netEventHandler;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView collapseIgv;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView minimizeRoomBtn;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final AnchorTopHeadView topHeadView;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private com.tencent.icgame.game.liveroom.impl.room.toparea.e headViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mUIVisibleChangedListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnchor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long anchorUid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mHintView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "", "", NodeProps.VISIBLE, "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface c {
        void a(boolean visible);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "", "", "roomId", "", "c", "d", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface d {
        void a(long roomId);

        void b(long roomId);

        void c(long roomId);

        void d(long roomId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface e {
    }

    static {
        Lazy<BlockOptConfig> lazy;
        ArrayList<Integer> arrayList = new ArrayList<>();
        f115719a0 = arrayList;
        ArrayList<TianShuAdPosItemData> arrayList2 = new ArrayList<>();
        f115720b0 = arrayList2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BlockOptConfig>() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.AnchorTopAreaView$Companion$blockOptConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BlockOptConfig invoke() {
                return new BlockOptConfig(false, false, false, false, false, 31, null);
            }
        });
        f115721c0 = lazy;
        arrayList.add(878);
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 878;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList2.add(tianShuAdPosItemData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void G() {
        d dVar;
        if (this.hasClickRequestPermission && com.tencent.icgame.game.utils.e.b(getContext()) && (dVar = this.mListener) != null) {
            dVar.d(this.mRoomId);
        }
        this.hasClickRequestPermission = false;
    }

    private final void H() {
        this.collapseIgv.setVisibility(0);
    }

    private final void I() {
        boolean z16;
        if (this.mIsAnchor) {
            this.minimizeRoomBtn.setVisibility(8);
        }
        if (this.mLiveRoomExtraInfo.f114882f == 2) {
            this.minimizeRoomBtn.setVisibility(8);
        }
        c cVar = this.mUIVisibleChangedListener;
        if (cVar != null) {
            if (this.minimizeRoomBtn.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.a(z16);
        }
    }

    private final void J() {
        String str;
        if (!this.mIsAnchor && this.minimizeRoomBtn.getVisibility() == 0) {
            HashMap hashMap = new HashMap();
            if (this.isLandscape) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("icgame_screen_orientation", str);
            mm4.a b16 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11162a.a((ru0.a) b16, this.minimizeRoomBtn, false, null, "em_icgame_room_window", hashMap, 6, null);
        }
    }

    private final void K() {
        com.tencent.icgame.game.utils.e.e(getContext(), new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorTopAreaView.L(AnchorTopAreaView.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorTopAreaView.M(AnchorTopAreaView.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AnchorTopAreaView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this$0.getContext());
        this$0.hasClickRequestPermission = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AnchorTopAreaView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this$0.hasClickRequestPermission = false;
    }

    private final void N() {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        s(viewGroup);
        viewGroup.removeView(this.mHintView);
        viewGroup.addView(this.mHintView, new ViewGroup.LayoutParams(-1, -1));
        final View view = this.mHintView;
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        this.collapseIgv.getGlobalVisibleRect(rect);
        final int b16 = rect.bottom + uu0.a.b(3);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorTopAreaView.R(view, view2);
            }
        });
        TextView collapseTxv = (TextView) view.findViewById(R.id.u0g);
        collapseTxv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorTopAreaView.S(AnchorTopAreaView.this, view, view2);
            }
        });
        TextView endLiveTxv = (TextView) view.findViewById(R.id.uva);
        endLiveTxv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorTopAreaView.O(AnchorTopAreaView.this, view, view2);
            }
        });
        HashMap hashMap = new HashMap();
        mm4.a b17 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(collapseTxv, "collapseTxv");
        a.C11162a.a((ru0.a) b17, collapseTxv, false, null, "em_icgame_room_mini", hashMap, 6, null);
        mm4.a b18 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
        Intrinsics.checkNotNullExpressionValue(endLiveTxv, "endLiveTxv");
        a.C11162a.a((ru0.a) b18, endLiveTxv, false, null, "em_icgame_living_end", hashMap, 6, null);
        VideoReport.traversePage(viewGroup);
        post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.k
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.P(view, b16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(AnchorTopAreaView this$0, View hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        d dVar = this$0.mListener;
        if (dVar != null) {
            dVar.a(this$0.mRoomId);
        }
        hintView.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(final View hintView, int i3, AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final RelativeLayout relativeLayout = (RelativeLayout) hintView.findViewById(R.id.b9r);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i3;
        relativeLayout.setLayoutParams(layoutParams2);
        this$0.post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.l
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.Q(relativeLayout, hintView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(RelativeLayout relativeLayout, View hintView) {
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        relativeLayout.setVisibility(0);
        hintView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(View hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        hintView.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AnchorTopAreaView this$0, View hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        d dVar = this$0.mListener;
        if (dVar != null) {
            dVar.c(this$0.mRoomId);
        }
        hintView.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.g
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.U(AnchorTopAreaView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.f("netErrorToastTag", MiniBoxNoticeInfo.MIN_5)) {
            QQToast.makeText(this$0.getContext(), "\u5f53\u524d\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AnchorTopAreaView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (o.a()) {
            QLog.i("ICGameAnchorTopAreaView_", 1, "collapseIgv double click");
        } else if (this$0.mIsAnchor) {
            this$0.N();
        } else if (this$0.mPip) {
            d dVar = this$0.mListener;
            if (dVar != null) {
                dVar.c(this$0.mRoomId);
            }
        } else {
            d dVar2 = this$0.mListener;
            if (dVar2 != null) {
                dVar2.b(this$0.mRoomId);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AnchorTopAreaView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (o.a()) {
            QLog.i("ICGameAnchorTopAreaView_", 1, "minimizeBtn double click");
        } else {
            this$0.v();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AnchorTopAreaView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.T();
        }
    }

    private final void r() {
        String str;
        HashMap hashMap = new HashMap();
        if (!this.mIsAnchor) {
            if (this.isLandscape) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("icgame_screen_orientation", str);
            mm4.a b16 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11162a.a((ru0.a) b16, this.collapseIgv, false, null, "em_icgame_room_close", hashMap, 6, null);
        }
    }

    private final boolean s(ViewGroup parent) {
        if (this.mHintView == null) {
            this.mHintView = View.inflate(getContext(), R.layout.faw, null);
            return true;
        }
        return false;
    }

    private final com.tencent.icgame.game.liveroom.impl.room.toparea.e t(int roomType) {
        com.tencent.icgame.game.liveroom.impl.room.toparea.e eVar = this.headViewModel;
        if (eVar != null) {
            Intrinsics.checkNotNull(eVar);
            return eVar;
        }
        com.tencent.icgame.game.liveroom.impl.room.toparea.b bVar = new com.tencent.icgame.game.liveroom.impl.room.toparea.b();
        this.headViewModel = bVar;
        return bVar;
    }

    private final int u() {
        return this.mLiveRoomExtraInfo.f114882f;
    }

    private final void x(long anchorUid) {
        this.anchorUid = anchorUid;
    }

    private final boolean y() {
        if (this.minimizeRoomBtn.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void A(long roomId, boolean isAnchor) {
        this.mAegisLog.i("ICGameAnchorTopAreaView_", 1, "onEnterRoom roomId:" + roomId + ", isAnchor:" + isAnchor);
        this.mRoomId = roomId;
        this.mIsAnchor = isAnchor;
        this.topHeadView.setRoomType(u());
        this.topHeadView.D(roomId, isAnchor);
        H();
        I();
        J();
        r();
        ((fu0.c) qx0.a.b(fu0.c.class)).S1().a(this.timiCmdListener);
    }

    public void B(long roomId) {
        this.topHeadView.E(roomId);
        ((fu0.c) qx0.a.b(fu0.c.class)).S1().b(this.timiCmdListener);
        this.moreLivingClickListener = null;
    }

    public final void C(boolean isLandscape) {
        this.isLandscape = isLandscape;
        r();
        J();
        this.topHeadView.F(isLandscape);
    }

    public void D(long roomId) {
        this.topHeadView.G(roomId);
    }

    public void E(long roomId) {
        this.topHeadView.H(roomId);
    }

    public void F(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        this.mRoomId = roomId;
        this.mIsAnchor = isAnchor;
        this.topHeadView.setRoomType(u());
        this.topHeadView.I(roomId, isAnchor, videoUrl);
    }

    public final void V() {
        this.topHeadView.M();
        Runnable runnable = this.fetchOperationAdsTaskForCancel;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 128);
        }
        this.fetchOperationAdsTaskForCancel = null;
    }

    public final void W() {
        this.topHeadView.N();
    }

    public final void Y() {
        this.mAegisLog.i("ICGameAnchorTopAreaView_", 1, "\u4e3b\u52a8\u67e5\u8be2\u699c\u5355\u6570\u636e");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AppNetConnInfo.unregisterNetEventHandler(this.netEventHandler);
        super.onDetachedFromWindow();
        this.isDetachedFromWindow = true;
    }

    public final void setActivityContext(@Nullable Context context) {
        this.mActivityContext = context;
    }

    public final void setAnchorTopHeadViewModel() {
        this.topHeadView.setViewModel(new com.tencent.icgame.game.liveroom.impl.room.toparea.b());
    }

    public final void setAudienceViewModel(@NotNull pv0.a audienceViewModel) {
        Intrinsics.checkNotNullParameter(audienceViewModel, "audienceViewModel");
    }

    public final void setFromFloatWindow(boolean fromFloatWindow) {
        this.fromFloatWindow = fromFloatWindow;
    }

    public final void setGameId(int gameId) {
        this.mGameId = gameId;
    }

    public final void setIsAnchor(boolean isAnchor) {
        this.mIsAnchor = isAnchor;
        I();
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = owner;
        this.topHeadView.setLifecycle(owner);
    }

    public final void setListener(@NotNull d l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener = l3;
    }

    public final void setLiveExtraInfo(@NotNull LiveRoomExtraInfo extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.mLiveRoomExtraInfo = extraInfo;
        String string = extraInfo.E.getString("pip");
        boolean z16 = false;
        if (string != null && Boolean.parseBoolean(string)) {
            z16 = true;
        }
        this.mPip = z16;
        H();
        I();
        this.topHeadView.setViewModel(t(extraInfo.f114882f));
        this.topHeadView.J(this.mLiveRoomExtraInfo);
    }

    public final void setLiveRoomInfo(long anchorUid) {
        x(anchorUid);
    }

    public final void setMoreLivingClickListener(@Nullable View.OnClickListener onClickListener) {
        this.moreLivingClickListener = onClickListener;
    }

    public final void setQQLive(boolean isQQLive) {
        this.topHeadView.setQQLive();
    }

    public final void setUIVisibleChangedListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mUIVisibleChangedListener = listener;
    }

    public final void v() {
        if (!this.mIsAnchor) {
            this.mAegisLog.i("ICGameAnchorTopAreaView_", "handleClickMinimizeBtn:" + this.mRoomId);
            if (y()) {
                if (com.tencent.icgame.game.utils.e.b(getContext())) {
                    d dVar = this.mListener;
                    if (dVar != null) {
                        dVar.d(this.mRoomId);
                        return;
                    }
                    return;
                }
                K();
                return;
            }
            d dVar2 = this.mListener;
            if (dVar2 != null) {
                dVar2.b(this.mRoomId);
            }
        }
    }

    public final void w(@Nullable List<PendantOuterClass$PendantMsg> mutableList) {
        Object obj;
        if (mutableList != null) {
            Iterator<T> it = mutableList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((PendantOuterClass$PendantMsg) obj).content.sub_script.has()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
        }
    }

    public final void z() {
        this.mAegisLog.i("ICGameAnchorTopAreaView_", 1, "onActivityResume task:" + this.mPermissionDelayTask);
        Runnable runnable = this.mPermissionDelayTask;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorTopAreaView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLiveRoomExtraInfo = new LiveRoomExtraInfo();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        View.inflate(context, R.layout.fb_, this);
        View findViewById = findViewById(R.id.u0f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.collapseIgv)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
        this.collapseIgv = roundCornerImageView;
        roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.m(AnchorTopAreaView.this, view);
            }
        });
        View findViewById2 = findViewById(R.id.zbr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.minimizeRoomBtn)");
        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) findViewById2;
        this.minimizeRoomBtn = roundCornerImageView2;
        roundCornerImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.n(AnchorTopAreaView.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.f99535q2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.topHeadView)");
        this.topHeadView = (AnchorTopHeadView) findViewById3;
        this.mPermissionDelayTask = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.e
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.o(AnchorTopAreaView.this);
            }
        };
        this.timiCmdListener = new a();
        INetEventHandler iNetEventHandler = new INetEventHandler() { // from class: com.tencent.icgame.game.liveroom.impl.room.view.f
            @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
            public final void onNetChangeEvent(boolean z16) {
                AnchorTopAreaView.p(AnchorTopAreaView.this, z16);
            }
        };
        this.netEventHandler = iNetEventHandler;
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), iNetEventHandler);
    }

    public final void X(boolean likeEnable) {
    }

    public final void setMoreLivingShowListener(@Nullable e eVar) {
    }

    public final void setShowFansGroup(boolean visible) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/view/AnchorTopAreaView$a", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements IQQCmdPushCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            List<PendantOuterClass$PendantMsg> mutableListOf;
            MessageOuterClass$TimMsgBody a16 = bx0.a.f29349a.a(data);
            if (a16 != null) {
                AnchorTopAreaView.this.mAegisLog.i("ICGameAnchorTopAreaView_", 1, "handleCmdMsg type:" + a16.msg_type.get());
                if (a16.msg_type.get() == 93) {
                    AnchorTopAreaView anchorTopAreaView = AnchorTopAreaView.this;
                    PendantOuterClass$PendantMsg pendantOuterClass$PendantMsg = a16.content.pendant_msg;
                    Intrinsics.checkNotNullExpressionValue(pendantOuterClass$PendantMsg, "msg.content.pendant_msg");
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(pendantOuterClass$PendantMsg);
                    anchorTopAreaView.w(mutableListOf);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
