package com.tencent.mobileqq.qqlive.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.c;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.d;
import com.tencent.mobileqq.qqlive.utils.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile com.tencent.mobileqq.qqlive.trtc.a f273280a;

    /* renamed from: b, reason: collision with root package name */
    private List<ITRTCRoomListener> f273281b;

    /* renamed from: c, reason: collision with root package name */
    private ITRTCRoomListener f273282c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements ITRTCRoomListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEnterRoom(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onEnterRoom(j3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onEvent(int i3, int i16, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onEvent(i3, i16, str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onExitRoom(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onExitRoom(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalAudioFrameSent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onFirstLocalAudioFrameSent();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onFirstLocalVideoFrameSent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onFirstLocalVideoFrameSent(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserEnterRoom(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onRemoteUserEnterRoom(str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onRemoteUserLeaveRoom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onRemoteUserLeaveRoom(str, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
        public void onSwitchRoom(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            Iterator it = b.this.f273281b.iterator();
            while (it.hasNext()) {
                ((ITRTCRoomListener) it.next()).onSwitchRoom(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.trtc.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class C8399b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final b f273284a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61370);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f273284a = new b();
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273281b = new CopyOnWriteArrayList();
        }
    }

    private void g() {
        this.f273282c = new a();
    }

    public static b r() {
        return C8399b.f273284a;
    }

    private <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T x(@NonNull Class<T> cls) {
        T t16 = (T) this.f273280a.g(cls);
        this.f273280a.l(t16);
        return t16;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.audio.a i3 = this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class);
            if (i3 != null && (i3 instanceof com.tencent.mobileqq.qqlive.trtc.audio.b)) {
                return ((com.tencent.mobileqq.qqlive.trtc.audio.b) i3).isMicEnable();
            }
        } catch (Throwable th5) {
            QLog.e("TRTCEngineProxy", 1, th5, new Object[0]);
        }
        return false;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.audio.a i3 = this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class);
            if (i3 != null && (i3 instanceof com.tencent.mobileqq.qqlive.trtc.audio.b)) {
                return ((com.tencent.mobileqq.qqlive.trtc.audio.b) i3).isMicMuteEnable();
            }
        } catch (Throwable th5) {
            QLog.e("TRTCEngineProxy", 1, th5, new Object[0]);
        }
        return false;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return false;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 == null) {
            return false;
        }
        return q16.o();
    }

    public boolean D(RTCCameraDefine.RTCMirrorType rTCMirrorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) rTCMirrorType)).booleanValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return false;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 == null) {
            return false;
        }
        return q16.l(rTCMirrorType);
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return false;
        }
        if (this.f273280a.b() == null) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine getLocalRender null!");
            return false;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 == null) {
            return false;
        }
        return q16.n();
    }

    public void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "muteAllRemoteAudio, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.muteAllRemoteAudio(z16);
        }
    }

    public void G(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, z16);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "muteLocalVideo, trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b o16 = o(true);
        if (o16 != null) {
            o16.e(z16);
        }
    }

    public void H(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, str, Boolean.valueOf(z16));
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "muteRemoteAudio, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.muteRemoteAudio(str, z16);
        }
    }

    public void I(@NonNull QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) qQLiveTranscodingConfig);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "openMixTranscoding, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.openMixTranscoding(qQLiveTranscodingConfig);
        }
    }

    public void J(Bitmap bitmap, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        if (i3 < 5 || i3 > 20) {
            QLog.e("TRTCEngineProxy", 1, "fps except [5, 20]. but " + i3);
            i3 = 10;
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.video.source.a j3 = this.f273280a.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class);
            if (j3 != null) {
                if (bitmap != null) {
                    j3.i(bitmap, i3);
                }
                j3.b();
            }
        } catch (Throwable th5) {
            QLog.e("TRTCEngineProxy", 1, th5, new Object[0]);
        }
        if (z16) {
            try {
                com.tencent.mobileqq.qqlive.trtc.audio.a i16 = this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class);
                if (i16 != null) {
                    i16.b();
                }
            } catch (Throwable th6) {
                QLog.e("TRTCEngineProxy", 1, th6, new Object[0]);
            }
        }
    }

    public void K(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) iTRTCRoomListener);
        } else {
            this.f273281b.remove(iTRTCRoomListener);
        }
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, z16);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.video.source.a j3 = this.f273280a.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class);
            if (j3 != null) {
                j3.f();
            }
        } catch (Throwable th5) {
            QLog.e("TRTCEngineProxy", 1, th5, new Object[0]);
        }
        if (z16) {
            try {
                com.tencent.mobileqq.qqlive.trtc.audio.a i3 = this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class);
                if (i3 != null) {
                    i3.f();
                }
            } catch (Throwable th6) {
                QLog.e("TRTCEngineProxy", 1, th6, new Object[0]);
            }
        }
    }

    public boolean M(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "sendSEIMsg, engine null or not ready!");
            return false;
        }
        return this.f273280a.m().sendSEIMsg(bArr, i3);
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b o16 = o(false);
        if (o16 != null) {
            o16.setAudioCaptureVolume(i3);
        }
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, i3);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setAudioPlayOutVolume, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.setAudioPlayOutVolume(i3);
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        } else if (q(true) != null) {
            a0(r.b(this.f273280a.d().b()));
        }
    }

    public void Q(RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, rTCMirrorType, Boolean.valueOf(z16));
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 != null) {
            q16.d(rTCMirrorType, z16);
        }
    }

    public void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, z16);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 != null) {
            q16.setMirror(z16);
        }
    }

    public void S(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) aVar);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setNetworkQosPreferenceParam, engine null or not ready!");
        } else {
            this.f273280a.setNetworkQosPreferenceParam(aVar);
        }
    }

    public void T(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) viewGroup);
            return;
        }
        if (viewGroup != null && z()) {
            if (this.f273280a.b() == null) {
                QLog.e("TRTCEngineProxy", 1, "don't support setPreviewViewGroup, fail!");
                return;
            } else {
                this.f273280a.b().a(new WeakReference<>(viewGroup));
                return;
            }
        }
        QLog.e("TRTCEngineProxy", 1, "setPreviewViewGroup failed!");
    }

    public void U(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) str, i3);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setRemoteAudioVolume, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.setRemoteAudioVolume(str, i3);
        }
    }

    public void V(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) str, (Object) qQLiveRenderParams);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setRemoteVideoParam, engine null or not ready! userId:" + str + " params:" + qQLiveRenderParams);
            return;
        }
        this.f273280a.m().setRemoteVideoParam(str, qQLiveRenderParams);
    }

    public void W(com.tencent.mobileqq.qqlive.trtc.video.source.screen.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) aVar);
            return;
        }
        c t16 = t(true);
        if (t16 != null) {
            t16.g(aVar);
        }
    }

    public void X(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) dVar);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        } else {
            this.f273280a.h(dVar);
        }
    }

    public void Y(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) iTRTCRemoteListener);
        } else if (this.f273280a != null) {
            this.f273280a.f(iTRTCRemoteListener);
        }
    }

    public void Z(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) aVar);
        } else if (this.f273280a != null) {
            this.f273280a.setVideoPreProcess(aVar);
        }
    }

    public void a0(@NonNull TRTCVideoQualityParams tRTCVideoQualityParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) tRTCVideoQualityParams);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.a j3 = this.f273280a.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class);
        if (j3 != null) {
            j3.setVideoQuality(tRTCVideoQualityParams);
        }
    }

    public void b(@NonNull ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) iTRTCRoomListener);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        if (iTRTCRoomListener == null) {
            QLog.e("TRTCEngineProxy", 1, "addRoomListener,listener can't be null\uff0cif you want to clear room listener,use clearRoomListener instead");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.room.a m3 = this.f273280a.m();
        if (m3 == null) {
            QLog.w("TRTCEngineProxy", 1, "roomCtrl null !");
            return;
        }
        if (this.f273282c == null) {
            QLog.i("TRTCEngineProxy", 1, "set init RoomListener");
            g();
            m3.b(this.f273282c);
        }
        if (!this.f273281b.contains(iTRTCRoomListener)) {
            this.f273281b.add(iTRTCRoomListener);
        }
    }

    @Deprecated
    public void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            c0(2);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.room.a m3 = this.f273280a.m();
        if (m3 == null) {
            return;
        }
        this.f273281b.clear();
        m3.b(null);
        this.f273282c = null;
    }

    public void c0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b o16 = o(true);
        if (o16 != null) {
            o16.g(i3);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "closeMixTranscoding, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.closeMixTranscoding();
        }
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        if (this.f273280a.b() == null) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine getLocalRender null!");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(true);
        if (q16 != null) {
            P();
            q16.p(this.f273280a.b());
        }
    }

    public void e(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, Long.valueOf(j3), Long.valueOf(j16));
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "connectRemote, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.connectRemote(j3, j16);
        }
    }

    public void e0(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str, (Object) viewGroup);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setRemoteView, engine null or not ready! userId:" + str + " viewGroup:" + viewGroup);
            return;
        }
        this.f273280a.m().startRemoteVideo(str, viewGroup);
    }

    public IRTCMusicAccompany f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "[createMusicAccompany] trtcEngine null or not ready !");
            return null;
        }
        return this.f273280a.createMusicAccompany();
    }

    public void f0(String str, TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str, (Object) tXCloudVideoView);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "startRemoteView, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.e(str, tXCloudVideoView);
        }
    }

    public void g0(TRTCVideoQualityParams tRTCVideoQualityParams, QQLiveScreenCaptureParams qQLiveScreenCaptureParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) tRTCVideoQualityParams, (Object) qQLiveScreenCaptureParams);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        c t16 = t(true);
        if (t16 != null) {
            if (tRTCVideoQualityParams == null) {
                tRTCVideoQualityParams = r.c(this.f273280a.d().b());
            }
            t16.e(tRTCVideoQualityParams, qQLiveScreenCaptureParams);
        }
    }

    public synchronized void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        } else {
            this.f273280a.a();
            this.f273280a = null;
        }
    }

    public void h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "stopAllRemoteVideo, engine null or not ready!");
        } else {
            this.f273280a.m().stopAllRemoteVideo();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "disconnectRemote, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.disconnectRemote();
        }
    }

    public void i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b o16 = o(false);
        if (o16 != null) {
            o16.d();
        }
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b o16 = o(true);
        if (o16 != null) {
            o16.enableAudioVolumeEvaluation(i3);
        }
    }

    public void j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 != null) {
            q16.stopCapture();
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "enableCustomVideoCapture, engine null or not ready!");
        } else {
            this.f273280a.enableCustomVideoCapture(z16);
        }
    }

    public void k0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "setRemoteVideoParam, engine null or not ready! userId:" + str);
            return;
        }
        this.f273280a.m().stopRemoteVideo(str);
    }

    public void l(QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qQLiveRoomParams);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        } else {
            this.f273280a.m().enterRoom(qQLiveRoomParams);
        }
    }

    public void l0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) str);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "stopRemoteView, trtcEngine null or not ready !");
        } else if (this.f273280a != null) {
            this.f273280a.stopRemoteView(str);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        } else {
            this.f273280a.m().exitRoom();
        }
    }

    public void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return;
        }
        c t16 = t(false);
        if (t16 != null) {
            t16.stopScreenCapture();
        }
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this)).intValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "getAudioPlayOutVolume, trtcEngine null or not ready !");
            return 0;
        }
        if (this.f273280a == null) {
            return 0;
        }
        return this.f273280a.getAudioPlayOutVolume();
    }

    public boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return false;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 == null) {
            return false;
        }
        q16.switchCamera();
        return true;
    }

    public com.tencent.mobileqq.qqlive.trtc.audio.b o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.qqlive.trtc.audio.b) iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b bVar = null;
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return null;
        }
        try {
            bVar = (com.tencent.mobileqq.qqlive.trtc.audio.b) this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, e16.toString());
        }
        if (bVar == null) {
            if (z16) {
                com.tencent.mobileqq.qqlive.trtc.audio.b bVar2 = (com.tencent.mobileqq.qqlive.trtc.audio.b) this.f273280a.k(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
                this.f273280a.c(bVar2);
                return bVar2;
            }
            QLog.e("TRTCEngineProxy", 1, "failed to get audio source! isNeedCreate is false!");
            return bVar;
        }
        return bVar;
    }

    public void o0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, i3);
        } else if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "switchRole, trtcEngine null or not ready !");
        } else {
            this.f273280a.switchRole(i3);
        }
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return 1;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q16 = q(false);
        if (q16 == null) {
            return 1;
        }
        return q16.getCameraId();
    }

    public com.tencent.mobileqq.qqlive.trtc.video.source.camera.a q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a aVar = null;
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return null;
        }
        try {
            aVar = (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) this.f273280a.j(com.tencent.mobileqq.qqlive.trtc.video.source.camera.a.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, "getCameraSource error!", e16);
        }
        if (aVar == null) {
            if (z16) {
                return (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) x(com.tencent.mobileqq.qqlive.trtc.video.source.camera.a.class);
            }
            QLog.e("TRTCEngineProxy", 1, "error! cameraCaptureSource not exit!");
            return aVar;
        }
        return aVar;
    }

    public com.tencent.mobileqq.qqlive.trtc.room.a s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (com.tencent.mobileqq.qqlive.trtc.room.a) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return null;
        }
        return this.f273280a.m();
    }

    public c t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (c) iPatchRedirector.redirect((short) 27, (Object) this, z16);
        }
        c cVar = null;
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return null;
        }
        try {
            cVar = (c) this.f273280a.j(c.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, "getScreenCaptureSource error!", e16);
        }
        if (cVar == null) {
            if (z16) {
                return (c) x(c.class);
            }
            QLog.e("TRTCEngineProxy", 1, "screenCaptureSource is null!, isNeedCreate is false!");
            return cVar;
        }
        return cVar;
    }

    public TRTCVideoQualityParams u() {
        com.tencent.mobileqq.qqlive.trtc.video.source.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        if (!z()) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
            return null;
        }
        try {
            aVar = this.f273280a.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, "getVideoQuality error!", e16);
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.getVideoQuality();
    }

    public void v() {
        com.tencent.mobileqq.qqlive.trtc.audio.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (this.f273280a == null) {
            QLog.e("TRTCEngineProxy", 1, "trtcEngine is null!!");
            return;
        }
        try {
            bVar = (com.tencent.mobileqq.qqlive.trtc.audio.b) this.f273280a.i(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, e16.toString());
            bVar = null;
        }
        if (bVar == null) {
            this.f273280a.c((com.tencent.mobileqq.qqlive.trtc.audio.b) this.f273280a.k(com.tencent.mobileqq.qqlive.trtc.audio.b.class));
        }
    }

    public synchronized void w(Context context, String str, TRTCInitCallback tRTCInitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, tRTCInitCallback);
            return;
        }
        if (z()) {
            QLog.e("TRTCEngineProxy", 1, "already init engine!");
            if (tRTCInitCallback != null) {
                tRTCInitCallback.onInitEvent(2, 0);
            }
        } else {
            if (this.f273280a == null) {
                this.f273280a = com.tencent.mobileqq.qqlive.trtc.ipc.c.h().f();
            }
            if (this.f273280a != null) {
                this.f273280a.initEngine(context, str, tRTCInitCallback);
            }
        }
    }

    public void y() {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        try {
            cVar = (c) this.f273280a.j(c.class);
        } catch (Exception e16) {
            QLog.e("TRTCEngineProxy", 1, "initScreenCaptureSource error!", e16);
            cVar = null;
        }
        if (cVar == null) {
            x(c.class);
        }
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        if (this.f273280a != null && this.f273280a.getEngineState() == 2) {
            return true;
        }
        return false;
    }
}
