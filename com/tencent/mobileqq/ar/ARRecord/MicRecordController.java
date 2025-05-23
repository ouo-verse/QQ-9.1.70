package com.tencent.mobileqq.ar.ARRecord;

import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MicRecordController extends AudioRecordController {
    private AudioRecord D;
    private boolean E;
    private int F;
    private byte[] G;
    private volatile boolean H;

    public MicRecordController(g gVar) {
        super(gVar);
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void o() {
        g gVar;
        while (this.E) {
            if (this.D != null && !this.H) {
                try {
                    int read = this.D.read(this.G, 0, this.F);
                    if (read > 0 && (gVar = this.C.get()) != null) {
                        byte[] bArr = new byte[read];
                        System.arraycopy(this.G, 0, bArr, 0, read);
                        gVar.s(bArr, SystemClock.elapsedRealtimeNanos());
                    }
                } catch (Exception e16) {
                    QLog.e("MicAudioRecordControlle", 1, "AudioRecordController read fail.", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void p() {
        if (this.D == null) {
            this.F = AudioRecord.getMinBufferSize(48000, 1, 2) * 4;
            this.D = new AudioRecord(1, 48000, 1, 2, this.F);
            this.G = new byte[this.F];
        }
        if (!this.E) {
            AudioMonitor.startRecording(this.D);
            this.E = true;
            start();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void q() {
        if (this.E) {
            AudioRecord audioRecord = this.D;
            if (audioRecord != null) {
                audioRecord.stop();
                this.D.release();
                this.D = null;
            }
            this.E = false;
        }
    }
}
