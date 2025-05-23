package com.tencent.qzonehub.api.impl;

import android.content.Context;
import com.tencent.qzonehub.api.ISimManagerApi;
import cooperation.qzone.sim.SimInfo;
import cooperation.qzone.sim.SimManager;
import cooperation.qzone.sim.SimManagerFectory;

/* compiled from: P */
/* loaded from: classes34.dex */
public class SimManagerApiImpl implements ISimManagerApi {
    private SimManager simManager;

    @Override // com.tencent.qzonehub.api.ISimManagerApi
    public ISimManagerApi createProduct(String str, int i3) {
        this.simManager = SimManagerFectory.createProduct(str, i3);
        return this;
    }

    @Override // com.tencent.qzonehub.api.ISimManagerApi
    public SimInfo getDataSimInfo() {
        SimManager simManager = this.simManager;
        if (simManager == null) {
            return null;
        }
        return simManager.getDataSimInfo();
    }

    @Override // com.tencent.qzonehub.api.ISimManagerApi
    public void initAllInfo(Context context) {
        SimManager simManager = this.simManager;
        if (simManager != null) {
            simManager.initAllInfo(context);
        }
    }
}
