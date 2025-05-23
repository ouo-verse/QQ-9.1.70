package com.tencent.imsdk.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IMContext {
    private static final String TAG = "IMContext";
    private Context mContext;
    private Handler mMainHandler;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class Holder {
        public static IMContext instance = new IMContext();

        Holder() {
        }
    }

    public static IMContext getInstance() {
        return Holder.instance;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void runOnMainThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    IMContext() {
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
