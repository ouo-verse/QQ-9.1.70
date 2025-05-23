package com.tencent.component.media.utils;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseHandler extends Handler {
    public BaseHandler() {
    }

    public BaseHandler(Looper looper) {
        super(looper);
    }

    @TargetApi(3)
    public BaseHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
