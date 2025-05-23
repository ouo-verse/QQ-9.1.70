package com.tencent.mobileqq.activity.shortvideo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SendVideoActivity extends BaseActivity implements Handler.Callback {

    /* renamed from: a0, reason: collision with root package name */
    private static MqqWeakReferenceHandler f186245a0;

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
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
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
                            MqqWeakReferenceHandler mqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
                            f186245a0 = mqqWeakReferenceHandler;
                            mqqWeakReferenceHandler.sendEmptyMessageDelayed(1, 45000L);
                        }
                    } else {
                        ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
                    }
                }
            } else {
                String stringExtra2 = getIntent().getStringExtra(ShortVideoConstants.ACTIVITY_BEFORE_ENTER_SEND_VIDEO);
                if (stringExtra2 != null && ShortVideoPreviewActivity.class.getName().equals(stringExtra2)) {
                    new f(this).execute(new Void[0]);
                } else {
                    ThreadManager.getSubThreadHandler().post(new SendTask(this, null));
                }
            }
        } else {
            new h(this, null).execute(new Void[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        MqqWeakReferenceHandler mqqWeakReferenceHandler = f186245a0;
        if (mqqWeakReferenceHandler != null) {
            mqqWeakReferenceHandler.removeMessages(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IHttpCommunicatorListener findProcessor;
        if (message.what == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("SendVideoActivity", 2, "handleMessage: send video timeout!");
            }
            MessageForShortVideo Q = ((BlessManager) getAppInterface().getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).Q();
            if (Q != null && (findProcessor = ((ITransFileController) this.app.getRuntimeService(ITransFileController.class)).findProcessor(Q.frienduin, Q.uniseq)) != null && IShortVideoUploadProcessor.class.isInstance(findProcessor)) {
                boolean isPause = ((BaseTransProcessor) findProcessor).isPause();
                int i3 = Q.videoFileStatus;
                if (isPause || i3 == 1002 || i3 == 1001) {
                    com.tencent.mobileqq.video.a.c(this.app, Q.frienduin, Q.uniseq);
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
