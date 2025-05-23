package com.tencent.qqnt.shortvideo.msg;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.BaseActivity;
import dy3.a;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SendVideoActivity extends BaseActivity implements Handler.Callback {

    /* renamed from: b0, reason: collision with root package name */
    private final Handler f362253b0 = new Handler(Looper.getMainLooper());

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && QLog.isColorLevel()) {
            QLog.i("SendVideoActivity", 2, "handleMessage: send video timeout!");
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate(), ===>> busiType=" + intExtra + ",VideoFileDir = " + getIntent().getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR));
        }
        if (intExtra != 0) {
            if (intExtra != 2) {
                if (intExtra != 3) {
                    if (intExtra == 4) {
                        ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
                    }
                } else {
                    String stringExtra = getIntent().getStringExtra("uin");
                    if (QLog.isColorLevel()) {
                        QLog.d("SendVideoActivity", 2, "doOnCreate, uin= " + stringExtra);
                    }
                    if (stringExtra != null && stringExtra.equals("0")) {
                        int intExtra2 = getIntent().getIntExtra("uintype", -1);
                        if (intExtra2 != 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SendVideoActivity", 2, "doOnCreate error, uinType= " + intExtra2 + " busiType= " + intExtra);
                            }
                            finish();
                        } else {
                            this.f362253b0.sendEmptyMessageDelayed(1, 45000L);
                        }
                    } else {
                        ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
                    }
                }
            } else {
                getIntent().getStringExtra(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
            }
        } else {
            new a(this, null).execute(new Void[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f362253b0;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    @Override // com.tencent.qqnt.base.BaseActivity
    public void initViewModel() {
    }
}
