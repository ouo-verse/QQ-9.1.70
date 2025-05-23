package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bb implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 1) {
            b(z16, bundle);
        } else if (i3 == 2) {
            a(z16, bundle);
        }
    }

    public void a(boolean z16, Bundle bundle) {
    }

    public void b(boolean z16, Bundle bundle) {
    }
}
