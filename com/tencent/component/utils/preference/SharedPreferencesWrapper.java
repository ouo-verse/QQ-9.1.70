package com.tencent.component.utils.preference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class SharedPreferencesWrapper implements SharedPreferences {
    private final KeyGenerator mKeyGenerator;
    private final SharedPreferences mWrappedPreferences;

    /* loaded from: classes5.dex */
    static class EditorWrapper implements SharedPreferences.Editor {
        private final KeyGenerator mKeyGenerator;
        private final SharedPreferences.Editor mWrappedEditor;

        public EditorWrapper(SharedPreferences.Editor editor) {
            this(editor, null);
        }

        private String generateKey(String str) {
            KeyGenerator keyGenerator = this.mKeyGenerator;
            if (keyGenerator != null) {
                return keyGenerator.generate(str);
            }
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public void apply() {
            this.mWrappedEditor.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mWrappedEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mWrappedEditor.commit();
        }

        public final KeyGenerator getKeyGenerator() {
            return this.mKeyGenerator;
        }

        public final SharedPreferences.Editor getWrappedEditor() {
            return this.mWrappedEditor;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            this.mWrappedEditor.putBoolean(generateKey(str), z16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            this.mWrappedEditor.putFloat(generateKey(str), f16);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            this.mWrappedEditor.putInt(generateKey(str), i3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            this.mWrappedEditor.putLong(generateKey(str), j3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mWrappedEditor.putString(generateKey(str), str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @SuppressLint({"NewApi"})
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.mWrappedEditor.putStringSet(generateKey(str), set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mWrappedEditor.remove(generateKey(str));
            return this;
        }

        public EditorWrapper(SharedPreferences.Editor editor, KeyGenerator keyGenerator) {
            this.mWrappedEditor = editor;
            this.mKeyGenerator = keyGenerator;
        }
    }

    public SharedPreferencesWrapper(SharedPreferences sharedPreferences) {
        this(sharedPreferences, null);
    }

    private String generateKey(String str) {
        KeyGenerator keyGenerator = this.mKeyGenerator;
        if (keyGenerator != null) {
            return keyGenerator.generate(str);
        }
        return str;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mWrappedPreferences.contains(generateKey(str));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.mWrappedPreferences.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mWrappedPreferences.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.mWrappedPreferences.getBoolean(generateKey(str), z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.mWrappedPreferences.getFloat(generateKey(str), f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.mWrappedPreferences.getInt(generateKey(str), i3);
    }

    public final KeyGenerator getKeyGenerator() {
        return this.mKeyGenerator;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.mWrappedPreferences.getLong(generateKey(str), j3);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.mWrappedPreferences.getString(generateKey(str), str2);
    }

    @Override // android.content.SharedPreferences
    @SuppressLint({"NewApi"})
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mWrappedPreferences.getStringSet(generateKey(str), set);
    }

    public final SharedPreferences getWrappedSharedPreferences() {
        return this.mWrappedPreferences;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mWrappedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mWrappedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferencesWrapper(SharedPreferences sharedPreferences, KeyGenerator keyGenerator) {
        this.mWrappedPreferences = sharedPreferences;
        this.mKeyGenerator = keyGenerator;
    }
}
