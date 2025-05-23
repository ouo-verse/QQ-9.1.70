package org.light.listener;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface OnLoadAssetListener {
    void OnAssetDurationChange(long j3);

    void OnAssetProcessing(HashMap<String, String> hashMap);

    void OnLoadAssetError(int i3);
}
