package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.SearchLocalInfoType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLocalInfoResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {656}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
final class NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchLocalInfoResult>, Object> {
    final /* synthetic */ Ref.IntRef $queryId;
    final /* synthetic */ Flow<SearchLocalInfoResult> $resultFlow;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1(Flow<SearchLocalInfoResult> flow, Ref.IntRef intRef, Continuation<? super NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1> continuation) {
        super(2, continuation);
        this.$resultFlow = flow;
        this.$queryId = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1(this.$resultFlow, this.$queryId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            QLog.d("NTFtsMessageSearchEngine", 1, "#search get data");
            final Flow<SearchLocalInfoResult> flow = this.$resultFlow;
            final Ref.IntRef intRef = this.$queryId;
            Flow<SearchLocalInfoResult> flow2 = new Flow<SearchLocalInfoResult>() { // from class: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1$invokeSuspend$$inlined$filter$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes18.dex */
                public static final class AnonymousClass2 implements FlowCollector<SearchLocalInfoResult> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f283273d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Ref.IntRef f283274e;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1$invokeSuspend$$inlined$filter$1$2", f = "NTFtsMessageSearchEngine.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: classes18.dex */
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

                    public AnonymousClass2(FlowCollector flowCollector, Ref.IntRef intRef) {
                        this.f283273d = flowCollector;
                        this.f283274e = intRef;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(SearchLocalInfoResult searchLocalInfoResult, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
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
                                    FlowCollector flowCollector = this.f283273d;
                                    SearchLocalInfoResult searchLocalInfoResult2 = searchLocalInfoResult;
                                    if (searchLocalInfoResult2.f359215id == this.f283274e.element && searchLocalInfoResult2.type == SearchLocalInfoType.KSEARCHLOCALINFOTYPEMSG) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(searchLocalInfoResult, anonymousClass1) == coroutine_suspended) {
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
                public Object collect(@NotNull FlowCollector<? super SearchLocalInfoResult> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, intRef), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            obj = FlowKt.first(flow2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SearchLocalInfoResult> continuation) {
        return ((NTFtsMessageSearchEngine$searchAsyncWithMapFunc$2$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
