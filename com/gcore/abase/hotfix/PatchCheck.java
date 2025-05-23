package com.gcore.abase.hotfix;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.gcore.abase.utils.SDKUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class PatchCheck {
    private static final String PREFER_NAME = "GCloud";
    private static final String SAFE_MODE_COUNT_NAME = "SafeModeCoun";
    private static final int SAFE_MODE_DELAY_TIME = 5000;
    private static final int SAFE_MODE_MAX_COUNT = 3;
    private static final String TAG = "GCloud.PatchCheck";

    public static boolean checkComplete(Context context, File file, SecurityCheck securityCheck) {
        if (!file.exists()) {
            Log.e(TAG, "patch file not exist!");
            return false;
        }
        if (!securityCheck.verifyPatchMetaSignature(file)) {
            Log.e(TAG, "verifyPatchMetaSignature failed!");
            return false;
        }
        PatchInfo patchInfo = securityCheck.getPatchInfo();
        if (patchInfo == null) {
            Log.e(TAG, "patch info is null!");
            return false;
        }
        String sDKVersion = SDKUtils.getSDKVersion(context, patchInfo.sdkName);
        if (sDKVersion != null && sDKVersion.equals(patchInfo.sdkVersion)) {
            if (PatchManager.getSDKPatchVersion(context, patchInfo.sdkName, patchInfo.sdkVersion) != patchInfo.patchVersion) {
                Log.e(TAG, "patchVersion dismatch");
                return false;
            }
            return true;
        }
        Log.e(TAG, "sdkVersion dismatch");
        return false;
    }

    public static boolean checkPatch(Context context, File file, SecurityCheck securityCheck) {
        if (!securityCheck.verifyPatchMetaSignature(file)) {
            Log.e(TAG, "verifyPatchMetaSignature failed!");
            return false;
        }
        PatchInfo patchInfo = securityCheck.getPatchInfo();
        if (patchInfo == null) {
            Log.e(TAG, "patch info is null!");
            return false;
        }
        String sDKVersion = SDKUtils.getSDKVersion(context, patchInfo.sdkName);
        if (sDKVersion != null && sDKVersion.equals(patchInfo.sdkVersion)) {
            if (PatchManager.getSDKPatchVersion(context, patchInfo.sdkName, patchInfo.sdkVersion) == patchInfo.patchVersion) {
                Log.e(TAG, "patch is already exits");
                return false;
            }
            return true;
        }
        Log.e(TAG, "sdkVersion dismatch");
        return false;
    }

    public static boolean checkSafeModeCount(final Context context) {
        int safeModeCount = getSafeModeCount(context);
        if (safeModeCount >= 2) {
            setSafeModeCount(context, 0);
            return false;
        }
        setSafeModeCount(context, safeModeCount + 1);
        new Handler().postDelayed(new Runnable() { // from class: com.gcore.abase.hotfix.PatchCheck.1
            @Override // java.lang.Runnable
            public void run() {
                PatchCheck.setSafeModeCount(context, 0);
            }
        }, 5000L);
        return true;
    }

    public static int getSafeModeCount(Context context) {
        int i3 = context.getSharedPreferences(PREFER_NAME, 0).getInt(SAFE_MODE_COUNT_NAME, 0);
        Log.w(TAG, "getSafeModeCount: " + i3);
        return i3;
    }

    public static void setSafeModeCount(Context context, int i3) {
        context.getSharedPreferences(PREFER_NAME, 0).edit().putInt(SAFE_MODE_COUNT_NAME, i3).commit();
        Log.w(TAG, "setSafeModeCount: " + i3);
    }
}
