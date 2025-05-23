package com.tencent.bugly.traffic.custom;

import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.logger.Logger;
import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Okhttp3ListenerFactory implements EventListener.Factory {
    private static final String TAG = "Okhttp3ListenerFactory";
    private final EventListener.Factory factory;

    public Okhttp3ListenerFactory(EventListener.Factory factory) {
        this.factory = factory;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(@NonNull Call call) {
        EventListener eventListener;
        EventListener.Factory factory = this.factory;
        if (factory != null) {
            eventListener = factory.create(call);
        } else {
            eventListener = null;
        }
        if (eventListener == null) {
            return new Okhttp3EventListener();
        }
        try {
            if (!eventListener.getClass().getName().startsWith("okhttp3")) {
                return eventListener;
            }
        } catch (Throwable th5) {
            Logger.f365497g.w(TAG, "get listener clz fail, throwable " + th5);
        }
        return new Okhttp3EventListener(eventListener);
    }
}
