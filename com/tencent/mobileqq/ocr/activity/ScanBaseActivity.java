package com.tencent.mobileqq.ocr.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.ARGlobalConfigManager;
import com.tencent.mobileqq.ar.ArNativeSoManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.h;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ScanBaseActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f254626a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f254627b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f254628c0;

    /* renamed from: d0, reason: collision with root package name */
    public OcrConfig f254629d0;

    /* renamed from: e0, reason: collision with root package name */
    public AppInterface f254630e0;

    /* renamed from: f0, reason: collision with root package name */
    public QQAppInterface f254631f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f254632g0;

    public ScanBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f254632g0 = false;
        }
    }

    private boolean F2() {
        ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList;
        if (this.f254629d0 == null) {
            this.f254629d0 = H2();
        }
        if (this.f254629d0 == null) {
            QLog.d("ScanBaseActivity", 1, "checkOcrEnable config is null");
            return false;
        }
        boolean isSupportOcr = ((IOCRService) this.f254630e0.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.f254630e0.getCurrentAccountUin(), 0);
        if (isSupportOcr) {
            boolean z16 = ARCloudControl.z();
            if (!z16) {
                QLog.d("ScanBaseActivity", 1, "checkOcrEnable load so failed!");
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ocr.activity.ScanBaseActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanBaseActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("param_FailCode", String.valueOf(-1003));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ocr_entrance", true, 0L, 0L, hashMap, "", false);
                    }
                }, 5, null, false);
            }
            return isSupportOcr & z16;
        }
        ARCommonConfigInfo f16 = ((ARGlobalConfigManager) this.f254630e0.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER)).f(true);
        if (f16 != null && (arrayList = f16.nativeSoResList) != null && arrayList.size() > 0) {
            new ArrayList();
            new ArrayList();
            ArrayList<ARCommonConfigInfo.NativeSoRes> arrayList2 = f16.nativeSoResList;
            ArNativeSoManager arNativeSoManager = new ArNativeSoManager(this.f254631f0);
            if (!h.c()) {
                arNativeSoManager.m(arrayList2, arrayList2, "arcloud");
                return isSupportOcr;
            }
            return isSupportOcr;
        }
        return isSupportOcr;
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public OcrConfig H2() {
        OcrConfig ocrConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (OcrConfig) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ocrConfig = (OcrConfig) extras.get("key_ocr_config");
        } else {
            ocrConfig = null;
        }
        if (ocrConfig == null) {
            AppInterface appInterface = this.f254630e0;
            if (appInterface instanceof QQAppInterface) {
                ocrConfig = ((IOCRService) appInterface.getRuntimeService(IOCRService.class, "")).getOCRConfig(false);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScanBaseActivity", 2, "getOcrConfig:" + ocrConfig);
        }
        return ocrConfig;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        boolean F2 = F2();
        if (QLog.isColorLevel()) {
            QLog.d("ScanBaseActivity", 2, "checkOcrEnable:" + F2);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnDestroy();
        QQProgressDialog qQProgressDialog = this.f254626a0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (ScanTorchActivity.TAG.equals(getClass().getSimpleName())) {
            return "module_olympic";
        }
        return super.getModuleId();
    }

    public void initTitleView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f254627b0 = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f254628c0 = (TextView) findViewById(R.id.ivTitleName);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this);
            View findViewById = findViewById(R.id.jo6);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            findViewById.setLayoutParams(layoutParams);
        }
        if (AppSetting.f99565y) {
            findViewById(R.id.ivTitleBtnLeft).setContentDescription(HardCodeUtil.qqStr(R.string.t3e));
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity
    public void updateAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.f254631f0 = qQAppInterface;
        this.f254630e0 = qQAppInterface;
    }
}
