package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Handler;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.crossFade.AudioCrossFadeBusiness;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MicFileHandlerThread extends BaseHandlerThread implements com.tencent.karaoke.recordsdk.media.g {
    private long C;
    private boolean D;
    private Handler E;
    private RandomAccessFile F;
    private boolean G;
    private LinkedList<byte[]> H;
    private int I;
    private com.tencent.karaoke.recordsdk.media.i J;
    private boolean K;
    private int L;
    private ByteBuffer M;
    private volatile boolean N;
    private volatile boolean P;
    private AudioCrossFadeBusiness Q;
    private int[] R;
    private byte[] S;
    private boolean T;
    private int U;
    private int V;
    private long W;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f117002m;

    /* compiled from: P */
    /* renamed from: com.tencent.karaoke.recordsdk.media.audio.MicFileHandlerThread$5, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f117006d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f117007e;
        final /* synthetic */ MicFileHandlerThread this$0;

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("MicFileHandlerThread", "copySelectMicFile task run, currentGuideMicTask: " + ((Object) null) + ", startTime: " + this.f117006d + ", duration: " + this.f117007e);
            long j3 = 0;
            try {
                j3 = this.this$0.F.getFilePointer();
                MicFileHandlerThread.h(this.this$0);
                throw null;
            } catch (IOException e16) {
                LogUtil.i("MicFileHandlerThread", "copySelectMicFile exception");
                e16.printStackTrace();
                try {
                    this.this$0.F.seek(j3);
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("copySelectMicFile, ");
                sb5.append(e16.getMessage());
                throw null;
            }
        }
    }

    static /* synthetic */ com.tencent.karaoke.recordsdk.media.b h(MicFileHandlerThread micFileHandlerThread) {
        micFileHandlerThread.getClass();
        return null;
    }

    static /* synthetic */ int k(MicFileHandlerThread micFileHandlerThread) {
        int i3 = micFileHandlerThread.U;
        micFileHandlerThread.U = i3 + 1;
        return i3;
    }

    static /* synthetic */ vz0.a n(MicFileHandlerThread micFileHandlerThread) {
        micFileHandlerThread.getClass();
        return null;
    }

    private void r(int i3) {
        if (i3 == 3) {
            com.tencent.karaoke.recordsdk.media.k kVar = com.tencent.karaoke.recordsdk.media.k.f117057e;
            if (kVar.b()) {
                this.N = true;
                if (this.Q == null) {
                    this.Q = new AudioCrossFadeBusiness();
                }
                this.Q.setPcmSampleRate(44100);
                this.Q.setPcmChannel(2);
                this.Q.prepare();
                int a16 = kVar.a();
                if (!this.Q.setFadeInMs(0, a16)) {
                    LogUtil.i("MicFileHandlerThread", "setFadeInMs():fail,ms=" + a16 + ",LastErrorCode=" + this.Q.getLastErrorCode());
                    this.N = false;
                    return;
                }
                this.P = true;
                return;
            }
        }
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.N = false;
        AudioCrossFadeBusiness audioCrossFadeBusiness = this.Q;
        if (audioCrossFadeBusiness != null) {
            audioCrossFadeBusiness.release();
            this.Q = null;
            LogUtil.i("MicFileHandlerThread", "releaseFadeInBusiness()");
        }
        this.P = false;
    }

    private boolean t(final long j3) {
        return this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.MicFileHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long length = MicFileHandlerThread.this.F.length();
                    LogUtil.i("MicFileHandlerThread", "seekPosition: " + j3 + ", fileLength: " + length);
                    if (j3 > length) {
                        MicFileHandlerThread.this.F.seek(length);
                        byte[] bArr = new byte[8192];
                        long j16 = 8192;
                        long j17 = (j3 - length) / j16;
                        for (long j18 = 0; j18 < j17; j18++) {
                            MicFileHandlerThread.this.F.write(bArr);
                        }
                        MicFileHandlerThread.this.F.write(bArr, 0, (int) ((j3 - length) % j16));
                    } else {
                        MicFileHandlerThread.this.F.seek(j3);
                        if (MicFileHandlerThread.this.K) {
                            MicFileHandlerThread.this.F.setLength(j3);
                        }
                    }
                    LogUtil.i("MicFileHandlerThread", "seek complete ->");
                } catch (IOException e16) {
                    LogUtil.w("MicFileHandlerThread", e16);
                    MicFileHandlerThread.this.G = false;
                    try {
                        MicFileHandlerThread.this.F.close();
                    } catch (IOException e17) {
                        LogUtil.i("MicFileHandlerThread", "can't close?", e17);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(byte[] bArr) {
        int i3;
        if (this.D) {
            int i16 = 0;
            while (true) {
                if (i16 >= this.I) {
                    break;
                }
                if (bArr[i16] != 0) {
                    this.D = false;
                    break;
                }
                i16++;
            }
        }
        if (this.D) {
            long j3 = this.C + this.I;
            this.C = j3;
            if (j3 >= this.W) {
                com.tencent.karaoke.recordsdk.media.i iVar = this.J;
                if (this.f117002m) {
                    i3 = MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT;
                } else {
                    i3 = MessageRecord.MSG_TYPE_GAME_SHARE;
                }
                iVar.onError(i3);
                this.f117002m = false;
                this.C = 0L;
                return;
            }
            return;
        }
        this.C = 0L;
    }

    private byte[] v(byte[] bArr, int i3) {
        byte[] bArr2;
        if (this.N && bArr != null && i3 > 0 && this.Q != null && this.P && (bArr2 = this.S) != null && bArr2.length > 0) {
            int[] iArr = this.R;
            iArr[0] = i3;
            boolean processFadeIn = this.Q.processFadeIn(bArr, i3, bArr2, iArr);
            this.T = processFadeIn;
            if (!processFadeIn) {
                LogUtil.i("MicFileHandlerThread", "processFadeIn():fail,LastErrorCode=" + this.Q.getLastErrorCode());
                this.N = false;
                return bArr;
            }
            return this.S;
        }
        return bArr;
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void a(int i3, final int i16, int i17) {
        int c16;
        if (!this.G) {
            return;
        }
        if (i17 == -1) {
            if (this.K) {
                c16 = 0;
            } else {
                c16 = wz0.a.c(this.L);
            }
            t(i16 + c16);
            return;
        }
        this.M.flip();
        int remaining = this.M.remaining();
        if (remaining > 0) {
            LogUtil.i("MicFileHandlerThread", "onSeek -> write remain data:" + remaining);
            this.M.get(new byte[remaining]);
            this.M.compact();
        }
        r(i17);
        this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.MicFileHandlerThread.3
            @Override // java.lang.Runnable
            public void run() {
                int c17;
                int i18;
                int c18;
                try {
                    long length = MicFileHandlerThread.this.F.length();
                    int i19 = i16;
                    if (i19 < 0) {
                        LogUtil.w("MicFileHandlerThread", "bytePosition should not be less than 0 while SEEK_SET");
                        if (MicFileHandlerThread.this.K) {
                            c18 = 0;
                        } else {
                            c18 = wz0.a.c(MicFileHandlerThread.this.L);
                        }
                        i18 = c18 + 0;
                    } else {
                        if (MicFileHandlerThread.this.K) {
                            c17 = 0;
                        } else {
                            c17 = wz0.a.c(MicFileHandlerThread.this.L);
                        }
                        i18 = i19 + c17;
                    }
                    long j3 = i18;
                    if (j3 > length) {
                        LogUtil.i("MicFileHandlerThread", "seek backward because seekPosition(" + j3 + ") is larger than file length: " + length);
                        MicFileHandlerThread.this.F.seek(length);
                        byte[] bArr = new byte[8192];
                        long j16 = j3 - length;
                        long j17 = (long) 8192;
                        long j18 = j16 / j17;
                        for (long j19 = 0; j19 < j18; j19++) {
                            MicFileHandlerThread.this.F.write(bArr);
                        }
                        MicFileHandlerThread.this.F.write(bArr, 0, (int) (j16 % j17));
                        LogUtil.i("MicFileHandlerThread", "seek backward complete");
                    } else {
                        LogUtil.i("MicFileHandlerThread", "seek forward because seekPosition(" + j3 + ") is less than (or equal with) file length: " + length);
                        MicFileHandlerThread.this.F.seek(j3);
                        if (MicFileHandlerThread.this.K) {
                            MicFileHandlerThread.this.F.setLength(j3);
                        }
                    }
                    LogUtil.i("MicFileHandlerThread", "onSeek complete. file length:" + MicFileHandlerThread.this.F.length());
                } catch (IOException e16) {
                    LogUtil.w("MicFileHandlerThread", e16);
                    MicFileHandlerThread.this.G = false;
                    try {
                        MicFileHandlerThread.this.F.close();
                    } catch (IOException e17) {
                        LogUtil.i("MicFileHandlerThread", "can't close?", e17);
                    }
                }
            }
        });
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void b(int i3) {
        LogUtil.i("MicFileHandlerThread", "onStop, " + getName());
        this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.MicFileHandlerThread.4
            @Override // java.lang.Runnable
            public void run() {
                if (MicFileHandlerThread.this.D) {
                    LogUtil.w("MicFileHandlerThread", "all the recorded data is 0");
                    if (MicFileHandlerThread.this.K) {
                        try {
                            MicFileHandlerThread.this.F.setLength(0L);
                        } catch (IOException e16) {
                            LogUtil.i("MicFileHandlerThread", "can't setLength", e16);
                        }
                    }
                }
                if (MicFileHandlerThread.this.G) {
                    try {
                        MicFileHandlerThread.this.M.flip();
                        int remaining = MicFileHandlerThread.this.M.remaining();
                        if (remaining > 0) {
                            LogUtil.i("MicFileHandlerThread", "onStop -> write remain data:" + remaining);
                            byte[] bArr = new byte[remaining];
                            MicFileHandlerThread.this.M.get(bArr);
                            MicFileHandlerThread.this.F.write(bArr);
                        }
                        LogUtil.i("MicFileHandlerThread", "onStop -> file  length:" + MicFileHandlerThread.this.F.length());
                        MicFileHandlerThread.this.F.close();
                    } catch (IOException e17) {
                        LogUtil.i("MicFileHandlerThread", "can't close?", e17);
                    }
                }
                MicFileHandlerThread.this.s();
                MicFileHandlerThread.this.quit();
            }
        });
    }

    @Override // com.tencent.karaoke.recordsdk.media.g
    public void c(byte[] bArr, int i3, int i16) {
        final byte[] bArr2;
        if (!this.G) {
            return;
        }
        byte[] v3 = v(bArr, i3);
        if (this.M.remaining() >= i3) {
            this.M.put(v3, 0, i3);
        }
        this.M.flip();
        if (this.M.remaining() < this.I) {
            this.M.compact();
            return;
        }
        synchronized (this.H) {
            if (this.H.size() > 0) {
                bArr2 = this.H.peek();
                this.H.remove();
            } else {
                bArr2 = new byte[this.I];
            }
        }
        int i17 = this.V + 1;
        this.V = i17;
        if (i17 - this.U > 50) {
            LogUtil.w("MicFileHandlerThread", String.format("Maybe OOM will happen! Decode:%d, Write:%d", Integer.valueOf(i17), Integer.valueOf(this.U)));
        }
        this.M.get(bArr2);
        this.M.compact();
        this.E.post(new Runnable() { // from class: com.tencent.karaoke.recordsdk.media.audio.MicFileHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                MicFileHandlerThread.this.u(bArr2);
                try {
                    MicFileHandlerThread.this.F.write(bArr2, 0, MicFileHandlerThread.this.I);
                    synchronized (MicFileHandlerThread.this.H) {
                        if (MicFileHandlerThread.this.H.size() < 3) {
                            MicFileHandlerThread.this.H.add(bArr2);
                        }
                    }
                    MicFileHandlerThread.k(MicFileHandlerThread.this);
                } catch (IOException e16) {
                    LogUtil.w("MicFileHandlerThread", e16);
                    MicFileHandlerThread.this.G = false;
                    MicFileHandlerThread.n(MicFileHandlerThread.this);
                    try {
                        MicFileHandlerThread.this.F.close();
                    } catch (IOException e17) {
                        LogUtil.i("MicFileHandlerThread", "can't close?", e17);
                    }
                }
            }
        });
    }
}
