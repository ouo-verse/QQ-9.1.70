package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.g;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppInterface;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniAppInterface implements IMiniAppInterface {
    private static final String TAG = "minisdk-start_MiniAppInterface";

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniAppInterface
    public void onCreate(final Context context, final Configuration configuration) {
        QMLog.w(TAG, "onCreate");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.MiniAppInterface.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    g.b(context);
                    PreloadResource.g().preload(context.getApplicationContext(), configuration);
                } catch (Throwable th5) {
                    QMLog.e(MiniAppInterface.TAG, "", th5);
                }
            }
        });
    }
}
