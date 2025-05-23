package com.tencent.mobileqq.qqlive.trtc.room;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRenderParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.trtc.engine.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TRTCRoomCtrl implements a, ITRTCRoomListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f273356a;

    /* renamed from: b, reason: collision with root package name */
    private TRTCCloud f273357b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f273358c;

    /* renamed from: d, reason: collision with root package name */
    private ITRTCRoomListener f273359d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.config.a f273360e;

    public TRTCRoomCtrl(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f273356a = cVar;
        this.f273357b = cVar.f273306a;
        this.f273360e = com.tencent.mobileqq.qqlive.config.a.INSTANCE.a(cVar.f273308c);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void a(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveRoomParams);
            return;
        }
        if (qQLiveRoomParams != null) {
            TRTCCloudDef.TRTCSwitchRoomConfig i3 = com.tencent.mobileqq.qqlive.trtc.utils.a.i(qQLiveRoomParams);
            if (QLog.isColorLevel()) {
                QLog.i("TRTCRoomCtrl", 2, "switchRoom roomId:" + i3.roomId + " userSig:" + i3.userSig);
            }
            TRTCCloud tRTCCloud = this.f273357b;
            if (tRTCCloud != null) {
                tRTCCloud.switchRoom(i3);
                return;
            } else {
                QLog.e("TRTCRoomCtrl", 1, "switchRoom. trtcCloud == null");
                return;
            }
        }
        QLog.e("TRTCRoomCtrl", 1, "switchRoom, param == null. ");
        throw new IllegalArgumentException("param == null");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void b(@Nullable ITRTCRoomListener iTRTCRoomListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iTRTCRoomListener);
        } else {
            this.f273359d = iTRTCRoomListener;
        }
    }

    public void d(@NonNull Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) handler);
        } else {
            this.f273358c = handler;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.utils.b.a();
        this.f273357b = null;
        this.f273358c = null;
        this.f273359d = null;
        this.f273360e = null;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void enterRoom(QQLiveRoomParams qQLiveRoomParams) throws IllegalStateException, IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveRoomParams);
            return;
        }
        if (qQLiveRoomParams != null && this.f273357b != null) {
            TRTCCloudDef.TRTCParams g16 = com.tencent.mobileqq.qqlive.trtc.utils.a.g(qQLiveRoomParams);
            try {
                g16.sdkAppId = Integer.parseInt(this.f273360e.a().j());
                if (QLog.isColorLevel()) {
                    QLog.i("TRTCRoomCtrl", 2, "enterRoom userId:" + g16.userId + " role:" + g16.role + " roomId:" + g16.roomId + " scene:" + qQLiveRoomParams.getScene() + " sig:" + g16.userSig);
                }
                if (this.f273358c == null) {
                    this.f273358c = new Handler(Looper.getMainLooper());
                }
                this.f273357b.enterRoom(g16, com.tencent.mobileqq.qqlive.trtc.utils.a.c(qQLiveRoomParams.getScene()));
                return;
            } catch (Exception unused) {
                QLog.e("TRTCRoomCtrl", 1, "enterRoom error!, app id is not init!");
                throw new IllegalArgumentException("appId is not int!");
            }
        }
        throw new IllegalArgumentException("param or trtcCloud == null");
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void exitRoom() throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TRTCRoomCtrl", 2, "exitRoom!");
        }
        if (this.f273357b != null) {
            stopAllRemoteVideo();
            this.f273357b.exitRoom();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEnterRoom(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCRoomCtrl", 2, "onEnterRoom " + j3 + ", msg: " + str);
        }
        if (this.f273359d == null) {
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(j3, str) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f273361d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f273362e;

            {
                this.f273361d = j3;
                this.f273362e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TRTCRoomCtrl.this, Long.valueOf(j3), str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TRTCRoomCtrl.this.f273359d.onEnterRoom(this.f273361d, this.f273362e);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onEvent(int i3, int i16, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
            return;
        }
        if (this.f273359d == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCRoomCtrl", 2, "onEvent, event " + i3 + ", code: " + i16 + ", msg: " + str);
        }
        com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(i3, i16, str, bundle) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f273370d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f273371e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f273372f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Bundle f273373h;

            {
                this.f273370d = i3;
                this.f273371e = i16;
                this.f273372f = str;
                this.f273373h = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TRTCRoomCtrl.this, Integer.valueOf(i3), Integer.valueOf(i16), str, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TRTCRoomCtrl.this.f273359d.onEvent(this.f273370d, this.f273371e, this.f273372f, this.f273373h);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onExitRoom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TRTCRoomCtrl", 2, "onExitRoom " + i3);
        }
        if (this.f273359d == null) {
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(i3) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f273363d;

            {
                this.f273363d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCRoomCtrl.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TRTCRoomCtrl.this.f273359d.onExitRoom(this.f273363d);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalAudioFrameSent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            if (this.f273359d == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable() { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCRoomCtrl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TRTCRoomCtrl.this.f273359d.onFirstLocalAudioFrameSent();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onFirstLocalVideoFrameSent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            if (this.f273359d == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(i3) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f273369d;

                {
                    this.f273369d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCRoomCtrl.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TRTCRoomCtrl.this.f273359d.onFirstLocalVideoFrameSent(this.f273369d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserEnterRoom(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            if (this.f273359d == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(str) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f273366d;

                {
                    this.f273366d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCRoomCtrl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TRTCRoomCtrl.this.f273359d.onRemoteUserEnterRoom(this.f273366d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onRemoteUserLeaveRoom(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
        } else {
            if (this.f273359d == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(str, i3) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f273367d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f273368e;

                {
                    this.f273367d = str;
                    this.f273368e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCRoomCtrl.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TRTCRoomCtrl.this.f273359d.onRemoteUserLeaveRoom(this.f273367d, this.f273368e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
    public void onSwitchRoom(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) str);
        } else {
            if (this.f273359d == null) {
                return;
            }
            com.tencent.mobileqq.qqlive.trtc.utils.c.a(this.f273358c, new Runnable(i3, str) { // from class: com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f273364d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f273365e;

                {
                    this.f273364d = i3;
                    this.f273365e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TRTCRoomCtrl.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TRTCRoomCtrl.this.f273359d.onSwitchRoom(this.f273364d, this.f273365e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public boolean sendSEIMsg(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr, i3)).booleanValue();
        }
        TRTCCloud tRTCCloud = this.f273357b;
        if (tRTCCloud == null) {
            QLog.e("TRTCRoomCtrl", 1, "sendSEIMsg fail! trtcCloud is null!");
            return false;
        }
        return tRTCCloud.sendSEIMsg(bArr, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void setRemoteVideoParam(String str, QQLiveRenderParams qQLiveRenderParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) qQLiveRenderParams);
            return;
        }
        if (!TextUtils.isEmpty(str) && qQLiveRenderParams != null) {
            QLog.i("TRTCRoomCtrl", 1, "setRemoteVideoParam userId:" + str + " params:" + qQLiveRenderParams);
            this.f273357b.setRemoteRenderParams(str, 0, com.tencent.mobileqq.qqlive.trtc.utils.a.d(qQLiveRenderParams));
            return;
        }
        QLog.e("TRTCRoomCtrl", 1, "setRemoteVideoParam error! userId or params is null! userId:" + str + " params:" + qQLiveRenderParams);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void startRemoteVideo(String str, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) viewGroup);
            return;
        }
        if (!TextUtils.isEmpty(str) && viewGroup != null) {
            Context context = this.f273356a.f273307b.get();
            if (context == null) {
                QLog.e("TRTCRoomCtrl", 1, "startRemoteVideo error! context is null!");
                return;
            }
            QLog.i("TRTCRoomCtrl", 1, "startRemoteVideo userId:" + str + " viewGroup:" + viewGroup);
            com.tencent.mobileqq.qqlive.trtc.utils.b.e(str);
            this.f273357b.startRemoteView(str, 0, com.tencent.mobileqq.qqlive.trtc.utils.b.c(str, new WeakReference(viewGroup), context));
            return;
        }
        QLog.e("TRTCRoomCtrl", 1, "startRemoteVideo error! userId or viewGroup is null! userId:" + str + " viewGroup:" + viewGroup);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void stopAllRemoteVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i("TRTCRoomCtrl", 1, "stopAllRemoteVideo");
        com.tencent.mobileqq.qqlive.trtc.utils.b.a();
        this.f273357b.stopAllRemoteView();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.room.a
    public void stopRemoteVideo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("TRTCRoomCtrl", 1, "stopRemoteVideo error! userId is null! userId:" + str);
            return;
        }
        QLog.i("TRTCRoomCtrl", 1, "stopRemoteVideo userId:" + str);
        com.tencent.mobileqq.qqlive.trtc.utils.b.b(str);
        this.f273357b.stopRemoteView(str, 0);
    }
}
