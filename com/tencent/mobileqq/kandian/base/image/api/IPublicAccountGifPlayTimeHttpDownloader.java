package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.net.URL;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPublicAccountGifPlayTimeHttpDownloader extends QRouteApi {
    public static final String PROTOCOL_GIF_PLAY_ACCOUNT = "pubaccountimage_gifplaytime";

    Object getHttpDownloader();

    URL getPubURL(String str);
}
