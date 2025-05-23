package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class ServiceWorkerController {
    public static ServiceWorkerController getInstance(Context context) {
        p a16 = p.a();
        a16.a(context);
        if (a16.b()) {
            final IX5CoreServiceWorkerController q16 = p.a().c().q();
            if (q16 == null) {
                return null;
            }
            return new ServiceWorkerController() { // from class: com.tencent.smtt.sdk.ServiceWorkerController.1
                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                    return IX5CoreServiceWorkerController.this.getServiceWorkerWebSettings();
                }

                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
                    IX5CoreServiceWorkerController.this.setServiceWorkerClient(serviceWorkerClient);
                }
            };
        }
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new k();
    }

    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);
}
