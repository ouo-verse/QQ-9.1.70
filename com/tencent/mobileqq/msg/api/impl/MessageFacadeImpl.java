package com.tencent.mobileqq.msg.api.impl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ak;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.qphone.base.util.QLog;
import ed1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msf.msgsvc.msg_svc$RoutingHead;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MessageFacadeImpl implements IMessageFacade {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "MessageFacadeImpl";
    private QQAppInterface mApp;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseMessageObserver f251004d;

        a(BaseMessageObserver baseMessageObserver) {
            this.f251004d = baseMessageObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MessageFacadeImpl.this, (Object) baseMessageObserver);
            }
        }

        @Override // com.tencent.mobileqq.app.bs, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else {
                this.f251004d.onUpdate(i3, z16, obj);
            }
        }
    }

    public MessageFacadeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQMessageFacade getMessageFacade() {
        return this.mApp.getMessageFacade();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addAIOHeadMessage(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, str, Integer.valueOf(i3), list);
        } else {
            this.mApp.getMessageFacade().f1(str, i3, list);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(MessageRecord messageRecord, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            getMessageFacade().c(messageRecord, str);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) observer);
        } else {
            getMessageFacade().addObserver(observer);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void cancelNotificationWhenRevokeMessage(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) messageRecord);
        } else {
            getMessageFacade().f116353m.cancelNotificationWhenRevokeMessage(messageRecord);
        }
    }

    public boolean checkAppRuntimeInValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        if (this.mApp == null) {
            QLog.d(TAG, 1, "checkAppRuntimeInValid mApp == null");
        }
        if (this.mApp == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int clearHistory(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) ? getMessageFacade().q(str, i3) : ((Integer) iPatchRedirector.redirect((short) 48, (Object) this, (Object) str, i3)).intValue();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void clearInAioParallerPullMsgMark(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, str, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            getMessageFacade().G1().i1(str, j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void clearTransFileInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            getMessageFacade().j1(str);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord constructMessageForText(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 34, this, str, str2, str3, Integer.valueOf(i3));
        }
        MessageForText messageForText = new MessageForText();
        messageForText.selfuin = this.mApp.getCurrentAccountUin();
        messageForText.frienduin = str3;
        messageForText.istroop = i3;
        messageForText.senderuin = "";
        messageForText.time = NetConnInfoCenter.getServerTime();
        messageForText.f203106msg = str;
        messageForText.uniseq = str2.hashCode();
        return messageForText;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void decodeMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) messageRecord);
        } else {
            getMessageFacade().w((Message) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void deleteObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) observer);
        } else {
            getMessageFacade().deleteObserver(observer);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void dumpmsgs(String str, Collection<MessageRecord> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) str, (Object) collection);
        } else {
            getMessageFacade().B(str, collection);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord findLongMsgHead(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 25, (Object) this, (Object) messageRecord);
        }
        return getMessageFacade().C(messageRecord);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getAIOList(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) ? new ArrayList(this.mApp.getMessageFacade().l1(str, i3)) : (List) iPatchRedirector.redirect((short) 44, (Object) this, (Object) str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getAllMessages(String str, int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (List) iPatchRedirector.redirect((short) 43, this, str, Integer.valueOf(i3), iArr);
        }
        return getMessageFacade().D(str, i3, iArr);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public ConcurrentHashMap<String, Boolean> getAutoPullCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        return getMessageFacade().H;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Map<String, Message> getCachedMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Map) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mApp.getMessageFacade().f116349e;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public String getCurrChatUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.mApp.getMessageFacade().s1();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public DraftSummaryInfo getDraftSummaryInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (DraftSummaryInfo) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str, i3);
        }
        return getMessageFacade().getDraftSummaryInfo(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Handler getFacadeHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Handler) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return getMessageFacade().f116351h;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Message getFirstUnreadMessage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (Message) iPatchRedirector.redirect((short) 81, (Object) this, (Object) str, i3);
        }
        return this.mApp.getMessageFacade().u1(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Message getIncomingMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Message) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return getMessageFacade().v1();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getIsLastMsgCacheLazyLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Integer) iPatchRedirector.redirect((short) 90, (Object) this)).intValue();
        }
        return getMessageFacade().Q.a();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean getIsLastMsgCacheLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Boolean) iPatchRedirector.redirect((short) 91, (Object) this)).booleanValue();
        }
        return getMessageFacade().Q.b();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Message getLastMessage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Message) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str, i3);
        }
        QQMessageFacade messageFacade = getMessageFacade();
        if (messageFacade != null) {
            return messageFacade.getLastMessage(str, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord getLastMsgForMsgTab(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3);
        }
        return getMessageFacade().x1(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord getLastMsgForMsgTabWithAutoInit(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, i3);
        }
        return getMessageFacade().y1(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getMessages(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (List) iPatchRedirector.redirect((short) 63, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return getMessageFacade().N(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord getMsgItemByUniseq(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 58, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return getMessageFacade().P(str, i3, j3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getMsgList(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        if (checkAppRuntimeInValid()) {
            return null;
        }
        return getMessageFacade().Q(str, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public long getMsgUinSeq(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord)).longValue();
        }
        return messageRecord.uniseq;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<com.tencent.imcore.message.core.codec.a> getPBMsgElemsDecoders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return getMessageFacade().Y().o();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public ConcurrentHashMap<Integer, List<MessageRecord>> getPullCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return getMessageFacade().G;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public AtomicInteger getPullCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (AtomicInteger) iPatchRedirector.redirect((short) 72, (Object) this);
        }
        return getMessageFacade().F;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Object getQQMessageFacadeStub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return getMessageFacade();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getQuickDBMsgCount(String str, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Integer) iPatchRedirector.redirect((short) 84, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).intValue();
        }
        return getMessageFacade().A1(str, j3, j16, z16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getQuickDbMessage(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (List) iPatchRedirector.redirect((short) 86, (Object) this, (Object) str, (Object) str2);
        }
        return getMessageFacade().C1(str, str2);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Map<String, Boolean> getRefreshActionMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Map) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return getMessageFacade().f116350f;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public ak getRegistry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (ak) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return getMessageFacade().Y();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getRoutingType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, i3)).intValue();
        }
        return getMessageFacade().Y().u().getRoutingType(i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord getSendingTroopMsgItem(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 64)) ? getMessageFacade().a0(str, i3, messageRecord) : (MessageRecord) iPatchRedirector.redirect((short) 64, this, str, Integer.valueOf(i3), messageRecord);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getSlowDBMsgCount(String str, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return ((Integer) iPatchRedirector.redirect((short) 85, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).intValue();
        }
        return getMessageFacade().D1(str, j3, j16, z16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> getSlowDbMessage(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (List) iPatchRedirector.redirect((short) 87, (Object) this, (Object) str, (Object) str2);
        }
        return getMessageFacade().E1(str, str2);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public String getSqlStr(String str, long j3, long j16, long j17, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (String) iPatchRedirector.redirect((short) 88, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return getMessageFacade().c0(str, j3, j16, j17, i3, z16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public c getTinyIdCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (c) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return getMessageFacade().F1();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getUinType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return getMessageFacade().Y().t().get(Integer.valueOf(i3)).getUinType();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int getUnreadMsgsNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.mApp.getMessageFacade().H1();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void handleReceivedMessage(int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            this.mApp.handleReceivedMessage(i3, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void handleRefreshMessageListHeadResult(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, str, Integer.valueOf(i3), list, list2, bundle);
        } else {
            getMessageFacade().g0(str, i3, list, list2, bundle);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void handleRevokedNotifyAndNotify(ArrayList<RevokeMsgInfo> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, arrayList, Boolean.valueOf(z16));
        } else {
            getMessageFacade().I1(arrayList, z16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean isChatting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Boolean) iPatchRedirector.redirect((short) 78, (Object) this)).booleanValue();
        }
        return this.mApp.getMessageFacade().K1();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean isMessageForText(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord instanceof MessageForText) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean isTheLastTabMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return getMessageFacade().k0(messageRecord);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = "MessageFacadeImpl onCreate: app instanceOf QQApp: ";
            objArr[1] = Boolean.valueOf(appRuntime instanceof QQAppInterface);
            objArr[2] = "app is null: ";
            if (appRuntime == null) {
                z16 = true;
            }
            objArr[3] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean pullRecentGroupMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Boolean) iPatchRedirector.redirect((short) 89, (Object) this, (Object) str)).booleanValue();
        }
        return getMessageFacade().O1(str);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void putAioInParallelPullMsgMark(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, str, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            getMessageFacade().G1().j1(str, j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void qLogColor(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) str2);
        } else {
            getMessageFacade().p0(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<MessageRecord> queryMsgItemByShmsgseq(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (List) iPatchRedirector.redirect((short) 68, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return getMessageFacade().t0(str, i3, j3, j16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord queryMsgItemByUniseq(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 62, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return getMessageFacade().w0(str, i3, j3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void removeMsgByMessageRecord(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, messageRecord, Boolean.valueOf(z16));
        } else if (!checkAppRuntimeInValid() && messageRecord != null) {
            getMessageFacade().z0(messageRecord, z16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void removeMsgByUniseq(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            getMessageFacade().T1(str, i3, j3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean removeMsgFromCacheByUniseq(String str, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return ((Boolean) iPatchRedirector.redirect((short) 82, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3))).booleanValue();
        }
        return this.mApp.getMessageFacade().A0(str, i3, i16, j3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void removeNotification(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str, i3);
        } else {
            getMessageFacade().f116353m.removeNotification(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void removeRecentUser(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) recentUser);
        } else {
            getMessageFacade().Z1(recentUser);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void sendMessage(MessageRecord messageRecord, BaseMessageObserver baseMessageObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageRecord, (Object) baseMessageObserver);
        } else {
            if (checkAppRuntimeInValid() || messageRecord == null) {
                return;
            }
            this.mApp.getMessageFacade().D0(messageRecord, new a(baseMessageObserver));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean setAutoPullC2CMsgResult(String str, int i3, List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, str, Integer.valueOf(i3), list, Boolean.valueOf(z16))).booleanValue();
        }
        return getMessageFacade().H0(str, i3, list, z16);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setChangeAndNotify(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, obj);
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            getMessageFacade().K0(obj);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setIncomingMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) messageRecord);
        } else {
            getMessageFacade().e2((Message) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setReadFrom(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 46)) {
            getMessageFacade().M0(str, i3, j3);
        } else {
            iPatchRedirector.redirect((short) 46, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setReaded(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 52)) {
            getMessageFacade().R0(str, i3, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 52, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public boolean setRoutingHead(AppInterface appInterface, int i3, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, this, appInterface, Integer.valueOf(i3), obj, obj2)).booleanValue();
        }
        if (!(obj2 instanceof MessageRecord) || !(obj instanceof msg_svc$RoutingHead) || !(appInterface instanceof QQAppInterface)) {
            return false;
        }
        return getMessageFacade().Y().t().get(Integer.valueOf(i3)).c((msg_svc$RoutingHead) obj, (MessageRecord) obj2, (QQAppInterface) appInterface);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void stopHttpProcessorIfNeed(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) messageRecord);
        } else {
            getMessageFacade().f2(messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void updateGroupMsgSeqAndTimeByUniseq(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            getMessageFacade().g2(str, i3, j3, j16, j17);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void updateMsgContentByUniseq(String str, int i3, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            getMessageFacade().Y0(str, i3, j3, bArr);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void updateMsgFieldByUniseq(String str, int i3, long j3, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, obj);
        } else {
            getMessageFacade().a1(str, i3, j3, str2, obj);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(List<MessageRecord> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list, (Object) str);
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            getMessageFacade().i(list, str, this.mApp.isBackgroundStop);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public int clearHistory(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) ? getMessageFacade().r(str, i3, z16, z17) : ((Integer) iPatchRedirector.redirect((short) 49, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public List<ChatMessage> getAIOList(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) ? getMessageFacade().m1(str, i3, j3) : (List) iPatchRedirector.redirect((short) 50, this, str, Integer.valueOf(i3), Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public MessageRecord getSendingTroopMsgItem(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 77)) ? getMessageFacade().b0(str, i3, messageRecord, list) : (MessageRecord) iPatchRedirector.redirect((short) 77, this, str, Integer.valueOf(i3), messageRecord, list);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void handleReceivedMessage(int i3, boolean z16, boolean z17, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            this.mApp.handleReceivedMessage(i3, z16, z17, message);
        } else {
            iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), message);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setReadFrom(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            getMessageFacade().N0(str, i3, j3, z16);
        } else {
            iPatchRedirector.redirect((short) 47, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void setReaded(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 80)) {
            this.mApp.getMessageFacade().O0(str, i3);
        } else {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public Message getLastMessage(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) ? getMessageFacade().K(str, i3, i16) : (Message) iPatchRedirector.redirect((short) 41, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void removeMsgByUniseq(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            getMessageFacade().V1(str, i3, j3, z16);
        } else {
            iPatchRedirector.redirect((short) 51, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            getMessageFacade().e(arrayList, str, z16);
        } else {
            iPatchRedirector.redirect((short) 7, this, arrayList, str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(MessageRecord messageRecord, String str, boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, messageRecord, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            getMessageFacade().d(messageRecord, str, z16, z17, z18, z19);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(List<MessageRecord> list, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, str, Boolean.valueOf(z16));
        } else {
            if (checkAppRuntimeInValid()) {
                return;
            }
            this.mApp.getMessageFacade().i(list, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            getMessageFacade().f(arrayList, str, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 10, this, arrayList, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageFacade
    public void addMessage(ArrayList<MessageRecord> arrayList, String str, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 66)) {
            getMessageFacade().g(arrayList, str, z16, z17, z18);
        } else {
            iPatchRedirector.redirect((short) 66, this, arrayList, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }
}
