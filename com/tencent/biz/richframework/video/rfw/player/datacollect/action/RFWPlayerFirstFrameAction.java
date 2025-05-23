package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerFirstFrameAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(long j3, long j16) {
        return a.a(this, j3, j16);
    }

    public /* synthetic */ String b(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void c(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Long) {
                rFWPlayerCollectParams.setFirstRenderCostTimeS(Float.valueOf(a(rFWPlayerCollectParams.getPlayRequestStartTime(), ((Long) obj).longValue())).floatValue());
                c(b(str), "QFSFirstFrameFinish", rFWPlayerCollectParams.toString());
            }
        }
    }
}
