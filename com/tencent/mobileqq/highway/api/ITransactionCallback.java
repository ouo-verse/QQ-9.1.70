package com.tencent.mobileqq.highway.api;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ITransactionCallback {
    void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap);

    void onSuccess(byte[] bArr, HashMap<String, String> hashMap);

    void onSwitch2BackupChannel();

    void onTransStart();

    void onUpdateProgress(int i3);
}
