package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;

/* loaded from: classes5.dex */
public class RFWPlayerWeakNetTipsAction implements RFWPlayerCollectBaseAction {
    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        long j3;
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length > 0) {
            int i3 = 0;
            Object obj = objArr[0];
            if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            }
            if (objArr.length >= 2) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Long) {
                    j3 = ((Long) obj2).longValue();
                    rFWPlayerCollectParams.setWeakNetTipsStatus(i3);
                    rFWPlayerCollectParams.setWeakNetTipsUserClickTime(j3);
                }
            }
            j3 = 0;
            rFWPlayerCollectParams.setWeakNetTipsStatus(i3);
            rFWPlayerCollectParams.setWeakNetTipsUserClickTime(j3);
        }
    }
}
