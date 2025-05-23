package com.tencent.hlyyb.downloader.e.f;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static int[] f114529g;

    /* renamed from: h, reason: collision with root package name */
    public static int[] f114530h;

    /* renamed from: a, reason: collision with root package name */
    public String f114531a;

    /* renamed from: b, reason: collision with root package name */
    public int f114532b;

    /* renamed from: c, reason: collision with root package name */
    public int f114533c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f114534d;

    /* renamed from: e, reason: collision with root package name */
    public String f114535e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f114536f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.e.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class EnumC5821a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final int f114537a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f114538b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f114539c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f114540d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f114541e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f114542f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f114543g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final int f114544h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final int f114545i = 9;

        /* renamed from: j, reason: collision with root package name */
        public static final int f114546j = 10;

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int[] f114547k;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13492);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f114547k = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            }
        }

        public static int[] a() {
            return (int[]) f114547k.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19362);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int i3 = EnumC5821a.f114539c;
        int i16 = EnumC5821a.f114538b;
        int i17 = EnumC5821a.f114542f;
        int i18 = EnumC5821a.f114541e;
        int i19 = EnumC5821a.f114546j;
        int i26 = EnumC5821a.f114540d;
        int i27 = EnumC5821a.f114544h;
        int i28 = EnumC5821a.f114545i;
        int i29 = EnumC5821a.f114543g;
        f114529g = new int[]{i3, i16, i17, i18, i19, i26, i27, i28, i29};
        f114530h = new int[]{i17, i3, i18, i26, i19, i16, i27, i28, i29};
    }

    public a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f114533c = 0;
        this.f114534d = false;
        this.f114535e = "";
        this.f114536f = false;
        this.f114531a = str;
        this.f114532b = i3;
    }

    public static int a(int i3, boolean z16) {
        int[] iArr;
        if (z16) {
            iArr = f114529g;
        } else {
            iArr = f114530h;
        }
        int i16 = iArr[0];
        if (i3 != 0) {
            for (int i17 = 0; i17 < iArr.length; i17++) {
                if (i3 == iArr[i17] && i17 != iArr.length - 1) {
                    return iArr[i17 + 1];
                }
            }
            return i16;
        }
        return i16;
    }

    public static boolean b(int i3) {
        if (i3 != EnumC5821a.f114539c && i3 != EnumC5821a.f114540d && i3 != EnumC5821a.f114541e && i3 != EnumC5821a.f114542f && i3 != EnumC5821a.f114544h && i3 != EnumC5821a.f114545i && i3 != EnumC5821a.f114546j) {
            return false;
        }
        return true;
    }

    public static boolean c(int i3) {
        if (i3 != EnumC5821a.f114539c && i3 != EnumC5821a.f114541e && i3 != EnumC5821a.f114542f && i3 != EnumC5821a.f114544h && i3 != EnumC5821a.f114546j) {
            return false;
        }
        return true;
    }

    public final String toString() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        int i3 = this.f114532b;
        if (i3 != EnumC5821a.f114541e && i3 != EnumC5821a.f114542f && i3 != EnumC5821a.f114546j && i3 != EnumC5821a.f114539c && i3 != EnumC5821a.f114544h) {
            z16 = false;
        } else {
            z16 = true;
        }
        return this.f114533c + ":" + (this.f114532b - 1) + ":" + com.tencent.hlyyb.common.b.b.a(this.f114531a, z16);
    }
}
