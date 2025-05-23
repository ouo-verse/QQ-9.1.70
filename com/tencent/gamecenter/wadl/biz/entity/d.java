package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: v, reason: collision with root package name */
    public static int f106766v = 51;

    /* renamed from: b, reason: collision with root package name */
    public String f106768b;

    /* renamed from: c, reason: collision with root package name */
    public String f106769c;

    /* renamed from: d, reason: collision with root package name */
    public String f106770d;

    /* renamed from: e, reason: collision with root package name */
    public String f106771e;

    /* renamed from: f, reason: collision with root package name */
    public String f106772f;

    /* renamed from: g, reason: collision with root package name */
    public String f106773g;

    /* renamed from: h, reason: collision with root package name */
    public String f106774h;

    /* renamed from: i, reason: collision with root package name */
    public String f106775i;

    /* renamed from: j, reason: collision with root package name */
    public String f106776j;

    /* renamed from: k, reason: collision with root package name */
    public String f106777k;

    /* renamed from: l, reason: collision with root package name */
    public String f106778l;

    /* renamed from: m, reason: collision with root package name */
    public String f106779m;

    /* renamed from: n, reason: collision with root package name */
    public String f106780n;

    /* renamed from: o, reason: collision with root package name */
    public String f106781o;

    /* renamed from: p, reason: collision with root package name */
    public String f106782p;

    /* renamed from: q, reason: collision with root package name */
    public String f106783q;

    /* renamed from: r, reason: collision with root package name */
    public String f106784r;

    /* renamed from: s, reason: collision with root package name */
    public String f106785s;

    /* renamed from: t, reason: collision with root package name */
    private JSONObject f106786t;

    /* renamed from: a, reason: collision with root package name */
    private String f106767a = "08900078603";

    /* renamed from: u, reason: collision with root package name */
    public HashMap<Integer, String> f106787u = new HashMap<>();

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.f106786t;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f106768b)) {
                jSONObject2.put(WadlReportBuilder.TableElem.OPER_ID, this.f106768b);
            }
            if (!TextUtils.isEmpty(this.f106769c)) {
                jSONObject2.put("event_code", this.f106769c);
            }
            if (!TextUtils.isEmpty(this.f106770d)) {
                jSONObject2.put("page_id", this.f106770d);
            }
            if (!TextUtils.isEmpty(this.f106771e)) {
                jSONObject2.put("page_name", this.f106771e);
            }
            if (!TextUtils.isEmpty(this.f106772f)) {
                jSONObject2.put("module_id", this.f106772f);
            }
            if (!TextUtils.isEmpty(this.f106773g)) {
                jSONObject2.put("module_name", this.f106773g);
            }
            if (!TextUtils.isEmpty(this.f106774h)) {
                jSONObject2.put("sub_module_id", this.f106774h);
            }
            if (!TextUtils.isEmpty(this.f106775i)) {
                jSONObject2.put("sub_module_name", this.f106775i);
            }
            if (!TextUtils.isEmpty(this.f106776j)) {
                jSONObject2.put("element_name", this.f106776j);
            }
            if (!TextUtils.isEmpty(this.f106777k)) {
                jSONObject2.put("element_level", this.f106777k);
            }
            if (!TextUtils.isEmpty(this.f106778l)) {
                jSONObject2.put("pre_page_name", this.f106778l);
            }
            if (!TextUtils.isEmpty(this.f106779m)) {
                jSONObject2.put("adtag", this.f106779m);
            }
            if (!TextUtils.isEmpty(this.f106780n)) {
                jSONObject2.put("game_id", this.f106780n);
            }
            if (!TextUtils.isEmpty(this.f106781o)) {
                jSONObject2.put(CrashRtInfoHolder.BeaconKey.GAME_NAME, this.f106781o);
            }
            if (!TextUtils.isEmpty(this.f106782p)) {
                jSONObject2.put("pkg_name", this.f106782p);
            }
            if (!TextUtils.isEmpty(this.f106768b)) {
                jSONObject2.put(WadlReportBuilder.TableElem.OPER_ID, this.f106768b);
            }
            if (!TextUtils.isEmpty(this.f106783q)) {
                jSONObject2.put(QAdVrReportParams.ParamKey.EXPERIMENT_ID, this.f106783q);
            }
            if (!TextUtils.isEmpty(this.f106784r)) {
                jSONObject2.put("activity_id", this.f106784r);
            }
            if (!TextUtils.isEmpty(this.f106785s)) {
                jSONObject2.put(ServiceConst.PARA_SESSION_ID, this.f106785s);
            }
            for (Map.Entry<Integer, String> entry : this.f106787u.entrySet()) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    jSONObject2.put("ext" + entry.getKey(), value);
                }
            }
            jSONObject.put("data", jSONObject2);
            jSONObject.put(WadlReportBuilder.KEY_DC_ID, this.f106767a);
        } catch (Exception e16) {
            QLog.e("WadlAttaReportBuilder", 1, "parseJson exception:", e16);
        }
        return jSONObject;
    }

    public void b() {
        QLog.d("WadlAttaReportBuilder", 1, "report " + this);
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportToAtta78603(this);
    }

    public d c(String str) {
        this.f106784r = str;
        return this;
    }

    public d d(String str) {
        this.f106779m = str;
        return this;
    }

    public d e(JSONObject jSONObject) {
        this.f106786t = jSONObject;
        return this;
    }

    public d f(String str) {
        this.f106777k = str;
        return this;
    }

    public d g(String str) {
        this.f106776j = str;
        return this;
    }

    public d h(String str) {
        this.f106769c = str;
        return this;
    }

    public d i(String str) {
        this.f106783q = str;
        return this;
    }

    public d j(int i3, String str) {
        if (str != null && i3 >= 1 && i3 <= f106766v) {
            this.f106787u.put(Integer.valueOf(i3), str);
        }
        return this;
    }

    public d k(String str) {
        this.f106780n = str;
        return this;
    }

    public d l(String str) {
        this.f106781o = str;
        return this;
    }

    public d m(String str) {
        this.f106772f = str;
        return this;
    }

    public d n(String str) {
        this.f106773g = str;
        return this;
    }

    public d o(String str) {
        this.f106768b = str;
        return this;
    }

    public d p(String str) {
        this.f106770d = str;
        return this;
    }

    public d q(String str) {
        this.f106771e = str;
        return this;
    }

    public d r(String str) {
        this.f106782p = str;
        return this;
    }

    public d s(String str) {
        this.f106778l = str;
        return this;
    }

    public d t(String str) {
        this.f106785s = str;
        return this;
    }

    public String toString() {
        return "[operId=" + this.f106768b + ",eventCode=" + this.f106769c + "]";
    }

    public d u(String str) {
        this.f106774h = str;
        return this;
    }

    public d v(String str) {
        this.f106775i = str;
        return this;
    }
}
