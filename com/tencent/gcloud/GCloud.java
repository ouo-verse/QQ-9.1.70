package com.tencent.gcloud;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.gcloudsdk.gcloud.core.GCorePaths;
import com.gcloudsdk.gcloud.core.GCoreSystem;
import com.gcloudsdk.gcloud.core.NetworkChangeHelper;
import com.gcloudsdk.gcloud.core.NetworkStateChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gcloud.netinterface.NetInterfaceHelper;
import com.tencent.gcloud.qr.QRCodeAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GCloud {
    static IPatchRedirector $redirector_ = null;
    public static final GCloud Instance;
    private static final String TAG = "GCloud";
    private static Context mContext;
    NetworkStateChecker NetChecker;
    private String _appVersion;
    private String mDeviceBrand;
    private Handler mHandler;
    private int m_Carrier;
    private String m_CarrierCode;
    private String m_CurrentAPN;
    private int m_DetailNetworkState;
    private String m_szBundleId;
    private String m_szModel;
    private String m_szSysVersion;
    private String m_szUdid;
    GCorePaths paths;
    private Thread savedMainThread;
    String strJsonConfig;
    GCoreSystem xsystem;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        try {
            System.loadLibrary("gcloud");
        } catch (Throwable th5) {
            Log.e(TAG, "GCloud loadLibrary error=" + th5.toString());
        }
        Instance = new GCloud();
    }

    GCloud() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.strJsonConfig = null;
        this.mHandler = null;
        this.savedMainThread = null;
        this.paths = new GCorePaths();
        this.xsystem = new GCoreSystem();
        this.NetChecker = new NetworkStateChecker();
        this.m_DetailNetworkState = NetworkStateChecker.DetailNetworkState.NotReachable.ordinal();
        this.m_Carrier = NetworkStateChecker.Carrier.None.ordinal();
        this.m_CarrierCode = "";
        this.m_CurrentAPN = "";
        this.m_szUdid = null;
        this.m_szBundleId = null;
        this.m_szModel = null;
        this.m_szSysVersion = null;
        this._appVersion = null;
        this.mDeviceBrand = "";
        Log.i(TAG, "GCloud()");
    }

    private void CreateMainHandler() {
        this.mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.gcloud.GCloud.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GCloud.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                Log.i(GCloud.TAG, "handleMessage Main Thread:" + GCloud.this.savedMainThread + "Current Thread:" + Thread.currentThread());
                try {
                    GCloud.this.nativePerform(Long.parseLong(message.obj.toString()));
                    return true;
                } catch (Throwable th5) {
                    Log.e(GCloud.TAG, "nativePerform call error=" + th5);
                    return true;
                }
            }
        });
        Log.i(TAG, "CreateMainHandler success:" + this.mHandler);
    }

    public static int GetResourceID(String str, String str2) {
        Context context = mContext;
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getIdentifier(str, str2, mContext.getPackageName());
        } catch (Exception unused) {
            Log.e(TAG, "GetResourceID " + str + " Error");
            return 0;
        }
    }

    private void cachePaths(Context context) {
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
                    Log.e("TX", "Create cache dir Error");
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
                    Log.e("TX", "Create cache dir Error");
                }
            }
            filesDir = externalFilesDir;
            this.paths.DataPath = filesDir.getAbsolutePath() + "/";
        }
        Log.i(TAG, "AppPath:" + this.paths.AppPath + ",CachePath:" + this.paths.CachePath + ",DataPath:" + this.paths.DataPath);
    }

    private void cacheSystemInfo(Context context) {
        this.m_szUdid = this.xsystem.GetUdid(context);
        this.m_szBundleId = this.xsystem.GetBundleId(context);
        this.m_szModel = this.xsystem.GetModel();
        this.m_szSysVersion = this.xsystem.GetSysVersion();
        this._appVersion = this.xsystem.GetAppVersion(context);
        this.mDeviceBrand = GCoreSystem.getDeviceBrand();
    }

    private void callbackFromJNI(long j3) {
        Message message = new Message();
        message.obj = Long.valueOf(j3);
        if (Thread.currentThread() == this.savedMainThread) {
            try {
                Log.i(TAG, "callbackFromJNI nativePerform Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
                nativePerform(j3);
                return;
            } catch (Throwable th5) {
                Log.e(TAG, "nativePerform call error=" + th5);
                return;
            }
        }
        Log.i(TAG, "callbackFromJNI Main Thread:" + this.savedMainThread + "Current Thread:" + Thread.currentThread());
        sendMsg(message, this.mHandler);
    }

    private int checkNetworkState() {
        return this.NetChecker.CheckNetworkState(mContext);
    }

    private native void gcloudInit(Context context, GCorePaths gCorePaths);

    private void getDetailNetworkInfo() {
        this.m_CarrierCode = "";
        this.m_Carrier = NetworkStateChecker.Carrier.None.ordinal();
        this.m_CurrentAPN = "";
        this.m_DetailNetworkState = this.NetChecker.GetDetailNetworkState(mContext);
        if (NetworkStateChecker.DetailNetworkState.ReachableViaWWAN_2G.ordinal() == this.m_DetailNetworkState || NetworkStateChecker.DetailNetworkState.ReachableViaWWAN_3G.ordinal() == this.m_DetailNetworkState || NetworkStateChecker.DetailNetworkState.ReachableViaWWAN_4G.ordinal() == this.m_DetailNetworkState || NetworkStateChecker.DetailNetworkState.ReachableViaWWAN_5G.ordinal() == this.m_DetailNetworkState || NetworkStateChecker.DetailNetworkState.ReachableViaWWAN_UNKNOWN.ordinal() == this.m_DetailNetworkState) {
            this.m_CarrierCode = this.NetChecker.GetCurrentCarrierCode(mContext);
            String GetCurrentAPN = this.NetChecker.GetCurrentAPN(mContext);
            this.m_CurrentAPN = GetCurrentAPN;
            this.m_Carrier = this.NetChecker.GetCurrentCarrier(this.m_CarrierCode, GetCurrentAPN);
        }
    }

    private native void nativeNetworkStateChangeNotify(int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativePerform(long j3);

    private synchronized void sendMsg(Message message, Handler handler) {
        Log.i(TAG, "sendMsg before sendMessage:" + this.mHandler);
        this.mHandler.sendMessage(message);
    }

    private native void setAppStatus(int i3);

    public void NetworkStateChangeNotify(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        try {
            nativeNetworkStateChangeNotify(i3);
        } catch (Throwable th5) {
            Log.e(TAG, "nativeNetworkStateChangeNotify call error=" + th5);
        }
    }

    public boolean initialize(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        mContext = context;
        cachePaths(context);
        cacheSystemInfo(mContext);
        this.savedMainThread = Thread.currentThread();
        CreateMainHandler();
        try {
            Log.i(TAG, "GCloud Init");
            gcloudInit(mContext, this.paths);
        } catch (Throwable th5) {
            Log.e(TAG, "Gcloud init error=" + th5.toString());
        }
        Log.i(TAG, "QRCoce Init");
        QRCodeAPI.getInstance().QRCodeInit();
        try {
            NetworkChangeHelper.Instance.registerNetworkListener(mContext);
        } catch (Exception e16) {
            Log.e(TAG, "initialize exception:" + e16.toString());
        }
        NetInterfaceHelper.init(mContext);
        return true;
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        Log.i(TAG, "OnActivityResult requestCode:" + i3 + " resultCode:" + i16);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Log.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        try {
            NetworkChangeHelper.Instance.unregisterNetworkListener(mContext);
            setAppStatus(5);
        } catch (Exception e16) {
            Log.e(TAG, "OnDestroy exception:" + e16.toString());
        }
    }

    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            Log.i(TAG, "OnStop");
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            Log.i(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            setAppStatus(3);
        }
    }

    public void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            Log.i(TAG, "OnRestart");
            setAppStatus(6);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            Log.i(TAG, "onResume");
            setAppStatus(2);
        }
    }

    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Log.i(TAG, "OnStart");
            setAppStatus(1);
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            Log.i(TAG, "OnStop");
            setAppStatus(4);
        }
    }
}
