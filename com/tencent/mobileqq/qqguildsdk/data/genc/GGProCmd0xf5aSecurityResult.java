package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf5aSecurityResult;

/* loaded from: classes17.dex */
public class GGProCmd0xf5aSecurityResult implements IGProCmd0xf5aSecurityResult {
    public final GProCmd0xf5aSecurityResult mInfo;

    public GGProCmd0xf5aSecurityResult(GProCmd0xf5aSecurityResult gProCmd0xf5aSecurityResult) {
        this.mInfo = gProCmd0xf5aSecurityResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aSecurityResult
    public long getAction() {
        return this.mInfo.getAction();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aSecurityResult
    public String getDetail() {
        return this.mInfo.getDetail();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aSecurityResult
    public String getPrompt() {
        return this.mInfo.getPrompt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aSecurityResult
    public String toString() {
        return this.mInfo.toString();
    }
}
