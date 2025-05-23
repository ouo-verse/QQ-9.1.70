package com.tencent.luggage.wxa.ti;

import android.media.AudioRecord;
import android.util.Log;
import com.tencent.luggage.wxa.t9.h;
import com.tencent.luggage.wxa.t9.x;
import com.tencent.luggage.wxa.ti.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {
    public int A;

    /* renamed from: f, reason: collision with root package name */
    public int f141352f;

    /* renamed from: g, reason: collision with root package name */
    public int f141353g;

    /* renamed from: h, reason: collision with root package name */
    public int f141354h;

    /* renamed from: k, reason: collision with root package name */
    public int f141357k;

    /* renamed from: l, reason: collision with root package name */
    public int f141358l;

    /* renamed from: p, reason: collision with root package name */
    public int f141362p;

    /* renamed from: r, reason: collision with root package name */
    public int f141364r;

    /* renamed from: v, reason: collision with root package name */
    public boolean f141368v;

    /* renamed from: w, reason: collision with root package name */
    public AudioRecord f141369w;

    /* renamed from: x, reason: collision with root package name */
    public b f141370x;

    /* renamed from: y, reason: collision with root package name */
    public e f141371y;

    /* renamed from: z, reason: collision with root package name */
    public com.tencent.luggage.wxa.s9.e f141372z;

    /* renamed from: a, reason: collision with root package name */
    public int f141347a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f141348b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f141349c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f141350d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f141351e = 1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f141355i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f141356j = false;

    /* renamed from: m, reason: collision with root package name */
    public int f141359m = -123456789;

    /* renamed from: n, reason: collision with root package name */
    public boolean f141360n = false;

    /* renamed from: o, reason: collision with root package name */
    public long f141361o = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f141363q = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f141365s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f141366t = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f141367u = false;
    public int B = 1;
    public int C = 0;
    public e.a D = new C6757a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ti.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6757a implements e.a {
        public C6757a() {
        }

        @Override // com.tencent.luggage.wxa.ti.e.a
        public void a(int i3, byte[] bArr) {
            a.a(a.this, 1);
            if (a.this.f141368v && System.currentTimeMillis() - a.this.f141361o <= 1000 && a.this.f141366t - 10 > (System.currentTimeMillis() - a.this.f141361o) / a.this.f141354h) {
                a.this.f141367u = true;
            }
            if (i3 > 0) {
                a.this.a(bArr, i3);
            }
            if (a.this.f141356j) {
                if (i3 > 0) {
                    a.this.b(bArr, i3);
                } else {
                    a.this.a(i3);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3, int i16);

        void a(byte[] bArr, int i3);
    }

    public a(int i3, int i16, int i17) {
        int i18;
        this.f141352f = 1;
        this.f141353g = 8000;
        this.f141354h = 120;
        this.f141357k = 10;
        this.f141358l = -1;
        this.f141368v = false;
        this.A = 2;
        this.f141352f = i16;
        this.f141353g = i3;
        this.f141358l = i17;
        if (i16 == 2) {
            this.A = 3;
        } else {
            this.A = 2;
        }
        if (i17 == 0 && (i18 = x.f141187m.f141017l) > 0) {
            this.f141354h = i18;
        }
        com.tencent.luggage.wxa.t9.e eVar = x.f141187m;
        int i19 = eVar.f141039w;
        if (i19 > 0) {
            this.A = i19;
        }
        int i26 = eVar.f141007g;
        if (i26 > 0) {
            this.f141357k = i26;
        }
        this.f141368v = true;
        Log.i("MMPcmRecorder", String.format("MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(i3), Integer.valueOf(this.f141352f), Integer.valueOf(this.f141354h), Boolean.valueOf(this.f141355i), Integer.valueOf(this.f141358l)));
    }

    public final boolean f() {
        com.tencent.luggage.wxa.aa.c cVar = new com.tencent.luggage.wxa.aa.c();
        Log.i("MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
        if (this.f141369w != null) {
            Log.e("MMPcmRecorder", "start error ,is recording ");
            return false;
        }
        cVar.c();
        Log.d("MMPcmRecorder", "startRecordInternal, start init");
        if (!c()) {
            Log.e("MMPcmRecorder", "startRecord init error");
            return false;
        }
        Log.i("MMPcmRecorder", "init cost: " + cVar.a() + "ms");
        cVar.c();
        AudioMonitor.startRecording(this.f141369w);
        Log.i("MMPcmRecorder", "startRecording cost: " + cVar.a());
        if (this.f141369w.getRecordingState() != 3) {
            this.B = 2;
            this.f141347a = 4;
            Log.e("MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
            d();
            return false;
        }
        e eVar = this.f141371y;
        if (eVar != null) {
            return eVar.a();
        }
        Log.e("MMPcmRecorder", "mRecordMode is null");
        return false;
    }

    public synchronized boolean g() {
        if (true == this.f141365s) {
            Log.i("MMPcmRecorder", "already have stopped");
            return true;
        }
        this.f141365s = true;
        boolean h16 = h();
        if ((!this.f141363q && -1 != this.f141361o && System.currentTimeMillis() - this.f141361o >= 2000) || this.f141367u) {
            Log.i("MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
        }
        return h16;
    }

    public final boolean h() {
        com.tencent.luggage.wxa.aa.c cVar = new com.tencent.luggage.wxa.aa.c();
        cVar.c();
        e eVar = this.f141371y;
        if (eVar != null) {
            eVar.b();
            this.f141371y = null;
        }
        Log.i("MMPcmRecorder", "cost " + cVar.a() + "ms to call stopRecord");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("stopRecord, ");
        sb5.append(Thread.currentThread().getStackTrace()[2].getMethodName());
        Log.i("MMPcmRecorder", sb5.toString());
        AudioRecord audioRecord = this.f141369w;
        if (audioRecord == null) {
            Log.e("MMPcmRecorder", "audioRecord is null");
            return false;
        }
        if (audioRecord.getState() != 1) {
            Log.e("MMPcmRecorder", "audioRecord sate error " + this.f141369w.getState());
            return false;
        }
        cVar.c();
        this.f141369w.stop();
        this.f141369w.release();
        this.f141369w = null;
        Log.i("MMPcmRecorder", "cost " + cVar.a() + "ms to call stop and unInit");
        return true;
    }

    public static /* synthetic */ int a(a aVar, int i3) {
        int i16 = aVar.f141366t + i3;
        aVar.f141366t = i16;
        return i16;
    }

    public final boolean c() {
        this.B = 1;
        boolean z16 = x.f141187m.f141009h != 2;
        int a16 = h.a();
        int i3 = x.f141177c.f140942q0;
        if ((a16 & 1024) != 0) {
            if (i3 <= 0) {
                i3 = 0;
            }
            Log.i("MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i3);
        } else {
            i3 = 1;
        }
        boolean z17 = i3 == 1;
        Log.d("MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.f141353g, this.A, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            Log.d("MMPcmRecorder", "finish getMinBufferSize, minBufSize: " + minBufferSize);
            int i16 = this.f141353g;
            int i17 = this.f141352f;
            this.f141362p = (((i16 * 20) * i17) * 2) / 1000;
            int i18 = ((i16 * this.f141354h) * i17) / 1000;
            int i19 = i18 * 2;
            int b16 = b(this.f141358l);
            try {
                Log.e("", "audiosource:" + b16 + ",mSampleRate:" + this.f141353g + "," + this.A + ",mMultipleOfMinBuffer * minBufSize:" + (this.f141357k * minBufferSize));
                AudioRecord audioRecord = new AudioRecord(b16, this.f141353g, this.A, 2, this.f141357k * minBufferSize);
                this.f141369w = audioRecord;
                if (audioRecord.getState() == 0) {
                    this.f141369w.release();
                    this.f141347a = 2;
                    Log.e("MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    b16 = 7 == b16 ? 1 : 0;
                    this.f141369w = new AudioRecord(b16, this.f141353g, this.A, 2, this.f141357k * minBufferSize);
                }
                if (this.f141369w.getState() == 0) {
                    this.f141369w.release();
                    this.f141369w = null;
                    this.B = 2;
                    this.f141347a = 3;
                    Log.e("MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    d();
                    return false;
                }
                if (z16) {
                    AudioRecord audioRecord2 = this.f141369w;
                    boolean z18 = this.f141355i;
                    b bVar = this.f141370x;
                    int i26 = this.f141358l;
                    this.f141371y = new d(audioRecord2, z18, i19, bVar, (i26 == 1 || i26 == 6) && z17);
                } else {
                    this.f141371y = new c(this.f141369w, this.f141370x, this.f141355i, i18, i19);
                }
                this.f141371y.a(this.D);
                int i27 = this.f141359m;
                if (-123456789 != i27) {
                    this.f141371y.a(i27);
                }
                if (this.f141360n) {
                    com.tencent.luggage.wxa.s9.e eVar = new com.tencent.luggage.wxa.s9.e();
                    this.f141372z = eVar;
                    eVar.a(this.f141369w, this.f141358l);
                }
                this.f141351e = b16;
                return true;
            } catch (Exception unused) {
                Log.e("MMPcmRecorder", "new AudioRecord failed");
                this.f141347a = 12;
                return false;
            }
        }
        this.B = 3;
        this.f141347a = 1;
        Log.e("MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
        d();
        return false;
    }

    public void d(int i3) {
        this.f141354h = i3;
        Log.i("MMPcmRecorder", "mDurationPreFrame: " + this.f141354h);
    }

    public boolean e() {
        Log.d("MMPcmRecorder", "startRecord");
        this.f141361o = System.currentTimeMillis();
        this.f141363q = false;
        this.f141365s = false;
        boolean f16 = f();
        if (!f16) {
            g();
        }
        return f16;
    }

    public int b() {
        int i3 = this.C;
        if (i3 > 0) {
            return i3;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(this.f141353g, this.A, 2);
        w.d("MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", Integer.valueOf(minBufferSize));
        if (minBufferSize == -2 || minBufferSize == -1) {
            return 0;
        }
        int i16 = this.f141357k * minBufferSize;
        this.C = i16;
        return i16;
    }

    public final void d() {
        b bVar = this.f141370x;
        if (bVar != null) {
            bVar.a(this.B, this.f141347a);
        }
    }

    public void a(b bVar) {
        this.f141370x = bVar;
    }

    public int a() {
        return this.f141354h;
    }

    public void a(boolean z16) {
        this.f141355i = z16;
        Log.i("MMPcmRecorder", "mNewBufPreFrame: " + this.f141355i);
    }

    public final int b(int i3) {
        int i16 = this.f141351e;
        if (1 == i3 || 6 == i3 || 7 == i3) {
            com.tencent.luggage.wxa.t9.c cVar = x.f141177c;
            int i17 = cVar.f140907a ? 1 : 7;
            int i18 = cVar.D;
            if (i18 > -1) {
                i17 = i18;
            }
            if (6 != i3 || (i16 = cVar.A0) <= -1) {
                i16 = i17;
            }
        }
        w.d("MMPcmRecorder", "init audio source: %s", Integer.valueOf(i16));
        return i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        android.util.Log.e("MMPcmRecorder", "error start: " + r4 + ", end: " + r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(byte[] bArr, int i3) {
        if (this.f141363q && -2 == this.f141349c) {
            return;
        }
        int i16 = i3 / this.f141362p;
        int i17 = 5;
        while (true) {
            int i18 = this.f141364r;
            if (i17 > i16 + i18) {
                break;
            }
            int i19 = this.f141362p;
            int i26 = ((i17 - i18) - 1) * i19;
            int i27 = i19 + i26;
            if (i26 < 0 || i27 > i3) {
                break;
            }
            while (true) {
                if (i26 >= i27) {
                    break;
                }
                if (bArr[i26] != 0) {
                    this.f141349c = -1;
                    this.f141363q = true;
                    break;
                }
                i26++;
            }
            this.f141349c++;
            i17 += 5;
        }
        this.f141364r = (this.f141364r + i16) % 5;
        if (this.f141349c == 20) {
            this.f141347a = 6;
            Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
            int i28 = this.f141348b;
            if (i28 == -1 && this.f141350d == -1) {
                this.f141347a = 11;
                Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            } else if (i28 == -1) {
                this.f141347a = 8;
                Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
            } else if (this.f141350d == -1) {
                this.f141347a = 9;
                Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
            }
            this.f141349c = -2;
            d();
        }
    }

    public final void b(byte[] bArr, int i3) {
        if (this.f141348b == -1) {
            return;
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= i3 / 2) {
                break;
            }
            int i18 = i16 * 2;
            short s16 = (short) ((bArr[i18 + 0] & 255) | (bArr[i18 + 1] << 8));
            if (s16 >= 32760 || s16 == Short.MIN_VALUE) {
                i17++;
            }
            if (i17 >= 5) {
                this.f141348b++;
                break;
            }
            i16++;
        }
        if (this.f141348b > 100) {
            this.f141347a = 7;
            Log.e("MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
            int i19 = this.f141349c;
            if (i19 == -2 && this.f141350d == -1) {
                this.f141347a = 11;
                Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
            } else if (i19 == -2) {
                this.f141347a = 8;
                Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
            } else if (this.f141350d == -1) {
                this.f141347a = 10;
                Log.e("MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
            }
            d();
            this.f141348b = -1;
        }
    }

    public final void a(int i3) {
        int i16 = this.f141350d;
        if (i16 != -1 && i3 < 0) {
            int i17 = i16 + 1;
            this.f141350d = i17;
            if (i17 >= 50) {
                this.f141347a = 5;
                Log.e("MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                int i18 = this.f141349c;
                if (i18 == -2 && this.f141348b == -1) {
                    this.f141347a = 11;
                    Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                } else if (i18 == -2) {
                    this.f141347a = 9;
                    Log.e("MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                } else if (this.f141348b == -1) {
                    this.f141347a = 10;
                    Log.e("MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                }
                d();
                this.f141350d = -1;
            }
        }
    }

    public void c(int i3) {
        this.f141351e = i3;
        w.d("MMPcmRecorder", "mAudioSource: " + i3);
    }
}
