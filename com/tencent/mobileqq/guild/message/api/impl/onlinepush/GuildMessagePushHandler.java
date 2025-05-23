package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.n;
import com.tencent.mobileqq.guild.message.registerproxy.b;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import st1.g;
import tencent.im.group_pro_proto.common.common$Msg;

@KeepClassConstructor
/* loaded from: classes14.dex */
public class GuildMessagePushHandler extends BaseGuildMessageHandler implements g {
    private e C;
    private b D;
    private f E;
    private GPServiceObserver F;

    /* renamed from: d, reason: collision with root package name */
    protected final AppInterface f230205d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f230206e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f230207f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f230208h;

    /* renamed from: i, reason: collision with root package name */
    private GuildMsgPushConsumer f230209i;

    /* renamed from: m, reason: collision with root package name */
    private c f230210m;

    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "onAddGuild.");
            }
            if (iGProGuildInfo != null && iGProGuildInfo.getUserType() == 0) {
                GuildMessagePushHandler.this.P2(iGProGuildInfo.getGuildID(), true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(String str, String str2, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "onChannelVisibleChanged.");
            }
            if (i16 == 1) {
                GuildMessagePushHandler.this.O2(str, str2);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onCreateChannel(IGProChannelInfo iGProChannelInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "onCreateChannel.");
            }
            if (iGProChannelInfo != null) {
                GuildMessagePushHandler.this.O2(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onCreateGuild(IGProGuildInfo iGProGuildInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "onCreateGuild.");
            }
            if (iGProGuildInfo != null) {
                GuildMessagePushHandler.this.P2(iGProGuildInfo.getGuildID(), false);
            }
        }
    }

    public GuildMessagePushHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230207f = false;
        this.f230208h = false;
        this.E = new f(5000);
        this.F = new a();
        this.f230205d = appInterface;
        e eVar = new e(appInterface, this);
        this.C = eVar;
        eVar.B();
        this.f230209i = new GuildMsgPushConsumer(this);
        this.f230210m = new c(this);
        this.D = new b(appInterface);
    }

    private void G2() {
        if (this.f230207f) {
            return;
        }
        this.f230207f = true;
        final IGProGlobalService iGProGlobalService = (IGProGlobalService) this.f230205d.getRuntimeService(IGProGlobalService.class, "");
        iGProGlobalService.addObserver(this.F);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.onlinepush.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildMessagePushHandler.N2(IGProGlobalService.this);
            }
        });
    }

    private void M2(String str, IGProChannelInfo iGProChannelInfo, ArrayList<b.a> arrayList) {
        if (!TextUtils.isEmpty(str) && iGProChannelInfo != null && arrayList != null) {
            IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) this.f230205d.getRuntimeService(IGuildMsgSeqTimeService.class, "");
            int channelType = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).getChannelType(this.f230205d, str, iGProChannelInfo.getChannelUin());
            if (iGProChannelInfo.getType() != 5 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSupportTextChannleAbility(channelType)) {
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).addMessageForGuildWelcome((BaseQQAppInterface) this.f230205d, iGProChannelInfo.getChannelUin());
            }
            IGuildMsgSeqTimeService.a aVar = new IGuildMsgSeqTimeService.a(iGProChannelInfo.getLastMsgSeq(), iGProChannelInfo.getLastCntMsgSeq(), iGProChannelInfo.getLastMsgTime(), iGProChannelInfo.getMsgMeta());
            iGuildMsgSeqTimeService.setLastSvrMsgSeq(str, iGProChannelInfo.getChannelUin(), aVar, true);
            IGuildMsgSeqTimeService.a aVar2 = new IGuildMsgSeqTimeService.a(iGProChannelInfo.getReadMsgSeq(), iGProChannelInfo.getReadCntMsgSeq(), iGProChannelInfo.getReadMsgTime(), iGProChannelInfo.getReadMsgMeta());
            iGuildMsgSeqTimeService.setReadedMsgSeq(str, iGProChannelInfo.getChannelUin(), aVar2, true);
            long parseLong = Long.parseLong(iGProChannelInfo.getChannelUin());
            arrayList.add(new b.a(parseLong, iGProChannelInfo.getLastMsgSeq(), iGProChannelInfo.getLastMsgTime(), iGProChannelInfo.getFinalMsgNotify(), false));
            QLog.i("GuildMessagePushHandler", 1, "handleNewChannelAdded. PullMsgChannelInfo: channelIdL = " + parseLong + ", LastSvrMsgSeqItem toString: " + aVar.toString() + ", msgSeqReadedItem toString: " + aVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N2(IGProGlobalService iGProGlobalService) {
        if (ca.a()) {
            iGProGlobalService.initSdk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2(String str, String str2) {
        QLog.i("GuildMessagePushHandler", 1, "onNewChannelAdded guildId:" + str + " channelId:" + str2);
        if (!I2() && H2(false) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                com.tencent.mobileqq.guild.message.registerproxy.g gVar = (com.tencent.mobileqq.guild.message.registerproxy.g) this.f230205d.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName());
                IGProChannelInfo channelInfo = ((IGPSService) this.f230205d.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
                ArrayList<com.tencent.mobileqq.guild.message.registerproxy.b> arrayList = new ArrayList<>();
                com.tencent.mobileqq.guild.message.registerproxy.b bVar = new com.tencent.mobileqq.guild.message.registerproxy.b();
                bVar.f230765a = Long.parseLong(str);
                arrayList.add(bVar);
                M2(str, channelInfo, bVar.f230767c);
                QLog.i("GuildMessagePushHandler", 1, "onNewChannelAdded. pullChannelMsgs: key = " + str + ", paramListSize: " + bVar.f230767c.size());
                gVar.Q0(arrayList);
            } catch (Exception e16) {
                QLog.e("GuildMessagePushHandler", 1, "onNewChannelAdded. invalid key or channelId. " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(String str, boolean z16) {
        QLog.i("GuildMessagePushHandler", 1, "onNewGuildAdded guildId:" + str + " clearAioCache:" + z16);
        if (I2() || !H2(false) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.tencent.mobileqq.guild.message.registerproxy.g gVar = (com.tencent.mobileqq.guild.message.registerproxy.g) this.f230205d.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName());
            List<IGProChannelInfo> channelList = ((IGPSService) this.f230205d.getRuntimeService(IGPSService.class, "")).getChannelList(str);
            ArrayList<com.tencent.mobileqq.guild.message.registerproxy.b> arrayList = new ArrayList<>();
            com.tencent.mobileqq.guild.message.registerproxy.b bVar = new com.tencent.mobileqq.guild.message.registerproxy.b();
            bVar.f230765a = Long.parseLong(str);
            arrayList.add(bVar);
            for (IGProChannelInfo iGProChannelInfo : channelList) {
                if (z16 && iGProChannelInfo != null) {
                    ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230205d).F(10014).y(10014).t(10014, iGProChannelInfo.getChannelUin());
                }
                M2(str, iGProChannelInfo, bVar.f230767c);
            }
            QLog.i("GuildMessagePushHandler", 1, "onNewGuildAdded. pullChannelMsgs: key = " + str + ", paramListSize: " + bVar.f230767c.size());
            IGProChannelInfo R = ch.R(channelList);
            if (R != null) {
                gVar.y(R.getChannelUin());
            }
            gVar.Q0(arrayList);
        } catch (Exception e16) {
            QLog.e("GuildMessagePushHandler", 1, "onNewGuildAdded. invalid key or channelId. " + e16.getMessage());
        }
    }

    @Override // st1.g
    public void B(long j3) {
        this.f230209i.h(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H2(boolean z16) {
        if (z16 && !this.f230207f) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "checkReadyToReceiveMsg: isGpsObserverAdded = false. Try to add observer.");
            }
            G2();
        }
        if (!TextUtils.isEmpty(((IGPSService) this.f230205d.getRuntimeService(IGPSService.class, "")).getSelfTinyId()) || this.f230208h) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMessagePushHandler", 2, "handleNewGuildOrChannelAdded. selfTid is empty, do sendRegisterProxy.");
        }
        this.f230208h = true;
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).startAsyncStepLite(this.f230205d);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I2() {
        return false;
    }

    @Override // st1.g
    public void J1(String str, long j3) {
        notifyUI(n.C, true, new Object[]{str, Long.valueOf(j3)});
    }

    public b J2() {
        return this.D;
    }

    @Override // st1.g
    public void K1() {
        QLog.i("GuildMessagePushHandler", 1, "runActiveChannelTaskImmediately");
        this.C.T();
    }

    public e K2() {
        return this.C;
    }

    public void L2(List<byte[]> list) {
        this.f230209i.e(list);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushCommandList() {
        if (this.f230206e == null) {
            this.f230206e = new HashSet();
        }
        return this.f230206e;
    }

    @Override // st1.g
    public void j() {
        QLog.i("GuildMessagePushHandler", 1, "handleOnlinePushAfterSyncMsg");
        this.C.G();
        this.f230210m.s();
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return n.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        this.f230209i.g();
        this.f230210m.r();
        this.C.C();
    }

    @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd) && QLog.isColorLevel()) {
                QLog.d("GuildMessagePushHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMessagePushHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // st1.g
    public void p1(List<common$Msg> list) {
        this.f230209i.f(list);
    }
}
