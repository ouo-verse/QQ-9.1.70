package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DebugHelper {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f348353a;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final DebugHelper f348355a = new DebugHelper();
    }

    public static DebugHelper d() {
        return a.f348355a;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            QMLog.e("DebugHelper", "getDebugEnabled appId is null or empty!");
            return false;
        }
        if (this.f348353a == null) {
            QMLog.e("DebugHelper", "mDebugEnabled is null!");
            this.f348353a = Boolean.valueOf(StorageUtil.getPreference().getBoolean(str + "_debug", false));
        }
        QMLog.d("DebugHelper", "getDebugEnabled:" + this.f348353a);
        return this.f348353a.booleanValue();
    }

    public void e(final String str) {
        if (TextUtils.isEmpty(str)) {
            QMLog.e("DebugHelper", "preloadDebugEnableInfo appId is null or empty!");
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.DebugHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    DebugHelper.this.f348353a = Boolean.valueOf(StorageUtil.getPreference().getBoolean(str + "_debug", false));
                    QMLog.d("DebugHelper", "preloadDebugEnableInfo appId:" + str + " mDebugEnabled:" + DebugHelper.this.f348353a);
                }
            });
        }
    }

    DebugHelper() {
    }
}
