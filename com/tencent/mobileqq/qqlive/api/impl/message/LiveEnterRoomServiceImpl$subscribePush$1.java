package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class LiveEnterRoomServiceImpl$subscribePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ LiveEnterRoomServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveEnterRoomServiceImpl$subscribePush$1(LiveEnterRoomServiceImpl liveEnterRoomServiceImpl, Continuation<? super LiveEnterRoomServiceImpl$subscribePush$1> continuation) {
        super(2, continuation);
        this.this$0 = liveEnterRoomServiceImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveEnterRoomServiceImpl, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveEnterRoomServiceImpl$subscribePush$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ILiveRoom iLiveRoom;
        IQQLiveSDK iQQLiveSDK;
        IQQLiveSDK iQQLiveSDK2;
        IQQLiveSDK iQQLiveSDK3;
        ni2.b bVar;
        final SharedFlow<fp4.c> d16;
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
                iLiveRoom = this.this$0.currentRoom;
                if (iLiveRoom != null) {
                    iQQLiveSDK = this.this$0.sdk;
                    if (iQQLiveSDK != null) {
                        iQQLiveSDK2 = this.this$0.sdk;
                        Intrinsics.checkNotNull(iQQLiveSDK2);
                        if (!iQQLiveSDK2.isDestroyed()) {
                            iQQLiveSDK3 = this.this$0.sdk;
                            Intrinsics.checkNotNull(iQQLiveSDK3);
                            IQQLiveModule extModule = iQQLiveSDK3.getExtModule("roomPush");
                            if (extModule instanceof ni2.b) {
                                bVar = (ni2.b) extModule;
                            } else {
                                bVar = null;
                            }
                            if (bVar != null && (d16 = bVar.d(200)) != null) {
                                final Flow<sq3.a> flow = new Flow<sq3.a>() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1
                                    static IPatchRedirector $redirector_;

                                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                                    /* renamed from: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                                    /* loaded from: classes17.dex */
                                    public static final class AnonymousClass2 implements FlowCollector<fp4.c> {
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

                                        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                                        @DebugMetadata(c = "com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                                        /* renamed from: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                                        /* loaded from: classes17.dex */
                                        public static final class AnonymousClass1 extends ContinuationImpl {
                                            static IPatchRedirector $redirector_;
                                            Object L$0;
                                            int label;
                                            /* synthetic */ Object result;

                                            public AnonymousClass1(Continuation continuation) {
                                                super(continuation);
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) continuation);
                                                }
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @Nullable
                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                                                }
                                                this.result = obj;
                                                this.label |= Integer.MIN_VALUE;
                                                return AnonymousClass2.this.emit(null, this);
                                            }
                                        }

                                        public AnonymousClass2(FlowCollector flowCollector) {
                                            this.$this_unsafeFlow$inlined = flowCollector;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector);
                                            }
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                                        /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                                        @Override // kotlinx.coroutines.flow.FlowCollector
                                        @Nullable
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public Object emit(fp4.c cVar, @NotNull Continuation continuation) {
                                            AnonymousClass1 anonymousClass1;
                                            Object coroutine_suspended;
                                            int i3;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) continuation);
                                            }
                                            if (continuation instanceof AnonymousClass1) {
                                                anonymousClass1 = (AnonymousClass1) continuation;
                                                int i16 = anonymousClass1.label;
                                                if ((i16 & Integer.MIN_VALUE) != 0) {
                                                    anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                                    Object obj = anonymousClass1.result;
                                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    i3 = anonymousClass1.label;
                                                    if (i3 == 0) {
                                                        if (i3 == 1) {
                                                            ResultKt.throwOnFailure(obj);
                                                        } else {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                    } else {
                                                        ResultKt.throwOnFailure(obj);
                                                        FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                                                        fp4.c it = cVar;
                                                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                                                        if (companion.isDevelopLevel()) {
                                                            companion.d(LiveEnterRoomServiceImpl.LOG_TAG, "subscribePush", "got msg, " + it.f400284b);
                                                        }
                                                        Intrinsics.checkNotNullExpressionValue(it, "it");
                                                        sq3.a C = com.tencent.mobileqq.qqlive.sail.push.a.C(it);
                                                        anonymousClass1.label = 1;
                                                        if (flowCollector.emit(C, anonymousClass1) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            anonymousClass1 = new AnonymousClass1(continuation);
                                            Object obj2 = anonymousClass1.result;
                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            i3 = anonymousClass1.label;
                                            if (i3 == 0) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Flow.this);
                                        }
                                    }

                                    @Override // kotlinx.coroutines.flow.Flow
                                    @Nullable
                                    public Object collect(@NotNull FlowCollector<? super sq3.a> flowCollector, @NotNull Continuation continuation) {
                                        Object coroutine_suspended2;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            return iPatchRedirector2.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                                        }
                                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (collect == coroutine_suspended2) {
                                            return collect;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                Flow filterNotNull = FlowKt.filterNotNull(new Flow<sq3.a>() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1
                                    static IPatchRedirector $redirector_;

                                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                                    /* renamed from: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                                    /* loaded from: classes17.dex */
                                    public static final class AnonymousClass2 implements FlowCollector<sq3.a> {
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

                                        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                                        @DebugMetadata(c = "com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                                        /* renamed from: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                                        /* loaded from: classes17.dex */
                                        public static final class AnonymousClass1 extends ContinuationImpl {
                                            static IPatchRedirector $redirector_;
                                            Object L$0;
                                            Object L$1;
                                            int label;
                                            /* synthetic */ Object result;

                                            public AnonymousClass1(Continuation continuation) {
                                                super(continuation);
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) continuation);
                                                }
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            @Nullable
                                            public final Object invokeSuspend(@NotNull Object obj) {
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                                                }
                                                this.result = obj;
                                                this.label |= Integer.MIN_VALUE;
                                                return AnonymousClass2.this.emit(null, this);
                                            }
                                        }

                                        public AnonymousClass2(FlowCollector flowCollector) {
                                            this.$this_unsafeFlow$inlined = flowCollector;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector);
                                            }
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                                        /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                                        @Override // kotlinx.coroutines.flow.FlowCollector
                                        @Nullable
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public Object emit(sq3.a aVar, @NotNull Continuation continuation) {
                                            AnonymousClass1 anonymousClass1;
                                            Object coroutine_suspended;
                                            int i3;
                                            sq3.b bVar;
                                            boolean z16;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
                                            }
                                            if (continuation instanceof AnonymousClass1) {
                                                anonymousClass1 = (AnonymousClass1) continuation;
                                                int i16 = anonymousClass1.label;
                                                if ((i16 & Integer.MIN_VALUE) != 0) {
                                                    anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                                    Object obj = anonymousClass1.result;
                                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    i3 = anonymousClass1.label;
                                                    if (i3 == 0) {
                                                        if (i3 == 1) {
                                                            ResultKt.throwOnFailure(obj);
                                                        } else {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                    } else {
                                                        ResultKt.throwOnFailure(obj);
                                                        FlowCollector flowCollector = this.$this_unsafeFlow$inlined;
                                                        sq3.a aVar2 = aVar;
                                                        if (aVar2 != null) {
                                                            bVar = aVar2.f434219a;
                                                        } else {
                                                            bVar = null;
                                                        }
                                                        if (bVar != null) {
                                                            z16 = true;
                                                        } else {
                                                            z16 = false;
                                                        }
                                                        if (z16) {
                                                            anonymousClass1.label = 1;
                                                            if (flowCollector.emit(aVar, anonymousClass1) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            anonymousClass1 = new AnonymousClass1(continuation);
                                            Object obj2 = anonymousClass1.result;
                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            i3 = anonymousClass1.label;
                                            if (i3 == 0) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Flow.this);
                                        }
                                    }

                                    @Override // kotlinx.coroutines.flow.Flow
                                    @Nullable
                                    public Object collect(@NotNull FlowCollector<? super sq3.a> flowCollector, @NotNull Continuation continuation) {
                                        Object coroutine_suspended2;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            return iPatchRedirector2.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                                        }
                                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (collect == coroutine_suspended2) {
                                            return collect;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (filterNotNull != null) {
                                    final LiveEnterRoomServiceImpl liveEnterRoomServiceImpl = this.this$0;
                                    FlowCollector<sq3.a> flowCollector = new FlowCollector<sq3.a>() { // from class: com.tencent.mobileqq.qqlive.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$collect$1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveEnterRoomServiceImpl.this);
                                            }
                                        }

                                        @Override // kotlinx.coroutines.flow.FlowCollector
                                        @Nullable
                                        public Object emit(sq3.a aVar, @NotNull Continuation<? super Unit> continuation) {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                return iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar, (Object) continuation);
                                            }
                                            sq3.a aVar2 = aVar;
                                            if (aVar2.f434221c == 1) {
                                                LiveEnterRoomServiceImpl liveEnterRoomServiceImpl2 = LiveEnterRoomServiceImpl.this;
                                                sq3.b bVar2 = aVar2.f434219a;
                                                Intrinsics.checkNotNullExpressionValue(bVar2, "it.userInfo");
                                                liveEnterRoomServiceImpl2.notifyUserEnterRoom(bVar2);
                                            }
                                            LiveEnterRoomServiceImpl.this.notifyAudienceInfo(aVar2);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    this.label = 1;
                                    if (filterNotNull.collect(flowCollector, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        }
                    }
                }
                AegisLogger.INSTANCE.w(LiveEnterRoomServiceImpl.LOG_TAG, "", "invalid room or sdk");
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveEnterRoomServiceImpl$subscribePush$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
