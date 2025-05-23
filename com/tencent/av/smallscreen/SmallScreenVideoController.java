package com.tencent.av.smallscreen;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.GInviteTimeOutHelper;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.utils.ba;
import com.tencent.avcore.camera.observe.CameraObserver;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import cooperation.qzone.remote.ServiceConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenVideoController implements SmallScreenVideoLayerUI.a {

    /* renamed from: a, reason: collision with root package name */
    Display f74536a;

    /* renamed from: b, reason: collision with root package name */
    SmallScreenService f74537b;

    /* renamed from: c, reason: collision with root package name */
    Context f74538c;

    /* renamed from: t, reason: collision with root package name */
    SmallScreenVideoControlUI f74555t;

    /* renamed from: u, reason: collision with root package name */
    SmallScreenVideoLayerUI f74556u;

    /* renamed from: v, reason: collision with root package name */
    ICameraManagerApi f74557v;

    /* renamed from: d, reason: collision with root package name */
    int f74539d = -1;

    /* renamed from: e, reason: collision with root package name */
    Timer f74540e = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f74541f = false;

    /* renamed from: g, reason: collision with root package name */
    int f74542g = 1;

    /* renamed from: h, reason: collision with root package name */
    int f74543h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f74544i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f74545j = -1;

    /* renamed from: k, reason: collision with root package name */
    int f74546k = 0;

    /* renamed from: l, reason: collision with root package name */
    String f74547l = null;

    /* renamed from: m, reason: collision with root package name */
    String f74548m = null;

    /* renamed from: n, reason: collision with root package name */
    String f74549n = null;

    /* renamed from: o, reason: collision with root package name */
    boolean f74550o = false;

    /* renamed from: p, reason: collision with root package name */
    boolean f74551p = false;

    /* renamed from: q, reason: collision with root package name */
    boolean f74552q = false;

    /* renamed from: r, reason: collision with root package name */
    boolean f74553r = false;

    /* renamed from: s, reason: collision with root package name */
    VideoAppInterface f74554s = null;

    /* renamed from: w, reason: collision with root package name */
    Bitmap f74558w = null;

    /* renamed from: x, reason: collision with root package name */
    com.tencent.av.ui.e f74559x = null;

    /* renamed from: y, reason: collision with root package name */
    int f74560y = 0;

    /* renamed from: z, reason: collision with root package name */
    ControlUIObserver f74561z = new b();
    CameraObserver A = new a();
    GAudioUIObserver B = new GAudioUIObserver() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.3
        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            int c16 = n.e().c();
            QLog.d("SmallScreenVideoController", 1, "onDestroyInviteUI count=" + c16 + " getMainSession=" + n.e().f());
            if (c16 > 0) {
                return;
            }
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.g(i3);
            }
            GInviteTimeOutHelper.b().a();
            Handler M = SmallScreenVideoController.this.f74554s.M();
            if (M != null) {
                M.postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SmallScreenVideoController.this.k();
                    }
                }, 1500L);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void o() {
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            if (smallScreenVideoController.f74554s == null) {
                return;
            }
            SmallScreenVideoControlUI smallScreenVideoControlUI = smallScreenVideoController.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.g(0);
            }
            Handler M = SmallScreenVideoController.this.f74554s.M();
            if (M != null) {
                final int i3 = n.e().f().S0;
                final long j3 = n.e().f().P0;
                M.postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SmallScreenVideoController.this.k();
                        if (r.h0() == null || SmallScreenVideoController.this.f74541f) {
                            return;
                        }
                        r.h0().Q0(-1041L, i3, j3, 8, false);
                    }
                }, 1500L);
            }
        }
    };
    boolean C = false;
    MyVideoObserver D = new MyVideoObserver();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class MyVideoObserver extends VideoObserver {
        MyVideoObserver() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void A(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("SmallScreenVideoController", 2, "onNotifySelfZplanAvatarSwitch enable: " + z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void B(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("SmallScreenVideoController", 2, "onNotifyUpdateZplanAvatarFakeBackground isShow: " + z16);
            }
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.k1(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void I() {
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.j();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void J() {
            super.J();
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.l();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void K() {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onPauseVideo, seq[" + d16 + "]");
            }
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            if (smallScreenVideoController.f74556u != null) {
                smallScreenVideoController.h(1);
                SmallScreenVideoController.this.f74556u.D1(n.e().f().f73091w, 1, false, false, r.h0().j1(SmallScreenVideoController.this.f74547l));
            }
            if (n.e().f().f73067q == 1011 && n.e().f().N) {
                SmallScreenVideoController.this.f74557v.closeCamera(d16, true);
                if (n.e().f().f73001a1 == 3) {
                    n.e().f().f73001a1 = 0;
                }
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void L(String str, boolean z16) {
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.m(str, z16);
            }
            SmallScreenVideoController.this.i();
            if (SmallScreenVideoController.this.f74556u != null && n.e().f().O) {
                SmallScreenVideoController.this.f74556u.b1(n.e().f().f73091w, r.h0().j1(SmallScreenVideoController.this.f74547l));
            }
            QavVideoRecordUICtrl.p0(r.h0());
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void M(boolean z16, boolean z17) {
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.n(z16, z17);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void N(int i3) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI;
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + i3);
            }
            String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(SmallScreenVideoController.this.f74554s, i3, VipFunCallUtil.getResourceType(), null);
            if (resourcePathByUrl == null) {
                return;
            }
            if (new File(resourcePathByUrl).exists() && n.e().f().f73043k != 4) {
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                if (smallScreenVideoController.f74543h == 1 && (smallScreenVideoLayerUI = smallScreenVideoController.f74556u) != null) {
                    smallScreenVideoLayerUI.G0();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate finish id:" + i3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        public void R(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + str);
            }
            n.e().f().f73001a1 = 0;
        }

        @Override // com.tencent.av.app.VideoObserver
        public void T(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onRequestVideoMode fromUin = " + str);
            }
            n.e().f().f73001a1 = 2;
            SmallScreenVideoController.this.o();
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void U(long j3) {
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onResumeVideo, seq[" + j3 + "]");
            }
            SmallScreenRelativeLayout B = SmallScreenVideoController.this.f74537b.B(1);
            if (B == null) {
                SmallScreenVideoController.this.f74537b.R();
                B = SmallScreenVideoController.this.f74537b.B(1);
                QLog.w("SmallScreenVideoController", 1, "onRequest_ResumeVideo, create videoToastView.");
            }
            if (B == null) {
                QLog.e("SmallScreenVideoController", 1, "onRequest_ResumeVideo, error videoToastView = null.");
                return;
            }
            View findViewById = B.findViewById(R.id.rad);
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = smallScreenVideoController.f74556u;
            if (smallScreenVideoLayerUI == null) {
                SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                smallScreenVideoController.f74556u = new SmallScreenVideoLayerUI(smallScreenVideoController2.f74554s, smallScreenVideoController2.f74537b, findViewById, smallScreenVideoController2);
            } else {
                smallScreenVideoLayerUI.F();
            }
            if (SmallScreenVideoController.this.f74556u != null) {
                SmallScreenVideoController.this.f74556u.D1(n.e().f().f73091w, 1, true, false, r.h0().j1(SmallScreenVideoController.this.f74547l));
                SmallScreenVideoController.this.f74556u.z1(n.e().f().f73091w, 1, SmallScreenVideoController.this.f74558w, true, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void V() {
            super.V();
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.p();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void W() {
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.q();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        public void a(String str) {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w("SmallScreenVideoController", 1, "onAcceptVideoMode, fromUin[" + str + "], seq[" + d16 + "]");
            n.e().f().f73001a1 = 3;
            SmallScreenVideoController.this.f74557v.openCamera(d16);
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.B1(true, false);
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                smallScreenVideoController.f74556u.U0(d16, smallScreenVideoController.f74557v.isFrontCamera());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void b(int i3) {
            super.b(i3);
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.b(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void d(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + str);
            }
            super.d(str);
            n.e().f().f73001a1 = 0;
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI;
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onClose, reason[" + i3 + "], peerUin[" + str + "], seq[" + j3 + "]");
            }
            if (TextUtils.equals(str, n.e().f().f73091w)) {
                SmallScreenVideoController.this.f74557v.closeCamera(j3, false);
                if (n.e().f().f73067q == 1011 && (smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u) != null) {
                    smallScreenVideoLayerUI.D1(str, 1, false, false, r.h0().j1(SmallScreenVideoController.this.f74547l));
                    SmallScreenVideoController.this.f74556u.B1(false, false);
                    SmallScreenVideoController.this.f74556u.y1();
                }
                SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
                if (smallScreenVideoControlUI != null) {
                    smallScreenVideoControlUI.c(i3);
                }
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void g(long j3) {
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onConnected, seq[" + j3 + "]");
            }
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.i1();
            }
            if (n.e().f().f73035i == 2 && SmallScreenVideoController.this.f74556u != null) {
                SmallScreenVideoController.this.f74556u.D1(n.e().f().f73091w, 1, n.e().f().O, false, r.h0().j1(SmallScreenVideoController.this.f74547l));
            }
            if (n.e().f().f73035i == 1) {
                n.e().f().c0(j3, false);
            }
            SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI2 != null) {
                smallScreenVideoLayerUI2.C1(0, 0, true);
            }
            if (n.e().f().H2) {
                SmallScreenVideoController.this.f74554s.v0(true, new Notification());
            } else if (SmallScreenVideoController.this.f74554s.isBackgroundStop) {
                r.h0().K3();
            }
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.d();
            }
            QavVideoRecordUICtrl.p0(r.h0());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(final String str, final boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI isQuit = " + z16 + ", mSessionType = " + SmallScreenVideoController.this.f74543h);
            }
            super.h(str, z16);
            VideoAppInterface videoAppInterface = SmallScreenVideoController.this.f74554s;
            if (videoAppInterface == null || videoAppInterface.M() == null) {
                return;
            }
            SmallScreenVideoController.this.f74554s.M().postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    SharedPreferences U0 = ea.U0(SmallScreenVideoController.this.f74538c);
                    if (U0.getBoolean("kick_out_self", false)) {
                        return;
                    }
                    SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                    int i3 = smallScreenVideoController.f74543h;
                    if (i3 == 1 || i3 == 2) {
                        String str4 = smallScreenVideoController.f74547l;
                        if (str4 != null && (str2 = str) != null && str4.equals(str2)) {
                            SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                            smallScreenVideoController2.f74551p = z16;
                            smallScreenVideoController2.k();
                        }
                        if (SmallScreenVideoController.this.f74556u != null) {
                            SharedPreferences.Editor edit = U0.edit();
                            edit.putInt("video_position", SmallScreenVideoController.this.f74556u.y0());
                            edit.commit();
                            return;
                        }
                        return;
                    }
                    if (i3 != 3 && i3 != 4) {
                        if (i3 == 0 && smallScreenVideoController.f74550o) {
                            int i16 = smallScreenVideoController.f74544i;
                            if (i16 == 1 || i16 == 2) {
                                smallScreenVideoController.f74551p = z16;
                                smallScreenVideoController.k();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SessionInfo f16 = (r.h0() == null || SmallScreenVideoController.this.f74541f) ? null : n.e().f();
                    String valueOf = f16 != null ? String.valueOf(f16.P0) : null;
                    if (valueOf == null || (str3 = str) == null || !valueOf.equals(str3)) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
                    }
                    SmallScreenVideoController smallScreenVideoController3 = SmallScreenVideoController.this;
                    smallScreenVideoController3.f74551p = z16;
                    smallScreenVideoController3.k();
                }
            }, 1500L);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void i(long j3, int i3) {
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onDetectNoDevicePermission, DeviceType[" + i3 + "], seq[" + j3 + "]");
            }
            if (i3 == 2 || i3 == 1) {
                ControlUIObserver controlUIObserver = SmallScreenVideoController.this.f74561z;
                if (controlUIObserver != null) {
                    controlUIObserver.update(null, new Object[]{106, Long.valueOf(j3)});
                }
                long longValue = Long.valueOf(SmallScreenVideoController.this.f74554s.getCurrentAccountUin()).longValue();
                int q16 = n.e().f().q(longValue, 1);
                if (q16 == -1) {
                    return;
                }
                n.e().f().f73045k1.remove(q16);
                synchronized (n.e().f().f73053m1) {
                    int p16 = n.e().f().p(longValue, 1);
                    if (p16 == -1) {
                        return;
                    }
                    n.e().f().f73053m1.remove(p16);
                }
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void k(String str, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "peerUin = " + str + " # isQuit :" + z16);
            }
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            int i3 = smallScreenVideoController.f74543h;
            if (i3 == 1 || i3 == 2) {
                String str2 = smallScreenVideoController.f74547l;
                if (str2 != null && str != null && str2.equals(str)) {
                    SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                    smallScreenVideoController2.f74551p = z16;
                    smallScreenVideoController2.k();
                }
                SmallScreenVideoController smallScreenVideoController3 = SmallScreenVideoController.this;
                if (smallScreenVideoController3.f74556u != null) {
                    SharedPreferences.Editor edit = ea.U0(smallScreenVideoController3.f74538c).edit();
                    edit.putInt("video_position", SmallScreenVideoController.this.f74556u.y0());
                    edit.commit();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void p(String str, String str2) {
            super.p(str, str2);
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.h(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void v(boolean z16) {
            super.v(z16);
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.i(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void z(String str, boolean z16, String str2, int i3) {
            ICameraManagerApi iCameraManagerApi;
            if (QLog.isColorLevel()) {
                QLog.i("SmallScreenVideoController", 2, "onNotifyPeerZplanAvatarSwitch enable: " + z16 + " backgroundId: " + str2);
            }
            if (i3 == 1) {
                return;
            }
            r.h0().l2(2);
            long d16 = com.tencent.av.utils.e.d();
            SmallScreenVideoController.this.i();
            if (SmallScreenVideoController.this.f74556u != null) {
                QLog.d("SmallScreenVideoController", 1, "onNotifyPeerZplanAvatarSwitch enable=" + z16 + " remoteHasVideo=" + n.e().f().O + " localHasVideo=" + n.e().f().N);
                if (!n.e().f().O && !n.e().f().N) {
                    if (z16) {
                        SmallScreenVideoController.this.f74556u.D1(n.e().f().f73091w, 1, true, false, r.h0().j1(SmallScreenVideoController.this.f74547l));
                        SmallScreenVideoController.this.f74556u.z1(n.e().f().f73091w, 1, SmallScreenVideoController.this.f74558w, false, false);
                    } else {
                        SmallScreenVideoController.this.f74554s.k0(new Object[]{15, Long.valueOf(com.tencent.av.utils.e.d())});
                    }
                }
                if (z16 && !n.e().f().f73098x2 && n.e().f().f73035i == 2 && (iCameraManagerApi = SmallScreenVideoController.this.f74557v) != null && iCameraManagerApi.isCameraOpened(d16)) {
                    QLog.d("SmallScreenVideoController", 2, "onNotifyPeerZplanAvatarSwitch request close camera");
                    SmallScreenVideoController.this.f74554s.k0(new Object[]{106, Long.valueOf(d16)});
                }
                if ((n.e().f().f73098x2 || n.e().f().f73102y2) && SmallScreenVideoController.this.f74556u.P0() && !z16) {
                    r.h0().M0(false, false);
                }
                n.e().f().x0(false, z16);
                SmallScreenVideoController.this.E(n.e().f(), true);
                if (z16 || n.e().f().f73102y2 || n.e().f().f73098x2) {
                    return;
                }
                SmallScreenVideoController.this.f74537b.I(com.tencent.av.utils.e.d());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class OnResumeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f74574d;

        OnResumeRunnable(long j3) {
            this.f74574d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlUIObserver controlUIObserver;
            if (r.h0() != null) {
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                if (smallScreenVideoController.f74541f || smallScreenVideoController.f74554s == null || n.e().f() == null) {
                    return;
                }
                if (n.e().f().G()) {
                    r.h0().r(n.e().f().f73091w, 226);
                    r.h0().j2(226);
                    int i3 = n.e().f().f73035i;
                    r.h0().q(n.e().f().f73091w, 21);
                    if (i3 == 1) {
                        n.e().f().p0(this.f74574d, "small.onResume.1", 3);
                    } else if (i3 == 2) {
                        n.e().f().p0(this.f74574d, "small.onResume.2", 4);
                    }
                    if (n.e().f().I()) {
                        n.e().f().f73067q = 1;
                    } else {
                        n.e().f().f73067q = 3000;
                    }
                    n.e().f().k0(this.f74574d, false);
                    n.e().f().Z("SmallScreen.onResume", 0);
                }
                if (n.e().f().O && n.e().f().T1 && n.e().f().V1 > 0) {
                    SmallScreenVideoController.this.g();
                }
                if (n.e().f().f73035i != 2 || (controlUIObserver = SmallScreenVideoController.this.f74561z) == null) {
                    return;
                }
                controlUIObserver.t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends com.tencent.av.ui.e {
        public c(Context context, int i3) {
            super(context, i3);
        }

        @Override // com.tencent.av.ui.e
        public void d(int i3, boolean z16) {
            int i16;
            try {
                i16 = ((SmallScreenVideoController.this.f74536a.getRotation() * 90) + i3) % 360;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenVideoController", 2, "onVideoOrientationChanged e = " + e16);
                }
                i16 = 0;
            }
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.v(i16);
            }
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.e1(i3, z16);
            }
            ICameraManagerApi iCameraManagerApi = SmallScreenVideoController.this.f74557v;
            if (iCameraManagerApi != null) {
                iCameraManagerApi.setRotation(i3);
            }
            SmallScreenVideoController.this.f74560y = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmallScreenVideoController(SmallScreenService smallScreenService) {
        this.f74536a = null;
        this.f74538c = null;
        this.f74537b = smallScreenService;
        this.f74538c = smallScreenService.getApplicationContext();
        this.f74536a = ((WindowManager) this.f74537b.getSystemService("window")).getDefaultDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(SessionInfo sessionInfo) {
        ax.j J0 = r.h0().J0();
        if (J0 == null) {
            return;
        }
        J0.m0(!sessionInfo.f73102y2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final SessionInfo sessionInfo, boolean z16) {
        SmallScreenVideoLayerUI smallScreenVideoLayerUI;
        i();
        if ((sessionInfo.f73098x2 || sessionInfo.f73102y2) && (smallScreenVideoLayerUI = this.f74556u) != null) {
            if (smallScreenVideoLayerUI.P0()) {
                return;
            }
            this.f74556u.g1(true);
            if (!z16 || this.f74556u.v0() == null) {
                return;
            }
            this.f74556u.v0().post(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SmallScreenVideoController.this.f74556u == null || r.h0() == null) {
                        return;
                    }
                    SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                    if (smallScreenVideoController.f74541f || smallScreenVideoController.f74556u.v0() == null) {
                        return;
                    }
                    r.h0().S0(SmallScreenVideoController.this.f74556u.v0());
                    SmallScreenVideoController.this.D(sessionInfo);
                }
            });
            return;
        }
        SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = this.f74556u;
        if (smallScreenVideoLayerUI2 == null || !smallScreenVideoLayerUI2.P0()) {
            return;
        }
        this.f74556u.g1(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        VideoAppInterface videoAppInterface = this.f74554s;
        if (videoAppInterface == null || videoAppInterface.M() == null) {
            return;
        }
        this.f74554s.M().postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.4
            @Override // java.lang.Runnable
            public void run() {
                if (SmallScreenVideoController.this.f74555t instanceof SmallScreenDoubleVideoControlUI) {
                    int i3 = n.e().f().U1;
                    VideoAppInterface videoAppInterface2 = SmallScreenVideoController.this.f74554s;
                    if (videoAppInterface2 != null) {
                        videoAppInterface2.k0(new Object[]{42, Integer.valueOf(i3)});
                    }
                }
                SmallScreenVideoController.this.A();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3) {
        long d16 = com.tencent.av.utils.e.d();
        if (com.tencent.av.utils.e.k()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("changeVideoLayoutMode, mode[");
            sb5.append(i3);
            sb5.append("], mVideoLayerUI[");
            sb5.append(this.f74556u != null);
            sb5.append("], seq[");
            sb5.append(d16);
            sb5.append("]");
            QLog.w("SmallScreenVideoController", 1, sb5.toString());
        }
        SmallScreenVideoLayerUI smallScreenVideoLayerUI = this.f74556u;
        if (smallScreenVideoLayerUI == null || i3 == smallScreenVideoLayerUI.u1()) {
            return;
        }
        if (i3 == 1) {
            n(6101, null, Boolean.FALSE);
        }
        this.f74556u.m0(i3);
        this.f74537b.I(d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f74537b.B(1) == null) {
            this.f74537b.R();
            View findViewById = this.f74537b.B(1).findViewById(R.id.rad);
            if (this.f74556u != null || this.f74554s == null) {
                return;
            }
            this.f74556u = new SmallScreenVideoLayerUI(this.f74554s, this.f74537b, findViewById, this);
        }
    }

    public static void j(Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo start");
        }
        if (context != null && r.h0() != null) {
            if (n.e().f().f73047l == 16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenVideoController", 2, "enterVideo on switching.");
                }
            } else if (MultiIncomingCallsActivity.isShowing()) {
                Intent intent = new Intent(context, (Class<?>) MultiIncomingCallsActivity.class);
                intent.addFlags(262144);
                intent.addFlags(268435456);
                intent.addFlags(4194304);
                try {
                    context.startActivity(intent);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + e16);
                    }
                }
            } else {
                m(context);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo context or controller is null.");
        }
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo end");
        }
    }

    private void l(SessionInfo sessionInfo) {
        int i3 = this.f74543h;
        if (i3 == 0) {
            if (sessionInfo == null || !sessionInfo.G) {
                return;
            }
            int i16 = sessionInfo.f73043k;
            if (i16 == 1 || i16 == 2) {
                this.f74555t = new SmallScreenDoubleVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (this.f74555t == null) {
                if (this.f74553r) {
                    this.f74555t = new SmallScreenMultiVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                    if (sessionInfo != null) {
                        this.f74543h = sessionInfo.f73035i;
                        this.f74544i = sessionInfo.f73039j;
                        return;
                    }
                    return;
                }
                this.f74555t = new SmallScreenDoubleVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if ((i3 == 3 || i3 == 4) && this.f74555t == null) {
                if (this.f74553r) {
                    this.f74555t = new SmallScreenMultiVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                    if (sessionInfo != null) {
                        this.f74543h = sessionInfo.f73035i;
                        this.f74544i = sessionInfo.f73039j;
                        return;
                    }
                    return;
                }
                if (n.e().f().f73063p == 2) {
                    this.f74555t = new SmallScreenMultiVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                    return;
                } else {
                    this.f74555t = new SmallScreenMultiVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
                    return;
                }
            }
            return;
        }
        if (this.f74553r) {
            this.f74555t = new SmallScreenMultiVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
            if (sessionInfo != null) {
                this.f74543h = sessionInfo.f73035i;
                this.f74544i = sessionInfo.f73039j;
                return;
            }
            return;
        }
        if (this.f74555t == null) {
            this.f74555t = new SmallScreenDoubleVideoControlUI(this.f74554s, this.f74537b, this.f74561z);
        }
    }

    void A() {
        Timer timer = this.f74540e;
        if (timer != null) {
            timer.cancel();
            this.f74540e = null;
        }
        this.f74540e = new BaseTimer();
        this.f74540e.schedule(new TimerTask() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SessionInfo f16;
                long j3;
                if (r.h0() != null) {
                    SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                    if (smallScreenVideoController.f74541f || smallScreenVideoController.f74556u == null || smallScreenVideoController.f74554s == null || (f16 = n.e().f()) == null) {
                        return;
                    }
                    String str = f16.f73091w;
                    if (f16.V1 <= 0) {
                        Timer timer2 = SmallScreenVideoController.this.f74540e;
                        if (timer2 != null) {
                            timer2.cancel();
                            SmallScreenVideoController.this.f74540e = null;
                            return;
                        }
                        return;
                    }
                    try {
                        j3 = SmallScreenVideoController.this.f74556u.x0(str);
                    } catch (Exception e16) {
                        QLog.e("SmallScreenVideoController", 1, "startGlassCheck getLastRenderTimestamp error: " + e16);
                        j3 = 0L;
                    }
                    QLog.d("SmallScreenVideoController", 1, "startGlassCheck lLastTick=" + j3);
                    final long currentTimeMillis = System.currentTimeMillis();
                    if (j3 == 0 || currentTimeMillis - j3 <= r1 * 1000) {
                        return;
                    }
                    SmallScreenVideoController.this.f74554s.runOnUiThread(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenVideoController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r.h0() != null) {
                                SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                                if (!smallScreenVideoController2.f74541f && smallScreenVideoController2.f74554s != null) {
                                    SessionInfo f17 = n.e().f();
                                    if (f17 != null) {
                                        QLog.d("SmallScreenVideoController", 1, "AsyncReadDoubleGlassConfig Timer lCurrent=" + currentTimeMillis + ", mCurrentVideoGlassWaitTime=" + f17.V1 + ", mCurrentDefaultTimeOutRule=" + f17.W1 + ", mCurrentVideoGlassSwitch=" + SmallScreenVideoController.this.f74539d);
                                        SmallScreenVideoController.this.z(f17.W1);
                                        return;
                                    }
                                    AVCoreLog.printErrorLog("SmallScreenVideoController", "AsyncReadDoubleGlassConfig Timer lCurrent=" + currentTimeMillis + ", sessionInfo is null, mCurrentVideoGlassSwitch=" + SmallScreenVideoController.this.f74539d);
                                    return;
                                }
                            }
                            AVCoreLog.printErrorLog("SmallScreenVideoController", "VideoController.getInstance() is null");
                        }
                    });
                }
            }
        }, 1000L);
    }

    void B() {
        com.tencent.av.ui.e eVar = this.f74559x;
        if (eVar != null) {
            eVar.enable();
        }
    }

    void C() {
        com.tencent.av.ui.e eVar = this.f74559x;
        if (eVar != null) {
            eVar.disable();
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoLayerUI.a
    public void a(int i3) {
        this.f74537b.X(i3);
    }

    void k() {
        SmallScreenService smallScreenService = this.f74537b;
        i A = smallScreenService == null ? null : smallScreenService.A(1);
        SmallScreenService smallScreenService2 = this.f74537b;
        SmallScreenRelativeLayout B = smallScreenService2 != null ? smallScreenService2.B(1) : null;
        if (this.f74551p && A != null && A.b() && B != null && B.getVisibility() != 8) {
            B.h();
            return;
        }
        SmallScreenService smallScreenService3 = this.f74537b;
        if (smallScreenService3 != null) {
            smallScreenService3.stopSelf();
        }
    }

    protected void n(Integer num, Object obj, Object obj2) {
        AVCoreLog.printColorLog("SmallScreenVideoController", "notifyEvent :" + num + "|" + obj + "|" + obj2);
        Object[] objArr = {num, obj, obj2};
        VideoAppInterface videoAppInterface = this.f74554s;
        if (videoAppInterface != null) {
            videoAppInterface.k0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "onClick start");
        }
        j(this.f74538c);
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "onClick end");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(AppRuntime appRuntime) {
        if (appRuntime instanceof VideoAppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onCreate");
            }
            VideoAppInterface videoAppInterface = (VideoAppInterface) appRuntime;
            this.f74554s = videoAppInterface;
            this.f74541f = false;
            videoAppInterface.addObserver(this.f74561z);
            this.f74554s.addObserver(this.B);
            this.f74554s.addObserver(this.D);
            r.h0().l0().sendGetGatewayMsg();
            y();
            if (!n.e().f().H()) {
                x();
            }
            NtrtcVideoRender.getInstance();
            q(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z16) {
        SmallScreenVideoLayerUI smallScreenVideoLayerUI;
        SessionInfo f16 = n.e().f();
        if (f16 != null && QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + f16.f73035i);
        }
        this.f74558w = ba.getBitmapFromResourceId(this.f74538c, R.drawable.d_0);
        if (this.f74557v == null) {
            ICameraManagerApi a16 = com.tencent.av.camera.b.a(this.f74538c);
            this.f74557v = a16;
            a16.addObserver(this.A);
            this.f74557v.setCameraListener(r.h0().I());
        }
        l(f16);
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.e(z16);
        }
        if (f16 != null && f16.f73043k != 4 && this.f74543h == 1 && !this.f74550o) {
            VideoAppInterface videoAppInterface = this.f74554s;
            int resIdByUin = VipFunCallUtil.getResIdByUin(videoAppInterface, videoAppInterface.getAccount(), 6, true, null);
            if (resIdByUin > 0) {
                String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(this.f74554s, resIdByUin, VipFunCallUtil.getResourceType(), null);
                if (resourcePathByUrl != null && new File(resourcePathByUrl).exists() && (smallScreenVideoLayerUI = this.f74556u) != null) {
                    smallScreenVideoLayerUI.G0();
                }
            }
        }
        SmallScreenRelativeLayout B = this.f74537b.B(1);
        if (B == null) {
            QLog.w("SmallScreenVideoController", 2, "onCreateUI videoToastView == null");
            return;
        }
        View findViewById = B.findViewById(R.id.rad);
        SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = this.f74556u;
        if (smallScreenVideoLayerUI2 == null) {
            this.f74556u = new SmallScreenVideoLayerUI(this.f74554s, this.f74537b, findViewById, this);
        } else {
            smallScreenVideoLayerUI2.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(long j3) {
        View findViewById;
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenVideoController", 1, "onDestroy, mActivityState[" + this.f74542g + "->0], seq[" + j3 + "]");
        }
        this.f74542g = 0;
        SmallScreenService smallScreenService = this.f74537b;
        SmallScreenRelativeLayout B = smallScreenService == null ? null : smallScreenService.B(1);
        if (B != null && (findViewById = B.findViewById(R.id.rbz)) != null) {
            findViewById.findViewById(R.id.f163663rc0).clearAnimation();
        }
        Timer timer = this.f74540e;
        if (timer != null) {
            timer.cancel();
            this.f74540e = null;
        }
        ICameraManagerApi iCameraManagerApi = this.f74557v;
        if (iCameraManagerApi != null) {
            iCameraManagerApi.deleteObserver(this.A);
            this.f74557v = null;
        }
        SmallScreenVideoLayerUI smallScreenVideoLayerUI = this.f74556u;
        if (smallScreenVideoLayerUI != null) {
            smallScreenVideoLayerUI.V0();
            this.f74556u = null;
        }
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.f(j3);
            this.f74555t = null;
        }
        VideoAppInterface videoAppInterface = this.f74554s;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.D);
            this.f74554s.deleteObserver(this.f74561z);
            this.f74554s.deleteObserver(this.B);
            n.e().f().u0("SmallScreen.onDestroy", 0);
        }
        this.f74541f = true;
        this.f74554s = null;
        this.f74559x = null;
        this.f74561z = null;
        this.D = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (this.f74551p) {
            this.f74537b.stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        C();
        this.f74542g = 4;
        SmallScreenVideoLayerUI smallScreenVideoLayerUI = this.f74556u;
        if (smallScreenVideoLayerUI != null) {
            smallScreenVideoLayerUI.W0();
        }
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.k();
        }
        r.h0().L2(true);
    }

    public void v() {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + currentTimeMillis);
        }
        this.f74542g = 3;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "onStart");
        }
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.r();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + currentTimeMillis2);
            QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
        }
    }

    void x() {
        this.f74543h = n.e().f().f73035i;
        this.f74544i = n.e().f().f73039j;
        this.f74553r = n.e().f().f73060o0;
        this.f74545j = n.e().f().f73067q;
        this.f74547l = n.e().f().f73091w;
        this.f74546k = n.e().f().B0;
        this.f74549n = n.e().f().D0;
        this.f74548m = n.e().f().f73103z;
        this.f74550o = n.e().f().G;
    }

    void y() {
        if (this.f74559x == null) {
            this.f74559x = new c(this.f74538c, 2);
        }
    }

    public boolean z(int i3) {
        SmallScreenVideoControlUI smallScreenVideoControlUI;
        if (!n.e().f().T1 || this.f74539d == i3 || (smallScreenVideoControlUI = this.f74555t) == null || !(smallScreenVideoControlUI instanceof SmallScreenDoubleVideoControlUI)) {
            return false;
        }
        if (!n.e().f().O) {
            AVCoreLog.printErrorLog("SmallScreenVideoController", "Remote not has video, nOff=" + i3);
            return false;
        }
        QLog.d("SmallScreenVideoController", 1, "setGlassSwitch nOff=" + i3 + ", prior=" + this.f74539d);
        this.f74539d = i3;
        n.e().f().U1 = i3;
        if (i3 == 0) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.r0();
            }
            r.h0().W2(0);
        } else if (i3 == 1) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = this.f74556u;
            if (smallScreenVideoLayerUI2 != null) {
                smallScreenVideoLayerUI2.s0();
            }
            r.h0().W2(0);
        } else if (i3 == 2) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI3 = this.f74556u;
            if (smallScreenVideoLayerUI3 != null) {
                smallScreenVideoLayerUI3.r0();
            }
            r.h0().W2(1);
        } else if (i3 == 3) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI4 = this.f74556u;
            if (smallScreenVideoLayerUI4 != null) {
                smallScreenVideoLayerUI4.s0();
            }
            r.h0().W2(1);
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends ControlUIObserver {
        b() {
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void I(long j3) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.B1(false, false);
                SmallScreenVideoController.this.h(1);
            }
            if (SmallScreenVideoController.this.f74557v != null) {
                if (r.h0() != null && !SmallScreenVideoController.this.f74541f) {
                    SessionInfo f16 = n.e().f();
                    f16.U2 = f16.f73030h;
                }
                SmallScreenVideoController.this.f74557v.closeCamera(j3, true);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void O(boolean z16, long j3) {
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            if (smallScreenVideoController.f74542g == 2) {
                return;
            }
            if (smallScreenVideoController.f74557v != null && !smallScreenVideoController.f74554s.b0()) {
                SmallScreenVideoController.this.f74557v.openCamera(j3);
            }
            SmallScreenVideoController.this.i();
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.B1(true, z16);
                ICameraManagerApi iCameraManagerApi = SmallScreenVideoController.this.f74557v;
                SmallScreenVideoController.this.f74556u.U0(j3, iCameraManagerApi != null && iCameraManagerApi.isFrontCamera());
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void f() {
            SmallScreenService smallScreenService = SmallScreenVideoController.this.f74537b;
            SmallScreenRelativeLayout B = smallScreenService == null ? null : smallScreenService.B(1);
            if (B != null) {
                DoodleUtils.a(B);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void i(ArrayList<com.tencent.av.gaudio.c> arrayList) {
            if (SmallScreenVideoController.this.f74556u == null || arrayList == null) {
                return;
            }
            String I0 = r.h0().I0(arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + I0);
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.tencent.av.gaudio.c cVar = arrayList.get(i3);
                String valueOf = String.valueOf(cVar.f73827a);
                boolean z16 = cVar.f73829c;
                int i16 = cVar.f73828b;
                if (!valueOf.equals(SmallScreenVideoController.this.f74554s.getCurrentAccountUin())) {
                    if (SmallScreenVideoController.this.f74556u.L0(valueOf, i16)) {
                        cw.e.d(SmallScreenVideoController.this.f74554s, 1036);
                        cw.e.d(SmallScreenVideoController.this.f74554s, 1037);
                    }
                    SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
                    long j3 = cVar.f73833g;
                    smallScreenVideoLayerUI.D1(valueOf, i16, false, z16, j3 == 5 || j3 == 14);
                }
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void j() {
            if (r.h0().d1()) {
                r.h0().f3(false);
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                smallScreenVideoController.f74551p = true;
                smallScreenVideoController.k();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.ui.ControlUIObserver
        public void k(long j3) {
            if (r.h0() != null) {
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                if (!smallScreenVideoController.f74541f && smallScreenVideoController.f74554s != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + SmallScreenVideoController.this.f74554s.isBackgroundStop + "], seq[" + j3 + "]");
                    }
                    SmallScreenVideoController.this.h(1);
                    SessionInfo f16 = n.e().f();
                    if (f16.f73047l == 11) {
                        return;
                    }
                    SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
                    if (smallScreenVideoLayerUI != null) {
                        smallScreenVideoLayerUI.D1(f16.f73091w, 1, false, false, false);
                    }
                    SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
                    if (smallScreenVideoControlUI != null) {
                        smallScreenVideoControlUI.f(j3);
                        SmallScreenVideoController.this.f74555t = null;
                    }
                    SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                    smallScreenVideoController2.f74553r = false;
                    smallScreenVideoController2.f74543h = f16.f73035i;
                    smallScreenVideoController2.f74544i = f16.f73039j;
                    if (!AVCoreSystemInfo.isNormalSharp()) {
                        SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = SmallScreenVideoController.this.f74556u;
                        if (smallScreenVideoLayerUI2 != null) {
                            smallScreenVideoLayerUI2.B1(false, false);
                        }
                        f16.c0(j3, false);
                    }
                    SmallScreenVideoController.this.q(true);
                    SmallScreenVideoControlUI smallScreenVideoControlUI2 = SmallScreenVideoController.this.f74555t;
                    if (smallScreenVideoControlUI2 != null) {
                        smallScreenVideoControlUI2.r();
                        SmallScreenVideoController smallScreenVideoController3 = SmallScreenVideoController.this;
                        if (smallScreenVideoController3.f74542g != 2) {
                            smallScreenVideoController3.f74555t.o();
                        }
                    }
                    String str = f16.f73091w;
                    if (str == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
                            return;
                        }
                        return;
                    }
                    f16.Z0 = Long.valueOf(str).longValue();
                    long j16 = f16.P0;
                    if (f16.f73067q == 3000) {
                        f16.Q0 = SmallScreenVideoController.this.f74554s.E(String.valueOf(j16));
                    }
                    f16.u0("onChangeUI_DobuleAudio2MultiAudio", 0);
                    r.h0().q3(false);
                    r.h0().r3(false);
                    SmallScreenVideoController smallScreenVideoController4 = SmallScreenVideoController.this;
                    smallScreenVideoController4.f74545j = f16.f73067q;
                    if (smallScreenVideoController4.f74543h == 4) {
                        r.h0().P2(j3, SmallScreenVideoController.this.f74543h, false, false);
                    }
                    String str2 = r.h0().J(n.e().f().f73091w) + "";
                    MagicDataReport.i(SmallScreenVideoController.this.f74554s, str2);
                    MagicDataReport.m(2, str2);
                    MagicDataReport.l(2);
                    return;
                }
            }
            QLog.e("SmallScreenVideoController", 1, "onChangeUI_DobuleAudio2MultiAudio error . mIsDestroyed=" + SmallScreenVideoController.this.f74541f);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void q(long j3) {
            if (r.h0() != null) {
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                if (!smallScreenVideoController.f74541f && smallScreenVideoController.f74554s != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting, isBackground_Stop[" + SmallScreenVideoController.this.f74554s.isBackgroundStop + "], seq[" + j3 + "], session[" + n.e().f() + "]");
                    }
                    SmallScreenVideoController.this.h(1);
                    SessionInfo f16 = n.e().f();
                    if (f16.f73047l == 16) {
                        return;
                    }
                    SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
                    if (smallScreenVideoLayerUI != null) {
                        smallScreenVideoLayerUI.D1(f16.f73091w, 1, false, false, false);
                    }
                    SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
                    if (smallScreenVideoControlUI != null) {
                        smallScreenVideoControlUI.f(j3);
                        SmallScreenVideoController.this.f74555t = null;
                    }
                    f16.y0("onChangeUI_Normal2Meeting", true);
                    SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                    smallScreenVideoController2.f74553r = true;
                    smallScreenVideoController2.f74543h = 1;
                    smallScreenVideoController2.f74544i = f16.f73039j;
                    if (!AVCoreSystemInfo.isNormalSharp()) {
                        SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = SmallScreenVideoController.this.f74556u;
                        if (smallScreenVideoLayerUI2 != null) {
                            smallScreenVideoLayerUI2.B1(false, false);
                        }
                        f16.c0(j3, false);
                    }
                    if (SmallScreenVideoController.this.f74537b.B(1) == null) {
                        SmallScreenVideoController.this.f74537b.R();
                    }
                    SmallScreenVideoController.this.q(true);
                    SmallScreenVideoControlUI smallScreenVideoControlUI2 = SmallScreenVideoController.this.f74555t;
                    if (smallScreenVideoControlUI2 != null) {
                        smallScreenVideoControlUI2.r();
                        SmallScreenVideoController smallScreenVideoController3 = SmallScreenVideoController.this;
                        if (smallScreenVideoController3.f74542g != 2) {
                            smallScreenVideoController3.f74555t.o();
                        }
                    }
                    if (f16.f73091w == null) {
                        if (QLog.isColorLevel()) {
                            QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
                            return;
                        }
                        return;
                    } else {
                        f16.s0("SmallScreen.onChangeUI_Normal2Meeting", false);
                        SmallScreenVideoController.this.f74545j = 0;
                        r.h0().P2(j3, SmallScreenVideoController.this.f74543h, false, true);
                        SmallScreenVideoController.this.h(4);
                        return;
                    }
                }
            }
            QLog.e("SmallScreenVideoController", 1, "onChangeUI_Normal2Meeting error . mIsDestroyed=" + SmallScreenVideoController.this.f74541f);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.av.ui.ControlUIObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void t() {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
            }
            SmallScreenService smallScreenService = SmallScreenVideoController.this.f74537b;
            SmallScreenRelativeLayout B = smallScreenService == null ? null : smallScreenService.B(1);
            if (SmallScreenVideoController.this.f74537b == null || r.h0() == null) {
                return;
            }
            SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
            if (smallScreenVideoController.f74541f || B == null || smallScreenVideoController.f74554s == null) {
                return;
            }
            View findViewById = B.findViewById(R.id.rbz);
            if (findViewById == null) {
                QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
                return;
            }
            findViewById.clearAnimation();
            if (!n.e().f().f73003a3 && !n.e().f().Y2) {
                findViewById.setVisibility(8);
                return;
            }
            boolean z16 = false;
            findViewById.setVisibility(0);
            QavVideoRecordUICtrl.d dVar = new QavVideoRecordUICtrl.d();
            dVar.setDuration(1000L);
            dVar.setRepeatCount(-1);
            findViewById.findViewById(R.id.f163663rc0).startAnimation(dVar);
            if (n.e().f().Y2 && n.e().f().f73003a3) {
                ((TextView) findViewById.findViewById(R.id.f163664rc1)).setText(R.string.dhs);
            } else {
                if (n.e().f().Y2) {
                    ((TextView) findViewById.findViewById(R.id.f163664rc1)).setText(R.string.dht);
                    if (z16) {
                        return;
                    }
                    String str = Build.MANUFACTURER;
                    String model = DeviceInfoMonitor.getModel();
                    if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str) && "MI MAX".equalsIgnoreCase(model)) {
                        ((TextView) findViewById.findViewById(R.id.f163664rc1)).setTextSize(1, 8.0f);
                        return;
                    }
                    return;
                }
                ((TextView) findViewById.findViewById(R.id.f163664rc1)).setText(R.string.dhr);
            }
            z16 = true;
            if (z16) {
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void u() {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
            if (smallScreenVideoLayerUI != null) {
                smallScreenVideoLayerUI.C1(0, 0, true);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0133, code lost:
        
            if (r3 != 8) goto L41;
         */
        @Override // com.tencent.av.ui.ControlUIObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void z(String str, String str2) {
            int i3;
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "Qav.Record, onChangeUi_ReceiveRecordMsg, from=" + str + ", data=" + str2);
            }
            if (r.h0() != null) {
                SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                if (smallScreenVideoController.f74541f || smallScreenVideoController.f74554s == null) {
                    return;
                }
                try {
                    i3 = Integer.parseInt(str2);
                } catch (NumberFormatException e16) {
                    QLog.d("SmallScreenVideoController", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + e16.getMessage());
                    i3 = -1;
                }
                if (i3 == -1) {
                    QLog.d("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + str2);
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    if ("SUPPORT_TRUE".equals(str2)) {
                        n.e().f().X2 = true;
                        n.e().f().W2 = Math.max(n.e().f().W2, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
                    } else if (str2.startsWith("SUPPORT_TRUE_7.3.5")) {
                        n.e().f().X2 = true;
                        n.e().f().W2 = Math.max(n.e().f().W2, com.tencent.luggage.wxa.ci.b.CTRL_INDEX);
                        int a16 = com.tencent.av.ui.funchat.record.h.a(str2, com.tencent.av.ui.funchat.record.e.a().f75877i);
                        QLog.i("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + a16);
                        n.e().f().Z2 = ((long) (a16 * 60)) * 1000;
                    }
                }
                int i16 = n.e().f().f73035i;
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenVideoController", 2, "onChangeUi_ReceiveRecordMsg, session type=" + i16);
                }
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 == 5) {
                            r.h0().s2(8, String.valueOf(6));
                        }
                    }
                    r.h0().s2(8, String.valueOf(4));
                    n.e().f().f73003a3 = false;
                } else {
                    r.h0().s2(8, String.valueOf(2));
                    r.h0().U1();
                    n.e().f().f73003a3 = true;
                }
                t();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void y(String str) {
            if (str == null || !str.equals("1") || n.e().f().O0) {
                return;
            }
            n.e().f().a0(true);
            SmallScreenVideoController.this.h(2);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x018b A[SYNTHETIC] */
        @Override // com.tencent.av.ui.ControlUIObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void Q(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, boolean z16) {
            boolean z17;
            SmallScreenVideoController.this.i();
            if (SmallScreenVideoController.this.f74556u != null && arrayList != null) {
                String I0 = r.h0().I0(arrayList);
                int H0 = r.h0().H0();
                if (QLog.isColorLevel()) {
                    QLog.w("SmallScreenVideoController", 1, "onRequest_ShowVideo, seq[" + j3 + "], infoLogs[" + I0 + "]");
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.tencent.av.gaudio.c cVar = arrayList.get(i3);
                    String valueOf = String.valueOf(cVar.f73827a);
                    int i16 = cVar.f73828b;
                    boolean z18 = cVar.f73829c;
                    SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                    int i17 = smallScreenVideoController.f74545j;
                    String G = smallScreenVideoController.f74554s.G(i17 == 3000 ? 1004 : i17 == 1 ? 1000 : i17 == 0 ? 0 : -1, valueOf, String.valueOf(n.e().f().P0));
                    if (cVar.f73830d && !r.h0().F()) {
                        if (!valueOf.equals(SmallScreenVideoController.this.f74554s.getCurrentAccountUin())) {
                            SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
                            long j16 = cVar.f73833g;
                            smallScreenVideoLayerUI.D1(valueOf, i16, true, z18, j16 == 5 || j16 == 14);
                        } else {
                            SmallScreenVideoController.this.f74557v.openCamera(j3);
                            SmallScreenVideoController.this.f74556u.B1(true, z18);
                            z17 = true;
                            if (!z17) {
                                if (!cVar.f73830d && !cVar.f73829c && H0 != 4) {
                                    if (n.e().f().S0 == 2) {
                                        ReportController.o(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
                                    } else {
                                        ReportController.o(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
                                    }
                                }
                                SmallScreenVideoController smallScreenVideoController2 = SmallScreenVideoController.this;
                                smallScreenVideoController2.f74556u.z1(valueOf, i16, smallScreenVideoController2.f74558w, cVar.f73830d, cVar.f73829c);
                            }
                            if (n.e().f().f73060o0) {
                                float dp2px = ba.dp2px(SmallScreenVideoController.this.f74538c, 12.0f);
                                if (!valueOf.equals(SmallScreenVideoController.this.f74554s.getCurrentAccountUin())) {
                                    SmallScreenVideoController.this.f74556u.E1(valueOf, i16, G, dp2px, -1);
                                }
                                SmallScreenVideoController.this.f74556u.j1(valueOf, i16);
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                    if (n.e().f().f73060o0) {
                    }
                }
                SmallScreenVideoController smallScreenVideoController3 = SmallScreenVideoController.this;
                SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = smallScreenVideoController3.f74556u;
                int i18 = smallScreenVideoController3.f74560y;
                com.tencent.av.ui.e eVar = smallScreenVideoController3.f74559x;
                smallScreenVideoLayerUI2.e1(i18, eVar == null ? true : eVar.f75527c);
                if (z16) {
                    SmallScreenVideoController.this.f74556u.T0(true);
                }
            }
            SmallScreenVideoController smallScreenVideoController4 = SmallScreenVideoController.this;
            int rotation = (smallScreenVideoController4.f74560y + (smallScreenVideoController4.f74536a.getRotation() * 90)) % 360;
            SmallScreenVideoControlUI smallScreenVideoControlUI = SmallScreenVideoController.this.f74555t;
            if (smallScreenVideoControlUI != null) {
                smallScreenVideoControlUI.v(rotation);
            }
            SmallScreenVideoController smallScreenVideoController5 = SmallScreenVideoController.this;
            ICameraManagerApi iCameraManagerApi = smallScreenVideoController5.f74557v;
            if (iCameraManagerApi != null) {
                iCameraManagerApi.setRotation(smallScreenVideoController5.f74560y);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void m(String str, int i3, String str2, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f74542g = 2;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, DKHippyEvent.EVENT_STOP);
        }
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.s();
        }
    }

    private static void m(Context context) {
        Intent intent;
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo sessionType =" + i3);
        }
        if (i3 != 1 && i3 != 2) {
            long j3 = f16.P0;
            int i16 = f16.S0;
            long j16 = 0;
            if (j3 != 0) {
                if (f16.u()) {
                    try {
                        j16 = Long.parseLong(f16.Y0);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    intent = new Intent(context, (Class<?>) GaInviteLockActivity.class);
                    ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).setIntentFrom(intent, "SmallScreenInvite");
                    intent.addFlags(268435456);
                    intent.putExtra("uinType", f16.f73067q);
                    intent.putExtra("peerUin", f16.Y0);
                    intent.putExtra("friendUin", j16);
                    intent.putExtra("relationType", f16.S0);
                    intent.putExtra("MultiAVType", f16.f73063p);
                    intent.putExtra("discussId", f16.P0);
                    intent.putExtra("memberList", f16.Q0);
                    intent.putExtra("isDoubleVideoMeeting", f16.f73060o0);
                    intent.putExtra(ServiceConst.PARA_SESSION_ID, f16.f73030h);
                } else {
                    Intent intent2 = new Intent(context, (Class<?>) AVActivity.class);
                    intent2.addFlags(262144);
                    intent2.addFlags(268435456);
                    intent2.addFlags(4194304);
                    intent2.putExtra("GroupId", String.valueOf(j3));
                    intent2.putExtra("Type", 2);
                    intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
                    intent2.putExtra("uinType", ba.avRelationType2UinType(i16));
                    intent2.putExtra("isDoubleVideoMeeting", f16.f73060o0);
                    intent2.putExtra("MultiAVType", f16.f73063p);
                    intent2.putExtra("Fromwhere", "SmallScreen");
                    intent = intent2;
                }
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + e16);
                        return;
                    }
                    return;
                }
            }
            if (r.h0().h() && f16.C()) {
                Intent intent3 = new Intent(context, (Class<?>) VideoInviteActivity.class);
                intent3.addFlags(268435456);
                intent3.putExtra("uinType", f16.f73067q);
                intent3.putExtra("peerUin", f16.f73091w);
                intent3.putExtra("extraUin", f16.f73103z);
                intent3.putExtra("isAudioMode", f16.f73039j == 1 || f16.f73060o0);
                intent3.putExtra("inviteScene", f16.f73004b0);
                intent3.putExtra("Fromwhere", "SmallScreen");
                intent3.putExtra("isDoubleVideoMeeting", f16.f73060o0);
                context.startActivity(intent3);
                QLog.d("SmallScreenVideoController", 2, "enterVideo startActivity VideoInviteActivity");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
                return;
            }
            return;
        }
        Intent intent4 = new Intent(context, (Class<?>) AVActivity.class);
        if (f16.f73067q == 1011) {
            return;
        }
        intent4.addFlags(262144);
        intent4.addFlags(268435456);
        intent4.addFlags(4194304);
        intent4.putExtra("Fromwhere", "SmallScreen");
        if (f16.f73060o0) {
            f16.f73067q = 0;
            intent4.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, f16.f73035i);
            intent4.putExtra("GroupId", f16.f73091w);
            intent4.putExtra("uin", f16.f73091w);
            intent4.putExtra("isDoubleVideoMeeting", true);
            intent4.putExtra("uinType", f16.f73067q);
            try {
                context.startActivity(intent4);
                return;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + e17);
                    return;
                }
                return;
            }
        }
        intent4.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
        intent4.putExtra("uin", f16.f73091w);
        try {
            context.startActivity(intent4);
        } catch (Exception e18) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + e18);
            }
        }
    }

    public void u() {
        SmallScreenVideoLayerUI smallScreenVideoLayerUI;
        long currentTimeMillis = System.currentTimeMillis();
        this.C = false;
        this.f74542g = 5;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenVideoController", 1, "onResume, seq[" + d16 + "] sessionType=" + n.e().f().f73035i);
        }
        this.f74554s.M().postDelayed(new OnResumeRunnable(d16), 200L);
        if (n.e().f().f73035i == 2) {
            i();
            boolean z16 = this.f74557v.isCameraOpening(d16) || this.f74557v.isCameraOpened(d16);
            if (n.e().f().z()) {
                String str = n.e().f().f73091w;
                boolean z17 = n.e().f().O || n.e().f().f73102y2;
                SmallScreenVideoLayerUI smallScreenVideoLayerUI2 = this.f74556u;
                if (smallScreenVideoLayerUI2 != null) {
                    smallScreenVideoLayerUI2.D1(str, 1, z17, false, r.h0().j1(this.f74547l));
                }
                if (n.e().f().N && !this.f74554s.b0()) {
                    if (!z16) {
                        this.f74557v.openCamera(d16);
                    }
                    SmallScreenVideoLayerUI smallScreenVideoLayerUI3 = this.f74556u;
                    if (smallScreenVideoLayerUI3 != null) {
                        smallScreenVideoLayerUI3.B1(true, false);
                        this.f74556u.U0(d16, this.f74557v.isFrontCamera());
                    }
                }
            } else if (!n.e().f().f73081t1 && !this.f74552q) {
                n.e().f().c0(d16, true);
                if (!z16) {
                    this.f74557v.openCamera(d16);
                }
                SmallScreenVideoLayerUI smallScreenVideoLayerUI4 = this.f74556u;
                if (smallScreenVideoLayerUI4 != null) {
                    smallScreenVideoLayerUI4.B1(true, false);
                    this.f74556u.U0(d16, this.f74557v.isFrontCamera());
                }
            }
        } else if (n.e().f().f73035i == 4) {
            ArrayList<com.tencent.av.gaudio.c> arrayList = n.e().f().f73045k1;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.tencent.av.gaudio.c cVar = arrayList.get(i3);
                String valueOf = String.valueOf(cVar.f73827a);
                int i16 = cVar.f73828b;
                boolean z18 = cVar.f73829c;
                boolean z19 = cVar.f73830d;
                long j3 = cVar.f73833g;
                boolean z26 = j3 == 5 || j3 == 14;
                if (!valueOf.equals(this.f74554s.getCurrentAccountUin()) && z19 && (smallScreenVideoLayerUI = this.f74556u) != null) {
                    smallScreenVideoLayerUI.D1(valueOf, i16, z19, z18, z26);
                }
            }
        }
        SmallScreenVideoLayerUI smallScreenVideoLayerUI5 = this.f74556u;
        if (smallScreenVideoLayerUI5 != null) {
            smallScreenVideoLayerUI5.X0();
        }
        SmallScreenVideoControlUI smallScreenVideoControlUI = this.f74555t;
        if (smallScreenVideoControlUI != null) {
            smallScreenVideoControlUI.o();
        }
        r.h0().L2(false);
        B();
        if (r.h0().J0() != null) {
            r.h0().J0().f0();
        }
        E(n.e().f(), true);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + currentTimeMillis2);
            QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends CameraObserver {
        a() {
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void b(long j3, boolean z16) {
            SmallScreenVideoLayerUI smallScreenVideoLayerUI;
            if (r.h0() == null || SmallScreenVideoController.this.f74541f || n.e().f().f73067q != 1011 || (smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u) == null) {
                return;
            }
            smallScreenVideoLayerUI.B1(false, false);
            SmallScreenVideoController.this.f74556u.y1();
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void c(long j3, boolean z16, int i3) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenVideoController", 1, "onAfterOpenCamera, success[" + z16 + "], preSessionType[" + i3 + "], seq[" + j3 + "]");
            }
            if (z16) {
                if (SmallScreenVideoController.this.f74554s == null || !SmallScreenUtils.w()) {
                    return;
                }
                if (i3 == 1 || i3 == 3) {
                    SmallScreenVideoController.this.i();
                    SmallScreenVideoLayerUI smallScreenVideoLayerUI = SmallScreenVideoController.this.f74556u;
                    if (smallScreenVideoLayerUI != null) {
                        smallScreenVideoLayerUI.B1(true, false);
                        SmallScreenVideoController smallScreenVideoController = SmallScreenVideoController.this;
                        smallScreenVideoController.f74556u.U0(j3, smallScreenVideoController.f74557v.isFrontCamera());
                        return;
                    }
                    return;
                }
                return;
            }
            if (r.h0() != null && !SmallScreenVideoController.this.f74541f && n.e().f() != null) {
                if (n.e().f().F()) {
                    str = "0X8004894";
                } else if (n.e().f().f73039j == 1) {
                    str = "0X8004888";
                } else if (n.e().f().f73039j == 2) {
                    str = "0X800488E";
                } else {
                    str = "";
                }
                String str2 = str;
                ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
            }
            VideoAppInterface videoAppInterface = SmallScreenVideoController.this.f74554s;
            if (videoAppInterface != null) {
                videoAppInterface.k0(new Object[]{38, 2, Long.valueOf(j3)});
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void e(boolean z16) {
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void i() {
        }
    }
}
