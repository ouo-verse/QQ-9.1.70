package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;

/* loaded from: classes12.dex */
public class FilePicQFavActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    long f208165a0;

    /* renamed from: b0, reason: collision with root package name */
    ChatMessage f208166b0;

    private void G2() {
        FileManagerEntity D;
        if (this.f208165a0 != -1 && (D = this.app.getFileManagerDataCenter().D(this.f208165a0)) != null && -1 != D.uniseq) {
            this.f208166b0 = (ChatMessage) this.app.getMessageFacade().w0(D.peerUin, D.peerType, D.uniseq);
            new QfavBuilder(3).u(this.app, this, D, this.f208166b0, false);
        }
        finish();
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
        super.doOnCreate(bundle);
        this.f208165a0 = getIntent().getLongExtra("file_pic_favorites", -1L);
        G2();
        return true;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isDevelopLevel()) {
            QLog.d("FilePicQFavActivity", 4, "FilePicQFavActivity onDestroy");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
