package cooperation.ilive.share;

import cooperation.qzone.mobilereport.MobileReportManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class IliveShareHelper {
    public static String getFollowInfo(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zt_str1", str);
            jSONObject.put("zt_str2", str2);
            jSONObject.put("zt_str3", str3);
            jSONObject.put("zt_str4", str4);
            jSONObject.put("roomid", str5);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void reportAction(String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        reportAction(str, str2, str3, str4, "", "", str6, str5, "", i3, 0);
    }

    public static void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, int i16) {
        MobileReportManager.getInstance().reportActionLive(str, str2, new MobileReportManager.ItemInfoBuilder().setItemId(str3).setBusiInfo(str7).setModuleId(str4).setItemType(str8).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), i3, i16).build()).build());
    }
}
