package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes21.dex */
public class SharedPreferencesProxyManager {
    private static final int LOCK_BUCKET_SIZE = 8;
    private static final String LOG_TAG = "SharedPreferencesProxyManager";
    private static volatile SharedPreferencesProxyManager sInstance = null;
    static boolean sIsCrashing = false;
    static boolean sIsDebugVersion = false;
    static ISpLogCallback sLogCallback;
    public static String sSystemSpExceptionMsg;
    IAdapter adapter;
    private Map<String, SharedPreferences> mLocalSPs = new ConcurrentHashMap(5);
    private Map<String, SharedPreferences> mRemoteSPs = new ConcurrentHashMap(5);
    private final Object[] mLocksBucket = new Object[8];
    private WeakReference<Context> mBoundContext = null;

    /* loaded from: classes21.dex */
    public interface IAdapter {
        SharedPreferences getSystemSharedPreferences(String str, int i3);
    }

    /* loaded from: classes21.dex */
    public interface ISpLogCallback {
        void onIllegalModify(String str, String str2, Object obj);

        void printLog(boolean z16, String str, String str2, Exception exc);
    }

    SharedPreferencesProxyManager() {
    }

    public static SharedPreferencesProxyManager getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (SharedPreferencesProxyManager.class) {
            if (sInstance == null) {
                sInstance = new SharedPreferencesProxyManager();
            }
        }
        return sInstance;
    }

    private void printLog(boolean z16, String str, String str2, Exception exc) {
        ISpLogCallback iSpLogCallback = sLogCallback;
        if (iSpLogCallback != null) {
            iSpLogCallback.printLog(z16, str, str2, exc);
        }
    }

    private SharedPreferencesProxyManager realInit(Context context, String str, IAdapter iAdapter) {
        printLog(true, "SpManager", "init " + context, null);
        this.adapter = iAdapter;
        if (context == null) {
            printLog(true, "SpManager", "init context is null", new RuntimeException());
            if (sIsDebugVersion) {
                throw new RuntimeException("init context is null");
            }
        }
        if (this.mBoundContext == null && context != null) {
            if (TextUtils.isEmpty(str)) {
                Utils.initCurrentProcessName(context);
            } else {
                Utils.initCurrentProcessName(context, str);
            }
            this.mBoundContext = new WeakReference<>(context);
        }
        for (int i3 = 0; i3 < 8; i3++) {
            this.mLocksBucket[i3] = new Object();
        }
        return this;
    }

    public static void setLogCallback(ISpLogCallback iSpLogCallback) {
        sLogCallback = iSpLogCallback;
    }

    public SharedPreferences getProxy(String str, int i3) {
        return getProxyInner(str, i3, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences getProxyInner(String str, int i3, boolean z16) {
        Map<String, SharedPreferences> map;
        if (str == null) {
            str = "null";
        }
        if ((i3 & 4) == 4 && !Utils.sIsSameProcessAsCP) {
            if ("set_sp_mp".equals(str)) {
                QLog.i(LOG_TAG, 1, "getProxyInner from mRemoteSPs");
            }
            map = this.mRemoteSPs;
        } else {
            if ("set_sp_mp".equals(str)) {
                QLog.i(LOG_TAG, 1, "getProxyInner from mLocalSPs");
            }
            map = this.mLocalSPs;
        }
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences == null) {
            synchronized (this.mLocksBucket[Math.abs(str.hashCode() % 8)]) {
                sharedPreferences = map.get(str);
                if (sharedPreferences == null) {
                    sharedPreferences = new SharedPreferencesProxy(this.mBoundContext, str, i3, z16);
                    map.put(str, sharedPreferences);
                }
            }
        }
        return sharedPreferences;
    }

    public synchronized SharedPreferencesProxyManager init(Context context, IAdapter iAdapter) {
        return realInit(context, null, iAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMonitored() {
        if (sLogCallback != null) {
            return true;
        }
        return false;
    }

    public void onCrashStart() {
        sIsCrashing = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onModifySp(String str, String str2, Object obj) {
        ISpLogCallback iSpLogCallback = sLogCallback;
        if (iSpLogCallback != null) {
            iSpLogCallback.onIllegalModify(str, str2, obj);
        }
    }

    public synchronized SharedPreferencesProxyManager init(Context context, boolean z16, IAdapter iAdapter) {
        sIsDebugVersion = z16;
        return realInit(context, null, iAdapter);
    }

    public synchronized SharedPreferencesProxyManager init(Context context, String str, IAdapter iAdapter) {
        return realInit(context, str, iAdapter);
    }

    public synchronized SharedPreferencesProxyManager init(Context context, boolean z16, String str, IAdapter iAdapter) {
        sIsDebugVersion = z16;
        return realInit(context, str, iAdapter);
    }

    public void setCatLogEnabled(boolean z16) {
    }

    public void setTimeLogEnabled(boolean z16) {
    }
}
