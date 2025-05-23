package com.tencent.gdtad.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class m implements AdProcessManagerAdapter {
    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @NonNull
    public String getMainProcessName() {
        return "com.tencent.mobileqq";
    }

    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @NonNull
    public String getWebProcessName() {
        return "com.tencent.mobileqq:tool";
    }

    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @Nullable
    public Boolean isOnMainProcess() {
        if (BaseApplicationImpl.getApplication() == null || BaseApplicationImpl.getApplication().getRuntime() == null) {
            return null;
        }
        return Boolean.valueOf(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface);
    }

    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @Nullable
    public Boolean isOnWebProcess() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            String currentProcessName = AdProcessManager.getInstance().getCurrentProcessName(application);
            if (TextUtils.isEmpty(currentProcessName)) {
                return null;
            }
            return Boolean.valueOf(TextUtils.equals(currentProcessName, AdProcessManager.getInstance().getWebProcessName()));
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @Nullable
    public Boolean isWebProcessRunning() {
        AppRuntime runtime;
        Boolean isWebProcessRunningForPreloading = isWebProcessRunningForPreloading();
        if (isWebProcessRunningForPreloading != null && isWebProcessRunningForPreloading.booleanValue()) {
            return Boolean.TRUE;
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null && (runtime = application.getRuntime()) != null && (runtime instanceof QQAppInterface)) {
            try {
                return Boolean.valueOf(QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"));
            } catch (Throwable th5) {
                GdtLog.e("GdtProcessManagerAdapter", "isWebProcessRunning", th5);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.ad.tangram.process.AdProcessManagerAdapter
    @Nullable
    public Boolean isWebProcessRunningForPreloading() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null || (runtime = application.getRuntime()) == null || !(runtime instanceof ToolAppRuntime)) {
            return null;
        }
        return Boolean.valueOf(SwiftBrowserStatistics.f314343h1);
    }
}
