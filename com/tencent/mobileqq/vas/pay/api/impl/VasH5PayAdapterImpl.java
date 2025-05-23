package com.tencent.mobileqq.vas.pay.api.impl;

import com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter;

/* loaded from: classes20.dex */
public class VasH5PayAdapterImpl implements IVasH5PayAdapter {
    @Override // com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter
    public String getDiyCardH5Pay() {
        return "diyCardH5Pay";
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter
    public String getSvipCallbackSN() {
        return "svip";
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter
    public long getWebViewTransparentConstants() {
        return 524288L;
    }
}
