package com.tencent.mobileqq.weiyun.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements Cloneable {
    static IPatchRedirector $redirector_;
    public final String C;
    public final String D;
    public String E;
    public final String F;
    public b G;

    /* renamed from: d, reason: collision with root package name */
    public final int f315157d;

    /* renamed from: e, reason: collision with root package name */
    public final String f315158e;

    /* renamed from: f, reason: collision with root package name */
    public final String f315159f;

    /* renamed from: h, reason: collision with root package name */
    public final String f315160h;

    /* renamed from: i, reason: collision with root package name */
    public final long f315161i;

    /* renamed from: m, reason: collision with root package name */
    public final int f315162m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Cloneable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f315163d;

        /* renamed from: e, reason: collision with root package name */
        public int f315164e;

        /* renamed from: f, reason: collision with root package name */
        public String f315165f;

        /* renamed from: h, reason: collision with root package name */
        public String f315166h;

        /* renamed from: i, reason: collision with root package name */
        public String f315167i;

        /* renamed from: m, reason: collision with root package name */
        public String f315168m;

        /* synthetic */ b(a aVar, String str, int i3, String str2, String str3, String str4, String str5, C8980a c8980a) {
            this(str, i3, str2, str3, str4, str5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, aVar, str, Integer.valueOf(i3), str2, str3, str4, str5, c8980a);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        b(String str, int i3, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, Integer.valueOf(i3), str2, str3, str4, str5);
                return;
            }
            this.f315163d = str;
            this.f315164e = i3;
            this.f315165f = str2;
            this.f315166h = str3;
            this.f315167i = str4;
            this.f315168m = str5;
        }
    }

    a(int i3, String str, String str2, String str3, long j3, int i16, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, Long.valueOf(j3), Integer.valueOf(i16), str4, str5, str6);
            return;
        }
        this.f315157d = i3;
        this.f315158e = str;
        this.f315159f = str2;
        this.f315160h = str3;
        this.f315161i = j3;
        this.f315162m = i16;
        this.C = str4;
        this.D = str5;
        this.F = str6;
    }

    public static a b(int i3, String str, String str2, String str3, long j3, int i16, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && j3 >= 0) {
            return new a(i3, str, str2, str3.toLowerCase(), j3, i16, str4, str5, str6);
        }
        throw new IllegalArgumentException("The params fileName, pDirKey, fileId, sha and fileSize should be valid.");
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void c(String str, int i3, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, str3, str4, str5);
        } else {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return;
            }
            this.G = new b(this, str, i3, str2, str3, str4, str5, null);
        }
    }
}
