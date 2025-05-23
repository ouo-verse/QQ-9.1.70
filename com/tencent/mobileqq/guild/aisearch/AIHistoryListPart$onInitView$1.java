package com.tencent.mobileqq.guild.aisearch;

import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.widget.drawerlayout.SafeDrawerLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "aiChatSession", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1", f = "AIHistoryListPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class AIHistoryListPart$onInitView$1 extends SuspendLambda implements Function2<AiChatSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Job> $refreshJob;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIHistoryListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "state", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$2", f = "AIHistoryListPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ AIHistoryListPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AIHistoryListPart aIHistoryListPart, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = aIHistoryListPart;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.I$0 = ((Number) obj).intValue();
            return anonymousClass2;
        }

        @Nullable
        public final Object invoke(int i3, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            SafeDrawerLayout safeDrawerLayout;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.I$0 == 5) {
                    safeDrawerLayout = this.this$0.guildAiSearchDrawer;
                    boolean z16 = false;
                    if (safeDrawerLayout != null && safeDrawerLayout.isDrawerVisible(8388611)) {
                        z16 = true;
                    }
                    if (z16) {
                        this.this$0.X9().h2();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return invoke(num.intValue(), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIHistoryListPart$onInitView$1(Ref.ObjectRef<Job> objectRef, AIHistoryListPart aIHistoryListPart, Continuation<? super AIHistoryListPart$onInitView$1> continuation) {
        super(2, continuation);
        this.$refreshJob = objectRef;
        this.this$0 = aIHistoryListPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIHistoryListPart$onInitView$1 aIHistoryListPart$onInitView$1 = new AIHistoryListPart$onInitView$1(this.$refreshJob, this.this$0, continuation);
        aIHistoryListPart$onInitView$1.L$0 = obj;
        return aIHistoryListPart$onInitView$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable AiChatSession aiChatSession, @Nullable Continuation<? super Unit> continuation) {
        return ((AIHistoryListPart$onInitView$1) create(aiChatSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v9, types: [T, kotlinx.coroutines.Job] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a.AnswerItem e16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AiChatSession aiChatSession = (AiChatSession) this.L$0;
            if (aiChatSession != null && (e16 = aiChatSession.e()) != null) {
                Job job = this.$refreshJob.element;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                Ref.ObjectRef<Job> objectRef = this.$refreshJob;
                final StateFlow<ChatAnswerData> b16 = e16.b();
                objectRef.element = FlowKt.launchIn(FlowKt.onEach(new Flow<Integer>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    public static final class AnonymousClass2 implements FlowCollector<ChatAnswerData> {

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ FlowCollector f213943d;

                        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                        @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$invokeSuspend$$inlined$map$1$2", f = "AIHistoryListPart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.guild.aisearch.AIHistoryListPart$onInitView$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes12.dex */
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
                            this.f213943d = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public Object emit(ChatAnswerData chatAnswerData, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            Object coroutine_suspended;
                            int i3;
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
                                        FlowCollector flowCollector = this.f213943d;
                                        Integer boxInt = Boxing.boxInt(chatAnswerData.getState());
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(boxInt, anonymousClass1) == coroutine_suspended) {
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
                    public Object collect(@NotNull FlowCollector<? super Integer> flowCollector, @NotNull Continuation continuation) {
                        Object coroutine_suspended;
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (collect == coroutine_suspended) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }
                }, new AnonymousClass2(this.this$0, null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this.this$0));
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
