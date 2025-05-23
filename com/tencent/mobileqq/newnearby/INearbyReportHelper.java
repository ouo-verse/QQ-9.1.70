package com.tencent.mobileqq.newnearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyReportHelper extends QRouteApi {
    public static final int REPORT_JUBAO = 2;

    void reportNearbyJubao(long j3, int i3);

    void reportNearbyTicketShow(String str, String str2, String str3, String str4, String str5);

    void reportNearbyVerifyDone();

    void reportTrendDetailCommentClick(AppInterface appInterface, String str);

    void reportTrendDetailExp(AppInterface appInterface, String str);

    void reportTrendDetailLikeClick(AppInterface appInterface, String str);

    void reportTrendDetailSafeReportClick(AppInterface appInterface, String str);

    void reportTrendDetailShareClick(AppInterface appInterface, String str);
}
