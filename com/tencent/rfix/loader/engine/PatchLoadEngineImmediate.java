package com.tencent.rfix.loader.engine;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class PatchLoadEngineImmediate extends PatchLoadEngineBase {
    private static final String TAG = "RFix.PatchLoadEngineImmediate";

    public PatchLoadEngineImmediate(Application application) {
        super(application);
    }

    @Override // com.tencent.rfix.loader.engine.PatchLoadEngineBase
    protected void initLoaders() {
        registerLoader(new RedirectPatchLoader(this.application));
    }

    @Override // com.tencent.rfix.loader.engine.PatchLoadEngineBase, com.tencent.rfix.loader.engine.IPatchLoadEngine
    public RFixLoadResult tryLoadPatch() {
        RFixLog.i(TAG, "tryLoadPatch...");
        long nanoTime = System.nanoTime();
        RFixLoadResult rFixLoadResult = new RFixLoadResult();
        rFixLoadResult.result = RFixConstants.LoadResult.LOAD_RESULT_UNKNOWN_EXCEPTION;
        rFixLoadResult.effectImmediate = true;
        tryLoadPatchInternal(rFixLoadResult);
        rFixLoadResult.timeCost = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        RFixLog.i(TAG, String.format("tryLoadPatch loadResult=%s", rFixLoadResult));
        return rFixLoadResult;
    }

    public boolean tryUnloadPatch() {
        RFixLog.i(TAG, "tryUnloadPatch...");
        File patchDirectory = PatchFileUtils.getPatchDirectory(this.application);
        if (patchDirectory != null && patchDirectory.exists()) {
            RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.application);
            if (TextUtils.isEmpty(rFixPatchInfo.version)) {
                RFixLog.w(TAG, "tryUnloadPatch patch info empty.");
                return false;
            }
            if (RFixPatchInfo.PATCH_TYPE_REDIRECT.equals(rFixPatchInfo.patchType) && rFixPatchInfo.effectImmediate && rFixPatchInfo.removePatch) {
                PatchRedirectCenter.unApply();
                return true;
            }
            RFixLog.w(TAG, "tryUnloadPatch patch info not match.");
            return false;
        }
        RFixLog.w(TAG, "tryUnloadPatch patch dir not exist.");
        return false;
    }
}
