package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f200935a;

    /* renamed from: b, reason: collision with root package name */
    public long f200936b;

    /* renamed from: c, reason: collision with root package name */
    public String f200937c;

    /* renamed from: d, reason: collision with root package name */
    public String f200938d;

    /* renamed from: e, reason: collision with root package name */
    public String f200939e;

    /* renamed from: f, reason: collision with root package name */
    public String f200940f;

    /* renamed from: g, reason: collision with root package name */
    public String f200941g;

    /* renamed from: h, reason: collision with root package name */
    public int f200942h;

    /* renamed from: i, reason: collision with root package name */
    public int f200943i;

    /* renamed from: j, reason: collision with root package name */
    public int f200944j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f200945k;

    /* renamed from: l, reason: collision with root package name */
    public String f200946l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<a> f200947m;

    /* renamed from: n, reason: collision with root package name */
    public int f200948n;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f200949a;

        /* renamed from: b, reason: collision with root package name */
        public String f200950b;

        /* renamed from: c, reason: collision with root package name */
        public String f200951c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "Label{content='" + this.f200949a + "', bgColor='" + this.f200950b + "', textColor='" + this.f200951c + "'}";
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "C2CShortcutAppInfo{appId=" + this.f200935a + ", type=" + this.f200936b + ", name='" + this.f200937c + "', iconUrl='" + this.f200938d + "', jumpUrl='" + this.f200939e + "', desc='" + this.f200940f + "', cmdTrace='" + this.f200941g + "', redPoint=" + this.f200942h + ", showFrame=" + this.f200943i + ", playingNum=" + this.f200944j + ", canSendArkMsg=" + this.f200945k + ", arkLabelWording=" + this.f200946l + ", labels=" + this.f200947m + ", jumpType=" + this.f200948n + '}';
    }
}
