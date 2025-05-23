package bu1;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.x;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f29159a;

    /* renamed from: b, reason: collision with root package name */
    private String f29160b;

    /* renamed from: c, reason: collision with root package name */
    private String f29161c;

    /* renamed from: d, reason: collision with root package name */
    private HashSet<Long> f29162d = new HashSet<>();

    public d(AppInterface appInterface, String str, String str2) {
        this.f29159a = appInterface;
        this.f29160b = str;
        this.f29161c = str2;
    }

    private void a(long j3, long j16) {
        for (long j17 = j3; j17 <= j16; j17++) {
            this.f29162d.add(Long.valueOf(j17));
        }
        QLog.i("PullChannelEventFlowLogic", 1, "addPullSeqs: guildId:" + this.f29160b + " channelId:" + this.f29161c + " beginSeq:" + j3 + " endSeq:" + j16 + " pullSeqsFromSvr:" + this.f29162d.toString());
    }

    private ArrayList<ArrayList<b>> b(ArrayList<b> arrayList) {
        int size = arrayList.size();
        b bVar = arrayList.get(0);
        long j3 = bVar.f29153a;
        ArrayList<ArrayList<b>> arrayList2 = new ArrayList<>();
        ArrayList<b> arrayList3 = new ArrayList<>();
        if (c(bVar)) {
            arrayList3.add(bVar);
        }
        for (int i3 = 1; i3 < size; i3++) {
            b bVar2 = arrayList.get(i3);
            if (bVar2.f29153a != 1 + j3 && !arrayList3.isEmpty()) {
                arrayList2.add(arrayList3);
                arrayList3 = new ArrayList<>();
            }
            if (c(bVar2)) {
                arrayList3.add(bVar2);
                j3 = bVar2.f29153a;
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }

    private boolean c(b bVar) {
        boolean z16 = false;
        if (bVar == null) {
            return false;
        }
        synchronized (this.f29162d) {
            boolean contains = this.f29162d.contains(Long.valueOf(bVar.f29153a));
            if (contains) {
                QLog.i("PullChannelEventFlowLogic", 1, "needUpdate: guildId:" + this.f29160b + " channelId:" + this.f29161c + " isPullIng:" + contains);
                return false;
            }
            GuildEventFlowTimeItem eventFlowTimeItem = ((IGuildMsgSeqTimeService) this.f29159a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getEventFlowTimeItem(this.f29161c);
            if (eventFlowTimeItem == null) {
                QLog.i("PullChannelEventFlowLogic", 1, "needUpdate: guildId:" + this.f29160b + " channelId:" + this.f29161c + " eventFlowTimeItem: null");
                return false;
            }
            if (bVar.b() < eventFlowTimeItem.eventBeginTime) {
                QLog.i("PullChannelEventFlowLogic", 1, "needUpdate: guildId:" + this.f29160b + " channelId:" + this.f29161c + " getSyncTime:" + bVar.b() + " eventBeginTime:" + eventFlowTimeItem.eventBeginTime);
            } else {
                if (bVar.c()) {
                    QLog.i("PullChannelEventFlowLogic", 1, "needUpdate: guildId:" + this.f29160b + " channelId:" + this.f29161c + " needVersionUpdate:" + bVar.c());
                }
                if (!z16 && !((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isRevokeMsg(bVar.f29155c)) {
                    bVar.f29156d = 1;
                } else {
                    bVar.f29156d = 2;
                }
                return z16;
            }
            z16 = true;
            if (!z16) {
            }
            bVar.f29156d = 2;
            return z16;
        }
    }

    private boolean f(ArrayList<b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        QLog.i("PullChannelEventFlowLogic", 1, "pullEventFlowMsgInfo: guildId:" + this.f29160b + " channelId:" + this.f29161c + " needUpdateInfos:" + arrayList.toString());
        long j3 = arrayList.get(0).f29153a;
        long j16 = arrayList.get(arrayList.size() - 1).f29153a;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            arrayList2.add(new Pair(Long.valueOf(next.f29153a), Long.valueOf(next.a())));
            if (next.f29157e.size() > 0) {
                ArrayList arrayList4 = new ArrayList(next.f29157e);
                if (next.f29158f.size() > 0) {
                    arrayList4.addAll(next.f29158f);
                }
                arrayList3.add(new Pair(Long.valueOf(next.f29153a), arrayList4));
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("pull_roammsg_from_eventflow", true);
        bundle.putSerializable("msgevent_version_list", arrayList2);
        bundle.putSerializable("msgevent_comment_list", arrayList3);
        IGuildRoamMessageHandler iGuildRoamMessageHandler = (IGuildRoamMessageHandler) this.f29159a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRoamMsgHandlerName());
        synchronized (this.f29162d) {
            if (!iGuildRoamMessageHandler.reqPullRoamMsg(this.f29161c, j3, j16, bundle)) {
                return false;
            }
            a(j3, j16);
            return true;
        }
    }

    private void g(long j3, long j16) {
        for (long j17 = j3; j17 <= j16; j17++) {
            this.f29162d.remove(Long.valueOf(j17));
        }
        QLog.i("PullChannelEventFlowLogic", 1, "removePullSeqs: guildId:" + this.f29160b + " channelId:" + this.f29161c + " beginSeq:" + j3 + " endSeq:" + j16 + " pullSeqsFromSvr:" + this.f29162d.toString());
    }

    private void h(ArrayList<b> arrayList) {
        Iterator<b> it;
        String str;
        b bVar;
        boolean z16;
        Iterator<Long> it5;
        String str2;
        b bVar2;
        x xVar = (x) ((IGuildMsgFactory) this.f29159a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5);
        Iterator<b> it6 = arrayList.iterator();
        boolean z17 = false;
        while (it6.hasNext()) {
            b next = it6.next();
            ArrayList<Long> arrayList2 = next.f29157e;
            ArrayList<Long> arrayList3 = next.f29158f;
            int i3 = next.f29156d;
            String str3 = " CommonInfoChange";
            String str4 = " channelId:";
            if (arrayList2.size() > 0 && i3 == 2) {
                QLog.i("PullChannelEventFlowLogic", 1, "updataUIonExposureForCommentRevoke: guildId:" + this.f29160b + " channelId:" + this.f29161c + "update local msgReply msgEventInfoForUpdate:" + next.toString());
                Iterator<Long> it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    Long next2 = it7.next();
                    Iterator<b> it8 = it6;
                    String str5 = str4;
                    int indexOf = arrayList.indexOf(new b(next2.longValue()));
                    if (indexOf != -1 && (bVar2 = arrayList.get(indexOf)) != null) {
                        z16 = z17;
                        it5 = it7;
                        if (xVar.L(bVar2.f29155c, next.f29155c, false, true)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("updataUIonExposureForCommentRevoke: channelId:");
                            sb5.append(this.f29161c);
                            sb5.append("replyMsgSeq:");
                            sb5.append(next2);
                            sb5.append(str3);
                            str2 = str3;
                            sb5.append(((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getReplyMsgCommentCnt(bVar2.f29155c));
                            sb5.append(" isSourceRevokeForReplyMsg:");
                            sb5.append(((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSourceRevokeForReplyMsg(bVar2.f29155c));
                            QLog.i("PullChannelEventFlowLogic", 1, sb5.toString());
                            z17 = true;
                            str3 = str2;
                            it6 = it8;
                            str4 = str5;
                            it7 = it5;
                        }
                    } else {
                        z16 = z17;
                        it5 = it7;
                    }
                    str2 = str3;
                    z17 = z16;
                    str3 = str2;
                    it6 = it8;
                    str4 = str5;
                    it7 = it5;
                }
                it = it6;
                str = str4;
            } else {
                it = it6;
                str = " channelId:";
            }
            String str6 = str3;
            if (arrayList3.size() > 0 && i3 == 2) {
                QLog.i("PullChannelEventFlowLogic", 1, "updataUIonExposureForCommentCnt: guildId:" + this.f29160b + str + this.f29161c + "update local msgReply msgEventInfoForUpdate:" + next.toString());
                Iterator<Long> it9 = arrayList3.iterator();
                boolean z18 = z17;
                while (it9.hasNext()) {
                    Long next3 = it9.next();
                    int indexOf2 = arrayList.indexOf(new b(next3.longValue()));
                    if (indexOf2 != -1 && (bVar = arrayList.get(indexOf2)) != null && xVar.L(bVar.f29155c, next.f29155c, true, false)) {
                        QLog.i("PullChannelEventFlowLogic", 1, "updataUIonExposureForCommentCnt: channelId:" + this.f29161c + "rootMsgSeq:" + next3 + str6 + ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getReplyMsgCommentCnt(bVar.f29155c) + " isSourceRevokeForReplyMsg:" + ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSourceRevokeForReplyMsg(bVar.f29155c));
                        z18 = true;
                    }
                }
                z17 = z18;
            }
            it6 = it;
        }
        if (z17) {
            this.f29159a.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName()).notifyUI(GuildEventFlowObserver.D, true, new Object[]{this.f29161c});
        }
    }

    public void d(ArrayList<b> arrayList) {
        ArrayList<ArrayList<b>> b16 = b(arrayList);
        if (b16.size() > 0) {
            Iterator<ArrayList<b>> it = b16.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
        }
        h(arrayList);
    }

    public void e(boolean z16, ToServiceMsg toServiceMsg, synclogic$ChannelMsgRsp synclogic_channelmsgrsp, ArrayList<common$Msg> arrayList) {
        String uin;
        long j3 = toServiceMsg.extraData.getLong("lBeginSeq");
        long j16 = toServiceMsg.extraData.getLong("lEndSeq");
        QLog.i("PullChannelEventFlowLogic", 1, "onPullRoamMsgEventFlowRsp: guildId:" + this.f29160b + " channelId:" + this.f29161c + " beginSeq:" + j3 + " endSeq:" + j16 + " result:" + z16);
        synchronized (((IGuildMsgFactory) this.f29159a.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().a(this.f29161c)) {
            if (toServiceMsg.getUin() == null) {
                uin = this.f29159a.getCurrentAccountUin();
            } else {
                uin = toServiceMsg.getUin();
            }
            ((IGuildMsgFactory) this.f29159a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(5).a(toServiceMsg, synclogic_channelmsgrsp, arrayList, uin);
        }
        synchronized (this.f29162d) {
            g(j3, j16);
        }
    }
}
