package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Servlet {
    private ServletContainer container;
    private AppRuntime mAppRuntime;

    public AppRuntime getAppRuntime() {
        return this.mAppRuntime;
    }

    ServletContainer getServletContainer() {
        return this.container;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(AppRuntime appRuntime, ServletContainer servletContainer) {
        this.mAppRuntime = appRuntime;
        this.container = servletContainer;
    }

    public void notifyObserver(Intent intent, int i3, boolean z16, Bundle bundle, Class<? extends BusinessObserver> cls) {
        BusinessObserver observer;
        if ((intent instanceof NewIntent) && (observer = ((NewIntent) intent).getObserver()) != null) {
            getAppRuntime().notifyObserver(observer, i3, z16, bundle);
        }
        getAppRuntime().notifyObservers(cls, i3, z16, bundle);
    }

    public abstract void service(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }
}
