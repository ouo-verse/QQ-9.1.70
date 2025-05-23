package com.qq.e.comm.pi;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITGChangeBackgroundStatusManager {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IChangeBackgroundStatusCallBack {
        void onBackground();

        void onForeground();
    }

    void register(WeakReference<IChangeBackgroundStatusCallBack> weakReference);

    void unRegister(WeakReference<IChangeBackgroundStatusCallBack> weakReference);
}
