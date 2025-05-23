package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelStorageCleanListener {
    void onChatCleanDone(String str, int i3);

    void onCleanCacheProgressChanged(int i3, int i16);

    void onCleanCacheStorageChanged(ArrayList<Long> arrayList);

    void onFinishScan(ArrayList<Long> arrayList);

    void onScanCacheProgressChanged(int i3, int i16);
}
