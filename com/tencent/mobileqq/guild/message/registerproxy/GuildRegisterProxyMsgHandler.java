package com.tencent.mobileqq.guild.message.registerproxy;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.mobileqq.guild.message.registerproxy.b;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.appchannelinfo.appchannelinfo$ApplicationChannelInfo;
import tencent.im.group_pro_proto.synclogic.synclogic$ChannelNode;
import tencent.im.group_pro_proto.synclogic.synclogic$FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;
import tencent.im.group_pro_proto.synclogic.synclogic$MultiChannelMsgRsp;

/* loaded from: classes14.dex */
public class GuildRegisterProxyMsgHandler extends BusinessHandler implements g {
    private long C;
    private long D;
    private final Map<Integer, h> E;
    private volatile com.tencent.mobileqq.guild.message.registerproxy.a F;
    private boolean G;
    private final ou1.a H;
    private Observer I;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f230731d;

    /* renamed from: e, reason: collision with root package name */
    private long f230732e;

    /* renamed from: f, reason: collision with root package name */
    private int f230733f;

    /* renamed from: h, reason: collision with root package name */
    private int f230734h;

    /* renamed from: i, reason: collision with root package name */
    private int f230735i;

    /* renamed from: m, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, h> f230736m;

    /* loaded from: classes14.dex */
    class a extends ou1.a {
        a() {
        }

        private void m(ArrayList<synclogic$GuildNode> arrayList) {
            st1.c cVar = (st1.c) GuildRegisterProxyMsgHandler.this.f230731d.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMsgBoxHandlerName());
            if (cVar != null) {
                cVar.B1(arrayList);
            }
        }

        private void n() {
            st1.c cVar = (st1.c) GuildRegisterProxyMsgHandler.this.f230731d.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildMsgBoxHandlerName());
            if (cVar != null) {
                cVar.B0();
            }
        }

        private void o(ArrayList<synclogic$GuildNode> arrayList) {
            QLog.i("GuildRegisterProxyMsgHandler", 1, "\u5f00\u59cb\u5904\u7406\u5176\u5b83chanel\u6d88\u606f\u7684\u8865\u62c9\u903b\u8f91");
            if (arrayList != null && arrayList.size() > 0) {
                GuildRegisterProxyMsgHandler.this.O2(arrayList);
            }
        }

        private void p(boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
            if (z16 && arrayList != null && arrayList.size() >= 1) {
                ((com.tencent.mobileqq.guild.message.eventflow.revoke.b) GuildRegisterProxyMsgHandler.this.f230731d.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyRevokeEventHandlerName())).E0(arrayList, 2L);
            }
        }

        private boolean q(int i3) {
            if (GuildRegisterProxyMsgHandler.this.f230736m.containsKey(Integer.valueOf(i3))) {
                ((h) GuildRegisterProxyMsgHandler.this.f230736m.get(Integer.valueOf(i3))).onDestory();
                GuildRegisterProxyMsgHandler.this.f230736m.remove(Integer.valueOf(i3));
                return true;
            }
            return false;
        }

        private void r(boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
            long j3;
            if (!z16) {
                QLog.e("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel return. isSuccess = false.");
                return;
            }
            if (arrayList == null) {
                QLog.e("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel return. guildNodes = null.");
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<synclogic$GuildNode> it = arrayList.iterator();
            while (it.hasNext()) {
                synclogic$GuildNode next = it.next();
                for (synclogic$ChannelNode synclogic_channelnode : next.rpt_channel_nodes.get()) {
                    if (synclogic_channelnode.msg_list_tab.get().is_in_list.get() != 0) {
                        if (synclogic_channelnode.application_info.has()) {
                            appchannelinfo$ApplicationChannelInfo appchannelinfo_applicationchannelinfo = new appchannelinfo$ApplicationChannelInfo();
                            try {
                                appchannelinfo_applicationchannelinfo.mergeFrom(synclogic_channelnode.application_info.get().toByteArray());
                                j3 = appchannelinfo_applicationchannelinfo.uint64_application_id.get();
                            } catch (InvalidProtocolBufferMicroException e16) {
                                QLog.d("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel mergeFrom ", e16);
                            }
                            fk fkVar = new fk(String.valueOf(next.guild_id.get()), String.valueOf(synclogic_channelnode.channel_id.get()), synclogic_channelnode.msg_list_tab.get().top_timestamp.get(), next.guild_name.get().toStringUtf8(), synclogic_channelnode.channel_name.get().toStringUtf8(), next.face_seq.get(), synclogic_channelnode.channel_type.get(), j3);
                            arrayList2.add(fkVar);
                            QLog.i("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel: guildId: " + fkVar.getGuildId() + ", channelId: " + fkVar.getChannelId() + ", topTimeStamp: " + fkVar.getTopTimestamp() + ", faceSeq: " + fkVar.getAvatarSeq() + ", guildName: " + fkVar.getGuildName() + ", channelName: " + fkVar.getChannelName() + ", channelType: " + fkVar.getChannelType() + ", appId: " + fkVar.getAppId());
                        }
                        j3 = 0;
                        fk fkVar2 = new fk(String.valueOf(next.guild_id.get()), String.valueOf(synclogic_channelnode.channel_id.get()), synclogic_channelnode.msg_list_tab.get().top_timestamp.get(), next.guild_name.get().toStringUtf8(), synclogic_channelnode.channel_name.get().toStringUtf8(), next.face_seq.get(), synclogic_channelnode.channel_type.get(), j3);
                        arrayList2.add(fkVar2);
                        QLog.i("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel: guildId: " + fkVar2.getGuildId() + ", channelId: " + fkVar2.getChannelId() + ", topTimeStamp: " + fkVar2.getTopTimestamp() + ", faceSeq: " + fkVar2.getAvatarSeq() + ", guildName: " + fkVar2.getGuildName() + ", channelName: " + fkVar2.getChannelName() + ", channelType: " + fkVar2.getChannelType() + ", appId: " + fkVar2.getAppId());
                    }
                }
            }
            QLog.i("GuildRegisterProxyMsgHandler", 1, "syncMsgListChannel. qqMsgListChannels size: " + arrayList2.size());
        }

        @Override // ou1.a
        protected void b(boolean z16, int i3, synclogic$MultiChannelMsgRsp synclogic_multichannelmsgrsp) {
            QLog.i("GuildRegisterProxyMsgHandler", 1, "onUpdateGetMultiChannelMsgReq isSuccess:" + z16 + " remove seq:" + i3);
        }

        @Override // ou1.a
        protected void c(boolean z16, int i3) {
            QLog.i("GuildRegisterProxyMsgHandler", 1, "onUpdatePushChannelMsg isSuccess:" + z16 + " remove seq:" + i3);
        }

        @Override // ou1.a
        protected void d(int i3) {
            if (q(i3)) {
                QLog.i("GuildRegisterProxyMsgHandler", 1, "onUpdatePushChannelMsg remove seq:" + i3);
            }
        }

        @Override // ou1.a
        protected void e(boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
            r(z16, arrayList);
            o(arrayList);
            n();
            m(arrayList);
            p(z16, arrayList);
            vt1.c.a();
            vt1.c.c(GuildRegisterProxyMsgHandler.this.f230731d, z16, arrayList);
            QLog.i("GuildRegisterProxyMsgHandler", 1, "\u9996\u5c4f\u5305\u5904\u7406\u5b8c\u6210");
        }

        @Override // ou1.a
        protected void f(boolean z16, synclogic$FirstViewRsp synclogic_firstviewrsp) {
            if (!z16) {
                QLog.e("GuildRegisterProxyMsgHandler", 1, "onUpdateRegisterProxyReq fail");
                n();
            }
            vt1.c.a();
            vt1.c.d(GuildRegisterProxyMsgHandler.this.f230731d, z16, synclogic_firstviewrsp);
        }
    }

    public GuildRegisterProxyMsgHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230732e = -1L;
        this.f230733f = -1;
        this.f230734h = -1;
        this.f230735i = 0;
        this.f230736m = new ConcurrentHashMap<>();
        this.C = 0L;
        this.D = 0L;
        this.E = new ConcurrentHashMap();
        this.G = false;
        this.H = new a();
        this.I = new Observer() { // from class: com.tencent.mobileqq.guild.message.registerproxy.d
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                GuildRegisterProxyMsgHandler.this.L2(observable, obj);
            }
        };
        this.f230731d = appInterface;
        appInterface.getRuntimeService(IGuildRegisterProxyGaryService.class, "");
        G2();
    }

    private void G2() {
        IGuildLocalFocusService iGuildLocalFocusService = (IGuildLocalFocusService) this.f230731d.getRuntimeService(IGuildLocalFocusService.class, "");
        long activeGuildId = iGuildLocalFocusService.getActiveGuildId();
        long activeChannelId = iGuildLocalFocusService.getActiveChannelId();
        long j3 = com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B;
        if (activeGuildId != j3) {
            this.C = activeGuildId;
        }
        if (activeChannelId != j3) {
            this.D = activeChannelId;
        }
        iGuildLocalFocusService.addObserver(this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(Observable observable, Object obj) {
        if (!(obj instanceof IGuildLocalFocusService.a)) {
            return;
        }
        IGuildLocalFocusService.a aVar = (IGuildLocalFocusService.a) obj;
        int i3 = aVar.f230117a;
        if (i3 == 1) {
            long longValue = ((Long) aVar.f230118b).longValue();
            if (longValue != com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
                M2(longValue);
                return;
            }
            return;
        }
        if (i3 == 2) {
            long longValue2 = ((Long) aVar.f230118b).longValue();
            if (longValue2 != com.tencent.mobileqq.guild.message.api.impl.onlinepush.e.B) {
                N2(longValue2);
            }
        }
    }

    private void M2(long j3) {
        this.D = j3;
        ((GuildRegisterProxyPullMsgProcesser) K2(2)).x();
    }

    private void N2(long j3) {
        this.C = j3;
        ((GuildRegisterProxyPullMsgProcesser) K2(2)).y();
    }

    private void P2() {
        ((IGuildLocalFocusService) this.f230731d.getRuntimeService(IGuildLocalFocusService.class, "")).deleteObserver(this.I);
    }

    public com.tencent.mobileqq.guild.message.registerproxy.a H2() {
        synchronized (this) {
            if (this.F == null) {
                this.F = new com.tencent.mobileqq.guild.message.registerproxy.a(this.f230731d);
            }
        }
        return this.F;
    }

    public long I2() {
        return this.D;
    }

    public long J2() {
        return this.C;
    }

    public h K2(int i3) {
        h hVar;
        if (!this.E.containsKey(Integer.valueOf(i3))) {
            synchronized (this.E) {
                if (!this.E.containsKey(Integer.valueOf(i3))) {
                    if (1 == i3) {
                        hVar = new c(this.f230731d, this);
                    } else if (2 == i3) {
                        hVar = new GuildRegisterProxyPullMsgProcesser(this.f230731d, this, 1);
                    } else {
                        hVar = null;
                    }
                    if (hVar == null) {
                        return null;
                    }
                    this.E.put(Integer.valueOf(i3), hVar);
                }
            }
        }
        return this.E.get(Integer.valueOf(i3));
    }

    public void O2(ArrayList<synclogic$GuildNode> arrayList) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<synclogic$GuildNode> it = arrayList.iterator();
            while (it.hasNext()) {
                synclogic$GuildNode next = it.next();
                b bVar = new b();
                bVar.f230765a = next.guild_id.get();
                if (next.huge_flag.get() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f230766b = z16;
                for (synclogic$ChannelNode synclogic_channelnode : next.rpt_channel_nodes.get()) {
                    if (synclogic_channelnode.msg_list_tab.has()) {
                        if (synclogic_channelnode.msg_list_tab.get().is_in_list.get() != 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        z17 = z18;
                    } else {
                        z17 = false;
                    }
                    bVar.f230767c.add(new b.a(synclogic_channelnode.channel_id.get(), synclogic_channelnode.msg_seq.get(), synclogic_channelnode.msg_time.get(), synclogic_channelnode.msg_notify_type.get(), z17));
                }
                arrayList2.add(bVar);
            }
            if (K2(2).b(arrayList2)) {
                this.f230735i = K2(2).a();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.g
    public void Q0(ArrayList<b> arrayList) {
        GuildRegisterProxyPullMsgProcesser guildRegisterProxyPullMsgProcesser = new GuildRegisterProxyPullMsgProcesser(this.f230731d, this, 2);
        if (guildRegisterProxyPullMsgProcesser.b(arrayList)) {
            this.f230736m.put(Integer.valueOf(guildRegisterProxyPullMsgProcesser.a()), guildRegisterProxyPullMsgProcesser);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.g
    public void f1(long j3) {
        if (this.f230732e < j3) {
            this.f230732e = j3;
            if (this.f230731d.getCurrentAccountUin() != null) {
                this.f230731d.getApp().getSharedPreferences(this.f230731d.getCurrentAccountUin(), 0).edit().putLong("guild_lastmsg_time", this.f230732e).apply();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet();
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ou1.a.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        Iterator<h> it = this.E.values().iterator();
        while (it.hasNext()) {
            it.next().onDestory();
        }
        this.E.clear();
        Iterator<h> it5 = this.f230736m.values().iterator();
        while (it5.hasNext()) {
            it5.next().onDestory();
        }
        this.f230736m.clear();
        P2();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                QLog.e("GuildRegisterProxyMsgHandler", 1, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        QLog.e("GuildRegisterProxyMsgHandler", 1, "onReceive,resp == null or req == null");
    }

    @Override // com.tencent.mobileqq.guild.message.registerproxy.g
    public void y(String str) {
        long j3;
        if (!TextUtils.isEmpty(str)) {
            try {
                j3 = Long.parseLong(str);
            } catch (Exception unused) {
                j3 = 0;
            }
            this.D = j3;
        }
    }
}
