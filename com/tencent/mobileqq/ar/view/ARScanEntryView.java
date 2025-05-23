package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARLBSPOIDialog;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.mobileqq.ar.arengine.ab;
import com.tencent.mobileqq.ar.arengine.ac;
import com.tencent.mobileqq.ar.arengine.b;
import com.tencent.mobileqq.ar.arengine.v;
import com.tencent.mobileqq.ar.arengine.x;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.mobileqq.ar.model.c;
import com.tencent.mobileqq.ar.q;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.olympic.activity.a;
import com.tencent.mobileqq.olympic.activity.b;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanDaTongApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.api.IARTransparentWebViewPluginApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.mapview.QMapView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARScanEntryView extends ScanEntryProviderView implements v, Handler.Callback, View.OnClickListener, CameraProxy.a, b.InterfaceC8180b {
    private boolean A0;
    private boolean B0;
    private boolean C0;
    private String D0;
    private String E0;
    public RelativeLayout F;
    private volatile ARCommonConfigInfo F0;
    public TextView G;
    private boolean G0;
    public TextView H;
    private Bundle H0;
    public TextView I;
    private long I0;
    public FrameLayout J;
    private boolean J0;
    public LinearLayout K;
    private boolean K0;
    public ScanSuccessView L;
    private boolean L0;
    public ObjectSurfaceView M;
    private boolean M0;
    public String N;
    private int N0;
    private int O0;
    public String P;
    private boolean P0;
    public String Q;
    private boolean Q0;
    public String R;
    private volatile boolean R0;
    public int S;
    private HashMap<String, Integer> S0;
    public boolean T;
    private ARVideoRecordViewProxy T0;
    public boolean U;
    private boolean U0;
    TextView V;
    private RelativeLayout V0;
    q W;
    private ScanIconAnimateView W0;
    private ImageView X0;
    private boolean Y0;
    private boolean Z0;

    /* renamed from: a0, reason: collision with root package name */
    boolean f198607a0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f198608a1;

    /* renamed from: b0, reason: collision with root package name */
    boolean f198609b0;

    /* renamed from: b1, reason: collision with root package name */
    private RelativeLayout f198610b1;

    /* renamed from: c0, reason: collision with root package name */
    boolean f198611c0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f198612c1;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f198613d0;

    /* renamed from: d1, reason: collision with root package name */
    private boolean f198614d1;

    /* renamed from: e0, reason: collision with root package name */
    boolean f198615e0;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f198616e1;

    /* renamed from: f0, reason: collision with root package name */
    boolean f198617f0;

    /* renamed from: f1, reason: collision with root package name */
    private com.tencent.mobileqq.olympic.activity.b f198618f1;

    /* renamed from: g0, reason: collision with root package name */
    volatile boolean f198619g0;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f198620g1;

    /* renamed from: h0, reason: collision with root package name */
    volatile boolean f198621h0;

    /* renamed from: h1, reason: collision with root package name */
    private MessageQueue.IdleHandler f198622h1;

    /* renamed from: i0, reason: collision with root package name */
    long f198623i0;

    /* renamed from: i1, reason: collision with root package name */
    private View.OnTouchListener f198624i1;

    /* renamed from: j0, reason: collision with root package name */
    ARTransferDoorLogicManager f198625j0;

    /* renamed from: j1, reason: collision with root package name */
    private long f198626j1;

    /* renamed from: k0, reason: collision with root package name */
    int f198627k0;

    /* renamed from: k1, reason: collision with root package name */
    private boolean f198628k1;

    /* renamed from: l0, reason: collision with root package name */
    boolean f198629l0;

    /* renamed from: l1, reason: collision with root package name */
    private boolean f198630l1;

    /* renamed from: m0, reason: collision with root package name */
    private com.tencent.mobileqq.olympic.activity.a f198631m0;

    /* renamed from: m1, reason: collision with root package name */
    private boolean f198632m1;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f198633n0;

    /* renamed from: n1, reason: collision with root package name */
    private QQCustomDialog f198634n1;

    /* renamed from: o0, reason: collision with root package name */
    private Runnable f198635o0;

    /* renamed from: o1, reason: collision with root package name */
    private ARLBSPOIDialog f198636o1;

    /* renamed from: p0, reason: collision with root package name */
    private Handler f198637p0;

    /* renamed from: p1, reason: collision with root package name */
    private QMapView f198638p1;

    /* renamed from: q0, reason: collision with root package name */
    private MqqHandler f198639q0;

    /* renamed from: q1, reason: collision with root package name */
    private Runnable f198640q1;

    /* renamed from: r0, reason: collision with root package name */
    private FrameLayout f198641r0;

    /* renamed from: r1, reason: collision with root package name */
    private boolean f198642r1;

    /* renamed from: s0, reason: collision with root package name */
    private TouchWebView f198643s0;

    /* renamed from: s1, reason: collision with root package name */
    private c.a f198644s1;

    /* renamed from: t0, reason: collision with root package name */
    private ViewGroup f198645t0;

    /* renamed from: t1, reason: collision with root package name */
    private boolean f198646t1;

    /* renamed from: u0, reason: collision with root package name */
    private TextView f198647u0;

    /* renamed from: u1, reason: collision with root package name */
    private c.b f198648u1;

    /* renamed from: v0, reason: collision with root package name */
    private TextView f198649v0;

    /* renamed from: v1, reason: collision with root package name */
    private com.tencent.mobileqq.armap.b f198650v1;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f198651w0;

    /* renamed from: w1, reason: collision with root package name */
    private SimpleDateFormat f198652w1;

    /* renamed from: x0, reason: collision with root package name */
    private QQARSession f198653x0;

    /* renamed from: x1, reason: collision with root package name */
    private boolean f198654x1;

    /* renamed from: y0, reason: collision with root package name */
    private com.tencent.mobileqq.ar.f f198655y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f198656z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Activity activity = (Activity) ARScanEntryView.this.f198780f;
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.putExtra("big_brother_source_key", "biz_src_jc_sacan");
            activity.startActivity(intent);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ARScanEntryView.this.f198634n1 = null;
            ARScanEntryView.this.f198653x0.J();
            ARScanEntryView.this.m1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ARScanEntryView.this.f198636o1 = null;
            ARScanEntryView.this.f198638p1 = null;
            ARScanEntryView.this.f198653x0.J();
            ARScanEntryView.this.m1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements TencentMap.OnMapLoadedCallback {
        g() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
        public void onMapLoaded() {
            Point screenLocation;
            ARScanEntryView aRScanEntryView = ARScanEntryView.this;
            aRScanEntryView.U = true;
            if (aRScanEntryView.f198638p1 != null) {
                Projection projection = ARScanEntryView.this.f198638p1.getMap().getProjection();
                TencentMap map = ARScanEntryView.this.f198638p1.getMap();
                if (projection != null && map != null && (screenLocation = projection.toScreenLocation(map.getCameraPosition().target)) != null) {
                    screenLocation.offset(0, BaseAIOUtils.f(60.0f, ARScanEntryView.this.f198780f.getResources()) * (-1));
                    map.moveCamera(CameraUpdateFactory.newLatLng(projection.fromScreenLocation(screenLocation)));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class h implements c.a {
        h() {
        }

        @Override // com.tencent.mobileqq.ar.model.c.a
        public void a() {
            QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResDownloadComplete ;" + ARScanEntryView.this.D);
            ARScanEntryView aRScanEntryView = ARScanEntryView.this;
            if (aRScanEntryView.D) {
                aRScanEntryView.N0 = 100;
                ARScanEntryView.this.f198637p0.removeMessages(324);
                ARScanEntryView.this.f198637p0.sendEmptyMessage(324);
                ARScanEntryView.this.G1();
            }
        }

        @Override // com.tencent.mobileqq.ar.model.c.a
        public void b() {
            ARScanEntryView.this.G1();
        }

        @Override // com.tencent.mobileqq.ar.model.c.a
        public void c(int i3) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResUpdateProgress " + i3 + ";" + ARScanEntryView.this.D);
            ARScanEntryView aRScanEntryView = ARScanEntryView.this;
            if (aRScanEntryView.D) {
                aRScanEntryView.N0 = i3;
                ARScanEntryView.this.F1();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class i implements c.b {
        i() {
        }

        @Override // com.tencent.mobileqq.ar.model.c.b
        public void a(int i3) {
            QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResUpdateProgress " + i3 + ";" + ARScanEntryView.this.D);
            ARScanEntryView aRScanEntryView = ARScanEntryView.this;
            if (aRScanEntryView.D) {
                aRScanEntryView.O0 = i3;
                ARScanEntryView.this.F1();
            }
        }

        @Override // com.tencent.mobileqq.ar.model.c.b
        public void b() {
            QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResDownLoadComplete " + ARScanEntryView.this.D);
            ARScanEntryView aRScanEntryView = ARScanEntryView.this;
            if (aRScanEntryView.D) {
                aRScanEntryView.O0 = 100;
                if (ARScanEntryView.this.f198653x0.F != null && ARScanEntryView.this.f198653x0.F.f197808c != null) {
                    ARScanEntryView.this.f198653x0.F.f197808c.n();
                }
                if (ARScanEntryView.this.f198637p0 != null) {
                    ARScanEntryView.this.f198637p0.removeMessages(324);
                    ARScanEntryView.this.f198637p0.sendEmptyMessage(324);
                }
                if (ARScanEntryView.this.f198646t1 && ARScanEntryView.this.f198783m.c().s()) {
                    ARScanEntryView.this.D1();
                    QLog.d("AREngine_ARScanEntryView", 1, "everything is ready,so quit update resources");
                } else {
                    ARScanEntryView.this.G1();
                }
            }
        }

        @Override // com.tencent.mobileqq.ar.model.c.b
        public void c() {
            ARScanEntryView.this.G1();
        }
    }

    public ARScanEntryView(Context context, com.tencent.mobileqq.ar.view.d dVar, boolean z16) {
        super(context, dVar);
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = -1;
        this.T = false;
        this.U = false;
        this.f198607a0 = true;
        this.f198609b0 = false;
        this.f198611c0 = false;
        this.f198615e0 = false;
        this.f198617f0 = false;
        this.f198619g0 = false;
        this.f198621h0 = false;
        this.f198623i0 = -1L;
        this.f198655y0 = null;
        this.f198656z0 = false;
        this.A0 = false;
        this.B0 = false;
        this.C0 = false;
        this.G0 = false;
        this.J0 = false;
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.N0 = 0;
        this.O0 = 0;
        this.P0 = false;
        this.Q0 = false;
        this.R0 = true;
        this.S0 = new HashMap<>();
        this.U0 = false;
        this.Y0 = false;
        this.Z0 = true;
        this.f198608a1 = false;
        this.f198612c1 = false;
        this.f198614d1 = false;
        this.f198616e1 = false;
        this.f198618f1 = null;
        this.f198622h1 = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "queueIdle called ");
                }
                if (ARScanEntryView.this.f198653x0 != null) {
                    ARScanEntryView aRScanEntryView = ARScanEntryView.this;
                    if (aRScanEntryView.D) {
                        aRScanEntryView.W0.e();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        };
        this.f198624i1 = new b();
        this.f198626j1 = -1L;
        this.f198628k1 = false;
        this.f198630l1 = false;
        this.f198632m1 = false;
        this.f198634n1 = null;
        this.f198636o1 = null;
        this.f198638p1 = null;
        this.f198644s1 = new h();
        this.f198646t1 = false;
        this.f198648u1 = new i();
        this.f198650v1 = new com.tencent.mobileqq.armap.b() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.5
            @Override // com.tencent.mobileqq.armap.b
            public void a(boolean z17, int i3, long j3) {
                boolean z18;
                SharedPreferences b16 = com.tencent.mobileqq.armap.c.b(ARScanEntryView.this.f198778d);
                long j16 = b16.getLong("key_ar_act_id", 0L);
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "onGetARRedDotInfo redSwitch = " + i3 + ",actID = " + j3 + ",isSuccess = " + z17 + ",savedActID = " + j16);
                }
                b16.edit().putLong("key_ar_act_id", j3).commit();
                if (!ARScanEntryView.this.D) {
                    QLog.d("AREngine_ARScanEntryView", 1, "onGetARRedDotInfo,not deal redhot message when pause");
                    return;
                }
                boolean z19 = b16.getBoolean("key_show_reddot", false);
                if (i3 == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    ARScanEntryView.this.Y0 = false;
                    ARScanEntryView.this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARScanEntryView.this.W0.c()) {
                                ARScanEntryView.this.W0.f();
                                ARScanEntryView.this.X0.setVisibility(4);
                            }
                        }
                    });
                    return;
                }
                if (j3 > j16 || (z19 && j3 == j16)) {
                    ARScanEntryView.this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ARScanEntryView.this.W0.d();
                            ARScanEntryView.this.X0.setVisibility(0);
                        }
                    });
                    b16.edit().putBoolean("key_show_reddot", true).commit();
                    ARScanEntryView.this.Y0 = true;
                }
                if (j3 < j16) {
                    ARScanEntryView.this.Y0 = false;
                    ARScanEntryView.this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARScanEntryView.this.W0.c()) {
                                ARScanEntryView.this.W0.f();
                                ARScanEntryView.this.X0.setVisibility(4);
                            }
                        }
                    });
                    b16.edit().putBoolean("key_show_reddot", false).commit();
                }
            }
        };
        this.f198654x1 = z16;
    }

    private void A0() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("addTimeoutCheck mArEnabled=%s mHasCallRemoveTimeoutCheck=%s", Boolean.TRUE, Boolean.valueOf(this.f198646t1)));
        }
        if (!this.f198646t1 && this.f198637p0 != null) {
            if (this.f198635o0 == null) {
                this.f198635o0 = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.36
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        boolean d16 = ARDeviceController.b().d();
                        boolean e16 = ARDeviceController.b().e();
                        boolean s16 = ARScanEntryView.this.f198783m.c().s();
                        com.tencent.mobileqq.olympic.activity.c h16 = ARScanEntryView.this.f198783m.h();
                        if (ARScanEntryView.this.f198612c1 && h16 != null) {
                            z16 = h16.s(ARScanEntryView.this.f198778d);
                        } else {
                            z16 = true;
                        }
                        QLog.d("AREngine_ARScanEntryView", 1, "excute mTimeoutChecker runnable isAREnable:=" + d16 + ",isSupportAr:=" + e16 + ",isBaseSoReady:=" + s16 + ",isPromotionResReady:=" + z16);
                        if (d16 && e16) {
                            if (!s16 || !z16) {
                                ARScanEntryView.this.J0 = true;
                                ARScanEntryView.this.G1();
                            } else if (ARScanEntryView.this.f198633n0) {
                                QLog.d("AREngine_ARScanEntryView", 1, "ARLoadFailed. mIsArSoReady = " + s16 + "mARStartFail = " + ARScanEntryView.this.f198633n0 + ",isPromotionResReady =" + z16);
                                ARScanEntryView.this.o1(HardCodeUtil.qqStr(R.string.jrf));
                            } else if (!ARScanEntryView.this.f198612c1) {
                                ARScanEntryView.this.o1(HardCodeUtil.qqStr(R.string.jra));
                                ReportController.o(null, "dc00898", "", "", "0X80085B3", "0X80085B3", 0, 0, "", "", "", "");
                            }
                        }
                        ARScanEntryView.this.f198635o0 = null;
                    }
                };
            }
            long j3 = 8000;
            if (this.f198783m.g() != null) {
                long j16 = this.f198783m.g().mARNoResultCheckTime;
                if (j16 > 0) {
                    j3 = j16;
                }
            }
            this.f198637p0.postDelayed(this.f198635o0, j3);
        }
    }

    private void A1() {
        if (this.f198640q1 == null) {
            this.f198640q1 = new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.35
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.ar.model.c c16 = ARScanEntryView.this.f198783m.c();
                    boolean q16 = c16.q();
                    QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck, AR\u7ec4\u4ef6\u52a0\u8f7d\u8d85, mIsDownloadTimeout[" + ARScanEntryView.this.f198642r1 + "],isBaseSoReady:=" + q16 + ",isFaceSoReady:=" + c16.r());
                    ARScanEntryView.this.f198642r1 = true;
                    if (!q16) {
                        ARScanEntryView.this.o1(HardCodeUtil.qqStr(R.string.jrg));
                        return;
                    }
                    ARScanEntryView.this.V0();
                    if (!ARScanEntryView.this.f198612c1) {
                        QQToast.makeText(BaseApplication.getContext(), R.string.br9, 0).show();
                    }
                }
            };
            QLog.d("AREngine_ARScanEntryView", 1, "startDownloadTimeoutCheck");
        }
        this.f198642r1 = false;
        this.f198637p0.removeCallbacks(this.f198640q1);
        this.f198637p0.postDelayed(this.f198640q1, 30000L);
    }

    private void B0() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("checkArDependenceReady time cost:%sms", Long.valueOf(System.currentTimeMillis() - this.f198626j1)));
        }
        boolean d16 = ARDeviceController.b().d();
        boolean e16 = ARDeviceController.b().e();
        QLog.i("AREngine_ARScanEntryView", 1, "checkArDependenceReady. isAREnable = " + d16 + ", isSupportAr = " + e16 + ", mIsArSoReady = false, mIsVideoPluginReady = false");
        com.tencent.mobileqq.ar.model.c c16 = this.f198783m.c();
        if (d16 && e16 && c16.f(2) && c16.f(8) && !this.G0) {
            QQARSession qQARSession = this.f198653x0;
            if (qQARSession != null && qQARSession.C0()) {
                if (!this.f198653x0.B0()) {
                    Y0();
                }
                if (this.D && this.f198653x0.B0() && this.f198653x0.C0() && this.f198653x0.G() == 1) {
                    this.f198653x0.J();
                }
            }
            if (this.f198783m.g() != null) {
                if (this.f198783m.g().isEnableVideoRecord == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ARVideoRecordUIControllerImpl.t().N(z16);
                QLog.d("AREngine_ARScanEntryView", 1, String.format("checkARVideoRecordEnable enable=%s", Boolean.valueOf(z16)));
            }
            if (!this.f198628k1 && !this.f198637p0.hasMessages(321)) {
                this.f198637p0.sendEmptyMessageDelayed(321, 100L);
                QLog.d("AREngine_ARScanEntryView", 1, "checkArDependenceReady do delay initARView");
            }
        }
    }

    private void C0() {
        QLog.d("AREngine_ARScanEntryView", 1, "checkIfNeedAutoFocus isCameraPrviewing=" + CameraProxy.v().B() + ";mIsResumed=" + this.D);
        if (CameraProxy.v().B() && this.D) {
            CameraProxy.v().n(UniformGLRenderManagerImpl.U, UniformGLRenderManagerImpl.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        QLog.i("AREngine_ARScanEntryView", 1, "stopAutoFoucus ");
        CameraProxy.v().p();
    }

    private void D0() {
        QLog.i("AREngine_ARScanEntryView", 1, "checkReadyToStartARSession = " + this.D);
        QQARSession qQARSession = this.f198653x0;
        if (qQARSession != null && qQARSession.B0() && this.D) {
            this.f198653x0.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        QLog.d("AREngine_ARScanEntryView", 2, "stopDownloadTimeoutCheck");
        Runnable runnable = this.f198640q1;
        if (runnable != null) {
            this.f198637p0.removeCallbacks(runnable);
            this.f198640q1 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        TextView textView = this.G;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.R = null;
        this.K.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        if (this.J0 && !this.f198642r1 && this.L0) {
            q1("updateDownloadProgress");
        }
    }

    private String G0(String str) {
        return str + "&_wv=" + android.R.layout.activity_list_item;
    }

    private void H0() {
        com.tencent.mobileqq.olympic.activity.b bVar = this.f198618f1;
        if (bVar != null) {
            bVar.c(null);
            this.f198618f1 = null;
        }
    }

    private void I0() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "doAfterAREngineReady = ");
        }
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.z(this.f198653x0);
        }
        com.tencent.mobileqq.olympic.activity.c h16 = this.f198783m.h();
        if (h16 != null) {
            h16.t(this.f198778d);
        }
        this.U0 = true;
    }

    private void J0() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "doHideNonPromotionUI = ");
        }
        this.V0.setVisibility(8);
        this.V.setVisibility(8);
    }

    private void L0(ARCommonConfigInfo aRCommonConfigInfo) {
        ArrayList<ARScanAR> arrayList;
        QLog.d("AREngine_ARScanEntryView", 1, "doWhenGetARConfig ");
        if (this.F0 != null) {
            return;
        }
        if (aRCommonConfigInfo != null && (arrayList = aRCommonConfigInfo.arControllers) != null) {
            Iterator<ARScanAR> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ARScanAR next = it.next();
                if (next != null && next.f197345d == 1) {
                    this.E0 = next.M;
                    this.D0 = next.I;
                    break;
                }
            }
        }
        if (!this.f198612c1) {
            this.f198637p0.removeMessages(325);
            this.f198637p0.sendEmptyMessage(325);
        }
        this.F0 = aRCommonConfigInfo;
        if (!this.H0.getBoolean("NoLimitParams", true)) {
            M0(this.F0, this.H0.getLong("recognitionMask", 0L));
        }
        final com.tencent.mobileqq.ar.model.c c16 = this.f198783m.c();
        final long j3 = this.I0;
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig start time cost:%sms", Long.valueOf(System.currentTimeMillis() - ARScanEntryView.this.f198626j1)));
                }
                long j16 = 0;
                if ((j3 & 4) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!c16.f(2)) {
                    j16 = 2;
                }
                if (!c16.f(8)) {
                    j16 |= 8;
                }
                if (c16.f(4) || !z16) {
                    ARScanEntryView.this.O0 = 100;
                } else {
                    j16 |= 4;
                }
                c16.x(j16, ARScanEntryView.this.f198644s1, ARScanEntryView.this.f198648u1);
                boolean q16 = c16.q();
                if (c16.f(4) || !z16) {
                    ARScanEntryView.this.O0 = 100;
                }
                if (q16) {
                    ARScanEntryView.this.N0 = 100;
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARScanEntryView", 2, String.format("doWhenGetARConfig end time cost:%sms", Long.valueOf(System.currentTimeMillis() - ARScanEntryView.this.f198626j1)));
                    }
                    if (ARScanEntryView.this.f198637p0 != null) {
                        ARScanEntryView.this.f198637p0.removeMessages(324);
                        ARScanEntryView.this.f198637p0.sendEmptyMessage(324);
                    }
                }
                if (q16 && ARScanEntryView.this.O0 != 100) {
                    ARScanEntryView.this.G1();
                }
            }
        }, null, false);
    }

    private void M0(ARCommonConfigInfo aRCommonConfigInfo, long j3) {
        ArrayList<ARRecognition> arrayList = aRCommonConfigInfo.recognitions;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<ARRecognition> arrayList2 = new ArrayList<>();
            if (j3 != 0) {
                Iterator<ARRecognition> it = aRCommonConfigInfo.recognitions.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    ARRecognition next = it.next();
                    if (next.f196956d == 12) {
                        z16 = true;
                    }
                    if (((1 << ((int) r9)) & j3) != 0) {
                        arrayList2.add(next);
                    }
                }
                if (!z16 && (j3 & 4096) != 0) {
                    ARRecognition aRRecognition = new ARRecognition();
                    aRRecognition.f196956d = 12L;
                    aRRecognition.f196957e = 1;
                    aRRecognition.f196958f = 1;
                    aRRecognition.f196959h = 4;
                    aRRecognition.f196961m = 1;
                }
                aRCommonConfigInfo.recognitions = arrayList2;
            }
        }
    }

    private String N0(long j3) {
        if (this.f198652w1 == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
            this.f198652w1 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        }
        try {
            return this.f198652w1.format(Long.valueOf(j3));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "getCurrentDateString exception", e16);
            }
            return null;
        }
    }

    private QMapView O0() {
        if (this.f198638p1 == null) {
            this.U = false;
            QMapView qMapView = new QMapView(this.f198780f);
            this.f198638p1 = qMapView;
            if (qMapView.getMap().getUiSettings() != null) {
                this.f198638p1.getMap().getUiSettings().setLogoPosition(0);
                this.f198638p1.getMap().getUiSettings().setScaleViewEnabled(false);
                this.f198638p1.getMap().getUiSettings().setScrollGesturesEnabled(false);
            }
            TencentMap map = this.f198638p1.getMap();
            map.setOnCameraChangeListener(new f());
            map.setOnMapLoadedCallback(new g());
            this.f198638p1.setEnabled(true);
            this.f198638p1.setClickable(true);
        }
        return this.f198638p1;
    }

    private TouchWebView P0() {
        if (this.f198643s0 == null) {
            g1();
        }
        return this.f198643s0;
    }

    private void T0() {
        QLog.d("AREngine_ARScanEntryView", 1, "handleARStartFail");
        this.f198633n0 = true;
        if (this.f198635o0 == null) {
            o1(HardCodeUtil.qqStr(R.string.jr9));
        }
    }

    private boolean U0() {
        boolean z16;
        String string = com.tencent.mobileqq.armap.c.b(this.f198778d).getString("key_click_reddot_date", null);
        String N0 = N0(NetConnInfoCenter.getServerTimeMillis());
        if (string != null && string.equals(N0)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "hasClickedRedDotToday  result = " + z16 + ",curDate = " + N0 + ",clickDate = " + string);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        FrameLayout frameLayout = this.J;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "hideViewFinder");
        }
        LinearLayout linearLayout = this.K;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setBackgroundResource(R.drawable.f1f);
        int f16 = BaseAIOUtils.f(15.0f, getResources());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(170.0f, getResources());
        this.K.setPadding(f16, f16, f16, BaseAIOUtils.f(7.0f, getResources()));
        if (this.f198630l1) {
            this.f198630l1 = false;
            layoutParams.addRule(13, 0);
        }
        TextView textView = this.f198651w0;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.f198607a0 = false;
    }

    private void Y0() {
        if (this.G0) {
            return;
        }
        Activity activity = (Activity) this.f198780f;
        try {
            QQARSession qQARSession = this.f198653x0;
            if (qQARSession != null && qQARSession.C0()) {
                long currentTimeMillis = System.currentTimeMillis();
                int y06 = this.f198653x0.y0(false, this.Z0, this.f198612c1, false, this.F0, null, null, this, activity, this.f198625j0, this.f198783m.j());
                ARReport.c().h(System.currentTimeMillis() - currentTimeMillis, y06);
                if (y06 == 0 && this.f198653x0.B0()) {
                    D0();
                } else {
                    QLog.e("AREngine_ARScanEntryView", 1, String.format("initAr fail. result=%s", Integer.valueOf(y06)));
                }
            }
        } catch (Exception e16) {
            QLog.e("AREngine_ARScanEntryView", 1, "initAr fail.", e16);
        }
        this.G0 = true;
    }

    private void Z0() {
        Activity activity = (Activity) this.f198780f;
        ARVideoRecordUIControllerImpl.t().K(activity);
        ARVideoRecordUIControllerImpl.t().I(activity);
        ARVideoRecordUIControllerImpl.t().m(this.T0);
    }

    private void a1() {
        if (!QQARSession.D0()) {
            QLog.d("AREngine_ARScanEntryView", 1, "ARScanEntryView onCreate error happen");
            return;
        }
        QQARSession s06 = QQARSession.s0();
        this.f198653x0 = s06;
        this.f198782i = s06;
        s06.H(this.f198780f, this.f198778d);
    }

    private void b1() {
        long currentTimeMillis = System.currentTimeMillis();
        this.F = (RelativeLayout) findViewById(R.id.root);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.jo9);
        this.f198645t0 = viewGroup;
        z81.e.d(this.f198780f, viewGroup);
        this.f198649v0 = (TextView) findViewById(R.id.jo_);
        this.f198647u0 = (TextView) findViewById(R.id.joc);
        String string = this.H0.getString("Title");
        if (!TextUtils.isEmpty(string)) {
            this.f198647u0.setText(string);
        }
        this.f198649v0.setOnClickListener(this);
        this.f198649v0.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        TextView textView = (TextView) findViewById(R.id.f164422x5);
        this.V = textView;
        if (this.f198654x1) {
            textView.setTextSize(16.0f);
        }
        this.f198641r0 = (FrameLayout) findViewById(R.id.l1y);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.b_r);
        this.V0 = relativeLayout;
        relativeLayout.setOnTouchListener(this.f198624i1);
        this.V0.setOnClickListener(this);
        this.V0.setContentDescription(HardCodeUtil.qqStr(R.string.jr_));
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setHelpBtnInfo(this.V0, IScanDaTongApi.PAGE_ID_AR, this.f198654x1);
        ScanIconAnimateView scanIconAnimateView = (ScanIconAnimateView) findViewById(R.id.b_u);
        this.W0 = scanIconAnimateView;
        scanIconAnimateView.setPopUpListener(new ScanIconAnimateView.i() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.7
            @Override // com.tencent.mobileqq.olympic.view.ScanIconAnimateView.i
            public void onEnd() {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "PopUp onEnd  needReportRedDot = " + ARScanEntryView.this.Y0);
                }
                if (ARScanEntryView.this.f198637p0 != null) {
                    ARScanEntryView.this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ARScanEntryView.this.Y0) {
                                ARScanEntryView.this.W0.d();
                                ARScanEntryView.this.X0.setVisibility(0);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.olympic.view.ScanIconAnimateView.i
            public void onStart() {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "PopUp onStart ");
                }
            }
        });
        this.X0 = (ImageView) findViewById(R.id.cap);
        ViewStub viewStub = (ViewStub) findViewById(R.id.f164421x2);
        if (viewStub != null) {
            viewStub.inflate();
            this.T0 = new ARVideoRecordViewProxy(findViewById(R.id.f164440xr));
        } else {
            QLog.e("AREngine_ARScanEntryView", 1, "initView but ar recordvideo stub is null.");
        }
        this.f198610b1 = (RelativeLayout) findViewById(R.id.f164417wy);
        if (this.f198625j0 == null) {
            ARTransferDoorLogicManager aRTransferDoorLogicManager = new ARTransferDoorLogicManager();
            this.f198625j0 = aRTransferDoorLogicManager;
            aRTransferDoorLogicManager.r(this.f198778d, (ScanTorchActivity) this.f198780f, this.f198610b1);
            this.f198625j0.f196835h = this;
        }
        if (this.f198612c1) {
            J0();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("initView time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    private boolean d1() {
        if (this.f198783m.j() != null) {
            return this.f198783m.j().C();
        }
        return true;
    }

    private boolean e1() {
        return !this.H0.getBoolean("NoLimitParams", true);
    }

    private void f1() {
        if (this.f198628k1) {
            return;
        }
        this.f198628k1 = true;
        long currentTimeMillis = System.currentTimeMillis();
        ViewStub viewStub = (ViewStub) findViewById(R.id.f164416wv);
        if (viewStub != null) {
            viewStub.inflate();
            ObjectSurfaceView objectSurfaceView = (ObjectSurfaceView) super.findViewById(R.id.fcf);
            this.M = objectSurfaceView;
            objectSurfaceView.setVisibility(8);
            q qVar = new q(this.f198780f, this.f198631m0);
            this.W = qVar;
            this.M.D = qVar;
            this.K = (LinearLayout) super.findViewById(R.id.l4z);
            this.G = (TextView) super.findViewById(R.id.jhp);
            this.H = (TextView) super.findViewById(R.id.jhq);
            TextView textView = (TextView) super.findViewById(R.id.jhr);
            this.I = textView;
            textView.setOnClickListener(this);
            FrameLayout frameLayout = (FrameLayout) super.findViewById(R.id.f167007jv2);
            this.J = frameLayout;
            frameLayout.setClickable(true);
            this.J.setOnClickListener(this);
            F0();
            W0();
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.J.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.f198780f), 0, 0);
            }
            y1();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitARView time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    private void g1() {
        if (this.f198643s0 == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f198643s0 = ((ScanTorchActivity) this.f198780f).getWebView(null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f198643s0.setVisibility(4);
            this.f198643s0.setOnScrollChangedListener(null);
            this.f198643s0.setBackgroundColor(0);
            this.f198643s0.setBackgroundResource(0);
            Drawable background = this.f198643s0.getBackground();
            if (background != null) {
                background.setAlpha(0);
            }
            this.f198641r0.setVisibility(0);
            this.f198641r0.addView(this.f198643s0, layoutParams);
            ARReport.c().r(System.currentTimeMillis() - currentTimeMillis);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, String.format("lazyInitWebView time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str) {
        QLog.d("AREngine_ARScanEntryView", 1, "scanTorch preLaunchToQQBrowseActivity ");
        String G0 = G0(str);
        P0();
        TouchWebView touchWebView = this.f198643s0;
        if (touchWebView != null) {
            touchWebView.onResume();
            this.f198643s0.loadUrl(G0);
        }
    }

    private void k1() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "removeTimeoutCheck");
        }
        this.f198646t1 = true;
        this.L0 = false;
        if (this.f198637p0 != null && this.f198635o0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "do removeTimeoutCheck");
            }
            this.f198637p0.removeCallbacks(this.f198635o0);
            this.f198635o0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(boolean z16) {
        ArCloudConfigInfo arCloudConfigInfo;
        com.tencent.mobileqq.ar.f fVar = this.f198655y0;
        if (fVar != null && (arCloudConfigInfo = fVar.f198365a) != null) {
            ArWebInfo arWebInfo = arCloudConfigInfo.H;
            if (arWebInfo != null) {
                this.R = arWebInfo.f198434f;
            }
            if (this.f198630l1) {
                this.f198630l1 = false;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                layoutParams.bottomMargin = BaseAIOUtils.f(170.0f, getResources());
                layoutParams.addRule(13, 0);
            }
            if (z16) {
                AppInterface appInterface = this.f198778d;
                com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", "0X80069D2", "0X80069D2", 0, 0, "1", appInterface.getCurrentAccountUin(), "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge flag=%s", Boolean.valueOf(z16)));
        }
        if (this.f198632m1 == z16) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "edge show equal so refuse");
                return;
            }
            return;
        }
        this.f198632m1 = z16;
        if (this.f198783m.j() != null) {
            this.f198783m.j().w(z16, 0.0f, 1.0f);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, String.format("setHaveEdge do real call flag=%s", Boolean.valueOf(z16)));
            }
        }
        this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.10
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                boolean z17;
                RelativeLayout relativeLayout = ARScanEntryView.this.V0;
                int i16 = 8;
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                relativeLayout.setVisibility(i3);
                if (z16 && !ARScanEntryView.this.f198612c1 && !ARScanEntryView.this.f198614d1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                TextView textView = ARScanEntryView.this.V;
                if (z17) {
                    i16 = 0;
                }
                textView.setVisibility(i16);
            }
        });
        this.f198783m.d(z16);
        G(z16);
    }

    private boolean n1() {
        SharedPreferences b16 = com.tencent.mobileqq.armap.c.b(this.f198778d);
        boolean z16 = b16.getBoolean("key_show_reddot", false);
        if (!U0()) {
            try {
                ArMapHandler arMapHandler = (ArMapHandler) this.f198778d.getBusinessHandler(com.tencent.mobileqq.armap.a.f199721a);
                long j3 = b16.getLong("key_ar_act_id", 0L);
                if (arMapHandler != null) {
                    try {
                        arMapHandler.F2(Long.parseLong(this.f198778d.getCurrentAccountUin()), j3);
                    } catch (NumberFormatException unused) {
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d("AREngine_ARScanEntryView", 1, "shouldShowActRedDot  getBusinessHandler fail ");
                return z16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "shouldShowActRedDot  result = " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(com.tencent.mobileqq.ar.arengine.b bVar, ArLBSActivity arLBSActivity) {
        if (arLBSActivity == null) {
            new ArLBSActivity();
            return;
        }
        int i3 = bVar.f198147a;
        if (i3 == 0) {
            if (bVar.f198149c == null) {
                QQToast.makeText(this.f198780f, arLBSActivity.f198419m, 1).show();
                return;
            }
            this.f198653x0.I();
            m1(false);
            s1(bVar.f198149c, arLBSActivity);
            return;
        }
        if (i3 == 2) {
            this.f198653x0.J();
            m1(false);
            if (this.f198634n1 == null) {
                this.f198634n1 = DialogUtil.createCustomDialog(this.f198780f, 230, arLBSActivity.C, arLBSActivity.D, HardCodeUtil.qqStr(R.string.ket), HardCodeUtil.qqStr(R.string.jr6), new a(), new c());
            }
            this.f198634n1.setOnDismissListener(new d());
            this.f198634n1.show();
        }
    }

    private void s1(b.a aVar, ArLBSActivity arLBSActivity) {
        if (this.f198636o1 == null) {
            ARLBSPOIDialog aRLBSPOIDialog = new ARLBSPOIDialog((Activity) this.f198780f, O0(), this);
            this.f198636o1 = aRLBSPOIDialog;
            aRLBSPOIDialog.setOnDismissListener(new e());
        }
        this.f198636o1.P();
        this.f198636o1.N(aVar, arLBSActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "showTouchView");
        }
        this.K.setVisibility(8);
        this.J.setVisibility(0);
        com.tencent.mobileqq.ar.f fVar = this.f198655y0;
        if (fVar == null || fVar.f198365a == null) {
            QLog.d("AREngine_ARScanEntryView", 1, "mArTarget == null || mArTarget.arResourceInfo == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("showViewFinder mHasViewFinderShow=%s isPause=%s", Boolean.valueOf(this.f198607a0), Boolean.valueOf(this.C)));
        }
        if (!this.f198607a0 && !this.C) {
            this.f198607a0 = true;
            TextView textView = this.f198651w0;
            if (textView != null) {
                textView.setVisibility(0);
            } else if (textView != null) {
                textView.setVisibility(8);
            }
            if (this.K != null) {
                int f16 = BaseAIOUtils.f(15.0f, getResources());
                this.K.setBackgroundResource(R.color.ajr);
                this.K.setPadding(f16, f16, f16, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                layoutParams.bottomMargin = BaseAIOUtils.f(170.0f, getResources());
                if (this.f198630l1) {
                    this.f198630l1 = false;
                    layoutParams.addRule(13, 0);
                }
                this.K.setLayoutParams(layoutParams);
                F0();
            }
        }
    }

    private void z1(boolean z16) {
        if (z16) {
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.11
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.m1(true);
                    ARScanEntryView.this.y1();
                    ARScanEntryView.this.l1(true);
                }
            });
        } else {
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.12
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.m1(false);
                    ARScanEntryView.this.X0();
                    ARScanEntryView.this.F0();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void A() {
        QLog.d("AREngine_ARScanEntryView", 1, "onDestroy ");
        if (this.Y0) {
            AppInterface appInterface = this.f198778d;
            com.tencent.mobileqq.utils.g.a(appInterface, "dc00898", "", appInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
        }
        this.f198783m.c().d();
        QQARSession qQARSession = this.f198653x0;
        if (qQARSession != null && qQARSession.C0()) {
            this.f198653x0.A1();
            this.f198653x0.K();
        }
        this.f198653x0 = null;
        QQARSession.t0();
        CameraProxy.v().H(this);
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.H();
            this.f198625j0 = null;
        }
        this.f198778d.removeObserver(this.f198650v1);
        ARVideoRecordUIControllerImpl.t().M();
        removeAllViews();
        this.f198781h = null;
        Context context = this.f198780f;
        if (context != null && (context instanceof ScanTorchActivity)) {
            ((ScanTorchActivity) context).doReport();
        }
        ScanIconAnimateView scanIconAnimateView = this.W0;
        if (scanIconAnimateView != null) {
            scanIconAnimateView.g();
            this.W0.f();
            this.W0 = null;
        }
        Handler handler = this.f198637p0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f198637p0 = null;
        }
        this.J0 = false;
        this.K0 = false;
        this.L0 = false;
        this.f198642r1 = false;
        H0();
        this.F0 = null;
        this.G0 = false;
        this.f198779e = false;
        this.f198633n0 = false;
        this.f198628k1 = false;
        super.A();
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void B(ARCommonConfigInfo aRCommonConfigInfo) {
        L0(aRCommonConfigInfo);
    }

    public void B1() {
        QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady isNotifyRecivied " + this.f198629l0);
        P0();
        this.f198643s0.setVisibility(0);
        this.f198647u0.setVisibility(8);
        ARVideoRecordUIControllerImpl.t().C(6);
        if (this.f198629l0) {
            ((IARTransparentWebViewPluginApi) QRoute.api(IARTransparentWebViewPluginApi.class)).startRender();
            this.f198637p0.sendEmptyMessage(307);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void C() {
        QLog.d("AREngine_ARScanEntryView", 1, "onPause ");
        m1(false);
        C1();
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.n();
        }
        ARVideoRecordUIControllerImpl.t().o();
        this.f198621h0 = true;
        TouchWebView touchWebView = this.f198643s0;
        if (touchWebView != null) {
            touchWebView.onPause();
        }
        Handler handler = this.f198637p0;
        if (handler != null) {
            handler.sendEmptyMessage(307);
        }
        ARLBSPOIDialog aRLBSPOIDialog = this.f198636o1;
        if (aRLBSPOIDialog != null) {
            aRLBSPOIDialog.dismiss();
        }
        QQCustomDialog qQCustomDialog = this.f198634n1;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        super.C();
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void D() {
        QLog.d("AREngine_ARScanEntryView", 1, "onProviderViewClose. mQQARSession mCurrentStatus:=" + this.f198653x0.G());
        super.D();
        C1();
        this.f198783m.c().d();
        m1(false);
        k1();
        V0();
        this.W0.g();
        this.W0.f();
        Looper.myQueue().removeIdleHandler(this.f198622h1);
        this.f198778d.removeObserver(this.f198650v1);
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.n();
        }
        ARVideoRecordUIControllerImpl.t().o();
        this.f198783m.d(true);
        this.f198646t1 = false;
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void E() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onProviderViewShow. mQQARSession mCurrentStatus:=");
        QQARSession qQARSession = this.f198653x0;
        if (qQARSession == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(qQARSession.G());
        }
        sb5.append(valueOf);
        QLog.d("AREngine_ARScanEntryView", 1, sb5.toString());
        this.f198626j1 = System.currentTimeMillis();
        super.E();
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setPageParams((ScanTorchActivity) this.f198780f, this, IScanDaTongApi.PAGE_ID_AR, this.f198654x1);
        C0();
        A0();
        if (!this.f198612c1) {
            K0();
            m1(true);
            this.f198778d.addObserver(this.f198650v1);
            if (n1()) {
                this.Y0 = true;
                Looper.myQueue().addIdleHandler(this.f198622h1);
            }
        } else {
            m1(false);
        }
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.o();
        }
        ARVideoRecordUIControllerImpl.t().p();
    }

    public boolean E0(String str) {
        boolean z16 = false;
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("mqqapi://miniapp/open") || lowerCase.startsWith("mqqapi://microapp/open")) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "checkUrlIsMiniAppJumpSchema, retValue is " + z16 + ",strUrl" + str);
        }
        return z16;
    }

    public void E1(String str, PromotionConfigInfo.a aVar, boolean z16) {
        QLog.d("AREngine_ARScanEntryView", 1, "tryToEnterTransferMode[" + str + "], mIsTransferDoorMode[" + this.f198614d1 + "], ready[" + z16 + "]");
        this.f198614d1 = true;
        this.f198612c1 = true;
        if (aVar != null) {
            this.f198647u0.setText(aVar.f196898f);
        }
        J0();
        WeakReference<QQARSession> weakReference = this.f198625j0.f196836i;
        if (weakReference != null && weakReference.get() != null) {
            this.f198625j0.f196836i.get().r0();
        }
        if (z16 && aVar != null) {
            this.f198616e1 = true;
            w1(false);
            x1(1);
            ArCloudConfigInfo c16 = aVar.c();
            this.f198625j0.A(2);
            this.f198625j0.w();
            this.f198625j0.C();
            this.f198625j0.D(c16);
            k1();
            V0();
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void F() {
        com.tencent.mobileqq.olympic.activity.a aVar;
        QQCustomDialog qQCustomDialog;
        QLog.d("AREngine_ARScanEntryView", 1, "onResume ");
        super.F();
        C0();
        if (!this.f198612c1 && !this.f198614d1) {
            m1(true);
        }
        this.f198621h0 = false;
        if (!this.f198607a0) {
            y1();
        }
        TouchWebView touchWebView = this.f198643s0;
        if (touchWebView != null) {
            touchWebView.onResume();
        }
        if (this.B0) {
            m1(true);
        }
        HashMap<String, Integer> hashMap = this.S0;
        if (hashMap != null) {
            hashMap.clear();
        }
        if (this.A0) {
            m1(true);
            TouchWebView touchWebView2 = this.f198643s0;
            if (touchWebView2 != null) {
                touchWebView2.setVisibility(4);
            }
        }
        this.A0 = false;
        this.f198609b0 = false;
        this.f198611c0 = false;
        q qVar = this.W;
        if (qVar != null && (qQCustomDialog = qVar.f198551b) != null && qQCustomDialog.isShowing()) {
            this.W.f198551b.dismiss();
        }
        q qVar2 = this.W;
        if (qVar2 != null && (aVar = qVar2.f198550a) != null) {
            aVar.k();
        }
        ARTransferDoorLogicManager aRTransferDoorLogicManager = this.f198625j0;
        if (aRTransferDoorLogicManager != null) {
            aRTransferDoorLogicManager.o();
        }
        ARVideoRecordUIControllerImpl.t().p();
    }

    public void G1() {
        H1(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b3, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H1(boolean z16) {
        boolean z17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateDownloadStatus, from[");
        sb5.append(!z16);
        sb5.append("]!mAfterDependenceTimeout=");
        sb5.append(!this.J0);
        sb5.append(";mIsDownloadTimeout=");
        sb5.append(this.f198642r1);
        QLog.d("AREngine_ARScanEntryView", 1, sb5.toString());
        if ((!this.J0 && !z16) || this.f198642r1) {
            return;
        }
        final com.tencent.mobileqq.ar.model.c c16 = this.f198783m.c();
        final com.tencent.mobileqq.olympic.activity.c h16 = this.f198783m.h();
        if (this.f198612c1 && h16 != null) {
            z17 = h16.s(this.f198778d);
        } else {
            z17 = true;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 2222, " + c16.s() + ";" + z17);
        boolean z18 = false;
        if (c16.s() && z17) {
            if (this.K0 || this.L0 || z16) {
                V0();
                this.K0 = false;
                this.L0 = false;
                D1();
                return;
            }
            return;
        }
        if (this.f198612c1) {
            QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 333, " + c16.u());
            if (!z18) {
                t1("AR\u7ec4\u4ef6\u52a0\u8f7d\u5931\u8d25", HardCodeUtil.qqStr(R.string.jrc), new a.j() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.37
                    @Override // com.tencent.mobileqq.olympic.activity.a.j
                    public void a() {
                        ARScanEntryView.this.M0 = false;
                        ARScanEntryView.this.q1("ClickTips");
                        ARScanEntryView.this.L0 = true;
                        ARScanEntryView.this.f198637p0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.37.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass37 anonymousClass37;
                                com.tencent.mobileqq.olympic.activity.c cVar;
                                c16.y();
                                if (ARScanEntryView.this.f198612c1 && (cVar = h16) != null) {
                                    cVar.w(ARScanEntryView.this.f198778d);
                                }
                            }
                        }, 1000L);
                    }
                });
                this.M0 = true;
                this.K0 = true;
                D1();
                if (!this.P0) {
                    this.P0 = true;
                    ReportController.o(null, "dc00898", "", "", "0X80085B5", "0X80085B5", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            q1("updateDownloadStatus");
            this.L0 = true;
            return;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "updateDownloadStatus 333, " + c16.u());
        if (!z18) {
        }
    }

    public String Q0(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("https")) {
            if (str.startsWith("http")) {
                return str;
            }
            return "https://" + str;
        }
        return str;
    }

    public com.tencent.mobileqq.olympic.activity.b R0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "getPromotionGuide create = " + z16);
        }
        if (!this.D) {
            return null;
        }
        if (this.f198618f1 == null && z16) {
            com.tencent.mobileqq.olympic.activity.b bVar = new com.tencent.mobileqq.olympic.activity.b((Activity) this.f198780f);
            this.f198618f1 = bVar;
            bVar.f(this);
        }
        return this.f198618f1;
    }

    public int S0() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void S3() {
        QLog.i("AREngine_ARScanEntryView", 1, "onStartPreviewSuccess");
        D0();
        K0();
        C0();
    }

    public void V0() {
        Throwable th5;
        com.tencent.mobileqq.olympic.activity.a aVar = this.f198631m0;
        if (aVar != null) {
            if (aVar.m()) {
                th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
            } else {
                th5 = null;
            }
            QLog.w("AREngine_ARScanEntryView", 1, "hideTips", th5);
            this.f198631m0.k();
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void b(final ArVideoResourceInfo arVideoResourceInfo, final com.tencent.mobileqq.ar.ARRenderModel.c cVar) {
        this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.25

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ar.view.ARScanEntryView$25$a */
            /* loaded from: classes11.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AnonymousClass25 anonymousClass25 = AnonymousClass25.this;
                    com.tencent.mobileqq.ar.ARRenderModel.c cVar = cVar;
                    if (cVar != null) {
                        cVar.j(arVideoResourceInfo);
                    }
                    ARScanEntryView.this.W0();
                    ARScanEntryView.this.F0();
                    ARScanEntryView aRScanEntryView = ARScanEntryView.this;
                    aRScanEntryView.J.setOnClickListener(aRScanEntryView);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ARScanEntryView.this.F0();
                ARScanEntryView.this.K.setVisibility(8);
                ARScanEntryView.this.J.setVisibility(0);
                ARScanEntryView.this.J.setOnClickListener(new a());
                if (QLog.isColorLevel()) {
                    QLog.i("AREngine_ARScanEntryView", 2, "onMultiARAnimationInteraction \u8bf7\u70b9\u51fb\u5c4f\u5e55\u8fdb\u5165\u4e0b\u4e00\u52a8\u753b\u7247\u6bb5\uff01");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void c(int i3) {
        Handler handler = this.f198637p0;
        if (handler == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 1, "onARStartComplete mUIhandler null retCode " + i3);
                return;
            }
            return;
        }
        if (i3 != 0) {
            if (i3 != 7) {
                if (i3 == 8) {
                    handler.sendEmptyMessage(310);
                    return;
                }
                return;
            }
            handler.sendEmptyMessage(309);
            return;
        }
        ScanTorchActivity scanTorchActivity = (ScanTorchActivity) this.f198780f;
        if (scanTorchActivity.mTimeArReady < 0) {
            scanTorchActivity.mTimeArReady = System.currentTimeMillis();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "onArReady success + time is " + (System.currentTimeMillis() - this.f198626j1));
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "onArReady success-visiable + time is " + (System.currentTimeMillis() - scanTorchActivity.getTimeActivityVisible()));
        }
        this.f198637p0.sendEmptyMessage(295);
    }

    public boolean c1() {
        if (this.f198608a1 && this.D && this.f198653x0.G() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void d(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "onEnginePause resetFaceUI = " + z16);
        }
        if (z16) {
            this.f198619g0 = false;
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.27
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.y1();
                    ARScanEntryView.this.l1(true);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void e(ArCloudConfigInfo arCloudConfigInfo, ArCloudConfigInfo arCloudConfigInfo2, int i3, int i16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "onCommonCallbackFromUI, config=" + arCloudConfigInfo + ", action=" + i3 + ", result=" + i16 + ", data=" + obj);
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.b.InterfaceC8180b
    public PromotionConfigInfo.a g() {
        return this.f198783m.h().l();
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void h(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f198627k0 = i16;
                    this.f198637p0.sendEmptyMessage(311);
                    return;
                }
                return;
            }
            this.f198637p0.sendEmptyMessage(307);
            return;
        }
        m1(false);
        k1();
        V0();
        this.f198637p0.sendEmptyMessage(306);
    }

    public void h1(PromotionConfigInfo.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "loadTransferDoorGuide ");
        }
        com.tencent.mobileqq.olympic.activity.b R0 = R0(true);
        if (R0 == null) {
            return;
        }
        R0.e(aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        TextView textView;
        TextView textView2;
        Handler handler;
        int i3 = message.what;
        if (i3 != 295) {
            if (i3 != 296) {
                if (i3 != 321) {
                    if (i3 != 352) {
                        if (i3 != 324) {
                            if (i3 != 325) {
                                switch (i3) {
                                    case 306:
                                        if (this.L == null) {
                                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                            ScanSuccessView scanSuccessView = new ScanSuccessView(this.f198780f);
                                            this.L = scanSuccessView;
                                            scanSuccessView.setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
                                            this.L.setScale(ScreenUtil.SCREEN_WIDTH);
                                            this.F.addView(this.L, layoutParams);
                                            this.f198637p0.removeMessages(com.tencent.luggage.wxa.rf.g.CTRL_INDEX);
                                            if (d1()) {
                                                m1(false);
                                                this.C0 = true;
                                                break;
                                            }
                                        }
                                        break;
                                    case 307:
                                        ScanSuccessView scanSuccessView2 = this.L;
                                        if (scanSuccessView2 != null) {
                                            this.F.removeView(scanSuccessView2);
                                            this.L = null;
                                            if (this.C0 && (handler = this.f198637p0) != null) {
                                                handler.sendEmptyMessageDelayed(com.tencent.luggage.wxa.rf.g.CTRL_INDEX, 2500L);
                                            }
                                            QLog.d("AREngine_ARScanEntryView", 1, "MSG_HIDE_SCAN_SUCCESS_PROGRESS,juhua has call finished ");
                                            break;
                                        }
                                        break;
                                    case 308:
                                        T0();
                                        break;
                                    case 309:
                                        T0();
                                        break;
                                    case 310:
                                        T0();
                                        break;
                                    case 311:
                                        ScanSuccessView scanSuccessView3 = this.L;
                                        if (scanSuccessView3 != null) {
                                            scanSuccessView3.setTotalProgress(this.f198627k0);
                                            break;
                                        }
                                        break;
                                    case 312:
                                        TouchWebView touchWebView = this.f198643s0;
                                        if (touchWebView != null) {
                                            touchWebView.onPause();
                                            break;
                                        }
                                        break;
                                    case 313:
                                        this.f198637p0.sendEmptyMessageDelayed(313, 50L);
                                        int i16 = this.f198627k0 + 1;
                                        this.f198627k0 = i16;
                                        ScanSuccessView scanSuccessView4 = this.L;
                                        if (scanSuccessView4 != null) {
                                            scanSuccessView4.setTotalProgress(i16);
                                            break;
                                        }
                                        break;
                                }
                            } else {
                                if (!TextUtils.isEmpty(this.D0) && (textView2 = this.V) != null) {
                                    textView2.setText(this.D0.replace(RedTouch.NEWLINE_CHAR, "\n"));
                                }
                                if (!this.f198612c1 && !this.f198614d1 && (textView = this.V) != null) {
                                    textView.setVisibility(0);
                                }
                            }
                        } else {
                            B0();
                        }
                    } else {
                        Activity activity = (Activity) this.f198780f;
                        if (this.C0 && !activity.isFinishing()) {
                            m1(true);
                        }
                    }
                } else {
                    f1();
                }
            } else {
                T0();
            }
        } else {
            QLog.d("AREngine_ARScanEntryView", 1, "start AR ready");
            l1(false);
            this.f198608a1 = true;
            I0();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void i(long j3, boolean z16, com.tencent.mobileqq.ar.f fVar) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "onAREnableModelRender, isEnable = " + z16);
        }
        boolean z17 = true;
        if (!z16) {
            try {
                ArCloudConfigInfo arCloudConfigInfo = fVar.f198365a;
                int i16 = arCloudConfigInfo.f197702i;
                int i17 = 3;
                int i18 = 100;
                if (i16 != 0) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                        } else if (arCloudConfigInfo.f()) {
                            i18 = 2;
                        } else if (fVar.f198365a.n()) {
                            i18 = 4;
                        } else {
                            i18 = 6;
                        }
                    } else if (arCloudConfigInfo.n()) {
                        i18 = 1;
                    } else if (fVar.f198365a.m()) {
                        i18 = 5;
                    }
                    i3 = 1;
                } else {
                    if (!arCloudConfigInfo.n()) {
                        if (fVar.f198365a.f()) {
                            i17 = 0;
                        } else {
                            i17 = 100;
                        }
                    }
                    i3 = 2;
                    i18 = i17;
                }
                ReportController.o(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, fVar.f198365a.f197703m, String.valueOf(i18), String.valueOf(i3), "");
            } catch (Exception e16) {
                QLog.d("AREngine_ARScanEntryView", 1, "0X80081E0 ReportController  error " + e16.getMessage());
            }
            if (!this.S0.containsValue(0) || !fVar.f198365a.f()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "onARStateChanged, AR_RECOG_STATE_LOST in");
                }
                if (this.A0) {
                    return;
                }
                m1(true);
                this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.18
                    @Override // java.lang.Runnable
                    public void run() {
                        ARScanEntryView.this.y1();
                        ARScanEntryView.this.W0();
                        ARScanEntryView.this.f198655y0 = null;
                    }
                });
                return;
            }
            return;
        }
        ArCloudConfigInfo arCloudConfigInfo2 = fVar.f198365a;
        if (arCloudConfigInfo2.f197698d != 1 || arCloudConfigInfo2.C != 0) {
            z17 = false;
        }
        if (!z17 || arCloudConfigInfo2.f()) {
            m1(false);
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.19
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.X0();
                    ARScanEntryView.this.F0();
                    ARScanEntryView.this.W0();
                }
            });
        }
    }

    public void i1() {
        this.f198629l0 = true;
        this.f198637p0.removeMessages(312);
        QLog.d("AREngine_ARScanEntryView", 1, "scanTorch notifyRenderReady " + this.f198611c0);
        if (this.f198611c0) {
            B1();
            this.f198637p0.sendEmptyMessage(307);
            this.f198637p0.removeMessages(313);
        }
        QQARSession qQARSession = this.f198653x0;
        if (qQARSession != null) {
            qQARSession.F0();
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void k() {
        QLog.d("AREngine_ARScanEntryView", 2, "ARTransferDoorLogicManager onRenderManagerStarted");
        if (this.D && this.f198614d1 && this.f198608a1) {
            QLog.d("AREngine_ARScanEntryView", 2, "start for next Time");
            this.f198625j0.C();
            this.f198625j0.D(null);
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void l(long j3, int i3, com.tencent.mobileqq.ar.ARRenderModel.f fVar, ab abVar) {
        x xVar;
        q qVar;
        QQCustomDialog qQCustomDialog;
        com.tencent.mobileqq.olympic.activity.a aVar;
        int l3;
        String str;
        String str2;
        k1();
        if (j3 == 128 && (abVar instanceof ac.a)) {
            ac.a aVar2 = (ac.a) abVar;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 1, " externalRenderResult info is isValidData=" + aVar2.f198003b + "isNeedShowViewFinder " + aVar2.f198004c);
            }
            if (!aVar2.f198003b) {
                this.R0 = false;
                z1(aVar2.f198004c);
                this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.13
                    @Override // java.lang.Runnable
                    public void run() {
                        ARScanEntryView.this.M.setVisibility(8);
                        ARScanEntryView.this.M.m();
                    }
                });
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("MIG object RectF(\u534f\u8bae\u539f\u59cb\u7684\u6570\u636e) ");
                ac.e eVar = aVar2.f198006e;
                if (eVar != null) {
                    str2 = eVar.f198029b.toString();
                } else {
                    str2 = "error happen";
                }
                sb5.append(str2);
                QLog.d("AREngine_MIGObjectClassifyResult", 1, sb5.toString());
            }
            z1(false);
            if (aVar2.f198006e == null) {
                return;
            }
            DrawView2.a aVar3 = new DrawView2.a();
            aVar3.f197441o = 99.0f;
            aVar3.f197433g = HardCodeUtil.qqStr(R.string.jr7) + ((int) (aVar2.f198006e.f198031d * 100.0d)) + "%";
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_MIGObjectClassifyResult", 1, " scantorch activitity result ok " + aVar2.f198006e.f198031d);
            }
            aVar3.f197432f = 10;
            aVar3.f197429c = DrawView2.a.c(aVar2.f198006e.f198029b);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_MIGObjectClassifyResult", 1, "MIG mapMigObjectRect2Screen(\u534f\u8bae\u8f6c\u5316\u540e\u7684\u6570\u636e) object RectF " + aVar3.f197429c);
            }
            aVar3.f197427a = null;
            aVar3.f197442p = null;
            ac.e eVar2 = aVar2.f198006e;
            aVar3.f197440n = eVar2.f198036i;
            aVar3.f197443q = false;
            aVar3.f197434h = true;
            aVar3.f197439m = true;
            aVar3.f197444r = false;
            aVar3.f197430d = eVar2.f198030c;
            String str3 = " ";
            if (TextUtils.isEmpty(eVar2.f198032e)) {
                str = " ";
            } else {
                str = aVar2.f198006e.f198032e;
            }
            aVar3.f197435i = str;
            if (!TextUtils.isEmpty(aVar2.f198006e.f198033f)) {
                str3 = aVar2.f198006e.f198033f;
            }
            aVar3.f197436j = str3;
            aVar3.f197431e = null;
            aVar3.f197437k = null;
            aVar3.f197438l = aVar2.f198006e.f198034g;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 1, " label name is " + aVar3.f197430d + "isAutoJump " + aVar3.f197440n);
                if (TextUtils.isEmpty(aVar2.f198006e.f198033f)) {
                    QLog.d("AREngine_ARScanEntryView", 1, " profileContent    null  ");
                }
            }
            ObjectSurfaceView objectSurfaceView = this.M;
            if (objectSurfaceView == null) {
                QLog.d("AREngine_ARScanEntryView", 1, " mObjectSurfaceView not ready ");
                return;
            }
            objectSurfaceView.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.14
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.M.setVisibility(0);
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar3);
            this.M.setFaceData(arrayList);
            return;
        }
        if (j3 == 4) {
            q qVar2 = this.W;
            if (qVar2 != null && (aVar = qVar2.f198550a) != null && (l3 = aVar.l()) != 3 && l3 != 2 && l3 != 0) {
                V0();
            }
        } else {
            V0();
        }
        if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
            QLog.d("AREngine_ARScanEntryView", 2, "onARTrackComplete, recogType = " + j3 + ",trackMode = " + i3 + ",trackResult = " + fVar + ",localRecogResult = " + abVar + ",isPause = " + this.f198621h0);
        }
        if (this.f198621h0 || j3 != 4 || !(abVar instanceof x) || (xVar = (x) abVar) == null) {
            return;
        }
        Activity activity = (Activity) this.f198780f;
        ArrayList<DrawView2.a> arrayList2 = xVar.f198293d;
        if ((arrayList2 == null || arrayList2.size() <= 0) && (qVar = this.W) != null && (qQCustomDialog = qVar.f198551b) != null && qQCustomDialog.isShowing() && !activity.isFinishing()) {
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.15
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.W.f198551b.dismiss();
                }
            });
        }
        if (xVar.f198292c) {
            this.f198619g0 = false;
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.16
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.m1(true);
                    ARScanEntryView.this.y1();
                    ARScanEntryView.this.l1(true);
                }
            });
            return;
        }
        if (!this.f198619g0) {
            this.f198619g0 = true;
            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.17
                @Override // java.lang.Runnable
                public void run() {
                    ARScanEntryView.this.m1(false);
                    ARScanEntryView.this.C1();
                    ARScanEntryView.this.X0();
                    ARScanEntryView.this.F0();
                }
            });
        }
        if (this.f198623i0 < 0) {
            this.f198623i0 = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void m(long j3, final com.tencent.mobileqq.ar.f fVar) {
        ArWebInfo arWebInfo;
        k1();
        V0();
        if (fVar != null && fVar.f198365a != null) {
            if (!this.f198620g1) {
                try {
                    ArrayList<String> x06 = this.f198653x0.x0();
                    if (x06 != null) {
                        x06.size();
                        x06.toString();
                    }
                } catch (Exception unused) {
                }
                this.f198620g1 = true;
            }
            if (fVar.f198365a.j()) {
                return;
            }
            ArWebInfo arWebInfo2 = fVar.f198365a.H;
            if (arWebInfo2 != null && arWebInfo2.f198433e && arWebInfo2.f198432d && !TextUtils.isEmpty(arWebInfo2.f198434f)) {
                this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        ARScanEntryView.this.A0 = true;
                        ARScanEntryView.this.X0();
                        ARScanEntryView.this.F0();
                        ARScanEntryView.this.m1(false);
                        ARScanEntryView aRScanEntryView = ARScanEntryView.this;
                        if (!aRScanEntryView.f198609b0 || !aRScanEntryView.f198629l0) {
                            aRScanEntryView.j1(fVar.f198365a.H.f198434f);
                            ARScanEntryView.this.f198611c0 = true;
                        } else {
                            aRScanEntryView.B1();
                        }
                    }
                });
                if (!this.f198609b0) {
                    this.f198637p0.sendEmptyMessage(306);
                    this.f198637p0.sendEmptyMessageAtTime(313, 100L);
                    this.f198637p0.sendEmptyMessageDelayed(312, JsonGrayBusiId.UI_RESERVE_100000_110000);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete start jump :" + fVar.f198365a.H.f198434f);
                    return;
                }
                return;
            }
            ArCloudConfigInfo arCloudConfigInfo = fVar.f198365a;
            if (arCloudConfigInfo.f197702i == 6 && (arWebInfo = arCloudConfigInfo.H) != null && !arWebInfo.f198433e && arWebInfo.f198432d && !TextUtils.isEmpty(arWebInfo.f198434f)) {
                ReportController.o(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, fVar.f198365a.f197703m, "1", "0", "");
                String str = fVar.f198365a.H.f198434f;
                Activity activity = (Activity) this.f198780f;
                if (E0(str)) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(str));
                    intent.addFlags(268435456);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setPackage(this.f198778d.getApp().getPackageName());
                    this.f198780f.startActivity(intent);
                } else {
                    Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("big_brother_source_key", "biz_src_jc_sacan");
                    intent2.putExtra("url", str);
                    intent2.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
                    activity.startActivity(intent2);
                }
                if (this.f198780f instanceof Activity) {
                    activity.overridePendingTransition(R.anim.f154454a3, 0);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARRecogComplete empty value");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0293, code lost:
    
        if (r4 != 4) goto L117;
     */
    @Override // com.tencent.mobileqq.ar.arengine.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(int i3, final com.tencent.mobileqq.ar.f fVar, final int i16) {
        ArWebInfo arWebInfo;
        ArCloudConfigInfo arCloudConfigInfo;
        int i17;
        int i18;
        ArWebInfo arWebInfo2;
        final boolean z16 = true;
        if (fVar != null && fVar.f198365a != null) {
            QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, remainCount " + i16);
            int i19 = 4;
            int i26 = 3;
            int i27 = 0;
            int i28 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "onARAnimationStateChanged, mLastArAnimState=", Integer.valueOf(this.S), ", newState=", i3 + ", target=" + fVar);
            }
            int i29 = 100;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            this.T = false;
                            this.f198655y0 = null;
                            this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.24
                                @Override // java.lang.Runnable
                                public void run() {
                                    QQToast.makeText(ARScanEntryView.this.f198780f, HardCodeUtil.qqStr(R.string.jrb), 1).show(ARScanEntryView.this.S0());
                                }
                            });
                        }
                    } else {
                        try {
                            ArCloudConfigInfo arCloudConfigInfo2 = fVar.f198365a;
                            int i36 = arCloudConfigInfo2.f197702i;
                            if (i36 != 0) {
                                if (i36 != 2) {
                                    if (i36 != 3) {
                                        if (i36 == 4) {
                                            i28 = 0;
                                        }
                                    } else {
                                        if (arCloudConfigInfo2.f()) {
                                            i19 = 2;
                                        } else if (!fVar.f198365a.n()) {
                                            i19 = 6;
                                        }
                                        i28 = 1;
                                        i29 = i19;
                                    }
                                } else {
                                    if (arCloudConfigInfo2.n()) {
                                        i29 = 1;
                                    } else if (fVar.f198365a.m()) {
                                        i29 = 5;
                                    }
                                    i28 = 1;
                                }
                            } else {
                                if (!arCloudConfigInfo2.n()) {
                                    if (fVar.f198365a.f()) {
                                        i26 = 0;
                                    } else {
                                        i26 = 100;
                                    }
                                }
                                i29 = i26;
                            }
                            ReportController.o(null, "CliOper", "", "", "0X80081E0", "0X80081E0", 0, 0, fVar.f198365a.f197703m, String.valueOf(i29), String.valueOf(i28), "");
                        } catch (Exception e16) {
                            QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + e16.getMessage());
                        }
                        this.T = false;
                        this.f198655y0 = null;
                        this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.23
                            @Override // java.lang.Runnable
                            public void run() {
                                ARScanEntryView.this.l1(true);
                                ARScanEntryView.this.W0();
                                ARScanEntryView.this.y1();
                            }
                        });
                        AppInterface appInterface = this.f198778d;
                        com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", "0X80069D0", "0X80069D0", 0, 0, "1", appInterface.getCurrentAccountUin(), fVar.f198365a.f197703m, "");
                    }
                } else {
                    this.f198655y0 = fVar;
                    if (!fVar.f198365a.f()) {
                        AppInterface appInterface2 = this.f198778d;
                        com.tencent.mobileqq.utils.g.a(appInterface2, "CliOper", "", "", "0X8008144", "0X8008144", 0, 0, "1", appInterface2.getCurrentAccountUin(), fVar.f198365a.f197703m, "2");
                    }
                    int i37 = fVar.f198365a.f197702i;
                    if (i37 != 0 && i37 != 5) {
                        i18 = com.tencent.mobileqq.ar.g.c(fVar);
                        if (i18 == 0) {
                            i18 = Integer.MAX_VALUE;
                        }
                    } else {
                        i18 = 1;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARScanEntryView", 2, "AREngineCallback.AR_ANIMATION_STATE_END, remainCount is " + i18 + ",remainCount" + i16);
                    }
                    if (i16 == 0) {
                        try {
                            ArCloudConfigInfo arCloudConfigInfo3 = fVar.f198365a;
                            int i38 = arCloudConfigInfo3.f197702i;
                            if (i38 != 0) {
                                if (i38 != 2) {
                                    if (i38 != 3) {
                                        if (i38 == 4) {
                                            i28 = 0;
                                        }
                                    } else {
                                        if (arCloudConfigInfo3.f()) {
                                            i19 = 2;
                                        } else if (!fVar.f198365a.n()) {
                                            i19 = 6;
                                        }
                                        i28 = 1;
                                        i29 = i19;
                                    }
                                } else {
                                    if (arCloudConfigInfo3.n()) {
                                        i29 = 1;
                                    } else if (fVar.f198365a.m()) {
                                        i29 = 5;
                                    }
                                    i28 = 1;
                                }
                            } else {
                                if (!arCloudConfigInfo3.n()) {
                                    if (fVar.f198365a.f()) {
                                        i26 = 0;
                                    } else {
                                        i26 = 100;
                                    }
                                }
                                i29 = i26;
                            }
                            ReportController.o(null, "CliOper", "", "", "0X80081E1", "0X80081E1", 0, 0, fVar.f198365a.f197703m, String.valueOf(i29), String.valueOf(i28), "");
                        } catch (Exception e17) {
                            QLog.d("AREngine_ARScanEntryView", 1, "0X80081E1 ReportController  error " + e17.getMessage());
                        }
                    }
                    ArCloudConfigInfo arCloudConfigInfo4 = fVar.f198365a;
                    if (arCloudConfigInfo4.f197698d != 0 && ((arWebInfo2 = arCloudConfigInfo4.H) == null || TextUtils.isEmpty(arWebInfo2.f198434f))) {
                        z16 = false;
                    }
                    this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.22
                        @Override // java.lang.Runnable
                        public void run() {
                            ArWebInfo arWebInfo3;
                            ArCloudConfigInfo arCloudConfigInfo5 = fVar.f198365a;
                            if (arCloudConfigInfo5.f197698d == 1 || (arWebInfo3 = arCloudConfigInfo5.H) == null || !arWebInfo3.f198432d || TextUtils.isEmpty(arWebInfo3.f198434f) || i16 != 0) {
                                ARScanEntryView.this.F0();
                                if (z16) {
                                    ARScanEntryView.this.v1();
                                    return;
                                }
                                return;
                            }
                            ArCloudConfigInfo arCloudConfigInfo6 = fVar.f198365a;
                            if (arCloudConfigInfo6.H.f198433e) {
                                ReportController.o(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, arCloudConfigInfo6.f197703m, "1", "1", "");
                                ARScanEntryView.this.A0 = true;
                                if (ARScanEntryView.this.f198653x0 != null) {
                                    ARScanEntryView.this.f198653x0.U0(1L);
                                    ARScanEntryView.this.f198653x0.F1();
                                }
                                ARScanEntryView.this.B1();
                                return;
                            }
                            ReportController.o(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, arCloudConfigInfo6.f197703m, "1", "0", "");
                            if (fVar.f198365a.b()) {
                                ReportController.o(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, fVar.f198365a.f197703m, "1", "0", "");
                            }
                            Activity activity = (Activity) ARScanEntryView.this.f198780f;
                            String str = fVar.f198365a.H.f198434f;
                            activity.setResult(11);
                            ARVideoRecordUIControllerImpl.t().C(2);
                            if (ARScanEntryView.this.E0(str)) {
                                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                                intent.setData(Uri.parse(str));
                                intent.addFlags(268435456);
                                intent.addCategory("android.intent.category.DEFAULT");
                                intent.setPackage(ARScanEntryView.this.f198778d.getApp().getPackageName());
                                ARScanEntryView.this.f198780f.startActivity(intent);
                            } else {
                                Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                intent2.putExtra("big_brother_source_key", "biz_src_jc_sacan");
                                intent2.putExtra("url", ARScanEntryView.this.Q0(str));
                                activity.startActivity(intent2);
                            }
                            if (ARScanEntryView.this.f198655y0 != null && !ARScanEntryView.this.f198655y0.f198365a.f()) {
                                AppInterface appInterface3 = ARScanEntryView.this.f198778d;
                                com.tencent.mobileqq.utils.g.a(appInterface3, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", appInterface3.getCurrentAccountUin(), ARScanEntryView.this.f198655y0.f198365a.f197703m, "2");
                            }
                            ARScanEntryView.this.B0 = true;
                        }
                    });
                    AppInterface appInterface3 = this.f198778d;
                    com.tencent.mobileqq.utils.g.a(appInterface3, "CliOper", "", "", "0X80069CF", "0X80069CF", 0, 0, "1", appInterface3.getCurrentAccountUin(), fVar.f198365a.f197703m, "");
                }
            } else {
                this.T = true;
                this.f198655y0 = fVar;
                this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.20
                    @Override // java.lang.Runnable
                    public void run() {
                        ARScanEntryView.this.X0();
                        ARScanEntryView.this.F0();
                        ARScanEntryView.this.W0();
                        ARScanEntryView.this.m1(false);
                        if ((!ARVideoRecordUIControllerImpl.t().F() || ARVideoRecordUIControllerImpl.t().E()) && !fVar.f198365a.e() && !fVar.f198365a.a()) {
                            ARVideoRecordUIControllerImpl.t().J();
                            ARVideoRecordUIControllerImpl.t().H();
                            QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning false");
                        } else if (fVar.f198365a.e()) {
                            ARVideoRecordUIControllerImpl.t().B();
                            QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl bin hai not show");
                        } else {
                            QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, ARVideoRecordUIControllerImpl isVideoRecordRunning true");
                        }
                    }
                });
                try {
                    arCloudConfigInfo = fVar.f198365a;
                    i17 = arCloudConfigInfo.f197702i;
                } catch (Exception e18) {
                    QLog.d("AREngine_ARScanEntryView", 1, "0X80081DF ReportController  error " + e18.getMessage());
                }
                if (i17 != 0) {
                    if (i17 != 2) {
                        if (i17 == 3) {
                            if (arCloudConfigInfo.f()) {
                                i19 = 2;
                            } else if (!fVar.f198365a.n()) {
                                i19 = 6;
                            }
                            i27 = 1;
                            i29 = i19;
                        }
                    } else {
                        if (arCloudConfigInfo.n()) {
                            i29 = 1;
                        } else if (fVar.f198365a.m()) {
                            i29 = 5;
                        }
                        i27 = 1;
                    }
                    ReportController.o(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, fVar.f198365a.f197703m, String.valueOf(i29), String.valueOf(i27), "");
                    arWebInfo = fVar.f198365a.H;
                    if (arWebInfo == null && arWebInfo.f198433e) {
                        this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.21
                            @Override // java.lang.Runnable
                            public void run() {
                                ARScanEntryView.this.j1(fVar.f198365a.H.f198434f);
                            }
                        });
                        this.f198637p0.sendEmptyMessageDelayed(312, JsonGrayBusiId.UI_RESERVE_100000_110000);
                        return;
                    } else {
                        AppInterface appInterface4 = this.f198778d;
                        com.tencent.mobileqq.utils.g.a(appInterface4, "CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", appInterface4.getCurrentAccountUin(), fVar.f198365a.f197703m, "2");
                    }
                } else {
                    if (!arCloudConfigInfo.n()) {
                        if (fVar.f198365a.f()) {
                            i26 = 0;
                        } else {
                            i26 = 100;
                        }
                    }
                    i29 = i26;
                }
                i27 = 2;
                ReportController.o(null, "CliOper", "", "", "0X80081DF", "0X80081DF", 0, 0, fVar.f198365a.f197703m, String.valueOf(i29), String.valueOf(i27), "");
                arWebInfo = fVar.f198365a.H;
                if (arWebInfo == null) {
                }
                AppInterface appInterface42 = this.f198778d;
                com.tencent.mobileqq.utils.g.a(appInterface42, "CliOper", "", "", "0X80069CC", "0X80069CC", 0, 0, "1", appInterface42.getCurrentAccountUin(), fVar.f198365a.f197703m, "2");
            }
            this.S = i3;
            return;
        }
        QLog.d("AREngine_ARScanEntryView", 1, "onARAnimationStateChanged, arTarget == null || arTarget.arResourceInfo == null");
    }

    public void o1(String str) {
        if (this.f198631m0 != null) {
            QLog.w("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + str + "], isVisible[" + this.f198631m0.m() + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            this.f198631m0.t(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("AREngine_ARScanEntryView", 1, "onAttachedToWindow ");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArWebInfo arWebInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        ScanTorchActivity scanTorchActivity = (ScanTorchActivity) this.f198780f;
        int id5 = view.getId();
        if (id5 == R.id.jo_) {
            scanTorchActivity.doOnBackPressed(false);
        } else if (id5 == R.id.f167007jv2) {
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_ARScanEntryView", 2, "onClick R.id.touch_view");
            }
            com.tencent.mobileqq.ar.f fVar = this.f198655y0;
            if (fVar != null && (arWebInfo = fVar.f198365a.H) != null && !TextUtils.isEmpty(arWebInfo.f198434f)) {
                ArCloudConfigInfo arCloudConfigInfo = this.f198655y0.f198365a;
                if (!arCloudConfigInfo.H.f198433e) {
                    ReportController.o(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, arCloudConfigInfo.f197703m, "0", "1", "");
                    if (this.f198655y0.f198365a.b()) {
                        ReportController.o(null, "CliOper", "", "", "0X80098D1", "0X80098D1", 0, 0, this.f198655y0.f198365a.f197703m, "1", "0", "");
                    }
                    String str = this.f198655y0.f198365a.H.f198434f;
                    scanTorchActivity.setResult(11);
                    ARVideoRecordUIControllerImpl.t().C(3);
                    if (E0(str)) {
                        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                        intent.setData(Uri.parse(str));
                        intent.addFlags(268435456);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setPackage(this.f198778d.getApp().getPackageName());
                        this.f198780f.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent(scanTorchActivity, (Class<?>) QQBrowserActivity.class);
                        intent2.putExtra("big_brother_source_key", "biz_src_jc_sacan");
                        intent2.putExtra("url", Q0(str));
                        scanTorchActivity.startActivity(intent2);
                    }
                    this.B0 = true;
                } else {
                    ReportController.o(null, "CliOper", "", "", "0X80081E2", "0X80081E2", 0, 0, arCloudConfigInfo.f197703m, "0", "0", "");
                    this.A0 = true;
                    m1(false);
                    X0();
                    F0();
                    QQARSession qQARSession = this.f198653x0;
                    if (qQARSession != null) {
                        qQARSession.U0(1L);
                        this.f198653x0.F1();
                    }
                    B1();
                }
                com.tencent.mobileqq.ar.f fVar2 = this.f198655y0;
                if (fVar2 != null && !fVar2.f198365a.f()) {
                    AppInterface appInterface = this.f198778d;
                    com.tencent.mobileqq.utils.g.a(appInterface, "CliOper", "", "", "0X8008145", "0X8008145", 0, 0, "1", appInterface.getCurrentAccountUin(), this.f198655y0.f198365a.f197703m, "2");
                }
                W0();
            }
            com.tencent.mobileqq.ar.f fVar3 = this.f198655y0;
            if (fVar3 != null && !TextUtils.isEmpty(fVar3.f198365a.f197703m)) {
                AppInterface appInterface2 = this.f198778d;
                com.tencent.mobileqq.utils.g.a(appInterface2, "CliOper", "", "", "0X80069D1", "0X80069D1", 0, 0, "1", appInterface2.getCurrentAccountUin(), this.f198655y0.f198365a.f197703m, "");
            }
        } else if (id5 == R.id.b_r) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "find button clicked what2scanUrl = " + this.E0);
            }
            AppInterface appInterface3 = this.f198778d;
            com.tencent.mobileqq.utils.g.a(appInterface3, "dc00898", "", appInterface3.getCurrentAccountUin(), "0X8008615", "0X8008615", 0, 0, "", "", "", "");
            SharedPreferences b16 = com.tencent.mobileqq.armap.c.b(this.f198778d);
            if (this.W0.c()) {
                this.W0.f();
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning runiing");
                }
            }
            this.X0.setVisibility(4);
            if (b16.getBoolean("key_show_reddot", false)) {
                b16.edit().putString("key_click_reddot_date", N0(NetConnInfoCenter.getServerTimeMillis())).commit();
                b16.edit().putBoolean("key_show_reddot", false).commit();
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "isPendulumRunning KEY_SHOW_REDDOT true");
                }
            }
            try {
                String str2 = this.E0;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "https://ti.qq.com/arinfo/index.html?_nav_alpha=true";
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARScanEntryView", 2, "find button clicked jumpurl  = " + str2);
                }
                Intent intent3 = new Intent(scanTorchActivity, (Class<?>) QQBrowserActivity.class);
                intent3.putExtra("big_brother_source_key", "biz_src_jc_sacan");
                intent3.putExtra("url", str2);
                intent3.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, false);
                scanTorchActivity.startActivity(intent3);
            } catch (Exception e16) {
                QLog.e("AREngine_ARScanEntryView", 1, "find button clicked start QQBrowserActivity catch an Exception.", e16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.olympic.activity.b.InterfaceC8180b
    public boolean p() {
        return this.D;
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void q(final com.tencent.mobileqq.ar.arengine.b bVar, final ArLBSActivity arLBSActivity) {
        QLog.d("AREngine_ARScanEntryView", 2, "onLBSLocationComplete. retCode = " + bVar.f198147a + ", LBSActivity = " + arLBSActivity);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.28
            @Override // java.lang.Runnable
            public void run() {
                ARScanEntryView.this.p1(bVar, arLBSActivity);
            }
        });
    }

    public void q1(String str) {
        r1(str, false);
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void r(int i3, final String str) {
        QLog.d("AREngine_ARScanEntryView", 2, "onStartLoadUrl");
        this.f198609b0 = true;
        this.f198637p0.post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.ARScanEntryView.26
            @Override // java.lang.Runnable
            public void run() {
                ARScanEntryView.this.j1(str);
            }
        });
        this.f198637p0.sendEmptyMessageDelayed(312, JsonGrayBusiId.UI_RESERVE_100000_110000);
    }

    public void r1(String str, boolean z16) {
        boolean z17;
        int i3;
        if (z16 && ((this.f198616e1 || this.M0) && !this.f198633n0)) {
            QLog.w("AREngine_ARScanEntryView", 1, "showLoadProgress, \u5df2\u7ecf\u5728\u7a7f\u8d8a\u95e8\u91cc\u9762\u4e86, from[" + str + "]");
            return;
        }
        this.f198783m.c();
        int i16 = (this.O0 + this.N0) / 2;
        QLog.d("AREngine_ARScanEntryView", 1, "showLoadProgress mCurrentAsyncProgress:=" + this.O0 + ",mCurrentSyncProgress:=" + this.N0);
        ARVideoRecordViewProxy aRVideoRecordViewProxy = this.T0;
        boolean z18 = false;
        if (aRVideoRecordViewProxy != null && aRVideoRecordViewProxy.o()) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.mobileqq.olympic.activity.c h16 = this.f198783m.h();
        if (h16 != null && this.f198612c1) {
            z18 = h16.r();
            i3 = h16.n();
        } else {
            i3 = 0;
        }
        if (z18) {
            i16 = (i16 + i3) / 2;
        }
        if (z17) {
            V0();
        } else {
            u1(str, HardCodeUtil.qqStr(R.string.jre), i16);
        }
        A1();
        if (!this.Q0) {
            this.Q0 = true;
            ReportController.o(null, "dc00898", "", "", "0X80085B6", "0X80085B6", 0, 0, "", "", "", "");
        }
    }

    public void t1(String str, String str2, a.j jVar) {
        if (this.f198631m0 != null) {
            QLog.d("AREngine_ARScanEntryView", 1, "showErrorTips, str[" + str + "], isVisible[" + this.f198631m0.m() + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            this.f198631m0.v(str, str2, jVar);
        }
    }

    public void u1(String str, String str2, int i3) {
        if (this.f198631m0 != null) {
            QLog.w("AREngine_ARScanEntryView", 1, "showTipsWithProgress, from[" + str + "], tips[" + str2 + "], progress[" + i3 + "], isVisible[" + this.f198631m0.m() + "]");
            this.f198631m0.x(str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void v(boolean z16) {
        QLog.d("AREngine_ARScanEntryView", 1, "doAfterProviderViewClose isPromotionPage =  " + e1() + "mHasReachEntryReady:" + this.U0);
        if (e1() || z16 || !this.U0) {
            A();
        }
    }

    public void w1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideImage show = " + z16);
        }
        if (R0(true) == null) {
            return;
        }
        this.f198618f1.g(z16);
    }

    public void x1(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, "showTransferDoorGuideText textIndex = " + i3);
        }
        if (R0(false) == null) {
            return;
        }
        this.f198618f1.h(i3);
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void z(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f198637p0 = new Handler(this);
        this.H0 = bundle;
        this.I0 = bundle.getLong("downloadItems", 14L);
        this.f198612c1 = this.H0.getBoolean("arTransferPromotion", false);
        this.Z0 = this.H0.getBoolean("enableARCloud", true);
        if (this.f198781h == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.ara, (ViewGroup) this, false);
            addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
            b1();
            Z0();
            this.f198781h = relativeLayout;
        }
        this.f198613d0 = ((IFeatureRuntimeService) this.f198778d.getRuntimeService(IFeatureRuntimeService.class, "tool")).isFeatureSwitchEnable("qrscan_tips_view_adjust");
        this.f198631m0 = new com.tencent.mobileqq.olympic.activity.a(this.f198780f, (RelativeLayout) this.f198781h, new j(), this.f198654x1);
        this.f198639q0 = ThreadManager.getSubThreadHandler();
        a1();
        CameraProxy.v().M(this);
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARScanEntryView", 2, String.format("onCreate time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        this.U0 = false;
        this.f198779e = true;
    }

    private void K0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements TencentMap.OnCameraChangeListener {
        f() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            if (ARScanEntryView.this.f198636o1 != null && QLog.isColorLevel()) {
                QLog.d("AREngine_ARScanEntryView", 2, "ARLBSPOIDialog onCameraChangeFinish");
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class j implements a.h {
        j() {
        }

        @Override // com.tencent.mobileqq.olympic.activity.a.h
        public void onVisibleChanged(boolean z16) {
        }
    }

    @Override // com.tencent.mobileqq.ar.arengine.v
    public void j(boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    @Override // com.tencent.mobileqq.ar.model.CameraProxy.a
    public void R5(int i3, int i16) {
    }
}
