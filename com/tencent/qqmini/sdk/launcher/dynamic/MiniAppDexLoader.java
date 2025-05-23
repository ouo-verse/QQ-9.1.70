package com.tencent.qqmini.sdk.launcher.dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniCrashHandler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniAppDexLoader {
    public static final String MAIN_KEY_MINI_APP = "qqminiapp";
    public static final String MINI_APP_GOOGLE_PLAY_LOAD_SO_SWITCH = "mini_app_google_play_load_so_switch";
    public static final String TAG = "minisdk-MiniAppDexLoader";
    private static volatile MiniAppDexLoader instance;
    private static volatile byte[] lock = new byte[0];
    protected Context mContext;
    private MiniDexConfig mDexConfig;
    private String mDexConfigStr;
    private ClassLoader mNewClassLoader;
    private boolean mDexEnable = true;
    private boolean mIsLocalDexEnable = false;
    private boolean mDexLoaded = false;

    public static MiniAppDexLoader g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppDexLoader();
                }
            }
        }
        return instance;
    }

    private String getDexPath() {
        if (this.mIsLocalDexEnable && new File("/data/local/tmp/miniapp/sdk.jar").exists()) {
            QMLog.d(TAG, "getDexPath: use local Dex!");
            return "/data/local/tmp/miniapp/sdk.jar";
        }
        if (TextUtils.isEmpty(this.mDexConfigStr)) {
            QMLog.w(TAG, "Dex Config is empty.");
            return null;
        }
        MiniDynamicManager.g().updateDexConfig(this.mDexConfigStr);
        MiniDexConfig validDexConfig = MiniDynamicManager.g().getValidDexConfig();
        if (validDexConfig == null) {
            return null;
        }
        this.mDexConfig = validDexConfig;
        return validDexConfig.getDexPath();
    }

    public Object create(String str) {
        try {
            if (this.mNewClassLoader == null) {
                loadDex();
            }
            QMLog.i(TAG, " MiniAppDexLoader : " + str);
            ClassLoader classLoader = this.mNewClassLoader;
            if (classLoader != null) {
                Object obj = Reflect.on(str, classLoader).create().get();
                QMLog.i(TAG, " MiniAppDexLoader : " + str + " obj:" + obj);
                return obj;
            }
            return Reflect.on(str, getClass().getClassLoader()).create().get();
        } catch (Exception e16) {
            QMLog.w(TAG, " MiniAppDexLoader create: " + str + " failed." + e16.getMessage());
            try {
                return Reflect.on(str, getClass().getClassLoader()).create().get();
            } catch (Throwable unused) {
                QMLog.w(TAG, " MiniAppDexLoader create: " + str + " failed.", e16);
                return null;
            }
        }
    }

    public Class findClass(String str) {
        try {
            if (this.mNewClassLoader == null) {
                loadDex();
            }
            QMLog.i(TAG, " MiniAppDexLoader findClass: " + str);
            ClassLoader classLoader = this.mNewClassLoader;
            if (classLoader != null) {
                Class<?> loadClass = classLoader.loadClass(str);
                QMLog.i(TAG, " MiniAppDexLoader findClass: " + str + " Class:" + loadClass);
                return loadClass;
            }
            return getClass().getClassLoader().loadClass(str);
        } catch (Exception e16) {
            QMLog.w(TAG, " MiniAppDexLoader findClass: " + str + " failed." + e16.getMessage());
            try {
                return getClass().getClassLoader().loadClass(str);
            } catch (Throwable unused) {
                QMLog.w(TAG, " MiniAppDexLoader findClass: " + str + " failed.", e16);
                return null;
            }
        }
    }

    public MiniDexConfig getDexConfig() {
        return this.mDexConfig;
    }

    public boolean hasNewDex() {
        String dexPath = getDexPath();
        if (TextUtils.isEmpty(dexPath)) {
            QMLog.i(TAG, "There's not a dex to be loaded.");
            return false;
        }
        if (!new File(dexPath).exists()) {
            return false;
        }
        QMLog.i(TAG, "load dexPath : " + dexPath);
        return true;
    }

    public void init(Context context, boolean z16, String str, boolean z17) {
        this.mContext = context;
        this.mDexEnable = z16;
        this.mDexConfigStr = str;
        this.mIsLocalDexEnable = z17;
        QMLog.w(TAG, "enableDex: " + z16 + " dexConfig:" + this.mDexConfigStr);
    }

    public synchronized void loadDex() {
        if (this.mDexEnable && !this.mDexLoaded && this.mContext != null) {
            if (hasNewDex() && this.mNewClassLoader == null) {
                this.mNewClassLoader = new MiniAppClassloader(getDexPath(), this.mContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader());
            }
            if (!AppLoaderFactory.g().isMainProcess()) {
                Thread.setDefaultUncaughtExceptionHandler(new MiniCrashHandler());
            }
            this.mDexLoaded = true;
        }
    }
}
