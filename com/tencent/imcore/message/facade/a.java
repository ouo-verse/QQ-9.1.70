package com.tencent.imcore.message.facade;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a<FT extends BaseQQMessageFacade, T extends BaseQQAppInterface> {
    void a(FT ft5, T t16, List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16);
}
