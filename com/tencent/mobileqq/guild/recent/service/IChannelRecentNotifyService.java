package com.tencent.mobileqq.guild.recent.service;

import android.os.Bundle;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import pw1.a;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IChannelRecentNotifyService extends IRuntimeService {
    public static final int REFRESH_TYPE_FULL = 2;
    public static final String REFRESH_TYPE_PART_CHANNEL_ID = "channelId";
    public static final int REFRESH_TYPE_SINGLE_ITEM = 0;

    void refreshRecentList(int i3, Bundle bundle);

    void refreshRecentListForLastMsgChanged(LastMessage lastMessage);

    void setRecentChannelObserver(a aVar);
}
