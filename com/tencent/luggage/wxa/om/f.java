package com.tencent.luggage.wxa.om;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements b {

    /* renamed from: i, reason: collision with root package name */
    public static long f137028i;

    /* renamed from: h, reason: collision with root package name */
    public List f137029h = new ArrayList(10);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f137030a;

        public a(long j3) {
            this.f137030a = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(this.f137030a);
            f.this.b();
        }
    }

    public f(List list) {
        if (list != null && !list.isEmpty()) {
            this.f137029h.addAll(list);
        }
    }

    public final void b() {
        String str;
        w.d("MicroMsg.Music.PieceCacheCleanController", "clean music piece file");
        String a16 = e.a();
        if (a16.endsWith("/")) {
            str = a16 + "music";
        } else {
            str = a16 + "/music";
        }
        v vVar = new v(str);
        if (vVar.e() && vVar.p()) {
            String[] t16 = vVar.t();
            if (t16 != null && t16.length != 0) {
                for (String str2 : t16) {
                    if (a(str2)) {
                        w.d("MicroMsg.Music.PieceCacheCleanController", "file is the block file, don't delete");
                    } else {
                        v vVar2 = new v(str + "/" + str2);
                        if (!vVar2.e()) {
                            w.d("MicroMsg.Music.PieceCacheCleanController", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                        } else if (vVar2.p()) {
                            w.d("MicroMsg.Music.PieceCacheCleanController", "file is directory, don't delete");
                        } else if (System.currentTimeMillis() - vVar2.r() > b.f137016a.longValue()) {
                            w.b("MicroMsg.Music.PieceCacheCleanController", "Clean 7 days file in music file name=%s, path:%s", vVar2.i(), vVar2.g());
                            vVar2.d();
                            if (str2.startsWith("piece")) {
                                w.b("MicroMsg.Music.PieceCacheCleanController", "file is piece prefix, delete the piece info in db");
                                e.a(str2);
                            }
                        } else {
                            w.d("MicroMsg.Music.PieceCacheCleanController", "not delete the file, file is in valid time for 7 day");
                        }
                    }
                }
                return;
            }
            w.d("MicroMsg.Music.PieceCacheCleanController", "none files exist");
            return;
        }
        w.d("MicroMsg.Music.PieceCacheCleanController", "musicFolder is not exist or not Directory");
    }

    public final void c() {
        if (f137028i == 0) {
            f137028i = e.b();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f137028i <= b.f137021f.longValue()) {
            w.b("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
            return;
        }
        f137028i = currentTimeMillis;
        w.d("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
        com.tencent.luggage.wxa.co.a.a(new a(currentTimeMillis), "PieceCacheCleanController");
    }

    @Override // com.tencent.luggage.wxa.om.b
    public void a() {
        c();
    }

    public final boolean a(String str) {
        Iterator it = this.f137029h.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
