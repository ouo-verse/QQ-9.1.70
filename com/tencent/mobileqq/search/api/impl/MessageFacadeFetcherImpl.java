package com.tencent.mobileqq.search.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.api.IMessageFacadeFetcher;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageFacadeFetcherImpl implements IMessageFacadeFetcher {
    @Override // com.tencent.mobileqq.search.api.IMessageFacadeFetcher
    public Message getLastMessage(String str, int i3) {
        return ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getMessageFacade().getLastMessage(str, i3);
    }
}
