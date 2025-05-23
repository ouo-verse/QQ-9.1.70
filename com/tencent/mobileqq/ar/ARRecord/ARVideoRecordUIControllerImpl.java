package com.tencent.mobileqq.ar.ARRecord;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARRecord.b;
import com.tencent.mobileqq.ar.ARRecord.g;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionGrant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARVideoRecordUIControllerImpl implements b.a, Handler.Callback, g.a {
    public static final String Z = HardCodeUtil.qqStr(R.string.jrw);

    /* renamed from: a0, reason: collision with root package name */
    public static final String f196984a0 = HardCodeUtil.qqStr(R.string.jrx);

    /* renamed from: b0, reason: collision with root package name */
    public static final String f196985b0 = HardCodeUtil.qqStr(R.string.jrs);

    /* renamed from: c0, reason: collision with root package name */
    public static final String f196986c0 = HardCodeUtil.qqStr(R.string.jrt);

    /* renamed from: d0, reason: collision with root package name */
    public static final String f196987d0 = HardCodeUtil.qqStr(R.string.jrv);

    /* renamed from: e0, reason: collision with root package name */
    public static final String f196988e0 = HardCodeUtil.qqStr(R.string.jrz);

    /* renamed from: f0, reason: collision with root package name */
    public static final String f196989f0 = HardCodeUtil.qqStr(R.string.jru);

    /* renamed from: g0, reason: collision with root package name */
    public static final String f196990g0 = HardCodeUtil.qqStr(R.string.jry);
    private volatile com.tencent.mobileqq.ar.ARRecord.b M;
    private volatile com.tencent.mobileqq.ar.ARRecord.a N;

    @Deprecated
    private Context T;
    private boolean U;
    private Activity W;
    private boolean X;
    private QQPermission Y;

    /* renamed from: d, reason: collision with root package name */
    private final int f196991d = 1;

    /* renamed from: e, reason: collision with root package name */
    private final int f196992e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final int f196993f = 3;

    /* renamed from: h, reason: collision with root package name */
    private final int f196994h = 4;

    /* renamed from: i, reason: collision with root package name */
    private final int f196995i = 5;

    /* renamed from: m, reason: collision with root package name */
    private final int f196996m = 6;
    private final int C = 7;
    private final int D = 8;
    private final int E = 9;
    private final int F = 10;
    private final int G = 12;
    private final int H = 13;
    private boolean I = false;
    private boolean J = false;
    private HandlerThread K = null;
    private Handler L = null;
    private int P = 0;
    private boolean Q = false;
    private boolean R = false;
    private int S = -1;
    private boolean V = true;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION allow restart it");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final ARVideoRecordUIControllerImpl f197001a = new ARVideoRecordUIControllerImpl();
    }

    ARVideoRecordUIControllerImpl() {
        this.U = true;
        this.U = e.c();
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "ARVideoRecordUIControllerImpl mIsEnableVideoRecord" + this.U);
        }
    }

    private void A(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleVideoRecordErrorStatus " + i3);
        }
        if (this.I) {
            this.M.d(0);
            if (!this.Q) {
                if (i3 == 11) {
                    ARRecordUtils.h(Z, false);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), 1, ARVideoRecordUIControllerImpl.f196984a0, 1).show();
                        }
                    });
                }
            } else {
                this.Q = false;
            }
            this.R = false;
        } else {
            if (this.M != null) {
                this.M.d(0);
                this.M.hide();
            }
            if (!this.Q) {
                if (i3 == 11) {
                    ARRecordUtils.h(Z, false);
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplication.getContext(), 1, ARVideoRecordUIControllerImpl.f196984a0, 1).show();
                        }
                    });
                }
            } else {
                this.Q = false;
            }
            this.R = false;
            r();
        }
        this.S = -1;
        q("0X8008A57");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        if (F() && this.N.isRecording()) {
            return true;
        }
        return false;
    }

    private void G(Runnable runnable) {
        Handler handler = this.L;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void q(String str) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "finalizeDestroy " + this.J);
        }
        if (this.J && !this.R) {
            Handler handler = this.L;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.L = null;
            }
            HandlerThread handlerThread = this.K;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.K = null;
            }
        }
    }

    public static ARVideoRecordUIControllerImpl t() {
        return b.f197001a;
    }

    private void u() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleDoOnResume");
        }
        this.R = false;
        this.S = -1;
    }

    private void v() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationEnd");
        }
        if (this.M != null) {
            this.M.show();
        }
    }

    private void w() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationStart");
        }
        if (!this.U) {
            return;
        }
        if (this.N != null && this.N.isRecording()) {
            this.N.d(false, true);
        }
        if (this.M != null) {
            this.M.hide();
        }
    }

    private void x(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord " + i3);
        }
        if (D()) {
            if (this.M != null) {
                this.M.d(0);
                this.M.hide();
            }
            if (i3 != 2 && i3 != 4 && i3 != 6 && i3 != 1 && i3 != 3) {
                this.N.d(false, false);
                if (QLog.isColorLevel()) {
                    QLog.i("ARVideoRecordUIControllerImpl", 2, "error branch ,should not happen");
                }
            } else {
                this.N.d(false, true);
            }
            this.S = i3;
            this.R = true;
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord normal record running");
                return;
            }
            return;
        }
        if (this.M != null) {
            this.M.hide();
        }
        if (this.N != null) {
            this.N.d(false, false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord other condition");
        }
    }

    private void y() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal");
        }
        if (this.N != null && this.M != null) {
            if (this.M.c() == 0) {
                if (!ARRecordUtils.d(GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT)) {
                    ARRecordUtils.g(f196985b0, f196986c0);
                    return;
                }
                if (!this.N.c(true, null)) {
                    ARRecordUtils.h(Z, false);
                    if (QLog.isColorLevel()) {
                        QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord failed");
                        return;
                    }
                    return;
                }
                q("0X8008A54");
                this.M.d(1);
                if (QLog.isColorLevel()) {
                    QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord end");
                    return;
                }
                return;
            }
            if (D()) {
                this.N.d(true, true);
                this.S = 7;
                this.R = true;
                q("0X8008A55");
                if (QLog.isColorLevel()) {
                    QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord and doReport");
                }
            }
            this.M.d(0);
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord end");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal with value null");
        }
    }

    private void z() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause");
        }
        if (D() && this.S == -1) {
            this.N.d(false, false);
            this.S = 5;
            this.R = false;
            q("0X8008A57");
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause mInterruptAnimationReason EXTERNAL_INTERRUPT");
            }
        } else if (this.S == -1 && this.N != null) {
            this.N.d(false, false);
        }
        com.tencent.mobileqq.ar.ARRecord.b bVar = this.M;
        if (bVar != null) {
            bVar.d(0);
            bVar.hide();
        }
    }

    public void B() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "hideVideoRecordButton");
        }
        if (this.U && this.V) {
            G(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ARVideoRecordUIControllerImpl.this.M != null) {
                        ARVideoRecordUIControllerImpl.this.M.d(0);
                        ARVideoRecordUIControllerImpl.this.M.hide();
                    }
                }
            });
        }
    }

    public void C(int i3) {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "interruptARVideoRecordIfNeed");
        }
        if (this.U && this.V && (handler = this.L) != null && this.K != null) {
            handler.removeMessages(7);
            Message obtainMessage = this.L.obtainMessage(7);
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
        }
    }

    public boolean E() {
        if (this.N != null && this.N.f() && !this.N.isRecording()) {
            return true;
        }
        return false;
    }

    public boolean F() {
        if (this.N != null && this.N.f()) {
            return true;
        }
        return false;
    }

    public void H() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "recordAnimationStartTimeStamp");
        }
        if (this.U && this.V && this.N != null) {
            this.N.e(System.currentTimeMillis());
        }
    }

    @Deprecated
    public void I(Context context) {
        this.T = context;
    }

    public void J() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "showVideoRecordButton");
        }
        if (this.U && this.V) {
            G(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("showVideoRecordButton inner run +");
                        if (ARVideoRecordUIControllerImpl.this.M != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        QLog.i("ARVideoRecordUIControllerImpl", 2, sb5.toString());
                    }
                    if (ARVideoRecordUIControllerImpl.this.M != null) {
                        ARVideoRecordUIControllerImpl.this.M.show();
                        ARVideoRecordUIControllerImpl.this.M.d(0);
                    }
                }
            });
        }
    }

    public void K(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "start");
        }
        if (!this.U) {
            return;
        }
        if (this.K == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("ARVideoRecordThread-P", 0);
            this.K = newFreeHandlerThread;
            newFreeHandlerThread.start();
            this.L = new Handler(this.K.getLooper(), this);
        }
        this.W = activity;
        this.J = false;
    }

    public void L(int i3) {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "startPreRecord " + i3);
        }
        Activity activity = this.W;
        if (activity == null) {
            return;
        }
        int checkSelfPermission = ((QBaseActivity) activity).checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO);
        if (checkSelfPermission == 0) {
            int checkSelfPermission2 = ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            int checkSelfPermission3 = ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
            if (checkSelfPermission2 != 0 || checkSelfPermission3 != 0) {
                checkSelfPermission = -1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("startPreRecord permission=%s", Integer.valueOf(checkSelfPermission)));
        }
        if (this.U && this.V && checkSelfPermission == 0 && (handler = this.L) != null) {
            handler.sendEmptyMessage(1);
        }
    }

    public void M() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "stop");
        }
        if (this.U && this.V) {
            if (this.I) {
                if (QLog.isColorLevel()) {
                    QLog.i("ARVideoRecordUIControllerImpl", 2, "stop has been refused because of ActivityLifeCircle ERROR");
                }
            } else {
                this.M = null;
                this.N = null;
                this.T = null;
                this.W = null;
                this.J = true;
                r();
            }
        }
    }

    public void N(boolean z16) {
        if (!this.U) {
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "do nothing apart from return ");
                return;
            }
            return;
        }
        if (z16 == this.V) {
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "value equal return value:" + this.V);
                return;
            }
            return;
        }
        this.V = z16;
        if (z16) {
            this.R = false;
            this.S = -1;
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from disable to enable");
                return;
            }
            return;
        }
        this.M = null;
        this.N = null;
        this.T = null;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from enable to disable");
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.g.a
    public void a(final int i3, String str) {
        QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordFinish finishType=%s", Integer.valueOf(i3)));
        G(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                if (ARVideoRecordUIControllerImpl.this.M != null) {
                    ARVideoRecordUIControllerImpl.this.M.d(0);
                }
                if (i3 == 0) {
                    if (ARVideoRecordUIControllerImpl.this.S != -1) {
                        int i16 = ARVideoRecordUIControllerImpl.this.S;
                        if (i16 != 1) {
                            if (i16 != 2 && i16 != 3 && i16 != 4 && i16 != 6) {
                                if (i16 == 7) {
                                    ARRecordUtils.h(ARVideoRecordUIControllerImpl.f196990g0, true);
                                }
                            } else {
                                ARVideoRecordUIControllerImpl.q("0X8008A56");
                                ARRecordUtils.h(ARVideoRecordUIControllerImpl.f196990g0, true);
                            }
                        } else {
                            ARVideoRecordUIControllerImpl.q("0X8008A56");
                            ARRecordUtils.g("AR\u89c6\u9891\u5df2\u4fdd\u5b58", ARVideoRecordUIControllerImpl.f196987d0);
                        }
                        ARVideoRecordUIControllerImpl.this.S = -1;
                    } else if (ARVideoRecordUIControllerImpl.this.Q) {
                        ARVideoRecordUIControllerImpl.this.Q = false;
                    } else {
                        ARVideoRecordUIControllerImpl.q("0X8008A56");
                        ARRecordUtils.h(ARVideoRecordUIControllerImpl.f196990g0, true);
                    }
                } else {
                    ARVideoRecordUIControllerImpl.q("0X8008A56");
                    if (i3 == 1) {
                        ARRecordUtils.g("AR\u89c6\u9891\u5df2\u4fdd\u5b58", ARVideoRecordUIControllerImpl.f196988e0);
                    } else {
                        ARRecordUtils.g("AR\u89c6\u9891\u5df2\u4fdd\u5b58", ARVideoRecordUIControllerImpl.f196989f0);
                    }
                }
                ARVideoRecordUIControllerImpl.this.R = false;
                if (!ARVideoRecordUIControllerImpl.this.I) {
                    ARVideoRecordUIControllerImpl.this.r();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.g.a
    public void b(int i3) {
        QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordError errorType=%s", Integer.valueOf(i3)));
        Handler handler = this.L;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(8);
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b.a
    public void c() {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "onMonitorUserOperation");
        }
        if (this.U && this.V && (handler = this.L) != null) {
            handler.sendEmptyMessage(6);
        }
    }

    @QQPermissionGrant(1)
    public void grant() {
        QLog.d("ARVideoRecordUIControllerImpl", 2, "CheckPermission user grant");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        char c16 = 0;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 12) {
                    if (i3 != 13) {
                        switch (i3) {
                            case 6:
                                if (this.M.c() == 0) {
                                    this.X = true;
                                    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode normal");
                                    int checkSelfPermission = ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO);
                                    int checkSelfPermission2 = ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
                                    int checkSelfPermission3 = ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
                                    if (checkSelfPermission != 0 || checkSelfPermission2 != 0 || checkSelfPermission3 != 0) {
                                        c16 = '\uffff';
                                    }
                                    if (c16 == 0) {
                                        QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION has permission");
                                        y();
                                        break;
                                    } else {
                                        QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION need request permission");
                                        if (this.Y == null) {
                                            this.Y = QQPermissionFactory.getQQPermission(this.W, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SCAN_AR, QQPermissionConstants.Business.SCENE.AR_SCAN_VIDEO_RECORD));
                                        }
                                        QQPermission qQPermission = this.Y;
                                        if (qQPermission != null) {
                                            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
                                            break;
                                        } else {
                                            QLog.e("ARVideoRecordUIControllerImpl", 1, "mQQPermission is null!");
                                            break;
                                        }
                                    }
                                } else {
                                    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode pressed");
                                    y();
                                    break;
                                }
                            case 7:
                                x(message.arg1);
                                break;
                            case 8:
                                A(message.arg1);
                                break;
                            case 9:
                                w();
                                break;
                            case 10:
                                v();
                                break;
                        }
                    } else {
                        z();
                    }
                } else {
                    u();
                }
            } else if (this.N != null) {
                this.N.d(false, false);
            }
        } else if (((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0 && ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && ((QBaseActivity) this.W).checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            if (F()) {
                return true;
            }
            this.X = false;
            if (this.N != null) {
                this.N.c(false, null);
            }
        } else {
            QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_START_PRE_RECORD permmit");
        }
        return true;
    }

    public void m(Object obj) {
        if (obj != null && this.U) {
            if (obj instanceof com.tencent.mobileqq.ar.ARRecord.b) {
                this.M = (com.tencent.mobileqq.ar.ARRecord.b) obj;
                this.M.b(this);
            } else if (obj instanceof com.tencent.mobileqq.ar.ARRecord.a) {
                this.N = (com.tencent.mobileqq.ar.ARRecord.a) obj;
                this.N.h(this);
            }
        }
    }

    public void n(Object obj) {
        if (obj != null && this.U && this.V) {
            if (obj instanceof com.tencent.mobileqq.ar.ARRecord.b) {
                this.M = null;
            } else if (obj instanceof com.tencent.mobileqq.ar.ARRecord.a) {
                this.N = null;
            }
        }
    }

    public void o() {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnPause");
        }
        this.I = false;
        if (this.U && this.V && (handler = this.L) != null) {
            handler.removeMessages(13);
            this.L.sendEmptyMessage(13);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.g.a
    public void onRecordStart() {
        QLog.d("ARVideoRecordUIControllerImpl", 2, "onRecordStart");
        G(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.6
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.g.a
    public void onRecordUpdate(final int i3, final int i16) {
        QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate duration=%s fileSize=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        G(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate progress=%s", 1));
                if (ARVideoRecordUIControllerImpl.this.D()) {
                    ARVideoRecordUIControllerImpl.this.M.a(i3, i16);
                }
            }
        });
    }

    public void p() {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnResume");
        }
        this.I = true;
        if (this.U && this.V && (handler = this.L) != null) {
            handler.removeMessages(12);
            this.L.sendEmptyMessage(12);
        }
    }

    @Deprecated
    public Context s() {
        return this.T;
    }
}
