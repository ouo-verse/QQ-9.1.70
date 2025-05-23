package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes15.dex */
public interface IMessageHandler extends IRuntimeService {
    void notifyUI(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16, Object obj);
}
