package com.qq.e.comm.plugin.base.ad;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.heytap.databaseengine.type.DataReadType;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.QQSetting;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.k.az;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f38340a = new Random(System.currentTimeMillis());

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f38341b = null;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.ad.a$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38342a;

        static {
            int[] iArr = new int[b.values().length];
            f38342a = iArr;
            try {
                iArr[b.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38342a[b.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38342a[b.APP_WALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38342a[b.SPLASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38342a[b.FEEDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Map<String, String> a(Request request, GDTADManager gDTADManager, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        request.addQuery("adposcount", String.valueOf(bVar.h()));
        request.addQuery("count", String.valueOf(bVar.i()));
        request.addQuery("posid", bVar.g());
        int m3 = bVar.m();
        b bVar2 = b.SPLASH;
        if (m3 == bVar2.b()) {
            request.addQuery("spsa", "1");
        }
        int k3 = bVar.k();
        int l3 = bVar.l();
        if (k3 > 0 && l3 > 0) {
            request.addQuery("posw", String.valueOf(bVar.k()));
            request.addQuery("posh", String.valueOf(bVar.l()));
        }
        if (bVar.m() == b.NATIVEEXPRESSAD.b()) {
            request.addQuery("actual_width", String.valueOf(bVar.e()));
            request.addQuery("actual_height", String.valueOf(bVar.f()));
        }
        if (bVar.j() > 0) {
            request.addQuery("datatype", String.valueOf(bVar.j()));
        }
        if (bVar.n() > 0) {
            request.addQuery("reqtype", String.valueOf(bVar.n()));
        }
        if (bVar.s() > 0) {
            request.addQuery("flow_source", String.valueOf(bVar.s()));
        }
        if (bVar.v() != null && bVar.v().getValue() > 0) {
            request.addQuery(MsfConstants.ATTRIBUTE_LOGIN_TYPE, String.valueOf(bVar.v().getValue()));
        }
        if (!TextUtils.isEmpty(bVar.w())) {
            request.addQuery("login_appid", bVar.w());
        }
        if (!TextUtils.isEmpty(bVar.t())) {
            request.addQuery("login_openid", bVar.t());
        }
        if (!TextUtils.isEmpty(bVar.u())) {
            request.addQuery("uin", bVar.u());
        }
        if (bVar.m() == bVar2.b()) {
            request.addQuery("block_effect", String.valueOf(bVar.D()));
        }
        if (gDTADManager.getSM().getInteger("support_https", 0) == 1) {
            request.addQuery("support_https", "1");
        }
        b(request, gDTADManager, bVar);
        a(request, bVar);
        a(request);
        return request.getQuerys();
    }

    private static void b(Request request, GDTADManager gDTADManager, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        JSONObject a16 = a(gDTADManager, request, bVar);
        GDTLogger.d("loadRequestParams =" + a16.toString());
        request.addQuery("ext", a16.toString());
        JSONObject b16 = b(gDTADManager, request, bVar);
        if (b16 != null) {
            request.addQuery("outerext", b16.toString());
        }
        request.addQuery("r", String.valueOf(Math.random()));
    }

    private static JSONObject c(GDTADManager gDTADManager, Request request, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        com.qq.e.comm.plugin.e.c cVar = new com.qq.e.comm.plugin.e.c();
        if (bVar == null) {
            GDTLogger.d("AdRequestHelpergetExtReqParams reqData is null");
            return null;
        }
        JSONObject jSONObject = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).get(bVar.m(), cVar);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject g16 = y.g(jSONObject, "device_ext");
        if (y.a(g16)) {
            y.a(g16, "module_name", bVar.S());
        }
        if (TextUtils.isEmpty(y.e(jSONObject, "m10"))) {
            y.a(jSONObject, "m10", "_QQ_OAID_");
        }
        if (TextUtils.isEmpty(y.e(jSONObject, "m11"))) {
            y.a(jSONObject, "m11", "_QQ_TAID_");
        }
        String screenOrientation = gDTADManager.getDeviceStatus().getScreenOrientation();
        jSONObject.put("c_ori", (screenOrientation == null || screenOrientation.equals("p")) ? 0 : 90);
        d(jSONObject, bVar);
        if (bVar.m() == b.REWARDVIDEOAD.b()) {
            jSONObject.put("support_app_landing_page", GDTADManager.getInstance().getSM().getInteger("rewardVideoSupportLandingPage", 0));
            int integer = GDTADManager.getInstance().getSM().getInteger("rewardVideoServerMaxDuration", 31);
            int integer2 = GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.GDT_SDK_IDENTITY, 1);
            if (integer > 0 && (integer2 == 1 || integer2 == 3)) {
                jSONObject.put(DataReadType.MAX_DURATION, integer);
            }
        } else {
            jSONObject.put("support_app_landing_page", 1);
            int x16 = bVar.x();
            int y16 = bVar.y();
            if (y16 <= 0 || y16 >= x16) {
                if (x16 > 0) {
                    jSONObject.put("min_duration", x16);
                }
                if (y16 > 0) {
                    jSONObject.put(DataReadType.MAX_DURATION, y16);
                }
            } else {
                GDTLogger.e("\u53c2\u6570\u8bbe\u7f6e\u9519\u8bef , minVideoDuration\u4e0d\u80fd\u5927\u4e8emaxVideoDuration");
            }
        }
        jSONObject.put("postype", bVar.m());
        if (bVar.m() == b.INTERSTITIAL.b() || bVar.m() == b.UNIFIED_INTERSTITIAL.b()) {
            jSONObject.put("inline_full_screen", 1);
        }
        if (bVar.m() == b.UNIFIED_INTERSTITIAL.b() && az.a()) {
            jSONObject.put("support_video", true);
        }
        int m3 = bVar.m();
        b bVar2 = b.NATIVEEXPRESSAD;
        if (m3 == bVar2.b()) {
            jSONObject.put("support_video", true);
        }
        if (bVar.m() == bVar2.b() || bVar.m() == b.NATIVEUNIFIEDAD.b()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ap", bVar.F());
            jSONObject2.put("rt", bVar.G());
            jSONObject.put("v", jSONObject2);
        }
        c(jSONObject, bVar);
        if (y.a(bVar.T())) {
            y.a(jSONObject, "client_tp", bVar.T());
        }
        if (bVar.o() != null) {
            JSONObject o16 = bVar.o();
            Iterator keys = o16.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                jSONObject.put(str, o16.get(str));
            }
        }
        jSONObject.put("url", bVar.q());
        jSONObject.putOpt("xflow_pos_id", bVar.r());
        jSONObject.put("sdk_st", 2);
        jSONObject.put("sdk_pt", 1);
        jSONObject.put("uid", bVar.L());
        String a16 = d.a();
        if (!TextUtils.isEmpty(a16)) {
            jSONObject.put("qq_ver", a16);
        }
        jSONObject.put("rd_prld", bVar.c());
        jSONObject.put("unreward_show_ad_count", bVar.a());
        jSONObject.put("rewarded_show_ad_count", bVar.b());
        jSONObject.put("support_c2s", 2);
        if (bVar.d() != null) {
            jSONObject.put("rd_wl", bVar.d());
        }
        Map I = bVar.I();
        if (I != null) {
            if (I.get(IPublicAccountBrowser.KEY_PUB_UIN) != null) {
                jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, I.get(IPublicAccountBrowser.KEY_PUB_UIN));
                I.remove(IPublicAccountBrowser.KEY_PUB_UIN);
            }
            if (I.get("atid") != null) {
                jSONObject.put("atid", I.get("atid"));
                I.remove("atid");
            }
            if (I.get("ecpm_level_request") != null) {
                jSONObject.put("ecpm_level_request", I.get("ecpm_level_request"));
                I.remove("ecpm_level_request");
            }
            bVar.a(I);
        }
        b(jSONObject, bVar);
        jSONObject.put("hostappid", GDTADManager.getInstance().getAppStatus().getAPPID());
        jSONObject.put("hostver", GDTADManager.getInstance().getAppStatus().getAPPVersion());
        if (bVar.P() != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bVar.P()) {
                jSONArray.mo162put(str2);
            }
            jSONObject.put("apknames", jSONArray);
        }
        if (y.a(bVar.Q())) {
            jSONObject.put("client_ability", bVar.Q());
        }
        a(jSONObject, bVar);
        y.a(jSONObject, "app_version_id", QQSetting.getQQAppVersionId());
        GDTLogger.i("AdRequestHelper extReq: " + jSONObject);
        return jSONObject;
    }

    private static void d(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        if (bVar.m() == b.BANNER.b()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.INTERSTITIAL.b()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.APP_WALL.b()) {
            jSONObject.put("placement_type", 3);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.SPLASH.b()) {
            jSONObject.put("placement_type", 4);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.NATIVEMEDIAAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.GDTNATIVEAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.NATIVEEXPRESSAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 3);
        }
        if (bVar.m() == b.REWARDVIDEOAD.b()) {
            jSONObject.put("placement_type", 10);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
        }
        if (bVar.m() == b.NATIVEUNIFIEDAD.b()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 1);
            jSONObject.put("support_container", true);
        }
        if (bVar.m() == b.UNIFIED_BANNER.b()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 3);
        }
        if (bVar.m() == b.UNIFIED_INTERSTITIAL.b()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put(ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, 3);
        }
    }

    private static JSONObject b(GDTADManager gDTADManager, Request request, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        if (bVar.p() == null || bVar.p().size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", new JSONArray((Collection) bVar.p()));
        return jSONObject;
    }

    private static void b(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        String b16 = e.a().b((String) null, "ex_exp_info");
        int i3 = -1;
        if (!TextUtils.isEmpty(b16)) {
            Pair<Integer, JSONArray> a16 = a(b16, -1, jSONArray);
            i3 = ((Integer) a16.first).intValue();
            jSONArray = (JSONArray) a16.second;
        }
        String b17 = e.a().b(bVar.g(), "ex_exp_info");
        if (!TextUtils.isEmpty(b17) && !b17.equals(b16)) {
            Pair<Integer, JSONArray> a17 = a(b17, i3, jSONArray);
            i3 = ((Integer) a17.first).intValue();
            jSONArray = (JSONArray) a17.second;
        }
        if (bVar.M() != null) {
            for (String str : bVar.M()) {
                jSONArray.mo162put(str);
            }
            i3 = bVar.N();
        }
        if (jSONArray.length() != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", i3);
            jSONObject2.put("exp_id", jSONArray);
            jSONObject.putOpt("ex_exp_info", jSONObject2);
        }
    }

    private static void a(Request request, com.qq.e.comm.plugin.base.ad.model.b bVar) {
        if (!com.qq.e.comm.plugin.j.c.a("pass_through", 1, 1) || bVar.I() == null || bVar.I().size() == 0) {
            return;
        }
        request.addQuery("pass_through", bVar.J());
    }

    private static void a(Request request) {
        com.qq.e.comm.plugin.d.c cVar = com.qq.e.comm.plugin.d.b.f39333b;
        if (cVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.b())) {
            request.addQuery("uin", com.qq.e.comm.plugin.d.b.f39333b.b());
        }
        if (TextUtils.isEmpty(com.qq.e.comm.plugin.d.b.f39333b.a())) {
            return;
        }
        request.addQuery("proxy_info", com.qq.e.comm.plugin.d.b.f39333b.a());
    }

    private static JSONObject a(GDTADManager gDTADManager, Request request, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (a() && com.qq.e.comm.plugin.d.b.f39333b.c()) {
            jSONObject.put("debug", true);
        }
        jSONObject.put("req", c(gDTADManager, request, bVar));
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        JSONObject g16 = y.g(y.g(jSONObject, "device_ext"), "configure_ability");
        int R = bVar.R();
        if (R > 0) {
            y.a(g16, "reward_max_level", R);
        }
    }

    private static Pair<Integer, JSONArray> a(String str, int i3, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("type");
            JSONArray optJSONArray = jSONObject.optJSONArray("exp_id");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        jSONArray.mo162put(optJSONArray.get(i16));
                    }
                }
                jSONArray = optJSONArray;
            }
        } catch (JSONException e16) {
            GDTLogger.e(e16.getMessage());
        }
        return new Pair<>(Integer.valueOf(i3), jSONArray);
    }

    private static boolean a() {
        return aj.g() && com.qq.e.comm.plugin.d.b.f39333b != null;
    }

    public static com.qq.e.comm.plugin.base.ad.definition.a a(b bVar, int i3) {
        int i16 = AnonymousClass1.f38342a[bVar.ordinal()];
        if (i16 == 1) {
            if (i3 < 160) {
                return com.qq.e.comm.plugin.base.ad.definition.a.f38755a;
            }
            if (i3 >= 160 && i3 < 240) {
                return com.qq.e.comm.plugin.base.ad.definition.a.f38756b;
            }
            if (i3 >= 240 && i3 < 320) {
                return com.qq.e.comm.plugin.base.ad.definition.a.f38757c;
            }
            return com.qq.e.comm.plugin.base.ad.definition.a.f38758d;
        }
        if (i16 == 2) {
            if (i3 >= 320) {
                return com.qq.e.comm.plugin.base.ad.definition.a.f38760f;
            }
            return com.qq.e.comm.plugin.base.ad.definition.a.f38759e;
        }
        if (i16 == 3) {
            return com.qq.e.comm.plugin.base.ad.definition.a.f38761g;
        }
        if (i16 != 4) {
            if (i16 != 5) {
                return null;
            }
            return com.qq.e.comm.plugin.base.ad.definition.a.f38764j;
        }
        if (i3 >= 320) {
            return com.qq.e.comm.plugin.base.ad.definition.a.f38763i;
        }
        return com.qq.e.comm.plugin.base.ad.definition.a.f38762h;
    }

    private static void c(JSONObject jSONObject, com.qq.e.comm.plugin.base.ad.model.b bVar) throws JSONException {
        if (bVar.m() == b.SPLASH.b()) {
            jSONObject.put(AdParam.HWMODEL, Build.DEVICE);
            jSONObject.put(AdParam.HWMACHINE, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel());
            jSONObject.put(AdParam.BRANDS, Build.BRAND);
            jSONObject.put("prld", bVar.z());
            jSONObject.put("rtld", bVar.B());
            if (bVar.A() != Integer.MIN_VALUE) {
                jSONObject.put("pre_req_type", bVar.A());
            }
            jSONObject.put("wl", bVar.C());
            jSONObject.put("playround", bVar.E());
            jSONObject.put("oneshot", bVar.H());
            JSONObject a16 = y.a();
            y.a(a16, "ams_qqopenid", bVar.U());
            y.a(jSONObject, "login_info", a16);
            jSONObject.put("warm_boot", bVar.K());
            jSONObject.put("is_alternate_list", bVar.O());
        }
    }
}
