package com.tencent.av.service;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.service.e;
import com.tencent.av.ui.ap;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.af;
import com.tencent.av.utils.x;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import fu.a;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVServiceForQQ extends AppService {

    /* renamed from: h, reason: collision with root package name */
    public String f74307h;

    /* renamed from: m, reason: collision with root package name */
    private AVScreenCaptureService f74309m;

    /* renamed from: d, reason: collision with root package name */
    VideoAppInterface f74304d = null;

    /* renamed from: e, reason: collision with root package name */
    Notification f74305e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f74306f = 10;

    /* renamed from: i, reason: collision with root package name */
    private AVServiceForQQStub f74308i = null;

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        boolean z16;
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof VideoAppInterface) {
            this.f74304d = (VideoAppInterface) appRuntime;
        }
        Object[] objArr = new Object[2];
        boolean z17 = false;
        if (this.f74304d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        if (this.f74308i != null) {
            z17 = true;
        }
        objArr[1] = Boolean.valueOf(z17);
        QLog.i("AVServiceForQQ", 1, String.format("onBind, appInterface[%b], AVServiceForQQ[%b]", objArr));
        return this.f74308i;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        boolean z16;
        boolean z17 = false;
        try {
            super.onCreate();
            if (this.f74308i == null) {
                this.f74308i = new AVServiceForQQStub();
            }
        } catch (Exception e16) {
            QLog.d("AVServiceForQQ", 1, "AVServiceForQQ onCreate, Fail", e16);
            try {
                QQToast.makeText(super.getBaseContext(), super.getString(R.string.ico) + " 0x0a", 0).show();
            } catch (Exception unused) {
            }
        }
        Object[] objArr = new Object[2];
        if (this.f74304d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        if (this.f74308i != null) {
            z17 = true;
        }
        objArr[1] = Boolean.valueOf(z17);
        AVCoreLog.printAllUserLog("AVServiceForQQ", String.format("onCreate, appInterface[%b], AVServiceForQQ[%b]", objArr));
        QLog.d("AVServiceForQQ", 1, "AVServiceForQQ onCreate " + this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        boolean z16;
        AVScreenCaptureService aVScreenCaptureService = this.f74309m;
        if (aVScreenCaptureService != null) {
            aVScreenCaptureService.d(this);
            this.f74309m = null;
        }
        try {
            if (this.f74305e != null) {
                stopForeground(true);
                this.f74305e = null;
            }
        } catch (Exception unused) {
        }
        super.onDestroy();
        QLog.d("AVServiceForQQ", 1, "onDestroy " + this);
        Object[] objArr = new Object[2];
        boolean z17 = false;
        if (this.f74304d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        if (this.f74308i != null) {
            z17 = true;
        }
        objArr[1] = Boolean.valueOf(z17);
        AVCoreLog.printAllUserLog("AVServiceForQQ", String.format("onDestroy, appInterface[%b], AVServiceForQQ[%b]", objArr));
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i3, int i16) {
        boolean z16;
        boolean z17;
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof VideoAppInterface) {
            this.f74304d = (VideoAppInterface) appRuntime;
        }
        if (QLog.isDevelopLevel()) {
            Object[] objArr = new Object[4];
            if (this.f74304d != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            if (this.f74308i != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr[1] = Boolean.valueOf(z17);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(i16);
            QLog.d("AVServiceForQQ", 4, String.format("onCreate, appInterface[%b], AVServiceForQQ[%b], flags[%d], startId[%d]", objArr));
        }
        QLog.d("AVServiceForQQ", 1, "onStartCommand " + this);
        if (intent != null) {
            if (intent.getBooleanExtra("setForeground", false)) {
                boolean booleanExtra = intent.getBooleanExtra(com.tencent.mobileqq.msf.core.net.r.a.f248963o, false);
                Notification notification = (Notification) intent.getParcelableExtra("notification");
                try {
                    AVServiceForQQStub aVServiceForQQStub = this.f74308i;
                    if (aVServiceForQQStub != null) {
                        aVServiceForQQStub.v0(booleanExtra, notification);
                    }
                } catch (Throwable th5) {
                    QLog.e("AVServiceForQQ", 1, "", th5);
                }
            }
            if (intent.getBooleanExtra("isScreenCapture", false)) {
                this.f74309m = new AVScreenCaptureService(this, this.f74304d);
                this.f74304d.M().postDelayed(new Runnable() { // from class: com.tencent.av.service.AVServiceForQQ.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AVServiceForQQ.this.f74309m != null) {
                            AVServiceForQQ.this.f74309m.e(intent, AVServiceForQQ.this);
                        }
                    }
                }, 200L);
            }
        }
        return 2;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class AVServiceForQQStub extends e.a {
        AVServiceForQQStub() {
        }

        @Override // com.tencent.av.service.e
        public void A0(long j3, String str) throws RemoteException {
            if (r.h0().W0() && n.e().f().f73006b2) {
                return;
            }
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("AVServiceForQQ", 1, "enterRoom, groupId[" + j3 + "], nickname[" + str + "], seq[" + d16 + "]");
            n.e().f().r0("enterRoom", true);
            TraeHelper I = TraeHelper.I();
            I.b0(null);
            I.L();
            I.S();
            AVServiceForQQ aVServiceForQQ = AVServiceForQQ.this;
            aVServiceForQQ.f74307h = n.b(aVServiceForQQ.f74306f, String.valueOf(j3), new int[0]);
            n.e().a(AVServiceForQQ.this.f74307h, false);
            if (r.h0().W0()) {
                r.h0().a2(r.h0().b0(), r.h0().X(), 94);
            }
            n.e().o(AVServiceForQQ.this.f74307h);
            I.m0();
            I.i0(TraeConstants.VIDEO_CALL_CONFIG);
            I.a0();
            if (r.h0().W0()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AVServiceForQQ", 2, "StartOrEnterGAudio already in room");
                }
            } else {
                AppRuntime appRuntime = AVServiceForQQ.this.f74304d;
                if (appRuntime == null) {
                    appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                }
                int y36 = r.h0().y3(AVServiceForQQ.this.f74306f, j3, 13, new long[]{appRuntime.getLongAccountUin()}, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d("AVServiceForQQ", 2, "enterRoom result = " + y36);
                }
            }
            n.e().f().p0(d16, "enterRoom", 3);
            n.e().f().f73006b2 = true;
        }

        @Override // com.tencent.av.service.e
        public void H0(byte[] bArr) throws RemoteException {
            if (r.h0() != null) {
                r.h0().l0().i(bArr);
            }
        }

        @Override // com.tencent.av.service.e
        public void I3(byte[] bArr) throws RemoteException {
            if (r.h0() != null) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("buffer", bArr);
                r.h0().l0().receiveMultiVideoAck(bundle);
            }
        }

        @Override // com.tencent.av.service.e
        public void V4(int i3, long j3, byte[] bArr) throws RemoteException {
            if (af.H() && (i3 == 768 || i3 == 769)) {
                return;
            }
            boolean c16 = x.c("AVServiceForQQ", j3);
            if (r.h0() != null && !c16) {
                x.a(j3);
                r.h0().l0().receiveSSOMultiVideoMsg(i3, bArr, false);
            }
        }

        @Override // com.tencent.av.service.e
        public void d2(String str, Bundle bundle, i iVar) {
            com.tencent.av.zplan.d.a().c(str, bundle, iVar);
        }

        @Override // com.tencent.av.service.e
        public void f2(long j3) throws RemoteException {
            u4();
            if (r.h0().W0()) {
                r.h0().a2(r.h0().b0(), r.h0().X(), 95);
            } else {
                r.h0().a2(AVServiceForQQ.this.f74306f, j3, 96);
            }
        }

        @Override // com.tencent.av.service.e
        public int getPstnUserNumberInMAV(long j3, int i3) {
            int i16 = 0;
            if (r.h0() != null && r.h0().W0() && n.e().f().S0 == i3 && n.e().f().P0 == j3) {
                Iterator<com.tencent.av.e> it = r.h0().Y().iterator();
                while (it.hasNext()) {
                    if (it.next().f73715o == 1) {
                        i16++;
                    }
                }
            }
            return i16;
        }

        @Override // com.tencent.av.service.e
        public void i4() throws RemoteException {
            int e06 = r.h0().e0();
            r.h0().z("startSpeak", r.h0().X(), true, true, -1);
            r.h0().q1(-1L, e06, r.h0().e0());
        }

        @Override // com.tencent.av.service.e
        public void processS2C(byte[] bArr) throws RemoteException {
            if (r.h0() != null) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("buffer", bArr);
                r.h0().l0().receiveMultiVideoMsg(bundle);
            }
        }

        @Override // com.tencent.av.service.e
        public void q0(String str) throws RemoteException {
            if (r.h0() != null) {
                r.h0().D1(str);
            }
        }

        @Override // com.tencent.av.service.e
        public void u3() throws RemoteException {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("AVServiceForQQ", 1, "exitQQCall, seq[" + d16 + "]");
            TraeHelper.I().k0(d16);
            n.e().f().H = false;
            r.h0().r(n.e().f().f73091w, 224);
            r.h0().j2(224);
            if (n.e().f().A0 == -1) {
                n.e().f().A0 = 0;
            }
            n.e().f().X = true;
            AVCoreLog.printColorLog("AVServiceForQQ", "DataReport onClose: ");
            a.C10338a.d(AVServiceForQQ.this.f74304d);
            EffectPendantTools.a.c("AVServiceForQQ", AVServiceForQQ.this.f74304d);
            VideoAppInterface videoAppInterface = AVServiceForQQ.this.f74304d;
            if (videoAppInterface != null) {
                com.tencent.av.ui.effect.toolbar.a.a(videoAppInterface.getCurrentAccountUin());
            }
            ap.a(n.e().f());
            r.h0().q(n.e().f().f73091w, n.e().f().A0);
            n.e().f().d0("exitQQCall", false);
            n.e().f().q0("exitQQCall", 0);
        }

        @Override // com.tencent.av.service.e
        public void u4() throws RemoteException {
            int e06 = r.h0().e0();
            r.h0().z("stopSpeak", r.h0().X(), false, true, -1);
            r.h0().q1(-1L, e06, r.h0().e0());
        }

        @Override // com.tencent.av.service.e
        public void v0(boolean z16, Notification notification) throws RemoteException {
            int i3 = Build.VERSION.SDK_INT;
            if (z16) {
                if (notification != null) {
                    AVServiceForQQ.this.f74305e = notification;
                } else {
                    AVServiceForQQ.this.f74305e = new Notification();
                }
                if (i3 >= 26) {
                    QLog.i("AVServiceForQQ", 1, "setAvServiceForegroud add channel id");
                    QQNotificationManager.addChannelIfNeed(AVServiceForQQ.this.f74305e, QQNotificationManager.CHANNEL_ID_SHOW_BADGE);
                }
                VideoAppInterface videoAppInterface = AVServiceForQQ.this.f74304d;
                if (videoAppInterface != null) {
                    videoAppInterface.M().post(new Runnable() { // from class: com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AVServiceForQQ aVServiceForQQ = AVServiceForQQ.this;
                                aVServiceForQQ.startForeground(235, aVServiceForQQ.f74305e);
                                if (QLog.isColorLevel()) {
                                    QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud start foreground.");
                                }
                            } catch (Exception e16) {
                                QLog.d("AVServiceForQQ", 1, "setAVServiceForegroud, e = " + e16);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            try {
                AVServiceForQQ.this.stopForeground(true);
                QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground.");
            } catch (Throwable th5) {
                QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground fail", th5);
            }
            AVServiceForQQ.this.f74305e = null;
        }

        @Override // com.tencent.av.service.e
        public void z2(boolean z16) throws RemoteException {
            r.h0().l3(z16);
        }

        @Override // com.tencent.av.service.e
        public void g2(d dVar) throws RemoteException {
        }

        @Override // com.tencent.av.service.e
        public void k3(String str, Bitmap bitmap) throws RemoteException {
        }
    }
}
