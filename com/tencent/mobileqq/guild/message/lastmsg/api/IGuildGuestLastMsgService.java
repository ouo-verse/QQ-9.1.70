package com.tencent.mobileqq.guild.message.lastmsg.api;

import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildGuestLastMsgService extends IRuntimeService {
    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    GuildLastMsgItem getLastMsgItemForGuest(String str);

    void updateLastMsgItemForGuest(String str, GuildLastMsgItem guildLastMsgItem);
}
