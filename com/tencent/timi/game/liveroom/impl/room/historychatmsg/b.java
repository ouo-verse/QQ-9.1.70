package com.tencent.timi.game.liveroom.impl.room.historychatmsg;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryChatMsgModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0002\u001a\u001eB\u0007\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b;", "", "", "roomId", "", "fromFloatWindow", "l", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "list", "", "singleMsgInterval", "", "g", "e", "j", "", "platform", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b$b;", "sendMsgCallback", h.F, "i", "f", "msg", "d", "", "a", "Ljava/util/List;", "historyMsgList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel;", "c", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel;", "historyChatMsgModel", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b$b;", "Z", "shouldShowHistoryMsg", "J", "historyMsgSendInterval", "enterRoomTime", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "sendMsgRunnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: j, reason: collision with root package name */
    private static long f377744j;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC9938b sendMsgCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long historyMsgSendInterval;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long enterRoomTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LiveMessageData> historyMsgList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<LiveMessageData> msgList = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HistoryChatMsgModel historyChatMsgModel = new HistoryChatMsgModel();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowHistoryMsg = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable sendMsgRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.historychatmsg.a
        @Override // java.lang.Runnable
        public final void run() {
            b.k(b.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b$b;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "", "isHistoryMsg", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.historychatmsg.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC9938b {
        void a(@NotNull LiveMessageData msg2, boolean isHistoryMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/historychatmsg/b$c", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryChatMsgModel$b;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "historyList", "", "singleMsgInterval", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements HistoryChatMsgModel.b {
        c() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryChatMsgModel.b
        public void a(@NotNull List<? extends LiveMessageData> historyList, int singleMsgInterval) {
            Intrinsics.checkNotNullParameter(historyList, "historyList");
            b.this.g(historyList, singleMsgInterval);
            b.this.j();
        }
    }

    private final boolean e() {
        if (this.historyMsgSendInterval > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(List<? extends LiveMessageData> list, int singleMsgInterval) {
        long j3;
        this.historyMsgList.clear();
        this.historyMsgList.addAll(list);
        if (singleMsgInterval > 0) {
            j3 = singleMsgInterval;
        } else {
            j3 = 500;
        }
        this.historyMsgSendInterval = j3;
        this.msgList.addAll(0, this.historyMsgList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.msgList.isEmpty()) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryChatMsgManager", "msgList is Empty.");
            return;
        }
        LiveMessageData msgData = this.msgList.get(0);
        boolean contains = this.historyMsgList.contains(msgData);
        InterfaceC9938b interfaceC9938b = this.sendMsgCallback;
        if (interfaceC9938b != null) {
            Intrinsics.checkNotNullExpressionValue(msgData, "msgData");
            interfaceC9938b.a(msgData, contains);
        }
        this.msgList.remove(msgData);
        if (this.msgList.isEmpty()) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryChatMsgManager", "msgList send over.");
        } else if (this.historyMsgList.contains(this.msgList.get(0))) {
            RFWThreadManager.getUIHandler().postDelayed(this.sendMsgRunnable, this.historyMsgSendInterval);
        } else {
            RFWThreadManager.getUIHandler().postDelayed(this.sendMsgRunnable, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
    }

    private final boolean l(long roomId, boolean fromFloatWindow) {
        if (fromFloatWindow) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryChatMsgManager", "isFromFloatWindow");
            f377744j = 0L;
            return false;
        }
        if (f377744j == roomId) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryChatMsgManager", "Float window is showing, enter same room.");
            return false;
        }
        f377744j = roomId;
        return ht3.a.e("qqlive_history_chat_msg_enable", true);
    }

    public final void d(@NotNull LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msgList.add(msg2);
    }

    public final boolean f() {
        if (!this.shouldShowHistoryMsg || System.currentTimeMillis() - this.enterRoomTime > 30000) {
            return true;
        }
        if (e() && this.msgList.isEmpty()) {
            return true;
        }
        return false;
    }

    public final void h(long roomId, @Nullable String platform, boolean fromFloatWindow, @NotNull InterfaceC9938b sendMsgCallback) {
        Intrinsics.checkNotNullParameter(sendMsgCallback, "sendMsgCallback");
        boolean l3 = l(roomId, fromFloatWindow);
        this.shouldShowHistoryMsg = l3;
        if (!l3) {
            return;
        }
        this.sendMsgCallback = sendMsgCallback;
        this.historyChatMsgModel.g(roomId, platform, new c());
        this.enterRoomTime = System.currentTimeMillis();
    }

    public final void i() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.sendMsgRunnable);
        this.historyMsgList.clear();
        this.msgList.clear();
        this.historyMsgSendInterval = 0L;
    }
}
