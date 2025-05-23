package com.tencent.mobileqq.emosm.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.j;
import com.tencent.mobileqq.emosm.favroaming.k;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IEmoBatchAddedHandlerApi extends QRouteApi {
    j createEmoBatchAddedCallback(BaseQQAppInterface baseQQAppInterface, k kVar, int i3);

    k createEmoBatchAddedHandler(IChatHistoryEmotionBaseFragment iChatHistoryEmotionBaseFragment, BaseQQAppInterface baseQQAppInterface);
}
