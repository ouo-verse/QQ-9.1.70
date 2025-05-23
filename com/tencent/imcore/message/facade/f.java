package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface f<T extends BaseQQAppInterface> {
    boolean a(MessageRecord messageRecord);

    void b(T t16, MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16);
}
