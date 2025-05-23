package com.tencent.mobileqq.qqlive.trtc.audio;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trtc.TRTCCloud;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f273276a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f273277b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f273278c;

    /* renamed from: d, reason: collision with root package name */
    private TRTCCloud f273279d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273276a = new AtomicBoolean(false);
        this.f273277b = new AtomicBoolean(false);
        this.f273278c = new AtomicBoolean(false);
    }

    private int h(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 3;
            if (i3 != 3) {
                return 2;
            }
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void a(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) handler);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void b() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TRTCCloud tRTCCloud = this.f273279d;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(true);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public boolean c(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        if (!this.f273278c.compareAndSet(false, true)) {
            return false;
        }
        this.f273279d = cVar.f273306a;
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f273279d != null && this.f273276a.compareAndSet(true, false)) {
            this.f273279d.stopLocalAudio();
            this.f273279d.stopSystemAudioLoopback();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f273278c.compareAndSet(true, false)) {
            TRTCCloud tRTCCloud = this.f273279d;
            if (tRTCCloud != null) {
                tRTCCloud.stopLocalAudio();
                this.f273279d.setAudioFrameListener(null);
                this.f273279d = null;
            }
            this.f273276a.set(false);
            this.f273277b.set(false);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void e(boolean z16) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        TRTCCloud tRTCCloud = this.f273279d;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(z16);
            this.f273277b.set(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void enableAudioVolumeEvaluation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        TRTCCloud tRTCCloud = this.f273279d;
        if (tRTCCloud != null) {
            tRTCCloud.enableAudioVolumeEvaluation(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.a
    public void f() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TRTCCloud tRTCCloud = this.f273279d;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(false);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void g(int i3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (this.f273279d != null && this.f273276a.compareAndSet(false, true)) {
            this.f273279d.startLocalAudio(h(i3));
            this.f273279d.startSystemAudioLoopback();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public boolean isMicEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f273276a.get();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public boolean isMicMuteEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f273277b.get();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.b
    public void setAudioCaptureVolume(int i3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        TRTCCloud tRTCCloud = this.f273279d;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioCaptureVolume(i3);
        }
    }
}
