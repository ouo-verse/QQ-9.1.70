package com.tencent.qqmini.minigame;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.task.GameRuntimeLoaderManager;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.List;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class GameRuntimeLoader extends BaseRuntimeLoader {

    @MiniKeep
    public static final BaseRuntimeLoader.Creator<GameRuntimeLoader> CREATOR = new BaseRuntimeLoader.Creator<GameRuntimeLoader>() { // from class: com.tencent.qqmini.minigame.GameRuntimeLoader.1
        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public boolean isEnginePrepared(Bundle bundle) {
            return true;
        }

        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public boolean support(MiniAppInfo miniAppInfo) {
            if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public GameRuntimeLoader create(Context context, Bundle bundle) {
            return new GameRuntimeLoader(context, bundle);
        }

        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public void doPrepareEngine(Bundle bundle) {
        }
    };
    public static final String LOG_TAG = "GameRuntimeLoader";
    public static final int RESULT_CODE_APP_INFO_FAILED = 3;
    public static final int RESULT_CODE_GAME_PKG_FAILED = 1;
    public static final int RESULT_CODE_OK = 0;
    public static final int RESULT_CODE_RUNTIME_FAILED = 4;
    public static final int RESULT_CODE_TRITION_ENGINE_FAILED = 2;
    private GameRuntimeLoaderManager gameRuntimeLoaderManager;
    private GameInfoManager mGameInfoManager;

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    protected BaseRuntime createRuntime(Context context) {
        GameRuntime gameRuntime = new GameRuntime(context);
        gameRuntime.setRuntimeMsgObserver(this);
        GameInfoManager gameInfoManager = new GameInfoManager(this);
        this.mGameInfoManager = gameInfoManager;
        gameRuntime.setGameInfoManager(gameInfoManager);
        this.mRuntime = gameRuntime;
        return gameRuntime;
    }

    public MiniGamePkg getMiniGamePkg() {
        return this.gameRuntimeLoaderManager.getMiniGamePkg();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public int getStatus() {
        if (isLoadSucceed()) {
            return 5;
        }
        if (isRunning()) {
            return 2;
        }
        return 1;
    }

    public List<TaskExecutionStatics> getTaskExecuteStatics() {
        return this.gameRuntimeLoaderManager.getTaskExecuteStatics();
    }

    public void handleNotifyRuntimeEvent(int i3, @Nullable Object... objArr) {
        if (i3 == 2002) {
            this.mGameInfoManager.setLaunchOptions();
        }
        notifyRuntimeEvent(i3, objArr);
    }

    public boolean isGameReadyStart(MiniAppInfo miniAppInfo) {
        return this.gameRuntimeLoaderManager.isGameReady(miniAppInfo);
    }

    public void notifyLoaderFailed(int i3, String str) {
        QMLog.e(BaseRuntimeLoader.TAG, "ready to init game runtime failed code:" + i3 + ", message:" + str);
        markHasTaskFailed(true);
        notifyRuntimeEvent(12, new Object[0]);
        onRuntimeLoadResult(i3, str);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniPause() {
        if (!isLoadSucceed()) {
            return;
        }
        super.onMiniPause();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        if (!isLoadSucceed()) {
            notifyRuntimeEvent(21, new Object[0]);
        } else {
            super.onMiniResume();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStart() {
        if (!isLoadSucceed()) {
            return;
        }
        super.onMiniStart();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStop() {
        if (!isLoadSucceed()) {
            return;
        }
        super.onMiniStop();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void onRuntimeLoadResult(int i3, String str) {
        super.onRuntimeLoadResult(i3, str);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        miniAppInfo.apkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(miniAppInfo), miniAppInfo);
        super.setMiniAppInfo(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void start() {
        super.start();
        this.gameRuntimeLoaderManager.startLoader(this.mMiniAppInfo);
    }

    GameRuntimeLoader(Context context, Bundle bundle) {
        super(context);
        this.gameRuntimeLoaderManager = new GameRuntimeLoaderManager(context, this);
    }
}
