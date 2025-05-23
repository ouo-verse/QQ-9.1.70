package com.tencent.luggage.wxa.f9;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    public static final Long f125559c = 2592000000L;

    /* renamed from: d, reason: collision with root package name */
    public static final Long f125560d = 604800000L;

    /* renamed from: e, reason: collision with root package name */
    public static final Long f125561e = 259200000L;

    /* renamed from: f, reason: collision with root package name */
    public static final Long f125562f = 172800000L;

    /* renamed from: g, reason: collision with root package name */
    public static final Long f125563g = 86400000L;

    /* renamed from: h, reason: collision with root package name */
    public static final Long f125564h = 43200000L;

    /* renamed from: i, reason: collision with root package name */
    public static final Long f125565i = 240000L;

    /* renamed from: j, reason: collision with root package name */
    public static final Long f125566j = 86400000L;

    /* renamed from: k, reason: collision with root package name */
    public static final Long f125567k = 60000L;

    /* renamed from: l, reason: collision with root package name */
    public static long f125568l = 0;

    /* renamed from: a, reason: collision with root package name */
    public List f125569a = new ArrayList(10);

    /* renamed from: b, reason: collision with root package name */
    public String f125570b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.g9.l {
        public a(String str, int i3) {
            super(str, i3);
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a();
            com.tencent.luggage.wxa.g9.k.d(this);
        }
    }

    public g(List list) {
        if (list != null && !list.isEmpty()) {
            this.f125569a.addAll(list);
        }
    }

    public void b(String str) {
        this.f125570b = str;
        b();
    }

    public final void c(String str) {
        v vVar = new v(str);
        if (vVar.e() && vVar.p()) {
            String[] t16 = vVar.t();
            if (t16 != null && t16.length != 0) {
                for (String str2 : t16) {
                    if (a(str2)) {
                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
                    } else {
                        String str3 = str + "/" + str2;
                        v vVar2 = new v(str3);
                        if (!vVar2.e()) {
                            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                        } else if (vVar2.p()) {
                            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete subFilePath:%s", str3);
                            c(str3);
                        } else if (System.currentTimeMillis() - vVar2.r() > f125562f.longValue()) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", vVar2.i(), vVar2.g());
                            vVar2.d();
                        }
                    }
                }
                return;
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
            return;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", str);
    }

    public final void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "clean mix convert file");
        c(com.tencent.luggage.wxa.m9.a.a().m());
    }

    public final void b() {
        if (f125568l == 0) {
            f125568l = 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f125568l <= f125566j.longValue()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
            return;
        }
        f125568l = currentTimeMillis;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
        com.tencent.luggage.wxa.g9.k.b(new a("clean audio mix convert cache", 5));
    }

    public final boolean a(String str) {
        Iterator it = this.f125569a.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
