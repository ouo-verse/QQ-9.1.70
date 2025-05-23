package com.tencent.mobileqq.minigame.report;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/StartupReportDispatcher;", "", "()V", "TAG", "", "sIsMainProcess", "", "reportAsync", "", "param", "Lcom/tencent/qqmini/sdk/launcher/model/StartupReportData;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class StartupReportDispatcher {
    private static final String TAG = "StartupReportDispatcher";
    public static final StartupReportDispatcher INSTANCE = new StartupReportDispatcher();
    private static final boolean sIsMainProcess = com.tencent.mobileqq.util.g.b();

    StartupReportDispatcher() {
    }

    @JvmStatic
    public static final void reportAsync(final StartupReportData param) {
        Intrinsics.checkNotNullParameter(param, "param");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.l
            @Override // java.lang.Runnable
            public final void run() {
                StartupReportDispatcher.reportAsync$lambda$0(StartupReportData.this);
            }
        }, 160, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportAsync$lambda$0(StartupReportData param) {
        Intrinsics.checkNotNullParameter(param, "$param");
        if (!sIsMainProcess) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(StartupReportData.class.getClassLoader());
            bundle.putParcelable("data", param);
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_STARTUP_REPORT, bundle);
            return;
        }
        try {
            MiniGameStartupReporter.report(param);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "MiniGameStartupReporter.report exception=", e16);
        }
    }
}
