package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b7\u00108J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001d\u001a\u00020\u0007R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00103R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/LivePushRepository;", "", "", "appId", "", "roomId", "roomPlatform", "", "k", "Lfp4/c;", "msgInfo", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;", "speed", h.F, "f", "", "e", "", "cmd", "Lkotlinx/coroutines/flow/SharedFlow;", "l", "d", "Lni2/c;", "receiver", "b", "i", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", DownloadInfo.spKey_Config, "j", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "a", "Ljava/util/concurrent/CopyOnWriteArraySet;", "receivers", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "nonConstChannel", "constChannel", "Lcom/tencent/mobileqq/qqlive/push/g;", "smoothChannel", "huYaChannel", "Lcom/tencent/mobileqq/qqlive/push/PullHandler;", "Lcom/tencent/mobileqq/qqlive/push/PullHandler;", "pullHandler", "Lcom/tencent/mobileqq/qqlive/push/PushHandler;", "g", "Lcom/tencent/mobileqq/qqlive/push/PushHandler;", "pushHandler", "Lcom/tencent/mobileqq/qqlive/push/a;", "Lcom/tencent/mobileqq/qqlive/push/a;", "huYaPushHandler", "J", "openTime", "Lcom/tencent/mobileqq/qqlive/data/config/MessagePushConfig;", "smoothConfig", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LivePushRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<ni2.c> receivers;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<fp4.c> nonConstChannel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<fp4.c> constChannel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<g> smoothChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Channel<fp4.c> huYaChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PullHandler pullHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PushHandler pushHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a huYaPushHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long openTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessagePushConfig smoothConfig;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/LivePushRepository$a;", "", "", "INVALID_ROOM_ID", "J", "", "LOG_TAG", "Ljava/lang/String;", "", "MAX_PUSH_MSG_BUFFER", "I", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.push.LivePushRepository$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LivePushRepository() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.receivers = new CopyOnWriteArraySet<>();
        }
    }

    public static /* synthetic */ void g(LivePushRepository livePushRepository, String str, long j3, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        livePushRepository.f(str, j3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(fp4.c msgInfo, LiveMsgExtInfo.MsgSpeed speed) {
        d dVar;
        for (ni2.c cVar : this.receivers) {
            if (cVar instanceof d) {
                dVar = (d) cVar;
            } else {
                dVar = null;
            }
            if (dVar != null && dVar.d() == msgInfo.f400284b) {
                LiveMsgExtInfo liveMsgExtInfo = new LiveMsgExtInfo();
                liveMsgExtInfo.msgType = msgInfo.f400287e;
                liveMsgExtInfo.msgSpeed = speed;
                liveMsgExtInfo.msgUid = msgInfo.f400288f;
                ni2.a c16 = ((d) cVar).c();
                if (c16 != null) {
                    c16.onRecv(msgInfo.f400284b, msgInfo.f400285c, liveMsgExtInfo);
                }
            }
        }
    }

    private final void k(String appId, long roomId, String roomPlatform) {
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        this.nonConstChannel = ChannelKt.Channel(200, bufferOverflow, LivePushRepository$startHandlers$1.INSTANCE);
        this.constChannel = ChannelKt.Channel(200, bufferOverflow, LivePushRepository$startHandlers$2.INSTANCE);
        this.smoothChannel = ChannelKt.Channel(200, bufferOverflow, LivePushRepository$startHandlers$3.INSTANCE);
        long j3 = this.openTime;
        Channel<fp4.c> channel = this.constChannel;
        Intrinsics.checkNotNull(channel);
        Channel<fp4.c> channel2 = this.nonConstChannel;
        Intrinsics.checkNotNull(channel2);
        Channel<g> channel3 = this.smoothChannel;
        Intrinsics.checkNotNull(channel3);
        PullHandler pullHandler = new PullHandler(appId, roomId, j3, channel, channel2, channel3, this.smoothConfig);
        pullHandler.n();
        this.pullHandler = pullHandler;
        if (Intrinsics.areEqual(roomPlatform, "huya")) {
            this.huYaChannel = ChannelKt.Channel(200, bufferOverflow, LivePushRepository$startHandlers$5.INSTANCE);
            Channel<fp4.c> channel4 = this.huYaChannel;
            Intrinsics.checkNotNull(channel4);
            a aVar = new a(channel4);
            aVar.f();
            this.huYaPushHandler = aVar;
        }
        Channel<fp4.c> channel5 = this.constChannel;
        Intrinsics.checkNotNull(channel5);
        Channel<fp4.c> channel6 = this.nonConstChannel;
        Intrinsics.checkNotNull(channel6);
        Channel<g> channel7 = this.smoothChannel;
        Intrinsics.checkNotNull(channel7);
        PushHandler pushHandler = new PushHandler(channel5, channel6, channel7, this.huYaChannel, new LivePushRepository$startHandlers$7(this));
        pushHandler.m();
        this.pushHandler = pushHandler;
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528", replaceWith = @ReplaceWith(expression = "subscribe", imports = {}))
    public final void b(@Nullable ni2.c receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) receiver);
        } else if (receiver == null) {
            AegisLogger.INSTANCE.i("Push|LivePushRepository", "addReceiver", "invalid receiver");
        } else {
            this.receivers.add(receiver);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i("Push|LivePushRepository", 1, "close");
        this.receivers.clear();
        Channel<fp4.c> channel = this.nonConstChannel;
        if (channel != null) {
            channel.cancel((CancellationException) null);
        }
        this.nonConstChannel = null;
        Channel<fp4.c> channel2 = this.constChannel;
        if (channel2 != null) {
            channel2.cancel((CancellationException) null);
        }
        this.constChannel = null;
        Channel<g> channel3 = this.smoothChannel;
        if (channel3 != null) {
            channel3.cancel((CancellationException) null);
        }
        this.smoothChannel = null;
        Channel<fp4.c> channel4 = this.huYaChannel;
        if (channel4 != null) {
            channel4.cancel((CancellationException) null);
        }
        this.huYaChannel = null;
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
        a aVar = this.huYaPushHandler;
        if (aVar != null) {
            CoroutineScopeKt.cancel$default(aVar, null, 1, null);
        }
        a aVar2 = this.huYaPushHandler;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.huYaPushHandler = null;
        this.openTime = 0L;
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528\uff0croomId\u5e94\u8be5\u4ece\u623f\u95f4\u83b7\u53d6\uff0c\u4e0d\u5e94\u8be5\u4ecepush\u901a\u9053\u83b7\u53d6")
    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.openTime != 0) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String appId, long roomId, @Nullable String roomPlatform) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appId, Long.valueOf(roomId), roomPlatform);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        AegisLogger.INSTANCE.i("Push|LivePushRepository", "open", "appId=" + appId + ", roomId=" + roomId);
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
                k(appId, roomId, roomPlatform);
                return;
            } else {
                throw new IllegalArgumentException(("invalid roomId, " + roomId).toString());
            }
        }
        throw new IllegalArgumentException("already opened, please call close() first".toString());
    }

    @Deprecated(message = "\u9488\u5bf9\u8001\u4ee3\u7801\u7684\u8c03\u7528", replaceWith = @ReplaceWith(expression = "subscribe", imports = {}))
    public final void i(@Nullable ni2.c receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) receiver);
        } else if (receiver == null) {
            AegisLogger.INSTANCE.i("Push|LivePushRepository", "removeReceiver", "invalid receiver");
        } else {
            this.receivers.remove(receiver);
        }
    }

    public final void j(@Nullable MessagePushConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) config);
            return;
        }
        AegisLogger.INSTANCE.i("Push|LivePushRepository", "setMessageSmoothConfig");
        this.smoothConfig = config;
        PullHandler pullHandler = this.pullHandler;
        if (pullHandler != null) {
            pullHandler.m(config);
        }
    }

    @NotNull
    public final SharedFlow<fp4.c> l(int cmd) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 4, (Object) this, cmd);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Push|LivePushRepository", "subscribe", "roomId=" + this.roomId + ", cmd=" + cmd);
        }
        if (this.openTime != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PushHandler pushHandler = this.pushHandler;
            Intrinsics.checkNotNull(pushHandler);
            return pushHandler.n(cmd);
        }
        throw new IllegalArgumentException(("roomId=" + this.roomId + ", cmd=" + cmd + ", push not opened, please call open() first").toString());
    }
}
