package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerReplacePreloadAction implements RFWPlayerCollectBaseAction {
    public /* synthetic */ String a(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ String b(String str) {
        return a.c(this, str);
    }

    public /* synthetic */ void c(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length >= 3) {
            Object obj = objArr[0];
            if ((obj instanceof String) && (objArr[1] instanceof String) && (objArr[2] instanceof Float)) {
                rFWPlayerCollectParams.setPreloadTag((String) obj);
                String str2 = (String) objArr[1];
                rFWPlayerCollectParams.setPlayUrl(str2);
                rFWPlayerCollectParams.setRateKBS(((Float) objArr[2]).floatValue() / 8.0f);
                rFWPlayerCollectParams.setPlayScene(b(str2));
                c(a(str), "onPreloadReplace", rFWPlayerCollectParams.toString());
            }
        }
    }
}
