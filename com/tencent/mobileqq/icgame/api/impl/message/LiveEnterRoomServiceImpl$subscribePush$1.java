package com.tencent.mobileqq.icgame.api.impl.message;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
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
import rt0.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class LiveEnterRoomServiceImpl$subscribePush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LiveEnterRoomServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveEnterRoomServiceImpl$subscribePush$1(LiveEnterRoomServiceImpl liveEnterRoomServiceImpl, Continuation<? super LiveEnterRoomServiceImpl$subscribePush$1> continuation) {
        super(2, continuation);
        this.this$0 = liveEnterRoomServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
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
        t32.a aVar;
        final SharedFlow<bz0.c> d16;
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
                        if (extModule instanceof t32.a) {
                            aVar = (t32.a) extModule;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null && (d16 = aVar.d(200)) != null) {
                            final Flow<wy0.a> flow = new Flow<wy0.a>() { // from class: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1

                                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                                /* renamed from: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                                /* loaded from: classes15.dex */
                                public static final class AnonymousClass2 implements FlowCollector<bz0.c> {
                                    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

                                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                                    @DebugMetadata(c = "com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                                    /* renamed from: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                                    /* loaded from: classes15.dex */
                                    public static final class AnonymousClass1 extends ContinuationImpl {
                                        Object L$0;
                                        int label;
                                        /* synthetic */ Object result;

                                        public AnonymousClass1(Continuation continuation) {
                                            super(continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            this.result = obj;
                                            this.label |= Integer.MIN_VALUE;
                                            return AnonymousClass2.this.emit(null, this);
                                        }
                                    }

                                    public AnonymousClass2(FlowCollector flowCollector) {
                                        this.$this_unsafeFlow$inlined = flowCollector;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                    @Nullable
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public Object emit(bz0.c cVar, @NotNull Continuation continuation) {
                                        AnonymousClass1 anonymousClass1;
                                        Object coroutine_suspended;
                                        int i3;
                                        wy0.a aVar;
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
                                                    bz0.c cVar2 = cVar;
                                                    a.Companion companion = rt0.a.INSTANCE;
                                                    if (companion.m()) {
                                                        companion.g(LiveEnterRoomServiceImpl.LOG_TAG, "subscribePush", "got msg, " + cVar2.f29441b);
                                                    }
                                                    try {
                                                        aVar = wy0.a.c(cVar2.f29442c);
                                                    } catch (Exception e16) {
                                                        rt0.a.INSTANCE.i(LiveEnterRoomServiceImpl.LOG_TAG, "subscribePush", "parse error, ", e16);
                                                        aVar = null;
                                                    }
                                                    anonymousClass1.label = 1;
                                                    if (flowCollector.emit(aVar, anonymousClass1) == coroutine_suspended) {
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

                                @Override // kotlinx.coroutines.flow.Flow
                                @Nullable
                                public Object collect(@NotNull FlowCollector<? super wy0.a> flowCollector, @NotNull Continuation continuation) {
                                    Object coroutine_suspended2;
                                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (collect == coroutine_suspended2) {
                                        return collect;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            Flow filterNotNull = FlowKt.filterNotNull(new Flow<wy0.a>() { // from class: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1

                                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                                /* renamed from: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                                /* loaded from: classes15.dex */
                                public static final class AnonymousClass2 implements FlowCollector<wy0.a> {
                                    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

                                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                                    @DebugMetadata(c = "com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2", f = "LiveEnterRoomServiceImpl.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                                    /* renamed from: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                                    /* loaded from: classes15.dex */
                                    public static final class AnonymousClass1 extends ContinuationImpl {
                                        Object L$0;
                                        Object L$1;
                                        int label;
                                        /* synthetic */ Object result;

                                        public AnonymousClass1(Continuation continuation) {
                                            super(continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            this.result = obj;
                                            this.label |= Integer.MIN_VALUE;
                                            return AnonymousClass2.this.emit(null, this);
                                        }
                                    }

                                    public AnonymousClass2(FlowCollector flowCollector) {
                                        this.$this_unsafeFlow$inlined = flowCollector;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                    @Nullable
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public Object emit(wy0.a aVar, @NotNull Continuation continuation) {
                                        AnonymousClass1 anonymousClass1;
                                        Object coroutine_suspended;
                                        int i3;
                                        wy0.b bVar;
                                        boolean z16;
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
                                                    wy0.a aVar2 = aVar;
                                                    if (aVar2 != null) {
                                                        bVar = aVar2.f446712a;
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

                                @Override // kotlinx.coroutines.flow.Flow
                                @Nullable
                                public Object collect(@NotNull FlowCollector<? super wy0.a> flowCollector, @NotNull Continuation continuation) {
                                    Object coroutine_suspended2;
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
                                FlowCollector<wy0.a> flowCollector = new FlowCollector<wy0.a>() { // from class: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$1$invokeSuspend$$inlined$collect$1
                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                    @Nullable
                                    public Object emit(wy0.a aVar2, @NotNull Continuation<? super Unit> continuation) {
                                        wy0.a aVar3 = aVar2;
                                        if (aVar3.f446714c == 1) {
                                            LiveEnterRoomServiceImpl liveEnterRoomServiceImpl2 = LiveEnterRoomServiceImpl.this;
                                            wy0.b bVar = aVar3.f446712a;
                                            Intrinsics.checkNotNullExpressionValue(bVar, "it.userInfo");
                                            liveEnterRoomServiceImpl2.notifyUserEnterRoom(bVar);
                                        }
                                        LiveEnterRoomServiceImpl.this.notifyAudienceInfo(aVar3);
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
            rt0.a.INSTANCE.q(LiveEnterRoomServiceImpl.LOG_TAG, "", "invalid room or sdk");
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LiveEnterRoomServiceImpl$subscribePush$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
