package com.tencent.mobileqq.zootopia.lua;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\u0006\u0010\u0016\u001a\u00020\u0015R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanHttpToolsPlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "url", "Lorg/json/JSONArray;", "heads", "body", "bodyContentType", "Lcom/tencent/zplan/luabridge/LuaArgument;", "callback", "", "e", "", "ret", "code", "msg", "Lorg/json/JSONObject;", "d", "argument", "handleHttpRequestGet", "handleHttpRequestPost", "Lokhttp3/OkHttpClient;", "c", "Lokhttp3/OkHttpClient;", "client", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHttpToolsPlugin extends LuaBasePlugin {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZPlanHttpToolsPlugin> f328389f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final OkHttpClient client = new OkHttpClient.Builder().callTimeout(10, TimeUnit.SECONDS).addNetworkInterceptor(new f()).build();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZPlanHttpToolsPlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanHttpToolsPlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanHttpToolsPlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZPlanHttpToolsPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanHttpToolsPlugin a() {
            return (ZPlanHttpToolsPlugin) ZPlanHttpToolsPlugin.f328389f.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ZPlanHttpToolsPlugin$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Request f328391a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328392b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanHttpToolsPlugin f328393c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f328394d;

        b(Request request, LuaArgument luaArgument, ZPlanHttpToolsPlugin zPlanHttpToolsPlugin, String str) {
            this.f328391a = request;
            this.f328392b = luaArgument;
            this.f328393c = zPlanHttpToolsPlugin;
            this.f328394d = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.e("ZPlanHttpToolsPlugin", 1, this.f328391a.url() + " onFailure,exception:" + e16.getMessage());
            LuaArgument luaArgument = this.f328392b;
            if (luaArgument != null) {
                luaArgument.callback(luaArgument.fail(this.f328393c.d(-2, "", e16.getMessage())));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            List split$default;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                if (response.body() == null) {
                    str = "null";
                } else {
                    ResponseBody body = response.body();
                    if (body == null || (str = body.string()) == null) {
                        str = "";
                    }
                }
                QLog.i("ZPlanHttpToolsPlugin", 1, "handleHttpRequest onResponse,response:" + response + ",\nbody:" + str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", this.f328394d);
                jSONObject.put("rspCode", response.code());
                jSONObject.put("body", str);
                JSONArray jSONArray = new JSONArray();
                split$default = StringsKt__StringsKt.split$default((CharSequence) response.headers().toString(), new String[]{"\n"}, false, 0, 6, (Object) null);
                Iterator it = split$default.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((String) it.next());
                }
                jSONObject.put("headers", jSONArray);
                LuaArgument luaArgument = this.f328392b;
                if (luaArgument != null) {
                    luaArgument.callback(luaArgument.ok(jSONObject));
                }
            } catch (Exception e16) {
                QLog.e("ZPlanHttpToolsPlugin", 1, this.f328391a.url() + " onFailure when onResponse,exception:" + e16.getMessage());
                LuaArgument luaArgument2 = this.f328392b;
                if (luaArgument2 != null) {
                    luaArgument2.callback(luaArgument2.fail(this.f328393c.d(-3, "", e16.getMessage())));
                }
            }
        }
    }

    static {
        Lazy<ZPlanHttpToolsPlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanHttpToolsPlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZPlanHttpToolsPlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanHttpToolsPlugin invoke() {
                return new ZPlanHttpToolsPlugin();
            }
        });
        f328389f = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject d(int ret, String code, String msg2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", ret);
        jSONObject.put("code", code);
        jSONObject.put("msg", msg2);
        return jSONObject;
    }

    /* renamed from: c, reason: from getter */
    public final OkHttpClient getClient() {
        return this.client;
    }

    @LuaEvent("L2N_HttpReqGet")
    public final void handleHttpRequestGet(LuaArgument argument) {
        String str;
        QLog.i("ZPlanHttpToolsPlugin", 1, "trigger handleHttpRequestGet." + (argument != null ? argument.getF440574c() : null));
        try {
            if (argument == null || (str = argument.getF440574c()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            String url = jSONObject.optString("url", "");
            JSONArray heads = jSONObject.getJSONArray("headers");
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Intrinsics.checkNotNullExpressionValue(heads, "heads");
            e(url, heads, "", "", argument);
        } catch (Exception e16) {
            if (argument != null) {
                argument.callback(argument.fail(d(-1, "", e16.getMessage())));
            }
            QLog.e("ZPlanHttpToolsPlugin", 1, "handleHttpRequestGet exception:" + e16.getMessage());
        }
    }

    @LuaEvent("L2N_HttpReqPost")
    public final void handleHttpRequestPost(LuaArgument argument) {
        String str;
        QLog.i("ZPlanHttpToolsPlugin", 1, "trigger handleHttpRequestPost." + (argument != null ? argument.getF440574c() : null));
        try {
            if (argument == null || (str = argument.getF440574c()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            String url = jSONObject.optString("url", "");
            JSONArray heads = jSONObject.getJSONArray("headers");
            String body = jSONObject.optString("body");
            String optString = jSONObject.optString("bodyContentType");
            if (TextUtils.isEmpty(optString)) {
                optString = "application/json";
            }
            String bodyContentType = optString;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Intrinsics.checkNotNullExpressionValue(heads, "heads");
            Intrinsics.checkNotNullExpressionValue(body, "body");
            Intrinsics.checkNotNullExpressionValue(bodyContentType, "bodyContentType");
            e(url, heads, body, bodyContentType, argument);
        } catch (Exception e16) {
            if (argument != null) {
                argument.callback(argument.fail(d(-1, "", e16.getMessage())));
            }
            QLog.e("ZPlanHttpToolsPlugin", 1, "handleHttpRequestPost exception:" + e16.getMessage());
        }
    }

    private final void e(String url, JSONArray heads, String body, String bodyContentType, LuaArgument callback) {
        Request.Builder url2;
        int indexOf$default;
        Headers.Builder builder = new Headers.Builder();
        if (heads.length() > 0) {
            int length = heads.length();
            for (int i3 = 0; i3 < length; i3++) {
                String headStr = heads.getString(i3);
                Intrinsics.checkNotNullExpressionValue(headStr, "headStr");
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) headStr, ":", 0, false, 6, (Object) null);
                if (indexOf$default > 0) {
                    String string = heads.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "heads.getString(i)");
                    builder.add(string);
                } else {
                    QLog.e("ZPlanHttpToolsPlugin", 1, " handleHttpRequestGet unSupport Header :" + headStr);
                }
            }
        }
        if (TextUtils.isEmpty(body)) {
            url2 = new Request.Builder().headers(builder.build()).get().url(url);
        } else {
            url2 = new Request.Builder().headers(builder.build()).post(RequestBody.INSTANCE.create(MediaType.INSTANCE.parse(bodyContentType), body)).url(url);
        }
        OkHttpClient client = getClient();
        Request build = url2.build();
        Call newCall = client.newCall(build);
        QLog.i("ZPlanHttpToolsPlugin", 1, "handleHttpRequest start request : " + url);
        newCall.enqueue(new b(build, callback, this, url));
    }
}
