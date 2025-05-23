package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class q {
    static IPatchRedirector $redirector_;
    private static final /* synthetic */ q[] A;

    /* renamed from: a, reason: collision with root package name */
    public static final q f248923a;

    /* renamed from: b, reason: collision with root package name */
    public static final q f248924b;

    /* renamed from: c, reason: collision with root package name */
    public static final q f248925c;

    /* renamed from: d, reason: collision with root package name */
    public static final q f248926d;

    /* renamed from: e, reason: collision with root package name */
    public static final q f248927e;

    /* renamed from: f, reason: collision with root package name */
    public static final q f248928f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f248929g;

    /* renamed from: h, reason: collision with root package name */
    public static final q f248930h;

    /* renamed from: i, reason: collision with root package name */
    public static final q f248931i;

    /* renamed from: j, reason: collision with root package name */
    public static final q f248932j;

    /* renamed from: k, reason: collision with root package name */
    public static final q f248933k;

    /* renamed from: l, reason: collision with root package name */
    public static final q f248934l;

    /* renamed from: m, reason: collision with root package name */
    public static final q f248935m;

    /* renamed from: n, reason: collision with root package name */
    public static final q f248936n;

    /* renamed from: o, reason: collision with root package name */
    public static final q f248937o;

    /* renamed from: p, reason: collision with root package name */
    public static final q f248938p;

    /* renamed from: q, reason: collision with root package name */
    public static final q f248939q;

    /* renamed from: r, reason: collision with root package name */
    public static final q f248940r;

    /* renamed from: s, reason: collision with root package name */
    public static final q f248941s;

    /* renamed from: t, reason: collision with root package name */
    public static final q f248942t;

    /* renamed from: u, reason: collision with root package name */
    public static final q f248943u;

    /* renamed from: v, reason: collision with root package name */
    public static final q f248944v;

    /* renamed from: w, reason: collision with root package name */
    public static final q f248945w;

    /* renamed from: x, reason: collision with root package name */
    public static final q f248946x;

    /* renamed from: y, reason: collision with root package name */
    public static final q f248947y;

    /* renamed from: z, reason: collision with root package name */
    public static final q f248948z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15534);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        q qVar = new q("connInit", 0);
        f248923a = qVar;
        q qVar2 = new q("connStarting", 1);
        f248924b = qVar2;
        q qVar3 = new q("connSucc", 2);
        f248925c = qVar3;
        q qVar4 = new q("connClosing", 3);
        f248926d = qVar4;
        q qVar5 = new q("connClosed", 4);
        f248927e = qVar5;
        q qVar6 = new q("interrupted", 5);
        f248928f = qVar6;
        q qVar7 = new q("connError_illegalargument", 6);
        f248929g = qVar7;
        q qVar8 = new q("connError_enotsock", 7);
        f248930h = qVar8;
        q qVar9 = new q("connError_permission", 8);
        f248931i = qVar9;
        q qVar10 = new q("connError_ebadFileNum", 9);
        f248932j = qVar10;
        q qVar11 = new q("connError_errno", 10);
        f248933k = qVar11;
        q qVar12 = new q("connError_enobufs", 11);
        f248934l = qVar12;
        q qVar13 = new q("connError_unreachable", 12);
        f248935m = qVar13;
        q qVar14 = new q("connError_invalidArgument", 13);
        f248936n = qVar14;
        q qVar15 = new q("connError_unresolved", 14);
        f248937o = qVar15;
        q qVar16 = new q("connError_unknownhost", 15);
        f248938p = qVar16;
        q qVar17 = new q("connError_noroute", 16);
        f248939q = qVar17;
        q qVar18 = new q("connError_reset", 17);
        f248940r = qVar18;
        q qVar19 = new q("connError_refused", 18);
        f248941s = qVar19;
        q qVar20 = new q("connError_timeout", 19);
        f248942t = qVar20;
        q qVar21 = new q("connError_unknown", 20);
        f248943u = qVar21;
        q qVar22 = new q("recvSsoRespSucc", 21);
        f248944v = qVar22;
        q qVar23 = new q("decodeSsoRespError", 22);
        f248945w = qVar23;
        q qVar24 = new q("recvSsoData", 23);
        f248946x = qVar24;
        q qVar25 = new q("recvSsoDataError", 24);
        f248947y = qVar25;
        q qVar26 = new q("quitAfterDualEnd", 25);
        f248948z = qVar26;
        A = new q[]{qVar, qVar2, qVar3, qVar4, qVar5, qVar6, qVar7, qVar8, qVar9, qVar10, qVar11, qVar12, qVar13, qVar14, qVar15, qVar16, qVar17, qVar18, qVar19, qVar20, qVar21, qVar22, qVar23, qVar24, qVar25, qVar26};
    }

    q(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static q a(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) A.clone();
    }
}
