package com.tencent.mobileqq.icgame.api.message;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import java.util.ArrayList;
import y22.a;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IQQLiveChatMsgService extends IQQLiveModule {
    public static final int DEFAULT_SEND = 0;
    public static final int SEND_LOCAL_ONLY = 2;
    public static final int SEND_REMOTE_ONLY = 1;

    void addChatMessageListener(a aVar);

    void delChatMessageListener(a aVar);

    void sendMessage(LiveMessageData liveMessageData, IQQLiveMessageCallback iQQLiveMessageCallback, int i3);

    void sendMessage(String str, ArrayList<LiveMessageData.ExtData> arrayList, IQQLiveMessageCallback iQQLiveMessageCallback);
}
