package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationV2Info;

/* loaded from: classes17.dex */
public class GGProNavigationV2Info implements IGProNavigationV2Info {
    public final GProNavigationV2Info mInfo;

    public GGProNavigationV2Info(GProNavigationV2Info gProNavigationV2Info) {
        this.mInfo = gProNavigationV2Info;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public long getBeginVersion() {
        return this.mInfo.getBeginVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getBubbleDesc() {
        return this.mInfo.getBubbleDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public long getEndVersion() {
        return this.mInfo.getEndVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public IGProNavigationItemExt getExtInfo() {
        return new GGProNavigationItemExt(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public long getIconId() {
        return this.mInfo.getIconId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getJumpUrlAuditDesc() {
        return this.mInfo.getJumpUrlAuditDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public int getJumpUrlAuditStatus() {
        return this.mInfo.getJumpUrlAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public int getJumpUrlType() {
        return this.mInfo.getJumpUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public int getPlatForm() {
        return this.mInfo.getPlatForm();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public boolean getShowBubble() {
        return this.mInfo.getShowBubble();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getTitleAuditDesc() {
        return this.mInfo.getTitleAuditDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public int getTitleAuditStatus() {
        return this.mInfo.getTitleAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String getUuid() {
        return this.mInfo.getUuid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info
    public String toString() {
        return this.mInfo.toString();
    }
}
