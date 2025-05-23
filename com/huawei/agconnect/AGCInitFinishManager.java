package com.huawei.agconnect;

import com.huawei.agconnect.core.a.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback aGCInitFinishCallback);
}
