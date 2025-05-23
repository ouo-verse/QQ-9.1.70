package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("scene", "");
        String optString2 = jSONObject.optString("title", "");
        String optString3 = jSONObject.optString(WadlProxyConsts.SCENE_ID, "");
        String optString4 = jSONObject.optString("kvo", "");
        String optString5 = jSONObject.optString("startDate", "");
        String optString6 = jSONObject.optString("expiryDate", "");
        int optInt = jSONObject.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        c.a aVar = new c.a();
        aVar.f356635c = optInt;
        aVar.f356634b = optString3;
        aVar.f356637e = optString;
        aVar.f356636d = optString2;
        aVar.f356638f = optString4;
        if (!StringUtil.isEmpty(optString5) && !StringUtil.isEmpty(optString6)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            try {
                aVar.f356639g = simpleDateFormat.parse(optString5);
                aVar.f356640h = simpleDateFormat.parse(optString6);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScenesRecommendUtils", 2, "parse invalidTime failed!", e16);
                }
            }
        }
        if (optJSONArray != null) {
            aVar.f356633a = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString7 = optJSONArray.optString(i3);
                if (!StringUtil.isEmpty(optString7)) {
                    aVar.f356633a.add(optString7);
                }
            }
        }
        c d16 = d(aVar);
        if (d16 == null) {
            return null;
        }
        if (jSONObject.has("extra")) {
            try {
                d16.f(jSONObject.getJSONObject("extra"));
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return new c(aVar);
    }

    public static String b(AppInterface appInterface) {
        return appInterface.getApp().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).getString("SCENESRECOMMEND_CONTEXT" + appInterface.getCurrentAccountUin(), "");
    }

    public static List<c> c(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScenesRecommendUtils", 2, "parseJson  strJson = " + str);
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("scenes")) {
                JSONArray jSONArray = jSONObject.getJSONArray("scenes");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    c a16 = a(jSONArray.getJSONObject(i3));
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("ScenesRecommendUtils", 2, "parseJson has exception strJson = " + str, e16);
            }
        }
        return arrayList;
    }

    private static c d(c.a aVar) {
        String str;
        if (aVar != null && (str = aVar.f356634b) != null) {
            if (str.equalsIgnoreCase("redpacket_id001")) {
                return new HongBaoScenesRecommendItem(aVar);
            }
            return new c(aVar);
        }
        return null;
    }
}
