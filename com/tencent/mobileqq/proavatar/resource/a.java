package com.tencent.mobileqq.proavatar.resource;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static String f259672n;

    /* renamed from: a, reason: collision with root package name */
    public final String f259673a;

    /* renamed from: b, reason: collision with root package name */
    public String f259674b;

    /* renamed from: c, reason: collision with root package name */
    public final File f259675c;

    /* renamed from: d, reason: collision with root package name */
    public final int f259676d;

    /* renamed from: e, reason: collision with root package name */
    public String f259677e;

    /* renamed from: f, reason: collision with root package name */
    public int f259678f;

    /* renamed from: g, reason: collision with root package name */
    public int f259679g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f259680h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f259681i;

    /* renamed from: j, reason: collision with root package name */
    public String f259682j;

    /* renamed from: k, reason: collision with root package name */
    public int f259683k;

    /* renamed from: l, reason: collision with root package name */
    public String f259684l;

    /* renamed from: m, reason: collision with root package name */
    public String f259685m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20859);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259672n = "https://";
        }
    }

    public a(String str, File file, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, file, Integer.valueOf(i3));
            return;
        }
        this.f259677e = null;
        this.f259678f = -1;
        this.f259679g = -1;
        this.f259680h = null;
        this.f259682j = "";
        this.f259674b = str;
        this.f259673a = str;
        if (!TextUtils.isEmpty(str) && str.startsWith(f259672n)) {
            this.f259681i = true;
        }
        this.f259675c = file;
        this.f259676d = i3;
    }
}
