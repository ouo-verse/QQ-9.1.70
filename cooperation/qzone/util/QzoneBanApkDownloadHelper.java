package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import common.config.service.QzoneConfig;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneBanApkDownloadHelper {
    private static final String TAG = "QzoneBanApkDownloadHelper";
    private static final String gApkBanlistDomainArrayConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS, QzoneConfig.SECONDARY_IGNORE_DOWNLOAD_APK_DOMAINS_DEFAULT);
    private static String gQzoneCallAppUrlListConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_CALL_APP_URL_LIST, QzoneConfig.QZONE_CALL_APP_URL_LIST_DEFAULT);

    private static String[] getApkBanlistDomainArray() {
        String[] split;
        String str = gApkBanlistDomainArrayConfig;
        if (TextUtils.isEmpty(str) || (split = str.split(",")) == null) {
            return null;
        }
        for (int i3 = 0; i3 < split.length; i3++) {
            if (TextUtils.isEmpty(split[i3])) {
                split[i3] = "";
            } else {
                split[i3] = split[i3].trim();
            }
        }
        return split;
    }

    public static boolean isDomainInBlackList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String domin = Utils.getDomin(str);
        if (TextUtils.isEmpty(domin)) {
            return false;
        }
        String lowerCase = domin.toLowerCase();
        String[] apkBanlistDomainArray = getApkBanlistDomainArray();
        if (apkBanlistDomainArray != null && apkBanlistDomainArray.length != 0) {
            for (String str2 : apkBanlistDomainArray) {
                if (!TextUtils.isEmpty(str2)) {
                    String lowerCase2 = str2.toLowerCase();
                    if (lowerCase.endsWith("." + lowerCase2)) {
                        if (QZLog.isDevelopLevel()) {
                            QZLog.d(TAG, 4, "match domain:" + lowerCase + ",webviewUrl=" + str);
                        }
                        return true;
                    }
                    if (lowerCase.equals(lowerCase2)) {
                        if (QZLog.isDevelopLevel()) {
                            QZLog.d(TAG, 4, "match domain:" + lowerCase + ",webviewUrl=" + str);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isUrlInRegList(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString) && QzoneStringMatcher.isMatch(str, optString)) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.i(TAG, 1, "isUrlInRegList match url:" + str + " ,reg=" + optString);
                    }
                    return true;
                }
            }
            return false;
        } catch (JSONException e16) {
            QZLog.e(TAG, "isUrlInRegList json error.", e16);
            return false;
        }
    }

    public static boolean isUrlMatchQzoneCallAppUrlList(String str) {
        return isUrlInRegList(str, gQzoneCallAppUrlListConfig);
    }
}
