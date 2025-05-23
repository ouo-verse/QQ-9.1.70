package com.tencent.mobileqq.troop;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f297709a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f297710b;

    /* renamed from: c, reason: collision with root package name */
    private final String f297711c;

    /* renamed from: d, reason: collision with root package name */
    private final int f297712d;

    /* renamed from: e, reason: collision with root package name */
    private final String f297713e;

    public k(@NotNull String str, boolean z16, @Nullable String str2, int i3, @NotNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), str2, Integer.valueOf(i3), str3);
            return;
        }
        this.f297709a = str;
        this.f297710b = z16;
        this.f297711c = str2;
        this.f297712d = i3;
        this.f297713e = str3;
    }

    @NotNull
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f297713e;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f297710b;
    }

    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f297711c;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f297712d;
    }

    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f297709a;
    }
}
