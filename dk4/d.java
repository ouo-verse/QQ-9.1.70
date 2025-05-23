package dk4;

import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mt3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0002\u0014\u0018\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f\u0005B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Ldk4/d;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lmt3/e;", "msg", "", "b", "Lsq3/b;", ITVKPlayerEventListener.KEY_USER_INFO, "c", "", "roomId", "Ldk4/d$b;", "receiver", "d", "e", "Lfp4/c;", "msgInfo", "onPush", "Ldk4/d$b;", "J", "dk4/d$d", "f", "Ldk4/d$d;", "roomAudienceInfoListener", "dk4/d$c", h.F, "Ldk4/d$c;", "receiveGiftMessageListener", "<init>", "()V", "i", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b receiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10189d roomAudienceInfoListener = new C10189d();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c receiveGiftMessageListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Ldk4/d$b;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "", "onAudienceEnterRoom", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "onGiftMessageReceive", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void onAudienceEnterRoom(@NotNull LiveMessageData.SpeakerInfo audienceInfo);

        void onGiftMessageReceive(@NotNull GiftMessage msg2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"dk4/d$c", "Lcom/tencent/mobileqq/qqlive/callback/gift/ReceiveGiftMessageListener;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "", "onGiftMessageReceive", "", "code", "", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ReceiveGiftMessageListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.w("unknown|PlayLevelEnterRoomPushMgr", "onGiftFail", "errCode=" + code + ", errMsg=" + msg2);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(@NotNull GiftMessage msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AegisLogger.INSTANCE.d("unknown|PlayLevelEnterRoomPushMgr", "onGiftMessageReceive");
            b bVar = d.this.receiver;
            if (bVar != null) {
                bVar.onGiftMessageReceive(msg2);
            }
        }
    }

    private final void b(e msg2) {
        GiftMessage giftMsg = GiftMessage.from(msg2);
        AegisLogger.INSTANCE.d("unknown|PlayLevelEnterRoomPushMgr", "notifyGiftMsg", "name=" + giftMsg.giftName + ", id=" + giftMsg.giftID + ", num=" + giftMsg.giftNum);
        b bVar = this.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(giftMsg, "giftMsg");
            bVar.onGiftMessageReceive(giftMsg);
        }
    }

    private final void c(sq3.b userInfo) {
        if (userInfo == null) {
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "notifyUserEnterRoom", "invalid userInfo");
            return;
        }
        if (com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null) == userInfo.f434233a) {
            AegisLogger.INSTANCE.i("Chat_Message|MessagePushMgr", "notifyUserEnterRoom", "drop self enter room msg");
            return;
        }
        LiveMessageData.SpeakerInfo speakerInfo = LiveMessageData.SpeakerInfo.from(userInfo);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("unknown|PlayLevelEnterRoomPushMgr", "notifyUserEnterRoom", speakerInfo.mSpeakerName + " entered room");
        }
        b bVar = this.receiver;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(speakerInfo, "speakerInfo");
            bVar.onAudienceEnterRoom(speakerInfo);
        }
    }

    public final void d(long roomId, @NotNull b receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        this.receiver = receiver;
        this.roomId = roomId;
        f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(200, this);
            z16.p(167, this);
            z16.p(235, this);
        } else {
            ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(roomId);
            if (k3 != null) {
                k3.registerAudienceInfoListener(this.roomAudienceInfoListener);
                k3.registerReceiveGiftMessageListener(this.receiveGiftMessageListener);
            }
        }
    }

    public final void e() {
        this.receiver = null;
        this.roomId = 0L;
        f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, 0L, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterAudienceInfoListener(this.roomAudienceInfoListener);
            k3.unRegisterReceiveGiftMessageListener(this.receiveGiftMessageListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        int i3 = msgInfo.f400284b;
        if (i3 != 167) {
            if (i3 != 200) {
                if (i3 != 235) {
                    return;
                }
            } else {
                sq3.a C = com.tencent.mobileqq.qqlive.sail.push.a.C(msgInfo);
                if (C != null && C.f434221c == 1) {
                    c(C.f434219a);
                    return;
                }
                return;
            }
        }
        e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
        if (m3 != null) {
            b(m3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"dk4/d$d", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "Lcom/tencent/mobileqq/qqlive/data/room/RoomAudienceInfo;", "info", "", "onRecAudienceInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "onAudienceEnterRoom", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dk4.d$d, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10189d implements RoomAudienceInfoListener {
        C10189d() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onAudienceEnterRoom(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
            Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
            AegisLogger.INSTANCE.d("unknown|PlayLevelEnterRoomPushMgr", "onAudienceEnterRoom");
            b bVar = d.this.receiver;
            if (bVar != null) {
                bVar.onAudienceEnterRoom(audienceInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onRecAudienceInfo(@Nullable RoomAudienceInfo info) {
        }
    }
}
