package com.tencent.qzonehub.api;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneReq extends QRouteApi {
    void sendPublicAccountPushReq();

    void sentGetAlbumListNumServlet(BusinessObserver businessObserver, long j3);

    void sentGetGroupCountServlet(BusinessObserver businessObserver, long j3, long j16);

    void sentGetPublicMsgServlet(AppRuntime appRuntime, BusinessObserver businessObserver, long j3, String str);

    void sentNewestFeedServlet(AppRuntime appRuntime, BusinessObserver businessObserver, long j3, long[] jArr, long j16, int i3);

    void sentOnlineServlet(AppRuntime appRuntime, String str, long j3);

    void sentOnlineTimeServlet(ArrayList<mobile_online_report_item> arrayList);

    void sentPushAckServlet(long j3, long j16, String str, long j17);
}
