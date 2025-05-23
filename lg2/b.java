package lg2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J4\u0010\b\u001a\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J4\u0010\t\u001a\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J1\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000b\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002J,\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0014J1\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000b\"\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018JO\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u000b\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010&\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00030/j\b\u0012\u0004\u0012\u00020\u0003`08\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Llg2/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "callbackId", "", "t", ReportConstant.COSTREPORT_PREFIX, "url", "", "args", "Lorg/json/JSONObject;", "w", "(Ljava/lang/String;[Ljava/lang/String;)Lorg/json/JSONObject;", "v", "jsonObject", HippyTKDListViewAdapter.X, "u", "getNameSpace", "onCreate", "func", "callJs", "(Ljava/lang/String;[Ljava/lang/String;)V", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", PushClientConstants.TAG_PKG_NAME, "method", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/biz/troop/b;", "d", "Lcom/tencent/biz/troop/b;", "getMClient", "()Lcom/tencent/biz/troop/b;", "setMClient", "(Lcom/tencent/biz/troop/b;)V", "mClient", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "localProcessJsBridgeList", "Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "f", "Lcom/tencent/ecommerce/biz/webview/IECWebViewPluginModel;", "pluginModel", "<init>", "()V", h.F, "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.troop.b mClient;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> localProcessJsBridgeList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IECWebViewPluginModel pluginModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"lg2/b$b", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lg2.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10722b implements Function1<HashMap<String, Object>, Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f414531e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f414532f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"lg2/b$b$a", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "result", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: lg2.b$b$a */
        /* loaded from: classes38.dex */
        public static final class a implements IECLogicCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f414533a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f414534b;

            a(String str, b bVar) {
                this.f414533a = str;
                this.f414534b = bVar;
            }

            @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
            public void onResult(HashMap<String, Object> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Object obj = result.get("resultJson");
                String obj2 = obj != null ? obj.toString() : null;
                try {
                    if (this.f414533a.length() > 0) {
                        this.f414534b.callJs(this.f414533a, obj2);
                    }
                } catch (Exception e16) {
                    QLog.e("ECWebViewPlugin", 1, "[callJsBridgeInLocalProcess] callback invoked error = " + e16);
                }
                this.f414534b.pluginModel = null;
            }
        }

        C10722b(HashMap<String, String> hashMap, String str) {
            this.f414531e = hashMap;
            this.f414532f = str;
        }

        public void a(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b bVar = b.this;
            Object obj = result.get("web_view_plugin_model");
            bVar.pluginModel = obj instanceof IECWebViewPluginModel ? (IECWebViewPluginModel) obj : null;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashMap<String, String> hashMap = this.f414531e;
            b bVar2 = b.this;
            linkedHashMap.putAll(hashMap);
            linkedHashMap.put("requestCode", Integer.valueOf(bVar2.getRequestCode((byte) 17)));
            IECWebViewPluginModel iECWebViewPluginModel = b.this.pluginModel;
            if (iECWebViewPluginModel != null) {
                iECWebViewPluginModel.action(b.this.mRuntime.a(), linkedHashMap, new a(this.f414532f, b.this));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
            a(hashMap);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"lg2/b$c", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements Function1<HashMap<String, Object>, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f414535d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f414536e;

        c(String str, b bVar) {
            this.f414535d = str;
            this.f414536e = bVar;
        }

        public void a(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ECWebViewPlugin", 1, "[handleJsRequest] callback invoked result = " + result);
            try {
                String valueOf = String.valueOf(result.get("resultJson"));
                if (this.f414535d.length() > 0) {
                    this.f414536e.callJs(this.f414535d, valueOf);
                }
            } catch (Exception e16) {
                QLog.i("ECWebViewPlugin", 1, "[handleJsRequest] callback invoked error = " + e16);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
            a(hashMap);
            return Unit.INSTANCE;
        }
    }

    public b() {
        ArrayList<String> arrayListOf;
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        Intrinsics.checkNotNullExpressionValue(A, "getInstence()");
        this.mClient = A;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("getAddress", OpenConstants.ApiName.PAY);
        this.localProcessJsBridgeList = arrayListOf;
    }

    private final void s(HashMap<String, String> params, String callbackId) {
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(128, params, new C10722b(params, callbackId));
    }

    private final void t(HashMap<String, String> params, String callbackId) {
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(123, params, new c(callbackId, this));
    }

    private final HashMap<String, String> u(JSONObject jsonObject) {
        String optString = jsonObject.optString("exts");
        if (TextUtils.isEmpty(optString)) {
            return new HashMap<>();
        }
        try {
            JSONObject jSONObject = new JSONObject(optString);
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object next = keys.next();
                String value = jSONObject.optString(String.valueOf(next));
                if (!TextUtils.isEmpty(value)) {
                    String valueOf = String.valueOf(next);
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    hashMap.put(valueOf, value);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("ECWebViewPlugin", 1, e16, new Object[0]);
            return new HashMap<>();
        }
    }

    private final void v(String url) {
        JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(url);
        if (jsonFromJSBridge == null) {
            return;
        }
        x(jsonFromJSBridge);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject w(String url, String... args) {
        int indexOf$default;
        int i3;
        JSONObject jSONObject;
        boolean z16;
        QLog.i("ECWebViewPlugin", 1, "[parseReqParams] invoked url = " + url + " args = " + args);
        boolean z17 = false;
        JSONObject jSONObject2 = null;
        if (!(args.length == 0)) {
            String str = args[0];
            if (str != null) {
                if (str.length() > 0) {
                    z16 = true;
                    if (z16) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(str);
                            try {
                                QLog.i("ECWebViewPlugin", 1, "[parseReqParams] parse params success params = " + jSONObject3);
                                return jSONObject3;
                            } catch (Exception e16) {
                                e = e16;
                                jSONObject2 = jSONObject3;
                                QLog.e("ECWebViewPlugin", 1, "[parseReqParams] parse params error = " + e);
                                if (url != null) {
                                }
                                if (z17) {
                                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url, "#", 0, false, 6, (Object) null);
                                    try {
                                        String substring = url.substring(i3);
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                        String decode = URLDecoder.decode(substring, "UTF-8");
                                        jSONObject = new JSONObject();
                                    } catch (Exception e17) {
                                        e = e17;
                                    }
                                    try {
                                        jSONObject.put("callback", decode);
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e18) {
                                        e = e18;
                                        jSONObject2 = jSONObject;
                                        QLog.e("ECWebViewPlugin", 1, "[parseReqParams] getJsonFromJSBridge error! " + url + " error = " + e, e);
                                        QLog.i("ECWebViewPlugin", 1, "[parseReqParams] params = " + jSONObject2);
                                        if (jSONObject2 == null) {
                                        }
                                    }
                                }
                                QLog.i("ECWebViewPlugin", 1, "[parseReqParams] params = " + jSONObject2);
                                if (jSONObject2 == null) {
                                }
                            }
                        } catch (Exception e19) {
                            e = e19;
                        }
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (url != null) {
            if (url.length() > 0) {
                z17 = true;
            }
        }
        if (z17 && (jSONObject2 = WebViewPlugin.getJsonFromJSBridge(url)) == null && indexOf$default != -1 && (i3 = indexOf$default + 1) < url.length()) {
            String substring2 = url.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String decode2 = URLDecoder.decode(substring2, "UTF-8");
            jSONObject = new JSONObject();
            jSONObject.put("callback", decode2);
            jSONObject2 = jSONObject;
        }
        QLog.i("ECWebViewPlugin", 1, "[parseReqParams] params = " + jSONObject2);
        return jSONObject2 == null ? new JSONObject() : jSONObject2;
    }

    private final void x(JSONObject jsonObject) {
        String optString = jsonObject.optString("service");
        String optString2 = jsonObject.optString("method");
        String body = jsonObject.optString("body");
        String optString3 = jsonObject.optString("refer");
        final String optString4 = jsonObject.optString("callback");
        HashMap<String, String> u16 = u(jsonObject);
        com.tencent.biz.troop.b bVar = this.mClient;
        Intrinsics.checkNotNullExpressionValue(body, "body");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = body.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        bVar.I0(optString, optString2, bytes, optString3, u16, new ITroopMemberApiClientApi.a() { // from class: lg2.a
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle) {
                b.y(b.this, optString4, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(b this$0, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = bundle.getBoolean("success", false);
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(QCircleWeakNetReporter.KEY_TRACE_ID, bundle.getString(QCircleWeakNetReporter.KEY_TRACE_ID, ""));
                if (z16) {
                    int i3 = bundle.getInt("code", -2);
                    String string = bundle.getString("msg", "");
                    jSONObject.put("retCode", i3);
                    jSONObject.put("retMsg", string);
                    byte[] byteArray = bundle.getByteArray("body");
                    if (byteArray != null) {
                        jSONObject.put("body", new String(byteArray, Charsets.UTF_8));
                    }
                    QLog.i("ECWebViewPlugin", 1, "#ssoForward: isSuccess=true, code=" + i3 + ", msg" + string);
                } else {
                    jSONObject.put("retCode", -2);
                    QLog.i("ECWebViewPlugin", 1, "#ssoForward: isSuccess=false");
                }
                this$0.callJs(str, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("ECWebViewPlugin", 1, e16, new Object[0]);
                this$0.callJs(str, jSONObject.toString());
            }
        } catch (Throwable th5) {
            this$0.callJs(str, jSONObject.toString());
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String func, String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        super.callJs(func, (String[]) Arrays.copyOf(args, args.length));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "ecommerce";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        boolean equals$default;
        boolean equals;
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(url == null || url.length() == 0)) {
            if (!(method == null || method.length() == 0)) {
                equals$default = StringsKt__StringsJVMKt.equals$default(pkgName, getNameSpace(), false, 2, null);
                if (equals$default) {
                    equals = StringsKt__StringsJVMKt.equals("ssoForward", method, true);
                    if (equals) {
                        v(url);
                        return true;
                    }
                    JSONObject w3 = w(url, (String[]) Arrays.copyOf(args, args.length));
                    String callbackId = w3.optString("callback");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("url", url);
                    if (pkgName == null) {
                        pkgName = "";
                    }
                    hashMap.put("nameSpace", pkgName);
                    hashMap.put("method", method);
                    hashMap.put("requestJson", w3.toString());
                    if (this.localProcessJsBridgeList.contains(method)) {
                        Intrinsics.checkNotNullExpressionValue(callbackId, "callbackId");
                        s(hashMap, callbackId);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(callbackId, "callbackId");
                        t(hashMap, callbackId);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte requestCode, int resultCode) {
        super.onActivityResult(intent, requestCode, resultCode);
        IECWebViewPluginModel iECWebViewPluginModel = this.pluginModel;
        if (iECWebViewPluginModel != null) {
            iECWebViewPluginModel.onActivityResult(intent, requestCode, resultCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mClient.p();
    }
}
