package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPAtContent;

/* loaded from: classes17.dex */
public class GGProMVPAtContent implements IGProMVPAtContent {
    public final GProMVPAtContent mInfo;

    public GGProMVPAtContent(GProMVPAtContent gProMVPAtContent) {
        this.mInfo = gProMVPAtContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public String getAtAllText() {
        return this.mInfo.getAtAllText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public IGProMVPRoleGroup getRoleGroup() {
        return new GGProMVPRoleGroup(this.mInfo.getRoleGroup());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public IGProMVPUser getUser() {
        return new GGProMVPUser(this.mInfo.getUser());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPAtContent
    public String toString() {
        return this.mInfo.toString();
    }
}
