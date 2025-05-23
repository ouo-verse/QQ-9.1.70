package com.qzone.proxy.vipcomponent.adapter;

import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IVipManager {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface IEnvironment {
        void dealResultAfterRequestSucceed(int i3, ResultWrapper resultWrapper);

        void sendRequest(int i3, JceStruct jceStruct, String str, ServiceCallbackWrapper serviceCallbackWrapper, RequestCallbackListener requestCallbackListener);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface RequestCallbackListener {
        void onFailed(ResultWrapper resultWrapper, int i3);

        void onSucceed(ResultWrapper resultWrapper, int i3);
    }

    void getVipReminder(long j3, int i3, String str, int i16, ServiceCallbackWrapper serviceCallbackWrapper);

    void init(IEnvironment iEnvironment);

    void reportPayFailedReminder(String str, int i3, int i16, String str2, ServiceCallbackWrapper serviceCallbackWrapper);

    void reportReminder(long j3, int i3, int i16, String str, ServiceCallbackWrapper serviceCallbackWrapper);
}
