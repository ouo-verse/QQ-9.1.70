package com.tencent.tbs.one.optional;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TBSOneStandaloneService extends Service {
    public static final String IMPL_CLASS_NAME_KEY = "implClassName";

    /* renamed from: a, reason: collision with root package name */
    private ServiceImpl f375106a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl == null) {
            return null;
        }
        return serviceImpl.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        ServiceImpl serviceImpl;
        if (intent == null) {
            return 2;
        }
        String stringExtra = intent.getStringExtra(IMPL_CLASS_NAME_KEY);
        if (!TextUtils.isEmpty(stringExtra) && ((serviceImpl = this.f375106a) == null || !serviceImpl.getClass().getName().equals(stringExtra))) {
            ServiceImpl serviceImpl2 = this.f375106a;
            if (serviceImpl2 != null) {
                serviceImpl2.onDestroy();
                this.f375106a = null;
            }
            try {
                ServiceImpl serviceImpl3 = (ServiceImpl) Class.forName(stringExtra).newInstance();
                this.f375106a = serviceImpl3;
                serviceImpl3.setBaseService(this);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            ServiceImpl serviceImpl4 = this.f375106a;
            if (serviceImpl4 != null) {
                serviceImpl4.onCreate();
            }
        }
        ServiceImpl serviceImpl5 = this.f375106a;
        if (serviceImpl5 == null) {
            return 2;
        }
        return serviceImpl5.onStartCommand(intent, i3, i16);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl != null) {
            serviceImpl.onTrimMemory(i3);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ServiceImpl serviceImpl = this.f375106a;
        if (serviceImpl == null) {
            return super.onUnbind(intent);
        }
        return serviceImpl.onUnbind(intent);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class ServiceImpl {

        /* renamed from: a, reason: collision with root package name */
        protected Service f375107a;

        public IBinder onBind(Intent intent) {
            return null;
        }

        public abstract int onStartCommand(Intent intent, int i3, int i16);

        public boolean onUnbind(Intent intent) {
            return false;
        }

        public void setBaseService(Service service) {
            this.f375107a = service;
        }

        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void onLowMemory() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onRebind(Intent intent) {
        }

        public void onTaskRemoved(Intent intent) {
        }

        public void onTrimMemory(int i3) {
        }
    }
}
