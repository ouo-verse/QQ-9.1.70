package com.tencent.timi.game.liveroom.impl.room.inscription;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.BaseLiveGameInfoView;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import fh4.g;
import java.io.IOException;
import java.util.LinkedHashMap;
import jg4.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pj4.k;
import tl.h;
import trpc.yes.common.MessageOuterClass$AnchorEquipStatusNotifyMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001L\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\"\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u001a\u0010\"\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 J\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\"\u00104\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u00106\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010/R\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010/R\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010/\u001a\u0004\bI\u00101\"\u0004\bJ\u00103R\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010/R\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010M\u00a8\u0006U"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/inscription/LivingInscriptionInterEntranceView;", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/BaseLiveGameInfoView;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "p", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "msg", "t", "", "rooid", "r", "u", "o", "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "e", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "roomId", "isAnchor", AppConstants.Key.KEY_QZONE_VIDEO_URL, "onPreload", "onPageIn", "onPageOut", "Lcom/tencent/mobileqq/qqlive/api/room/IAudienceRoom;", "audienceInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "extraRoom", "setLiveRoomInfo", "anchorId", "", VirtualAppProxy.KEY_GAME_ID, "onEnterRoom", "onExitRoom", h.F, "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoomMessage;", "i", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoomMessage;", "liveRoomMessage", "Z", DomainData.DOMAIN_NAME, "()Z", "setSettingEntranceShowFlag", "(Z)V", "settingEntranceShowFlag", BdhLogUtil.LogTag.Tag_Conn, "J", "getAnchorId", "()J", "setAnchorId", "(J)V", "D", "I", "getGameId", "()I", "setGameId", "(I)V", "E", "getRoomId", "setRoomId", UserInfo.SEX_FEMALE, "isDestroyed", "G", MiniChatConstants.MINI_APP_LANDSCAPE, "H", "isInAnchorState", "setInAnchorState", "isReport", "com/tencent/timi/game/liveroom/impl/room/inscription/LivingInscriptionInterEntranceView$a", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/LivingInscriptionInterEntranceView$a;", "statusListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LivingInscriptionInterEntranceView extends BaseLiveGameInfoView implements IRoomWidget {

    /* renamed from: C, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: D, reason: from kotlin metadata */
    private int gameId;

    /* renamed from: E, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isInAnchorState;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isReport;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final a statusListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ILiveRoomMessage liveRoomMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean settingEntranceShowFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/inscription/LivingInscriptionInterEntranceView$a", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IQQCmdPushCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            l.e(LivingInscriptionInterEntranceView.this.TAG, "statusListener onError " + errCode + " " + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            boolean z16;
            l.i(LivingInscriptionInterEntranceView.this.TAG, "IQQCmdPushCallback ");
            if (data != null) {
                MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
                try {
                    messageOuterClass$TimMsgBody.mergeFrom(data);
                    z16 = true;
                } catch (IOException e16) {
                    l.e(LivingInscriptionInterEntranceView.this.TAG, "statusListener onError " + e16);
                    z16 = false;
                }
                if (z16) {
                    LivingInscriptionInterEntranceView.this.t(messageOuterClass$TimMsgBody);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LivingInscriptionInterEntranceView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String m() {
        String str;
        boolean contains$default;
        CharSequence text;
        if (getVisibility() == 0) {
            TextView textView = getBinding().f420791c;
            if (textView == null || (text = textView.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\u5e38\u7528\u82f1\u96c4", false, 2, (Object) null);
            if (contains$default) {
                return "1";
            }
            return "2";
        }
        return "0";
    }

    private final boolean p() {
        long j3;
        LiveUserInfo selfUserInfo;
        b bVar = (b) mm4.b.b(b.class);
        if (bVar != null && (selfUserInfo = bVar.getSelfUserInfo()) != null) {
            j3 = selfUserInfo.uid;
        } else {
            j3 = 0;
        }
        if (j3 == this.anchorId) {
            return true;
        }
        return false;
    }

    private final boolean q(GetAnchorRoomInfoRequest.a result) {
        if (result == null || this.roomId != result.getRoomId()) {
            return false;
        }
        return true;
    }

    private final void r(long rooid) {
        ILiveRoomMessage iLiveRoomMessage;
        b bVar = (b) mm4.b.b(b.class);
        if (bVar != null) {
            iLiveRoomMessage = bVar.k(rooid);
        } else {
            iLiveRoomMessage = null;
        }
        this.liveRoomMessage = iLiveRoomMessage;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.registerHighPriorityListener(k.f426383a.a(), this.statusListener);
        }
        ((b) mm4.b.b(b.class)).Y1(this.isInAnchorState).a(this.statusListener);
    }

    private final void s() {
        String str;
        if (this.isReport) {
            return;
        }
        this.isReport = true;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qqlive_equip_status", m());
        if (!p()) {
            if (this.isLandscape) {
                str = "1";
            } else {
                str = "0";
            }
            linkedHashMap.put("qqlive_screen_orientation", str);
        }
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this, true, null, "em_qqlive_equip_entrance", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(MessageOuterClass$TimMsgBody msg2) {
        int i3;
        String str;
        MessageOuterClass$AnchorEquipStatusNotifyMsg messageOuterClass$AnchorEquipStatusNotifyMsg;
        PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo;
        MessageOuterClass$AnchorEquipStatusNotifyMsg messageOuterClass$AnchorEquipStatusNotifyMsg2;
        PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo2;
        PBStringField pBStringField;
        MessageOuterClass$AnchorEquipStatusNotifyMsg messageOuterClass$AnchorEquipStatusNotifyMsg3;
        PBInt32Field pBInt32Field;
        if (msg2.msg_type.get() == 81) {
            MessageOuterClass$MsgContent messageOuterClass$MsgContent = msg2.content;
            boolean z16 = false;
            if (messageOuterClass$MsgContent != null && (messageOuterClass$AnchorEquipStatusNotifyMsg3 = messageOuterClass$MsgContent.anchor_equip_status_notify_msg) != null && (pBInt32Field = messageOuterClass$AnchorEquipStatusNotifyMsg3.equip_status) != null) {
                i3 = pBInt32Field.get();
            } else {
                i3 = 0;
            }
            if (1 == i3) {
                z16 = true;
            }
            MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = msg2.content;
            PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo3 = null;
            if (messageOuterClass$MsgContent2 != null && (messageOuterClass$AnchorEquipStatusNotifyMsg2 = messageOuterClass$MsgContent2.anchor_equip_status_notify_msg) != null && (premadesTeamServerOuterClass$AnchorGameInfo2 = messageOuterClass$AnchorEquipStatusNotifyMsg2.game_info) != null && (pBStringField = premadesTeamServerOuterClass$AnchorGameInfo2.url) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            l.i(this.TAG, "setContentWhenStatusChanged " + i3 + " " + z16 + " " + isEmpty);
            MessageOuterClass$MsgContent messageOuterClass$MsgContent3 = msg2.content;
            if (messageOuterClass$MsgContent3 != null && (messageOuterClass$AnchorEquipStatusNotifyMsg = messageOuterClass$MsgContent3.anchor_equip_status_notify_msg) != null && (premadesTeamServerOuterClass$AnchorGameInfo = messageOuterClass$AnchorEquipStatusNotifyMsg.game_info) != null) {
                premadesTeamServerOuterClass$AnchorGameInfo3 = premadesTeamServerOuterClass$AnchorGameInfo.get();
            }
            g(premadesTeamServerOuterClass$AnchorGameInfo3, true);
        }
    }

    private final void u() {
        ILiveRoomMessage iLiveRoomMessage = this.liveRoomMessage;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.unRegisterHighPriorityListener(k.f426383a.a(), this.statusListener);
        }
        this.liveRoomMessage = null;
        ((b) mm4.b.b(b.class)).Y1(this.isInAnchorState).b(this.statusListener);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.gameinfo.BaseLiveGameInfoView
    @NotNull
    public LivingRoomInfo e() {
        return new LivingRoomInfo(String.valueOf(this.anchorId), String.valueOf(this.roomId), this.gameId, p());
    }

    /* renamed from: n, reason: from getter */
    public final boolean getSettingEntranceShowFlag() {
        return this.settingEntranceShowFlag;
    }

    public final void o(@Nullable GetAnchorRoomInfoRequest.a result) {
        String str;
        Integer num;
        boolean z16;
        PremadesTeamServerOuterClass$AnchorGameInfo info;
        PBStringField pBStringField;
        PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo = null;
        if (result != null && (info = result.getInfo()) != null && (pBStringField = info.url) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = this.TAG;
        long j3 = this.roomId;
        if (result != null) {
            num = Integer.valueOf(result.getPeriod());
        } else {
            num = null;
        }
        l.e(str2, "requestAnchorRoomInfo success roomId =" + j3 + " period= " + num + " ," + isEmpty);
        if (!this.isDestroyed && q(result)) {
            if (result != null) {
                z16 = result.getEntranceShowFlag();
            } else {
                z16 = false;
            }
            this.settingEntranceShowFlag = z16;
            if (result != null) {
                premadesTeamServerOuterClass$AnchorGameInfo = result.getInfo();
            }
            g(premadesTeamServerOuterClass$AnchorGameInfo, true);
            pj4.b.INSTANCE.a().f(this.roomId, m());
            s();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isDestroyed = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isDestroyed = true;
        u();
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onExitRoom(long roomId) {
        u();
        pj4.b.INSTANCE.a().d();
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageOut(long roomId) {
        g.o(this, false);
        pj4.b.INSTANCE.a().d();
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPreload(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        try {
            ((lo4.a) mm4.b.b(lo4.a.class)).K1();
        } catch (Exception e16) {
            l.n(this.TAG, "[onPreload] ", e16);
        }
    }

    public final void setAnchorId(long j3) {
        this.anchorId = j3;
    }

    public final void setGameId(int i3) {
        this.gameId = i3;
    }

    public final void setInAnchorState(boolean z16) {
        this.isInAnchorState = z16;
    }

    public final void setLiveRoomInfo(@Nullable IAudienceRoom audienceInfo, @Nullable LiveRoomExtraInfo extraRoom) {
        LiveInfo roomLiveInfo;
        LiveRoomInfo liveRoomInfo;
        LiveInfo roomLiveInfo2;
        LiveAnchorInfo liveAnchorInfo;
        long j3 = 0;
        long j16 = (audienceInfo == null || (roomLiveInfo2 = audienceInfo.getRoomLiveInfo()) == null || (liveAnchorInfo = roomLiveInfo2.anchorInfo) == null) ? 0L : liveAnchorInfo.uid;
        if (audienceInfo != null && (roomLiveInfo = audienceInfo.getRoomLiveInfo()) != null && (liveRoomInfo = roomLiveInfo.roomInfo) != null) {
            j3 = liveRoomInfo.roomId;
        }
        setLiveRoomInfo(j16, j3, extraRoom != null ? extraRoom.f376294h : 0);
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public final void setSettingEntranceShowFlag(boolean z16) {
        this.settingEntranceShowFlag = z16;
    }

    public /* synthetic */ LivingInscriptionInterEntranceView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LivingInscriptionInterEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "LivingInscriptionInterEntranceView";
        this.statusListener = new a();
    }

    public final void setLiveRoomInfo(long anchorId, long roomId, int gameId) {
        this.anchorId = anchorId;
        this.roomId = roomId;
        this.gameId = gameId;
        l.i(this.TAG, "setLiveRoomInfo  " + roomId + " " + gameId);
        u();
        r(roomId);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageIn(long roomId) {
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onEnterRoom(long roomId, boolean isAnchor) {
    }
}
