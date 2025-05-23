package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.mobileqq.wink.editor.openingending.a;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1", f = "WinkEditorOpeningEndingAigcImageSelectFragment.kt", i = {}, l = {MiniReportManager.EventId.SDK_EMBEDDED_VIDEO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkEditorOpeningEndingAigcImageSelectFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<com.tencent.mobileqq.wink.editor.openingending.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkEditorOpeningEndingAigcImageSelectFragment f321330d;

        public a(WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment) {
            this.f321330d = winkEditorOpeningEndingAigcImageSelectFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(com.tencent.mobileqq.wink.editor.openingending.a aVar, @NotNull Continuation<? super Unit> continuation) {
            com.tencent.mobileqq.wink.editor.openingending.a aVar2 = aVar;
            if (aVar2 instanceof a.NeedDismiss) {
                this.f321330d.needDismiss = ((a.NeedDismiss) aVar2).getNeedDismiss();
            } else if (aVar2 instanceof a.AigcTemplateGenerateResult) {
                this.f321330d.Fi((a.AigcTemplateGenerateResult) aVar2);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1(WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment, Continuation<? super WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorOpeningEndingAigcImageSelectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkEditorOpeningEndingViewModel Ei;
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
            Ei = this.this$0.Ei();
            SharedFlow<com.tencent.mobileqq.wink.editor.openingending.a> r26 = Ei.r2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (r26.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorOpeningEndingAigcImageSelectFragment$initLiveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
