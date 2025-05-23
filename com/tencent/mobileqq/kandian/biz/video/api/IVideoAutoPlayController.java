package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoAutoPlayController extends QRouteApi {
    boolean canAutoPlayVideo();

    void initVideoPlaySetting(String str);

    boolean isNeedNetWorkAlert();

    boolean isNeedNetWorkAlertForIPC();

    boolean isRefreshingList();

    boolean isWifi();

    void setChannelFrom(long j3);

    void setChannelId(int i3);

    void setIsRefreshingList(boolean z16);

    void updateNetworkChange(boolean z16);
}
