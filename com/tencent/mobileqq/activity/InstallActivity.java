package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

/* compiled from: P */
@RoutePage(desc = "\u5b89\u88c5", path = RouterConstants.UI_ROUTE_INSTALL)
/* loaded from: classes9.dex */
public class InstallActivity extends AppActivity implements Runnable {
    static IPatchRedirector $redirector_ = null;
    public static final String NEXT_ACTIVITY = "NT_AY";
    boolean mSplashed;

    public InstallActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSplashed = false;
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Intent intent;
        ClassNotFoundException e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent2 = (Intent) getIntent().getParcelableExtra(NEXT_ACTIVITY);
        if (intent2 == null) {
            try {
                String str = SplashActivity.TAG;
                intent = new Intent(this, (Class<?>) SplashActivity.class);
            } catch (ClassNotFoundException e17) {
                intent = intent2;
                e16 = e17;
            }
            try {
                intent.addFlags(67108864);
            } catch (ClassNotFoundException e18) {
                e16 = e18;
                e16.printStackTrace();
                intent2 = intent;
                startActivity(intent2);
                finish();
                return false;
            }
            intent2 = intent;
        }
        try {
            startActivity(intent2);
            finish();
            return false;
        } catch (Exception unused) {
            System.exit(-1);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        try {
            setContentView(new LinearLayout(this));
        } catch (Exception unused) {
        }
        this.mRuntime = null;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        if (!this.mSplashed) {
            BaseApplicationImpl.sUiHandler.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (this.mSplashed) {
                return;
            }
            this.mSplashed = true;
            BaseApplicationImpl.sApplication.getResources();
            com.tencent.mobileqq.splashad.l.f288780d.r(this, false, null);
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
