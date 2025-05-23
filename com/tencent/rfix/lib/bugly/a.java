package com.tencent.rfix.lib.bugly;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static void a(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (name.startsWith("patch_tag_flag_") && !name.equals(str)) {
                    file2.delete();
                }
            }
        }
    }

    public static void b(Context context) {
        if (!ProcessUtils.isInMainProcess(context)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString("425f7fa217", "1.2.4-beta4-SNAPSHOT");
            edit.apply();
        } catch (Exception e16) {
            RFixLog.e("RFix.BuglyInitializer", "initialize fail!", e16);
        }
    }

    public static void c(Context context, RFixLoadResult rFixLoadResult) {
        String str;
        RFixPatchInfo rFixPatchInfo;
        int i3;
        if (!ProcessUtils.isInMainProcess(context)) {
            return;
        }
        try {
            boolean isLoaderSuccess = rFixLoadResult.isLoaderSuccess();
            if (isLoaderSuccess) {
                str = "1";
            } else {
                str = "0";
            }
            String str2 = "";
            if (isLoaderSuccess && (rFixPatchInfo = rFixLoadResult.patchInfo) != null && (i3 = rFixPatchInfo.configId) != 0) {
                str2 = String.valueOf(i3);
            }
            String str3 = "patch_tag_flag_" + str + "_" + str2;
            File patchDirectory = PatchFileUtils.getPatchDirectory(context);
            File file = new File(patchDirectory, str3);
            if (!file.exists()) {
                RFixLog.d("RFix.BuglyInitializer", "updatePatchTag inHotFix=" + str + " patchVersion=" + str2);
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.BUGLY_SHARED_PREFERENCES, 0).edit();
                edit.putString(Constants.BASE_IN_HOTFIX, str);
                edit.putString(Constants.HOT_PATCH_NUM, str2);
                edit.apply();
                file.getParentFile().mkdirs();
                file.createNewFile();
                a(patchDirectory, str3);
            }
        } catch (Exception e16) {
            RFixLog.e("RFix.BuglyInitializer", "updatePatchTag fail!", e16);
        }
    }
}
