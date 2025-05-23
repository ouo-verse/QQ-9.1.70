package com.qzone.common.activities.base;

import android.content.Context;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
@Named("CustomListViewFragmentPublishQueueImp")
/* loaded from: classes39.dex */
public class ah implements d5.x {
    @Inject
    public ah() {
    }

    @Override // d5.x
    public boolean a(Context context) {
        if (!QZonePublishQueue.F || NetworkState.isWifiConn()) {
            return false;
        }
        QZonePublishQueue.w().b0(context);
        QZonePublishQueue.F = false;
        return true;
    }

    @Override // d5.x
    public void b() {
        QZonePublishQueue.w().c0();
    }

    @Override // d5.x
    public void c() {
        QZonePublishQueue.w().d0();
    }
}
