package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f305839a;

    /* renamed from: b, reason: collision with root package name */
    private String f305840b;

    /* renamed from: c, reason: collision with root package name */
    private long f305841c;

    /* renamed from: d, reason: collision with root package name */
    private String f305842d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f305843e;

    /* renamed from: f, reason: collision with root package name */
    private int f305844f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305845g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a f(Bundle bundle, String str) {
        Bundle bundle2 = bundle.getBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA);
        if (bundle2 == null) {
            bundle2 = new Bundle();
            if (bundle.containsKey("big_brother_source_key")) {
                bundle2.putString("big_brother_source_key", bundle.getString("big_brother_source_key"));
            }
        }
        return new a().o(str).j(bundle.getString(IUniformDownloadMgr.FILENAME_FROM_DIALOG)).k(bundle.getLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG)).m(bundle.getString(IUniformDownloadMgr.NOTIFY_NAME_DIALOG, "")).i(bundle2).l(-1).n(false);
    }

    public Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305843e;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f305840b;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f305841c;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f305844f;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f305842d;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305839a;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f305845g;
    }

    public a i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
        }
        this.f305843e = bundle;
        return this;
    }

    public a j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        this.f305840b = str;
        return this;
    }

    public a k(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this, j3);
        }
        this.f305841c = j3;
        return this;
    }

    public a l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        this.f305844f = i3;
        return this;
    }

    public a m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        this.f305842d = str;
        return this;
    }

    public a n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (a) iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
        this.f305845g = z16;
        return this;
    }

    public a o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        this.f305839a = str;
        return this;
    }
}
