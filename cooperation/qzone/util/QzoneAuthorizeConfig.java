package cooperation.qzone.util;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneAuthorizeConfig {
    public static final String DEFAULT_JSAPI_BLACK_LIST = "";
    public static final String DEFAULT_SCHEMA_BLACK_LIST = "";
    static final String TAG = "QzoneAuthorizeConfig";
    private static QzoneAuthorizeConfig instance;
    private final ConcurrentHashMap<String, Set<String>> mJsApiBlackList = new ConcurrentHashMap<>();
    private String mJsApiBlackString = null;
    private final ConcurrentHashMap<String, Set<String>> mSchemaBlackList = new ConcurrentHashMap<>();
    private String mSchemaBlackString = null;

    public static QzoneAuthorizeConfig getInstance() {
        if (instance == null) {
            synchronized (QzoneAuthorizeConfig.class) {
                if (instance == null) {
                    instance = new QzoneAuthorizeConfig();
                }
            }
        }
        return instance;
    }

    private void getNewBlackList(String str, ConcurrentHashMap<String, Set<String>> concurrentHashMap) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONArray = new JSONArray(str);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Js Api Config JSONArray error!", e16);
                }
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                concurrentHashMap.clear();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(QZoneDTLoginReporter.SCHEMA);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(QZoneImageUtils.KEY_MATCH);
                    int length2 = optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        String optString = optJSONArray2.optString(i16);
                        Set<String> set = concurrentHashMap.get(optString);
                        if (set == null) {
                            set = new HashSet<>(20);
                        }
                        int length3 = optJSONArray.length();
                        for (int i17 = 0; i17 < length3; i17++) {
                            set.add(optJSONArray.optString(i17));
                        }
                        concurrentHashMap.put(optString, set);
                    }
                }
                return;
            }
            QLog.e(TAG, 1, "Js Api Config JSONArray From jsApiBlackString is empty");
            return;
        }
        QLog.e(TAG, 1, "get Js Api Config From jsApiBlackString is empty!");
    }

    public static boolean isDomainMatch(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if ("*".equals(str)) {
            return true;
        }
        if ("*.*".equals(str)) {
            if (str2.indexOf(46) == -1) {
                return false;
            }
            return true;
        }
        if (str.startsWith("*")) {
            return str2.endsWith(str.substring(1));
        }
        if (str.endsWith("*")) {
            return str2.startsWith(str.substring(0, str.length() - 1));
        }
        return str2.equals(str);
    }

    public boolean hasJsApiRight(String str, String str2) {
        Set<String> set;
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!scheme.equals("http") && !scheme.equals("https")) {
                return false;
            }
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_JSAPI_BLACK_LIST, "");
            if (!config.equals(this.mJsApiBlackString)) {
                getNewBlackList(config, this.mJsApiBlackList);
                this.mJsApiBlackString = config;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, this.mJsApiBlackString);
                }
            }
            if (this.mJsApiBlackList.size() == 0) {
                return true;
            }
            Set<String> keySet = this.mJsApiBlackList.keySet();
            if (keySet.size() == 0) {
                return true;
            }
            String host = parse.getHost();
            if (!TextUtils.isEmpty(host)) {
                host = host.toLowerCase();
            }
            for (String str3 : keySet) {
                if (isDomainMatch(str3, host) && (set = this.mJsApiBlackList.get(str3)) != null && set.size() != 0) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        if (isDomainMatch(it.next(), str2)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasJsApiRight()", e16);
            return true;
        }
    }

    public boolean hasSchemeRight(String str, String str2) {
        Set<String> set;
        try {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SCHEMA_BLACK_LIST, "");
            if (!config.equals(this.mSchemaBlackString)) {
                getNewBlackList(config, this.mSchemaBlackList);
                this.mSchemaBlackString = config;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, this.mSchemaBlackString);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasSchemeRight()", e16);
        }
        if (this.mSchemaBlackList.size() == 0) {
            return true;
        }
        Set<String> keySet = this.mSchemaBlackList.keySet();
        if (keySet.size() == 0) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        for (String str3 : keySet) {
            if (isDomainMatch(str3, lowerCase) && (set = this.mSchemaBlackList.get(str3)) != null && set.size() != 0) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    if (isDomainMatch(it.next(), str2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
