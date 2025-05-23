package com.tencent.mobileqq.app;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.C2CMessageProcessorCallback;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyCallback;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.adder.LongMixAddMessageHandler;
import com.tencent.imcore.message.adder.LongTextAddMessageHandler;
import com.tencent.imcore.message.ak;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGenerator;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMsgUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.mobileqq.troop.data.d;
import cooperation.qzone.util.WnsNetworkConst;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQMessageFacadeConfig implements ak.a {
    static IPatchRedirector $redirector_;
    public static ArrayList<Class<? extends AtTroopMemberInfo.Callback>> sAtTroopMemberInfoCallbackCls;
    public static ArrayList<Class<? extends ConversationInfo.Callback>> sConversationInfoCallbackCls;
    public static ArrayList<Class<? extends d.a>> sMessageNavInfoCallbackCls;
    public static ArrayList<Class<? extends MessageRecord.Callback>> sMessageRecordCallbackCls;
    private QQMessageFacade mFacade;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        sMessageRecordCallbackCls = new ArrayList<>();
        sMessageNavInfoCallbackCls = new ArrayList<>();
        sAtTroopMemberInfoCallbackCls = new ArrayList<>();
        sConversationInfoCallbackCls = new ArrayList<>();
        initAtClsInit();
    }

    public QQMessageFacadeConfig(QQMessageFacade qQMessageFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQMessageFacade);
        } else {
            this.mFacade = qQMessageFacade;
        }
    }

    private static void initAtClsInit() {
        registerMessageRecord();
        registerMessageNavInfo();
        registerAtTroopMemberInfo();
        registerConversationInfo();
        ConversationFacade.r0(new com.tencent.imcore.message.l());
        com.tencent.imcore.message.y.w2(new MsgProxyCallback());
        com.tencent.imcore.message.z.k(new com.tencent.imcore.message.aa());
        com.tencent.imcore.message.t.b(new com.tencent.imcore.message.u());
        com.tencent.mobileqq.service.message.e.N1(new com.tencent.mobileqq.service.message.f());
        com.tencent.imcore.message.ad.T(new com.tencent.imcore.message.msgproxy.b());
        com.tencent.mobileqq.graytip.g.j(new com.tencent.mobileqq.graytip.h());
        BaseMessageProcessor.y(new com.tencent.imcore.message.d());
        MsgNotifyManager.setCallback(new com.tencent.mobileqq.app.msgnotify.b());
        com.tencent.imcore.message.i.U0(new C2CMessageProcessorCallback());
        BaseMessageManager.e0(new com.tencent.imcore.message.b());
        BaseMessageManagerForTroopAndDisc.g1(new com.tencent.imcore.message.c());
        com.tencent.mobileqq.service.message.m.z(new com.tencent.mobileqq.service.message.n());
        com.tencent.mobileqq.service.message.k.y(new com.tencent.mobileqq.service.message.l());
        ParcelHooker.setCallback(new com.tencent.mobileqq.app.message.hookparcel.a());
        MessageHandlerUtils.setCallback(new bp());
        com.tencent.mobileqq.troop.data.y.B(new com.tencent.mobileqq.troop.data.z());
        C2CMessageManager.d1(new com.tencent.imcore.message.h());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setMsgProxyCallback(new com.tencent.imcore.message.msgproxy.b());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildRoamMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.j());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildOfflineMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.g());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildPushMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.h());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildMessageManagerCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.f());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildSystemMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.l());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildGuestMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.e());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildRoamMessageEventFlowProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.i());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildDispersionRoamMsgProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.d());
        ((IGuildMessageCallbackApi) QRoute.api(IGuildMessageCallbackApi.class)).setGuildS2CMessageProcessorCallback((com.tencent.mobileqq.guild.message.base.r) com.tencent.mobileqq.guild.temp.api.d.k());
    }

    private static void registerAtTroopMemberInfo() {
        if (sAtTroopMemberInfoCallbackCls.isEmpty()) {
            return;
        }
        try {
            AtTroopMemberInfo.setCallback(sAtTroopMemberInfoCallbackCls.get(0).newInstance());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void registerConversationInfo() {
        if (sConversationInfoCallbackCls.isEmpty()) {
            return;
        }
        try {
            ConversationInfo.setCallback(sConversationInfoCallbackCls.get(0).newInstance());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void registerMessageNavInfo() {
        if (sMessageNavInfoCallbackCls.isEmpty()) {
            return;
        }
        try {
            com.tencent.mobileqq.troop.data.d.g(sMessageNavInfoCallbackCls.get(0).newInstance());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void registerMessageRecord() {
        if (sMessageRecordCallbackCls.isEmpty()) {
            return;
        }
        try {
            MessageRecord.setCallback(sMessageRecordCallbackCls.get(0).newInstance());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initAddMessageHandler(com.tencent.imcore.message.adder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        aVar.register(com.tencent.imcore.message.adder.k.class);
        aVar.register(com.tencent.imcore.message.adder.j.class);
        aVar.register(com.tencent.imcore.message.adder.g.class);
        aVar.register(LongTextAddMessageHandler.class);
        aVar.register(LongMixAddMessageHandler.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initAioMsgHandler(com.tencent.imcore.message.aiolist.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        aVar.register(com.tencent.imcore.message.aiolist.c.class);
        aVar.register(com.tencent.imcore.message.aiolist.d.class);
        aVar.register(com.tencent.imcore.message.aiolist.e.class);
        aVar.register(com.tencent.imcore.message.aiolist.h.class);
        aVar.register(com.tencent.imcore.message.aiolist.g.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initC2CAddMessageHandler(com.tencent.imcore.message.adder.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
            return;
        }
        cVar.register(ge1.a.class);
        cVar.register(com.tencent.imcore.message.adder.f.class);
        cVar.register(com.tencent.imcore.message.adder.e.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initC2CMessageDecoderGenerator(com.tencent.mobileqq.service.message.codec.decoder.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
            return;
        }
        bVar.a(193, com.tencent.mobileqq.service.message.codec.decoder.m.class);
        bVar.a(Integer.valueOf(PlayerResources.ViewId.GET_MORE_JUMP_AREA), com.tencent.mobileqq.service.message.codec.decoder.n.class);
        bVar.a(Integer.valueOf(WnsNetworkConst.NETWORK_DISABLE), com.tencent.mobileqq.service.message.codec.decoder.h.class);
        bVar.a(524, com.tencent.mobileqq.service.message.codec.decoder.e.class);
        bVar.a(528, MsgType0x210Decoder.class);
        bVar.a(529, com.tencent.mobileqq.service.message.codec.decoder.g.class);
        bVar.a(208, com.tencent.mobileqq.service.message.codec.decoder.i.class);
        bVar.a(140, com.tencent.mobileqq.service.message.codec.decoder.k.class);
        bVar.a(141, com.tencent.mobileqq.service.message.codec.decoder.k.class);
        bVar.a(187, com.tencent.mobileqq.service.message.codec.decoder.j.class);
        bVar.a(188, com.tencent.mobileqq.service.message.codec.decoder.j.class);
        bVar.a(189, com.tencent.mobileqq.service.message.codec.decoder.j.class);
        bVar.a(190, com.tencent.mobileqq.service.message.codec.decoder.j.class);
        bVar.a(191, com.tencent.mobileqq.service.message.codec.decoder.j.class);
        bVar.a(84, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(86, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(87, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(35, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(37, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(45, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(46, com.tencent.mobileqq.service.message.codec.decoder.l.class);
        bVar.a(9, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(10, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(31, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(79, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(97, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(120, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(132, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(133, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(166, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.a(167, com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.a.class);
        bVar.register(com.tencent.mobileqq.service.message.codec.decoder.a.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initGeneralFlagProvider(GeneralFlagProviderGenerator generalFlagProviderGenerator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) generalFlagProviderGenerator);
            return;
        }
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.a.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.k.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.o.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.p.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.c.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.q.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.m.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.f.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.b.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.h.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.e.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.n.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.g.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.i.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.j.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.l.class);
        generalFlagProviderGenerator.register(com.tencent.mobileqq.app.generalflag.d.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initMessageDecoder(com.tencent.imcore.message.decoder.l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) lVar);
            return;
        }
        lVar.register(com.tencent.imcore.message.decoder.v.class);
        lVar.register(com.tencent.imcore.message.decoder.aa.class);
        lVar.register(com.tencent.imcore.message.decoder.y.class);
        lVar.register(com.tencent.imcore.message.decoder.a.class);
        lVar.register(com.tencent.imcore.message.decoder.u.class);
        lVar.register(com.tencent.imcore.message.decoder.ab.class);
        lVar.register(com.tencent.imcore.message.decoder.r.class);
        lVar.register(com.tencent.imcore.message.decoder.q.class);
        lVar.register(com.tencent.imcore.message.decoder.o.class);
        lVar.register(com.tencent.imcore.message.decoder.z.class);
        lVar.register(com.tencent.imcore.message.decoder.k.class);
        lVar.register(com.tencent.imcore.message.decoder.x.class);
        lVar.register(com.tencent.imcore.message.decoder.n.class);
        lVar.register(com.tencent.imcore.message.decoder.i.class);
        lVar.register(com.tencent.imcore.message.decoder.t.class);
        lVar.register(com.tencent.imcore.message.decoder.p.class);
        lVar.register(com.tencent.imcore.message.decoder.f.class);
        lVar.register(com.tencent.imcore.message.decoder.w.class);
        lVar.register(com.tencent.imcore.message.decoder.s.class);
        lVar.register(com.tencent.imcore.message.decoder.ah.class);
        lVar.register(com.tencent.imcore.message.decoder.h.class);
        lVar.register(com.tencent.imcore.message.decoder.b.class);
        lVar.register(com.tencent.imcore.message.decoder.c.class);
        lVar.register(com.tencent.imcore.message.decoder.d.class);
        lVar.register(com.tencent.imcore.message.decoder.g.class);
        lVar.register(com.tencent.imcore.message.decoder.af.class);
        lVar.register(com.tencent.imcore.message.decoder.ac.class);
        lVar.register(com.tencent.imcore.message.decoder.ag.class);
        lVar.register(com.tencent.imcore.message.decoder.ae.class);
        lVar.register(com.tencent.imcore.message.decoder.ad.class);
        lVar.register(com.tencent.imcore.message.decoder.e.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initMsgBoxAppender(com.tencent.imcore.message.msgboxappender.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
            return;
        }
        fVar.register(com.tencent.imcore.message.msgboxappender.i.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.d.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.c.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.j.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.k.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.h.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.a.class);
        fVar.register(com.tencent.imcore.message.msgboxappender.e.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initPBMsgElemDecoder(com.tencent.imcore.message.core.codec.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ad.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ak.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.g.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.q.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.o.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.b.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.u.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.j.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.aq.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ai.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.z.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.aj.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ab.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.y.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ac.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.t.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.x.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ag.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ah.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.l.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.k.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.aa.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.w.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.am.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.an.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.al.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.h.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.c.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.d.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.i.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.s.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ae.class);
        bVar.register(LifeOnlineElemDecoder.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.v.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.n.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.f.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ao.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.p.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.e.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.m.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ar.class);
        bVar.register(zt.a.class);
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.r.class);
        bVar.register(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMessageForLiveGiftDecoder());
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.a.class);
        bVar.register(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMsgEventDecoder());
        bVar.register(((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).getGuildMixElemDecoder());
        bVar.register(((IGuildFeedMsgUtilsApi) QRoute.api(IGuildFeedMsgUtilsApi.class)).getMsgFeedDecoder());
        bVar.register(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getAppChannelNormalMsgDecoder());
        bVar.register(com.tencent.imcore.message.ext.codec.decoder.pbelement.ap.class);
        bVar.register(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getAppChannelMarkdownDecoder());
        bVar.register(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getAppChannelInnerKeyboardDecoder());
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initPbSendReqHandler(PbSendReqHandlerGenerator pbSendReqHandlerGenerator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pbSendReqHandlerGenerator);
            return;
        }
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.g.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.b.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.a.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.e.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.c.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.h.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.d.class);
        pbSendReqHandlerGenerator.register(com.tencent.mobileqq.app.pbsendhandler.f.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initRichTextAndMsgViaProvider(RichTextAndMsgViaProviderGenerator richTextAndMsgViaProviderGenerator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) richTextAndMsgViaProviderGenerator);
            return;
        }
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.v.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.p.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.x.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.i.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.j.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.h.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.s.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.u.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.r.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.k.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.b.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.e.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.o.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.n.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.t.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.a.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.guild.temp.api.d.b());
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.m.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.w.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.q.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.d.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.c.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.f.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.g.class);
        richTextAndMsgViaProviderGenerator.register(com.tencent.mobileqq.app.richtext.l.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initRoutingType(com.tencent.imcore.message.core.codec.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
            return;
        }
        eVar.a(1, com.tencent.imcore.message.ext.codec.routingtype.d.class);
        eVar.a(3, com.tencent.imcore.message.ext.codec.routingtype.n.class);
        eVar.a(6, com.tencent.imcore.message.ext.codec.routingtype.ae.class);
        eVar.a(8, com.tencent.imcore.message.ext.codec.routingtype.y.class);
        eVar.a(10, com.tencent.imcore.message.ext.codec.routingtype.i.class);
        eVar.a(5, com.tencent.imcore.message.ext.codec.routingtype.k.class);
        eVar.a(11, com.tencent.imcore.message.ext.codec.routingtype.ab.class);
        eVar.a(12, com.tencent.imcore.message.ext.codec.routingtype.p.class);
        eVar.a(23, com.tencent.imcore.message.ext.codec.routingtype.ad.class);
        eVar.a(25, com.tencent.imcore.message.ext.codec.routingtype.g.class);
        eVar.a(26, com.tencent.imcore.message.ext.codec.routingtype.h.class);
        eVar.a(24, com.tencent.imcore.message.ext.codec.routingtype.t.class);
        eVar.a(4, com.tencent.imcore.message.ext.codec.routingtype.j.class);
        eVar.a(2, com.tencent.imcore.message.ext.codec.routingtype.m.class);
        eVar.a(14, com.tencent.imcore.message.ext.codec.routingtype.w.class);
        eVar.a(16, com.tencent.imcore.message.ext.codec.routingtype.e.class);
        eVar.a(17, com.tencent.imcore.message.ext.codec.routingtype.l.class);
        eVar.a(18, com.tencent.imcore.message.ext.codec.routingtype.x.class);
        eVar.a(15, com.tencent.imcore.message.ext.codec.routingtype.c.class);
        eVar.a(19, com.tencent.imcore.message.ext.codec.routingtype.v.class);
        eVar.a(20, com.tencent.imcore.message.ext.codec.routingtype.u.class);
        eVar.a(21, com.tencent.imcore.message.ext.codec.routingtype.o.class);
        eVar.a(22, com.tencent.imcore.message.ext.codec.routingtype.a.class);
        eVar.a(27, com.tencent.imcore.message.ext.codec.routingtype.f.class);
        eVar.a(29, com.tencent.imcore.message.ext.codec.routingtype.r.class);
        eVar.a(30, com.tencent.imcore.message.ext.codec.routingtype.q.class);
        eVar.a(31, com.tencent.imcore.message.ext.codec.routingtype.aa.class);
        eVar.a(32, com.tencent.imcore.message.ext.codec.routingtype.z.class);
        eVar.a(33, com.tencent.imcore.message.ext.codec.routingtype.b.class);
        eVar.a(34, com.tencent.imcore.message.ext.codec.routingtype.s.class);
        eVar.a(35, com.tencent.imcore.message.ext.codec.routingtype.ac.class);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initUinTypeRoutingTypeMap(com.tencent.imcore.message.core.codec.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) gVar);
            return;
        }
        gVar.a(0, 1);
        gVar.a(1000, 3);
        gVar.a(10004, 24);
        gVar.a(1005, 6);
        gVar.a(1008, 8);
        gVar.a(1006, 10);
        gVar.a(1004, 5);
        gVar.a(1009, 11);
        gVar.a(3000, 4);
        gVar.a(1, 2);
        gVar.a(1001, 12);
        gVar.a(10002, 23);
        gVar.a(1033, 25);
        gVar.a(1034, 26);
        gVar.a(1020, 14);
        gVar.a(1021, 16);
        gVar.a(1022, 17);
        gVar.a(1023, 18);
        gVar.a(1025, 15);
        gVar.a(1024, 15);
        gVar.a(1010, 19);
        gVar.a(AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION, 22);
        gVar.a(1026, 21);
        gVar.a(1036, 27);
        gVar.a(1044, 29);
        gVar.a(1045, 30);
        gVar.a(10007, 31);
        gVar.a(10008, 32);
        gVar.a(10010, 33);
        gVar.a(1046, 34);
        gVar.a(10019, 35);
    }

    @Override // com.tencent.imcore.message.ak.a
    public void initUnreadMsgNumCallback(com.tencent.imcore.message.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) eVar);
            return;
        }
        eVar.register(com.tencent.mobileqq.troop.blocktroop.l.class);
        eVar.register(com.tencent.mobileqq.activity.recent.msgbox.d.class);
        eVar.register(com.tencent.imcore.message.ext.codec.a.class);
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mFacade.Y().w(this);
        }
    }
}
