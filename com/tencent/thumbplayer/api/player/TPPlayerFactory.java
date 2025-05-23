package com.tencent.thumbplayer.api.player;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.common.thread.TPThreadSwitchProxy;
import com.tencent.thumbplayer.tpplayer.TPPlayer;

/* loaded from: classes26.dex */
public class TPPlayerFactory {
    private static final String LOG_TAG = "TPPlayerFactory";

    public static ITPPlayer createTPPlayer(@NonNull Context context) throws IllegalStateException, TPLoadLibraryException {
        if (TPMgr.isInitialized()) {
            TPPlayer tPPlayer = new TPPlayer(context);
            return (ITPPlayer) new TPThreadSwitchProxy(tPPlayer, tPPlayer.getTPConext().getWorkerLooper(), ((Long) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_LONG_SYNC_API_WAIT_TIMEOUT_MS, 500L)).longValue()).getProxyInstance();
        }
        throw new IllegalStateException("TPMgr uninitialized.");
    }

    public static ITPPlayer createTPPlayer(@NonNull Context context, @Nullable Looper looper) throws IllegalStateException, TPLoadLibraryException {
        if (TPMgr.isInitialized()) {
            TPPlayer tPPlayer = new TPPlayer(context, looper);
            return (ITPPlayer) new TPThreadSwitchProxy(tPPlayer, tPPlayer.getTPConext().getWorkerLooper(), ((Long) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_LONG_SYNC_API_WAIT_TIMEOUT_MS, 500L)).longValue()).getProxyInstance();
        }
        throw new IllegalStateException("TPMgr uninitialized.");
    }

    public static ITPPlayer createTPPlayer(@NonNull Context context, @Nullable Looper looper, @Nullable Looper looper2) throws IllegalStateException, TPLoadLibraryException {
        if (TPMgr.isInitialized()) {
            TPPlayer tPPlayer = new TPPlayer(context, looper, looper2);
            return (ITPPlayer) new TPThreadSwitchProxy(tPPlayer, tPPlayer.getTPConext().getWorkerLooper(), ((Long) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_LONG_SYNC_API_WAIT_TIMEOUT_MS, 500L)).longValue()).getProxyInstance();
        }
        throw new IllegalStateException("TPMgr uninitialized.");
    }

    public static ITPPlayer createTPPlayer(@NonNull Context context, @Nullable Looper looper, @Nullable Looper looper2, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws IllegalStateException, TPLoadLibraryException {
        if (TPMgr.isInitialized()) {
            TPPlayer tPPlayer = new TPPlayer(context, looper, looper2, tPPlayerConstructParams);
            return (ITPPlayer) new TPThreadSwitchProxy(tPPlayer, tPPlayer.getTPConext().getWorkerLooper(), ((Long) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_LONG_SYNC_API_WAIT_TIMEOUT_MS, 500L)).longValue()).getProxyInstance();
        }
        throw new IllegalStateException("TPMgr uninitialized.");
    }
}
