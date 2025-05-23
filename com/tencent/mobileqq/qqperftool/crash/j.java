package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private int f274272b;

    /* renamed from: c, reason: collision with root package name */
    private int f274273c;

    /* renamed from: d, reason: collision with root package name */
    private int f274274d;

    /* renamed from: e, reason: collision with root package name */
    private String f274275e;

    public j(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        this.f274272b = i3;
        this.f274273c = i16;
        this.f274274d = i17;
        this.f274275e = str;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    @NonNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return l.b(this.f274272b) + "(" + l.a(this.f274272b, this.f274273c) + ")";
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    @NonNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.b
    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f274274d;
    }
}
