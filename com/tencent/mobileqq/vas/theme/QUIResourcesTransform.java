package com.tencent.mobileqq.vas.theme;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.h;
import com.tencent.util.QUITokenResCompat;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIResourcesTransform implements h {
    private static final String KEY_THEME_ID = "qui_resources_transform_theme_id";
    private static final String KEY_THEME_PATH = "qui_resources_transform_theme_path";
    private static final String MAPPING_CONFIG_NAME = "qui_token_mapping.json";
    private static final String SUFFIX_FORCE = "#force";
    private static final String TAG = "QUIResourcesTransform";
    private static final QUIResourcesTransform sInstance = new QUIResourcesTransform();
    private String mCurrThemeId;
    private Map<String, h.a> mVasFileNameToTransformResult = null;
    private Map<String, h.a> mSuperFileNameToTransformResult = null;
    private ConcurrentHashMap<Integer, Integer> mVasResIdToResId = null;
    private ConcurrentHashMap<Integer, Integer> mSuperResIdToResId = null;
    private final AtomicBoolean mHasParseConfig = new AtomicBoolean(false);
    private volatile boolean mIsVasThemeNow = false;
    private volatile boolean mIsSuperThemeNow = false;

    QUIResourcesTransform() {
        onThemeUpdate(QQTheme.getCurrentThemeId(), SkinEngine.getInstances().getRealRootPath());
    }

    private int getDrawableResId(String str) {
        try {
            int indexOf = str.indexOf(".");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                BaseApplication context = BaseApplication.getContext();
                return context.getResources().getIdentifier(substring, "drawable", context.getPackageName());
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 2, "getDrawableResId exception", th5);
        }
        return 0;
    }

    public static QUIResourcesTransform getInstance() {
        return sInstance;
    }

    private ConcurrentHashMap<Integer, Integer> getResIdToResIdMap(Map<String, h.a> map) {
        h.a aVar;
        if (map == null) {
            return null;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : map.keySet()) {
            int drawableResId = getDrawableResId(str);
            if (drawableResId != 0 && (aVar = map.get(str)) != null) {
                if (aVar.f376073a == 0 && !TextUtils.isEmpty(aVar.f376074b)) {
                    aVar.f376073a = getDrawableResId(aVar.f376074b);
                }
                if (aVar.f376073a != 0) {
                    concurrentHashMap.put(Integer.valueOf(drawableResId), Integer.valueOf(aVar.f376073a));
                }
            }
        }
        return concurrentHashMap;
    }

    private boolean isVasSuperTheme(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            String str3 = File.separator;
            if (str.endsWith(str3)) {
                str2 = str + "config.json";
            } else {
                str2 = str + str3 + "config.json";
            }
            File file = new File(str2);
            if (file.exists()) {
                try {
                    String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
                    if (readFileToStringEx != null && readFileToStringEx.length() >= 2) {
                        return "super".equals(new JSONObject(readFileToStringEx).optString("style"));
                    }
                    return false;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "isVasSuperTheme err , msg:" + th5.getMessage());
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateResIdMapping$0() {
        if (!QUITokenResCompat.isTokenResMappingSwitchOn()) {
            return;
        }
        if (!this.mIsVasThemeNow) {
            QUITokenResCompat.updateMappingConfig(null, null);
            return;
        }
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.mSuperResIdToResId;
        if (concurrentHashMap == null && this.mVasResIdToResId == null) {
            Map<String, h.a> map = this.mSuperFileNameToTransformResult;
            if (map != null) {
                this.mSuperResIdToResId = getResIdToResIdMap(map);
            }
            Map<String, h.a> map2 = this.mVasFileNameToTransformResult;
            if (map2 != null) {
                this.mVasResIdToResId = getResIdToResIdMap(map2);
            }
            QUITokenResCompat.updateMappingConfig(this.mVasResIdToResId, this.mSuperResIdToResId);
            return;
        }
        QUITokenResCompat.updateMappingConfig(this.mVasResIdToResId, concurrentHashMap);
    }

    private void parseMappingConfig() {
        JSONObject jSONObject;
        if (!this.mHasParseConfig.getAndSet(true)) {
            String a16 = k.a(BaseApplication.getContext(), MAPPING_CONFIG_NAME);
            if (TextUtils.isEmpty(a16)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a16);
                JSONObject optJSONObject = jSONObject2.optJSONObject(PreDownloadConstants.DEPARTMENT_VAS);
                JSONObject jSONObject3 = null;
                if (optJSONObject != null) {
                    jSONObject = optJSONObject.optJSONObject("drawable");
                } else {
                    jSONObject = null;
                }
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("super");
                if (optJSONObject2 != null) {
                    jSONObject3 = optJSONObject2.optJSONObject("drawable");
                }
                HashMap<String, h.a> parseTransformResultHashMap = parseTransformResultHashMap(jSONObject);
                HashMap<String, h.a> parseTransformResultHashMap2 = parseTransformResultHashMap(jSONObject3);
                this.mVasFileNameToTransformResult = parseTransformResultHashMap;
                this.mSuperFileNameToTransformResult = parseTransformResultHashMap2;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "parseMappingConfig exception", e16);
            }
        }
    }

    private HashMap<String, h.a> parseTransformResultHashMap(JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, h.a> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String optString = jSONObject.optString(str);
            if (optString.endsWith(SUFFIX_FORCE)) {
                optString = optString.substring(0, optString.length() - 6);
                z16 = true;
            } else {
                z16 = false;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString)) {
                h.a aVar = new h.a();
                aVar.f376073a = 0;
                aVar.f376074b = optString;
                aVar.f376075c = z16;
                hashMap.put(str, aVar);
            }
        }
        return hashMap;
    }

    private void updateResIdMapping() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.a
            @Override // java.lang.Runnable
            public final void run() {
                QUIResourcesTransform.this.lambda$updateResIdMapping$0();
            }
        }, 16, null, true);
    }

    private void updateTransformConfig(String str, String str2) {
        boolean z16;
        boolean z17 = false;
        if (str != null && QQTheme.isVasTheme(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsVasThemeNow = z16;
        if (this.mIsVasThemeNow) {
            if (Build.VERSION.SDK_INT > 28 && isVasSuperTheme(str2)) {
                z17 = true;
            }
            this.mIsSuperThemeNow = z17;
        } else {
            this.mIsSuperThemeNow = false;
        }
        QLog.i(TAG, 1, "updateTransformConfig themeId = " + str + ", isVasTheme = " + this.mIsVasThemeNow + ", isSuperTheme = " + this.mIsSuperThemeNow);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateTransformConfig themePath = " + str2);
        }
        if (this.mIsVasThemeNow) {
            parseMappingConfig();
        }
        updateResIdMapping();
    }

    @Override // com.tencent.theme.h
    public boolean needTransformDrawable(int i3) {
        if (this.mIsVasThemeNow && QUITokenResCompat.isTokenResMappingSwitchOn() && i3 > R.drawable.qui_0 && i3 < R.drawable.qui_zzzzzz) {
            return true;
        }
        return false;
    }

    public void onPreThemeUpdate() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        String decodeString = from.decodeString(KEY_THEME_ID, null);
        String decodeString2 = from.decodeString(KEY_THEME_PATH, null);
        QLog.i(TAG, 1, "onPreThemeUpdate newThemeId = " + decodeString);
        if (!TextUtils.isEmpty(decodeString) && !TextUtils.equals(decodeString, this.mCurrThemeId)) {
            this.mCurrThemeId = decodeString;
            updateTransformConfig(decodeString, decodeString2);
        }
    }

    public void onThemeUpdate(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i(TAG, 1, "onThemeUpdate themeId = " + str);
        this.mCurrThemeId = str;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        from.encodeString(KEY_THEME_ID, str);
        from.encodeString(KEY_THEME_PATH, str2);
        updateTransformConfig(str, str2);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "onThemeUpdate cost time " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    @Override // com.tencent.theme.h
    public h.a transformDrawable(int i3, String str) {
        h.a aVar;
        Map<String, h.a> map;
        Map<String, h.a> map2;
        if (i3 == 0 || str == null || !this.mIsVasThemeNow) {
            return null;
        }
        if (this.mIsSuperThemeNow && (map2 = this.mSuperFileNameToTransformResult) != null) {
            aVar = map2.get(str);
        } else {
            aVar = null;
        }
        if (aVar == null && (map = this.mVasFileNameToTransformResult) != null) {
            aVar = map.get(str);
        }
        if (aVar != null) {
            if (aVar.f376073a == 0 && !TextUtils.isEmpty(aVar.f376074b)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getResId when transform drawable");
                }
                aVar.f376073a = getDrawableResId(aVar.f376074b);
            }
            QLog.d(TAG, 1, "transformDrawable (" + i3 + ", " + str + ") -> (" + aVar.f376073a + ", " + aVar.f376074b + ", " + aVar.f376075c + ")");
            if (aVar.f376073a == 0) {
                return null;
            }
        }
        return aVar;
    }

    public int getDrawableResId(int i3) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap2;
        try {
            Integer num = (!this.mIsSuperThemeNow || (concurrentHashMap2 = this.mSuperResIdToResId) == null) ? null : concurrentHashMap2.get(Integer.valueOf(i3));
            if (num == null && this.mIsVasThemeNow && (concurrentHashMap = this.mVasResIdToResId) != null) {
                num = concurrentHashMap.get(Integer.valueOf(i3));
            }
            if (num != null && num.intValue() != 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "getDrawableResId tokenResId = " + i3 + " mappingResId = " + num);
                }
                return num.intValue();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "getDrawableResId exception", e16);
        }
        return i3;
    }
}
