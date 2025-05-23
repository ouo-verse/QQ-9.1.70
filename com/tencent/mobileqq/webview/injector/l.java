package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/injector/l;", "Lcom/tencent/smtt/sdk/QbSdk$TbsInstallerCallBack;", "", "Ljava/io/File;", "files", "", "onCoreRenameFinished", "([Ljava/io/File;)V", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l implements QbSdk.TbsInstallerCallBack {
    @Override // com.tencent.smtt.sdk.QbSdk.TbsInstallerCallBack
    public void onCoreRenameFinished(File[] files) {
        if (QLog.isColorLevel()) {
            QLog.d("TbsSoInstallCallback", 2, "onCoreRenameFinished:", Arrays.toString(files));
        }
        if (files != null) {
            for (File file : files) {
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.getContext(), file.getPath());
            }
        }
    }
}
