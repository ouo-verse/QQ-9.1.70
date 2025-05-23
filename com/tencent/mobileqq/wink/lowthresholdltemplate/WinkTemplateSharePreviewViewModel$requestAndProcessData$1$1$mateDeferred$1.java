package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.mobileqq.wink.lowthresholdltemplate.r;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1", f = "WinkTemplateSharePreviewViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends MetaMaterial, ? extends Long>>, Object> {
    final /* synthetic */ Ref.BooleanRef $needDownLoadTemplate;
    int label;
    final /* synthetic */ WinkTemplateSharePreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1(WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel, Ref.BooleanRef booleanRef, Continuation<? super WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkTemplateSharePreviewViewModel;
        this.$needDownLoadTemplate = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1(this.this$0, this.$needDownLoadTemplate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends MetaMaterial, ? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<MetaMaterial, Long>>) continuation);
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
                obj = r.a.a(X1, d16, false, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Pair pair = (Pair) obj;
            MetaMaterial metaMaterial = (MetaMaterial) pair.getFirst();
            String m3 = WinkEditorResourceManager.a1().m((MetaMaterial) pair.getFirst());
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(mate.first)");
            com.tencent.mobileqq.wink.editor.c.D1(metaMaterial, m3);
            this.$needDownLoadTemplate.element = ((Boolean) pair.getSecond()).booleanValue();
            return TuplesKt.to(pair.getFirst(), Boxing.boxLong(SystemClock.elapsedRealtime()));
        } catch (Exception e16) {
            throw new TemplateShareException(3, e16);
        }
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<MetaMaterial, Long>> continuation) {
        return ((WinkTemplateSharePreviewViewModel$requestAndProcessData$1$1$mateDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
