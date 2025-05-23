package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ao implements SharedPreferences {

    /* renamed from: d, reason: collision with root package name */
    final MMKVOptionEntity f202306d;

    /* renamed from: e, reason: collision with root package name */
    final CopyOnWriteArraySet<SharedPreferences.OnSharedPreferenceChangeListener> f202307e;

    /* renamed from: f, reason: collision with root package name */
    final String f202308f;

    public ao(Context context, String str) {
        this(context, "common_mmkv_configurations", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        return this.f202308f + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = this.f202307e.iterator();
        while (it.hasNext()) {
            it.next().onSharedPreferenceChanged(this, str);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f202306d.containsKey(c(str));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new a();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new RuntimeException("getAll method not implemented");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f202306d.decodeBool(c(str), z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f202306d.decodeFloat(c(str), f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f202306d.decodeInt(c(str), i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f202306d.decodeLong(c(str), j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f202306d.decodeString(c(str), str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f202306d.decodeStringSet(c(str), set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f202307e.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f202307e.remove(onSharedPreferenceChangeListener);
    }

    public ao(Context context, String str, String str2) {
        this.f202307e = new CopyOnWriteArraySet<>();
        this.f202306d = QMMKV.from(context, str);
        this.f202308f = str2;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class a implements SharedPreferences.Editor {
        a() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            ao.this.f202306d.commitAsync();
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            ao.this.f202306d.commitSync();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z16) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeBool(aoVar.c(str), z16);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f16) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeFloat(aoVar.c(str), f16);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i3) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeInt(aoVar.c(str), i3);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j3) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeLong(aoVar.c(str), j3);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeString(aoVar.c(str), str2);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            ao aoVar = ao.this;
            aoVar.f202306d.encodeStringSet(aoVar.c(str), set);
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            ao aoVar = ao.this;
            aoVar.f202306d.removeKey(aoVar.c(str));
            ao.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            return this;
        }
    }
}
