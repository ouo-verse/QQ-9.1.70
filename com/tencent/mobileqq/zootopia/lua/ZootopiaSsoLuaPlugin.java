package com.tencent.mobileqq.zootopia.lua;

import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleCommonRequest", "handleCommonRequestByJson", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSsoLuaPlugin extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy<ZootopiaSsoLuaPlugin> f328452e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaSsoLuaPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaSsoLuaPlugin a() {
            return (ZootopiaSsoLuaPlugin) ZootopiaSsoLuaPlugin.f328452e.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f328453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328454b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328455c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f328456d;

        b(int i3, LuaArgument luaArgument, String str, String str2) {
            this.f328453a = i3;
            this.f328454b = luaArgument;
            this.f328455c = str;
            this.f328456d = str2;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaSsoLuaPlugin", 1, "handleCommonRequest, luaId:" + this.f328453a + ", onError errCode:" + errCode + ", errMsg:" + errMsg + ", params:" + this.f328454b.getParams());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("service", this.f328455c);
            jSONObject.put("method", this.f328456d);
            jSONObject.put("errorCode", errCode);
            jSONObject.put("errMsg", "errCode: " + errCode + ", errMsg: " + errMsg);
            LuaArgument luaArgument = this.f328454b;
            luaArgument.callback(luaArgument.ok(jSONObject));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequest, onReceive luaId:" + this.f328453a + ", params:" + this.f328454b.getParams());
            String encodeToString = Base64.encodeToString(data, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("service", this.f328455c);
            jSONObject.put("method", this.f328456d);
            jSONObject.put(WebViewPlugin.KEY_RESPONSE, encodeToString);
            LuaArgument luaArgument = this.f328454b;
            luaArgument.callback(luaArgument.ok(jSONObject));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f328457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328458b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328459c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f328460d;

        c(int i3, LuaArgument luaArgument, String str, String str2) {
            this.f328457a = i3;
            this.f328458b = luaArgument;
            this.f328459c = str;
            this.f328460d = str2;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaSsoLuaPlugin", 1, "handleCommonRequestByJson, luaId:" + this.f328457a + ", onError errCode:" + errCode + ", errMsg:" + errMsg + ", params:" + this.f328458b.getParams());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("service", this.f328459c);
            jSONObject.put("method", this.f328460d);
            jSONObject.put("errorCode", errCode);
            jSONObject.put("errMsg", "errCode: " + errCode + ", errMsg: " + errMsg);
            LuaArgument luaArgument = this.f328458b;
            luaArgument.callback(luaArgument.ok(jSONObject));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequestByJson, onReceive luaId:" + this.f328457a + ", params:" + this.f328458b.getParams());
            if (data != null) {
                String str = new String(data, Charsets.UTF_8);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service", this.f328459c);
                jSONObject.put("method", this.f328460d);
                jSONObject.put(WebViewPlugin.KEY_RESPONSE, URLEncoder.encode(str, "UTF-8"));
                LuaArgument luaArgument = this.f328458b;
                luaArgument.callback(luaArgument.ok(jSONObject));
                return;
            }
            LuaArgument luaArgument2 = this.f328458b;
            luaArgument2.callback(luaArgument2.fail("onReceive data is null"));
        }
    }

    static {
        Lazy<ZootopiaSsoLuaPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSsoLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaSsoLuaPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSsoLuaPlugin invoke() {
                return new ZootopiaSsoLuaPlugin(null);
            }
        });
        f328452e = lazy;
    }

    public /* synthetic */ ZootopiaSsoLuaPlugin(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    ZootopiaSsoLuaPlugin() {
    }

    @LuaEvent(checkAsync = true, value = "L2N_CommonRequest")
    public final String handleCommonRequest(LuaArgument argument) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequest, params:" + argument.getParams());
        JSONObject jSONObject = new JSONObject(argument.getParams());
        int optInt = jSONObject.optInt("luaId");
        String service = jSONObject.optString("service");
        String method = jSONObject.optString("method");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return argument.fail("handleCommonRequest get AppInterface is null");
        }
        byte[] request = Base64.decode(jSONObject.optString(WebViewPlugin.KEY_REQUEST), 2);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        Intrinsics.checkNotNullExpressionValue(service, "service");
        Intrinsics.checkNotNullExpressionValue(method, "method");
        Intrinsics.checkNotNullExpressionValue(request, "request");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, service, method, request, emptyMap, new b(optInt, argument, service, method), 0, 0, 192, null);
        return null;
    }

    @LuaEvent(checkAsync = true, value = "L2N_CommonRequestByJson")
    public final String handleCommonRequestByJson(LuaArgument argument) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequestByJson, params:" + argument.getParams());
        JSONObject jSONObject = new JSONObject(argument.getParams());
        int optInt = jSONObject.optInt("luaId");
        String service = jSONObject.optString("service");
        String method = jSONObject.optString("method");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return argument.fail("handleCommonRequestByJson get AppInterface is null");
        }
        String optString = jSONObject.optString(WebViewPlugin.KEY_REQUEST);
        QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequestByJson, dataStringBeforeDecode:" + optString);
        String dataStringAfterDecode = URLDecoder.decode(optString, "UTF-8");
        QLog.i("ZootopiaSsoLuaPlugin", 1, "handleCommonRequestByJson, dataStringAfterDecode:" + dataStringAfterDecode);
        Intrinsics.checkNotNullExpressionValue(dataStringAfterDecode, "dataStringAfterDecode");
        byte[] bytes = dataStringAfterDecode.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        Intrinsics.checkNotNullExpressionValue(service, "service");
        Intrinsics.checkNotNullExpressionValue(method, "method");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.a((IZootopiaProxyServlet) api, appInterface, service, method, bytes, emptyMap, new c(optInt, argument, service, method), 0, 0, 192, null);
        return null;
    }
}
