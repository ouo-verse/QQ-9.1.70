package com.tencent.tgpa.lite.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {
    static IPatchRedirector $redirector_;
    public static final a A;
    private static final /* synthetic */ a[] B;

    /* renamed from: b, reason: collision with root package name */
    public static final a f375882b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f375883c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f375884d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f375885e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f375886f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f375887g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f375888h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f375889i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f375890j;

    /* renamed from: k, reason: collision with root package name */
    public static final a f375891k;

    /* renamed from: l, reason: collision with root package name */
    public static final a f375892l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f375893m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f375894n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f375895o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f375896p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f375897q;

    /* renamed from: r, reason: collision with root package name */
    public static final a f375898r;

    /* renamed from: s, reason: collision with root package name */
    public static final a f375899s;

    /* renamed from: t, reason: collision with root package name */
    public static final a f375900t;

    /* renamed from: u, reason: collision with root package name */
    public static final a f375901u;

    /* renamed from: v, reason: collision with root package name */
    public static final a f375902v;

    /* renamed from: w, reason: collision with root package name */
    public static final a f375903w;

    /* renamed from: x, reason: collision with root package name */
    public static final a f375904x;

    /* renamed from: y, reason: collision with root package name */
    public static final a f375905y;

    /* renamed from: z, reason: collision with root package name */
    public static final a f375906z;

    /* renamed from: a, reason: collision with root package name */
    private int f375907a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        a aVar = new a("SUCCESS", 0, 0);
        f375882b = aVar;
        a aVar2 = new a("CANNT_FIND_LOCAL_CONFIG", 1, 1);
        f375883c = aVar2;
        a aVar3 = new a("CANNT_READ_LOCAL_CONFIG", 2, 2);
        f375884d = aVar3;
        a aVar4 = new a("READ_LOCAL_CONFIG_EXCEPTION", 3, 3);
        f375885e = aVar4;
        a aVar5 = new a("GET_LOCAL_CONFIG_EMPTY", 4, 4);
        f375886f = aVar5;
        a aVar6 = new a("PARSE_JSON_CONFIG_EXCEPTION", 5, 5);
        f375887g = aVar6;
        a aVar7 = new a("PARSE_JSON_VALUE_EXCEPTION", 6, 6);
        f375888h = aVar7;
        a aVar8 = new a("START_SERVER_FAILED", 7, 7);
        f375889i = aVar8;
        a aVar9 = new a("INIT_THREAD_TIMEOUT", 8, 8);
        f375890j = aVar9;
        a aVar10 = new a("REALLY_INIT_EXCEPTION", 9, 9);
        f375891k = aVar10;
        a aVar11 = new a("CONTEXT_IS_NULL", 10, 10);
        f375892l = aVar11;
        a aVar12 = new a("DOWNLOAD_NEW_CONFIG_IOEXCEPTION", 11, 11);
        f375893m = aVar12;
        a aVar13 = new a("DOWNLOAD_NEW_CONFIG_EMPTY", 12, 12);
        f375894n = aVar13;
        a aVar14 = new a("DOWNLOAD_NEW_CONFIG_SAVE_FILE_EXCEPTION", 13, 13);
        f375895o = aVar14;
        a aVar15 = new a("DOWNLOAD_NEW_CODE_EXCEPTION", 14, 14);
        f375896p = aVar15;
        a aVar16 = new a("DOWNLOAD_NEW_CONFIG_CONTENT_JSON_ERROR", 15, 15);
        f375897q = aVar16;
        a aVar17 = new a("DOWNLOAD_NEW_CONFIG_CONTENT_ERROR", 16, 16);
        f375898r = aVar17;
        a aVar18 = new a("DOWNLOAD_NEW_CONFIG_HAS_NO_RET", 17, 17);
        f375899s = aVar18;
        a aVar19 = new a("DOWNLOAD_NEW_CONFIG_RET_IS_NOT_0", 18, 18);
        f375900t = aVar19;
        a aVar20 = new a("DOWNLOAD_NEW_CONFIG_HAS_NO_DATA", 19, 19);
        f375901u = aVar20;
        a aVar21 = new a("DOWNLOAD_NEW_CONFIG_DATA_IS_NULL", 20, 20);
        f375902v = aVar21;
        a aVar22 = new a("DOWNLOAD_NEW_CONFIG_EXCEPTION", 21, 21);
        f375903w = aVar22;
        a aVar23 = new a("LOCAL_CONFIG_NO_CONTEXT", 22, 51);
        f375904x = aVar23;
        a aVar24 = new a("LOCAL_CONFIG_NOT_EXSIT", 23, 52);
        f375905y = aVar24;
        a aVar25 = new a("LOCAL_CONFIG_READ_EXCEPTION", 24, 53);
        f375906z = aVar25;
        a aVar26 = new a("LOCAL_CONFIG_CONTENT_PARSE_ERROR", 25, 54);
        A = aVar26;
        B = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20, aVar21, aVar22, aVar23, aVar24, aVar25, aVar26};
    }

    a(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f375907a = i16;
        }
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) B.clone();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return String.valueOf(this.f375907a);
    }
}
