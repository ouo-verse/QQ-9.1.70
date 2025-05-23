package com.tencent.rfix.loader.lite;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.rfix.loader.engine.PatchLoadEngineBase;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.safemode.RFixSafeModeKeeper;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixLoader {
    private static final String TAG = "RFix.RFixLoader";

    public static RFixLoadResult tryLoad(Application application) {
        RFixLoadResult rFixLoadResult;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        TimeTracker.beginTrack(TimeTrackType.PATCH_LOAD_TOTAL);
        try {
            RFixSafeModeKeeper.initialize(application);
            rFixLoadResult = new PatchLoadEngineBase(application).tryLoadPatch();
            RFixSafeModeKeeper.onLoadPatchEnd(application, rFixLoadResult);
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoad fail.", th5);
            rFixLoadResult = new RFixLoadResult();
            rFixLoadResult.result = RFixConstants.LoadResult.LOAD_RESULT_UNKNOWN_EXCEPTION;
            rFixLoadResult.exception = th5;
        }
        rFixLoadResult.applicationStartElapsedTime = elapsedRealtime;
        rFixLoadResult.applicationStartMillisTime = currentTimeMillis;
        TimeTrackType timeTrackType = TimeTrackType.PATCH_LOAD_TOTAL;
        TimeTracker.endTrack(timeTrackType);
        rFixLoadResult.timeCost = TimeTracker.getTrackTimeMillis(timeTrackType);
        return rFixLoadResult;
    }
}
