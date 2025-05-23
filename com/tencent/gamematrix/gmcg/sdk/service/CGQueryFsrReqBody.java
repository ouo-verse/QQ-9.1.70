package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGQueryFsrReqBody extends CGQueryMobileConfigReqBody {
    public boolean judgeFSR = true;

    public static CGQueryFsrReqBody create() {
        CGQueryFsrReqBody cGQueryFsrReqBody = new CGQueryFsrReqBody();
        cGQueryFsrReqBody.brand = CGGlbConfig.getBuildBrand();
        cGQueryFsrReqBody.model = CGGlbConfig.getBuildModel();
        if (GmCgSdk.isAllTvBiz()) {
            cGQueryFsrReqBody.soc = cGQueryFsrReqBody.model;
        } else {
            cGQueryFsrReqBody.soc = CGGlbConfig.getSoc();
        }
        cGQueryFsrReqBody.cpu = CGSystemUtil.getCpuCores();
        cGQueryFsrReqBody.memory = CGSystemUtil.getTotalMemoryInGb(CGGlbConfig.getAppContext());
        cGQueryFsrReqBody.f107902os = CGSystemUtil.getAndroidVersionString();
        cGQueryFsrReqBody.judgeFSR = true;
        return cGQueryFsrReqBody;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGQueryMobileConfigReqBody
    public String toSimpleString() {
        return super.toSimpleString() + "|" + this.judgeFSR;
    }
}
