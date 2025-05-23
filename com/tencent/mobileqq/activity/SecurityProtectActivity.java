package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class SecurityProtectActivity extends IphoneTitleBarActivity implements View.OnClickListener, HttpDownloadUtil.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f177004a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f177005b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f177006c0;

    /* renamed from: d0, reason: collision with root package name */
    private Button f177007d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f177008e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f177009f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f177010g0;

    /* renamed from: h0, reason: collision with root package name */
    String f177011h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f177012i0;

    /* renamed from: j0, reason: collision with root package name */
    public Long f177013j0;

    public SecurityProtectActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177004a0 = null;
        this.f177005b0 = null;
        this.f177006c0 = null;
        this.f177007d0 = null;
        this.f177008e0 = false;
        this.f177009f0 = false;
        this.f177010g0 = false;
        this.f177011h0 = "https://qqwx.qq.com/s?aid=index&g_f=407";
        this.f177012i0 = HardCodeUtil.qqStr(R.string.t8f);
        this.f177013j0 = 0L;
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
        super.setContentView(R.layout.f169082by2);
        setTitle(R.string.hbs);
        this.rightViewText.setVisibility(8);
        this.leftView.setText(R.string.hby);
        this.leftView.setOnClickListener(this);
        this.f177004a0 = (ImageView) findViewById(R.id.jsx);
        this.f177005b0 = (TextView) findViewById(R.id.czz);
        this.f177006c0 = (TextView) findViewById(R.id.ipj);
        Button button = (Button) findViewById(R.id.ug_btn);
        this.f177007d0 = button;
        button.setOnClickListener(this);
        this.f177007d0.setClickable(true);
        this.f177007d0.setFocusable(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.f177010g0) {
            finish();
            return;
        }
        this.f177008e0 = com.tencent.mobileqq.utils.bj.d(this);
        boolean e16 = com.tencent.mobileqq.utils.bj.e(this);
        this.f177009f0 = e16;
        if (!this.f177008e0) {
            this.f177004a0.setImageResource(R.drawable.sec_detect_low);
            this.f177005b0.setText(R.string.hbm);
            this.f177006c0.setVisibility(0);
            this.f177007d0.setText(R.string.hbg);
        } else if (!e16) {
            this.f177004a0.setImageResource(R.drawable.sec_detect_middle);
            this.f177005b0.setText(R.string.hbo);
            this.f177006c0.setVisibility(4);
            this.f177007d0.setText(R.string.hbh);
        } else {
            this.f177004a0.setImageResource(R.drawable.sec_detect_high);
            this.f177005b0.setText(R.string.hbi);
            this.f177006c0.setVisibility(4);
            this.f177007d0.setText(R.string.hbn);
        }
        if (this.f177009f0) {
            str = "qqpimsecure is running";
        } else if (this.f177008e0) {
            str = "qqpimsecure installed but not running";
        } else {
            str = "qqpimsecure not installed";
        }
        ReportController.o(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", str, 0, 0, "", "", "", "");
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
        if (this.f177010g0) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ug_btn) {
                if (!this.f177008e0) {
                    ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.activity.SecurityProtectActivity.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecurityProtectActivity.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                SecurityProtectActivity securityProtectActivity = SecurityProtectActivity.this;
                                HttpDownloadUtil.queryDownloadInfo(securityProtectActivity.f177011h0, securityProtectActivity);
                            }
                        }
                    });
                    this.f177010g0 = true;
                    this.f177005b0.setText(R.string.hbj);
                    this.f177006c0.setVisibility(4);
                    this.f177007d0.setVisibility(8);
                    ((LinearLayout) findViewById(R.id.bpp)).setVisibility(0);
                    ReportController.o(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn download qqpimsecure", 0, 0, "", "", "", "");
                } else if (!this.f177009f0) {
                    com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 7798785);
                    ReportController.o(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn weakup qqpimsecure", 0, 0, "", "", "", "");
                } else {
                    com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 8716289);
                    ReportController.o(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on bluebtn run_scan", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.ivTitleBtnLeft) {
                finish();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloadInfo)).booleanValue();
        }
        if (downloadInfo.resultCode == 0) {
            this.f177013j0 = Long.valueOf(downloadInfo.respContentLength);
            if (NetworkUtil.isNetSupport(getActivity()) && this.f177013j0.longValue() > 0) {
                Bundle bundle = new Bundle();
                bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, this.f177012i0);
                bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, this.f177013j0.longValue());
                bundle.putString("big_brother_source_key", "biz_src_safe");
                bundle.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_safe");
                ((IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(this.f177011h0, bundle);
                return true;
            }
        } else {
            this.f177013j0 = 0L;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.SecurityProtectActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SecurityProtectActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    SecurityProtectActivity.this.f177010g0 = false;
                    SecurityProtectActivity.this.f177005b0.setText(R.string.hbi);
                    SecurityProtectActivity.this.f177006c0.setVisibility(0);
                    SecurityProtectActivity.this.f177007d0.setVisibility(0);
                    ((LinearLayout) SecurityProtectActivity.this.findViewById(R.id.bpp)).setVisibility(8);
                    com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        return true;
    }
}
