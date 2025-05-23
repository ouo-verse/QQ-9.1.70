package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$3", f = "EditMiniHomeFragment.kt", i = {}, l = {1936}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class EditMiniHomeFragment$onCreateView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableStateFlow<r55.b[]> $roomSource;
    final /* synthetic */ com.tencent.mobileqq.zplan.minihome.view.h $sampleRoomAdapter;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<r55.b[]> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.minihome.view.h f334259d;

        public a(com.tencent.mobileqq.zplan.minihome.view.h hVar) {
            this.f334259d = hVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(r55.b[] bVarArr, Continuation<? super Unit> continuation) {
            r55.b[] bVarArr2 = bVarArr;
            int length = bVarArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                }
                if (bVarArr2[i3].f430795r) {
                    break;
                }
                i3++;
            }
            Integer boxInt = Boxing.boxInt(i3);
            if (!(boxInt.intValue() != -1)) {
                boxInt = null;
            }
            if (boxInt != null && boxInt.intValue() < bVarArr2.length) {
                this.f334259d.p0(boxInt);
            }
            this.f334259d.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMiniHomeFragment$onCreateView$3(MutableStateFlow<r55.b[]> mutableStateFlow, com.tencent.mobileqq.zplan.minihome.view.h hVar, Continuation<? super EditMiniHomeFragment$onCreateView$3> continuation) {
        super(2, continuation);
        this.$roomSource = mutableStateFlow;
        this.$sampleRoomAdapter = hVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditMiniHomeFragment$onCreateView$3(this.$roomSource, this.$sampleRoomAdapter, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<r55.b[]> mutableStateFlow = this.$roomSource;
            a aVar = new a(this.$sampleRoomAdapter);
            this.label = 1;
            if (mutableStateFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditMiniHomeFragment$onCreateView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
