package com.tencent.mobileqq.guild.feed.personalbox;

import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.Observer;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.msgpush.servtype$FeedEvent;
import tencent.im.group_pro_proto.msgpush.servtype$ReadFeedNotify;
import tencent.im.group_pro_proto.synclogic.synclogic$FeedsEventNode;

@Service(process = {""})
@Deprecated
/* loaded from: classes13.dex */
public interface IGuildFeedPersonalBoxUnreadService extends IRuntimeService {

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IGuildUnreadCntService.b f222745a = new IGuildUnreadCntService.b();

        /* renamed from: b, reason: collision with root package name */
        public String f222746b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f222747c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f222748d = "";

        public String toString() {
            String bVar;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" {info} lastMsgSummary:");
            sb5.append(this.f222746b);
            sb5.append(" lastMsgTime:");
            sb5.append(this.f222747c);
            sb5.append(" lastFeedId:");
            sb5.append(this.f222748d);
            sb5.append(" cntInfo:");
            IGuildUnreadCntService.b bVar2 = this.f222745a;
            if (bVar2 == null) {
                bVar = "";
            } else {
                bVar = bVar2.toString();
            }
            sb5.append(bVar);
            return sb5.toString();
        }
    }

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    a getGuildFeedPersonalBoxLastMsg();

    void onFeedsEventOnlinePush(servtype$FeedEvent servtype_feedevent);

    void onReadFeedEventPush(servtype$ReadFeedNotify servtype_readfeednotify);

    void onReceiveRegistProxy(synclogic$FeedsEventNode synclogic_feedseventnode);

    void reportFeedRead();

    void reportFeedRead(long j3);
}
