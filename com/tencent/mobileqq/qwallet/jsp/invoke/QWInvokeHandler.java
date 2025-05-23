package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.content.Intent;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0005\u000e\u001a\u001b\u0017\u001cB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J=\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0016J*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "", "jsCallback", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$EnumError;", "error", "Lorg/json/JSONObject;", "jsonData", "", "f", "", "args", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "d", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "<init>", "()V", "EnumError", "EnumInvokeMethod", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWInvokeHandler extends QWalletJsPlugin.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$EnumError;", "", "retCode", "", "retMsg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getRetCode", "()I", "getRetMsg", "()Ljava/lang/String;", "NO_METHOD_PARAM", "NO_MATCH_METHOD", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum EnumError {
        NO_METHOD_PARAM(-1001, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR),
        NO_MATCH_METHOD(-1002, "\u5f53\u524d\u7248\u672c\u8fc7\u4f4e\uff0c\u8bf7\u5347\u7ea7\u81f3QQ\u6700\u65b0\u7248\u672c\u3002");

        private final int retCode;

        @NotNull
        private final String retMsg;

        EnumError(int i3, String str) {
            this.retCode = i3;
            this.retMsg = str;
        }

        public final int getRetCode() {
            return this.retCode;
        }

        @NotNull
        public final String getRetMsg() {
            return this.retMsg;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$EnumInvokeMethod;", "", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "methodProcessor", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "getMethodProcessor", "()Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;)V", "qpaySilentLogin", "chooseAIGCImage", "bindBankFinish", "faceIdentify", "chsiCertification", "studentAuthorization", "queryAccountList", "getGatewayMobilePhone", "openFullWebview", "openSkinPreview", "getSkinSuccess", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public enum EnumInvokeMethod {
        qpaySilentLogin(new i()),
        chooseAIGCImage(new com.tencent.mobileqq.qwallet.jsp.invoke.b()),
        bindBankFinish(new a()),
        faceIdentify(new d()),
        chsiCertification(new com.tencent.mobileqq.qwallet.jsp.invoke.c()),
        studentAuthorization(new h()),
        queryAccountList(new j()),
        getGatewayMobilePhone(new QWalletLocalPhoneProcessor()),
        openFullWebview(new e()),
        openSkinPreview(new g()),
        getSkinSuccess(new f());


        @NotNull
        private final c methodProcessor;

        EnumInvokeMethod(c cVar) {
            this.methodProcessor = cVar;
        }

        @NotNull
        public final c getMethodProcessor() {
            return this.methodProcessor;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$b;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback);
    }

    private final void f(WebViewPlugin plugin, String jsCallback, EnumError error, JSONObject jsonData) {
        QLog.w("QWalletJsPlugin.qw.invoke", 1, "callbackFail, error: " + error + ", " + jsonData);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", error.getRetCode());
        jSONObject.put("retMsg", error.getRetMsg());
        plugin.callJs(jsCallback, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        String str;
        EnumInvokeMethod enumInvokeMethod;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        Unit unit = null;
        if (jsonData != null) {
            str = jsonData.optString("method");
        } else {
            str = null;
        }
        if (str == null) {
            f(plugin, jsCallback, EnumError.NO_METHOD_PARAM, jsonData);
            return;
        }
        EnumInvokeMethod[] values = EnumInvokeMethod.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                enumInvokeMethod = values[i3];
                if (Intrinsics.areEqual(enumInvokeMethod.name(), str)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                enumInvokeMethod = null;
                break;
            }
        }
        if (enumInvokeMethod != null) {
            enumInvokeMethod.getMethodProcessor().a(plugin, jsonData, jsCallback);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            f(plugin, jsCallback, EnumError.NO_MATCH_METHOD, jsonData);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        for (EnumInvokeMethod enumInvokeMethod : EnumInvokeMethod.values()) {
            enumInvokeMethod.getMethodProcessor().b(plugin, intent, requestCode, resultCode);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.b
    public void d() {
        super.d();
        for (EnumInvokeMethod enumInvokeMethod : EnumInvokeMethod.values()) {
            enumInvokeMethod.getMethodProcessor().c();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "", "b", "c", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static abstract class c implements b {
        public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
        }

        public void c() {
        }
    }
}
