package com.tencent.mobileqq.qrscan.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.f;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qrscan.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class DispatchScanResultActivity extends QBaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    AppRuntime f276534a0;

    /* renamed from: b0, reason: collision with root package name */
    private ScannerParams f276535b0;

    /* renamed from: c0, reason: collision with root package name */
    private JSONObject f276536c0;

    /* renamed from: d0, reason: collision with root package name */
    List<f> f276537d0;

    /* renamed from: e0, reason: collision with root package name */
    private final k f276538e0;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements k {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DispatchScanResultActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                QLog.d("DispatchScanResultActivity", 1, "setProgressBarShow");
            }
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public JSONObject b() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getQRReportParams = ");
            if (DispatchScanResultActivity.this.f276536c0 != null) {
                str = DispatchScanResultActivity.this.f276536c0.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.d("DispatchScanResultActivity", 1, sb5.toString());
            return DispatchScanResultActivity.this.f276536c0;
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("DispatchScanResultActivity", 2, "restartDecodeFrame");
                DispatchScanResultActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public void finish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("DispatchScanResultActivity", 2, "onFinish");
                DispatchScanResultActivity.this.finish();
            }
        }

        @Override // com.tencent.mobileqq.qrscan.k
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return DispatchScanResultActivity.this;
        }
    }

    public DispatchScanResultActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276537d0 = new ArrayList();
            this.f276538e0 = new a();
        }
    }

    private void H2(int i3, String str, String str2) {
        boolean z16;
        int i16;
        f fVar;
        boolean z17;
        boolean z18;
        String name;
        QLog.i("DispatchScanResultActivity", 1, "doHandleScannerResult scannerResult:" + str2 + "  scannerType:" + str + " resultType:" + i3);
        String trim = str2.trim();
        if ((i3 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        Iterator<f> it = this.f276537d0.iterator();
        while (true) {
            if (it.hasNext()) {
                fVar = it.next();
                if (fVar.a(i16, trim, str, this.f276535b0)) {
                    z17 = fVar.d(trim, str, this.f276535b0);
                    z18 = true;
                    break;
                }
            } else {
                fVar = null;
                z17 = false;
                z18 = false;
                break;
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(z18);
        if (fVar == null) {
            name = "null";
        } else {
            name = fVar.getName();
        }
        objArr[1] = name;
        objArr[2] = Boolean.valueOf(z17);
        QLog.d("DispatchScanResultActivity", 1, String.format("doHandleScannerResult intercepted=%b processor=%s handle=%b", objArr));
        if (!z18) {
            r.b(this.f276534a0, this, trim);
            finish();
        }
    }

    private boolean I2(int i3, int i16, @Nullable Intent intent) {
        f fVar;
        boolean z16;
        boolean z17;
        String name;
        Iterator<f> it = this.f276537d0.iterator();
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
        QLog.d("DispatchScanResultActivity", 1, String.format("handleActivityResult intercepted=%b processor=%s handle=%b", objArr));
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(Intent intent) {
        String str;
        String str2;
        int intExtra = intent.getIntExtra("detectType", 1);
        String stringExtra = intent.getStringExtra("scannerType");
        String stringExtra2 = intent.getStringExtra("scannerResult");
        if (intent.hasExtra("filePath")) {
            str = intent.getStringExtra("filePath");
        } else {
            str = null;
        }
        ScannerParams scannerParams = (ScannerParams) intent.getParcelableExtra("scanner_param");
        this.f276535b0 = scannerParams;
        if (scannerParams == null) {
            QLog.d("DispatchScanResultActivity", 1, "ScannerParams is null, create a new Param");
            this.f276535b0 = new ScannerParams();
        }
        this.f276535b0.f276517h = str;
        String stringExtra3 = intent.getStringExtra("qr_report_param");
        if (stringExtra3 != null) {
            try {
                this.f276536c0 = new JSONObject(stringExtra3);
            } catch (JSONException e16) {
                QLog.e("DispatchScanResultActivity", 1, "get ReportParams error, e = " + e16);
            }
        }
        if ((intExtra & 2) == 2) {
            QLog.d("DispatchScanResultActivity", 1, "handleScanResult, is mini code.");
            finish();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleScanResult, ");
        sb5.append(this.f276535b0.toString());
        sb5.append(", getQRReportParams =  ");
        JSONObject jSONObject = this.f276536c0;
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QLog.d("DispatchScanResultActivity", 1, sb5.toString());
        H2(intExtra, stringExtra, stringExtra2);
    }

    private void destroyQRScanResultProcessors() {
        Iterator<f> it = this.f276537d0.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.f276537d0.clear();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (!I2(i3, i16, intent)) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        QLog.d("DispatchScanResultActivity", 1, "onCreate");
        this.f276534a0 = getAppRuntime();
        Intent intent = getIntent();
        initQRScanResultProcessors();
        ThreadManagerV2.executeDelay(new Runnable(intent) { // from class: com.tencent.mobileqq.qrscan.activity.DispatchScanResultActivity.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Intent f276539d;

            {
                this.f276539d = intent;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DispatchScanResultActivity.this, (Object) intent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DispatchScanResultActivity.this.J2(this.f276539d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, false, 200L);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("DispatchScanResultActivity", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.doOnDestroy();
        destroyQRScanResultProcessors();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("DispatchScanResultActivity", 1, "finishActivity.");
        if (isFinishing()) {
            QLog.d("DispatchScanResultActivity", 1, "activity is finishing.");
            return;
        }
        Intent intent = new Intent(IQRJumpApi.ACTION_FINISH_SCAN_TORCH_ACTIVITY);
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        sendBroadcast(intent);
        overridePendingTransition(0, 0);
        super.finish();
    }

    public void initQRScanResultProcessors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f276537d0.isEmpty()) {
            this.f276537d0.addAll(new com.tencent.mobileqq.qrscan.inject.a().a(this.f276534a0, this.f276538e0));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        QLog.d("DispatchScanResultActivity", 1, "startActivity");
        super.startActivity(intent);
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, i3);
            return;
        }
        QLog.d("DispatchScanResultActivity", 1, "startActivityForResult requestCode:" + i3);
        super.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent, (Object) bundle);
            return;
        }
        QLog.d("DispatchScanResultActivity", 1, "startActivity2");
        super.startActivity(intent, bundle);
        finish();
    }
}
