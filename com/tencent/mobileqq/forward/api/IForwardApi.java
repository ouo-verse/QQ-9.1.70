package com.tencent.mobileqq.forward.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IForwardApi extends QRouteApi {
    String KEY_DIRECT_SHOW_UIN();

    String KEY_DIRECT_SHOW_UIN_TYPE();

    String KEY_REQ();

    int REQ_DIRECT_SHOW_DIALOG();

    String SELECTION_MODE();

    int SELECTION_MODE_MULTI();

    int SEND_ASK_ANONYMOUSLY_ARK_MSG();

    Class getForwardRecentActivityClass();

    Class getForwardRecentTranslucentActivityClass();

    String keyDirectShowMsg();

    String keyForwardTitle();

    String keyIsShowRecentChatList();

    String keyIsShowRecentForwardList();
}
