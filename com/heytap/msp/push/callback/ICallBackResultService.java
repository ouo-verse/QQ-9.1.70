package com.heytap.msp.push.callback;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ICallBackResultService {
    void onGetNotificationStatus(int i3, int i16);

    void onGetPushStatus(int i3, int i16);

    void onRegister(int i3, String str);

    void onSetPushTime(int i3, String str);

    void onUnRegister(int i3);
}
