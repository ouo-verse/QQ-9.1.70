package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveTranscodingConfig;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorHelperTRTC implements IQQLiveAnchorRemoteControl {
    static IPatchRedirector $redirector_;
    private ITRTCRemoteListener C;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.trtc.b f270850d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f270851e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f270852f;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, WeakReference<TXCloudVideoView>> f270853h;

    /* renamed from: i, reason: collision with root package name */
    private List<ITRTCRemoteListener> f270854i;

    /* renamed from: m, reason: collision with root package name */
    private IQQLiveAnchorRoomStream f270855m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements ITRTCRemoteListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorHelperTRTC.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onConnectOtherRoom(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onConnectOtherRoom(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onDisConnectOtherRoom(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onDisConnectOtherRoom(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onFirstAudioFrame(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onFirstAudioFrame(str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onFirstVideoFrame(str, i3, i16, i17);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList<QQLiveQuality> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveQuality, (Object) arrayList);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onNetworkQuality(qQLiveQuality, arrayList);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserAudioAvailable(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onUserAudioAvailable(str, z16);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserSei(String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) bArr);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onUserSei(str, bArr);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVideoAvailable(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onUserVideoAvailable(str, z16);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
        public void onUserVoiceVolume(ArrayList<RemoteUserAudioInfo> arrayList, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, i3);
                return;
            }
            for (int size = QQLiveAnchorHelperTRTC.this.f270854i.size() - 1; size >= 0; size--) {
                ((ITRTCRemoteListener) QQLiveAnchorHelperTRTC.this.f270854i.get(size)).onUserVoiceVolume(arrayList, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements TRTCInitCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f270859a;

        b(d dVar) {
            this.f270859a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorHelperTRTC.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
        public void onInitEvent(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveAnchor_TRTC", 1, "trtc init:" + i3 + ", " + i16);
            }
            if (i3 == 2) {
                QQLiveAnchorHelperTRTC.this.f270851e = true;
                this.f270859a.onSuccess();
            } else if (i3 == 3) {
                QQLiveAnchorHelperTRTC.this.f270851e = false;
                QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                qQLiveErrorMsg.bizModule = 2;
                qQLiveErrorMsg.bizErrCode = 6101;
                qQLiveErrorMsg.bizErrMsg = "trtc init failed";
                qQLiveErrorMsg.originErrCode = i16;
                qQLiveErrorMsg.originErrMsg = "";
                this.f270859a.a(qQLiveErrorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements com.tencent.mobileqq.qqlive.trtc.video.source.screen.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveAnchorHelperTRTC.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            QLog.i("QQLiveAnchor_TRTC", 1, "onScreenCaptureResumed reason:" + i3);
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void k(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i("QQLiveAnchor_TRTC", 1, "onScreenCaptureError errCode:" + i3 + " errMsg:" + str);
            IQQLiveAnchorRoomStream iQQLiveAnchorRoomStream = QQLiveAnchorHelperTRTC.this.f270855m;
            if (iQQLiveAnchorRoomStream != null) {
                iQQLiveAnchorRoomStream.onScreenCaptureError(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            QLog.i("QQLiveAnchor_TRTC", 1, "onScreenCapturePaused reason:" + i3);
            IQQLiveAnchorRoomStream iQQLiveAnchorRoomStream = QQLiveAnchorHelperTRTC.this.f270855m;
            if (iQQLiveAnchorRoomStream != null) {
                iQQLiveAnchorRoomStream.onScreenCapturePause(i3);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void onScreenCaptureStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("QQLiveAnchor_TRTC", 1, "onScreenCaptureStarted");
            IQQLiveAnchorRoomStream iQQLiveAnchorRoomStream = QQLiveAnchorHelperTRTC.this.f270855m;
            if (iQQLiveAnchorRoomStream != null) {
                iQQLiveAnchorRoomStream.onScreenCaptureStarted();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.a
        public void onScreenCaptureStopped(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            QLog.i("QQLiveAnchor_TRTC", 1, "onScreenCaptureStopped reason:" + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface d {
        void a(QQLiveErrorMsg qQLiveErrorMsg);

        void onSuccess();
    }

    public QQLiveAnchorHelperTRTC() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f270850d = com.tencent.mobileqq.qqlive.trtc.b.r();
        this.f270851e = false;
        this.f270852f = false;
        this.f270853h = new HashMap();
        this.f270854i = new LinkedList();
        this.C = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        this.f270850d.g0(com.tencent.mobileqq.qqlive.utils.r.f(MobileQQ.sMobileQQ, true, true), null);
        N();
        this.f270852f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        try {
            this.f270850d.i0();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void C() {
        try {
            this.f270850d.T(null);
            this.f270850d.j0();
            this.f270852f = false;
        } finally {
            try {
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        try {
            this.f270850d.m0();
            Z();
        } finally {
            try {
            } finally {
            }
        }
    }

    private void I(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private void N() {
        this.f270850d.W(new c());
    }

    private void Z() {
        this.f270850d.W(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(int i3) {
        try {
            this.f270850d.N(i3);
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        try {
            this.f270850d.c0(3);
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
        }
    }

    public void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            try {
                bVar.G(z16);
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
            }
        }
    }

    public void F(@NonNull QQLiveTranscodingConfig qQLiveTranscodingConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) qQLiveTranscodingConfig);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.I(qQLiveTranscodingConfig);
        }
    }

    public void G(Bitmap bitmap, int i3, boolean z16) {
        com.tencent.mobileqq.qqlive.trtc.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, bitmap, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_TRTC", 1, "pausePublishStream, pause");
        }
        if (this.f270851e && (bVar = this.f270850d) != null) {
            try {
                bVar.J(bitmap, i3, z16);
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
            }
        }
    }

    public void H(boolean z16) {
        com.tencent.mobileqq.qqlive.trtc.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLiveAnchor_TRTC", 1, "resumePublishStream, resume");
        }
        if (this.f270851e && (bVar = this.f270850d) != null) {
            try {
                bVar.L(z16);
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
            }
        }
    }

    public void J(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.y(i3);
                }
            });
        }
    }

    public void K(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, RTCCameraDefine.RTCMirrorType rTCMirrorType, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, qQLiveAnchorRoomConfig, rTCMirrorType, Boolean.valueOf(z16));
        } else if (this.f270851e && this.f270852f && qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            this.f270850d.Q(rTCMirrorType, z16);
        }
    }

    public void L(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, qQLiveAnchorRoomConfig, Boolean.valueOf(z16));
        } else if (this.f270851e && this.f270852f && qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            this.f270850d.R(z16);
        }
    }

    public void M(com.tencent.mobileqq.qqlive.trtc.encoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.S(aVar);
        }
    }

    public void O(com.tencent.mobileqq.qqlive.trtc.video.source.screen.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.X(dVar);
        }
    }

    public void P(IQQLiveAnchorRoomStream iQQLiveAnchorRoomStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveAnchorRoomStream);
        } else {
            this.f270855m = iQQLiveAnchorRoomStream;
        }
    }

    public void Q(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.Z(aVar);
        }
    }

    public void R(TRTCVideoQualityParams tRTCVideoQualityParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) tRTCVideoQualityParams);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.a0(tRTCVideoQualityParams);
        }
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.z();
                }
            });
        }
    }

    public void T(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQLiveAnchorRoomConfig, (Object) frameLayout);
        } else if (this.f270851e && !this.f270852f) {
            I(new Runnable(frameLayout, qQLiveAnchorRoomConfig) { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FrameLayout f270856d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQLiveAnchorRoomConfig f270857e;

                {
                    this.f270856d = frameLayout;
                    this.f270857e = qQLiveAnchorRoomConfig;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQLiveAnchorHelperTRTC.this, frameLayout, qQLiveAnchorRoomConfig);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQLiveAnchorHelperTRTC.this.f270850d.T(this.f270856d);
                    QQLiveAnchorHelperTRTC.this.f270850d.d0();
                    QQLiveAnchorHelperTRTC.this.f270850d.R(this.f270857e.cameraMirror);
                    QQLiveAnchorHelperTRTC.this.f270852f = true;
                }
            });
        }
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.f270851e && !this.f270852f) {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.o
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.A();
                }
            });
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.m
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.B();
                }
            });
        }
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.f270851e && this.f270852f) {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.j
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.C();
                }
            });
        }
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.f270851e && this.f270852f) {
            I(new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.room.helper.n
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAnchorHelperTRTC.this.D();
                }
            });
        }
    }

    public void Y(QQLiveAnchorRoomConfig qQLiveAnchorRoomConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) qQLiveAnchorRoomConfig);
        } else if (this.f270851e && this.f270852f && qQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
            this.f270850d.n0();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void addRemoteListener(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            this.f270854i.add(iTRTCRemoteListener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void connectRemote(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.e(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public int getAudioPlayOutVolume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            return bVar.n();
        }
        return 0;
    }

    public void j(ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iTRTCRoomListener);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.b(iTRTCRoomListener);
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        if (this.f270850d == null) {
            return;
        }
        TRTCVideoQualityParams s16 = s();
        if (s16 == null) {
            QLog.e("QQLiveAnchor_TRTC", 1, "changeOrientationInner but params is null");
        } else if (i3 == s16.getVideoResolutionMode()) {
            QLog.e("QQLiveAnchor_TRTC", 1, "changeOrientationInner but not change");
        } else {
            R(new TRTCVideoQualityParams.Builder().setEnableAdjustRes(s16.isEnableAdjustRes()).setMinVideoBitRate(s16.getMinVideoBitRate()).setVideoBitRate(s16.getVideoBitRate()).setVideoResolution(s16.getVideoResolution()).setVideoFps(s16.getVideoFps()).setVideoResolutionMode(i3).build());
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void muteAllRemoteAudio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.F(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void muteRemoteAudio(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.H(str, z16);
        }
    }

    public IRTCMusicAccompany n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f270850d.f();
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (this.f270850d == null) {
            return;
        }
        r();
        V();
        X();
        W();
        try {
            this.f270850d.Y(null);
            this.f270850d.X(null);
            this.f270850d.W(null);
            this.f270850d.c();
            this.f270850d.h();
        } catch (Throwable th5) {
            QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
        }
    }

    public void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            if (!this.f270851e) {
                return;
            }
            this.f270850d.j(i3);
        }
    }

    public void q(QQLiveRoomParams qQLiveRoomParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) qQLiveRoomParams);
        } else {
            if (!this.f270851e) {
                return;
            }
            try {
                this.f270850d.l(qQLiveRoomParams);
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
            }
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            if (!this.f270851e) {
                return;
            }
            try {
                this.f270850d.m();
            } catch (Throwable th5) {
                QLog.e("QQLiveAnchor_TRTC", 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void removeRemoteListener(ITRTCRemoteListener iTRTCRemoteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) iTRTCRemoteListener);
        } else {
            this.f270854i.remove(iTRTCRemoteListener);
        }
    }

    public TRTCVideoQualityParams s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            return bVar.u();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            return bVar.M(bArr, i3);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setAudioPlayOutVolume(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.O(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setRemoteAudioVolume(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str, i3);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.U(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) str, (Object) qQLiveRenderParams);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.V(str, qQLiveRenderParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str, (Object) viewGroup);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.e0(str, viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void startRemoteView(String str, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) frameLayout);
            return;
        }
        TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(frameLayout.getContext());
        this.f270853h.put(str, new WeakReference<>(tXCloudVideoView));
        frameLayout.addView(tXCloudVideoView, new FrameLayout.LayoutParams(-1, -1));
        this.f270850d.f0(str, tXCloudVideoView);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopAllRemoteVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.h0();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopRemoteVideo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            bVar.k0(str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorRemoteControl
    public void stopRemoteView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        } else {
            this.f270853h.remove(str);
            this.f270850d.l0(str);
        }
    }

    public void t(Context context, IQQLiveSDK iQQLiveSDK, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, iQQLiveSDK, dVar);
            return;
        }
        this.f270851e = false;
        this.f270850d.w(context, iQQLiveSDK.getAppId(), new b(dVar));
        this.f270850d.Y(this.C);
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (!this.f270851e) {
            return false;
        }
        return this.f270850d.C();
    }

    public boolean v(RTCCameraDefine.RTCMirrorType rTCMirrorType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) rTCMirrorType)).booleanValue();
        }
        if (!this.f270851e) {
            return false;
        }
        return this.f270850d.D(rTCMirrorType);
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            return bVar.A();
        }
        return false;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.trtc.b bVar = this.f270850d;
        if (bVar != null) {
            return bVar.B();
        }
        return false;
    }
}
