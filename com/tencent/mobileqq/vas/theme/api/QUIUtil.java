package com.tencent.mobileqq.vas.theme.api;

import android.graphics.Color;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qui.quitoken.QUITokenConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.theme.BusinessTintManager;
import com.tencent.mobileqq.vas.theme.QUITintManager;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIUtil {
    private static final String TAG = "QUIUtil";
    private static Map<String, String> defaultThemeTokenMap = null;
    private static volatile String sQuiTokenConfigContent = "";

    static {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.api.b
            @Override // java.lang.Runnable
            public final void run() {
                QUIUtil.lambda$static$0();
            }
        }, 16, null, false);
    }

    public static Map<String, String> filterQUIPrefix(Map<String, String> map) {
        String replace;
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.contains("qui_common_")) {
                    replace = key.replace("qui_common_", "");
                } else if (key.contains("qui_button_")) {
                    replace = key.replace("qui_", "");
                }
                hashMap.put(replace.replace(".xml", ""), value);
            }
        }
        return hashMap;
    }

    public static int getColorWithOverlayColor(int i3, int i16) {
        float alpha = Color.alpha(i3) / 255.0f;
        float alpha2 = Color.alpha(i16) / 255.0f;
        if (alpha == 0.0f && alpha2 == 0.0f) {
            return i3;
        }
        if (alpha == 0.0f) {
            return i16;
        }
        if (alpha2 == 0.0f) {
            return i3;
        }
        float red = Color.red(i3) * 1.0f;
        float green = Color.green(i3) * 1.0f;
        float f16 = 1.0f - alpha2;
        float f17 = 1.0f - ((1.0f - alpha) * f16);
        return ((int) ((((alpha2 * (Color.blue(i16) * 1.0f)) + ((f16 * (Color.blue(i3) * 1.0f)) * alpha)) / f17) + 0.5f)) | (((int) ((f17 * 255.0f) + 0.5f)) << 24) | (((int) (((((Color.red(i16) * 1.0f) * alpha2) + ((red * f16) * alpha)) / f17) + 0.5f)) << 16) | (((int) (((((Color.green(i16) * 1.0f) * alpha2) + ((green * f16) * alpha)) / f17) + 0.5f)) << 8);
    }

    public static Map<String, String> getCurrentTokenMap() {
        Map<String, String> currentTintColorMap;
        Map<String, String> filterQUIPrefix = filterQUIPrefix(getDefaultThemeTokenMap());
        if (QUITokenResUtil.isNowQUIDebugTheme()) {
            currentTintColorMap = QUITintManager.instance().getCurrentTintColorMap();
        } else if (QQTheme.isNowSimpleUI()) {
            currentTintColorMap = SimpleTintManager.instance().getCurrentTintColorMap();
        } else {
            currentTintColorMap = BusinessTintManager.instance().getCurrentTintColorMap();
        }
        overrideTokenMap(filterQUIPrefix, filterQUIPrefix(currentTintColorMap));
        return filterQUIPrefix;
    }

    public static Map<String, String> getDefaultThemeTokenMap() {
        Map<String, String> map = defaultThemeTokenMap;
        if (map != null && !map.isEmpty()) {
            return defaultThemeTokenMap;
        }
        String str = sQuiTokenConfigContent;
        if (TextUtils.isEmpty(str)) {
            try {
                str = k.a(BaseApplication.getContext(), QUITokenConstants.CONFIG_FILE_NAME);
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "getDefaultThemeTokenMap from assets, ", e16);
            }
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getDefaultThemeTokenMap, content is empty.");
            return new HashMap();
        }
        try {
            Map<String, String> parseHashMap = parseHashMap(new JSONObject(str).optJSONObject("1001").optJSONObject("color"));
            defaultThemeTokenMap = parseHashMap;
            return parseHashMap;
        } catch (Exception e17) {
            QLog.e(TAG, 1, "getDefaultThemeTokenMap error: ", e17);
            return new HashMap();
        }
    }

    public static boolean isDarkColor(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        if (((int) (fArr[2] * 100.0f)) <= 50) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
        if (ar.b("shouyouye", "2024-03-01", "vas_bug_121033513").isEnable(true) && TextUtils.isEmpty(sQuiTokenConfigContent)) {
            try {
                sQuiTokenConfigContent = k.a(BaseApplication.getContext(), QUITokenConstants.CONFIG_FILE_NAME);
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "static getDefaultThemeTokenMap from assets, ", e16);
            }
        }
    }

    private static void overrideTokenMap(Map<String, String> map, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (map.containsKey(key)) {
                map.put(key, value);
            }
        }
    }

    private static Map<String, String> parseHashMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.optString(str));
        }
        return hashMap;
    }

    public static void printQUITintConfig(String str, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            Map<String, String> filterQUIPrefix = filterQUIPrefix(map);
            if (filterQUIPrefix.size() <= 0) {
                return;
            }
            String str2 = str + "_QUITintConfig";
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : filterQUIPrefix.entrySet()) {
                String str3 = entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + " ";
                if (str3.length() + sb5.length() > 1024) {
                    QLog.i(str2, 1, sb5.toString());
                    sb5.setLength(0);
                }
                sb5.append(str3);
            }
            if (sb5.length() > 0) {
                QLog.i(str2, 1, sb5.toString());
            }
        }
    }

    public static String toHexEncoding(int i3) {
        StringBuilder sb5 = new StringBuilder();
        String hexString = Integer.toHexString(Color.alpha(i3));
        String hexString2 = Integer.toHexString(Color.red(i3));
        String hexString3 = Integer.toHexString(Color.green(i3));
        String hexString4 = Integer.toHexString(Color.blue(i3));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        sb5.append("#");
        if (!hexString.equals("FF")) {
            sb5.append(hexString);
        }
        sb5.append(hexString2);
        sb5.append(hexString3);
        sb5.append(hexString4);
        return sb5.toString();
    }
}
