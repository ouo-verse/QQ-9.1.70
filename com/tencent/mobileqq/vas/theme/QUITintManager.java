package com.tencent.mobileqq.vas.theme;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.theme.api.QUITintHelper;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUITintManager implements ISkinTint {
    private static final String KEY_COLOR = "color";
    private static final String QUI_TOKEN_CONFIG = "qui_token_config.json";
    private static final String TAG = "QUITintManager";
    private static final String THEME_ID_NEW_NIGHT = "1";
    private static final String TOKEN_DEFAULT_SUFFIX = "_default";
    private static final String TOKEN_DISABLE_SUFFIX = "_disable";
    private static final String TOKEN_PRESSED_SUFFIX = "_pressed";
    private static final String TOKEN_SELECTOR_SUFFIX = "_selector";
    private static final String TOKEN_SUFFIX = ".xml";
    private static final List<String> sButtonTextToken;
    private static final Map<String, Pair<String, String>> sExtraToken;
    private static final List<String> sNeedAddPressedToken = Arrays.asList("qui_common_text_nav_primary.xml", "qui_common_text_nav_secondary.xml", "qui_common_text_primary.xml", "qui_common_text_primary_light.xml", "qui_common_text_secondary.xml", "qui_common_text_tertiary.xml", "qui_common_text_link.xml", "qui_common_icon_nav_primary.xml");
    private static final List<String> sNeedAddSelectorToken = Arrays.asList("qui_common_text_primary.xml", "qui_common_text_primary_light.xml", "qui_common_text_secondary.xml", "qui_common_text_tertiary.xml", "qui_common_text_link.xml", "qui_common_text_nav_primary.xml", "qui_common_text_nav_secondary.xml");
    public static volatile QUITintManager sQUITintManager;
    private String mAssetsMappingStr;
    private String mThemeId = "1";
    private Map<String, String> mTintColorMap;

    static {
        HashMap hashMap = new HashMap();
        sExtraToken = hashMap;
        hashMap.put("qui_common_bg_top_light_pressed.xml", new Pair("qui_common_bg_top_light.xml", "qui_common_overlay_standard_primary.xml"));
        hashMap.put("qui_common_fill_light_secondary_pressed.xml", new Pair("qui_common_fill_light_secondary.xml", "qui_common_overlay_standard_primary.xml"));
        hashMap.put("qui_common_fill_light_primary_stick.xml", new Pair("qui_common_fill_light_primary.xml", "qui_common_overlay_light.xml"));
        hashMap.put("qui_common_fill_light_primary_pressed.xml", new Pair("qui_common_fill_light_primary.xml", "qui_common_overlay_standard_primary.xml"));
        sButtonTextToken = Arrays.asList("qui_button_text_primary.xml", "qui_button_text_secondary.xml", "qui_button_text_error.xml", "qui_button_text_ghost.xml");
    }

    QUITintManager() {
    }

    private void addButtonTextToken(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : sButtonTextToken) {
            String replace = str.replace(TOKEN_SUFFIX, "_default.xml");
            String replace2 = str.replace(TOKEN_SUFFIX, "_pressed.xml");
            String replace3 = str.replace(TOKEN_SUFFIX, "_disable.xml");
            if (map.containsKey(replace) && map.containsKey(replace2) && map.containsKey(replace3)) {
                String str2 = map.get(replace2) + "," + map.get(replace2) + "," + map.get(replace3) + "," + map.get(replace);
                if (!TextUtils.isEmpty(str2)) {
                    map.put(str, str2);
                    QLog.i(TAG, 1, "addButtonTextToken, targetToken=" + str);
                }
            }
        }
    }

    private void addExtraColor(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Pair<String, String>> entry : sExtraToken.entrySet()) {
            String key = entry.getKey();
            Pair<String, String> value = entry.getValue();
            String str = (String) value.first;
            String str2 = (String) value.second;
            if (map.containsKey(str) && map.containsKey(str2)) {
                int colorWithOverlayColor = QUIUtil.getColorWithOverlayColor(Color.parseColor(map.get(str)), Color.parseColor(map.get(str2)));
                map.put(key, QUIUtil.toHexEncoding(colorWithOverlayColor));
                QLog.i(TAG, 1, "addExtraColor, targetColorToken=" + key + ", newColor=" + QUIUtil.toHexEncoding(colorWithOverlayColor));
            }
        }
    }

    private void addPressedAndSelectorToken(Map<String, String> map) {
        String str;
        if (map == null) {
            return;
        }
        for (String str2 : sNeedAddPressedToken) {
            if (map.containsKey(str2)) {
                int parseColor = Color.parseColor(map.get(str2));
                String replace = str2.replace(TOKEN_SUFFIX, "_pressed.xml");
                map.put(replace, QUIUtil.toHexEncoding(ColorUtils.setAlphaComponent(parseColor, 128)));
                QLog.i(TAG, 1, "AddPressedToken, targetColorToken=" + replace);
            }
        }
        for (String str3 : sNeedAddSelectorToken) {
            if (map.containsKey(str3)) {
                String str4 = map.get(str3);
                int parseColor2 = Color.parseColor(str4);
                String replace2 = str3.replace(TOKEN_SUFFIX, "_selector.xml");
                String hexEncoding = QUIUtil.toHexEncoding(ColorUtils.setAlphaComponent(parseColor2, 128));
                if ("qui_common_text_link.xml".equals(str3)) {
                    str = QUIUtil.toHexEncoding(ColorUtils.setAlphaComponent(parseColor2, 77)) + "," + hexEncoding + "," + str4;
                } else {
                    str = hexEncoding + "," + str4;
                }
                if (!TextUtils.isEmpty(str)) {
                    map.put(replace2, str);
                    QLog.i(TAG, 1, "AddSelectorToken, targetToken=" + replace2);
                }
            }
        }
    }

    public static QUITintManager instance() {
        if (sQUITintManager == null) {
            synchronized (QUITintManager.class) {
                if (sQUITintManager == null) {
                    sQUITintManager = new QUITintManager();
                }
            }
        }
        return sQUITintManager;
    }

    private void parseMapping(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(this.mThemeId);
            if (optJSONObject == null) {
                QLog.d(TAG, 1, "parseConfigFromJson, theme json is null");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("color");
            if (optJSONObject2 == null) {
                QLog.d(TAG, 1, "parseConfigFromJson, color json is null");
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, optJSONObject2.optString(str2));
            }
            addExtraColor(hashMap);
            addPressedAndSelectorToken(hashMap);
            addButtonTextToken(hashMap);
            this.mTintColorMap = hashMap;
        } catch (JSONException e16) {
            QLog.d(TAG, 1, "parseMapping, JSONException:" + e16);
        }
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    public Map<String, String> getCurrentTintColorMap() {
        return this.mTintColorMap;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        Map<String, String> map = this.mTintColorMap;
        if ((map != null && map.containsKey(str)) || QUITintHelper.INSTANCE.needTint(str, null)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        return true;
    }

    public void setThemeId(String str) {
        this.mTintColorMap = null;
        this.mThemeId = str;
        if (this.mAssetsMappingStr == null) {
            this.mAssetsMappingStr = k.b(BaseApplication.getContext().getAssets(), "qui_token_config.json");
        }
        parseMapping(this.mAssetsMappingStr);
    }

    public void setTokenMap(Map<String, String> map) {
        this.mTintColorMap = map;
        addExtraColor(map);
        addButtonTextToken(this.mTintColorMap);
        addPressedAndSelectorToken(this.mTintColorMap);
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        QUITintHelper.INSTANCE.tint(paint, str, null);
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        Map<String, String> map;
        String[] split;
        if (iArr != null && iArr.length > 0 && (map = this.mTintColorMap) != null && map.containsKey(str) && (split = this.mTintColorMap.get(str).split(",")) != null && split.length > 0) {
            for (int i3 = 0; i3 < split.length; i3++) {
                setColors(iArr, i3, Integer.valueOf(Color.parseColor(split[i3])));
            }
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
    }
}
