package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class PhoneUnityVerifyActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private String f176626a0;

    public PhoneUnityVerifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 1001) {
            super.setResult(-1, intent);
            super.finish();
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
        super.setContentView(R.layout.az6);
        super.setTitle(getString(R.string.csa));
        this.leftView.setVisibility(8);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(R.string.bop);
        this.rightViewText.setOnClickListener(this);
        Button button = (Button) super.findViewById(R.id.fnf);
        if (button != null) {
            button.setOnClickListener(this);
        }
        Intent intent = super.getIntent();
        if (intent != null) {
            this.f176626a0 = intent.getStringExtra("url");
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        super.setResult(-1, new Intent());
        super.finish();
        super.overridePendingTransition(0, R.anim.f154458a7);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.fnf) {
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("uin", this.app.getCurrentAccountUin());
                intent.putExtra("url", this.f176626a0);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("hide_more_button", true);
                intent.putExtra("portraitOnly", true);
                intent.putExtra("isShowAd", false);
                intent.putExtra("needResult", true);
                intent.putExtra("business", 16384L);
                super.startActivityForResult(intent, 1001);
            } else if (id5 == R.id.ivTitleBtnRightText) {
                super.setResult(-1, new Intent());
                super.finish();
                super.overridePendingTransition(0, R.anim.f154458a7);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
