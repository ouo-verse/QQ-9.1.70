package com.tencent.mobileqq.mini.launch;

import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.cl;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.aq;
import common.config.service.QzoneConfig;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppStartUtils {
    private static final String TAG = "miniapp-start-File";
    private static int mFrequencySwitch;
    private static int mTimeInterval;
    public static final String FOLDER = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini_intent/";
    private static final String SCENE_WHITELIST_PRESET = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_STUDY_MODE_SCENE_WHITELIST, QzoneConfig.DEFAULT_STUDY_MODE_SCENE_WHITELIST);
    private static final String APPID_WHITELIST_PRESET = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_STUDY_MODE_APPID_WHITELIST, QzoneConfig.DEFAULT_STUDY_MODE_APPID_WHITELIST);
    private static String KEY_APPID_WHITELIST_REMOTE = "remoteAppidWhiteList";
    private static String mAppIDWhiteListRemote = "";
    private static Runnable mUpdateWhiteListRunnable = null;

    public static String getFilePath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.contains(":")) {
                str2 = str.substring(str.indexOf(":") + 1);
            } else {
                str2 = "main";
            }
            String str3 = FOLDER + str2;
            QLog.i(TAG, 1, "processName file path:" + str3 + " processName:" + str);
            return str3;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getFilePath exception! processName:" + str, th5);
            return null;
        }
    }

    public static MiniAppConfig parserStringToMiniAppInfo(String str) {
        Parcel parcel;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            parcel = Utils.unmarshall(Base64.decode(str, 0));
        } catch (Throwable th5) {
            th = th5;
            parcel = null;
        }
        try {
            MiniAppConfig miniAppConfig = (MiniAppConfig) parcel.readParcelable(MiniAppConfig.class.getClassLoader());
            OaidMonitor.parcelRecycle(parcel);
            return miniAppConfig;
        } catch (Throwable th6) {
            th = th6;
            try {
                QDLog.e(TAG, "parserStringToMiniAppInfo exception!", th);
                return null;
            } finally {
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
            }
        }
    }

    public static boolean shouldInterceptStartMiniApp(String str, String str2) {
        if (!StudyModeManager.t() || aq.j(str)) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniAppStartUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (MiniAppStartUtils.mFrequencySwitch == 0) {
                    QLog.i(MiniAppStartUtils.TAG, 1, "try to start mini app, update whitelist");
                    MiniAppStartUtils.updateWhiteList();
                } else {
                    QLog.i(MiniAppStartUtils.TAG, 1, "frequency switch is on, skip update whitelist.");
                }
            }
        }, 16, null, true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("scene=");
        sb5.append(str2);
        sb5.append(", appid=");
        sb5.append(str);
        sb5.append(", scene list=");
        String str3 = SCENE_WHITELIST_PRESET;
        sb5.append(str3);
        QLog.i(TAG, 1, sb5.toString());
        String str4 = APPID_WHITELIST_PRESET;
        if (!TextUtils.isEmpty(str4) && str4.contains(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(str3) && str3.contains(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(mAppIDWhiteListRemote)) {
            mAppIDWhiteListRemote = cl.d(BaseApplication.getContext(), KEY_APPID_WHITELIST_REMOTE);
        }
        return TextUtils.isEmpty(mAppIDWhiteListRemote) || !mAppIDWhiteListRemote.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startCountDownTime() {
        long j3 = mTimeInterval * 1000;
        if (j3 > 0) {
            Runnable runnable = mUpdateWhiteListRunnable;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
            }
            mUpdateWhiteListRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniAppStartUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i(MiniAppStartUtils.TAG, 1, " start mUpdateWhiteListRunnable");
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniAppStartUtils.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.i(MiniAppStartUtils.TAG, 1, "get whitelist at intervals.");
                            MiniAppStartUtils.updateWhiteList();
                        }
                    }, 16, null, true);
                }
            }, 16, null, true, j3);
        }
    }

    public static void updateWhiteList() {
        MiniAppCmdUtil.getInstance().getTeenagerConfig("", new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.launch.MiniAppStartUtils.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (!z16 || jSONObject == null) {
                    return;
                }
                MiniAppStartUtils.mFrequencySwitch = jSONObject.optInt(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, -1);
                MiniAppStartUtils.mTimeInterval = jSONObject.optInt(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, -1);
                String optString = jSONObject.optString(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST, "");
                if (TextUtils.isEmpty(optString)) {
                    QLog.i(MiniAppStartUtils.TAG, 1, "remote appIdWhiteList is empty.");
                }
                if (TextUtils.isEmpty(MiniAppStartUtils.mAppIDWhiteListRemote) || !MiniAppStartUtils.mAppIDWhiteListRemote.equals(optString)) {
                    cl.g(BaseApplication.getContext(), MiniAppStartUtils.KEY_APPID_WHITELIST_REMOTE);
                    cl.j(BaseApplication.getContext(), MiniAppStartUtils.KEY_APPID_WHITELIST_REMOTE, optString);
                    MiniAppStartUtils.mAppIDWhiteListRemote = optString;
                }
                MiniAppStartUtils.startCountDownTime();
            }
        });
    }
}
