package com.tencent.thumbplayer.common.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.common.annotation.TPOptionalParamUtil;
import com.tencent.thumbplayer.common.annotation.TPOptionalParamValueAnnotation;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPConfig {
    private static final String TAG = "TPConfig";
    private static final ITPOnGetConfigListener sNativeListener = new ITPOnGetConfigListener() { // from class: com.tencent.thumbplayer.common.config.TPConfig.1
        @Override // com.tencent.thumbplayer.common.config.ITPOnGetConfigListener
        @Nullable
        public TPOptionalParam<?> onGetConfig(@NonNull String str) {
            return TPConfig.getConfig(str);
        }
    };
    private static final Map<String, TPOptionalParam<?>> sConfigMap = new HashMap();

    static {
        loadAllDeclaredConfigs();
    }

    public static synchronized void addConfig(@NonNull TPOptionalParam<?> tPOptionalParam) {
        synchronized (TPConfig.class) {
            sConfigMap.put(tPOptionalParam.getKey(), tPOptionalParam);
        }
    }

    @Nullable
    public static synchronized TPOptionalParam<?> getConfig(@NonNull String str) {
        TPOptionalParam<?> tPOptionalParam;
        synchronized (TPConfig.class) {
            tPOptionalParam = sConfigMap.get(str);
        }
        return tPOptionalParam;
    }

    @NonNull
    public static synchronized <T> T getConfigValue(@NonNull String str, @NonNull T t16) {
        synchronized (TPConfig.class) {
            TPOptionalParam<?> tPOptionalParam = sConfigMap.get(str);
            if (tPOptionalParam == null) {
                return t16;
            }
            if (!tPOptionalParam.getValue().getClass().equals(t16.getClass())) {
                return t16;
            }
            try {
                return (T) tPOptionalParam.getValue();
            } catch (ClassCastException unused) {
                return t16;
            }
        }
    }

    public static synchronized void initConfigs() {
        synchronized (TPConfig.class) {
            if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
                TPLogUtil.e(TAG, "failed to create connection , native libraries not successfully loaded");
            } else {
                try {
                    native_setOnGetConfigListener(sNativeListener);
                } catch (UnsatisfiedLinkError unused) {
                    TPLogUtil.e(TAG, "fait to set on get config listener, so load failed");
                }
            }
        }
    }

    private static void loadAllDeclaredConfigs() {
        String str;
        for (Field field : TPMgrConfig.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(TPOptionalParamValueAnnotation.class) && Modifier.isStatic(field.getModifiers()) && field.getGenericType() == String.class) {
                try {
                    str = (String) field.get(TPMgrConfig.class);
                } catch (IllegalAccessException unused) {
                    TPLogUtil.w(TAG, "one optional param load failed");
                    str = null;
                }
                TPOptionalParam<?> optOptionalParam = TPOptionalParamUtil.optOptionalParam(str, (TPOptionalParamValueAnnotation) field.getAnnotation(TPOptionalParamValueAnnotation.class));
                if (optOptionalParam != null) {
                    sConfigMap.put(optOptionalParam.getKey(), optOptionalParam);
                }
            }
        }
    }

    private static native int native_setOnGetConfigListener(ITPOnGetConfigListener iTPOnGetConfigListener);
}
