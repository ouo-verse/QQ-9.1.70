package com.tencent.mobileqq.vas.theme;

import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.QUITintHelper;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BusinessTintManager extends AbsTintManger {
    private static final String TAG = "BusinessTintManager";
    private static volatile AbsTintManger sInstance;
    private ThemeConfigItem mThemeConfigItem;
    private String mThemeId;
    private final TintManager mTintManager = TintManager.instance();

    BusinessTintManager() {
    }

    private boolean businessNeedTint(String str) {
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem == null) {
            return false;
        }
        Map<String, String> tintColorMap = themeConfigItem.getTintColorMap();
        if (tintColorMap != null && tintColorMap.containsKey(str)) {
            return true;
        }
        Map<String, String> tintDrawableMap = this.mThemeConfigItem.getTintDrawableMap();
        if (tintDrawableMap == null || !tintDrawableMap.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static AbsTintManger instance() {
        if (sInstance == null) {
            synchronized (BusinessTintManager.class) {
                if (sInstance == null) {
                    if (VasNormalToggle.THEME_TINT_V2_ENABLE.isEnable(false)) {
                        sInstance = ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).getTintManagerV2();
                        QLog.e(TAG, 1, "create TintManagerV2");
                    } else {
                        sInstance = new BusinessTintManager();
                        QLog.e(TAG, 1, "create BusinessTintManager");
                    }
                }
            }
        }
        return sInstance;
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        QLog.d(TAG, 1, "start clean");
        this.mThemeConfigItem = null;
        this.mThemeId = null;
        this.mTintManager.clear();
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Map<String, String> getCurrentTintColorMap() {
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem != null) {
            return themeConfigItem.getTintColorMap();
        }
        return this.mTintManager.getCurrentQUITokenMap();
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Integer getPlateColor(String str) {
        return this.mTintManager.getPlateColor(str);
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        if (!this.mTintManager.isTint(str) && !businessNeedTint(str) && !QUITintHelper.INSTANCE.needTint(str, this.mThemeId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
        this.mThemeId = ThemeConfigParser.parseThemeIdFromPath(str);
        QLog.d(TAG, 1, "loadConfig, path is : ", str);
        if (this.mThemeId == null) {
            QLog.d(TAG, 1, "load config theme id is null");
            return;
        }
        QQTheme.getCurrentThemeId();
        ThemeConfigItem parseBusinessConfig = ThemeConfigParser.parseBusinessConfig(BaseApplication.getContext(), this.mThemeId);
        this.mThemeConfigItem = parseBusinessConfig;
        this.mTintManager.loadConfig(resources, str);
        QLog.d(TAG, 1, "current theme id is : ", this.mThemeId, " item : ", parseBusinessConfig);
        if (parseBusinessConfig != null) {
            QUIUtil.printQUITintConfig(TAG, parseBusinessConfig.getTintColorMap());
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        if (!businessNeedTint(str) && !QUITintHelper.INSTANCE.needTint(str, this.mThemeId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        Map<String, String> tintDrawableMap;
        int parseColor;
        if (QUITintHelper.INSTANCE.tint(paint, str, this.mThemeId)) {
            return;
        }
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem != null && (tintDrawableMap = themeConfigItem.getTintDrawableMap()) != null && tintDrawableMap.containsKey(str)) {
            String str2 = tintDrawableMap.get(str);
            QLog.d(TAG, 1, "tint filename is : " + str, " color : ", str2);
            if (TextUtils.isEmpty(str2)) {
                parseColor = this.mThemeConfigItem.getDefaultColor();
            } else {
                parseColor = ThemeConfigParser.parseColor(str2, -1);
            }
            paint.setColorFilter(new LightingColorFilter(0, parseColor));
            return;
        }
        this.mTintManager.tint(paint, str);
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        Map<String, String> tintColorMap;
        int parseColor;
        if (iArr != null && iArr.length != 0 && !TextUtils.isEmpty(str)) {
            ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
            if (themeConfigItem != null && (tintColorMap = themeConfigItem.getTintColorMap()) != null && tintColorMap.containsKey(str)) {
                String str2 = tintColorMap.get(str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "tint color filename is : " + str, " color : ", str2);
                }
                int defaultColor = this.mThemeConfigItem.getDefaultColor();
                if (str2.contains(",")) {
                    String[] split = str2.split(",");
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (TextUtils.isEmpty(split[i3])) {
                            parseColor = defaultColor;
                        } else {
                            parseColor = ThemeConfigParser.parseColor(split[i3], defaultColor, -1);
                        }
                        setColors(iArr, i3, Integer.valueOf(parseColor));
                    }
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    defaultColor = ThemeConfigParser.parseColor(str2, -1);
                }
                setColors(iArr, 0, Integer.valueOf(defaultColor));
                return;
            }
            this.mTintManager.tintColorState(iArr, iArr2, str);
            return;
        }
        this.mTintManager.tintColorState(iArr, iArr2, str);
    }
}
