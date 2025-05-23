package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class SecurityPickproofActivity extends IphoneTitleBarActivity implements View.OnClickListener, HttpDownloadUtil.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public String f176992a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f176993b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f176994c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f176995d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f176996e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f176997f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f176998g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f176999h0;

    /* renamed from: i0, reason: collision with root package name */
    public Long f177000i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f177001j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f177002k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f177003l0;

    public SecurityPickproofActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176992a0 = "https://qqwx.qq.com/s?aid=index&g_f=436";
        this.f176993b0 = HardCodeUtil.qqStr(R.string.t8g);
        this.f176998g0 = false;
        this.f176999h0 = false;
        this.f177000i0 = 0L;
        this.f177001j0 = false;
        this.f177002k0 = false;
        this.f177003l0 = "";
    }

    private JSONObject M2() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSecurityPayOpen", com.tencent.mobileqq.utils.bj.f(this));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private void P2() {
        this.f176994c0.setText(R.string.hc5);
        this.f176997f0.setText(R.string.f173095hc2);
        this.f176996e0.setText(R.string.cw8);
    }

    private void initParams() {
        String stringExtra;
        if (getIntent().hasExtra("fromSecurityPay")) {
            this.f177002k0 = getIntent().getBooleanExtra("fromSecurityPay", false);
        }
        if (getIntent().hasExtra("options") && (stringExtra = getIntent().getStringExtra("options")) != null) {
            try {
                this.f177002k0 = new JSONObject(stringExtra).getBoolean("fromSecurityPay");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (this.f177002k0) {
            this.f176992a0 = "https://qqwx.qq.com/s?aid=index&g_f=442";
            ReportController.o(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.i("SecurityPickproofActivity", 2, "fromSecurityPay = " + this.f177002k0);
        }
    }

    private void initUI() {
        if (this.f177002k0) {
            setTitle(R.string.hc6);
        } else {
            setTitle(R.string.cw_);
        }
        Button button = (Button) findViewById(R.id.agu);
        this.f176994c0 = button;
        button.setOnClickListener(this);
        View findViewById = findViewById(R.id.bpp);
        this.f176995d0 = findViewById;
        findViewById.setVisibility(8);
        this.f176996e0 = (TextView) findViewById(R.id.kbq);
        this.f176997f0 = (TextView) findViewById(R.id.k8k);
    }

    protected IUniformDownloadMgr N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IUniformDownloadMgr) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        super.setContentView(R.layout.f169081by1);
        initParams();
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.f177001j0) {
            finish();
            return;
        }
        boolean d16 = com.tencent.mobileqq.utils.bj.d(this);
        this.f176998g0 = d16;
        if (this.f177002k0 && !d16) {
            this.f176992a0 = "https://qqwx.qq.com/s?aid=index&g_f=460";
        }
        this.f176999h0 = com.tencent.mobileqq.utils.bj.e(this);
        if (!this.f176998g0) {
            if (N2().isExistedDownloadOfUrl(this.f176992a0)) {
                this.f177001j0 = true;
                this.f176997f0.setText(R.string.hbj);
                this.f176994c0.setVisibility(8);
                this.f176996e0.setVisibility(8);
                this.f176995d0.setVisibility(0);
                return;
            }
            this.f176994c0.setVisibility(0);
            this.f176996e0.setVisibility(0);
            this.f176995d0.setVisibility(8);
            if (this.f177002k0) {
                this.f176997f0.setText(R.string.f173095hc2);
                this.f176994c0.setText(R.string.hod);
            } else {
                this.f176994c0.setText(R.string.f171173cw3);
            }
            this.f176996e0.setText(R.string.f171174cw4);
            return;
        }
        if (!com.tencent.mobileqq.utils.bj.c(this) && (!this.f177002k0 || com.tencent.mobileqq.utils.bj.a(this))) {
            if (this.f177002k0) {
                P2();
                return;
            } else {
                this.f176994c0.setText(R.string.cw7);
                this.f176996e0.setText(R.string.cw8);
                return;
            }
        }
        if (N2().isExistedDownloadOfUrl(this.f176992a0)) {
            this.f177001j0 = true;
            this.f176997f0.setText(R.string.hbj);
            this.f176994c0.setVisibility(8);
            this.f176996e0.setVisibility(8);
            this.f176995d0.setVisibility(0);
            return;
        }
        this.f176994c0.setVisibility(0);
        this.f176996e0.setVisibility(0);
        this.f176995d0.setVisibility(8);
        if (this.f177002k0) {
            if (com.tencent.mobileqq.utils.bj.b(this)) {
                P2();
                return;
            }
            this.f176997f0.setText(R.string.f173095hc2);
            this.f176994c0.setText(R.string.hc7);
            this.f176996e0.setText(R.string.f173094hc1);
            return;
        }
        this.f176994c0.setText(R.string.f171173cw3);
        this.f176996e0.setText(R.string.cw5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnStop();
        if (this.f177001j0) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f177002k0) {
            Intent intent = new Intent();
            intent.putExtra("result", M2().toString());
            setResult(-1, intent);
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view.getId() == R.id.agu) {
            this.f177003l0 = this.f176997f0.getText().toString();
            if (this.f176998g0 && !com.tencent.mobileqq.utils.bj.c(this) && (!this.f177002k0 || com.tencent.mobileqq.utils.bj.a(this))) {
                if (this.f177002k0) {
                    com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 11862017);
                    ReportController.o(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
                } else {
                    com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 9109505);
                    ReportController.o(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
                }
            } else if (this.f177002k0 && com.tencent.mobileqq.utils.bj.b(this)) {
                com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 11862017);
                ReportController.o(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
            } else {
                ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SecurityPickproofActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecurityPickproofActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            SecurityPickproofActivity securityPickproofActivity = SecurityPickproofActivity.this;
                            HttpDownloadUtil.queryDownloadInfo(securityPickproofActivity.f176992a0, securityPickproofActivity);
                        }
                    }
                });
                this.f177001j0 = true;
                this.f176997f0.setText(R.string.hbj);
                this.f176994c0.setVisibility(8);
                this.f176996e0.setVisibility(8);
                this.f176995d0.setVisibility(0);
                if (this.f177002k0) {
                    if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.f176992a0)) {
                        ReportController.o(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
                    } else if ("https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.f176992a0)) {
                        ReportController.o(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
                    }
                } else if (com.tencent.mobileqq.utils.bj.c(this)) {
                    ReportController.o(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.a
    public boolean onRespDownloadInfo(DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadInfo)).booleanValue();
        }
        if (downloadInfo.resultCode == 0) {
            this.f177000i0 = Long.valueOf(downloadInfo.respContentLength);
            if (NetworkUtil.isNetSupport(this) && this.f177000i0.longValue() > 0) {
                Bundle bundle = new Bundle();
                bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, this.f176993b0);
                bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, this.f177000i0.longValue());
                bundle.putString("big_brother_source_key", "biz_src_safe");
                bundle.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_safe");
                N2().startDownload(this.f176992a0, bundle);
                return true;
            }
        } else {
            this.f177000i0 = 0L;
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SecurityPickproofActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecurityPickproofActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SecurityPickproofActivity.this.f177001j0 = false;
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
                    SecurityPickproofActivity.this.f176997f0.setText(SecurityPickproofActivity.this.f177003l0);
                    SecurityPickproofActivity.this.f176996e0.setVisibility(0);
                    SecurityPickproofActivity.this.f176994c0.setVisibility(0);
                    SecurityPickproofActivity.this.f176995d0.setVisibility(8);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        return true;
    }
}
