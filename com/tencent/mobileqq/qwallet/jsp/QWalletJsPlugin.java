package com.tencent.mobileqq.qwallet.jsp;

import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001e\u001f !B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016JO\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\t\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/webview/swift/y;", "uiInterface", "setWebUiInterface", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "onActivityResult", "<init>", "()V", "d", "a", "EnumMethodHandler", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletJsPlugin extends WebViewPlugin {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$EnumMethodHandler;", "", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "handler", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "getHandler", "()Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;)V", "invoke", "getPayAdInfo", "pushMusicInfo", "financialPetOperation", "openCustomWebview", "getTopBarInfo", "financialPetShareArkMessage", TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, "studentAuthorization", "openLogin", "getEncryptedAccount", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public enum EnumMethodHandler {
        invoke(new QWInvokeHandler()),
        getPayAdInfo(new com.tencent.mobileqq.qwallet.jsp.c()),
        pushMusicInfo(new g()),
        financialPetOperation(new a()),
        openCustomWebview(new e()),
        getTopBarInfo(new d()),
        financialPetShareArkMessage(new FinancialPetShareArkMessageHandler()),
        authorization(new h()),
        studentAuthorization(new j()),
        openLogin(new f()),
        getEncryptedAccount(new com.tencent.mobileqq.qwallet.jsp.b());


        @NotNull
        private final b handler;

        EnumMethodHandler(b bVar) {
            this.handler = bVar;
        }

        @NotNull
        public final b getHandler() {
            return this.handler;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$c;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface c {
        void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "qw";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean z16;
        String str;
        String str2;
        EnumMethodHandler enumMethodHandler;
        Object firstOrNull;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(args, "args");
        int i3 = 0;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "";
        } else {
            str = args[0];
        }
        QLog.i("QWalletJsPlugin", 1, "handleJsRequest -> url : " + url + ", pkgName : " + pkgName + ", method : " + method + ", args[0] : " + str);
        if (!Intrinsics.areEqual("qw", pkgName) || method == null) {
            return false;
        }
        EnumMethodHandler[] values = EnumMethodHandler.values();
        int length = values.length;
        while (true) {
            str2 = null;
            if (i3 < length) {
                enumMethodHandler = values[i3];
                if (Intrinsics.areEqual(enumMethodHandler.name(), method)) {
                    break;
                }
                i3++;
            } else {
                enumMethodHandler = null;
                break;
            }
        }
        if (enumMethodHandler != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
            String str3 = (String) firstOrNull;
            if (str3 != null) {
                try {
                    jSONObject = new JSONObject(str3);
                } catch (JSONException unused) {
                    QLog.w("QWalletJsPlugin", 2, "handleJsRequest fail, args[0] not json: " + str3);
                }
                if (jSONObject != null) {
                    str2 = jSONObject.optString("callback");
                }
                enumMethodHandler.getHandler().a(this, jSONObject, args, str2);
                return true;
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
            enumMethodHandler.getHandler().a(this, jSONObject, args, str2);
            return true;
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(@Nullable Intent intent, byte requestCode, int resultCode) {
        super.onActivityResult(intent, requestCode, resultCode);
        for (EnumMethodHandler enumMethodHandler : EnumMethodHandler.values()) {
            enumMethodHandler.getHandler().b(this, intent, requestCode, resultCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        for (EnumMethodHandler enumMethodHandler : EnumMethodHandler.values()) {
            enumMethodHandler.getHandler().c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        for (EnumMethodHandler enumMethodHandler : EnumMethodHandler.values()) {
            enumMethodHandler.getHandler().d();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void setWebUiInterface(@Nullable y uiInterface) {
        super.setWebUiInterface(uiInterface);
        for (EnumMethodHandler enumMethodHandler : EnumMethodHandler.values()) {
            enumMethodHandler.getHandler().e(uiInterface);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "", "c", "d", "Lcom/tencent/mobileqq/webview/swift/y;", "uiInterface", "e", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static abstract class b implements c {
        public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
        }

        public void c(@NotNull WebViewPlugin plugin) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
        }

        public void d() {
        }

        public void e(@Nullable y uiInterface) {
        }
    }
}
