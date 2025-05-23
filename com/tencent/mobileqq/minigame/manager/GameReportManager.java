package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameReportManager {
    private final String TAG = toString();
    private boolean firstFrame = false;
    private boolean jsError = false;
    private volatile MiniAppConfig mAppConfig;

    public void onFirstFrame() {
        try {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GameReportManager.2
                @Override // java.lang.Runnable
                public void run() {
                    GameReportManager.this.firstFrame = true;
                }
            });
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "onFirstFrame", th5);
        }
    }

    public void setAppConfig(MiniAppConfig miniAppConfig) {
        this.mAppConfig = miniAppConfig;
    }

    public void onJsError() {
        try {
            if (this.jsError) {
                return;
            }
            this.jsError = true;
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GameReportManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GameReportManager.this.firstFrame || GameReportManager.this.mAppConfig == null) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("app_config", GameReportManager.this.mAppConfig);
                    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LAUNCH_REPORT_JS_ERROR, bundle);
                }
            });
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "onJsError", th5);
        }
    }
}
