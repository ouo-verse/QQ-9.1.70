package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.api.IZPlanStartWXMiniAppForResultApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ag;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "Lcom/tencent/mobileqq/wxmini/api/data/b;", "callback", "", "g", "", "ret", "", "code", "msg", "Lorg/json/JSONObject;", "j", "handleLaunchWxMiniApp", "handleLaunchWxMiniAppInWX", "handleFetchWxAppCode", "handleRequestWxPayment", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ag extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ag$b", "Lcom/tencent/mobileqq/zootopia/ipc/t;", "", "ret", "", "code", "msg", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328479a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ag f328480b;

        b(LuaArgument luaArgument, ag agVar) {
            this.f328479a = luaArgument;
            this.f328480b = agVar;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.t
        public void onResult(int ret, String code, String msg2) {
            if (ret == 0 && !TextUtils.isEmpty(code)) {
                LuaArgument luaArgument = this.f328479a;
                if (luaArgument != null) {
                    ag agVar = this.f328480b;
                    if (code == null) {
                        code = "";
                    }
                    luaArgument.callback(luaArgument.ok(agVar.j(0, code, "success")));
                    return;
                }
                return;
            }
            LuaArgument luaArgument2 = this.f328479a;
            if (luaArgument2 != null) {
                ag agVar2 = this.f328480b;
                if (msg2 == null) {
                    msg2 = "";
                }
                luaArgument2.callback(luaArgument2.fail(agVar2.j(ret, "", msg2)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ag$c", "Lcom/tencent/mobileqq/zootopia/ipc/am;", "", "ret", "", "msg", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.ipc.am {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328481a;

        c(LuaArgument luaArgument) {
            this.f328481a = luaArgument;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.am
        public void onResult(int ret, String msg2) {
            QLog.e("ZPlanWXMiniAppPlugin", 1, "handleRequestWXPayment  result:" + ret + " msg:" + msg2);
            if (ret == 0) {
                LuaArgument luaArgument = this.f328481a;
                if (luaArgument != null) {
                    luaArgument.callback(luaArgument.ok());
                    return;
                }
                return;
            }
            LuaArgument luaArgument2 = this.f328481a;
            if (luaArgument2 != null) {
                luaArgument2.callback(luaArgument2.fail());
            }
        }
    }

    public ag(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    private final void g(final LuaArgument argument, final com.tencent.mobileqq.wxmini.api.data.b callback) {
        String str;
        if (((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkDynamicPackage()) {
            callback.onCallback(true, new Bundle());
            return;
        }
        QLog.d("ZPlanWXMiniAppPlugin", 1, "start loadDynamicPackage");
        if (argument == null || (str = argument.getF440574c()) == null) {
            str = "";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.optBoolean("donot_show_prepare_wx_runtime_toast", false)) {
            final String optString = jSONObject.optString("prepare_wx_runtime_toast", "\u52a0\u8f7d\u4e2d\u8bf7\u7a0d\u5019");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ag.h(optString);
                }
            });
        }
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.zootopia.lua.af
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                ag.i(LuaArgument.this, this, callback, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str) {
        QQToast.makeText(BaseApplication.context, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LuaArgument luaArgument, ag this$0, com.tencent.mobileqq.wxmini.api.data.b callback, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean checkDynamicPackage = !z16 ? ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkDynamicPackage() : z16;
        QLog.d("ZPlanWXMiniAppPlugin", 1, "loadDynamicPackage finish,success:" + z16 + ",packageSuccess:" + checkDynamicPackage + ",data:" + xb4.b.f447772a.g(bundle));
        if (checkDynamicPackage) {
            callback.onCallback(checkDynamicPackage, bundle);
        } else if (luaArgument != null) {
            luaArgument.callback(luaArgument.fail(this$0.j(-2, "", "wx miniapp runtime init failed")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject j(int ret, String code, String msg2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", ret);
        jSONObject.put("code", code);
        jSONObject.put("msg", msg2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LuaArgument luaArgument, ag this$0, boolean z16, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (luaArgument == null || (str = luaArgument.getF440574c()) == null) {
                str = "";
            }
            String optString = new JSONObject(str).optString("appId", "");
            if (!TextUtils.isEmpty(optString)) {
                ((com.tencent.mobileqq.zootopia.ipc.al) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.al.class)).fetchWxCode(optString, new b(luaArgument, this$0));
            } else if (luaArgument != null) {
                luaArgument.callback(luaArgument.fail(this$0.j(-1, "", "appId is empty")));
            }
        } catch (Exception e16) {
            QLog.e("ZPlanWXMiniAppPlugin", 1, " handleFetchWxAppCode get exception ." + e16);
            if (luaArgument != null) {
                String message = e16.getMessage();
                luaArgument.callback(luaArgument.fail(this$0.j(-1, "get exception", message != null ? message : "")));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(LuaArgument luaArgument, ag this$0, boolean z16, Bundle bundle) {
        String str;
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (luaArgument == null || (str = luaArgument.getF440574c()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId", "");
            String optString2 = jSONObject.optString("path", "");
            if (!jSONObject.optBoolean("disableProcessOptimize", false)) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(MobileQQ.PACKAGE_NAME + ":wxa_container0", MobileQQ.PACKAGE_NAME + ":wxa_container1");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.ZPlanAppInterface");
                ((ZPlanAppInterface) peekAppRuntime).y(mutableListOf);
            }
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(this$0.activity, optString, optString2, 0);
            if (luaArgument != null) {
                luaArgument.callback(luaArgument.ok());
            }
        } catch (Exception e16) {
            if (luaArgument != null) {
                luaArgument.callback(luaArgument.fail(this$0.j(-1, "", e16.getMessage())));
            }
            QLog.e("ZPlanWXMiniAppPlugin", 1, "handleLaunchWxMiniApp exception:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LuaArgument luaArgument, boolean z16, Bundle bundle) {
        String str;
        Long longOrNull;
        try {
            if (luaArgument == null || (str = luaArgument.getF440574c()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId", "");
            String timestamp = jSONObject.optString("timestamp", "");
            String nonceStr = jSONObject.optString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, "");
            String optString2 = jSONObject.optString("packageStr", "");
            String optString3 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, "");
            String paySign = jSONObject.optString(PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY, "");
            com.tencent.mobileqq.zootopia.ipc.al alVar = (com.tencent.mobileqq.zootopia.ipc.al) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.al.class);
            Intrinsics.checkNotNullExpressionValue(timestamp, "timestamp");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(timestamp);
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            Intrinsics.checkNotNullExpressionValue(nonceStr, "nonceStr");
            Intrinsics.checkNotNullExpressionValue(paySign, "paySign");
            alVar.requestWxPay(optString, longValue, nonceStr, optString2, optString3, paySign, new c(luaArgument));
        } catch (Exception e16) {
            if (luaArgument != null) {
                luaArgument.callback(luaArgument.fail());
            }
            QLog.e("ZPlanWXMiniAppPlugin", 1, "handleRequestWXPayment exception:" + e16.getMessage());
        }
    }

    @LuaEvent("L2N_LaunchWXMiniAppInWX")
    public final void handleLaunchWxMiniAppInWX(LuaArgument argument) {
        String str;
        try {
            if (argument == null || (str = argument.getF440574c()) == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            String originId = jSONObject.optString("originId", "");
            String path = jSONObject.optString("path", "");
            int optInt = jSONObject.optInt("type", 0);
            IZPlanStartWXMiniAppForResultApi iZPlanStartWXMiniAppForResultApi = (IZPlanStartWXMiniAppForResultApi) QRoute.api(IZPlanStartWXMiniAppForResultApi.class);
            Intrinsics.checkNotNullExpressionValue(originId, "originId");
            Intrinsics.checkNotNullExpressionValue(path, "path");
            iZPlanStartWXMiniAppForResultApi.startWXMiniAppForResult(originId, path, optInt);
            if (argument != null) {
                argument.callback(argument.ok());
            }
        } catch (Exception e16) {
            if (argument != null) {
                argument.callback(argument.fail(j(-1, "", e16.getMessage())));
            }
            QLog.e("ZPlanWXMiniAppPlugin", 1, "handleLaunchWxMiniAppInWX exception:" + e16.getMessage());
        }
    }

    @LuaEvent("L2N_LaunchWXMiniApp")
    public final void handleLaunchWxMiniApp(final LuaArgument argument) {
        QLog.i("ZPlanWXMiniAppPlugin", 1, "trigger handleLaunchWxMiniApp." + (argument != null ? argument.getF440574c() : null));
        g(argument, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.zootopia.lua.ab
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                ag.l(LuaArgument.this, this, z16, bundle);
            }
        });
    }

    @LuaEvent("L2N_RequestWXPayment")
    public final void handleRequestWxPayment(final LuaArgument argument) {
        QLog.i("ZPlanWXMiniAppPlugin", 1, "trigger handleRequestWXPayment." + (argument != null ? argument.getF440574c() : null));
        g(argument, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.zootopia.lua.ad
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                ag.m(LuaArgument.this, z16, bundle);
            }
        });
    }

    @LuaEvent("L2N_FetchWXAppCode")
    public final String handleFetchWxAppCode(final LuaArgument argument) {
        QLog.i("ZPlanWXMiniAppPlugin", 1, "trigger handleFetchWxAppCode." + (argument != null ? argument.getF440574c() : null));
        g(argument, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: com.tencent.mobileqq.zootopia.lua.ac
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                ag.k(LuaArgument.this, this, z16, bundle);
            }
        });
        return null;
    }
}
