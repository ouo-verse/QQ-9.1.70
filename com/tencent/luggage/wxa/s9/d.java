package com.tencent.luggage.wxa.s9;

import com.tencent.luggage.wxa.p9.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f140202a;

    /* renamed from: b, reason: collision with root package name */
    public static int f140203b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap f140204c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static int f140205d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f140206e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static HashMap f140207f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public static int f140208g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static int f140209h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static HashMap f140210i = new HashMap();

    public static void a(int i3) {
        f140208g++;
        w.b("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i3), Integer.valueOf(f140208g), Integer.valueOf(f140209h));
        f140210i.put(Integer.valueOf(i3), w0.b().toString());
        a();
    }

    public static void b(int i3) {
        f140209h++;
        w.b("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i3), Integer.valueOf(f140208g), Integer.valueOf(f140209h));
        f140210i.remove(Integer.valueOf(i3));
    }

    public static void a() {
        com.tencent.luggage.wxa.p9.f fVar = new com.tencent.luggage.wxa.p9.f();
        if (f140202a - f140203b > 1) {
            f.a aVar = fVar.f137450d;
            aVar.f137451a = true;
            aVar.f137452b = f140204c.size();
        }
        if (f140208g - f140209h > 1) {
            f.a aVar2 = fVar.f137450d;
            aVar2.f137453c = true;
            aVar2.f137454d = f140210i.size();
        }
        if (f140205d - f140206e > 1) {
            f.a aVar3 = fVar.f137450d;
            aVar3.f137455e = true;
            aVar3.f137456f = f140207f.size();
        }
        f.a aVar4 = fVar.f137450d;
        if (aVar4.f137453c || aVar4.f137451a || aVar4.f137455e) {
            w.b("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(aVar4.f137451a), Integer.valueOf(fVar.f137450d.f137452b), Boolean.valueOf(fVar.f137450d.f137453c), Integer.valueOf(fVar.f137450d.f137454d), Boolean.valueOf(fVar.f137450d.f137455e), Integer.valueOf(fVar.f137450d.f137456f));
            fVar.c();
        }
    }
}
