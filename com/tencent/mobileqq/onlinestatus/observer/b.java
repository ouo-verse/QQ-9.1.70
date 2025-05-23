package com.tencent.mobileqq.onlinestatus.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        QLog.d("OnlineStatusAggregationObserver", 1, "type=" + i3 + ", isSuccess=" + z16);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        b(z16, (Bundle) obj);
                        return;
                    }
                    return;
                }
                c(z16, (Map) obj);
                return;
            }
            a(z16, obj);
            return;
        }
        d(z16, (Bundle) obj);
    }

    protected void a(boolean z16, Object obj) {
    }

    protected void b(boolean z16, Bundle bundle) {
    }

    protected void c(boolean z16, Map<String, Object> map) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z16, Bundle bundle) {
    }
}
