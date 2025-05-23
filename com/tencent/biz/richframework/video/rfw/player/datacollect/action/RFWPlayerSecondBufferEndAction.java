package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerBufferRecode;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import java.util.List;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerSecondBufferEndAction implements RFWPlayerCollectBaseAction {
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
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0 && (objArr[0] instanceof Long)) {
            List<RFWPlayerBufferRecode> secondBufferRecodeList = rFWPlayerCollectParams.getSecondBufferRecodeList();
            if (secondBufferRecodeList.size() == 0) {
                return;
            }
            RFWPlayerBufferRecode rFWPlayerBufferRecode = secondBufferRecodeList.get(secondBufferRecodeList.size() - 1);
            long longValue = ((Long) objArr[0]).longValue();
            String a16 = a(rFWPlayerBufferRecode.getBufferStartTime(), longValue);
            rFWPlayerBufferRecode.setBufferEndTime(longValue);
            rFWPlayerBufferRecode.setBufferCostTimeS(Float.valueOf(a16).floatValue());
            c(b(str), "SecondBufferEnd", rFWPlayerCollectParams.toString());
        }
    }
}
