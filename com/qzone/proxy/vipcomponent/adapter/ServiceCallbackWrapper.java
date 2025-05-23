package com.qzone.proxy.vipcomponent.adapter;

import android.os.Handler;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ServiceCallbackWrapper {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Handler> f51003a;

    ServiceCallbackWrapper() {
    }

    public static ServiceCallbackWrapper obtain(Handler handler) {
        ServiceCallbackWrapper serviceCallbackWrapper = new ServiceCallbackWrapper();
        serviceCallbackWrapper.f51003a = new WeakReference<>(handler);
        return serviceCallbackWrapper;
    }

    public Handler getRealCallback() {
        WeakReference<Handler> weakReference = this.f51003a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void onResult(ResultWrapper resultWrapper) {
        if (resultWrapper == null || resultWrapper.getResult() == null) {
            return;
        }
        WeakReference<Handler> weakReference = this.f51003a;
        Handler handler = weakReference == null ? null : weakReference.get();
        if (handler != null) {
            resultWrapper.getResult().sendToHandler(handler);
        } else if (QZLog.isColorLevel()) {
            QZLog.i("Feeds", 2, "****ServiceCallbackWrapper Handler is null");
        }
    }
}
