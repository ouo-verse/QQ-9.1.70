package ew2;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParamKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdAction;
import com.tencent.qqlive.ona.protocol.jce.AdActionReport;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdReportType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import pw2.u;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c {

    /* renamed from: s, reason: collision with root package name */
    private String f397283s;

    /* renamed from: t, reason: collision with root package name */
    private String f397284t;

    e() {
        super(null, null, null, null, null, null, null);
    }

    public static e D() {
        return new e();
    }

    public static e E(AdOrderItem adOrderItem, String str, String str2) {
        AdAction adAction;
        AdActionReport adActionReport;
        AdReport adReport;
        String str3;
        String str4;
        AdReport adReport2 = null;
        if (adOrderItem == null || (adAction = adOrderItem.adAction) == null || (adActionReport = adAction.actionReport) == null || (adReport = adActionReport.effectReport) == null || TextUtils.isEmpty(adReport.url)) {
            return null;
        }
        AdActionReport adActionReport2 = adOrderItem.adAction.actionReport;
        if (adActionReport2 != null) {
            adReport2 = adActionReport2.effectReport;
        }
        AdReport adReport3 = adReport2;
        String str5 = "";
        if (adActionReport2 == null) {
            str3 = "";
        } else {
            str3 = adActionReport2.adReportKey;
        }
        if (adActionReport2 == null) {
            str4 = "";
        } else {
            str4 = adActionReport2.adReportParams;
        }
        AdPositionItem adPositionItem = adOrderItem.positionItem;
        if (adPositionItem != null) {
            str5 = adPositionItem.adSpace;
        }
        return new e(str, str2, adReport3, adOrderItem.orderId, str5, str3, str4, adOrderItem);
    }

    public static e F(String str, AdReport adReport, String str2, String str3, String str4, String str5, String str6) {
        e eVar = new e();
        eVar.f304049b = str;
        eVar.f397283s = str3;
        eVar.f397284t = str4;
        eVar.f304050c = str2;
        eVar.f304048a = adReport;
        eVar.f304051d = str5;
        eVar.f304052e = str6;
        eVar.f304054g = false;
        return eVar;
    }

    public static e G(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, String str, String str2) {
        e eVar = null;
        if (adOrderItem == null) {
            return null;
        }
        AdReport a16 = kw2.b.a(adOrderItem, AdReportType.AD_REPORT_TYPE_EFFECT);
        if (a16 != null && !TextUtils.isEmpty(a16.url)) {
            eVar = new e();
            eVar.f304052e = adOrderItem.ad_report_param;
            eVar.f304051d = adOrderItem.ad_report_key;
            eVar.f304054g = false;
            eVar.f304049b = adOrderItem.order_id;
            eVar.f397283s = str;
            eVar.f397284t = str2;
            eVar.f304048a = a16;
            Map<String, String> c16 = kw2.b.c(adOrderItem, AdReportType.AD_REPORT_TYPE_CLICK);
            if (!y.i(c16)) {
                eVar.f304044o = c16.get("__CHANNEL_ID__");
                eVar.f304045p = y.m(c16.get("__SEQ__"), 0);
                eVar.f304046q = y.m(c16.get("__ABS_SEQ__"), 0);
            }
        }
        return eVar;
    }

    public String H() {
        return this.f397283s;
    }

    public String I() {
        return this.f397284t;
    }

    public void J(String str) {
        this.f397283s = str;
    }

    public void K(String str) {
        this.f397284t = str;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.e(jSONObject);
        this.f397283s = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_ID, null);
        this.f397284t = jSONObject.optString(MiniChatConstants.CLICK_ID, null);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public JSONObject m() {
        JSONObject m3 = super.m();
        try {
            m3.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_ID, this.f397283s);
            m3.put(MiniChatConstants.CLICK_ID, this.f397284t);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return m3;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public HashMap<String, String> s() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = this.f304049b;
        if (str != null) {
            hashMap.put("adId", str);
        }
        String str2 = this.f304050c;
        if (str2 != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_POS, str2);
        }
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_ID, this.f397283s);
        hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, this.f304051d);
        hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, this.f304052e);
        HashMap<String, String> b16 = b();
        if (b16.size() > 0) {
            hashMap.putAll(b16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.c(this, this.f304054g, gVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String y() {
        String str;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        String d16 = u.d(str);
        if (d16 == null) {
            return null;
        }
        String str2 = this.f397284t;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        String replace = d16.replace("__CLICK_ID__", str2);
        String str4 = this.f397283s;
        if (str4 != null) {
            str3 = str4;
        }
        return replace.replace("__ACTION_ID__", str3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String z() {
        String str;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        return u.e(str);
    }

    public e(String str, String str2, AdReport adReport, String str3, String str4, String str5, String str6, AdOrderItem adOrderItem) {
        super(adReport, str3, str4, str5, str6, adOrderItem, "");
        this.f397283s = str;
        this.f397284t = str2;
        this.f304054g = false;
    }
}
