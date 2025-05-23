package com.tencent.mobileqq.qrscan.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.qrscan.api.IQRScanMainProcService;
import com.tencent.mobileqq.qrscan.api.IScanCacheApi;
import com.tencent.mobileqq.qrscan.f;
import com.tencent.mobileqq.qrscan.g;
import com.tencent.mobileqq.qrscan.h;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qrscan.r;
import com.tencent.mobileqq.qrscan.t;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.qrreport.ITroopQRScanReportApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "\u626b\u4e00\u626b\u8bc6\u522b\u4e2d\u8f6c\u9875", path = "/qrscan/scanner")
/* loaded from: classes17.dex */
public class ScannerActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static final int MSG_SHOW_PROGRESS = 1;
    protected static final String TAG = "IQRScanConst_ScannerActivity";
    public static final String TOOL_PROCESS = "com.tencent.mobileqq:tool";
    public static boolean mFirstEnterAR;
    AppRuntime app;
    private boolean isFirstCreate;
    private long mClickTime;
    private t.a mFileDecodeListener;
    private k mHandleResultCallback;
    private boolean mHasARBack;
    private boolean mHasGetResult;
    public boolean mHasStartedAR;
    private QQProgressDialog mLoadingProgress;
    private ScannerMultiResultSelectView.c mMultiSelectListener;
    private com.tencent.mobileqq.qrscan.ipc.a mPreCallUpToolProc;
    private boolean mProgressShowing;
    private t mQrImageScan;
    private ScannerMultiResultSelectView mScannerMultiResultSelectView;
    public ScannerParams mScannerParams;
    private boolean mToolProcExist;
    private Handler.Callback mUiCallBack;
    private Handler mUiHandler;
    private String photoPathForMd5;
    private View progressBar;
    List<f> qrResultProcessors;
    private String qrScanGroupId;
    private long start_time;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qrscan.activity.ScannerActivity$4, reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f276593d;

        AnonymousClass4(long j3) {
            this.f276593d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ScannerActivity.this, Long.valueOf(j3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ScannerActivity.this.mToolProcExist = com.tencent.mobileqq.hitrate.d.e("com.tencent.mobileqq:tool");
            if (ScannerActivity.this.mUiHandler == null) {
                QLog.e(ScannerActivity.TAG, 1, "uiHandler is null, return.");
            } else {
                ScannerActivity.this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.activity.ScannerActivity.4.1
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.qrscan.activity.ScannerActivity$4$1$a */
                    /* loaded from: classes17.dex */
                    class a implements g.a {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.qrscan.g.a
                        public void a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            ScannerActivity.this.doLaunchAr(true);
                            QLog.i(ScannerActivity.TAG, 1, "launchAr time end: " + (System.currentTimeMillis() - AnonymousClass4.this.f276593d));
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (ScannerActivity.this.mPreCallUpToolProc == null) {
                            ScannerActivity scannerActivity = ScannerActivity.this;
                            scannerActivity.mPreCallUpToolProc = new com.tencent.mobileqq.qrscan.ipc.a(scannerActivity);
                        }
                        QLog.i(ScannerActivity.TAG, 1, "launchAr time pre: " + (System.currentTimeMillis() - AnonymousClass4.this.f276593d));
                        ScannerActivity.this.mPreCallUpToolProc.f("qr", 5000L, new a());
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements t.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qrscan.activity.ScannerActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class C8441a extends e {
            static IPatchRedirector $redirector_;

            C8441a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.qrscan.activity.ScannerActivity.e
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ScannerActivity.this.mHandleResultCallback.finish();
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.t.a
        public void a(ScannerResult scannerResult, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) scannerResult, i3);
            } else if (!ScannerActivity.this.isFinishing()) {
                ScannerActivity.this.handleScannerResult(scannerResult, i3);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.t.a
        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (ScannerActivity.this.isFinishing()) {
                return;
            }
            ScannerActivity.this.progressBar.setVisibility(8);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(ScannerActivity.this, 230);
            if (i3 == 2) {
                createCustomDialog.setMessage(R.string.f173082h60);
            } else {
                createCustomDialog.setMessage(R.string.h68);
            }
            C8441a c8441a = new C8441a();
            createCustomDialog.setPositiveButton(R.string.f171151ok, c8441a);
            createCustomDialog.setOnCancelListener(c8441a);
            createCustomDialog.show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements k {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void a(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                View view = ScannerActivity.this.progressBar;
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public JSONObject b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                try {
                    return ScannerActivity.this.buildQRReportParams();
                } catch (Throwable th5) {
                    QLog.i(ScannerActivity.TAG, 1, "getQRReportParams error: " + th5.getMessage());
                    return null;
                }
            }
            return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ScannerActivity.TAG, 2, "restartDecodeFrame");
            }
            ScannerActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void finish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ScannerActivity.TAG, 2, "onFinish");
            }
            ScannerActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return ScannerActivity.this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class c implements Handler.Callback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerActivity.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == 1) {
                ScannerActivity.this.showProgress();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements ScannerMultiResultSelectView.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
        public void a(QBarResult qBarResult, int i3, h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, qBarResult, Integer.valueOf(i3), hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ScannerActivity.TAG, 2, "onMultiSelectQr result:" + qBarResult + " " + i3);
            }
            ScannerActivity.this.handleScannerResult(1, qBarResult.f276507e, qBarResult.f276508f, i3);
        }

        @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ScannerActivity.TAG, 2, "onMultiCancel");
            }
            ScannerActivity.this.doOnBackPressed();
        }

        @Override // com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.c
        public void c(QMiniResult qMiniResult, int i3, h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, qMiniResult, Integer.valueOf(i3), hVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ScannerActivity.TAG, 2, "onMultiSelectMini result:" + qMiniResult + " " + i3);
            }
            ScannerActivity.this.handleScannerResult(2, qMiniResult.f276513h, qMiniResult.f276511e, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    protected static abstract class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        protected e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void a();

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                a();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialogInterface, i3);
            } else {
                a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            mFirstEnterAR = true;
        }
    }

    public ScannerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasGetResult = false;
        this.mHasStartedAR = false;
        this.mHasARBack = false;
        this.start_time = -1L;
        this.isFirstCreate = true;
        this.photoPathForMd5 = null;
        this.qrResultProcessors = new ArrayList();
        this.mFileDecodeListener = new a();
        this.mHandleResultCallback = new b();
        this.mUiCallBack = new c();
        this.mMultiSelectListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject buildQRReportParams() throws JSONException {
        Intent intent = getIntent();
        String str = this.photoPathForMd5;
        JSONObject jSONObject = null;
        if (intent == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (intent != null && intent.hasExtra("report_params")) {
            String stringExtra = intent.getStringExtra("report_params");
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject = new JSONObject(stringExtra);
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("type", 9);
            } else {
                jSONObject.put("type", 8);
            }
        }
        if (TextUtils.isEmpty(jSONObject.optString("md5")) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            String b16 = com.tencent.mobileqq.qrscan.utils.e.b(str);
            if (!TextUtils.isEmpty(b16)) {
                jSONObject.put("md5", b16.toUpperCase());
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "buildQRReportParams md5:" + b16 + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "buildQRReportParams params:" + jSONObject.toString());
        }
        return jSONObject;
    }

    private void clearCacheFile() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qrscan.activity.ScannerActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).clear();
                }
            }
        }, 64, null, false);
    }

    private void destroyQRScanResultProcessors() {
        Iterator<f> it = this.qrResultProcessors.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.qrResultProcessors.clear();
    }

    private void handleActivityResultDefault(int i3, int i16, Intent intent) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 10) {
                    if (this.mHasGetResult) {
                        finish();
                        return;
                    }
                    return;
                }
                this.mHasARBack = true;
                switch (i16) {
                    case 11:
                        finish();
                        return;
                    case 12:
                        finish();
                        overridePendingTransition(0, 0);
                        return;
                    case 13:
                        this.photoPathForMd5 = null;
                        if (intent.hasExtra("filePath")) {
                            this.photoPathForMd5 = intent.getStringExtra("filePath");
                        }
                        this.mScannerParams.f276517h = this.photoPathForMd5;
                        int intExtra = intent.getIntExtra("detectType", 1);
                        String stringExtra = intent.getStringExtra("scannerResult");
                        String stringExtra2 = intent.getStringExtra("scannerType");
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "doOnActivityResult  scannerResult:" + stringExtra + " scannerType\uff1a" + stringExtra2 + " photoPathForMd5:" + this.photoPathForMd5);
                        }
                        if (intExtra == 2) {
                            finish();
                            return;
                        } else {
                            handleScannerResult(intExtra, stringExtra2, stringExtra, 3);
                            return;
                        }
                    default:
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "doOnActivityResult default finish.");
                        }
                        finish();
                        return;
                }
            }
            return;
        }
        finish();
    }

    private void handleDecodeFile(String str, int i3) {
        if (this.mQrImageScan == null) {
            this.mQrImageScan = new t(this, this.mFileDecodeListener);
        }
        if (i3 == 0) {
            i3 = 3;
        }
        this.mScannerParams.f276517h = str;
        this.photoPathForMd5 = str;
        this.mQrImageScan.a(str, i3);
    }

    private boolean handlePreScanResult() {
        JSONObject jSONObject;
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handlePreResult detectType:" + this.mScannerParams.E + " preResult:" + this.mScannerParams.F + " preScanResult:" + this.mScannerParams.G);
        }
        ScannerResult scannerResult = this.mScannerParams.G;
        if (scannerResult != null && scannerResult.m()) {
            ScannerParams scannerParams = this.mScannerParams;
            handleScannerResult(scannerParams.G, scannerParams.E);
            return true;
        }
        if (!TextUtils.isEmpty(this.mScannerParams.F)) {
            try {
                jSONObject = new JSONObject(this.mScannerParams.F);
            } catch (Throwable th5) {
                th5.printStackTrace();
                jSONObject = null;
            }
            int i3 = this.mScannerParams.E;
            if (com.tencent.mobileqq.qrscan.utils.b.g(i3) && jSONObject != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (com.tencent.mobileqq.qrscan.utils.b.f(i3) && jSONObject != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16) {
                handleScannerResult(1, jSONObject.optString("scannerType"), jSONObject.optString("scannerResult"), i3);
                return true;
            }
            if (z17) {
                handleScannerResult(2, jSONObject.optString("type"), jSONObject.optString("strMini"), i3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScannerResult(ScannerResult scannerResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleScannerResult requestType:" + i3 + " scannerResult:" + scannerResult);
        }
        if (scannerResult == null) {
            return;
        }
        if (scannerResult.k()) {
            showMultiResultSelectPage(scannerResult, i3);
            return;
        }
        if (scannerResult.l()) {
            Pair<StringBuilder, StringBuilder> f16 = scannerResult.f();
            if (f16 != null) {
                handleScannerResult(1, ((StringBuilder) f16.second).toString(), ((StringBuilder) f16.first).toString(), i3);
                return;
            }
            return;
        }
        if (scannerResult.j()) {
            handleScannerResult(2, scannerResult.e(), scannerResult.c(), i3);
        }
    }

    private void initQRScanResultProcessors() {
        if (this.qrResultProcessors.isEmpty()) {
            this.qrResultProcessors.addAll(new com.tencent.mobileqq.qrscan.inject.a().a(this.app, this.mHandleResultCallback));
        }
    }

    private void initQrData() {
        JSONObject jSONObject;
        this.mScannerParams = new ScannerParams();
        Intent intent = getIntent();
        this.mScannerParams.f276515e = intent.getStringExtra("from");
        if ("addcontacts".equals(this.mScannerParams.f276515e)) {
            StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "addfriend_QR", 1);
        } else if ("ImagePreviewActivity".equals(this.mScannerParams.f276515e)) {
            StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bigpicture_QR", 1);
        } else if ("Conversation".equals(this.mScannerParams.f276515e)) {
            this.mScannerParams.f276519m = true;
            StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bulb_QR", 1);
        } else if (TextUtils.isEmpty(this.mScannerParams.f276515e)) {
            StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "find_QR", 1);
        } else if (IPublicAccountH5AbilityPlugin.PACKAGE_NAME.equals(this.mScannerParams.f276515e)) {
            intent.putExtra("scanForResult", true);
        } else if ("QRDisplayActivity".equals(this.mScannerParams.f276515e)) {
            this.mScannerParams.f276519m = true;
        }
        this.mScannerParams.f276518i = intent.getBooleanExtra("fromPicQRDecode", false);
        this.mScannerParams.E = intent.getIntExtra("detectType", 3);
        this.mScannerParams.F = intent.getStringExtra("preResult");
        this.mScannerParams.G = (ScannerResult) intent.getParcelableExtra("preScanResult");
        this.mScannerParams.C = super.getPackageManager().hasSystemFeature("android.hardware.camera");
        this.mScannerParams.f276516f = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        ScannerParams scannerParams = this.mScannerParams;
        scannerParams.f276517h = scannerParams.f276516f;
        scannerParams.f276514d = intent.getBooleanExtra("scanForResult", false);
        this.mScannerParams.H = (ScanPicData) intent.getParcelableExtra("o3_scan_pic_data");
        this.mScannerParams.D = 0;
        try {
            String stringExtra = intent.getStringExtra("report_params");
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject = new JSONObject(stringExtra);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null && jSONObject.has("type")) {
                this.mScannerParams.D = jSONObject.optInt("type", 0);
            } else if (TextUtils.isEmpty(this.photoPathForMd5)) {
                this.mScannerParams.D = 8;
            } else {
                this.mScannerParams.D = 9;
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse reportParams error : " + e16);
        }
        View findViewById = findViewById(R.id.f166824ih1);
        this.progressBar = findViewById;
        ViewCompat.setImportantForAccessibility(findViewById, 2);
        this.start_time = intent.getLongExtra("start_time", -1L);
        this.qrScanGroupId = intent.getStringExtra(AppConstants.Key.KEY_QR_SCAN_TROOP_ID);
        QLog.i(TAG, 1, "mScannerParams: " + this.mScannerParams.toString());
    }

    private void showMultiResultSelectPage(ScannerResult scannerResult, int i3) {
        if (this.mScannerMultiResultSelectView == null) {
            ScannerMultiResultSelectView scannerMultiResultSelectView = new ScannerMultiResultSelectView(this);
            this.mScannerMultiResultSelectView = scannerMultiResultSelectView;
            scannerMultiResultSelectView.setMultiSelectListener(this.mMultiSelectListener);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f79664_d);
        h hVar = new h();
        hVar.f276640d = this.mScannerParams.f276517h;
        this.mScannerMultiResultSelectView.B(relativeLayout, scannerResult, i3, hVar, 2, 4);
        com.tencent.mobileqq.qrscan.utils.e.a(this.app);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void doLaunchAr(boolean z16) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 2, String.format("doLaunchAr", new Object[0]));
        com.tencent.mobileqq.qrscan.ipc.a aVar = this.mPreCallUpToolProc;
        if (aVar != null) {
            aVar.d();
            this.mPreCallUpToolProc = null;
        }
        Intent intent = new Intent(this, (Class<?>) WebProcessReceiver.class);
        intent.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
        sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        try {
            jSONObject = buildQRReportParams();
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "getQRReportParams error: " + th5.getMessage());
            jSONObject = null;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("preload_process", false);
        IQRScanAbilityApi iQRScanAbilityApi = (IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class);
        AppRuntime appRuntime = this.app;
        ScannerParams scannerParams = this.mScannerParams;
        iQRScanAbilityApi.launchAR(this, appRuntime, scannerParams.f276515e, this.mClickTime, this.mToolProcExist, mFirstEnterAR, this.start_time, z16, booleanExtra, jSONObject, scannerParams);
        mFirstEnterAR = false;
        this.mHasStartedAR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        f fVar;
        boolean z16;
        boolean z17;
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnActivityResult requestCode:" + i3 + ", resultCode:" + i16);
        }
        hideProgress();
        Iterator<f> it = this.qrResultProcessors.iterator();
        while (true) {
            if (it.hasNext()) {
                fVar = it.next();
                if (fVar.c(i3, i16, intent)) {
                    z16 = fVar.b(i3, i16, intent);
                    z17 = true;
                    break;
                }
            } else {
                fVar = null;
                z16 = false;
                z17 = false;
                break;
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z17);
        if (fVar == null) {
            name = "null";
        } else {
            name = fVar.getName();
        }
        objArr[1] = name;
        objArr[2] = Boolean.valueOf(z16);
        QLog.d(TAG, 1, String.format("handleActivityResult intercepted=%b processor=%s handle=%b", objArr));
        if (!z17) {
            handleActivityResultDefault(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        IQRScanMainProcService iQRScanMainProcService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate");
        }
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.hcf);
        this.app = getAppRuntime();
        initQrData();
        initQRScanResultProcessors();
        this.mHasARBack = false;
        this.mHasGetResult = false;
        this.mUiHandler = new Handler(this.mUiCallBack);
        if (bundle != null) {
            z16 = bundle.getBoolean("hansSavedState", false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hansSavedState : " + z16);
            }
        } else {
            if (getIntent().getBooleanExtra("from_+", false)) {
                ReportController.o(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.mScannerParams.f276515e, "");
            }
            z16 = false;
        }
        clearCacheFile();
        if (TextUtils.isEmpty(this.mScannerParams.f276516f)) {
            if (enablePadCompat()) {
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.f224036hu), 0).show();
                finish();
                return true;
            }
            if (!z16) {
                launchAr();
            }
        }
        if (this.app.isLogin() && (iQRScanMainProcService = (IQRScanMainProcService) this.app.getRuntimeService(IQRScanMainProcService.class, "")) != null) {
            iQRScanMainProcService.onScannerCreate(getApplicationContext(), this.mScannerParams);
        }
        com.tencent.mobileqq.qrscan.utils.c.f276798a.a(getWindow());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IQRScanMainProcService iQRScanMainProcService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDestroy mHasARBack:" + this.mHasARBack + "  mHasStartedAR:" + this.mHasStartedAR);
        }
        if (!this.mHasStartedAR || this.mHasARBack) {
            if ("com.tencent.ark.scan".equals(this.mScannerParams.f276515e)) {
                Intent intent = new Intent("com.tencent.mobileqq.ark.api.scanResultAction");
                intent.putExtra("com.tencent.ark.scanResultData", "");
                intent.putExtra("com.tencent.ark.scanResultType", "");
                sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            }
            AppRuntime appRuntime = this.app;
            if (appRuntime != null && appRuntime.isLogin() && (iQRScanMainProcService = (IQRScanMainProcService) this.app.getRuntimeService(IQRScanMainProcService.class, "")) != null) {
                iQRScanMainProcService.onScannerDestroy();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "doOnDestroy in onScannerDestroy");
            }
        }
        t tVar = this.mQrImageScan;
        if (tVar != null) {
            tVar.b();
            this.mQrImageScan = null;
        }
        com.tencent.mobileqq.qrscan.ipc.a aVar = this.mPreCallUpToolProc;
        if (aVar != null) {
            aVar.d();
            this.mPreCallUpToolProc = null;
        }
        QQProgressDialog qQProgressDialog = this.mLoadingProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.mLoadingProgress = null;
        }
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mUiHandler = null;
        }
        destroyQRScanResultProcessors();
        super.doOnDestroy();
        com.tencent.mobileqq.qrscan.utils.b.c(this);
        this.app = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnNewIntent");
        }
        super.doOnNewIntent(intent);
        this.mScannerParams.f276516f = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onResume");
        }
        super.doOnResume();
        if (!TextUtils.isEmpty(this.mScannerParams.f276516f)) {
            ScannerParams scannerParams = this.mScannerParams;
            scannerParams.f276517h = scannerParams.f276516f;
            this.progressBar.setVisibility(0);
            if (!handlePreScanResult()) {
                ScannerParams scannerParams2 = this.mScannerParams;
                handleDecodeFile(scannerParams2.f276516f, scannerParams2.E);
            }
            this.mScannerParams.f276516f = null;
        }
        if (QLog.isColorLevel() && this.isFirstCreate && this.start_time > 0) {
            QLog.d(TAG, 2, Long.valueOf(System.currentTimeMillis() - this.start_time));
            this.isFirstCreate = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnSaveInstanceState");
        }
        bundle.putBoolean("hansSavedState", true);
        super.doOnSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnStop");
        }
        super.doOnStop();
        hideProgress();
    }

    public boolean enablePadCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (PadUtil.a(this) != DeviceType.TABLET) {
            return false;
        }
        if (!AppSetting.o(this)) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "isAllowLandscape == false");
            }
            return false;
        }
        if (getResources().getConfiguration().orientation != 2) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "Configuration.orientation != ORIENTATION_LANDSCAPE");
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "finish");
        }
        super.finish();
    }

    public void hideProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hideProgress  mProgressShowing:" + this.mProgressShowing);
        }
        try {
            Handler handler = this.mUiHandler;
            if (handler != null) {
                handler.removeMessages(1);
            }
            QQProgressDialog qQProgressDialog = this.mLoadingProgress;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.mLoadingProgress.dismiss();
            }
            this.mProgressShowing = false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hide init check progress:" + e16.getMessage());
            }
            e16.printStackTrace();
        }
    }

    public void launchAr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mClickTime = System.currentTimeMillis();
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mUiHandler.sendEmptyMessageDelayed(1, 1000L);
        }
        ThreadManagerV2.excute(new AnonymousClass4(currentTimeMillis), 16, null, true);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void showProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showProgress mProgressShowing:" + this.mProgressShowing);
        }
        if (this.mProgressShowing) {
            return;
        }
        try {
            if (this.mLoadingProgress == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
                this.mLoadingProgress = qQProgressDialog;
                qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.f21711605));
                this.mLoadingProgress.setBackAndSearchFilter(false);
            }
            this.mProgressShowing = true;
            this.mLoadingProgress.show();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "");
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startActivity  mHasGetResult:" + this.mHasGetResult);
        }
        super.startActivity(intent);
        if (this.mHasGetResult) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startActivityForResult requestCode:" + i3);
        }
        super.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startActivity2  mHasGetResult:" + this.mHasGetResult);
        }
        super.startActivity(intent, bundle);
        if (this.mHasGetResult) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScannerResult(int i3, String str, String str2, int i16) {
        f fVar;
        boolean z16;
        boolean z17;
        this.mHasGetResult = true;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "handleScannerResult scannerResult:" + str2 + "  scannerType:" + str + " resultType:" + i3 + " reqType:" + i16);
        }
        ((ITroopQRScanReportApi) QRoute.api(ITroopQRScanReportApi.class)).troopQRScanJumpTargetDTReport(this.qrScanGroupId, str2);
        String trim = str2.trim();
        if (this.mScannerParams.f276514d) {
            com.tencent.mobileqq.qrscan.utils.e.a(this.app);
            setResult(-1, getIntent().putExtra("scanResult", trim));
            finish();
            return;
        }
        int i17 = (i3 & 1) == 1 ? 1 : 2;
        Iterator<f> it = this.qrResultProcessors.iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                z16 = false;
                z17 = false;
                break;
            } else {
                fVar = it.next();
                if (fVar.a(i17, trim, str, this.mScannerParams)) {
                    z16 = fVar.d(trim, str, this.mScannerParams);
                    z17 = true;
                    break;
                }
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z17);
        objArr[1] = fVar == null ? "null" : fVar.getName();
        objArr[2] = Boolean.valueOf(z16);
        QLog.d(TAG, 1, String.format("handleScannerResult intercepted=%b processor=%s handle=%b", objArr));
        if (z17) {
            return;
        }
        r.b(this.app, this, trim);
        finish();
    }
}
