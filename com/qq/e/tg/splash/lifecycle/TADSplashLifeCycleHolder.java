package com.qq.e.tg.splash.lifecycle;

import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TADSplashLifeCycleHolder {

    /* renamed from: a, reason: collision with root package name */
    private static volatile TADSplashLifeCycleHolder f40845a;

    /* renamed from: b, reason: collision with root package name */
    private final List<SplashLifeCycleCallback> f40846b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<SplashLifeCycleCallback> f40847c = new CopyOnWriteArrayList();

    TADSplashLifeCycleHolder() {
    }

    public static TADSplashLifeCycleHolder getInstance() {
        if (f40845a == null) {
            synchronized (TADSplashLifeCycleHolder.class) {
                if (f40845a == null) {
                    f40845a = new TADSplashLifeCycleHolder();
                }
            }
        }
        return f40845a;
    }

    public void addListener(boolean z16, SplashLifeCycleCallback splashLifeCycleCallback) {
        List<SplashLifeCycleCallback> list;
        if (splashLifeCycleCallback == null) {
            return;
        }
        if (z16) {
            list = this.f40847c;
        } else {
            list = this.f40846b;
        }
        list.add(splashLifeCycleCallback);
    }

    public void clear(boolean z16) {
        List<SplashLifeCycleCallback> list;
        if (z16) {
            list = this.f40847c;
        } else {
            list = this.f40846b;
        }
        list.clear();
    }

    public void notifySplashDismiss(boolean z16) {
        List<SplashLifeCycleCallback> list;
        GDTLogger.i("notifySplashDismiss :" + z16);
        if (z16) {
            list = this.f40847c;
        } else {
            list = this.f40846b;
        }
        for (SplashLifeCycleCallback splashLifeCycleCallback : list) {
            if (splashLifeCycleCallback != null) {
                splashLifeCycleCallback.onSplashDismiss(z16);
            }
        }
    }

    public void notifySplashExposure(boolean z16) {
        List<SplashLifeCycleCallback> list;
        GDTLogger.i("notifySplashExposure :" + z16);
        if (z16) {
            list = this.f40847c;
        } else {
            list = this.f40846b;
        }
        for (SplashLifeCycleCallback splashLifeCycleCallback : list) {
            if (splashLifeCycleCallback != null) {
                splashLifeCycleCallback.onSplashExposure(z16);
            }
        }
    }

    public void removeListener(boolean z16, SplashLifeCycleCallback splashLifeCycleCallback) {
        List<SplashLifeCycleCallback> list;
        if (splashLifeCycleCallback == null) {
            return;
        }
        if (z16) {
            list = this.f40847c;
        } else {
            list = this.f40846b;
        }
        list.remove(splashLifeCycleCallback);
    }
}
