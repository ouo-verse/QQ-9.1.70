package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.favroaming.j;
import com.tencent.mobileqq.emosm.favroaming.k;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoBatchAddedHandlerApiImpl implements IEmoBatchAddedHandlerApi {
    @Override // com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi
    public j createEmoBatchAddedCallback(BaseQQAppInterface baseQQAppInterface, k kVar, int i3) {
        return new com.tencent.mobileqq.emosm.favroaming.b(baseQQAppInterface, (com.tencent.mobileqq.emosm.favroaming.c) kVar, i3);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi
    public k createEmoBatchAddedHandler(IChatHistoryEmotionBaseFragment iChatHistoryEmotionBaseFragment, BaseQQAppInterface baseQQAppInterface) {
        return new com.tencent.mobileqq.emosm.favroaming.c(iChatHistoryEmotionBaseFragment, baseQQAppInterface);
    }
}
