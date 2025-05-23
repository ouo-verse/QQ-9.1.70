package com.tencent.mobileqq.wxmini.impl.util;

import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.data.LaunchWxaErrorCode;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i {
    public static LaunchWxaErrorCode a(TdiAuthErrCode tdiAuthErrCode) {
        if (tdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK) {
            return LaunchWxaErrorCode.Success;
        }
        for (LaunchWxaErrorCode launchWxaErrorCode : LaunchWxaErrorCode.values()) {
            if (launchWxaErrorCode.getCode() == tdiAuthErrCode.ordinal()) {
                return launchWxaErrorCode;
            }
        }
        return LaunchWxaErrorCode.FailAuthCommon;
    }

    public static LaunchWxaErrorCode b(LaunchWxaAppResult launchWxaAppResult) {
        if (launchWxaAppResult == LaunchWxaAppResult.OK) {
            return LaunchWxaErrorCode.Success;
        }
        for (LaunchWxaErrorCode launchWxaErrorCode : LaunchWxaErrorCode.values()) {
            if (launchWxaErrorCode.getCode() == launchWxaAppResult.code) {
                return launchWxaErrorCode;
            }
        }
        return LaunchWxaErrorCode.FailLaunchCommon;
    }

    public static String c(int i3) {
        for (LaunchWxaErrorCode launchWxaErrorCode : LaunchWxaErrorCode.values()) {
            if (launchWxaErrorCode.getCode() == i3) {
                return launchWxaErrorCode.name();
            }
        }
        return "UnKnow-NeedSupply";
    }

    public static void d(String str, String str2, String str3, String str4, String str5, String str6, MiniAppCmdInterface miniAppCmdInterface) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).getShareInfo(MiniProgramShareUtils.newShareInfoRequest(str, str3, str4, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), 1, 1, 2, str6, null, str2, str5, null, 3, "", 7, false, "", null, "", "", ""), miniAppCmdInterface);
    }
}
