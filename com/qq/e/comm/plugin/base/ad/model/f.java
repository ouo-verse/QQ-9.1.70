package com.qq.e.comm.plugin.base.ad.model;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.plugin.k.ab;
import com.qq.e.comm.plugin.k.ae;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    protected boolean A;
    protected String B;
    protected int E;
    protected com.qq.e.comm.plugin.base.ad.b F;
    protected JSONObject G;
    protected h H;
    protected String I;
    protected boolean J;
    protected String K;
    protected String L;
    protected String M;
    private int O;
    private String P;
    private int Q;
    private int R;
    private List<s> S;
    private List<s> T;
    private List<String> U;
    private List<String> V;
    private String W;
    private int X;
    private String Y;
    private boolean Z;

    /* renamed from: a, reason: collision with root package name */
    protected String f38980a;
    private List<a> aC;
    private int[] aD;
    private String aE;
    private int aF;

    /* renamed from: aa, reason: collision with root package name */
    private int f38981aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f38982ab;

    /* renamed from: ac, reason: collision with root package name */
    private int f38983ac;

    /* renamed from: ad, reason: collision with root package name */
    private String f38984ad;

    /* renamed from: ae, reason: collision with root package name */
    private String f38985ae;

    /* renamed from: af, reason: collision with root package name */
    private boolean f38986af;

    /* renamed from: ag, reason: collision with root package name */
    private List<q> f38987ag;

    /* renamed from: ah, reason: collision with root package name */
    private int f38988ah;

    /* renamed from: ai, reason: collision with root package name */
    private String f38989ai;

    /* renamed from: aj, reason: collision with root package name */
    private List<String> f38990aj;

    /* renamed from: ak, reason: collision with root package name */
    private JSONObject f38991ak;

    /* renamed from: al, reason: collision with root package name */
    private String f38992al;

    /* renamed from: ao, reason: collision with root package name */
    private boolean f38995ao;

    /* renamed from: ap, reason: collision with root package name */
    private n f38996ap;

    /* renamed from: aq, reason: collision with root package name */
    private String f38997aq;

    /* renamed from: ar, reason: collision with root package name */
    private String f38998ar;

    /* renamed from: as, reason: collision with root package name */
    private String f38999as;

    /* renamed from: at, reason: collision with root package name */
    private i f39000at;

    /* renamed from: au, reason: collision with root package name */
    private String f39001au;

    /* renamed from: aw, reason: collision with root package name */
    private String f39003aw;

    /* renamed from: b, reason: collision with root package name */
    protected String f39007b;

    /* renamed from: c, reason: collision with root package name */
    protected String f39008c;

    /* renamed from: d, reason: collision with root package name */
    protected String f39009d;

    /* renamed from: e, reason: collision with root package name */
    protected String f39010e;

    /* renamed from: f, reason: collision with root package name */
    protected String f39011f;

    /* renamed from: g, reason: collision with root package name */
    protected String f39012g;

    /* renamed from: h, reason: collision with root package name */
    protected String f39013h;

    /* renamed from: i, reason: collision with root package name */
    protected String f39014i;

    /* renamed from: j, reason: collision with root package name */
    protected String f39015j;

    /* renamed from: k, reason: collision with root package name */
    protected int f39016k;

    /* renamed from: l, reason: collision with root package name */
    protected String f39017l;

    /* renamed from: m, reason: collision with root package name */
    protected int f39018m;

    /* renamed from: n, reason: collision with root package name */
    protected String f39019n;

    /* renamed from: o, reason: collision with root package name */
    protected String f39020o;

    /* renamed from: p, reason: collision with root package name */
    protected String f39021p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f39022q;

    /* renamed from: r, reason: collision with root package name */
    protected e f39023r;

    /* renamed from: s, reason: collision with root package name */
    protected int f39024s;

    /* renamed from: t, reason: collision with root package name */
    protected String f39025t;

    /* renamed from: u, reason: collision with root package name */
    protected float f39026u;

    /* renamed from: v, reason: collision with root package name */
    protected float f39027v;

    /* renamed from: w, reason: collision with root package name */
    protected float f39028w;

    /* renamed from: x, reason: collision with root package name */
    protected float f39029x;

    /* renamed from: y, reason: collision with root package name */
    protected String f39030y;

    /* renamed from: z, reason: collision with root package name */
    protected String f39031z;
    protected int C = -1;
    protected int D = -1;

    /* renamed from: am, reason: collision with root package name */
    private boolean f38993am = false;

    /* renamed from: an, reason: collision with root package name */
    private boolean f38994an = false;

    /* renamed from: av, reason: collision with root package name */
    private double f39002av = -1.0d;

    /* renamed from: ax, reason: collision with root package name */
    private boolean f39004ax = false;

    /* renamed from: ay, reason: collision with root package name */
    private boolean f39005ay = false;

    /* renamed from: az, reason: collision with root package name */
    private long f39006az = 0;
    private long aA = 0;
    private String aB = null;
    protected boolean N = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f39032a;

        /* renamed from: b, reason: collision with root package name */
        public int f39033b;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (aVar == null) {
                return 0;
            }
            return aVar.f39033b - this.f39033b;
        }

        public String toString() {
            return "play time =" + this.f39033b + "; reportUrl = " + this.f39032a;
        }
    }

    public f() {
    }

    private static boolean o(int i3) {
        return i3 != 1;
    }

    public int A() {
        return this.Q;
    }

    public int B() {
        return this.R;
    }

    public List<s> C() {
        return this.S;
    }

    public List<s> D() {
        return this.T;
    }

    public List<String> E() {
        return this.U;
    }

    public List<String> F() {
        return this.V;
    }

    public String G() {
        return this.W;
    }

    public int H() {
        return this.X;
    }

    public int I() {
        return this.f38982ab;
    }

    public int J() {
        return this.f38981aa;
    }

    public int K() {
        return this.f38983ac;
    }

    public String L() {
        return this.f38984ad;
    }

    public String M() {
        return this.f38985ae;
    }

    public boolean N() {
        return this.f38986af;
    }

    public List<q> O() {
        return this.f38987ag;
    }

    public int P() {
        return this.f38988ah;
    }

    public String Q() {
        return this.f38989ai;
    }

    public boolean R() {
        return this.Z;
    }

    public boolean S() {
        return this.J;
    }

    public List<String> T() {
        return this.f38990aj;
    }

    public n U() {
        return this.f38996ap;
    }

    public String V() {
        return this.f38999as;
    }

    public String W() {
        return this.f38998ar;
    }

    public i X() {
        return this.f39000at;
    }

    public int Y() {
        return this.aF;
    }

    public void Z() {
        List<s> list = this.S;
        if (list != null && list.size() > 0) {
            for (s sVar : this.S) {
                if (sVar != null) {
                    af.b(sVar.a());
                }
            }
        }
    }

    public boolean a() {
        return o(this.E);
    }

    public void aa() {
        List<s> list = this.T;
        if (list != null && list.size() > 0) {
            for (s sVar : this.T) {
                if (sVar != null) {
                    ab.a(sVar.a());
                }
            }
        }
    }

    public void ab() {
        List<String> list = this.V;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.V.iterator();
            while (it.hasNext()) {
                ab.a(it.next());
            }
        }
    }

    public JSONObject ac() {
        return this.f38991ak;
    }

    public String ad() {
        return this.f38992al;
    }

    public String ae() {
        return this.K;
    }

    public String af() {
        return this.f39003aw;
    }

    public String ag() {
        return this.aE;
    }

    public boolean ah() {
        return this.f39004ax;
    }

    public boolean ai() {
        return this.f39005ay;
    }

    public long aj() {
        return this.f39006az;
    }

    public long ak() {
        return this.aA;
    }

    public String al() {
        return this.aB;
    }

    public double am() {
        return this.f39002av;
    }

    public String an() {
        return this.L;
    }

    public String ao() {
        return this.M;
    }

    public int[] ap() {
        return this.aD;
    }

    public boolean aq() {
        if (Y() == 2) {
            return true;
        }
        return false;
    }

    public String b() {
        return this.I;
    }

    public h c() {
        return this.H;
    }

    public boolean d() {
        return this.f38995ao;
    }

    public String e() {
        return this.f39001au;
    }

    public String f() {
        return this.f38980a;
    }

    public String g() {
        return this.f39007b;
    }

    public String getButtonTxt() {
        return this.Y;
    }

    public String getDesc() {
        return this.f39008c;
    }

    public int getECPM() {
        return this.C;
    }

    public String h() {
        return this.f39009d;
    }

    public String i() {
        return this.f39010e;
    }

    public boolean isAppAd() {
        return this.f39022q;
    }

    public boolean isWeChatCanvasAd() {
        if (P() == 12) {
            return true;
        }
        return false;
    }

    public String j() {
        return this.f39011f;
    }

    public String k() {
        return this.f39012g;
    }

    public String l() {
        return this.f39013h;
    }

    public String m() {
        return this.f39014i;
    }

    public String n() {
        return this.f39015j;
    }

    public int p() {
        return this.f39018m;
    }

    public String q() {
        return this.f39019n;
    }

    public String r() {
        return this.f39020o;
    }

    public String s() {
        return this.B;
    }

    public com.qq.e.comm.plugin.base.ad.b t() {
        return this.F;
    }

    public String toString() {
        try {
            return "BaseAdInfo{cl='" + this.f38980a + "', txt='" + this.f39007b + "', desc='" + this.f39008c + "', img='" + this.f39009d + "', apurl='" + this.f39011f + "', customizedpingurl='" + this.f39017l + "', negative_feedback_url='" + this.f39019n + "', isAppAd=" + this.f39022q + ", duration=" + this.f39024s + ", background_url='" + this.f39025t + "', leftPadding=" + this.f39026u + ", topPadding=" + this.f39027v + ", widthRatio=" + this.f39028w + ", heightRatio=" + this.f39029x + ", hideDescVertical=" + this.A + ", appId=" + this.f39030y + ", posId=" + this.B + ", adThreadId=" + this.f39031z + ", adType=" + this.F + ", disableJumpAppHome=" + this.J + ", passThrough=" + this.f38991ak + ", Transparent video Url=" + this.f38992al + ", downloadRate = " + this.f39002av + ", corporateName = " + this.L + ", corporateImg = " + this.M + '}';
        } catch (Throwable th5) {
            GDTLogger.e("BaseAdInfo toString error: ", th5);
            return "BaseAdInfo{}";
        }
    }

    public String u() {
        return this.f39031z;
    }

    public JSONObject v() {
        return this.G;
    }

    public int w() {
        return this.O;
    }

    public String x() {
        return this.P;
    }

    public String y() {
        return this.f39021p;
    }

    public String z() {
        return this.f39011f;
    }

    private void E(String str) {
        this.aE = str;
    }

    private void F(String str) {
        this.aB = str;
    }

    public void A(String str) {
        this.K = str;
    }

    public void B(String str) {
        this.f39003aw = str;
    }

    public void C(String str) {
        this.L = str;
    }

    public void D(String str) {
        this.M = str;
    }

    public void a(String str) {
        this.I = str;
    }

    public void b(String str) {
        this.f39001au = str;
    }

    public void c(String str) {
        this.f38980a = str;
    }

    public void d(String str) {
        this.f39007b = str;
    }

    public void e(String str) {
        this.f39008c = str;
    }

    public void f(String str) {
        this.f39009d = str;
    }

    public void g(String str) {
        this.f39010e = str;
    }

    public void h(String str) {
        this.f39011f = str;
    }

    public void i(String str) {
        this.f39012g = str;
    }

    public void j(String str) {
        this.f39013h = str;
    }

    public void k(String str) {
        this.f39014i = str;
    }

    public void l(String str) {
        this.f39015j = str;
    }

    public void m(String str) {
        this.f39017l = str;
    }

    public void n(String str) {
        this.f39019n = str;
    }

    public String o() {
        return this.f39017l;
    }

    public void p(String str) {
        this.P = str;
    }

    public void q(String str) {
        this.f39021p = str;
    }

    public void r(String str) {
        this.W = str;
    }

    public void s(String str) {
        this.f38984ad = str;
    }

    public void t(String str) {
        this.f38985ae = str;
    }

    public void u(String str) {
        this.f38989ai = str;
    }

    public void v(String str) {
        this.Y = str;
    }

    public void w(String str) {
        this.f38999as = str;
    }

    public void x(String str) {
        this.f38997aq = str;
    }

    public void y(String str) {
        this.f38998ar = str;
    }

    public void z(String str) {
        this.f38992al = str;
    }

    private void p(int i3) {
        this.aA = i3;
    }

    private void q(int i3) {
        this.f39006az = i3;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.H = new h(jSONObject);
        }
    }

    public void b(int i3) {
        this.f39018m = i3;
    }

    public void c(int i3) {
        this.O = i3;
    }

    public void d(int i3) {
        this.C = i3;
    }

    public void e(int i3) {
        this.D = i3;
    }

    public void f(int i3) {
        this.E = i3;
    }

    public void g(int i3) {
        this.Q = i3;
    }

    public void h(int i3) {
        this.R = i3;
    }

    public void i(int i3) {
        this.X = i3;
    }

    public void j(int i3) {
        this.f38982ab = i3;
    }

    public void k(int i3) {
        this.f38981aa = i3;
    }

    public void l(int i3) {
        this.f38983ac = i3;
    }

    public void m(int i3) {
        this.f38988ah = i3;
    }

    public void n(int i3) {
        this.aF = i3;
    }

    public void o(String str) {
        this.f39020o = str;
    }

    private void i(boolean z16) {
        this.f39004ax = z16;
    }

    private void j(boolean z16) {
        this.f39005ay = z16;
    }

    public void a(boolean z16) {
        this.f38995ao = z16;
    }

    public void b(boolean z16) {
        this.f39022q = z16;
    }

    public void c(List<String> list) {
        this.U = list;
    }

    public void d(List<String> list) {
        this.V = list;
    }

    public void e(boolean z16) {
        this.J = z16;
    }

    public void f(boolean z16) {
        this.f38993am = z16;
    }

    public void g(boolean z16) {
        this.f38994an = z16;
    }

    public void h(boolean z16) {
        this.N = z16;
    }

    public void a(int i3) {
        this.f39016k = i3;
    }

    public void b(JSONObject jSONObject) {
        this.G = jSONObject;
    }

    public void c(boolean z16) {
        this.f38986af = z16;
    }

    public void d(boolean z16) {
        this.Z = z16;
    }

    public void e(List<String> list) {
        this.f38990aj = list;
    }

    public void a(e eVar) {
        this.f39023r = eVar;
    }

    public void b(List<s> list) {
        this.T = list;
    }

    public void c(JSONObject jSONObject) {
        i iVar = new i();
        this.f39000at = iVar;
        iVar.a(jSONObject);
    }

    public void d(JSONObject jSONObject) {
        this.f38991ak = jSONObject;
    }

    public void e(JSONObject jSONObject) {
        n a16;
        if (jSONObject == null) {
            return;
        }
        b(jSONObject);
        c(jSONObject.optString("cl"));
        d(jSONObject.optString(FileReaderHelper.TXT_EXT));
        e(jSONObject.optString("desc"));
        f(jSONObject.optString("img"));
        g(jSONObject.optString("img2"));
        E(jSONObject.optString("img4"));
        h(jSONObject.optString("apurl"));
        i(jSONObject.optString("v_apurl"));
        j(jSONObject.optString("original_exposure_url"));
        k(jSONObject.optString("stay_report_url"));
        l(jSONObject.optString("rl"));
        a(jSONObject.optInt("sdk_proto_type"));
        m(jSONObject.optString("customizedpingurl"));
        b(jSONObject.optInt("producttype"));
        q(jSONObject.optString("traceid"));
        o(jSONObject.optString("landing_page_report_url"));
        a(jSONObject.optString("effect_url"));
        a(jSONObject.optJSONObject(HippyQQConstants.URL_COMPONENT_NAME));
        d(jSONObject.optInt("ecpm", -1));
        e(-1);
        f(jSONObject.optInt("buyingtype", 1));
        String optString = jSONObject.optString(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO);
        if (!TextUtils.isEmpty(optString)) {
            n(optString.replace("__ACT_TYPE__", "2001"));
        }
        b(com.qq.e.comm.plugin.k.d.a(jSONObject));
        if (isAppAd()) {
            a(com.qq.e.comm.plugin.k.d.c(jSONObject));
        }
        e(jSONObject.optBoolean("disable_jump_app_home"));
        c(jSONObject.optInt("sub_type"));
        p(jSONObject.optString("video"));
        g(jSONObject.optInt("video_width"));
        h(jSONObject.optInt("video_height"));
        a(s.a(jSONObject.optJSONArray("report_url")));
        b(s.a(jSONObject.optJSONArray("report_url_sdk")));
        c(ae.a(jSONObject.optJSONArray("click_mo_url")));
        d(ae.a(jSONObject.optJSONArray("click_mo_url_sdk")));
        r(jSONObject.optString("net_log_req_id"));
        i(jSONObject.optInt("sdk_jump_type"));
        k(jSONObject.optInt("pic_width"));
        j(jSONObject.optInt("pic_height"));
        l(jSONObject.optInt("inner_adshowtype"));
        s(jSONObject.optString("endcard"));
        t(jSONObject.optString("mini_program_app_id"));
        c(jSONObject.optBoolean("is_contract_ad", false));
        a(jSONObject.optJSONArray("neg_fb_items"));
        m(jSONObject.optInt("desttype", -1));
        v(jSONObject.optString(AppDownloadCallback.BUTTON_TXT));
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (y.a(optJSONObject)) {
            String optString2 = optJSONObject.optString("sdk_data");
            if (!TextUtils.isEmpty(optString2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    u(jSONObject2.optString("wechat_canvas_ext_info"));
                    b(jSONObject2.optString("quick_app_link"));
                    B(jSONObject2.optString("web_ext_data"));
                    n(y.c(jSONObject2, "landingpage_open_type"));
                } catch (JSONException e16) {
                    GDTLogger.d(e16.getMessage());
                }
            }
        }
        d(jSONObject.optBoolean("video_floating_view", false));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("sdk_switch");
        if (y.a(optJSONObject2)) {
            f(optJSONObject2.optBoolean(ACTD.NEED_GESTURE_BACK, false));
            g(optJSONObject2.optBoolean("activity_new_task", false));
            a(optJSONObject2.optBoolean("downloading_with_play", false));
            i(y.b(optJSONObject2, "support_pcdn", false));
            j(y.b(optJSONObject2, "support_p2p", false));
            q(y.b(optJSONObject2, "pcdn_min_time_ms", -1));
            p(y.b(optJSONObject2, "pcdn_max_time_ms", -1));
            F(y.e(optJSONObject2, "sdk_support_exp_ids"));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("img_list");
        if (!y.a(optJSONArray)) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString3 = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString3)) {
                    arrayList.add(optString3);
                }
            }
            e(arrayList);
        }
        JSONObject g16 = y.g(jSONObject, "jump_android_market_info");
        if (y.a(g16) && (a16 = n.a(g16)) != null) {
            a(a16);
        }
        d(jSONObject.optJSONObject("pass_through_data"));
        z(jSONObject.optString("video2"));
        A(jSONObject.optString("video_report_url"));
        w(jSONObject.optString("productid"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("app_download_info");
        if (y.a(optJSONObject3)) {
            x(optJSONObject3.optString("channel_id", "0"));
            y(y.e(optJSONObject3, "download_api_url"));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("dest_info");
        if (y.a(optJSONObject4)) {
            c(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("material_download_control");
        if (y.a(optJSONObject5)) {
            a(optJSONObject5.optDouble("download_raito", -1.0d));
        }
        C(y.e(jSONObject, "corporate_image_name"));
        D(y.e(jSONObject, "corporate_logo"));
        h(y.a(jSONObject, "support_qb_webview"));
        JSONObject g17 = y.g(jSONObject, "thirdparty_monitor_urls");
        if (y.a(g17)) {
            b(y.f(g17, "multi_video_play_monitor_urls"));
        }
        c(y.f(jSONObject, "ad_extension_type"));
    }

    public void a(com.qq.e.comm.plugin.base.ad.b bVar) {
        this.F = bVar;
    }

    public void b(JSONArray jSONArray) {
        if (w.b(jSONArray)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject c16 = w.c(jSONArray, i3);
            a aVar = new a();
            aVar.f39032a = ae.a(y.f(c16, "report_url"));
            aVar.f39033b = y.c(c16, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME);
            arrayList.add(aVar);
            GDTLogger.d("videoPlayMonitorInfo :" + aVar.toString());
        }
        Collections.sort(arrayList);
        this.aC = arrayList;
    }

    public void a(List<s> list) {
        this.S = list;
    }

    public void c(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            iArr[i3] = y.b(jSONArray, i3);
        }
        a(iArr);
    }

    public void a(JSONArray jSONArray) {
        this.f38987ag = new ArrayList();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                this.f38987ag.add(new q(jSONArray.getJSONObject(i3)));
            } catch (Exception unused) {
                GDTLogger.e("negativeFeedBackItems json error");
                return;
            }
        }
    }

    public f(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar) {
        this.f39030y = str;
        this.B = str2;
        this.f39031z = str3;
        this.F = bVar;
    }

    public void a(n nVar) {
        this.f38996ap = nVar;
    }

    public void a(double d16) {
        this.f39002av = d16;
    }

    public void a(int[] iArr) {
        this.aD = iArr;
    }
}
