package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.os.SystemClock;
import java.util.concurrent.TimeoutException;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\t\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.lowthresholdltemplate.WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1", f = "WinkPhotoTemplateViewModel.kt", i = {}, l = {94, 103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Unit, ? extends Long>>, Object> {
    final /* synthetic */ Ref.BooleanRef $needDownLoadSo;
    int label;
    final /* synthetic */ WinkPhotoTemplateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1(WinkPhotoTemplateViewModel winkPhotoTemplateViewModel, Ref.BooleanRef booleanRef, Continuation<? super WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = winkPhotoTemplateViewModel;
        this.$needDownLoadSo = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1(this.this$0, this.$needDownLoadSo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Unit, ? extends Long>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Unit, Long>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        r W1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return TuplesKt.to(Unit.INSTANCE, Boxing.boxLong(SystemClock.elapsedRealtime()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                w53.b.f(this.this$0.getTAG(), "isEditorResReady begin");
                WinkPhotoTemplateViewModel winkPhotoTemplateViewModel = this.this$0;
                this.label = 1;
                obj = winkPhotoTemplateViewModel.a2(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Pair pair = (Pair) obj;
            if (((Boolean) pair.getFirst()).booleanValue()) {
                this.$needDownLoadSo.element = ((Boolean) pair.getSecond()).booleanValue();
                W1 = this.this$0.W1();
                this.label = 2;
                if (W1.d(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return TuplesKt.to(Unit.INSTANCE, Boxing.boxLong(SystemClock.elapsedRealtime()));
            }
            throw new TemplateShareException(2, new TimeoutException("wait Camera Res Ready timeout"));
        } catch (Exception e16) {
            throw new TemplateShareException(2, e16);
        }
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<Unit, Long>> continuation) {
        return ((WinkPhotoTemplateViewModel$requestAndProcessData$1$1$loadLightDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
