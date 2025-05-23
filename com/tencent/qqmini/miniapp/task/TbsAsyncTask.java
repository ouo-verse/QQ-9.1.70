package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.receiver.WebProcessReceiver;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.TbsLogClient;
import java.util.HashMap;

/* compiled from: P */
@ClassTag(tag = "TbsAsyncTask")
/* loaded from: classes23.dex */
public class TbsAsyncTask extends AsyncTask {
    public static final int MSG_WHAT_CHECK_TBS = 6;
    public static final int MSG_WHAT_X5_DOWNLOAD_PROGRESS = 3;
    public static final int MSG_WHAT_X5_TIMEOUT = 7;
    private static final String TBS_TAG = "[MiniSDK][TBS]";
    private static final int X5_LOAD_TIME_OUT = 30000;
    private static int X5_STATE_DOWNLOAD_EXIST_IN_WX = 122;
    private static int X5_STATE_DOWNLOAD_FAIL_INIT_THREAD = 121;
    private static int X5_STATE_DOWNLOAD_OTHER_PROCESS = 177;
    private static int X5_STATE_DOWNLOAD_READY = 120;
    private static int X5_STATE_DOWNLOAD_REPEAT = 110;
    private static int X5_STATE_DOWNLOAD_SUCC = 100;
    private static int X5_STATE_INSTALL_COPY_SUCC = 220;
    private static int X5_STATE_INSTALL_SUCC = 200;
    private static int X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK = 232;
    private boolean mDownloadForground;
    public boolean mIsTimeout;
    private int mTbsProgress;
    private boolean mWaitForX5;
    protected Handler workHander;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends TbsLogClient {
        a(Context context) {
            super(context);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void d(String str, String str2) {
            if (QMLog.isColorLevel()) {
                QMLog.d(TbsAsyncTask.TBS_TAG + str, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void e(String str, String str2) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TbsAsyncTask.TBS_TAG + str, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void i(String str, String str2) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TbsAsyncTask.TBS_TAG + str, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void w(String str, String str2) {
            if (QMLog.isColorLevel()) {
                QMLog.w(TbsAsyncTask.TBS_TAG + str, str2);
            }
        }
    }

    public TbsAsyncTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
        this.mIsTimeout = false;
        this.mDownloadForground = false;
        this.mWaitForX5 = false;
        this.mTbsProgress = 0;
    }

    public static String getSubProcessName() {
        String str = null;
        try {
            String processName = AppLoaderFactory.g().getProcessName();
            if (processName.contains(":")) {
                str = processName.substring(processName.indexOf(":") + 1);
            }
        } catch (Throwable th5) {
            QMLog.e(AppLoaderFactory.TAG, "getSubProcessName exception!", th5);
        }
        if (TextUtils.isEmpty(str)) {
            return "mini";
        }
        return str;
    }

    private void initTbsLog() {
        QbSdk.setTbsLogClient(new a(this.mContext));
    }

    public void doCheckTbs() {
        int tbsVersion = QbSdk.getTbsVersion(this.mContext);
        int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(this.mContext);
        QMLog.d(AppLoaderFactory.TAG, "getTbsVersion=" + tbsVersion + " tmpDirTbsVersion=" + tmpDirTbsVersion);
        Context context = this.mContext;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mContext.getPackageName());
        sb5.append("_preferences");
        SharedPreferences sharedPreferences = context.getSharedPreferences(sb5.toString(), 4);
        int i3 = sharedPreferences.getInt("tbs_download_complete", -1);
        QMLog.i(AppLoaderFactory.TAG, "tbs download result: " + i3);
        if ((i3 != X5_STATE_INSTALL_SUCCESS_AND_RELEASE_LOCK && i3 != X5_STATE_INSTALL_COPY_SUCC) || (tbsVersion <= 0 && tmpDirTbsVersion <= 0)) {
            if (i3 != -1) {
                getWorkHander().removeMessages(6);
                onTaskFailed();
                return;
            }
            int i16 = sharedPreferences.getInt("tbs_download_progress", 0);
            QMLog.d(AppLoaderFactory.TAG, "tbs download progress " + i16);
            if (i16 > this.mTbsProgress) {
                this.mTbsProgress = i16;
                getWorkHander().removeMessages(7);
                getWorkHander().sendEmptyMessageDelayed(7, 30000L);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.arg1 = i16;
            }
            if (!isDone()) {
                getWorkHander().sendEmptyMessageDelayed(6, 1000L);
                return;
            }
            return;
        }
        getWorkHander().removeMessages(6);
        onTaskSucceed();
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        QMLog.i(AppLoaderFactory.TAG, "startTbs");
        int tbsVersion = QbSdk.getTbsVersion(this.mContext);
        int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(this.mContext);
        QMLog.i(AppLoaderFactory.TAG, "tbsVersion=" + tbsVersion + " tmpDirTbsVersion=" + tmpDirTbsVersion + ",data_directory_suffix:" + getSubProcessName());
        HashMap hashMap = new HashMap();
        hashMap.put("data_directory_suffix", getSubProcessName());
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.TRUE);
        QbSdk.initTbsSettings(hashMap);
        initTbsLog();
        this.mIsTimeout = false;
        if (tbsVersion <= 0 && tmpDirTbsVersion <= 0) {
            if (QUAUtil.isQQApp()) {
                QMLog.i(AppLoaderFactory.TAG, "QQ App no need to update x5 in sdk.");
                onTaskSucceed();
                return;
            }
            if (!this.mWaitForX5) {
                QMLog.i(AppLoaderFactory.TAG, "X5 isn't completed\uff0c use system core\u3002");
                Intent intent = new Intent(this.mContext, (Class<?>) WebProcessReceiver.class);
                intent.setAction(WebProcessReceiver.ACTION_DOWNLOAD_TBS);
                intent.putExtra("isDownloadForeground", this.mDownloadForground);
                intent.putExtra("fromMiniApp", true);
                this.mContext.sendBroadcast(intent);
                onTaskSucceed();
                return;
            }
            getWorkHander().sendEmptyMessageDelayed(7, 30000L);
            this.mTbsProgress = 0;
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
            sharedPreferences.edit().remove("tbs_download_complete").commit();
            sharedPreferences.edit().remove("tbs_download_progress").commit();
            Intent intent2 = new Intent(this.mContext, (Class<?>) WebProcessReceiver.class);
            intent2.setAction(WebProcessReceiver.ACTION_DOWNLOAD_TBS);
            intent2.putExtra("isDownloadForeground", this.mDownloadForground);
            intent2.putExtra("fromMiniApp", true);
            this.mContext.sendBroadcast(intent2);
            QMLog.d(AppLoaderFactory.TAG, "start WebProcessReceiver isDownloadForeground" + this.mDownloadForground);
            getWorkHander().sendEmptyMessageDelayed(6, 1000L);
            return;
        }
        onTaskSucceed();
    }

    public Handler getWorkHander() {
        if (this.workHander == null) {
            this.workHander = new Handler(Looper.getMainLooper(), this);
        }
        return this.workHander;
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 6) {
            if (i3 == 7) {
                int tbsVersion = QbSdk.getTbsVersion(this.mContext);
                int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(this.mContext);
                QMLog.d(AppLoaderFactory.TAG, "X5\u5b89\u88c5\u8d85\u65f6 tbsVersion=" + tbsVersion + " tmpDirTbsVersion=" + tmpDirTbsVersion);
                if (tbsVersion <= 0 && tmpDirTbsVersion <= 0) {
                    this.mIsTimeout = true;
                    onTaskFailed();
                    return false;
                }
                onTaskSucceed();
                return false;
            }
            return false;
        }
        doCheckTbs();
        return false;
    }

    public void needDownloadForeground(boolean z16) {
        this.mDownloadForground = z16;
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskFailed() {
        getWorkHander().removeMessages(7);
        QMLog.d(AppLoaderFactory.TAG, "TbsAsyncTask failed! Work continue as same as succeed anyway. ");
        super.onTaskSucceed();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        getWorkHander().removeMessages(7);
        super.onTaskSucceed();
    }
}
