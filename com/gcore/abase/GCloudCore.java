package com.gcore.abase;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.gcore.abase.log.XLog;
import com.gcore.abase.utils.DialogUtils;
import com.gcore.gcloud.tasksystem.TaskSystem;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudCore {
    public static GCloudCore Instance = null;
    public static final String TAG = "[GCloudCore]";
    private Context m_cntxt;
    private Thread savedMainThread = null;
    private Handler mHandler = null;
    GCloudCorePaths paths = new GCloudCorePaths();
    GCloudCoreSystem xsystem = new GCloudCoreSystem();
    NetworkStateChecker NetChecker = new NetworkStateChecker();
    private int m_DetailNetworkState = DetailNetworkState.NotReachable.ordinal();
    private int m_Carrier = Carrier.None.ordinal();
    private String m_CarrierCode = "";
    private String m_SSID = "";
    private String m_BSSID = "";
    private String m_CurrentAPN = "";
    private String m_szUdid = null;
    private String m_szBundleId = null;
    private String m_szModel = null;
    private String m_szSysVersion = null;
    private String _appVersion = null;
    private String mDeviceBrand = "";
    SolidConfigReader m_scReader = new SolidConfigReader();

    static {
        try {
            System.loadLibrary("gcloudcore");
        } catch (Throwable th5) {
            XLog.e(TAG, "loadLibrary libgcloudcore.so error=" + th5);
        }
        Instance = new GCloudCore();
    }

    GCloudCore() {
    }

    private void CreateMainHandler() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.gcore.abase.GCloudCore.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                XLog.i(GCloudCore.TAG, "handleMessage Main Thread:" + GCloudCore.this.savedMainThread + "Current Thread:" + Thread.currentThread());
                try {
                    GCloudCore.this.nativePerform(Long.parseLong(message.obj.toString()));
                    return true;
                } catch (Throwable th5) {
                    XLog.e(GCloudCore.TAG, "nativePerform call error=" + th5);
                    return true;
                }
            }
        });
        XLog.i(TAG, "CreateMainHandler success:" + this.mHandler);
    }

    private void GCloudCorecallJNIperform(long j3) {
        try {
            nativePerform(j3);
        } catch (Throwable th5) {
            XLog.e(TAG, "nativePerform call error=" + th5);
        }
    }

    private void cacheSystemInfo(Context context) {
        this.m_szUdid = this.xsystem.GetUdid(context);
        this.m_szBundleId = this.xsystem.GetBundleId(context);
        this.m_szModel = this.xsystem.GetModel();
        this.m_szSysVersion = this.xsystem.GetSysVersion();
        this._appVersion = this.xsystem.GetAppVersion(context);
        this.mDeviceBrand = GCloudCoreSystem.getDeviceBrand();
    }

    private void callbackFromJNI(long j3) {
        Message message = new Message();
        message.obj = Long.valueOf(j3);
        if (Thread.currentThread() == this.savedMainThread) {
            try {
                XLog.i(TAG, "callbackFromJNI nativePerform Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
                nativePerform(j3);
                return;
            } catch (Throwable th5) {
                XLog.e(TAG, "nativePerform call error=" + th5);
                return;
            }
        }
        XLog.i(TAG, "callbackFromJNI Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
        sendMsg(message, this.mHandler);
    }

    private int checkNetworkState() {
        return this.NetChecker.CheckNetworkState(this.m_cntxt);
    }

    private void getDetailNetworkInfo() {
        this.m_CarrierCode = "";
        this.m_Carrier = Carrier.None.ordinal();
        this.m_CurrentAPN = "";
        this.m_SSID = "";
        this.m_BSSID = "";
        this.m_DetailNetworkState = this.NetChecker.GetDetailNetworkState(this.m_cntxt);
        if (DetailNetworkState.ReachableViaWiFi.ordinal() == this.m_DetailNetworkState) {
            this.m_SSID = this.NetChecker.GetSSID(this.m_cntxt);
            this.m_BSSID = this.NetChecker.GetBSSID(this.m_cntxt);
        } else if (DetailNetworkState.ReachableViaWWAN_2G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_3G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_4G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_5G.ordinal() == this.m_DetailNetworkState || DetailNetworkState.ReachableViaWWAN_UNKNOWN.ordinal() == this.m_DetailNetworkState) {
            this.m_CarrierCode = this.NetChecker.GetCurrentCarrierCode(this.m_cntxt);
            String GetCurrentAPN = this.NetChecker.GetCurrentAPN(this.m_cntxt);
            this.m_CurrentAPN = GetCurrentAPN;
            this.m_Carrier = this.NetChecker.GetCurrentCarrier(this.m_CarrierCode, GetCurrentAPN);
        }
    }

    private String getMetaString(String str, String str2, String str3) {
        return this.m_scReader.GetMetaString(this.m_cntxt, str, str2, str3);
    }

    private void getSolidConfigAllKeys(String str, List<String> list) {
        this.m_scReader.GetAllKeys(str, list);
    }

    private int getSolidConfigInt(String str, String str2, int i3) {
        return this.m_scReader.GetInt(str, str2, i3);
    }

    private boolean isSolidConfigContainKey(String str, String str2) {
        return this.m_scReader.IsContainKey(str, str2);
    }

    private native void nativeCreate(Activity activity, Context context, GCloudCorePaths gCloudCorePaths);

    private native void nativeNetworkStateChangeNotify(int i3);

    private native void nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePerform(long j3);

    private native void nativeResume();

    private synchronized void sendMsg(Message message, Handler handler) {
        XLog.i(TAG, "sendMsg before sendMessage:" + this.mHandler);
        this.mHandler.sendMessage(message);
    }

    public void Destroy() {
        try {
            NetworkChangeHelper.Instance.unregisterNetworkListener(this.m_cntxt);
        } catch (Exception e16) {
            XLog.e(TAG, "Destroy error:" + e16.toString());
        }
    }

    public void Initialize(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        this.m_cntxt = applicationContext;
        getPaths(applicationContext);
        this.savedMainThread = Thread.currentThread();
        CreateMainHandler();
        this.m_scReader.Init(this.m_cntxt);
        cacheSystemInfo(this.m_cntxt);
        URLRequest.init();
        DialogUtils.init(activity);
        SecurityStore.Instance.init(this.m_cntxt);
        TaskSystem.Instance.init(this.m_cntxt);
        try {
            nativeCreate(activity, this.m_cntxt, this.paths);
        } catch (Throwable th5) {
            XLog.e(TAG, "nativeCreate call error=" + th5);
        }
        try {
            NetworkChangeHelper.Instance.registerNetworkListener(this.m_cntxt);
        } catch (Exception e16) {
            XLog.e(TAG, "Initialize registerNetworkListener error:" + e16.toString());
        }
        XLog.i(TAG, "GCloudCore Initialize ends");
    }

    public void Initialize2(Context context) {
        this.m_cntxt = context;
        getPaths(context);
        this.savedMainThread = Thread.currentThread();
        CreateMainHandler();
        this.m_scReader.Init(this.m_cntxt);
        cacheSystemInfo(this.m_cntxt);
        URLRequest.init();
        DialogUtils.init(null);
        DialogUtils.initContext(context);
        SecurityStore.Instance.init(this.m_cntxt);
        TaskSystem.Instance.init(this.m_cntxt);
        try {
            nativeCreate(null, this.m_cntxt, this.paths);
        } catch (Throwable th5) {
            XLog.e(TAG, "nativeCreate call error=" + th5);
        }
        try {
            NetworkChangeHelper.Instance.registerNetworkListener(this.m_cntxt);
        } catch (Exception e16) {
            XLog.e(TAG, "Initialize2 registerNetworkListener error:" + e16.toString());
        }
        XLog.i(TAG, "GCloudCore Initialize2 ends");
    }

    public void NetworkStateChangeNotify(int i3) {
        try {
            nativeNetworkStateChangeNotify(i3);
        } catch (Throwable th5) {
            XLog.e(TAG, "nativeNetworkStateChangeNotify call error=" + th5);
        }
    }

    public void Pause() {
        try {
            nativePause();
        } catch (Throwable th5) {
            XLog.e(TAG, "nativePause call error=" + th5);
        }
    }

    public void Resume() {
        try {
            nativeResume();
        } catch (Throwable th5) {
            XLog.e(TAG, "nativeResume call error=" + th5);
        }
    }

    void getPaths(Context context) {
        File filesDir = context.getFilesDir();
        File cacheDir = context.getCacheDir();
        this.paths.DataPath = filesDir.getAbsolutePath() + "/";
        this.paths.CachePath = cacheDir.getAbsolutePath() + "/";
        this.paths.AppPath = new File(this.paths.CachePath).getParent() + "/";
        this.paths.InnerCachePath = filesDir.getAbsolutePath() + "/";
        this.paths.InnerFilePath = filesDir.getAbsolutePath() + "/";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                try {
                    cacheDir = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache"));
                } catch (Exception unused) {
                    XLog.e("GCloudCore", "Create cache dir Error");
                }
            } else {
                cacheDir = externalCacheDir;
            }
            this.paths.CachePath = cacheDir.getAbsolutePath() + "/";
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                try {
                    externalFilesDir = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files"));
                } catch (Exception unused2) {
                    XLog.e("GCloudCore", "Create cache dir Error");
                }
            }
            filesDir = externalFilesDir;
            this.paths.DataPath = filesDir.getAbsolutePath() + "/";
        }
        XLog.i(TAG, "AppPath:" + this.paths.AppPath + ",CachePath:" + this.paths.CachePath + ",DataPath:" + this.paths.DataPath);
    }

    public boolean getSolidConfigBool(String str, String str2, boolean z16) {
        return this.m_scReader.GetBool(str, str2, z16);
    }

    public String getSolidConfigString(String str, String str2, String str3) {
        return this.m_scReader.GetString(str, str2, str3);
    }
}
