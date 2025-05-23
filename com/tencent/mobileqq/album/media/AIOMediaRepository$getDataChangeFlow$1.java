package com.tencent.mobileqq.album.media;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005*\u001c\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.album.media.AIOMediaRepository$getDataChangeFlow$1", f = "AIOMediaRepository.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class AIOMediaRepository$getDataChangeFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends List<LocalMediaInfo>, ? extends Integer>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIOMediaRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMediaRepository$getDataChangeFlow$1(AIOMediaRepository aIOMediaRepository, Continuation<? super AIOMediaRepository$getDataChangeFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = aIOMediaRepository;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMediaRepository, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        AIOMediaRepository$getDataChangeFlow$1 aIOMediaRepository$getDataChangeFlow$1 = new AIOMediaRepository$getDataChangeFlow$1(this.this$0, continuation);
        aIOMediaRepository$getDataChangeFlow$1.L$0 = obj;
        return aIOMediaRepository$getDataChangeFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Pair<? extends List<LocalMediaInfo>, ? extends Integer>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Pair<? extends List<LocalMediaInfo>, Integer>>) producerScope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
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
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                Function1<Pair<? extends List<LocalMediaInfo>, ? extends Integer>, Unit> function1 = new Function1<Pair<? extends List<LocalMediaInfo>, ? extends Integer>, Unit>(producerScope) { // from class: com.tencent.mobileqq.album.media.AIOMediaRepository$getDataChangeFlow$1$listener$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ ProducerScope<Pair<? extends List<LocalMediaInfo>, Integer>> $$this$callbackFlow;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$$this$callbackFlow = producerScope;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) producerScope);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<LocalMediaInfo>, ? extends Integer> pair) {
                        invoke2((Pair<? extends List<LocalMediaInfo>, Integer>) pair);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Pair<? extends List<LocalMediaInfo>, Integer> it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.$$this$callbackFlow.mo2003trySendJP2dKIU(it);
                        }
                    }
                };
                hashMap = this.this$0.listeners;
                hashMap.put(Boxing.boxInt(function1.hashCode()), function1);
                Function0<Unit> function0 = new Function0<Unit>(function1) { // from class: com.tencent.mobileqq.album.media.AIOMediaRepository$getDataChangeFlow$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function1<Pair<? extends List<LocalMediaInfo>, Integer>, Unit> $listener;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                        this.$listener = function1;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMediaRepository.this, (Object) function1);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        HashMap hashMap2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            hashMap2 = AIOMediaRepository.this.listeners;
                            hashMap2.remove(Integer.valueOf(this.$listener.hashCode()));
                        }
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Pair<? extends List<LocalMediaInfo>, Integer>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIOMediaRepository$getDataChangeFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
