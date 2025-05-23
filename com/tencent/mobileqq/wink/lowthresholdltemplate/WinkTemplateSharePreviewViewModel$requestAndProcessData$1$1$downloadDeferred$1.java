package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.os.SystemClock;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1", f = "WinkTemplateSharePreviewViewModel.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends String>, ? extends Long>>, Object> {
    int label;
    final /* synthetic */ WinkTemplateSharePreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1(WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel, Continuation<? super WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkTemplateSharePreviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<? extends String>, ? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<? extends List<String>, Long>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        r X1;
        p pVar;
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
                X1 = this.this$0.X1();
                pVar = this.this$0.winkTemplateShareConfig;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                    pVar = null;
                }
                p.TemplateConfig d16 = pVar.d();
                this.label = 1;
                obj = X1.b(d16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return TuplesKt.to((List) obj, Boxing.boxLong(SystemClock.elapsedRealtime()));
        } catch (Exception e16) {
            throw new TemplateShareException(4, e16);
        }
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<? extends List<String>, Long>> continuation) {
        return ((WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$downloadDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
