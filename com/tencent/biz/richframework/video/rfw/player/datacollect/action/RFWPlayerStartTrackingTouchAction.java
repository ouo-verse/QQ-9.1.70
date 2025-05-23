package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerSeekRecode;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerStartTrackingTouchAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void b(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0) {
            if (objArr[0] instanceof Integer) {
                RFWPlayerSeekRecode rFWPlayerSeekRecode = new RFWPlayerSeekRecode();
                rFWPlayerSeekRecode.setSeekStartPoi(((Integer) r6).intValue());
                rFWPlayerCollectParams.addSeekRecodeList(rFWPlayerSeekRecode);
                b(a(str), "StartTrackingTouch", rFWPlayerCollectParams.toString());
            }
        }
    }
}
