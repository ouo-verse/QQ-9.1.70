package com.tencent.mobileqq.wxmini.impl.util;

import NS_MINI_INTERFACE.INTERFACE$StGetWeixinSDKAppInfoRsp;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.n2;
import com.tencent.luggage.wxa.hn.w8;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.r;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxaInfoObtainUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.luggage.wxa.m6.l f327777a = new com.tencent.luggage.wxa.m6.l();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(boolean z16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.m6.k f327778a;

        /* renamed from: b, reason: collision with root package name */
        public final Function2 f327779b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f327780c = new AtomicBoolean(false);

        public c(com.tencent.luggage.wxa.m6.k kVar, Function2 function2) {
            this.f327778a = kVar;
            this.f327779b = function2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Object obj) {
            if (this.f327780c.compareAndSet(false, true)) {
                QLog.d("[wxa-q]WxaObtainUtil", 1, "request wx data: ", obj);
                this.f327779b.invoke(this.f327778a, obj);
            }
        }

        public void b() {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.WxaInfoObtainUtil.c.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("[wxa-q]WxaObtainUtil", 1, "request wx data timeout");
                    c.this.a(null);
                }
            }, 16, null, true, 2000L);
        }
    }

    private static int i(int i3) {
        if (i3 != 1012 && i3 != 1013) {
            return 4;
        }
        return 34;
    }

    private static int j(int i3) {
        if (i3 == 22) {
            return 0;
        }
        return 4;
    }

    private static String k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                return Global.TRACKING_WIFI;
            }
            String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
            if (netGetExInfo != null) {
                return netGetExInfo.toLowerCase(Locale.getDefault());
            }
            return "no";
        }
        return "no";
    }

    private static void l(int i3, String str, final int i16, int i17, final db3.a aVar) {
        com.tencent.luggage.wxa.m6.k kVar = new com.tencent.luggage.wxa.m6.k();
        kVar.f128128t = k();
        kVar.f128131w = (int) System.currentTimeMillis();
        kVar.f128118j = new e9().a(str);
        kVar.f128113e = 2;
        kVar.f128121m = i3;
        kVar.f128125q = 0;
        kVar.f128122n = null;
        kVar.f128129u = i16;
        kVar.f128130v = i17;
        kVar.f128134z = new w8();
        kVar.f128115g = new e9().a((String) null);
        try {
            com.tencent.luggage.wxa.m6.a a16 = f327777a.a(kVar.f128118j.f(), kVar.f128125q);
            c cVar = new c(kVar, new Function2() { // from class: com.tencent.mobileqq.wxmini.impl.util.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Object m3;
                    m3 = WxaInfoObtainUtil.m(i16, aVar, obj, obj2);
                    return m3;
                }
            });
            a16.a(kVar, n2.class).a(cVar);
            cVar.b();
        } catch (Exception e16) {
            aVar.a(false, null);
            QLog.e("[wxa-q]WxaObtainUtil", 1, "fail to get wx mini app info.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object m(int i3, db3.a aVar, Object obj, Object obj2) {
        boolean z16;
        com.tencent.mobileqq.wxmini.api.data.e t16 = t("", i3);
        try {
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaObtainUtil", 1, "fail to get wx mini app info.", e16);
        }
        if (obj2 instanceof n2) {
            t16 = t(((n2) obj2).f128231e, i3);
            if (t16 != null) {
                t16.f327614b = true;
            }
            z16 = true;
            QLog.d("[wxa-q]WxaObtainUtil", 1, "callback result: ", Boolean.valueOf(z16), " with data: ", t16);
            aVar.a(z16, t16);
            return null;
        }
        z16 = false;
        QLog.d("[wxa-q]WxaObtainUtil", 1, "callback result: ", Boolean.valueOf(z16), " with data: ", t16);
        aVar.a(z16, t16);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(final int i3, final String str, final int i16, final int i17, final db3.a aVar) {
        fb3.i.w().r(new com.tencent.luggage.wxaapi.h() { // from class: com.tencent.mobileqq.wxmini.impl.util.o
            @Override // com.tencent.luggage.wxaapi.h
            public final void onStateChecked(TdiAuthState tdiAuthState, String str2) {
                WxaInfoObtainUtil.r(i3, str, i16, i17, aVar, tdiAuthState, str2);
            }
        });
    }

    public static com.tencent.mobileqq.wxmini.api.data.e t(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 == 19 && !str.contains("qr_type4wxa")) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("appid");
        String queryParameter2 = parse.getQueryParameter("username");
        String queryParameter3 = parse.getQueryParameter("type");
        if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2)) {
            return null;
        }
        if (queryParameter3 == null) {
            queryParameter3 = String.valueOf(0);
        }
        com.tencent.mobileqq.wxmini.api.data.e eVar = new com.tencent.mobileqq.wxmini.api.data.e();
        eVar.f327613a = str;
        eVar.f327615c = queryParameter;
        eVar.f327616d = queryParameter2;
        try {
            eVar.f327618f = Integer.parseInt(queryParameter3);
        } catch (NumberFormatException unused) {
            eVar.f327618f = 0;
        }
        String queryParameter4 = parse.getQueryParameter("path");
        if (TextUtils.isEmpty(queryParameter4)) {
            queryParameter4 = "";
        }
        eVar.f327617e = queryParameter4;
        return eVar;
    }

    public static void w(final int i3, final String str, final int i16, boolean z16, final db3.a aVar) {
        x(str, i16, new db3.a() { // from class: com.tencent.mobileqq.wxmini.impl.util.k
            @Override // db3.a
            public final void a(boolean z17, com.tencent.mobileqq.wxmini.api.data.e eVar) {
                WxaInfoObtainUtil.o(str, i3, i16, aVar, z17, eVar);
            }
        });
    }

    private static void x(String str, final int i3, final db3.a aVar) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).getWxAppUrl(i3, str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.wxmini.impl.util.m
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                WxaInfoObtainUtil.p(i3, aVar, z16, jSONObject);
            }
        });
    }

    public static void y(String str, final db3.a aVar) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).getWeixinSDKAppInfo(str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.wxmini.impl.util.q
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                WxaInfoObtainUtil.q(db3.a.this, z16, jSONObject);
            }
        });
    }

    private static void z(int i3, final String str, final int i16, final db3.a aVar) {
        final int i17 = i(i3);
        final int j3 = j(i16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.impl.util.n
            @Override // java.lang.Runnable
            public final void run() {
                WxaInfoObtainUtil.s(i17, str, i16, j3, aVar);
            }
        }, 128, null, true);
    }

    private static com.tencent.mobileqq.wxmini.api.data.e h(JSONObject jSONObject) {
        try {
            byte[] bArr = (byte[]) jSONObject.opt("appInfo_pb");
            if (bArr != null) {
                INTERFACE$StGetWeixinSDKAppInfoRsp iNTERFACE$StGetWeixinSDKAppInfoRsp = new INTERFACE$StGetWeixinSDKAppInfoRsp();
                iNTERFACE$StGetWeixinSDKAppInfoRsp.mergeFrom(bArr);
                String str = iNTERFACE$StGetWeixinSDKAppInfoRsp.appInfo.appid.get();
                if (str == null) {
                    return null;
                }
                com.tencent.mobileqq.wxmini.api.data.e eVar = new com.tencent.mobileqq.wxmini.api.data.e();
                eVar.f327615c = str;
                return eVar;
            }
        } catch (Exception e16) {
            QLog.e("[wxa-q]WxaObtainUtil", 1, "fail to convert wx mini app info.", e16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(int i3, String str, int i16, int i17, db3.a aVar, TdiAuthState tdiAuthState, String str2) {
        QLog.d("[wxa-q]WxaObtainUtil", 1, "checkAuthState: ", tdiAuthState);
        if (tdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK) {
            l(i3, str, i16, i17, aVar);
        } else {
            aVar.a(false, null);
        }
    }

    public static void u(String str, int i3, r rVar, LaunchWxaAppResult launchWxaAppResult) {
        v(str, i3, rVar, launchWxaAppResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(String str, LaunchWxaAppResult launchWxaAppResult, a aVar, boolean z16, JSONObject jSONObject) {
        QLog.d("[wxa-q]WxaObtainUtil", 1, "report appid: ", str, " errorCode: ", launchWxaAppResult, " success: ", Boolean.valueOf(z16), " ret: ", jSONObject);
        if (aVar != null) {
            aVar.a(z16, String.valueOf(jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(String str, int i3, int i16, db3.a aVar, boolean z16, com.tencent.mobileqq.wxmini.api.data.e eVar) {
        if (!z16) {
            QLog.d("[wxa-q]WxaObtainUtil", 1, "requestWxMiniAppInfo failed, use wxAPI to get info, code: ", str);
            z(i3, str, i16, aVar);
        } else if (aVar != null) {
            aVar.a(z16, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(int i3, db3.a aVar, boolean z16, JSONObject jSONObject) {
        if (!z16) {
            if (aVar != null) {
                aVar.a(false, null);
            }
        } else {
            com.tencent.mobileqq.wxmini.api.data.e t16 = t(jSONObject.optString("key_url", ""), i3);
            if (aVar != null) {
                aVar.a(t16 != null, t16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(db3.a aVar, boolean z16, JSONObject jSONObject) {
        if (!z16) {
            if (aVar != null) {
                aVar.a(false, null);
            }
        } else {
            com.tencent.mobileqq.wxmini.api.data.e h16 = h(jSONObject);
            if (aVar != null) {
                aVar.a(h16 != null, h16);
            }
        }
    }

    public static void v(final String str, int i3, r rVar, final LaunchWxaAppResult launchWxaAppResult, final a aVar) {
        if (rVar == null) {
            QLog.d("[wxa-q]WxaObtainUtil", 1, "report after launch: ", str, "scene:", Integer.valueOf(i3), " but data is null, result: ", launchWxaAppResult);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra(MiniConst.WxMiniAppInfoConst.EXTRA_ALIAS, "");
        intent.putExtra(MiniConst.WxMiniAppInfoConst.EXTRA_ICON, rVar.f146896c);
        intent.putExtra("app_name", rVar.f146895b);
        intent.putExtra(MiniConst.WxMiniAppInfoConst.EXTRA_DESC, rVar.f146897d);
        JSONArray jSONArray = new JSONArray();
        for (Pair<String, String> pair : rVar.f146898e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, pair.first);
                jSONObject.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, pair.second);
                jSONArray.mo162put(jSONObject);
            } catch (JSONException unused) {
            }
        }
        intent.putExtra(MiniConst.WxMiniAppInfoConst.EXTRA_CATEGORIES, jSONArray.toString());
        intent.putExtra("result_code", launchWxaAppResult.code + "");
        intent.putExtra(MiniConst.WxMiniAppInfoConst.EXTRA_REGISTER_BODY, rVar.f146899f);
        intent.putExtra("app_type", 0);
        intent.putExtra("scene", i3);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).setWxAppInfo(intent, new MiniAppCmdInterface(str, launchWxaAppResult, aVar) { // from class: com.tencent.mobileqq.wxmini.impl.util.l

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f327787a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LaunchWxaAppResult f327788b;

            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject2) {
                WxaInfoObtainUtil.n(this.f327787a, this.f327788b, null, z16, jSONObject2);
            }
        });
    }
}
