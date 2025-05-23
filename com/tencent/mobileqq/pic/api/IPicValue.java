package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicValue extends QRouteApi {
    void fillStickInfo(MessageForPic messageForPic);

    int getAioOtherSpaceValue();
}
