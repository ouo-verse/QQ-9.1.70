package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerSeekRecode;
import java.util.List;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerStopTrackingTouchAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void b(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Long)) {
            List<RFWPlayerSeekRecode> seekRecodeList = rFWPlayerCollectParams.getSeekRecodeList();
            if (seekRecodeList.size() == 0) {
                return;
            }
            int intValue = ((Integer) objArr[0]).intValue();
            Long l3 = (Long) objArr[1];
            RFWPlayerSeekRecode rFWPlayerSeekRecode = seekRecodeList.get(seekRecodeList.size() - 1);
            rFWPlayerSeekRecode.setSeekEndPoi(intValue);
            rFWPlayerSeekRecode.setSeekStartTime(l3.longValue());
            rFWPlayerCollectParams.setIsOnSeeking(true);
            b(a(str), "StopTrackingTouch", rFWPlayerCollectParams.toString());
        }
    }
}
