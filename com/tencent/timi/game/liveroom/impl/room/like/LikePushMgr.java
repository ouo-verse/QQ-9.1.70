package com.tencent.timi.game.liveroom.impl.room.like;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.like.LikePushMgr;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0019\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00150\u0014H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/like/LocalLikeEvent;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lyq4/a;", "msg", "", "notifyLikeMsg", "", "roomId", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$IPushReceiver;", "receiver", "register", "unregister", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$IPushReceiver;", "J", "com/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$roomLikeInfoListener$1", "roomLikeInfoListener", "Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$roomLikeInfoListener$1;", "<init>", "()V", "IPushReceiver", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LikePushMgr implements SimpleEventReceiver<LocalLikeEvent>, com.tencent.mobileqq.qqlive.sail.room.g {

    @Nullable
    private IPushReceiver receiver;
    private long roomId;

    @NotNull
    private final LikePushMgr$roomLikeInfoListener$1 roomLikeInfoListener = new ji2.a() { // from class: com.tencent.timi.game.liveroom.impl.room.like.LikePushMgr$roomLikeInfoListener$1
        @Override // ji2.a
        public void onReceiveFreeLove(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast) {
            LikePushMgr.IPushReceiver iPushReceiver;
            iPushReceiver = LikePushMgr.this.receiver;
            if (iPushReceiver != null) {
                iPushReceiver.onLikeReceive(uid, freeLoves, fromBroadCast);
            }
        }

        @Override // ji2.a
        public void onReceiveRoomLikePush(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/LikePushMgr$IPushReceiver;", "", "onLikeReceive", "", "uid", "", "freeLoves", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "fromBroadCast", "", "(JLjava/util/ArrayList;Ljava/lang/Boolean;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public interface IPushReceiver {
        void onLikeReceive(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast);
    }

    private final void notifyLikeMsg(yq4.a msg2) {
        IntRange indices;
        List zip;
        int collectionSizeOrDefault;
        ArrayList arrayList;
        String str;
        List zip2;
        int collectionSizeOrDefault2;
        final QLBroadCastFreeLove qLBroadCastFreeLove = new QLBroadCastFreeLove();
        qLBroadCastFreeLove.roomId = msg2.f451019a;
        qLBroadCastFreeLove.headImg = msg2.f451022d;
        qLBroadCastFreeLove.roomMsg = msg2.f451023e;
        qLBroadCastFreeLove.userNick = msg2.f451021c;
        qLBroadCastFreeLove.uid = msg2.f451020b;
        qLBroadCastFreeLove.freeLoves = new ArrayList<>();
        String[] strArr = msg2.f451024f;
        if (strArr.length == msg2.f451025g.length) {
            Intrinsics.checkNotNullExpressionValue(strArr, "msg.materialId");
            String[] strArr2 = msg2.f451025g;
            Intrinsics.checkNotNullExpressionValue(strArr2, "msg.clientDatas");
            zip2 = ArraysKt___ArraysKt.zip(strArr, strArr2);
            List<Pair> list = zip2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault2);
            for (Pair pair : list) {
                arrayList.add(new FreeLove((String) pair.getFirst(), (String) pair.getSecond(), 1));
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(strArr, "msg.materialId");
            indices = ArraysKt___ArraysKt.getIndices(strArr);
            String[] strArr3 = msg2.f451024f;
            Intrinsics.checkNotNullExpressionValue(strArr3, "msg.materialId");
            zip = CollectionsKt___CollectionsKt.zip(indices, strArr3);
            List<Pair> list2 = zip;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Pair pair2 : list2) {
                int intValue = ((Number) pair2.component1()).intValue();
                String str2 = (String) pair2.component2();
                String[] strArr4 = msg2.f451025g;
                if (intValue < strArr4.length) {
                    str = strArr4[intValue];
                } else {
                    str = "";
                }
                arrayList2.add(new FreeLove(str2, str, 1));
            }
            arrayList = arrayList2;
        }
        qLBroadCastFreeLove.freeLoves.addAll(arrayList);
        AegisLogger.INSTANCE.d("Chat_Message|MessagePushMgr", "notifyLike", "count=" + qLBroadCastFreeLove.freeLoves.size() + ", nick=" + qLBroadCastFreeLove.userNick);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.like.d
            @Override // java.lang.Runnable
            public final void run() {
                LikePushMgr.notifyLikeMsg$lambda$6(LikePushMgr.this, qLBroadCastFreeLove);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyLikeMsg$lambda$6(LikePushMgr this$0, QLBroadCastFreeLove broadCastFreeLove) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(broadCastFreeLove, "$broadCastFreeLove");
        IPushReceiver iPushReceiver = this$0.receiver;
        if (iPushReceiver != null) {
            iPushReceiver.onLikeReceive(broadCastFreeLove.uid, broadCastFreeLove.freeLoves, Boolean.TRUE);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<LocalLikeEvent>> getEventClass() {
        ArrayList<Class<LocalLikeEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(LocalLikeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        yq4.a p16 = com.tencent.mobileqq.qqlive.sail.push.a.p(msgInfo);
        if (p16 != null) {
            notifyLikeMsg(p16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        ArrayList<FreeLove> arrayListOf;
        if (event instanceof LocalLikeEvent) {
            LocalLikeEvent localLikeEvent = (LocalLikeEvent) event;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new FreeLove(localLikeEvent.getMaterialId(), localLikeEvent.getLikeResId(), 1));
            IPushReceiver iPushReceiver = this.receiver;
            if (iPushReceiver != null) {
                iPushReceiver.onLikeReceive(com.tencent.mobileqq.qqlive.sail.c.f272176a.G(), arrayListOf, Boolean.FALSE);
            }
        }
    }

    public final void register(long roomId, @Nullable IPushReceiver receiver) {
        this.roomId = roomId;
        this.receiver = receiver;
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(234, this);
            z16.p(263, this);
        } else {
            ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(roomId);
            if (k3 != null) {
                k3.registerOnReceiveFloatHeartListener(this.roomLikeInfoListener);
            }
        }
    }

    public final void unregister() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterOnReceiveFloatHeartListener(this.roomLikeInfoListener);
        }
        this.receiver = null;
        this.roomId = 0L;
    }
}
