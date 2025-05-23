package com.tencent.luggage.wxa.bo;

import android.os.Looper;
import android.os.MessageQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageQueue.IdleHandler f123088a;

        public a(MessageQueue.IdleHandler idleHandler) {
            this.f123088a = idleHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(this.f123088a);
        }
    }

    public static void a(MessageQueue.IdleHandler idleHandler) {
        if (idleHandler == null) {
            return;
        }
        Looper.getMainLooper().getQueue().addIdleHandler(idleHandler);
    }
}
