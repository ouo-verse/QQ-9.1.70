package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/ipc/remote/RedTouchIPC;", "Lcom/tencent/mobileqq/vas/ipc/remote/IRedTouchIPC;", "()V", "getAppInfo", "", "path", "getRedTouchManager", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "onRedTouchItemClick", "", "reportLevelOne", AdMetricTag.Report.TYPE, "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class RedTouchIPC implements IRedTouchIPC {
    @Override // com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC
    @Nullable
    public String getAppInfo(@NotNull String path) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(path, "path");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = getRedTouchManager().getAppInfoByPath(path);
        if (appInfoByPath != null) {
            bArr = appInfoByPath.toByteArray();
        } else {
            bArr = null;
        }
        return PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 0);
    }

    @NotNull
    public final IRedTouchManager getRedTouchManager() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        return (IRedTouchManager) runtimeService;
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC
    public void onRedTouchItemClick(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        getRedTouchManager().onRedTouchItemClick(path);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.IRedTouchIPC
    public void reportLevelOne(@NotNull String path, int reportType) {
        Intrinsics.checkNotNullParameter(path, "path");
        getRedTouchManager().reportLevelOneRedInfo(path, reportType);
    }
}
