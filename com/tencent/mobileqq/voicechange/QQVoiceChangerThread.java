package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVoiceChangerThread extends BaseThread implements com.tencent.mobileqq.qqaudio.audioprocessor.d {
    static IPatchRedirector $redirector_;
    private Context C;
    private String D;
    private FileInputStream E;
    private FileOutputStream F;
    public volatile boolean G;
    private com.tencent.mobileqq.qqaudio.audioprocessor.b H;
    private AudioTrack I;
    private boolean J;
    private byte[] K;
    int L;
    int M;
    int N;
    public String P;
    b Q;
    d R;
    a S;

    public QQVoiceChangerThread(Context context, b bVar, d dVar, String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, bVar, dVar, str, aVar);
            return;
        }
        this.E = null;
        this.F = null;
        this.G = true;
        this.I = null;
        this.J = false;
        this.K = new byte[960];
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.C = context;
        this.D = bVar.f313138a;
        this.Q = bVar;
        this.R = dVar;
        this.P = str;
        this.S = aVar;
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.D + " sampleRate=" + bVar.f313140c + " bitRate=" + bVar.f313142e + " voiceType=" + bVar.f313143f + " changeType=" + bVar.f313144g);
        }
    }

    private void o() throws IOException {
        AudioTrack audioTrack = this.I;
        if (audioTrack != null) {
            audioTrack.release();
        }
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = this.H;
        if (bVar != null) {
            bVar.release();
        }
        FileInputStream fileInputStream = this.E;
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        FileOutputStream fileOutputStream = this.F;
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (this.J) {
            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).deleteAllFiles(this.Q.f313138a, this.D);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.J);
        }
    }

    private void r() throws IOException {
        String str = this.R.f313161f;
        if (!TextUtils.isEmpty(str)) {
            this.D = str;
        } else {
            this.D = ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).renameFileToPcm(this.D);
        }
        this.E = new FileInputStream(this.D);
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "open:" + this.D + " a=" + this.E.available());
        }
    }

    private void t(byte[] bArr, int i3) {
        int b16 = (int) AudioHelper.b(this.C, bArr, i3, 1.0f);
        a aVar = this.S;
        if (aVar != null) {
            aVar.onSlicePlayed(b16, (this.N * 100) / this.M, this.L);
        }
        this.I.write(bArr, 0, i3);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
    public void a(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar, (Object) aVar);
            return;
        }
        if (cVar instanceof VoiceChange) {
            d dVar = this.R;
            if (!dVar.f313158c && dVar.f313156a) {
                t(aVar.f262210c, aVar.f262208a);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
    public void b(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar, (Object) aVar);
            return;
        }
        if ((cVar instanceof SilkCodecWrapper) || (cVar instanceof AmrInputStreamWrapper)) {
            this.L += (int) ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getMillisecond(this.Q.f313140c, 4, 2, aVar.f262208a);
            if (this.R.f313156a) {
                t(aVar.f262210c, aVar.f262208a);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QQVoiceChanger", 2, "copy AFPCM failed!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void p() throws IOException {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.M = this.E.available();
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + this.M + " filePath=" + this.D + "pcmFilePath=" + this.Q.f313138a);
        }
        boolean z16 = false;
        boolean z17 = false;
        while (true) {
            if (!this.G) {
                break;
            }
            if (this.R.f313160e && !z16) {
                int i3 = this.Q.f313143f;
                if (i3 == 0) {
                    this.E.skip(6);
                } else if (i3 == 1) {
                    this.E.skip(10L);
                } else if (i3 == 2) {
                    int read = this.E.read(this.K, 0, 64);
                    if (read != 64 || (fileOutputStream = this.F) == null) {
                        break;
                    }
                    fileOutputStream.write(this.K, 0, read);
                    this.F.flush();
                }
                z16 = true;
            }
            try {
                int read2 = this.E.read(this.K, 0, 960);
                if (read2 == -1) {
                    this.G = false;
                    a aVar = this.S;
                    if (aVar != null) {
                        aVar.onPlayEnd();
                    }
                    ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(4, this.L);
                    IVoiceChangeManager iVoiceChangeManager = (IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class);
                    int i16 = this.L;
                    b bVar = this.Q;
                    iVoiceChangeManager.voiceChangeEnd(i16, bVar.f313138a, this.D, bVar.f313144g, bVar.f313143f);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + this.L);
                    }
                } else {
                    this.N += read2;
                    c.a a16 = this.H.a(this.K, 0, read2);
                    ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).noteOneFrameProcessed();
                    FileOutputStream fileOutputStream2 = this.F;
                    if (fileOutputStream2 != null && this.R.f313158c) {
                        if (!z17) {
                            b bVar2 = this.Q;
                            byte[] a17 = RecordParams.a(bVar2.f313143f, bVar2.f313140c);
                            this.F.write(a17, 0, a17.length);
                            this.F.flush();
                            z17 = true;
                        }
                        if (a16 != null) {
                            this.F.write(a16.f262210c, 0, a16.f262208a);
                            this.F.flush();
                        }
                    } else if (fileOutputStream2 != null && a16 != null) {
                        fileOutputStream2.write(a16.f262210c, 0, a16.f262208a);
                        this.F.flush();
                    }
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("QQVoiceChanger", 2, "read failed" + e16.getStackTrace());
                }
            }
        }
        a aVar2 = this.S;
        if (aVar2 != null) {
            aVar2.onPlayStop();
        }
    }

    protected void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        b bVar = this.Q;
        ReportAudioTrack reportAudioTrack = new ReportAudioTrack(3, this.Q.f313140c, 4, 2, AudioTrack.getMinBufferSize(bVar.f313140c, bVar.f313139b, bVar.f313141d), 1);
        this.I = reportAudioTrack;
        reportAudioTrack.play();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Process.setThreadPriority(-19);
        com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
        this.H = bVar;
        try {
            try {
                try {
                    if (this.Q.f313144g == 0) {
                        this.R.f313159d = false;
                    }
                    if (this.R.f313159d) {
                        bVar.c(new VoiceChange(this.C, this.Q.f313144g, this.P));
                    }
                    if (this.R.f313157b) {
                        WechatNsWrapper wechatNsWrapper = new WechatNsWrapper(this.C);
                        if (WechatNsWrapper.J) {
                            this.H.c(wechatNsWrapper);
                        }
                    }
                    if (this.R.f313158c) {
                        if (this.Q.f313143f == 0) {
                            this.H.c(new AmrInputStreamWrapper(this.C));
                        } else {
                            this.H.c(new SilkCodecWrapper(this.C));
                        }
                    }
                    r();
                    s(this.Q.f313144g);
                    com.tencent.mobileqq.qqaudio.audioprocessor.b bVar2 = this.H;
                    b bVar3 = this.Q;
                    bVar2.b(bVar3.f313140c, bVar3.f313142e, bVar3.f313143f);
                    this.H.d(this);
                    q();
                    p();
                    o();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    a aVar = this.S;
                    if (aVar != null) {
                        aVar.onError();
                    }
                    o();
                } catch (Exception e17) {
                    a aVar2 = this.S;
                    if (aVar2 != null) {
                        aVar2.onError();
                    }
                    e17.printStackTrace();
                    o();
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
        } catch (Throwable th5) {
            try {
                o();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            throw th5;
        }
    }

    protected void s(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        File file = new File(((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(this.Q.f313138a, i3));
        file.createNewFile();
        this.F = new FileOutputStream(file);
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.G) {
            ((IVoiceTuneUtil) QRoute.api(IVoiceTuneUtil.class)).deleteAllFilesOnExit(this.Q.f313138a, this.D);
        }
        this.S = null;
        this.G = false;
        this.J = true;
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.G);
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.R.f313156a = false;
        this.S = null;
        if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.G);
        }
    }
}
