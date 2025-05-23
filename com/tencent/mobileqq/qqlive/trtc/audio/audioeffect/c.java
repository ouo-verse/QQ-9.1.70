package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.RTCMusicAccompanyParam;
import com.tencent.mobileqq.qqlive.trtc.utils.thread.RTCThreadAnnotations;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;

/* compiled from: P */
/* loaded from: classes17.dex */
class c implements com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final TRTCCloud f273223a;

    /* renamed from: b, reason: collision with root package name */
    private long f273224b;

    /* renamed from: c, reason: collision with root package name */
    private long f273225c;

    /* renamed from: d, reason: collision with root package name */
    private int f273226d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f273227e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a f273228f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f273229g;

    /* renamed from: h, reason: collision with root package name */
    private int f273230h;

    /* renamed from: i, reason: collision with root package name */
    private long f273231i;

    /* renamed from: j, reason: collision with root package name */
    private final a f273232j;

    /* renamed from: k, reason: collision with root package name */
    private b f273233k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends Handler {
        static IPatchRedirector $redirector_;

        public a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1) {
                c.this.f();
                return;
            }
            QLog.w("RTCInnerMusicAccompany", 1, "message:" + message.what + ", was not processed");
        }
    }

    public c(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f273224b = -1L;
        this.f273225c = -1L;
        this.f273228f = new com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.e();
        this.f273229g = false;
        this.f273230h = 1000;
        this.f273231i = 0L;
        this.f273223a = cVar.f273306a;
        this.f273232j = new a(ThreadManagerV2.getQQCommonThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f273229g) {
            QLog.i("RTCInnerMusicAccompany", 1, "doSendData, was paused, pause send data");
            return;
        }
        TRTCCloudDef.TRTCAudioFrame h16 = h();
        if (h16 == null) {
            this.f273232j.removeMessages(1);
            return;
        }
        long length = (((h16.data.length * 1000) / h16.channel) / 2) / h16.sampleRate;
        long j3 = length / 2;
        if (this.f273223a.mixExternalAudioFrame(h16) <= 200) {
            length = j3;
        }
        this.f273232j.sendEmptyMessageDelayed(1, length);
        o(this.f273228f.a());
    }

    @Nullable
    private TRTCCloudDef.TRTCAudioFrame h() {
        int i3;
        int i16 = 0;
        if (this.f273228f.c() != null) {
            i3 = this.f273228f.f();
        } else {
            i3 = 0;
        }
        if (this.f273228f.d() != null) {
            i16 = this.f273228f.g();
        }
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i16];
        int h16 = this.f273228f.h(bArr, bArr2, i3, i16);
        if (h16 != i3 && h16 != i16) {
            if (this.f273227e) {
                this.f273228f.seekTo(0L);
                int h17 = this.f273228f.h(bArr, bArr2, i3, i16);
                if (h17 != i3 && h17 != i16) {
                    QLog.e("RTCInnerMusicAccompany", 1, "try to loop but failed");
                    k(2102);
                    return null;
                }
            } else {
                QLog.i("RTCInnerMusicAccompany", 1, "reach file end");
                j();
                return null;
            }
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.timestamp = 0L;
        if (this.f273226d == 2) {
            tRTCAudioFrame.channel = this.f273228f.d().a();
            tRTCAudioFrame.sampleRate = (int) this.f273228f.d().c();
            tRTCAudioFrame.data = bArr2;
        } else {
            tRTCAudioFrame.channel = this.f273228f.c().a();
            tRTCAudioFrame.sampleRate = (int) this.f273228f.c().c();
            tRTCAudioFrame.data = bArr;
        }
        return tRTCAudioFrame;
    }

    private void j() {
        QLog.i("RTCInnerMusicAccompany", 1, "notifyComplete");
        b bVar = this.f273233k;
        if (bVar == null) {
            QLog.w("RTCInnerMusicAccompany", 1, "listener is null");
        } else {
            bVar.onComplete();
        }
    }

    private void k(int i3) {
        QLog.i("RTCInnerMusicAccompany", 1, "notifyError:" + i3);
        b bVar = this.f273233k;
        if (bVar == null) {
            QLog.w("RTCInnerMusicAccompany", 1, "listener is null");
        } else {
            bVar.onError(i3);
        }
    }

    private void l(long j3) {
        b bVar = this.f273233k;
        if (bVar == null) {
            QLog.w("RTCInnerMusicAccompany", 1, "listener is null");
        } else {
            bVar.onProgressUpdate(j3);
        }
    }

    private void m() {
        QLog.i("RTCInnerMusicAccompany", 1, "notifyStart");
        b bVar = this.f273233k;
        if (bVar == null) {
            QLog.w("RTCInnerMusicAccompany", 1, "listener is null");
        } else {
            bVar.onStart();
        }
    }

    private void n() {
        QLog.i("RTCInnerMusicAccompany", 1, "notifyStopped");
        b bVar = this.f273233k;
        if (bVar == null) {
            QLog.w("RTCInnerMusicAccompany", 1, "listener is null");
        } else {
            bVar.onStopped();
        }
    }

    private void o(long j3) {
        this.f273224b = j3;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f273231i >= this.f273230h) {
            l(this.f273224b);
            this.f273231i = currentTimeMillis;
        }
    }

    private void p(RTCMusicAccompanyParam rTCMusicAccompanyParam) {
        int progressIntervalSec = (int) (rTCMusicAccompanyParam.getProgressIntervalSec() * 1000.0f);
        this.f273230h = progressIntervalSec;
        if (progressIntervalSec < 100) {
            this.f273230h = 100;
        } else if (progressIntervalSec > 10000) {
            this.f273230h = 10000;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void a(@NonNull RTCMusicAccompanyParam rTCMusicAccompanyParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rTCMusicAccompanyParam);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "startAsync");
        this.f273229g = false;
        com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a aVar = this.f273228f;
        if (aVar != null) {
            aVar.release();
        }
        this.f273228f = new com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.e();
        p(rTCMusicAccompanyParam);
        this.f273226d = 1;
        if (TextUtils.isEmpty(rTCMusicAccompanyParam.getOriginFilePath())) {
            this.f273226d = 2;
        }
        int b16 = this.f273228f.b(rTCMusicAccompanyParam.getOriginFilePath(), rTCMusicAccompanyParam.getDubFilePath());
        if (b16 == 0) {
            this.f273225c = this.f273228f.getDurationMs();
            m();
            f();
        } else {
            this.f273228f.release();
            k(b16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f273233k = bVar;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "resumeAsync");
        this.f273229g = false;
        f();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "pauseAsync");
        this.f273229g = true;
        this.f273232j.removeMessages(1);
    }

    public Looper g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Looper) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ThreadManagerV2.getQQCommonThreadLooper();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    public long getCurrentPositionMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.f273224b;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    public long getDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.f273225c;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RTCInnerMusicAccompany";
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void setLoopback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "setLoopback:" + z16);
        this.f273227e = z16;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void stopAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "stopAsync");
        this.f273229g = true;
        this.f273228f.release();
        this.f273232j.removeMessages(1);
        n();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a
    @RTCThreadAnnotations.ThreadSwitch
    public void switchAccompanyType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        QLog.i("RTCInnerMusicAccompany", 1, "switchAccompanyType:" + i3);
        this.f273226d = i3;
    }
}
