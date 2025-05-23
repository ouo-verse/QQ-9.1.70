package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class z {
    public static com.qq.e.comm.plugin.stat.b a(ClickInfo clickInfo, JSONObject jSONObject) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (clickInfo != null) {
            if (clickInfo.c() != null) {
                bVar.a(clickInfo.c().f38511c);
                bVar.f(clickInfo.g());
            }
            JSONObject j3 = clickInfo.j();
            if (y.a(j3)) {
                bVar.b(y.e(j3, "cl"));
                bVar.c(y.e(j3, "traceid"));
                bVar.a(y.c(j3, "ad_first_category"));
                bVar.b(y.c(j3, "advertiser_id"));
                bVar.c(y.c(j3, "producttype"));
                bVar.d(y.c(j3, "inner_adshowtype"));
            }
        }
        bVar.a(jSONObject);
        return bVar;
    }

    public static com.qq.e.comm.plugin.stat.b a(com.qq.e.comm.plugin.f.b bVar) {
        com.qq.e.comm.plugin.stat.b bVar2 = new com.qq.e.comm.plugin.stat.b();
        if (bVar != null) {
            String c16 = bVar.c();
            if (!TextUtils.isEmpty(c16)) {
                bVar2.b(c16);
            }
            String d16 = bVar.d();
            if (!TextUtils.isEmpty(d16)) {
                bVar2.c(d16);
            }
            String b16 = bVar.b();
            if (!TextUtils.isEmpty(b16)) {
                bVar2.a(b16);
            }
            JSONObject jSONObject = new JSONObject();
            y.a(jSONObject, LinkReportConstant$BizKey.AUTO_DOWNLOAD, bVar.e());
            y.a(jSONObject, LinkReportConstant$BizKey.DOWNLOAD_SCENE, bVar.f());
            bVar2.a(jSONObject);
        }
        return bVar2;
    }

    public static com.qq.e.comm.plugin.stat.b a(JSONObject jSONObject, JSONObject jSONObject2) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (y.a(jSONObject)) {
            bVar.b(y.e(jSONObject, "cl"));
            bVar.c(y.e(jSONObject, "traceid"));
            bVar.a(y.c(jSONObject, "ad_first_category"));
            bVar.b(y.c(jSONObject, "advertiser_id"));
            bVar.c(y.c(jSONObject, "producttype"));
            bVar.d(y.c(jSONObject, "inner_adshowtype"));
        }
        bVar.a(jSONObject2);
        return bVar;
    }

    public static com.qq.e.comm.plugin.stat.b a(ClickInfo clickInfo, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        if (z16) {
            try {
                jSONObject.putOpt(LinkReportConstant$BizKey.DEEPLINK_TYPE, 1);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        jSONObject.putOpt(LinkReportConstant$BizKey.DEEPLINK_SCENE, 1);
        return a(clickInfo, jSONObject);
    }

    public static com.qq.e.comm.plugin.stat.b a(com.qq.e.comm.plugin.stat.b bVar, JSONObject jSONObject, long j3) {
        if (bVar == null) {
            return new com.qq.e.comm.plugin.stat.b().a(jSONObject).a(System.currentTimeMillis() - j3);
        }
        return bVar.a(jSONObject).a(System.currentTimeMillis() - j3);
    }

    public static com.qq.e.comm.plugin.stat.b a(com.qq.e.comm.plugin.stat.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONException e16;
        if (bVar == null) {
            bVar = new com.qq.e.comm.plugin.stat.b();
        }
        if (jSONObject == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (JSONException e17) {
                jSONObject2 = jSONObject;
                e16 = e17;
            }
            try {
                jSONObject2.putOpt("lp_type", 2);
                jSONObject2.putOpt(LinkReportConstant$BizKey.CLICK_REQ_TYPE, 3);
                jSONObject = jSONObject2;
            } catch (JSONException e18) {
                e16 = e18;
                GDTLogger.e(e16.getMessage());
                return bVar.a(jSONObject2);
            }
        }
        jSONObject2 = jSONObject;
        return bVar.a(jSONObject2);
    }
}
