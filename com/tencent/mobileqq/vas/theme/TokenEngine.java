package com.tencent.mobileqq.vas.theme;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TokenEngine implements com.tencent.mobileqq.skin.a {
    private static final List<String> FOCUS_IMAGE_LIST = Arrays.asList("qui_login_qq_logo_text_primary.xml", "qui_chevron_left.png", "qui_close_icon_secondary_01.xml", "qui_close_icon_secondary_01_pressed.xml");
    private static final String SWITCH_TOKEN_ENGINE = "token_engine";
    private static final String SWITCH_USE_ID_FILTER = "use_res_id_filter";
    private static final String TAG = "TokenEngine";
    private static final String TOKEN_PREFIX = "qui_";
    private ThemeConfigItem mConfigItem;
    private boolean mHasInitSwitch;
    private String mThemeId;
    private boolean mUseIdFilterSwitch;
    private boolean mUseTokenEngine;
    private Boolean mEnableDrawableLog = null;
    protected final LongSparseArray<WeakReference<SkinnableColorStateList>> mColorStateCaches = new LongSparseArray<>();
    protected final LongSparseArray<WeakReference<BaseConstantState>> mDrawableCaches = new LongSparseArray<>();
    private final SkinBitmapFilter mBitmapFilter = new SkinBitmapFilter();
    private final HighFreqLogUtil highFreqLogUtil = new HighFreqLogUtil(2);

    private boolean enableDrawableLog() {
        if (this.mEnableDrawableLog == null) {
            this.mEnableDrawableLog = Boolean.valueOf(new UnitedProxy("vas_theme_token_drawable_log", true).isEnable(true));
        }
        Boolean bool = this.mEnableDrawableLog;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static long getNowTime() {
        return System.currentTimeMillis();
    }

    private void initSwitch() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        this.mUseIdFilterSwitch = iFeatureRuntimeService.isFeatureSwitchEnable(SWITCH_USE_ID_FILTER, true);
        this.mUseTokenEngine = iFeatureRuntimeService.isFeatureSwitchEnable(SWITCH_TOKEN_ENGINE, true);
        this.mHasInitSwitch = true;
    }

    private boolean isTokenEngineSwitchOn() {
        if (this.mHasInitSwitch) {
            return this.mUseTokenEngine;
        }
        initSwitch();
        if (this.mHasInitSwitch) {
            return this.mUseTokenEngine;
        }
        return false;
    }

    private boolean isUserIdSwitchOn() {
        if (this.mHasInitSwitch) {
            return this.mUseIdFilterSwitch;
        }
        initSwitch();
        if (this.mHasInitSwitch) {
            return this.mUseIdFilterSwitch;
        }
        return false;
    }

    private void loadColorFromThemeFile(SkinnableColorStateList skinnableColorStateList, String str) {
        String themeFileRootPath = SubEngineUtils.getThemeFileRootPath(str);
        com.tencent.mobileqq.qui.util.b bVar = com.tencent.mobileqq.qui.util.b.f276941a;
        QLog.d(TAG, 1, "before resetColor, color state list : ", skinnableColorStateList.skinData.mFileName, " color : ", bVar.e(skinnableColorStateList.getDefaultColor()));
        SkinnableColorStateList loadColorForTheme = SkinEngine.getInstances().loadColorForTheme(skinnableColorStateList.skinData, themeFileRootPath);
        if (loadColorForTheme == null) {
            return;
        }
        skinnableColorStateList.update(loadColorForTheme);
        QLog.d(TAG, 1, "after resetColor, color state list : ", skinnableColorStateList.skinData.mFileName, " color : ", bVar.e(skinnableColorStateList.getDefaultColor()));
    }

    private void refreshDrawableTint() {
        int size = this.mDrawableCaches.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<BaseConstantState> valueAt = this.mDrawableCaches.valueAt(i3);
            if (valueAt != null && valueAt.get() != null) {
                BaseConstantState baseConstantState = valueAt.get();
                SkinData skinData = baseConstantState.skinData;
                if (skinData != null && skinData.mTintColorResId == 0) {
                    skinData.mTintColorResId = R.color.qui_common_icon_primary;
                }
                baseConstantState.reloadTintColor();
                if (!QLog.isDevelopLevel()) {
                    continue;
                } else {
                    if (skinData == null) {
                        return;
                    }
                    QLog.d(TAG, 1, "refresh drawable, filename : " + skinData.mFileName + " tintColorResId : " + skinData.mTintColorResId);
                }
            }
        }
    }

    private void refreshToLocalTheme(boolean z16) {
        SkinnableColorStateList skinnableColorStateList;
        SkinData skinData;
        int size = this.mColorStateCaches.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<SkinnableColorStateList> valueAt = this.mColorStateCaches.valueAt(i3);
            if (valueAt != null && (skinnableColorStateList = valueAt.get()) != null && (skinData = skinnableColorStateList.skinData) != null && skinData.mFileName != null) {
                skinnableColorStateList.update(SkinEngine.getInstances().grabImageAndLoadColor(skinnableColorStateList.skinData.mResourcesID, BaseApplication.getContext().getResources(), skinnableColorStateList.skinData));
            }
        }
        refreshDrawableTint();
        if (z16) {
            SkinEngine.getInstances().notifyUIChanged(BaseApplication.getContext());
        }
    }

    private void refreshToOtherTheme(String str) {
        SkinnableColorStateList skinnableColorStateList;
        SkinData skinData;
        resetColorToThemeFiles();
        ThemeConfigItem parseBusinessConfig = ThemeConfigParser.parseBusinessConfig(BaseApplication.getContext(), str);
        this.mConfigItem = parseBusinessConfig;
        this.mThemeId = str;
        QLog.d(TAG, 1, "start refresh ui, theme : ", str);
        if (parseBusinessConfig == null) {
            QLog.d(TAG, 1, "refresh ui info, item is null");
            refreshDrawableTint();
            SkinEngine.getInstances().notifyUIChanged(BaseApplication.getContext());
            return;
        }
        int size = this.mColorStateCaches.size();
        if (parseBusinessConfig.getTintColorMap() != null) {
            for (int i3 = 0; i3 < size; i3++) {
                WeakReference<SkinnableColorStateList> valueAt = this.mColorStateCaches.valueAt(i3);
                if (valueAt != null && (skinnableColorStateList = valueAt.get()) != null && (skinData = skinnableColorStateList.skinData) != null && skinData.mFileName != null) {
                    tintColorFromThemeConfig(skinnableColorStateList, parseBusinessConfig);
                }
            }
        }
        refreshDrawableTint();
        SkinEngine.getInstances().notifyUIChanged(BaseApplication.getContext());
    }

    private synchronized void refreshUIInfo(String str) {
        boolean z16 = true;
        if (str != null) {
            if (!str.equals(QQTheme.getCurrentThemeId())) {
                if (str.equals(this.mThemeId)) {
                    QLog.d(TAG, 1, "refresh ui info, same theme id");
                    return;
                }
                this.mThemeId = str;
                QLog.d(TAG, 1, "refreshToOtherTheme");
                refreshToOtherTheme(str);
                return;
            }
        }
        this.mThemeId = str;
        if (str == null) {
            z16 = false;
        }
        refreshToLocalTheme(z16);
    }

    private void resetColorToThemeFiles() {
        SkinnableColorStateList skinnableColorStateList;
        SkinData skinData;
        int size = this.mColorStateCaches.size();
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference<SkinnableColorStateList> valueAt = this.mColorStateCaches.valueAt(i3);
            if (valueAt != null && (skinnableColorStateList = valueAt.get()) != null && (skinData = skinnableColorStateList.skinData) != null && skinData.mResourcesID != 0) {
                loadColorFromThemeFile(skinnableColorStateList, this.mThemeId);
            }
        }
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    private void tintColorFromThemeConfig(SkinnableColorStateList skinnableColorStateList, ThemeConfigItem themeConfigItem) {
        int parseColor;
        if (themeConfigItem != null && themeConfigItem.getTintColorMap() != null) {
            Map<String, String> tintColorMap = themeConfigItem.getTintColorMap();
            QLog.d(TAG, 1, "tint colorData filename is : " + skinnableColorStateList.skinData.mFileName);
            String str = tintColorMap.get(skinnableColorStateList.skinData.mFileName);
            if (str == null) {
                return;
            }
            QLog.d(TAG, 1, " colorData : ", str);
            int[] colors = skinnableColorStateList.getColors();
            int defaultColor = themeConfigItem.getDefaultColor();
            int[][] stateSpecs = skinnableColorStateList.getStateSpecs();
            if (str.contains(",")) {
                String[] split = str.split(",");
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (TextUtils.isEmpty(split[i3])) {
                        parseColor = defaultColor;
                    } else {
                        parseColor = ThemeConfigParser.parseColor(split[i3], -1);
                    }
                    setColors(colors, i3, Integer.valueOf(parseColor));
                }
                skinnableColorStateList.setDefaultColor(colors, stateSpecs);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                defaultColor = ThemeConfigParser.parseColor(str, -1);
            }
            setColors(colors, 0, Integer.valueOf(defaultColor));
            skinnableColorStateList.setDefaultColor(skinnableColorStateList.getColors(), stateSpecs);
            return;
        }
        QLog.d(TAG, 1, "reload color, item or map null");
    }

    @Override // com.tencent.theme.i
    public boolean addResources(int i3, String str) {
        return isFocusedDrawable(i3, str);
    }

    @Override // com.tencent.mobileqq.skin.a
    public boolean isFocusedColor(SkinnableColorStateList skinnableColorStateList) {
        boolean z16;
        if (skinnableColorStateList != null && skinnableColorStateList.skinData != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        String str = skinnableColorStateList.skinData.mFileName;
        if (str != null && str.startsWith(TOKEN_PREFIX)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.skin.a
    public boolean isFocusedDrawable(BaseConstantState baseConstantState) {
        if ((baseConstantState == null || baseConstantState.skinData == null) ? false : true) {
            return FOCUS_IMAGE_LIST.contains(baseConstantState.skinData.mFileName);
        }
        return false;
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetAlpha(BaseConstantState baseConstantState, int i3) {
        SkinData skinData;
        SkinBitmapFilter skinBitmapFilter = this.mBitmapFilter;
        if (baseConstantState == null) {
            skinData = null;
        } else {
            skinData = baseConstantState.skinData;
        }
        return skinBitmapFilter.needBlockSetAlpha(skinData, i3);
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetColorFilter(BaseConstantState baseConstantState, ColorFilter colorFilter) {
        SkinData skinData;
        SkinBitmapFilter skinBitmapFilter = this.mBitmapFilter;
        if (baseConstantState == null) {
            skinData = null;
        } else {
            skinData = baseConstantState.skinData;
        }
        return skinBitmapFilter.needBlockSetColorFilter(skinData, colorFilter);
    }

    @Override // com.tencent.theme.i
    public void onColorLoaded(SkinnableColorStateList skinnableColorStateList) {
        int i3 = skinnableColorStateList.skinData.mResourcesID;
        this.mColorStateCaches.put(i3, new WeakReference<>(skinnableColorStateList));
        String str = this.mThemeId;
        if (str != null && !str.equals(QQTheme.getCurrentThemeId())) {
            loadColorFromThemeFile(skinnableColorStateList, this.mThemeId);
            tintColorFromThemeConfig(skinnableColorStateList, this.mConfigItem);
        }
        if (QLog.isColorLevel()) {
            this.highFreqLogUtil.e(TAG, 1, getNowTime() + "colorLoaded id:" + i3 + skinnableColorStateList.skinData.mFileName + ",color:" + com.tencent.mobileqq.qui.util.b.f276941a.e(skinnableColorStateList.getDefaultColor()));
        }
    }

    @Override // com.tencent.theme.i
    public void onColorReloaded(SkinnableColorStateList skinnableColorStateList) {
        SkinData skinData;
        if (skinnableColorStateList != null && (skinData = skinnableColorStateList.skinData) != null) {
            int i3 = skinData.mResourcesID;
            if (QLog.isColorLevel()) {
                this.highFreqLogUtil.e(TAG, 1, getNowTime() + "colorReloaded id:" + i3 + skinnableColorStateList.skinData.mFileName + ",color:" + com.tencent.mobileqq.qui.util.b.f276941a.e(skinnableColorStateList.getDefaultColor()) + ",obj:" + Integer.toHexString(skinnableColorStateList.hashCode()) + ",detail:" + skinnableColorStateList);
            }
        }
    }

    @Override // com.tencent.theme.i
    public void onDrawableLoaded(BaseConstantState baseConstantState) {
        this.mDrawableCaches.put(baseConstantState.skinData.mResourcesID, new WeakReference<>(baseConstantState));
        if (QLog.isColorLevel() && enableDrawableLog()) {
            this.highFreqLogUtil.e(TAG, 1, getNowTime() + "onDrawableLoaded :" + baseConstantState.skinData);
        }
    }

    @Override // com.tencent.theme.i
    public void onDrawableReloaded(BaseConstantState baseConstantState) {
        if (QLog.isColorLevel() && enableDrawableLog()) {
            this.highFreqLogUtil.e(TAG, 1, getNowTime() + "onDrawableReloaded :" + baseConstantState.skinData);
        }
    }

    public void resetTheme() {
        this.mThemeId = null;
        this.mConfigItem = null;
        switchTheme(null);
    }

    public void switchTheme(String str) {
        if (!isTokenEngineSwitchOn()) {
            QLog.d(TAG, 1, "isTokenEngineSwitchOn : false");
            return;
        }
        QLog.d(TAG, 1, "switchTheme : ", str);
        long currentTimeMillis = System.currentTimeMillis();
        refreshUIInfo(str);
        QLog.d(TAG, 1, "refreshUIInfo cost time : ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private boolean isFocusedDrawable(int i3, String str) {
        if (isUserIdSwitchOn()) {
            return i3 < R.drawable.qui_zzzzzz && i3 > R.drawable.qui_0;
        }
        return str.contains(File.separator + TOKEN_PREFIX);
    }
}
