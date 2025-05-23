package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016JO\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0010\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/jsp/AppPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "args", "Lorg/json/JSONObject;", "param", "", "p", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "", "Lsy2/e;", "d", "Lkotlin/Lazy;", "r", "()Ljava/util/List;", "mHandlerList", "<init>", "()V", "e", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AppPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy mHandlerList;

    public AppPlugin() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends sy2.e>>() { // from class: com.tencent.mobileqq.jsp.AppPlugin$mHandlerList$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends sy2.e> invoke() {
                return new sy2.h().get();
            }
        });
        this.mHandlerList = lazy;
    }

    private final void p(String args, JSONObject param) {
        if (args == null) {
            QLog.d("AppPlugin", 1, "callbackJS args null");
            return;
        }
        String optString = new JSONObject(args).optString("callback", "");
        if (TextUtils.isEmpty(optString)) {
            QLog.d("AppPlugin", 1, "callbackJS callbackFunc null");
        } else {
            callJs(optString, param.toString());
        }
    }

    private final Activity q() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private final List<sy2.e> r() {
        return (List) this.mHandlerList.getValue();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "app";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        QLog.d("AppPlugin", 1, "handleJsPackageInfoRequest methodName: " + method);
        Activity q16 = q();
        if (q16 == null) {
            QLog.d("AppPlugin", 1, "handleJsPackageInfoRequest context null");
            return false;
        }
        if (TextUtils.isEmpty(method)) {
            QLog.d("AppPlugin", 1, "handleJsPackageInfoRequest method null");
            return false;
        }
        for (sy2.e eVar : r()) {
            Intrinsics.checkNotNull(method);
            Object a16 = eVar.a(q16, method, (String[]) Arrays.copyOf(args, args.length));
            if (a16 != null) {
                if (!(args.length == 0)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("info", a16);
                    p(args[0], jSONObject);
                }
                return true;
            }
        }
        return false;
    }
}
