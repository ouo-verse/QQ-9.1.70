package com.tencent.qqmini.sdk.server.launch;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy;
import com.tencent.qqmini.sdk.server.launch.LaunchStrategy;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 O2\u00020\u0001:\u0002OPB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006H\u0011\u00a2\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u001f\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0082\bJ\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001fH\u0002J\u0014\u0010!\u001a\u00060\u000fR\u00020\u00002\u0006\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u00020\u00172\n\u0010(\u001a\u00060\u000fR\u00020\u00002\u0006\u0010)\u001a\u00020&H\u0002J\u0014\u0010*\u001a\u00020\u00172\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010,\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u00100\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J \u00101\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\"\u00102\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0016\u00103\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/J\u0018\u00104\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0016J\u0019\u00105\u001a\u00020\u00172\n\u00106\u001a\u00060\u000fR\u00020\u0000H\u0001\u00a2\u0006\u0002\b7J\u001e\u00108\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020&0\u0005H\u0016J!\u0010:\u001a\u00020\u00172\n\u0010(\u001a\u00060\u000fR\u00020\u00002\u0006\u0010;\u001a\u00020<H\u0011\u00a2\u0006\u0002\b=J\u001c\u0010>\u001a\u00020\u00172\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0019\u0010C\u001a\u00020\u00172\n\u0010(\u001a\u00060\u000fR\u00020\u0000H\u0011\u00a2\u0006\u0002\bDJ\u0010\u0010E\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0014\u0010F\u001a\u00020\u00172\n\u0010(\u001a\u00060\u000fR\u00020\u0000H\u0002J\u0012\u0010G\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u0010H\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020N2\u0006\u0010)\u001a\u00020&H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u000fR\u00020\u00000\u00058@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u000fR\u00020\u00000\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy;", "context", "Landroid/content/Context;", "processConfig", "", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "gameLaunchConfig", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "preloader", "Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;", "debug", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;Lcom/tencent/qqmini/sdk/server/launch/ProcessPreloader;Z)V", "inspectRunningProcess", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "inspectRunningProcess$annotations", "()V", "getInspectRunningProcess$lib_miniserver_internalRelease", "()Ljava/util/List;", "runningProcess", "Ljava/util/LinkedList;", "checkProcessConfig", "", DownloadInfo.spKey_Config, "checkProcessConfig$lib_miniserver_internalRelease", "cleanOldGameIfNeed", "debugAssert", "condition", "message", "Lkotlin/Function0;", "", "debugThrow", "getOrAddProcessInfo", "processName", "killAllProcess", "killMiniAppProcess", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "killProcessByNewEngineConfig", "process", "appConfig", "logCurrentState", "action", "onAppBackground", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "bundle", "Landroid/os/Bundle;", "onAppForeground", "onAppStart", GameInfoManager.GAME_STOP, "onGetEngineInfo", "onPreloaded", "onProcessExited", "runningProcessInfo", "onProcessExited$lib_miniserver_internalRelease", "onReceiveProcessRunningAppInfos", "runningApps", "performFinishTaskForOldGameInProcess", "lastApp", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease", "performFinishTaskForSameUriDiffActClass", "componentName", "Landroid/content/ComponentName;", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "performKillProcess", "performKillProcess$lib_miniserver_internalRelease", "performPreloadProcess", "preformCleanOldGameInProcess", "preloadProcess", "registerProcessMessenger", "messenger", "Landroid/os/Messenger;", "sendMessageToMiniProcess", "Landroid/os/Message;", "startMiniApp", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "Companion", "RunningProcessInfo", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public class GameLaunchStrategy implements LaunchStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "GameLaunchStrategy";
    private final Context context;
    private final boolean debug;
    private final GameLaunchConfig gameLaunchConfig;
    private final ProcessPreloader preloader;
    private final List<MiniProcessorConfig> processConfig;
    private final LinkedList<RunningProcessInfo> runningProcess;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fR\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001\u00a2\u0006\u0002\b\u0012J-\u0010\u0013\u001a\b\u0018\u00010\fR\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\fR\u00020\r0\u0017H\u0001\u00a2\u0006\u0002\b\u0018J-\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\fR\u00020\r0\u0017H\u0001\u00a2\u0006\u0002\b\u001cJ3\u0010\u001d\u001a\b\u0018\u00010\fR\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\fR\u00020\r0\u0017H\u0001\u00a2\u0006\u0002\b\u001eJ/\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u00060\fR\u00020\r0\u0017H\u0001\u00a2\u0006\u0002\b J@\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u00110%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\"0'H\u0082\b\u00a2\u0006\u0002\u0010(J&\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0#2\u0006\u0010+\u001a\u0002H\"H\u0082\b\u00a2\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\u0015*\u00020.H\u0001\u00a2\u0006\u0002\b/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$Companion;", "", "()V", "TAG", "", "createLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", DownloadInfo.spKey_Config, "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchConfig;", "process", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;", "appConfig", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "isForceReload", "", "createLaunchIntent$lib_miniserver_internalRelease", "findExistedProcessForGame", "game", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "runningProcesses", "", "findExistedProcessForGame$lib_miniserver_internalRelease", "findProcessForLaunch", "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "processConfig", "findProcessForLaunch$lib_miniserver_internalRelease", "findProcessToClean", "findProcessToClean$lib_miniserver_internalRelease", "findProcessToPreload", "findProcessToPreload$lib_miniserver_internalRelease", "getOrPutFist", "T", "", "condition", "Lkotlin/Function1;", "factory", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "moveToFront", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "toId", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "toId$lib_miniserver_internalRelease", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ Intent createLaunchIntent$lib_miniserver_internalRelease$default(Companion companion, Context context, GameLaunchConfig gameLaunchConfig, RunningProcessInfo runningProcessInfo, MiniAppInfo miniAppInfo, boolean z16, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                z16 = false;
            }
            return companion.createLaunchIntent$lib_miniserver_internalRelease(context, gameLaunchConfig, runningProcessInfo, miniAppInfo, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> T getOrPutFist(@NotNull List<T> list, Function1<? super T, Boolean> function1, Function0<? extends T> function0) {
            T t16;
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    t16 = it.next();
                    if (function1.invoke(t16).booleanValue()) {
                        break;
                    }
                } else {
                    t16 = (T) null;
                    break;
                }
            }
            if (t16 != null) {
                return (T) t16;
            }
            T invoke = function0.invoke();
            list.add(0, invoke);
            return invoke;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> void moveToFront(@NotNull List<T> list, T t16) {
            list.remove(t16);
            list.add(0, t16);
        }

        @VisibleForTesting
        @NotNull
        public final Intent createLaunchIntent$lib_miniserver_internalRelease(@NotNull Context context, @NotNull GameLaunchConfig config, @NotNull RunningProcessInfo process, @NotNull MiniAppInfo appConfig, boolean isForceReload) {
            Boolean bool;
            Class<?> cls;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(config, "config");
            Intrinsics.checkParameterIsNotNull(process, "process");
            Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null) {
                bool = Boolean.valueOf(qQCustomizedProxy.isCustomMiniGame(appConfig));
            } else {
                bool = null;
            }
            boolean areEqual = Intrinsics.areEqual(bool, Boolean.TRUE);
            MiniProcessorConfig config2 = process.getConfig();
            if (areEqual) {
                cls = config2.internalUIClass;
            } else {
                cls = config2.appUIClass;
            }
            QMLog.d(GameLaunchStrategy.TAG, "uiClass:" + cls + " customize:" + bool);
            Intent intent = new Intent(context, cls);
            intent.addFlags(524288);
            intent.addFlags(8192);
            intent.addFlags(536870912);
            if (qQCustomizedProxy == null || !qQCustomizedProxy.disableNewTask(appConfig)) {
                intent.addFlags(268435456);
            }
            intent.setData(GameLaunchStrategy.INSTANCE.toId$lib_miniserver_internalRelease(appConfig).getUri());
            if (isForceReload) {
                intent.addFlags(32768);
            }
            return intent;
        }

        @VisibleForTesting
        @Nullable
        public final RunningProcessInfo findExistedProcessForGame$lib_miniserver_internalRelease(@NotNull AppIdentity game, @NotNull List<RunningProcessInfo> runningProcesses) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(game, "game");
            Intrinsics.checkParameterIsNotNull(runningProcesses, "runningProcesses");
            Iterator<T> it = runningProcesses.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((RunningProcessInfo) obj).has(game)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (RunningProcessInfo) obj;
        }

        @VisibleForTesting
        @NotNull
        public final MiniProcessorConfig findProcessForLaunch$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> processConfig, @NotNull List<RunningProcessInfo> runningProcesses) {
            List sortedWith;
            Object obj;
            Set set;
            int collectionSizeOrDefault;
            Set set2;
            Set subtract;
            Object first;
            Object first2;
            Intrinsics.checkParameterIsNotNull(processConfig, "processConfig");
            Intrinsics.checkParameterIsNotNull(runningProcesses, "runningProcesses");
            if (runningProcesses.isEmpty()) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) processConfig);
                return (MiniProcessorConfig) first2;
            }
            List<RunningProcessInfo> list = runningProcesses;
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy$Companion$findProcessForLaunch$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((GameLaunchStrategy.RunningProcessInfo) t17).getRunningAppCount()), Integer.valueOf(((GameLaunchStrategy.RunningProcessInfo) t16).getRunningAppCount()));
                    return compareValues;
                }
            });
            Iterator it = sortedWith.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (!((RunningProcessInfo) obj).getFull()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            RunningProcessInfo runningProcessInfo = (RunningProcessInfo) obj;
            if (runningProcessInfo != null) {
                return runningProcessInfo.getConfig();
            }
            if (runningProcesses.size() < processConfig.size()) {
                set = CollectionsKt___CollectionsKt.toSet(processConfig);
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    arrayList.add(((RunningProcessInfo) it5.next()).getConfig());
                }
                set2 = CollectionsKt___CollectionsKt.toSet(arrayList);
                subtract = CollectionsKt___CollectionsKt.subtract(set, set2);
                first = CollectionsKt___CollectionsKt.first(subtract);
                return (MiniProcessorConfig) first;
            }
            throw new IllegalStateException("all process are full, no idle process available");
        }

        @VisibleForTesting
        @Nullable
        public final RunningProcessInfo findProcessToClean$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> processConfig, @NotNull List<RunningProcessInfo> runningProcesses) {
            Object last;
            Intrinsics.checkParameterIsNotNull(processConfig, "processConfig");
            Intrinsics.checkParameterIsNotNull(runningProcesses, "runningProcesses");
            if (runningProcesses.size() == processConfig.size()) {
                List<RunningProcessInfo> list = runningProcesses;
                boolean z16 = true;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!((RunningProcessInfo) it.next()).getFull()) {
                            z16 = false;
                            break;
                        }
                    }
                }
                if (z16) {
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) runningProcesses);
                    return (RunningProcessInfo) last;
                }
                return null;
            }
            return null;
        }

        @VisibleForTesting
        @Nullable
        public final MiniProcessorConfig findProcessToPreload$lib_miniserver_internalRelease(@NotNull List<? extends MiniProcessorConfig> processConfig, @NotNull List<RunningProcessInfo> runningProcesses) {
            Set set;
            int collectionSizeOrDefault;
            Set set2;
            Set subtract;
            Object first;
            Intrinsics.checkParameterIsNotNull(processConfig, "processConfig");
            Intrinsics.checkParameterIsNotNull(runningProcesses, "runningProcesses");
            List<RunningProcessInfo> list = runningProcesses;
            boolean z16 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!((RunningProcessInfo) it.next()).getFull()) {
                        z16 = false;
                        break;
                    }
                }
            }
            if (z16 && runningProcesses.size() != processConfig.size()) {
                set = CollectionsKt___CollectionsKt.toSet(processConfig);
                List<RunningProcessInfo> list2 = runningProcesses;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList.add(((RunningProcessInfo) it5.next()).getConfig());
                }
                set2 = CollectionsKt___CollectionsKt.toSet(arrayList);
                subtract = CollectionsKt___CollectionsKt.subtract(set, set2);
                first = CollectionsKt___CollectionsKt.first(subtract);
                return (MiniProcessorConfig) first;
            }
            return null;
        }

        @VisibleForTesting
        @NotNull
        public final AppIdentity toId$lib_miniserver_internalRelease(@NotNull MiniAppBaseInfo toId) {
            Intrinsics.checkParameterIsNotNull(toId, "$this$toId");
            String appId = toId.appId;
            Intrinsics.checkExpressionValueIsNotNull(appId, "appId");
            return new AppIdentity(appId, toId.verType, toId.version, toId.name);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RunningProcessState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RunningProcessState.STARTING.ordinal()] = 1;
            iArr[RunningProcessState.RUNNING.ordinal()] = 2;
            iArr[RunningProcessState.PRELOAD.ordinal()] = 3;
        }
    }

    public GameLaunchStrategy(@NotNull Context context, @NotNull List<? extends MiniProcessorConfig> processConfig, @NotNull GameLaunchConfig gameLaunchConfig, @NotNull ProcessPreloader preloader, boolean z16) {
        List<MiniProcessorConfig> list;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(processConfig, "processConfig");
        Intrinsics.checkParameterIsNotNull(gameLaunchConfig, "gameLaunchConfig");
        Intrinsics.checkParameterIsNotNull(preloader, "preloader");
        this.context = context;
        this.gameLaunchConfig = gameLaunchConfig;
        this.preloader = preloader;
        this.debug = z16;
        List<? extends MiniProcessorConfig> list2 = processConfig;
        list = CollectionsKt___CollectionsKt.toList(list2);
        this.processConfig = list;
        if (z16) {
            if (!processConfig.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    checkProcessConfig$lib_miniserver_internalRelease(this.context, (MiniProcessorConfig) it.next());
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        this.runningProcess = new LinkedList<>();
    }

    private final void cleanOldGameIfNeed() {
        RunningProcessInfo findProcessToClean$lib_miniserver_internalRelease = INSTANCE.findProcessToClean$lib_miniserver_internalRelease(this.processConfig, this.runningProcess);
        if (findProcessToClean$lib_miniserver_internalRelease != null) {
            preformCleanOldGameInProcess(findProcessToClean$lib_miniserver_internalRelease);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void debugAssert(boolean condition, Function0<String> message) {
        if (!condition) {
            debugThrow(message.invoke());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void debugThrow(String message) {
        if (!this.debug) {
            QMLog.e(TAG, message);
            return;
        }
        throw new IllegalStateException(message);
    }

    private final RunningProcessInfo getOrAddProcessInfo(String processName) {
        Object obj;
        LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RunningProcessInfo) obj).getConfig().processName, processName)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            for (MiniProcessorConfig miniProcessorConfig : this.processConfig) {
                if (Intrinsics.areEqual(miniProcessorConfig.processName, processName)) {
                    RunningProcessInfo runningProcessInfo = new RunningProcessInfo(this, miniProcessorConfig);
                    linkedList.add(0, runningProcessInfo);
                    obj = runningProcessInfo;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return (RunningProcessInfo) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void killProcessByNewEngineConfig(RunningProcessInfo process, MiniAppInfo appConfig) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy != null) {
            str = wnsConfigProxy.getMiniGameEnginePackageConfig();
        } else {
            str = null;
        }
        boolean z19 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QMLog.i(TAG, "killProcessByNewEngineConfig: config is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            z17 = jSONObject.optBoolean("forceLoadNewEngine", false);
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("appIdList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        if (Intrinsics.areEqual(appConfig.appId, optJSONArray.getString(i3))) {
                            z18 = true;
                            break;
                        }
                    }
                }
            } catch (Exception e16) {
                e = e16;
                QMLog.e(TAG, "needKillOldProcess: parse config failed, config=" + str, e);
                z18 = false;
                if (process.getIsNewEngine()) {
                }
                z19 = false;
                QMLog.i(TAG, "killProcessByNewEngineConfig: appId=" + appConfig.appId + ", isForceLoadNewEngine=" + z17 + ", canUseNewEngine=" + z18 + ", isNewEngine=" + process.getIsNewEngine() + ", needKillProcess=" + z19 + ", pid=" + process.getPid() + ", runningAppCount=" + process.getRunningAppCount());
                if (!z19) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            z17 = false;
        }
        z18 = false;
        if ((process.getIsNewEngine() || z18) && (process.getIsNewEngine() || !z17 || !z18)) {
            z19 = false;
        }
        QMLog.i(TAG, "killProcessByNewEngineConfig: appId=" + appConfig.appId + ", isForceLoadNewEngine=" + z17 + ", canUseNewEngine=" + z18 + ", isNewEngine=" + process.getIsNewEngine() + ", needKillProcess=" + z19 + ", pid=" + process.getPid() + ", runningAppCount=" + process.getRunningAppCount());
        if (!z19) {
            if (process.getPid() > 0) {
                performKillProcess$lib_miniserver_internalRelease(process);
            }
            if (process.getRunningAppCount() > 0) {
                process.removeApp(process.getLastApp());
            }
        }
    }

    private final void logCurrentState(String action) {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("currentStateOfRunningProcessAndApps");
        if (action != null) {
            sb5.append(" [");
            sb5.append(action);
            sb5.append("]");
        }
        sb5.append('\n');
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.runningProcess, "\n", null, null, 0, null, new Function1<RunningProcessInfo, String>() { // from class: com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy$logCurrentState$message$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull GameLaunchStrategy.RunningProcessInfo it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.toSimpleString();
            }
        }, 30, null);
        sb5.append(joinToString$default);
        sb5.append('\n');
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "StringBuilder().apply(builderAction).toString()");
        QMLog.i(TAG, sb6);
    }

    static /* synthetic */ void logCurrentState$default(GameLaunchStrategy gameLaunchStrategy, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                str = null;
            }
            gameLaunchStrategy.logCurrentState(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCurrentState");
    }

    private final void performFinishTaskForSameUriDiffActClass(ComponentName componentName, Uri uri) {
        boolean z16;
        ActivityManager.RecentTaskInfo recentTaskInfo;
        Intent intent;
        Intent intent2;
        Intent intent3;
        if (componentName != null && uri != null) {
            Object systemService = this.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null) {
                List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
                List<ActivityManager.AppTask> list = appTasks;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                for (ActivityManager.AppTask appTask : appTasks) {
                    try {
                        Intrinsics.checkExpressionValueIsNotNull(appTask, "appTask");
                        recentTaskInfo = appTask.getTaskInfo();
                    } catch (IllegalArgumentException e16) {
                        QMLog.e(TAG, "performFinishTaskForSameAppDiffActClass: taskInfo fail.", e16);
                        recentTaskInfo = null;
                    }
                    if (recentTaskInfo != null) {
                        intent = recentTaskInfo.baseIntent;
                        Intrinsics.checkExpressionValueIsNotNull(intent, "taskInfo.baseIntent");
                        if (Intrinsics.areEqual(intent.getData(), uri)) {
                            intent2 = recentTaskInfo.baseIntent;
                            Intrinsics.checkExpressionValueIsNotNull(intent2, "taskInfo.baseIntent");
                            if ((intent2.getFlags() & 524288) != 0) {
                                intent3 = recentTaskInfo.baseIntent;
                                Intrinsics.checkExpressionValueIsNotNull(intent3, "taskInfo.baseIntent");
                                if (!Intrinsics.areEqual(intent3.getComponent(), componentName)) {
                                    QMLog.i(TAG, "performFinishTaskForSameAppDiffActClass: uri= " + uri);
                                    appTask.finishAndRemoveTask();
                                }
                            }
                        }
                    }
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
        }
    }

    private final void performPreloadProcess(MiniProcessorConfig process) {
        Object obj;
        this.preloader.performPreloadProcess(process);
        LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((RunningProcessInfo) obj).getConfig(), process)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            linkedList.add(0, new RunningProcessInfo(this, process));
        }
    }

    private final void preformCleanOldGameInProcess(RunningProcessInfo process) {
        if (this.gameLaunchConfig.getEnableProcessReuse()) {
            performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease(process, process.getLastApp());
        } else {
            performKillProcess$lib_miniserver_internalRelease(process);
        }
    }

    @VisibleForTesting
    public void checkProcessConfig$lib_miniserver_internalRelease(@NotNull Context context, @NotNull MiniProcessorConfig config) {
        boolean z16;
        boolean z17;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(config, "config");
        boolean z18 = true;
        if (config.processType == ProcessType.MINI_GAME) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (Activity.class.isAssignableFrom(config.appUIClass)) {
                if (BroadcastReceiver.class.isAssignableFrom(config.appPreLoadClass)) {
                    PackageManager packageManager = context.getPackageManager();
                    String packageName = context.getPackageName();
                    Class<?> cls = config.appUIClass;
                    Intrinsics.checkExpressionValueIsNotNull(cls, "config.appUIClass");
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, cls.getName()), 0);
                    if (activityInfo.launchMode == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        int i3 = activityInfo.documentLaunchMode;
                        if (i3 != 0 && i3 != 1) {
                            z18 = false;
                        }
                        if (z18) {
                            return;
                        } else {
                            throw new IllegalStateException("MiniGame activity:documentLaunchMode must be 'none' or 'intoExisting'".toString());
                        }
                    }
                    throw new IllegalStateException("MiniGame activity:launchMode must be 'standard'".toString());
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public final List<RunningProcessInfo> getInspectRunningProcess$lib_miniserver_internalRelease() {
        List<RunningProcessInfo> list;
        list = CollectionsKt___CollectionsKt.toList(this.runningProcess);
        return list;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void killAllProcess() {
        Iterator<T> it = this.runningProcess.iterator();
        while (it.hasNext()) {
            performKillProcess$lib_miniserver_internalRelease((RunningProcessInfo) it.next());
        }
        logCurrentState("killAllProcess");
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized boolean killMiniAppProcess(@NotNull MiniAppInfo miniAppInfo) {
        RunningProcessInfo runningProcessInfo;
        Object obj;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        AppIdentity id$lib_miniserver_internalRelease = INSTANCE.toId$lib_miniserver_internalRelease(miniAppInfo);
        Iterator<T> it = this.runningProcess.iterator();
        while (true) {
            runningProcessInfo = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((RunningProcessInfo) obj).has(id$lib_miniserver_internalRelease)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RunningProcessInfo runningProcessInfo2 = (RunningProcessInfo) obj;
        if (runningProcessInfo2 != null) {
            performKillProcess$lib_miniserver_internalRelease(runningProcessInfo2);
            logCurrentState("killMiniAppProcess " + INSTANCE.toId$lib_miniserver_internalRelease(miniAppInfo));
            runningProcessInfo = runningProcessInfo2;
        }
        if (runningProcessInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onAppBackground(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        Companion companion = INSTANCE;
        orAddProcessInfo.appBackground(companion.toId$lib_miniserver_internalRelease(appConfig));
        logCurrentState("onAppBackground " + companion.toId$lib_miniserver_internalRelease(appConfig));
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onAppForeground(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
        linkedList.remove(orAddProcessInfo);
        linkedList.add(0, orAddProcessInfo);
        Companion companion = INSTANCE;
        orAddProcessInfo.appForeground(companion.toId$lib_miniserver_internalRelease(appConfig));
        logCurrentState("onAppForeground " + companion.toId$lib_miniserver_internalRelease(appConfig));
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onAppStart(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
        linkedList.remove(orAddProcessInfo);
        linkedList.add(0, orAddProcessInfo);
        Companion companion = INSTANCE;
        orAddProcessInfo.addApp(companion.toId$lib_miniserver_internalRelease(appConfig));
        orAddProcessInfo.onProcessStarted(bundle);
        logCurrentState("onAppStart " + companion.toId$lib_miniserver_internalRelease(appConfig));
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onAppStop(@NotNull String processName, @NotNull MiniAppBaseInfo appConfig, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        Companion companion = INSTANCE;
        orAddProcessInfo.removeApp(companion.toId$lib_miniserver_internalRelease(appConfig));
        logCurrentState("onAppStop " + companion.toId$lib_miniserver_internalRelease(appConfig));
    }

    public final synchronized void onGetEngineInfo(@NotNull String processName, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        orAddProcessInfo.setNewEngine(bundle.getBoolean(IPCConst.KEY_GAME_NEW_ENGINE, false));
        QMLog.i(TAG, "onGetEngineInfo: isNewEngine=" + orAddProcessInfo.getIsNewEngine());
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onPreloaded(@NotNull String processName, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        orAddProcessInfo.onPreloaded();
        orAddProcessInfo.onProcessStarted(bundle);
        logCurrentState("onPreloaded " + processName);
    }

    @VisibleForTesting
    public final synchronized void onProcessExited$lib_miniserver_internalRelease(@NotNull RunningProcessInfo runningProcessInfo) {
        Intrinsics.checkParameterIsNotNull(runningProcessInfo, "runningProcessInfo");
        this.runningProcess.remove(runningProcessInfo);
        logCurrentState("onProcessExited " + runningProcessInfo.toSimpleString());
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void onReceiveProcessRunningAppInfos(@NotNull String processName, @NotNull List<? extends MiniAppInfo> runningApps) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(runningApps, "runningApps");
        getOrAddProcessInfo(processName).restoreRunningApps(runningApps);
    }

    @RequiresApi(21)
    @VisibleForTesting
    public void performFinishTaskForOldGameInProcess$lib_miniserver_internalRelease(@NotNull RunningProcessInfo process, @NotNull AppIdentity lastApp) {
        Object obj;
        Intent intent;
        Intent intent2;
        Intrinsics.checkParameterIsNotNull(process, "process");
        Intrinsics.checkParameterIsNotNull(lastApp, "lastApp");
        Object systemService = this.context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
            Intrinsics.checkExpressionValueIsNotNull(appTasks, "(context.getSystemServic\u2026ActivityManager).appTasks");
            Iterator<T> it = appTasks.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    ActivityManager.AppTask it5 = (ActivityManager.AppTask) obj;
                    Intrinsics.checkExpressionValueIsNotNull(it5, "it");
                    intent2 = it5.getTaskInfo().baseIntent;
                    Intrinsics.checkExpressionValueIsNotNull(intent2, "it.taskInfo.baseIntent");
                    if (Intrinsics.areEqual(intent2.getData(), lastApp.getUri())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ActivityManager.AppTask appTask = (ActivityManager.AppTask) obj;
            if (appTask != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("performFinishTaskForOldGameInProcess ");
                intent = appTask.getTaskInfo().baseIntent;
                sb5.append(intent);
                QMLog.i(TAG, sb5.toString());
                appTask.finishAndRemoveTask();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @VisibleForTesting
    public void performKillProcess$lib_miniserver_internalRelease(@NotNull RunningProcessInfo process) {
        Intrinsics.checkParameterIsNotNull(process, "process");
        ProcessUtil.killProcess(process.getPid());
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized boolean preloadProcess(@Nullable Bundle bundle) {
        boolean z16;
        MiniProcessorConfig findProcessToPreload$lib_miniserver_internalRelease = INSTANCE.findProcessToPreload$lib_miniserver_internalRelease(this.processConfig, this.runningProcess);
        if (findProcessToPreload$lib_miniserver_internalRelease != null) {
            performPreloadProcess(findProcessToPreload$lib_miniserver_internalRelease);
        } else {
            findProcessToPreload$lib_miniserver_internalRelease = null;
        }
        if (findProcessToPreload$lib_miniserver_internalRelease != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void registerProcessMessenger(@NotNull String processName, @NotNull Messenger messenger) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(messenger, "messenger");
        RunningProcessInfo orAddProcessInfo = getOrAddProcessInfo(processName);
        LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
        linkedList.remove(orAddProcessInfo);
        linkedList.add(0, orAddProcessInfo);
        orAddProcessInfo.setMessenger(messenger);
    }

    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    public synchronized void sendMessageToMiniProcess(@NotNull MiniAppInfo miniAppInfo, @NotNull Message message) {
        Object obj;
        Messenger messenger;
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(message, "message");
        AppIdentity id$lib_miniserver_internalRelease = INSTANCE.toId$lib_miniserver_internalRelease(miniAppInfo);
        Iterator<T> it = this.runningProcess.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((RunningProcessInfo) obj).has(id$lib_miniserver_internalRelease)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RunningProcessInfo runningProcessInfo = (RunningProcessInfo) obj;
        if (runningProcessInfo != null && (messenger = runningProcessInfo.getMessenger()) != null) {
            messenger.send(message);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqmini.sdk.server.launch.LaunchStrategy
    @NotNull
    public synchronized LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo appConfig) {
        RunningProcessState state;
        boolean z16;
        Intent createLaunchIntent$lib_miniserver_internalRelease;
        ProcessState processState;
        Object last;
        MiniProcessorConfig config;
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(appConfig, "appConfig");
        Companion companion = INSTANCE;
        RunningProcessInfo findExistedProcessForGame$lib_miniserver_internalRelease = companion.findExistedProcessForGame$lib_miniserver_internalRelease(companion.toId$lib_miniserver_internalRelease(appConfig), this.runningProcess);
        if (findExistedProcessForGame$lib_miniserver_internalRelease == null) {
            RunningProcessInfo runningProcessInfo = null;
            try {
                QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
                if (qQCustomizedProxy != null) {
                    bool = Boolean.valueOf(qQCustomizedProxy.isCustomMiniGame(appConfig));
                } else {
                    bool = null;
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    Iterator<MiniProcessorConfig> it = this.processConfig.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            config = it.next();
                            if (config.internalUIClass != null) {
                                QMLog.d(TAG, "find internalUI" + config);
                                break;
                            }
                        } else {
                            config = null;
                            break;
                        }
                    }
                    if (config == null) {
                        config = INSTANCE.findProcessForLaunch$lib_miniserver_internalRelease(this.processConfig, this.runningProcess);
                    }
                } else {
                    config = companion.findProcessForLaunch$lib_miniserver_internalRelease(this.processConfig, this.runningProcess);
                }
            } catch (IllegalStateException e16) {
                QMLog.e(TAG, "processInfo find failed", e16);
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.runningProcess);
                RunningProcessInfo runningProcessInfo2 = (RunningProcessInfo) last;
                preformCleanOldGameInProcess(runningProcessInfo2);
                config = runningProcessInfo2.getConfig();
            }
            LinkedList<RunningProcessInfo> linkedList = this.runningProcess;
            Iterator<T> it5 = linkedList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (Intrinsics.areEqual(((RunningProcessInfo) next).getConfig(), config)) {
                    runningProcessInfo = next;
                    break;
                }
            }
            if (runningProcessInfo == null) {
                runningProcessInfo = new RunningProcessInfo(this, config);
                linkedList.add(0, runningProcessInfo);
            }
            findExistedProcessForGame$lib_miniserver_internalRelease = runningProcessInfo;
            try {
                killProcessByNewEngineConfig(findExistedProcessForGame$lib_miniserver_internalRelease, appConfig);
            } catch (Exception e17) {
                QMLog.e(TAG, "killProcessByNewEngineConfig: failed.", e17);
            }
            state = findExistedProcessForGame$lib_miniserver_internalRelease.getState();
            findExistedProcessForGame$lib_miniserver_internalRelease.addApp(INSTANCE.toId$lib_miniserver_internalRelease(appConfig));
            LinkedList<RunningProcessInfo> linkedList2 = this.runningProcess;
            linkedList2.remove(findExistedProcessForGame$lib_miniserver_internalRelease);
            linkedList2.add(0, findExistedProcessForGame$lib_miniserver_internalRelease);
        } else {
            state = findExistedProcessForGame$lib_miniserver_internalRelease.getState();
        }
        RunningProcessInfo runningProcessInfo3 = findExistedProcessForGame$lib_miniserver_internalRelease;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Start ");
        Companion companion2 = INSTANCE;
        sb5.append(companion2.toId$lib_miniserver_internalRelease(appConfig));
        logCurrentState(sb5.toString());
        Context context = this.context;
        GameLaunchConfig gameLaunchConfig = this.gameLaunchConfig;
        if (appConfig.launchParam.forceReload != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        createLaunchIntent$lib_miniserver_internalRelease = companion2.createLaunchIntent$lib_miniserver_internalRelease(context, gameLaunchConfig, runningProcessInfo3, appConfig, z16);
        performFinishTaskForSameUriDiffActClass(createLaunchIntent$lib_miniserver_internalRelease.getComponent(), createLaunchIntent$lib_miniserver_internalRelease.getData());
        int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    processState = ProcessState.PRELOADED;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                processState = ProcessState.REUSE;
            }
        } else {
            processState = ProcessState.EMPTY;
        }
        return new LaunchStrategy.LaunchData(createLaunchIntent$lib_miniserver_internalRelease, processState);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001cJ\u000e\u00103\u001a\u0002012\u0006\u00102\u001a\u00020\u001cJ\u000e\u00104\u001a\u0002012\u0006\u00102\u001a\u00020\u001cJ\u000e\u00105\u001a\u00020\r2\u0006\u00102\u001a\u00020\u001cJ\u0006\u00106\u001a\u000201J\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u0002012\u0006\u00102\u001a\u00020\u001cJ\u0014\u0010;\u001a\u0002012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0013J\u0006\u0010>\u001a\u00020?R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020&8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u001e\u0010-\u001a\u00020,2\u0006\u0010%\u001a\u00020,@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "", DownloadInfo.spKey_Config, "Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "(Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;)V", "apps", "Ljava/util/LinkedList;", "Lcom/tencent/qqmini/sdk/server/launch/RunningApp;", "getConfig", "()Lcom/tencent/qqmini/sdk/launcher/MiniProcessorConfig;", "deathNotifier", "Lcom/tencent/qqmini/sdk/launcher/ipc/ProcessDeathNotifier;", "full", "", "getFull", "()Z", HippyPagerPageChangeListener.IDLE, "getIdle", "inspectApps", "", "inspectApps$annotations", "()V", "getInspectApps$lib_miniserver_internalRelease", "()Ljava/util/List;", "isNewEngine", "setNewEngine", "(Z)V", "lastApp", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "getLastApp", "()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "messenger", "Landroid/os/Messenger;", "getMessenger", "()Landroid/os/Messenger;", "setMessenger", "(Landroid/os/Messenger;)V", "<set-?>", "", "pid", "getPid", "()I", "runningAppCount", "getRunningAppCount", "Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "state", "getState", "()Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "addApp", "", "app", "appBackground", "appForeground", "has", "onPreloaded", "onProcessStarted", "bundle", "Landroid/os/Bundle;", "removeApp", "restoreRunningApps", "runningApps", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "toSimpleString", "", "lib_miniserver_internalRelease"}, k = 1, mv = {1, 1, 16})
    @VisibleForTesting
    /* loaded from: classes23.dex */
    public final class RunningProcessInfo {
        private final LinkedList<RunningApp> apps;

        @NotNull
        private final MiniProcessorConfig config;
        private ProcessDeathNotifier deathNotifier;
        private boolean isNewEngine;

        @Nullable
        private Messenger messenger;
        private int pid;

        @NotNull
        private RunningProcessState state;
        final /* synthetic */ GameLaunchStrategy this$0;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes23.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[RunningProcessState.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[RunningProcessState.STARTING.ordinal()] = 1;
                iArr[RunningProcessState.RUNNING.ordinal()] = 2;
                iArr[RunningProcessState.PRELOAD.ordinal()] = 3;
                int[] iArr2 = new int[RunningMiniAppState.values().length];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[RunningMiniAppState.STARTING.ordinal()] = 1;
                iArr2[RunningMiniAppState.FOREGROUND.ordinal()] = 2;
                iArr2[RunningMiniAppState.BACKGROUND.ordinal()] = 3;
                iArr2[RunningMiniAppState.STOPPED.ordinal()] = 4;
            }
        }

        public RunningProcessInfo(@NotNull GameLaunchStrategy gameLaunchStrategy, MiniProcessorConfig config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            this.this$0 = gameLaunchStrategy;
            this.config = config;
            this.apps = new LinkedList<>();
            this.state = RunningProcessState.STARTING;
            this.pid = -1;
        }

        public final synchronized void addApp(@NotNull AppIdentity app) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(app, "app");
            this.state = RunningProcessState.RUNNING;
            Iterator<T> it = this.apps.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((RunningApp) obj).getId(), app)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                return;
            }
            this.apps.addFirst(new RunningApp(app));
        }

        public final synchronized void appBackground(@NotNull AppIdentity app) {
            RunningApp runningApp;
            Intrinsics.checkParameterIsNotNull(app, "app");
            Iterator<RunningApp> it = this.apps.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getId(), app)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                RunningApp runningApp2 = this.apps.get(i3);
                Intrinsics.checkExpressionValueIsNotNull(runningApp2, "apps[index]");
                runningApp = runningApp2;
            } else {
                RunningApp runningApp3 = new RunningApp(app);
                this.apps.addLast(runningApp3);
                runningApp = runningApp3;
            }
            runningApp.setState(RunningMiniAppState.BACKGROUND);
            this.state = RunningProcessState.RUNNING;
        }

        public final synchronized void appForeground(@NotNull AppIdentity app) {
            RunningApp runningApp;
            Intrinsics.checkParameterIsNotNull(app, "app");
            Iterator<RunningApp> it = this.apps.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getId(), app)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                RunningApp remove = this.apps.remove(i3);
                Intrinsics.checkExpressionValueIsNotNull(remove, "apps.removeAt(index)");
                runningApp = remove;
                this.apps.addFirst(runningApp);
            } else {
                RunningApp runningApp2 = new RunningApp(app);
                this.apps.addFirst(runningApp2);
                runningApp = runningApp2;
            }
            this.state = RunningProcessState.RUNNING;
            runningApp.setState(RunningMiniAppState.FOREGROUND);
        }

        @NotNull
        public final MiniProcessorConfig getConfig() {
            return this.config;
        }

        public final boolean getFull() {
            if (getRunningAppCount() >= this.this$0.gameLaunchConfig.getMultiInstanceCount()) {
                return true;
            }
            return false;
        }

        public final boolean getIdle() {
            if (getRunningAppCount() == 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<RunningApp> getInspectApps$lib_miniserver_internalRelease() {
            List<RunningApp> list;
            list = CollectionsKt___CollectionsKt.toList(this.apps);
            return list;
        }

        @NotNull
        public final AppIdentity getLastApp() {
            Object last;
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.apps);
            return ((RunningApp) last).getId();
        }

        @Nullable
        public final Messenger getMessenger() {
            return this.messenger;
        }

        public final int getPid() {
            return this.pid;
        }

        public final int getRunningAppCount() {
            return this.apps.size();
        }

        @NotNull
        public final RunningProcessState getState() {
            return this.state;
        }

        public final boolean has(@NotNull AppIdentity app) {
            Intrinsics.checkParameterIsNotNull(app, "app");
            LinkedList<RunningApp> linkedList = this.apps;
            if ((linkedList instanceof Collection) && linkedList.isEmpty()) {
                return false;
            }
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((RunningApp) it.next()).getId(), app)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: isNewEngine, reason: from getter */
        public final boolean getIsNewEngine() {
            return this.isNewEngine;
        }

        public final synchronized void onPreloaded() {
            if (this.state == RunningProcessState.STARTING) {
                this.state = RunningProcessState.PRELOAD;
            }
        }

        public final synchronized void onProcessStarted(@NotNull Bundle bundle) {
            boolean z16;
            Intrinsics.checkParameterIsNotNull(bundle, "bundle");
            if (this.deathNotifier == null) {
                bundle.setClassLoader(ProcessDeathNotifier.class.getClassLoader());
                Parcelable parcelable = bundle.getParcelable(IPCConst.KEY_CLIENT_PROCESS_DEATH_NOTIFIER);
                if (parcelable == null) {
                    Intrinsics.throwNpe();
                }
                ProcessDeathNotifier processDeathNotifier = (ProcessDeathNotifier) parcelable;
                this.deathNotifier = processDeathNotifier;
                if (processDeathNotifier == null) {
                    Intrinsics.throwNpe();
                }
                processDeathNotifier.observeDeath(new Runnable() { // from class: com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy$RunningProcessInfo$onProcessStarted$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameLaunchStrategy.RunningProcessInfo runningProcessInfo = GameLaunchStrategy.RunningProcessInfo.this;
                        runningProcessInfo.this$0.onProcessExited$lib_miniserver_internalRelease(runningProcessInfo);
                    }
                });
                int i3 = bundle.getInt(IPCConst.KEY_CLIENT_PROCESS_PID, -1);
                this.pid = i3;
                GameLaunchStrategy gameLaunchStrategy = this.this$0;
                if (i3 != -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    gameLaunchStrategy.debugThrow("can't get pid from bundle " + bundle);
                }
            }
        }

        public final synchronized void removeApp(@NotNull AppIdentity app) {
            Intrinsics.checkParameterIsNotNull(app, "app");
            Iterator<RunningApp> it = this.apps.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getId(), app)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                return;
            }
            this.apps.remove(i3).setState(RunningMiniAppState.STOPPED);
            this.state = RunningProcessState.RUNNING;
        }

        public final synchronized void restoreRunningApps(@NotNull List<? extends MiniAppInfo> runningApps) {
            int collectionSizeOrDefault;
            Set set;
            int collectionSizeOrDefault2;
            Set minus;
            int collectionSizeOrDefault3;
            Intrinsics.checkParameterIsNotNull(runningApps, "runningApps");
            List<? extends MiniAppInfo> list = runningApps;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(GameLaunchStrategy.INSTANCE.toId$lib_miniserver_internalRelease((MiniAppInfo) it.next()));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            LinkedList<RunningApp> linkedList = this.apps;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = linkedList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(((RunningApp) it5.next()).getId());
            }
            minus = SetsKt___SetsKt.minus(set, (Iterable) arrayList2);
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(minus, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator it6 = minus.iterator();
            while (it6.hasNext()) {
                RunningApp runningApp = new RunningApp((AppIdentity) it6.next());
                runningApp.setState(RunningMiniAppState.BACKGROUND);
                arrayList3.add(runningApp);
            }
            this.apps.addAll(0, arrayList3);
        }

        public final void setMessenger(@Nullable Messenger messenger) {
            this.messenger = messenger;
        }

        public final void setNewEngine(boolean z16) {
            this.isNewEngine = z16;
        }

        @NotNull
        public final String toSimpleString() {
            String substringAfter$default;
            String joinToString$default;
            StringBuilder sb5 = new StringBuilder();
            String str = this.config.processName;
            Intrinsics.checkExpressionValueIsNotNull(str, "config.processName");
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(str, ":", (String) null, 2, (Object) null);
            sb5.append(substringAfter$default);
            sb5.append(" ");
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        sb5.append("\u1f4beP");
                    }
                } else {
                    sb5.append("\u1f601R");
                }
            } else {
                sb5.append("\u1f680S");
            }
            sb5.append(" ");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.apps, ", ", "[ ", " ]", 0, null, new Function1<RunningApp, String>() { // from class: com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy$RunningProcessInfo$toSimpleString$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final String invoke(@NotNull RunningApp it) {
                    String str2;
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    StringBuilder sb6 = new StringBuilder();
                    int i16 = GameLaunchStrategy.RunningProcessInfo.WhenMappings.$EnumSwitchMapping$1[it.getState().ordinal()];
                    if (i16 == 1) {
                        str2 = "\u1f680S";
                    } else if (i16 == 2) {
                        str2 = "\u1f604F";
                    } else if (i16 == 3) {
                        str2 = "\u1f634B";
                    } else {
                        if (i16 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str2 = "\u2620\ufe0fS";
                    }
                    sb6.append(str2);
                    sb6.append(it.getId().toSimpleString());
                    return sb6.toString();
                }
            }, 24, null);
            sb5.append(joinToString$default);
            String sb6 = sb5.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb6, "StringBuilder().apply(builderAction).toString()");
            return sb6;
        }

        @VisibleForTesting
        public static /* synthetic */ void inspectApps$annotations() {
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void inspectRunningProcess$annotations() {
    }
}
