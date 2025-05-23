package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQZonePushApi;
import java.util.Map;

/* loaded from: classes34.dex */
public class QZonePushApiImpl implements IQZonePushApi {
    private static final String TAG = "QZonePushApiImpl";

    @Override // com.tencent.qzonehub.api.IQZonePushApi
    public void handleSilentPush(String str, Map<String, String> map) {
        vm.a.f441845a.a(str, map);
    }
}
