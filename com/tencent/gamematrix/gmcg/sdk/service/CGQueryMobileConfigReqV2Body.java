package com.tencent.gamematrix.gmcg.sdk.service;

import android.os.Build;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.env.CGCodecHelper;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGQueryMobileConfigReqV2Body {
    public boolean h264_hard_support;
    public boolean h265_hard_support;
    public String brand = "";
    public String model = "";
    public String soc = "";
    public final int os_version = Build.VERSION.SDK_INT;

    CGQueryMobileConfigReqV2Body() {
    }

    public static CGQueryMobileConfigReqV2Body create() {
        CGQueryMobileConfigReqV2Body cGQueryMobileConfigReqV2Body = new CGQueryMobileConfigReqV2Body();
        cGQueryMobileConfigReqV2Body.brand = CGGlbConfig.getBuildBrand();
        cGQueryMobileConfigReqV2Body.model = CGGlbConfig.getBuildModel();
        if (GmCgSdk.isAllTvBiz()) {
            cGQueryMobileConfigReqV2Body.soc = cGQueryMobileConfigReqV2Body.model;
        } else {
            cGQueryMobileConfigReqV2Body.soc = CGGlbConfig.getSoc();
        }
        cGQueryMobileConfigReqV2Body.h264_hard_support = CGCodecHelper.isHardH264Support();
        cGQueryMobileConfigReqV2Body.h265_hard_support = CGCodecHelper.isHardH265Support();
        return cGQueryMobileConfigReqV2Body;
    }
}
