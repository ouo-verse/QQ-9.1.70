package com.tencent.timi.game.liveroom.impl.room.message.stack;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0013\u0012B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g;", "", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "c", "", "roomId", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "", "d", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "floatingBannerLogic", "f", "e", "b", "a", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/f;", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/f;", "messageQueue", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NormalFloatingBannerLogic floatingBannerLogic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f messageQueue = new f(ht3.a.b("chat_area_max_normal_banner_count", 10), ht3.a.c("chat_area_normal_banner_stay_duration", 300));

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g$b;", "", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/stack/g$c", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g$b;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f378102b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ vi2.a f378103c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ vi2.c f378104d;

        c(long j3, vi2.a aVar, vi2.c cVar) {
            this.f378102b = j3;
            this.f378103c = aVar;
            this.f378104d = cVar;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.message.stack.g.b
        public void a(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            NormalFloatingBannerLogic normalFloatingBannerLogic = g.this.floatingBannerLogic;
            if (normalFloatingBannerLogic != null) {
                normalFloatingBannerLogic.l(this.f378102b, this.f378103c, this.f378104d, msg2);
            }
        }
    }

    private final boolean c(com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.b) {
            if (((com.tencent.mobileqq.qqlive.widget.chat.message.b) msg2).f273851d.mSpeakId == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                return true;
            }
        } else if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.g) {
            if (((com.tencent.mobileqq.qqlive.widget.chat.message.g) msg2).f273857d.uid == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                return true;
            }
        } else if ((msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.c) && ((com.tencent.mobileqq.qqlive.widget.chat.message.c) msg2).b().uid == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.messageQueue.c(msg2, c(msg2));
    }

    public final void d(long roomId, @NotNull vi2.a dataSupport, @NotNull vi2.c playFunc) {
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        this.messageQueue.i(new c(roomId, dataSupport, playFunc));
    }

    public final void e() {
        this.messageQueue.j();
    }

    public final void f(@NotNull NormalFloatingBannerLogic floatingBannerLogic) {
        Intrinsics.checkNotNullParameter(floatingBannerLogic, "floatingBannerLogic");
        this.floatingBannerLogic = floatingBannerLogic;
    }
}
