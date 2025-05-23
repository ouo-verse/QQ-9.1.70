package com.tencent.mobileqq.activity.richmedia.state;

import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes10.dex */
public class RMVideoInitState extends e {

    /* renamed from: a, reason: collision with root package name */
    boolean f185877a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f185878b = false;

    /* renamed from: c, reason: collision with root package name */
    boolean f185879c = false;

    /* renamed from: d, reason: collision with root package name */
    boolean f185880d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f185881e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f185882f = true;

    /* renamed from: g, reason: collision with root package name */
    final Runnable f185883g = new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
        @Override // java.lang.Runnable
        public void run() {
            boolean isFoundProductFeature = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f69012z);
            if (isFoundProductFeature) {
                RMVideoStateMgr.u().a(1102, HardCodeUtil.qqStr(R.string.t1y), true);
                return;
            }
            try {
                RMVideoInitState rMVideoInitState = RMVideoInitState.this;
                if (!rMVideoInitState.f185880d && rMVideoInitState.f185882f) {
                    RMVideoStateMgr.u().a(1102, HardCodeUtil.qqStr(R.string.f172647t24) + 1102, true);
                }
                RMVideoStateMgr u16 = RMVideoStateMgr.u();
                if (QLog.isColorLevel()) {
                    QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]\u521d\u59cb\u5316\u5931\u8d25,code=1102 mIsReadAVCodec=" + RMVideoInitState.this.f185877a + " mIsReadCamera=" + RMVideoInitState.this.f185878b + " black=" + isFoundProductFeature + " rmStateMgr.mIsAudioReady=" + u16.K + " rmStateMgr.mVideoFileDir=" + u16.M);
                }
                RMVideoStateMgr.i(null);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    };

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void a() {
        if (j()) {
            RMVideoStateMgr.u().f(3);
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void b() {
        this.f185880d = false;
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (u16 != null) {
            com.tencent.mobileqq.shortvideo.util.a aVar = u16.X;
            if (aVar != null) {
                aVar.c(u16);
            }
            g gVar = u16.Q;
            if (gVar != null) {
                gVar.A();
            }
            if (!u16.K) {
                this.f185879c = false;
            }
            if (!this.f185879c) {
                i();
            } else {
                u16.K();
                k();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void c(Object obj, int i3, Object... objArr) {
        if (obj instanceof CameraProxy.CameraPreviewObservable) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 12) {
                        if (!this.f185880d) {
                            this.f185880d = true;
                            RMVideoStateMgr.u().a(2002, HardCodeUtil.qqStr(R.string.f172648t25), false);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_CAMERA_DISABLED error");
                        }
                    }
                } else if (objArr != null && (objArr[0] instanceof String)) {
                    if (!this.f185880d) {
                        this.f185880d = true;
                        RMVideoStateMgr.u().a(2003, HardCodeUtil.qqStr(R.string.t27), false);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_SET_CAMERA_PARAM error, error = " + objArr[0]);
                    }
                }
            } else if (objArr != null) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Boolean) {
                    this.f185878b = true;
                    l();
                    if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA[success] obj= " + objArr[0]);
                    }
                    String qQProcessName = BaseApplicationImpl.sApplication.getQQProcessName();
                    if (qQProcessName != null && qQProcessName.endsWith(":story")) {
                        id0.a.k("take_video", "camera_initial", 0, 0, new String[0]);
                    }
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5
                        @Override // java.lang.Runnable
                        public void run() {
                            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
                            boolean z16 = sharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
                            boolean z17 = sharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
                            CameraControl u16 = CameraControl.u();
                            if (!z16 && com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
                                com.tencent.mobileqq.activity.richmedia.f.h(u16.o(), "front");
                                sharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
                            } else if (!z17 && com.tencent.mobileqq.activity.richmedia.c.f185845b == 2) {
                                com.tencent.mobileqq.activity.richmedia.f.h(u16.o(), "back");
                                sharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
                            }
                        }
                    }, 8, null, true);
                } else if (obj2 instanceof String) {
                    if (!this.f185880d) {
                        this.f185880d = true;
                        RMVideoStateMgr.u().a(2002, HardCodeUtil.qqStr(R.string.t2b), false);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_CREATE_CAMERA, error = " + objArr[0]);
                    }
                    String qQProcessName2 = BaseApplicationImpl.sApplication.getQQProcessName();
                    if (qQProcessName2 != null && qQProcessName2.endsWith(":story")) {
                        id0.a.k("take_video", "camera_initial", 0, -1, new String[0]);
                    }
                }
            }
        } else if (obj instanceof AudioCapture) {
            RMVideoStateMgr u16 = RMVideoStateMgr.u();
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 == 6) {
                        if (objArr != null) {
                            Object obj3 = objArr[0];
                            if ((obj3 instanceof Boolean) && ((Boolean) obj3).booleanValue()) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [OK]");
                                }
                                u16.N(true);
                                l();
                                u16.L = true;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_START_MIC [error]\u9ea6\u514b\u98ce\u542f\u52a8\u5f55\u5236\u5931\u8d25...");
                        }
                        u16.J = null;
                        u16.L = false;
                        if (RMVideoStateMgr.f185888s0) {
                            u16.N(true);
                            l();
                        } else {
                            u16.N(false);
                        }
                        if (!u16.V) {
                            RMVideoStateMgr.u().b(0, HardCodeUtil.qqStr(R.string.f172646t23), false);
                            u16.V = true;
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("RMVideoInitState", 2, "[@] EVENT_OPEN_MIC [error]\u9ea6\u514b\u98ce\u6253\u5f00\u5931\u8d25...");
                    }
                    u16.J = null;
                    u16.L = false;
                    if (RMVideoStateMgr.f185888s0) {
                        u16.N(true);
                        l();
                    } else {
                        u16.N(false);
                    }
                    if (!u16.V) {
                        RMVideoStateMgr.u().b(0, HardCodeUtil.qqStr(R.string.t28), false);
                        u16.V = true;
                    }
                }
            } else {
                if (objArr != null) {
                    Object obj4 = objArr[0];
                    if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [OK]");
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]\u9ea6\u514b\u98ce\u521d\u59cb\u5316\u53c2\u6570\u5931\u8d25...");
                    QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [error]mAudioSampleRate=" + CodecParam.mAudioSampleRate + " mAudioChannel=" + CodecParam.mAudioChannel + " mAudioFormat=" + CodecParam.mAudioFormat);
                }
                u16.J = null;
                u16.L = false;
                u16.N(false);
                Handler handler = u16.f185906l0;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.6
                        @Override // java.lang.Runnable
                        public void run() {
                            RMVideoStateMgr.u().b(0, HardCodeUtil.qqStr(R.string.f172645t20), false);
                        }
                    });
                } else if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] EVENT_INIT [Error]\u9ea6\u514b\u98ce\u53c2\u6570\u521d\u59cb\u5316\u5931\u8d25 ,rmStateMgr.mHandler = null");
                }
            }
        }
        super.c(obj, i3, objArr);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void d(AVCodec.AVCodecCallback aVCodecCallback, MessageStruct messageStruct) {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (messageStruct.mId == 33554435) {
            u16.M = (String) messageStruct.mObj0;
            this.f185877a = true;
            if (QLog.isColorLevel()) {
                QLog.d("RMVideoInitState", 2, "[@] onAVCodecEvent[RMFileEventNotify] path=" + u16.M + ",files : " + Arrays.toString(new File(u16.M).list()));
            }
            u16.f185906l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.4
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = RMVideoStateMgr.u().Q;
                    if (gVar != null) {
                        gVar.d0();
                    }
                }
            });
            l();
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void e() {
        RMVideoStateMgr.u().j();
        this.f185879c = false;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void f() {
        RMVideoStateMgr.u().j();
        this.f185879c = false;
        this.f185877a = false;
        this.f185878b = false;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void g(boolean z16) {
        this.f185881e = z16;
    }

    void i() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] delayInit called");
        }
        u16.f185906l0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] delayInit,run start");
                }
                RMVideoStateMgr u17 = RMVideoStateMgr.u();
                if (!u17.g()) {
                    RMVideoStateMgr.i(null);
                    if (!u17.g()) {
                        return;
                    }
                }
                File file = new File(yq2.a.f450985b + File.separator + ".nomedia");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] delayInit, post timeout runnable");
                }
                u17.f185906l0.postDelayed(RMVideoInitState.this.f185883g, 10000L);
                u17.v();
                u17.K();
                u17.stopWatching();
                try {
                    AVCodec.get().init();
                } catch (UnsatisfiedLinkError e16) {
                    e16.printStackTrace();
                    RMVideoInitState.this.f185879c = false;
                }
                RMVideoInitState.this.f185879c = true;
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] delayInit,run finish");
                }
            }
        }, 50L);
    }

    boolean j() {
        if (RMVideoStateMgr.u().K && this.f185877a && this.f185878b) {
            return true;
        }
        return false;
    }

    void k() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (QLog.isColorLevel()) {
            QLog.d("RMVideoInitState", 2, "[@] retake called");
        }
        AudioCapture audioCapture = u16.J;
        if (audioCapture != null) {
            audioCapture.p();
        }
        try {
            u16.stopWatching();
            if (this.f185881e) {
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().retake()");
                }
                AVCodec.get().retake();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("RMVideoInitState", 2, "[@] retake call AVCodec.get().init()");
                }
                AVCodec.get().init();
                this.f185881e = true;
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        PreviewContext previewContext = u16.I;
        if (previewContext != null) {
            previewContext.reset();
        }
        com.tencent.mobileqq.shortvideo.mediadevice.c.b().e().f(0);
    }

    void l() {
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (j()) {
            u16.f185906l0.removeCallbacks(this.f185883g);
            u16.f185906l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.3
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = RMVideoStateMgr.u().Q;
                    if (gVar != null) {
                        gVar.l();
                    }
                }
            });
        }
    }
}
