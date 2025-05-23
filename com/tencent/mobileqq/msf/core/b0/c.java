package com.tencent.mobileqq.msf.core.b0;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements SharedPreferences {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    public static final String f247550f = "MSFSharePreferencesAdapter";

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f247551a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f247552b;

    /* renamed from: c, reason: collision with root package name */
    private final String f247553c;

    /* renamed from: d, reason: collision with root package name */
    private final String f247554d;

    /* renamed from: e, reason: collision with root package name */
    private MMKVOptionEntity f247555e;

    public c(@NonNull SharedPreferences sharedPreferences, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sharedPreferences, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.f247551a = sharedPreferences;
        this.f247553c = str;
        this.f247554d = str2;
        this.f247552b = z16;
        QLog.d(f247550f, 1, "getSharedPreferences, spName: " + str + ", mmkvFile: " + str2 + ", isUseMMKV: " + z16);
    }

    private SharedPreferences a() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), this.f247553c, this.f247554d);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f247552b) {
            return a().contains(str);
        }
        return this.f247551a.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new d(this.f247551a.edit(), this.f247553c, this.f247554d, this.f247552b);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f247551a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return this.f247551a.getBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, this, str, Float.valueOf(f16))).floatValue();
        }
        return this.f247551a.getFloat(str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3)).intValue();
        }
        return this.f247551a.getInt(str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3))).longValue();
        }
        return this.f247551a.getLong(str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        return this.f247551a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) set);
        }
        return this.f247551a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onSharedPreferenceChangeListener);
        } else {
            this.f247551a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onSharedPreferenceChangeListener);
        } else {
            this.f247551a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
