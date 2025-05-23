package com.tencent.mobileqq.qqlive.push;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 82\u00020\u0001:\u00019B}\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014\u0012:\u0010$\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00120\u001ej\u0002`\"\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016RH\u0010$\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00120\u001ej\u0002`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R&\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070.0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/PushHandler;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "k", "i", "l", "j", "Lfp4/c;", "msg", "", "delayMs", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;", "speed", h.F, "", "cmd", "Lkotlinx/coroutines/flow/SharedFlow;", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/channels/Channel;", "d", "Lkotlinx/coroutines/channels/Channel;", "constChannel", "e", "nonConstChannel", "Lcom/tencent/mobileqq/qqlive/push/g;", "f", "smoothChannel", "huYaChannel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msgInfo", "Lcom/tencent/mobileqq/qqlive/push/PushMsgCallback;", "Lkotlin/jvm/functions/Function2;", "pushCallback", "Lkotlinx/coroutines/CoroutineExceptionHandler;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "", "D", "Z", "isStarted", "", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "E", "Ljava/util/Map;", "pushFlowMap", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", UserInfo.SEX_FEMALE, "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PushHandler implements CoroutineScope {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CoroutineExceptionHandler jobException;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean isStarted;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, MutableSharedFlow<fp4.c>> pushFlowMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<fp4.c> constChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<fp4.c> nonConstChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<g> smoothChannel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Channel<fp4.c> huYaChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<fp4.c, LiveMsgExtInfo.MsgSpeed, Unit> pushCallback;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f271415m;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/push/PushHandler$a;", "", "", "EMIT_MSG_TIMEOUT", "J", "", "LOG_TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.push.PushHandler$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        static IPatchRedirector $redirector_;

        public b(CoroutineExceptionHandler.Companion companion) {
            super(companion);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) companion);
            }
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) exception);
            } else {
                AegisLogger.INSTANCE.e("Push|PushHandler", "jobException", "error, ", exception);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PushHandler(@NotNull Channel<fp4.c> constChannel, @NotNull Channel<fp4.c> nonConstChannel, @NotNull Channel<g> smoothChannel, @Nullable Channel<fp4.c> channel, @NotNull Function2<? super fp4.c, ? super LiveMsgExtInfo.MsgSpeed, Unit> pushCallback) {
        Intrinsics.checkNotNullParameter(constChannel, "constChannel");
        Intrinsics.checkNotNullParameter(nonConstChannel, "nonConstChannel");
        Intrinsics.checkNotNullParameter(smoothChannel, "smoothChannel");
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, constChannel, nonConstChannel, smoothChannel, channel, pushCallback);
            return;
        }
        this.constChannel = constChannel;
        this.nonConstChannel = nonConstChannel;
        this.smoothChannel = smoothChannel;
        this.huYaChannel = channel;
        this.pushCallback = pushCallback;
        this.f271415m = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(LiveCoroutineScopes.f273421a.b()));
        this.jobException = new b(CoroutineExceptionHandler.INSTANCE);
        this.pushFlowMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job h(fp4.c msg2, long delayMs, LiveMsgExtInfo.MsgSpeed speed) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(this.jobException), null, new PushHandler$pushMsg$1(delayMs, this, msg2, speed, null), 2, null);
        return launch$default;
    }

    private final Job i() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushConstJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(PushHandler$setupPushConstJob$2$1.INSTANCE);
        return launch$default;
    }

    private final Job j() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushHuYaJob$1(this, null), 2, null);
        return launch$default;
    }

    private final Job k() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushNonConstJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(PushHandler$setupPushNonConstJob$2$1.INSTANCE);
        return launch$default;
    }

    private final Job l() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushSmoothJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(PushHandler$setupPushSmoothJob$2$1.INSTANCE);
        return launch$default;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271415m.getCoroutineContext();
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.isStarted) {
            this.isStarted = true;
            i();
            k();
            l();
            j();
            return;
        }
        throw new IllegalArgumentException("PushHandler is already started".toString());
    }

    @NotNull
    public final SharedFlow<fp4.c> n(int cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 3, (Object) this, cmd);
        }
        AegisLogger.INSTANCE.i("Push|PushHandler", "subscribe", "cmd=" + cmd);
        Map<Integer, MutableSharedFlow<fp4.c>> map = this.pushFlowMap;
        Integer valueOf = Integer.valueOf(cmd);
        MutableSharedFlow<fp4.c> mutableSharedFlow = map.get(valueOf);
        if (mutableSharedFlow == null) {
            mutableSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 3, BufferOverflow.SUSPEND, 1, null);
            map.put(valueOf, mutableSharedFlow);
        }
        return FlowKt.asSharedFlow(mutableSharedFlow);
    }
}
