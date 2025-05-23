package com.tencent.mobileqq.icgame.push;

import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001a\u001a\u00020\u0006R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010 R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010)R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/icgame/push/LivePushRepository;", "", "", "appId", "", "roomId", "", "i", "Lbz0/c;", "msgInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;", "speed", "f", "e", "", "cmd", "Lkotlinx/coroutines/flow/SharedFlow;", "j", "d", "Lt32/b;", "receiver", "b", "g", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", DownloadInfo.spKey_Config, h.F, "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "a", "Ljava/util/concurrent/CopyOnWriteArraySet;", "receivers", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "nonConstChannel", "constChannel", "Lcom/tencent/mobileqq/icgame/push/f;", "smoothChannel", "Lcom/tencent/mobileqq/icgame/push/PullHandler;", "Lcom/tencent/mobileqq/icgame/push/PullHandler;", "pullHandler", "Lcom/tencent/mobileqq/icgame/push/PushHandler;", "Lcom/tencent/mobileqq/icgame/push/PushHandler;", "pushHandler", "J", "openTime", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "smoothConfig", "<init>", "()V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LivePushRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<t32.b> receivers = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<bz0.c> nonConstChannel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<bz0.c> constChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<SmoothMsgInfo> smoothChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PullHandler pullHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PushHandler pushHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long openTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessagePushConfig smoothConfig;

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(bz0.c msgInfo, LiveMsgExtInfo.MsgSpeed speed) {
        c cVar;
        for (t32.b bVar : this.receivers) {
            if (bVar instanceof c) {
                cVar = (c) bVar;
            } else {
                cVar = null;
            }
            if (cVar != null && cVar.d() == msgInfo.f29441b) {
                LiveMsgExtInfo liveMsgExtInfo = new LiveMsgExtInfo();
                liveMsgExtInfo.msgType = msgInfo.f29444e;
                liveMsgExtInfo.msgSpeed = speed;
                liveMsgExtInfo.msgUid = msgInfo.f29445f;
                ni2.a c16 = ((c) bVar).c();
                if (c16 != null) {
                    c16.onRecv(msgInfo.f29441b, msgInfo.f29442c, liveMsgExtInfo);
                }
            }
        }
    }

    private final void i(String appId, long roomId) {
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        this.nonConstChannel = ChannelKt.Channel(200, bufferOverflow, new Function1<bz0.c, Unit>() { // from class: com.tencent.mobileqq.icgame.push.LivePushRepository$startHandlers$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bz0.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull bz0.c msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                a.Companion companion = rt0.a.INSTANCE;
                if (companion.m()) {
                    companion.q("ICGamePush|ICGameLivePushRepository", "startHandlers", "drop msg on nonConstChannel, " + a.a(msg2));
                }
            }
        });
        this.constChannel = ChannelKt.Channel(200, bufferOverflow, new Function1<bz0.c, Unit>() { // from class: com.tencent.mobileqq.icgame.push.LivePushRepository$startHandlers$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bz0.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull bz0.c msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                a.Companion companion = rt0.a.INSTANCE;
                if (companion.m()) {
                    companion.q("ICGamePush|ICGameLivePushRepository", "startHandlers", "drop msg on constChannel, " + a.a(msg2));
                }
            }
        });
        this.smoothChannel = ChannelKt.Channel(200, bufferOverflow, new Function1<SmoothMsgInfo, Unit>() { // from class: com.tencent.mobileqq.icgame.push.LivePushRepository$startHandlers$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SmoothMsgInfo smoothMsgInfo) {
                invoke2(smoothMsgInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SmoothMsgInfo msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                a.Companion companion = rt0.a.INSTANCE;
                if (companion.m()) {
                    companion.q("ICGamePush|ICGameLivePushRepository", "startHandlers", "drop msg on smoothChannel, " + a.a(msg2.getMsg()));
                }
            }
        });
        long j3 = this.openTime;
        Channel<bz0.c> channel = this.constChannel;
        Intrinsics.checkNotNull(channel);
        Channel<bz0.c> channel2 = this.nonConstChannel;
        Intrinsics.checkNotNull(channel2);
        Channel<SmoothMsgInfo> channel3 = this.smoothChannel;
        Intrinsics.checkNotNull(channel3);
        PullHandler pullHandler = new PullHandler(appId, roomId, j3, channel, channel2, channel3, this.smoothConfig);
        pullHandler.n();
        this.pullHandler = pullHandler;
        Channel<bz0.c> channel4 = this.constChannel;
        Intrinsics.checkNotNull(channel4);
        Channel<bz0.c> channel5 = this.nonConstChannel;
        Intrinsics.checkNotNull(channel5);
        Channel<SmoothMsgInfo> channel6 = this.smoothChannel;
        Intrinsics.checkNotNull(channel6);
        PushHandler pushHandler = new PushHandler(channel4, channel5, channel6, new LivePushRepository$startHandlers$5(this));
        pushHandler.k();
        this.pushHandler = pushHandler;
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528", replaceWith = @ReplaceWith(expression = "subscribe", imports = {}))
    public final void b(@Nullable t32.b receiver) {
        if (receiver == null) {
            rt0.a.INSTANCE.k("ICGamePush|ICGameLivePushRepository", "addReceiver", "invalid receiver");
        } else {
            this.receivers.add(receiver);
        }
    }

    public final void c() {
        rt0.a.INSTANCE.j("ICGamePush|ICGameLivePushRepository", "close");
        this.receivers.clear();
        Channel<bz0.c> channel = this.nonConstChannel;
        if (channel != null) {
            channel.cancel((CancellationException) null);
        }
        this.nonConstChannel = null;
        Channel<bz0.c> channel2 = this.constChannel;
        if (channel2 != null) {
            channel2.cancel((CancellationException) null);
        }
        this.constChannel = null;
        Channel<SmoothMsgInfo> channel3 = this.smoothChannel;
        if (channel3 != null) {
            channel3.cancel((CancellationException) null);
        }
        this.smoothChannel = null;
        PullHandler pullHandler = this.pullHandler;
        if (pullHandler != null) {
            CoroutineScopeKt.cancel$default(pullHandler, null, 1, null);
        }
        this.pullHandler = null;
        PushHandler pushHandler = this.pushHandler;
        if (pushHandler != null) {
            CoroutineScopeKt.cancel$default(pushHandler, null, 1, null);
        }
        this.pushHandler = null;
        this.openTime = 0L;
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528\uff0croomId\u5e94\u8be5\u4ece\u623f\u95f4\u83b7\u53d6\uff0c\u4e0d\u5e94\u8be5\u4ecepush\u901a\u9053\u83b7\u53d6")
    /* renamed from: d, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public final void e(@NotNull String appId, long roomId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        rt0.a.INSTANCE.k("ICGamePush|ICGameLivePushRepository", "open", "appId=" + appId + ", roomId=" + roomId);
        boolean z17 = true;
        if (this.openTime == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (roomId == 0) {
                z17 = false;
            }
            if (z17) {
                this.openTime = System.currentTimeMillis();
                this.roomId = roomId;
                i(appId, roomId);
                return;
            } else {
                throw new IllegalArgumentException(("invalid roomId, " + roomId).toString());
            }
        }
        throw new IllegalArgumentException("already opened, please call close() first".toString());
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528", replaceWith = @ReplaceWith(expression = "subscribe", imports = {}))
    public final void g(@Nullable t32.b receiver) {
        if (receiver == null) {
            rt0.a.INSTANCE.k("ICGamePush|ICGameLivePushRepository", "removeReceiver", "invalid receiver");
        } else {
            this.receivers.remove(receiver);
        }
    }

    public final void h(@Nullable MessagePushConfig config) {
        rt0.a.INSTANCE.j("ICGamePush|ICGameLivePushRepository", "setMessageSmoothConfig");
        this.smoothConfig = config;
        PullHandler pullHandler = this.pullHandler;
        if (pullHandler != null) {
            pullHandler.m(config);
        }
    }

    @NotNull
    public final SharedFlow<bz0.c> j(int cmd) {
        boolean z16;
        rt0.a.INSTANCE.k("ICGamePush|ICGameLivePushRepository", "subscribe", "cmd=" + cmd);
        if (this.openTime != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PushHandler pushHandler = this.pushHandler;
            Intrinsics.checkNotNull(pushHandler);
            return pushHandler.l(cmd);
        }
        throw new IllegalArgumentException("push not opened, please call open() first".toString());
    }
}
