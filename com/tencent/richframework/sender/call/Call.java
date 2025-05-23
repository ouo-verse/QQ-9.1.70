package com.tencent.richframework.sender.call;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface Call<T> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnRspCallBack<T> {
        void onReceive(boolean z16, long j3, String str, T t16, Object obj, Bundle bundle);
    }

    void execute();
}
