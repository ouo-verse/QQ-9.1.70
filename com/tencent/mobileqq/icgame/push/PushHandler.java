package com.tencent.mobileqq.icgame.push;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 62\u00020\u0001:\u00017Bm\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013\u0012:\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00110\u001cj\u0002` \u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015RH\u0010\"\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00110\u001cj\u0002` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R&\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/icgame/push/PushHandler;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "i", h.F, "j", "Lbz0/c;", "msg", "", "delayMs", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;", "speed", "g", "", "cmd", "Lkotlinx/coroutines/flow/SharedFlow;", "l", "", "k", "Lkotlinx/coroutines/channels/Channel;", "d", "Lkotlinx/coroutines/channels/Channel;", "constChannel", "e", "nonConstChannel", "Lcom/tencent/mobileqq/icgame/push/f;", "f", "smoothChannel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "msgInfo", "Lcom/tencent/mobileqq/icgame/push/PushMsgCallback;", "Lkotlin/jvm/functions/Function2;", "pushCallback", "Lkotlinx/coroutines/CoroutineExceptionHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isStarted", "", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "D", "Ljava/util/Map;", "pushFlowMap", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "E", "a", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PushHandler implements CoroutineScope {

    /* renamed from: C, reason: from kotlin metadata */
    private volatile boolean isStarted;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, MutableSharedFlow<bz0.c>> pushFlowMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<bz0.c> constChannel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<bz0.c> nonConstChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Channel<SmoothMsgInfo> smoothChannel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<bz0.c, LiveMsgExtInfo.MsgSpeed, Unit> pushCallback;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f237406i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineExceptionHandler jobException;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            rt0.a.INSTANCE.i("ICGamePush|ICGamePushHandler", "jobException", "error, ", exception);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PushHandler(@NotNull Channel<bz0.c> constChannel, @NotNull Channel<bz0.c> nonConstChannel, @NotNull Channel<SmoothMsgInfo> smoothChannel, @NotNull Function2<? super bz0.c, ? super LiveMsgExtInfo.MsgSpeed, Unit> pushCallback) {
        Intrinsics.checkNotNullParameter(constChannel, "constChannel");
        Intrinsics.checkNotNullParameter(nonConstChannel, "nonConstChannel");
        Intrinsics.checkNotNullParameter(smoothChannel, "smoothChannel");
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        this.constChannel = constChannel;
        this.nonConstChannel = nonConstChannel;
        this.smoothChannel = smoothChannel;
        this.pushCallback = pushCallback;
        this.f237406i = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(LiveCoroutineScopes.f273421a.b()));
        this.jobException = new b(CoroutineExceptionHandler.INSTANCE);
        this.pushFlowMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job g(bz0.c msg2, long delayMs, LiveMsgExtInfo.MsgSpeed speed) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(this.jobException), null, new PushHandler$pushMsg$1(delayMs, msg2, this, speed, null), 2, null);
        return launch$default;
    }

    private final Job h() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushConstJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.icgame.push.PushHandler$setupPushConstJob$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                rt0.a.INSTANCE.k("ICGamePush|ICGamePushHandler", "setupPushConstJob", "pushConstJob is completed");
            }
        });
        return launch$default;
    }

    private final Job i() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushNonConstJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.icgame.push.PushHandler$setupPushNonConstJob$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                rt0.a.INSTANCE.k("ICGamePush|ICGamePushHandler", "setupPushNonConstJob", "pushNonConstJob is completed");
            }
        });
        return launch$default;
    }

    private final Job j() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.jobException, null, new PushHandler$setupPushSmoothJob$1(this, null), 2, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.icgame.push.PushHandler$setupPushSmoothJob$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                rt0.a.INSTANCE.k("ICGamePush|ICGamePushHandler", "setupPushSmoothJob", "pushSmoothJob is completed");
            }
        });
        return launch$default;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f237406i.getCoroutineContext();
    }

    public final void k() {
        if (!this.isStarted) {
            this.isStarted = true;
            h();
            i();
            j();
            return;
        }
        throw new IllegalArgumentException("PushHandler is already started".toString());
    }

    @NotNull
    public final SharedFlow<bz0.c> l(int cmd) {
        rt0.a.INSTANCE.k("ICGamePush|ICGamePushHandler", "subscribe", "cmd=" + cmd);
        Map<Integer, MutableSharedFlow<bz0.c>> map = this.pushFlowMap;
        Integer valueOf = Integer.valueOf(cmd);
        MutableSharedFlow<bz0.c> mutableSharedFlow = map.get(valueOf);
        if (mutableSharedFlow == null) {
            mutableSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
            map.put(valueOf, mutableSharedFlow);
        }
        return FlowKt.asSharedFlow(mutableSharedFlow);
    }
}
