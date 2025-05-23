package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.render.impl.FilamentNativeApp$startWithEntry$4", f = "FilamentNativeApp.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilamentNativeApp$startWithEntry$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FilamentNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentNativeApp$startWithEntry$4(FilamentNativeApp filamentNativeApp, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentNativeApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentNativeApp$startWithEntry$4(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentNativeApp$startWithEntry$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IBusinessScene iBusinessScene;
        com.tencent.zplan.zplantracing.c cVar;
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
                iBusinessScene = this.this$0.scene;
                if (iBusinessScene != null) {
                    com.tencent.zplan.zplantracing.b bVar = this.this$0.startWithEntrySpan;
                    if (bVar != null) {
                        cVar = bVar.c();
                    } else {
                        cVar = null;
                    }
                    this.label = 1;
                    if (iBusinessScene.onLaunch(cVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } catch (Throwable th5) {
            FLog.INSTANCE.e("FilamentNativeApp", "onLaunch exception", th5);
            this.this$0.startUpTrack.j(String.valueOf(this.this$0.appStatus.get()), 201000, th5.getMessage());
            com.tencent.zplan.zplantracing.b bVar2 = this.this$0.startWithEntrySpan;
            if (bVar2 != null) {
                bVar2.a(th5.getMessage());
            }
            this.this$0.startWithEntrySpan = null;
        }
        return Unit.INSTANCE;
    }
}
