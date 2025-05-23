package cooperation.vip.vipcomponent;

import NS_COMM_VIP_GROWTH.IconInfo;
import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.util.QZLog;
import cooperation.vip.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QQUnionIconInfo implements Serializable {

    @NeedParcel
    public Map<String, String> mCommonMapExtendInfo;

    @NeedParcel
    public Map<String, String> mExtendInfo;

    @NeedParcel
    public int mIconHeight;

    @NeedParcel
    public String mIconUrl;

    @NeedParcel
    public int mIconWidth;

    private static boolean a(QQUnionIconInfo qQUnionIconInfo) {
        Map<String, String> map;
        if (qQUnionIconInfo != null && (map = qQUnionIconInfo.mCommonMapExtendInfo) != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static JSONObject convertToJson(QQUnionIconInfo qQUnionIconInfo) {
        if (qQUnionIconInfo == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mIconUrl", qQUnionIconInfo.mIconUrl);
            jSONObject.put("mIconWidth", qQUnionIconInfo.mIconWidth);
            jSONObject.put("mIconHeight", qQUnionIconInfo.mIconHeight);
            jSONObject.put("mExtendInfo", new JSONObject(qQUnionIconInfo.mExtendInfo));
            jSONObject.put("mCommonMapExtendInfo", new JSONObject(qQUnionIconInfo.mCommonMapExtendInfo));
        } catch (Exception e16) {
            QZLog.e("QQUnionIconInfo", "convertToJson error", e16);
        }
        return jSONObject;
    }

    public static QQUnionIconInfo convertToQQUnionIconInfo(IconInfo iconInfo) {
        if (iconInfo == null) {
            return null;
        }
        QQUnionIconInfo qQUnionIconInfo = new QQUnionIconInfo();
        qQUnionIconInfo.mIconUrl = iconInfo.strUrl;
        qQUnionIconInfo.mIconWidth = iconInfo.iWidth;
        qQUnionIconInfo.mIconHeight = iconInfo.iHigh;
        qQUnionIconInfo.mExtendInfo = iconInfo.mapExtendInfo;
        qQUnionIconInfo.mCommonMapExtendInfo = iconInfo.commonMapExtendInfo;
        return qQUnionIconInfo;
    }

    public static Map<String, QQUnionIconInfo> convertToQQUnionIconMap(Map<String, IconInfo> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, IconInfo> entry : map.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                hashMap.put(entry.getKey(), convertToQQUnionIconInfo(entry.getValue()));
            }
        }
        return hashMap;
    }

    public static String getCarouselUrls(QQUnionIconInfo qQUnionIconInfo) {
        if (a(qQUnionIconInfo)) {
            return qQUnionIconInfo.mCommonMapExtendInfo.get("carousel_url_list");
        }
        return null;
    }

    public static String getTenYellowId(QQUnionIconInfo qQUnionIconInfo) {
        Map<String, String> map;
        if (qQUnionIconInfo != null && (map = qQUnionIconInfo.mExtendInfo) != null && !map.isEmpty()) {
            return qQUnionIconInfo.mExtendInfo.get("digital_decorate_id");
        }
        return null;
    }

    public static QQUnionIconInfo parseFromJson(JSONObject jSONObject) {
        String obj;
        String obj2;
        if (jSONObject == null) {
            return null;
        }
        QQUnionIconInfo qQUnionIconInfo = new QQUnionIconInfo();
        try {
            qQUnionIconInfo.mIconUrl = jSONObject.optString("mIconUrl");
            qQUnionIconInfo.mIconWidth = jSONObject.optInt("mIconWidth");
            qQUnionIconInfo.mIconHeight = jSONObject.optInt("mIconHeight");
            Map<String, Object> b16 = b.b(jSONObject.optJSONObject("mExtendInfo"));
            qQUnionIconInfo.mExtendInfo = new HashMap();
            if (b16 != null) {
                for (String str : b16.keySet()) {
                    Map<String, String> map = qQUnionIconInfo.mExtendInfo;
                    if (b16.get(str) == null) {
                        obj2 = null;
                    } else {
                        obj2 = b16.get(str).toString();
                    }
                    map.put(str, obj2);
                }
            }
            Map<String, Object> b17 = b.b(jSONObject.optJSONObject("mCommonMapExtendInfo"));
            qQUnionIconInfo.mCommonMapExtendInfo = new HashMap();
            if (b17 != null) {
                for (String str2 : b17.keySet()) {
                    Map<String, String> map2 = qQUnionIconInfo.mCommonMapExtendInfo;
                    if (b17.get(str2) == null) {
                        obj = null;
                    } else {
                        obj = b17.get(str2).toString();
                    }
                    map2.put(str2, obj);
                }
            }
        } catch (Exception e16) {
            QZLog.e("QQUnionIconInfo", "parseFromJson error", e16);
        }
        return qQUnionIconInfo;
    }
}
