package a20;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.recommend.data.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    private static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            x.f("WSSubTabsHelper", "[WSSubTabsHelper.java][getJsonObj] jsonStr is null!");
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            x.f("WSSubTabsHelper", "[WSSubTabsHelper.java] getJsonObj return null!!!");
            return null;
        }
    }

    public static List<c> b(g gVar) {
        ArrayList<c> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (gVar == null || (arrayList = gVar.f81431a) == null || arrayList.size() == 0) {
            return arrayList2;
        }
        for (int i3 = 0; i3 < gVar.f81431a.size(); i3++) {
            c cVar = gVar.f81431a.get(i3);
            if (cVar != null) {
                cVar.i(false).j(16);
            }
        }
        return gVar.f81431a;
    }

    public static g c(String str) {
        JSONObject a16 = a(str);
        if (a16 == null) {
            return null;
        }
        String optString = a16.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE);
        JSONArray optJSONArray = a16.optJSONArray("subTabs");
        if (optJSONArray == null) {
            x.f("WSSubTabsHelper", "[WSSubTabsHelper.java] subTabs is null!!!");
            return null;
        }
        g gVar = new g();
        ArrayList<c> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            String optString2 = optJSONObject.optString("id");
            String optString3 = optJSONObject.optString("title");
            arrayList.add(new c(optString3).g(optString2).h(optJSONObject.optString(QQWinkConstants.TAB_SUBTITLE)));
        }
        gVar.a(optString);
        gVar.b(arrayList);
        return gVar;
    }
}
