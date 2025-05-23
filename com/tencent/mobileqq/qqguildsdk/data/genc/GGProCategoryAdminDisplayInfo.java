package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryAdminDisplayInfo;

/* loaded from: classes17.dex */
public class GGProCategoryAdminDisplayInfo implements IGProCategoryAdminDisplayInfo {
    public final GProCategoryAdminDisplayInfo mInfo;

    public GGProCategoryAdminDisplayInfo(GProCategoryAdminDisplayInfo gProCategoryAdminDisplayInfo) {
        this.mInfo = gProCategoryAdminDisplayInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo
    public long getCategoryAdminNum() {
        return this.mInfo.getCategoryAdminNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo
    public String getCategoryName() {
        return this.mInfo.getCategoryName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo
    public int getCategoryType() {
        return this.mInfo.getCategoryType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryAdminDisplayInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
