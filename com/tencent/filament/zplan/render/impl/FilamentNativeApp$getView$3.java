package com.tencent.filament.zplan.render.impl;

import android.content.Context;
import com.tencent.filament.zplanservice.util.DeviceUtil;
import com.tencent.luggage.wxa.ig.l;
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
@DebugMetadata(c = "com.tencent.filament.zplan.render.impl.FilamentNativeApp$getView$3", f = "FilamentNativeApp.kt", i = {}, l = {l.CTRL_INDEX, 500}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilamentNativeApp$getView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    final /* synthetic */ FilamentNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentNativeApp$getView$3(FilamentNativeApp filamentNativeApp, Context context, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentNativeApp;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentNativeApp$getView$3(this.this$0, this.$context, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentNativeApp$getView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        FilamentNativeApp filamentNativeApp;
        FilamentNativeApp filamentNativeApp2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            filamentNativeApp = (FilamentNativeApp) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            i3 = this.this$0.deviceLevel;
            if (i3 < 0) {
                filamentNativeApp = this.this$0;
                DeviceUtil deviceUtil = DeviceUtil.f106440d;
                Context context = this.$context;
                this.L$0 = filamentNativeApp;
                this.label = 1;
                obj = deviceUtil.d(context, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            filamentNativeApp2 = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (filamentNativeApp2.J0(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        filamentNativeApp.deviceLevel = ((Number) obj).intValue();
        filamentNativeApp2 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (filamentNativeApp2.J0(this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
