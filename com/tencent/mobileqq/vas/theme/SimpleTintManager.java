package com.tencent.mobileqq.vas.theme;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.QUITintHelper;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinTint;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SimpleTintManager implements ISkinTint {
    private static final String TAG = "SimpleTintManager";
    private static volatile SimpleTintManager sTintManager;
    protected String mThemeId;
    private int mThemeColor = -1;
    protected Map<String, String> mTintDrawableNames = new HashMap();
    protected Map<String, String> mCustomColorMap = new HashMap();

    SimpleTintManager() {
        parseConfig();
    }

    public static SimpleTintManager instance() {
        if (sTintManager == null) {
            synchronized (SimpleTintManager.class) {
                if (sTintManager == null) {
                    sTintManager = new SimpleTintManager();
                }
            }
        }
        return sTintManager;
    }

    private int parseColor(String str) {
        return parseColor(str, -1);
    }

    private void parseConfig() {
        if (this.mThemeId == null) {
            QLog.d(TAG, 1, "mThemeId is null, reinit");
            this.mThemeId = QQTheme.getCurrentThemeId();
        }
        String str = this.mThemeId;
        if (str == null) {
            QLog.d(TAG, 1, "mThemeId is null");
            return;
        }
        if (!QQTheme.isThemeSimpleUI(str)) {
            QLog.d(TAG, 1, "not simple ui, mThemeId is : ", this.mThemeId);
            return;
        }
        ThemeConfigItem parseSimpleConfig = ThemeConfigParser.parseSimpleConfig(BaseApplication.getContext(), this.mThemeId);
        if (parseSimpleConfig == null) {
            return;
        }
        this.mTintDrawableNames = parseSimpleConfig.getTintDrawableMap();
        this.mCustomColorMap = parseSimpleConfig.getTintColorMap();
        this.mThemeColor = parseSimpleConfig.getDefaultColor();
        QLog.i(TAG, 1, "current theme id is : " + this.mThemeId);
        QUIUtil.printQUITintConfig(TAG, this.mCustomColorMap);
    }

    private int parseXmlColor(String str, int i3) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            int identifier = BaseApplication.getContext().getResources().getIdentifier(str.replace(".xml", ""), "color", context.getPackageName());
            if (identifier > 0) {
                return SkinEngine.getInstances().getColor(identifier);
            }
        }
        return i3;
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    public void checkSkinEngineInit() {
        if (VasNormalToggle.VAS_THEME_INIT_BACK_TOOL.isEnable(false)) {
            return;
        }
        if ((QQTheme.isNowSimpleUI() || QQTheme.isNowThemeDefaultNight()) && !SimpleUIManager.skinInitFinish()) {
            SimpleUIManager.initSkinEngine();
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        this.mCustomColorMap.clear();
        this.mTintDrawableNames.clear();
        this.mThemeId = null;
    }

    public Map<String, String> getCurrentTintColorMap() {
        return this.mCustomColorMap;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        if (!this.mTintDrawableNames.containsKey(str) && !this.mCustomColorMap.containsKey(str) && !QUITintHelper.INSTANCE.needTint(str, this.mThemeId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
        TintManager.instance().clear();
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        return true;
    }

    public void setThemeId(String str) {
        QLog.d(TAG, 1, "set theme id : ", str);
        clear();
        this.mThemeId = str;
        parseConfig();
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        int parseColor;
        if (paint == null || TextUtils.isEmpty(str) || !isTint(str) || QUITintHelper.INSTANCE.tint(paint, str, this.mThemeId)) {
            return;
        }
        String str2 = this.mTintDrawableNames.get(str);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "tint filename is : " + str, " color : ", str2);
        }
        if (TextUtils.isEmpty(str2)) {
            parseColor = this.mThemeColor;
        } else {
            parseColor = parseColor(str2);
        }
        paint.setColorFilter(new LightingColorFilter(0, parseColor));
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        int parseColor;
        int parseColor2;
        if (iArr == null || iArr.length == 0 || this.mCustomColorMap.isEmpty() || TextUtils.isEmpty(str) || !this.mCustomColorMap.containsKey(str)) {
            return;
        }
        String str2 = this.mCustomColorMap.get(str);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "tint color filename is : " + str, " color : ", str2);
        }
        if (str2.contains(",")) {
            String[] split = str2.split(",");
            for (int i3 = 0; i3 < split.length; i3++) {
                if (TextUtils.isEmpty(split[i3])) {
                    parseColor2 = this.mThemeColor;
                } else {
                    parseColor2 = parseColor(split[i3]);
                }
                setColors(iArr, i3, Integer.valueOf(parseColor2));
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            parseColor = this.mThemeColor;
        } else {
            parseColor = parseColor(str2);
        }
        setColors(iArr, 0, Integer.valueOf(parseColor));
    }

    private int parseColor(String str, int i3) {
        try {
            if (str.contains(".xml")) {
                return parseXmlColor(str, i3);
            }
            if (TextUtils.isEmpty(str)) {
                return this.mThemeColor;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i3;
        }
    }
}
