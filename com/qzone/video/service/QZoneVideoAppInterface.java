package com.qzone.video.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import bp.b;
import com.qzone.util.SystemTools;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoAppInterface extends AppRuntime {
    private static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
    private static final int EXIT_TYPE_EXIT_APP = 0;
    private static final String QZONEVIDEO_PROCESS = "com.tencent.mobileqq:qzonevideo";
    public static final String TAG = "QZoneVideoAppInterface";
    private static boolean mLibraryLoaded = false;
    private BroadcastReceiver qqExitBroadcastReceiver = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        SystemTools.f();
    }

    private String getLocalVerify(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLegalBroadcast(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        return str.equals(getLocalVerify(arrayList, false)) || str.equals(getLocalVerify(arrayList, true));
    }

    @Override // mqq.app.AppRuntime
    public BaseApplication getApp() {
        return BaseApplication.getContext();
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.getAccount();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            GlobalInit.loadLibraryWithFullPath(ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext()) + VideoEnvironment.getShortVideoSoLibName());
            mLibraryLoaded = true;
        } catch (Throwable th5) {
            QZLog.w(TAG, "loadLibrary error", th5);
            b.c(1007);
        }
        if (!mLibraryLoaded) {
            QQToast.makeText(BaseApplication.getContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInitSoFileFail", "\u521d\u59cb\u5316so\u6587\u4ef6\u52a0\u8f7d\u5931\u8d25"), 1).show();
            exit();
            return;
        }
        String account = getAccount();
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "account uin=" + account);
        }
        if (TextUtils.isEmpty(account)) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGetAccoutFail", "\u62b1\u6b49\uff0c\u83b7\u53d6\u8d26\u53f7\u5931\u8d25");
            b.c(1008);
            QZLog.e(TAG, "can not get account, msg=" + config);
            QQToast.makeText(BaseApplication.getContext(), config, 1).show();
            exit();
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.video.service.QZoneVideoAppInterface.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZLog.isColorLevel()) {
                    QZLog.d(QZoneVideoAppInterface.TAG, 2, "registerExitReceiver");
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.process.exit");
                BaseApplication.getContext().registerReceiver(QZoneVideoAppInterface.this.qqExitBroadcastReceiver, intentFilter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onDestroy() {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "onRunningBackground");
        }
        super.onRunningBackground();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "onRunningForeground");
        }
        super.onRunningForeground();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("exit_type", 0);
            if (QZLog.isColorLevel()) {
                QZLog.d(QZoneVideoAppInterface.TAG, 2, "qqExitBroadcastReceiver, onReceive, exit type=" + intExtra);
            }
            if ((intent.getStringExtra("K_EXCEP") == null || !intent.getStringExtra("K_EXCEP").endsWith(QZoneVideoAppInterface.QZONEVIDEO_PROCESS)) && "com.tencent.process.exit".equals(intent.getAction())) {
                ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
                if (QZoneVideoAppInterface.this.isLegalBroadcast(intent.getExtras().getString("verify"), stringArrayList) && QZoneVideoAppInterface.this.isContainsProc(stringArrayList)) {
                    if (intExtra == 0 || !QzoneVideoPluginService.U()) {
                        QZLog.e(QZoneVideoAppInterface.TAG, "***exitProcexx*** receive broacast action=" + intent.getAction());
                        QZoneVideoAppInterface.this.exit();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isContainsProc(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        return arrayList.contains(getApplication().getQQProcessName());
    }
}
