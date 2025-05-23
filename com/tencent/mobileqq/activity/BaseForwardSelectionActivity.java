package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BaseForwardSelectionActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected ForwardBaseOption f175036a0;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f175037b0;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f175038c0;

    /* renamed from: d0, reason: collision with root package name */
    protected Bundle f175039d0;

    public BaseForwardSelectionActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void startChatAndSendMsg() {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        Bundle bundle = new Bundle(this.f175039d0);
        bundle.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, false);
        bundle.putBoolean(PeakConstants.IS_FORWARD, true);
        bundle.putInt(PeakConstants.SEND_BUSINESS_TYPE, 1031);
        bundle.putBoolean("PicContants.NEED_COMPRESS", false);
        m3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        m3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        m3.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        m3.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        m3.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
        m3.putExtra("isBack2Root", false);
        m3.putExtras(bundle);
        String string = bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        PhotoUtils.sendPhoto(this, m3, arrayList, 0, false);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1) {
            if (i3 != 20001) {
                if (i3 == 20002) {
                    this.f175036a0.onActivityResult(i3, i16, intent);
                }
            } else {
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = getIntent().getBooleanExtra("call_by_forward", false);
            this.f175038c0 = booleanExtra;
            if (booleanExtra) {
                ForwardBaseOption d16 = com.tencent.mobileqq.forward.k.d(intent, this.app, this);
                this.f175036a0 = d16;
                this.f175039d0 = d16.getExtras();
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ForwardBaseOption forwardBaseOption = this.f175036a0;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("BaseForwardSelectionActivity", 2, "BaseForwardSelectionActivity onNewIntent()");
        }
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false) && (stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS")) != null && !stringArrayListExtra.isEmpty()) {
            String str = stringArrayListExtra.get(0);
            this.f175039d0.putBoolean(AppConstants.Key.FORWARD_IS_EDITED, true);
            int i3 = this.f175039d0.getInt("key_forward_ability_type", 0);
            if (i3 != com.tencent.mobileqq.forward.e.S3.intValue() && i3 != com.tencent.mobileqq.forward.e.X3.intValue() && i3 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
                this.f175039d0.putString("GALLERY.FORWORD_LOCAL_PATH", str);
                startChatAndSendMsg();
                ReportController.o(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
                return;
            }
            this.f175036a0.forwardToDataLine(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
