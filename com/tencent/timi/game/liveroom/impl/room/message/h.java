package com.tencent.timi.game.liveroom.impl.room.message;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import com.tencent.timi.game.liveroom.impl.room.notice.TimiMessagePushDialog;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020#H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0016\u0010,\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J\u0012\u0010/\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J&\u00106\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\rJ\u000e\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u000200R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/h;", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "", "msg", "", "X0", "T0", "", "f0", "Lvi2/b;", "anchorMessageLayout", "Landroid/content/Context;", "context", "", "isInAnchorState", "isSingleLine", "S0", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "D", "P", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "J", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "G", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "onGiftMessageReceive", "", "data", "K", "Lcom/tencent/mobileqq/qqlive/callback/userlevel/UserLevelUpgrade;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "register", "unregister", "newMsg", ReportConstant.COSTREPORT_PREFIX, "", "datas", DomainData.DOMAIN_NAME, "Landroid/view/ViewParent;", "parentView", "u", "", "roomId", "ownerId", "", "roomType", "isSingleLineModel", "V0", "U0", "Z", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h extends ChatMessageLayoutManager {

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isSingleLine;

    private final void T0(Object msg2) {
        if (this.isSingleLine) {
            vi2.b mainLayout = getMainLayout();
            if (mainLayout != null) {
                mainLayout.g(msg2);
                return;
            }
            return;
        }
        vi2.b mainLayout2 = getMainLayout();
        if (mainLayout2 != null) {
            mainLayout2.d(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(int i3, h this$0, com.tencent.mobileqq.qqlive.widget.chat.message.f msg2, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.i("Chat_Message|FloatingChatMessageLayoutManager", "onNewMsg", "msgType=" + i3 + ", supplier=" + this$0.getClass().getSimpleName());
        this$0.X0(msg2);
    }

    private final void X0(Object msg2) {
        if (eh4.a.c()) {
            AegisLogger.INSTANCE.i(f0(), "onNewMsgInner - " + msg2);
        }
        T0(msg2);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void A(@NotNull UserLevelUpgrade msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!UserLevelToggle.INSTANCE.d()) {
            AegisLogger.INSTANCE.i(f0(), "toggle \u63a7\u5236\u4e0d\u5c55\u793a\u5347\u7ea7\u4fe1\u606f");
            return;
        }
        if (!TimiMessagePushDialog.INSTANCE.e()) {
            return;
        }
        String string = b0().getString(R.string.f1651627s, com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().b(getRoomId(), msg2.getNick(), msg2.getUid(), getOwnerId()), Long.valueOf(msg2.getNewLevel()));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026   msg.newLevel\n        )");
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + getRoomId(), "UserLevelUpgrade " + msg2.getNick() + " content:" + msg2);
        s(new j(new SpannableStringBuilder(string), 0, 0, null, null, 30, null));
        QQLiveMedalServiceSupplier.f377955a.a().a(msg2.getUid(), getRoomId(), wj4.c.a(getRoomId()), new d.a() { // from class: com.tencent.timi.game.liveroom.impl.room.message.g
            @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
            public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                h.Y0(bVar);
            }
        });
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void D(@NotNull LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + getRoomId(), msg2.mSpeakerInfo.mSpeakerName + ProgressTracer.SEPARATOR + msg2.msgContent);
        if (TimiMessagePushDialog.INSTANCE.b()) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.h(msg2));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void G(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
        Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
        if (audienceInfo.mSpeakId == com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, getRoomId(), 0, 2, null)) {
            AegisLogger.INSTANCE.e(f0(), "Msg_Receive_" + getRoomId(), "onAudienceEnterRoom " + audienceInfo.mSpeakId + " is same");
            return;
        }
        if (!TimiMessagePushDialog.INSTANCE.c()) {
            return;
        }
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + getRoomId(), "onAudienceEnterRoom " + audienceInfo.mSpeakerName);
        s(new com.tencent.mobileqq.qqlive.widget.chat.message.b(audienceInfo));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void J(@NotNull FollowPushMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + getRoomId(), "onFollowReceive ownerId:" + getOwnerId() + " msg:{" + msg2 + "}");
        if (msg2.type == 1 && msg2.toUid == getOwnerId() && TimiMessagePushDialog.INSTANCE.d()) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.c(msg2));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void P(@NotNull LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void Q(@NotNull AnnouncePushMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    public final void S0(@NotNull vi2.b anchorMessageLayout, @NotNull Context context, boolean isInAnchorState, boolean isSingleLine) {
        Intrinsics.checkNotNullParameter(anchorMessageLayout, "anchorMessageLayout");
        Intrinsics.checkNotNullParameter(context, "context");
        super.Z(anchorMessageLayout, context, isInAnchorState);
        this.isSingleLine = isSingleLine;
    }

    public final void U0(long roomId) {
        vi2.b mainLayout = getMainLayout();
        if (mainLayout != null) {
            mainLayout.f(roomId);
        }
    }

    public final void V0(long roomId, long ownerId, int roomType, boolean isSingleLineModel) {
        vi2.b mainLayout = getMainLayout();
        if (mainLayout != null) {
            mainLayout.e(roomId, ownerId, roomType, isSingleLineModel);
        }
        K0(ownerId);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager
    @NotNull
    public String f0() {
        return "Chat_Message|FloatingChatMessageLayoutManager";
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void n(@NotNull List<Object> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long roomId = getRoomId();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(datas);
        Unit unit = Unit.INSTANCE;
        cVar.L(roomId, arrayList);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void onGiftMessageReceive(@NotNull GiftMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!TimiMessagePushDialog.INSTANCE.e() || pk4.b.z(msg2.giftID)) {
            return;
        }
        AegisLogger.INSTANCE.i(f0(), "Msg_Receive_" + getRoomId(), "onGiftMessageReceive onNewGift:" + msg2);
        if (msg2.comboOver || msg2.allComboCnt == 0) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.d(msg2));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void register() {
        AegisLogger.INSTANCE.i(f0(), "registerListeners roomId:" + getRoomId());
        getMsgPushMgr().a(getRoomId(), this, getIsInAnchorState());
        i.f378067a.a(getNewLocalMsgReceiver());
        getMedalSupplierMgr().b(getRoomId(), 1);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void s(@NotNull Object newMsg) {
        Intrinsics.checkNotNullParameter(newMsg, "newMsg");
        if (newMsg instanceof com.tencent.mobileqq.qqlive.widget.chat.message.f) {
            final int a16 = com.tencent.timi.game.liveroom.impl.room.view.message.a.a(newMsg);
            getMedalSupplierMgr().a(getRoomId(), 1, a16).a((com.tencent.mobileqq.qqlive.widget.chat.message.f) newMsg, new e.a() { // from class: com.tencent.timi.game.liveroom.impl.room.message.f
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.e.a
                public final void a(com.tencent.mobileqq.qqlive.widget.chat.message.f fVar, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    h.W0(a16, this, fVar, bVar);
                }
            });
        } else {
            X0(newMsg);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public boolean u(@Nullable ViewParent parentView) {
        return !(parentView instanceof xh4.c);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void unregister() {
        AegisLogger.INSTANCE.i(f0(), "unRegisterListeners roomId:" + getRoomId());
        getMsgPushMgr().unregister();
        i.f378067a.c(getNewLocalMsgReceiver());
        getMedalSupplierMgr().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void K(@Nullable byte[] data) {
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void O(@Nullable byte[] data) {
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void x(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
    }
}
