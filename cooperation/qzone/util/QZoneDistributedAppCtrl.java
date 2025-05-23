package cooperation.qzone.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.ServerListProvider;
import java.util.HashMap;
import java.util.Map;
import km.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneDistributedAppCtrl implements Handler.Callback {
    public static final int CMD_CLEAR_AD_FEEDS = 1;
    public static final int CMD_CLEAR_ALL_FEEDS = 2;
    public static final int CMD_CLEAR_CACHE = 3;
    public static final int CMD_CLEAR_TOKEN = 4;
    public static final int CMD_COMBQZ_PROTECT = 11;
    public static final int CMD_ENABLE_DEBUG = 12;
    public static final int CMD_ENABLE_PERFORMANCE_MONITOR = 13;
    public static final int CMD_PRINT_DIR_FILE_LIST = 16;
    public static final int CMD_PRINT_WNS_CONFIG = 15;
    public static final int CMD_REACT_DEVELOP_BUNDLE = 17;
    public static final int CMD_RESTART = 5;
    public static final int CMD_UPLOAD_ANR = 8;
    public static final int CMD_UPLOAD_AVSDK = 18;
    public static final int CMD_UPLOAD_CUSTOM = 14;
    public static final int CMD_UPLOAD_DB = 7;
    public static final int CMD_UPLOAD_LOGCAT = 10;
    public static final int CMD_UPLOAD_TRACE = 9;
    private static final long HalfHourMills = 1800000;
    public static final String KEY_AVSDK_ENDTIME = "key_avsdk_endTime";
    public static final String KEY_AVSDK_STARTTIME = "key_avsdk_startTime";
    public static final String KEY_CTRL_PARAM_ENABLE = "key_ctrl_param_enable";
    public static final String KEY_PATH_DATA = "key_path_data";
    public static final String KEY_PATH_TENCENT = "key_path_tencent";
    public static final String KEY_QZAPP_VERSION_CODE = "key_qzapp_versioncode";
    public static final String KEY_QZCOMBO_PROTECT_SWITCH = "key_qzcombo_protect";
    public static final String KEY_QZH5_URL = "key_qzh5_url";
    public static final String KEY_REACT_DEVEL_BUNDLE_ON = "key_rndev_bundle_on";
    public static final String KEY_REACT_DEVEL_BUNDLE_URL = "key_rndev_bundle_url";
    public static final String KEY_TRACE_STARTTIME = "key_trace_baseTime";
    public static final String KEY_TRACE_TIMEOFFSET = "key_trace_offset";
    public static final String KEY_UPLOAD_DBNAME = "key_upload_dbname";
    public static final String KEY_UPLOAD_FILE_MAXSIZE = "key_upload_maxsize";
    public static final String KEY_URL = "key_url";
    public static final String KEY_WNS_CONFIG_MAIN = "key_wns_config_main";
    public static final String KEY_WNS_CONFIG_SECOND = "key_wns_config_second";
    static final int MSG_BASE = 0;
    static final int MSG_CMD = 2;
    static final int MSG_EXEC = 1;
    private static final String TAG = "QZoneDistributedAppCtrl";
    private static QZoneDistributedAppCtrl instance;
    private static Object lock = new Object();
    public static String mUin;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class Control {
        public int cmd;
        public Map<String, String> data = new HashMap();

        public String toString() {
            return "ctrl:[cmd = " + this.cmd + ", data = " + this.data + "]";
        }
    }

    QZoneDistributedAppCtrl(String str) {
        mUin = str;
    }

    private void execCmd(Control control) {
        int i3 = control.cmd;
        if (i3 == 5 || !QLog.isDevelopLevel()) {
            return;
        }
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i3);
    }

    public static QZoneDistributedAppCtrl getInstance(String str) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new QZoneDistributedAppCtrl(str);
                }
            }
        }
        return instance;
    }

    public static void handleReactDev(Map<String, String> map) {
        String str = map.get(KEY_REACT_DEVEL_BUNDLE_URL);
        String str2 = map.get(KEY_REACT_DEVEL_BUNDLE_ON);
        LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
        LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", str2);
        QLog.i("QZoneDistributedAppCtrl", 1, "rnbundleurl=" + str + ",rndevon=" + str2);
    }

    public static void killQZoneProcess() {
        QLog.d(TimeCostTrace.TAG_QZONE_LAUNCH, 1, "QZoneDistributedAppCtrl killQZoneProcess: " + Log.getStackTraceString(new Throwable()));
        BaseApplication.getContext().stopService(QZoneHelper.getQzoneBootServiceIntent(BaseApplication.getContext()));
        a.f412646a.e(BaseApplication.getContext(), "com.tencent.mobileqq:qzone");
    }

    private void onHandleComboQzProtect(boolean z16, int i3, String str) {
        LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_PROTECT_ENABLE, z16);
        LocalMultiProcConfig.putInt(QZoneHelper.Constants.KEY_QZAPP_VERCODE, i3);
        if (z16) {
            if (!TextUtils.isEmpty(str)) {
                LocalMultiProcConfig.putString(QZoneHelper.Constants.KEY_QZH5_URL, str);
            }
            LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_SAFE_MODE_TIP, false);
            LocalMultiProcConfig.putString(QZoneHelper.Constants.KEY_QUA, QUA.getQUA3());
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + message);
        }
        int i3 = message.what;
        if (i3 == 1) {
            execCtrl((Control) message.obj);
        } else {
            if (i3 != 2) {
                return false;
            }
            execCmd((Control) message.obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execCtrl(Control control) {
        long j3;
        long longValue;
        long j16;
        QZoneDistributedAppCtrl qZoneDistributedAppCtrl;
        String str;
        boolean z16;
        long j17;
        String str2;
        int i3 = control.cmd;
        if (QLog.isColorLevel()) {
            QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i3);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String str3 = "";
        boolean z17 = false;
        switch (i3) {
            case 1:
                killQZoneProcess();
                return;
            case 2:
                QZoneHelper.clearFeedsCache(BaseApplication.getContext(), mUin);
                return;
            case 3:
                if (runtime instanceof QQAppInterface) {
                    QZoneHelper.clearCache(runtime, true);
                    return;
                }
                return;
            case 4:
                break;
            case 5:
                killQZoneProcess();
                if (runtime instanceof QQAppInterface) {
                    QZoneHelper.preloadQzone((QQAppInterface) runtime, "QZoneDistributedAppCtrl");
                    return;
                }
                return;
            case 6:
            default:
                if (QLog.isDevelopLevel()) {
                    QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i3);
                    return;
                }
                return;
            case 7:
                QZoneAppCtrlUploadFileLogic.uploadDB(BaseApplication.getContext(), mUin, control.data.get(KEY_UPLOAD_DBNAME));
                return;
            case 8:
                QZoneAppCtrlUploadFileLogic.uploadANR(BaseApplication.getContext(), mUin);
                return;
            case 9:
                String str4 = control.data.get(KEY_TRACE_STARTTIME);
                String str5 = control.data.get(KEY_TRACE_TIMEOFFSET);
                if (TextUtils.isEmpty(str4)) {
                    longValue = System.currentTimeMillis();
                } else {
                    try {
                        longValue = Long.valueOf(str4).longValue() * 1000;
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                        j3 = 0;
                    }
                }
                j3 = longValue;
                if (TextUtils.isEmpty(str5)) {
                    j16 = 1800000;
                } else {
                    try {
                        j16 = Long.valueOf(str5).longValue() * 1000;
                    } catch (NumberFormatException e17) {
                        e17.printStackTrace();
                        j16 = 0;
                    }
                }
                if (j3 <= 0) {
                    j3 = System.currentTimeMillis();
                }
                long j18 = j16 > 0 ? j16 : 1800000L;
                long j19 = j3 - j18;
                if (QLog.isDevelopLevel()) {
                    QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + j19 + "ms\t offsettime: " + j18 + "\t trace endTime: " + j3 + "ms");
                }
                QZoneAppCtrlUploadFileLogic.uploadTrace(BaseApplication.getContext(), mUin, j19, j3);
                return;
            case 10:
                QZoneAppCtrlUploadFileLogic.saveLogcatToFileV2(BaseApplication.getContext(), mUin);
                return;
            case 11:
                int i16 = 82;
                try {
                    z17 = Boolean.parseBoolean(control.data.get(KEY_QZCOMBO_PROTECT_SWITCH));
                    i16 = Integer.parseInt(control.data.get(KEY_QZAPP_VERSION_CODE));
                    qZoneDistributedAppCtrl = this;
                    str3 = control.data.get(KEY_QZH5_URL);
                } catch (Throwable th5) {
                    QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", th5);
                    qZoneDistributedAppCtrl = this;
                }
                qZoneDistributedAppCtrl.onHandleComboQzProtect(z17, i16, str3);
                return;
            case 12:
                String str6 = control.data.get(KEY_CTRL_PARAM_ENABLE);
                if (!TextUtils.isEmpty(str6)) {
                    ServerListProvider.enableDebug(Boolean.valueOf(str6).booleanValue());
                }
                if (QLog.isDevelopLevel()) {
                    QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param\uff1a" + str6);
                    break;
                }
                break;
            case 13:
                String str7 = control.data.get(KEY_CTRL_PARAM_ENABLE);
                if (!TextUtils.isEmpty(str7)) {
                    if (Boolean.valueOf(str7).booleanValue()) {
                        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
                    } else {
                        LocalMultiProcConfig.putString("LooperMonitor", "-1");
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param\uff1a" + str7);
                    break;
                }
                break;
            case 14:
                String str8 = control.data.get(KEY_PATH_TENCENT);
                if (TextUtils.isEmpty(str8)) {
                    str = control.data.get(KEY_PATH_DATA);
                    z16 = true;
                } else {
                    str = str8;
                    z16 = false;
                }
                if (!TextUtils.isEmpty(str)) {
                    String str9 = control.data.get(KEY_UPLOAD_FILE_MAXSIZE);
                    try {
                        j17 = Long.valueOf(str9).longValue();
                    } catch (Exception unused) {
                        if (QLog.isDevelopLevel()) {
                            QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param\uff1a" + str9 + ",error:Not long");
                        }
                        j17 = 1048576;
                    }
                    long j26 = j17;
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("CMD_UPLOAD_CUSTOM, param\uff1a");
                        if (z16) {
                            str2 = "dataPath";
                        } else {
                            str2 = "tencentPath";
                        }
                        sb5.append(str2);
                        sb5.append(",");
                        sb5.append(str);
                        QLog.w("QZoneDistributedAppCtrl", 4, sb5.toString());
                    }
                    QZoneAppCtrlUploadFileLogic.uploadByCustom(BaseApplication.getContext(), str, mUin, j26, z16);
                    break;
                } else {
                    return;
                }
            case 15:
                QzoneConfig.getInstance().printWNSConfig(control.data.get(KEY_WNS_CONFIG_MAIN), control.data.get(KEY_WNS_CONFIG_SECOND));
                break;
            case 16:
                QZoneAppCtrlUploadFileLogic.showDirFileList(BaseApplication.getContext(), control.data.get("key_url"));
                break;
            case 17:
                handleReactDev(control.data);
                break;
            case 18:
                String str10 = control.data.get(KEY_AVSDK_STARTTIME);
                String str11 = control.data.get(KEY_AVSDK_ENDTIME);
                long avsdkTimeFromServer = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer(str10);
                long avsdkTimeFromServer2 = QZoneAppCtrlUploadFileLogic.getAvsdkTimeFromServer(str11);
                if (avsdkTimeFromServer != -1) {
                    if (avsdkTimeFromServer2 == -1) {
                        avsdkTimeFromServer2 = System.currentTimeMillis();
                    }
                    if (avsdkTimeFromServer > avsdkTimeFromServer2) {
                        avsdkTimeFromServer2 = System.currentTimeMillis();
                    }
                    QZoneAppCtrlUploadFileLogic.uploadAvsdk(BaseApplication.getContext(), mUin, avsdkTimeFromServer, avsdkTimeFromServer2);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str10 + ",endTime=" + str11);
                        break;
                    }
                } else {
                    return;
                }
                break;
        }
    }

    public void submitCtrl(final Control control) {
        if (control != null) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: cooperation.qzone.util.QZoneDistributedAppCtrl.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneDistributedAppCtrl.this.execCtrl(control);
                }
            });
        }
    }
}
