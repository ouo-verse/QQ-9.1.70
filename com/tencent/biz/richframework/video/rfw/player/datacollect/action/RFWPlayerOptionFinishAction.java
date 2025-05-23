package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerOptionFinishAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(long j3, long j16) {
        return a.a(this, j3, j16);
    }

    public /* synthetic */ String b(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ String c(String str) {
        return a.c(this, str);
    }

    public /* synthetic */ void d(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length >= 3) {
            Object obj = objArr[0];
            if (obj instanceof Long) {
                Object obj2 = objArr[1];
                if ((obj2 instanceof String) && (objArr[2] instanceof Float)) {
                    String str2 = (String) obj2;
                    rFWPlayerCollectParams.setPlayUrl(str2);
                    rFWPlayerCollectParams.setRateKBS(((Float) objArr[2]).floatValue() / 8.0f);
                    rFWPlayerCollectParams.setPlayScene(c(str2));
                    rFWPlayerCollectParams.setProcessCostTimeS(Float.valueOf(a(rFWPlayerCollectParams.getPlayRequestStartTime(), ((Long) obj).longValue())).floatValue());
                    d(b(str), "loadProcessFinish", rFWPlayerCollectParams.toString());
                }
            }
        }
    }
}
