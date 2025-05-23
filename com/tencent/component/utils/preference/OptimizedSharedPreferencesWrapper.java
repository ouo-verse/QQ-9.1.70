package com.tencent.component.utils.preference;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.component.utils.preference.SharedPreferencesWrapper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
class OptimizedSharedPreferencesWrapper extends SharedPreferencesWrapper {
    private static final Object mContent = new Object();
    private SharedPreferences.OnSharedPreferenceChangeListener mInnerListener;
    private final String mKeyPrefix;
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
    private final boolean mOptimize;

    /* loaded from: classes5.dex */
    class OptimizedEditorWrapper extends SharedPreferencesWrapper.EditorWrapper {
        public OptimizedEditorWrapper(SharedPreferences.Editor editor) {
            super(editor, OptimizedSharedPreferencesWrapper.this.getKeyGenerator());
        }

        @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper.EditorWrapper, android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            if (TextUtils.isEmpty(OptimizedSharedPreferencesWrapper.this.mKeyPrefix)) {
                super.clear();
            } else {
                Map<String, ?> all = OptimizedSharedPreferencesWrapper.this.getWrappedSharedPreferences().getAll();
                if (all != null && !all.isEmpty()) {
                    for (String str : all.keySet()) {
                        if (OptimizedSharedPreferencesWrapper.isGeneratedKey(OptimizedSharedPreferencesWrapper.this.mKeyPrefix, str)) {
                            super.remove(str);
                        }
                    }
                }
            }
            return this;
        }

        @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper.EditorWrapper, android.content.SharedPreferences.Editor
        public boolean commit() {
            if (OptimizedSharedPreferencesWrapper.this.mOptimize) {
                super.apply();
                return true;
            }
            return super.commit();
        }
    }

    public OptimizedSharedPreferencesWrapper(SharedPreferences sharedPreferences, final String str, boolean z16) {
        super(sharedPreferences, new KeyGenerator() { // from class: com.tencent.component.utils.preference.OptimizedSharedPreferencesWrapper.1
            @Override // com.tencent.component.utils.preference.KeyGenerator
            public String generate(String str2) {
                return OptimizedSharedPreferencesWrapper.generateKey(str, str2);
            }
        });
        this.mListeners = new WeakHashMap<>();
        this.mKeyPrefix = str;
        this.mOptimize = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (str2 != null) {
            return str + str2;
        }
        throw new RuntimeException("null key is not supported when contains key prefix " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isGeneratedKey(String str, String str2) {
        if (!TextUtils.isEmpty(str) && (TextUtils.isEmpty(str2) || !str2.startsWith(str))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(String str) {
        HashSet<SharedPreferences.OnSharedPreferenceChangeListener> hashSet;
        synchronized (this.mListeners) {
            if (!this.mListeners.isEmpty()) {
                hashSet = new HashSet(this.mListeners.keySet());
            } else {
                unregisterInnerListenerIfNeedLocked();
                hashSet = null;
            }
        }
        if (hashSet != null) {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : hashSet) {
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String rGenerateKey(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
            return str2.substring(str.length());
        }
        return null;
    }

    private void registerInnerListenerIfNeedLocked() {
        if (this.mInnerListener == null) {
            this.mInnerListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.tencent.component.utils.preference.OptimizedSharedPreferencesWrapper.2
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    String rGenerateKey = OptimizedSharedPreferencesWrapper.rGenerateKey(OptimizedSharedPreferencesWrapper.this.mKeyPrefix, str);
                    if (rGenerateKey != null || TextUtils.isEmpty(OptimizedSharedPreferencesWrapper.this.mKeyPrefix)) {
                        OptimizedSharedPreferencesWrapper.this.notifyListeners(rGenerateKey);
                    }
                }
            };
            getWrappedSharedPreferences().registerOnSharedPreferenceChangeListener(this.mInnerListener);
        }
    }

    private void unregisterInnerListenerIfNeedLocked() {
        if (this.mInnerListener != null) {
            getWrappedSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.mInnerListener);
            this.mInnerListener = null;
        }
    }

    @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor edit = super.edit();
        if (edit != null) {
            return new OptimizedEditorWrapper(edit);
        }
        return null;
    }

    @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> all = super.getAll();
        if (!TextUtils.isEmpty(this.mKeyPrefix) && all != null && !all.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String rGenerateKey = rGenerateKey(this.mKeyPrefix, entry.getKey());
                if (rGenerateKey != null || TextUtils.isEmpty(this.mKeyPrefix)) {
                    hashMap.put(rGenerateKey, entry.getValue());
                }
            }
            return hashMap;
        }
        return all;
    }

    @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mListeners) {
            if (this.mListeners.isEmpty()) {
                registerInnerListenerIfNeedLocked();
            }
            this.mListeners.put(onSharedPreferenceChangeListener, mContent);
        }
    }

    @Override // com.tencent.component.utils.preference.SharedPreferencesWrapper, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mListeners) {
            this.mListeners.remove(onSharedPreferenceChangeListener);
            if (this.mListeners.isEmpty()) {
                unregisterInnerListenerIfNeedLocked();
            }
        }
    }
}
