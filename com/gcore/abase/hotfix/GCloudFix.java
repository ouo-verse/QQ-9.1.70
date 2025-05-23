package com.gcore.abase.hotfix;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.gcore.abase.utils.FileUtils;
import com.gcore.abase.utils.SDKUtils;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GCloudFix {
    private static final String TAG = "GCloud.GCloudFix";
    private static Context sContext;

    public static void cleanAllPatch() {
        FileUtils.deleteDir(new File(PatchManager.getPatchRootPath(sContext)));
    }

    public static void cleanPatch(String str) {
        FileUtils.deleteDir(new File(PatchManager.getPatchSDKPath(sContext, str)));
    }

    public static void init(Context context) {
        sContext = context;
        openSafeMode();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        loadPatch();
        Log.i(TAG, "loadPatch cost: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
        GCloudSoFix.init(context);
    }

    public static void loadPatch() {
        if (!new File(PatchManager.getPatchRootPath(sContext)).exists()) {
            Log.i(TAG, "GCloudPatch folder is not exits");
            return;
        }
        for (String str : SDKUtils.getAllSDKNames(sContext)) {
            if (new File(PatchManager.getPatchSDKPath(sContext, str)).exists()) {
                File file = new File(PatchManager.getPatchFilePath(sContext, str));
                SecurityCheck securityCheck = new SecurityCheck(sContext);
                if (!PatchCheck.checkComplete(sContext, file, securityCheck)) {
                    Log.e(TAG, "check complete failed");
                    cleanPatch(str);
                } else {
                    PatchInfo patchInfo = securityCheck.getPatchInfo();
                    List<SoInfo> soInfos = securityCheck.getSoInfos();
                    if (patchInfo == null) {
                        Log.e(TAG, "patchInfo is null");
                        return;
                    }
                    PatchManager.setPatchSoInfos(patchInfo.sdkName, soInfos);
                }
            }
        }
    }

    private static void openSafeMode() {
        if (GCloudFixConfig.useSafeMode && !PatchCheck.checkSafeModeCount(sContext)) {
            cleanAllPatch();
        }
    }

    public static void recievePatch(String str) {
        File file = new File(str);
        if (!FileUtils.isLegalFile(file)) {
            Log.e(TAG, "file is illegal " + str);
            return;
        }
        SecurityCheck securityCheck = new SecurityCheck(sContext);
        if (!PatchCheck.checkPatch(sContext, file, securityCheck)) {
            Log.e(TAG, "check patch failed");
            return;
        }
        PatchInfo patchInfo = securityCheck.getPatchInfo();
        if (patchInfo == null) {
            Log.e(TAG, "patchInfo is null");
            return;
        }
        if (!PatchManager.copyPatch(sContext, patchInfo.sdkName, file)) {
            Log.e(TAG, "copy patch failed");
            return;
        }
        List<SoInfo> soInfos = securityCheck.getSoInfos();
        if (soInfos.size() == 0) {
            return;
        }
        if (!PatchManager.excractSo(sContext, patchInfo.sdkName, soInfos)) {
            Log.e(TAG, "excract so failed");
        } else {
            PatchManager.updateSDKPatchVersion(sContext, patchInfo);
            Log.i(TAG, "patch success! reboot effect!");
        }
    }
}
