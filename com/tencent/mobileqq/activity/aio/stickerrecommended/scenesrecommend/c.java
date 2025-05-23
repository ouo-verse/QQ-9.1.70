package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    private static b a(JSONObject jSONObject) {
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
        b.a aVar = new b.a();
        aVar.f179987c = optInt;
        aVar.f179986b = optString3;
        aVar.f179989e = optString;
        aVar.f179988d = optString2;
        aVar.f179990f = optString4;
        if (!StringUtil.isEmpty(optString5) && !StringUtil.isEmpty(optString6)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            try {
                aVar.f179991g = simpleDateFormat.parse(optString5);
                aVar.f179992h = simpleDateFormat.parse(optString6);
            } catch (Exception e16) {
                QLog.d("ScenesRecommendUtils", 2, "parse invalidTime failed!", e16);
            }
        }
        if (optJSONArray != null) {
            aVar.f179985a = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString7 = optJSONArray.optString(i3);
                if (!StringUtil.isEmpty(optString7)) {
                    aVar.f179985a.add(optString7);
                }
            }
        }
        b d16 = d(aVar);
        if (d16 == null) {
            return null;
        }
        if (jSONObject.has("extra")) {
            try {
                d16.e(jSONObject.getJSONObject("extra"));
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return new b(aVar);
    }

    public static String b(AppInterface appInterface) {
        return appInterface.getApp().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).getString("SCENESRECOMMEND_CONTEXT" + appInterface.getCurrentAccountUin(), "");
    }

    public static List<b> c(String str) {
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
                    b a16 = a(jSONArray.getJSONObject(i3));
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("ScenesRecommendUtils", 2, "parseJson has exception strJson = " + str, e16);
        }
        return arrayList;
    }

    private static b d(b.a aVar) {
        String str;
        if (aVar != null && (str = aVar.f179986b) != null) {
            if (str.equalsIgnoreCase("redpacket_id001")) {
                return new HongBaoScenesRecommendItem(aVar);
            }
            return new b(aVar);
        }
        return null;
    }

    public static void e(AppInterface appInterface, String str) {
        if (str == null) {
            return;
        }
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).edit();
        edit.putString("SCENESRECOMMEND_CONTEXT" + appInterface.getCurrentAccountUin(), str);
        edit.apply();
    }
}
