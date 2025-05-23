package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes5.dex */
public class PcmPlayer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AudioTrack f99156a;

    /* renamed from: b, reason: collision with root package name */
    private int f99157b;

    /* renamed from: c, reason: collision with root package name */
    private int f99158c;

    /* renamed from: d, reason: collision with root package name */
    private int f99159d;

    /* renamed from: e, reason: collision with root package name */
    private int f99160e;

    /* renamed from: f, reason: collision with root package name */
    private String f99161f;

    /* renamed from: g, reason: collision with root package name */
    private PlayThread f99162g;

    /* renamed from: h, reason: collision with root package name */
    private Context f99163h;

    /* renamed from: i, reason: collision with root package name */
    private a f99164i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PlayThread extends BaseThread {
        static IPatchRedirector $redirector_;
        volatile boolean C;

        PlayThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PcmPlayer.this);
            } else {
                this.C = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            FileInputStream fileInputStream;
            int read;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            File file = new File(PcmPlayer.this.f99161f);
            if (QLog.isColorLevel()) {
                QLog.d("PcmPlayer", 2, "start play, " + file.length());
            }
            boolean z16 = true;
            if (file.exists()) {
                int i16 = PcmPlayer.this.f99158c;
                byte[] bArr = new byte[i16];
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    while (this.C && (read = bufferedInputStream.read(bArr, 0, i16)) > 0) {
                        PcmPlayer.this.f99156a.write(bArr, 0, read);
                    }
                    PcmPlayer.this.f99156a.stop();
                    PcmPlayer.this.f99156a.release();
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    if (PcmPlayer.this.f99164i != null) {
                        PcmPlayer.this.f99164i.u2(0);
                    }
                } catch (Exception e17) {
                    e = e17;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("PcmPlayer", 2, "", e);
                        }
                        PcmPlayer.this.f99156a.stop();
                        PcmPlayer.this.f99156a.release();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (PcmPlayer.this.f99164i != null) {
                            PcmPlayer.this.f99164i.u2(2);
                        }
                        PcmPlayer.this.f99162g = null;
                        PcmPlayer.this.f99156a = null;
                        return;
                    } catch (Throwable th6) {
                        th = th6;
                        PcmPlayer.this.f99156a.stop();
                        PcmPlayer.this.f99156a.release();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (PcmPlayer.this.f99164i != null) {
                            a aVar = PcmPlayer.this.f99164i;
                            if (!z16) {
                                i3 = 0;
                            }
                            aVar.u2(i3);
                        }
                        PcmPlayer.this.f99162g = null;
                        PcmPlayer.this.f99156a = null;
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z16 = false;
                    PcmPlayer.this.f99156a.stop();
                    PcmPlayer.this.f99156a.release();
                    if (fileInputStream != null) {
                    }
                    if (PcmPlayer.this.f99164i != null) {
                    }
                    PcmPlayer.this.f99162g = null;
                    PcmPlayer.this.f99156a = null;
                    throw th;
                }
                PcmPlayer.this.f99162g = null;
                PcmPlayer.this.f99156a = null;
                return;
            }
            if (PcmPlayer.this.f99164i != null) {
                PcmPlayer.this.f99164i.u2(1);
            }
            PcmPlayer.this.f99162g = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void onPlayStart();

        void u2(int i3);
    }

    public PcmPlayer(Context context, a aVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, Integer.valueOf(i3), str);
            return;
        }
        this.f99158c = 0;
        this.f99159d = 2;
        this.f99160e = 2;
        this.f99163h = context;
        this.f99164i = aVar;
        this.f99157b = i3;
        this.f99161f = str;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f99162g != null) {
            return;
        }
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(this.f99157b, this.f99159d, this.f99160e);
            int i3 = this.f99157b;
            int i16 = this.f99160e;
            this.f99158c = (i3 / 1000) * 20 * i16;
            ReportAudioTrack reportAudioTrack = new ReportAudioTrack(3, i3, this.f99159d, i16, minBufferSize, 1);
            this.f99156a = reportAudioTrack;
            reportAudioTrack.play();
            PlayThread playThread = new PlayThread();
            this.f99162g = playThread;
            playThread.start();
            a aVar = this.f99164i;
            if (aVar != null) {
                aVar.onPlayStart();
            }
        } catch (Exception e16) {
            QLog.e("PcmPlayer", 1, "startPlay fail.", e16);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        PlayThread playThread = this.f99162g;
        if (playThread != null) {
            playThread.C = false;
        }
    }
}
