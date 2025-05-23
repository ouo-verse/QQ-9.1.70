package com.tencent.timi.game.liveroom.impl.room.view.operation;

import af4.OperationData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.qbox.QBoxConfProcessor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.ad.ui.BaseOperationContainer;
import com.tencent.timi.game.liveroom.impl.room.live.event.AutoShowControllerUI;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.operation.TimiLiveOperationContainer;
import com.tencent.timi.game.web.business.api.task.LiveLotteryTaskDataManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantRsp;
import trpc.yes.common.LiveActivityServerOuterClass$UserRedpacket;
import trpc.yes.common.MessageOuterClass$PowerRedpacketLotteryResultMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.PendantOuterClass$PendantMsg;
import uq4.c;
import zk4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001&B'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0017\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0014J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0014J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH\u0014J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016J\u001a\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u0006R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\u0006R\u0014\u00106\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010\u0006R\u0018\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006N"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/operation/TimiLiveOperationContainer;", "Lcom/tencent/timi/game/ad/ui/BaseOperationContainer;", "Lbf4/b;", "", "isShowPendant", "", "I", "", "data", "D", "Ltrpc/yes/common/PendantOuterClass$PendantMsg;", "msg", "", "from", "B", "E", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "chatMessageLayout", "setChatMessageLayout", "", "roomId", "", VirtualAppProxy.KEY_GAME_ID, UserInfo.SEX_FEMALE, "H", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "o", DomainData.DOMAIN_NAME, "G", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "rsp", "a", "errCode", "b", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "M", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "N", "J", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "configFlagGone", BdhLogUtil.LogTag.Tag_Req, "landscapeBtmMargin", ExifInterface.LATITUDE_SOUTH, "portraitBtmMargin", "T", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "messageLayout", "U", "Ltrpc/yes/common/PendantOuterClass$PendantMsg;", "mLastRedPocketOperationData", "V", "isInAnchorState", "()Z", "setInAnchorState", "(Z)V", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "W", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "mPushListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiLiveOperationContainer extends BaseOperationContainer implements bf4.b {

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Integer> f378818b0;

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<TianShuAdPosItemData> f378819c0;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: N, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: P, reason: from kotlin metadata */
    private int gameId;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean configFlagGone;

    /* renamed from: R, reason: from kotlin metadata */
    private final int landscapeBtmMargin;

    /* renamed from: S, reason: from kotlin metadata */
    private final int portraitBtmMargin;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ChatMessageLayout messageLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private PendantOuterClass$PendantMsg mLastRedPocketOperationData;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isInAnchorState;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private IQQCmdPushCallback mPushListener;

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        f378818b0 = arrayList;
        f378819c0 = new ArrayList<>();
        arrayList.add(874);
        arrayList.add(Integer.valueOf(QBoxConfProcessor.TASK_TYPE_ID));
        arrayList.add(876);
        arrayList.add(877);
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer id5 = it.next();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            tianShuAdPosItemData.mPosId = id5.intValue();
            tianShuAdPosItemData.mNeedCnt = 20;
            f378819c0.add(tianShuAdPosItemData);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiLiveOperationContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(PendantOuterClass$PendantMsg msg2, String from) {
        OperationData c16 = il4.b.f407937a.c(msg2);
        this.mAegisLog.i("TimiLiveOperationContainer", "handleCommonOperationMsg from:" + from + ", operationData:" + c16);
        w(c16);
        SimpleEventBus.getInstance().dispatchEvent(new AutoShowControllerUI());
    }

    private final void B(PendantOuterClass$PendantMsg msg2, String from) {
        int i3 = msg2.type.get();
        if (i3 != 1) {
            if (i3 != 3) {
                this.mAegisLog.w("TimiLiveOperationContainer", "handlePendantMsg don't care pendant type:" + i3);
                return;
            }
            if (msg2.content.power.has()) {
                this.mAegisLog.i("TimiLiveOperationContainer", "handlePendantMsg is Power msg!");
                C(msg2, from);
                return;
            } else {
                this.mAegisLog.e("TimiLiveOperationContainer", "handlePendantMsg bad Power msg!");
                return;
            }
        }
        if (msg2.content.redpacket.has()) {
            this.mAegisLog.i("TimiLiveOperationContainer", "handlePendantMsg is red pocket msg!");
            E(msg2, from);
        } else {
            this.mAegisLog.e("TimiLiveOperationContainer", "handlePendantMsg bad red pocket msg!");
        }
    }

    private final void C(PendantOuterClass$PendantMsg msg2, String from) {
        A(msg2, from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(byte[] data) {
        MessageOuterClass$TimMsgBody a16 = a.f452717a.a(data);
        if (a16 == null) {
            return;
        }
        int i3 = a16.msg_type.get();
        this.mAegisLog.i("TimiLiveOperationContainer", "received push type:" + i3);
        if (i3 != 93) {
            if (i3 == 94) {
                LiveLotteryTaskDataManager liveLotteryTaskDataManager = LiveLotteryTaskDataManager.f380318a;
                MessageOuterClass$PowerRedpacketLotteryResultMsg messageOuterClass$PowerRedpacketLotteryResultMsg = a16.content.power_redpacket_lottery_result_msg.get();
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$PowerRedpacketLotteryResultMsg, "msg.content.power_redpac\u2026_lottery_result_msg.get()");
                liveLotteryTaskDataManager.h(messageOuterClass$PowerRedpacketLotteryResultMsg);
                return;
            }
            return;
        }
        PendantOuterClass$PendantMsg pendantOuterClass$PendantMsg = a16.content.pendant_msg;
        Intrinsics.checkNotNullExpressionValue(pendantOuterClass$PendantMsg, "msg.content.pendant_msg");
        B(pendantOuterClass$PendantMsg, "push [0xef]");
    }

    private final void E(PendantOuterClass$PendantMsg msg2, String from) {
        long j3 = this.mLastRedPocketOperationData.current_time.get();
        long j16 = msg2.current_time.get();
        if (j3 > j16) {
            this.mAegisLog.e("TimiLiveOperationContainer", "handleTimiRedPocketMsg bad data version: lastMsgTime:" + j3 + ", currentMsgTime:" + j16 + ", from:" + from);
            return;
        }
        this.mLastRedPocketOperationData = msg2;
        A(msg2, from);
    }

    private final void I(final boolean isShowPendant) {
        if (this.messageLayout == null) {
            return;
        }
        post(new Runnable() { // from class: il4.a
            @Override // java.lang.Runnable
            public final void run() {
                TimiLiveOperationContainer.J(TimiLiveOperationContainer.this, isShowPendant);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(TimiLiveOperationContainer this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChatMessageLayout chatMessageLayout = this$0.messageLayout;
        Intrinsics.checkNotNull(chatMessageLayout);
        ViewGroup.LayoutParams layoutParams = chatMessageLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i3 = marginLayoutParams.rightMargin;
        if (z16) {
            if (i3 < this$0.getWidth()) {
                marginLayoutParams.rightMargin = this$0.getWidth();
                ChatMessageLayout chatMessageLayout2 = this$0.messageLayout;
                if (chatMessageLayout2 != null) {
                    chatMessageLayout2.setLayoutParams(marginLayoutParams);
                }
            }
            this$0.mAegisLog.i("TimiLiveOperationContainer", "layoutParams.rightMargin=" + marginLayoutParams.rightMargin);
            this$0.setVisibility(0);
        } else if (i3 == this$0.getWidth()) {
            marginLayoutParams.rightMargin = 0;
            ChatMessageLayout chatMessageLayout3 = this$0.messageLayout;
            if (chatMessageLayout3 != null) {
                chatMessageLayout3.setLayoutParams(marginLayoutParams);
            }
            this$0.setVisibility(8);
        }
        ChatMessageLayout chatMessageLayout4 = this$0.messageLayout;
        if (chatMessageLayout4 != null) {
            chatMessageLayout4.notifyDataSetChanged();
        }
    }

    public final void F(long roomId, int gameId) {
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(this.isInAnchorState).a(this.mPushListener);
        this.roomId = roomId;
        this.gameId = gameId;
        H(roomId);
        l();
    }

    public final void G(long roomId) {
        this.mAegisLog.i("TimiLiveOperationContainer", "onExitRoom " + roomId);
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(this.isInAnchorState).b(this.mPushListener);
        k();
    }

    public final boolean H(long roomId) {
        uq4.a[] boolConfig;
        c cVar = BusConfigHelper.f378723a.j().get(Long.valueOf(roomId));
        if (cVar != null && (boolConfig = cVar.f439826a) != null) {
            Intrinsics.checkNotNullExpressionValue(boolConfig, "boolConfig");
            for (uq4.a aVar : boolConfig) {
                if (aVar.f439822a == 2) {
                    this.configFlagGone = aVar.f439823b;
                    u();
                    return true;
                }
            }
        }
        return false;
    }

    @Override // bf4.b
    public void a(@NotNull LiveActivityServerOuterClass$GetRoomPendantRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (rsp.user_redpacket.has()) {
            LiveLotteryTaskDataManager liveLotteryTaskDataManager = LiveLotteryTaskDataManager.f380318a;
            LiveActivityServerOuterClass$UserRedpacket liveActivityServerOuterClass$UserRedpacket = rsp.user_redpacket;
            Intrinsics.checkNotNullExpressionValue(liveActivityServerOuterClass$UserRedpacket, "rsp.user_redpacket");
            liveLotteryTaskDataManager.e(liveActivityServerOuterClass$UserRedpacket);
        }
        List<PendantOuterClass$PendantMsg> operationDataList = rsp.pendant_list.get();
        Intrinsics.checkNotNullExpressionValue(operationDataList, "operationDataList");
        for (PendantOuterClass$PendantMsg it : operationDataList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            B(it, "active req[719]");
        }
    }

    @Override // bf4.b
    public void b(int errCode, @Nullable String msg2) {
        this.mAegisLog.e("TimiLiveOperationContainer", "onGetRoomOperationDataError " + errCode + " " + msg2);
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    @NotNull
    protected List<Integer> n() {
        return f378818b0;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    @NotNull
    protected List<TianShuAdPosItemData> o() {
        return f378819c0;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    /* renamed from: p, reason: from getter */
    protected int getGameId() {
        return this.gameId;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    /* renamed from: q, reason: from getter */
    protected long getRoomId() {
        return this.roomId;
    }

    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    protected int s() {
        return 1;
    }

    public final void setChatMessageLayout(@NotNull ChatMessageLayout chatMessageLayout) {
        Intrinsics.checkNotNullParameter(chatMessageLayout, "chatMessageLayout");
        this.messageLayout = chatMessageLayout;
    }

    public final void setInAnchorState(boolean z16) {
        this.isInAnchorState = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ad.ui.BaseOperationContainer
    public void u() {
        if (this.configFlagGone) {
            setVisibility(8);
            I(false);
            return;
        }
        super.u();
        if (getChildCount() > 0) {
            I(true);
        } else {
            I(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiLiveOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimiLiveOperationContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiLiveOperationContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.landscapeBtmMargin = com.tencent.timi.game.utils.b.a(65);
        this.portraitBtmMargin = com.tencent.timi.game.utils.b.a(92);
        this.mLastRedPocketOperationData = new PendantOuterClass$PendantMsg();
        this.mPushListener = new b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/operation/TimiLiveOperationContainer$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            TimiLiveOperationContainer.this.D(data);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}
