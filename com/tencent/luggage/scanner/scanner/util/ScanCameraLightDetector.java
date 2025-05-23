package com.tencent.luggage.scanner.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.cq.d;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScanCameraLightDetector {

    /* renamed from: h, reason: collision with root package name */
    public static final ScanCameraLightDetector f120177h = new ScanCameraLightDetector();

    /* renamed from: b, reason: collision with root package name */
    public String f120179b;

    /* renamed from: c, reason: collision with root package name */
    public int f120180c;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f120183f;

    /* renamed from: g, reason: collision with root package name */
    public b0 f120184g;

    /* renamed from: a, reason: collision with root package name */
    public final int f120178a = 2;

    /* renamed from: d, reason: collision with root package name */
    public long f120181d = -1;

    /* renamed from: e, reason: collision with root package name */
    public float f120182e = -1.0f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends b0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.scanner.scanner.util.ScanCameraLightDetector$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC5966a implements Runnable {
            public RunnableC5966a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.c4.a aVar = new com.tencent.luggage.wxa.c4.a();
                aVar.f123287d.f123288a = true;
                aVar.c();
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.c4.a aVar = new com.tencent.luggage.wxa.c4.a();
                aVar.f123287d.f123288a = false;
                aVar.c();
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            b bVar;
            if (message.what == 233 && (bVar = (b) message.obj) != null) {
                long a16 = w0.a();
                boolean b16 = ScanCameraLightDetector.this.b(bVar.f120188a, bVar.f120189b, bVar.f120190c);
                w.d("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", Boolean.valueOf(b16), Float.valueOf(ScanCameraLightDetector.this.f120182e), Long.valueOf(w0.e(a16)));
                if (b16) {
                    w.d("MicroMsg.ScanCameraLightDetector", "is dark now");
                    ScanCameraLightDetector.c(ScanCameraLightDetector.this);
                    if (!ScanCameraLightDetector.this.f120179b.equals("continuous-video") || ScanCameraLightDetector.this.f120180c >= 2) {
                        ScanCameraLightDetector.this.f120180c = 0;
                        c0.a(new RunnableC5966a());
                        return;
                    }
                    return;
                }
                w.d("MicroMsg.ScanCameraLightDetector", "not dark");
                ScanCameraLightDetector.this.f120180c = 0;
                c0.a(new b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f120188a;

        /* renamed from: b, reason: collision with root package name */
        public int f120189b;

        /* renamed from: c, reason: collision with root package name */
        public int f120190c;

        public b() {
        }

        public /* synthetic */ b(ScanCameraLightDetector scanCameraLightDetector, a aVar) {
            this();
        }
    }

    static {
        h.b("wmpfcommonjni", ScanCameraLightDetector.class.getClassLoader());
    }

    public static /* synthetic */ int c(ScanCameraLightDetector scanCameraLightDetector) {
        int i3 = scanCameraLightDetector.f120180c;
        scanCameraLightDetector.f120180c = i3 + 1;
        return i3;
    }

    private static native int calcLumNative(byte[] bArr, int i3, int i16);

    public void b() {
        try {
            this.f120181d = -1L;
            HandlerThread handlerThread = this.f120183f;
            if (handlerThread != null) {
                handlerThread.quit();
            }
        } catch (Exception e16) {
            w.a("MicroMsg.ScanCameraLightDetector", e16, "stop error: %s", e16.getMessage());
        }
    }

    public void a(String str) {
        try {
            this.f120179b = str;
            a();
        } catch (Exception e16) {
            w.a("MicroMsg.ScanCameraLightDetector", e16, "start error: %s", e16.getMessage());
        }
    }

    public final boolean b(byte[] bArr, int i3, int i16) {
        if (!w0.b(bArr) && bArr.length > i3 * i16) {
            int calcLumNative = calcLumNative(bArr, i3, i16);
            w.d("MicroMsg.ScanCameraLightDetector", "lum light: %s", Integer.valueOf(calcLumNative));
            if (calcLumNative < 50) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        w.d("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
        b();
        HandlerThread c16 = d.c("ScanCameraLightDetector_detectThread", 5);
        this.f120183f = c16;
        c16.start();
        this.f120184g = new a(this.f120183f.getLooper());
    }

    public void a(byte[] bArr, int i3, int i16) {
        HandlerThread handlerThread;
        long j3 = this.f120181d;
        if ((j3 < 0 || w0.e(j3) >= 1000) && this.f120184g != null && (handlerThread = this.f120183f) != null && handlerThread.isAlive()) {
            b bVar = new b(this, null);
            bVar.f120188a = bArr;
            bVar.f120189b = i3;
            bVar.f120190c = i16;
            Message obtain = Message.obtain();
            obtain.what = 233;
            obtain.obj = bVar;
            this.f120184g.a(obtain);
            this.f120181d = w0.a();
        }
    }
}
