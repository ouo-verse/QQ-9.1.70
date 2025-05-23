package com.tencent.ark;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkEnvironmentManager {
    private static final String PREF_APP_BIZ_CONFIG = "ArkAppBizConfig";
    private static final String PREF_APP_BIZ_CONFIG_DEBUG = "ArkAppBizConfigDebug";
    private static final String PREF_APP_CACHE_CONFIG = "ArkAppCacheConfig";
    private static final String PREF_APP_CACHE_CONFIG_DEBUG = "ArkAppCacheConfigDebug";
    private static final String PREF_APP_SERVER_CONFIG = "ArkAppServerConfig";
    private static final String PREF_APP_SERVER_CONFIG_DEBUG = "ArkAppServerConfigDebug";
    public static final String TAG = "ArkApp";
    private static final String TAG_INNER = "ArkApp.Environment";
    private String mCurUin;
    private IDataReport mDataReport;
    boolean mIsAccelerationChecked;
    boolean mIsDebug;
    boolean mIsHardwareAcceleration;
    private boolean mIsTestEnv;
    private LibraryLoader mLoader;
    private String mQQVersion;
    private String mRootDirectory;
    boolean mShowFps;
    boolean mShowProfilingLog;
    boolean mShowVsyncLog;
    private ThreadCreater mThreadCreater;
    boolean mUseSingleThread;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IDataReport {
        void dtReport(String str, Map<String, String> map);

        void report(String str, String str2, boolean z16, int i3, Map<String, String> map);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class LazyHolder {
        static final ArkEnvironmentManager gInstance = new ArkEnvironmentManager();

        LazyHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LibraryLoader {
        boolean Load();

        boolean isLibraryLoad();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class LoadLibraryTask implements Runnable {
        LoadLibraryTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArkEnvironmentManager.getInstance().loadLibraryImpl();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ThreadCreater {
        HandlerThread createHandlerThread(String str);
    }

    public static String GetMinSdkVersion() {
        return StringUtil.format("%d", Integer.valueOf(ark.arkGetMinPlatformVersion()));
    }

    public static String GetPlatformBuildNumber() {
        return StringUtil.format("%ld", Long.valueOf(ark.arkGetPlatformBuildNumber()));
    }

    public static String GetSdkVersion() {
        return StringUtil.format("%d", Integer.valueOf(ark.arkGetPlatformVersion()));
    }

    public static ArkEnvironmentManager getInstance() {
        return LazyHolder.gInstance;
    }

    public HandlerThread createHandlerThread(String str) {
        ThreadCreater threadCreater = this.mThreadCreater;
        if (threadCreater != null) {
            return threadCreater.createHandlerThread(str);
        }
        return null;
    }

    public boolean disableHardwareRendering() {
        if (this.mIsAccelerationChecked && this.mIsHardwareAcceleration) {
            return false;
        }
        this.mIsAccelerationChecked = true;
        this.mIsHardwareAcceleration = false;
        return true;
    }

    public void doDataReport(String str, String str2, boolean z16, int i3, Map<String, String> map) {
        IDataReport iDataReport = this.mDataReport;
        if (iDataReport != null) {
            iDataReport.report(str, str2, z16, i3, map);
        }
    }

    public void dtReport(String str, Map<String, String> map) {
        IDataReport iDataReport = this.mDataReport;
        if (iDataReport != null) {
            iDataReport.dtReport(str, map);
        }
    }

    public String getAppIconDirectory() {
        return this.mRootDirectory + "/Icon";
    }

    public String getAppInstallDirectory() {
        return this.mRootDirectory + "/Install";
    }

    public String getAppResPath(String str) {
        String str2 = getResDirectory() + "/" + str;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public String getCGIDomain() {
        if (this.mIsDebug) {
            return "test.ark.qq.com";
        }
        return "cgi.ark.qq.com";
    }

    public String getCacheDirectory() {
        return this.mRootDirectory + "/Cache";
    }

    public String getCurrentUin() {
        if (!TextUtils.isEmpty(this.mCurUin) && !"0".equals(this.mCurUin)) {
            return this.mCurUin;
        }
        return "";
    }

    public boolean getDebugFlag() {
        return this.mIsDebug;
    }

    public String getProxyHost() {
        return System.getProperty("http.proxyHost");
    }

    public int getProxyPort() {
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public String getQQVersion() {
        if (!TextUtils.isEmpty(this.mQQVersion)) {
            return this.mQQVersion;
        }
        return "";
    }

    public String getResDirectory() {
        return this.mRootDirectory + "/Res";
    }

    public String getRootDirectory() {
        return this.mRootDirectory;
    }

    public String getStorageDirectory() {
        return this.mRootDirectory + "/Storage";
    }

    public boolean isEGLSpecialDeviceLimited() {
        return EGLContextHolder.isSpecialDeviceLimited();
    }

    public boolean isHardwareAcceleration() {
        if (!this.mIsAccelerationChecked) {
            synchronized (this) {
                if (!this.mIsAccelerationChecked) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mIsHardwareAcceleration = EGLContextHolder.isDeviceSupported();
                    Logger.logI(TAG_INNER, String.format("isHardwareAcceleration, %s, time=%d", Boolean.valueOf(this.mIsHardwareAcceleration), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    this.mIsAccelerationChecked = true;
                }
            }
        }
        return this.mIsHardwareAcceleration;
    }

    public boolean isLibraryLoad() {
        LibraryLoader libraryLoader = this.mLoader;
        if (libraryLoader != null) {
            return libraryLoader.isLibraryLoad();
        }
        return false;
    }

    public boolean isSingleThreadMode() {
        return this.mUseSingleThread;
    }

    public boolean isTestEnv() {
        return this.mIsTestEnv;
    }

    public boolean loadLibrary() {
        if (!isLibraryLoad()) {
            loadLibraryImpl();
        }
        return isLibraryLoad();
    }

    protected boolean loadLibraryImpl() {
        LibraryLoader libraryLoader = this.mLoader;
        if (libraryLoader == null || !libraryLoader.Load()) {
            return false;
        }
        ark.SetEnvironmentManager(this);
        return true;
    }

    public void setCurrentUin(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mCurUin = str;
        }
    }

    public void setDataReport(IDataReport iDataReport) {
        this.mDataReport = iDataReport;
    }

    public void setDebugFlag(boolean z16) {
        this.mIsDebug = z16;
        ArkUtil.checkVersion(z16);
    }

    public void setEnableShowFps(boolean z16) {
        this.mShowFps = z16;
    }

    public void setEnv(boolean z16) {
        this.mIsTestEnv = z16;
        Logger.logI("ArkApp", "ArkEnvironmentManager setEnv Type isTestEnv =" + z16);
    }

    public void setHardwareDisableList(JSONObject jSONObject) {
        EGLContextHolder.setDeviceMatcher(jSONObject);
    }

    public void setLibraryLoader(LibraryLoader libraryLoader) {
        this.mLoader = libraryLoader;
    }

    public void setLogCallback(ILog iLog) {
        Logger.setLogCallback(iLog);
    }

    public void setProfilingLogFlag(boolean z16) {
        this.mShowProfilingLog = z16;
    }

    public void setQQVersion(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mQQVersion = str;
        }
    }

    public void setRootDirecotry(String str) {
        this.mRootDirectory = str;
    }

    public void setSingleThreadMode(boolean z16) {
        this.mUseSingleThread = z16;
    }

    public void setThreadCreator(ThreadCreater threadCreater) {
        this.mThreadCreater = threadCreater;
    }

    public void setThreadMode() {
        if (isLibraryLoad()) {
            if (isSingleThreadMode()) {
                ArkDispatchQueue.setDefaultAttribute(1);
                Logger.logI(TAG_INNER, "setThreadMode, single thread mode");
                return;
            } else {
                ArkDispatchQueue.setDefaultAttribute(4);
                Logger.logI(TAG_INNER, "setThreadMode, multiple thread mode");
                return;
            }
        }
        Logger.logI(TAG_INNER, "setThreadMode, library not load");
    }

    public void setUseVirtualContext(boolean z16) {
        EGLContextHolder.setVirtualContext(z16);
    }

    public void setVsyncLogFlag(boolean z16) {
        this.mShowVsyncLog = z16;
    }

    ArkEnvironmentManager() {
        this.mIsDebug = false;
        this.mShowVsyncLog = false;
        this.mShowFps = false;
        this.mShowProfilingLog = false;
        this.mIsHardwareAcceleration = false;
        this.mIsAccelerationChecked = false;
        this.mUseSingleThread = true;
        this.mIsTestEnv = false;
    }
}
