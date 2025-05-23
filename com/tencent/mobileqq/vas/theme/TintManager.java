package com.tencent.mobileqq.vas.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import xy2.d;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TintManager implements ISkinTint {
    private static final String TAG = "TintManager";
    public static volatile TintManager sTintManager;
    private static boolean tokenBugFix = new UnitedProxy("vas_theme_fix_plate_config", true).isEnable(false);
    private JSONArray forbidden;
    private JSONObject mapping;
    private JSONObject plate;
    private final HashMap<String, Boolean> mForbiddenMap = new HashMap<>();
    private String assetsMappingStr = "";
    private String cloudExtraMappingStr = "";

    TintManager() {
    }

    private void addExtraMapping(String str, Resources resources) {
        if (TextUtils.isEmpty(this.cloudExtraMappingStr)) {
            this.cloudExtraMappingStr = k.b(resources.getAssets(), "theme_mapping_extra.json");
        }
        if (this.mapping != null && !TextUtils.isEmpty(this.cloudExtraMappingStr)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.cloudExtraMappingStr).optJSONObject("mapping");
                if (optJSONObject == null) {
                    return;
                }
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String optString = optJSONObject.optString(str2);
                    if (!TextUtils.isEmpty(optString) && !this.mapping.has(str2)) {
                        try {
                            this.mapping.putOpt(str2, optString);
                            if (QLog.isColorLevel()) {
                                QLog.w(TAG, 2, "addMappingIfEmpty:" + str2 + "," + optString);
                            }
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
                if (QQTheme.isNowThemeIsDIY(str)) {
                    try {
                        if (!QQTheme.isBaseDIYTheme(str)) {
                            this.mapping.putOpt("skin_background.png", "B1");
                            this.mapping.putOpt("skin_background_theme_version2.png", "B1");
                        }
                        this.mapping.putOpt("qui_common_fill_light_primary.xml", "B3*0.1");
                        this.mapping.putOpt("qui_common_fill_light_primary_stick.xml", "B3*0.4");
                        this.mapping.putOpt("qq_setting_item_bg_nor.xml", "B3*0");
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
            } catch (JSONException e18) {
                QLog.e(TAG, 1, "addExtraMapping error", e18);
            }
        }
    }

    private int blendWithMaskColor(int i3, int i16) {
        int alphaComponent;
        if (isBlackColor(i3)) {
            alphaComponent = ColorUtils.setAlphaComponent(-1, i16);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(-16777216, i16);
        }
        return ColorUtils.blendARGB(i3, alphaComponent, 0.5f);
    }

    private int blendWithMaskColorNew(int i3, float f16, boolean z16) {
        int alphaComponent;
        int intValue = Float.valueOf(f16 * 255.0f).intValue();
        if (z16) {
            alphaComponent = ColorUtils.setAlphaComponent(-1, intValue);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(-16777216, intValue);
        }
        return getColorWithOverlayColor(i3, alphaComponent);
    }

    private String calculateBackgroundColor(String str, String str2) {
        String str3 = "vas_palette_theme5_" + str;
        String decodeString = VasMMKV.getCommon().decodeString(str3, "");
        String str4 = "vas_palette_theme_text5_" + str;
        String decodeString2 = VasMMKV.getCommon().decodeString(str4, "");
        String str5 = "vas_palette_theme_text_t5_" + str;
        String decodeString3 = VasMMKV.getCommon().decodeString(str5, "");
        if (!TextUtils.isEmpty(decodeString2)) {
            overrideTextColor(decodeString2, decodeString3);
        }
        if (!TextUtils.isEmpty(decodeString)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "calculateBackgroundColor use cache color:" + decodeString);
            }
            return decodeString;
        }
        return doPaletteColor(str, str2, str4, str5, str3);
    }

    private String calculateBackgroundDefaultColor() {
        Integer plateColor = getPlateColor("T1");
        if (plateColor != null && isBlackColor(plateColor.intValue())) {
            return toHexEncoding(-1);
        }
        return "#7f7f7f";
    }

    private String colorHexAddMask(String str, float f16) {
        return toHexEncoding(blendWithMaskColorNew(Color.parseColor(str), f16, isBlackColor(Color.parseColor(str))));
    }

    private int computeNegationColor(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        int i16 = (int) (fArr[1] * 100.0f);
        int i17 = (int) (fArr[2] * 100.0f);
        if (i16 < 40 && i17 > 60) {
            return -16777216;
        }
        return -1;
    }

    private void copyPlateForOldVasTheme(String str, Resources resources, String str2) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(str) && QQTheme.isVasTheme(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !handleBaseDIYTheme(str)) {
            File parentFile = new File(str2).getParentFile();
            copySkinBackgroundFile(parentFile);
            JSONObject jSONObject = this.plate;
            if (jSONObject != null) {
                if (TextUtils.isEmpty(jSONObject.optString("A1", "")) || TextUtils.isEmpty(this.plate.optString("B1", "")) || TextUtils.isEmpty(this.plate.optString("C1", ""))) {
                    z17 = true;
                }
                if (z17 && parentFile != null) {
                    String absolutePath = parentFile.getAbsolutePath();
                    overrideColor(this.plate, absolutePath, "A1", R.color.skin_black_theme_version2, "#4D4D4D");
                    overrideColor(this.plate, absolutePath, NowProxyConstants.AccountInfoKey.A2, R.color.skin_bar_text, "#FFFFFF");
                    overrideColor(this.plate, absolutePath, "A3", R.color.skin_gray2_theme_version2, "#999999");
                    overrideColor(this.plate, absolutePath, "A4", R.color.skin_bar_text, "#CCCCCC");
                    if (VasNormalToggle.VAS_THEME_BUG_115515807.isEnable(true) && QQTheme.isBaseDIYTheme(str)) {
                        removePlateColor(this.plate, "A1");
                        removePlateColor(this.plate, "A4");
                    }
                    overrideColor(this.plate, absolutePath, "A6", R.color.skin_color_tab_simple_selected, "#0099FF");
                    overrideColor(this.plate, absolutePath, "T1", R.color.skin_input_theme_version2, "#000000");
                    overrideColor(this.plate, absolutePath, "T2", R.color.skin_gray2_theme_version2, "#8C8C8C");
                    overrideColor(this.plate, absolutePath, "T3", R.color.skin_hint_input_theme_version2, "#CCCCCC");
                    overrideColor(this.plate, absolutePath, "T4", R.color.skin_bar_text, "#FFFFFF");
                    overrideColor(this.plate, absolutePath, "T5", R.color.skin_chat_buble_link, "#000000");
                    overrideColor(this.plate, absolutePath, "T6", R.color.skin_chat_buble_link_mine, "#2D77E5");
                    overrideColor(this.plate, absolutePath, "T7", R.color.skin_chat_buble, "#000000");
                    overrideColor(this.plate, absolutePath, "T8", R.color.skin_chat_buble_mine, "#FFFFFF");
                    overrideColor(this.plate, absolutePath, "T9", R.color.skin_aio_input_button, "#000000");
                    overrideBackgroundColor(str, calculateBackgroundColor(str, absolutePath));
                    addExtraMapping(str, resources);
                    return;
                }
                try {
                    Integer plateColor = getPlateColor("B1");
                    Integer plateColor2 = getPlateColor("B3");
                    if (plateColor != null && plateColor2 != null && plateColor.intValue() == plateColor2.intValue()) {
                        this.plate.put("B3", colorHexAddMask(toHexEncoding(plateColor.intValue()), 0.12f));
                        QLog.i(TAG, 1, "overrideBackgroundColor b3");
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "plate error", e16);
                }
            }
        }
    }

    private static void copySkinBackgroundFile(File file) {
        if (!new File(file, "drawable-xxhdpi/skin_background.png").exists() && !new File(file, "drawable-xhdpi/skin_background.png").exists()) {
            if (new File(file, "drawable-xxhdpi/skin_background_theme_version2.png").exists()) {
                QLog.i(TAG, 2, "copy drawable-xxhdpi/skin_background_theme_version2.png");
                FileUtils.copyFile(new File(file, "drawable-xxhdpi/skin_background_theme_version2.png"), new File(file, "drawable-xxhdpi/skin_background.png"));
            } else if (new File(file, "drawable-xhdpi/skin_background_theme_version2.png").exists()) {
                QLog.i(TAG, 2, "copy drawable-xhdpi/skin_background_theme_version2.png");
                FileUtils.copyFile(new File(file, "drawable-xhdpi/skin_background_theme_version2.png"), new File(file, "drawable-xhdpi/skin_background.png"));
            }
        }
    }

    private String doPaletteColor(String str, String str2, String str3, String str4, String str5) {
        int i3;
        String str6;
        String findPathByName;
        int parseColor;
        char c16;
        String hexEncoding;
        String hexEncoding2;
        String calculateBackgroundDefaultColor = calculateBackgroundDefaultColor();
        if ("999".equals(str)) {
            return calculateBackgroundDefaultColor;
        }
        try {
            String str7 = File.separator;
            if (str2.endsWith(str7)) {
                str6 = "";
            } else {
                str6 = str2 + str7;
            }
            if (QQTheme.isNowThemeIsDIY(str)) {
                findPathByName = findPathByName(str6, "skin_header_bar_bg.9.png");
                QLog.d(TAG, 1, "calculateBackgroundColor use diy res");
            } else {
                findPathByName = findPathByName(str6, "skin_background.png");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 4;
            Bitmap decodeFile = BitmapFactory.decodeFile(findPathByName, options);
            try {
                if (decodeFile != null) {
                    d b16 = new d.b(decodeFile).a().b();
                    if (decodeFile.getWidth() > 0 && decodeFile.getHeight() > 0) {
                        parseColor = decodeFile.getPixel(0, 0);
                    } else {
                        parseColor = Color.parseColor(calculateBackgroundDefaultColor);
                    }
                    String hexEncoding3 = toHexEncoding(b16.i(parseColor));
                    d.C11578d j3 = b16.j();
                    if (j3 != null) {
                        if (QQTheme.isNowThemeIsDIY(str)) {
                            if (!isBlackColor(j3.b())) {
                                hexEncoding = toHexEncoding(blendWithMaskColorNew(j3.b(), 0.5f, false));
                                hexEncoding2 = toHexEncoding(blendWithMaskColorNew(j3.f(), 0.5f, false));
                            } else {
                                hexEncoding = toHexEncoding(j3.b());
                                hexEncoding2 = toHexEncoding(j3.f());
                            }
                            String str8 = hexEncoding2;
                            VasMMKV.getCommon().encodeString(str3, overrideColor(this.plate, str2, "T1", R.color.skin_black_theme_version2, hexEncoding));
                            VasMMKV.getCommon().encodeString(str4, overrideColor(this.plate, str2, "T2", R.color.skin_gray2_theme_version2, str8));
                        } else {
                            String hexEncoding4 = toHexEncoding(j3.b());
                            VasMMKV.getCommon().encodeString(str3, hexEncoding4);
                            overrideTextColor(hexEncoding4, "");
                        }
                    }
                    switch (str.hashCode()) {
                        case 1448635040:
                            if (str.equals("100001")) {
                                c16 = 0;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1448635042:
                            if (str.equals("100003")) {
                                c16 = 1;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1448635047:
                            if (str.equals("100008")) {
                                c16 = 2;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1448635104:
                            if (str.equals("100023")) {
                                c16 = 3;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1448635108:
                            if (str.equals("100027")) {
                                c16 = 4;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        case 1448635133:
                            if (str.equals("100031")) {
                                c16 = 5;
                                break;
                            }
                            c16 = '\uffff';
                            break;
                        default:
                            c16 = '\uffff';
                            break;
                    }
                    if (c16 != 0) {
                        if (c16 != 1) {
                            if (c16 != 2) {
                                if (c16 != 3) {
                                    if (c16 != 4) {
                                        if (c16 == 5) {
                                            hexEncoding3 = "#FFFFF0";
                                        }
                                    } else {
                                        hexEncoding3 = "#4169E1";
                                    }
                                } else {
                                    hexEncoding3 = "#B0E2FF";
                                }
                            } else {
                                hexEncoding3 = "#CD9B9B";
                            }
                        } else {
                            hexEncoding3 = "#EEA9B8";
                        }
                    } else {
                        hexEncoding3 = "#BDB76B";
                    }
                    String str9 = hexEncoding3;
                    QLog.d(TAG, 1, "calculateBackgroundColor palette dominant color:" + str9);
                    VasMMKV.getCommon().encodeString(str5, str9);
                    decodeFile.recycle();
                    return str9;
                }
                QLog.d(TAG, 1, "calculateBackgroundColor null bitmap:" + str2);
                return calculateBackgroundDefaultColor;
            } catch (Exception e16) {
                e = e16;
                i3 = 0;
                QLog.e(TAG, 1, e, new Object[i3]);
                return calculateBackgroundDefaultColor;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
    }

    private void doTint(Paint paint, String str, JSONObject jSONObject) {
        String str2;
        int resourceIdByName;
        String optString = jSONObject.optString(str);
        if (!TextUtils.isEmpty(optString)) {
            if (str.contains(".")) {
                str2 = str.split("\\.")[0];
            } else {
                str2 = str;
            }
            if (BaseApplication.getContext() != null && (resourceIdByName = getResourceIdByName(str2, "drawable")) > 0 && SkinEngine.getInstances().checkResExist(resourceIdByName)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "checkResExist fileName:" + str);
                    return;
                }
                return;
            }
            if (optString.contains(",")) {
                String[] split = optString.split("\\,");
                int length = split.length;
                for (int i3 = 0; i3 < length && !tintByPlateColor(paint, split[i3]); i3++) {
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "plateName:" + optString + " fileName:" + str);
            }
            tintByPlateColor(paint, optString);
        }
    }

    private String findPathByName(String str, String str2) {
        String str3 = str + "drawable-xxhdpi/" + str2;
        if (!new File(str3).exists()) {
            String str4 = str + "drawable-xhdpi/" + str2;
            if (!new File(str4).exists()) {
                String str5 = str + "drawable-hdpi/" + str2;
                if (!new File(str5).exists()) {
                    return str + "drawable-mdpi/" + str2;
                }
                return str5;
            }
            return str4;
        }
        return str3;
    }

    private static int getColorWithOverlayColor(int i3, int i16) {
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

    private int getResourceIdByName(String str, String str2) {
        return BaseApplication.getContext().getResources().getIdentifier(str, str2, BaseApplication.getContext().getPackageName());
    }

    private boolean handleBaseDIYTheme(String str) {
        if (!QQTheme.isBaseDIYTheme(str)) {
            return false;
        }
        try {
            if (this.plate == null) {
                this.plate = new JSONObject();
            }
            this.plate.put("C1", "#FFFFFF");
            this.plate.put("X1", "#FFFFFF");
            if (this.mapping == null) {
                this.mapping = new JSONObject();
            }
            this.mapping.putOpt("qui_common_fill_light_primary.xml", "X1*0.1");
            this.mapping.putOpt("qui_common_fill_light_primary_stick.xml", "X1*0.4");
            this.mapping.putOpt("qq_setting_item_bg_nor.xml", "X1*0");
            QLog.i(TAG, 1, "handleBaseDIYTheme");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return true;
    }

    public static TintManager instance() {
        if (sTintManager == null) {
            synchronized (TintManager.class) {
                if (sTintManager == null) {
                    sTintManager = new TintManager();
                }
            }
        }
        return sTintManager;
    }

    private boolean isBlackColor(int i3) {
        if (Math.max(Color.red(i3), Math.max(Color.green(i3), Color.blue(i3))) < 127) {
            return true;
        }
        return false;
    }

    private void mappingOverride(JSONObject jSONObject, JSONObject jSONObject2, boolean z16) {
        if (jSONObject2 == null) {
            return;
        }
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String optString = jSONObject2.optString(str);
            if (!TextUtils.isEmpty(optString)) {
                if (z16) {
                    String optString2 = jSONObject.optString(str);
                    if (!TextUtils.isEmpty(optString2)) {
                        optString = optString + "," + optString2;
                    }
                    try {
                        jSONObject.putOpt(str, optString);
                    } catch (JSONException e16) {
                        QLog.e(TAG, 1, e16, new Object[0]);
                    }
                } else {
                    try {
                        jSONObject.putOpt(str, optString);
                    } catch (JSONException e17) {
                        QLog.e(TAG, 1, e17, new Object[0]);
                    }
                }
            }
        }
    }

    private void overrideBackgroundColor(String str, String str2) {
        try {
            if ("999".equals(str)) {
                str2 = toHexEncoding(blendWithMaskColorNew(Color.parseColor(str2), 0.6f, true));
            }
            this.plate.put("B1", str2);
            this.plate.put("B2", colorHexAddMask(str2, 0.05f));
            this.plate.put("B3", colorHexAddMask(str2, 0.12f));
            this.plate.put("B4", str2);
            this.plate.put("B5", colorHexAddMask(str2, 0.23f));
            this.plate.put("B6", colorHexAddMask(str2, 0.28f));
            this.plate.put("C1", colorHexAddMask(str2, 0.1f));
            this.plate.put("C2", colorHexAddMask(str2, 0.2f));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "overrideBackgroundColor " + str2);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private String overrideColor(JSONObject jSONObject, String str, String str2, int i3, String str3) {
        SkinnableColorStateList skinnableColorStateList;
        if (SkinEngine.getInstances().checkResExist(i3)) {
            skinnableColorStateList = SkinEngine.getInstances().loadColorForTheme(i3, str);
        } else {
            skinnableColorStateList = null;
        }
        if (skinnableColorStateList != null) {
            try {
                String hexEncoding = toHexEncoding(skinnableColorStateList.getDefaultColor());
                jSONObject.put(str2, hexEncoding);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "overrideColor " + str2 + " to " + hexEncoding);
                }
                return hexEncoding;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        try {
            jSONObject.put(str2, str3);
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "overrideColor " + str2 + " to default(" + str3 + ")");
            }
        } catch (JSONException e17) {
            QLog.e(TAG, 1, e17, new Object[0]);
        }
        return str3;
    }

    private void overrideData(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("mapping");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("plate");
                JSONArray optJSONArray = jSONObject.optJSONArray("forbidden");
                if (tokenBugFix) {
                    mappingOverride(this.mapping, optJSONObject, false);
                } else {
                    mappingOverride(this.mapping, optJSONObject, true);
                }
                mappingOverride(this.plate, optJSONObject2, false);
                if (optJSONArray != null) {
                    this.forbidden = optJSONArray;
                    for (int i3 = 0; i3 < this.forbidden.length(); i3++) {
                        this.mForbiddenMap.put(this.forbidden.optString(i3), Boolean.TRUE);
                    }
                }
            }
        } catch (JSONException e16) {
            VasLogReporter.getTheme().report("TintManager overrideData error");
            QLog.e(TAG, 1, "overrideData error", e16);
        }
    }

    private void overrideTextColor(String str, String str2) {
        try {
            this.plate.put("T1", str);
            if (!TextUtils.isEmpty(str2)) {
                this.plate.put("T2", str2);
            }
            QLog.w(TAG, 1, "overrideTextColor t1" + str + ",t2=" + str2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void parseLocalData(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.mapping = jSONObject.optJSONObject("mapping");
                this.plate = jSONObject.optJSONObject("plate");
            }
        } catch (JSONException e16) {
            VasLogReporter.getTheme().report("TintManager parseLocalData error");
            QLog.e(TAG, 1, "parseLocalData error", e16);
        }
        if (this.mapping == null) {
            this.mapping = new JSONObject();
        }
        if (this.plate == null) {
            this.plate = new JSONObject();
        }
    }

    private void removePlateColor(JSONObject jSONObject, String str) {
        try {
            jSONObject.remove(str);
            QLog.w(TAG, 1, "removePlateColor:" + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    private boolean tintByPlateColor(Paint paint, String str) {
        String replace;
        int resourceIdByName;
        Integer plateColor;
        if (this.plate != null && (plateColor = getPlateColor(str)) != null && paint != null) {
            paint.setColorFilter(new LightingColorFilter(0, plateColor.intValue()));
            return true;
        }
        if (BaseApplication.getContext() != null && str.contains(".xml") && (resourceIdByName = getResourceIdByName((replace = str.replace(".xml", "")), "color")) > 0) {
            int color = SkinEngine.getInstances().getColor(resourceIdByName);
            if (paint != null) {
                paint.setColorFilter(new LightingColorFilter(0, color));
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" skin_bar_textcolorName:");
                    sb5.append(replace);
                    sb5.append(" colorId:");
                    sb5.append(resourceIdByName);
                    sb5.append(" rgbColor:");
                    int i3 = 16777215 - color;
                    sb5.append(Integer.toString(i3, 16));
                    sb5.append(" ");
                    sb5.append(Integer.toHexString(i3));
                    sb5.append(" ");
                    sb5.append(color);
                    QLog.i(TAG, 1, sb5.toString());
                }
                return true;
            }
        }
        return false;
    }

    @NotNull
    private String toHexEncoding(int i3) {
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

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        this.mapping = null;
        this.plate = null;
        this.mForbiddenMap.clear();
    }

    public Map<String, String> getCurrentQUITokenMap() {
        Integer plateColor;
        if (this.mapping != null && this.plate != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = this.mapping;
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str.contains("qui_") && !jSONObject.optString(str).contains(",") && (plateColor = getPlateColor(jSONObject.optString(str))) != null) {
                        hashMap.put(str, toHexEncoding(plateColor.intValue()));
                    }
                }
                return hashMap;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getCurrentQUITokenMap error: ", e16);
            }
        }
        return null;
    }

    public Integer getPlateColor(String str) {
        JSONObject jSONObject;
        Integer valueOf;
        Integer valueOf2;
        if (TextUtils.isEmpty(str) || (jSONObject = this.plate) == null) {
            return null;
        }
        String optString = jSONObject.optString(str.split("[*+!]")[0]);
        if (!TextUtils.isEmpty(optString)) {
            try {
                valueOf = Integer.valueOf(Color.parseColor(optString));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return null;
            }
        } else {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        if (str.contains("*")) {
            int parseFloat = (int) (Float.parseFloat(str.split("[*]")[1]) * 255.0f);
            if (parseFloat == 0) {
                return 0;
            }
            if (parseFloat > 0 && parseFloat < 255) {
                valueOf2 = Integer.valueOf(ColorUtils.setAlphaComponent(valueOf.intValue(), parseFloat));
            } else {
                return valueOf;
            }
        } else if (str.contains(Marker.ANY_NON_NULL_MARKER)) {
            int parseFloat2 = (int) (Float.parseFloat(str.split("[+]")[1]) * 255.0f);
            if (parseFloat2 > 0 && parseFloat2 < 255) {
                valueOf2 = Integer.valueOf(blendWithMaskColor(valueOf.intValue(), parseFloat2));
            } else {
                return valueOf;
            }
        } else {
            if (str.contains("!")) {
                return Integer.valueOf(computeNegationColor(valueOf.intValue()));
            }
            return valueOf;
        }
        return valueOf2;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        JSONObject jSONObject = this.mapping;
        if (this.mForbiddenMap.get(str) != null || jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString(str));
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
        SimpleTintManager.instance().clear();
        long currentTimeMillis = System.currentTimeMillis();
        clear();
        try {
            if (TextUtils.isEmpty(this.assetsMappingStr)) {
                this.assetsMappingStr = k.b(resources.getAssets(), "theme_mapping.json");
            }
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "skinFilePath " + str);
                }
                File file = new File(str);
                if (file.exists()) {
                    str2 = FileUtils.readFileContent(file);
                }
            }
            this.forbidden = null;
            this.mForbiddenMap.clear();
            parseLocalData(this.assetsMappingStr);
            overrideData(str2);
            String parseThemeIdFromPath = ThemeConfigParser.parseThemeIdFromPath(str);
            copyPlateForOldVasTheme(parseThemeIdFromPath, resources, str);
            String optString = VasLongToggle.THEME_FIX_PLATE_CONFIG.getJson().optString(parseThemeIdFromPath);
            if (!TextUtils.isEmpty(optString)) {
                overrideData(optString);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "loadConfig elapse:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "loadConfig error skinFilePath:" + str, e16);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        JSONObject jSONObject = this.mapping;
        if (jSONObject != null && paint != null && !TextUtils.isEmpty(str)) {
            if (this.forbidden != null) {
                for (int i3 = 0; i3 < this.forbidden.length(); i3++) {
                    if (str.equals(this.forbidden.optString(i3))) {
                        return;
                    }
                }
            }
            doTint(paint, str, jSONObject);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        JSONObject jSONObject = this.mapping;
        if (iArr != null && iArr.length > 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            String optString = jSONObject.optString(str);
            if (optString.contains(",")) {
                String[] split = optString.split("\\,");
                for (int i3 = 0; i3 < split.length; i3++) {
                    setColors(iArr, i3, getPlateColor(split[i3]));
                }
                return;
            }
            if (!TextUtils.isEmpty(optString)) {
                setColors(iArr, 0, getPlateColor(optString));
            }
        }
    }
}
