package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AudioCapture extends yq2.b {
    public static int A = 160768;
    public static int B = 4;

    /* renamed from: c, reason: collision with root package name */
    Context f288051c;

    /* renamed from: d, reason: collision with root package name */
    AudioRecord f288052d;

    /* renamed from: e, reason: collision with root package name */
    public int f288053e;

    /* renamed from: f, reason: collision with root package name */
    public int f288054f;

    /* renamed from: g, reason: collision with root package name */
    byte[] f288055g = null;

    /* renamed from: h, reason: collision with root package name */
    int f288056h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f288057i = 0;

    /* renamed from: j, reason: collision with root package name */
    byte[] f288058j = null;

    /* renamed from: k, reason: collision with root package name */
    int f288059k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f288060l = 0;

    /* renamed from: m, reason: collision with root package name */
    Object f288061m = new Object();

    /* renamed from: n, reason: collision with root package name */
    volatile boolean f288062n = false;

    /* renamed from: o, reason: collision with root package name */
    boolean f288063o = false;

    /* renamed from: p, reason: collision with root package name */
    boolean f288064p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f288065q = false;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f288066r = true;

    /* renamed from: s, reason: collision with root package name */
    public volatile int f288067s = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f288068t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f288069u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f288070v = false;

    /* renamed from: w, reason: collision with root package name */
    public AtomicReference<SVHwEncoder> f288071w = new AtomicReference<>(null);

    /* renamed from: x, reason: collision with root package name */
    public AtomicReference<com.tencent.mobileqq.shortvideo.util.a> f288072x = new AtomicReference<>(null);

    /* renamed from: y, reason: collision with root package name */
    long f288073y;

    /* renamed from: z, reason: collision with root package name */
    long f288074z;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class RecordThread2 extends BaseThread {
        RecordThread2() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            int i3;
            byte[] bArr;
            int i16;
            byte[] bArr2;
            AudioCapture.this.l();
            while (true) {
                int i17 = 0;
                while (AudioCapture.this.f288062n) {
                    synchronized (AudioCapture.this.f288061m) {
                        try {
                            LockMethodProxy.wait(AudioCapture.this.f288061m);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (AudioCapture.this.f288062n) {
                        AudioCapture.this.f288073y = System.currentTimeMillis();
                        AudioCapture.this.f288074z = System.currentTimeMillis();
                        Process.setThreadPriority(-19);
                        boolean z16 = true;
                        while (b.f288186b) {
                            AudioCapture audioCapture = AudioCapture.this;
                            if (audioCapture.f288052d != null && audioCapture.f288055g != null && audioCapture.f288058j != null) {
                                audioCapture.f288074z = System.currentTimeMillis();
                                AudioCapture audioCapture2 = AudioCapture.this;
                                int i18 = audioCapture2.f288056h;
                                int i19 = audioCapture2.f288057i;
                                if (i18 >= i19) {
                                    AudioRecord audioRecord = audioCapture2.f288052d;
                                    if (audioRecord != null && (bArr = audioCapture2.f288055g) != null) {
                                        i3 = audioRecord.read(bArr, 0, i19);
                                    } else {
                                        i3 = 0;
                                    }
                                    AudioCapture.this.i(i3);
                                    if (z16) {
                                        z16 = false;
                                    } else {
                                        AudioCapture audioCapture3 = AudioCapture.this;
                                        audioCapture3.w(audioCapture3.f288055g, i3, System.currentTimeMillis() - AudioCapture.this.f288073y, true, 4);
                                    }
                                } else {
                                    AudioRecord audioRecord2 = audioCapture2.f288052d;
                                    if (audioRecord2 != null && (bArr2 = audioCapture2.f288055g) != null) {
                                        i16 = audioRecord2.read(bArr2, 0, i18);
                                    } else {
                                        i16 = 0;
                                    }
                                    AudioCapture.this.i(i16);
                                    if (i16 > 0) {
                                        if (z16) {
                                            z16 = false;
                                        } else {
                                            int i26 = i17 + i16;
                                            AudioCapture audioCapture4 = AudioCapture.this;
                                            int i27 = audioCapture4.f288057i;
                                            if (i26 > i27) {
                                                System.arraycopy(audioCapture4.f288055g, 0, audioCapture4.f288058j, i17, i27 - i17);
                                                AudioCapture audioCapture5 = AudioCapture.this;
                                                int g16 = audioCapture5.g(audioCapture5.f288058j, audioCapture5.f288057i);
                                                AudioCapture audioCapture6 = AudioCapture.this;
                                                int i28 = audioCapture6.f288057i - g16;
                                                audioCapture6.w(audioCapture6.f288058j, i28, System.currentTimeMillis() - AudioCapture.this.f288073y, true, 4);
                                                if (g16 > 0) {
                                                    byte[] bArr3 = AudioCapture.this.f288058j;
                                                    System.arraycopy(bArr3, i28, bArr3, 0, g16);
                                                }
                                                AudioCapture audioCapture7 = AudioCapture.this;
                                                int i29 = audioCapture7.f288057i - i17;
                                                int i36 = i16 - i29;
                                                System.arraycopy(audioCapture7.f288055g, i29, audioCapture7.f288058j, g16, i36);
                                                i26 = g16 + i36;
                                            } else {
                                                System.arraycopy(audioCapture4.f288055g, 0, audioCapture4.f288058j, i17, i16);
                                            }
                                            i17 = i26;
                                        }
                                    }
                                }
                            }
                        }
                        AudioCapture audioCapture8 = AudioCapture.this;
                        int g17 = audioCapture8.g(audioCapture8.f288058j, i17);
                        int i37 = i17 - g17;
                        AudioCapture audioCapture9 = AudioCapture.this;
                        audioCapture9.w(audioCapture9.f288058j, i37, System.currentTimeMillis() - AudioCapture.this.f288073y, false, 9);
                        if (g17 > 0) {
                            byte[] bArr4 = AudioCapture.this.f288058j;
                            System.arraycopy(bArr4, i37, bArr4, 0, g17);
                            i17 = g17;
                        } else if (QLog.isColorLevel()) {
                            QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: leftLen=" + g17);
                        }
                    } else {
                        continue;
                    }
                }
                AudioCapture.this.q();
                return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a extends yq2.c {
    }

    public AudioCapture(Context context) {
        this.f288053e = 0;
        this.f288054f = 0;
        this.f288051c = context;
        this.f288053e = 0;
        this.f288054f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(byte[] bArr, int i3) {
        return 0;
    }

    public void h(a aVar) {
        a(aVar, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    void i(int i3) {
        if (i3 == -3) {
            this.f288066r = false;
            this.f288067s = -1;
        } else if (i3 == 0) {
            int i16 = this.f288053e;
            if (i16 < 5) {
                this.f288053e = i16 + 1;
            } else {
                this.f288066r = false;
                this.f288067s = -2;
            }
        } else {
            this.f288053e = 0;
            int i17 = 128;
            if (i3 <= 128) {
                i17 = i3;
            }
            if (!this.f288068t) {
                boolean isFoundProductFeature = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f69002p);
                if (isFoundProductFeature && this.f288054f < 5) {
                    this.f288069u = PreviewContext.checkIsDisablePrivilage(this.f288055g, i17);
                } else {
                    this.f288069u = false;
                }
                int i18 = this.f288054f + 1;
                this.f288054f = i18;
                boolean z16 = this.f288069u;
                if (!z16) {
                    this.f288068t = true;
                } else if (z16 && i18 >= 5) {
                    this.f288068t = true;
                    this.f288066r = false;
                    this.f288067s = -3;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + i3 + " mDisableAudioPrivilage=" + this.f288069u + " blackPhone=" + isFoundProductFeature + " mAudioInvalidData=" + this.f288054f);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.f288069u + " limit=" + i17 + " mAudioCanUsed=" + this.f288066r);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "checkAudioPrivilage[end]: result=" + i3 + " mAudioCanUsed=" + this.f288066r);
        }
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[destory]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        this.f288062n = false;
        synchronized (this.f288061m) {
            this.f288061m.notifyAll();
        }
        t();
        n();
        this.f288059k = 0;
        this.f288060l = 0;
    }

    public boolean k() {
        this.f288062n = true;
        this.f288068t = false;
        this.f288069u = false;
        this.f288070v = RMVideoStateMgr.u().C();
        new RecordThread2().start();
        return true;
    }

    public synchronized boolean l() {
        boolean z16 = this.f288065q;
        if (z16) {
            return z16;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
        this.f288056h = minBufferSize;
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.f288055g = new byte[minBufferSize];
            int i3 = A;
            int i16 = B;
            if (minBufferSize > i3 / i16) {
                i3 = minBufferSize * i16;
            }
            this.f288057i = i3;
            this.f288058j = new byte[i3];
            this.f288065q = true;
            c(3, Boolean.TRUE, 0);
            return true;
        }
        if (!c.b().d().b(this, 3, "init audio failed")) {
            c(3, "init audio failed");
        }
        return false;
    }

    public void m() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        if (!this.f288063o) {
            try {
                l();
                AudioRecord audioRecord = new AudioRecord(1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.f288056h);
                this.f288052d = audioRecord;
                if (audioRecord.getState() == 0) {
                    c(5, HardCodeUtil.qqStr(R.string.jsg));
                    return;
                }
                this.f288063o = true;
            } catch (Exception e16) {
                e16.printStackTrace();
                c(5, HardCodeUtil.qqStr(R.string.jsj));
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
    }

    public void n() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        AudioRecord audioRecord = this.f288052d;
        if (audioRecord != null) {
            audioRecord.release();
            this.f288052d = null;
            this.f288063o = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        this.f288051c = null;
    }

    public void o(a aVar) {
        e(aVar);
    }

    public void p() {
        this.f288059k = 0;
        this.f288060l = 0;
    }

    public void q() {
        this.f288056h = 0;
        this.f288055g = null;
        this.f288057i = 0;
        this.f288058j = null;
        this.f288065q = false;
        this.f288053e = 0;
        this.f288054f = 0;
        this.f288069u = false;
    }

    public void r() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        AudioRecord audioRecord = this.f288052d;
        if (audioRecord != null && this.f288063o && !this.f288064p) {
            try {
                AudioMonitor.startRecording(audioRecord);
                this.f288064p = true;
                c(6, Boolean.TRUE);
            } catch (IllegalStateException e16) {
                this.f288064p = false;
                e16.printStackTrace();
                try {
                    this.f288052d.release();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                c(6, HardCodeUtil.qqStr(R.string.jsk));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
    }

    public void s() {
        if (!b.f288186b) {
            return;
        }
        synchronized (this.f288061m) {
            this.f288061m.notifyAll();
        }
        c(1, 0);
    }

    public void t() {
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        AudioRecord audioRecord = this.f288052d;
        if (audioRecord != null && this.f288063o && this.f288064p) {
            audioRecord.stop();
            this.f288064p = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.f288063o + " isStart=" + this.f288064p + " mAudioRecord=" + this.f288052d);
        }
        this.f288051c = null;
    }

    public void u() {
        if (b.f288186b) {
            return;
        }
        c(2, 0);
    }

    void v(byte[] bArr, int i3, long j3, boolean z16, int i16) {
        int i17;
        AVIOStruct aVIOStruct = new AVIOStruct();
        if (z16) {
            i17 = this.f288059k;
        } else {
            i17 = this.f288059k;
            this.f288059k = i17 + 1;
        }
        aVIOStruct.pBlockIndex = i17;
        int i18 = this.f288060l;
        this.f288060l = i18 + 1;
        aVIOStruct.pFrameIndex = i18;
        aVIOStruct.aBitrate = CodecParam.mDstAudioEncBitrate;
        aVIOStruct.pCodec = CodecParam.mCodecId;
        aVIOStruct.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
        aVIOStruct.aChannel = CodecParam.mAudioChannel;
        aVIOStruct.aFormat = CodecParam.mAudioFormat;
        aVIOStruct.aSampleRate = CodecParam.mAudioSampleRate;
        if (bArr != null && i3 > 0) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            c.b().c().handleAudio(bArr2, aVIOStruct, (int) j3);
            SVHwEncoder sVHwEncoder = this.f288071w.get();
            if (sVHwEncoder != null) {
                SVHwEncoder.a aVar = new SVHwEncoder.a();
                aVar.f287989a = bArr2;
                aVar.f287990b = 0;
                aVar.f287991c = i3;
                aVar.f287992d = SystemClock.elapsedRealtime();
                aVar.f287993e = false;
                aVar.f287994f = false;
                sVHwEncoder.D(aVar, false);
            }
            c(i16, 0);
        }
    }

    void w(byte[] bArr, int i3, long j3, boolean z16, int i16) {
        if (this.f288070v) {
            x(bArr, i3, j3, z16, i16);
        } else {
            v(bArr, i3, j3, z16, i16);
        }
    }

    void x(byte[] bArr, int i3, long j3, boolean z16, int i16) {
        if (bArr != null && i3 > 0 && i3 <= bArr.length) {
            if (this.f288072x.get() != null) {
                this.f288072x.get().d(bArr, 0, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
            }
            c(i16, 0);
        }
    }
}
