package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerSeekRecode;
import java.util.List;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerSeekCompleteAction implements RFWPlayerCollectBaseAction {
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
            List<RFWPlayerSeekRecode> seekRecodeList = rFWPlayerCollectParams.getSeekRecodeList();
            if (seekRecodeList.size() == 0) {
                return;
            }
            Long l3 = (Long) objArr[0];
            RFWPlayerSeekRecode rFWPlayerSeekRecode = seekRecodeList.get(seekRecodeList.size() - 1);
            rFWPlayerSeekRecode.setSeekCompleteTime(l3.longValue());
            rFWPlayerSeekRecode.setSeekCostS(Float.valueOf(a(rFWPlayerSeekRecode.getSeekStartTime(), l3.longValue())).floatValue());
            rFWPlayerCollectParams.setIsOnSeeking(false);
            c(b(str), "SeekComplete", rFWPlayerCollectParams.toString());
        }
    }
}
