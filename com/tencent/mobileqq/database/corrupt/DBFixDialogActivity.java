package com.tencent.mobileqq.database.corrupt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DBFixDialogActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private MMKVOptionEntity f203216a0;

    public DBFixDialogActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203216a0 = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
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
        String str;
        long j3;
        int i3;
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        boolean z17 = false;
        if (intent != null) {
            long longExtra = intent.getLongExtra(DBFixManager.I, 0L);
            str = intent.getStringExtra(DBFixManager.J);
            if (longExtra > 0 && !TextUtils.isEmpty(str)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = DBFixManager.H;
            } else {
                str2 = DBFixManager.E;
            }
            i3 = intent.getIntExtra(str2, 1);
            QLog.d("DBFix", 1, "DBFixDialogActivity onCreate dbSize is " + longExtra + " ,dbPath is " + str + " ,isNT is " + z16 + " ,count is " + i3 + " ,dbFixNTIsNeed is " + DBFixManager.f203270j0);
            j3 = longExtra;
        } else {
            str = "";
            j3 = 0;
            i3 = 1;
        }
        String str3 = str;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getAccount())) {
            if (!this.app.getApplication().getSharedPreferences(DBFixManager.f203271m, 0).getBoolean(this.app.getAccount() + DBFixManager.D, false) && !DBFixManager.f203270j0) {
                QLog.e("DBFix", 1, "db is not corrupt!");
                return true;
            }
            new DBFixDialogUI(this, this.app, j3, str3).v(i3);
            return true;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "app is null: ";
        if (this.app == null) {
            z17 = true;
        }
        objArr[1] = Boolean.valueOf(z17);
        QLog.e("DBFix", 1, objArr);
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.requestWindowFeature(1);
        }
    }
}
