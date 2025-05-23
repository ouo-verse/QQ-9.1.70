package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.q;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenMultiVideoControlUI extends SmallScreenVideoControlUI {

    /* renamed from: a0, reason: collision with root package name */
    static int f74490a0 = 16;
    int K;
    int L;
    int M;
    long[] N;
    long P;
    Runnable Q;
    Runnable R;
    Runnable S;
    Runnable T;
    boolean U;
    String V;
    QAVNotification W;
    IMediaPlayerApi X;
    GAudioUIObserver Y;
    StartRecvVideoRunnable Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class AutoCheckRunnable implements Runnable {
        AutoCheckRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmallScreenMultiVideoControlUI.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RefreshUIRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f74498d;

        /* renamed from: e, reason: collision with root package name */
        int f74499e;

        /* renamed from: f, reason: collision with root package name */
        boolean f74500f;

        /* renamed from: h, reason: collision with root package name */
        int f74501h;

        public RefreshUIRunnable(int i3, long j3, boolean z16, int i16) {
            this.f74498d = j3;
            this.f74499e = i3;
            this.f74500f = z16;
            this.f74501h = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmallScreenMultiVideoControlUI.this.F(this.f74499e, this.f74498d, this.f74500f, this.f74501h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RequestVideoTimeOutRunnable implements Runnable {
        RequestVideoTimeOutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() != null && !SmallScreenMultiVideoControlUI.this.J) {
                r.h0().B3("Small_RequestVideoTimeOutRunnable");
                cw.e.d(SmallScreenMultiVideoControlUI.this.E, 1036);
                cw.e.d(SmallScreenMultiVideoControlUI.this.E, 1037);
                cw.e.o(SmallScreenMultiVideoControlUI.this.E, 1030, R.string.dkf);
                n.e().f().V(SmallScreenMultiVideoControlUI.this.P, true, true);
                SmallScreenMultiVideoControlUI.this.Z(true, false, true);
                if (SmallScreenMultiVideoControlUI.this.M == 2) {
                    ReportController.o(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, VideoController.getInstance() = null!!!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class StartRecvVideoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public String f74502d = null;

        StartRecvVideoRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.f74502d);
            }
            SmallScreenMultiVideoControlUI.this.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmallScreenMultiVideoControlUI(VideoAppInterface videoAppInterface, SmallScreenService smallScreenService, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, smallScreenService, controlUIObserver);
        this.K = -1;
        this.L = -1;
        this.M = 0;
        this.N = null;
        this.P = 0L;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = false;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = new MyGAudioUIObserver();
        this.Z = new StartRecvVideoRunnable();
        VideoAppInterface videoAppInterface2 = this.E;
        if (videoAppInterface2 != null) {
            this.V = videoAppInterface2.getCurrentAccountUin();
        }
        this.P = Long.valueOf(this.V).longValue();
        this.L = n.e().f().f73067q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context I() {
        WeakReference<Context> weakReference = this.D;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(long j3) {
        if (r.h0() != null && !this.J && this.E != null) {
            SessionInfo f16 = n.e().f();
            if (QLog.isColorLevel()) {
                QLog.i("SmallScreenMultiVideoControlUI", 2, "updateWhenCreateOrEnterRoomSuc, seq[" + j3 + "] mHasLocalVideoWhenSwitch=" + f16.f73062o2, new Throwable());
            }
            f16.z0("onEnterRoomSuc", true);
            f16.f73097x1 = true;
            if (TextUtils.isEmpty(f16.f73091w)) {
                f16.f73091w = String.valueOf(f16.P0);
            }
            r.h0().x3(3, 0, true, true, f16.f73091w);
            return;
        }
        QLog.i("SmallScreenMultiVideoControlUI", 1, "updateWhenCreateOrEnterRoomSuc error.");
    }

    void B(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Add-->functionName=" + str);
        }
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface == null) {
            QLog.e("SmallScreenMultiVideoControlUI", 1, "addRequestVideoTimeoutRunnable error......");
            return;
        }
        if (this.R != null) {
            videoAppInterface.M().removeCallbacks(this.R);
        } else {
            this.R = new RequestVideoTimeOutRunnable();
        }
        this.E.M().postDelayed(this.R, 30000L);
    }

    boolean C() {
        if (n.e().f().f73045k1.size() == 0) {
            D();
            Z(false, false, false);
            return false;
        }
        if (n.e().f().f73045k1.size() != 1 || n.e().f().f73045k1.get(0).f73827a != this.P) {
            return true;
        }
        Z(false, false, false);
        W("checkRemoteVideo");
        return false;
    }

    void D() {
        ControlUIObserver controlUIObserver;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenMultiVideoControlUI", 1, "closeRemoteVideo, seq[" + d16 + "]");
        }
        if (r.h0() != null && !this.J) {
            r.h0().B3("Meeting_closeRemoteVideo");
            n.e().f().w0(d16, "closeRemoteVideo", false, true);
            b0();
        }
        W("closeRemoteVideo");
        if (r.h0() == null || this.J || (controlUIObserver = this.F) == null) {
            return;
        }
        controlUIObserver.update(null, new Object[]{104, n.e().f().f73045k1});
    }

    void E(long j3, boolean z16) {
        long J = J();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenMultiVideoControlUI", 1, "createOrEnterGAudio, mType[" + this.K + "], relationType[" + this.M + "], groupId[" + J + "], seq[" + j3 + "], isDoubleAudioToMultiAudio[" + z16 + "]");
        }
        if (J == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
                return;
            }
            return;
        }
        String string = this.C.getString(R.string.djz);
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(string);
        }
        int i3 = this.K;
        if (i3 != 0) {
            if (i3 == 1 && z16) {
                r.h0().a(j3, this.M, J, this.N, false);
                return;
            }
            return;
        }
        if (this.N == null && this.M == 2) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
            }
            H(true);
        }
    }

    void G() {
        if (r.h0() != null && !this.J && this.D != null) {
            if (!r.h0().W0()) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->VideoController.getInstance().IsGAudioInRoom() =" + r.h0().W0());
                    return;
                }
                return;
            }
            int q16 = n.e().f().q(this.P, 1);
            int r06 = r.h0().r0();
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->index=" + q16 + ", onstageNum=" + r06);
            }
            if (!NetworkUtil.isWifiConnected(I()) && !NetworkUtil.isMobileNetWork(I()) && !n.e().f().C1) {
                if (q16 != -1) {
                    r.h0().h2(this.P, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                    r.h0().v3();
                }
                if (n.e().f().f73045k1.size() > 0) {
                    n.e().f().w0(-1023L, "enterOrResumeRemoteOrLocalVideo", true, true);
                    b0();
                    Z(true, true, true);
                    return;
                }
                return;
            }
            if (q16 != -1) {
                if (r.h0().r0() < f74490a0) {
                    if (n.e().f().N && !r.h0().L0() && QLog.isColorLevel()) {
                        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
                    }
                } else {
                    r.h0().h2(this.P, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                    r.h0().v3();
                }
            }
            if (n.e().f().f73045k1.size() > 0) {
                a0();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mContext is null");
        }
    }

    void H(boolean z16) {
        this.U = z16;
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null) {
            videoAppInterface.k0(new Object[]{28, String.valueOf(J()), Boolean.valueOf(z16)});
        }
    }

    long J() {
        if (r.h0() != null) {
            return n.e().f().P0;
        }
        return 0L;
    }

    void K(long j3) {
        r.h0().K0();
        n.e().f().w0(j3, "goOffStage", false, false);
        ControlUIObserver controlUIObserver = this.F;
        if (controlUIObserver != null) {
            controlUIObserver.update(null, new Object[]{106, Long.valueOf(j3)});
        }
        b0();
    }

    void L(long j3, boolean z16) {
        int i3 = this.K;
        if (i3 == 0 || i3 == 1) {
            D();
            E(j3, z16);
        } else if (i3 == 2) {
            if (n.e().f().f73043k == 9) {
                this.f74532h = true;
                String string = this.C.getString(R.string.dk7);
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(string);
                }
            } else {
                this.f74532h = false;
            }
            x();
        } else if (n.e().f().u()) {
            this.f74532h = true;
            String string2 = this.C.getString(R.string.dk7);
            TextView textView2 = this.G;
            if (textView2 != null) {
                textView2.setText(string2);
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "handleExterData-->Wrong gaudioStatusType-->type=" + this.K + ",relationId=" + J() + ",relationType=" + this.M);
        }
        X();
    }

    void M(int i3) {
        String string;
        if (n.e().f().f73043k == 9) {
            Resources resources = this.C;
            if (resources == null) {
                string = "";
            } else {
                string = resources.getString(R.string.dk7);
            }
            TextView textView = this.G;
            if (textView != null) {
                textView.setText(string);
            }
            if (this.f74531f) {
                this.f74532h = true;
            }
            ba.setAccText(this.G, string);
        } else if (i3 == 0) {
            this.f74532h = false;
            x();
        }
        Q();
    }

    void O(long j3, int i3, long j16) {
        boolean z16;
        boolean z17 = j16 == this.P;
        if (i3 == 6) {
            z16 = C();
            if (z17 && !n.e().f().A1) {
                r.h0().h2(this.P, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
            }
        } else {
            z16 = true;
        }
        if (n.e().f().f73097x1 && z16 && this.f74530e < 4) {
            if (!NetworkUtil.isWifiConnected(I()) && n.e().f().o() == -1 && !n.e().f().C1) {
                if (z17) {
                    return;
                }
                n.e().f().w0(j3, "drawUI.1", true, true);
                b0();
                Z(true, true, true);
                return;
            }
            VideoAppInterface videoAppInterface = this.E;
            if (videoAppInterface == null) {
                QLog.e("SmallScreenMultiVideoControlUI", 1, "handleRefreshVideoInOrOut error.");
                return;
            }
            if (!z17) {
                videoAppInterface.M().removeCallbacks(this.Z);
                this.Z.f74502d = "DrawUI:TYPE=" + String.valueOf(i3);
                this.E.M().postDelayed(this.Z, 1000L);
                return;
            }
            int q16 = n.e().f().q(this.P, 1);
            int o16 = n.e().f().o();
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onSelfVideoIn.-->FirstVideo=" + o16 + ",index=" + q16);
            }
            if (o16 == -1 || (q16 == o16 && q16 != 0)) {
                this.E.M().removeCallbacks(this.Z);
                this.Z.f74502d = "DrawUI:TYPE=" + String.valueOf(i3);
                this.E.M().postDelayed(this.Z, 1000L);
            }
        }
    }

    void P(long j3, int i3) {
        boolean C = C();
        if (n.e().f().f73097x1 && C && this.f74530e < 4) {
            if (!NetworkUtil.isWifiConnected(I()) && n.e().f().o() == -1 && !n.e().f().C1) {
                n.e().f().w0(j3, "drawUI.3", true, true);
                b0();
                Z(true, true, true);
                return;
            }
            VideoAppInterface videoAppInterface = this.E;
            if (videoAppInterface != null) {
                videoAppInterface.M().removeCallbacks(this.Z);
                this.Z.f74502d = "DrawUI:TYPE=" + String.valueOf(i3);
                this.E.M().postDelayed(this.Z, 1000L);
            }
        }
    }

    void Q() {
        U();
    }

    void R(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            com.tencent.av.gaudio.c cVar = arrayList.get(i3);
            if (cVar.f73827a == this.P && cVar.f73828b == 1 && !n.e().f().N) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        ControlUIObserver controlUIObserver = this.F;
        if (controlUIObserver != null) {
            Object[] objArr = new Object[4];
            objArr[0] = 103;
            objArr[1] = arrayList;
            objArr[2] = Long.valueOf(j3);
            objArr[3] = Boolean.valueOf(size != arrayList.size());
            controlUIObserver.update(null, objArr);
        }
    }

    void S(boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        IMediaPlayerApi iMediaPlayerApi = this.X;
        if (iMediaPlayerApi == null) {
            IMediaPlayerApi iMediaPlayerApi2 = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
            this.X = iMediaPlayerApi2;
            iMediaPlayerApi2.init(this.D.get(), null);
        } else {
            iMediaPlayerApi.stopRing(d16);
        }
        if (z16) {
            if (q.b("qav_gaudio_muted.mp3")) {
                this.X.playRing(d16, 2, 0, null, q.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
                return;
            }
            return;
        }
        if (q.b("qav_gaudio_cancel_muted.mp3")) {
            this.X.playRing(d16, 2, 0, null, q.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
        }
    }

    void T() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData-->mType=" + n.e().f().R0 + " IntentGroupId=" + n.e().f().P0 + " isInRoom=" + r.h0().W0() + " mRoomDiscussionId=" + r.h0().X());
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null) {
            int i3 = f16.f73067q;
            this.L = i3;
            if (i3 == 3000) {
                this.M = 2;
            } else if (i3 == 1) {
                this.M = 1;
            } else if (i3 == 0) {
                this.M = 3;
            } else {
                this.M = f16.S0;
            }
            this.K = f16.R0;
            this.N = f16.Q0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "processExtraData mGroupId = " + J());
        }
    }

    void U() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
        }
        if (r.h0() == null && QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
        }
    }

    void V(long j3, int i3, boolean z16, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin=" + j3 + " type=" + i3 + " isRefreshTitle=" + z16 + " originalType=" + i16);
        }
        if (j3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
            }
        } else if (this.E != null) {
            this.E.M().post(new RefreshUIRunnable(i3, j3, z16, i16));
        } else if (QLog.isColorLevel()) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
        }
    }

    void W(String str) {
        VideoAppInterface videoAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeoutRunnable-->Remove-->functionName=" + str);
        }
        if (this.R == null || (videoAppInterface = this.E) == null) {
            return;
        }
        videoAppInterface.M().removeCallbacks(this.R);
    }

    void X() {
        if (this.E == null) {
            return;
        }
        this.E.A0(this.L, String.valueOf(J()));
    }

    void Y() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
        }
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface == null) {
            QLog.e("SmallScreenMultiVideoControlUI", 1, "resumeVideo error.");
            return;
        }
        if (this.Q == null) {
            this.Q = new AutoCheckRunnable();
        } else {
            videoAppInterface.M().removeCallbacks(this.Q);
        }
        this.E.M().postDelayed(this.Q, 500L);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    protected void a() {
        super.a();
        if (n.e().f().f73043k == 9) {
            String string = this.C.getString(R.string.dk7);
            TextView textView = this.G;
            if (textView != null) {
                textView.setText(string);
            }
        }
        if (n.e().f().G() && n.e().f().K) {
            r.h0().y("SmallScreenMultiVideoControlUI.initUI", n.e().f().P0, false);
        }
    }

    void b0() {
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "switchUIMode, sessionType = " + n.e().f().f73035i);
        }
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null) {
            videoAppInterface.k0(new Object[]{102});
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void e(boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        super.e(z16);
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null) {
            videoAppInterface.addObserver(this.Y);
        }
        T();
        if (n.e().f().G()) {
            String str = n.e().f().F0;
            TraeHelper.I().h0(d16, this.I, str);
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenMultiVideoControlUI", 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.I + "], deviceName[" + str + "], seq[" + d16 + "]");
            }
            TraeHelper.I().E(d16, str);
        }
        L(d16, z16);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void f(long j3) {
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.Y);
            this.E.M().removeCallbacks(this.Q);
            this.E.M().removeCallbacks(this.R);
            this.E.M().removeCallbacks(this.S);
            this.E.M().removeCallbacks(this.T);
        }
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        IMediaPlayerApi iMediaPlayerApi = this.X;
        if (iMediaPlayerApi != null) {
            iMediaPlayerApi.stopRing(j3);
            this.X = null;
        }
        super.f(j3);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void k() {
        WeakReference<Context> weakReference;
        super.k();
        if (r.h0() == null || this.J || (weakReference = this.D) == null || NetworkUtil.isWifiConnected(weakReference.get()) || n.e().f().o() == -1 || n.e().f().f73060o0) {
            return;
        }
        r.h0().B3("Small_onPause");
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    public void o() {
        super.o();
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
        }
        if (r.h0() == null || this.J) {
            return;
        }
        if (r.h0().W0()) {
            r.h0().U2();
            if (n.e().f().f73043k == 9) {
                this.f74532h = true;
                String string = this.C.getString(R.string.dk7);
                TextView textView = this.G;
                if (textView != null) {
                    textView.setText(string);
                }
            } else {
                this.f74532h = false;
            }
            x();
        }
        QAVNotification qAVNotification = this.W;
        if (qAVNotification != null) {
            qAVNotification.f(n.e().f().f73030h);
        }
        n.e().f().A1 = false;
        if (r.h0().W0()) {
            Y();
        }
        X();
    }

    @Override // com.tencent.av.smallscreen.SmallScreenVideoControlUI
    protected void t(int i3) {
        TextView textView = this.G;
        if (textView == null || i3 <= 0) {
            return;
        }
        textView.setText(i3);
    }

    boolean a0() {
        if (r.h0() == null || this.J || this.E == null) {
            return false;
        }
        int size = n.e().f().f73045k1.size();
        if (n.e().f().N) {
            size--;
        }
        if (size == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
            }
            return false;
        }
        VideoAppInterface videoAppInterface = this.E;
        if (videoAppInterface != null && tv.c.c(videoAppInterface.getApp()) == 1) {
            return false;
        }
        ReportController.o(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
        int H0 = r.h0().H0();
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->VideoAblityLevel=" + H0);
        }
        if (H0 != 4) {
            if (this.M == 2) {
                ReportController.o(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
            }
            cw.e.n(this.E, 3009);
        }
        n.e().f().f73057n1.clear();
        VideoAppInterface videoAppInterface2 = this.E;
        if (videoAppInterface2 != null) {
            long parseLong = Long.parseLong(videoAppInterface2.getCurrentAccountUin());
            for (int i3 = 0; i3 < n.e().f().f73045k1.size(); i3++) {
                if (n.e().f().f73045k1.get(i3).f73831e && parseLong != n.e().f().f73045k1.get(i3).f73827a) {
                    n.e().f().f73057n1.add(n.e().f().f73045k1.get(i3));
                }
            }
        }
        Z(false, false, false);
        return r.h0().m2(false);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class MyGAudioUIObserver extends GAudioUIObserver {

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class AutoCheckVideoRunnable implements Runnable {
            AutoCheckVideoRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface videoAppInterface;
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenMultiVideoControlUI", 2, "AutoCheckVideoRunnable");
                }
                if (r.h0() != null && !SmallScreenMultiVideoControlUI.this.J) {
                    n.e().f().f73097x1 = true;
                }
                SmallScreenMultiVideoControlUI.this.G();
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
                if (smallScreenMultiVideoControlUI.L != 1 || (videoAppInterface = smallScreenMultiVideoControlUI.E) == null) {
                    return;
                }
                videoAppInterface.V(smallScreenMultiVideoControlUI.J());
            }
        }

        MyGAudioUIObserver() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void B(long j3, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteSomeoneEnter-->firstUin=" + j3 + " length=" + i3);
            }
            super.B(j3, i3);
            SmallScreenMultiVideoControlUI.this.V(j3, 68, true, -1);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void C(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onInviteUserNotice --> Count = " + i3 + " ,firstName = " + str);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void E(long j3, long j16, int i3, boolean z16) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberBanOrCancelBanAudio, groupUin[" + j3 + "], userUin[" + j16 + "], relationType[" + i3 + "], bBan[" + z16 + "], seq[" + d16 + "]");
            }
            if (SmallScreenMultiVideoControlUI.this.J() == j3 && j16 == SmallScreenMultiVideoControlUI.this.P && i3 == 1 && z16) {
                n.e().f().f73032h1 = true;
                if (n.e().f().N) {
                    SmallScreenMultiVideoControlUI.this.K(d16);
                    r.h0().h2(SmallScreenMultiVideoControlUI.this.P, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void F(long j3, long j16, boolean z16, boolean z17) {
            super.F(j3, j16, z16, z17);
            if (SmallScreenMultiVideoControlUI.this.J() != j3) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberJoin,wrong group uin.GroupUin = " + j3 + " ,mGroupId = " + SmallScreenMultiVideoControlUI.this.J() + " ,isQQUser = " + z17);
                    return;
                }
                return;
            }
            SmallScreenMultiVideoControlUI.this.V(j16, 0, z16, 70);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void G(long j3, long j16, boolean z16, boolean z17) {
            if (n.e().f().f73060o0) {
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
                if (j16 != smallScreenMultiVideoControlUI.P) {
                    smallScreenMultiVideoControlUI.w();
                    r.h0().Y1(com.tencent.av.utils.e.d(), j16, false, 2);
                    return;
                }
                return;
            }
            if (SmallScreenMultiVideoControlUI.this.J() != j3) {
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenMultiVideoControlUI", 2, "onMemberLeave,wrong group uin.GroupUin = " + j3 + " ,mGroupId = " + SmallScreenMultiVideoControlUI.this.J() + " ,isQQUser = " + z16);
                    return;
                }
                return;
            }
            super.G(j3, j16, z16, z17);
            SmallScreenMultiVideoControlUI.this.V(j16, 1, true, 71);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void H(long j3, long j16, long j17, int i3, boolean z16) {
            VideoAppInterface videoAppInterface;
            if (SmallScreenMultiVideoControlUI.this.M == 1 && z16) {
                if (n.e().f().f73045k1.size() == 0) {
                    n.e().f().w0(j3, "onMemberPPTInOrOut", false, false);
                    SmallScreenMultiVideoControlUI.this.b0();
                    SmallScreenMultiVideoControlUI.this.Z(false, false, false);
                    return;
                }
                if (!NetworkUtil.isWifiConnected(SmallScreenMultiVideoControlUI.this.I()) && n.e().f().o() == -1 && !n.e().f().C1) {
                    n.e().f().w0(j3, "onMemberPPTInOrOut", true, true);
                    SmallScreenMultiVideoControlUI.this.b0();
                    SmallScreenMultiVideoControlUI.this.Z(true, true, true);
                    return;
                }
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
                if (smallScreenMultiVideoControlUI.f74530e >= 4 || (videoAppInterface = smallScreenMultiVideoControlUI.E) == null) {
                    return;
                }
                videoAppInterface.M().removeCallbacks(SmallScreenMultiVideoControlUI.this.Z);
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI2 = SmallScreenMultiVideoControlUI.this;
                smallScreenMultiVideoControlUI2.Z.f74502d = "onMemberPPTInOrOut";
                smallScreenMultiVideoControlUI2.E.M().postDelayed(SmallScreenMultiVideoControlUI.this.Z, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void I(long j3, boolean z16, boolean z17, int i3) {
            super.I(j3, z16, z17, i3);
            SmallScreenMultiVideoControlUI.this.V(j3, 2, z17, z16 ? 42 : 43);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void J(long j3, long j16) {
            super.J(j3, j16);
            SmallScreenMultiVideoControlUI.this.V(j16, 5, false, 72);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void K(long j3, long j16, long j17, int i3) {
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenMultiVideoControlUI", 1, "onMemberVideoOut, groupId[" + j16 + "], friendUin[" + j17 + "], videoSrcType[" + i3 + "], seq[" + j3 + "]");
            }
            if (j17 == SmallScreenMultiVideoControlUI.this.P) {
                if (n.e().f().N) {
                    SmallScreenMultiVideoControlUI.this.K(j3);
                }
            } else {
                com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
                cVar.f73827a = j17;
                cVar.f73828b = i3;
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar);
                ControlUIObserver controlUIObserver = SmallScreenMultiVideoControlUI.this.F;
                if (controlUIObserver != null) {
                    controlUIObserver.update(null, new Object[]{104, arrayList});
                }
            }
            SmallScreenMultiVideoControlUI.this.V(j17, 6, false, 73);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void M(String str, String[] strArr) {
            super.M(str, strArr);
            int length = strArr.length;
            if (length < 1) {
                return;
            }
            r.h0().U(strArr[0], String.valueOf(SmallScreenMultiVideoControlUI.this.J()), SmallScreenMultiVideoControlUI.this.M);
            if (length == 1) {
                SmallScreenMultiVideoControlUI.this.C.getString(R.string.dbg);
            } else {
                String.format(SmallScreenMultiVideoControlUI.this.C.getString(R.string.dbf), Integer.valueOf(length));
            }
            SmallScreenMultiVideoControlUI.this.V(Long.valueOf(str).longValue(), 82, true, -1);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void N(int i3, long j3, int i16) {
            if (SmallScreenMultiVideoControlUI.this.M != 1) {
                return;
            }
            if (i16 == 102) {
                n.e().f().f73017e1 = true;
            } else if (i16 == 103) {
                n.e().f().f73017e1 = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void O() {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onServiceConnected");
            }
            super.O();
            SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
            if (smallScreenMultiVideoControlUI.E == null) {
                QLog.e("SmallScreenMultiVideoControlUI", 1, "onServiceConnected app is null......");
                return;
            }
            if (smallScreenMultiVideoControlUI.J() != 0) {
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI2 = SmallScreenMultiVideoControlUI.this;
                int i3 = smallScreenMultiVideoControlUI2.L;
                String valueOf = String.valueOf(smallScreenMultiVideoControlUI2.J());
                SmallScreenMultiVideoControlUI.this.E.A0(i3, valueOf);
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI3 = SmallScreenMultiVideoControlUI.this;
                long[] jArr = smallScreenMultiVideoControlUI3.N;
                if (jArr != null && jArr.length == 0 && smallScreenMultiVideoControlUI3.L == 3000 && smallScreenMultiVideoControlUI3.K == 0) {
                    long[] E = smallScreenMultiVideoControlUI3.E.E(valueOf);
                    if (r.h0() == null || SmallScreenMultiVideoControlUI.this.J || E == null) {
                        return;
                    }
                    r.h0().Q2(E);
                    r.h0().T0(E, false, null);
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void Q(int i3, long j3, int i16) {
            if (SmallScreenMultiVideoControlUI.this.M != 1) {
                return;
            }
            if (i16 == 101) {
                r.h0().y("SmallScreenMultiVideoControlUI.onSpeakModeChanged", SmallScreenMultiVideoControlUI.this.J(), false);
                n.e().f().f73013d1 = true;
            } else if (i16 == 104) {
                n.e().f().f73009c1 = 104;
            } else if (i16 == 107) {
                n.e().f().f73009c1 = 107;
            } else {
                if (i16 != 108) {
                    return;
                }
                n.e().f().f73009c1 = 108;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void R() {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo --> Start");
            }
            SmallScreenService smallScreenService = (SmallScreenService) SmallScreenMultiVideoControlUI.this.D.get();
            SmallScreenRelativeLayout B = smallScreenService == null ? null : smallScreenService.B(1);
            if (B != null) {
                B.post(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SmallScreenMultiVideoControlUI.this.Q();
                    }
                });
            } else if (QLog.isColorLevel()) {
                QLog.e("SmallScreenMultiVideoControlUI", 2, "onUpdatePstnInfo-->Can not get AVActivity");
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void T(long j3, long j16, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onVideoSrcTypeChange-->mGroupId=" + SmallScreenMultiVideoControlUI.this.J() + " userUin=" + j16 + " groupUin=" + j3 + " videoSrcType=" + i3 + " relationType" + i16);
            }
            if (j3 == SmallScreenMultiVideoControlUI.this.J() && i16 == 1) {
                SmallScreenMultiVideoControlUI.this.V(j16, 10, false, i3);
                if (SmallScreenMultiVideoControlUI.this.E == null) {
                    return;
                }
                if (i3 == 2 && n.e().f().O) {
                    SmallScreenMultiVideoControlUI.this.E.k0(new Object[]{111, Boolean.TRUE});
                } else {
                    SmallScreenMultiVideoControlUI.this.E.k0(new Object[]{111, Boolean.FALSE});
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            VideoAppInterface videoAppInterface;
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onCreateRoomSuc-->GroupID=" + j16);
            }
            SmallScreenMultiVideoControlUI.this.X();
            n.e().f().f73097x1 = true;
            SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
            if (smallScreenMultiVideoControlUI.L == 1 && (videoAppInterface = smallScreenMultiVideoControlUI.E) != null) {
                videoAppInterface.V(smallScreenMultiVideoControlUI.J());
            }
            if (n.e().f().f73060o0) {
                SmallScreenMultiVideoControlUI.this.c0(j3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void i(final long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onDestroyUI");
            }
            super.i(j3);
            VideoAppInterface videoAppInterface = SmallScreenMultiVideoControlUI.this.E;
            if (videoAppInterface == null) {
                return;
            }
            videoAppInterface.M().postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoAppInterface videoAppInterface2;
                    if (SmallScreenMultiVideoControlUI.this.J() != j3 || (videoAppInterface2 = SmallScreenMultiVideoControlUI.this.E) == null || videoAppInterface2.getApp() == null || ea.U0(SmallScreenMultiVideoControlUI.this.E.getApp().getApplicationContext()).getBoolean("kick_out_self", false)) {
                        return;
                    }
                    SmallScreenMultiVideoControlUI.this.H(true);
                }
            }, 1500L);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(final long j3, long j16) {
            VideoAppInterface videoAppInterface;
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onEnterRoomSuc-->GroupID=" + j16 + " " + n.e().f().f73062o2);
            }
            SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
            if (smallScreenMultiVideoControlUI.E == null) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onEnterRoomSuc return");
                return;
            }
            smallScreenMultiVideoControlUI.X();
            VideoAppInterface videoAppInterface2 = SmallScreenMultiVideoControlUI.this.E;
            if (videoAppInterface2 != null) {
                videoAppInterface2.M().postDelayed(new AutoCheckVideoRunnable(), 500L);
            }
            if (r.h0() == null || SmallScreenMultiVideoControlUI.this.J || n.e().f() == null) {
                return;
            }
            if (n.e().f().f73062o2 && (videoAppInterface = SmallScreenMultiVideoControlUI.this.E) != null) {
                videoAppInterface.M().postDelayed(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.MyGAudioUIObserver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (r.h0() == null || SmallScreenMultiVideoControlUI.this.J || !n.e().f().f73062o2) {
                            return;
                        }
                        r.h0().P2(j3, 4, false, false);
                        r.h0().L0();
                    }
                }, 500L);
            }
            if (n.e().f().f73060o0) {
                SmallScreenMultiVideoControlUI.this.c0(j3);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void l(long j3, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onFirstFrameDataComeIn");
            }
            SmallScreenMultiVideoControlUI.this.W("onFirstFrameDataComeIn");
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void q(long j3, int i3) {
            SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
            if (j3 == smallScreenMultiVideoControlUI.P || j3 == 0) {
                return;
            }
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 0) {
                    return;
                } else {
                    z16 = false;
                }
            }
            smallScreenMultiVideoControlUI.S(z16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void u(long j3, long j16, boolean z16, boolean z17) {
            int i3;
            int i16;
            super.u(j3, j16, z16, z17);
            if (z16) {
                i3 = 7;
                i16 = 78;
            } else {
                i3 = 8;
                i16 = 79;
            }
            SmallScreenMultiVideoControlUI.this.V(j16, i3, false, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void w(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->groupid=" + j3 + " info=" + j16 + " strMsg=" + str);
            }
            SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
            if (smallScreenMultiVideoControlUI.M == 1 && j3 == smallScreenMultiVideoControlUI.J()) {
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 33);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", SmallScreenMultiVideoControlUI.this.L);
                intent.putExtra("info", j16);
                intent.putExtra("strMsg", str);
                intent.putExtra("MultiAVType", n.e().f().f73063p);
                intent.putExtra("from", "SmallScreenMultiVideoControlUI1");
                SmallScreenService smallScreenService = (SmallScreenService) SmallScreenMultiVideoControlUI.this.D.get();
                if (smallScreenService != null) {
                    VideoAppInterface videoAppInterface = SmallScreenMultiVideoControlUI.this.E;
                    if (videoAppInterface != null) {
                        intent.setPackage(videoAppInterface.getApplication().getPackageName());
                    }
                    smallScreenService.sendBroadcast(intent);
                    smallScreenService.stopSelf();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupSecurityLimit-->can not get the activity");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void x(long j3, long j16, boolean z16) {
            if (SmallScreenMultiVideoControlUI.this.M != 1) {
                return;
            }
            n.e().f().f73037i1 = false;
            boolean z17 = n.e().f().N;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void y(long j3, long j16, boolean z16) {
            if (SmallScreenMultiVideoControlUI.this.M != 1) {
                return;
            }
            n.e().f().f73037i1 = true;
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void z(long j3, int i3, int i16) {
            long J = SmallScreenMultiVideoControlUI.this.J();
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenMultiVideoControlUI", 1, "onGroupVideoChatClosed, relationId[" + j3 + "], curGroupId[" + J + "]");
            }
            if (J == j3 && SmallScreenMultiVideoControlUI.this.M == 1) {
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 32);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", SmallScreenMultiVideoControlUI.this.L);
                intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, i3);
                intent.putExtra("MultiAVType", i16);
                intent.putExtra("from", "SmallScreenMultiVideoControlUI2");
                SmallScreenService smallScreenService = (SmallScreenService) SmallScreenMultiVideoControlUI.this.D.get();
                if (smallScreenService != null) {
                    VideoAppInterface videoAppInterface = SmallScreenMultiVideoControlUI.this.E;
                    if (videoAppInterface != null) {
                        intent.setPackage(videoAppInterface.getApplication().getPackageName());
                    }
                    smallScreenService.sendBroadcast(intent);
                    SmallScreenMultiVideoControlUI.this.H(true);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("SmallScreenMultiVideoControlUI", 2, "onGroupVideoChatClosed-->can not get the activity");
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void r(long j3, boolean z16, boolean z17) {
            if (j3 != 0) {
                SmallScreenMultiVideoControlUI smallScreenMultiVideoControlUI = SmallScreenMultiVideoControlUI.this;
                if (j3 == smallScreenMultiVideoControlUI.P) {
                    return;
                }
                smallScreenMultiVideoControlUI.S(z16);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void v(long j3, int i3, long j16, long j17, long j18, int i16) {
            boolean z16;
            switch (i3) {
                case 90:
                    if (j17 == 3) {
                        ArrayList<com.tencent.av.gaudio.c> arrayList = n.e().f().f73045k1;
                        int i17 = 0;
                        while (true) {
                            if (i17 < arrayList.size()) {
                                com.tencent.av.gaudio.c cVar = arrayList.get(i17);
                                if (j16 == cVar.f73827a && cVar.f73828b == 1) {
                                    z16 = cVar.f73829c;
                                } else {
                                    i17++;
                                }
                            } else {
                                z16 = false;
                            }
                        }
                        ControlUIObserver controlUIObserver = SmallScreenMultiVideoControlUI.this.F;
                        if (controlUIObserver != null) {
                            controlUIObserver.update(null, new Object[]{105, Boolean.valueOf(z16), Long.valueOf(j3)});
                        }
                        SmallScreenMultiVideoControlUI.this.b0();
                        return;
                    }
                    return;
                case 91:
                case 92:
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenMultiVideoControlUI", 2, "go on stage failed");
                    }
                    if (SmallScreenMultiVideoControlUI.this.M == 2) {
                        ReportController.o(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                case 93:
                case 94:
                case 95:
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenMultiVideoControlUI", 2, "Go Off Stage-->roomMode=" + n.e().f().f73009c1 + " isBeBan" + n.e().f().f73032h1 + " isPressSpeaking=" + n.e().f().f73013d1 + " isOnlyManagerCanOnStage=" + n.e().f().f73017e1);
                        return;
                    }
                    return;
                case 96:
                    if (QLog.isColorLevel()) {
                        QLog.w("SmallScreenMultiVideoControlUI", 1, "onGaOperationResult, EV_GA_SDK_REQUEST_VIDEO_SUC, info[" + j17 + "], seq[" + j3 + "]");
                    }
                    if (j17 == 1) {
                        SmallScreenMultiVideoControlUI.this.B("onGaOperationResult");
                        SmallScreenMultiVideoControlUI.this.b0();
                        SmallScreenMultiVideoControlUI.this.R(j3, n.e().f().f73045k1);
                        return;
                    }
                    return;
                case 97:
                case 98:
                    if (QLog.isColorLevel()) {
                        QLog.d("SmallScreenMultiVideoControlUI", 2, "request video failed");
                    }
                    SmallScreenMultiVideoControlUI.this.V(j16, i3, false, -1);
                    return;
                default:
                    return;
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void j() {
        }
    }

    void F(int i3, long j3, boolean z16, int i16) {
        String str;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w("SmallScreenMultiVideoControlUI", 1, "drawUI, type[" + i3 + "], uin[" + j3 + "], fresh[" + z16 + "], originalType[" + i16 + "], seq[" + d16 + "]");
        }
        if (r.h0() == null || this.J || this.E == null) {
            return;
        }
        if (i3 != 0 || r.h0() == null || j3 == this.P || !n.e().f().f73097x1 || n.e().f().f73063p == 2) {
            str = "SmallScreenMultiVideoControlUI";
        } else {
            str = "SmallScreenMultiVideoControlUI";
            TraeHelper.I().g0(d16, this.E, R.raw.qav_gaudio_join, null, 0, null);
        }
        if (i3 == 0 || i3 == 1) {
            M(i3);
            return;
        }
        if (i3 == 5 || i3 == 6) {
            O(d16, i3, j3);
            return;
        }
        if (i3 == 7 || i3 == 8) {
            N(d16, i3, j3);
            return;
        }
        if (i3 != 97 && i3 != 98) {
            if (i3 == 10) {
                P(d16, i3);
            }
        } else if (QLog.isColorLevel()) {
            QLog.e(str, 2, "Request remote video failed.Uin = " + j3 + ",type=" + i3);
        }
    }

    void Z(boolean z16, boolean z17, boolean z18) {
        if (z16) {
            int i3 = this.M;
            if (i3 == 2) {
                if (!NetworkUtil.isWifiConnected(I())) {
                    ReportController.o(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
                }
            } else if (i3 == 1) {
                if (NetworkUtil.isWifiConnected(I())) {
                    ReportController.o(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
                }
            }
            if (z17) {
                cw.e.n(this.E, 3015);
            } else {
                cw.e.d(this.E, 3015);
            }
        } else {
            cw.e.d(this.E, 3015);
            cw.e.d(this.E, 1030);
        }
        if (z18) {
            R(com.tencent.av.utils.e.d(), n.e().f().f73045k1);
        }
    }

    void N(long j3, int i3, long j16) {
        if (i3 == 8) {
            com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
            cVar.f73827a = j16;
            cVar.f73828b = 2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            ControlUIObserver controlUIObserver = this.F;
            if (controlUIObserver != null) {
                controlUIObserver.update(null, new Object[]{104, arrayList});
            }
        } else if (this.M == 2) {
            ReportController.o(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
        }
        boolean C = i3 == 8 ? C() : true;
        if ((n.e().f().f73060o0 || n.e().f().f73097x1) && C && this.f74530e < 4) {
            if (!NetworkUtil.isWifiConnected(I()) && !NetworkUtil.isMobileNetWork(I()) && n.e().f().o() == -1 && !n.e().f().C1) {
                n.e().f().w0(j3, "drawUI.2", true, true);
                b0();
                Z(true, true, true);
                return;
            }
            VideoAppInterface videoAppInterface = this.E;
            if (videoAppInterface != null) {
                videoAppInterface.M().removeCallbacks(this.Z);
                this.Z.f74502d = "DrawUI:TYPE=" + String.valueOf(i3);
                this.E.M().postDelayed(this.Z, 1000L);
            }
        }
    }
}
