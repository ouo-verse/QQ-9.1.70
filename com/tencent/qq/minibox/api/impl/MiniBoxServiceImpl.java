package com.tencent.qq.minibox.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.MiniBoxAppInterface;
import com.tencent.qq.minibox.api.IMiniBoxService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us3.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016JH\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020#H\u0016J\"\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0004H\u0016J.\u00107\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u00106\u001a\u000205H\u0016J\u0012\u00108\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020:2\u0006\u00109\u001a\u00020\u0002H\u0016J$\u0010?\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u00109\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\b\u0010A\u001a\u00020\u0004H\u0016R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/qq/minibox/api/impl/MiniBoxServiceImpl;", "Lcom/tencent/qq/minibox/api/IMiniBoxService;", "", "toggleName", "", "isFeatureSwitchEnable", "Lmqq/app/MobileQQ;", "app", "procName", "Lmqq/app/AppRuntime;", "createAppInterface", "isMiniBoxFeatureSwitchEnable", "isMiniBoxSystemInstallSwitchEnable", "isNativeCrashed", "crashType", "crashAddress", "crashStack", "", "nativeSICODE", "", "crashTime", "processName", "", "reportCrash", "getAllCacheSize", "isDeleteFile", "clearAllCache", "clearMMKVCache", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getMiniBoxIPCModule", "isMiniBoxNoticeSwitchEnanle", "", "getToggleParams", "moduleName", "isMiniBoxHippyModule", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getHippyModuleProvider", "pid", "action", "Landroid/os/Bundle;", "params", "notifyClient", "Ljava/lang/Class;", "Lks3/b;", "getJumpParserClass", "dexVersion", "isMatchVAPlugin", "clearDir", "updatePlugin", "defaultAvailable", "timeout", "", "crashStackRules", "Lbs3/b;", "checkListener", "checkMiniBoxAvailable", "checkIsAvailableCrash", "appId", "Lkotlin/Pair;", "isDexBlockApp", "Landroid/content/Context;", "context", "oldDexVersion", "checkAndClearDexCrashRecord", "isForceLaunchLocal", "isMountServiceHookFailed", "Lcom/tencent/qq/minibox/api/impl/AvailableCheckTask;", "availableCheckTask", "Lcom/tencent/qq/minibox/api/impl/AvailableCheckTask;", "<init>", "()V", "Companion", "a", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxServiceImpl implements IMiniBoxService {

    @NotNull
    private static final String TAG = "MiniBoxServiceImpl";

    @Nullable
    private AvailableCheckTask availableCheckTask;

    private final boolean isFeatureSwitchEnable(String toggleName) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = false;
        if (peekAppRuntime != null) {
            z16 = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(toggleName, false);
        }
        QLog.d(TAG, 2, '[' + toggleName + "] " + z16);
        return z16;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void checkAndClearDexCrashRecord(@Nullable Context context, @NotNull String appId, @Nullable String oldDexVersion) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        gs3.c.f403270a.c(context, appId, oldDexVersion);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void checkIsAvailableCrash(@Nullable String crashStack) {
        QLog.d(TAG, 2, "checkIsAvailableCrash crashStack:" + crashStack);
        if (crashStack != null) {
            AvailableCheckTask availableCheckTask = this.availableCheckTask;
            boolean z16 = false;
            if (availableCheckTask != null && availableCheckTask.l(crashStack)) {
                z16 = true;
            }
            if (z16) {
                this.availableCheckTask = null;
            }
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void checkMiniBoxAvailable(boolean defaultAvailable, int timeout, @NotNull List<String> crashStackRules, @NotNull bs3.b checkListener) {
        Intrinsics.checkNotNullParameter(crashStackRules, "crashStackRules");
        Intrinsics.checkNotNullParameter(checkListener, "checkListener");
        if (this.availableCheckTask == null) {
            this.availableCheckTask = new AvailableCheckTask();
        }
        AvailableCheckTask availableCheckTask = this.availableCheckTask;
        if (availableCheckTask != null) {
            availableCheckTask.g(checkListener);
        }
        AvailableCheckTask availableCheckTask2 = this.availableCheckTask;
        if (availableCheckTask2 != null) {
            availableCheckTask2.m(Boolean.valueOf(defaultAvailable), timeout, crashStackRules);
        }
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void clearAllCache(boolean isDeleteFile) {
        MiniBoxSDK.clearAllCache(BaseApplication.getContext(), isDeleteFile);
        m.f439991a.c();
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void clearMMKVCache() {
        m.f439991a.c();
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @Nullable
    public AppRuntime createAppInterface(@Nullable MobileQQ app, @Nullable String procName) {
        return new MiniBoxAppInterface(app, procName);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public long getAllCacheSize() {
        return MiniBoxSDK.getAllCacheSize(BaseApplication.getContext());
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @NotNull
    public HippyAPIProvider getHippyModuleProvider() {
        return new hs3.b();
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @NotNull
    public Class<ks3.b> getJumpParserClass() {
        return ks3.b.class;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @NotNull
    public QIPCModule getMiniBoxIPCModule() {
        return js3.a.f410940d;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @NotNull
    public Map<String, String> getToggleParams(@NotNull String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) runtimeService).isEnabledWithDataSet(toggleName, "");
        if (isEnabledWithDataSet == null) {
            return new HashMap();
        }
        return isEnabledWithDataSet;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    @NotNull
    public Pair<Boolean, String> isDexBlockApp(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return gs3.c.f403270a.j(appId);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isForceLaunchLocal() {
        return false;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMatchVAPlugin(@NotNull String dexVersion) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(dexVersion, "dexVersion");
        if (!TextUtils.isEmpty(dexVersion)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(dexVersion, "0.5.2", false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMiniBoxFeatureSwitchEnable() {
        return isFeatureSwitchEnable("minibox_feature_switch");
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMiniBoxHippyModule(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        if (!TextUtils.equals(moduleName, HippyQQConstants.ModuleName.QQ_MINI_BOX) && !TextUtils.equals(moduleName, HippyQQConstants.ModuleName.QQ_MINI_GAME_VIRTUAL)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMiniBoxNoticeSwitchEnanle() {
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).exposeReportForHome();
        return isFeatureSwitchEnable("minibox_notice_switch");
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMiniBoxSystemInstallSwitchEnable() {
        return isFeatureSwitchEnable("minibox_system_install");
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public boolean isMountServiceHookFailed() {
        boolean g16 = m.f439991a.g("is_mount_service_hook_failed");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isMountServiceHookFailed isFailed:" + g16);
        }
        return g16;
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void notifyClient(int pid, @NotNull String action, @Nullable Bundle params) {
        Intrinsics.checkNotNullParameter(action, "action");
        MiniBoxSDK.notifyClient(pid, action, params);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void reportCrash(boolean isNativeCrashed, @Nullable String crashType, @Nullable String crashAddress, @Nullable String crashStack, int nativeSICODE, long crashTime, @Nullable String processName) {
        gs3.c.f403270a.l(isNativeCrashed, crashType, crashAddress, crashStack, nativeSICODE, crashTime, processName);
    }

    @Override // com.tencent.qq.minibox.api.IMiniBoxService
    public void updatePlugin(boolean clearDir) {
        if (clearDir) {
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = BaseApplication.getContext();
            }
            MiniBoxSDK.clearPluginSafely(context);
        }
    }
}
