package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.RTCMusicAccompanyParam;
import com.tencent.mobileqq.qqlive.trtc.utils.lock.RTCReadWriteLock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i implements IRTCMusicAccompany, ui2.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f273263a;

    /* renamed from: b, reason: collision with root package name */
    public TRTCCloud f273264b;

    /* renamed from: c, reason: collision with root package name */
    private final RTCMusicAccompanyState f273265c;

    /* renamed from: d, reason: collision with root package name */
    private IRTCMusicAccompanyListener f273266d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a f273267e;

    /* renamed from: f, reason: collision with root package name */
    private b f273268f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f273269g;

    /* renamed from: h, reason: collision with root package name */
    private int f273270h;

    /* renamed from: i, reason: collision with root package name */
    private int f273271i;

    /* renamed from: j, reason: collision with root package name */
    private RTCMusicAccompanyParam f273272j;

    /* renamed from: k, reason: collision with root package name */
    private RTCReadWriteLock f273273k;

    /* renamed from: l, reason: collision with root package name */
    private Handler f273274l;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private class a implements b {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        private void e() {
            QLog.i("RTCMusicAccompany", 1, "notifyComplete");
            final IRTCMusicAccompanyListener iRTCMusicAccompanyListener = i.this.f273266d;
            if (iRTCMusicAccompanyListener == null) {
                QLog.w("RTCMusicAccompany", 1, "listener is null");
            } else {
                com.tencent.mobileqq.qqlive.trtc.utils.c.a(i.this.f273274l, new Runnable() { // from class: com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        IRTCMusicAccompanyListener.this.onComplete();
                    }
                });
            }
        }

        private void f(final int i3) {
            QLog.i("RTCMusicAccompany", 1, "notifyError:" + i3);
            final IRTCMusicAccompanyListener iRTCMusicAccompanyListener = i.this.f273266d;
            if (iRTCMusicAccompanyListener == null) {
                QLog.w("RTCMusicAccompany", 1, "listener is null");
            } else {
                com.tencent.mobileqq.qqlive.trtc.utils.c.a(i.this.f273274l, new Runnable() { // from class: com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        IRTCMusicAccompanyListener.this.onError(i3);
                    }
                });
            }
        }

        private void g(final long j3) {
            final IRTCMusicAccompanyListener iRTCMusicAccompanyListener = i.this.f273266d;
            if (iRTCMusicAccompanyListener == null) {
                QLog.w("RTCMusicAccompany", 1, "listener is null");
            } else {
                com.tencent.mobileqq.qqlive.trtc.utils.c.a(i.this.f273274l, new Runnable() { // from class: com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        IRTCMusicAccompanyListener.this.onProgressUpdate(j3);
                    }
                });
            }
        }

        private void h() {
            QLog.i("RTCMusicAccompany", 1, "notifyStart");
            final IRTCMusicAccompanyListener iRTCMusicAccompanyListener = i.this.f273266d;
            if (iRTCMusicAccompanyListener == null) {
                QLog.w("RTCMusicAccompany", 1, "listener is null");
            } else {
                com.tencent.mobileqq.qqlive.trtc.utils.c.a(i.this.f273274l, new Runnable() { // from class: com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        IRTCMusicAccompanyListener.this.onStart();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.b
        public void onComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.i("RTCMusicAccompany", 1, "Callback: onComplete:, isInited:" + i.this.f273263a + ", state:" + i.this.f273265c);
            synchronized (i.this) {
                if (i.this.k(102)) {
                    QLog.w("RTCMusicAccompany", 1, "Callback: onComplete, invalid state:" + i.this.f273265c);
                    return;
                }
                i.this.f273265c.a(9);
                e();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.b
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            QLog.i("RTCMusicAccompany", 1, "Callback: onError:" + i3 + ", isInited:" + i.this.f273263a + ", state:" + i.this.f273265c);
            synchronized (i.this) {
                if (i.this.k(104)) {
                    QLog.w("RTCMusicAccompany", 1, "Callback: onError, invalid state:" + i.this.f273265c);
                    return;
                }
                i.this.f273265c.a(12);
                f(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.b
        public void onProgressUpdate(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else {
                g(j3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.b
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("RTCMusicAccompany", 1, "Callback: onStart :  isInited:" + i.this.f273263a + ", state:" + i.this.f273265c);
            synchronized (i.this) {
                if (i.this.k(101)) {
                    QLog.w("RTCMusicAccompany", 1, "Callback: onStart, invalid state:" + i.this.f273265c);
                    return;
                }
                i.this.f273265c.a(6);
                h();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.b
        public void onStopped() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("RTCMusicAccompany", 1, "Callback: onStopped: isInited:" + i.this.f273263a + ", state:" + i.this.f273265c);
            synchronized (i.this) {
                i.this.f273265c.a(11);
                i.this.f273273k.writeLockCondSignalAll();
            }
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273263a = false;
        this.f273265c = new RTCMusicAccompanyState();
        this.f273266d = null;
        this.f273269g = false;
        this.f273270h = 100;
        this.f273271i = 100;
        this.f273272j = null;
        this.f273273k = new RTCReadWriteLock();
    }

    private boolean j(int i3) {
        return !RTCMusicAccompanyStateStrategy.validStateCall(i3, this.f273265c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(int i3) {
        if (!RTCMusicAccompanyStateStrategy.validStateCallback(i3, this.f273265c)) {
            return true;
        }
        return false;
    }

    private void l() throws IllegalStateException {
        if (this.f273263a) {
        } else {
            throw new IllegalStateException("audio source is not set to audio source ctrl");
        }
    }

    @Override // ui2.a
    public void a(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) handler);
        } else {
            this.f273274l = handler;
        }
    }

    @Override // ui2.b
    public synchronized boolean b(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        QLog.i("RTCMusicAccompany", 1, "initEffect: " + cVar + ",isInited: " + this.f273263a);
        if (this.f273263a) {
            QLog.i("RTCMusicAccompany", 1, "initEffect: effect already inited!");
            return true;
        }
        TRTCCloud tRTCCloud = cVar.f273306a;
        if (tRTCCloud == null) {
            QLog.e("RTCMusicAccompany", 1, "initEffect: trtcCloud is null!");
            return false;
        }
        this.f273264b = tRTCCloud;
        this.f273267e = d.c(cVar);
        a aVar = new a();
        this.f273268f = aVar;
        this.f273267e.b(aVar);
        this.f273264b.setMixExternalAudioVolume(this.f273271i, this.f273270h);
        this.f273264b.enableMixExternalAudioFrame(this.f273269g, true);
        this.f273265c.a(1);
        this.f273263a = true;
        return true;
    }

    @Override // ui2.a
    public synchronized void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "resetEffect: isInited " + this.f273263a + ",state " + this.f273265c);
        if (!this.f273263a) {
            QLog.w("RTCMusicAccompany", 1, "resetEffect, source is not inited!");
            return;
        }
        if (j(9)) {
            this.f273267e.stopAsync();
            this.f273273k.writeLockCondWait(200L);
        }
        this.f273264b.enableMixExternalAudioFrame(false, false);
        this.f273265c.a(1);
        this.f273264b = null;
        this.f273263a = false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void enableMixPublish(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "enableMixPublish: " + z16 + ", isInited:" + this.f273263a + ", state:" + this.f273265c);
        this.f273269g = z16;
        if (!this.f273263a) {
            QLog.w("RTCMusicAccompany", 1, "enableMixPublish: not inited");
        } else {
            this.f273264b.enableMixExternalAudioFrame(z16, true);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized long getCurrentPositionMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        if (!this.f273263a) {
            return -1L;
        }
        if (j(23)) {
            return -1L;
        }
        return this.f273267e.getCurrentPositionMs();
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized long getDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        if (!this.f273263a) {
            return -1L;
        }
        if (j(21)) {
            return -1L;
        }
        return this.f273267e.getDurationMs();
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void pause() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "pause:  isInited: " + this.f273263a + ", state:" + this.f273265c);
        l();
        if (j(8)) {
            QLog.e("RTCMusicAccompany", 1, "pause: error state");
        } else {
            this.f273265c.a(7);
            this.f273267e.d();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void resume() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "resume:  isInited:" + this.f273263a + ", state:" + this.f273265c);
        l();
        if (j(6)) {
            QLog.w("RTCMusicAccompany", 1, "resume, error state");
        } else {
            this.f273265c.a(6);
            this.f273267e.c();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void setListener(IRTCMusicAccompanyListener iRTCMusicAccompanyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) iRTCMusicAccompanyListener);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "setListener: " + iRTCMusicAccompanyListener + ", isInited: " + this.f273263a);
        this.f273266d = iRTCMusicAccompanyListener;
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void setLocalVolume(int i3) {
        TRTCCloud tRTCCloud;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "setLocalVolume: " + i3 + ", mIsInited:" + this.f273263a + ", state:" + this.f273265c);
        this.f273270h = i3;
        if (this.f273263a && (tRTCCloud = this.f273264b) != null) {
            tRTCCloud.setMixExternalAudioVolume(-1, i3);
            return;
        }
        QLog.w("RTCMusicAccompany", 1, "setLocalVolume: not inited or mTrtcCloud == null.");
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void setLoopback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "setLoopback: " + z16 + ", isInited:" + this.f273263a + ", state:" + this.f273265c);
        if (!this.f273263a) {
            QLog.w("RTCMusicAccompany", 1, "not inited, return");
        } else if (j(16)) {
            QLog.w("RTCMusicAccompany", 1, "setLoopback, error state");
        } else {
            this.f273267e.setLoopback(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void setPublishVolume(int i3) {
        TRTCCloud tRTCCloud;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "setPublishVolume: " + i3 + ", isInited:" + this.f273263a + ", state:" + this.f273265c);
        this.f273271i = i3;
        if (this.f273263a && (tRTCCloud = this.f273264b) != null) {
            tRTCCloud.setMixExternalAudioVolume(i3, -1);
            return;
        }
        QLog.w("RTCMusicAccompany", 1, "setPublishVolume: not inited or mTrtcCloud == null.");
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void start(@NonNull RTCMusicAccompanyParam rTCMusicAccompanyParam) throws IllegalArgumentException, IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) rTCMusicAccompanyParam);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "start: " + rTCMusicAccompanyParam.toString() + ", isInited:" + this.f273263a + ",state:" + this.f273265c);
        l();
        if (TextUtils.isEmpty(rTCMusicAccompanyParam.getDubFilePath()) && TextUtils.isEmpty(rTCMusicAccompanyParam.getOriginFilePath())) {
            QLog.e("RTCMusicAccompany", 1, "start: DubFilePath and OriginFilePath is null!");
            throw new IllegalArgumentException("start:DubFilePath and OriginFilePath is null!");
        }
        if (j(7)) {
            QLog.e("RTCMusicAccompany", 1, "start: error state");
            return;
        }
        this.f273272j = rTCMusicAccompanyParam;
        this.f273265c.a(5);
        this.f273267e.a(rTCMusicAccompanyParam);
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "stop: , isInited: " + this.f273263a + ",state: " + this.f273265c);
        if (!this.f273263a) {
            QLog.e("RTCMusicAccompany", 1, "stop: not inited, return!");
        } else {
            if (j(9)) {
                QLog.e("RTCMusicAccompany", 1, "stop: error state");
                return;
            }
            this.f273265c.a(10);
            this.f273267e.stopAsync();
            this.f273273k.writeLockCondWait(200L);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany
    public synchronized void switchAccompanyType(int i3) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        QLog.i("RTCMusicAccompany", 1, "switchAccompanyType: " + i3 + ", isInited:" + this.f273263a + ", state:" + this.f273265c);
        l();
        if (j(15)) {
            QLog.w("RTCMusicAccompany", 1, "switchAccompanyType: error state");
            return;
        }
        if (i3 == 2 && TextUtils.isEmpty(this.f273272j.getDubFilePath())) {
            QLog.w("RTCMusicAccompany", 1, "switchAccompanyType: no dub file");
        } else if (i3 == 1 && TextUtils.isEmpty(this.f273272j.getOriginFilePath())) {
            QLog.w("RTCMusicAccompany", 1, "switchAccompanyType: no origin file");
        } else {
            this.f273267e.switchAccompanyType(i3);
        }
    }
}
