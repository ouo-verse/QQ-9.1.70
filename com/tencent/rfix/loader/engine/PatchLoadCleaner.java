package com.tencent.rfix.loader.engine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* loaded from: classes25.dex */
public class PatchLoadCleaner {
    private static final String TAG = "RFix.PatchLoadCleaner";
    private final Context context;
    private final IPatchLoadEngine patchLoadEngine;

    public PatchLoadCleaner(Context context, IPatchLoadEngine iPatchLoadEngine) {
        this.context = context;
        this.patchLoadEngine = iPatchLoadEngine;
    }

    public void cleanInvalidPatch(RFixLoadResult rFixLoadResult) {
        String[] list;
        String str;
        boolean isInMainProcess = ProcessUtils.isInMainProcess(this.context);
        File patchDirectory = PatchFileUtils.getPatchDirectory(this.context);
        if (isInMainProcess && patchDirectory.exists() && (list = patchDirectory.list()) != null && list.length != 0) {
            File file = rFixLoadResult.patchVersionDirectory;
            if (file != null) {
                str = file.getName();
            } else {
                str = null;
            }
            RFixLog.i(TAG, String.format("cleanInvalidPatch excludePatchDirectory=%s", str));
            deleteInvalidPatch(patchDirectory, list, str);
        }
    }

    protected void deleteInvalidPatch(File file, String[] strArr, String str) {
        String str2;
        if (file != null && strArr != null && strArr.length != 0) {
            for (String str3 : strArr) {
                File file2 = new File(file, str3);
                if (file2.isDirectory() && str3.startsWith(RFixConstants.PATCH_NAME_PREFIX) && !TextUtils.equals(str, str3)) {
                    if (new File(new File(file2, RFixConstants.APK_PATH), RFixConstants.APK_TINKER_NAME).exists()) {
                        str2 = RFixPatchInfo.PATCH_TYPE_TINKER;
                    } else {
                        str2 = RFixPatchInfo.PATCH_TYPE_QFIX;
                    }
                    deletePatch(file2, str2);
                }
            }
        }
    }

    protected void deletePatch(File file, String str) {
        IPatchLoader loader = this.patchLoadEngine.getLoader(str);
        if (loader != null) {
            RFixLog.i(TAG, String.format("deletePatch loader clean patch result=%s", Boolean.valueOf(loader.cleanPatch(file))));
        }
        PatchFileUtils.deleteFile(file);
        RFixLog.i(TAG, String.format("deletePatch delete file patchVersionDirectory=%s", file.getAbsolutePath()));
    }
}
