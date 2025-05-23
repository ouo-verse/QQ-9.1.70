package com.tencent.beacon.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.beacon.a.b.i;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f77679a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f77680b;

    /* renamed from: c, reason: collision with root package name */
    private g f77681c;

    /* renamed from: d, reason: collision with root package name */
    private SharedPreferencesEditorC0784a f77682d;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f77683e;

    a() {
    }

    public static a a() {
        if (f77679a == null) {
            synchronized (a.class) {
                if (f77679a == null) {
                    f77679a = new a();
                }
            }
        }
        return f77679a;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f77681c.a(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f77681c.b();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(@NonNull String str, boolean z16) {
        Object a16 = a(str, Boolean.valueOf(z16));
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return z16;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(@NonNull String str, float f16) {
        Object a16 = a(str, Float.valueOf(f16));
        if (a16 instanceof Number) {
            return ((Number) a16).floatValue();
        }
        return f16;
    }

    @Override // android.content.SharedPreferences
    public int getInt(@NonNull String str, int i3) {
        Object a16 = a(str, Integer.valueOf(i3));
        if (a16 instanceof Number) {
            return ((Number) a16).intValue();
        }
        return i3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(@NonNull String str, long j3) {
        Object a16 = a(str, Long.valueOf(j3));
        if (a16 instanceof Number) {
            return ((Number) a16).longValue();
        }
        return j3;
    }

    @Override // android.content.SharedPreferences
    public String getString(@NonNull String str, @NonNull String str2) {
        Object a16 = a(str, str2);
        if (a16 instanceof String) {
            return (String) a16;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(@NonNull String str, @Nullable Set<String> set) {
        if (!this.f77680b) {
            return set;
        }
        return this.f77681c.a(str, (Set) set);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferencesEditorC0784a edit() {
        if (!this.f77680b) {
            com.tencent.beacon.base.util.e.a("BeaconProperties has not init!");
            a(com.tencent.beacon.a.c.c.c().b());
        }
        return this.f77682d;
    }

    public synchronized void a(Context context) {
        if (this.f77680b || context == null) {
            return;
        }
        try {
            String replace = com.tencent.beacon.a.c.b.c(context).replace(context.getPackageName(), "");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("prop_");
            sb5.append(replace);
            g a16 = g.a(context, sb5.toString());
            this.f77681c = a16;
            this.f77682d = new SharedPreferencesEditorC0784a(a16);
            this.f77680b = true;
        } catch (IOException e16) {
            com.tencent.beacon.base.util.c.a(e16);
            i.e().a("504", "[properties] PropertiesFile create error!", e16);
            this.f77680b = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> Object a(@NonNull String str, T t16) {
        if (!this.f77680b) {
            return t16;
        }
        Object a16 = this.f77681c.a(str, (String) t16);
        if (a16 == null || a16 == t16) {
            Context b16 = com.tencent.beacon.a.c.c.c().b();
            if (this.f77683e == null) {
                this.f77683e = b16.getSharedPreferences("DENGTA_META", 0);
            }
            if (t16 instanceof Boolean) {
                a16 = Boolean.valueOf(this.f77683e.getBoolean(str, ((Boolean) t16).booleanValue()));
            } else if (t16 instanceof String) {
                a16 = this.f77683e.getString(str, (String) t16);
            } else if (t16 instanceof Integer) {
                a16 = Integer.valueOf(this.f77683e.getInt(str, ((Integer) t16).intValue()));
            } else if (t16 instanceof Long) {
                a16 = Long.valueOf(this.f77683e.getLong(str, ((Long) t16).longValue()));
            } else if (t16 instanceof Float) {
                a16 = Float.valueOf(this.f77683e.getFloat(str, ((Float) t16).floatValue()));
            }
            if (a16 != null && a16 != t16) {
                this.f77681c.b(str, a16);
            }
        }
        return a16 == null ? t16 : a16;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class SharedPreferencesEditorC0784a implements SharedPreferences.Editor {

        /* renamed from: a, reason: collision with root package name */
        private g f77684a;

        SharedPreferencesEditorC0784a(g gVar) {
            this.f77684a = gVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f77684a.a();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(@NonNull String str, boolean z16) {
            this.f77684a.b(str, Boolean.valueOf(z16));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(@NonNull String str, float f16) {
            this.f77684a.b(str, Float.valueOf(f16));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(@NonNull String str, int i3) {
            this.f77684a.b(str, Integer.valueOf(i3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(@NonNull String str, long j3) {
            this.f77684a.b(str, Long.valueOf(j3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(@NonNull String str, @NonNull String str2) {
            this.f77684a.b(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(@NonNull String str, @NonNull Set<String> set) {
            this.f77684a.b(str, (Set) set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f77684a.b(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
