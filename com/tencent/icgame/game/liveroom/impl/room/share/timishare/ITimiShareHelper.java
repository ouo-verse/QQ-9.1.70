package com.tencent.icgame.game.liveroom.impl.room.share.timishare;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface ITimiShareHelper extends QRouteApi {
    Intent getShareArkIntent(c cVar);

    String getShareDetailUrl(c cVar, int i3);

    String getShareSingleTitle(String str);

    String getShareSummary(String str);

    void sendArkMsg(int i3, String str, String str2, String str3, a aVar);
}
