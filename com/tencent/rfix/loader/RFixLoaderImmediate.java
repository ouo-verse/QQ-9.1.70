package com.tencent.rfix.loader;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rfix.loader.engine.PatchLoadEngineImmediate;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.safemode.RFixSafeModeKeeper;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixLoaderImmediate {
    private static final String ACTION_IMMEDIATE_LOAD = "ACTION_IMMEDIATE_LOAD";
    private static final String ACTION_IMMEDIATE_UNLOAD = "ACTION_IMMEDIATE_UNLOAD";
    private static final String TAG = "RFix.RFixLoaderImmediate";
    private static Application application;
    private static boolean initialized;
    private static RFixLoadResult lastLoadResult;
    private static ImmediateLoadListener listener;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface ImmediateLoadListener {
        void onLoadResult(RFixLoadResult rFixLoadResult);
    }

    public static RFixLoadResult getLastLoadResult() {
        return lastLoadResult;
    }

    public static void initialize(Application application2) {
        if (!initialized) {
            application = application2;
            if (!ProcessUtils.isInMainProcess(application2)) {
                registerImmediateEffectReceiver();
            }
            initialized = true;
        }
    }

    private static void notifyImmediateEffect(String str) {
        if (!ProcessUtils.isInMainProcess(application)) {
            return;
        }
        Intent intent = new Intent(str);
        intent.addCategory(application.getPackageName());
        application.sendBroadcast(intent);
    }

    private static void registerImmediateEffectReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_IMMEDIATE_LOAD);
        intentFilter.addAction(ACTION_IMMEDIATE_UNLOAD);
        intentFilter.addCategory(application.getPackageName());
        application.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.rfix.loader.RFixLoaderImmediate.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                RFixLog.i(RFixLoaderImmediate.TAG, String.format("onReceive action=%s process=%s", action, ProcessUtils.getProcessName(RFixLoaderImmediate.application)));
                if (RFixLoaderImmediate.ACTION_IMMEDIATE_LOAD.equals(action)) {
                    RFixLoaderImmediate.tryLoad();
                } else if (RFixLoaderImmediate.ACTION_IMMEDIATE_UNLOAD.equals(action)) {
                    RFixLoaderImmediate.tryUnload();
                }
            }
        }, intentFilter);
    }

    public static void setListener(ImmediateLoadListener immediateLoadListener) {
        listener = immediateLoadListener;
    }

    public static void tryLoad() {
        if (!initialized) {
            RFixLog.e(TAG, "tryLoad not initialized?");
            return;
        }
        RFixLog.i(TAG, "tryLoad processName=" + ProcessUtils.getProcessName(application));
        RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.loader.RFixLoaderImmediate.1
            @Override // java.lang.Runnable
            public void run() {
                RFixLoaderImmediate.tryLoadInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tryLoadInternal() {
        RFixLoadResult rFixLoadResult;
        TimeTracker.beginTrack(TimeTrackType.PATCH_LOAD_TOTAL);
        try {
            RFixSafeModeKeeper.initialize(application);
            rFixLoadResult = new PatchLoadEngineImmediate(application).tryLoadPatch();
            RFixSafeModeKeeper.onLoadPatchEnd(application, rFixLoadResult);
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryLoad fail.", th5);
            RFixLoadResult rFixLoadResult2 = new RFixLoadResult();
            rFixLoadResult2.result = RFixConstants.LoadResult.LOAD_RESULT_UNKNOWN_EXCEPTION;
            rFixLoadResult2.exception = th5;
            rFixLoadResult = rFixLoadResult2;
        }
        TimeTrackType timeTrackType = TimeTrackType.PATCH_LOAD_TOTAL;
        TimeTracker.endTrack(timeTrackType);
        rFixLoadResult.timeCost = TimeTracker.getTrackTimeMillis(timeTrackType);
        if (rFixLoadResult.isLoaderSuccess()) {
            notifyImmediateEffect(ACTION_IMMEDIATE_LOAD);
        }
        lastLoadResult = rFixLoadResult;
        ImmediateLoadListener immediateLoadListener = listener;
        if (immediateLoadListener != null) {
            immediateLoadListener.onLoadResult(rFixLoadResult);
        }
    }

    public static void tryUnload() {
        boolean z16;
        if (!initialized) {
            RFixLog.e(TAG, "tryUnload not initialized?");
            return;
        }
        RFixLog.i(TAG, "tryUnload processName=" + ProcessUtils.getProcessName(application));
        try {
            z16 = new PatchLoadEngineImmediate(application).tryUnloadPatch();
        } catch (Throwable th5) {
            RFixLog.e(TAG, "tryUnload unload patch fail!", th5);
            z16 = false;
        }
        if (z16) {
            notifyImmediateEffect(ACTION_IMMEDIATE_UNLOAD);
            RFixLoadResult rFixLoadResult = new RFixLoadResult();
            rFixLoadResult.result = RFixConstants.LoadResult.LOAD_RESULT_PATCH_REMOVED;
            rFixLoadResult.effectImmediate = true;
            lastLoadResult = rFixLoadResult;
            ImmediateLoadListener immediateLoadListener = listener;
            if (immediateLoadListener != null) {
                immediateLoadListener.onLoadResult(rFixLoadResult);
            }
        }
    }
}
