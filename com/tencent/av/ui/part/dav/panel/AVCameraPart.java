package com.tencent.av.ui.part.dav.panel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.fragment.NTMultiVideoBaseFragment;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.af;
import com.tencent.av.utils.at;
import com.tencent.av.utils.i;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mw.h;
import mw.j;
import mw.k;
import org.slf4j.Marker;

/* loaded from: classes32.dex */
public class AVCameraPart extends com.tencent.av.ui.part.base.panel.e {

    /* renamed from: m, reason: collision with root package name */
    static int f76380m = 16;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76381h;

    /* renamed from: i, reason: collision with root package name */
    private e f76382i;

    /* loaded from: classes32.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76383d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f76384e;

        a(long j3, k kVar) {
            this.f76383d = j3;
            this.f76384e = kVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (AVCameraPart.this.getActivity().isDestroyed()) {
                return;
            }
            if (n.e().f().o() == -1) {
                AVCameraPart.this.J9(this.f76383d);
            } else if (AVCameraPart.this.I9()) {
                AVCameraPart.this.f76381h = true;
                this.f76384e.updateBtn(this.f76383d, 33554431);
            } else if (QLog.isColorLevel()) {
                QLog.e(AVCameraPart.this.f76368d, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
            }
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76387d;

        c(long j3) {
            this.f76387d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (r.h0() != null && AVCameraPart.this.I9()) {
                AVCameraPart.this.f76381h = true;
                k kVar = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, AVCameraPart.this.getPartRootView(), null);
                kVar.h();
                kVar.updateBtn(this.f76387d, 33554431);
                n.e().f().C1 = true;
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public AVCameraPart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76381h = false;
        this.f76382i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(long j3, int i3) {
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isDestroyed()) {
            return;
        }
        if (!com.tencent.av.camera.b.a(getContext()).isCameraOpening(j3) && !com.tencent.av.camera.b.a(getContext()).isCameraOpened(j3)) {
            if (r.h0() != null) {
                n.e().f().f73066p2 = i3;
            }
            aVActivity.I0.i1(j3, 33554431);
        } else if (QLog.isColorLevel()) {
            QLog.w(this.f76368d, 1, "enableCameraRelatedBtn, cameraAvailable[" + i3 + "], already opening or opened");
        }
    }

    private boolean K9() {
        return r.h0() != null && n.e().f().N;
    }

    private boolean L9() {
        return yt.e.c(nw.b.b().getCurrentAccountUin());
    }

    private boolean M9() {
        return n.e().f().f73067q == 1044;
    }

    private void Y9(boolean z16, boolean z17) {
        Integer num;
        String str;
        if (this.f76370f == null) {
            QLog.e(this.f76368d, 1, "updateBtnCameraExpImage error: mQavPanel is null.");
            return;
        }
        boolean K9 = K9();
        if (com.tencent.av.utils.e.j()) {
            QLog.w(this.f76368d, 1, "updateBtn_CameraExpImage, null, localHasVideo[" + K9 + "]");
        }
        ImageButton imageButton = (ImageButton) this.f76370f.h1(m.l.D);
        if (imageButton != null) {
            int intValue = ((Integer) imageButton.getTag()).intValue();
            if (K9) {
                num = com.tencent.av.camera.b.f73501a;
            } else {
                num = com.tencent.av.camera.b.f73502b;
            }
            int intValue2 = num.intValue();
            int i3 = !K9 ? R.drawable.n6y : R.drawable.n6z;
            if (intValue != intValue2 || z17) {
                imageButton.setImageDrawable(imageButton.getResources().getDrawable(i3));
                imageButton.setTag(new Integer(intValue2));
                if (K9) {
                    str = "\u5173\u95ed\u6444\u50cf\u5934";
                } else {
                    str = "\u5f00\u542f\u6444\u50cf\u5934";
                }
                imageButton.setContentDescription(str);
            }
        } else {
            QLog.e(this.f76368d, 1, "updateBtnCameraExpImage can not find ABTest_Camera.");
        }
        if (z16) {
            this.f76370f.setViewEnable(m.b.f75998b, H9(-1L));
        }
    }

    boolean F9() {
        VideoAppInterface b16 = nw.b.b();
        if (AVCoreSystemInfo.isNormalSharp() && tv.c.c(b16.getApp()) != 1) {
            int r06 = r.h0().r0();
            if (r06 < f76380m) {
                return true;
            }
            QLog.d(this.f76368d, 1, "checkCanClickCamera onstageNum=" + r06);
            cw.e.n(b16, 1031);
            return false;
        }
        VideoUtil.o(b16);
        QLog.d(this.f76368d, 1, "checkCanClickCamera failed");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0109, code lost:
    
        if (r0.J2 != false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean H9(long j3) {
        boolean z16;
        boolean z17 = false;
        if (tv.c.c(getContext()) == 1) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "getCameraEnable, GLVersion, seq[" + j3 + "]");
            }
        } else {
            if (r.h0() == null) {
                return false;
            }
            SessionInfo f16 = n.e().f();
            if (f16.f73067q != 1044) {
                int i3 = f16.f73035i;
                if (i3 != 1 && i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        if (f16.f73060o0) {
                            if (!f16.f73064p0) {
                                if (com.tencent.av.utils.e.j()) {
                                    QLog.w(this.f76368d, 1, "getCameraEnable, not enter room for meeting, seq[" + j3 + "]");
                                }
                            }
                            if (com.tencent.av.zplan.e.c(r.h0().Y())) {
                                z16 = false;
                            }
                        } else {
                            if (!r.h0().W0()) {
                                if (com.tencent.av.utils.e.j()) {
                                    QLog.w(this.f76368d, 1, "getCameraEnable, \u6ca1\u6709\u8fdb\u5165\u623f\u95f4, seq[" + j3 + "]");
                                }
                            }
                            if (com.tencent.av.zplan.e.c(r.h0().Y())) {
                            }
                        }
                    }
                    z16 = true;
                } else if (!f16.K() && !f16.w() && !f16.x()) {
                    if (!r.h0().e()) {
                        if (com.tencent.av.utils.e.j()) {
                            QLog.w(this.f76368d, 1, "getCameraEnable, !canAVShift, seq[" + j3 + "]");
                        }
                    } else {
                        if (f16.f73035i == 1) {
                            if (!f16.I2) {
                            }
                        }
                        z16 = true;
                    }
                } else if (com.tencent.av.utils.e.j()) {
                    QLog.w(this.f76368d, 1, "getCameraEnable, state[" + f16.f73043k + "], seq[" + j3 + "]");
                }
                if (!f16.T) {
                    if (com.tencent.av.utils.e.j()) {
                        QLog.w(this.f76368d, 1, "getCameraEnable, cameraPermission, seq[" + j3 + "]");
                    }
                } else if (f16.f73066p2 == 0) {
                    if (com.tencent.av.utils.e.j()) {
                        QLog.w(this.f76368d, 1, "getCameraEnable, mCameraAvailable, seq[" + j3 + "]");
                    }
                } else if (!com.tencent.av.camera.b.a(getContext()).isCameraOpening(j3)) {
                    z17 = z16;
                } else if (com.tencent.av.utils.e.j()) {
                    QLog.w(this.f76368d, 1, "getCameraEnable, isCameraOpening, seq[" + j3 + "]");
                }
            }
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "getCameraEnable, enable[" + z17 + "], seq[" + j3 + "]");
        }
        return z17;
    }

    boolean I9() {
        if (QLog.isColorLevel()) {
            QLog.d(this.f76368d, 2, "Go on Stage");
        }
        if (r.h0() != null) {
            return r.h0().L0();
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.e(this.f76368d, 2, "Go On Stage, VideoController is null");
        return false;
    }

    void J9(long j3) {
        Context context = getContext();
        String str = this.f76368d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("goOnStageWithoutWiFiCheck, mContext[");
        sb5.append(context != null);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        if (context == null) {
            return;
        }
        DialogUtil.createCustomDialog(context, 230, (String) null, context.getResources().getString(n.e().f().P() ? R.string.f171251dg3 : R.string.f171252dg4), R.string.d_2, R.string.d_d, new c(j3), new d()).show();
    }

    public void O9(long j3, View view) {
        h hVar = (h) RFWIocAbilityProvider.g().getIocInterface(h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.CAMERA, view, null)) {
            SessionInfo f16 = n.e().f();
            f16.f73062o2 = false;
            VideoAppInterface b16 = nw.b.b();
            k kVar = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null);
            if (!f16.N) {
                kVar.e(j3);
                b16.k0(new Object[]{105, Boolean.FALSE, Long.valueOf(j3)});
                if (QLog.isColorLevel()) {
                    QLog.w(this.f76368d, 1, "onClick, Open Camera, seq[" + j3 + "]");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f76368d, 1, "onClick, Close Camera, seq[" + j3 + "]");
                }
                kVar.onBeforeCloseCamera(j3);
                b16.k0(new Object[]{106, Long.valueOf(j3)});
                r.h0().K0();
                if (getPartHost() instanceof NTBaseVideoFragment) {
                    ((NTBaseVideoFragment) getPartHost()).lk(j3, 33554431);
                }
            }
            ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
        }
        A9(j3, m.e.f76014a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P9(long j3, View view) {
        SessionInfo f16 = n.e().f();
        QLog.w(this.f76368d, 1, "onClick_CAMERA, sessionInfo[" + f16 + "], mHasLauncnRequestFromCameraButton[" + this.f76381h + "], seq[" + j3 + "]");
        h hVar = (h) RFWIocAbilityProvider.g().getIocInterface(h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.CAMERA, view, null)) {
            if (!f16.N) {
                if (!F9()) {
                    return;
                }
                boolean z16 = false;
                if (E9(nw.b.b(), getContext().getResources(), false)) {
                    return;
                }
                DataReport.I(true);
                k kVar = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null);
                if (!NetworkUtil.isWifiConnected(getContext())) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(r.f74233b);
                    sb5.append(nw.b.b().getCurrentAccountUin());
                    if (r.C0(sb5.toString()) <= 0) {
                        Context context = getContext();
                        if (context == null) {
                            return;
                        }
                        Resources resources = context.getResources();
                        DialogUtil.createCustomDialog(context, 230, resources.getString(R.string.dfp), resources.getString(R.string.dfm), R.string.d_2, R.string.d_d, new a(j3, kVar), new b()).show();
                        if (z16) {
                            if (f16.o() == -1 && !NetworkUtil.isWifiConnected(getContext())) {
                                J9(j3);
                            } else if (I9()) {
                                this.f76381h = true;
                                kVar.updateBtn(j3, 33554431);
                            } else if (QLog.isColorLevel()) {
                                QLog.e(this.f76368d, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
                            }
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            } else {
                if (getPartHost() instanceof NTMultiVideoBaseFragment) {
                    ((NTMultiVideoBaseFragment) getPartHost()).Xk(j3);
                }
                r.h0().h2(Long.valueOf(nw.b.b().getCurrentAccountUin()).longValue(), f16.f73045k1, f16.f73053m1, 1, false);
            }
        }
        A9(j3, m.e.f76014a);
    }

    public void Q9(long j3) {
        int i3;
        String str;
        QLog.w(this.f76368d, 1, "onClick, switch_camera, seq[" + j3 + "]");
        com.tencent.av.utils.c.a("switch_camera", "switch_camera", 1, Long.valueOf(j3));
        VideoAppInterface b16 = nw.b.b();
        if (b16 == null) {
            QLog.d(this.f76368d, 1, "onClickSwitchCamera error. app is null");
            return;
        }
        b16.k0(new Object[]{107, Long.valueOf(j3)});
        if (r.h0() == null) {
            QLog.d(this.f76368d, 1, "onClickSwitchCamera error. VideoController.getInstance() is null");
            return;
        }
        n.e().f().R = !n.e().f().R;
        if (n.e().f().R) {
            DataReport.T(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
            i3 = R.string.bhq;
        } else {
            DataReport.T(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
            i3 = R.string.bhp;
        }
        if (this.f76370f != null) {
            Resources resources = getContext().getResources();
            if (resources != null) {
                str = resources.getString(i3);
            } else {
                str = "";
            }
            this.f76370f.Q0(m.l.B, str);
        }
    }

    public boolean S9(long j3) {
        int i3;
        boolean L9 = L9();
        boolean H9 = H9(j3);
        int i16 = 0;
        if (r.h0() == null) {
            return false;
        }
        SessionInfo f16 = n.e().f();
        if (f16.f73035i == 1 && !f16.z()) {
            i16 = 8;
        }
        if (!L9 && (i3 = f16.f73046k2) != 2 && i3 != 1) {
            V9(j3, H9, i16);
        } else {
            W9(H9, i16);
        }
        return H9;
    }

    public void T9(long j3) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return;
        }
        rw.a M = qavPanel.M(m.e.f76014a);
        if (M == null) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Camera, null, seq[" + j3 + "]");
                return;
            }
            return;
        }
        if (r.h0() == null) {
            return;
        }
        if (n.e().f().N) {
            M.l(R.drawable.dcq);
            M.j("\u5173\u95ed\u6444\u50cf\u5934");
        } else {
            M.l(R.drawable.n7f);
            M.j("\u6253\u5f00\u6444\u50cf\u5934");
        }
    }

    public boolean U9(boolean z16, long j3) {
        boolean H9 = H9(j3);
        int i3 = z16 ? 0 : 8;
        if (r.h0() == null) {
            return false;
        }
        SessionInfo f16 = n.e().f();
        W9(H9, (f16.f73035i != 1 || f16.z()) ? i3 : 8);
        return H9;
    }

    public void V9(long j3, boolean z16, int i3) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return;
        }
        rw.a M = qavPanel.M(m.e.f76014a);
        if (M == null) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Camera, null, seq[" + j3 + "]");
                return;
            }
            return;
        }
        if (M9()) {
            z16 = false;
        }
        if (r.h0() != null && n.e().f() != null) {
            SessionInfo f16 = n.e().f();
            if (f16.f73098x2 || f16.f73102y2) {
                z16 = false;
            }
        }
        M.n(i3 == 0);
        M.k(!z16);
        M.i(z16);
    }

    public void Z9() {
        SessionInfo f16;
        if (this.f76370f == null || r.h0() == null || (f16 = n.e().f()) == null || this.f76370f == null) {
            return;
        }
        int cameraNum = ((ICameraUtilsStaticApi) QRoute.api(ICameraUtilsStaticApi.class)).getInstance(getContext()).getCameraNum();
        if (f16.N) {
            QLog.d(this.f76368d, 1, "updateBtnSwitchCamera cameraNum=" + cameraNum);
        }
        if (f16.N && cameraNum > 1 && !f16.f73098x2 && !f16.f73102y2) {
            this.f76370f.setViewVisibility(m.l.B, 0);
        } else {
            this.f76370f.setViewVisibility(m.l.B, 8);
        }
    }

    public void onCreate() {
        if (this.f76382i == null) {
            this.f76382i = new e();
            if (getContext() != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f76368d, 2, "register camera availability change receiver");
                }
                Context applicationContext = getContext().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.qav.camera.availability");
                if (applicationContext != null) {
                    applicationContext.registerReceiver(this.f76382i, intentFilter);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f76368d, 2, "CANNOT register camera availability change receiver!");
            }
        }
    }

    @Override // com.tencent.av.ui.part.base.panel.e
    public void onDestroy() {
        super.onDestroy();
        if (this.f76382i != null) {
            Context applicationContext = getContext().getApplicationContext();
            if (applicationContext != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f76368d, 2, "UnRegister camera availability change receiver");
                }
                applicationContext.unregisterReceiver(this.f76382i);
                this.f76382i = null;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f76368d, 2, "CANNOT UnRegister camera availability change receiver!!");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76381h = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i3;
            if (intent == null || r.h0() == null) {
                return;
            }
            long a16 = at.a(intent);
            String stringExtra = intent.getStringExtra("camera_id");
            int intExtra = intent.getIntExtra("availability", 1);
            QLog.w(AVCameraPart.this.f76368d, 1, "CameraAvailabilityReceiver, cameraId[" + stringExtra + "], availability[" + intExtra + "], mCameraAvailable[" + n.e().f().f73066p2 + "], seq[" + a16 + "]");
            VideoAppInterface b16 = nw.b.b();
            if (b16 == null) {
                return;
            }
            b16.G0(stringExtra, intExtra);
            if (intExtra == 0) {
                AVCameraPart.this.G9(a16, intExtra);
                return;
            }
            Map<String, Integer> C = b16.C();
            if (C != null && C.size() > 0) {
                Iterator<Map.Entry<String, Integer>> it = C.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().intValue() == 0) {
                        i3 = 0;
                        break;
                    }
                }
            }
            i3 = -1;
            AVCameraPart.this.G9(a16, i3);
        }
    }

    public void W9(boolean z16, int i3) {
        Y9(false, false);
        if (M9()) {
            i3 = 8;
            z16 = false;
        }
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            QLog.e(this.f76368d, 1, "updateBtnCameraExp error: mQavPanel is null.");
            return;
        }
        int i16 = m.b.f75998b;
        qavPanel.setViewVisibility(i16, i3);
        this.f76370f.setViewEnable(i16, z16);
        QLog.w(this.f76368d, 1, "updateBtn_CameraExp, null, enable[" + z16 + "]");
        rw.a M = this.f76370f.M(m.e.f76014a);
        if (M != null) {
            M.n(false);
        }
    }

    public void X9(boolean z16) {
        Y9(true, z16);
    }

    public void R9(long j3, long j16, int i3) {
        VideoAppInterface b16 = nw.b.b();
        if (j3 == 2) {
            cw.e.n(b16, 1029);
            return;
        }
        if (j3 != 4) {
            if (j3 == 8) {
                if (this.f76381h) {
                    this.f76381h = false;
                    cw.e.p(b16, 1033, getContext().getResources().getString(R.string.f171253w35));
                    return;
                }
                return;
            }
            if (j3 == 9 && this.f76381h) {
                this.f76381h = false;
                cw.e.p(b16, 1033, getContext().getResources().getString(R.string.w36));
                return;
            }
            return;
        }
        if (!(j16 == b16.getLongAccountUin() && !n.e().f().N)) {
            cw.e.n(b16, 1031);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(this.f76368d, 2, "VideoConstants.GaChatOperationResult.EV_GA_SDK_GO_ON_STAGE_SUC with repeat message " + this.f76381h);
            }
            if (this.f76381h) {
                cw.e.n(b16, 1031);
                this.f76381h = false;
            }
        }
        if (i3 == 2) {
            ReportController.o(null, "CliOper", "", "", "0X8004CFD", "0X8004CFD", 0, 0, "", "", "", "");
        }
    }

    public void N9(long j3, View view) {
        VideoAppInterface b16 = nw.b.b();
        h hVar = (h) RFWIocAbilityProvider.g().getIocInterface(h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.CAMERA, view, null)) {
            SessionInfo f16 = n.e().f();
            DataReport.p();
            k kVar = (k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null);
            int i3 = f16.f73035i;
            if (i3 == 1) {
                com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
                String str = f16.f73091w;
                if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    str = str.substring(1);
                }
                cVar.f73827a = i.g(str);
                cVar.f73828b = 1;
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar);
                b16.k0(new Object[]{104, arrayList});
                if (kVar != null) {
                    kVar.e(j3);
                }
                b16.k0(new Object[]{105, Boolean.FALSE, Long.valueOf(j3)});
                if (QLog.isColorLevel()) {
                    QLog.w(this.f76368d, 1, "onClick_Camera, open1, seq[" + j3 + "]");
                }
                DataReport.T(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
                if (f16.f73052m0) {
                    b16.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.dav.panel.AVCameraPart.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j jVar = (j) RFWIocAbilityProvider.g().getIocInterface(j.class, AVCameraPart.this.getPartRootView(), null);
                            if (jVar != null) {
                                jVar.childLock();
                            }
                        }
                    }, 500L);
                }
            } else if (i3 == 2) {
                if (f16.N) {
                    if (kVar != null) {
                        kVar.onBeforeCloseCamera(j3);
                    }
                    b16.k0(new Object[]{106, Long.valueOf(j3)});
                    if (QLog.isColorLevel()) {
                        QLog.w(this.f76368d, 1, "onClick_Camera, close, seq[" + j3 + "]");
                    }
                } else {
                    if (kVar != null) {
                        kVar.e(j3);
                    }
                    b16.k0(new Object[]{105, Boolean.FALSE, Long.valueOf(j3)});
                    if (QLog.isColorLevel()) {
                        QLog.w(this.f76368d, 1, "onClick_Camera, open2, seq[" + j3 + "]");
                    }
                }
            }
        }
        A9(j3, m.e.f76014a);
    }

    public boolean E9(VideoAppInterface videoAppInterface, Resources resources, boolean z16) {
        SessionInfo f16 = n.e().f();
        boolean v3 = af.v();
        boolean z17 = (f16.f73037i1 || f16.f73041j1) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.w(this.f76368d, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + v3 + "], isNormalUser[" + z17 + "], isRoomMicOff[" + f16.W0 + "], micAuthByAdmin[" + f16.X0 + "], openMic[" + z16 + "]");
        }
        if (z17 && f16.W0 && f16.X0 != 0) {
            cw.e.p(videoAppInterface, 1033, resources.getString(z16 ? R.string.vu_ : R.string.f171253w35));
            ReportController.o(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", z16 ? 1 : 2, 0, "1", "", "", "");
            return true;
        }
        if (v3 || !z17 || f16.X0 != 1) {
            return false;
        }
        cw.e.p(videoAppInterface, 1033, resources.getString(z16 ? R.string.vub : R.string.w36));
        ReportController.o(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", z16 ? 1 : 2, 0, "2", "", "", "");
        return true;
    }
}
