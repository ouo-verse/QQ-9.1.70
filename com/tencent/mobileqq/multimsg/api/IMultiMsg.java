package com.tencent.mobileqq.multimsg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMultiMsg extends QRouteApi {
    a getMultiMsgValue();

    String getPicDefaultPath();

    long getPicDefaultSize();
}
