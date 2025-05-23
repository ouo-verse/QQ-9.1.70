package om4;

import android.util.Base64;
import com.tencent.timi.game.utils.l;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f423184a = "SmobaSchemeUtil";

    public static String a(boolean z16, String str, String str2, String str3) {
        if (z16) {
            return str2 + "?OpenId=" + str + "&openid=" + str + "&user_openid=" + str + "&current_uin=" + str + "&leftViewText=\u6709\u4e50&platform=qq_m&gamedata=" + str3 + "&launchtype=cymini";
        }
        return str2 + "?OpenId=" + str + "&openid=" + str + "&user_openid=" + str + "&wx_openId=" + str + "&wx_callback=onReq&messageExt=\u6709\u4e50&platformId=wechat&gamedata=" + str3 + "&launchtype=cymini";
    }

    public static String b(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, String str8) {
        try {
            String str9 = "\"" + str + "\"";
            for (int i16 = 0; i16 < i3 - 1; i16++) {
                str9 = str9 + ",\"" + str + "\"";
            }
            JSONObject jSONObject = new JSONObject("{\"createType\":\"" + str2 + "\",\"mapID\":\"" + str6 + "\",\"mapType\":\"" + str7 + "\",\"ullExternUid\":\"" + str8 + "\",\"roomName\":\"helloname\",\"teamerNum\":\"" + i3 + "\",\"platType\":\"1\",\"iServerid\":\"0\",\"ullRoomid\":\"456\",  \"campid\":\"" + str3 + "\",\"AddType\":\"" + str4 + "\",\"AddPos\":\"" + str5 + "\", \"partitionids\":[" + str9 + "]}");
            String str10 = f423184a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("generateTestSmobaGangupGameData - ");
            sb5.append(jSONObject);
            l.i(str10, sb5.toString());
            return "SmobaLaunch_" + Base64.encodeToString(jSONObject.toString().getBytes(), 0).trim().replaceAll("\n", "").replaceAll(" ", "");
        } catch (Exception e16) {
            l.f(f423184a, "generateTestSmobaGangupGameData error", e16);
            return "";
        }
    }

    public static String c() {
        return "tencentmsdk1104466820://";
    }
}
