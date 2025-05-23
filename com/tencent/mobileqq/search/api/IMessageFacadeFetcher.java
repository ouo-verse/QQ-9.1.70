package com.tencent.mobileqq.search.api;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMessageFacadeFetcher extends QRouteApi {
    Message getLastMessage(String str, int i3);
}
