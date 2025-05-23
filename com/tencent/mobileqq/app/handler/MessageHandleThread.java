package com.tencent.mobileqq.app.handler;

import MessageSvcPack.GroupInfo;
import MessageSvcPack.stConfNumInfo;
import RegisterProxySvcPack.RegisterPushNotice;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import msf.registerproxy.register_proxy$DiscussList;
import msf.registerproxy.register_proxy$GroupList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageHandleThread extends BaseThread {
    static IPatchRedirector $redirector_;
    public static long MESSAGE_HANDLE_THREAD_TIMEOUT;
    public volatile boolean isDoing;
    public boolean isRunning;
    private final BaseMessageHandler messageHandler;
    private final RegisterProxyHandler registerProxyHandler;
    ArrayList<MessageObject> respMsgQueue;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            MESSAGE_HANDLE_THREAD_TIMEOUT = 180000L;
        }
    }

    public MessageHandleThread(RegisterProxyHandler registerProxyHandler, BaseMessageHandler baseMessageHandler, ArrayList<MessageObject> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, registerProxyHandler, baseMessageHandler, arrayList);
            return;
        }
        this.isRunning = true;
        this.isDoing = false;
        this.registerProxyHandler = registerProxyHandler;
        this.messageHandler = baseMessageHandler;
        this.respMsgQueue = arrayList;
    }

    private int getCheck(int i3) {
        MessageObject messageObject;
        TraceUtils.traceBegin("do");
        try {
            try {
                synchronized (this.respMsgQueue) {
                    if (this.respMsgQueue.size() > 0) {
                        messageObject = this.respMsgQueue.remove(0);
                        i3 = 0;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(BaseMessageHandler.TAG, 2, "MessageHandleThread waiting... name=" + getName());
                        }
                        this.respMsgQueue.wait(MESSAGE_HANDLE_THREAD_TIMEOUT);
                        i3++;
                        messageObject = null;
                    }
                }
                this.isDoing = true;
                if (messageObject != null) {
                    handleMessageObject(messageObject);
                }
                this.isDoing = false;
                if (this.registerProxyHandler.registerProxyEnd != null && this.registerProxyHandler.isAllTroopThreadDone() && this.registerProxyHandler.isTroopQueueEmpty()) {
                    handleAllMsgDone();
                }
                if (this.registerProxyHandler.isFirstGroupMsgFin()) {
                    this.messageHandler.notifyUI(4017, true, null);
                }
                RegisterProxyHandler registerProxyHandler = this.registerProxyHandler;
                if (registerProxyHandler.hasNewRegisterAllEnd && registerProxyHandler.isAllTroopThreadDone() && this.registerProxyHandler.isTroopQueueEmpty()) {
                    notifyAllMsgThreadEnd();
                }
                Thread.yield();
            } catch (Exception e16) {
                QLog.e(BaseMessageHandler.TAG, 1, "getCheck: ", e16);
            }
            return i3;
        } finally {
            TraceUtils.traceEnd();
        }
    }

    private void handleAllMsgDone() {
        synchronized (this.registerProxyHandler.allMsgThreadEndLock) {
            if (this.registerProxyHandler.registerProxyEnd != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(BaseMessageHandler.TAG, 2, "registerproxy->MessageHandleThread End. NoticeEnd notify");
                }
                boolean z16 = false;
                Long[] lArr = {Long.valueOf(((RegisterPushNotice) this.registerProxyHandler.registerProxyEnd.first).ulTimeOutFlag), (Long) this.registerProxyHandler.registerProxyEnd.second};
                if ((((RegisterPushNotice) this.registerProxyHandler.registerProxyEnd.first).uFlag & 1) == 1) {
                    z16 = true;
                }
                this.registerProxyHandler.registerProxyEnd = null;
                e eVar = (e) this.messageHandler.getApp().getMsgCache();
                if (lArr[1].longValue() == 1 || !eVar.l1() || !eVar.m1()) {
                    this.messageHandler.flushDiscussionAndTroopMsg();
                    this.messageHandler.notifyUI(4013, z16, lArr);
                }
                this.registerProxyHandler.allMsgThreadEndLock.set(true);
                this.registerProxyHandler.allMsgThreadEndLock.notifyAll();
            }
        }
    }

    private void handleMessageObject(MessageObject messageObject) {
        long j3;
        int i3;
        long j16;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            Object obj = messageObject.data;
            if (obj != null) {
                i3 = obj.hashCode();
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d(BaseMessageHandler.TAG, 2, "registerproxy->MessageHandleThread Beg.  moType=" + messageObject.type + ", dataHash=@" + Integer.toHexString(i3));
            }
        } else {
            j3 = 0;
            i3 = 0;
        }
        AppInterface app = this.messageHandler.getApp();
        IMessageFacade iMessageFacade = (IMessageFacade) app.getRuntimeService(IMessageFacade.class, "");
        e eVar = (e) app.getMsgCache();
        int i16 = messageObject.type;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        if (i16 != 5) {
                            j16 = j3;
                        } else {
                            Object obj2 = messageObject.data;
                            if (obj2 instanceof stConfNumInfo) {
                                stConfNumInfo stconfnuminfo = (stConfNumInfo) obj2;
                                String valueOf = String.valueOf(stconfnuminfo.lConfUin);
                                j16 = j3;
                                long j17 = stconfnuminfo.uMemberMsgSeq;
                                if (eVar.t0(String.valueOf(stconfnuminfo.lConfUin)) == 2) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                iMessageFacade.setReadFrom(valueOf, 3000, j17, z19);
                            } else {
                                j16 = j3;
                                if (obj2 instanceof register_proxy$DiscussList) {
                                    register_proxy$DiscussList register_proxy_discusslist = (register_proxy$DiscussList) obj2;
                                    String valueOf2 = String.valueOf(register_proxy_discusslist.discuss_code.get());
                                    long j18 = register_proxy_discusslist.member_seq.get();
                                    if (eVar.t0(String.valueOf(register_proxy_discusslist.discuss_code.get())) == 2) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    iMessageFacade.setReadFrom(valueOf2, 3000, j18, z18);
                                }
                            }
                        }
                    } else {
                        j16 = j3;
                        Object obj3 = messageObject.data;
                        if (obj3 instanceof GroupInfo) {
                            GroupInfo groupInfo = (GroupInfo) obj3;
                            String valueOf3 = String.valueOf(groupInfo.lGroupCode);
                            long j19 = groupInfo.lMemberSeq;
                            if (eVar.d1(String.valueOf(groupInfo.lGroupCode)) == 2) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            iMessageFacade.setReadFrom(valueOf3, 1, j19, z17);
                        } else if (obj3 instanceof register_proxy$GroupList) {
                            register_proxy$GroupList register_proxy_grouplist = (register_proxy$GroupList) obj3;
                            String valueOf4 = String.valueOf(register_proxy_grouplist.group_code.get());
                            long j26 = register_proxy_grouplist.member_seq.get();
                            if (eVar.d1(String.valueOf(register_proxy_grouplist.group_code.get())) == 2) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            iMessageFacade.setReadFrom(valueOf4, 1, j26, z16);
                        }
                    }
                } else {
                    j16 = j3;
                    this.messageHandler.doMsgProxyDiscussMsgResp_PB(messageObject.req, messageObject.resp, messageObject.data);
                }
            } else {
                j16 = j3;
                this.messageHandler.doMsgProxyTroopMsgResp_PB(messageObject.req, messageObject.resp, messageObject.data);
            }
        } else {
            j16 = j3;
            this.messageHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).t(1002, messageObject.req, messageObject.resp, messageObject.data);
        }
        this.messageHandler.updateLastRegisterProxyRespTime();
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "registerproxy->MessageHandleThread End.  moType=" + messageObject.type + ", dataHash=@" + Integer.toHexString(i3) + ", cost=" + (System.currentTimeMillis() - j16));
        }
    }

    private void notifyAllMsgThreadEnd() {
        synchronized (this.registerProxyHandler.allMsgThreadEndLock) {
            if (!this.registerProxyHandler.allMsgThreadEndLock.get()) {
                this.registerProxyHandler.allMsgThreadEndLock.set(true);
                this.registerProxyHandler.allMsgThreadEndLock.notifyAll();
            }
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.isRunning = false;
        synchronized (this.respMsgQueue) {
            this.respMsgQueue.notifyAll();
        }
    }

    public boolean isClose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return !this.isRunning;
    }

    public boolean isDoing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isDoing;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "MessageHandleThread start, name=" + getName());
        }
        int i3 = 0;
        while (this.isRunning && (i3 < 2 || this.respMsgQueue.size() > 0)) {
            i3 = getCheck(i3);
        }
        close();
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "MessageHandleThread exit, name=" + getName());
        }
    }
}
