package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQSettingCleanActivity extends IphoneTitleBarActivity implements View.OnClickListener, HttpDownloadUtil.a, com.tencent.mobileqq.uniformdownload.util.d {
    static IPatchRedirector $redirector_;
    public static final ArrayList<String> A0;

    /* renamed from: y0, reason: collision with root package name */
    public static final String[] f176880y0;

    /* renamed from: z0, reason: collision with root package name */
    public static final String f176881z0;

    /* renamed from: a0, reason: collision with root package name */
    public QQProgressDialog f176882a0;

    /* renamed from: b0, reason: collision with root package name */
    public Button f176883b0;

    /* renamed from: c0, reason: collision with root package name */
    public Button f176884c0;

    /* renamed from: d0, reason: collision with root package name */
    public View f176885d0;

    /* renamed from: e0, reason: collision with root package name */
    public View f176886e0;

    /* renamed from: f0, reason: collision with root package name */
    public View f176887f0;

    /* renamed from: g0, reason: collision with root package name */
    public View f176888g0;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f176889h0;

    /* renamed from: i0, reason: collision with root package name */
    public CircleProgressBar f176890i0;

    /* renamed from: j0, reason: collision with root package name */
    public TextView f176891j0;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f176892k0;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f176893l0;

    /* renamed from: m0, reason: collision with root package name */
    public TextView f176894m0;

    /* renamed from: n0, reason: collision with root package name */
    public LinearLayout f176895n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f176896o0;

    /* renamed from: p0, reason: collision with root package name */
    public ProgressBar f176897p0;

    /* renamed from: q0, reason: collision with root package name */
    public long f176898q0;

    /* renamed from: r0, reason: collision with root package name */
    public long f176899r0;

    /* renamed from: s0, reason: collision with root package name */
    public long f176900s0;

    /* renamed from: t0, reason: collision with root package name */
    public long f176901t0;

    /* renamed from: u0, reason: collision with root package name */
    public long f176902u0;

    /* renamed from: v0, reason: collision with root package name */
    public long f176903v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f176904w0;

    /* renamed from: x0, reason: collision with root package name */
    public b f176905x0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class GetApkSizeTask implements Runnable {
        static IPatchRedirector $redirector_;

        GetApkSizeTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                HttpResponse execute = new DefaultHttpClient().execute(new HttpGet("https://qqwx.qq.com/s?aid=index&p=5&c=102120&vt=2&pf=0"));
                if (execute.getStatusLine().getStatusCode() == 200) {
                    String entityUtils = EntityUtils.toString(execute.getEntity());
                    if (!TextUtils.isEmpty(entityUtils)) {
                        long j3 = new JSONObject(entityUtils.substring(6, entityUtils.length() - 2)).getLong("size");
                        if (j3 > 0) {
                            QQSettingCleanActivity qQSettingCleanActivity = QQSettingCleanActivity.this;
                            qQSettingCleanActivity.f176898q0 = j3;
                            qQSettingCleanActivity.runOnUiThread(new ShowTask(0));
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ScanSpaceTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements com.tencent.mobileqq.app.message.filescan.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanSpaceTask.this);
                }
            }

            @Override // com.tencent.mobileqq.app.message.filescan.c
            public void a(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                } else {
                    QQSettingCleanActivity.this.f176890i0.setPercent(i3);
                }
            }
        }

        ScanSpaceTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long totalInternalMemorySize = SdCardUtil.getTotalInternalMemorySize();
            long totalExternalMemorySize = SdCardUtil.getTotalExternalMemorySize(QQSettingCleanActivity.this);
            long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
            long availableExternalMemorySize = SdCardUtil.getAvailableExternalMemorySize(QQSettingCleanActivity.this);
            QQSettingCleanActivity qQSettingCleanActivity = QQSettingCleanActivity.this;
            qQSettingCleanActivity.f176899r0 = totalInternalMemorySize + totalExternalMemorySize;
            qQSettingCleanActivity.f176902u0 = availableInternalMemorySize + availableExternalMemorySize;
            a aVar = new a();
            QQSettingCleanActivity.this.f176900s0 = StorageReport.k().o(aVar, 0, 98);
            QQSettingCleanActivity.this.f176901t0 = StorageReport.k().e(QQSettingCleanActivity.A0);
            QQSettingCleanActivity qQSettingCleanActivity2 = QQSettingCleanActivity.this;
            qQSettingCleanActivity2.f176900s0 -= qQSettingCleanActivity2.f176901t0;
            aVar.a(100);
            QLog.d("QQCleanActivity", 1, "SpaceInfo total: " + QQSettingCleanActivity.this.f176899r0 + " ava: " + QQSettingCleanActivity.this.f176902u0 + " qq: " + QQSettingCleanActivity.this.f176900s0 + " file: " + QQSettingCleanActivity.this.f176901t0);
            QLog.d("QQCleanActivity", 1, "SpaceInfo totalIner: " + totalInternalMemorySize + " totalExter: " + totalExternalMemorySize + " avaInter: " + availableInternalMemorySize + " avaExter: " + availableExternalMemorySize);
            QQSettingCleanActivity qQSettingCleanActivity3 = QQSettingCleanActivity.this;
            CircleProgressBar circleProgressBar = qQSettingCleanActivity3.f176890i0;
            long j3 = qQSettingCleanActivity3.f176900s0;
            long j16 = qQSettingCleanActivity3.f176901t0;
            long j17 = (qQSettingCleanActivity3.f176899r0 - j3) - j16;
            long j18 = qQSettingCleanActivity3.f176902u0;
            circleProgressBar.setFinish(j3, j16, j17 - j18, j18, 3.0f);
            QQSettingCleanActivity qQSettingCleanActivity4 = QQSettingCleanActivity.this;
            qQSettingCleanActivity4.runOnUiThread(new ShowTask(5));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class ShowTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f176909d;

        public ShowTask(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this, i3);
            } else {
                this.f176909d = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String H2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i3 = this.f176909d;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    QQSettingCleanActivity qQSettingCleanActivity = QQSettingCleanActivity.this;
                                    TextView textView = qQSettingCleanActivity.f176891j0;
                                    long j3 = qQSettingCleanActivity.f176900s0;
                                    String str = "0M";
                                    if (j3 > 0) {
                                        H2 = qQSettingCleanActivity.H2(j3);
                                    } else {
                                        H2 = "0M";
                                    }
                                    textView.setText(H2);
                                    QQSettingCleanActivity qQSettingCleanActivity2 = QQSettingCleanActivity.this;
                                    TextView textView2 = qQSettingCleanActivity2.f176892k0;
                                    long j16 = qQSettingCleanActivity2.f176901t0;
                                    if (j16 > 0) {
                                        str = qQSettingCleanActivity2.H2(j16);
                                    }
                                    textView2.setText(str);
                                    QQSettingCleanActivity qQSettingCleanActivity3 = QQSettingCleanActivity.this;
                                    qQSettingCleanActivity3.f176893l0.setText(qQSettingCleanActivity3.H2((qQSettingCleanActivity3.f176899r0 - qQSettingCleanActivity3.f176900s0) - qQSettingCleanActivity3.f176902u0));
                                    QQSettingCleanActivity qQSettingCleanActivity4 = QQSettingCleanActivity.this;
                                    qQSettingCleanActivity4.f176894m0.setText(qQSettingCleanActivity4.H2(qQSettingCleanActivity4.f176902u0));
                                    QQSettingCleanActivity.this.f176895n0.setVisibility(0);
                                    QQSettingCleanActivity.this.f176883b0.setEnabled(true);
                                    QQSettingCleanActivity.this.f176884c0.setEnabled(true);
                                    QQSettingCleanActivity.this.f176884c0.setBackgroundResource(R.drawable.common_btn_blue);
                                    QQSettingCleanActivity qQSettingCleanActivity5 = QQSettingCleanActivity.this;
                                    qQSettingCleanActivity5.f176884c0.setTextColor(qQSettingCleanActivity5.getResources().getColor(R.color.skin_color_button_blue));
                                    return;
                                }
                                return;
                            }
                            QQSettingCleanActivity.this.f176897p0.setVisibility(8);
                            QQSettingCleanActivity.this.f176884c0.setEnabled(true);
                            QQSettingCleanActivity qQSettingCleanActivity6 = QQSettingCleanActivity.this;
                            qQSettingCleanActivity6.f176884c0.setText(qQSettingCleanActivity6.getString(R.string.ho9));
                            return;
                        }
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
                        return;
                    }
                    QQSettingCleanActivity.this.f176897p0.setVisibility(0);
                    QQSettingCleanActivity.this.f176884c0.setEnabled(false);
                    QQSettingCleanActivity qQSettingCleanActivity7 = QQSettingCleanActivity.this;
                    qQSettingCleanActivity7.f176884c0.setText(qQSettingCleanActivity7.getString(R.string.ho_));
                    return;
                }
                TextView textView3 = QQSettingCleanActivity.this.f176896o0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(QQSettingCleanActivity.this.getString(R.string.hoi));
                QQSettingCleanActivity qQSettingCleanActivity8 = QQSettingCleanActivity.this;
                sb5.append(qQSettingCleanActivity8.H2(qQSettingCleanActivity8.f176900s0 - qQSettingCleanActivity8.f176903v0));
                textView3.setText(sb5.toString());
                QQSettingCleanActivity.this.f176896o0.setVisibility(0);
                return;
            }
            TextView textView4 = QQSettingCleanActivity.this.f176889h0;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(QQSettingCleanActivity.this.getString(R.string.hoe));
            sb6.append("(");
            QQSettingCleanActivity qQSettingCleanActivity9 = QQSettingCleanActivity.this;
            sb6.append(qQSettingCleanActivity9.H2(qQSettingCleanActivity9.f176898q0));
            sb6.append(")");
            textView4.setText(sb6.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                QQAppInterface qQAppInterface = QQSettingCleanActivity.this.app;
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007915", "0X8007915", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            QQProgressDialog qQProgressDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1 && (qQProgressDialog = QQSettingCleanActivity.this.f176882a0) != null && qQProgressDialog.isShowing()) {
                    QQSettingCleanActivity.this.f176882a0.cancel();
                    QQSettingCleanActivity qQSettingCleanActivity = QQSettingCleanActivity.this;
                    qQSettingCleanActivity.f176882a0.setMessage(qQSettingCleanActivity.getString(R.string.a3f));
                    QQSettingCleanActivity.this.f176882a0.setBackAndSearchFilter(true);
                    QQSettingCleanActivity.this.f176882a0.showTipImageView(false);
                    QQSettingCleanActivity.this.f176882a0.showProgerss(true);
                    return;
                }
                return;
            }
            if (!QQSettingCleanActivity.this.isFinishing()) {
                QQSettingCleanActivity qQSettingCleanActivity2 = QQSettingCleanActivity.this;
                qQSettingCleanActivity2.f176882a0.setMessage(qQSettingCleanActivity2.getString(R.string.a3d));
                QQSettingCleanActivity.this.f176882a0.setTipImageView(R.drawable.setting_icons_correct);
                QQSettingCleanActivity.this.f176882a0.showProgerss(false);
            }
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f176880y0 = new String[]{"sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business"};
        f176881z0 = HardCodeUtil.qqStr(R.string.r38);
        A0 = new ArrayList<>(2);
    }

    public QQSettingCleanActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176898q0 = 0L;
        this.f176899r0 = 0L;
        this.f176900s0 = 0L;
        this.f176901t0 = 0L;
        this.f176902u0 = 0L;
        this.f176903v0 = 0L;
        this.f176904w0 = false;
        this.f176905x0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H2(long j3) {
        if (j3 <= 0) {
            return null;
        }
        if (j3 < 1024) {
            return j3 + "B";
        }
        if (j3 < 1048576) {
            return String.format("%.1f", Float.valueOf(((float) j3) / 1024.0f)) + "K";
        }
        if (j3 < 1073741824) {
            return String.format("%.1f", Float.valueOf((((float) j3) / 1024.0f) / 1024.0f)) + "M";
        }
        return String.format("%.1f", Float.valueOf(((((float) j3) / 1024.0f) / 1024.0f) / 1024.0f)) + "G";
    }

    public static void K2(Context context) {
        Intent intent = new Intent(context, (Class<?>) QQSettingMsgHistoryActivity.class);
        intent.putExtra("set_display_type", 1);
        context.startActivity(intent);
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.f176890i0.b();
        this.f176890i0.setPercent(0);
        StorageReport.p().post(new ScanSpaceTask());
    }

    protected IUniformDownloadMgr J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IUniformDownloadMgr) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void R0(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) bundle);
        } else {
            runOnUiThread(new ShowTask(4));
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void a(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void c(int i3, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), str, bundle);
        } else {
            this.f176904w0 = false;
            runOnUiThread(new ShowTask(4));
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void c2(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) bundle);
        }
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
        setContentView(R.layout.f168867b24);
        setTitle(getString(R.string.fs7));
        this.f176883b0 = (Button) findViewById(R.id.ay9);
        this.f176884c0 = (Button) findViewById(R.id.ay8);
        this.f176883b0.setOnClickListener(this);
        this.f176884c0.setOnClickListener(this);
        this.f176885d0 = findViewById(R.id.gmq);
        this.f176886e0 = findViewById(R.id.gml);
        this.f176887f0 = findViewById(R.id.ffs);
        this.f176888g0 = findViewById(R.id.a2m);
        ((GradientDrawable) this.f176885d0.getBackground()).setColor(Color.parseColor("#00d1a4"));
        ((GradientDrawable) this.f176886e0.getBackground()).setColor(Color.parseColor("#fea356"));
        ((GradientDrawable) this.f176887f0.getBackground()).setColor(Color.parseColor("#529eff"));
        ((GradientDrawable) this.f176888g0.getBackground()).setColor(Color.parseColor("#e6e6e7"));
        this.f176889h0 = (TextView) findViewById(R.id.gqa);
        this.f176890i0 = (CircleProgressBar) findViewById(R.id.f166825ih3);
        this.f176891j0 = (TextView) findViewById(R.id.gmp);
        this.f176892k0 = (TextView) findViewById(R.id.gmm);
        this.f176893l0 = (TextView) findViewById(R.id.ffr);
        this.f176894m0 = (TextView) findViewById(R.id.a2l);
        this.f176895n0 = (LinearLayout) findViewById(R.id.izb);
        this.f176896o0 = (TextView) findViewById(R.id.ay_);
        this.f176897p0 = (ProgressBar) findViewById(R.id.bpp);
        StorageReport.k().A(false);
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        String otherRecvPath = lc1.b.a().getOtherRecvPath();
        ArrayList<String> arrayList = A0;
        arrayList.clear();
        if (!TextUtils.isEmpty(defaultRecvPath)) {
            arrayList.add(defaultRecvPath);
            QLog.d("QQCleanActivity", 2, " need scan file path1 = " + defaultRecvPath);
        }
        if (!TextUtils.isEmpty(otherRecvPath)) {
            arrayList.add(otherRecvPath);
            QLog.d("QQCleanActivity", 2, " need scan file path2 = " + otherRecvPath);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQCleanActivity", 2, " need scan file path1 = " + defaultRecvPath + " path2 = " + otherRecvPath);
        }
        I2();
        ThreadManagerV2.executeOnNetWorkThread(new GetApkSizeTask());
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
        QQProgressDialog qQProgressDialog = this.f176882a0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            dismissDialog(1);
        }
        J2().removeOuterListenner("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
        StorageReport.s();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (StorageReport.k().n()) {
            StorageReport.k().A(false);
            I2();
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void g0(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.d
    public void h(String str, long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Long.valueOf(j3), bundle);
            return;
        }
        this.f176904w0 = false;
        runOnUiThread(new ShowTask(4));
        QQAppInterface qQAppInterface = this.app;
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ay9) {
                QQAppInterface qQAppInterface = this.app;
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, qQAppInterface.getCurrentAccountUin(), "", "", "");
                Intent intent = new Intent(getActivity(), (Class<?>) QQSettingMsgHistoryActivity.class);
                intent.putExtra("set_display_type", 2);
                getActivity().startActivity(intent);
            } else if (id5 == R.id.ay8) {
                QQAppInterface qQAppInterface2 = this.app;
                ReportController.o(qQAppInterface2, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, qQAppInterface2.getCurrentAccountUin(), "", "", "");
                if (!com.tencent.mobileqq.utils.bj.d(this)) {
                    QQAppInterface qQAppInterface3 = this.app;
                    ReportController.o(qQAppInterface3, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, qQAppInterface3.getCurrentAccountUin(), "", "", "");
                    QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.ho9)).setMessage(getString(R.string.hok)).setPositiveButton(getString(R.string.hod), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.QQSettingCleanActivity.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingCleanActivity.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else {
                                ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.activity.QQSettingCleanActivity.2.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        QQAppInterface qQAppInterface4 = QQSettingCleanActivity.this.app;
                                        ReportController.o(qQAppInterface4, "dc00898", "", "", "0X8007914", "0X8007914", 0, 0, qQAppInterface4.getCurrentAccountUin(), "", "", "");
                                        HttpDownloadUtil.queryDownloadInfo("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", QQSettingCleanActivity.this);
                                    }
                                });
                            }
                        }
                    }).setNegativeButton(getString(R.string.cancel), new a());
                    if (negativeButton != null && !negativeButton.isShowing() && !isFinishing()) {
                        negativeButton.setCancelable(false);
                        negativeButton.show();
                    }
                } else {
                    QQAppInterface qQAppInterface4 = this.app;
                    ReportController.o(qQAppInterface4, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, qQAppInterface4.getCurrentAccountUin(), "", "", "");
                    com.tencent.mobileqq.utils.bj.g(this, MimeHelper.MIME_TYPE_MOBILEQQ, 9502721);
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

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Dialog) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 != 1) {
            return super.onCreateDialog(i3);
        }
        this.f176882a0 = null;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.f176882a0 = qQProgressDialog;
        qQProgressDialog.setMessage(getString(R.string.a3f));
        this.f176882a0.setBackAndSearchFilter(true);
        this.f176882a0.showTipImageView(false);
        this.f176882a0.showProgerss(true);
        return this.f176882a0;
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.a
    public boolean onRespDownloadInfo(DownloadInfo downloadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadInfo)).booleanValue();
        }
        if (downloadInfo.resultCode == 0) {
            long j3 = downloadInfo.respContentLength;
            if (NetworkUtil.isNetSupport(this) && j3 > 0) {
                Bundle bundle = new Bundle();
                bundle.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, f176881z0);
                bundle.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, j3);
                bundle.putString("big_brother_source_key", "biz_src_tmm");
                bundle.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_tmm");
                this.f176904w0 = true;
                runOnUiThread(new ShowTask(2));
                J2().startDownload("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", bundle, this);
            }
        } else {
            runOnUiThread(new ShowTask(3));
        }
        return true;
    }
}
