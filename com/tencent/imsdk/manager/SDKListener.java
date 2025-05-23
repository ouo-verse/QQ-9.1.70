package com.tencent.imsdk.manager;

import com.tencent.imsdk.relationship.UserInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface SDKListener {
    void onConnectFailed(int i3, String str);

    void onConnectSuccess();

    void onConnecting();

    void onKickedOffline();

    void onLog(int i3, String str);

    void onSelfInfoUpdated(UserInfo userInfo);

    void onUserSigExpired();
}
