package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.model.GenerateFlowInfo;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$aigcContentFlow$2", f = "MagicStudioCreationViewModel.kt", i = {}, l = {1147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$aigcContentFlow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $count;
    final /* synthetic */ String $desc;
    final /* synthetic */ MutableSharedFlow<GenerateFlowInfo> $firstAigcFlow;
    final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f $nnCurStyle;
    final /* synthetic */ String $picPath;
    final /* synthetic */ boolean $requireBaseImageIndex;
    final /* synthetic */ String $safeId;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>>> {
        final /* synthetic */ ArrayList C;
        final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f323626d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f323627e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MagicStudioCreationViewModel f323628f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f323629h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ MutableSharedFlow f323630i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f323631m;

        public a(AtomicInteger atomicInteger, Ref.IntRef intRef, MagicStudioCreationViewModel magicStudioCreationViewModel, CoroutineScope coroutineScope, MutableSharedFlow mutableSharedFlow, int i3, ArrayList arrayList, com.tencent.mobileqq.wink.magicstudio.model.f fVar) {
            this.f323626d = atomicInteger;
            this.f323627e = intRef;
            this.f323628f = magicStudioCreationViewModel;
            this.f323629h = coroutineScope;
            this.f323630i = mutableSharedFlow;
            this.f323631m = i3;
            this.C = arrayList;
            this.D = fVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>> pair, @NotNull Continuation<? super Unit> continuation) {
            Object f36;
            Object coroutine_suspended;
            Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>> pair2 = pair;
            w53.b.f("MagicStudioCreationViewModel", "aigcContentFlow successCount = " + this.f323626d + ", extra = " + pair2.getFirst().extra);
            Ref.IntRef intRef = this.f323627e;
            int i3 = intRef.element + (-1);
            intRef.element = i3;
            f36 = this.f323628f.f3(this.f323629h, pair2, this.f323626d, this.f323630i, this.f323631m, this.C, i3, this.D, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (f36 == coroutine_suspended) {
                return f36;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$aigcContentFlow$2(MagicStudioCreationViewModel magicStudioCreationViewModel, int i3, String str, com.tencent.mobileqq.wink.magicstudio.model.f fVar, String str2, String str3, MutableSharedFlow<GenerateFlowInfo> mutableSharedFlow, boolean z16, CoroutineScope coroutineScope, Continuation<? super MagicStudioCreationViewModel$aigcContentFlow$2> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$count = i3;
        this.$desc = str;
        this.$nnCurStyle = fVar;
        this.$picPath = str2;
        this.$safeId = str3;
        this.$firstAigcFlow = mutableSharedFlow;
        this.$requireBaseImageIndex = z16;
        this.$scope = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$aigcContentFlow$2(this.this$0, this.$count, this.$desc, this.$nnCurStyle, this.$picPath, this.$safeId, this.$firstAigcFlow, this.$requireBaseImageIndex, this.$scope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList B2;
        ArrayList b36;
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
            w53.b.f("MagicStudioCreationViewModel", "aigcContentFlow start");
            AtomicInteger atomicInteger = new AtomicInteger(0);
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            this.this$0.aigcCount = this.$count;
            Ref.IntRef intRef = new Ref.IntRef();
            int i16 = this.$count;
            intRef.element = i16;
            B2 = this.this$0.B2(i16);
            b36 = this.this$0.b3(this.$count, this.$desc, this.$nnCurStyle, this.$picPath, this.$safeId, atomicInteger2, atomicInteger, this.$firstAigcFlow, this.$requireBaseImageIndex);
            Flow cancellable = FlowKt.cancellable(FlowKt.merge(b36));
            a aVar = new a(atomicInteger, intRef, this.this$0, this.$scope, this.$firstAigcFlow, this.$count, B2, this.$nnCurStyle);
            this.label = 1;
            if (cancellable.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$aigcContentFlow$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
