package com.tencent.timi.game.liveroom.impl.room.share.timishare;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface ITimiShareHelper extends QRouteApi {
    Intent getShareArkIntent(TgLiveShareParam tgLiveShareParam);

    String getShareDetailUrl(TgLiveShareParam tgLiveShareParam, int i3);

    String getShareSingleTitle(String str);

    String getShareSummary(String str);

    String replaceArkData(String str, long j3, String str2, String str3, long j16, String str4, String str5, TgLiveShareParam tgLiveShareParam);

    void shareToQQ(Context context, TgShareParam tgShareParam, String str, int i3);

    void shareToQzone(Context context, String str, String str2, String str3, String str4, String str5, int i3);
}
