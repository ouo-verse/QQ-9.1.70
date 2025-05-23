package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import android.text.TextUtils;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.g;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.e;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.util.AVConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.WnsNetworkConst;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScreenShareCtrl {

    /* renamed from: i, reason: collision with root package name */
    private static final List<String> f74253i = Arrays.asList("M2011K2C", "PHZ110");

    /* renamed from: a, reason: collision with root package name */
    private c f74254a = null;

    /* renamed from: b, reason: collision with root package name */
    private ShareOpsTimeOutTask f74255b = null;

    /* renamed from: c, reason: collision with root package name */
    private final RecordParam f74256c = new RecordParam();

    /* renamed from: d, reason: collision with root package name */
    private int f74257d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f74258e = 0;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<AVActivity> f74259f = null;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f74260g = null;

    /* renamed from: h, reason: collision with root package name */
    private DoubleMeetingInviteTimeOutTask f74261h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DoubleMeetingInviteTimeOutTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final SessionInfo f74264d;

        public DoubleMeetingInviteTimeOutTask(@NotNull SessionInfo sessionInfo) {
            this.f74264d = sessionInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            long d16 = e.d();
            if (r.h0() != null && this.f74264d.f73043k == 9) {
                if (VideoAppInterface.N().r() > 0) {
                    VideoAppInterface.N().k0(new Object[]{404, Long.valueOf(d16), Long.valueOf(this.f74264d.P0)});
                } else if (VideoAppInterface.N().isBackgroundStop) {
                    r.h0().Y1(d16, this.f74264d.P0, true, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ShareOpsTimeOutTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final SessionInfo f74265d;

        /* renamed from: e, reason: collision with root package name */
        private final int f74266e;

        /* renamed from: f, reason: collision with root package name */
        private final int f74267f;

        public ShareOpsTimeOutTask(SessionInfo sessionInfo, int i3, int i16) {
            this.f74265d = sessionInfo;
            this.f74266e = i3;
            this.f74267f = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            SessionInfo sessionInfo;
            int i3;
            int i16;
            if (r.h0() != null && (sessionInfo = this.f74265d) != null) {
                if (this.f74266e == 1) {
                    i3 = 86;
                } else {
                    i3 = 89;
                }
                int i17 = i3;
                if (sessionInfo.N) {
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(AVConstants.SHARE_TAG, 2, "ShareOpsTimeOutTask, actionResult[" + i17 + "], session[" + this.f74265d + "], multiAVSubType[" + i16 + "]");
                }
                r h06 = r.h0();
                int i18 = this.f74267f;
                SessionInfo sessionInfo2 = this.f74265d;
                h06.O1(i17, i18, sessionInfo2.S0, sessionInfo2.P0, sessionInfo2.f73063p, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AVActivity f74268d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f74269e;

        a(AVActivity aVActivity, long j3) {
            this.f74268d = aVActivity;
            this.f74269e = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ScreenRecordHelper d36;
            QLog.d(AVConstants.SHARE_TAG, 2, "startOrStopScreenShare, onClick");
            ScreenShareCtrl.this.p(2);
            AVActivity aVActivity = this.f74268d;
            if (aVActivity == null) {
                d36 = null;
            } else {
                d36 = aVActivity.d3();
            }
            if (d36 != null) {
                d36.y(1);
            }
            VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(this.f74269e)});
            SessionInfo f16 = n.e().f();
            TraeHelper.I().k0(this.f74269e);
            f16.H = false;
            f16.A0 = 1;
            f16.X = true;
            String str = f16.f73091w;
            r.h0().Z1();
            r.h0().r(str, 237);
            r.h0().j2(237);
            r.h0().q(str, f16.A0);
            f16.d0("onClick_HangeUP", false);
            f16.q0("onClick_HangeUP", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends MediaProjection.Callback {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            ScreenRecordHelper screenRecordHelper;
            super.onStop();
            if (ScreenShareCtrl.this.g()) {
                QLog.e(AVConstants.SHARE_TAG, 1, "[MediaProjection.Callback] blackList:M2011K2C onStop.");
                return;
            }
            int i3 = n.e().f().f73046k2;
            if (i3 == 2 || i3 == 1) {
                int p16 = ScreenShareCtrl.this.p(2);
                ScreenShareCtrl.s(9);
                if (ScreenShareCtrl.this.f74259f != null && ScreenShareCtrl.this.f74259f.get() != 0) {
                    screenRecordHelper = ((AVActivity) ScreenShareCtrl.this.f74259f.get()).d3();
                } else {
                    screenRecordHelper = null;
                }
                if (screenRecordHelper == null) {
                    screenRecordHelper = r.h0().x0();
                }
                QLog.d(AVConstants.SHARE_TAG, 1, "[MediaProjection.Callback] onStop ret=" + p16 + " recordHelper=" + screenRecordHelper);
                if (screenRecordHelper != null) {
                    screenRecordHelper.y(1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c implements g.b, ScreenRecordHelper.b {

        /* renamed from: a, reason: collision with root package name */
        private final d f74272a = new d();

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<ScreenShareCtrl> f74273b;

        public c(ScreenShareCtrl screenShareCtrl) {
            this.f74273b = new WeakReference<>(screenShareCtrl);
        }

        @Override // com.tencent.av.ui.ScreenRecordHelper.b
        @TargetApi(21)
        public void a(RecordParam recordParam, int i3, int i16) {
            ScreenShareCtrl screenShareCtrl = this.f74273b.get();
            if (screenShareCtrl == null) {
                return;
            }
            screenShareCtrl.q(recordParam, i3, i16);
            if (screenShareCtrl.p(1) == 1) {
                ScreenShareCtrl.s(4);
                return;
            }
            ScreenShareCtrl.s(6);
            ScreenRecordHelper x06 = r.h0().x0();
            if (x06 != null) {
                x06.y(1);
            }
        }

        @Override // com.tencent.av.opengl.effects.g.b
        public void b(Bitmap bitmap, RecordParam recordParam) {
            ScreenShareCtrl screenShareCtrl = this.f74273b.get();
            if (screenShareCtrl != null) {
                screenShareCtrl.j(bitmap, recordParam);
            }
        }

        @Override // com.tencent.av.ui.ScreenRecordHelper.b
        @TargetApi(21)
        public void c(int i3) {
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.i(AVConstants.SHARE_TAG, 2, "onMediaProjectionEnd fromType:=" + i3);
            }
            ScreenShareCtrl screenShareCtrl = this.f74273b.get();
            if (screenShareCtrl != null && i3 == 2) {
                if (screenShareCtrl.p(2) != 1) {
                    i16 = 3;
                }
                ScreenShareCtrl.s(i16);
            }
        }

        @Override // com.tencent.av.ui.ScreenRecordHelper.b
        public void d(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i(AVConstants.SHARE_TAG, 2, "onMediaProjectionReady errorReason:=" + i3);
            }
        }

        @Override // com.tencent.av.opengl.effects.g.b
        public void e(byte[] bArr, int i3, int i16, RecordParam recordParam) {
            this.f74272a.a(1, bArr, i3, i16, recordParam);
            ScreenShareCtrl screenShareCtrl = this.f74273b.get();
            if (screenShareCtrl != null) {
                screenShareCtrl.k(bArr, i3, i16, recordParam);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f74274a;

        /* renamed from: b, reason: collision with root package name */
        public int f74275b;

        /* renamed from: c, reason: collision with root package name */
        public int f74276c;

        /* renamed from: d, reason: collision with root package name */
        public final RecordParam f74277d = new RecordParam();

        /* renamed from: e, reason: collision with root package name */
        public int f74278e;

        d() {
        }

        public void a(int i3, byte[] bArr, int i16, int i17, RecordParam recordParam) {
            Object valueOf;
            this.f74274a++;
            if (this.f74275b != i3 || this.f74276c != i16 || !this.f74277d.equals(recordParam) || this.f74278e != i17) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("updateFrame, frameIndex[");
                    sb5.append(this.f74274a);
                    sb5.append("], data[");
                    if (bArr == null) {
                        valueOf = "null";
                    } else {
                        valueOf = Integer.valueOf(bArr.length);
                    }
                    sb5.append(valueOf);
                    sb5.append("], imgFormat[");
                    sb5.append(this.f74276c);
                    sb5.append("-->");
                    sb5.append(i16);
                    sb5.append("], recordParam[");
                    sb5.append(this.f74277d);
                    sb5.append("--->");
                    sb5.append(recordParam);
                    sb5.append("], angle[");
                    sb5.append(this.f74278e);
                    sb5.append("-->");
                    sb5.append(i17);
                    sb5.append("]");
                    QLog.i(AVConstants.SHARE_TAG, 2, sb5.toString());
                }
                this.f74275b = i3;
                this.f74276c = i16;
                this.f74277d.update(recordParam);
                this.f74278e = i17;
            }
        }
    }

    private boolean c(QQGAudioCtrl qQGAudioCtrl) {
        if (qQGAudioCtrl != null && n.e().f().f73046k2 == 2) {
            return true;
        }
        return false;
    }

    private int d(SessionInfo sessionInfo, int i3, int i16) {
        QQGAudioCtrl W = r.h0().W();
        VideoAppInterface N = VideoAppInterface.N();
        boolean z16 = false;
        if (W == null || N == null) {
            return 0;
        }
        if (i3 == 1) {
            sessionInfo.A0("executeShareScreenOps", 1, i16);
        } else if (i3 == 2) {
            sessionInfo.A0("executeShareScreenOps", 4, i16);
        }
        if (i3 == 2) {
            z16 = true;
        }
        if (!W.startOrStopShareSend(z16, i16)) {
            if (i3 == 1) {
                sessionInfo.A0("executeShareScreenOps", 3, i16);
                return 4;
            }
            if (i3 != 2) {
                return 4;
            }
            sessionInfo.A0("executeShareScreenOps", 6, i16);
            return 4;
        }
        if (this.f74255b != null) {
            N.M().removeCallbacks(this.f74255b);
            this.f74255b = null;
        }
        this.f74255b = new ShareOpsTimeOutTask(sessionInfo, i3, i16);
        N.M().postDelayed(this.f74255b, 30000L);
        return 1;
    }

    public static boolean f(SessionInfo sessionInfo) {
        int i3;
        if (sessionInfo != null && ((i3 = sessionInfo.f73046k2) == 2 || i3 == 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Iterator<String> it = f74253i.iterator();
        while (it.hasNext()) {
            if (DeviceInfoMonitor.getModel().equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    private void n(AVActivity aVActivity, long j3) {
        if (aVActivity != null && !aVActivity.isFinishing() && !aVActivity.isDestroyed()) {
            int a16 = com.tencent.av.screenshare.d.a();
            PopupDialog.o0(aVActivity, 230, null, com.tencent.av.screenshare.d.b(), R.string.ddx, R.string.ddx, null, new a(aVActivity, j3));
            ReportController.o(null, "dc00898", "", "", "0X800B48D", "0X800B48D", a16, 0, "", "", "", "");
        }
    }

    private void r() {
        if (this.f74260g == null) {
            this.f74260g = new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareCtrl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(AVConstants.SHARE_TAG, 2, "SetTimeOut_Double2Meeting timeOut ");
                    }
                    long d16 = e.d();
                    String str = n.e().f().f73091w;
                    VideoAppInterface.N().k0(new Object[]{14, 2, str, Long.valueOf(d16)});
                    VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
                    r.h0().r(str, 202);
                    r.h0().q(str, 2);
                }
            };
        }
        if (VideoAppInterface.N() != null && this.f74260g != null) {
            VideoAppInterface.N().M().postDelayed(this.f74260g, 20000L);
        }
    }

    public static void s(int i3) {
        String string;
        BaseApplication context = BaseApplication.getContext();
        Resources resources = context.getResources();
        if (i3 != 1) {
            if (i3 != 7) {
                if (i3 != 8) {
                    if (i3 != 9) {
                        string = null;
                    } else {
                        string = resources.getString(R.string.f1783436e);
                    }
                } else {
                    string = resources.getString(R.string.f1783136b);
                }
            } else {
                string = resources.getString(R.string.f17826367);
            }
        } else {
            string = resources.getString(R.string.f1783036a);
        }
        if (!TextUtils.isEmpty(string)) {
            QQToast.makeText(context, -1, string, 0).show();
        }
    }

    private void v(int i3) {
        final AVActivity aVActivity;
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "stopShareScreen, from[" + i3 + "]");
        }
        WeakReference<AVActivity> weakReference = this.f74259f;
        if (weakReference == null) {
            aVActivity = null;
        } else {
            aVActivity = weakReference.get();
        }
        final SessionInfo f16 = n.e().f();
        if (f(f16)) {
            u(aVActivity, 1L);
            if (aVActivity != null) {
                aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareCtrl.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!aVActivity.isFinishing() && !aVActivity.isDestroyed()) {
                            SessionInfo f17 = n.e().f();
                            if (f17.F() && !f17.D() && TextUtils.equals(f16.f73030h, f17.f73030h)) {
                                QQToast.makeText(BaseApplicationImpl.getApplication(), 0, R.string.f17827368, 1).show();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(AVConstants.SHARE_TAG, 2, "stopShareScreen, session[" + f17 + "]");
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(AVConstants.SHARE_TAG, 2, "stopShareScreen, activity finish");
                        }
                    }
                });
            }
        }
    }

    public c e() {
        if (this.f74254a == null) {
            this.f74254a = new c(this);
        }
        return this.f74254a;
    }

    public void h(String str) {
        long d16 = e.d();
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.w("normal_2_meeting", 2, "onSwitchMeeting, session[" + f16 + "], seq[" + d16 + "]");
        }
        if (f16.f73060o0 || TextUtils.isEmpty(str) || !str.equalsIgnoreCase(f16.f73091w)) {
            return;
        }
        f16.s0("onSwitchMeeting", true);
        f16.P0 = 0L;
        f16.t0("onSwitchMeeting", 16);
        VideoAppInterface.N().k0(new Object[]{174, Long.valueOf(d16)});
        r();
    }

    @TargetApi(21)
    public void i(int i3, long j3, RecordParam recordParam) {
        ScreenRecordHelper x06;
        if (recordParam == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16.S0 == i3 && f16.P0 == j3) {
            if (QLog.isColorLevel()) {
                QLog.i(AVConstants.SHARE_TAG, 2, "onRecSharePushEncParam, param[" + recordParam + "], session[" + f16 + "]");
            }
            if (f16.f73046k2 == 2 && (x06 = r.h0().x0()) != null) {
                x06.C(recordParam.width, recordParam.height, recordParam.fps);
            }
        }
    }

    public void j(Bitmap bitmap, RecordParam recordParam) {
        if (recordParam == null) {
            return;
        }
        QQGAudioCtrl W = r.h0().W();
        if (c(W)) {
            if (!this.f74256c.equals(recordParam)) {
                this.f74256c.update(recordParam);
                W.setShareEncParam(this.f74256c, this.f74257d, this.f74258e, 1);
            }
            if (W.sendShareFrame(bitmap, recordParam.width, recordParam.height) != 0) {
                v(2);
                return;
            }
            return;
        }
        if (W == null) {
            v(1);
        }
    }

    public void k(byte[] bArr, int i3, int i16, RecordParam recordParam) {
        if (recordParam != null && r.h0() != null) {
            QQGAudioCtrl W = r.h0().W();
            if (c(W)) {
                if (!this.f74256c.equals(recordParam)) {
                    this.f74256c.update(recordParam);
                    W.setShareEncParam(this.f74256c, this.f74257d, this.f74258e, 1);
                }
                if (W.sendShareFrame(bArr, i3, recordParam.width, recordParam.height, i16) != 0) {
                    v(2);
                    return;
                }
                return;
            }
            if (W == null) {
                v(1);
            }
        }
    }

    public void l(int i3, int i16, int i17, long j3, int i18, int i19) {
        VideoAppInterface N = VideoAppInterface.N();
        if (N == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        String str = "]";
        if (f16.S0 == i17) {
            if (f16.P0 != j3) {
                str = "]";
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(AVConstants.SHARE_TAG, 2, "onShareOpsCallback, session[" + f16 + "], [" + i17 + "," + j3 + "," + i18 + "," + i19 + "], actionResult[" + i3 + "], shareType[" + i16 + "]");
                }
                if (this.f74255b != null) {
                    N.M().removeCallbacks(this.f74255b);
                    this.f74255b = null;
                }
                int i26 = f16.f73046k2;
                switch (i3) {
                    case 84:
                        if (i26 == 1) {
                            i26 = 2;
                        }
                        com.tencent.av.screenshare.c.h(f16.f73030h, "onShareOpsCallback");
                        break;
                    case 85:
                    case 86:
                        if (i26 == 1) {
                            i26 = 3;
                            break;
                        }
                        break;
                    case 87:
                        if (i26 == 4) {
                            i26 = 5;
                        }
                        com.tencent.av.screenshare.c.g(f16.f73030h, "onShareOpsCallback");
                        break;
                    case 88:
                    case 89:
                        if (i26 == 4) {
                            i26 = 6;
                        }
                        com.tencent.av.screenshare.c.g(f16.f73030h, "onShareOpsCallback");
                        break;
                }
                if (i26 != f16.f73046k2) {
                    f16.A0("onShareOpsCallback", i26, i16);
                    N.k0(new Object[]{Integer.valueOf(WnsNetworkConst.NETWORK_DISABLE), Integer.valueOf(i26), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Integer.valueOf(i18)});
                    return;
                }
                return;
            }
        }
        QLog.i(AVConstants.SHARE_TAG, 1, "onShareOpsCallback, error session, session[" + f16 + "], [" + i17 + "," + j3 + "," + i18 + "," + i19 + "], actionResult[" + i3 + "], shareType[" + i16 + str);
    }

    public void m(long j3, long j16, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("normal_2_meeting", 2, "onSwitch2DoubleMeeting, seq[" + j3 + "], uin[" + j16 + "], avtype[" + i3 + "], subType[" + i16 + "]");
        }
        if (this.f74260g != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f74260g);
            this.f74260g = null;
        }
        String b16 = n.b(100, String.valueOf(j16), new int[0]);
        SessionInfo f16 = n.e().f();
        SessionInfo i17 = n.e().i(b16);
        i17.M0 = true;
        i17.f73039j = 2;
        i17.f73103z = null;
        i17.G = true;
        i17.Y0 = String.valueOf(j16);
        i17.f73091w = f16.f73091w;
        i17.f73099y = f16.f73099y;
        i17.f73062o2 = f16.N;
        i17.c0(j3, false);
        i17.K = f16.K;
        i17.r0("onSwitch2DoubleMeeting", f16.I0);
        i17.Y("onSwitch2DoubleMeeting", f16.F0);
        i17.f73038i2 = true;
        if (f16.f73035i == 1) {
            i17.p0(j3, "onSwitch2DoubleMeeting.1", 3);
        } else {
            i17.p0(j3, "onSwitch2DoubleMeeting.2", 4);
        }
        i17.f73067q = f16.f73067q;
        i17.P0 = j16;
        i17.S0 = 3;
        i17.f73063p = 8;
        i17.y0("onSwitch2DoubleMeeting", true);
        i17.s0("onSwitch2DoubleMeeting", true);
        i17.t0("onSwitch2DoubleMeeting", 17);
        i17.n0("onSwitch2DoubleMeeting", 2);
        n e16 = n.e();
        VideoRecoveryMonitor T = VideoAppInterface.N().T();
        if (T != null) {
            T.k(262);
        }
        r.h0().q(f16.f73091w, 72);
        if (!TextUtils.isEmpty(f16.f73030h) && e16.j(f16.f73030h)) {
            boolean n3 = e16.n(j3, f16.f73030h);
            if (QLog.isColorLevel()) {
                QLog.i(AVConstants.SHARE_TAG, 2, "onSwitch2DoubleMeeting, need double remove ret[" + n3 + "]");
            }
        }
        if (n.e().f() != i17) {
            e16.o(i17.f73030h);
            if (QLog.isColorLevel()) {
                QLog.i(AVConstants.SHARE_TAG, 2, "onSwitch2DoubleMeeting, need double set main session. ");
            }
        }
        i17.Z("onSwitch2DoubleMeeting", 1);
        if (VideoAppInterface.N().r() > 0) {
            VideoAppInterface.N().k0(new Object[]{174, Long.valueOf(j3)});
        } else if (VideoAppInterface.N().isBackgroundStop) {
            r.h0().a(j3, 3, j16, new long[]{j16}, false);
        }
        r.h0().B2(i17.f73030h, i17.f73035i, false, false, true);
    }

    public void o(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "removeDoubleMeetingTimeOutTask, info[" + j3 + "]");
        }
        DoubleMeetingInviteTimeOutTask doubleMeetingInviteTimeOutTask = this.f74261h;
        if (doubleMeetingInviteTimeOutTask != null && doubleMeetingInviteTimeOutTask.f74264d.P0 == j3) {
            VideoAppInterface.N().M().removeCallbacks(this.f74261h);
            this.f74261h = null;
        }
    }

    public int p(int i3) {
        if (r.h0().W() == null) {
            return 2;
        }
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "requestShareScreenOps, emShareOps[" + i3 + "], cur[" + f16.f73046k2 + "," + f16.f73050l2 + "]");
        }
        int i16 = f16.f73050l2;
        if (i16 != 1 && i16 != 0) {
            return 3;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                switch (f16.f73046k2) {
                    case 0:
                    case 4:
                    case 5:
                        return 1;
                    case 1:
                    case 2:
                    case 3:
                    case 6:
                        return d(f16, i3, 1);
                }
            }
        } else {
            switch (f16.f73046k2) {
                case 0:
                case 3:
                case 4:
                case 5:
                case 6:
                    return d(f16, i3, 1);
                case 1:
                case 2:
                    return 1;
            }
        }
        return 0;
    }

    public void q(RecordParam recordParam, int i3, int i16) {
        QQGAudioCtrl W = r.h0().W();
        if (W != null && recordParam != null) {
            this.f74256c.update(recordParam);
            if (i3 != 0) {
                this.f74257d = i3;
            }
            if (i16 != 0) {
                this.f74258e = i16;
            }
            W.setShareEncParam(this.f74256c, this.f74257d, this.f74258e, 0);
        }
    }

    public void t(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "startDoubleMeetingTimeOutTask, info[" + sessionInfo + "]");
        }
        if (this.f74261h != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f74261h);
        }
        this.f74261h = new DoubleMeetingInviteTimeOutTask(sessionInfo);
        VideoAppInterface.N().M().postDelayed(this.f74261h, s.G);
    }

    @TargetApi(21)
    public void u(AVActivity aVActivity, long j3) {
        if (aVActivity != null) {
            this.f74259f = new WeakReference<>(aVActivity);
        }
        SessionInfo f16 = n.e().f();
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i(AVConstants.SHARE_TAG, 2, "startOrStopScreenShare, seq[" + j3 + "]");
        }
        int i16 = f16.f73046k2;
        ScreenRecordHelper screenRecordHelper = null;
        if (i16 != 2 && i16 != 1) {
            if (f16.O(VideoAppInterface.N().getCurrentAccountUin())) {
                s(1);
                return;
            }
            if (f16.R()) {
                s(8);
                return;
            }
            if (aVActivity != null && (com.tencent.av.screenshare.d.a() == 1 || com.tencent.av.screenshare.d.a() == 2)) {
                n(aVActivity, j3);
                return;
            }
            if (aVActivity != null) {
                screenRecordHelper = aVActivity.d3();
            }
            if (screenRecordHelper != null) {
                screenRecordHelper.v(e());
                screenRecordHelper.w(e());
                screenRecordHelper.s();
                screenRecordHelper.u(new b());
                return;
            }
            return;
        }
        if (p(2) != 1) {
            i3 = 3;
        }
        s(i3);
        if (aVActivity != null) {
            screenRecordHelper = aVActivity.d3();
        }
        if (screenRecordHelper != null) {
            screenRecordHelper.y(1);
        }
    }

    public void w(long j3) {
        long j16;
        int i3;
        SessionInfo f16 = n.e().f();
        try {
            j16 = Long.parseLong(f16.f73091w);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j16 = 0;
        }
        if (j16 == 0) {
            long j17 = f16.P0;
            if (j17 != 0) {
                j16 = j17;
            }
        }
        if (j16 == 0) {
            QLog.i("normal_2_meeting", 1, "switchToDoubleMeeting relationId illegal.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + f16 + "]");
        }
        n e16 = n.e();
        int i16 = f16.f73035i;
        String str = f16.f73030h;
        String b16 = n.b(100, String.valueOf(j16), new int[0]);
        SessionInfo a16 = e16.a(b16, false);
        a16.c0(j3, f16.N);
        a16.K = f16.K;
        a16.f73062o2 = f16.N;
        a16.r0("switchToDoubleMeeting", f16.I0);
        a16.Y("switchToDoubleMeeting", f16.F0);
        String str2 = f16.f73091w;
        a16.f73091w = str2;
        if (TextUtils.isEmpty(str2)) {
            a16.f73091w = String.valueOf(j16);
        }
        a16.f73099y = f16.f73099y;
        a16.f73063p = 8;
        a16.f73038i2 = true;
        a16.S0 = 3;
        a16.P0 = j16;
        a16.f73067q = 0;
        a16.s0("switchToDoubleMeeting", true);
        a16.h0(f16.f73070q2);
        a16.i0(f16.f73074r2);
        a16.f73042j2 = 5;
        r.h0().p3(true);
        r.h0().r(f16.f73091w, 8);
        r.h0().j2(262);
        r.h0().q(f16.f73091w, 72);
        r.h0().a3(3);
        if (e16.j(str)) {
            QLog.i(AVConstants.SHARE_TAG, 2, "switchToDoubleMeeting, need double remove. ret[" + e16.n(j3, str) + "]");
        }
        if (e16.f() != a16) {
            e16.o(b16);
        }
        if (QLog.isColorLevel()) {
            i3 = 2;
            QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + n.e().f() + "]");
        } else {
            i3 = 2;
        }
        a16.A0 = -1;
        if (i16 == 1) {
            a16.p0(j3, "switchToDoubleMeeting.1", 3);
        } else if (i16 == i3) {
            a16.p0(j3, "switchToDoubleMeeting.2", 4);
        }
        a16.f73067q = 0;
        a16.P0 = j16;
        a16.Z("switchToDoubleMeeting", 0);
        VideoAppInterface N = VideoAppInterface.N();
        Object[] objArr = new Object[i3];
        objArr[0] = 174;
        objArr[1] = Long.valueOf(j3);
        N.k0(objArr);
    }
}
