package com.tencent.timi.game.liveroom.impl.room.share.timishare.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgLiveShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TimiGameShareUtil;
import xk4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiShareHelperImpl implements ITimiShareHelper {
    private static final String TAG = "TimiShareHelperImpl";
    private static IAegisLogApi log = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public Intent getShareArkIntent(TgLiveShareParam tgLiveShareParam) {
        return a.d(tgLiveShareParam);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareDetailUrl(TgLiveShareParam tgLiveShareParam, int i3) {
        return a.e(tgLiveShareParam, i3);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareSingleTitle(String str) {
        return a.g(str);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareSummary(String str) {
        return a.h(str);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String replaceArkData(String str, long j3, String str2, String str3, long j16, String str4, String str5, TgLiveShareParam tgLiveShareParam) {
        log.e(TAG, "server empty body, use old share style");
        return a.i(str, j3, str2, str3, j16, str4, str5, tgLiveShareParam);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public void shareToQQ(Context context, TgShareParam tgShareParam, String str, int i3) {
        TgShareParam.ShareBody shareBody = tgShareParam.getShareBody(1);
        if (shareBody == null) {
            log.e(TAG, "empty share body");
        } else {
            TimiGameShareUtil.m(context, tgShareParam, shareBody, str, i3);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public void shareToQzone(Context context, String str, String str2, String str3, String str4, String str5, int i3) {
        TimiGameShareUtil.n(context, str, str2, str3, str4, str5, i3);
    }
}
