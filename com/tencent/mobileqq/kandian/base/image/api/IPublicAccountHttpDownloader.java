package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.net.URL;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPublicAccountHttpDownloader extends QRouteApi {
    public static final String BUSI_TYPE_PARAM_KEY = "busiType";
    public static final String PROTOCOL_PUB_ACCOUNT = "pubaccountimage";
    public static final int PUB_ACCOUNT_IMAGE_FROM_AIO = 0;
    public static final int PUB_ACCOUNT_IMAGE_FROM_BIGIMAGE = 2;
    public static final int PUB_ACCOUNT_IMAGE_FROM_KANDIAN = 3;
    public static final int PUB_ACCOUNT_IMAGE_FROM_NATIVE_WEB = 4;
    public static final int PUB_ACCOUNT_IMAGE_FROM_SUBSCRIPT = 1;

    Object getHttpDownloader();

    URL makeURL(String str, int i3);

    URL makeURL(String str, int i3, Object obj);

    URL makeURL(String str, int i3, Object obj, boolean z16);
}
