package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.videostory.config.VSConfigManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VSConfigManagerImpl implements IVSConfigManager {
    private static final String TAG = "VSConfigManagerImpl";

    @Override // com.tencent.aelight.camera.util.api.IVSConfigManager
    public <V> V getValue(String str, V v3) {
        try {
            return (V) VSConfigManager.c().e(str, v3);
        } catch (Error e16) {
            e16.printStackTrace();
            return v3;
        }
    }

    @Override // com.tencent.aelight.camera.util.api.IVSConfigManager
    public <V> void setValue(String str, V v3) {
        VSConfigManager.c().j(str, v3);
    }
}
