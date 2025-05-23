package com.tencent.mobileqq.vas.adv.kuikly.common;

import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.adv.kuikly.common.QQKuiklyAdModule$getDeviceInfo$1", f = "QQKuiklyAdModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
final class QQKuiklyAdModule$getDeviceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ String $params;
    int label;
    final /* synthetic */ QQKuiklyAdModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyAdModule$getDeviceInfo$1(String str, Function1<Object, Unit> function1, QQKuiklyAdModule qQKuiklyAdModule, Continuation<? super QQKuiklyAdModule$getDeviceInfo$1> continuation) {
        super(2, continuation);
        this.$params = str;
        this.$callback = function1;
        this.this$0 = qQKuiklyAdModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QQKuiklyAdModule$getDeviceInfo$1(this.$params, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JSONObject jSONObject;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject2 = new JSONObject();
            if (this.$params == null) {
                Function1<Object, Unit> function1 = this.$callback;
                if (function1 != null) {
                    function1.invoke(jSONObject2);
                }
                return Unit.INSTANCE;
            }
            try {
                JSONObject jSONObject3 = new JSONObject(this.$params);
                GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
                params.supportOpenMotiveAd = jSONObject3.optBoolean("supportOpenMotiveAd", false);
                GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(this.this$0.getContext(), params);
                if (create != null) {
                    jSONObject = (JSONObject) GdtJsonPbUtil.pbToJson(create.deviceInfo);
                } else {
                    jSONObject = null;
                }
                Function1<Object, Unit> function12 = this.$callback;
                if (function12 != null) {
                    if (jSONObject == null) {
                        jSONObject = jSONObject2;
                    }
                    function12.invoke(jSONObject);
                }
            } catch (Throwable th5) {
                QLog.e("QQKuiklyAdModule", 1, "getDeviceInfo error ", th5);
                Function1<Object, Unit> function13 = this.$callback;
                if (function13 != null) {
                    function13.invoke(jSONObject2);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QQKuiklyAdModule$getDeviceInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
