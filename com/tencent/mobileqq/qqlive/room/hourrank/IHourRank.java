package com.tencent.mobileqq.qqlive.room.hourrank;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IHourRank extends QRouteApi {
    void enterRoom(long j3);

    void openUrl(String str);

    void showTips(String str, int i3);
}
