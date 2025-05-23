package com.tencent.rfix.loader.engine;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import java.io.File;

/* loaded from: classes25.dex */
public class RedirectPatchLoader implements IPatchLoader {
    private static final int ERROR_CODE_UNKNOWN = -100;
    private static final String TAG = "RFix.RedirectPatchLoader";
    private final Application application;

    public RedirectPatchLoader(Application application) {
        this.application = application;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public boolean cleanPatch(File file) {
        return true;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public String getPatchType() {
        return RFixPatchInfo.PATCH_TYPE_REDIRECT;
    }

    @Override // com.tencent.rfix.loader.engine.IPatchLoader
    public boolean loadPatch(RFixLoadResult rFixLoadResult) {
        TimeTrackType timeTrackType = TimeTrackType.PATCH_LOAD_LOADER_SO;
        TimeTracker.beginTrack(timeTrackType);
        if (!QFixPatchLoader.tryLoadSoPatch(this.application, rFixLoadResult)) {
            return false;
        }
        TimeTracker.endTrack(timeTrackType);
        TimeTrackType timeTrackType2 = TimeTrackType.PATCH_LOAD_LOADER_DEX;
        TimeTracker.beginTrack(timeTrackType2);
        if (!tryLoadDexPath(rFixLoadResult)) {
            return false;
        }
        TimeTracker.endTrack(timeTrackType2);
        return true;
    }

    protected boolean tryLoadDexPath(RFixLoadResult rFixLoadResult) {
        int i3;
        try {
            File file = new File(rFixLoadResult.patchVersionDirectory, "dex");
            i3 = PatchRedirectCenter.apply(this.application, new File(file, "classes.dex").getAbsolutePath(), new File(file, "config.txt").getAbsolutePath());
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoadDexPath fail.", th5);
            i3 = -100;
        }
        rFixLoadResult.subResult = i3;
        RFixLog.d(TAG, String.format("tryLoadDexPath applyReturn=%s", Integer.valueOf(i3)));
        if (i3 == 0) {
            return true;
        }
        return false;
    }
}
