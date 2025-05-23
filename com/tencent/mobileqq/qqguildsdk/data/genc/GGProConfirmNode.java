package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProConfirmNode;

/* loaded from: classes17.dex */
public class GGProConfirmNode implements IGProConfirmNode {
    public final GProConfirmNode mInfo;

    public GGProConfirmNode(GProConfirmNode gProConfirmNode) {
        this.mInfo = gProConfirmNode;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmNode
    public String getButtonMsg() {
        return this.mInfo.getButtonMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmNode
    public boolean getCancelOpt() {
        return this.mInfo.getCancelOpt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmNode
    public String getConfirmExt() {
        return this.mInfo.getConfirmExt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmNode
    public String toString() {
        return this.mInfo.toString();
    }
}
