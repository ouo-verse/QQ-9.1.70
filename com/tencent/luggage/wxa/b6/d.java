package com.tencent.luggage.wxa.b6;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.tn.f0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public f0 f121887a;

    public d(f0 f0Var) {
        this.f121887a = f0Var;
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f121887a.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f121887a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f121887a.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f121887a.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f121887a.edit();
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        HashMap hashMap = new HashMap();
        String[] a16 = this.f121887a.a();
        if (a16 == null) {
            return hashMap;
        }
        for (String str : a16) {
            hashMap.put(str, "");
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f121887a.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f121887a.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f121887a.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f121887a.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.f121887a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        return this.f121887a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        return this.f121887a.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        return this.f121887a.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        return this.f121887a.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        return this.f121887a.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        return this.f121887a.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set set) {
        return this.f121887a.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f121887a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        return this.f121887a.remove(str);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f121887a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
