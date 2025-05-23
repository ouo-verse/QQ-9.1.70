package com.tencent.biz.common.offline;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Handler f78445a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static d f78446a = new d();
    }

    d() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HtmlOffline");
        baseHandlerThread.start();
        this.f78445a = new Handler(baseHandlerThread.getLooper());
        if (QLog.isColorLevel()) {
            QLog.d("HtmlCheckUpdate", 2, "init thread");
        }
    }

    public static d a() {
        return a.f78446a;
    }

    public void b(Runnable runnable) {
        this.f78445a.post(runnable);
    }

    public void c(Runnable runnable, long j3) {
        this.f78445a.postDelayed(runnable, j3);
    }
}
