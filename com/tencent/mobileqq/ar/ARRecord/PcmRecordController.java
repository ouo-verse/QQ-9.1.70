package com.tencent.mobileqq.ar.ARRecord;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class PcmRecordController extends AudioRecordController {
    private c D;
    private volatile boolean E;
    private volatile boolean F;
    private long G;
    private String H;

    public PcmRecordController(g gVar, String str) {
        super(gVar);
        this.H = str;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void o() {
        this.G = System.currentTimeMillis();
        while (this.E) {
            if (this.D != null && this.G > 0 && !this.F) {
                try {
                    long currentTimeMillis = System.currentTimeMillis() - this.G;
                    byte[] a16 = this.D.a(currentTimeMillis);
                    g gVar = this.C.get();
                    if (gVar != null) {
                        gVar.s(a16, SystemClock.elapsedRealtimeNanos());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PcmRecordController", 2, String.format("record audio duration: %s, buffer length: %s", Long.valueOf(currentTimeMillis), Integer.valueOf(a16.length)));
                    }
                    this.G = System.currentTimeMillis();
                    Thread.sleep(200L);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("PcmRecordController", 1, "AudioRecordController read fail.", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void p() {
        try {
            if (this.D == null) {
                this.D = new c(this.H, 48000, 1, 16);
            }
            if (!this.E) {
                this.E = true;
                this.F = false;
                start();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PcmRecordController", 2, String.format("startAudioRecord, mIsRecording: %s", Boolean.valueOf(this.E)));
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.AudioRecordController
    public void q() {
        if (this.E) {
            c cVar = this.D;
            if (cVar != null) {
                cVar.b();
                this.D = null;
            }
            this.E = false;
            this.G = 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PcmRecordController", 2, String.format("stopAudioRecord, isRecording: %s", Boolean.valueOf(this.E)));
        }
    }
}
