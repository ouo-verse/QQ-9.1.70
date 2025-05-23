package com.tencent.mobileqq.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.inputstatus.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/InputStatusInfo;", "inputStatusInfo", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.helper.InputStatusHelper$listenerInputStatus$1", f = "InputStatusHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class InputStatusHelper$listenerInputStatus$1 extends SuspendLambda implements Function2<InputStatusInfo, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputStatusHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputStatusHelper$listenerInputStatus$1(InputStatusHelper inputStatusHelper, Continuation<? super InputStatusHelper$listenerInputStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = inputStatusHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStatusHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        InputStatusHelper$listenerInputStatus$1 inputStatusHelper$listenerInputStatus$1 = new InputStatusHelper$listenerInputStatus$1(this.this$0, continuation);
        inputStatusHelper$listenerInputStatus$1.L$0 = obj;
        return inputStatusHelper$listenerInputStatus$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull InputStatusInfo inputStatusInfo, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((InputStatusHelper$listenerInputStatus$1) create(inputStatusInfo, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) inputStatusInfo, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        com.tencent.aio.api.runtime.a aVar;
        boolean z16;
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                InputStatusInfo inputStatusInfo = (InputStatusInfo) this.L$0;
                aVar = this.this$0.aioContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                }
                if (Intrinsics.areEqual(aVar.g().r().c().j(), inputStatusInfo.fromUin) && Intrinsics.areEqual(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), inputStatusInfo.toUin)) {
                    QLog.d("InputStatusHelper", 1, "ListenerInputStatus: " + inputStatusInfo);
                    this.this$0.mTimeStamp = inputStatusInfo.timestamp;
                    int i3 = inputStatusInfo.eventType;
                    a.Companion companion = com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE;
                    if (i3 != companion.a()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (TextUtils.isEmpty(inputStatusInfo.statusText)) {
                            if (inputStatusInfo.eventType == companion.b()) {
                                str = HardCodeUtil.qqStr(R.string.yri);
                            } else {
                                str = HardCodeUtil.qqStr(R.string.yrh);
                            }
                            Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026                        }");
                        } else {
                            str = inputStatusInfo.statusText;
                            Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026                        }");
                        }
                    } else {
                        str = "";
                    }
                    String str2 = inputStatusInfo.statusText;
                    j3 = this.this$0.mTimeStamp;
                    QLog.d("InputStatusHelper", 1, "isShow:" + z16 + ", finalStatusText:" + str + ", statusText:" + str2 + ", mTimeStamp: " + j3);
                    this.this$0.M(z16, str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
