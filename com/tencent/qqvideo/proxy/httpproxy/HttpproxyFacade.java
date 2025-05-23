package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.common.ConfigStorage;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class HttpproxyFacade {
    private static final int DOWNLOAD_CALLBACK_MSG = 1;
    private static final int LOG_DEBUG = 20;
    private static final int LOG_ERROR = 100;
    private static final int LOG_INFO = 40;
    private static final int LOG_VERBOSE = 0;
    private static final int LOG_WARN = 80;
    private static String TAG = "TV_Httpproxy";
    private static final String dev_type = "2";
    private static Context mContext = null;
    private static final Handler mDownloadCallBackHandler = new a(Looper.getMainLooper());
    private static HttpproxyFacade mInstance = null;
    private static boolean mbHttpProxyExist = false;
    private IUtils mUtils = null;

    HttpproxyFacade() {
    }

    public static void downloadCallBack(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            mDownloadCallBackHandler.sendMessage(obtain);
        } catch (Throwable unused) {
            print(6, TAG, "downloadCallBack exception");
        }
    }

    public static void idKeyReport(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                Log.d(TAG, "idKeyReport:id=" + str + ",key=" + str2 + ",value=" + str3);
                instance.mUtils.idKeyReport(str, str2, str3);
            }
        } catch (Throwable unused) {
            print(6, TAG, "idKeyReport exception");
        }
    }

    public static synchronized HttpproxyFacade instance() {
        HttpproxyFacade httpproxyFacade;
        synchronized (HttpproxyFacade.class) {
            if (mInstance == null) {
                mInstance = new HttpproxyFacade();
            }
            httpproxyFacade = mInstance;
        }
        return httpproxyFacade;
    }

    public static boolean isLoadSuccess() {
        return mbHttpProxyExist;
    }

    public static synchronized void javaUtilLog(int i3, String str) {
        int i16;
        synchronized (HttpproxyFacade.class) {
            IUtils iUtils = instance().mUtils;
            if (iUtils != null) {
                if (i3 != 0) {
                    i16 = 3;
                    if (i3 != 20) {
                        if (i3 == 40) {
                            i16 = 4;
                        } else if (i3 == 80) {
                            i16 = 5;
                        } else if (i3 == 100) {
                            i16 = 6;
                        }
                    }
                } else {
                    i16 = 2;
                }
                iUtils.javaUtilLog(i16, TAG, str);
            } else {
                Log.e(TAG, "IUtils.javaUtilLog not init " + str);
            }
        }
    }

    public static void jsonReport(String str) {
        try {
            String deviceID = VcSystemInfo.getDeviceID(mContext);
            String osVersion = VcSystemInfo.getOsVersion();
            int netWorkType = VcSystemInfo.getNetWorkType(mContext);
            String str2 = "";
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) mContext.getSystemService("wifi"));
            if (NetworkMonitor.getBSSID(connectionInfo) != null) {
                str2 = String.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5));
            }
            String httpProxyVersion = ConfigStorage.getHttpProxyVersion();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("dev_id", deviceID);
            jSONObject.put("dev_type", "2");
            jSONObject.put("os_ver", osVersion);
            jSONObject.put("net_type", netWorkType);
            jSONObject.put("net_stren", str2);
            jSONObject.put("config_ver", configVersion);
            jSONObject.put("proxy_ver", httpProxyVersion);
            String jSONObject2 = jSONObject.toString();
            Log.d(TAG, "IUtils.MTA_Report:" + jSONObject2);
            String replace = jSONObject2.replace(",", ";");
            if (TextUtils.isEmpty(replace)) {
                return;
            }
            HttpproxyFacade instance = instance();
            if (instance.mUtils != null) {
                if (replace.length() <= 1000) {
                    instance.mUtils.httpproxyReport(replace);
                    return;
                }
                int length = replace.length();
                if (length > 2000) {
                    length = 2000;
                }
                instance.mUtils.httpproxyReport(replace.substring(0, 1000), replace.substring(1000, length));
                return;
            }
            Log.e(TAG, "IUtils.MTA_Report:" + replace);
        } catch (Throwable unused) {
            print(6, TAG, "reportMTA exception");
        }
    }

    public static void print(int i3, String str, String str2) {
        IUtils iUtils = instance().mUtils;
        if (iUtils != null) {
            iUtils.javaUtilLog(i3, str, str2);
            return;
        }
        Log.e(TAG, "IUtils.javaUtilLog not init " + str2);
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public native String buildClipPlayURL(int i3, int i16);

    public native String buildPlayURL(int i3);

    public native int cleanMemory();

    public native int cleanStorage();

    public native void deinit();

    public native int deleteClipFileOnDisk(String str, int i3);

    public native int deleteFileOnDisk(String str);

    public native long getClipFileSizeOnDisk(String str, int i3);

    public native long getCurrentOffset(int i3);

    public native int getLocalServerPort();

    public native long getTotalOffset(int i3);

    public native String getVersion();

    public native int init(String str, String str2);

    public native boolean isClipCompleteOnDisk(String str, int i3);

    public native int pauseAllPreLoad();

    public native int pauseStorageIO();

    public native int preLoad(int i3, int i16);

    public native int preLoadClip(int i3, int i16, int i17, boolean z16, int i18);

    public native void pushEvent(int i3);

    public native int resumeAllPreLoad();

    public native int resumeStorageIO();

    public native int setClipInfo(int i3, int i16, String str, long j3, int i17);

    public native void setCookie(String str);

    public native void setHttpLowSpeedParams(int i3, int i16);

    public native int setMaxMemorySize(long j3);

    public native int setMaxStorageSize(long j3);

    public native void setNetWorkState(int i3);

    public native void setPlayerState(int i3, int i16);

    public native void setRemainTime(int i3, int i16);

    public void setUtils(IUtils iUtils) {
        this.mUtils = iUtils;
    }

    public native int startPlay(String str, int i3, String str2, long j3, int i16);

    public native int startPlayEx(int i3, String str, boolean z16, int i16);

    public native int startPreLoad(int i3, String str, boolean z16, int i16);

    public native int stopAllPreLoad();

    public native void stopPlay(int i3);

    public native int stopPreLoad(int i3);

    public static void kvReport(String str) {
        try {
            String httpProxyVersionCode = ConfigStorage.getHttpProxyVersionCode();
            String configVersion = ConfigStorage.getConfigVersion();
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("DownloadResult");
            String optString2 = jSONObject.optString("OptimalCDN");
            String optString3 = jSONObject.optString("VideoRate");
            String optString4 = jSONObject.optString("VideoTotalFileLength");
            String optString5 = jSONObject.optString("VideoContentLength");
            String optString6 = jSONObject.optString("DownloadTotalFlow");
            String optString7 = jSONObject.optString("DownloadCostTime");
            String optString8 = jSONObject.optString("DownloadAverageSpeed");
            String optString9 = jSONObject.optString("DownloaaxSpeed");
            String optString10 = jSONObject.optString("DownloainSpeed");
            IUtils iUtils = instance().mUtils;
            if (iUtils != null) {
                iUtils.kvReport(optString, optString2, httpProxyVersionCode, configVersion, optString3, optString4, optString5, optString6, optString7, optString8, optString9, optString10);
            }
        } catch (Throwable unused) {
            print(6, TAG, "kvReport exception");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            try {
                String str = (String) message.obj;
                if (message.what != 1 || str == null || TextUtils.isEmpty(str)) {
                    return;
                }
                HttpproxyFacade instance = HttpproxyFacade.instance();
                if (instance.mUtils != null) {
                    Log.d(HttpproxyFacade.TAG, "downloadCallBack:" + str);
                    instance.mUtils.downloadCallBack(str);
                }
            } catch (Throwable unused) {
                HttpproxyFacade.print(6, HttpproxyFacade.TAG, "downloadCallBack handle exception");
            }
        }
    }
}
