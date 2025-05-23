package com.tencent.imcore.message.facade.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.f;
import com.tencent.imcore.message.facade.a;
import com.tencent.imcore.message.facade.b;
import com.tencent.imcore.message.facade.c;
import com.tencent.imcore.message.facade.d;
import com.tencent.imcore.message.facade.g;
import com.tencent.imcore.message.n;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.e;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IMessageFacadeService extends QRouteApi {
    Provider<List<b>> getAddMultiMsgInnerProcessorProvider();

    ConversationFacade getConversationFacade(BaseQQAppInterface baseQQAppInterface);

    n getConversationProxy(BaseQQAppInterface baseQQAppInterface);

    <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> Provider<Map<Integer, c<FT, AT>>> getLastMsgGetterProvider();

    BaseQQMessageFacade getMessageFacade(BaseQQAppInterface baseQQAppInterface);

    f getMessageProxy(BaseQQAppInterface baseQQAppInterface, int i3);

    <T extends BaseQQMessageFacade> Provider<Map<Integer, g<T>>> getMsgAddCompleteObserverProvider();

    <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> Provider<List<a<FT, AT>>> getMsgAddEndProcessorProvider();

    e getMsgHandlerMsgCache(BaseQQAppInterface baseQQAppInterface);

    Provider<Map<Integer, BaseMessageManager>> getMsgManagerProvider(AppRuntime appRuntime, MsgPool msgPool);

    <T extends BaseQQAppInterface> Provider<List<d<T>>> getMsgNotifyProcessProvider();

    <T extends BaseQQAppInterface> Provider<List<com.tencent.imcore.message.facade.f<T>>> getMsgSenderProvider();

    <FT extends BaseQQMessageFacade, AT extends BaseQQAppInterface> MsgSummary getMsgSummaryForTroop(AT at5, FT ft5, Context context, MessageRecord messageRecord, boolean z16);

    <T extends BaseQQAppInterface> Provider<List<com.tencent.imcore.message.facade.e<T>>> getRealSendProcessorProvider();

    String getUinByPhoneNum(AppInterface appInterface, String str);

    int getUnReadMsg(BaseQQAppInterface baseQQAppInterface);

    boolean isBelongServiceAccountFolder(BaseQQAppInterface baseQQAppInterface, String str);

    boolean isTroopMark(AppRuntime appRuntime, String str, int i3);

    void reportMsgBoxRead(AppInterface appInterface, int i3, BusinessObserver businessObserver);

    void setReadedForHCTopic(BaseQQAppInterface baseQQAppInterface, String str);

    void setSubaccountAssistantReaded(BaseQQAppInterface baseQQAppInterface, StringBuilder sb5, msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq, ConversationInfo conversationInfo);

    msg_svc$PbC2CReadedReportReq setTempGameMsgReaded(BaseQQAppInterface baseQQAppInterface, BaseQQMessageFacade baseQQMessageFacade, boolean z16, msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq, ConversationInfo conversationInfo);

    String trimName(String str, float f16);
}
