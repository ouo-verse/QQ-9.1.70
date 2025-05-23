package com.tencent.av.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.PermissionUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes3.dex */
public class QavVideoRecordUICtrl implements View.OnClickListener, Handler.Callback, com.tencent.av.ui.funchat.record.g, com.tencent.av.ui.funchat.record.i, QavRecordButtonView.b {

    /* renamed from: u0, reason: collision with root package name */
    public static String f75114u0 = BaseApplicationImpl.getApplication().getFilesDir() + "/qav_record_test_switch.dat";

    /* renamed from: v0, reason: collision with root package name */
    public static boolean f75115v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public static boolean f75116w0 = false;
    private RelativeLayout C;
    private TextView D;
    private ImageButton E;
    private View F;
    private View G;
    private View H;
    private RelativeLayout.LayoutParams I;
    private RelativeLayout.LayoutParams J;
    private RelativeLayout.LayoutParams K;
    private WeakReference<QavRecordButtonView> L;
    private TextView M;
    private LinearLayout N;
    private String X;
    private String Y;
    private volatile long Z;

    /* renamed from: a0, reason: collision with root package name */
    private volatile long f75117a0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f75120d;

    /* renamed from: d0, reason: collision with root package name */
    private QavVideoAudioRecorder f75121d0;

    /* renamed from: e, reason: collision with root package name */
    public long f75122e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<AVActivity> f75124f;

    /* renamed from: g0, reason: collision with root package name */
    private aj f75126g0;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f75127h;

    /* renamed from: h0, reason: collision with root package name */
    private VideoNetStateBar f75128h0;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f75129i;

    /* renamed from: l0, reason: collision with root package name */
    public com.tencent.av.ui.funchat.record.e f75133l0;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f75134m;
    private boolean P = true;
    private int Q = 0;
    private long R = 0;
    private long S = 0;
    private long T = 0;
    private int U = 1;
    public int W = 0;

    /* renamed from: b0, reason: collision with root package name */
    public long f75118b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public long f75119c0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private File f75123e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f75125f0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private int f75130i0 = 0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f75131j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f75132k0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public int f75135m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    private ValueAnimator f75136n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f75137o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    private Animator.AnimatorListener f75138p0 = null;

    /* renamed from: q0, reason: collision with root package name */
    private volatile boolean f75139q0 = false;

    /* renamed from: r0, reason: collision with root package name */
    private ValueAnimator f75140r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    private volatile boolean f75141s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private volatile boolean f75142t0 = false;
    private Handler V = new Handler(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            if (!QavVideoRecordUICtrl.this.f75142t0) {
                QavVideoRecordUICtrl.this.f0();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QLog.d("QavVideoRecordUICtrl", 1, "showPermissionDialog deniedForRecord(1) 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue <= 220) {
                float f16 = intValue / 220.0f;
                if (QavVideoRecordUICtrl.this.D != null) {
                    QavVideoRecordUICtrl.this.D.setAlpha(f16);
                }
            }
            if (intValue <= 160) {
                float f17 = intValue / 100.0f;
                if (QavVideoRecordUICtrl.this.E != null) {
                    QavVideoRecordUICtrl.this.E.setAlpha(f17);
                }
            }
            if (QavVideoRecordUICtrl.this.f75134m != null) {
                QavVideoRecordUICtrl.this.f75134m.requestLayout();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d extends Animation {
        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            float f17;
            if (f16 < 0.5f) {
                f17 = 0.5f - f16;
            } else {
                f17 = f16 - 0.5f;
            }
            transformation.setAlpha(f17 / 0.5f);
            super.applyTransformation(f16, transformation);
        }
    }

    public QavVideoRecordUICtrl(AVActivity aVActivity, RelativeLayout relativeLayout, aj ajVar) {
        VideoNetStateBar n3;
        this.f75120d = false;
        this.f75121d0 = null;
        this.f75124f = new WeakReference<>(aVActivity);
        this.f75127h = relativeLayout;
        this.f75126g0 = ajVar;
        if (ajVar == null) {
            n3 = null;
        } else {
            n3 = ajVar.n();
        }
        this.f75128h0 = n3;
        if (n3 != null) {
            n3.s(true);
        }
        O();
        this.f75133l0 = com.tencent.av.ui.funchat.record.e.a();
        this.f75122e = r9.f75877i * 60 * 1000;
        if (com.tencent.av.n.e().f().Z2 < 0) {
            com.tencent.av.n.e().f().Z2 = this.f75122e;
        }
        try {
            if (X()) {
                this.f75121d0 = new QavVideoAudioRecorder();
            }
        } catch (OutOfMemoryError e16) {
            this.f75121d0 = null;
            QLog.e("QavVideoRecordUICtrl", 1, "oom " + e16, e16);
        }
        String C = com.tencent.mobileqq.utils.ah.C();
        QLog.i("QavVideoRecordUICtrl", 1, "QavVideoRecordUICtrl manufacture=" + C);
        if ("OPPO".equalsIgnoreCase(C) || CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(C)) {
            this.f75120d = true;
        }
    }

    private int B(int i3) {
        aj ajVar;
        if (i3 != 0 && (this.f75131j0 || this.f75132k0 || ((ajVar = this.f75126g0) != null && ajVar.I()))) {
            return 0;
        }
        return i3;
    }

    private int H(int i3) {
        return this.f75124f.get().getResources().getDimensionPixelSize(i3);
    }

    private QavRecordButtonView L() {
        WeakReference<QavRecordButtonView> weakReference = this.L;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private long N() {
        return Math.max(0L, System.currentTimeMillis() - this.T);
    }

    private void O() {
        LayoutInflater.from(this.f75124f.get()).inflate(R.layout.f168529zq, this.f75127h);
        this.f75129i = (RelativeLayout) this.f75127h.findViewById(R.id.kth);
        this.f75134m = (RelativeLayout) this.f75127h.findViewById(R.id.i4f);
        this.C = (RelativeLayout) this.f75127h.findViewById(R.id.i4e);
        this.D = (TextView) this.f75127h.findViewById(R.id.jho);
        this.E = (ImageButton) this.f75127h.findViewById(R.id.m5f);
        this.G = this.f75127h.findViewById(R.id.i3z);
        this.F = this.f75127h.findViewById(R.id.i3y);
        this.H = this.f75127h.findViewById(R.id.i3x);
        this.I = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        this.J = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        this.E.setOnClickListener(this);
        this.K = (RelativeLayout.LayoutParams) this.f75134m.getLayoutParams();
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.f75129i.setBackgroundColor(1602735851);
            this.f75134m.setBackgroundColor(2142109487);
        }
        this.f75129i.setWillNotDraw(false);
        this.W = BaseAIOUtils.f(51.0f, this.f75124f.get().getResources());
        this.X = this.f75124f.get().getString(R.string.dho);
        this.Y = this.f75124f.get().getString(R.string.dhk);
        ViewStub viewStub = (ViewStub) this.f75124f.get().findViewById(R.id.f30220nr);
        if (viewStub != null) {
            viewStub.inflate();
        }
        QavRecordButtonView qavRecordButtonView = (QavRecordButtonView) this.f75124f.get().findViewById(R.id.i3q);
        this.L = new WeakReference<>(qavRecordButtonView);
        qavRecordButtonView.setOnClickListener(this);
        qavRecordButtonView.setListener(this);
        this.N = (LinearLayout) this.f75124f.get().findViewById(R.id.f166770i44);
        this.M = (TextView) this.f75124f.get().findViewById(R.id.f166769i43);
        this.N.setVisibility(8);
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.N.setBackgroundColor(-273627938);
            this.M.setBackgroundColor(-65281);
        }
    }

    public static boolean S() {
        boolean z16;
        mv.a a16 = mv.a.a();
        if (a16 != null && !a16.f()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d("QavVideoRecordUICtrl", 1, "isInBlackList device not support");
        }
        return !z16;
    }

    public static boolean X() {
        QLog.isColorLevel();
        return true;
    }

    private void b0(long j3) {
        QLog.d("QavVideoRecordUICtrl", 1, "onForceStop time=" + j3);
        if (this.f75124f.get().H0 == null) {
            return;
        }
        com.tencent.av.n.e().f().Y2 = false;
        cw.e.o(this.f75124f.get().H0, 1023, R.string.dhc);
        com.tencent.av.r.h0().T1();
        B0();
        this.N.setVisibility(8);
        this.f75124f.get().H0.k0(new Object[]{163});
    }

    private void e0() {
        if (this.f75124f.get().H0 == null) {
            return;
        }
        this.f75130i0 = 0;
        QLog.d("QavVideoRecordUICtrl", 1, "onRecordBegin");
        com.tencent.av.n.e().f().Y2 = true;
        n0(1, true);
        B0();
        QavRecordButtonView L = L();
        if (L != null) {
            L.setProgress(0L, this.f75122e);
        }
        this.M.setText(J(0L));
        this.N.setVisibility(0);
        this.f75124f.get().H0.k0(new Object[]{163});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        EffectPendantTools effectPendantTools;
        FaceItem u16;
        int i3;
        VideoAppInterface videoAppInterface;
        AVActivity aVActivity = this.f75124f.get();
        if (aVActivity == null) {
            return;
        }
        if (aVActivity.H0 != null && com.tencent.av.r.h0() != null && !this.f75142t0) {
            QavRecordReporter.g("0X8008AAE");
            if (com.tencent.av.n.e().f().f73048l0) {
                aVActivity.U0.w(2);
                QLog.d("QavVideoRecordUICtrl", 1, "start record, child lock");
                return;
            }
            if (com.tencent.av.n.e().f().Y2) {
                z();
                long currentTimeMillis = (System.currentTimeMillis() - this.f75118b0) / 1000;
                ReportController.o(null, "CliOper", "", "", "0X800863B", "0X800863B", 0, 0, String.valueOf(currentTimeMillis), "", "", "");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(aVActivity.H0.getCurrentAccountUin(), "av_record_click_end", true, currentTimeMillis, 0L, (HashMap<String, String>) null, "", false);
                return;
            }
            com.tencent.av.n.e().f().i3.clear();
            boolean z16 = false;
            if (!X()) {
                VideoAppInterface videoAppInterface2 = aVActivity.H0;
                if (videoAppInterface2 != null) {
                    cw.e.o(videoAppInterface2, 1022, R.string.dh7);
                }
                QLog.d("QavVideoRecordUICtrl", 1, "start record, api not support");
            } else if (!com.tencent.av.n.e().f().X2) {
                QLog.d("QavVideoRecordUICtrl", 1, "start record, friend not support");
                if (com.tencent.av.r.h0().t0(com.tencent.av.n.e().f().f73091w) == 5) {
                    QavRecordReporter.g("0X8008AB6");
                    i3 = R.string.dhe;
                } else {
                    QavRecordReporter.g("0X8008AB5");
                    i3 = R.string.dhd;
                }
                VideoAppInterface videoAppInterface3 = aVActivity.H0;
                if (videoAppInterface3 != null) {
                    cw.e.o(videoAppInterface3, 1022, i3);
                }
            } else if (!U()) {
                VideoAppInterface videoAppInterface4 = aVActivity.H0;
                if (videoAppInterface4 != null) {
                    cw.e.o(videoAppInterface4, 1022, R.string.dhj);
                }
                QLog.d("QavVideoRecordUICtrl", 1, "start record, isPerformanceSupport==false");
                QavRecordReporter.g("0X8008AB4");
            } else if (com.tencent.av.n.e().f().f73003a3 && com.tencent.av.n.e().f().W2 < 735) {
                QLog.d("QavVideoRecordUICtrl", 1, "start record, friend's old version not support record in same time");
                cw.e.o(aVActivity.H0, 1022, R.string.dhh);
            } else if (!I()) {
                QLog.d("QavVideoRecordUICtrl", 1, "start record, last encode not stop");
                VideoAppInterface videoAppInterface5 = aVActivity.H0;
                if (videoAppInterface5 != null) {
                    cw.e.o(videoAppInterface5, 1022, R.string.dhf);
                }
            } else {
                if (aVActivity.H0.Y(3) && (u16 = ((com.tencent.av.business.manager.magicface.a) aVActivity.H0.B(3)).u()) != null && u16.isSameType(IndividuationUrlHelper.UrlId.PENDANT_HOME)) {
                    QavRecordReporter.g("0X8008ABE");
                }
                VideoChatRoomUIContoller videoChatRoomUIContoller = aVActivity.f74657h1;
                if (videoChatRoomUIContoller != null && videoChatRoomUIContoller.p()) {
                    cw.e.o(aVActivity.H0, 1022, R.string.w37);
                } else if (com.tencent.av.ui.funchat.record.b.c() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                    VideoAppInterface videoAppInterface6 = aVActivity.H0;
                    if (videoAppInterface6 != null) {
                        cw.e.o(videoAppInterface6, 1022, R.string.dhv);
                    }
                    QLog.d("QavVideoRecordUICtrl", 1, "start record, STORAGE_LEFT_MIN_SIZE not enough");
                } else {
                    if (com.tencent.av.n.e().f().f73078s2 != 0) {
                        com.tencent.av.n.e().f().i3.add(0);
                        QavRecordReporter.g("0X8008AC1");
                    }
                    if (aVActivity.H0.Y(2) && (effectPendantTools = (EffectPendantTools) aVActivity.H0.B(2)) != null && effectPendantTools.u() != null) {
                        com.tencent.av.n.e().f().i3.add(6);
                        QavRecordReporter.g("0X8008ABC");
                    }
                    z16 = true;
                }
            }
            if (z16) {
                com.tencent.av.n.e().f().f73029g3 = true;
                com.tencent.av.n.e().f().f73034h3 = Q();
                z0();
                if (Y() && aVActivity.H0.Y(3)) {
                    com.tencent.av.business.manager.magicface.a aVar = (com.tencent.av.business.manager.magicface.a) aVActivity.H0.B(3);
                    if (aVar.u() != null && aVar.T() && (videoAppInterface = aVActivity.H0) != null) {
                        cw.e.o(videoAppInterface, 1022, R.string.dhg);
                    }
                }
                QavRecordReporter.g("0X800863A");
                if (com.tencent.av.n.e().f().f73003a3) {
                    QavRecordReporter.g("0X8008ACC");
                }
                if (Q()) {
                    QavRecordReporter.g("0X8008AB9");
                } else {
                    QavRecordReporter.g("0X8008AB8");
                }
                if (com.tencent.av.n.e().f().i3.size() == 0) {
                    QavRecordReporter.g("0X8008ABB");
                    return;
                }
                return;
            }
            QavRecordReporter.g("0X8008AAF");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "record activity.mApp == null  || VideoController.getInstance() == null");
        }
    }

    private void g0(long j3) {
        QLog.d("QavVideoRecordUICtrl", 1, "onRecordEnd time=" + j3);
        if (this.f75124f.get().H0 == null) {
            return;
        }
        this.f75130i0 = 0;
        com.tencent.av.n.e().f().Y2 = false;
        if (j3 <= 1000 && !this.f75124f.get().f74643a1) {
            if (j3 >= 0) {
                this.V.postDelayed(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.8
                    @Override // java.lang.Runnable
                    public void run() {
                        QavVideoRecordUICtrl.this.n0(8, true);
                    }
                }, 1000L);
                cw.e.o(this.f75124f.get().H0, 1023, R.string.f171255di0);
                QavRecordReporter.g("0X8008AB0");
            } else {
                n0(3, true);
                cw.e.o(this.f75124f.get().H0, 1023, R.string.dhb);
                com.tencent.av.r.h0().T1();
            }
        } else {
            n0(3, true);
            com.tencent.av.n.e().f().f73007b3 = 0;
        }
        B0();
        this.N.setVisibility(8);
        this.f75124f.get().H0.k0(new Object[]{163});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i3) {
        int i16;
        if (i3 != 0) {
            if (i3 == 1 && !this.f75124f.get().f74643a1) {
                cw.e.o(this.f75124f.get().H0, 1023, R.string.dhb);
                return;
            }
            return;
        }
        if (!this.f75124f.get().f74643a1) {
            if (this.f75120d) {
                i16 = R.string.dhq;
            } else {
                i16 = R.string.dhp;
            }
            QQToast.makeText(this.f75124f.get(), 2, this.f75124f.get().getResources().getString(i16), 0).show();
        }
    }

    private void j0() {
        this.f75140r0 = null;
        this.f75136n0 = null;
        this.f75137o0 = null;
        this.f75138p0 = null;
    }

    private void l0() {
        this.U = 1;
        this.V.removeMessages(1);
        r0(false);
        s(false);
        this.f75129i.setVisibility(8);
    }

    public static void p0(com.tencent.av.r rVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "sendSupportMsg, controller=" + rVar);
        }
        if (X() && !S()) {
            if (rVar != null) {
                rVar.s2(8, "SUPPORT_TRUE");
                rVar.s2(8, "SUPPORT_TRUE");
                rVar.s2(8, "SUPPORT_TRUE_7.3.5#" + com.tencent.av.ui.funchat.record.e.a().f75877i);
                rVar.s2(8, "SUPPORT_TRUE_7.3.5#" + com.tencent.av.ui.funchat.record.e.a().f75877i);
                return;
            }
            return;
        }
        QLog.d("QavVideoRecordUICtrl", 1, "sendSupportMsg, not support");
    }

    private void r() {
        if (this.f75126g0 == null) {
            return;
        }
        QavRecordButtonView L = L();
        if (this.F != null && this.G != null && this.H != null) {
            if (this.f75126g0.I()) {
                this.G.setVisibility(8);
                this.F.setVisibility(8);
                this.H.setVisibility(8);
                return;
            }
            if (T()) {
                this.G.setVisibility(8);
                this.H.setVisibility(8);
                if ((L != null && L.c() == 3) || P()) {
                    this.F.setVisibility(0);
                    return;
                } else {
                    this.F.setVisibility(8);
                    return;
                }
            }
            this.F.setVisibility(8);
            if (L != null && L.c() == 3) {
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            if (P()) {
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
        }
    }

    private void t() {
        if (this.f75126g0 != null && this.f75124f.get().J0 != null && Q()) {
            if (P()) {
                this.f75126g0.Z0(T());
            } else {
                this.f75126g0.Z0(true);
            }
        }
    }

    private void u(Activity activity) {
        if (PermissionUtil.isHasStoragePermission(activity)) {
            f0();
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AV, QQPermissionConstants.Business.SCENE.QQ_AV_ROOM));
        if (qQPermission == null) {
            QLog.d("QavVideoRecordUICtrl", 1, "GetPermission failed");
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
        }
    }

    private void v() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (QLog.isColorLevel()) {
            QLog.i("QavVideoRecordUICtrl", 1, "clearAnim mAnimExpanding=" + this.f75139q0 + ", mAnimFolding=" + this.f75141s0);
        }
        if (this.f75139q0 && (valueAnimator2 = this.f75136n0) != null) {
            try {
                if (valueAnimator2.isRunning()) {
                    try {
                        this.f75136n0.removeAllUpdateListeners();
                        this.f75136n0.removeAllListeners();
                        this.f75136n0.cancel();
                    } catch (Exception e16) {
                        QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + e16, e16);
                        this.f75139q0 = false;
                    }
                    return;
                }
            } finally {
                this.f75139q0 = false;
                w0(3, false);
            }
        }
        if (this.f75141s0 && (valueAnimator = this.f75140r0) != null) {
            try {
                if (valueAnimator.isRunning()) {
                    try {
                        this.f75140r0.removeAllUpdateListeners();
                        this.f75140r0.removeAllListeners();
                        this.f75140r0.cancel();
                    } catch (Exception e17) {
                        QLog.e("QavVideoRecordUICtrl", 1, "clearAnim exception:" + e17, e17);
                    }
                }
            } finally {
                this.f75141s0 = false;
                w0(3, false);
            }
        }
    }

    private void w() {
        if (QLog.isColorLevel()) {
            QLog.i("QavVideoRecordUICtrl", 2, "doExpandAnim");
        }
        this.f75139q0 = true;
        if (this.f75137o0 == null) {
            this.f75137o0 = new b();
        }
        if (this.f75138p0 == null) {
            this.f75138p0 = new c();
        }
        if (this.f75136n0 == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 260);
            this.f75136n0 = ofInt;
            ofInt.setDuration(260L);
        }
        this.f75136n0.removeAllListeners();
        this.f75136n0.removeAllUpdateListeners();
        this.f75136n0.addUpdateListener(this.f75137o0);
        this.f75136n0.addListener(this.f75138p0);
        if (this.f75136n0.isRunning()) {
            this.f75136n0.cancel();
        }
        this.f75136n0.start();
    }

    private void y0() {
        VideoNetStateBar videoNetStateBar = this.f75128h0;
        if (videoNetStateBar == null) {
            return;
        }
        videoNetStateBar.u(this.Q);
        int i3 = this.Q;
        if (i3 != 90 && i3 != 270 && P()) {
            this.f75128h0.t(D() + H(R.dimen.a7m));
        } else {
            this.f75128h0.t(H(R.dimen.a7m));
        }
    }

    public void A(int i3) {
        boolean z16;
        f75116w0 = false;
        this.S = System.currentTimeMillis();
        QLog.w("QavVideoRecordUICtrl", 1, "endRecord, stopType[" + i3 + "], mStartTime[" + this.R + "], mRealStartTime[" + this.T + "], mEndTime[" + this.S + "]");
        this.V.removeMessages(10);
        this.V.removeMessages(11);
        if (i3 == 1) {
            g0(K());
        } else if (i3 == 2) {
            b0(K());
        } else {
            g0(-1L);
        }
        if (K() >= 1000 && i3 == 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f75125f0 = z16;
        QavVideoAudioRecorder qavVideoAudioRecorder = this.f75121d0;
        if (qavVideoAudioRecorder != null) {
            qavVideoAudioRecorder.m();
        }
        this.f75123e0 = null;
        com.tencent.av.r.h0().f(0, null);
        QLog.i("QavVideoRecordUICtrl", 1, "endRecord, after unregisterAudioDataCallbackAll, ret2=" + com.tencent.av.r.h0().E3(2, true) + ", ret4=" + com.tencent.av.r.h0().E3(4, true));
        if (com.tencent.av.n.e().f().f73019e3) {
            int e26 = com.tencent.av.r.h0().e2(3, false);
            int H2 = com.tencent.av.r.h0().H2(3, 48000, 1, 16);
            com.tencent.av.n.e().f().f73011c3 = true;
            com.tencent.av.n.e().f().f73015d3 = false;
            QLog.i("QavVideoRecordUICtrl", 1, "endRecord, registerAudioDataCallback, mix = true, ret3=" + e26 + ", set3=" + H2);
        }
        com.tencent.av.ui.funchat.record.e eVar = this.f75133l0;
        QavRecordReporter.d(eVar.f75887s, eVar.f75888t, i3, K());
    }

    public void A0() {
        boolean z16;
        aj ajVar;
        int H;
        aj ajVar2 = this.f75126g0;
        if (ajVar2 != null && !ajVar2.E()) {
            int B = B(this.Q);
            this.Q = B;
            u0(B);
            r();
            y0();
            if (!P()) {
                return;
            }
            int i3 = this.Q;
            if (i3 != 90 && i3 != 270) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && (ajVar = this.f75126g0) != null && !ajVar.I()) {
                if (M() == 3) {
                    H = H(R.dimen.a8k);
                } else {
                    H = H(R.dimen.a8q);
                }
                RelativeLayout.LayoutParams layoutParams = this.K;
                layoutParams.height = H;
                layoutParams.width = H;
                layoutParams.leftMargin = BaseAIOUtils.f(15.0f, this.f75124f.get().getResources());
                RelativeLayout relativeLayout = this.f75134m;
                if (relativeLayout != null) {
                    relativeLayout.setLayoutParams(this.K);
                }
                if (this.Q == 90) {
                    RelativeLayout relativeLayout2 = this.f75134m;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setRotation(-90.0f);
                    }
                    RelativeLayout relativeLayout3 = this.C;
                    if (relativeLayout3 != null) {
                        relativeLayout3.setScaleX(1.0f);
                        this.C.setScaleY(1.0f);
                    }
                } else {
                    RelativeLayout relativeLayout4 = this.C;
                    if (relativeLayout4 != null) {
                        relativeLayout4.setScaleX(-1.0f);
                        this.C.setScaleY(-1.0f);
                    }
                    RelativeLayout relativeLayout5 = this.f75134m;
                    if (relativeLayout5 != null) {
                        relativeLayout5.setRotation(-90.0f);
                    }
                }
            } else {
                RelativeLayout.LayoutParams layoutParams2 = this.K;
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                layoutParams2.leftMargin = 0;
                RelativeLayout relativeLayout6 = this.f75134m;
                if (relativeLayout6 != null) {
                    relativeLayout6.setLayoutParams(layoutParams2);
                }
                RelativeLayout relativeLayout7 = this.C;
                if (relativeLayout7 != null) {
                    relativeLayout7.setScaleX(1.0f);
                    this.C.setScaleY(1.0f);
                }
                RelativeLayout relativeLayout8 = this.f75134m;
                if (relativeLayout8 != null) {
                    relativeLayout8.setRotation(this.Q);
                }
            }
            t();
            r0(P());
        }
    }

    public void B0() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w("QavVideoRecordUICtrl", 1, "updateRecordButton, seq[" + d16 + "]");
        QavRecordButtonView L = L();
        if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null && this.f75124f.get().H0 != null && L != null && !this.f75142t0) {
            if (R()) {
                if (com.tencent.av.n.e().f().Y2) {
                    L.setShowState(3, this.f75124f.get().H0.U());
                } else {
                    L.setShowState(2, this.f75124f.get().H0.U());
                }
                if (this.f75124f.get().I0 != null) {
                    this.f75124f.get().I0.i1(d16, 33554431);
                    return;
                }
                return;
            }
            L.setShowState(1, this.f75124f.get().H0.U());
        }
    }

    public void C() {
        A(2);
    }

    public void C0(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        QavVideoAudioRecorder qavVideoAudioRecorder = this.f75121d0;
        if (qavVideoAudioRecorder != null) {
            qavVideoAudioRecorder.n(i3, i16, fArr, fArr2, j3);
        }
        QavRecordReporter.f();
    }

    int D() {
        if (P()) {
            return F() + E();
        }
        return 0;
    }

    public int E() {
        return H(R.dimen.a8v);
    }

    int F() {
        boolean isLiuHaiUseValid = LiuHaiUtils.isLiuHaiUseValid();
        if (P()) {
            if (isLiuHaiUseValid) {
                return LiuHaiUtils.getNotchInScreenHeight(this.f75124f.get());
            }
            return this.f75126g0.q();
        }
        return 0;
    }

    public long G() {
        long j3;
        try {
            File file = this.f75123e0;
            if (file == null) {
                j3 = this.Z;
            } else {
                j3 = com.tencent.av.ui.funchat.record.b.a(file);
            }
        } catch (Exception e16) {
            long j16 = this.Z;
            QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize Exception=" + e16.getMessage());
            j3 = j16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "getCurrentRecordSize=" + j3);
        }
        return j3;
    }

    public boolean I() {
        return this.P;
    }

    public String J(long j3) {
        if (j3 == 0) {
            return this.Y;
        }
        int i3 = (int) (j3 / 1000);
        int i16 = i3 / 60;
        return String.format(Locale.getDefault(), "%s (%02d:%02d)", this.X, Integer.valueOf(i16), Integer.valueOf(i3 - (i16 * 60)));
    }

    public long K() {
        long j3 = this.S - this.T;
        QLog.w("QavVideoRecordUICtrl", 1, "getRealDuration, dur[" + j3 + "], UITime[" + (this.S - this.R) + "]");
        return Math.max(0L, j3);
    }

    public int M() {
        return this.U;
    }

    public boolean P() {
        if (this.U == 3) {
            return true;
        }
        return false;
    }

    public boolean Q() {
        if (this.f75124f.get().J0 != null && this.f75124f.get().J0.N0()) {
            return true;
        }
        return false;
    }

    public boolean R() {
        if (com.tencent.av.r.h0() == null || com.tencent.av.n.e().f() == null || this.f75124f.get().H0 == null || this.f75142t0) {
            return false;
        }
        boolean z16 = com.tencent.av.n.e().f().Y2;
        boolean z17 = com.tencent.av.n.e().f().f73003a3;
        boolean z18 = com.tencent.av.n.e().f().f73048l0;
        if (!W()) {
            return false;
        }
        if (z16) {
            return true;
        }
        if (this.f75124f.get().H0.Y(3)) {
            com.tencent.av.business.manager.magicface.a aVar = (com.tencent.av.business.manager.magicface.a) this.f75124f.get().H0.B(3);
            if (aVar.u() != null) {
                aVar.T();
            }
        }
        if (z18) {
            return false;
        }
        if (z17 && com.tencent.av.n.e().f().W2 < 735) {
            return false;
        }
        return true;
    }

    public boolean T() {
        int i3 = this.Q;
        if (i3 != 90 && i3 != 270) {
            return false;
        }
        return true;
    }

    public boolean U() {
        if (this.f75135m0 == 0) {
            com.tencent.av.ui.funchat.record.e eVar = this.f75133l0;
            int i3 = eVar.f75887s;
            int i16 = eVar.f75873e;
            if (i3 > i16) {
                this.f75135m0 = 2;
            } else if (i3 == i16 && eVar.f75888t >= eVar.f75874f) {
                this.f75135m0 = 2;
            } else {
                int i17 = eVar.f75871c;
                if (i3 > i17) {
                    this.f75135m0 = 1;
                } else if (i3 == i17 && eVar.f75888t >= eVar.f75872d) {
                    this.f75135m0 = 1;
                } else {
                    this.f75135m0 = 3;
                }
            }
            if (eVar.f75870b != 1) {
                this.f75135m0 = 4;
            }
            if (f75115v0) {
                this.f75135m0 = 5;
            }
            QLog.d("QavVideoRecordUICtrl", 1, "isPerformanceSupport=" + this.f75135m0);
        }
        int i18 = this.f75135m0;
        if (i18 == 2 || i18 == 1 || i18 == 5) {
            return true;
        }
        return false;
    }

    public boolean V() {
        return f75116w0;
    }

    public boolean W() {
        if (!S() && X() && U() && com.tencent.av.n.e().f().X2) {
            return true;
        }
        return false;
    }

    public boolean Y() {
        if (this.f75135m0 == 0) {
            U();
        }
        if (this.f75135m0 == 1) {
            return true;
        }
        return false;
    }

    public void Z() {
        n0(5, true);
        t0(Q(), this.f75126g0, false);
        x0(true);
        if (this.f75124f.get().H0 != null) {
            cw.e.o(this.f75124f.get().H0, 1023, R.string.di5);
        }
        com.tencent.av.n.e().f().f73003a3 = false;
        B0();
        this.f75124f.get().H0.k0(new Object[]{163});
        long currentTimeMillis = (System.currentTimeMillis() - this.f75119c0) / 1000;
        ReportController.o(null, "CliOper", "", "", "0X800863E", "0X800863E", 0, 0, "", String.valueOf(currentTimeMillis), "", "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f75124f.get().H0.getCurrentAccountUin(), "av_record_cancel", true, currentTimeMillis, 0L, (HashMap<String, String>) null, "", false);
        v0(1);
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void a() {
        this.T = System.currentTimeMillis();
        QLog.w("QavVideoRecordUICtrl", 1, "onEncodeRealStart, mRealStartTime[" + this.T + "], StartOffset[" + (this.T - this.R) + "]");
    }

    public void a0() {
        this.f75142t0 = true;
        f75116w0 = false;
        this.V.removeMessages(10);
        this.V.removeMessages(11);
        QavVideoAudioRecorder qavVideoAudioRecorder = this.f75121d0;
        if (qavVideoAudioRecorder != null) {
            qavVideoAudioRecorder.k();
        }
        this.C = null;
        this.f75134m = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.f75129i = null;
        this.D = null;
        this.E = null;
        this.I = null;
        this.J = null;
        this.K = null;
        ValueAnimator valueAnimator = this.f75136n0;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f75136n0 = null;
        }
        j0();
    }

    public void c0(int i3) {
        if (this.f75126g0 == null) {
            return;
        }
        boolean z16 = com.tencent.av.n.e().f().Y2;
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect " + i3 + ", recording=" + z16);
        }
        if (z16 && this.f75124f.get().H0 != null) {
            int i16 = 1 << (i3 - 1);
            int i17 = this.f75130i0;
            if ((i17 & i16) == i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QavVideoRecordUICtrl", 2, "onChangeUI_RecordReceiveEffect return, type=" + i3);
                    return;
                }
                return;
            }
            this.f75130i0 = i16 | i17;
            if (i3 == 1) {
                cw.e.o(this.f75124f.get().H0, 1022, R.string.dhl);
                QavRecordReporter.g("0X8008AC9");
            }
        }
    }

    public void d0(String str, String str2) {
        int i3;
        EffectPendantTools effectPendantTools;
        int i16;
        long d16 = com.tencent.av.utils.e.d();
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.w("QavVideoRecordUICtrl", 1, "onReceiveRecordMsg, fromUin[" + str + "], data[" + str2 + "], seq[" + d16 + "]");
        }
        try {
            i3 = Integer.parseInt(str2);
        } catch (NumberFormatException e16) {
            QLog.i("QavVideoRecordUICtrl", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + e16.getMessage());
            i3 = -1;
        }
        if (i3 == -1) {
            QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + str2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if ("SUPPORT_TRUE".equals(str2)) {
                com.tencent.av.n.e().f().X2 = true;
                com.tencent.av.n.e().f().W2 = Math.max(com.tencent.av.n.e().f().W2, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
                B0();
                return;
            } else {
                if (str2.startsWith("SUPPORT_TRUE_7.3.5")) {
                    com.tencent.av.n.e().f().X2 = true;
                    com.tencent.av.n.e().f().W2 = Math.max(com.tencent.av.n.e().f().W2, com.tencent.luggage.wxa.ci.b.CTRL_INDEX);
                    int a16 = com.tencent.av.ui.funchat.record.h.a(str2, this.f75133l0.f75877i);
                    QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + a16);
                    com.tencent.av.n.e().f().Z2 = ((long) (a16 * 60)) * 1000;
                    B0();
                    return;
                }
                return;
            }
        }
        if (com.tencent.av.r.h0() != null && this.f75124f.get().H0 != null && !this.f75142t0) {
            int i17 = com.tencent.av.n.e().f().f73035i;
            if (QLog.isColorLevel()) {
                QLog.i("QavVideoRecordUICtrl", 2, "onChangeUi_ReceiveRecordMsg, session type=" + i17);
            }
            if (i17 != 2 && i17 != 1) {
                return;
            }
            switch (i3) {
                case 1:
                    com.tencent.av.n.e().f().f73003a3 = true;
                    v0(3);
                    B0();
                    x0(Q());
                    t0(Q(), this.f75126g0, true);
                    this.f75119c0 = System.currentTimeMillis();
                    s(true);
                    this.f75124f.get().R2(d16);
                    if (!"self".equalsIgnoreCase(str)) {
                        n0(2, false);
                        if (this.f75124f.get().isResume()) {
                            com.tencent.av.r.h0().T1();
                        } else {
                            com.tencent.av.r.h0().U1();
                        }
                    }
                    if (com.tencent.av.n.e().f().f73078s2 != 0) {
                        QavRecordReporter.g("0X8008AC2");
                    }
                    if (this.f75124f.get().H0.Y(2) && (effectPendantTools = (EffectPendantTools) this.f75124f.get().H0.B(2)) != null && effectPendantTools.u() != null) {
                        QavRecordReporter.g("0X8008ABC");
                    }
                    this.f75124f.get().H0.k0(new Object[]{163});
                    return;
                case 2:
                    k0(1);
                    return;
                case 3:
                case 8:
                    com.tencent.av.n.e().f().f73003a3 = false;
                    if (i3 == 3) {
                        n0(4, false);
                        cw.e.o(this.f75124f.get().H0, 1022, R.string.dha);
                    } else {
                        n0(9, false);
                        cw.e.o(this.f75124f.get().H0, 1022, R.string.dh_);
                    }
                    y();
                    return;
                case 4:
                    k0(3);
                    return;
                case 5:
                    if (com.tencent.av.n.e().f().Y2) {
                        C();
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        i16 = 6;
                    } else {
                        i16 = 7;
                    }
                    n0(i16, false);
                    return;
                case 6:
                case 7:
                    k0(5);
                    return;
                case 9:
                    k0(8);
                    return;
                default:
                    return;
            }
        }
        QLog.i("QavVideoRecordUICtrl", 1, "onChangeUi_ReceiveRecordMsg, VideoController.getInstance() == null || mActivity.get().mApp == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r2 != 11) goto L35;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1 && i3 != 3 && i3 != 5 && i3 != 8) {
            if (i3 != 14) {
                if (i3 == 10) {
                    this.V.removeMessages(10);
                    if (!f75116w0) {
                        return true;
                    }
                    long N = N();
                    if (N > this.f75122e) {
                        z();
                        long j3 = this.f75122e / 1000;
                        ReportController.o(null, "CliOper", "", "", "0X800863C", "0X800863C", 0, 0, String.valueOf(j3), "", "", "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_record_timeout", true, j3, 0L, (HashMap<String, String>) null, "", false);
                        return true;
                    }
                    QavRecordButtonView L = L();
                    if (L != null) {
                        L.setProgress(N, this.f75122e);
                    }
                    this.M.setText(J(N));
                    this.V.sendEmptyMessageDelayed(10, 500L);
                }
                this.V.removeMessages(11);
                if (!f75116w0) {
                    return true;
                }
                ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QavVideoRecordUICtrl qavVideoRecordUICtrl = QavVideoRecordUICtrl.this;
                        qavVideoRecordUICtrl.Z = qavVideoRecordUICtrl.G();
                        QavVideoRecordUICtrl.this.f75117a0 = com.tencent.av.ui.funchat.record.b.c();
                        if (QavVideoRecordUICtrl.this.f75117a0 < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                            QavVideoRecordUICtrl.this.V.post(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QavVideoRecordUICtrl.this.z();
                                    if (((AVActivity) QavVideoRecordUICtrl.this.f75124f.get()).H0 != null) {
                                        cw.e.o(((AVActivity) QavVideoRecordUICtrl.this.f75124f.get()).H0, 1023, R.string.dhu);
                                    }
                                }
                            });
                        } else if (QavVideoRecordUICtrl.f75116w0) {
                            QavVideoRecordUICtrl.this.V.sendEmptyMessageDelayed(11, 500L);
                        }
                    }
                }, null, false);
            } else if (!this.f75124f.get().f74643a1) {
                y();
            }
        } else {
            QLog.d("QavVideoRecordUICtrl", 1, "on msg time, msg=" + message.what);
            o0(message.what, false, message.arg1 - 1);
        }
        return true;
    }

    public void k0(int i3) {
        QLog.d("QavVideoRecordUICtrl", 1, "removeTimeoutMsg" + i3);
        this.V.removeMessages(i3);
    }

    public void m0(aj ajVar) {
        QLog.i("QavVideoRecordUICtrl", 1, "resetControlUI, ctrlUI=" + ajVar);
        if (ajVar == null) {
            return;
        }
        this.f75126g0 = ajVar;
        VideoNetStateBar n3 = ajVar.n();
        this.f75128h0 = n3;
        if (n3 != null) {
            n3.s(true);
        }
    }

    public void n0(int i3, boolean z16) {
        o0(i3, z16, 3);
    }

    public void o0(int i3, boolean z16, int i16) {
        QLog.d("QavVideoRecordUICtrl", 1, "sendRecordMsg " + i3 + ", " + z16 + ", " + i16);
        com.tencent.av.r.h0().s2(8, String.valueOf(i3));
        if (z16) {
            this.V.removeMessages(i3);
            Handler handler = this.V;
            handler.sendMessageDelayed(handler.obtainMessage(i3, i16, 0), 3000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("QavVideoRecordUICtrl", 1, NodeProps.ON_CLICK);
        if (view == this.E) {
            Z();
        } else if (view == L()) {
            u((Activity) view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void onEncodeError(int i3, Throwable th5) {
        QLog.d("QavVideoRecordUICtrl", 1, "onEncodeError " + i3 + ", e=" + th5);
        if (QLog.isColorLevel()) {
            QLog.e("QavVideoRecordUICtrl", 1, "onEncodeError ", th5);
        }
        QavRecordReporter.b(i3, th5);
        this.P = true;
        if (i3 != 1 && i3 != 2 && i3 != 5) {
            if (i3 == 4) {
                this.f75125f0 = true;
                if (K() >= 1000) {
                    this.V.post(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.5
                        @Override // java.lang.Runnable
                        public void run() {
                            QavVideoRecordUICtrl.this.i0(1);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        this.V.post(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.4
            @Override // java.lang.Runnable
            public void run() {
                QavVideoRecordUICtrl.this.A(3);
            }
        });
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void onEncodeFinish(String str) {
        QLog.w("QavVideoRecordUICtrl", 1, "onEncodeFinish, filePath[" + str + "], mDeleteThisVideo[" + this.f75125f0 + "]");
        QavRecordReporter.h();
        if (this.f75125f0) {
            boolean z16 = false;
            this.f75125f0 = false;
            try {
                z16 = new File(str).delete();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QavVideoRecordUICtrl", 2, "onEncodeFinish", e16);
                }
            }
            QLog.d("QavVideoRecordUICtrl", 1, "onEncodeFinish delete=" + z16);
        } else {
            com.tencent.av.ui.funchat.record.b.e(str, this.f75124f.get());
            this.V.post(new Runnable() { // from class: com.tencent.av.ui.QavVideoRecordUICtrl.3
                @Override // java.lang.Runnable
                public void run() {
                    QavVideoRecordUICtrl.this.i0(0);
                }
            });
        }
        this.P = true;
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void onEncodeStart() {
        QLog.d("QavVideoRecordUICtrl", 1, "onEncodeStart");
        this.P = false;
    }

    @Override // com.tencent.av.ui.funchat.record.i
    public void onReceiveAudioFrame(byte[] bArr, int i3, int i16) {
        QavVideoAudioRecorder qavVideoAudioRecorder;
        if (f75116w0 && (qavVideoAudioRecorder = this.f75121d0) != null && i3 == 100) {
            qavVideoAudioRecorder.f(bArr, SystemClock.elapsedRealtimeNanos() / 1000);
        }
    }

    @Override // com.tencent.av.ui.funchat.record.QavRecordButtonView.b
    public void onStateChange(int i3) {
        r();
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, cur=" + this.U + ", mAnimExpanding=" + this.f75139q0);
        }
        ValueAnimator valueAnimator = this.f75136n0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (QLog.isColorLevel()) {
                QLog.i("QavVideoRecordUICtrl", 2, "animExpandBar, isRunning");
                return;
            }
            return;
        }
        w();
    }

    public void q0() {
        if (this.f75126g0 != null && P()) {
            int F = F();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f75129i.getLayoutParams();
            layoutParams.topMargin = F;
            QLog.i("QavVideoRecordUICtrl", 1, "iveswu statusBar:density=" + this.f75124f.get().getResources().getDisplayMetrics().density);
            this.f75129i.setLayoutParams(layoutParams);
        }
    }

    public void r0(boolean z16) {
        q0();
        if (this.f75126g0 == null) {
            return;
        }
        boolean z17 = false;
        if (this.f75129i.getVisibility() == 0 && !Q() && !LiuHaiUtils.isLiuHaiUseValid()) {
            aj ajVar = this.f75126g0;
            int E = E() + F();
            if (!z16 || Q()) {
                z17 = true;
            }
            ajVar.X0(E, z17);
        } else {
            aj ajVar2 = this.f75126g0;
            int E2 = E();
            if (!z16 || Q()) {
                z17 = true;
            }
            ajVar2.X0(E2, z17);
        }
        this.f75124f.get().R2(-1034L);
        y0();
    }

    public void s(boolean z16) {
        if (com.tencent.av.n.e().f() == null) {
            return;
        }
        this.V.removeMessages(14);
        if (z16) {
            this.V.sendEmptyMessageDelayed(14, com.tencent.av.n.e().f().Z2);
        }
    }

    public void s0(int i3) {
        int B = B(i3);
        if (this.Q != B) {
            this.Q = B;
            r0(P());
            v();
        }
    }

    public void t0(boolean z16, aj ajVar, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "setDoubleScreenStatusBar doubleScreen=" + z16 + ", controlUI=" + ajVar + ", showBar=" + z17);
        }
        t();
    }

    public void u0(int i3) {
        if (i3 != 0) {
            if (i3 != 90) {
                if (i3 != 180) {
                    if (i3 != 270) {
                        return;
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            layoutParams.setMargins(BaseAIOUtils.f(-12.5f, this.f75124f.get().getResources()), 0, 0, BaseAIOUtils.f(32.5f, this.f75124f.get().getResources()));
            layoutParams.addRule(2, R.id.i3q);
            layoutParams.addRule(1, 0);
            layoutParams.addRule(6, 0);
            this.N.setLayoutParams(layoutParams);
            QavRecordButtonView L = L();
            if (i3 == 90) {
                this.N.setGravity(19);
                this.N.setRotation(270.0f);
                if (L != null) {
                    L.setRotation(270.0f);
                    return;
                }
                return;
            }
            this.N.setGravity(21);
            this.N.setRotation(90.0f);
            if (L != null) {
                L.setRotation(90.0f);
                return;
            }
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        layoutParams2.setMargins(BaseAIOUtils.f(10.0f, this.f75124f.get().getResources()), 0, 0, 0);
        layoutParams2.addRule(2, 0);
        layoutParams2.addRule(1, R.id.i3q);
        layoutParams2.addRule(6, R.id.i3q);
        this.N.setLayoutParams(layoutParams2);
        if (i3 == 0) {
            this.N.setGravity(19);
            this.N.setRotation(0.0f);
        } else {
            this.N.setGravity(21);
            this.N.setRotation(180.0f);
        }
        QavRecordButtonView L2 = L();
        if (L2 != null) {
            L2.setRotation(i3);
        }
    }

    public void v0(int i3) {
        w0(i3, true);
    }

    public void w0(int i3, boolean z16) {
        QLog.d("QavVideoRecordUICtrl", 1, "setShowState=" + i3);
        if (i3 == 3) {
            this.U = 3;
            RelativeLayout relativeLayout = this.f75129i;
            if (relativeLayout == null) {
                return;
            }
            relativeLayout.setVisibility(0);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            this.D.setAlpha(1.0f);
            this.E.setAlpha(1.0f);
            this.I.setMargins(H(R.dimen.a8o), 0, 0, 0);
            this.D.setLayoutParams(this.I);
            this.E.setLayoutParams(this.J);
            RelativeLayout.LayoutParams layoutParams = this.K;
            layoutParams.height = -2;
            layoutParams.width = -2;
            RelativeLayout relativeLayout2 = this.f75134m;
            if (relativeLayout2 != null) {
                relativeLayout2.setLayoutParams(layoutParams);
            }
            RelativeLayout relativeLayout3 = this.f75134m;
            if (relativeLayout3 != null) {
                relativeLayout3.requestLayout();
            }
            if (z16) {
                A0();
            } else {
                r();
            }
            t();
            r0(P());
            return;
        }
        l0();
        r();
    }

    @TargetApi(17)
    public int[] x(int i3, int i16, boolean z16) {
        int i17;
        int i18 = i3;
        if (this.f75121d0 == null) {
            try {
                if (X()) {
                    this.f75121d0 = new QavVideoAudioRecorder();
                }
            } catch (OutOfMemoryError e16) {
                this.f75121d0 = null;
                QLog.e("QavVideoRecordUICtrl", 1, "oom " + e16, e16);
            }
        }
        if (z16) {
            i17 = z.n(i3);
        } else {
            i17 = i16;
        }
        String b16 = com.tencent.av.ui.funchat.record.b.b();
        this.f75123e0 = new File(b16);
        this.Z = 0L;
        if (QLog.isColorLevel()) {
            QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord path=" + b16 + ", w=" + i18 + ", h=" + i16 + ", rh=" + i17);
        }
        int i19 = this.f75133l0.f75875g;
        if (i18 > i19) {
            i17 = (int) (i17 * ((i19 * 1.0f) / i18));
            if (QLog.isColorLevel()) {
                QLog.d("QavVideoRecordUICtrl", 2, "doNeedStartRecord calc size, maxWidth=" + i19 + ", realWidth=" + i19 + ", realHeight=" + i17);
            }
            i18 = i19;
        }
        if (i17 % 2 == 1) {
            i17++;
            QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord height+1");
        }
        QLog.d("QavVideoRecordUICtrl", 1, "doNeedStartRecord rW=" + i18 + ", rH=" + i17);
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(b16, i18, i17, 5120000, 1, false, 0);
        cVar.d(EGL14.eglGetCurrentContext());
        QavVideoAudioRecorder qavVideoAudioRecorder = this.f75121d0;
        if (qavVideoAudioRecorder != null) {
            qavVideoAudioRecorder.l(cVar, this);
            QavRecordReporter.e();
        } else {
            onEncodeError(5, null);
        }
        return new int[]{i18, i17};
    }

    public void x0(boolean z16) {
        aj ajVar = this.f75126g0;
        if (ajVar == null) {
            return;
        }
        ajVar.W0(z16);
    }

    public void y() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w("QavVideoRecordUICtrl", 1, "endBeenRecordedState, seq[" + d16 + "]");
        if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null && this.f75126g0 != null) {
            com.tencent.av.n.e().f().f73003a3 = false;
            v0(1);
            x0(true);
            t0(Q(), this.f75126g0, false);
            s(false);
            this.f75126g0.Z0(true);
        } else if (QLog.isColorLevel()) {
            QLog.i("QavVideoRecordUICtrl", 2, "endBeenRecordedState something is null: mControlUI=" + this.f75126g0);
        }
        this.f75124f.get().R2(d16);
        B0();
        if (this.f75124f.get().H0 != null) {
            this.f75124f.get().H0.k0(new Object[]{163});
        }
        j0();
    }

    public void z() {
        A(1);
    }

    public void z0() {
        f75116w0 = true;
        long currentTimeMillis = System.currentTimeMillis() - 200;
        this.R = currentTimeMillis;
        this.T = currentTimeMillis + 99999999;
        QLog.w("QavVideoRecordUICtrl", 1, "startRecord, mStartTime[" + this.R + "], mRealStartTime[" + this.T + "]");
        this.Z = 0L;
        this.f75117a0 = 31457380L;
        e0();
        this.f75118b0 = System.currentTimeMillis();
        this.V.sendEmptyMessageDelayed(10, 500L);
        this.V.sendEmptyMessageDelayed(11, 500L);
        com.tencent.av.r.h0().f(0, this);
        QLog.i("QavVideoRecordUICtrl", 1, "startRecord, after registerAudioDataCallback, ret2=" + com.tencent.av.r.h0().e2(2, true) + ", ret4=" + com.tencent.av.r.h0().e2(4, true) + ", set2=" + com.tencent.av.r.h0().H2(2, 48000, 1, 16) + ", set4=" + com.tencent.av.r.h0().H2(4, 48000, 1, 16));
        if (com.tencent.av.n.e().f().f73019e3) {
            QLog.d("QavVideoRecordUICtrl", 1, "startRecord, registerAudioDataCallback, mix = true, ret3=" + com.tencent.av.r.h0().e2(3, true) + ", set3=" + com.tencent.av.r.h0().H2(3, 48000, 1, 16));
            com.tencent.av.n.e().f().f73011c3 = true;
            com.tencent.av.n.e().f().f73015d3 = true;
        }
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void b() {
    }

    @Override // com.tencent.av.ui.funchat.record.g
    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationCancel");
            }
            QavVideoRecordUICtrl.this.w0(3, false);
            if (QavVideoRecordUICtrl.this.f75134m != null) {
                QavVideoRecordUICtrl.this.f75134m.requestLayout();
            }
            QavVideoRecordUICtrl.this.f75139q0 = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationEnd");
            }
            QavVideoRecordUICtrl.this.v0(3);
            if (QavVideoRecordUICtrl.this.f75134m != null) {
                QavVideoRecordUICtrl.this.f75134m.requestLayout();
            }
            QavVideoRecordUICtrl.this.f75139q0 = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QavVideoRecordUICtrl", 2, "expand onAnimationStart");
            }
            QavVideoRecordUICtrl.this.D.setVisibility(0);
            QavVideoRecordUICtrl.this.D.setAlpha(0.0f);
            QavVideoRecordUICtrl.this.E.setVisibility(0);
            QavVideoRecordUICtrl.this.E.setAlpha(0.0f);
            QavVideoRecordUICtrl.this.K.height = -2;
            QavVideoRecordUICtrl.this.K.width = -2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
