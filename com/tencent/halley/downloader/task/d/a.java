package com.tencent.halley.downloader.task.d;

import android.text.TextUtils;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static EnumC1249a[] f113888a;

    /* renamed from: b, reason: collision with root package name */
    public static EnumC1249a[] f113889b;

    /* renamed from: c, reason: collision with root package name */
    public String f113890c;

    /* renamed from: d, reason: collision with root package name */
    public EnumC1249a f113891d;

    /* renamed from: e, reason: collision with root package name */
    public int f113892e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f113893f;

    /* renamed from: g, reason: collision with root package name */
    public String f113894g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f113895h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class EnumC1249a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final EnumC1249a f113896a;

        /* renamed from: b, reason: collision with root package name */
        public static final EnumC1249a f113897b;

        /* renamed from: c, reason: collision with root package name */
        public static final EnumC1249a f113898c;

        /* renamed from: d, reason: collision with root package name */
        public static final EnumC1249a f113899d;

        /* renamed from: e, reason: collision with root package name */
        public static final EnumC1249a f113900e;

        /* renamed from: f, reason: collision with root package name */
        public static final EnumC1249a f113901f;

        /* renamed from: g, reason: collision with root package name */
        public static final EnumC1249a f113902g;

        /* renamed from: h, reason: collision with root package name */
        public static final EnumC1249a f113903h;

        /* renamed from: i, reason: collision with root package name */
        public static final EnumC1249a f113904i;

        /* renamed from: j, reason: collision with root package name */
        public static final EnumC1249a f113905j;

        /* renamed from: k, reason: collision with root package name */
        public static final EnumC1249a f113906k;

        /* renamed from: l, reason: collision with root package name */
        public static final EnumC1249a f113907l;

        /* renamed from: m, reason: collision with root package name */
        public static final EnumC1249a f113908m;

        /* renamed from: n, reason: collision with root package name */
        private static final /* synthetic */ EnumC1249a[] f113909n;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16619);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EnumC1249a enumC1249a = new EnumC1249a("Type_Outer", 0);
            f113896a = enumC1249a;
            EnumC1249a enumC1249a2 = new EnumC1249a("Type_CDN_Domain", 1);
            f113897b = enumC1249a2;
            EnumC1249a enumC1249a3 = new EnumC1249a("Type_CDN_Ip_App_Input", 2);
            f113898c = enumC1249a3;
            EnumC1249a enumC1249a4 = new EnumC1249a("Type_CDN_Ip_Jumped", 3);
            f113899d = enumC1249a4;
            EnumC1249a enumC1249a5 = new EnumC1249a("Type_CDN_Ip_Http_Header", 4);
            f113900e = enumC1249a5;
            EnumC1249a enumC1249a6 = new EnumC1249a("Type_CDN_Ip_Socket_Schedule", 5);
            f113901f = enumC1249a6;
            EnumC1249a enumC1249a7 = new EnumC1249a("Type_Src_Domain", 6);
            f113902g = enumC1249a7;
            EnumC1249a enumC1249a8 = new EnumC1249a("Type_Src_Ip_App_Input", 7);
            f113903h = enumC1249a8;
            EnumC1249a enumC1249a9 = new EnumC1249a("Type_Src_Ip_Jumped", 8);
            f113904i = enumC1249a9;
            EnumC1249a enumC1249a10 = new EnumC1249a("Type_CDN_Ip_Socket_Schedule_Https", 9);
            f113905j = enumC1249a10;
            EnumC1249a enumC1249a11 = new EnumC1249a("Type_CDN_Ip_User_Https", 10);
            f113906k = enumC1249a11;
            EnumC1249a enumC1249a12 = new EnumC1249a("Type_CDN_Ip_Pre_Dns_Parse", 11);
            f113907l = enumC1249a12;
            EnumC1249a enumC1249a13 = new EnumC1249a("Type_CDN_Ip_Http_Dns", 12);
            f113908m = enumC1249a13;
            f113909n = new EnumC1249a[]{enumC1249a, enumC1249a2, enumC1249a3, enumC1249a4, enumC1249a5, enumC1249a6, enumC1249a7, enumC1249a8, enumC1249a9, enumC1249a10, enumC1249a11, enumC1249a12, enumC1249a13};
        }

        EnumC1249a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EnumC1249a valueOf(String str) {
            return (EnumC1249a) Enum.valueOf(EnumC1249a.class, str);
        }

        public static EnumC1249a[] values() {
            return (EnumC1249a[]) f113909n.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        EnumC1249a enumC1249a = EnumC1249a.f113907l;
        EnumC1249a enumC1249a2 = EnumC1249a.f113908m;
        EnumC1249a enumC1249a3 = EnumC1249a.f113898c;
        EnumC1249a enumC1249a4 = EnumC1249a.f113897b;
        EnumC1249a enumC1249a5 = EnumC1249a.f113901f;
        EnumC1249a enumC1249a6 = EnumC1249a.f113900e;
        EnumC1249a enumC1249a7 = EnumC1249a.f113905j;
        EnumC1249a enumC1249a8 = EnumC1249a.f113899d;
        EnumC1249a enumC1249a9 = EnumC1249a.f113903h;
        EnumC1249a enumC1249a10 = EnumC1249a.f113904i;
        EnumC1249a enumC1249a11 = EnumC1249a.f113902g;
        f113888a = new EnumC1249a[]{enumC1249a, enumC1249a2, enumC1249a3, enumC1249a4, enumC1249a5, enumC1249a6, enumC1249a7, enumC1249a8, enumC1249a9, enumC1249a10, enumC1249a11};
        f113889b = new EnumC1249a[]{enumC1249a, enumC1249a2, enumC1249a5, enumC1249a3, enumC1249a6, enumC1249a8, enumC1249a7, enumC1249a4, enumC1249a9, enumC1249a10, enumC1249a11};
    }

    public a(String str, EnumC1249a enumC1249a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) enumC1249a);
            return;
        }
        this.f113892e = 0;
        this.f113893f = false;
        this.f113894g = "";
        this.f113895h = false;
        this.f113890c = str;
        this.f113891d = enumC1249a;
    }

    public static EnumC1249a a(EnumC1249a enumC1249a, boolean z16) {
        EnumC1249a[] enumC1249aArr = z16 ? f113888a : f113889b;
        EnumC1249a enumC1249a2 = enumC1249aArr[0];
        if (enumC1249a == null) {
            return enumC1249a2;
        }
        for (int i3 = 0; i3 < enumC1249aArr.length; i3++) {
            if (enumC1249a == enumC1249aArr[i3] && i3 != enumC1249aArr.length - 1) {
                return enumC1249aArr[i3 + 1];
            }
        }
        return enumC1249a2;
    }

    public static boolean b(EnumC1249a enumC1249a) {
        if (enumC1249a == EnumC1249a.f113898c || enumC1249a == EnumC1249a.f113900e || enumC1249a == EnumC1249a.f113901f || enumC1249a == EnumC1249a.f113907l || enumC1249a == EnumC1249a.f113908m || enumC1249a == EnumC1249a.f113905j || enumC1249a == EnumC1249a.f113903h) {
            return true;
        }
        return false;
    }

    public final String toString() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        EnumC1249a enumC1249a = this.f113891d;
        if (enumC1249a != EnumC1249a.f113900e && enumC1249a != EnumC1249a.f113901f && enumC1249a != EnumC1249a.f113905j && enumC1249a != EnumC1249a.f113898c && enumC1249a != EnumC1249a.f113903h) {
            z16 = false;
        } else {
            z16 = true;
        }
        return this.f113892e + ":" + this.f113891d.ordinal() + ":" + j.a(this.f113890c, z16);
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? !TextUtils.isEmpty(this.f113894g) ? this.f113894g : this.f113890c : (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public static boolean a(EnumC1249a enumC1249a) {
        return enumC1249a == EnumC1249a.f113898c || enumC1249a == EnumC1249a.f113899d || enumC1249a == EnumC1249a.f113900e || enumC1249a == EnumC1249a.f113907l || enumC1249a == EnumC1249a.f113908m || enumC1249a == EnumC1249a.f113901f || enumC1249a == EnumC1249a.f113903h || enumC1249a == EnumC1249a.f113904i || enumC1249a == EnumC1249a.f113905j;
    }
}
