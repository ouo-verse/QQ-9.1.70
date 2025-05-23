package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskSteps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0005\u0016\u0017\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "launchGameBeginTime", "", "steps", "Lcom/tencent/qqmini/sdk/task/TaskSteps;", "execute", "", "getName", "", "getSubTaskExecutionStatics", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTotalRunDurationMs", "onFirstFrame", "onGameLaunched", "statics", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "onRuntimeInitDone", "Companion", "FirstFrame", "InitEngine", "LaunchGame", "ScriptTask", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class LaunchEngineUISteps extends BaseTask {
    private static final String TAG = "LaunchEngineUISteps";
    private long launchGameBeginTime;
    private final TaskSteps steps;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$InitEngine;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "getName", "", "onTaskSucceed", "", "statics", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "effectivelyInitEngineTime", "", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private final class InitEngine extends ScriptTask {
        public InitEngine() {
            super();
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        @NotNull
        public String getName() {
            return "InitEngine";
        }

        public final void onTaskSucceed(@NotNull EngineInitStatistic statics, long effectivelyInitEngineTime) {
            List<TaskExecutionStatics> mutableList;
            Intrinsics.checkParameterIsNotNull(statics, "statics");
            super.onTaskSucceed(effectivelyInitEngineTime, statics.getEngineScriptLoadStatics());
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getSteps());
            mutableList.add(0, new TaskExecutionStatics("LoadSo", statics.getLoadNativeLibraryTimeMs(), 0L, null, null, null, statics.getInitEngineStartTimeMs(), 60, null));
            mutableList.add(mutableList.size(), new TaskExecutionStatics("EGL", statics.getCreateEGLContextTimeMs(), 0L, TaskExecutionStatics.Status.CACHED, null, null, 0L, 116, null));
            mutableList.add(0, new TaskExecutionStatics("LoadEngineScript", statics.getLoadEngineScriptTimeMs(), 0L, null, null, null, statics.getLoadEngineScriptStartTimeMs(), 60, null));
            setSteps(mutableList);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$LaunchGame;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "getName", "", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private final class LaunchGame extends ScriptTask {
        public LaunchGame() {
            super();
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        @NotNull
        public String getName() {
            return "LaunchGame";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchEngineUISteps(@NotNull Context context) {
        super(context, null);
        List listOf;
        Intrinsics.checkParameterIsNotNull(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseTask[]{new InitEngine(), new LaunchGame(), new FirstFrame()});
        this.steps = new TaskSteps(this, listOf);
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    protected void execute() {
        this.steps.start();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    @NotNull
    public String getName() {
        return "LaunchEngine";
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    @NotNull
    protected List<TaskExecutionStatics> getSubTaskExecutionStatics() {
        return this.steps.getStepExecutionStatics();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    /* renamed from: getTotalRunDurationMs */
    public long getWallDurationMs() {
        return getScriptDurationMs();
    }

    public final void onFirstFrame() {
        BaseTask currentStepOrNull = this.steps.getCurrentStepOrNull();
        if (currentStepOrNull != null) {
            currentStepOrNull.onTaskSucceed();
        }
        QMLog.i(TAG, "onFirstFrame");
    }

    public final void onGameLaunched(@NotNull GameLaunchStatistic statics) {
        String trimIndent;
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        long uptimeMillis = SystemClock.uptimeMillis() - this.launchGameBeginTime;
        long launchTimesMs = uptimeMillis - statics.getLaunchTimesMs();
        BaseTask currentStepOrNull = this.steps.getCurrentStepOrNull();
        BaseTask baseTask = null;
        if (!(currentStepOrNull instanceof InitEngine)) {
            currentStepOrNull = null;
        }
        InitEngine initEngine = (InitEngine) currentStepOrNull;
        if (initEngine != null) {
            initEngine.onTaskSucceed(statics.getEngineInitStatistic(), launchTimesMs);
        }
        BaseTask currentStepOrNull2 = this.steps.getCurrentStepOrNull();
        if (currentStepOrNull2 instanceof LaunchGame) {
            baseTask = currentStepOrNull2;
        }
        LaunchGame launchGame = (LaunchGame) baseTask;
        if (launchGame != null) {
            launchGame.onTaskSucceed(statics.getLaunchTimesMs(), statics.getGameScriptLoadStatics());
        }
        trimIndent = StringsKt__IndentKt.trimIndent("onGameLaunched launchGameEnd \n                        totalTimeSpendInLaunch: " + uptimeMillis + " \n                        effectivelyInitEngineTime: " + launchTimesMs + " \n                        engineInitTime: " + statics.getEngineInitStatistic().getTotalInitTimesMs() + " \n                        launchTime: " + statics.getLaunchTimesMs() + "\n                    ");
        QMLog.i(TAG, trimIndent);
    }

    public final void onRuntimeInitDone() {
        run();
        this.launchGameBeginTime = SystemClock.uptimeMillis();
        QMLog.i(TAG, "onRuntimeInitDone launchGameBegin");
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$FirstFrame;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "execute", "", "getName", "", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private final class FirstFrame extends BaseTask {
        public FirstFrame() {
            super(LaunchEngineUISteps.this.getContext(), LaunchEngineUISteps.this.getRuntimeLoader());
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        @NotNull
        public String getName() {
            return "FirstFrame";
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        protected void execute() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0092\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps$ScriptTask;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "(Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;)V", "scriptDurationMs", "", "steps", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getSteps", "()Ljava/util/List;", "setSteps", "(Ljava/util/List;)V", "wallDurationMs", "execute", "", "getRunDurationMs", "getSubTaskExecutionStatics", "getTotalRunDurationMs", "onTaskSucceed", "timeMs", "list", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public class ScriptTask extends BaseTask {
        private long scriptDurationMs;

        @NotNull
        private List<TaskExecutionStatics> steps;
        private long wallDurationMs;

        public ScriptTask() {
            super(LaunchEngineUISteps.this.getContext(), LaunchEngineUISteps.this.getRuntimeLoader());
            List<TaskExecutionStatics> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.steps = emptyList;
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        /* renamed from: getRunDurationMs, reason: from getter */
        public long getScriptDurationMs() {
            return this.scriptDurationMs;
        }

        @NotNull
        protected final List<TaskExecutionStatics> getSteps() {
            return this.steps;
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        @NotNull
        protected List<TaskExecutionStatics> getSubTaskExecutionStatics() {
            return this.steps;
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        /* renamed from: getTotalRunDurationMs, reason: from getter */
        public long getWallDurationMs() {
            return this.wallDurationMs;
        }

        public final void onTaskSucceed(long timeMs, @NotNull List<ScriptLoadStatistic> list) {
            int collectionSizeOrDefault;
            String str;
            List listOf;
            Intrinsics.checkParameterIsNotNull(list, "list");
            this.wallDurationMs = timeMs;
            super.onTaskSucceed();
            List<ScriptLoadStatistic> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ScriptLoadStatistic scriptLoadStatistic : list2) {
                this.scriptDurationMs += scriptLoadStatistic.getCompileTimeMs() + scriptLoadStatistic.getExecuteTimeMs();
                String scriptName = scriptLoadStatistic.getScriptName();
                long executeTimeMs = scriptLoadStatistic.getExecuteTimeMs() + scriptLoadStatistic.getCompileTimeMs();
                long executeTimeMs2 = scriptLoadStatistic.getExecuteTimeMs() + scriptLoadStatistic.getCompileTimeMs();
                if (scriptLoadStatistic.getLoadResult() == ScriptLoadResult.SUCCESS_WITH_CACHE) {
                    str = "cc";
                } else {
                    str = "";
                }
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TaskExecutionStatics[]{new TaskExecutionStatics("compile", scriptLoadStatistic.getCompileTimeMs(), 0L, null, null, null, 0L, 124, null), new TaskExecutionStatics("execute", scriptLoadStatistic.getExecuteTimeMs(), 0L, null, null, null, 0L, 124, null)});
                arrayList.add(new TaskExecutionStatics(scriptName, executeTimeMs, executeTimeMs2, null, str, listOf, scriptLoadStatistic.getStartTime(), 8, null));
            }
            this.steps = arrayList;
        }

        protected final void setSteps(@NotNull List<TaskExecutionStatics> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.steps = list;
        }

        @Override // com.tencent.qqmini.sdk.task.BaseTask
        protected void execute() {
        }
    }
}
