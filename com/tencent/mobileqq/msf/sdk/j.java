package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.c0.m;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;
    private String _bootBroadcastName;
    protected int appid;
    IErrorHandler errorHandler;
    protected final LinkedBlockingQueue<MsfMessagePair> highPriorityMessagePairs;
    protected String msfServiceName;
    private final Object preHandleQueueSyncLock;
    protected final LinkedBlockingQueue<MsfMessagePair> preHandlerMessagePairs;
    protected String processName;
    protected final LinkedBlockingQueue<MsfMessagePair> serviceRespMessagePairs;
    private final Object syncQueueLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.serviceRespMessagePairs = new LinkedBlockingQueue<>();
        this.highPriorityMessagePairs = new LinkedBlockingQueue<>();
        this.preHandlerMessagePairs = new LinkedBlockingQueue<>();
        this.syncQueueLock = new Object();
        this.preHandleQueueSyncLock = new Object();
    }

    public boolean addServicePushMsg(FromServiceMsg fromServiceMsg) {
        boolean add;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg)).booleanValue();
        }
        if (fromServiceMsg == null || fromServiceMsg.getServiceCmd() == null) {
            return false;
        }
        if (k.f250586d.contains(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("ThreadSplit", 2, "addServiceRespMsg, preHandlerMessagePairs added, " + fromServiceMsg.getServiceCmd());
            }
            add = this.preHandlerMessagePairs.add(new MsfMessagePair(null, fromServiceMsg));
            synchronized (this.preHandleQueueSyncLock) {
                this.preHandleQueueSyncLock.notify();
            }
        } else {
            if (k.f250585c.contains(fromServiceMsg.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThreadSplit", 2, "addServicePushMsg, high priority added, " + fromServiceMsg.getServiceCmd());
                }
                fromServiceMsg.extraData.putInt(k.f250583a, getQueueSize());
                add = this.highPriorityMessagePairs.add(new MsfMessagePair(null, fromServiceMsg));
            } else {
                add = this.serviceRespMessagePairs.add(new MsfMessagePair(null, fromServiceMsg));
            }
            synchronized (this.syncQueueLock) {
                this.syncQueueLock.notify();
            }
        }
        if (fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
            com.tencent.mobileqq.msf.core.c0.m.b().a(m.a.f247910e, fromServiceMsg.getWupBuffer(), 0);
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onRespToApp(null, fromServiceMsg);
        return add;
    }

    public boolean addServiceRespMsg(MsfMessagePair msfMessagePair) {
        boolean add;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfMessagePair)).booleanValue();
        }
        FromServiceMsg fromServiceMsg = msfMessagePair.fromServiceMsg;
        if (fromServiceMsg != null && fromServiceMsg.getServiceCmd() != null && k.f250586d.contains(msfMessagePair.fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("ThreadSplit", 2, "addServiceRespMsg, preHandlerMessagePairs added, " + msfMessagePair.fromServiceMsg.getServiceCmd());
            }
            add = this.preHandlerMessagePairs.add(msfMessagePair);
            synchronized (this.preHandleQueueSyncLock) {
                this.preHandleQueueSyncLock.notify();
            }
        } else {
            FromServiceMsg fromServiceMsg2 = msfMessagePair.fromServiceMsg;
            if (fromServiceMsg2 != null && fromServiceMsg2.getServiceCmd() != null && k.f250585c.contains(msfMessagePair.fromServiceMsg.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThreadSplit", 2, "addServiceRespMsg, high priority added, " + msfMessagePair.fromServiceMsg.getServiceCmd());
                }
                msfMessagePair.fromServiceMsg.extraData.putInt(k.f250583a, getQueueSize());
                msfMessagePair.fromServiceMsg.extraData.putLong(k.f250584b, System.currentTimeMillis());
                add = this.highPriorityMessagePairs.add(msfMessagePair);
            } else {
                add = this.serviceRespMessagePairs.add(msfMessagePair);
            }
            synchronized (this.syncQueueLock) {
                this.syncQueueLock.notify();
            }
        }
        ToServiceMsg toServiceMsg = msfMessagePair.toServiceMsg;
        if (toServiceMsg != null && BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC.equals(toServiceMsg.getServiceCmd())) {
            MsfServiceSdk.get().getMSFMsgPushHandlerUtil().handleRegisterProxyRsp();
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onRespToApp(msfMessagePair.toServiceMsg, msfMessagePair.fromServiceMsg);
        return add;
    }

    public String getBootBroadcastName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this._bootBroadcastName;
    }

    public IErrorHandler getErrorHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IErrorHandler) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.errorHandler;
    }

    public int getPreHandleQueueSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.preHandlerMessagePairs.size();
    }

    public MsfMessagePair getPreHandleServiceRespMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsfMessagePair) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.preHandlerMessagePairs.poll();
    }

    public int getQueueSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.serviceRespMessagePairs.size() + this.highPriorityMessagePairs.size();
    }

    public LinkedBlockingQueue<MsfMessagePair> getRespMsgQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LinkedBlockingQueue) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.highPriorityMessagePairs.size() > 0) {
            return this.highPriorityMessagePairs;
        }
        return this.serviceRespMessagePairs;
    }

    public MsfMessagePair getServiceRespMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MsfMessagePair) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.highPriorityMessagePairs.size() > 0) {
            return this.highPriorityMessagePairs.poll();
        }
        return this.serviceRespMessagePairs.poll();
    }

    public void initSub(String str, int i3, String str2, String str3, IErrorHandler iErrorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, str3, iErrorHandler);
            return;
        }
        this.appid = i3;
        this.msfServiceName = str2;
        setBootBroadcastName(str3);
        this.processName = str;
        this.errorHandler = iErrorHandler;
    }

    public void preHandleQueueWait() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        synchronized (this.preHandleQueueSyncLock) {
            try {
                if (this.preHandlerMessagePairs.size() == 0) {
                    LockMethodProxy.wait(this.preHandleQueueSyncLock);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public void queueWait() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (this.syncQueueLock) {
            try {
                if (this.serviceRespMessagePairs.size() == 0 && this.highPriorityMessagePairs.size() == 0) {
                    LockMethodProxy.wait(this.syncQueueLock);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public void setBootBroadcastName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this._bootBroadcastName = str;
        }
    }
}
