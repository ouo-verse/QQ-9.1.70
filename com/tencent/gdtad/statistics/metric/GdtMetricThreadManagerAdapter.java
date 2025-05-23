package com.tencent.gdtad.statistics.metric;

import android.os.Handler;
import com.tencent.ams.monitor.metric.m;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMetricThreadManagerAdapter implements m {

    /* renamed from: a, reason: collision with root package name */
    private Handler f109494a = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    @Override // com.tencent.ams.monitor.metric.m
    public boolean postDelayed(final Runnable runnable, int i3, long j3) {
        if (!ThreadManagerV2.getQQCommonThread().isAlive()) {
            QLog.e("GdtMetricThreadManagerAdapter", 1, "[postDelayed] do nothing, common thread is not alive");
            return false;
        }
        if (i3 != 1) {
            if (i3 != 10) {
                QLog.e("GdtMetricThreadManagerAdapter", 1, "[postDelayed] do nothing, unknown type, type:" + i3);
                return false;
            }
            return this.f109494a.postDelayed(new Runnable() { // from class: com.tencent.gdtad.statistics.metric.GdtMetricThreadManagerAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadManagerV2.excute(runnable, 128, null, true);
                }
            }, j3);
        }
        return this.f109494a.postDelayed(runnable, j3);
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean quitSafely() {
        return false;
    }
}
