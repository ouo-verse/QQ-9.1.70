package com.tencent.mobileqq.magicface.model;

import android.media.AudioRecord;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RecordVolume implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f243400d;

    /* renamed from: e, reason: collision with root package name */
    private AudioRecord f243401e;

    /* renamed from: f, reason: collision with root package name */
    private int f243402f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f243403h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3);
    }

    public RecordVolume(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f243403h = false;
            this.f243400d = aVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            try {
                int i3 = RecordParams.f307250a;
                this.f243402f = AudioRecord.getMinBufferSize(i3, 2, 2);
                AudioRecord audioRecord2 = new AudioRecord(1, i3, 2, 2, this.f243402f);
                this.f243401e = audioRecord2;
                AudioMonitor.startRecording(audioRecord2);
                int i16 = this.f243402f;
                short[] sArr = new short[i16];
                this.f243403h = true;
                while (this.f243403h) {
                    try {
                        int read = this.f243401e.read(sArr, 0, this.f243402f);
                        long j3 = 0;
                        for (int i17 = 0; i17 < i16; i17++) {
                            short s16 = sArr[i17];
                            j3 += s16 * s16;
                        }
                        if (read != 0 && j3 != 0) {
                            double log10 = Math.log10(j3 / read) * 10.0d;
                            if (QLog.isColorLevel()) {
                                QLog.i("recordVolume", 2, "====dB===" + log10);
                            }
                            a aVar = this.f243400d;
                            if (aVar != null) {
                                aVar.a((int) Math.round(log10));
                            }
                        }
                        LockMethodProxy.sleep(100L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                audioRecord = this.f243401e;
            } catch (Exception e17) {
                e17.printStackTrace();
                AudioRecord audioRecord3 = this.f243401e;
                if (audioRecord3 != null) {
                    try {
                        if (audioRecord3.getRecordingState() == 3) {
                            this.f243401e.stop();
                        }
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.i("RecordVolume", 2, "RecordVolume exception=" + e18.getMessage());
                        }
                    }
                    this.f243401e.release();
                    this.f243401e = null;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (audioRecord != null) {
                try {
                    if (audioRecord.getRecordingState() == 3) {
                        this.f243401e.stop();
                    }
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.i("RecordVolume", 2, "RecordVolume exception=" + e19.getMessage());
                    }
                }
                this.f243401e.release();
                this.f243401e = null;
                if (!QLog.isColorLevel()) {
                    return;
                }
                QLog.i("RecordVolume", 2, "====recordVolume release ok==");
            }
        } catch (Throwable th5) {
            AudioRecord audioRecord4 = this.f243401e;
            if (audioRecord4 != null) {
                try {
                    if (audioRecord4.getRecordingState() == 3) {
                        this.f243401e.stop();
                    }
                } catch (Exception e26) {
                    if (QLog.isColorLevel()) {
                        QLog.i("RecordVolume", 2, "RecordVolume exception=" + e26.getMessage());
                    }
                }
                this.f243401e.release();
                this.f243401e = null;
                if (QLog.isColorLevel()) {
                    QLog.i("RecordVolume", 2, "====recordVolume release ok==");
                    throw th5;
                }
                throw th5;
            }
            throw th5;
        }
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f243403h = false;
        }
    }
}
