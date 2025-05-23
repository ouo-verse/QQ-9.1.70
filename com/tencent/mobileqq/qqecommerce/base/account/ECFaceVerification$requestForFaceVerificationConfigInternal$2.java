package com.tencent.mobileqq.qqecommerce.base.account;

import com.tencent.ecommerce.base.account.api.IECFaceVerification;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.base.account.ECFaceVerification$requestForFaceVerificationConfigInternal$2", f = "ECFaceVerification.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ECFaceVerification$requestForFaceVerificationConfigInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IECFaceVerification.IdentificationConfig>, Object> {
    final /* synthetic */ int $appId;
    final /* synthetic */ String $from;
    final /* synthetic */ String $idCard;
    final /* synthetic */ String $key;
    final /* synthetic */ String $keyType;
    final /* synthetic */ String $name;
    final /* synthetic */ long $nonce;
    final /* synthetic */ String $uin;
    int label;
    final /* synthetic */ ECFaceVerification this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECFaceVerification$requestForFaceVerificationConfigInternal$2(ECFaceVerification eCFaceVerification, String str, String str2, String str3, int i3, String str4, String str5, String str6, long j3, Continuation<? super ECFaceVerification$requestForFaceVerificationConfigInternal$2> continuation) {
        super(2, continuation);
        this.this$0 = eCFaceVerification;
        this.$uin = str;
        this.$idCard = str2;
        this.$name = str3;
        this.$appId = i3;
        this.$keyType = str4;
        this.$key = str5;
        this.$from = str6;
        this.$nonce = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECFaceVerification$requestForFaceVerificationConfigInternal$2(this.this$0, this.$uin, this.$idCard, this.$name, this.$appId, this.$keyType, this.$key, this.$from, this.$nonce, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MediaType mediaType;
        String str;
        OkHttpClient c16;
        ResponseBody body;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = new JSONObject();
            String str2 = this.$idCard;
            String str3 = this.$name;
            jSONObject.put("id_card", str2);
            jSONObject.put("name", str3);
            JSONObject jSONObject2 = new JSONObject();
            int i3 = this.$appId;
            String str4 = this.$keyType;
            String str5 = this.$key;
            String str6 = this.$uin;
            String str7 = this.$from;
            long j3 = this.$nonce;
            jSONObject2.put("appid", i3);
            jSONObject2.put("key_type", str4);
            jSONObject2.put("key", str5);
            jSONObject2.put("uin", str6);
            jSONObject2.put("from", str7);
            jSONObject2.put("nonce", j3);
            jSONObject2.put("identity", jSONObject);
            String jSONObject3 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026\n            }.toString()");
            Request.Builder url = new Request.Builder().url("https://graph.qq.com/face/if_proxy");
            RequestBody.Companion companion = RequestBody.INSTANCE;
            mediaType = this.this$0.jsonType;
            Request build = url.post(companion.create(mediaType, jSONObject3)).build();
            IECFaceVerification.IdentificationConfig identificationConfig = null;
            try {
                c16 = this.this$0.c();
                body = c16.newCall(build).execute().body();
            } catch (IOException e16) {
                QLog.e("ECFaceVerification", 1, "getFaceVerificationConfig error, " + e16.getMessage(), e16);
            }
            if (body != null) {
                str = body.string();
                if (!(str != null || str.length() == 0)) {
                    QLog.e("ECFaceVerification", 1, "getFaceVerificationConfig error, rsp is null");
                    return null;
                }
                try {
                    JSONObject jSONObject4 = new JSONObject(str);
                    int optInt = jSONObject4.optInt("ret", -1);
                    if (optInt == 0) {
                        String tmpKey = jSONObject4.optString("tmpkey");
                        String openId = jSONObject4.optString("openid");
                        Intrinsics.checkNotNullExpressionValue(openId, "openId");
                        Intrinsics.checkNotNullExpressionValue(tmpKey, "tmpKey");
                        identificationConfig = new IECFaceVerification.IdentificationConfig(openId, tmpKey, this.$uin);
                    } else {
                        QLog.e("ECFaceVerification", 1, "request error, code=" + optInt + " msg=" + jSONObject4.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG));
                    }
                } catch (JSONException e17) {
                    QLog.e("ECFaceVerification", 1, "parse json error, " + e17.getMessage(), e17);
                }
                return identificationConfig;
            }
            str = null;
            if (!(str != null || str.length() == 0)) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IECFaceVerification.IdentificationConfig> continuation) {
        return ((ECFaceVerification$requestForFaceVerificationConfigInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
