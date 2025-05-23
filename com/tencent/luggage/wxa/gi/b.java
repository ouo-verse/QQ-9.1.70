package com.tencent.luggage.wxa.gi;

import com.tencent.luggage.wxa.hi.k;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static d f126762a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f126763b = false;

    public static void a(Class cls, String str) {
        List a16 = e.a(cls, null);
        if (a16 == null) {
            return;
        }
        b(str, ((k) a16.get(a16.size() - 1)).a());
        c.a(((k) a16.get(0)).a().d(), str);
    }

    public static void b(Class cls, String str) {
        List a16 = e.a(cls, null);
        if (a16 == null) {
            return;
        }
        b(str, ((k) a16.get(0)).a());
        c.b(((k) a16.get(0)).a().d(), str);
    }

    public static void c(String str, com.tencent.luggage.wxa.hi.b bVar) {
        if (f126763b) {
            f126762a.a(bVar.d(), "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str, bVar.name(), 0, "stepStart", "");
        }
        c.a(str, bVar);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2, long j3, long j16) {
        if (f126763b) {
            f126762a.a(bVar.d(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j3), str, bVar.name(), 0, "stepStart", str2);
            f126762a.a(bVar.d(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j16), str, bVar.name(), Integer.valueOf(bVar.b() ? 1 : 0), FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, str2);
        }
        c.a(str, bVar, str2, j16 - j3);
    }

    public static void b(String str, com.tencent.luggage.wxa.hi.b bVar) {
        b(str, bVar, "");
    }

    public static void b(String str, com.tencent.luggage.wxa.hi.b bVar, String str2) {
        if (f126763b) {
            a(bVar.d(), str, bVar.name(), bVar.b(), str2);
        }
        c.a(str, bVar, str2);
    }

    public static void a(String str, String str2, String str3, boolean z16, String str4) {
        f126762a.a(str, "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str2, str3, Integer.valueOf(z16 ? 1 : 0), FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, str4);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2, String str3, long j3, long j16) {
        if (f126763b) {
            f126762a.a(bVar.d(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j3), str, bVar.name(), 0, "stepStart", str3);
            f126762a.a(bVar.d(), "%d|%s|%s|%d|%s|%s", Long.valueOf(j16), str, bVar.name(), Integer.valueOf(bVar.b() ? 1 : 0), String.format("fail:%s", str2), str3);
        }
        c.a(str, bVar, str2, str3);
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar) {
        a(str, bVar, "");
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2) {
        a(str, bVar, str2, "");
    }

    public static void a(String str, com.tencent.luggage.wxa.hi.b bVar, String str2, String str3) {
        if (f126763b) {
            a(bVar.d(), str, bVar.name(), bVar.b(), str2, str3);
        }
        c.a(str, bVar, str2, str3);
    }

    public static void a(String str, String str2, String str3, boolean z16, String str4, String str5) {
        f126762a.a(str, "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str2, str3, Integer.valueOf(z16 ? 1 : 0), String.format("fail:%s", str4), str5);
    }

    public static void a(Class cls, String str, String str2) {
        String a16;
        if (f126763b && (a16 = e.a(cls)) != null) {
            f126762a.a(a16, "%d|%s|%s|%d|%s|%s", Long.valueOf(System.currentTimeMillis()), str, "CollectKeyInfo", 0, "", str2);
        }
    }
}
