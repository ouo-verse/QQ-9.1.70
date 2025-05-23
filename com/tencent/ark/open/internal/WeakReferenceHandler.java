package com.tencent.ark.open.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ark.Logger;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WeakReferenceHandler extends Handler {
    private final WeakReference<Handler.Callback> mWeakReferCallback;

    public WeakReferenceHandler(Looper looper, Handler.Callback callback) {
        super(looper);
        this.mWeakReferCallback = new WeakReference<>(callback);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler.Callback callback = this.mWeakReferCallback.get();
        if (callback != null) {
            callback.handleMessage(message);
            return;
        }
        Logger.logD("WeakReferenceHandler", "handleMessage cb is null! handler = " + this);
    }
}
