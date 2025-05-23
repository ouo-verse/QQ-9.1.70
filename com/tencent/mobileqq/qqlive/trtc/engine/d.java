package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements com.tencent.mobileqq.qqlive.trtc.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final c f273309a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f273310b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.room.b f273311c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f273312d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.video.source.a f273313e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.audio.a f273314f;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements SoLoad.LoadCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TRTCInitCallback f273315a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f273316b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f273317c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqlive.trtc.engine.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public class C8400a implements TRTCInitCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f273319a;

            C8400a(int i3) {
                this.f273319a = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
            public void onInitEvent(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                QLog.i("TRTCFakeEngineImpl", 1, "TRTCServerIPCModule TRTCInitCallback, engine state " + i3 + ", code " + i16);
                d.this.f273312d = i3;
                if (i3 == 2) {
                    d.this.q();
                }
                a aVar = a.this;
                TRTCInitCallback tRTCInitCallback = aVar.f273315a;
                if (tRTCInitCallback != null) {
                    tRTCInitCallback.onInitEvent(d.this.f273312d, this.f273319a);
                }
            }
        }

        a(TRTCInitCallback tRTCInitCallback, Context context, String str) {
            this.f273315a = tRTCInitCallback;
            this.f273316b = context;
            this.f273317c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, tRTCInitCallback, context, str);
            }
        }

        private void a(int i3, String str) {
            QLog.i("TRTCFakeEngineImpl", 1, "downloaded trtc so: " + str);
            TRTCServerIPCModule.h().initEngine(this.f273316b, this.f273317c, new C8400a(i3));
        }

        @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
        public void onLoad(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            QLog.i("TRTCFakeEngineImpl", 1, "initEngine onLoadResult isSuccess:" + z16);
            if (z16) {
                a(0, str2);
                return;
            }
            TRTCInitCallback tRTCInitCallback = this.f273315a;
            if (tRTCInitCallback != null) {
                tRTCInitCallback.onInitEvent(d.this.f273312d, -1);
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273309a = new c();
        this.f273310b = new Handler(Looper.getMainLooper());
        this.f273312d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f273311c == null) {
            this.f273311c = new com.tencent.mobileqq.qqlive.trtc.room.b();
        }
        if (this.f273314f == null) {
            c(new com.tencent.mobileqq.qqlive.trtc.audio.d());
        }
        if (this.f273313e == null) {
            l(new com.tencent.mobileqq.qqlive.trtc.video.source.screen.e());
        }
    }

    private boolean r() {
        QLog.d("TRTCFakeEngineImpl", 1, "isEngineInitSuccess engine state " + this.f273312d);
        if (this.f273312d == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.e("TRTCFakeEngineImpl", 1, "resetEngine and stop service!");
        TRTCServerIPCModule.g("Action_Client_Destroy_SDK", null, null);
        com.tencent.mobileqq.qqlive.trtc.audio.a aVar = this.f273314f;
        if (aVar != null) {
            aVar.destroy();
            this.f273314f = null;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar2 = this.f273313e;
        if (aVar2 != null) {
            aVar2.destroy();
            this.f273313e = null;
        }
        com.tencent.mobileqq.qqlive.trtc.ipc.c.h().d();
        com.tencent.mobileqq.qqlive.trtc.room.b bVar = this.f273311c;
        if (bVar != null) {
            bVar.destroy();
            this.f273311c = null;
        }
        this.f273312d = 0;
        this.f273309a.a();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public com.tencent.mobileqq.qqlive.trtc.render.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.qqlive.trtc.render.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void c(@Nullable com.tencent.mobileqq.qqlive.trtc.audio.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCFakeEngineImpl", 2, "setAudioSource: " + aVar);
        }
        com.tencent.mobileqq.qqlive.trtc.audio.a aVar2 = this.f273314f;
        if (aVar == aVar2) {
            QLog.w("TRTCFakeEngineImpl", 1, "setAudioSource: ignore. set the same audio source.");
            return;
        }
        if (aVar2 != null) {
            aVar2.destroy();
        }
        this.f273314f = aVar;
        if (aVar != null) {
            aVar.c(this.f273309a);
            this.f273314f.a(this.f273310b);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void closeMixTranscoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "closeMixTranscoding, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void connectRemote(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "connectRemote, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f273309a;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "disconnectRemote, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void e(String str, TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, (Object) tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void enableCustomVideoCapture(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void f(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "setRemoteListener, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T g(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cls);
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCFakeEngineImpl", 2, "create TRTC video source, class name:" + cls.getSimpleName());
        }
        if (cls.equals(com.tencent.mobileqq.qqlive.trtc.video.source.screen.c.class)) {
            return new com.tencent.mobileqq.qqlive.trtc.video.source.screen.e();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public int getAudioPlayOutVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        QLog.e("TRTCFakeEngineImpl", 1, "getAudioPlayOutVolume, ignore");
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public int getEngineState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.f273312d;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void h(com.tencent.mobileqq.qqlive.trtc.video.source.screen.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) dVar);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "setStatisticDataListener, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T i(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls);
        }
        if (r()) {
            if (cls.isInstance(this.f273314f)) {
                return (T) this.f273314f;
            }
            throw new IllegalArgumentException("no audio source of the specified type");
        }
        throw new IllegalStateException("getCurrentAudioSource: not init.");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void initEngine(@NonNull Context context, @NonNull String str, TRTCInitCallback tRTCInitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, tRTCInitCallback);
            return;
        }
        this.f273309a.f273307b = new WeakReference<>(context.getApplicationContext());
        this.f273309a.f273308c = str;
        if (this.f273312d == 2) {
            if (tRTCInitCallback != null) {
                tRTCInitCallback.onInitEvent(this.f273312d, 0);
            }
        } else {
            this.f273312d = 1;
            SoLoad.load("QQ\u76f4\u64ad", SoLoadConstants.SONAME_TRTC, new a(tRTCInitCallback, context, str));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T j(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        if (r()) {
            com.tencent.mobileqq.qqlive.trtc.video.source.a aVar = this.f273313e;
            if (aVar != null) {
                if (cls.isInstance(aVar)) {
                    return (T) this.f273313e;
                }
                throw new IllegalArgumentException("getCurrentVideoSource: cls type different.");
            }
            QLog.w("TRTCFakeEngineImpl", 1, "getCurrentVideoSource: video source not set.");
            throw new IllegalStateException("getCurrentVideoSource: video source not set.");
        }
        throw new IllegalStateException("getCurrentVideoSource: not init.");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public <T extends com.tencent.mobileqq.qqlive.trtc.audio.a> T k(@NonNull Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cls);
        }
        QLog.i("TRTCFakeEngineImpl", 2, "create TRTC audio source, class name:" + cls.getSimpleName());
        if (cls.equals(com.tencent.mobileqq.qqlive.trtc.audio.b.class)) {
            QLog.i("TRTCFakeEngineImpl", 2, "create music accompany effect.");
            return new com.tencent.mobileqq.qqlive.trtc.audio.d();
        }
        QLog.e("TRTCFakeEngineImpl", 1, "not support effect type.");
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.source.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCFakeEngineImpl", 2, "setVideoSource: " + aVar);
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar2 = this.f273313e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.destroy();
        }
        this.f273313e = aVar;
        if (aVar != null) {
            aVar.c(this.f273309a);
            this.f273313e.a(this.f273310b);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public com.tencent.mobileqq.qqlive.trtc.room.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.qqlive.trtc.room.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f273311c;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void muteAllRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "muteAllRemoteAudio, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void muteRemoteAudio(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Boolean.valueOf(z16));
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "muteRemoteAudio, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void openMixTranscoding(@NonNull @NotNull QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) qQLiveTranscodingConfig);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "openMixTranscoding, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setAudioPlayOutVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "setAudioPlayOutVolume, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setNetworkQosPreferenceParam(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setRemoteAudioVolume(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, i3);
        } else {
            QLog.e("TRTCFakeEngineImpl", 1, "setRemoteAudioVolume, ignore");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void setVideoPreProcess(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void stopRemoteView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.a
    public void switchRole(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        }
    }
}
