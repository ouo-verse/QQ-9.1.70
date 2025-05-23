package com.tencent.timi.game.liveroom.impl.room.message;

import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JD\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2$\b\u0002\u0010\u000f\u001a\u001e\u0012\b\u0012\u00060\fR\u00020\r\u0018\u00010\u000bj\u000e\u0012\b\u0012\u00060\fR\u00020\r\u0018\u0001`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/i;", "", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$a;", "receiver", "", "a", "c", "", "roomId", "", "message", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "exts", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "callback", "b", "", "Ljava/util/List;", "localMsgReceivers", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f378067a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> localMsgReceivers = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/i$a;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "", "t6", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void t6(@NotNull LiveMessageData msg2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/i$b;", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$a;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static class b implements a {
    }

    i() {
    }

    public final void a(@NotNull a receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        localMsgReceivers.add(receiver);
    }

    public final void b(long roomId, @NotNull String message, @Nullable ArrayList<LiveMessageData.ExtData> exts, @NotNull IQQLiveMessageCallback callback) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        cVar.M(roomId, message, exts, callback);
        if ((com.tencent.mobileqq.qqlive.sail.c.K(cVar, roomId, 0, 2, null) && cVar.d().m() != null) || SailAudienceRoomManager.t(cVar.m(), roomId, 0, 2, null) != null) {
            Iterator<T> it = localMsgReceivers.iterator();
            while (it.hasNext()) {
                ((a) it.next()).t6(com.tencent.mobileqq.qqlive.sail.a.a(roomId, message, exts));
            }
        }
    }

    public final void c(@NotNull a receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        localMsgReceivers.remove(receiver);
    }
}
