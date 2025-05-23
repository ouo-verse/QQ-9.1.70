package com.tencent.mobileqq.dt.web;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.dt.web.O3WebViewPlugin$accountAssistantCheckFace$1", f = "O3WebViewPlugin.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class O3WebViewPlugin$accountAssistantCheckFace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $callbackId;
    final /* synthetic */ JSONObject $json;
    int label;
    final /* synthetic */ O3WebViewPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O3WebViewPlugin$accountAssistantCheckFace$1(JSONObject jSONObject, O3WebViewPlugin o3WebViewPlugin, String str, Continuation<? super O3WebViewPlugin$accountAssistantCheckFace$1> continuation) {
        super(2, continuation);
        this.$json = jSONObject;
        this.this$0 = o3WebViewPlugin;
        this.$callbackId = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, jSONObject, o3WebViewPlugin, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new O3WebViewPlugin$accountAssistantCheckFace$1(this.$json, this.this$0, this.$callbackId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        byte[] bArr;
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
                String conversationId = this.$json.optString("conversationid", "");
                String token = this.$json.optString("token", "");
                int optInt = this.$json.optInt("retcode", -1);
                IO3AssistantRobotApi iO3AssistantRobotApi = (IO3AssistantRobotApi) QRoute.api(IO3AssistantRobotApi.class);
                Intrinsics.checkNotNullExpressionValue(conversationId, "conversationId");
                Intrinsics.checkNotNullExpressionValue(token, "token");
                bArr = this.this$0.smsToken;
                this.label = 1;
                obj = iO3AssistantRobotApi.accountAssistantCheckFace(conversationId, optInt, token, bArr, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            com.tencent.qqprotect.accountassistant.chat.data.basic.a aVar = (com.tencent.qqprotect.accountassistant.chat.data.basic.a) obj;
            if (aVar.d()) {
                O3WebViewPlugin o3WebViewPlugin = this.this$0;
                String str = this.$callbackId;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "");
                Unit unit = Unit.INSTANCE;
                o3WebViewPlugin.callJs(str, jSONObject.toString());
                return Unit.INSTANCE;
            }
            QLog.e("O3WebViewPlugin", 1, "accountAssistantCheckFace failed code=" + aVar.c());
            O3WebViewPlugin o3WebViewPlugin2 = this.this$0;
            String str2 = this.$callbackId;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", aVar.c());
            jSONObject2.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, aVar.b());
            Unit unit2 = Unit.INSTANCE;
            o3WebViewPlugin2.callJs(str2, jSONObject2.toString());
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((O3WebViewPlugin$accountAssistantCheckFace$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
