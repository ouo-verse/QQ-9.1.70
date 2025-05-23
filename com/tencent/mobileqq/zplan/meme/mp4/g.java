package com.tencent.mobileqq.zplan.meme.mp4;

import android.text.TextUtils;
import com.tencent.mobileqq.zplan.meme.mp4.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes34.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    private static g f334170c = new g();

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, f> f334171a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f334172b = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements f.d {

        /* renamed from: a, reason: collision with root package name */
        private f.d f334173a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.d f334174b;

        a(f.d dVar) {
            this.f334174b = dVar;
            this.f334173a = dVar;
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.f.d
        public void a(int i3, int i16) {
            f fVar = (f) g.this.f334171a.remove(Integer.valueOf(i3));
            if (fVar != null) {
                this.f334173a.a(i3, i16);
                if (TextUtils.isEmpty(fVar.k())) {
                    return;
                }
                File file = new File(fVar.k());
                QLog.i("SR_MP4_Manager", 1, "onTaskEnd, " + i3 + ", " + i16 + ", file.exist:" + file.exists() + ", file.size:" + file.length() + ", reportInfo:" + fVar.j().toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f334176a;

        /* renamed from: b, reason: collision with root package name */
        public int f334177b;

        /* renamed from: c, reason: collision with root package name */
        public int f334178c;

        /* renamed from: d, reason: collision with root package name */
        public int f334179d;

        /* renamed from: e, reason: collision with root package name */
        public int f334180e;

        /* renamed from: f, reason: collision with root package name */
        public int f334181f;

        /* renamed from: g, reason: collision with root package name */
        public String f334182g;

        public String toString() {
            return "PrepareParams{videoFrameWidth=" + this.f334176a + ", videoFrameHeight=" + this.f334177b + ", videoFrameRate=" + this.f334178c + ", audioSampleRate=" + this.f334179d + ", audioChannel=" + this.f334180e + ", audioSampleNumPerFrame=" + this.f334181f + ", savePath='" + this.f334182g + "'}";
        }
    }

    g() {
    }

    private f.e b(b bVar) {
        f.e eVar = new f.e();
        int i3 = bVar.f334176a;
        eVar.f334156f = i3;
        int i16 = bVar.f334177b;
        eVar.f334157g = i16;
        eVar.f334152b = bVar.f334178c;
        eVar.f334153c = e(i3, i16);
        eVar.f334155e = (int) (eVar.f334156f * eVar.f334157g * 4 * 1.5d);
        eVar.f334154d = 1;
        eVar.f334159i = bVar.f334179d;
        int i17 = bVar.f334180e;
        eVar.f334158h = i17;
        eVar.f334160j = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        eVar.f334161k = 2;
        int i18 = bVar.f334181f;
        eVar.f334163m = i18;
        eVar.f334162l = i18 * 2 * i17 * 2;
        eVar.f334151a = bVar.f334182g;
        return eVar;
    }

    private void c(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static g d() {
        return f334170c;
    }

    private int e(int i3, int i16) {
        int max = Math.max(i3, i16);
        if (max >= 1920) {
            return 8500000;
        }
        return max >= 1280 ? 3500000 : 1800000;
    }

    private boolean f(String str) {
        Iterator<f> it = this.f334171a.values().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().k())) {
                return true;
            }
        }
        return false;
    }

    public void g(int i3, byte[] bArr, int i16, int i17) {
        f fVar = this.f334171a.get(Integer.valueOf(i3));
        if (fVar == null) {
            return;
        }
        fVar.o(bArr, i16, i17);
    }

    public void h(int i3) {
        f fVar = this.f334171a.get(Integer.valueOf(i3));
        if (fVar == null) {
            return;
        }
        fVar.h();
        fVar.v();
    }

    public void i(int i3, byte[] bArr, int i16, int i17) {
        f fVar = this.f334171a.get(Integer.valueOf(i3));
        if (fVar == null) {
            return;
        }
        fVar.p(bArr, i16, i17);
    }

    public int j(b bVar, f.d dVar) {
        QLog.i("SR_MP4_Manager", 1, "prepareTask:" + bVar.toString());
        if (f(bVar.f334182g)) {
            return -1;
        }
        c(bVar.f334182g);
        f.e b16 = b(bVar);
        int incrementAndGet = this.f334172b.incrementAndGet();
        QLog.i("SR_MP4_Manager", 1, "newTask, taskId:" + incrementAndGet);
        try {
            f fVar = new f(incrementAndGet, b16, new a(dVar));
            this.f334171a.put(Integer.valueOf(incrementAndGet), fVar);
            fVar.u();
            return incrementAndGet;
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Manager", 1, "prepareTask, error: ", th5);
            return -1;
        }
    }
}
