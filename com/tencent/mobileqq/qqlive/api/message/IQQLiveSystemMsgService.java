package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveSystemMsgService extends IQQLiveModule {
    void addSystemMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void delSystemMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);
}
