package com.tencent.luggage.wxa.x7;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.tn.f0;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: c, reason: collision with root package name */
    public static final f f144620c = new f();

    /* renamed from: d, reason: collision with root package name */
    public static String f144621d;

    /* renamed from: e, reason: collision with root package name */
    public static int f144622e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f144623a = f0.e("IlinkOpenIdentityStore.bin");

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f144624b = f0.e("IlinkOpenIdentityStore.bin");

    public final void a(String hostAppID, String ilinkAppID) {
        Intrinsics.checkNotNullParameter(hostAppID, "hostAppID");
        Intrinsics.checkNotNullParameter(ilinkAppID, "ilinkAppID");
        putString(hostAppID, ilinkAppID);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f144624b.apply();
    }

    public final void b(String str) {
        f144621d = str;
        putString("__KEY_CURRENT_HOST_APPID__", str);
    }

    public final long c() {
        return getLong("__KEY_ILINK_UIN__", 0L);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f144624b.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f144624b.commit();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f144623a.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f144623a.edit();
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        return this.f144623a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return this.f144623a.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return this.f144623a.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return this.f144623a.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return this.f144623a.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.f144623a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        return this.f144623a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        return this.f144624b.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        return this.f144624b.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        return this.f144624b.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        return this.f144624b.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        return this.f144624b.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set set) {
        return this.f144624b.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f144623a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        return this.f144624b.remove(str);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f144623a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public final String a(String hostAppID) {
        Intrinsics.checkNotNullParameter(hostAppID, "hostAppID");
        return getString(hostAppID, null);
    }

    public final void a(long j3) {
        putLong("__KEY_ILINK_UIN__", j3);
    }

    public final int b() {
        int i3 = getInt("__KEY_HOST_ABI__", 0);
        f144622e = i3;
        return i3;
    }

    public final String a() {
        String string = getString("__KEY_CURRENT_HOST_APPID__", null);
        f144621d = string;
        return string;
    }

    public final void a(int i3) {
        f144622e = i3;
        putInt("__KEY_HOST_ABI__", i3);
    }
}
