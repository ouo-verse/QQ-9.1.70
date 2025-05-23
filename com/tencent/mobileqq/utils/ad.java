package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ad extends MqqHandler {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<Handler.Callback> f307400d;

    public ad(Looper looper, Handler.Callback callback) {
        super(looper);
        this.f307400d = new WeakReference<>(callback);
    }

    @Override // mqq.os.MqqHandler
    public void handleMessage(Message message) {
        Handler.Callback callback = this.f307400d.get();
        if (callback != null) {
            callback.handleMessage(message);
        }
    }

    @Override // mqq.os.MqqHandler
    public String toString() {
        return super.toString() + " " + this.f307400d.get();
    }
}
