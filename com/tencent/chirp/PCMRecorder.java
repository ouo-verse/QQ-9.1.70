package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes5.dex */
public class PCMRecorder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f99151a;

    /* renamed from: b, reason: collision with root package name */
    private int f99152b;

    /* renamed from: c, reason: collision with root package name */
    private volatile RecordThread f99153c;

    /* renamed from: d, reason: collision with root package name */
    private Context f99154d;

    /* renamed from: e, reason: collision with root package name */
    private a f99155e;

    /* loaded from: classes5.dex */
    class RecordThread extends BaseThread {
        static IPatchRedirector $redirector_;
        public volatile boolean C;

        RecordThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PCMRecorder.this);
            } else {
                this.C = true;
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            AudioRecord audioRecord;
            boolean isColorLevel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PCMRecorder", 2, "start record");
            }
            try {
                audioRecord = new AudioRecord(0, PCMRecorder.this.f99151a, 2, 2, AudioRecord.getMinBufferSize(PCMRecorder.this.f99151a, 2, 2));
            } catch (Throwable th5) {
                th = th5;
                audioRecord = null;
            }
            try {
            } catch (Throwable th6) {
                th = th6;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("PCMRecorder", 2, "", th);
                    }
                    if (PCMRecorder.this.f99155e != null) {
                        PCMRecorder.this.f99155e.b(-2);
                    }
                    if (!isColorLevel) {
                        return;
                    }
                } finally {
                    QQAudioUtils.i(PCMRecorder.this.f99154d, false);
                    if (audioRecord != null) {
                        audioRecord.release();
                    }
                    PCMRecorder.this.f99153c = null;
                    if (QLog.isColorLevel()) {
                        QLog.d("PCMRecorder", 2, "record end");
                    }
                }
            }
            if (audioRecord.getState() != 1) {
                PCMRecorder.this.f99155e.b(-1);
                QQAudioUtils.i(PCMRecorder.this.f99154d, false);
                audioRecord.release();
                PCMRecorder.this.f99153c = null;
                if (QLog.isColorLevel()) {
                    QLog.d("PCMRecorder", 2, "record end");
                    return;
                }
                return;
            }
            QQAudioUtils.i(PCMRecorder.this.f99154d, true);
            AudioMonitor.startRecording(audioRecord);
            byte[] bArr = new byte[PCMRecorder.this.f99152b];
            loop0: while (true) {
                int i3 = 0;
                while (this.C) {
                    i3 += audioRecord.read(bArr, i3, PCMRecorder.this.f99152b - i3);
                    if (i3 == PCMRecorder.this.f99152b) {
                        break;
                    }
                }
                PCMRecorder.this.f99155e.a(bArr);
            }
            QQAudioUtils.i(PCMRecorder.this.f99154d, false);
            audioRecord.release();
            PCMRecorder.this.f99153c = null;
            if (!QLog.isColorLevel()) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(byte[] bArr);

        void b(int i3);
    }

    public PCMRecorder(Context context, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), aVar);
            return;
        }
        this.f99152b = 0;
        this.f99154d = context;
        this.f99151a = i3;
        this.f99152b = (i3 / 50) * 2 * 2;
        this.f99155e = aVar;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f99153c == null) {
            this.f99153c = new RecordThread();
            this.f99153c.start();
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f99153c != null) {
            this.f99153c.C = false;
            this.f99153c = null;
        }
    }
}
