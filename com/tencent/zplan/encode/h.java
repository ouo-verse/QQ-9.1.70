package com.tencent.zplan.encode;

import android.text.TextUtils;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.zplan.encode.g;
import com.tencent.zplan.encode.utils.MediaCodecEncodeType;
import com.tencent.zplan.encode.utils.d;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private static h f385440c = new h();

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, g> f385441a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f385442b = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements com.tencent.zplan.encode.utils.c {

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.zplan.encode.utils.c f385443a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.encode.utils.c f385444b;

        a(com.tencent.zplan.encode.utils.c cVar) {
            this.f385444b = cVar;
            this.f385443a = cVar;
        }

        @Override // com.tencent.zplan.encode.utils.c
        public void a(int i3, int i16) {
            g gVar = (g) h.this.f385441a.remove(Integer.valueOf(i3));
            if (gVar != null) {
                this.f385443a.a(i3, i16);
                if (!TextUtils.isEmpty(gVar.k())) {
                    File file = new File(gVar.k());
                    d.e("SR_MP4_Manager", 1, "onTaskEnd, " + i3 + ", " + i16 + ", file.exist:" + file.exists() + ", file.size:" + file.length() + ", reportInfo:" + gVar.j().toString());
                }
                if (i16 != 0) {
                    d.b("SR_MP4_Manager", 2, "\u5408\u6210\u89c6\u9891\u5931\u8d25[code=" + i16 + "]");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f385446a;

        /* renamed from: b, reason: collision with root package name */
        public int f385447b;

        /* renamed from: c, reason: collision with root package name */
        public int f385448c;

        /* renamed from: l, reason: collision with root package name */
        public int f385457l;

        /* renamed from: m, reason: collision with root package name */
        public int f385458m;

        /* renamed from: n, reason: collision with root package name */
        public int f385459n;

        /* renamed from: p, reason: collision with root package name */
        public String f385461p;

        /* renamed from: q, reason: collision with root package name */
        public String f385462q;

        /* renamed from: d, reason: collision with root package name */
        public int f385449d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f385450e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f385451f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f385452g = true;

        /* renamed from: h, reason: collision with root package name */
        public d.i f385453h = new d.i();

        /* renamed from: i, reason: collision with root package name */
        public int f385454i = 16588800;

        /* renamed from: j, reason: collision with root package name */
        public int f385455j = 0;

        /* renamed from: k, reason: collision with root package name */
        public MediaCodecEncodeType f385456k = MediaCodecEncodeType.SURFACE;

        /* renamed from: o, reason: collision with root package name */
        public boolean f385460o = true;

        public String toString() {
            return "PrepareParams{videoFrameWidth=" + this.f385446a + ", videoFrameHeight=" + this.f385447b + ", videoFrameRate=" + this.f385448c + ", audioSampleRate=" + this.f385457l + ", audioChannel=" + this.f385458m + ", audioSampleNumPerFrame=" + this.f385459n + ", savePath='" + this.f385461p + "', tempPath=" + this.f385462q + '}';
        }
    }

    h() {
    }

    private g.e b(b bVar) {
        g.e eVar = new g.e();
        if (bVar.f385451f) {
            g.f fVar = new g.f();
            int i3 = bVar.f385446a;
            fVar.f385427f = i3;
            int i16 = bVar.f385447b;
            fVar.f385428g = i16;
            fVar.f385422a = bVar.f385448c;
            int i17 = bVar.f385449d;
            fVar.f385423b = i17;
            int i18 = fVar.f385432k;
            if (i18 == 0) {
                fVar.f385426e = (int) (i3 * i16 * 4 * 1.5d);
            } else {
                fVar.f385426e = (int) (i3 * 2 * i16 * 4 * 1.5d);
            }
            if (i17 == -1) {
                if (i18 == 0) {
                    fVar.f385423b = e(i3, i16);
                } else {
                    fVar.f385423b = e(i3 * 2, i16);
                }
            }
            int i19 = bVar.f385450e;
            if (i19 != -1) {
                fVar.f385424c = i19;
            }
            fVar.f385425d = 1;
            fVar.f385429h = bVar.f385452g;
            fVar.f385430i = bVar.f385453h;
            fVar.f385431j = bVar.f385454i;
            fVar.f385432k = bVar.f385455j;
            fVar.f385433l = bVar.f385456k;
            eVar.f385420c = fVar;
        }
        if (bVar.f385460o) {
            g.d dVar = new g.d();
            dVar.f385413b = bVar.f385457l;
            int i26 = bVar.f385458m;
            dVar.f385412a = i26;
            dVar.f385414c = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
            dVar.f385415d = 2;
            int i27 = bVar.f385459n;
            dVar.f385417f = i27;
            dVar.f385416e = i27 * 2 * i26 * 2;
            eVar.f385421d = dVar;
        }
        eVar.f385418a = bVar.f385461p;
        eVar.f385419b = bVar.f385462q;
        return eVar;
    }

    private void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static h d() {
        return f385440c;
    }

    private int e(int i3, int i16) {
        int max = Math.max(i3, i16);
        if (max >= 1920) {
            return 8500000;
        }
        return max >= 1280 ? 3500000 : 1800000;
    }

    private boolean f(String str) {
        Iterator<g> it = this.f385441a.values().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().k())) {
                return true;
            }
        }
        return false;
    }

    public void g(int i3) {
        g gVar = this.f385441a.get(Integer.valueOf(i3));
        if (gVar == null) {
            return;
        }
        gVar.h();
        gVar.u();
    }

    public void h(int i3, byte[] bArr, int i16, int i17) {
        g gVar = this.f385441a.get(Integer.valueOf(i3));
        if (gVar == null) {
            return;
        }
        gVar.o(bArr, i16, i17);
    }

    public int i(b bVar, com.tencent.zplan.encode.utils.c cVar) {
        d.e("SR_MP4_Manager", 1, "prepareTask:" + bVar.toString());
        if (f(bVar.f385461p)) {
            return -1;
        }
        c(bVar.f385461p);
        g.e b16 = b(bVar);
        int incrementAndGet = this.f385442b.incrementAndGet();
        d.e("SR_MP4_Manager", 1, "newTask, taskId:" + incrementAndGet);
        try {
            g gVar = new g(incrementAndGet, b16, new a(cVar));
            this.f385441a.put(Integer.valueOf(incrementAndGet), gVar);
            gVar.t();
            return incrementAndGet;
        } catch (Throwable th5) {
            d.c("SR_MP4_Manager", 1, "prepareTask, error: ", th5);
            return -1;
        }
    }
}
