package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class av implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        switch (i3) {
            case 1:
                f(z16, (Bundle) obj);
                return;
            case 2:
                g(z16, (Bundle) obj);
                return;
            case 3:
                i(z16, (Bundle) obj);
                return;
            case 4:
                b(z16, (Bundle) obj);
                return;
            case 5:
                c(z16);
                return;
            case 6:
                a(z16);
                return;
            case 7:
                e(z16, (Bundle) obj);
                return;
            case 8:
                j(z16, (pc2.a) obj);
                return;
            case 9:
            default:
                return;
            case 10:
                h(z16, (Bundle) obj);
                return;
            case 11:
                d(z16, (Bundle) obj);
                return;
        }
    }

    public void a(boolean z16) {
    }

    public void c(boolean z16) {
    }

    public void b(boolean z16, Bundle bundle) {
    }

    public void d(boolean z16, Bundle bundle) {
    }

    public void e(boolean z16, Bundle bundle) {
    }

    public void f(boolean z16, Bundle bundle) {
    }

    public void g(boolean z16, Bundle bundle) {
    }

    public void h(boolean z16, Bundle bundle) {
    }

    public void i(boolean z16, Bundle bundle) {
    }

    public void j(boolean z16, pc2.a aVar) {
    }
}
