package cooperation.qzone.font;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DefaultBarrageEffectInfo {
    public int itemId = -1;
    public String jsonStr;

    public static String toJson(int i3, String str, String str2, String str3, String str4, int i16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("iItemId", i3);
            jSONObject.put("strTextColor", str);
            jSONObject.put("strAndBgUrl", str2);
            jSONObject.put("strIosBgUrl", str3);
            jSONObject.put("strFrameZip", str4);
            jSONObject.put("iFrameRate", i16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }
}
