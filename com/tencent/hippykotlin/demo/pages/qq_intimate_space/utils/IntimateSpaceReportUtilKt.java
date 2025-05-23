package com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class IntimateSpaceReportUtilKt {
    public static final e getIntimateDTReportBaseParams() {
        String str;
        e eVar = new e();
        if (b.a().getPageData().getIsIOS()) {
            str = "0IOS0800YR4PO71P";
        } else {
            str = "0AND0MWZXR4U3RVU";
        }
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, str);
        return eVar;
    }
}
