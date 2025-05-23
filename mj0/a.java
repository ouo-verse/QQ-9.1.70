package mj0;

import com.tencent.ecommerce.base.ktx.e;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.ecommerce.biz.webviewplugin.IECWebViewPluginCallBack;
import com.tencent.ecommerce.biz.webviewplugin.processor.IECWebViewPluginProcessor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import nj0.c;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010\t\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lmj0/a;", "", "", "", "params", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "callBack", "", "c", "b", "methodName", "Lorg/json/JSONObject;", "param", "Lcom/tencent/ecommerce/biz/webviewplugin/IECWebViewPluginCallBack;", "callback", "a", "Lcom/tencent/ecommerce/biz/webviewplugin/processor/IECWebViewPluginProcessor;", "Ljava/util/Map;", "processorMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Map<String, ? extends IECWebViewPluginProcessor> processorMap;

    /* renamed from: b, reason: collision with root package name */
    public static final a f416860b = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"mj0/a$a", "Lcom/tencent/ecommerce/biz/webviewplugin/IECWebViewPluginCallBack;", "Lorg/json/JSONObject;", "resultJson", "", "invoke", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: mj0.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10788a implements IECWebViewPluginCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLogicCallback f416861a;

        C10788a(IECLogicCallback iECLogicCallback) {
            this.f416861a = iECLogicCallback;
        }

        @Override // com.tencent.ecommerce.biz.webviewplugin.IECWebViewPluginCallBack
        public void invoke(JSONObject resultJson) {
            cg0.a.b("ECWebViewPluginManager", "[jSBridgeDispatcher] call back invoked resultJson = " + resultJson);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("resultJson", resultJson.toString());
            this.f416861a.onResult(hashMap);
        }
    }

    static {
        Map<String, ? extends IECWebViewPluginProcessor> emptyMap;
        Map<String, ? extends IECWebViewPluginProcessor> mapOf;
        emptyMap = MapsKt__MapsKt.emptyMap();
        processorMap = emptyMap;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("addProduct", new oj0.a()));
        processorMap = mapOf;
    }

    a() {
    }

    public final void a(String methodName, JSONObject param, IECWebViewPluginCallBack callback) {
        IECWebViewPluginProcessor iECWebViewPluginProcessor = processorMap.get(methodName);
        if (iECWebViewPluginProcessor != null) {
            iECWebViewPluginProcessor.invoke(param, callback);
            cg0.a.b("ECWebViewPluginManager", "[dispatcher] methodName = " + methodName + " param = " + param);
            return;
        }
        cg0.a.a("ECWebViewPluginManager", "dispatcher", "[dispatcher] processor is null");
    }

    public final void b(Map<String, String> params, IECLogicCallback callBack) {
        String str = params.get("method");
        if (str == null) {
            str = "";
        }
        String str2 = params.get("requestJson");
        cg0.a.b("ECWebViewPluginManager", "[jSBridgeDispatcher] methodName = " + str + " paramString = " + str2 + " params = " + params);
        try {
            a(str, e.b(new JSONObject(), str2), new C10788a(callBack));
        } catch (Exception e16) {
            cg0.a.a("ECWebViewPluginManager", "jSBridgeDispatcher", "[jSBridgeDispatcher] parse params to Json error = " + e16);
        }
    }

    public final void c(Map<String, String> params, IECLogicCallback callBack) {
        String str = params.get("method");
        if (str == null) {
            str = "";
        }
        IECWebViewPluginModel a16 = c.f420226a.a(str);
        if (a16 != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("web_view_plugin_model", a16);
            Unit unit = Unit.INSTANCE;
            callBack.onResult(hashMap);
        }
    }
}
