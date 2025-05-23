package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveChatMsgService extends IQQLiveModule {
    public static final int DEFAULT_SEND = 0;
    public static final int SEND_LOCAL_ONLY = 2;
    public static final int SEND_REMOTE_ONLY = 1;

    void addChatMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void delChatMessageListener(IQQLiveReceiveMessageListener iQQLiveReceiveMessageListener);

    void sendMessage(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback, int i3);

    void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback, int i3);
}
