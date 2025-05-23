package com.tencent.mobileqq.guild.message.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildMessageBoxDataService extends IRuntimeService {
    void addChannelMsgBoxEvent(ChannelMsgEvent channelMsgEvent);

    void addChannelMsgBoxEventList(String str, List<ChannelMsgEvent> list);

    void clearChannelMsgBoxReadEventList(String str, long j3);

    HashMap<String, List<ChannelMsgEvent>> getAllChannelMsgEventList();

    @Nullable
    List<ChannelMsgEvent> getChannelMsgEventList(String str, long j3);

    int getChannelMsgEventUnreadCount(String str, long j3);

    String getMessageBoxCookie();

    void removeChannelMsgBoxReadEvent(ChannelMsgEvent channelMsgEvent);

    boolean setMessageBoxCookie(String str);
}
