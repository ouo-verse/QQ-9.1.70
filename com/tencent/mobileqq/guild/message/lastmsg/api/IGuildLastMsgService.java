package com.tencent.mobileqq.guild.message.lastmsg.api;

import com.tencent.mobileqq.guild.message.lastmsg.GuildLastMsgItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildLastMsgService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(String str, GuildLastMsgItem guildLastMsgItem);
    }

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    ConcurrentHashMap<String, GuildLastMsgItem> getClonedLastItemMap();

    GuildLastMsgItem getLastMsgItem(String str, boolean z16);

    void getLastMsgItemAsync(String str, a aVar);

    void lazyNotifyLastMsgChange(String str, GuildLastMsgItem guildLastMsgItem);

    void onDraftChangeNotify(String str, String str2, long j3);

    void onMsgRevoke(String str, long j3);

    void onMsgUpdate(String str, long j3);

    void updateLastMsgItem(String str, GuildLastMsgItem guildLastMsgItem);

    void updateUnreadCnt(String str, GuildLastMsgItem guildLastMsgItem);
}
