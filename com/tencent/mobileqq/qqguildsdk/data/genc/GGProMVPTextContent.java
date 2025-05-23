package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPTextContent;

/* loaded from: classes17.dex */
public class GGProMVPTextContent implements IGProMVPTextContent {
    public final GProMVPTextContent mInfo;

    public GGProMVPTextContent(GProMVPTextContent gProMVPTextContent) {
        this.mInfo = gProMVPTextContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTextContent
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTextContent
    public String toString() {
        return this.mInfo.toString();
    }
}
