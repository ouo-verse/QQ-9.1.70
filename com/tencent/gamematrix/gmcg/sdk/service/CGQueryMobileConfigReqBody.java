package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGQueryMobileConfigReqBody {
    public int cpu;
    public int memory;
    public String brand = "";
    public String model = "";
    public String soc = "";

    /* renamed from: os, reason: collision with root package name */
    public String f107902os = "";

    public static CGQueryMobileConfigReqBody create() {
        CGQueryMobileConfigReqBody cGQueryMobileConfigReqBody = new CGQueryMobileConfigReqBody();
        cGQueryMobileConfigReqBody.brand = CGGlbConfig.getBuildBrand();
        cGQueryMobileConfigReqBody.model = CGGlbConfig.getBuildModel();
        if (GmCgSdk.isAllTvBiz()) {
            cGQueryMobileConfigReqBody.soc = cGQueryMobileConfigReqBody.model;
        } else {
            cGQueryMobileConfigReqBody.soc = CGGlbConfig.getSoc();
        }
        cGQueryMobileConfigReqBody.cpu = CGSystemUtil.getCpuCores();
        cGQueryMobileConfigReqBody.memory = CGSystemUtil.getTotalMemoryInGb(CGGlbConfig.getAppContext());
        cGQueryMobileConfigReqBody.f107902os = CGSystemUtil.getAndroidVersionString();
        return cGQueryMobileConfigReqBody;
    }

    public String toSimpleString() {
        return this.brand + "|" + this.model + "|" + this.soc + "|" + this.f107902os;
    }
}
