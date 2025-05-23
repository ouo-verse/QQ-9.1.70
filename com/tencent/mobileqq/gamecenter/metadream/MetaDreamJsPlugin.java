package com.tencent.mobileqq.gamecenter.metadream;

import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.jsplugin.QQWidgetJsPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016JO\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000e\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/metadream/MetaDreamJsPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "jsCallback", "", "r", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "<init>", "()V", "d", "a", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MetaDreamJsPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f212205d = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/metadream/MetaDreamJsPlugin$a;", "", "", "METHOD_ADD_WIDGET", "Ljava/lang/String;", "METHOD_HAS_WIDGET", "METHOD_NAME_IS_TAB_ON", "NAMESPACE", "PARAM_CALLBACK", "PARAM_DATA", "PARAM_ERROR_MSG", "PARAM_RETURN_CODE", "TAG", "<init>", "()V", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void p(final String jsCallback) {
        final JSONObject jSONObject = new JSONObject();
        try {
            ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).addWidget(new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.gamecenter.metadream.MetaDreamJsPlugin$handleAddWidget$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    QLog.d("MetaDreamJsPlugin", 1, "handleAddWidget result:" + i3);
                    JSONObject.this.put("code", i3);
                    JSONObject.this.put("msg", errMsg);
                    this.callJs(jsCallback, JSONObject.this.toString());
                }
            });
        } catch (Exception e16) {
            QLog.e("MetaDreamJsPlugin", 1, "handleAddWidget exception", e16);
            jSONObject.put("code", -1);
            jSONObject.put("msg", "exception");
            callJs(jsCallback, jSONObject.toString());
        }
    }

    private final void q(String jsCallback) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).hasWidget()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("hasWidget", i3);
            jSONObject2.put("code", 0);
        } catch (Exception e16) {
            QLog.e("MetaDreamJsPlugin", 1, "handleHasWidget exception", e16);
            jSONObject2.put("code", -1);
            jSONObject2.put("msg", "exception");
        }
        jSONObject2.put("data", jSONObject.toString());
        callJs(jsCallback, jSONObject2.toString());
    }

    private final void r(String jsCallback) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).isTabOn()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("isOn", i3);
            jSONObject2.put("code", 0);
        } catch (Exception e16) {
            QLog.e("MetaDreamJsPlugin", 1, "handleIsTabOn exception", e16);
            jSONObject2.put("code", -1);
            jSONObject2.put("msg", "exception");
        }
        jSONObject2.put("data", jSONObject.toString());
        callJs(jsCallback, jSONObject2.toString());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "metadream";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.d("MetaDreamJsPlugin", 2, "handleJsRequest -> url : " + url + ",pkgName : " + pkgName + ",method : " + method + ",args[0 : " + args[0]);
        }
        if (Intrinsics.areEqual("metadream", pkgName)) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
            String str = (String) firstOrNull;
            if (str != null) {
                String optString = new JSONObject(str).optString("callback", null);
                if (method == null) {
                    return false;
                }
                int hashCode = method.hashCode();
                if (hashCode != -168297090) {
                    if (hashCode != 104792645) {
                        if (hashCode != 2071520586 || !method.equals("isTabOn")) {
                            return false;
                        }
                        r(optString);
                    } else {
                        if (!method.equals(QQWidgetJsPlugin.EVENT_ADD_WIDGET)) {
                            return false;
                        }
                        p(optString);
                    }
                } else {
                    if (!method.equals("hasWidget")) {
                        return false;
                    }
                    q(optString);
                }
                return true;
            }
            return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
        }
        return false;
    }
}
