package oicq.wlogin_sdk.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QMMKVFile;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final Context f422788a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f422789b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f422790c;

    /* renamed from: d, reason: collision with root package name */
    public final String f422791d;

    public c(@NonNull Context context, @NonNull SharedPreferences sharedPreferences, String str, String str2, boolean z16) {
        this.f422788a = context;
        this.f422789b = sharedPreferences;
        this.f422791d = str;
        this.f422790c = z16;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f422789b.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new d(this.f422788a, this.f422789b.edit(), this.f422791d, QMMKVFile.FILE_WTLOGIN, this.f422790c);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f422789b.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f422789b.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f422789b.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f422789b.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f422789b.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return this.f422789b.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.f422789b.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f422789b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f422789b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
