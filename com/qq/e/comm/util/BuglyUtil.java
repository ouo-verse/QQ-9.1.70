package com.qq.e.comm.util;

import android.content.SharedPreferences;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BuglyUtil {
    private static final String APP_ID = "81b471756a";
    private static volatile BuglyUtil INSTANCE = null;
    private static final String PREFERENCE_NAME = "BuglySdkInfos";
    private static final String SDK_VERSION = SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion();

    BuglyUtil() {
    }

    private void clearBuglyInfo() {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.remove(APP_ID);
        edit.apply();
    }

    public static BuglyUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (BuglyUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BuglyUtil();
                }
            }
        }
        return INSTANCE;
    }

    private void setBuglyInfo() {
        SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString(APP_ID, SDK_VERSION);
        edit.apply();
    }

    public void setUp() {
        try {
            setBuglyInfo();
        } catch (Exception e16) {
            GDTLogger.d("Bugly Init encounter exception: " + e16.getMessage());
        }
    }
}
