package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.audiofx.AEtimrescore;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AIEffectHandlerThread extends BaseHandlerThread implements com.tencent.karaoke.recordsdk.media.g {
    public static final String U = Environment.getExternalStorageDirectory() + "/Android/data/com.tencent.karaoke/files/pcm/obb.tkm";
    private String C;
    private Handler D;
    private AEtimrescore E;
    private float[] F;
    private byte[] G;
    private LinkedList<byte[]> H;
    private LinkedList<a> I;
    private LinkedList<b> J;
    private LinkedList<b> K;
    private int L;
    private int M;
    private int N;
    private ByteBuffer P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;

    /* renamed from: m, reason: collision with root package name */
    private int f116971m;

    /* compiled from: P */
    /* renamed from: com.tencent.karaoke.recordsdk.media.audio.AIEffectHandlerThread$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AIEffectHandlerThread this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (AIEffectHandlerThread.t(this.this$0.f116971m)) {
                LogUtil.i("AIEffectHandlerThread", "init: 2 ,obj: " + this);
                this.this$0.s();
                LogUtil.i("AIEffectHandlerThread", "init: 3 ,obj: " + this);
                return;
            }
            LogUtil.i("AIEffectHandlerThread", "init: 4 ,obj: " + this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.karaoke.recordsdk.media.audio.AIEffectHandlerThread$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float[] f116972d;
        final /* synthetic */ AIEffectHandlerThread this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (AIEffectHandlerThread.t(this.this$0.f116971m) && this.this$0.E != null) {
                if (!this.this$0.T) {
                    LogUtil.i("AIEffectHandlerThread", "getFeatureResultAsyn: getf0 begin ");
                    float[] fArr = this.f116972d;
                    fArr.getClass();
                    LogUtil.i("AIEffectHandlerThread", "getFeatureResultAsyn: getF0 ret =" + this.this$0.E.getPublicF0Total(fArr));
                } else {
                    LogUtil.i("AIEffectHandlerThread", "getFeatureResultAsyn: is not public f0");
                }
                AIEffectHandlerThread aIEffectHandlerThread = this.this$0;
                aIEffectHandlerThread.p(aIEffectHandlerThread.C);
                LogUtil.w("AIEffectHandlerThread", "getFeatureResultAsyn: return success");
                throw null;
            }
            LogUtil.w("AIEffectHandlerThread", "getFeatureResultAsyn: return null");
            throw null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.karaoke.recordsdk.media.audio.AIEffectHandlerThread$4, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ AIEffectHandlerThread this$0;

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("AIEffectHandlerThread", "handleRelease: 1 ,obj: " + this);
            if (this.this$0.E != null) {
                LogUtil.i("AIEffectHandlerThread", "handleRelease: 2 ,obj: " + this);
                LogUtil.i("AIEffectHandlerThread", "handleRelease: 3" + this.this$0.E.release() + " ,obj: " + this);
            }
            this.this$0.E = null;
            LogUtil.i("AIEffectHandlerThread", "run: quitSafely start ,obj: " + this);
            this.this$0.quitSafely();
            LogUtil.i("AIEffectHandlerThread", "run: quitSafely end ,obj: " + this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final int f116973a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f116974b;

        a(int i3, byte[] bArr) {
            this.f116973a = i3;
            this.f116974b = bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f116976a;

        /* renamed from: b, reason: collision with root package name */
        public final byte f116977b;

        /* renamed from: c, reason: collision with root package name */
        public final int f116978c;

        public b(int i3, int i16, byte b16) {
            this.f116978c = i3;
            this.f116976a = i16;
            this.f116977b = b16;
        }
    }

    private boolean o(byte[] bArr, int i3, int i16) {
        byte[] bArr2;
        u("onRecord -> data:------in-------" + ((int) bArr[0]) + " >>> " + i16 + " >>> " + i3);
        if (this.R) {
            this.L += i3;
        }
        int remaining = this.P.remaining();
        if (remaining >= i3) {
            this.P.put(bArr, 0, i3);
            this.Q = i16 + i3;
            u("onRecord: mRecordByteBuffer is ok, recordedLength: " + i16 + " >>> " + remaining + " >>> " + (remaining / 8192));
        } else {
            u("onRecord: mRecordByteBuffer is over, recordedLength: " + i16 + " >>> " + remaining + " >>> " + (remaining / 8192));
        }
        this.P.flip();
        int remaining2 = this.P.remaining();
        if (remaining2 < 8192) {
            this.P.compact();
            return true;
        }
        synchronized (this.H) {
            if (this.H.size() > 0) {
                bArr2 = this.H.peek();
                this.H.remove();
            } else {
                bArr2 = new byte[8192];
            }
        }
        int i17 = this.Q - remaining2;
        this.P.get(bArr2);
        this.P.compact();
        synchronized (this.I) {
            a aVar = new a(i17, bArr2);
            if (this.R) {
                this.J.add(new b(i3, i17, aVar.f116974b[0]));
            }
            this.I.add(aVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] p(String str) {
        float[] fArr;
        long[] jArr;
        int stopProcess;
        int i3;
        try {
            fArr = new float[1];
            jArr = new long[1];
            stopProcess = this.E.toStopProcess(fArr, jArr);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mAEtimrescore log: toStopProcess startTime:");
            sb5.append(fArr[0]);
            sb5.append("   ,samplePoints: ");
            sb5.append(jArr[0]);
            sb5.append(" ,obj: ");
            sb5.append(this);
            LogUtil.i("AIEffectHandlerThread", sb5.toString());
        } catch (Exception e16) {
            LogUtil.e("AIEffectHandlerThread", "dealAEtimrescoreLast error : ", e16);
        }
        if (stopProcess < 0) {
            LogUtil.i("AIEffectHandlerThread", " to stop error, " + stopProcess);
            return null;
        }
        if (fArr[0] != -1.0f || jArr[0] != -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.G != null) {
                this.G = null;
                LogUtil.e("AIEffectHandlerThread", "dealAEtimrescoreLast: may be err !!! ");
            }
            if (!q(str, fArr[0], jArr[0])) {
                return null;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            byte[] bArr = this.G;
            if (bArr != null && bArr.length != 0) {
                LogUtil.i("AIEffectHandlerThread", "mAEtimrescore log: total time:\n read file time\uff1a" + (elapsedRealtime2 - elapsedRealtime));
            }
            return null;
        }
        int result = this.E.getResult(this.G, (int) jArr[0], this.F);
        this.G = null;
        if (result < 0) {
            LogUtil.i("AIEffectHandlerThread", " getResult, " + stopProcess);
            return null;
        }
        SystemClock.elapsedRealtime();
        LogUtil.i("AIEffectHandlerThread", "mAEtimrescore log: total ret:" + stopProcess + "  " + result + " ,isNeedPostData: " + this.T);
        for (float f16 : this.F) {
        }
        return this.F;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q(String str, float f16, long j3) {
        int e16 = wz0.a.e(f16);
        int i3 = (int) (j3 * 2);
        if (e16 >= 0 && i3 >= 0) {
            if (i3 <= 1048576) {
                this.G = new byte[i3];
                RandomAccessFile randomAccessFile = null;
                try {
                    try {
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("getNeedFile: ");
                            sb5.append(randomAccessFile2.length());
                            sb5.append(" needData offset: ");
                            sb5.append(e16);
                            sb5.append(" len: ");
                            sb5.append(i3);
                            sb5.append("  endPosition: ");
                            int i16 = i3 + e16;
                            sb5.append(i16);
                            LogUtil.i("AIEffectHandlerThread", sb5.toString());
                            if (i16 > randomAccessFile2.length()) {
                                LogUtil.e("AIEffectHandlerThread", "position is over file ");
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e17) {
                                    LogUtil.e("AIEffectHandlerThread", "close file err 1: ", e17);
                                }
                                return false;
                            }
                            randomAccessFile2.seek(e16);
                            randomAccessFile2.read(this.G);
                            try {
                                randomAccessFile2.close();
                                return true;
                            } catch (IOException e18) {
                                LogUtil.e("AIEffectHandlerThread", "close file err 1: ", e18);
                                return true;
                            }
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            randomAccessFile = randomAccessFile2;
                            LogUtil.e("AIEffectHandlerThread", "get need file not find");
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException unused) {
                                    LogUtil.e("AIEffectHandlerThread", "close file err: ", e);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e26) {
                                    LogUtil.e("AIEffectHandlerThread", "close file err 1: ", e26);
                                }
                            }
                            return false;
                        } catch (Exception unused2) {
                            randomAccessFile = randomAccessFile2;
                            LogUtil.e("AIEffectHandlerThread", "get need file error");
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e27) {
                                    LogUtil.e("AIEffectHandlerThread", "close file err 1: ", e27);
                                }
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            randomAccessFile = randomAccessFile2;
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e28) {
                        e = e28;
                    } catch (Exception unused3) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e29) {
                            LogUtil.e("AIEffectHandlerThread", "close file err 1: ", e29);
                        }
                    }
                    throw th;
                }
            } else {
                try {
                    throw new Exception("get need file is too big: " + i3);
                } catch (Exception e36) {
                    LogUtil.e("AIEffectHandlerThread", "get need file err: " + i3, e36);
                    return false;
                }
            }
        } else {
            LogUtil.e("AIEffectHandlerThread", "getNeedFile: offset=" + e16 + " ,len: " + i3);
            return false;
        }
    }

    private void r() {
        this.D.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.AIEffectHandlerThread.3
            @Override // java.lang.Runnable
            public void run() {
                AIEffectHandlerThread.this.v();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s() {
        String str;
        AEtimrescore aEtimrescore = new AEtimrescore();
        this.E = aEtimrescore;
        int init = aEtimrescore.init(44100, 2);
        if (init != 0) {
            LogUtil.i("AIEffectHandlerThread", "initAEtimrescore init error : " + init);
            this.E = null;
            return init;
        }
        AEtimrescore.setDebug(this.R);
        if (!this.R) {
            return init;
        }
        try {
            str = new String(new String("/sdcard/tencent/karaoke/viplog.txt").getBytes("utf-8"));
        } catch (Exception e16) {
            LogUtil.e("AIEffectHandlerThread", "string to utf-8 error.", e16);
            str = "";
        }
        this.E.debug(str, 1);
        return init;
    }

    public static boolean t(int i3) {
        if (i3 != 10 && i3 != 11 && i3 != 20 && i3 != 21 && i3 != 22) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        if (this.R) {
            LogUtil.i("AIEffectHandlerThread", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (t(this.f116971m) && this.E != null) {
            synchronized (this.I) {
                a poll = this.I.poll();
                if (poll == null) {
                    LogUtil.e("AIEffectHandlerThread", "process data is null this time.");
                    return;
                }
                byte[] bArr = poll.f116974b;
                int i3 = poll.f116973a;
                if (this.R) {
                    this.K.add(new b(bArr.length, i3, bArr[0]));
                    this.N += bArr.length;
                }
                float a16 = (float) wz0.a.a(i3);
                u("onRecord -> data:------end-------" + ((int) bArr[0]) + " >>> " + i3 + " >>>> " + a16 + "  ,ret: " + this.E.process(a16, bArr, bArr.length / 2));
                synchronized (this.H) {
                    if (this.H.size() < 8) {
                        this.H.add(bArr);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.L == this.N + this.M + this.P.position()) {
            u("testData: total count is ok.");
        } else {
            u("testData: total count is error.");
        }
        int size = this.J.size();
        int size2 = this.K.size();
        u("testData inSize: " + size + "  outSize: " + size2);
        int min = Math.min(size, size2);
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < min) {
                b bVar = this.J.get(i3);
                b bVar2 = this.K.get(i3);
                if (bVar.f116976a != bVar2.f116976a) {
                    u("testData error" + bVar.f116976a + ">>>" + bVar2.f116976a);
                    break;
                }
                if (bVar.f116977b != bVar2.f116977b) {
                    u("testData maybe error" + bVar.f116976a + ">>>" + bVar2.f116976a);
                    break;
                }
                i3++;
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            u("testData is Ok ...");
        } else {
            u("testData is error !!!");
        }
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void a(int i3, int i16, int i17) {
        this.M += this.P.position();
        u("onSeek -> seek start" + i16 + ">>> mSeekTotalCount: " + this.M + " ,obj: " + this);
        this.P.clear();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSeek -> seek end");
        sb5.append(i16);
        sb5.append(" ,obj: ");
        sb5.append(this);
        u(sb5.toString());
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void b(int i3) {
        if (!isAlive()) {
            LogUtil.i("AIEffectHandlerThread", "onStop:  ,obj: " + this);
            return;
        }
        this.D.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.AIEffectHandlerThread.5
            @Override // java.lang.Runnable
            public void run() {
                if (AIEffectHandlerThread.t(AIEffectHandlerThread.this.f116971m) && AIEffectHandlerThread.this.E != null) {
                    LogUtil.i("AIEffectHandlerThread", "run: on stop  ,obj: " + this);
                    if (AIEffectHandlerThread.this.R) {
                        AIEffectHandlerThread.this.u("=====================================================");
                        AIEffectHandlerThread.this.w();
                        AIEffectHandlerThread.this.u("=====================================================");
                    }
                }
            }
        });
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void c(byte[] bArr, int i3, int i16) {
        if (!this.S) {
            u("per buf len: " + bArr.length + " ,obj: " + this);
            this.S = true;
        }
        if (!this.T || o(bArr, i3, i16)) {
            return;
        }
        r();
    }
}
