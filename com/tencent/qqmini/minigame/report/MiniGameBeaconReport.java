package com.tencent.qqmini.minigame.report;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.TraceStatistics;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00041234B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0007J2\u0010\u0014\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0007J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0007J2\u0010 \u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010$\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\"\u0010&\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\bJ\u0016\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005R\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport;", "", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "stack", "", "getTaskName", "eventCode", "", "params", "", "report", "appid", "statics", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "gameLaunchStatistic", "", "isSdk", "", "processState", "reportLaunchStatics", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "statistics", "isFirstFrame", "reportJankTraceRecords", "", "startTime", "receiveTime", "tritonInitTime", "reportPreloadTime", "Lcom/tencent/qqmini/minigame/report/GameStopType;", "stopType", "reportGameLoadCancelEvent", "getCodeCacheUsingState", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "reportWebgl2Usage", "recordMap", "reportGameLaunchJsEventCost", "appId", "appName", "reportV8OOMEvent", "TAG", "Ljava/lang/String;", "BEACON_MAX_EVENT_NAME_LENGTH", "I", "JANK_TRACE_TOP_RECORDS_COUNT", "<init>", "()V", "ExclusiveVisitor", "ParamConfigVisitor", "ParamVisitor", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameBeaconReport {
    private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
    public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
    private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
    private static final String TAG = "MiniGameBeaconReport";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamConfigVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", DownloadInfo.spKey_Config, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paramConfig", "", "getParamConfig", "()Ljava/lang/String;", "endTask", "", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private static final class ParamConfigVisitor extends ExclusiveVisitor {
        private final StringBuilder config = new StringBuilder();

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void endTask() {
            int lastIndex;
            Object last;
            int lastIndex2;
            Object last2;
            if (((ExclusiveVisitor) this).skipLevel != 0) {
                ((ExclusiveVisitor) this).skipLevel--;
                return;
            }
            List list = ((ExclusiveVisitor) this).stack;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            TaskExecutionStatics taskExecutionStatics = (TaskExecutionStatics) list.get(lastIndex);
            String taskName = MiniGameBeaconReport.INSTANCE.getTaskName(getStack());
            StringBuilder sb5 = this.config;
            if (!taskExecutionStatics.getSubSteps().isEmpty()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("game_launch \u542f\u52a8\u6b65\u9aa4 ");
                sb6.append(taskName);
                sb6.append(TokenParser.SP);
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) getStack());
                sb6.append(((TaskExecutionStatics) last2).getName());
                sb6.append("\u6b65\u9aa4\u603b\u8017\u65f6 bigint");
                sb5.append(sb6.toString());
                sb5.append("\n");
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("game_launch \u542f\u52a8\u6b65\u9aa4 ");
            sb7.append(taskName);
            sb7.append("_self ");
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) getStack());
            sb7.append(((TaskExecutionStatics) last).getName());
            sb7.append("\u6b65\u9aa4\u81ea\u8eab\u8017\u65f6 bigint");
            sb5.append(sb7.toString());
            sb5.append("\n");
            List list2 = ((ExclusiveVisitor) this).stack;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            list2.remove(lastIndex2);
        }

        @NotNull
        public final String getParamConfig() {
            String sb5 = this.config.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb5, "config.toString()");
            return sb5;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ParamVisitor;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "()V", "map", "", "", "param", "", "getParam", "()Ljava/util/Map;", "endTask", "", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private static final class ParamVisitor extends ExclusiveVisitor {
        private final Map<String, String> map = new LinkedHashMap();

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void endTask() {
            int lastIndex;
            Object last;
            int lastIndex2;
            Object last2;
            if (((ExclusiveVisitor) this).skipLevel != 0) {
                ((ExclusiveVisitor) this).skipLevel--;
                return;
            }
            List list = ((ExclusiveVisitor) this).stack;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            TaskExecutionStatics taskExecutionStatics = (TaskExecutionStatics) list.get(lastIndex);
            String taskName = MiniGameBeaconReport.INSTANCE.getTaskName(getStack());
            if (!taskExecutionStatics.getSubSteps().isEmpty()) {
                Map<String, String> map = this.map;
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) getStack());
                map.put(taskName, String.valueOf(((TaskExecutionStatics) last2).getTotalRunDurationMs()));
            }
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) getStack());
            this.map.put(taskName + "_self", String.valueOf(((TaskExecutionStatics) last).getRunDurationMs()));
            List list2 = ((ExclusiveVisitor) this).stack;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            list2.remove(lastIndex2);
        }

        @NotNull
        public final Map<String, String> getParam() {
            return this.map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$a;", "Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "", "endTask", "", "", "a", "Ljava/util/Map;", "map", "", "getParam", "()Ljava/util/Map;", "param", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a extends ExclusiveVisitor {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Map<String, String> map = new LinkedHashMap();

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void endTask() {
            int lastIndex;
            int lastIndex2;
            if (((ExclusiveVisitor) this).skipLevel != 0) {
                ((ExclusiveVisitor) this).skipLevel--;
                return;
            }
            List list = ((ExclusiveVisitor) this).stack;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            TaskExecutionStatics taskExecutionStatics = (TaskExecutionStatics) list.get(lastIndex);
            String taskName = MiniGameBeaconReport.INSTANCE.getTaskName(getStack());
            if (!taskExecutionStatics.getSubSteps().isEmpty()) {
                this.map.put(taskName, String.valueOf(taskExecutionStatics.getTotalRunDurationMs()));
            }
            this.map.put(taskName + "_self", String.valueOf(taskExecutionStatics.getRunDurationMs()));
            this.map.put(taskName + "_stat", taskExecutionStatics.getStatus().name());
            List list2 = ((ExclusiveVisitor) this).stack;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(((ExclusiveVisitor) this).stack);
            list2.remove(lastIndex2);
        }

        @NotNull
        public final Map<String, String> getParam() {
            return this.map;
        }
    }

    MiniGameBeaconReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCodeCacheUsingState(GameLaunchStatistic gameLaunchStatistic) {
        Map mapOf;
        Set<ScriptLoadStatistic> union;
        if (gameLaunchStatistic == null) {
            return "0";
        }
        int i3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("/game_preload/QGameAndroid.js", 1), TuplesKt.to("/game_preload/QGameOpenDataContext.js", 2), TuplesKt.to("/game/game.js", 4), TuplesKt.to("/game/subContext.js", 8));
        union = CollectionsKt___CollectionsKt.union(gameLaunchStatistic.getEngineInitStatistic().getEngineScriptLoadStatics(), gameLaunchStatistic.getGameScriptLoadStatics());
        for (ScriptLoadStatistic scriptLoadStatistic : union) {
            Integer num = (Integer) mapOf.get(scriptLoadStatistic.getScriptName());
            if (num != null && scriptLoadStatistic.getLoadResult() == ScriptLoadResult.SUCCESS_WITH_CACHE) {
                i3 = num.intValue() | i3;
            }
        }
        String binaryString = Integer.toBinaryString(i3);
        Intrinsics.checkExpressionValueIsNotNull(binaryString, "Integer.toBinaryString(flagResult)");
        return binaryString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTaskName(List<TaskExecutionStatics> stack) {
        String joinToString$default;
        String substring;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(stack, "_", null, null, 0, null, new Function1<TaskExecutionStatics, CharSequence>() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$getTaskName$name$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TaskExecutionStatics it) {
                boolean endsWith$default;
                String replace$default;
                int lastIndexOf$default;
                String replace$default2;
                Intrinsics.checkParameterIsNotNull(it, "it");
                String name = it.getName();
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, PTSFileUtil.JS_FORMAT, false, 2, null);
                if (endsWith$default) {
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) name, '/', 0, false, 6, (Object) null);
                    int i3 = lastIndexOf$default + 1;
                    if (name != null) {
                        String substring2 = name.substring(i3);
                        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                        replace$default2 = StringsKt__StringsJVMKt.replace$default(substring2, PTSFileUtil.JS_FORMAT, "_js", false, 4, (Object) null);
                        return replace$default2;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                replace$default = StringsKt__StringsJVMKt.replace$default(name, ".", "_", false, 4, (Object) null);
                return replace$default;
            }
        }, 30, null);
        if (Intrinsics.areEqual(joinToString$default, "root")) {
            substring = "total";
        } else if (joinToString$default != null) {
            substring = joinToString$default.substring(5);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        if (substring.length() > 59) {
            String substring2 = substring.substring(substring.length() - 59, substring.length());
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring2;
        }
        return substring;
    }

    @JvmStatic
    public static final void report(@NotNull String eventCode, @Nullable Map<String, String> params) {
        Intrinsics.checkParameterIsNotNull(eventCode, "eventCode");
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, eventCode, params);
        }
    }

    public static /* synthetic */ void report$default(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        report(str, map);
    }

    @JvmStatic
    public static final void reportGameLoadCancelEvent(@NotNull final String appid, @NotNull final TaskExecutionStatics statics, @Nullable final GameLaunchStatistic gameLaunchStatistic, @NotNull final GameStopType stopType, final int processState) {
        Intrinsics.checkParameterIsNotNull(appid, "appid");
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        Intrinsics.checkParameterIsNotNull(stopType, "stopType");
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportGameLoadCancelEvent$1
            @Override // java.lang.Runnable
            public final void run() {
                Map mutableMap;
                String codeCacheUsingState;
                MiniGameBeaconReport.a aVar = new MiniGameBeaconReport.a();
                new TaskStaticsVisualizer(aVar).visitRootTask(TaskExecutionStatics.this);
                mutableMap = MapsKt__MapsKt.toMutableMap(aVar.getParam());
                mutableMap.put("appid", appid);
                mutableMap.put("is_debug", String.valueOf(false));
                codeCacheUsingState = MiniGameBeaconReport.INSTANCE.getCodeCacheUsingState(gameLaunchStatistic);
                mutableMap.put("cc_state", codeCacheUsingState);
                mutableMap.put("process_state", String.valueOf(processState));
                mutableMap.put("stop_type", String.valueOf(stopType.getReportValue()));
                MiniGameBeaconReport.report("game_load_cancel", mutableMap);
            }
        });
    }

    @JvmStatic
    public static final void reportJankTraceRecords(@NotNull final TraceStatistics statistics, @NotNull final String appid, final boolean isSdk, final boolean isFirstFrame) {
        Intrinsics.checkParameterIsNotNull(statistics, "statistics");
        Intrinsics.checkParameterIsNotNull(appid, "appid");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportJankTraceRecords$1
            @Override // java.lang.Runnable
            public final void run() {
                List sortedWith;
                List<TraceStatistics.Record> take;
                Map mutableMapOf;
                try {
                    sortedWith = CollectionsKt___CollectionsKt.sortedWith(TraceStatistics.this.getRecords(), new Comparator<T>() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportJankTraceRecords$1$$special$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t16, T t17) {
                            int compareValues;
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((TraceStatistics.Record) t17).getTimeUs()), Long.valueOf(((TraceStatistics.Record) t16).getTimeUs()));
                            return compareValues;
                        }
                    });
                    take = CollectionsKt___CollectionsKt.take(sortedWith, 20);
                    for (TraceStatistics.Record record : take) {
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("trace_name", record.getName()), TuplesKt.to("trace_time", String.valueOf(record.getTimeUs())), TuplesKt.to("is_sdk", String.valueOf(isSdk)), TuplesKt.to("appid", appid), TuplesKt.to("isFirstFrame", String.valueOf(isFirstFrame)));
                        MiniGameBeaconReport.report("jank_trace", mutableMapOf);
                    }
                } catch (Exception e16) {
                    QMLog.e("Beacon", "reportJankTraceRecords fail", e16);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0029, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void reportLaunchStatics(@NotNull String appid, @NotNull TaskExecutionStatics statics, @Nullable GameLaunchStatistic gameLaunchStatistic, boolean isSdk, int processState) {
        int i3;
        int i16;
        Map mutableMap;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkParameterIsNotNull(appid, "appid");
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        ParamVisitor paramVisitor = new ParamVisitor();
        new TaskStaticsVisualizer(paramVisitor).visitRootTask(statics);
        String str = paramVisitor.getParam().get("total");
        if (str != null && intOrNull2 != null) {
            i3 = intOrNull2.intValue();
        } else {
            i3 = 0;
        }
        MiniGamePerformanceStatics.sLaunchCost = i3;
        String str2 = paramVisitor.getParam().get("GameInfoLoder");
        if (str2 != null && intOrNull != null) {
            i16 = intOrNull.intValue();
        } else {
            i16 = 0;
        }
        MiniGamePerformanceStatics.sPkgDownloadCost = i16;
        mutableMap = MapsKt__MapsKt.toMutableMap(paramVisitor.getParam());
        mutableMap.put("is_sdk", String.valueOf(isSdk));
        mutableMap.put("appid", appid);
        mutableMap.put("is_debug", String.valueOf(false));
        mutableMap.put("cc_state", INSTANCE.getCodeCacheUsingState(gameLaunchStatistic));
        mutableMap.put("process_state", String.valueOf(processState));
        QMLog.d(TAG, "launch_scene=" + processState);
        report("game_launch", mutableMap);
    }

    @JvmStatic
    public static final void reportPreloadTime(long startTime, long receiveTime, long tritonInitTime) {
        Map mutableMapOf;
        long j3 = receiveTime - startTime;
        long j16 = tritonInitTime - receiveTime;
        if (j3 > 0 && j16 > 0) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("process_time", String.valueOf(j3)), TuplesKt.to("triton_time", String.valueOf(j16)), TuplesKt.to("is_debug", String.valueOf(false)));
            report("game_preload", mutableMapOf);
            return;
        }
        QMLog.e(TAG, "[reportPreloadTime] processTime=" + j3 + " engineTime=" + j16);
    }

    @JvmStatic
    public static final void reportWebgl2Usage(@Nullable MiniAppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        final String str = appInfo.appId;
        final String str2 = appInfo.name;
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportWebgl2Usage$1
            @Override // java.lang.Runnable
            public final void run() {
                Map mutableMapOf;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("appid", str), TuplesKt.to("appname", str2));
                MiniGameBeaconReport.report("game_webgl2_usage", mutableMapOf);
            }
        });
    }

    public final void reportGameLaunchJsEventCost(@NotNull final String appid, @NotNull final Map<String, Long> recordMap) {
        Intrinsics.checkParameterIsNotNull(appid, "appid");
        Intrinsics.checkParameterIsNotNull(recordMap, "recordMap");
        ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportGameLaunchJsEventCost$1
            @Override // java.lang.Runnable
            public final void run() {
                Map map = recordMap;
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), String.valueOf(((Number) entry.getValue()).longValue()));
                }
                hashMap.put("appid", appid);
                MiniGameBeaconReport.report("game_launch_js_event", hashMap);
            }
        });
    }

    public final void reportV8OOMEvent(@NotNull final String appId, @NotNull final String appName) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appName, "appName");
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.report.MiniGameBeaconReport$reportV8OOMEvent$1
            @Override // java.lang.Runnable
            public final void run() {
                Map mutableMapOf;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("appid", appId), TuplesKt.to("appname", appName));
                MiniGameBeaconReport.report("game_v8_oom", mutableMapOf);
            }
        });
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\"\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001d\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u0014H\u0084\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqmini/minigame/report/MiniGameBeaconReport$ExclusiveVisitor;", "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "()V", "excludedTaskNames", "", "", "skipLevel", "", "stack", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getStack", "()Ljava/util/List;", "beginDependencies", "", "beginTask", "statics", "endDependencies", "popTask", "block", "Lkotlin/Function1;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    private static abstract class ExclusiveVisitor implements TaskStaticsVisualizer.TaskVisitor {
        private final Set<String> excludedTaskNames;
        private int skipLevel;

        @NotNull
        private final List<TaskExecutionStatics> stack;

        public ExclusiveVisitor() {
            Set<String> of5;
            of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"GetInstalledEngine", "DownloadPlugin"});
            this.excludedTaskNames = of5;
            this.stack = new ArrayList();
        }

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void beginTask(@NotNull TaskExecutionStatics statics) {
            Intrinsics.checkParameterIsNotNull(statics, "statics");
            if (this.skipLevel == 0 && !this.excludedTaskNames.contains(statics.getName())) {
                this.stack.add(statics);
            } else {
                this.skipLevel++;
            }
        }

        @NotNull
        protected final List<TaskExecutionStatics> getStack() {
            return this.stack;
        }

        protected final void popTask(@NotNull Function1<? super TaskExecutionStatics, Unit> block) {
            int lastIndex;
            int lastIndex2;
            Intrinsics.checkParameterIsNotNull(block, "block");
            if (this.skipLevel != 0) {
                this.skipLevel--;
                return;
            }
            List list = this.stack;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.stack);
            block.invoke(list.get(lastIndex));
            List list2 = this.stack;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this.stack);
            list2.remove(lastIndex2);
        }

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void beginDependencies() {
        }

        @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
        public void endDependencies() {
        }
    }
}
