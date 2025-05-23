package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.ae.p;
import com.tencent.aelight.camera.ae.q;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IAIOShortVideoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import dov.com.qq.im.ae.current.SessionWrap;
import mqq.util.WeakReference;
import yq.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCameraCaptureActivity extends BaseActivity2 implements or.e, or.d {
    private static SparseIntArray Y = new SparseIntArray();
    private q N;
    private int P;
    private boolean Q;
    private View R;
    private QQPermission W;
    private int S = 0;
    private int T = 0;
    private boolean U = false;
    private boolean V = false;
    private yq.d X = new yq.d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements d.a {
        a() {
        }

        @Override // yq.d.a
        public void doOnResume() {
            QIMCameraCaptureActivity.this.x0();
        }

        @Override // yq.d.a
        public Handler getMainHandler() {
            return ThreadManagerV2.getUIHandlerV2();
        }

        @Override // yq.d.a
        public boolean isResumed() {
            return QIMCameraCaptureActivity.this.isResume();
        }
    }

    private void A0() {
        this.X.k(new a());
    }

    private boolean B0() {
        if (!gq.a.r(getIntent()) && gq.a.a(getIntent()) != js.a.L.b() && gq.a.a(getIntent()) != js.a.f410904d.b()) {
            if (Y.indexOfKey(this.P) >= 0) {
                int i3 = Y.get(this.P) + 1;
                Y.put(this.P, i3);
                ms.a.a("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.P + " value: " + i3);
                return true;
            }
            Y.put(this.P, 1);
            ms.a.a("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.P + " value: 1");
        }
        return false;
    }

    public static void C0(Context context, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, currentTimeMillis);
        bundle.putLong("intent_key_launch_begin_time", currentTimeMillis);
        context.startActivity(y0(context, bundle));
    }

    public static void D0(Activity activity, Bundle bundle, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.tencent.aelight.camera.aioeditor.a.f66321a != 0) {
            com.tencent.aelight.camera.aioeditor.a.f66323c = currentTimeMillis;
            QLog.e(IAIOShortVideoUtil.MONITOR_EVENT_TAG, 1, "TIMESTAMP_START_ACTIVITY ", Long.valueOf(currentTimeMillis));
            bundle.putLong("TIMESTAMP_PRELOAD_PEAK", com.tencent.aelight.camera.aioeditor.a.f66321a);
            bundle.putLong("TIMESTAMP_CLICK_CAMERA", com.tencent.aelight.camera.aioeditor.a.f66322b);
            bundle.putLong("TIMESTAMP_START_ACTIVITY", com.tencent.aelight.camera.aioeditor.a.f66323c);
        }
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, currentTimeMillis);
        bundle.putLong("intent_key_launch_begin_time", currentTimeMillis);
        Intent y06 = y0(activity, bundle);
        if (gq.c.k(bundle)) {
            y06.addFlags(603979776);
        }
        activity.startActivityForResult(y06, i3);
        tq.b.h().o(IAELaunchRecorder.MILESTONE_START_ACTIVITY);
    }

    private void E0() {
        if (gq.a.r(getIntent())) {
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(this, QCircleDaTongConstant.PageId.BASE);
            VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("QIMCameraCaptureActivity"));
            QLog.i("QIMCameraCaptureActivity", 1, "reportDaTongRegister  subPage: QIMCameraCaptureActivity");
        }
    }

    private void w0() {
        if (this.Q) {
            return;
        }
        this.Q = true;
        if (Y.indexOfKey(this.P) >= 0) {
            int i3 = Y.get(this.P);
            ms.a.a("QIMCameraCaptureActivity", "decreaseFrom key: " + this.P + " value: " + i3);
            if (i3 <= 1) {
                Y.delete(this.P);
                return;
            } else {
                Y.put(this.P, i3 - 1);
                return;
            }
        }
        ms.a.a("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.P);
        Y.delete(this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        ms.a.f("QIMCameraCaptureActivity", "[onResume] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.U) {
            tq.b.h().o("activityOnResumeBegin");
        }
        super.onResume();
        if (Build.VERSION.SDK_INT >= 29 && !gq.a.q(this.P) && !gq.a.v(getIntent())) {
            com.tencent.biz.subscribe.utils.g.c(getWindow());
        }
        this.N.onActivityResume();
        ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).o(0);
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 51);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, false);
        if (!this.U) {
            tq.b.h().o("activityOnResumeEnd");
        }
        this.U = true;
        ms.a.f("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static Intent y0(Context context, Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
        }
        Intent intent = new Intent(context, (Class<?>) QIMCameraCaptureActivity.class);
        int i3 = bundle.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        if (!js.a.f410915o.d(i3) && !js.a.f410914n.d(i3)) {
            if (js.a.K.d(i3) || js.a.L.d(i3)) {
                ms.a.a("QIMCameraCaptureActivity", "set special launch flags case2");
                intent.setFlags(402653184);
            }
        } else {
            ms.a.a("QIMCameraCaptureActivity", "set special launch flags case1");
            intent.setFlags(402653184);
        }
        intent.putExtras(bundle);
        intent.putExtra(AECameraConstants.PARAMS_NEED_SHOW_BANNER, false);
        return intent;
    }

    @Override // or.e
    public void Q() {
        super.onBackPressed();
    }

    @Override // or.e
    public WeakReference<Activity> R() {
        return new WeakReference<>(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        q qVar = this.N;
        if (qVar != null) {
            qVar.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity
    public boolean isLatecyWaitRuntime() {
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.N.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, android.app.Activity
    public void onBackPressed() {
        this.N.onBackPressed();
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 51);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (p.e()) {
            DisplayMetrics c16 = com.tencent.aelight.camera.ae.flashshow.util.g.c(this);
            if (c16 != null) {
                int i3 = this.S;
                int i16 = c16.widthPixels;
                if (i3 != i16 || this.T != c16.heightPixels) {
                    this.S = i16;
                    int i17 = c16.heightPixels;
                    this.T = i17;
                    this.N.n(i16, i17);
                }
            }
            if (c16 != null && QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + c16.widthPixels + ", hight:" + c16.heightPixels);
            }
        }
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ms.a.f("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
        setVolumeControlStream(3);
        if (!isLatecyWaitRuntime()) {
            com.tencent.aelight.camera.aebase.a.a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = getActivity().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
        ms.a.a("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (currentTimeMillis - longExtra));
        this.P = gq.a.a(getIntent());
        tq.b.h().a();
        tq.b.h().p("mainProcessLaunch", longExtra);
        tq.b.h().p("activityOnCreateBegin", currentTimeMillis);
        tq.b.h().q(longExtra);
        com.tencent.aelight.camera.aioeditor.capture.control.a.f66678b = false;
        super.getWindow().addFlags(256);
        super.getWindow().addFlags(512);
        super.getWindow().addFlags(128);
        if (p.e()) {
            LiuHaiUtils.resetFullScreen(this);
        }
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
        DisplayMetrics c16 = com.tencent.aelight.camera.ae.flashshow.util.g.c(this);
        if (c16 != null) {
            this.S = c16.widthPixels;
            this.T = c16.heightPixels;
        }
        this.F = true;
        this.G = false;
        super.onCreate(bundle);
        if (B0()) {
            ms.a.c("QIMCameraCaptureActivity", "repeat launch from: " + this.P);
            finish();
            return;
        }
        getActivity().sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_OPEN_CAMERA), "com.tencent.msg.permission.pushnotify");
        Parcelable parcelableExtra = getIntent().getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
        if (parcelableExtra instanceof SessionWrap) {
            SessionWrap sessionWrap = (SessionWrap) parcelableExtra;
            ms.a.f("QIMCameraCaptureActivity", "onCreate: friendUin\uff1a" + StringUtil.getSimpleUinForPrint(sessionWrap.f394447d) + ", troopUin=" + StringUtil.getSimpleUinForPrint(sessionWrap.f394450h));
        }
        final int intExtra = getIntent().getIntExtra("edit_video_type", 10002);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(AECameraConstants.VIDEO_STORY_FROM_TYPE) && gq.a.f(getIntent().getExtras().getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE))) {
            intExtra = 10024;
        }
        long longExtra2 = getIntent().getLongExtra("downloadSDKSourceTime", -1L);
        if (longExtra2 > 0) {
            tq.b.h().p("downloadSDKSourceTime", longExtra2);
        }
        tq.b h16 = tq.b.h();
        if (longExtra2 > 0) {
            longExtra = longExtra2;
        }
        h16.u(longExtra, longExtra2 > 0);
        tq.b.h().o("buildCaptureUnit-begin");
        com.tencent.aelight.camera.ae.util.i.c();
        this.N = g.a(intExtra, this, this);
        tq.b.h().o("buildCaptureUnit-end");
        this.N.onCreate(bundle);
        tq.b.h().o("unitOnCreateView-begin");
        this.R = this.N.q(null);
        tq.b.h().o("unitOnCreateView-end");
        setContentView(this.R);
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.qcb), 0).show();
            finish();
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity.1
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "enter_story_capture_count", true, 0L, 0L, null, "");
                id0.a.n("video_shoot_new", "shoot_exp", id0.a.e(intExtra), 0, "", "", "", String.valueOf(QIMCameraCaptureActivity.this.getIntent().getIntExtra("entrance_type", 0)));
                com.tencent.aelight.camera.ae.report.b.b().O0(!TextUtils.isEmpty(QIMCameraCaptureActivity.this.getIntent().getStringExtra("KEY_ISENTER_SO_DOWNLOAD")));
            }
        }, 16, null, true);
        E0();
        tq.b.h().o("activityOnCreateEnd");
        A0();
        ms.a.f("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.X.d();
        ms.a.a("QIMCameraCaptureActivity", "onDestroy from: " + this.P);
        w0();
        q qVar = this.N;
        if (qVar != null) {
            qVar.onDestroy();
            QIMPtvTemplateManager.R = 0;
            ((com.tencent.aelight.camera.aioeditor.d) fr.f.c(13)).f(0);
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 51);
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
        }
        tq.b.h().s(true);
        tq.b.h().e();
        getActivity().sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_CLOSE_CAMERA), "com.tencent.msg.permission.pushnotify");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return this.N.m(i3, keyEvent, super.onKeyDown(i3, keyEvent));
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getIntent().putExtras(intent);
        this.N.onNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.X.e();
        q qVar = this.N;
        if (qVar != null) {
            qVar.onActivityPause();
        }
        ms.a.a("QIMCameraCaptureActivity", "onPause from: " + this.P);
        if (getActivity().isFinishing()) {
            w0();
        }
    }

    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        QQPermission qQPermission = this.W;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(i3, strArr, iArr);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.X.f();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.N.onSaveInstanceState(bundle);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        ms.a.f("QIMCameraCaptureActivity", "[onStart] + BEGIN");
        if (!this.V) {
            tq.b.h().o("activityOnStartBegin");
        }
        long currentTimeMillis = System.currentTimeMillis();
        waitAppRuntime();
        ms.a.a("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        super.onStart();
        this.N.onActivityStart();
        if (!this.V) {
            tq.b.h().o("activityOnStartEnd");
        }
        this.V = true;
        ms.a.f("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.X.h();
        ms.a.a("QIMCameraCaptureActivity", "onStop from: " + this.P);
        q qVar = this.N;
        if (qVar != null) {
            qVar.onActivityStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.N.onTouchEvent(motionEvent, super.onTouchEvent(motionEvent));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        this.X.i(z16);
        this.N.onWindowFocusChanged(z16);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    protected boolean q0() {
        return false;
    }

    public QQPermission z0() {
        if (this.W == null) {
            this.W = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_CAMERA, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_CAMERA));
        }
        return this.W;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider, or.e
    public Activity getActivity() {
        return this;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2
    public void initNavigationBarColor() {
    }
}
