package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J7\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u0012J7\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u0012J7\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u0012J7\u0010\u0017\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ah;", "", "", "encryptingStr", "publicKeyStr", "k", "encryptString", "encryptKey", "j", "decryptString", "decryptKey", "g", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", DomainData.DOMAIN_NAME, "l", tl.h.F, "e", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ah {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String jsonString, ah this$0, Function1 callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String key = jSONObject.optString("key");
        String content = jSONObject.optString("content");
        QLog.d("Secret", 4, "decryptAes from:" + content);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(key, "key");
        String g16 = this$0.g(content, key);
        QLog.d("Secret", 4, "decryptAes to:" + g16);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", g16));
        callback.invoke(mapOf);
    }

    private final String g(String decryptString, String decryptKey) {
        try {
            byte[] decode = Base64.decode(decryptString);
            Charset charset = Charsets.UTF_8;
            byte[] bytes = decryptKey.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(2, secretKeySpec);
            byte[] decryptedData = cipher.doFinal(decode);
            Intrinsics.checkNotNullExpressionValue(decryptedData, "decryptedData");
            return new String(decryptedData, charset);
        } catch (Exception e16) {
            QLog.e("Secret", 1, e16, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String jsonString, ah this$0, Function1 callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String key = jSONObject.optString("key");
        String content = jSONObject.optString("content");
        QLog.d("Secret", 4, "encryptAes from:" + content);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(key, "key");
        String j3 = this$0.j(content, key);
        QLog.d("Secret", 4, "encryptAes to:" + j3);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", j3));
        callback.invoke(mapOf);
    }

    private final String j(String encryptString, String encryptKey) {
        try {
            Charset charset = Charsets.UTF_8;
            byte[] bytes = encryptKey.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(1, secretKeySpec);
            byte[] bytes2 = encryptString.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            String encode = Base64.encode(cipher.doFinal(bytes2));
            Intrinsics.checkNotNullExpressionValue(encode, "encode(cipher.doFinal(en\u2026teArray(Charsets.UTF_8)))");
            return encode;
        } catch (Exception e16) {
            QLog.e("Secret", 1, e16, new Object[0]);
            return "";
        }
    }

    private final String k(String encryptingStr, String publicKeyStr) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(publicKeyStr));
            byte[] bytes = encryptingStr.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            String encode = Base64.encode(cipher.doFinal(bytes));
            Intrinsics.checkNotNullExpressionValue(encode, "encode(cipher.doFinal(data))");
            return encode;
        } catch (Exception e16) {
            QLog.e("Secret", 1, e16, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String jsonString, ah this$0, Function1 callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String key = jSONObject.optString("key");
        String content = jSONObject.optString("content");
        QLog.d("Secret", 4, "from:" + content);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        Intrinsics.checkNotNullExpressionValue(key, "key");
        String k3 = this$0.k(content, key);
        QLog.d("Secret", 4, "to:" + k3);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", k3));
        callback.invoke(mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String jsonString, Function1 callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String key = jSONObject.optString("key");
        String content = jSONObject.optString("content");
        QLog.d("Secret", 4, "from:" + content);
        Intrinsics.checkNotNullExpressionValue(key, "key");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = key.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        mac.init(secretKeySpec);
        Intrinsics.checkNotNullExpressionValue(content, "content");
        byte[] bytes2 = content.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        String encode = Base64.encode(mac.doFinal(bytes2));
        QLog.d("Secret", 4, "to:" + encode);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", encode));
        callback.invoke(mapOf);
    }

    public final void e(@NotNull final String jsonString, @NotNull final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.ae
            @Override // java.lang.Runnable
            public final void run() {
                ah.f(jsonString, this, callback);
            }
        });
    }

    public final void h(@NotNull final String jsonString, @NotNull final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.af
            @Override // java.lang.Runnable
            public final void run() {
                ah.i(jsonString, this, callback);
            }
        });
    }

    public final void l(@NotNull final String jsonString, @NotNull final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.ad
            @Override // java.lang.Runnable
            public final void run() {
                ah.m(jsonString, this, callback);
            }
        });
    }

    public final void n(@NotNull final String jsonString, @NotNull final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.ag
            @Override // java.lang.Runnable
            public final void run() {
                ah.o(jsonString, callback);
            }
        });
    }
}
