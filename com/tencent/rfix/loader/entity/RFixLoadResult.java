package com.tencent.rfix.loader.entity;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixLoadResult {
    public boolean effectImmediate;
    public Throwable exception;
    public boolean loaderCleanPatch;
    public RFixPatchInfo patchInfo;
    public File patchLibDirectory;
    public File patchVersionDirectory;
    public File patchVersionFile;
    public int safeModeSubResult;
    public int subResult;
    public long timeCost;
    public RFixConstants.LoadResult result = RFixConstants.LoadResult.LOAD_RESULT_UNKNOWN_EXCEPTION;
    public int tinkerFlags = 0;
    public boolean tinkerLoadVerifyFlag = false;
    public Intent tinkerResultIntent = null;
    public long applicationStartElapsedTime = 0;
    public long applicationStartMillisTime = 0;

    public boolean isLoaderSuccess() {
        if (this.result == RFixConstants.LoadResult.LOAD_RESULT_SUCCESS) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (!this.result.isNoPatch() && this.result != RFixConstants.LoadResult.LOAD_RESULT_SUCCESS) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "RFixLoadResult{result=" + this.result + ", subResult=" + this.subResult + ", timeCost=" + this.timeCost + ", patchInfo=" + this.patchInfo + '}';
    }
}
