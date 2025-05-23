package com.tencent.rfix.loader.engine;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.Relax;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.res.ResPatchLoader;
import com.tencent.rfix.loader.so.RFixLoadLibrary;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/* loaded from: classes25.dex */
public class QFixPatchLoader implements IPatchLoader {
    private static final int ERROR_CODE_RES_LOAD = 2000;
    private static final int ERROR_CODE_SO_LOAD = 1000;
    private static final int ERROR_CODE_UNKNOWN = -100;
    private static final String TAG = "RFix.QFixPatchLoader";
    private final Application application;

    public QFixPatchLoader(Application application) {
        this.application = application;
    }

    private boolean tryLoadResPatch(RFixLoadResult rFixLoadResult) {
        try {
            File file = new File(rFixLoadResult.patchVersionDirectory, "res");
            if (!file.exists()) {
                RFixLog.i(TAG, "tryLoadResPatch res patch not exists. resPath=" + file);
                return true;
            }
            return new ResPatchLoader().load(this.application, file.getAbsolutePath());
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoadResPatch fail.", th5);
            rFixLoadResult.subResult = 2000;
            return false;
        }
    }

    public static boolean tryLoadSoPatch(Application application, RFixLoadResult rFixLoadResult) {
        try {
            String[] strArr = {Build.CPU_ABI2, Build.CPU_ABI};
            RFixLog.i(TAG, "loadPatchSo supportedABIs=" + Arrays.toString(strArr));
            File file = null;
            for (int i3 = 0; i3 < 2; i3++) {
                String str = strArr[i3];
                if (!TextUtils.isEmpty(str)) {
                    File file2 = new File(rFixLoadResult.patchVersionDirectory, "/lib/lib/" + str);
                    if (!file2.exists()) {
                        RFixLog.i(TAG, "loadPatchSo lib patch not exists. libPath=" + file2);
                    } else {
                        ClassLoader classLoader = application.getClassLoader();
                        RFixLog.i(TAG, "loadPatchSo before hack classLoader=" + classLoader + " libPath=" + file2);
                        RFixLoadLibrary.installNativeLibraryPath(classLoader, file2);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("loadPatchSo after hack classLoader=");
                        sb5.append(classLoader);
                        RFixLog.i(TAG, sb5.toString());
                        file = file2;
                    }
                }
            }
            rFixLoadResult.patchLibDirectory = file;
            return true;
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoadSoPatch fail.", th5);
            rFixLoadResult.subResult = 1000;
            return false;
        }
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public boolean cleanPatch(File file) {
        return true;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public String getPatchType() {
        return RFixPatchInfo.PATCH_TYPE_QFIX;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public boolean loadPatch(RFixLoadResult rFixLoadResult) {
        TimeTrackType timeTrackType = TimeTrackType.PATCH_LOAD_LOADER_RES;
        TimeTracker.beginTrack(timeTrackType);
        if (!tryLoadResPatch(rFixLoadResult)) {
            return false;
        }
        TimeTracker.endTrack(timeTrackType);
        TimeTrackType timeTrackType2 = TimeTrackType.PATCH_LOAD_LOADER_SO;
        TimeTracker.beginTrack(timeTrackType2);
        if (!tryLoadSoPatch(this.application, rFixLoadResult)) {
            return false;
        }
        TimeTracker.endTrack(timeTrackType2);
        TimeTrackType timeTrackType3 = TimeTrackType.PATCH_LOAD_LOADER_DEX;
        TimeTracker.beginTrack(timeTrackType3);
        if (!tryLoadDexPath(rFixLoadResult)) {
            return false;
        }
        TimeTracker.endTrack(timeTrackType3);
        return true;
    }

    protected boolean tryLoadDexPath(RFixLoadResult rFixLoadResult) {
        int i3;
        File file;
        File file2;
        File file3;
        try {
            File file4 = new File(rFixLoadResult.patchVersionDirectory, "dex");
            file = new File(rFixLoadResult.patchVersionDirectory, RFixConstants.DEX_OPT_PATH);
            file2 = new File(file4, "classes.dex");
            file3 = new File(file4, "config.txt");
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoadDexPath fail.", th5);
            i3 = -100;
        }
        if (!file2.exists() && !file3.exists()) {
            RFixLog.i(TAG, "tryLoadDexPath not install dex patch.");
            return true;
        }
        FileInputStream fileInputStream = new FileInputStream(file3);
        if (!file.exists()) {
            file.mkdir();
        }
        i3 = Relax.apply(this.application, file2, file, fileInputStream, false, false);
        rFixLoadResult.subResult = i3;
        RFixLog.d(TAG, String.format("tryLoadDexPath applyReturn=%s", Integer.valueOf(i3)));
        if (i3 == 0) {
            return true;
        }
        return false;
    }
}
