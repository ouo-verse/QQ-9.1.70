package com.tencent.mobileqq.chat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IChatActivityApi extends QRouteApi {
    int FORWARD_REQUEST();

    String KEY_AIO_MSG_SOURCE();

    String OPEN_CHAT_FRAGMENT();

    int TYPE_DETAIL_MSG_REMIND();

    Class getChatActivityClass();
}
