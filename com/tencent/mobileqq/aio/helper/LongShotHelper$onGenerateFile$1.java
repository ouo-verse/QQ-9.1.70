package com.tencent.mobileqq.aio.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOScreenShotApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.helper.LongShotHelper$onGenerateFile$1", f = "LongShotHelper.kt", i = {}, l = {com.tencent.luggage.wxa.gf.i.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class LongShotHelper$onGenerateFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $path;
    final /* synthetic */ long $peerUin;
    int label;
    final /* synthetic */ LongShotHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongShotHelper$onGenerateFile$1(LongShotHelper longShotHelper, long j3, String str, Bitmap bitmap, Continuation<? super LongShotHelper$onGenerateFile$1> continuation) {
        super(2, continuation);
        this.this$0 = longShotHelper;
        this.$peerUin = j3;
        this.$path = str;
        this.$bitmap = bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, longShotHelper, Long.valueOf(j3), str, bitmap, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LongShotHelper$onGenerateFile$1(this.this$0, this.$peerUin, this.$path, this.$bitmap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IAIOScreenShotApi.OperationCode operationCode;
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                operationCode = this.this$0.mOperationCode;
                if (operationCode != null) {
                    final LongShotHelper longShotHelper = this.this$0;
                    long j3 = this.$peerUin;
                    String str = this.$path;
                    Bitmap bitmap = this.$bitmap;
                    IAIOScreenShotApi iAIOScreenShotApi = (IAIOScreenShotApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOScreenShotApi.class);
                    activity = longShotHelper.mActivity;
                    Intrinsics.checkNotNull(activity);
                    String valueOf = String.valueOf(j3);
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.helper.LongShotHelper$onGenerateFile$1$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LongShotHelper.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                LongShotHelper.this.I();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    };
                    this.label = 1;
                    if (iAIOScreenShotApi.aioScreenShotOperation(activity, valueOf, str, bitmap, operationCode, function0, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LongShotHelper$onGenerateFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
