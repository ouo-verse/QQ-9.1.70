package com.tencent.qqlive.tvkplayer.tools.config;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKConfigFieldSetter {
    private static final String TAG = "TVKPlayer[TVKConfigFieldSetter]";
    private static final HashMap<Class<?>, FieldHandler> sFieldTypeToSetHandlerTables;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface FieldHandler {
        void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException;
    }

    static {
        HashMap<Class<?>, FieldHandler> hashMap = new HashMap<>();
        sFieldTypeToSetHandlerTables = hashMap;
        hashMap.put(Long.TYPE, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.1
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.setLong(null, TVKUtils.optLong(str, field.getLong(null)));
            }
        });
        hashMap.put(Integer.TYPE, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.2
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.setInt(null, TVKUtils.optInt(str, field.getInt(null)));
            }
        });
        hashMap.put(Double.TYPE, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.3
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.setDouble(null, TVKUtils.optDouble(str, field.getDouble(null)));
            }
        });
        hashMap.put(Float.TYPE, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.4
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.setFloat(null, TVKUtils.optFloat(str, field.getFloat(null)));
            }
        });
        hashMap.put(Boolean.TYPE, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.5
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.setBoolean(null, TVKUtils.optBoolean(str, field.getBoolean(null)));
            }
        });
        hashMap.put(String.class, new FieldHandler() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.6
            @Override // com.tencent.qqlive.tvkplayer.tools.config.TVKConfigFieldSetter.FieldHandler
            public void setValue(@NonNull Field field, @NonNull String str) throws IllegalArgumentException, IllegalAccessException {
                field.set(null, str);
            }
        });
    }

    private static void setTVKConfigField(@NonNull Field field, @NonNull String str) {
        if (!Modifier.isStatic(field.getModifiers())) {
            TVKLogUtil.w(TAG, "[setTVKConfigField] Fails to access config field, non-static type.");
            return;
        }
        FieldHandler fieldHandler = sFieldTypeToSetHandlerTables.get(field.getType());
        if (fieldHandler == null) {
            TVKLogUtil.w(TAG, "[setTVKConfigField] Unsupported type, ignored: " + field.getType());
            return;
        }
        try {
            fieldHandler.setValue(field, str);
        } catch (IllegalAccessException | IllegalArgumentException e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    public static void setTVKConfigFields(@NonNull Class<?> cls, @NonNull HashMap<String, String> hashMap) {
        TVKLogUtil.i(TAG, "[setTVKConfigFields] Applying config: " + hashMap + " to " + cls);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            try {
                Field field = cls.getField(key);
                field.setAccessible(true);
                setTVKConfigField(field, entry.getValue());
            } catch (NoSuchFieldException e16) {
                TVKLogUtil.w(TAG, "[setTVKConfigFields] Illegal config field: " + key + ", ignored: " + e16.toString());
            }
        }
    }
}
