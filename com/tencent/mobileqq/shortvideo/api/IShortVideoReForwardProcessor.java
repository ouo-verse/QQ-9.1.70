package com.tencent.mobileqq.shortvideo.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShortVideoReForwardProcessor extends QRouteApi {
    boolean handleForwardVideoNotExistsOnServer(BaseQQAppInterface baseQQAppInterface, MessageForShortVideo messageForShortVideo);
}
