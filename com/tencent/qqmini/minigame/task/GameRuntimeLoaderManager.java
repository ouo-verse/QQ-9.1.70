package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@MiniKeep
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0019\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b@\u0010AJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0003J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J/\u0010-\u001a\u00020\u00062\u0006\u0010)\u001a\u00020%2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0016\u00a2\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00108R\u0016\u00109\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqmini/minigame/task/GameRuntimeLoaderManager;", "Lcom/tencent/qqmini/minigame/task/a;", "Lcom/tencent/qqmini/minigame/task/c;", "Lcom/tencent/qqmini/minigame/task/b;", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "", "b", "", "d", "a", "c", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "enginePackage", "info", "e", "startLoader", "isGameReady", "Lcom/tencent/qqmini/minigame/gpkg/MiniGamePkg;", "kotlin.jvm.PlatformType", "getMiniGamePkg", "getMiniEnginePackage", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTaskExecuteStatics", "onAppInfoUpdateSuccess", "", "ret", "", "msg", "onGameLoadFailed", "miniGamePkg", "onGameInfoLoadSuccess", "onTritonLoadFail", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "tritonPlatform", "onTritonLoadSuccess", "", "code", "onInitGameRuntimeFailed", "onInitGameRuntimeSuccess", "event", "", "", "objs", "notifyRuntimeEvent", "(I[Ljava/lang/Object;)V", "Lcom/tencent/qqmini/minigame/task/TritonEngineLoader;", "tritonEngineLoader", "Lcom/tencent/qqmini/minigame/task/TritonEngineLoader;", "Lcom/tencent/qqmini/minigame/task/GameInfoLoader;", "gameInfoLoader", "Lcom/tencent/qqmini/minigame/task/GameInfoLoader;", "Lcom/tencent/qqmini/minigame/task/d;", "initGameRuntimeLoader", "Lcom/tencent/qqmini/minigame/task/d;", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "loaderStartTime", "J", "Lcom/tencent/qqmini/minigame/GameRuntimeLoader;", "gameRuntime", "Lcom/tencent/qqmini/minigame/GameRuntimeLoader;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/qqmini/minigame/GameRuntimeLoader;)V", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameRuntimeLoaderManager implements a, c, b {
    private static final String TAG = "GameRuntimeLoaderManager";
    private final GameInfoLoader gameInfoLoader;
    private final GameRuntimeLoader gameRuntime;
    private final d initGameRuntimeLoader;
    private long loaderStartTime;
    private MiniAppInfo miniAppInfo;
    private final TritonEngineLoader tritonEngineLoader;

    public GameRuntimeLoaderManager(@Nullable Context context, @NotNull GameRuntimeLoader gameRuntime) {
        Intrinsics.checkParameterIsNotNull(gameRuntime, "gameRuntime");
        this.gameRuntime = gameRuntime;
        TritonEngineLoader tritonEngineLoader = new TritonEngineLoader();
        this.tritonEngineLoader = tritonEngineLoader;
        this.gameInfoLoader = new GameInfoLoader();
        this.initGameRuntimeLoader = new d();
        e.f346742a.a();
        if (context != null) {
            tritonEngineLoader.k(context, this);
        } else {
            QMLog.e(TAG, "start tritonEngineLoader but context is null");
        }
    }

    private final void a() {
        QMLog.i(TAG, "checkAndExecuteInitGameRuntime game:" + this.gameInfoLoader.E() + " triton:" + this.tritonEngineLoader.i());
        if (this.gameInfoLoader.E() && this.tritonEngineLoader.i()) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                c();
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameRuntimeLoaderManager$checkAndExecuteInitGameRuntime$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameRuntimeLoaderManager.this.c();
                    }
                });
            }
        }
    }

    private final void b(MiniAppInfo miniAppInfo) {
        String str;
        Version soVersion;
        String version;
        Version jsLibVersion;
        long currentTimeMillis = System.currentTimeMillis();
        MiniEnginePackage enginePackage = this.tritonEngineLoader.getEnginePackage();
        if (enginePackage != null && !e(enginePackage, miniAppInfo)) {
            notifyRuntimeEvent(2013, 104);
            this.gameRuntime.onRuntimeLoadResult(2013, "\u8bf7\u5347\u7ea7QQ\u7248\u672c\u3002");
            return;
        }
        notifyRuntimeEvent(2021, new Object[0]);
        this.gameRuntime.onRuntimeLoadResult(0, "Load runtime successfully");
        if (miniAppInfo != null) {
            long j3 = this.tritonEngineLoader.getCom.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant.Params.REPORT_PARMA_LOAD_TIME java.lang.String();
            String str2 = "";
            if (enginePackage == null || (jsLibVersion = enginePackage.getJsLibVersion()) == null || (str = jsLibVersion.getVersion()) == null) {
                str = "";
            }
            if (enginePackage != null && (soVersion = enginePackage.getSoVersion()) != null && (version = soVersion.getVersion()) != null) {
                str2 = version;
            }
            StartupReportUtil.reportEngineLoad(miniAppInfo, j3, str, str2);
            StartupReportUtil.reportInitEnv(miniAppInfo, currentTimeMillis - this.loaderStartTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void c() {
        BaseRuntime runtime = this.gameRuntime.getRuntime();
        TritonPlatform tritonPlatform = this.tritonEngineLoader.getTritonPlatform();
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if ((runtime instanceof GameRuntime) && tritonPlatform != null && miniAppInfo != null) {
            GameRuntime gameRuntime = (GameRuntime) runtime;
            gameRuntime.setEnginePackage(getMiniEnginePackage());
            this.initGameRuntimeLoader.b(gameRuntime, tritonPlatform, miniAppInfo, this);
            return;
        }
        onInitGameRuntimeFailed(-5, "env not ready");
    }

    private final boolean d(MiniAppInfo miniAppInfo) {
        MiniGamePkg B = this.gameInfoLoader.B();
        if (miniAppInfo != null && B != null && TextUtils.equals(B.appId, miniAppInfo.appId)) {
            return true;
        }
        return false;
    }

    private final boolean e(MiniEnginePackage enginePackage, MiniAppInfo info) {
        boolean z16 = false;
        if (info == null) {
            GameLog.getInstance().e(GameRuntimeLoader.LOG_TAG, "[MiniEng]isGameSatisfy info == null");
            return false;
        }
        String str = info.baselibMiniVersion;
        GameLog.getInstance().i(GameRuntimeLoader.LOG_TAG, "[MiniEng]isGameSatisfy minVersion=" + str);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        EngineVersion engineVersion = new EngineVersion(str);
        EngineVersion engineVersion2 = new EngineVersion(enginePackage.getJsLibVersion().getVersion());
        if (EngineVersion.compareVersion(engineVersion2.mMinor, engineVersion.mMinor) >= 0) {
            z16 = true;
        }
        GameLog.getInstance().i(GameRuntimeLoader.LOG_TAG, "[MiniEng]isGameSatisfy appMinVersion=" + engineVersion + ", jsSdkVersion=" + engineVersion2 + ",ret=" + z16);
        return z16;
    }

    @Nullable
    public final MiniEnginePackage getMiniEnginePackage() {
        return this.tritonEngineLoader.getEnginePackage();
    }

    public final MiniGamePkg getMiniGamePkg() {
        return this.gameInfoLoader.B();
    }

    @NotNull
    public final List<TaskExecutionStatics> getTaskExecuteStatics() {
        ArrayList arrayList = new ArrayList();
        TaskExecutionStatics A = this.gameInfoLoader.A();
        Intrinsics.checkExpressionValueIsNotNull(A, "gameInfoLoader.executionStatics");
        arrayList.add(A);
        arrayList.add(this.tritonEngineLoader.e());
        TaskExecutionStatics a16 = this.initGameRuntimeLoader.a();
        Intrinsics.checkExpressionValueIsNotNull(a16, "initGameRuntimeLoader.initGameRuntimeStatics");
        arrayList.add(a16);
        return arrayList;
    }

    public final boolean isGameReady(@Nullable MiniAppInfo miniAppInfo) {
        if (this.tritonEngineLoader.i() && d(miniAppInfo)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.minigame.task.a
    public void notifyRuntimeEvent(int event, @NotNull Object... objs) {
        Intrinsics.checkParameterIsNotNull(objs, "objs");
        this.gameRuntime.handleNotifyRuntimeEvent(event, objs);
    }

    @Override // com.tencent.qqmini.minigame.task.a
    public void onAppInfoUpdateSuccess(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        this.miniAppInfo = miniAppInfo;
        this.gameRuntime.updateMiniGameInfo(miniAppInfo);
    }

    @Override // com.tencent.qqmini.minigame.task.a
    public void onGameInfoLoadSuccess(@Nullable MiniGamePkg miniGamePkg) {
        if (miniGamePkg != null) {
            ApkgInfo apkgInfo = new ApkgInfo(miniGamePkg.apkgFolderPath, this.miniAppInfo);
            apkgInfo.mConfigStr = miniGamePkg.mConfigStr;
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo != null) {
                miniAppInfo.apkgInfo = apkgInfo;
            }
        }
        MiniAppInfo miniAppInfo2 = this.miniAppInfo;
        if (miniAppInfo2 != null) {
            this.gameRuntime.updateMiniGameInfo(miniAppInfo2);
        }
        this.gameRuntime.handleNotifyRuntimeEvent(2002, new Object[0]);
        a();
    }

    @Override // com.tencent.qqmini.minigame.task.a
    public void onGameLoadFailed(long ret, @Nullable String msg2) {
        QMLog.e(TAG, "onGameLoadFailed ret:" + ret + " msg:" + msg2);
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo != null) {
            SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, "1", null, "page_view", "load_fail", "pkg_task_fail", "");
            MiniAppReportManager2.reportPageView("2launch_fail", "pkg_task_fail", null, miniAppInfo);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSuccess", false);
        bundle.putLong("retCode", ret);
        bundle.putString("errMsg", msg2);
        notifyRuntimeEvent(2003, bundle);
    }

    @Override // com.tencent.qqmini.minigame.task.b
    public void onInitGameRuntimeFailed(int code, @Nullable String msg2) {
        this.gameRuntime.pause();
        this.gameRuntime.notifyLoaderFailed(code, msg2);
        QMLog.e(TAG, "onInitGameRuntimeFailed code:" + code + ", msg:" + msg2);
    }

    @Override // com.tencent.qqmini.minigame.task.b
    public void onInitGameRuntimeSuccess() {
        this.gameRuntime.pause();
        b(this.miniAppInfo);
    }

    @Override // com.tencent.qqmini.minigame.task.c
    public void onTritonLoadFail(@NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo != null) {
            SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, "1", null, "page_view", "load_fail", "baselib_task_fail", "");
            MiniAppReportManager2.reportPageView("2launch_fail", "baselib_task_fail", null, miniAppInfo);
        }
        QMLog.e(TAG, "onTritonLoadFail msg:" + msg2);
        notifyRuntimeEvent(2013, 105);
    }

    @Override // com.tencent.qqmini.minigame.task.c
    public void onTritonLoadSuccess(@NotNull MiniEnginePackage enginePackage, @NotNull TritonPlatform tritonPlatform) {
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        Intrinsics.checkParameterIsNotNull(tritonPlatform, "tritonPlatform");
        this.gameRuntime.handleNotifyRuntimeEvent(2012, 0);
        a();
    }

    public final void startLoader(@Nullable MiniAppInfo miniAppInfo) {
        this.loaderStartTime = System.currentTimeMillis();
        this.miniAppInfo = miniAppInfo;
        if (miniAppInfo != null) {
            this.gameInfoLoader.F(miniAppInfo, this);
        } else {
            QMLog.e(TAG, "start gameInfoLoader but appinfo is null");
        }
    }
}
