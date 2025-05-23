package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveImageFile$1", f = "MagicStudioMultiViewModel.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioMultiViewModel$saveImageFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<GenerateInfo> $generateInfoList;
    int label;
    final /* synthetic */ MagicStudioMultiViewModel this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioMultiViewModel f323681d;

        public a(MagicStudioMultiViewModel magicStudioMultiViewModel) {
            this.f323681d = magicStudioMultiViewModel;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Boolean bool, @NotNull Continuation<? super Unit> continuation) {
            boolean booleanValue = bool.booleanValue();
            w53.b.f("MagicStudioMultiViewModel", "saveImageFile result: " + booleanValue);
            this.f323681d.d2().postValue(Boxing.boxBoolean(booleanValue));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioMultiViewModel$saveImageFile$1(ArrayList<GenerateInfo> arrayList, MagicStudioMultiViewModel magicStudioMultiViewModel, Continuation<? super MagicStudioMultiViewModel$saveImageFile$1> continuation) {
        super(2, continuation);
        this.$generateInfoList = arrayList;
        this.this$0 = magicStudioMultiViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioMultiViewModel$saveImageFile$1(this.$generateInfoList, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List list;
        Flow j26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                ArrayList<GenerateInfo> arrayList2 = this.$generateInfoList;
                MagicStudioMultiViewModel magicStudioMultiViewModel = this.this$0;
                int i16 = 0;
                for (Object obj2 : arrayList2) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    j26 = magicStudioMultiViewModel.j2(i16, (GenerateInfo) obj2);
                    arrayList.add(j26);
                    i16 = i17;
                }
                list = CollectionsKt___CollectionsKt.toList(arrayList);
                Object[] array = list.toArray(new Flow[0]);
                if (array != null) {
                    final Flow[] flowArr = (Flow[]) array;
                    Flow cancellable = FlowKt.cancellable(new Flow<Boolean>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveImageFile$1$invokeSuspend$$inlined$combine$1

                        /* compiled from: P */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@\u00a8\u0006\u0006"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                        @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveImageFile$1$invokeSuspend$$inlined$combine$1$3", f = "MagicStudioMultiViewModel.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveImageFile$1$invokeSuspend$$inlined$combine$1$3, reason: invalid class name */
                        /* loaded from: classes21.dex */
                        public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Boolean[], Continuation<? super Unit>, Object> {
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            int label;

                            public AnonymousClass3(Continuation continuation) {
                                super(3, continuation);
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
                                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                                    Boolean[] boolArr = (Boolean[]) ((Object[]) this.L$1);
                                    int length = boolArr.length;
                                    boolean z16 = false;
                                    int i16 = 0;
                                    while (true) {
                                        if (i16 < length) {
                                            if (!boolArr[i16].booleanValue()) {
                                                break;
                                            }
                                            i16++;
                                        } else {
                                            z16 = true;
                                            break;
                                        }
                                    }
                                    Boolean boxBoolean = Boxing.boxBoolean(z16);
                                    this.label = 1;
                                    if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Boolean[] boolArr, @Nullable Continuation<? super Unit> continuation) {
                                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                                anonymousClass3.L$0 = flowCollector;
                                anonymousClass3.L$1 = boolArr;
                                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        @Nullable
                        public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                            Object coroutine_suspended2;
                            final Flow[] flowArr2 = flowArr;
                            Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<Boolean[]>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel$saveImageFile$1$invokeSuspend$$inlined$combine$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                @Nullable
                                public final Boolean[] invoke() {
                                    return new Boolean[flowArr2.length];
                                }
                            }, new AnonymousClass3(null), continuation);
                            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (combineInternal == coroutine_suspended2) {
                                return combineInternal;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (cancellable.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        } catch (Exception e16) {
            w53.b.c("MagicStudioMultiViewModel", "saveImageFile result: " + e16.getMessage());
            this.this$0.d2().postValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioMultiViewModel$saveImageFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
