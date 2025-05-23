package com.tencent.rfix.loader.engine;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.safemode.RFixSafeModeKeeper;
import com.tencent.rfix.loader.storage.RFixGlobalPreferences;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.ManifestUtils;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.rfix.loader.verify.RemoteVerifyTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes25.dex */
public class PatchLoadEngineBase implements IPatchLoadEngine {
    private static final String TAG = "RFix.PatchLoadEngineBase";
    protected Application application;
    protected PatchLoadCleaner cleaner;
    protected Map<String, IPatchLoader> loaders = new HashMap();

    public PatchLoadEngineBase(Application application) {
        this.application = application;
        this.cleaner = new PatchLoadCleaner(application, this);
        initLoaders();
    }

    private RFixConstants.LoadResult checkPatchVersion(String str, RFixLoadResult rFixLoadResult) {
        RFixPatchInfo rFixPatchInfo = rFixLoadResult.patchInfo;
        File patchVersionDirectory = PatchFileUtils.getPatchVersionDirectory(str, rFixPatchInfo.version);
        if (patchVersionDirectory != null && patchVersionDirectory.exists()) {
            File patchVersionFile = PatchFileUtils.getPatchVersionFile(str, rFixPatchInfo.version);
            if (patchVersionFile != null && patchVersionFile.exists()) {
                rFixLoadResult.patchVersionDirectory = patchVersionDirectory;
                rFixLoadResult.patchVersionFile = patchVersionFile;
                return RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
            }
            return RFixConstants.LoadResult.LOAD_RESULT_PATCH_VERSION_NOT_EXIST;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_PATCH_VERSION_NOT_EXIST;
    }

    protected RFixConstants.LoadResult checkPatch(RFixLoadResult rFixLoadResult) {
        File patchDirectory = PatchFileUtils.getPatchDirectory(this.application);
        String absolutePath = patchDirectory.getAbsolutePath();
        checkUnfinishedPatchInstall(absolutePath);
        RFixConstants.LoadResult checkPatchInfo = checkPatchInfo(patchDirectory, rFixLoadResult);
        RFixConstants.LoadResult loadResult = RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
        if (checkPatchInfo != loadResult) {
            return checkPatchInfo;
        }
        if (!ProcessUtils.isInPatchProcess(this.application) && checkProcessEnable(rFixLoadResult)) {
            RFixConstants.LoadResult checkPatchVerified = checkPatchVerified(rFixLoadResult);
            if (checkPatchVerified != loadResult) {
                return checkPatchVerified;
            }
            RFixConstants.LoadResult checkPatchVersion = checkPatchVersion(absolutePath, rFixLoadResult);
            if (checkPatchVersion != loadResult) {
                return checkPatchVersion;
            }
            RFixConstants.LoadResult checkPatchSafeMode = checkPatchSafeMode(rFixLoadResult);
            if (checkPatchSafeMode != loadResult) {
                return checkPatchSafeMode;
            }
            RFixConstants.LoadResult checkPatchLoader = checkPatchLoader(rFixLoadResult);
            if (checkPatchLoader != loadResult) {
                return checkPatchLoader;
            }
            return loadResult;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_PROCESS_DISABLE;
    }

    protected RFixConstants.LoadResult checkPatchInfo(File file, RFixLoadResult rFixLoadResult) {
        if (file != null && file.exists()) {
            RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.application);
            rFixLoadResult.patchInfo = rFixPatchInfo;
            if (TextUtils.isEmpty(rFixPatchInfo.version)) {
                if (rFixPatchInfo.lastConfigId <= 0) {
                    return RFixConstants.LoadResult.LOAD_RESULT_PATCH_INFO_BLANK;
                }
                int i3 = rFixPatchInfo.lastDownloadResult;
                if (i3 < 0) {
                    rFixLoadResult.subResult = i3;
                    return RFixConstants.LoadResult.LOAD_RESULT_PATCH_DOWNLOAD_FAIL;
                }
                rFixLoadResult.subResult = rFixPatchInfo.lastInstallResult;
                return RFixConstants.LoadResult.LOAD_RESULT_PATCH_INSTALL_FAIL;
            }
            if (needCleanPatch(this.application, rFixPatchInfo)) {
                if (ProcessUtils.isInMainProcess(this.application)) {
                    cleanPatch(rFixPatchInfo);
                }
                return RFixConstants.LoadResult.LOAD_RESULT_PATCH_REMOVED;
            }
            return RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_PATCH_INFO_BLANK;
    }

    protected RFixConstants.LoadResult checkPatchLoader(RFixLoadResult rFixLoadResult) {
        String str = rFixLoadResult.patchInfo.patchType;
        if (getLoader(str) == null) {
            RFixLog.e(TAG, String.format("no loader support. patchType=%s", str));
            return RFixConstants.LoadResult.LOAD_RESULT_NO_LOADER_SUPPORT;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
    }

    protected RFixConstants.LoadResult checkPatchSafeMode(RFixLoadResult rFixLoadResult) {
        boolean z16;
        int checkSafeMode;
        RFixSafeModeKeeper.Strategy strategy = RFixSafeModeKeeper.getStrategy();
        if (strategy == RFixSafeModeKeeper.Strategy.MAIN_PROCESS) {
            z16 = ProcessUtils.isInMainProcess(this.application);
        } else if (strategy == RFixSafeModeKeeper.Strategy.MULTI_PROCESS) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (checkSafeMode = RFixSafeModeKeeper.checkSafeMode(this.application, rFixLoadResult)) != 0) {
            RFixLog.e(TAG, "checkPatchSafeMode fail! safeModeResult=" + checkSafeMode);
            RFixPatchInfo rFixPatchInfo = rFixLoadResult.patchInfo;
            RFixGlobalPreferences rFixGlobalPreferences = new RFixGlobalPreferences(this.application);
            rFixGlobalPreferences.safeModeInterceptVersion = rFixPatchInfo.version;
            rFixGlobalPreferences.saveStoreInfo();
            cleanPatch(rFixPatchInfo);
            rFixLoadResult.subResult = checkSafeMode;
            return RFixConstants.LoadResult.LOAD_RESULT_SAFE_MODE_CHECK;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
    }

    protected RFixConstants.LoadResult checkPatchVerified(RFixLoadResult rFixLoadResult) {
        RFixPatchInfo rFixPatchInfo = rFixLoadResult.patchInfo;
        boolean isInMainProcess = ProcessUtils.isInMainProcess(this.application);
        if (isInMainProcess && rFixPatchInfo.configId == 0 && !new RemoteVerifyTask(this.application).remoteVerify()) {
            RFixLog.e(TAG, "checkPatchVerified remote verify fail!");
            cleanPatch(rFixPatchInfo);
            return RFixConstants.LoadResult.LOAD_RESULT_REMOTE_VERIFY_FAIL;
        }
        if (isInMainProcess && !rFixPatchInfo.mainVerified) {
            rFixPatchInfo.mainVerified = true;
            rFixPatchInfo.saveStoreInfo();
            if (!rFixLoadResult.effectImmediate) {
                ProcessUtils.killProcessExceptMain(this.application);
            }
        }
        if (rFixPatchInfo.mainVerified) {
            return RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
        }
        return RFixConstants.LoadResult.LOAD_RESULT_MAIN_UNVERIFIED;
    }

    protected boolean checkProcessEnable(RFixLoadResult rFixLoadResult) {
        RFixPatchInfo rFixPatchInfo = rFixLoadResult.patchInfo;
        if ((!RFixPatchInfo.PATCH_TYPE_QFIX.equals(rFixPatchInfo.patchType) && !RFixPatchInfo.PATCH_TYPE_REDIRECT.equals(rFixPatchInfo.patchType)) || TextUtils.isEmpty(rFixPatchInfo.patchProcess)) {
            return true;
        }
        String processName = ProcessUtils.getProcessName(this.application);
        for (String str : rFixPatchInfo.patchProcess.split("\\|")) {
            if (TextUtils.equals(str, processName)) {
                return true;
            }
        }
        return false;
    }

    protected void cleanPatch(RFixPatchInfo rFixPatchInfo) {
        RFixLog.i(TAG, String.format("cleanPatch version=%s patchType=%s", rFixPatchInfo.version, rFixPatchInfo.patchType));
        rFixPatchInfo.configId = 0;
        rFixPatchInfo.configType = 0;
        rFixPatchInfo.patchProcess = "";
        rFixPatchInfo.version = "";
        rFixPatchInfo.patchType = "";
        rFixPatchInfo.patchId = "";
        rFixPatchInfo.effectImmediate = false;
        rFixPatchInfo.enableAssertDex = false;
        rFixPatchInfo.enableAssertLib = false;
        rFixPatchInfo.enableAssertRes = false;
        rFixPatchInfo.removePatch = false;
        rFixPatchInfo.mainVerified = false;
        rFixPatchInfo.saveStoreInfo();
        ProcessUtils.killProcessExceptMain(this.application);
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoadEngine
    public IPatchLoader getLoader(String str) {
        return this.loaders.get(str);
    }

    protected void initLoaders() {
        registerLoader(new QFixPatchLoader(this.application));
        registerLoader(new RedirectPatchLoader(this.application));
    }

    protected boolean loadPatch(RFixLoadResult rFixLoadResult) {
        String str = rFixLoadResult.patchInfo.patchType;
        RFixLog.i(TAG, String.format("loadPatch patchType=%s patchVersionDirectory=%s", str, rFixLoadResult.patchVersionDirectory.getAbsolutePath()));
        boolean loadPatch = getLoader(str).loadPatch(rFixLoadResult);
        if (!loadPatch) {
            if (rFixLoadResult.loaderCleanPatch) {
                cleanPatch(rFixLoadResult.patchInfo);
            }
            RFixLog.e(TAG, "loadPatch loader fail.");
        }
        return loadPatch;
    }

    protected boolean needCleanPatch(Context context, RFixPatchInfo rFixPatchInfo) {
        if (context == null || rFixPatchInfo == null) {
            return false;
        }
        String manifestPatchId = ManifestUtils.getManifestPatchId(context);
        RFixLog.i(TAG, String.format("needCleanPatch removePatch=%s patchId=%s patchIdInApk=%s", Boolean.valueOf(rFixPatchInfo.removePatch), rFixPatchInfo.patchId, manifestPatchId));
        boolean equals = TextUtils.equals(manifestPatchId, rFixPatchInfo.patchId);
        if (!rFixPatchInfo.removePatch && equals) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoadEngine
    public boolean registerLoader(IPatchLoader iPatchLoader) {
        if (iPatchLoader == null) {
            return false;
        }
        String patchType = iPatchLoader.getPatchType();
        IPatchLoader iPatchLoader2 = this.loaders.get(patchType);
        if (iPatchLoader2 != null) {
            RFixLog.e(TAG, String.format("registerLoader loader already exist. patchType=%s loader=%s", patchType, iPatchLoader2));
            return false;
        }
        this.loaders.put(patchType, iPatchLoader);
        return true;
    }

    protected void tryCleanInvalidPatch(RFixLoadResult rFixLoadResult) {
        try {
            this.cleaner.cleanInvalidPatch(rFixLoadResult);
        } catch (Exception e16) {
            RFixLog.e(TAG, "tryCleanInvalidPatch fail!", e16);
        }
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoadEngine
    public RFixLoadResult tryLoadPatch() {
        RFixLog.i(TAG, "tryLoadPatch...");
        RFixLoadResult rFixLoadResult = new RFixLoadResult();
        rFixLoadResult.result = RFixConstants.LoadResult.LOAD_RESULT_UNKNOWN_EXCEPTION;
        tryLoadPatchInternal(rFixLoadResult);
        tryCleanInvalidPatch(rFixLoadResult);
        RFixLog.i(TAG, String.format("tryLoadPatch loadResult=%s", rFixLoadResult));
        return rFixLoadResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryLoadPatchInternal(RFixLoadResult rFixLoadResult) {
        TimeTrackType timeTrackType = TimeTrackType.PATCH_LOAD_CHECK;
        TimeTracker.beginTrack(timeTrackType);
        RFixConstants.LoadResult checkPatch = checkPatch(rFixLoadResult);
        TimeTracker.endTrack(timeTrackType);
        RFixConstants.LoadResult loadResult = RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
        if (checkPatch != loadResult) {
            rFixLoadResult.result = checkPatch;
            RFixLog.w(TAG, String.format("tryLoadPatchInternal check patch fail. checkResult=%s", checkPatch));
            return;
        }
        TimeTrackType timeTrackType2 = TimeTrackType.PATCH_LOAD_LOADER;
        TimeTracker.beginTrack(timeTrackType2);
        boolean loadPatch = loadPatch(rFixLoadResult);
        TimeTracker.endTrack(timeTrackType2);
        if (!loadPatch) {
            rFixLoadResult.result = RFixConstants.LoadResult.LOAD_RESULT_PATCH_LOADER_FAIL;
            RFixLog.e(TAG, String.format("tryLoadPatchInternal load patch fail. subResult=%s", Integer.valueOf(rFixLoadResult.subResult)));
        } else {
            rFixLoadResult.result = loadResult;
        }
    }

    protected void checkUnfinishedPatchInstall(String str) {
    }
}
