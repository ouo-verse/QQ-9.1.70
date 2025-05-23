package com.qq.e.comm.plugin.base.ad.e;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import com.tencent.mobileqq.msf.core.c0.j;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f38777a = 2048;

    /* renamed from: b, reason: collision with root package name */
    private static int f38778b = 2048;

    /* renamed from: c, reason: collision with root package name */
    private static long f38779c = -1;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private com.qq.e.comm.plugin.base.ad.model.b f38786a;

        /* renamed from: b, reason: collision with root package name */
        private com.qq.e.comm.plugin.base.ad.model.a f38787b;

        /* renamed from: c, reason: collision with root package name */
        private b f38788c;

        /* renamed from: d, reason: collision with root package name */
        private long f38789d;

        /* renamed from: e, reason: collision with root package name */
        private String f38790e;

        public a(com.qq.e.comm.plugin.base.ad.model.b bVar, com.qq.e.comm.plugin.base.ad.model.a aVar, b bVar2, long j3) {
            this.f38786a = bVar;
            this.f38787b = aVar;
            this.f38788c = bVar2;
            this.f38789d = j3;
        }

        public com.qq.e.comm.plugin.base.ad.model.b b() {
            return this.f38786a;
        }

        public com.qq.e.comm.plugin.base.ad.model.a c() {
            return this.f38787b;
        }

        public b d() {
            return this.f38788c;
        }

        public long e() {
            return this.f38789d;
        }

        public String f() {
            return this.f38790e;
        }

        public boolean a() {
            return (this.f38786a == null || this.f38787b == null || this.f38788c == null) ? false : true;
        }

        public a a(String str) {
            this.f38790e = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar);

        void a(JSONObject jSONObject);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("error_message_report_length", 150);
        return str.length() > integer ? str.substring(0, integer) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.qq.e.comm.plugin.base.ad.e.b.a c(String str) {
        String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
        if (GDTADManager.getInstance().getSM().getInteger("stop", 0) == 1) {
            return new com.qq.e.comm.plugin.base.ad.e.b.a("\u5e94\u7528\u5df2\u88ab\u5c01\u505c\uff0c\u5bf9\u5e94AppId:" + appid, 5019);
        }
        if (GDTADManager.getInstance().getSM().getIntegerForPlacement("stop", str, 0) == 1) {
            return new com.qq.e.comm.plugin.base.ad.e.b.a("\u5e7f\u544a\u4f4d\u5df2\u88ab\u5c01\u505c\uff0c\u5bf9\u5e94PosId:" + str + "\u5df2\u88ab\u5c01\u505c", 5018);
        }
        if (!a()) {
            return null;
        }
        au.a(100272, f38777a, str, "");
        return new com.qq.e.comm.plugin.base.ad.e.b.a("\u8d85\u8fc7\u6700\u5927\u8bf7\u6c42\u9891\u7387\u6bcf\u5206\u949f:" + f38777a + "\u6b21", 5013);
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.b bVar, com.qq.e.comm.plugin.base.ad.model.a aVar, b bVar2) {
        a(bVar, aVar, bVar2, b(aVar.f38907c));
    }

    private static void a(final com.qq.e.comm.plugin.base.ad.model.b bVar, final com.qq.e.comm.plugin.base.ad.model.a aVar, final b bVar2, final String str) {
        if (bVar2 != null && bVar != null) {
            if (Build.VERSION.SDK_INT <= com.qq.e.comm.plugin.j.c.a("adReqShieldSystemVersion", 22)) {
                bVar2.a(new com.qq.e.comm.plugin.base.ad.e.b.a("your system version is too low to shield!", 509));
                return;
            } else {
                GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.e.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.qq.e.comm.plugin.base.ad.e.b.a c16 = c.c(com.qq.e.comm.plugin.base.ad.model.b.this.g());
                        if (c16 != null) {
                            GDTLogger.e(c16.getMessage());
                            bVar2.a(c16);
                            return;
                        }
                        final long currentTimeMillis = System.currentTimeMillis();
                        PlainRequest plainRequest = new PlainRequest(str, 1, (byte[]) null);
                        try {
                            com.qq.e.comm.plugin.base.ad.a.a(plainRequest, GDTADManager.getInstance(), com.qq.e.comm.plugin.base.ad.model.b.this);
                            GDTLogger.d("req info = " + plainRequest.getQuerys());
                        } catch (JSONException e16) {
                            com.qq.e.comm.plugin.stat.b bVar3 = new com.qq.e.comm.plugin.stat.b();
                            com.qq.e.comm.plugin.base.ad.model.a aVar2 = aVar;
                            if (aVar2 != null) {
                                bVar3.a(aVar2.f38906b);
                            }
                            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                            cVar.a("msg", e16.getMessage());
                            StatTracer.trackEvent(4000, 0, bVar3, cVar);
                        }
                        NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.plugin.base.ad.e.c.1.1
                            @Override // com.qq.e.comm.net.NetworkCallBack
                            public void onException(Exception exc) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.a(exc, new a(com.qq.e.comm.plugin.base.ad.model.b.this, aVar, bVar2, currentTimeMillis));
                            }

                            @Override // com.qq.e.comm.net.NetworkCallBack
                            public void onResponse(Request request, Response response) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.a(request, response, new a(com.qq.e.comm.plugin.base.ad.model.b.this, aVar, bVar2, currentTimeMillis));
                            }
                        };
                        au.a(com.qq.e.comm.plugin.base.ad.model.b.this);
                        if (SDKStatus.getSDKVersionCode() >= 220) {
                            NetworkClientImpl.getInstance().submit(plainRequest, 1, networkCallBack, com.qq.e.comm.plugin.j.c.a(com.qq.e.comm.plugin.base.ad.model.b.this.g(), "requestConnectTimeout", Integer.MAX_VALUE));
                        } else {
                            NetworkClientImpl.getInstance().submit(plainRequest, 1, networkCallBack);
                        }
                    }
                });
                return;
            }
        }
        GDTLogger.e("Invoke LoadAD with illegal arguments");
    }

    public static String b(com.qq.e.comm.plugin.base.ad.b bVar) {
        com.qq.e.comm.plugin.d.a aVar;
        if (aj.g() && (aVar = com.qq.e.comm.plugin.d.b.f39332a) != null && (!TextUtils.isEmpty(aVar.b()) || !TextUtils.isEmpty(com.qq.e.comm.plugin.d.b.f39332a.a()))) {
            return com.qq.e.comm.plugin.d.b.f39332a.b();
        }
        if (aj.c()) {
            return bVar == com.qq.e.comm.plugin.base.ad.b.SPLASH ? "https://us.l.qq.com/exapp" : "https://ttc.gdt.qq.com/gdt_inner_view_autotest";
        }
        try {
            return aj.b() ? bVar == com.qq.e.comm.plugin.base.ad.b.SPLASH ? "https://ttc.gdt.qq.com/exapp" : "https://ttc.gdt.qq.com/gdt_inner_view" : bVar == com.qq.e.comm.plugin.base.ad.b.SPLASH ? c() : b();
        } catch (NoSuchElementException unused) {
            return bVar == com.qq.e.comm.plugin.base.ad.b.SPLASH ? aj.d() ? "https://ttc.gdt.qq.com/exapp" : c() : "https://ii.gdt.qq.com/gdt_inner_view";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x009e, code lost:
    
        if (r5.z() != 1) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0179  */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.qq.e.comm.plugin.base.ad.model.b] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.qq.e.comm.plugin.base.ad.model.a] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Request request, Response response, a aVar) {
        ?? r75;
        String str;
        com.qq.e.comm.plugin.base.ad.model.b bVar;
        String stringContent;
        int i3;
        String str2;
        Throwable th5;
        String b16;
        int i16;
        String str3;
        String str4;
        JSONException e16;
        String str5;
        String str6;
        b d16 = aVar != null ? aVar.d() : null;
        if (aVar != null && aVar.a()) {
            ?? b17 = aVar.b();
            ?? c16 = aVar.c();
            long currentTimeMillis = System.currentTimeMillis() - aVar.e();
            if ((response != null && response.getStatusCode() == 200) || !TextUtils.isEmpty(aVar.f())) {
                try {
                    try {
                        if (response != null) {
                            try {
                                stringContent = response.getStringContent();
                            } catch (JSONException e17) {
                                e16 = e17;
                                str5 = null;
                                i3 = Integer.MIN_VALUE;
                                str4 = str5;
                                GDTLogger.d("LoadADService  json exception  =" + e16.getMessage());
                                d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(e16, 502));
                                b16 = b(e16.getLocalizedMessage());
                                i16 = 2001;
                                c16 = str4;
                                r2 = b17;
                                b17 = i3;
                                au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                            } catch (Throwable th6) {
                                th5 = th6;
                                str3 = null;
                                i3 = Integer.MIN_VALUE;
                                str2 = str3;
                                d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(th5, 605));
                                b16 = b(th5.getLocalizedMessage());
                                i16 = 2009;
                                c16 = str2;
                                r2 = b17;
                                b17 = i3;
                                au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                            }
                        } else {
                            stringContent = null;
                        }
                        if (response == null && !TextUtils.isEmpty(aVar.f())) {
                            stringContent = aVar.f();
                        }
                        String str7 = stringContent;
                        if (TextUtils.isEmpty(str7)) {
                            d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a("response content is empty", 508));
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str7);
                            i3 = jSONObject.optInt("ret", Integer.MIN_VALUE);
                            try {
                                a(jSONObject, c16.f38906b, request.getUrlWithParas());
                                boolean z16 = true;
                                if (b17.c() != 1) {
                                    try {
                                    } catch (JSONException e18) {
                                        e16 = e18;
                                        str4 = str7;
                                        GDTLogger.d("LoadADService  json exception  =" + e16.getMessage());
                                        d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(e16, 502));
                                        b16 = b(e16.getLocalizedMessage());
                                        i16 = 2001;
                                        c16 = str4;
                                        r2 = b17;
                                        b17 = i3;
                                        au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                                    } catch (Throwable th7) {
                                        th5 = th7;
                                        str2 = str7;
                                        d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(th5, 605));
                                        b16 = b(th5.getLocalizedMessage());
                                        i16 = 2009;
                                        c16 = str2;
                                        r2 = b17;
                                        b17 = i3;
                                        au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                                    }
                                }
                                z16 = false;
                                String optString = jSONObject.optString("ip_ping_url", "");
                                if (!TextUtils.isEmpty(optString)) {
                                    if (z16) {
                                        GDTLogger.d("\u5b9e\u65f6\u62c9\u53d6\u5e7f\u544aping ipv4 :" + optString);
                                        af.b(optString);
                                    } else {
                                        SharedPreferencedUtil.putString("ipv4_" + b17.g(), optString);
                                    }
                                }
                                d16.a(jSONObject);
                                str6 = str7;
                                try {
                                    au.a((com.qq.e.comm.plugin.base.ad.model.b) b17, currentTimeMillis, true, Integer.MIN_VALUE, response != null ? response.getStatusCode() : -1, (String) null, i3);
                                    a(response, aVar, jSONObject);
                                } catch (JSONException e19) {
                                    e16 = e19;
                                    str4 = str6;
                                    GDTLogger.d("LoadADService  json exception  =" + e16.getMessage());
                                    d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(e16, 502));
                                    b16 = b(e16.getLocalizedMessage());
                                    i16 = 2001;
                                    c16 = str4;
                                    r2 = b17;
                                    b17 = i3;
                                    au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                                } catch (Throwable th8) {
                                    th5 = th8;
                                    str2 = str6;
                                    d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(th5, 605));
                                    b16 = b(th5.getLocalizedMessage());
                                    i16 = 2009;
                                    c16 = str2;
                                    r2 = b17;
                                    b17 = i3;
                                    au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                                }
                            } catch (JSONException e26) {
                                e16 = e26;
                                str6 = str7;
                            } catch (Throwable th9) {
                                th5 = th9;
                                str6 = str7;
                            }
                        } catch (JSONException e27) {
                            e16 = e27;
                            str5 = str7;
                            i3 = Integer.MIN_VALUE;
                            str4 = str5;
                            GDTLogger.d("LoadADService  json exception  =" + e16.getMessage());
                            d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(e16, 502));
                            b16 = b(e16.getLocalizedMessage());
                            i16 = 2001;
                            c16 = str4;
                            r2 = b17;
                            b17 = i3;
                            au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                        } catch (Throwable th10) {
                            th5 = th10;
                            str3 = str7;
                            i3 = Integer.MIN_VALUE;
                            str2 = str3;
                            d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(th5, 605));
                            b16 = b(th5.getLocalizedMessage());
                            i16 = 2009;
                            c16 = str2;
                            r2 = b17;
                            b17 = i3;
                            au.a(response, r2, currentTimeMillis, (int) b17, (String) c16, i16, b16);
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        r75 = 0;
                        bVar = b17;
                        str = c16;
                        if (r75 != 0) {
                        }
                        throw th;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    r75 = r2;
                    bVar = b17;
                    str = c16;
                    if (r75 != 0) {
                        au.a(response, bVar, currentTimeMillis, i3, str, (int) r75, "");
                    }
                    throw th;
                }
            } else if (response == null && TextUtils.isEmpty(aVar.f())) {
                d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a("ad data is empty", 801));
                au.a((com.qq.e.comm.plugin.base.ad.model.b) b17, currentTimeMillis, false, 2010, Integer.MIN_VALUE, (String) null, Integer.MIN_VALUE);
            } else if (response != null) {
                d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a("HttpStatus error", 403));
                au.a((com.qq.e.comm.plugin.base.ad.model.b) b17, currentTimeMillis, false, 2000, response.getStatusCode(), (String) null, Integer.MIN_VALUE);
            }
        } else {
            GDTLogger.e("responseAction with illegal arguments");
            au.a(aVar != null ? aVar.b() : null, aVar != null ? aVar.e() : -1L, false, 2008, response != null ? response.getStatusCode() : -1, (String) null, Integer.MIN_VALUE);
            if (d16 != null) {
                d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a("action params is illegal", 507));
            }
        }
    }

    private static String c() {
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, "splashAdCgiForTangram", "https://us.l.qq.com/exapp");
        return !TextUtils.isEmpty(a16) ? a16 : "https://us.l.qq.com/exapp";
    }

    private static String b() {
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, "commonAdCgiForTangram", "https://ii.gdt.qq.com/gdt_inner_view");
        return !TextUtils.isEmpty(a16) ? a16 : "https://ii.gdt.qq.com/gdt_inner_view";
    }

    private static void a(Response response, a aVar, JSONObject jSONObject) {
        try {
            com.qq.e.comm.plugin.j.e.a().c();
            a(aVar, jSONObject, response);
            a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.d("preload   exception  =" + th5.getMessage());
        }
    }

    private static void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int i3;
        int i16;
        try {
            if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI && (optJSONArray = jSONObject.optJSONArray("preorder_apps")) != null && optJSONArray.length() > 0) {
                int i17 = 0;
                int i18 = 0;
                while (i18 < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i18);
                    if (y.a(jSONObject2)) {
                        String optString = jSONObject2.optString("productid");
                        String optString2 = jSONObject2.optString("effect_url");
                        String optString3 = jSONObject2.optString("cl");
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(j.T0);
                        if (y.a(jSONObject3)) {
                            String optString4 = jSONObject3.optString("pkg_name");
                            String str = SharedPreferencedUtil.KEY_PREODER_APP_CALLBACK_NUM_PREFIX + optString4;
                            String str2 = SharedPreferencedUtil.KEY_PREODER_APP_CALLBACK_TIME_PREFIX + optString4;
                            int i19 = SharedPreferencedUtil.getInt(str, i17);
                            i16 = i18;
                            long currentTimeMillis = System.currentTimeMillis() - SharedPreferencedUtil.getLong(str2, 0L);
                            if (i19 < 3 && currentTimeMillis >= 86400000) {
                                if (TextUtils.isEmpty(SharedPreferencedUtil.getString(SharedPreferencedUtil.KEY_PREODER_APP_INFO_PREFIX + optString4, ""))) {
                                    SharedPreferencedUtil.putString(SharedPreferencedUtil.KEY_PREODER_APP_INFO_PREFIX + optString4, jSONObject2.toString());
                                }
                                if (com.qq.e.comm.plugin.k.c.a(GDTADManager.getInstance().getAppContext(), optString4)) {
                                    return;
                                }
                                com.qq.e.comm.plugin.base.ad.model.d task = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getTask(optString4);
                                if (task != null) {
                                    if (task.m() == 4) {
                                        return;
                                    }
                                    if (task.m() == 8) {
                                        com.qq.e.comm.plugin.base.a.a.a().a(task);
                                        return;
                                    } else {
                                        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).start(task);
                                        return;
                                    }
                                }
                                com.qq.e.comm.plugin.base.ad.model.d dVar = new com.qq.e.comm.plugin.base.ad.model.d(optString3, optString, jSONObject2.optString("traceid"), jSONObject3.optString(AppDownloadCallback.APP_LOGO), jSONObject3.getString("pkgurl"), jSONObject3.optString("appname"), optString4, null, 0, optString2);
                                i3 = 0;
                                dVar.a("autoInstall", false);
                                StatTracer.trackEvent(1600001, 0, new com.qq.e.comm.plugin.stat.b());
                                ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).start(dVar);
                                i18 = i16 + 1;
                                i17 = i3;
                            }
                            return;
                        }
                    }
                    i3 = i17;
                    i16 = i18;
                    i18 = i16 + 1;
                    i17 = i3;
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(a aVar, JSONObject jSONObject, Response response) throws JSONException {
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        String str2;
        boolean z16;
        int i19;
        JSONArray jSONArray;
        ?? r16 = jSONObject;
        str = "";
        long j3 = 0;
        j3 = 0;
        j3 = 0;
        r4 = 0;
        long j16 = 0;
        int i26 = 0;
        try {
            try {
                jSONArray = r16.getJSONObject("data").getJSONObject(aVar.f38786a.g()).getJSONArray("list");
                i18 = r16.optInt("ret", Integer.MIN_VALUE);
            } catch (JSONException e16) {
                e = e16;
                i18 = 0;
            } catch (Exception e17) {
                e = e17;
                i17 = 0;
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
                i16 = 0;
                z16 = r16;
                str2 = str;
                if (i16 != 0) {
                }
                throw th;
            }
            try {
                r16 = r16;
                str = str;
                i19 = i18;
                if (GDTLogger.isEnableConsoleLog()) {
                    GDTLogger.d("LoadADService  posAdList  =" + jSONArray);
                    r16 = r16;
                    str = str;
                    i19 = i18;
                }
            } catch (JSONException e18) {
                e = e18;
                e.printStackTrace();
                String b16 = b(e.getLocalizedMessage());
                long currentTimeMillis = System.currentTimeMillis() - (aVar != null ? aVar.e() : 0L);
                r3 = aVar != null ? aVar.b() : null;
                String jSONObject2 = r16 != 0 ? jSONObject.toString() : "";
                com.qq.e.comm.plugin.base.ad.model.b bVar = r3;
                long j17 = currentTimeMillis;
                int i27 = i18;
                i26 = 2001;
                ?? r75 = b16;
                au.a(response, bVar, j17, i27, jSONObject2, 2001, (String) r75);
                r16 = bVar;
                str = j17;
                j3 = i27;
                i19 = r75;
            } catch (Exception e19) {
                e = e19;
                i17 = i18;
                try {
                    e.printStackTrace();
                    i26 = 2009;
                    String b17 = b(e.getLocalizedMessage());
                    long currentTimeMillis2 = System.currentTimeMillis() - (aVar != null ? aVar.e() : 0L);
                    com.qq.e.comm.plugin.base.ad.model.b b18 = aVar != null ? aVar.b() : null;
                    String str3 = str;
                    if (r16 != 0) {
                        str3 = jSONObject.toString();
                    }
                    au.a(response, b18, currentTimeMillis2, i17, str3, 2009, b17);
                } catch (Throwable th6) {
                    th = th6;
                    i16 = i26;
                    i3 = i17;
                    z16 = r16;
                    str2 = str;
                    if (i16 != 0) {
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            i16 = i26;
            z16 = r16;
            str2 = str;
            j16 = j3;
            i3 = i19;
            if (i16 != 0) {
                if (aVar != null) {
                    j16 = aVar.e();
                }
                long currentTimeMillis3 = System.currentTimeMillis() - j16;
                if (aVar != null) {
                    r3 = aVar.b();
                }
                com.qq.e.comm.plugin.base.ad.model.b bVar2 = r3;
                String str4 = str2;
                if (z16) {
                    str4 = jSONObject.toString();
                }
                au.a(response, bVar2, currentTimeMillis3, i3, str4, i16, "");
            }
            throw th;
        }
    }

    public static void a(Exception exc, a aVar) {
        if (aVar != null && aVar.a()) {
            com.qq.e.comm.plugin.base.ad.model.b b16 = aVar.b();
            b d16 = aVar.d();
            long currentTimeMillis = System.currentTimeMillis() - aVar.e();
            d16.a(new com.qq.e.comm.plugin.base.ad.e.b.a(exc, 400));
            au.a(b16, currentTimeMillis, false, 2000, Integer.MIN_VALUE, b(exc.getLocalizedMessage()), Integer.MIN_VALUE);
            return;
        }
        GDTLogger.e("exceptionAction with illegal arguments");
        au.a(aVar != null ? aVar.f38786a : null, aVar != null ? aVar.e() : -1L, false, 2008, Integer.MIN_VALUE, b(exc.getLocalizedMessage()), Integer.MIN_VALUE);
    }

    public static String a(com.qq.e.comm.plugin.base.ad.b bVar) {
        return b(bVar);
    }

    private static boolean a() {
        if (f38779c == -1) {
            f38779c = SystemClock.elapsedRealtime();
            return false;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("loadad_limit_num", 2048);
        if (integer != f38777a) {
            if (integer < 5) {
                integer = 5;
            }
            GDTLogger.d("throttling new value:" + integer + " old:" + f38777a);
            f38779c = SystemClock.elapsedRealtime();
            f38777a = integer;
            f38778b = integer;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - f38779c;
        f38779c = elapsedRealtime;
        double d16 = j3 * (f38777a / 60000.0d);
        GDTLogger.d("throttling old:" + f38778b + " increase:" + d16);
        int i3 = (int) (((double) f38778b) + d16);
        f38778b = i3;
        int i16 = f38777a;
        if (i3 > i16) {
            f38778b = i16;
        }
        int i17 = f38778b;
        if (i17 < 1) {
            return true;
        }
        f38778b = i17 - 1;
        return false;
    }

    private static JSONObject a(JSONObject jSONObject, String str, String str2) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject.getInt("ret") == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject(str);
            if (jSONObject2.getInt("ret") == 0) {
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    jSONObject3.put("requrl", str2);
                    com.qq.e.comm.plugin.base.ad.model.e c16 = com.qq.e.comm.plugin.k.d.c(jSONObject3);
                    JSONObject optJSONObject3 = jSONObject3.optJSONObject("ext");
                    if (optJSONObject3 != null && com.qq.e.comm.plugin.k.d.a(jSONObject3) && !StringUtil.isEmpty(c16.b()) && (optJSONObject = optJSONObject3.optJSONObject("alist")) != null && (optJSONObject2 = optJSONObject.optJSONObject("2022")) != null) {
                        optJSONObject2.put("status", c16.e());
                    }
                }
            }
        }
        return jSONObject;
    }
}
