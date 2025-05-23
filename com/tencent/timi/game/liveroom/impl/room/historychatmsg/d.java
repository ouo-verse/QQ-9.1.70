package com.tencent.timi.game.liveroom.impl.room.historychatmsg;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryGiftMsgModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u0019\u001cB\u0007\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\bR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d;", "", "", "roomId", "", "fromFloatWindow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", TabPreloadItem.TAB_NAME_MESSAGE, "comboSeqList", "", h.F, "f", "k", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d$b;", "sendMsgCallback", "i", "comboSeq", "e", "j", "g", "msg", "d", "", "a", "Ljava/util/List;", "historyMsgList", "b", "historyMsgSeqList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel;", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel;", "historyGiftMsgModel", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d$b;", "Z", "shouldShowHistoryMsg", "J", "historyMsgSendInterval", "enterRoomTime", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "sendMsgRunnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    private static long f377756k;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b sendMsgCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long historyMsgSendInterval;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long enterRoomTime;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GiftMessage> historyMsgList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> historyMsgSeqList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<GiftMessage> msgList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HistoryGiftMsgModel historyGiftMsgModel = new HistoryGiftMsgModel();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowHistoryMsg = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable sendMsgRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.historychatmsg.c
        @Override // java.lang.Runnable
        public final void run() {
            d.l(d.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d$b;", "", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "", "isHistoryMsg", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull GiftMessage msg2, boolean isHistoryMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/historychatmsg/d$c", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/HistoryGiftMsgModel$b;", "", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "historyList", "", "historyComboSeqList", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements HistoryGiftMsgModel.b {
        c() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.historychatmsg.HistoryGiftMsgModel.b
        public void a(@NotNull List<? extends GiftMessage> historyList, @NotNull List<Long> historyComboSeqList) {
            Intrinsics.checkNotNullParameter(historyList, "historyList");
            Intrinsics.checkNotNullParameter(historyComboSeqList, "historyComboSeqList");
            d.this.h(historyList, historyComboSeqList);
            d.this.k();
        }
    }

    private final boolean f() {
        if (this.historyMsgSendInterval > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<? extends GiftMessage> msgList, List<Long> comboSeqList) {
        this.historyMsgList.clear();
        this.historyMsgList.addAll(msgList);
        this.historyMsgSeqList.clear();
        this.historyMsgSeqList.addAll(comboSeqList);
        this.historyMsgSendInterval = 200L;
        this.msgList.addAll(0, this.historyMsgList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (this.msgList.isEmpty()) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryGiftMsgManager", "msgList is Empty.");
            return;
        }
        GiftMessage msgData = this.msgList.get(0);
        boolean contains = this.historyMsgList.contains(msgData);
        b bVar = this.sendMsgCallback;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(msgData, "msgData");
            bVar.a(msgData, contains);
        }
        this.msgList.remove(msgData);
        if (this.msgList.isEmpty()) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryGiftMsgManager", "msgList send over.");
        } else if (this.historyMsgList.contains(this.msgList.get(0))) {
            RFWThreadManager.getUIHandler().postDelayed(this.sendMsgRunnable, this.historyMsgSendInterval);
        } else {
            RFWThreadManager.getUIHandler().postDelayed(this.sendMsgRunnable, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    private final boolean m(long roomId, boolean fromFloatWindow) {
        if (fromFloatWindow) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryGiftMsgManager", "isFromFloatWindow");
            f377756k = 0L;
            return false;
        }
        if (f377756k == roomId) {
            AegisLogger.INSTANCE.i("Chat_Message|HistoryGiftMsgManager", "Float window is showing, enter same room.");
            return false;
        }
        f377756k = roomId;
        return ht3.a.e("qqlive_history_gift_msg_enable", true);
    }

    public final void d(@NotNull GiftMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.msgList.add(msg2);
    }

    public final boolean e(long comboSeq) {
        return this.historyMsgSeqList.contains(Long.valueOf(comboSeq));
    }

    public final boolean g() {
        if (!this.shouldShowHistoryMsg || System.currentTimeMillis() - this.enterRoomTime > 30000) {
            return true;
        }
        if (f() && this.msgList.isEmpty()) {
            return true;
        }
        return false;
    }

    public final void i(long roomId, boolean fromFloatWindow, @NotNull b sendMsgCallback) {
        Intrinsics.checkNotNullParameter(sendMsgCallback, "sendMsgCallback");
        boolean m3 = m(roomId, fromFloatWindow);
        this.shouldShowHistoryMsg = m3;
        if (!m3) {
            return;
        }
        this.sendMsgCallback = sendMsgCallback;
        this.historyGiftMsgModel.h(com.tencent.mobileqq.qqlive.sail.c.w(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null), new c());
        this.enterRoomTime = System.currentTimeMillis();
    }

    public final void j() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.sendMsgRunnable);
        this.historyGiftMsgModel.i();
        this.historyMsgList.clear();
        this.historyMsgSeqList.clear();
        this.msgList.clear();
        this.historyMsgSendInterval = 0L;
        f377756k = 0L;
    }
}
