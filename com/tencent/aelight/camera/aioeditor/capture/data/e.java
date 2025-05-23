package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        switch (i3) {
            case 967:
                d();
                return;
            case 968:
                c(z16, bundle);
                return;
            case 969:
                e();
                return;
            case 970:
                a(bundle);
                return;
            case 971:
                b();
                return;
            default:
                return;
        }
    }

    public void a(Bundle bundle) {
    }

    public void b() {
    }

    public void d() {
    }

    public void e() {
    }

    public void c(boolean z16, Bundle bundle) {
    }
}
