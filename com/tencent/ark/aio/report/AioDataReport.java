package com.tencent.ark.aio.report;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AioDataReport {
    public static final int KCHATTYPEC2C = 1;
    public static final int KCHATTYPEGROUP = 2;
    public static final int KCHATTYPEGUILD = 4;
    public static final int KCHATTYPETEMPPUBLICACCOUNT = 103;

    public static String convertChatTypeToReportStr(int i3) {
        if (i3 == 1) {
            return "c2c";
        }
        if (i3 == 2) {
            return VipFunCallConstants.KEY_GROUP;
        }
        if (i3 == 4) {
            return WadlProxyConsts.CHANNEL;
        }
        if (i3 == 103) {
            return "gzh";
        }
        return "other";
    }
}
