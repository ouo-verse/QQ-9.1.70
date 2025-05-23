package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.push.LivePushRepository;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorRoom$createSubscribePushJob$job$1", f = "LiveAnchorRoom.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class LiveAnchorRoom$createSubscribePushJob$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $cmd;
    int label;
    final /* synthetic */ LiveAnchorRoom this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements FlowCollector<fp4.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveAnchorRoom f272390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f272391e;

        public a(LiveAnchorRoom liveAnchorRoom, int i3) {
            this.f272390d = liveAnchorRoom;
            this.f272391e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveAnchorRoom, i3);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(fp4.c cVar, @NotNull Continuation<? super Unit> continuation) {
            ConcurrentHashMap concurrentHashMap;
            ConcurrentHashMap concurrentHashMap2;
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) continuation);
            }
            fp4.c cVar2 = cVar;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                String N = this.f272390d.N();
                int i3 = this.f272391e;
                concurrentHashMap2 = this.f272390d.pushCmdToListeners;
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap2.get(Boxing.boxInt(this.f272391e));
                if (copyOnWriteArraySet != null) {
                    num = Boxing.boxInt(copyOnWriteArraySet.size());
                } else {
                    num = null;
                }
                companion.d(N, "subscribePush", "new push, cmd=" + i3 + ", listener size=" + num);
            }
            concurrentHashMap = this.f272390d.pushCmdToListeners;
            CopyOnWriteArraySet copyOnWriteArraySet2 = (CopyOnWriteArraySet) concurrentHashMap.get(Boxing.boxInt(this.f272391e));
            if (copyOnWriteArraySet2 != null) {
                Intrinsics.checkNotNullExpressionValue(copyOnWriteArraySet2, "pushCmdToListeners[cmd]");
                Iterator it = copyOnWriteArraySet2.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).onPush(cVar2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorRoom$createSubscribePushJob$job$1(LiveAnchorRoom liveAnchorRoom, int i3, Continuation<? super LiveAnchorRoom$createSubscribePushJob$job$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAnchorRoom;
        this.$cmd = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveAnchorRoom, Integer.valueOf(i3), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAnchorRoom$createSubscribePushJob$job$1(this.this$0, this.$cmd, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LivePushRepository K;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AegisLogger.INSTANCE.i(this.this$0.N(), "subscribePush", "collecting cmd: " + this.$cmd);
                K = this.this$0.K();
                SharedFlow<fp4.c> l3 = K.l(this.$cmd);
                a aVar = new a(this.this$0, this.$cmd);
                this.label = 1;
                if (l3.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAnchorRoom$createSubscribePushJob$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
