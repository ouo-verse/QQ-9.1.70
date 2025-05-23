package oicq.wlogin_sdk.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f422792a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f422793b;

    /* renamed from: c, reason: collision with root package name */
    public final String f422794c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f422795d;

    /* renamed from: e, reason: collision with root package name */
    public final String f422796e;

    public d(@NonNull Context context, @NonNull SharedPreferences.Editor editor, String str, @NonNull String str2, boolean z16) {
        this.f422792a = context;
        this.f422793b = editor;
        this.f422794c = str;
        this.f422796e = str2;
        this.f422795d = z16;
    }

    public final SharedPreferences a() {
        return QMMKV.fromSpAdapter(this.f422792a, this.f422794c, this.f422796e);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        this.f422793b.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        return this.f422793b.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        return this.f422793b.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        if (!this.f422795d) {
            a().edit().putBoolean(str, z16).apply();
        }
        return this.f422793b.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        if (!this.f422795d) {
            a().edit().putFloat(str, f16).apply();
        }
        return this.f422793b.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        if (!this.f422795d) {
            a().edit().putInt(str, i3).apply();
        }
        return this.f422793b.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        if (!this.f422795d) {
            a().edit().putLong(str, j3).apply();
        }
        return this.f422793b.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        if (!this.f422795d) {
            a().edit().putString(str, str2).apply();
        }
        return this.f422793b.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        if (!this.f422795d) {
            a().edit().putStringSet(str, set).apply();
        }
        return this.f422793b.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        return this.f422793b.remove(str);
    }
}
