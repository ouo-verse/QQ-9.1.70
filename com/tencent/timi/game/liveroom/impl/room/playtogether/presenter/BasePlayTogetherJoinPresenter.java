package com.tencent.timi.game.liveroom.impl.room.playtogether.presenter;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.app.event.AnchorInputEvent;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.playtogether.event.DefaultRoleChangedEvent;
import com.tencent.timi.game.liveroom.impl.room.playtogether.u;
import com.tencent.timi.game.liveroom.impl.room.playtogether.util.SmobaBindAccountFragment;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import hk4.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;
import trpc.yes.common.SafeOuterClass$CheckUserIegRealNameAuthRsp;
import trpc.yes.common.SafeOuterClass$SafeCheckResult;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloLiveTeamInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamJoinBattleRsp;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamPlayerInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamPlayerInfoList;

@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0094\u0001\b&\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u009c\u0001\u009d\u0001\u009e\u0001B\t\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0006H&J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0013H$J\b\u0010\u001b\u001a\u00020\u0003H$J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u001dH$J\b\u0010\u001f\u001a\u00020\u0006H$J\b\u0010 \u001a\u00020\u0006H$J\n\u0010\"\u001a\u0004\u0018\u00010!H$J\b\u0010#\u001a\u00020\bH&J\u0010\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0010\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0004J\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u000e\u00102\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0013J\f\u00107\u001a\b\u0012\u0004\u0012\u00020605J\u0006\u00108\u001a\u00020\u0006J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000605J\u0006\u0010;\u001a\u00020:J\u0006\u0010<\u001a\u00020:J\u0006\u0010=\u001a\u00020:J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000605J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020*05J\u001e\u0010C\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@05J\u0006\u0010D\u001a\u00020:J\u0012\u0010E\u001a\u00020:2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0006\u0010F\u001a\u00020:J\b\u0010G\u001a\u00020:H&J\u000f\u0010H\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\bH\u0010IJ\u0012\u0010K\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020M0LH\u0016J\u000e\u0010O\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020PH&J \u0010T\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u000fH\u0004R\"\u0010Z\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010;\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010;\u001a\u0004\ba\u0010W\"\u0004\bb\u0010YR\u0018\u0010e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010dR$\u0010m\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR,\u0010p\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@0n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010oR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u0002060n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010oR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020*0n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010oR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010oR\u0016\u0010t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00060n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010oR(\u0010w\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010v0@0n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010oR$\u0010%\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R&\u0010(\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0014\n\u0004\bF\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0082\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00101R\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bG\u0010\u0083\u0001R\u0019\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u0086\u0001R!\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\b=\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u0091\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008e\u00010\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R$\u0010\u0016\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0014\n\u0004\b\t\u0010;\u001a\u0005\b\u0092\u0001\u0010W\"\u0005\b\u0093\u0001\u0010YR\u0017\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b&\u0010\u0095\u0001R\u0017\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bR\u0010\u0098\u0001\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "uid", "toUid", "", "isFollowed", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "role", "a0", "teamStatus", "c0", "Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;", "info", "e0", "d0", "Landroid/content/Context;", "context", "X", "dialogOpenFlag", h.F, "condition", "ctx", "Y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", HippyTKDListViewAdapter.X, "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lpf4/b;", "playTogetherPanelListener", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/u;", "dialog", "V", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "teamInfo", "O", "b0", "f", "Z", "g", "cxt", "j", "Landroidx/lifecycle/LiveData;", "", "D", "v", "w", "", "I", "H", "N", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "Lkotlin/Pair;", "", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamPlayerInfo;", UserInfo.SEX_FEMALE, "K", "M", "J", "L", "p", "()Ljava/lang/Long;", "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "T", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamJoinBattleRsp;", "result", ExifInterface.LATITUDE_SOUTH, "liveTeamInfo", "k", "d", "getYesGameId", "()I", "setYesGameId", "(I)V", "yesGameId", "e", "Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;", "E", "()Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;", "setTeamInfo", "(Ltrpc/yes/common/YoloTeamOuterClass$YoloLiveTeamInfo;)V", "getMethodSwitch", "setMethodSwitch", "methodSwitch", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "defaultRole", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "i", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "o", "()Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "U", "(Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;)V", "anchorGameInfo", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "teamUserInfoListLiveData", "teamDetailLiveData", "accountInfoLiveData", "statusLiveData", "joinCondition", "joinConditionLiveData", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$b;", "isTeamAvailableLiveData", "Lpf4/b;", "y", "()Lpf4/b;", "setPlayTogetherPanelListener", "(Lpf4/b;)V", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/u;", "r", "()Lcom/tencent/timi/game/liveroom/impl/room/playtogether/u;", "setDialog", "(Lcom/tencent/timi/game/liveroom/impl/room/playtogether/u;)V", "teamInfoFirstUpdate", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$b;", "guide", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$CommentJoinTeamStatus;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$CommentJoinTeamStatus;", "commentJoinTeamStatus", "Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveFollowMsgService;", "Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveFollowMsgService;", "t", "()Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveFollowMsgService;", "followService", "Landroidx/lifecycle/Observer;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "P", "Landroidx/lifecycle/Observer;", "defaultRoleObserver", "getDialogOpenFlag", "W", "com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$d", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$d;", "qqLiveReceiveFollowListener", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "qqLiveFollowStateChangeListener", "<init>", "()V", "CommentJoinTeamStatus", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BasePlayTogetherJoinPresenter implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: F, reason: from kotlin metadata */
    private int joinCondition;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private pf4.b playTogetherPanelListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private u dialog;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Guide guide;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final IQQLiveFollowMsgService followService;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Observer<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> defaultRoleObserver;

    /* renamed from: Q, reason: from kotlin metadata */
    private int dialogOpenFlag;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final d qqLiveReceiveFollowListener;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final IQQLiveFollowApi.IQQLiveFollowStateListener qqLiveFollowStateChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YoloTeamOuterClass$YoloLiveTeamInfo teamInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YesGameInfoOuterClass$YesGameRoleInfo defaultRole;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PremadesTeamServerOuterClass$AnchorGameInfo anchorGameInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int yesGameId = 101;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int methodSwitch = 1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>>> teamUserInfoListLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<CharSequence> teamDetailLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> accountInfoLiveData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> statusLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> joinConditionLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Boolean, Guide>> isTeamAvailableLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    private boolean teamInfoFirstUpdate = true;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private CommentJoinTeamStatus commentJoinTeamStatus = CommentJoinTeamStatus.NONE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$CommentJoinTeamStatus;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "INPUT_BOX_SHOW", "SEND_CLICK", "INPUT_BOX_HIDE", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public enum CommentJoinTeamStatus {
        NONE(0),
        INPUT_BOX_SHOW(1),
        SEND_CLICK(2),
        INPUT_BOX_HIDE(3);

        private final int value;

        CommentJoinTeamStatus(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isJoinTeamGuide", "()Z", "b", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "content", "<init>", "(ZLjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter$b, reason: from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class Guide {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isJoinTeamGuide;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        public Guide(boolean z16, @NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.isJoinTeamGuide = z16;
            this.content = content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Guide)) {
                return false;
            }
            Guide guide = (Guide) other;
            if (this.isJoinTeamGuide == guide.isJoinTeamGuide && Intrinsics.areEqual(this.content, guide.content)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isJoinTeamGuide;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "Guide(isJoinTeamGuide=" + this.isJoinTeamGuide + ", content=" + this.content + ")";
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$c", "Lpl4/d;", "Ltrpc/yes/common/SafeOuterClass$CheckUserIegRealNameAuthRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements pl4.d<SafeOuterClass$CheckUserIegRealNameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f378311a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BasePlayTogetherJoinPresenter f378312b;

        c(Context context, BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter) {
            this.f378311a = context;
            this.f378312b = basePlayTogetherJoinPresenter;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable SafeOuterClass$CheckUserIegRealNameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("BasePlayTogetherJoinPresenter_", "CheckUserRealNameAuthServlet failed: errorCode == " + timiErrCode + ", errorMessage == " + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable SafeOuterClass$CheckUserIegRealNameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult;
            Activity activity = (Activity) this.f378311a;
            if (response != null) {
                safeOuterClass$SafeCheckResult = response.safe_check_result;
            } else {
                safeOuterClass$SafeCheckResult = null;
            }
            if (!com.tencent.timi.game.room.impl.util.e.a(activity, safeOuterClass$SafeCheckResult)) {
                BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.f378312b;
                basePlayTogetherJoinPresenter.Y(basePlayTogetherJoinPresenter.joinCondition, this.f378311a);
                l.i("BasePlayTogetherJoinPresenter_", "CheckUserRealNameAuthServlet success, and through safe check");
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$e", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamJoinBattleRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements IResultListener<YoloTeamOuterClass$YoloTeamJoinBattleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f378314a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BasePlayTogetherJoinPresenter f378315b;

        e(Context context, BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter) {
            this.f378314a = context;
            this.f378315b = basePlayTogetherJoinPresenter;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloTeamOuterClass$YoloTeamJoinBattleRsp result) {
            SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult;
            YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo;
            PBInt32Field pBInt32Field;
            YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo2;
            YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo;
            Activity activity = (Activity) this.f378314a;
            YoloRoomOuterClass$YoloCommonGameRouteInfo yoloRoomOuterClass$YoloCommonGameRouteInfo = null;
            if (result != null) {
                safeOuterClass$SafeCheckResult = result.ieg_real_name_result;
            } else {
                safeOuterClass$SafeCheckResult = null;
            }
            if (!com.tencent.timi.game.room.impl.util.e.a(activity, safeOuterClass$SafeCheckResult)) {
                if (this.f378315b.joinCondition == 2) {
                    com.tencent.timi.game.ui.widget.f.a("\u5df2\u5173\u6ce8\uff0c\u6210\u529f\u4e0a\u8f66\u3002");
                } else if (this.f378315b.joinCondition == 1) {
                    com.tencent.timi.game.ui.widget.f.a("\u5df2\u8bc4\u8bba\uff0c\u6210\u529f\u4e0a\u8f66\u3002");
                }
                if (result != null && (yoloTeamOuterClass$YoloLiveTeamInfo2 = result.team_info) != null && (yoloRoomOuterClass$YoloGameRouteInfo = yoloTeamOuterClass$YoloLiveTeamInfo2.game_route_info) != null) {
                    yoloRoomOuterClass$YoloCommonGameRouteInfo = yoloRoomOuterClass$YoloGameRouteInfo.common_game_route_info;
                }
                String str = YoloRoomManager.u2(yoloRoomOuterClass$YoloCommonGameRouteInfo, ((ll4.a) mm4.b.b(ll4.a.class)).E()).schema.get();
                if (result != null && (yoloTeamOuterClass$YoloLiveTeamInfo = result.team_info) != null && (pBInt32Field = yoloTeamOuterClass$YoloLiveTeamInfo.game_id) != null) {
                    int i3 = pBInt32Field.get();
                    Context context = this.f378314a;
                    BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.f378315b;
                    hg4.d.q(i3, str, (Activity) context);
                    basePlayTogetherJoinPresenter.S(result);
                }
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.a(errorMessage);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$f", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements IQQLiveCheckFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f378317b;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$f$a", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a implements IQQLiveFollowCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ BasePlayTogetherJoinPresenter f378318a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f378319b;

            a(BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter, Context context) {
                this.f378318a = basePlayTogetherJoinPresenter;
                this.f378319b = context;
            }

            @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
            public void onFail(int errCode, @Nullable String errMsg) {
                l.e("BasePlayTogetherJoinPresenter_", "followAnchor # errCode: " + errCode + "; errMsg: " + errMsg);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
            public void onSuccess() {
                u dialog = this.f378318a.getDialog();
                if (dialog != null) {
                    dialog.dismissDialog();
                }
                if (this.f378318a.getTeamInfo() != null) {
                    this.f378318a.T(this.f378319b);
                }
            }
        }

        f(Context context) {
            this.f378317b = context;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            l.e("BasePlayTogetherJoinPresenter_", "checkFollowAnchor # errCode: " + errCode + "; errMsg: " + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            if (isFollow == 1) {
                BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = BasePlayTogetherJoinPresenter.this;
                basePlayTogetherJoinPresenter.b0(basePlayTogetherJoinPresenter.joinCondition);
                u dialog = BasePlayTogetherJoinPresenter.this.getDialog();
                if (dialog != null) {
                    dialog.dismissDialog();
                }
                if (BasePlayTogetherJoinPresenter.this.getTeamInfo() != null) {
                    BasePlayTogetherJoinPresenter.this.T(this.f378317b);
                    return;
                }
                return;
            }
            TGLiveFollowManager.f377684a.h(BasePlayTogetherJoinPresenter.this.getFollowService(), BasePlayTogetherJoinPresenter.this.q(), BasePlayTogetherJoinPresenter.this.B(), new a(BasePlayTogetherJoinPresenter.this, this.f378317b));
        }
    }

    public BasePlayTogetherJoinPresenter() {
        IQQLiveFollowMsgService iQQLiveFollowMsgService;
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            iQQLiveFollowMsgService = f16.getFollowMsgService();
        } else {
            iQQLiveFollowMsgService = null;
        }
        this.followService = iQQLiveFollowMsgService;
        this.defaultRoleObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BasePlayTogetherJoinPresenter.i(BasePlayTogetherJoinPresenter.this, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
            }
        };
        this.dialogOpenFlag = -1;
        this.qqLiveReceiveFollowListener = new d();
        this.qqLiveFollowStateChangeListener = new IQQLiveFollowApi.IQQLiveFollowStateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.e
            @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
            public final void onFollowStateChange(long j3, long j16, int i3, String str) {
                BasePlayTogetherJoinPresenter.P(BasePlayTogetherJoinPresenter.this, j3, j16, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(BasePlayTogetherJoinPresenter this$0, long j3, long j16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q(j3, j16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(long uid, long toUid, int isFollowed) {
        long j3;
        LiveUserInfo selfUserInfo = ((jg4.b) mm4.b.b(jg4.b.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            j3 = selfUserInfo.uid;
        } else {
            j3 = 0;
        }
        if (j3 == uid && q() == toUid) {
            l.h("BasePlayTogetherJoinPresenter_", 1, "refreshFollowState uid:" + MobileQQ.getShortUinStr(String.valueOf(uid)) + ",toUid:" + MobileQQ.getShortUinStr(String.valueOf(toUid)) + ",isFollowed:" + isFollowed);
            b0(this.joinCondition);
        }
    }

    private final void X(Context context) {
        IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followService;
        if (iQQLiveFollowMsgService == null) {
            return;
        }
        TGLiveFollowManager.f377684a.f(iQQLiveFollowMsgService, q(), new f(context));
    }

    private final void a0(YesGameInfoOuterClass$YesGameRoleInfo role) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        if (role != null && (pBStringField = role.role_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.accountInfoLiveData.postValue("\u9700\u7ed1\u5b9a\u738b\u8005\u5e10\u6237");
            return;
        }
        this.accountInfoLiveData.postValue(str + "/" + com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.m(role));
    }

    private final void c0(int teamStatus) {
        l.i("BasePlayTogetherJoinPresenter_", "updateStatus == " + teamStatus);
        this.statusLiveData.postValue(Integer.valueOf(teamStatus));
    }

    private final void d0(YoloTeamOuterClass$YoloLiveTeamInfo info) {
        boolean z16;
        String str;
        String str2;
        if (!M(info)) {
            this.teamDetailLiveData.postValue(SpannableString.valueOf(""));
            return;
        }
        if (info == null) {
            return;
        }
        if (info.game_route_info.game_status.get() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "\u6e38\u620f\u4e2d";
        } else {
            str = "\u7ec4\u961f\u4e2d";
        }
        MutableLiveData<CharSequence> mutableLiveData = this.teamDetailLiveData;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" " + info.game_data_info.common_game_data_info.game_desc.get() + " ");
        SpannableString spannableString = new SpannableString(str);
        if (z16) {
            str2 = "#FFA551";
        } else {
            str2 = "#00CC8F";
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), 0, str.length(), 33);
        Unit unit = Unit.INSTANCE;
        mutableLiveData.postValue(spannableStringBuilder.append((CharSequence) spannableString));
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e0(YoloTeamOuterClass$YoloLiveTeamInfo info) {
        boolean z16;
        PBRepeatMessageField<YoloTeamOuterClass$YoloTeamPlayerInfo> pBRepeatMessageField;
        int i3;
        int i16;
        Guide guide;
        PBRepeatMessageField<YoloTeamOuterClass$YoloTeamPlayerInfo> pBRepeatMessageField2;
        List<YoloTeamOuterClass$YoloTeamPlayerInfo> list;
        boolean z17;
        PBRepeatMessageField<YoloTeamOuterClass$YoloTeamPlayerInfo> pBRepeatMessageField3;
        List<YoloTeamOuterClass$YoloTeamPlayerInfo> list2;
        this.teamInfo = info;
        b0(info.game_data_info.common_game_data_info.qq_live_room_config.enter_condition.get());
        if (info.game_route_info.game_status.get() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<YoloTeamOuterClass$YoloTeamPlayerInfo> list3 = null;
        if (this.teamInfoFirstUpdate && L()) {
            if (z16) {
                guide = new Guide(false, "\u6765\u548c\u4e3b\u64ad\u4e00\u8d77\u73a9\u5427");
            } else {
                YoloTeamOuterClass$YoloTeamPlayerInfoList yoloTeamOuterClass$YoloTeamPlayerInfoList = info.team_player_info_list;
                if (yoloTeamOuterClass$YoloTeamPlayerInfoList != null && (pBRepeatMessageField3 = yoloTeamOuterClass$YoloTeamPlayerInfoList.player_list) != null && (list2 = pBRepeatMessageField3.get()) != null) {
                    i3 = list2.size();
                } else {
                    i3 = 0;
                }
                YoloTeamOuterClass$YoloTeamPlayerInfoList yoloTeamOuterClass$YoloTeamPlayerInfoList2 = info.team_player_info_list;
                if (yoloTeamOuterClass$YoloTeamPlayerInfoList2 != null && (pBRepeatMessageField2 = yoloTeamOuterClass$YoloTeamPlayerInfoList2.player_list) != null && (list = pBRepeatMessageField2.get()) != null) {
                    List<YoloTeamOuterClass$YoloTeamPlayerInfo> list4 = list;
                    if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                        Iterator<T> it = list4.iterator();
                        i16 = 0;
                        while (it.hasNext()) {
                            if (((YoloTeamOuterClass$YoloTeamPlayerInfo) it.next()).status.get() != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && (i16 = i16 + 1) < 0) {
                                CollectionsKt__CollectionsKt.throwCountOverflow();
                            }
                        }
                        if (i3 != 0) {
                            guide = null;
                        } else {
                            guide = new Guide(true, "\u4e3b\u64ad\u6b63\u5728\u7b49\u5f85\u961f\u53cb (" + i16 + "/" + i3 + ")");
                        }
                    }
                }
                i16 = 0;
                if (i3 != 0) {
                }
            }
            this.guide = guide;
        }
        this.teamInfoFirstUpdate = false;
        this.isTeamAvailableLiveData.postValue(TuplesKt.to(Boolean.valueOf(M(info)), this.guide));
        c0(info.status.get());
        d0(info);
        Integer valueOf = Integer.valueOf(info.game_data_info.common_game_data_info.create_type.get());
        YoloTeamOuterClass$YoloTeamPlayerInfoList yoloTeamOuterClass$YoloTeamPlayerInfoList3 = info.team_player_info_list;
        if (yoloTeamOuterClass$YoloTeamPlayerInfoList3 != null && (pBRepeatMessageField = yoloTeamOuterClass$YoloTeamPlayerInfoList3.player_list) != null) {
            list3 = pBRepeatMessageField.get();
        }
        if (list3 == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        this.teamUserInfoListLiveData.postValue(new Pair<>(valueOf, list3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BasePlayTogetherJoinPresenter this$0, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo2 = null;
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            yesGameInfoOuterClass$YesGameRoleInfo = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info;
        } else {
            yesGameInfoOuterClass$YesGameRoleInfo = null;
        }
        this$0.defaultRole = yesGameInfoOuterClass$YesGameRoleInfo;
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp != null) {
            yesGameInfoOuterClass$YesGameRoleInfo2 = yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info;
        }
        this$0.a0(yesGameInfoOuterClass$YesGameRoleInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(BasePlayTogetherJoinPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new AnchorInputEvent(this$0.B(), "", true));
    }

    @NotNull
    public final String A() {
        Integer num;
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo;
        PBInt32Field pBInt32Field;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null && (yoloRoomOuterClass$YoloGameDataInfo = yoloTeamOuterClass$YoloLiveTeamInfo.game_data_info) != null && (yoloRoomOuterClass$YoloCommonGameDataInfo = yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info) != null && (pBInt32Field = yoloRoomOuterClass$YoloCommonGameDataInfo.game_mode) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            return "1";
        }
        if (num != null && num.intValue() == 2) {
            return "2";
        }
        return "0";
    }

    public abstract long B();

    @NotNull
    public final LiveData<Integer> C() {
        return this.statusLiveData;
    }

    @NotNull
    public final LiveData<CharSequence> D() {
        return this.teamDetailLiveData;
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final YoloTeamOuterClass$YoloLiveTeamInfo getTeamInfo() {
        return this.teamInfo;
    }

    @NotNull
    public final LiveData<Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>>> F() {
        return this.teamUserInfoListLiveData;
    }

    @Nullable
    protected abstract LiveUserInfo G();

    public final boolean H() {
        return TGLiveFollowManager.f377684a.n(q());
    }

    public final boolean I() {
        YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo;
        PBInt32Field pBInt32Field;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo == null || (yoloRoomOuterClass$YoloGameRouteInfo = yoloTeamOuterClass$YoloLiveTeamInfo.game_route_info) == null || (pBInt32Field = yoloRoomOuterClass$YoloGameRouteInfo.game_status) == null || pBInt32Field.get() != 3) {
            return false;
        }
        return true;
    }

    public final boolean J() {
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo;
        YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig;
        PBInt32Field pBInt32Field;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        boolean z16 = false;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null && (yoloRoomOuterClass$YoloGameDataInfo = yoloTeamOuterClass$YoloLiveTeamInfo.game_data_info) != null && (yoloRoomOuterClass$YoloCommonGameDataInfo = yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info) != null && (yoloRoomOuterClass$QQLiveRoomConfig = yoloRoomOuterClass$YoloCommonGameDataInfo.qq_live_room_config) != null && (pBInt32Field = yoloRoomOuterClass$QQLiveRoomConfig.enter_condition) != null && pBInt32Field.get() == 5) {
            z16 = true;
        }
        return !z16;
    }

    public final boolean K() {
        long j3 = ((ll4.a) mm4.b.b(ll4.a.class)).E().uid.get();
        Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>> value = this.teamUserInfoListLiveData.getValue();
        if (value != null && !value.getSecond().isEmpty()) {
            Iterator<YoloTeamOuterClass$YoloTeamPlayerInfo> it = value.getSecond().iterator();
            while (it.hasNext()) {
                if (j3 == it.next().user_id.uid.get()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public abstract boolean L();

    protected boolean M(@Nullable YoloTeamOuterClass$YoloLiveTeamInfo info) {
        boolean z16;
        boolean z17;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        if (info == null) {
            return false;
        }
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null && (pBInt32Field2 = yoloTeamOuterClass$YoloLiveTeamInfo.status) != null && pBInt32Field2.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo2 = this.teamInfo;
            if (yoloTeamOuterClass$YoloLiveTeamInfo2 != null && (pBInt32Field = yoloTeamOuterClass$YoloLiveTeamInfo2.status) != null && pBInt32Field.get() == 3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        if (info.game_data_info.common_game_data_info.qq_live_room_config.enter_condition.get() == 5) {
            return false;
        }
        return true;
    }

    public final boolean N() {
        int i3;
        YoloTeamOuterClass$YoloTeamPlayerInfoList yoloTeamOuterClass$YoloTeamPlayerInfoList;
        PBRepeatMessageField<YoloTeamOuterClass$YoloTeamPlayerInfo> pBRepeatMessageField;
        List<YoloTeamOuterClass$YoloTeamPlayerInfo> list;
        boolean z16;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null && (yoloTeamOuterClass$YoloTeamPlayerInfoList = yoloTeamOuterClass$YoloLiveTeamInfo.team_player_info_list) != null && (pBRepeatMessageField = yoloTeamOuterClass$YoloTeamPlayerInfoList.player_list) != null && (list = pBRepeatMessageField.get()) != null) {
            List<YoloTeamOuterClass$YoloTeamPlayerInfo> list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                i3 = 0;
            } else {
                Iterator<T> it = list2.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (((YoloTeamOuterClass$YoloTeamPlayerInfo) it.next()).status.get() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    public final void O(@Nullable YoloTeamOuterClass$YoloLiveTeamInfo teamInfo) {
        if (teamInfo != null) {
            e0(teamInfo);
        }
    }

    public final void R(@Nullable pf4.b playTogetherPanelListener) {
        this.playTogetherPanelListener = playTogetherPanelListener;
    }

    public abstract void S(@NotNull YoloTeamOuterClass$YoloTeamJoinBattleRsp result);

    public final void T(@NotNull Context context) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null) {
            b.C10448b c10448b = new b.C10448b();
            c10448b.f405225b = s();
            c10448b.f405226c = u();
            LiveUserInfo G = G();
            Integer num = null;
            if (G != null) {
                str = G.nick;
            } else {
                str = null;
            }
            c10448b.f405227d = str;
            LiveUserInfo G2 = G();
            if (G2 != null) {
                str2 = G2.headUrl;
            } else {
                str2 = null;
            }
            c10448b.f405228e = str2;
            LiveUserInfo G3 = G();
            if (G3 != null) {
                num = Integer.valueOf(G3.sex);
            }
            Intrinsics.checkNotNull(num);
            c10448b.f405229f = num.intValue();
            c10448b.f405224a = yoloTeamOuterClass$YoloLiveTeamInfo.team_id.get();
            hk4.b.a(c10448b, new e(context, this));
        }
    }

    public final void U(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo) {
        this.anchorGameInfo = premadesTeamServerOuterClass$AnchorGameInfo;
    }

    public final void V(@Nullable u dialog) {
        this.dialog = dialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W(int i3) {
        this.dialogOpenFlag = i3;
    }

    protected abstract void Y(int condition, @NotNull Context ctx);

    public final void Z() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followService;
        if (iQQLiveFollowMsgService != null) {
            iQQLiveFollowMsgService.delFollowMessageListener(this.qqLiveReceiveFollowListener);
        }
        TGLiveFollowManager.f377684a.w(this.qqLiveFollowStateChangeListener);
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((i) mm4.b.b(i.class)).B2(this.yesGameId);
        if (B2 != null) {
            B2.removeObserver(this.defaultRoleObserver);
        }
    }

    protected final void b0(int condition) {
        l.i("BasePlayTogetherJoinPresenter_", "updateJoinCondition == " + condition);
        this.joinCondition = condition;
        this.joinConditionLiveData.postValue(Integer.valueOf(condition));
    }

    public final void f() {
        SimpleEventBus.getInstance().registerReceiver(this);
        IQQLiveFollowMsgService iQQLiveFollowMsgService = this.followService;
        if (iQQLiveFollowMsgService != null) {
            iQQLiveFollowMsgService.addFollowMessageListener(this.qqLiveReceiveFollowListener);
        }
        TGLiveFollowManager.f377684a.u(this.qqLiveFollowStateChangeListener);
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((i) mm4.b.b(i.class)).B2(this.yesGameId);
        if (B2 != null) {
            B2.observeForever(this.defaultRoleObserver);
        }
    }

    public final void g(@NotNull final Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        u uVar = this.dialog;
        if (uVar != null) {
            uVar.dismissDialog();
        }
        if (this.defaultRole == null) {
            com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.g(new Function1<Boolean, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter$bindRole$1
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
                    if (z16) {
                        SmobaBindAccountFragment.INSTANCE.a(ctx, Long.valueOf(this.B()), this.x());
                    } else {
                        com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.n(ctx);
                    }
                }
            });
        } else {
            SmobaBindAccountFragment.INSTANCE.a(ctx, Long.valueOf(B()), x());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(DefaultRoleChangedEvent.class);
        return arrayList;
    }

    public abstract void h(int dialogOpenFlag);

    public final void j(@NotNull Context cxt) {
        Intrinsics.checkNotNullParameter(cxt, "cxt");
        if (!I() && !N() && getJoinCondition() != 5) {
            ((pl4.c) mm4.b.b(pl4.c.class)).F1(vk4.a.d(), SafeOuterClass$CheckUserIegRealNameAuthRsp.class, new c(cxt, this));
            return;
        }
        u uVar = this.dialog;
        if (uVar != null) {
            uVar.dismissDialog();
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(int condition, @NotNull Context ctx, @NotNull YoloTeamOuterClass$YoloLiveTeamInfo liveTeamInfo) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(liveTeamInfo, "liveTeamInfo");
        this.teamInfo = liveTeamInfo;
        if (liveTeamInfo != null) {
            int i3 = liveTeamInfo.game_data_info.common_game_data_info.qq_live_room_config.enter_condition.get();
            if (condition != i3) {
                com.tencent.timi.game.ui.widget.f.c("\u4e3b\u64ad\u4fee\u6539\u4e86\u4e0a\u8f66\u6761\u4ef6\uff0c\u518d\u91cd\u65b0\u52a0\u5165\u5427");
                b0(i3);
                return;
            }
            int i16 = this.joinCondition;
            if (i16 != 2) {
                if (i16 != 4) {
                    u uVar = this.dialog;
                    if (uVar != null) {
                        uVar.dismissDialog();
                    }
                    w.d(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            BasePlayTogetherJoinPresenter.l(BasePlayTogetherJoinPresenter.this);
                        }
                    }, 700L);
                    this.commentJoinTeamStatus = CommentJoinTeamStatus.INPUT_BOX_SHOW;
                    return;
                }
                u uVar2 = this.dialog;
                if (uVar2 != null) {
                    uVar2.dismissDialog();
                }
                if (this.teamInfo != null) {
                    T(ctx);
                    return;
                }
                return;
            }
            X(ctx);
        }
    }

    public abstract void m();

    @NotNull
    public final LiveData<String> n() {
        return this.accountInfoLiveData;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final PremadesTeamServerOuterClass$AnchorGameInfo getAnchorGameInfo() {
        return this.anchorGameInfo;
    }

    @Nullable
    public final Long p() {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        PBUInt64Field pBUInt64Field;
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo = this.teamInfo;
        if (yoloTeamOuterClass$YoloLiveTeamInfo != null && (commonOuterClass$QQUserId = yoloTeamOuterClass$YoloLiveTeamInfo.create_user_id) != null && (pBUInt64Field = commonOuterClass$QQUserId.uid) != null) {
            return Long.valueOf(pBUInt64Field.get());
        }
        return null;
    }

    protected abstract long q();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: r, reason: from getter */
    public final u getDialog() {
        return this.dialog;
    }

    protected abstract int s();

    @Nullable
    /* renamed from: t, reason: from getter */
    protected final IQQLiveFollowMsgService getFollowService() {
        return this.followService;
    }

    protected abstract int u();

    /* renamed from: v, reason: from getter */
    public final int getJoinCondition() {
        return this.joinCondition;
    }

    @NotNull
    public final LiveData<Integer> w() {
        return this.joinConditionLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract LiveRoomExtraInfo x();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: y, reason: from getter */
    public final pf4.b getPlayTogetherPanelListener() {
        return this.playTogetherPanelListener;
    }

    @NotNull
    public final String z() {
        if (this.dialogOpenFlag == 1) {
            return "0";
        }
        return "1";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter$d", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IQQLiveReceiveFollowListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFollowReceive(@Nullable FollowPushMessage followPushMessage) {
            if (followPushMessage != null) {
                BasePlayTogetherJoinPresenter.this.Q(followPushMessage.uid, followPushMessage.toUid, followPushMessage.type);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
