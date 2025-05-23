package com.tencent.mobileqq.msf.core.b0;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d implements SharedPreferences.Editor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences.Editor f247556a;

    /* renamed from: b, reason: collision with root package name */
    private final String f247557b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f247558c;

    /* renamed from: d, reason: collision with root package name */
    private final String f247559d;

    public d(@NonNull SharedPreferences.Editor editor, String str, @NonNull String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, editor, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.f247556a = editor;
        this.f247557b = str;
        this.f247559d = str2;
        this.f247558c = z16;
    }

    private SharedPreferences a() {
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), this.f247557b, this.f247559d);
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f247556a.apply();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f247556a.clear();
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f247556a.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
        }
        if (!this.f247558c) {
            a().edit().putBoolean(str, z16).apply();
        }
        return this.f247556a.putBoolean(str, z16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 6, this, str, Float.valueOf(f16));
        }
        if (!this.f247558c) {
            a().edit().putFloat(str, f16).apply();
        }
        return this.f247556a.putFloat(str, f16);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        if (!this.f247558c) {
            a().edit().putInt(str, i3).apply();
        }
        return this.f247556a.putInt(str, i3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
        }
        if (!this.f247558c) {
            a().edit().putLong(str, j3).apply();
        }
        return this.f247556a.putLong(str, j3);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (!this.f247558c) {
            a().edit().putString(str, str2).apply();
        }
        return this.f247556a.putString(str, str2);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) set);
        }
        if (!this.f247558c) {
            a().edit().putStringSet(str, set).apply();
        }
        return this.f247556a.putStringSet(str, set);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SharedPreferences.Editor) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return this.f247556a.remove(str);
    }
}
