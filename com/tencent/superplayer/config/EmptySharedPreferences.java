package com.tencent.superplayer.config;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* loaded from: classes26.dex */
class EmptySharedPreferences implements SharedPreferences {
    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return false;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new SharedPreferences.Editor() { // from class: com.tencent.superplayer.config.EmptySharedPreferences.1
            @Override // android.content.SharedPreferences.Editor
            public boolean commit() {
                return false;
            }

            @Override // android.content.SharedPreferences.Editor
            public void apply() {
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor clear() {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor remove(String str) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putBoolean(String str, boolean z16) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putFloat(String str, float f16) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putInt(String str, int i3) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putLong(String str, long j3) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putString(String str, @Nullable String str2) {
                return this;
            }

            @Override // android.content.SharedPreferences.Editor
            public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
                return this;
            }
        };
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return z16;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return f16;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return i3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return j3;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }
}
