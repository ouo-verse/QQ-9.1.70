package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.vas.theme.ThemeConfigItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes20.dex */
public class ThemeConfigParser {
    private static final String TAG = "ThemeConfigParser";

    private static void deleteConfigForSimpleException(String str, File file) {
        if (!QQTheme.isThemeSimpleUI(str)) {
            QLog.e(TAG, 1, "deleteConfigForSimpleException:: themeId: " + str + " is not SimpleUI, return");
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("simple_res_recheck_8988_116470726", true);
        if (isSwitchOn) {
            SimpleUIManager.resetFlagToRecheckRes();
            if (file.exists()) {
                QLog.e(TAG, 1, "deleteConfigForSimpleException:: parseConfig error, delete path: " + file.getAbsolutePath() + " success? " + file.delete() + ", themeId: " + str);
            }
        }
        QLog.e(TAG, 1, "deleteConfigForSimpleException:: parseConfig error, simpleResRecheck: " + isSwitchOn + ", themeId: " + str);
    }

    private static List<String> getConfigPathList(Context context) {
        String a16 = k.a(context, SkinConstants.SkinPathConstant.BUSINESS_CONFIG_PATH);
        if (a16 == null) {
            return null;
        }
        return parseConfigFromXml(a16, Xml.Encoding.UTF_8.name());
    }

    private static Map<String, String> getQUIExtraMap(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            parseJSONObject2Map(new JSONObject(k.a(context, "qui_private_token_mapping.json")).optJSONObject("color"), hashMap);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getQUIExtraMap error, ", e16);
        }
        return hashMap;
    }

    public static ThemeConfigItem parseBusinessConfig(Context context, String str) {
        List<String> configPathList = getConfigPathList(context);
        ThemeConfigItem themeConfigItem = null;
        if (configPathList != null && !configPathList.isEmpty()) {
            Iterator<String> it = configPathList.iterator();
            while (it.hasNext()) {
                ThemeConfigItem parseConfigItem = parseConfigItem(context, str, k.a(context, it.next()));
                if (themeConfigItem == null) {
                    themeConfigItem = parseConfigItem;
                } else {
                    themeConfigItem.mergeSameItem(parseConfigItem);
                }
            }
            if (themeConfigItem != null) {
                themeConfigItem.addQUIExtraMap(getQUIExtraMap(context));
            }
            return themeConfigItem;
        }
        QLog.e(TAG, 1, "parseBusinessConfig\uff0cconfig list null or empty, config list : ", configPathList);
        return null;
    }

    public static int parseColor(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse color error : ", e16);
            return i3;
        }
    }

    protected static List<String> parseConfigFromXml(String str, String str2) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(byteArrayInputStream, str2);
                ArrayList arrayList = new ArrayList();
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2 && SkinConstants.SkinPathConstant.TAG_CONFIG_PATH.equals(newPullParser.getName())) {
                        arrayList.add(newPullParser.nextText());
                    }
                }
                byteArrayInputStream.close();
                return arrayList;
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        } catch (IOException | XmlPullParserException e16) {
            QLog.e(TAG, 1, "parseConfigFromXml error : ", e16);
            return null;
        }
    }

    public static ThemeConfigItem parseConfigItem(Context context, String str, String str2) {
        ThemeConfigItem parseBusinessConfig;
        try {
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
            if (optJSONObject == null) {
                return null;
            }
            ThemeConfigItem themeConfigItem = new ThemeConfigItem();
            int parseColor = parseColor(optJSONObject.optString(SkinConstants.TintConstant.KEY_DEFAULT_COLOR), -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(SkinConstants.TintConstant.KEY_TEXT_PLIST);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(SkinConstants.TintConstant.KEY_DRAWABLE_LIST);
            JSONArray optJSONArray = optJSONObject.optJSONArray(SkinConstants.TintConstant.KEY_LINKED_CONFIGS);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            parseJSONObject2Map(optJSONObject2, hashMap);
            parseJSONObject2Map(optJSONObject3, hashMap2);
            List<ThemeConfigItem.LinkedConfig> parseLinkedConfig = parseLinkedConfig(optJSONArray);
            themeConfigItem.setLinkedConfigs(parseLinkedConfig);
            themeConfigItem.setDefaultColor(parseColor);
            themeConfigItem.setThemeId(str);
            themeConfigItem.setTintColorMap(hashMap);
            themeConfigItem.setTintDrawableMap(hashMap2);
            if (parseLinkedConfig != null) {
                for (ThemeConfigItem.LinkedConfig linkedConfig : parseLinkedConfig) {
                    int linkedType = linkedConfig.getLinkedType();
                    if (linkedType == 1 || linkedType == 2) {
                        String linkedName = linkedConfig.getLinkedName();
                        if (linkedName != null) {
                            if (linkedType == 2) {
                                parseBusinessConfig = parseSimpleConfig(context, linkedName);
                            } else {
                                parseBusinessConfig = parseBusinessConfig(context, linkedName);
                            }
                            themeConfigItem.mergeLinkedItem(parseBusinessConfig);
                        }
                    }
                }
            }
            return themeConfigItem;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse config item error : ", e16);
            return null;
        }
    }

    private static void parseJSONObject2Map(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && map != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                map.put(str, jSONObject.optString(str));
            }
        }
    }

    public static List<ThemeConfigItem.LinkedConfig> parseLinkedConfig(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                int optInt = optJSONObject.optInt(SkinConstants.TintConstant.KEY_LINKED_TYPE);
                String optString = optJSONObject.optString(SkinConstants.TintConstant.KEY_LINKED_NAME);
                ThemeConfigItem.LinkedConfig linkedConfig = new ThemeConfigItem.LinkedConfig();
                linkedConfig.setLinkedName(optString);
                linkedConfig.setLinkedType(optInt);
                arrayList.add(linkedConfig);
            }
            return arrayList;
        }
        return null;
    }

    public static ThemeConfigItem parseSimpleConfig(Context context, String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "start parseSimpleConfig");
        }
        String localPath = SimpleUIManager.getLocalPath(context);
        if ("2920".equals(str)) {
            str2 = SkinConstants.SkinPathConstant.SIMPLE_NIGHT_CONFIG_NAME;
        } else {
            str2 = "config.json";
        }
        File file = new File(localPath, str2);
        try {
            ThemeConfigItem parseConfigItem = parseConfigItem(context, str, FileUtils.readFileContent(file));
            if (parseConfigItem == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(TAG, 1, "parseConfigItem error, themeConfigItem is null!!!");
                }
                deleteConfigForSimpleException(str, file);
                return null;
            }
            parseConfigItem.addQUIExtraMap(getQUIExtraMap(context));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "color map size : ", Integer.valueOf(parseConfigItem.getTintColorMap().size()));
                QLog.d(TAG, 1, "drawable map size : ", Integer.valueOf(parseConfigItem.getTintDrawableMap().size()));
            }
            return parseConfigItem;
        } catch (Exception e16) {
            deleteConfigForSimpleException(str, file);
            QLog.e(TAG, 1, "parseConfig error, themeId: " + str + ", exception: ", e16);
            SimpleUIManager.deleteSkinRootPath(BaseApplication.getContext());
            return null;
        }
    }

    public static String parseThemeIdFromPath(String str) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "start parseThemeIdFromPath, path : ", str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith("config.json")) {
            str = str.substring(0, str.length() - 11);
        }
        String str3 = File.separator;
        if (str.endsWith(str3)) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.contains(QQTheme.INTERNAL_THEME_DIR_810)) {
            String[] simpleSplitStr = simpleSplitStr(str, str3.charAt(0));
            if (simpleSplitStr.length >= 3) {
                str2 = simpleSplitStr[simpleSplitStr.length - 3];
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        } else {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (!TextUtils.isEmpty(substring)) {
                String[] split = substring.split("_");
                if (split.length == 2) {
                    return split[0];
                }
            }
        }
        return null;
    }

    private static int parseXmlColor(String str, int i3) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            int identifier = BaseApplication.getContext().getResources().getIdentifier(str.replace(".xml", ""), "color", context.getPackageName());
            if (identifier > 0) {
                return SkinEngine.getInstances().getColor(identifier);
            }
        }
        return i3;
    }

    private static String[] simpleSplitStr(String str, char c16) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(c16);
        simpleStringSplitter.setString(str);
        ArrayList arrayList = new ArrayList();
        Iterator it = simpleStringSplitter.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static int parseColor(String str, int i3, int i16) {
        try {
            if (str.contains(".xml")) {
                return parseXmlColor(str, i16);
            }
            return TextUtils.isEmpty(str) ? i3 : Color.parseColor(str);
        } catch (Exception unused) {
            return i16;
        }
    }
}
