package com.tencent.gamecenter.common.util;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes6.dex */
public class m {
    public static void b(String str, long j3, short s16) {
        if (s16 == 0) {
            c(str, j3);
        } else if (s16 == 1) {
            d(str, j3);
        }
    }

    private static void c(String str, long j3) {
        String[] strArr;
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIGAME_CENTER_DOWNLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
        } else {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGGAME_CENTER_DOWNLOAD_FLOW, "param_XGFlow", "param_Flow"};
        }
        a(str, strArr, j3);
    }

    private static void d(String str, long j3) {
        String[] strArr;
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIGAME_CENTER_UPLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
        } else {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGGAME_CENTER_UPLOAD_FLOW, "param_XGFlow", "param_Flow"};
        }
        a(str, strArr, j3);
    }

    private static void a(String str, String[] strArr, long j3) {
    }
}
