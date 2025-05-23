package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.hz;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private a f387972a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<BaseService> f387973a;

        public a(WeakReference<BaseService> weakReference) {
            this.f387973a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.f387973a) != null && (baseService = weakReference.get()) != null) {
                jz4.c.z("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.mo298a()) {
                    baseService.stopSelf();
                } else {
                    jz4.c.z("TimeoutHandler has job");
                    sendEmptyMessageDelayed(1001, 1000L);
                }
            }
        }
    }

    /* renamed from: a */
    protected abstract boolean mo298a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
        if (this.f387972a == null) {
            this.f387972a = new a(new WeakReference(this));
        }
        this.f387972a.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        int onStartCommand = super.onStartCommand(intent, i3, i16);
        if (!hz.j(this)) {
            return 2;
        }
        return onStartCommand;
    }
}
