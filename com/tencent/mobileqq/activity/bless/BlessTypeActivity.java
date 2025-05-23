package com.tencent.mobileqq.activity.bless;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BlessTypeActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name */
    private static boolean f180575f0;

    /* renamed from: a0, reason: collision with root package name */
    protected View f180576a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f180577b0;

    /* renamed from: c0, reason: collision with root package name */
    protected BlessManager f180578c0;

    /* renamed from: d0, reason: collision with root package name */
    protected float f180579d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f180580e0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlessTypeActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67766);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f180575f0 = false;
        }
    }

    public BlessTypeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f180577b0 = true;
        }
    }

    private void initViews() {
        ((ImmersiveTitleBar2) findViewById(R.id.jq6)).setVisibility(4);
        this.f180576a0 = findViewById(R.id.title);
        findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        findViewById(R.id.aks).setOnClickListener(this);
        View findViewById = findViewById(R.id.f164675aj4);
        this.f180577b0 = this.f180578c0.s0();
        if (!this.f180578c0.r0()) {
            findViewById.setOnClickListener(this);
        } else {
            findViewById.setVisibility(8);
        }
        ImageView imageView = (ImageView) findViewById(R.id.du8);
        int S = BlessManager.S();
        int i3 = (int) (S * this.f180579d0);
        imageView.getLayoutParams().height = i3;
        imageView.requestLayout();
        if (QLog.isColorLevel()) {
            QLog.d("BlessTyeActivity", 2, "target banner size: " + S + " * " + i3);
        }
        String B = this.f180578c0.B(this.f180580e0);
        if (B != null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(B);
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream2, S, i3);
                        Bitmap d16 = com.tencent.mobileqq.util.j.d(B, options);
                        if (d16 != null) {
                            imageView.setImageBitmap(d16);
                        }
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused) {
                            if (!QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e("BlessTyeActivity", 2, "InputStream close excep!");
                        }
                    } catch (FileNotFoundException unused2) {
                        fileInputStream = fileInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.e("BlessTyeActivity", 2, "banner not exist");
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                QLog.e("BlessTyeActivity", 2, "InputStream close excep!");
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused4) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("BlessTyeActivity", 2, "InputStream close excep!");
                                }
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused5) {
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public boolean F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
            return true;
        }
        ShortVideoUtils.loadShortVideoSo(this.app);
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        } else if (i3 == 102 && i16 == -1) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        this.f180578c0 = (BlessManager) this.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("BlessTyeActivity", 2, "onNewIntent");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPostCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.doOnPostCreate(bundle);
            initViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x015b, code lost:
    
        if (r2 == 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                onBackEvent();
            } else if (id5 == R.id.aks) {
                if (this.f180578c0.z() <= 0) {
                    QQToast.makeText(this, String.format(getString(R.string.f170627wc), Integer.valueOf(this.f180578c0.Y())), 0).show();
                } else {
                    Intent intent = new Intent(this, (Class<?>) BlessSendTextActivity.class);
                    intent.putExtra("param_ptv_enable", this.f180577b0);
                    startActivity(intent);
                    overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
                    ReportController.o(this.app, "CliOper", "", "", "0X800618D", "0X800618D", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.f164675aj4) {
                if (this.f180578c0.z() <= 0) {
                    QQToast.makeText(this, String.format(getString(R.string.f170627wc), Integer.valueOf(this.f180578c0.Y())), 0).show();
                } else if (!this.f180577b0) {
                    QQToast.makeText(BaseApplication.getContext(), getString(R.string.f170610vr), 0).show();
                } else if (this.app.isVideoChatting()) {
                    QQToast.makeText(BaseApplication.getContext(), R.string.f171206d52, 0).show();
                } else if (AudioUtil.h(0)) {
                    ChatActivityUtils.Z(this);
                } else if (AudioUtil.h(1)) {
                    ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this);
                } else if (QQAudioHelper.g(0)) {
                    DialogUtil.createCustomDialog(this, 230, getString(R.string.f6e), getString(R.string.f6g), new a(), null).show();
                } else {
                    boolean j3 = com.tencent.mobileqq.shortvideo.util.f.j(this.app, BaseApplication.getContext());
                    if (F2()) {
                        if (!j3) {
                            int aEResStatus = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
                        }
                        z16 = true;
                        QLog.i("BlessTyeActivity", 2, "bless_ptv press, filterOK=" + j3 + ",videoAndSoReady:" + z16);
                        if (z16 && !f180575f0) {
                            AudioPanelUtils.a(this.app, false, "0X8006385");
                            f180575f0 = true;
                        }
                    }
                    z16 = false;
                    QLog.i("BlessTyeActivity", 2, "bless_ptv press, filterOK=" + j3 + ",videoAndSoReady:" + z16);
                    if (z16) {
                        AudioPanelUtils.a(this.app, false, "0X8006385");
                        f180575f0 = true;
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }
}
