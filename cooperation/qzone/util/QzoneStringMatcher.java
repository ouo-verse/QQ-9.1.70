package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import common.config.service.QzoneConfig;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneStringMatcher {
    public static final String TAG = "QzoneStringMatcher";
    private static final long UPDATE_CONFIG_INTERVAL_MS = 180000;
    private static LRULinkedHashMap<String, Pattern> gPatternCacheMap;
    private static final int QzoneStringMatcherLruMapSize = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_REG_STRING_MATCHER_LRU_MAP_SIZE, 50);
    private static String gUrlConfig = null;
    private static long gLastReadConfigTime = 0;

    private static String getUrlConfig() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - gLastReadConfigTime >= 180000) {
            gUrlConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_IGNORE_WEBVIEW_SCHEME_URL, QzoneConfig.SECONDARY_IGNORE_WEBVIEW_SCHEME_URL_DEFAULT);
            gLastReadConfigTime = currentTimeMillis;
        }
        return gUrlConfig;
    }

    public static boolean isMatch(String str, String str2) {
        Pattern pattern;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (gPatternCacheMap == null) {
            gPatternCacheMap = new LRULinkedHashMap<>(QzoneStringMatcherLruMapSize);
        }
        try {
            int i3 = QzoneStringMatcherLruMapSize;
            if (i3 > 0) {
                pattern = gPatternCacheMap.get(str2);
            } else {
                pattern = null;
            }
            if (pattern == null) {
                pattern = Pattern.compile(str2);
                if (i3 > 0) {
                    gPatternCacheMap.put(str2, pattern);
                }
            }
            return pattern.matcher(str).lookingAt();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isMatch reg error.", e16);
            return false;
        }
    }

    public static boolean needIgoreUrl(String str, String str2, boolean z16) {
        JSONArray jSONArray;
        boolean z17;
        JSONArray optJSONArray;
        if (!z16 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String urlConfig = getUrlConfig();
        if (TextUtils.isEmpty(urlConfig)) {
            return false;
        }
        try {
            jSONArray = new JSONArray(urlConfig);
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "config is not valid json. " + urlConfig);
        }
        if (jSONArray.length() <= 0) {
            return false;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("domains");
            if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                int i16 = 0;
                while (true) {
                    if (i16 < optJSONArray2.length()) {
                        String str3 = (String) optJSONArray2.get(i16);
                        if (!TextUtils.isEmpty(str3) && isMatch(str, str3)) {
                            z17 = true;
                            break;
                        }
                        i16++;
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (z17 && (optJSONArray = jSONObject.optJSONArray("items")) != null && optJSONArray.length() != 0) {
                    for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                        String str4 = (String) optJSONArray.get(i17);
                        if (!TextUtils.isEmpty(str4) && isMatch(str2, str4)) {
                            QLog.d(TAG, 2, "match url:" + str2 + ",item=" + str4);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
