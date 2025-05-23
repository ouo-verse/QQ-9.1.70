package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class PathUtil {
    public static JSONObject getJSONQueryString(String str) {
        int indexOf;
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                int indexOf2 = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf2 > -1 && str.length() > (i3 = indexOf2 + 1)) {
                    str = str.substring(i3);
                }
                String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2) && (indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER)) >= 0) {
                            jSONObject.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QMLog.e("PathUtil", "getJSONQueryString exception " + th5);
        }
        return jSONObject;
    }

    public static boolean isNetworkUrl(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
            return true;
        }
        return false;
    }
}
