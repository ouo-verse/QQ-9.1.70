package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerBufferRecode;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerSecondBufferStartAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void b(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Long) {
                long longValue = ((Long) obj).longValue();
                RFWPlayerBufferRecode rFWPlayerBufferRecode = new RFWPlayerBufferRecode();
                rFWPlayerBufferRecode.setBufferStartTime(longValue);
                rFWPlayerBufferRecode.setIsTriggerBySeek(rFWPlayerCollectParams.isOnSeeking());
                rFWPlayerCollectParams.addSecondBufferRecode(rFWPlayerBufferRecode);
                b(a(str), "SecondBufferStart", rFWPlayerCollectParams.toString());
            }
        }
    }
}
