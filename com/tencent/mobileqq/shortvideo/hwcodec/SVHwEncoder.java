package com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.AsyncTask;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.shortvideo.hwcodec.c;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.util.SVMp4Merge;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes18.dex */
public class SVHwEncoder {
    private static AtomicInteger C = new AtomicInteger(0);
    private static boolean D = false;
    private e A;

    /* renamed from: b, reason: collision with root package name */
    private int f287893b;

    /* renamed from: c, reason: collision with root package name */
    private int f287894c;

    /* renamed from: d, reason: collision with root package name */
    private String f287895d;

    /* renamed from: a, reason: collision with root package name */
    public int f287892a = 21;

    /* renamed from: e, reason: collision with root package name */
    private volatile float f287896e = 30.0f;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f287897f = 480000;

    /* renamed from: g, reason: collision with root package name */
    private int f287898g = 44100;

    /* renamed from: h, reason: collision with root package name */
    private int f287899h = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f287900i = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;

    /* renamed from: j, reason: collision with root package name */
    private int f287901j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f287902k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f287903l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f287904m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f287905n = 0;

    /* renamed from: o, reason: collision with root package name */
    private Object f287906o = new Object();

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<a> f287907p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<a> f287908q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    private ArrayList<a> f287909r = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f287910s = false;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f287911t = false;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f287912u = false;

    /* renamed from: v, reason: collision with root package name */
    private HwEncode f287913v = null;

    /* renamed from: w, reason: collision with root package name */
    private double f287914w = 0.0d;

    /* renamed from: x, reason: collision with root package name */
    private double f287915x = 0.0d;

    /* renamed from: y, reason: collision with root package name */
    private int f287916y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f287917z = 0;
    private int[] B = new int[4];

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f287989a;

        /* renamed from: b, reason: collision with root package name */
        public int f287990b;

        /* renamed from: c, reason: collision with root package name */
        public int f287991c;

        /* renamed from: d, reason: collision with root package name */
        public long f287992d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f287993e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f287994f;

        /* renamed from: g, reason: collision with root package name */
        public float f287995g;

        /* renamed from: h, reason: collision with root package name */
        public int f287996h;
    }

    private native boolean adjustDstresolution(int[] iArr);

    synchronized void C() {
        a aVar = new a();
        aVar.f287993e = true;
        aVar.f287994f = true;
        aVar.f287995g = 30.0f;
        aVar.f287996h = 480000;
        this.f287908q.add(aVar);
        a aVar2 = new a();
        aVar2.f287993e = true;
        aVar2.f287994f = false;
        this.f287909r.add(aVar2);
        O("hw_video_write_frame", "addMediaEndFrame finish...");
        O("hw_audio_write_frame", "addMediaEndFrame finish...");
    }

    public synchronized void D(a aVar, boolean z16) {
        ArrayList<a> arrayList;
        if (!this.f287910s) {
            if (z16 && (arrayList = this.f287908q) != null) {
                arrayList.add(aVar);
                O("hw_video_write_frame", "finish=" + aVar.f287993e + " size=" + aVar.f287991c);
            } else {
                ArrayList<a> arrayList2 = this.f287909r;
                if (arrayList2 != null) {
                    arrayList2.add(aVar);
                    O("hw_audio_write_frame", "finish=" + aVar.f287993e + " size=" + aVar.f287991c);
                }
            }
        }
    }

    boolean E(a aVar) {
        boolean z16 = false;
        if (this.f287907p.size() < 3) {
            synchronized (this.f287906o) {
                if (this.f287907p.size() < 3) {
                    this.f287907p.add(aVar);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public void F() {
        this.f287910s = true;
        this.f287911t = true;
    }

    synchronized void G(ArrayList<a> arrayList) {
        arrayList.clear();
    }

    public void H(int i3, int i16, int i17, int i18) {
        if (i3 == 8000 || i3 == 16000 || i3 == 44100) {
            this.f287898g = i3;
        }
        if (i16 == 1 || i16 == 2) {
            this.f287899h = i16;
        }
        if (i17 == 64000 || i17 == 128000) {
            this.f287900i = i17;
        }
        if (i18 == 1 || i18 == 2) {
            this.f287901j = i18;
        }
    }

    public void I(String str, int i3, int i16) {
        this.f287895d = str;
        this.f287893b = i3;
        this.f287894c = i16;
        M();
    }

    synchronized int J(ArrayList<a> arrayList) {
        return arrayList.size();
    }

    synchronized a K(ArrayList<a> arrayList) {
        a aVar;
        if (arrayList.size() > 0) {
            aVar = arrayList.get(0);
        } else {
            aVar = null;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a L() {
        ArrayList<a> arrayList;
        a aVar;
        OutOfMemoryError e16;
        byte[] bArr;
        a aVar2 = null;
        if (!this.f287910s && (arrayList = this.f287907p) != null) {
            if (arrayList.size() > 0) {
                synchronized (this.f287906o) {
                    if (this.f287907p.size() > 0) {
                        aVar2 = this.f287907p.get(0);
                        this.f287907p.remove(0);
                    }
                }
            }
            if (aVar2 != null && aVar2.f287989a != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SVHwEncoder", 2, "getRecycleFrame[cache frame]");
                }
            } else {
                try {
                    bArr = new byte[((this.f287893b * this.f287894c) * 3) / 2];
                    aVar = new a();
                } catch (OutOfMemoryError e17) {
                    aVar = aVar2;
                    e16 = e17;
                }
                try {
                    aVar.f287989a = bArr;
                    aVar.f287995g = -1.0f;
                    aVar.f287996h = -1;
                } catch (OutOfMemoryError e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.e("SVHwEncoder", 2, "getRecycleFrame allocate frame OOM erro ", e16);
                    }
                    e eVar = this.A;
                    if (eVar != null) {
                        eVar.k(-27, 0);
                    }
                    F();
                    aVar2 = aVar;
                    if (QLog.isColorLevel()) {
                    }
                    return aVar2;
                }
                aVar2 = aVar;
                if (QLog.isColorLevel()) {
                    QLog.d("SVHwEncoder", 2, "getRecycleFrame[allocate frame]");
                }
            }
        }
        return aVar2;
    }

    void M() {
        int[] iArr = this.B;
        boolean z16 = false;
        iArr[0] = this.f287893b;
        iArr[1] = this.f287894c;
        iArr[2] = 0;
        iArr[3] = 0;
        try {
            z16 = adjustDstresolution(iArr);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        if (!z16) {
            int i3 = this.f287893b;
            this.f287893b = i3 - (i3 % 16);
            int i16 = this.f287894c;
            this.f287894c = i16 - (i16 % 16);
            return;
        }
        int[] iArr2 = this.B;
        this.f287893b = iArr2[2];
        this.f287894c = iArr2[3];
    }

    void N(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, String str, int i3) {
        if (byteBuffer == null) {
            O(str, "Configdata buferData=null");
            return;
        }
        if (bufferInfo.size != 0) {
            O(str, "Configdata size=" + bufferInfo.size);
        }
        if (bufferInfo.size < i3) {
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < bufferInfo.size; i16++) {
                byteBuffer.position(bufferInfo.offset + i16);
                sb5.append((int) byteBuffer.get());
                sb5.append(',');
            }
            O(str, "Configdata =" + sb5.toString());
        }
    }

    void O(String str, String str2) {
        if (!D && QLog.isColorLevel()) {
            QLog.d("SVHwEncoder", 2, str + ":" + str2);
        }
    }

    synchronized void P(ArrayList<a> arrayList) {
        if (arrayList.size() > 0) {
            arrayList.remove(0);
        }
    }

    int Q(List<MediaCodecInfo> list, String str) {
        MediaCodecInfo.CodecCapabilities b16;
        int i3 = -1;
        if (list.size() <= 0) {
            return -1;
        }
        for (int i16 = 0; i16 < list.size() && (b16 = c.b(list.get(i16), str)) != null; i16++) {
            O("selectAudioCodec", "name=" + list.get(i16).getName());
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = b16.profileLevels;
            if (codecProfileLevelArr != null && codecProfileLevelArr.length > 0) {
                int i17 = 0;
                while (true) {
                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr2 = b16.profileLevels;
                    if (i17 >= codecProfileLevelArr2.length) {
                        break;
                    }
                    if (codecProfileLevelArr2[i17].profile == 2) {
                        i3 = i16;
                        break;
                    }
                    i17++;
                }
            }
        }
        return i3;
    }

    public boolean R(int i3, int i16, int i17) {
        this.f287902k = true;
        this.f287903l = i3;
        this.f287904m = i16;
        if (i17 != 0 && i17 != 90 && i17 != 180 && i17 != 270) {
            i17 = 0;
        }
        this.f287905n = i17;
        if (i16 <= 0) {
            this.f287904m = 1000;
            return false;
        }
        if (i3 > 0) {
            return true;
        }
        this.f287903l = 1;
        return false;
    }

    public void S(e eVar, d dVar, boolean z16) {
        this.A = eVar;
        HwEncode hwEncode = new HwEncode(this.f287895d, eVar, dVar, z16, 0);
        this.f287913v = hwEncode;
        hwEncode.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class HwEncode implements Runnable, e, com.tencent.mobileqq.shortvideo.hwcodec.d {
        private boolean D;
        private boolean F;
        private boolean G;
        private boolean H;
        private String T;
        private String U;
        private int W;

        /* renamed from: d, reason: collision with root package name */
        private e f287921d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.mobileqq.shortvideo.hwcodec.d f287923e;

        /* renamed from: f, reason: collision with root package name */
        private int f287925f;

        /* renamed from: j0, reason: collision with root package name */
        private boolean f287932j0;

        /* renamed from: l0, reason: collision with root package name */
        private boolean f287934l0;

        /* renamed from: n0, reason: collision with root package name */
        private boolean f287937n0;

        /* renamed from: o0, reason: collision with root package name */
        private volatile boolean f287938o0;

        /* renamed from: p0, reason: collision with root package name */
        private boolean f287939p0;

        /* renamed from: u0, reason: collision with root package name */
        private int f287944u0;

        /* renamed from: h, reason: collision with root package name */
        private boolean f287928h = false;

        /* renamed from: i, reason: collision with root package name */
        private MediaFormat f287930i = null;

        /* renamed from: m, reason: collision with root package name */
        private MediaFormat f287935m = null;
        private boolean C = false;
        private boolean E = false;
        private int I = -1;
        private int J = -1;
        private MediaFormat K = null;
        private MediaFormat L = null;
        private String M = null;
        private String N = null;
        private String P = null;
        private int Q = 0;
        private int R = 0;
        private MediaMuxer S = null;
        private int V = 0;
        private String X = null;
        private int Y = 0;
        private int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        private int f287918a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        private int f287919b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        private int f287920c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        private int f287922d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        private com.tencent.mobileqq.shortvideo.hwcodec.c f287924e0 = new com.tencent.mobileqq.shortvideo.hwcodec.c();

        /* renamed from: f0, reason: collision with root package name */
        private com.tencent.mobileqq.shortvideo.hwcodec.c f287926f0 = new com.tencent.mobileqq.shortvideo.hwcodec.c();

        /* renamed from: g0, reason: collision with root package name */
        private boolean f287927g0 = false;

        /* renamed from: h0, reason: collision with root package name */
        private g f287929h0 = new g();

        /* renamed from: i0, reason: collision with root package name */
        private boolean f287931i0 = false;

        /* renamed from: k0, reason: collision with root package name */
        private ArrayList<String> f287933k0 = new ArrayList<>();

        /* renamed from: m0, reason: collision with root package name */
        private boolean f287936m0 = true;

        /* renamed from: q0, reason: collision with root package name */
        private volatile boolean f287940q0 = false;

        /* renamed from: r0, reason: collision with root package name */
        private Object f287941r0 = new Object();

        /* renamed from: s0, reason: collision with root package name */
        private d f287942s0 = new d();

        /* renamed from: t0, reason: collision with root package name */
        private b f287943t0 = new b();

        /* renamed from: v0, reason: collision with root package name */
        f f287945v0 = new f();

        /* renamed from: w0, reason: collision with root package name */
        c f287946w0 = new c();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a extends AsyncTask<Void, Void, Integer> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer doInBackground(Void... voidArr) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = HwEncode.this.U + "shortvideo_thumb.jpg";
                HwEncode hwEncode = HwEncode.this;
                int a16 = hwEncode.f287945v0.a(hwEncode.T, SVHwEncoder.this.f287916y, SVHwEncoder.this.f287917z, SVHwEncoder.this.f287914w, SVHwEncoder.this.f287915x, str);
                if (a16 == 0) {
                    String l3 = j.l(HwEncode.this.f287945v0.f288026a, "jpg");
                    if (FileUtils.rename(str, l3)) {
                        HwEncode.this.f287945v0.f288027b = l3;
                    } else if (!FileUtils.fileExistsAndNotEmpty(l3)) {
                        SVHwEncoder.this.O("doInBackground()", "rename failure, mThumbFilePath = " + str + ",thumbPath=" + l3);
                        a16 = -3;
                    }
                }
                HwEncode.this.f287945v0.f288029d = System.currentTimeMillis() - currentTimeMillis;
                HwEncode hwEncode2 = HwEncode.this;
                hwEncode2.f287945v0.f288028c = a16;
                hwEncode2.f287938o0 = true;
                return Integer.valueOf(a16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            long f287948a;

            /* renamed from: b, reason: collision with root package name */
            long f287949b;

            /* renamed from: c, reason: collision with root package name */
            long f287950c;

            /* renamed from: d, reason: collision with root package name */
            long f287951d;

            /* renamed from: e, reason: collision with root package name */
            long f287952e;

            /* renamed from: f, reason: collision with root package name */
            long f287953f;

            /* renamed from: g, reason: collision with root package name */
            long f287954g;

            /* renamed from: h, reason: collision with root package name */
            long f287955h;

            /* renamed from: i, reason: collision with root package name */
            long f287956i;

            /* renamed from: j, reason: collision with root package name */
            long f287957j;

            /* renamed from: k, reason: collision with root package name */
            long f287958k;

            /* renamed from: l, reason: collision with root package name */
            long f287959l;

            /* renamed from: m, reason: collision with root package name */
            long f287960m;

            /* renamed from: n, reason: collision with root package name */
            long f287961n;

            /* renamed from: o, reason: collision with root package name */
            long f287962o;

            /* renamed from: p, reason: collision with root package name */
            long f287963p;

            /* renamed from: q, reason: collision with root package name */
            long f287964q = Long.MAX_VALUE;

            /* renamed from: r, reason: collision with root package name */
            long f287965r = 0;

            /* renamed from: s, reason: collision with root package name */
            long f287966s = Long.MAX_VALUE;

            /* renamed from: t, reason: collision with root package name */
            long f287967t = 0;

            /* renamed from: u, reason: collision with root package name */
            int f287968u = 0;

            /* renamed from: v, reason: collision with root package name */
            int f287969v = 0;

            /* renamed from: w, reason: collision with root package name */
            int f287970w = 0;

            /* renamed from: x, reason: collision with root package name */
            int f287971x = 0;

            /* renamed from: y, reason: collision with root package name */
            long[] f287972y = new long[3];

            /* renamed from: z, reason: collision with root package name */
            long[] f287973z = new long[3];

            b() {
            }

            void a(boolean z16) {
                int i3;
                if (z16 && (i3 = this.f287968u) < 3) {
                    long[] jArr = this.f287972y;
                    this.f287968u = i3 + 1;
                    jArr[i3] = System.currentTimeMillis();
                } else {
                    int i16 = this.f287969v;
                    if (i16 < 3) {
                        long[] jArr2 = this.f287973z;
                        this.f287969v = i16 + 1;
                        jArr2[i16] = System.currentTimeMillis();
                    }
                }
            }

            long b() {
                return System.currentTimeMillis() - this.f287948a;
            }

            void c(boolean z16) {
                long b16 = b();
                if (z16) {
                    if (b16 > this.f287965r) {
                        this.f287965r = b16;
                    }
                    if (b16 < this.f287964q) {
                        this.f287964q = b16;
                        return;
                    }
                    return;
                }
                if (b16 > this.f287967t) {
                    this.f287967t = b16;
                }
                if (b16 < this.f287966s) {
                    this.f287966s = b16;
                }
            }

            void d(boolean z16) {
                int i3;
                if (z16 && (i3 = this.f287970w) < 3) {
                    long[] jArr = this.f287972y;
                    long currentTimeMillis = System.currentTimeMillis();
                    long[] jArr2 = this.f287972y;
                    int i16 = this.f287970w;
                    jArr[i3] = currentTimeMillis - jArr2[i16];
                    int i17 = i16 + 1;
                    this.f287970w = i17;
                    if (i17 == 3) {
                        SVHwEncoder.this.O("hw_video_time_used_msg", "videoEncodeTime:cnt20=" + this.f287972y[0] + " cnt1=" + this.f287972y[1] + " cnt2" + this.f287972y[2]);
                        long[] jArr3 = this.f287972y;
                        jArr3[0] = ((((jArr3[0] + jArr3[1]) + jArr3[2]) / 3) * 1000) / 2;
                        SVHwEncoder sVHwEncoder = SVHwEncoder.this;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("videoEncodeTime:timeout=");
                        sb5.append(this.f287972y[0]);
                        sVHwEncoder.O("hw_video_time_used_msg", sb5.toString());
                        return;
                    }
                    return;
                }
                int i18 = this.f287971x;
                if (i18 < 3) {
                    long[] jArr4 = this.f287973z;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long[] jArr5 = this.f287973z;
                    int i19 = this.f287971x;
                    jArr4[i18] = currentTimeMillis2 - jArr5[i19];
                    int i26 = i19 + 1;
                    this.f287971x = i26;
                    if (i26 == 3) {
                        SVHwEncoder.this.O("hw_video_time_used_msg", "audioEncodeTime:cnt20=" + this.f287973z[0] + " cnt1=" + this.f287973z[1] + " cnt2" + this.f287973z[2]);
                        long[] jArr6 = this.f287973z;
                        jArr6[0] = ((((jArr6[0] + jArr6[1]) + jArr6[2]) / 3) * 1000) / 2;
                        SVHwEncoder sVHwEncoder2 = SVHwEncoder.this;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("audioEncodeTime:timeout=");
                        sb6.append(this.f287973z[0]);
                        sVHwEncoder2.O("hw_video_time_used_msg", sb6.toString());
                    }
                }
            }

            long e() {
                if (this.f287971x < 3) {
                    return 0L;
                }
                return this.f287973z[0];
            }

            long f() {
                if (this.f287970w < 3) {
                    return 0L;
                }
                return this.f287972y[0];
            }

            void g() {
                this.f287948a = System.currentTimeMillis();
            }

            public String toString() {
                return "mThumbGen=" + this.f287959l + " mThumbGenFunc=" + this.f287960m + " mMuxerCreate=" + this.f287961n + " mMuxerAdd=" + this.f287962o + " mMuxerStart=" + this.f287963p + " mWriteVideoMax=" + this.f287965r + " mWriteVideoMIn=" + this.f287964q + " mWriteAudioMax=" + this.f287967t + " mWriteAudioMIn=" + this.f287966s + " vConfig=" + this.f287949b + " vInit=" + this.f287950c + " vStart=" + this.f287951d + " vStop=" + this.f287952e + " vRelease=" + this.f287953f + " aConfig=" + this.f287954g + " aInit=" + this.f287955h + " aStart=" + this.f287956i + " aStop=" + this.f287957j + " aRelease=" + this.f287958k + " ";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class c {

            /* renamed from: a, reason: collision with root package name */
            int f287974a = 0;

            /* renamed from: b, reason: collision with root package name */
            int f287975b = 0;

            c() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class d {

            /* renamed from: a, reason: collision with root package name */
            boolean f287977a;

            /* renamed from: b, reason: collision with root package name */
            boolean f287978b;

            /* renamed from: c, reason: collision with root package name */
            boolean f287979c;

            /* renamed from: d, reason: collision with root package name */
            boolean f287980d;

            /* renamed from: e, reason: collision with root package name */
            boolean f287981e;

            /* renamed from: f, reason: collision with root package name */
            boolean f287982f;

            /* renamed from: g, reason: collision with root package name */
            boolean f287983g;

            /* renamed from: h, reason: collision with root package name */
            long f287984h;

            /* renamed from: i, reason: collision with root package name */
            long f287985i;

            /* renamed from: j, reason: collision with root package name */
            int f287986j;

            /* renamed from: k, reason: collision with root package name */
            int f287987k;

            d() {
            }

            boolean a() {
                SVHwEncoder.this.O("releaseMuxer[audioSpecOK]", "mNeedEncodeAudio=" + HwEncode.this.H + " mAudioConfigOK=" + this.f287981e);
                if (HwEncode.this.H) {
                    return this.f287981e;
                }
                return true;
            }

            void b(MediaFormat mediaFormat) {
                if (mediaFormat.containsKey("csd-0")) {
                    this.f287981e = true;
                }
            }

            void c(MediaFormat mediaFormat) {
                if (mediaFormat.containsKey("csd-0") && mediaFormat.containsKey("csd-1")) {
                    this.f287980d = true;
                }
            }

            boolean d() {
                if (a() && h()) {
                    return true;
                }
                return false;
            }

            boolean e(long j3, boolean z16) {
                boolean z17 = true;
                if (z16) {
                    if (this.f287984h > j3) {
                        this.f287982f = true;
                        this.f287986j++;
                    } else {
                        z17 = false;
                    }
                    this.f287984h = j3;
                } else {
                    if (this.f287985i > j3) {
                        this.f287983g = true;
                        this.f287987k++;
                    } else {
                        z17 = false;
                    }
                    this.f287985i = j3;
                }
                return z17;
            }

            void f(String str) {
                if (QLog.isColorLevel()) {
                    QLog.d("SVHwEncoder", 2, str + ": mHasKeyFrame=" + this.f287977a + " mVideoFirst=" + this.f287978b + " mFirstIsKey=" + this.f287979c + " mVideoConfigOK=" + this.f287980d + " mAudioConfigOK=" + this.f287981e + " mVideoMuxeredframeCount=" + HwEncode.this.f287918a0 + " mAudioMuxeredframeCount=" + HwEncode.this.f287922d0 + " mVideoOrderError=" + this.f287982f + " mAudioOrderError=" + this.f287983g + " mVideoOrderErrorCnt=" + this.f287986j + " mAudioOrderErrorCnt=" + this.f287987k);
                }
            }

            void g() {
                f("releaseMuxer[resetValidData]");
                this.f287977a = false;
                this.f287978b = false;
                this.f287979c = false;
                this.f287980d = false;
                this.f287981e = false;
                this.f287982f = false;
                this.f287983g = false;
                this.f287986j = 0;
                this.f287987k = 0;
                this.f287984h = 0L;
                this.f287985i = 0L;
            }

            boolean h() {
                SVHwEncoder.this.O("releaseMuxer[videoSpecOK]", "mNeedEncodeVideo=" + HwEncode.this.G + " mVideoConfigOK=" + this.f287980d);
                if (!HwEncode.this.G) {
                    return true;
                }
                if (this.f287977a && this.f287978b && this.f287979c && this.f287980d && !this.f287982f) {
                    return true;
                }
                return false;
            }
        }

        HwEncode(String str, e eVar, com.tencent.mobileqq.shortvideo.hwcodec.d dVar, boolean z16, int i3) {
            this.f287921d = null;
            this.f287923e = null;
            this.f287925f = 0;
            this.D = false;
            this.F = false;
            this.G = true;
            this.H = true;
            this.T = null;
            this.U = null;
            this.W = 0;
            this.f287932j0 = false;
            this.f287934l0 = false;
            this.f287937n0 = false;
            this.f287938o0 = false;
            this.f287939p0 = false;
            this.f287944u0 = 0;
            this.T = str;
            this.U = z(str);
            this.H = z16;
            this.G = true;
            this.f287921d = eVar;
            this.f287923e = dVar;
            E();
            if (!this.H) {
                this.D = true;
                this.F = true;
            }
            this.f287925f = 0;
            this.f287944u0 = i3;
            this.f287932j0 = false;
            this.f287934l0 = false;
            this.f287937n0 = false;
            this.f287938o0 = false;
            this.f287939p0 = false;
            this.W = 0;
        }

        void A() {
            if (this.V == 1 && !SVHwEncoder.this.f287902k && !this.f287937n0 && this.Y >= 1) {
                this.f287943t0.g();
                this.f287938o0 = false;
                f fVar = this.f287945v0;
                fVar.f288027b = null;
                fVar.f288026a = null;
                fVar.f288028c = 0;
                fVar.f288029d = 0L;
                new a().execute(new Void[0]);
                this.f287937n0 = true;
                b bVar = this.f287943t0;
                bVar.f287960m = bVar.b();
            }
        }

        long B() {
            if (SVHwEncoder.this.f287902k) {
                return this.f287944u0;
            }
            long e16 = this.f287943t0.e();
            int i3 = this.f287944u0;
            if (e16 > i3) {
                return i3;
            }
            return e16;
        }

        com.tencent.mobileqq.shortvideo.hwcodec.c C(boolean z16) {
            if (z16) {
                return this.f287924e0;
            }
            return this.f287926f0;
        }

        float D(int i3) {
            return (i3 * 1000.0f) / ((SVHwEncoder.this.f287898g * SVHwEncoder.this.f287899h) * SVHwEncoder.this.f287901j);
        }

        void E() {
            this.X = this.U + "shortvideo_seg_" + this.V + ".mp4";
            this.V = this.V + 1;
        }

        String F() {
            return this.U + "shortvideo_merge.mp4";
        }

        long G() {
            if (SVHwEncoder.this.f287902k) {
                return this.f287944u0;
            }
            long f16 = this.f287943t0.f();
            int i3 = this.f287944u0;
            if (f16 > i3) {
                return i3;
            }
            return f16;
        }

        boolean H(ArrayList<a> arrayList) {
            while (true) {
                a K = SVHwEncoder.this.K(arrayList);
                if (K != null) {
                    if (K.f287993e) {
                        SVHwEncoder.this.P(arrayList);
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        int I() {
            q();
            int x16 = x();
            if (x16 != 0) {
                return x16;
            }
            J();
            int w3 = w(true);
            if (w3 != 0) {
                return w3;
            }
            if (!this.H) {
                return w3;
            }
            int s16 = s();
            if (s16 != 0) {
                return s16;
            }
            return w(false);
        }

        void K() {
            int a16;
            long nanoTime;
            int size = this.f287933k0.size();
            String F = F();
            if (size <= 0) {
                SVHwEncoder.this.O("hw_av_merge_segment", "size <= 0");
                return;
            }
            if (size == 1) {
                long nanoTime2 = System.nanoTime();
                SVHwEncoder.this.O("hw_av_merge_segment", "renameTo.");
                a16 = 0;
                File file = new File(this.f287933k0.get(0));
                File file2 = new File(F);
                if (SVHwEncoder.this.f287902k) {
                    if (this.f287918a0 <= 0 && this.f287922d0 <= 0) {
                        FileUtils.deleteFile(file.getAbsolutePath());
                        SVHwEncoder.this.O("hw_av_merge_segment", "[mOnlyGenOneMp4:check]mVideoMuxeredframeCount=" + this.f287918a0 + " mAudioMuxeredframeCount=" + this.f287922d0);
                        a16 = -2;
                    } else if (!file.renameTo(file2)) {
                        a16 = -1;
                    }
                } else {
                    FileUtils.copyFile(file, file2);
                }
                nanoTime = (System.nanoTime() - nanoTime2) / 1000;
            } else {
                long nanoTime3 = System.nanoTime();
                a16 = SVMp4Merge.a(this.f287933k0, F);
                nanoTime = (System.nanoTime() - nanoTime3) / 1000;
                SVHwEncoder.this.O("hw_av_merge_segment", "merge:time=" + nanoTime + " us");
            }
            SVHwEncoder.this.O("hw_av_merge_segment", "merge mp4 Over error=" + a16);
            if (a16 == 0) {
                g(F, SVHwEncoder.this.f287904m, nanoTime);
                SVHwEncoder.this.O("hw_av_merge_segment", "notify merge OK......");
            } else {
                k(-40, a16);
                FileUtils.deleteDirectory(this.U);
                SVHwEncoder.this.O("hw_av_merge_segment", "merge error delete cache......");
            }
        }

        void L() {
            synchronized (this.f287941r0) {
                SVHwEncoder.this.O("pauseThread", "pauseThread:mHavePaused=" + this.f287940q0);
                if (!this.f287940q0) {
                    this.f287940q0 = true;
                    try {
                        LockMethodProxy.wait(this.f287941r0);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        void M(String str) {
            SVHwEncoder.this.O(str, ": mExitVideoEncode=" + SVHwEncoder.this.f287910s + " mVideoWritedFrameCount=" + this.Y + " mVideoEncodedframeCount=" + this.Z + " mVideoMuxeredframeCount=" + this.f287918a0);
            SVHwEncoder.this.O(str, ": mExitVideoEncode=" + SVHwEncoder.this.f287910s + " mAudioWritedFrameCount=" + this.f287919b0 + " mAudioEncodedframeCount=" + this.f287920c0 + " mAudioMuxeredframeCount=" + this.f287922d0);
        }

        int N() {
            try {
                LockMethodProxy.sleep(300L);
            } catch (InterruptedException unused) {
            }
            this.f287935m = null;
            int s16 = s();
            if (s16 != 0) {
                SVHwEncoder.this.O("audioEncodeInit", "err=" + this.f287925f);
                return s16;
            }
            int w3 = w(false);
            if (w3 != 0) {
                SVHwEncoder.this.O("audioEncodeInit", "err=" + this.f287925f);
                this.f287926f0.k();
            }
            return w3;
        }

        int O() {
            this.K.setInteger("frame-rate", (int) SVHwEncoder.this.f287896e);
            this.K.setInteger("bitrate", SVHwEncoder.this.f287897f);
            this.f287930i = null;
            int x16 = x();
            if (x16 != 0) {
                return x16;
            }
            int w3 = w(true);
            if (w3 != 0) {
                SVHwEncoder.this.O("VideoEncodeExit", "err=" + this.f287925f);
                this.f287924e0.k();
            }
            return w3;
        }

        boolean Q(boolean z16) {
            SVHwEncoder.this.O("hw_media_muxer_seg", "release mMuxerCreated=" + this.f287928h + " needCatch=" + z16 + "......");
            boolean z17 = false;
            if (this.f287928h) {
                this.f287928h = false;
                this.I = -1;
                this.J = -1;
                if (z16) {
                    try {
                        this.S.stop();
                    } catch (IllegalStateException e16) {
                        e16.printStackTrace();
                        return true;
                    }
                } else {
                    this.S.stop();
                }
                SVHwEncoder.this.O("hw_media_muxer_seg", "release mMuxerCreated=" + this.f287928h + " needCatch=" + z16 + "topped...");
                if (z16) {
                    try {
                        this.S.release();
                    } catch (IllegalStateException e17) {
                        e17.printStackTrace();
                        z17 = true;
                    }
                } else {
                    this.S.release();
                }
                this.S = null;
            }
            return z17;
        }

        void R() {
            this.Y = 0;
            this.Z = 0;
            this.f287918a0 = 0;
            this.f287919b0 = 0;
            this.f287920c0 = 0;
            this.f287922d0 = 0;
        }

        int S(MediaFormat mediaFormat, String str, int i3, int i16) {
            int i17;
            List<MediaCodecInfo> d16 = com.tencent.mobileqq.shortvideo.hwcodec.c.d(str, true);
            if (d16.size() <= 0) {
                return -6;
            }
            for (int i18 = 0; i18 < d16.size(); i18++) {
                SVHwEncoder.this.O("encodeVideoInit", " codecname=" + d16.get(i18).getName());
            }
            int i19 = 0;
            while (true) {
                if (i19 < d16.size()) {
                    MediaCodecInfo.CodecCapabilities b16 = com.tencent.mobileqq.shortvideo.hwcodec.c.b(d16.get(i19), str);
                    if (b16 == null) {
                        return -26;
                    }
                    int[] iArr = b16.colorFormats;
                    for (int i26 : iArr) {
                        SVHwEncoder.this.O("encodeVideoInit", " colorformat=0x" + Integer.toHexString(i26));
                    }
                    if (ArrayUtils.contains(iArr, 21)) {
                        i17 = 21;
                        break;
                    }
                    i19++;
                } else {
                    i17 = 0;
                    i19 = -1;
                    break;
                }
            }
            if (i19 < 0) {
                int i27 = 0;
                while (true) {
                    if (i27 >= d16.size()) {
                        break;
                    }
                    MediaCodecInfo.CodecCapabilities b17 = com.tencent.mobileqq.shortvideo.hwcodec.c.b(d16.get(i27), str);
                    if (b17 == null) {
                        return -26;
                    }
                    if (ArrayUtils.contains(b17.colorFormats, 19)) {
                        i17 = 19;
                        i19 = i27;
                        break;
                    }
                    i27++;
                }
            }
            if (i17 != 19 && i17 != 21) {
                return -1;
            }
            if (i17 != 2130708361 && i17 != 19) {
                if (i17 == 21) {
                    SVHwEncoder.this.f287892a = 21;
                }
            } else {
                SVHwEncoder.this.f287892a = 19;
            }
            mediaFormat.setInteger("color-format", i17);
            mediaFormat.setInteger("frame-rate", i3);
            mediaFormat.setInteger("bitrate", i16);
            mediaFormat.setInteger("i-frame-interval", 1);
            this.M = d16.get(i19).getName();
            return 0;
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void a(int i3) {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.a(i3);
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svEncodeProgress: progress=" + i3 + " mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void b(String str, int i3, int i16, String str2) {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.b(str, i3, i16, str2);
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svThumbOK:path=" + str + " md5=" + str2 + "width=" + i3 + " height=" + i16 + " mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.d
        public a e() {
            return this.f287923e.e();
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void f() {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.f();
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svEncodeBegin mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void g(String str, int i3, long j3) {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.g(str, i3, j3);
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svMergeOK:path=" + str + " totalTime=" + i3 + " mergeTime=" + j3 + " mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void h() {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.h();
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svEncodeEnd mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void i(String str, int i3, int i16, int i17) {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.i(str, i3, i16, i17);
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svSegmentOK:path=" + str + " index=" + i3 + "width=" + i16 + " height=" + i17 + " mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.d
        public a j(int i3) {
            return this.f287923e.j(i3);
        }

        @Override // com.tencent.mobileqq.shortvideo.hwcodec.e
        public void k(int i3, int i16) {
            if (this.f287921d != null && !SVHwEncoder.this.f287911t) {
                this.f287921d.k(i3, i16);
            }
            SVHwEncoder.this.O("hw_video_callback_msg", "svErrorOcured:error=" + i3 + " subcode=" + i16 + " mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
        }

        void q() {
            this.K.setInteger("width", SVHwEncoder.this.f287893b);
            this.K.setInteger("height", SVHwEncoder.this.f287894c);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int r(int i3, int i16, int i17) {
            String str;
            int i18;
            int i19;
            List<MediaCodecInfo> g16 = com.tencent.mobileqq.shortvideo.hwcodec.c.g("audio/mp4a-latm");
            List<MediaCodecInfo> d16 = com.tencent.mobileqq.shortvideo.hwcodec.c.d("audio/mp4a-latm", true);
            if (g16.size() <= 0 && d16.size() <= 0) {
                return -7;
            }
            String str2 = null;
            int i26 = 2;
            if (d16.size() > 0) {
                SVHwEncoder.this.O("audioEncodeInit", " HardCodecSize=" + d16.size());
                int Q = SVHwEncoder.this.Q(d16, "audio/mp4a-latm");
                if (Q < 0) {
                    str = d16.get(d16.size() - 1).getName();
                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = d16.get(0).getCapabilitiesForType("audio/mp4a-latm").profileLevels;
                    if (codecProfileLevelArr != null && codecProfileLevelArr.length > 0) {
                        i18 = codecProfileLevelArr[0].profile;
                    }
                } else {
                    str = d16.get(Q).getName();
                    i18 = 2;
                }
                if (g16.size() > 0) {
                    SVHwEncoder.this.O("audioEncodeInit", " softCodecSize=" + g16.size());
                    int Q2 = SVHwEncoder.this.Q(g16, "audio/mp4a-latm");
                    if (Q2 < 0) {
                        str2 = g16.get(0).getName();
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr2 = g16.get(0).getCapabilitiesForType("audio/mp4a-latm").profileLevels;
                        if (codecProfileLevelArr2 != null && codecProfileLevelArr2.length > 0) {
                            i19 = codecProfileLevelArr2[0].profile;
                        }
                    } else {
                        str2 = g16.get(Q2).getName();
                        i19 = 2;
                    }
                    if (i18 == -1) {
                        i18 = 2;
                    }
                    if (i19 != -1) {
                        i26 = i19;
                    }
                    MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i16);
                    this.L = createAudioFormat;
                    createAudioFormat.setInteger("bitrate", i17);
                    this.N = str;
                    this.P = str2;
                    this.Q = i18;
                    this.R = i26;
                    return 0;
                }
                i19 = -1;
                if (i18 == -1) {
                }
                if (i19 != -1) {
                }
                MediaFormat createAudioFormat2 = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i16);
                this.L = createAudioFormat2;
                createAudioFormat2.setInteger("bitrate", i17);
                this.N = str;
                this.P = str2;
                this.Q = i18;
                this.R = i26;
                return 0;
            }
            str = null;
            i18 = -1;
            if (g16.size() > 0) {
            }
            i19 = -1;
            if (i18 == -1) {
            }
            if (i19 != -1) {
            }
            MediaFormat createAudioFormat22 = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i16);
            this.L = createAudioFormat22;
            createAudioFormat22.setInteger("bitrate", i17);
            this.N = str;
            this.P = str2;
            this.Q = i18;
            this.R = i26;
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0d84  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x0db5  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x0ddc  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0daa  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x0808  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x0815  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x095a  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0964  */
        /* JADX WARN: Removed duplicated region for block: B:195:0x0973  */
        /* JADX WARN: Removed duplicated region for block: B:325:0x0d4c A[EDGE_INSN: B:325:0x0d4c->B:119:0x0d4c BREAK  A[LOOP:1: B:39:0x0108->B:277:0x0d2f], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0681  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x068e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            a aVar;
            a aVar2;
            long j3;
            int i3;
            int i16;
            int i17;
            MediaFormat mediaFormat;
            int i18;
            c.a a16;
            c.a a17;
            int u16 = u();
            this.f287925f = u16;
            byte[] bArr = 0;
            if (u16 == 0) {
                long j16 = 1000;
                if (!SVHwEncoder.this.f287902k && !com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b) {
                    synchronized (com.tencent.mobileqq.shortvideo.mediadevice.b.f288185a) {
                        do {
                            if (!com.tencent.mobileqq.shortvideo.mediadevice.b.f288186b) {
                                try {
                                    com.tencent.mobileqq.shortvideo.mediadevice.b.f288185a.wait(1000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        } while (!SVHwEncoder.this.f287910s);
                        return;
                    }
                }
                SVHwEncoder.this.O("[Lock.CAPTURE_LOCK=true]", "begin to record video......");
                f();
                int I = I();
                this.f287925f = I;
                if (I == 0) {
                    if (SVHwEncoder.this.f287902k) {
                        this.f287931i0 = true;
                        SVHwEncoder.this.f287896e = (r0.f287903l * 1000) / SVHwEncoder.this.f287904m;
                        this.f287929h0.c();
                        this.f287929h0.d(SVHwEncoder.this.f287896e);
                        SVHwEncoder.this.O("HwEncodeHelper:mOnlyGenOneMp4", "mTotalFrames=" + SVHwEncoder.this.f287903l + " mTotalTimes=" + SVHwEncoder.this.f287904m + " mVideoFps=" + SVHwEncoder.this.f287896e);
                    }
                    while (true) {
                        if (SVHwEncoder.this.f287911t) {
                            break;
                        }
                        if (SVHwEncoder.this.f287902k || this.C) {
                            aVar = bArr;
                        } else {
                            SVHwEncoder sVHwEncoder = SVHwEncoder.this;
                            aVar = sVHwEncoder.K(sVHwEncoder.f287908q);
                        }
                        SVHwEncoder.this.O("hw_video_write_frame", "mVideoSourceDone=" + this.C + " mDataSource=" + this.f287923e);
                        SVHwEncoder.this.O("hw_video_write_frame", "mMuxerCreated=" + this.f287928h + " encoderOutputVideoFormat=" + this.f287930i);
                        if ((aVar != null || (SVHwEncoder.this.f287902k && !this.C)) && (this.f287930i == null || this.f287928h)) {
                            try {
                                long G = G();
                                SVHwEncoder.this.O("hw_video_timestamp", "videotimeout=" + G);
                                c.a f16 = this.f287924e0.f(G);
                                if (f16 != null && f16.f288022c != -1) {
                                    if (f16.f288020a == null) {
                                        this.f287946w0.f287974a++;
                                        SVHwEncoder.this.O("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer = null mVideoBuferErrCount=" + this.f287946w0.f287974a);
                                        if (this.f287946w0.f287974a >= 3) {
                                            this.f287925f = -21;
                                            k(-21, 0);
                                            break;
                                        }
                                    } else {
                                        this.f287946w0.f287974a = 0;
                                        if (SVHwEncoder.this.f287902k && this.f287923e != null) {
                                            aVar = j(SVHwEncoder.this.f287892a);
                                        }
                                        if (aVar != null && !aVar.f287993e) {
                                            f16.f288020a.clear();
                                            int capacity = f16.f288020a.capacity();
                                            int i19 = aVar.f287991c;
                                            int i26 = aVar.f287990b;
                                            int i27 = i19 - i26;
                                            if (capacity >= i27) {
                                                f16.f288020a.put(aVar.f287989a, i26, i27);
                                                aVar.f287990b += i27;
                                                long j17 = aVar.f287992d;
                                                long j18 = j17 * j16;
                                                long b16 = this.f287931i0 ? this.f287929h0.b(j17) : j18;
                                                SVHwEncoder.this.O("hw_video_timestamp", "oldTime=" + j18 + " frameTime=" + b16);
                                                try {
                                                    this.f287924e0.j(f16, aVar.f287991c, b16, 0);
                                                    this.Y++;
                                                    SVHwEncoder.this.O("hw_video_write_frame", "mVideoWritedFrameCount=" + this.Y);
                                                    this.f287943t0.a(true);
                                                } catch (IllegalStateException e16) {
                                                    e16.printStackTrace();
                                                    this.f287925f = -17;
                                                    k(-17, 0);
                                                }
                                            } else {
                                                this.f287925f = -12;
                                                k(-12, 0);
                                                break;
                                            }
                                        } else {
                                            this.f287924e0.j(f16, 0, 0L, 4);
                                            this.C = true;
                                            if (aVar != null) {
                                                SVHwEncoder.this.O("hw_video_write_frame", "[end-of-stream] fps=" + aVar.f287995g + " bitrate" + aVar.f287996h);
                                                if (aVar.f287995g > 0.0f && !SVHwEncoder.this.f287902k) {
                                                    SVHwEncoder.this.O("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.f287931i0 + " mUpdateVideoFps=" + this.f287932j0 + " mVideoFps=" + SVHwEncoder.this.f287896e);
                                                    SVHwEncoder.this.f287896e = aVar.f287995g;
                                                    if (!this.f287931i0) {
                                                        this.f287932j0 = true;
                                                        SVHwEncoder.this.O("hw_smooth_time_stamp", "mNeedDoSmooth=" + this.f287931i0 + " mUpdateVideoFps=" + this.f287932j0 + " mVideoFps=" + SVHwEncoder.this.f287896e);
                                                    }
                                                }
                                                int i28 = aVar.f287996h;
                                                if (i28 > 0) {
                                                    SVHwEncoder.this.f287897f = i28;
                                                }
                                            }
                                        }
                                        if (this.f287923e == null && aVar != null && aVar.f287990b == aVar.f287991c) {
                                            SVHwEncoder sVHwEncoder2 = SVHwEncoder.this;
                                            sVHwEncoder2.P(sVHwEncoder2.f287908q);
                                            if (!SVHwEncoder.this.E(aVar)) {
                                                aVar.f287989a = bArr;
                                            }
                                        }
                                    }
                                } else {
                                    SVHwEncoder.this.O("hw_video_write_frame", "INFO_TRY_AGAIN_LATER");
                                }
                            } catch (IllegalStateException e17) {
                                e17.printStackTrace();
                                this.f287925f = -19;
                                k(-19, 0);
                            }
                        }
                        if (SVHwEncoder.this.f287902k || this.D) {
                            aVar2 = bArr;
                        } else {
                            SVHwEncoder sVHwEncoder3 = SVHwEncoder.this;
                            aVar2 = sVHwEncoder3.K(sVHwEncoder3.f287909r);
                        }
                        if ((aVar2 != null || (SVHwEncoder.this.f287902k && !this.D)) && (this.f287935m == null || this.f287928h)) {
                            try {
                                long B = B();
                                SVHwEncoder.this.O("hw_audio_timestamp", "audiotimeout=" + B);
                                c.a f17 = this.f287926f0.f(B);
                                if (f17 != null && f17.f288022c != -1) {
                                    if (f17.f288020a == null) {
                                        this.f287946w0.f287975b++;
                                        SVHwEncoder.this.O("hw_intel_x86__err_msg", "INFO_TRY_AGAIN_LATER: buffer=null mAudioBuferErrCount=" + this.f287946w0.f287975b);
                                        if (this.f287946w0.f287975b >= 3) {
                                            this.f287925f = -20;
                                            k(-20, 0);
                                            break;
                                        }
                                    } else {
                                        this.f287946w0.f287975b = 0;
                                        if (SVHwEncoder.this.f287902k && this.f287923e != null) {
                                            aVar2 = e();
                                        }
                                        a aVar3 = aVar2;
                                        if (aVar3 != null && !aVar3.f287993e) {
                                            f17.f288020a.clear();
                                            int capacity2 = f17.f288020a.capacity();
                                            int i29 = aVar3.f287991c;
                                            int i36 = aVar3.f287990b;
                                            int i37 = i29 - i36;
                                            if (capacity2 >= i37) {
                                                f17.f288020a.put(aVar3.f287989a, i36, i37);
                                                aVar3.f287990b += i37;
                                                i3 = i37;
                                            } else {
                                                f17.f288020a.put(aVar3.f287989a, i36, capacity2);
                                                aVar3.f287990b += capacity2;
                                                i3 = capacity2;
                                            }
                                            SVHwEncoder.this.O("hw_audio_write_frame", "offset=" + aVar3.f287990b + " size=" + aVar3.f287991c + " audiovalidSize=" + i37);
                                            SVHwEncoder sVHwEncoder4 = SVHwEncoder.this;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append("audiocapacity=");
                                            sb5.append(capacity2);
                                            sb5.append(" writedByte=");
                                            sb5.append(i3);
                                            sVHwEncoder4.O("hw_audio_write_frame", sb5.toString());
                                            j3 = 1000;
                                            long j19 = aVar3.f287992d * 1000;
                                            long a18 = this.f287931i0 ? this.f287929h0.a(D(i3)) : j19;
                                            SVHwEncoder.this.O("hw_audio_timestamp", "oldTime=" + j19 + " frameTime=" + a18);
                                            try {
                                                i16 = i37;
                                                try {
                                                    this.f287926f0.j(f17, i3, a18, 0);
                                                    this.f287919b0++;
                                                    SVHwEncoder.this.O("hw_audio_write_frame", "mWritedFrameCount=" + this.f287919b0);
                                                    this.f287943t0.a(false);
                                                } catch (IllegalStateException e18) {
                                                    e = e18;
                                                    SVHwEncoder.this.O("hw_audio_timestamp", "offset=" + aVar3.f287990b + " size=" + aVar3.f287991c + " audiovalidSize=" + i16);
                                                    SVHwEncoder sVHwEncoder5 = SVHwEncoder.this;
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append("audiocapacity=");
                                                    sb6.append(capacity2);
                                                    sb6.append(" writedByte=");
                                                    sb6.append(i3);
                                                    sVHwEncoder5.O("hw_audio_timestamp", sb6.toString());
                                                    e.printStackTrace();
                                                    this.f287925f = -16;
                                                    k(-16, 0);
                                                    v(true);
                                                    v(false);
                                                    P();
                                                    SVHwEncoder.this.O("hw_video_time_used_msg", "HwTimeUsed_End=" + this.f287943t0.toString());
                                                    SVHwEncoder.this.O("hw_av_merge_segment", "release resource ok......");
                                                    if (this.f287925f == 0) {
                                                    }
                                                    if (!SVHwEncoder.this.f287911t) {
                                                    }
                                                    this.f287921d = null;
                                                    this.f287923e = null;
                                                    SVHwEncoder.this.f287907p.clear();
                                                    SVHwEncoder.this.f287908q.clear();
                                                    SVHwEncoder.this.f287909r.clear();
                                                    SVHwEncoder.this.f287907p = null;
                                                    SVHwEncoder.this.f287908q = null;
                                                    SVHwEncoder.this.f287909r = null;
                                                    this.f287929h0.c();
                                                    this.W = 0;
                                                    return;
                                                }
                                            } catch (IllegalStateException e19) {
                                                e = e19;
                                                i16 = i37;
                                            }
                                        } else {
                                            j3 = 1000;
                                            this.f287926f0.j(f17, 0, 0L, 4);
                                            this.D = true;
                                            SVHwEncoder.this.O("hw_audio_write_frame", "mWritedFrameCount=" + this.f287919b0 + " [Finish]...");
                                        }
                                        if (this.f287923e == null && aVar3 != null && aVar3.f287990b == aVar3.f287991c) {
                                            SVHwEncoder sVHwEncoder6 = SVHwEncoder.this;
                                            sVHwEncoder6.P(sVHwEncoder6.f287909r);
                                            aVar3.f287989a = null;
                                        }
                                    }
                                } else {
                                    j3 = 1000;
                                    SVHwEncoder.this.O("hw_audio_write_frame", "INFO_TRY_AGAIN_LATER");
                                }
                                if (this.C && this.D && this.f287932j0 && !SVHwEncoder.this.f287902k) {
                                    SVHwEncoder.this.O("hw_smooth_time_stamp", "mUpdateVideoFps=" + this.f287932j0 + " mVideoFps=" + SVHwEncoder.this.f287896e);
                                    this.f287932j0 = false;
                                    this.f287931i0 = true;
                                    this.f287929h0.c();
                                    this.f287929h0.d(SVHwEncoder.this.f287896e);
                                }
                                if (this.f287936m0 && !this.E && (this.f287930i == null || this.f287928h)) {
                                    try {
                                        long G2 = G();
                                        SVHwEncoder.this.O("hw_video_encode_frame", "videoOutTime=" + G2);
                                        a17 = this.f287924e0.a(G2);
                                        if (a17 != null) {
                                            SVHwEncoder.this.O("hw_video_encode_frame", "encoderOutputBuffer=null");
                                        } else {
                                            MediaCodec.BufferInfo bufferInfo = a17.f288023d;
                                            int i38 = a17.f288022c;
                                            if (i38 == -1) {
                                                SVHwEncoder.this.O("hw_video_encode_frame", "try later");
                                            } else if (i38 == -3) {
                                                SVHwEncoder.this.O("hw_video_encode_frame", "output buffers changed");
                                            } else if (i38 == -2) {
                                                MediaFormat outputFormat = this.f287924e0.e().getOutputFormat();
                                                this.f287930i = outputFormat;
                                                this.f287942s0.c(outputFormat);
                                                SVHwEncoder.this.O("hw_video_encode_frame", "out format changed");
                                            } else if ((bufferInfo.flags & 2) != 0) {
                                                SVHwEncoder.this.O("hw_video_encode_frame", "get Config data...");
                                                SVHwEncoder.this.N(a17.f288020a, bufferInfo, "mVideoEncoder_dequeueOutputBuffer", 30);
                                                this.f287924e0.l(a17);
                                            } else {
                                                SVHwEncoder.this.O("hw_video_encode_frame", "writedata size=" + bufferInfo.size);
                                                if (bufferInfo.size != 0) {
                                                    this.f287943t0.d(true);
                                                    this.Z++;
                                                    if (this.S != null) {
                                                        if ((bufferInfo.flags & 1) != 0) {
                                                            d dVar = this.f287942s0;
                                                            dVar.f287977a = true;
                                                            if (this.f287918a0 == 0) {
                                                                dVar.f287979c = true;
                                                            }
                                                        }
                                                        int i39 = this.f287918a0;
                                                        if (i39 == 0) {
                                                            if (this.f287922d0 == 0) {
                                                                this.f287942s0.f287978b = true;
                                                            } else {
                                                                this.f287942s0.f287978b = false;
                                                            }
                                                        }
                                                        this.f287918a0 = i39 + 1;
                                                        SVHwEncoder.this.O("hw_video_writesample", "track=" + this.I + " pts=" + bufferInfo.presentationTimeUs);
                                                        this.f287942s0.e(bufferInfo.presentationTimeUs, true);
                                                        this.f287943t0.g();
                                                        try {
                                                            this.S.writeSampleData(this.I, a17.f288020a, bufferInfo);
                                                            this.f287943t0.c(true);
                                                        } catch (Throwable th5) {
                                                            if (QLog.isColorLevel()) {
                                                                QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of video erro", th5);
                                                            }
                                                            this.f287925f = -25;
                                                            k(-25, 0);
                                                        }
                                                    } else {
                                                        SVHwEncoder.this.O("hw_video_encode_frame", "video encoder:muxer is null");
                                                    }
                                                }
                                                if ((bufferInfo.flags & 4) != 0) {
                                                    this.E = true;
                                                    SVHwEncoder.this.O("hw_video_encode_frame", "end of stream");
                                                }
                                                this.f287924e0.l(a17);
                                            }
                                        }
                                    } catch (IllegalStateException e26) {
                                        e26.printStackTrace();
                                        this.f287925f = -23;
                                        k(-23, 0);
                                    }
                                }
                                if (this.f287936m0 && !this.F && (this.f287935m == null || this.f287928h)) {
                                    try {
                                        long B2 = B();
                                        SVHwEncoder.this.O("hw_audio_encode_frame", "audioOutTime=" + B2);
                                        a16 = this.f287926f0.a(B2);
                                        if (a16 != null) {
                                            SVHwEncoder.this.O("hw_audio_encode_frame", "encoderOutputBuffer=null");
                                        } else {
                                            MediaCodec.BufferInfo bufferInfo2 = a16.f288023d;
                                            int i46 = a16.f288022c;
                                            if (i46 == -1) {
                                                SVHwEncoder.this.O("hw_audio_encode_frame", "try later");
                                            } else if (i46 == -3) {
                                                SVHwEncoder.this.O("hw_audio_encode_frame", "out buffer change");
                                            } else if (i46 == -2) {
                                                MediaFormat outputFormat2 = this.f287926f0.e().getOutputFormat();
                                                this.f287935m = outputFormat2;
                                                this.f287942s0.b(outputFormat2);
                                                SVHwEncoder.this.O("hw_audio_encode_frame", "out format change");
                                            } else if ((bufferInfo2.flags & 2) != 0) {
                                                SVHwEncoder.this.O("hw_audio_encode_frame", "get config......");
                                                SVHwEncoder.this.N(a16.f288020a, bufferInfo2, "mAudioEncoder_dequeueOutputBuffer", 10);
                                                this.f287926f0.l(a16);
                                            } else {
                                                SVHwEncoder.this.O("hw_audio_encode_frame", "writedata size=" + bufferInfo2.size);
                                                if (bufferInfo2.size != 0) {
                                                    this.f287943t0.d(false);
                                                    this.f287920c0++;
                                                    if (this.S != null) {
                                                        this.f287922d0++;
                                                        SVHwEncoder.this.O("hw_audio_writesample", "track=" + this.J + " pts=" + bufferInfo2.presentationTimeUs);
                                                        if (!this.f287942s0.e(bufferInfo2.presentationTimeUs, false)) {
                                                            this.f287943t0.g();
                                                            try {
                                                                this.S.writeSampleData(this.J, a16.f288020a, bufferInfo2);
                                                                this.f287943t0.c(false);
                                                            } catch (Throwable th6) {
                                                                if (QLog.isColorLevel()) {
                                                                    QLog.e("SVHwEncoder", 2, "MediaMuxer.writeSampleData of audio erro", th6);
                                                                }
                                                                this.f287925f = -24;
                                                                k(-24, 0);
                                                            }
                                                        }
                                                    } else {
                                                        SVHwEncoder.this.O("hw_audio_encode_frame", "muxer is null");
                                                    }
                                                }
                                                if ((bufferInfo2.flags & 4) != 0) {
                                                    this.F = true;
                                                    SVHwEncoder.this.O("hw_audio_encode_frame", "end of stream");
                                                }
                                                this.f287926f0.l(a16);
                                            }
                                        }
                                    } catch (IllegalStateException e27) {
                                        e27.printStackTrace();
                                        this.f287925f = -22;
                                        k(-22, 0);
                                    }
                                }
                                if (SVHwEncoder.this.f287902k && !this.f287927g0) {
                                    i18 = (this.Z * 100) / SVHwEncoder.this.f287903l;
                                    a(i18);
                                    if (i18 >= 100) {
                                        this.f287927g0 = true;
                                    }
                                }
                                if (SVHwEncoder.this.f287912u) {
                                    L();
                                }
                                A();
                                t();
                                if (this.f287925f != 0) {
                                    break;
                                }
                                if (this.E && this.F) {
                                    boolean d16 = this.f287942s0.d();
                                    this.f287942s0.g();
                                    if (!d16) {
                                        SVHwEncoder.this.O("releaseMuxer[check]", "validSegment=" + d16);
                                        this.f287925f = -14;
                                        k(-14, 0);
                                        break;
                                    }
                                    if (Q(true)) {
                                        this.f287925f = -14;
                                        k(-14, 1);
                                        break;
                                    }
                                    if (this.f287939p0) {
                                        if (this.W + 1 < this.V) {
                                            if (this.f287933k0.size() != this.V - 1) {
                                                this.f287925f = -15;
                                                k(-15, 0);
                                                break;
                                            }
                                            int i47 = 0;
                                            while (i47 < this.f287933k0.size()) {
                                                SVHwEncoder.this.O("hw_video_segment_notify_msg", "svSegmentOK:[roll] i=" + i47 + " mCallSegmentIndex=" + this.W);
                                                String str = this.f287933k0.get(i47);
                                                i47++;
                                                i(str, i47, SVHwEncoder.this.f287893b, SVHwEncoder.this.f287894c);
                                                this.W = this.W + 1;
                                            }
                                        }
                                        SVHwEncoder.this.O("hw_video_segment_notify_msg", "svSegmentOK:[new]mCallSegmentIndex=" + this.W);
                                        i(this.X, this.V, SVHwEncoder.this.f287893b, SVHwEncoder.this.f287894c);
                                        this.f287933k0.add(this.X);
                                        this.W = this.W + 1;
                                    } else {
                                        this.f287933k0.add(this.X);
                                        SVHwEncoder.this.O("hw_video_segment_notify_msg", "mHasCallSVThumbOk=" + this.f287939p0 + " size=" + this.f287933k0.size());
                                    }
                                    if (SVHwEncoder.this.f287902k || y("VideoEncodeExit[one]")) {
                                        break;
                                    }
                                    v(true);
                                    v(false);
                                    SVHwEncoder.this.O("hw_video_time_used_msg", "HwTimeUsed=" + this.f287943t0.toString());
                                    E();
                                    int O = O();
                                    this.f287925f = O;
                                    if (O != 0) {
                                        k(O, 0);
                                        break;
                                    }
                                    if (this.H) {
                                        int N = N();
                                        this.f287925f = N;
                                        if (N != 0) {
                                            k(N, 0);
                                            break;
                                        }
                                    }
                                    this.E = false;
                                    if (this.H) {
                                        this.F = false;
                                    }
                                    R();
                                    this.f287934l0 = true;
                                }
                                if (!this.f287934l0) {
                                    if (SVHwEncoder.this.f287910s) {
                                        SVHwEncoder sVHwEncoder7 = SVHwEncoder.this;
                                        int J = sVHwEncoder7.J(sVHwEncoder7.f287908q);
                                        if (this.H) {
                                            SVHwEncoder sVHwEncoder8 = SVHwEncoder.this;
                                            i17 = sVHwEncoder8.J(sVHwEncoder8.f287909r);
                                        } else {
                                            i17 = 0;
                                        }
                                        M("VideoEncodeExit[three]videoSize=" + J + " audioSize=" + i17);
                                        if ((J <= 0 && i17 <= 0) || (this.H && i17 <= 0 && this.E && J <= 3)) {
                                            if (J > 0) {
                                                SVHwEncoder.this.O("VideoEncodeExit[three]", "videoSize=" + J + " mVideoEncodeDone=" + this.E);
                                                SVHwEncoder sVHwEncoder9 = SVHwEncoder.this;
                                                sVHwEncoder9.G(sVHwEncoder9.f287908q);
                                            }
                                            M("VideoEncodeExit[three]");
                                            SVHwEncoder.this.C();
                                        }
                                    }
                                } else {
                                    if (y("VideoEncodeExit[two]")) {
                                        break;
                                    }
                                    boolean H = H(SVHwEncoder.this.f287908q);
                                    boolean H2 = this.H ? H(SVHwEncoder.this.f287909r) : false;
                                    if (SVHwEncoder.this.f287910s) {
                                        if (!H) {
                                            this.G = false;
                                        }
                                        if (!H2) {
                                            this.H = false;
                                        }
                                        if (!this.G && !this.H) {
                                            M("VideoEncodeExit[Four]startVideo=" + H + " startAudio=" + H2);
                                            break;
                                        }
                                    }
                                    if (this.G) {
                                        mediaFormat = null;
                                    } else {
                                        this.E = true;
                                        mediaFormat = null;
                                        this.f287930i = null;
                                        H = true;
                                    }
                                    if (!this.H) {
                                        this.F = true;
                                        this.f287935m = mediaFormat;
                                        H2 = true;
                                    }
                                    if (H && H2) {
                                        this.C = false;
                                        this.D = false;
                                        this.f287936m0 = true;
                                        this.f287934l0 = false;
                                        this.f287942s0.f("releaseMuxer[mEnableEncode=true]");
                                        SVHwEncoder.this.O("hw_video_writesample", "track=" + this.I);
                                        SVHwEncoder.this.O("hw_audio_writesample", "track=" + this.J);
                                        SVHwEncoder.this.O("hw_video_timestamp", "new segment");
                                        SVHwEncoder.this.O("hw_audio_timestamp", "new segment");
                                    } else {
                                        this.f287936m0 = false;
                                    }
                                }
                                if (!this.f287928h && ((this.f287930i != null || !this.G) && (this.f287935m != null || !this.H))) {
                                    this.f287943t0.g();
                                    try {
                                        MediaMuxer mediaMuxer = new MediaMuxer(this.X, 0);
                                        this.S = mediaMuxer;
                                        mediaMuxer.setOrientationHint(SVHwEncoder.this.f287905n);
                                    } catch (IOException e28) {
                                        e28.printStackTrace();
                                        this.S = null;
                                        this.f287928h = false;
                                        this.f287925f = -11;
                                    }
                                    b bVar = this.f287943t0;
                                    bVar.f287961n = bVar.b();
                                    int i48 = this.f287925f;
                                    if (i48 != 0) {
                                        k(i48, 0);
                                        break;
                                    }
                                    this.f287943t0.g();
                                    MediaFormat mediaFormat2 = this.f287930i;
                                    if (mediaFormat2 != null) {
                                        this.I = this.S.addTrack(mediaFormat2);
                                        SVHwEncoder.this.O("hw_media_muxer_seg", "adding video track:outputVideoTrack=" + this.I);
                                    }
                                    MediaFormat mediaFormat3 = this.f287935m;
                                    if (mediaFormat3 != null) {
                                        this.J = this.S.addTrack(mediaFormat3);
                                        SVHwEncoder.this.O("hw_media_muxer_seg", " adding audio track:outputAudioTrack=" + this.J);
                                    }
                                    b bVar2 = this.f287943t0;
                                    bVar2.f287962o = bVar2.b();
                                    SVHwEncoder.this.O("hw_media_muxer_seg", "starting......");
                                    this.f287943t0.g();
                                    this.S.start();
                                    b bVar3 = this.f287943t0;
                                    bVar3.f287963p = bVar3.b();
                                    this.f287928h = true;
                                }
                                j16 = j3;
                                bArr = 0;
                            } catch (IllegalStateException e29) {
                                e29.printStackTrace();
                                this.f287925f = -18;
                                k(-18, 0);
                            }
                        }
                        j3 = 1000;
                        if (this.C) {
                            SVHwEncoder.this.O("hw_smooth_time_stamp", "mUpdateVideoFps=" + this.f287932j0 + " mVideoFps=" + SVHwEncoder.this.f287896e);
                            this.f287932j0 = false;
                            this.f287931i0 = true;
                            this.f287929h0.c();
                            this.f287929h0.d(SVHwEncoder.this.f287896e);
                        }
                        if (this.f287936m0) {
                            long G22 = G();
                            SVHwEncoder.this.O("hw_video_encode_frame", "videoOutTime=" + G22);
                            a17 = this.f287924e0.a(G22);
                            if (a17 != null) {
                            }
                        }
                        if (this.f287936m0) {
                            long B22 = B();
                            SVHwEncoder.this.O("hw_audio_encode_frame", "audioOutTime=" + B22);
                            a16 = this.f287926f0.a(B22);
                            if (a16 != null) {
                            }
                        }
                        if (SVHwEncoder.this.f287902k) {
                            i18 = (this.Z * 100) / SVHwEncoder.this.f287903l;
                            a(i18);
                            if (i18 >= 100) {
                            }
                        }
                        if (SVHwEncoder.this.f287912u) {
                        }
                        A();
                        t();
                        if (this.f287925f != 0) {
                        }
                    }
                    v(true);
                    v(false);
                    P();
                    SVHwEncoder.this.O("hw_video_time_used_msg", "HwTimeUsed_End=" + this.f287943t0.toString());
                    SVHwEncoder.this.O("hw_av_merge_segment", "release resource ok......");
                    if (this.f287925f == 0) {
                        SVHwEncoder.this.O("hw_av_merge_segment", "mLastErrCode=" + this.f287925f);
                        SVHwEncoder.this.f287911t = true;
                        Q(true);
                    } else {
                        h();
                    }
                    if (!SVHwEncoder.this.f287911t) {
                        SVHwEncoder.this.O("hw_av_merge_segment", "clear cache mCacellVideoEncode=" + SVHwEncoder.this.f287911t);
                        FileUtils.deleteDirectory(this.U);
                    } else {
                        SVHwEncoder.this.O("hw_av_merge_segment", "begin merge segments.");
                        K();
                    }
                    this.f287921d = null;
                    this.f287923e = null;
                    SVHwEncoder.this.f287907p.clear();
                    SVHwEncoder.this.f287908q.clear();
                    SVHwEncoder.this.f287909r.clear();
                    SVHwEncoder.this.f287907p = null;
                    SVHwEncoder.this.f287908q = null;
                    SVHwEncoder.this.f287909r = null;
                    this.f287929h0.c();
                    this.W = 0;
                    return;
                }
                SVHwEncoder.this.O("initEncodeStatus", " err=" + this.f287925f);
                k(this.f287925f, 0);
                v(true);
                v(false);
                P();
                return;
            }
            SVHwEncoder.this.O("configHardWareComponent", " err=" + this.f287925f);
            k(this.f287925f, 0);
            this.K = null;
            this.L = null;
        }

        int s() {
            boolean z16;
            this.f287943t0.g();
            if (this.P != null) {
                this.L.setInteger("aac-profile", this.R);
                z16 = this.f287926f0.h(this.L, this.P);
            } else {
                z16 = false;
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SVHwEncoder", 2, "audioEncodeInit: sfCodecinit error codecNameHw=" + this.P);
                }
                if (this.N != null) {
                    this.L.setInteger("aac-profile", this.Q);
                    z16 = this.f287926f0.h(this.L, this.N);
                }
            }
            b bVar = this.f287943t0;
            bVar.f287955h = bVar.b();
            if (z16) {
                return 0;
            }
            return -8;
        }

        void t() {
            this.f287925f = 0;
            if (this.f287938o0 && !this.f287939p0) {
                f fVar = this.f287945v0;
                int i3 = fVar.f288028c;
                if (i3 != 0) {
                    this.f287925f = -9;
                    k(-9, i3);
                    SVHwEncoder.this.O("hw_av_merge_segment", "genThumbFile mLastErrCode=" + this.f287925f + " subcode=" + this.f287945v0.f288028c);
                } else {
                    b(fVar.f288027b, SVHwEncoder.this.f287916y, SVHwEncoder.this.f287917z, this.f287945v0.f288026a);
                }
                SVHwEncoder.this.O("hw_video_segment_notify_msg", "svThumbOK:mCallSegmentIndex=" + this.W + " mLastErrCode=" + this.f287925f);
                this.f287943t0.f287959l = this.f287945v0.f288029d;
                this.f287939p0 = true;
            }
        }

        int u() {
            String str = com.tencent.mobileqq.shortvideo.hwcodec.c.f288007i;
            this.f287943t0.g();
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, SVHwEncoder.this.f287893b, SVHwEncoder.this.f287894c);
            this.K = createVideoFormat;
            int S = S(createVideoFormat, str, (int) SVHwEncoder.this.f287896e, SVHwEncoder.this.f287897f);
            b bVar = this.f287943t0;
            bVar.f287949b = bVar.b();
            if (S != 0) {
                return S;
            }
            if (!this.H) {
                return S;
            }
            this.f287943t0.g();
            int r16 = r(SVHwEncoder.this.f287898g, SVHwEncoder.this.f287899h, SVHwEncoder.this.f287900i);
            b bVar2 = this.f287943t0;
            bVar2.f287954g = bVar2.b();
            return r16;
        }

        void v(boolean z16) {
            try {
                com.tencent.mobileqq.shortvideo.hwcodec.c C = C(z16);
                this.f287943t0.g();
                C.n();
                if (z16) {
                    b bVar = this.f287943t0;
                    bVar.f287951d = bVar.b();
                } else {
                    b bVar2 = this.f287943t0;
                    bVar2.f287956i = bVar2.b();
                }
                this.f287943t0.g();
                C.k();
                if (z16) {
                    b bVar3 = this.f287943t0;
                    bVar3.f287953f = bVar3.b();
                } else {
                    b bVar4 = this.f287943t0;
                    bVar4.f287958k = bVar4.b();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        int w(boolean z16) {
            boolean z17;
            this.f287943t0.g();
            try {
                z17 = C(z16).m();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("SVHwEncoder", 2, "Exception", e16);
                }
                z17 = false;
            }
            if (z16) {
                b bVar = this.f287943t0;
                bVar.f287951d = bVar.b();
            } else {
                b bVar2 = this.f287943t0;
                bVar2.f287956i = bVar2.b();
            }
            if (z17) {
                return 0;
            }
            return -3;
        }

        int x() {
            this.f287943t0.g();
            boolean h16 = this.f287924e0.h(this.K, this.M);
            b bVar = this.f287943t0;
            bVar.f287950c = bVar.b();
            if (!h16) {
                return -2;
            }
            return 0;
        }

        boolean y(String str) {
            if (SVHwEncoder.this.f287911t) {
                M(str);
                return true;
            }
            if (SVHwEncoder.this.f287910s) {
                SVHwEncoder sVHwEncoder = SVHwEncoder.this;
                int J = sVHwEncoder.J(sVHwEncoder.f287908q);
                SVHwEncoder sVHwEncoder2 = SVHwEncoder.this;
                int J2 = sVHwEncoder2.J(sVHwEncoder2.f287909r);
                if (J <= 0 && J2 <= 0) {
                    M(str + "videosize=" + J + " audiosize=" + J2);
                    return true;
                }
            }
            return false;
        }

        String z(String str) {
            String str2 = str + "_qq_hw/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str2;
        }

        void J() {
        }

        void P() {
        }
    }
}
