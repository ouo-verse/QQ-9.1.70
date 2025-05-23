package com.tencent.gdtad.web;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.downloader.p;
import com.tencent.gdtad.downloader.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xm0.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u000e*\u0001\u0017\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014JO\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/gdtad/web/a;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "paramJson", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "name", "r", "getNameSpace", "Lcom/tencent/biz/pubaccount/CustomWebView;", "webView", "onWebViewCreated", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "com/tencent/gdtad/web/a$c", "d", "Lcom/tencent/gdtad/web/a$c;", "mDownloadCallback", "e", "Ljava/lang/String;", "mListenerId", "f", "mDomain", "<init>", "()V", tl.h.F, "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mDownloadCallback = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mListenerId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mDomain;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/gdtad/web/a$b", "Lcom/tencent/gdtad/downloader/x;", "", "result", "", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements x {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f109770b;

        b(String str) {
            this.f109770b = str;
        }

        @Override // com.tencent.gdtad.downloader.x
        public void a(@NotNull String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("GdtDownloadWebPlugin", 1, "<getQueryDownloadAction> result=" + result);
            a.this.callJs(this.f109770b, result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/gdtad/web/a$c", "Lxm0/e$a;", "", "actionType", "data", "", "onEvent", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements e.a {
        c() {
        }

        @Override // xm0.e.a
        public void onEvent(@Nullable String actionType, @Nullable String data) {
            if (Intrinsics.areEqual(actionType, xm0.a.f448135a.d())) {
                a aVar = a.this;
                aVar.callJs(aVar.mListenerId, data);
            }
        }
    }

    private final void q(String paramJson) {
        QLog.i("GdtDownloadWebPlugin", 2, "<getQueryDownloadAction> paramJson=" + paramJson);
        try {
            JSONObject jSONObject = new JSONObject(paramJson);
            p.f109191a.j(new JSONArray(jSONObject.optString("queryParams")), new b(jSONObject.optString("callback")));
        } catch (JSONException e16) {
            QLog.e("GdtDownloadWebPlugin", 2, "[queryDownloadAction] e=" + e16.getMessage());
        }
    }

    private final String r(String name) {
        Activity activity;
        String str;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity != null && activity.getIntent() != null) {
            str = activity.getIntent().getStringExtra(name);
        } else {
            str = "";
        }
        Log.i("GdtDownloadWebPlugin", "name = " + name + ", params = " + str);
        return str;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "q_download_gdt";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(args, "args");
        if (!TextUtils.equals(pkgName, "q_download_gdt")) {
            return false;
        }
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String str3 = args[0];
            if (str3 != null && str3.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                km0.e eVar = (km0.e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101159");
                if (eVar != null && eVar.a(this.mDomain)) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    QLog.e("GdtDownloadWebPlugin", 1, "call js failed, illegal domain is " + this.mDomain);
                    return false;
                }
                if (TextUtils.equals(method, WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION) && (str2 = args[0]) != null) {
                    try {
                        String r16 = r("WebReport_POS_ID");
                        if (TextUtils.isEmpty(r16)) {
                            r16 = r("gdt_download_pos_id");
                        }
                        String r17 = r("WebReport_AD_ID");
                        if (TextUtils.isEmpty(r17)) {
                            r17 = r("gdt_download_aid");
                        }
                        String r18 = r("WebReport_TRACE_ID");
                        if (TextUtils.isEmpty(r18)) {
                            r18 = r("gdt_download_trace_id");
                        }
                        QLog.i("GdtDownloadWebPlugin", 1, "[handleJsRequest] method:" + method + " posId:" + r16 + " aid:" + r17 + " traceId:" + r18);
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put("posId", r16);
                        jSONObject.put("adId", r17);
                        jSONObject.put("traceId", r18);
                        xm0.e eVar2 = xm0.e.f448154d;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                        eVar2.b(jSONObject2, xm0.a.f448135a.c(), null);
                    } catch (Throwable th5) {
                        QLog.e("GdtDownloadWebPlugin", 1, "[handleJsRequest]", th5);
                    }
                }
                if (TextUtils.equals(method, "getQueryDownloadAction") && (str = args[0]) != null) {
                    q(str);
                }
                if (TextUtils.equals(method, "registerDownloadCallBackListener")) {
                    JSONObject jSONObject3 = new JSONObject(args[0]);
                    QLog.i("GdtDownloadWebPlugin", 2, "<registerDownloadCallBackListener> paramJson= " + jSONObject3);
                    this.mListenerId = jSONObject3.optString("callback");
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        xm0.e.f448154d.unregister();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(@Nullable CustomWebView webView) {
        String str;
        super.onWebViewCreated(webView);
        xm0.e.f448154d.c(this.mDownloadCallback);
        if (webView != null) {
            str = webView.getUrl();
        } else {
            str = null;
        }
        this.mDomain = new URL(str).getHost();
    }
}
