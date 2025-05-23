package com.tencent.mobileqq.msf.sdk;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.IMsgPushMonitorHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes15.dex */
public class MSFMsgPushHandlerUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String MSF_MSG_PUSH_MONITOR_DISPATCH_THREAD = "msf_msg_push_monitor_dispatch_thread";
    private static final String TAG = "MSFMsgPushHandlerUtil";
    private final Handler dispatcherHandler;
    private final CopyOnWriteArrayList<IMsgPushMonitorHandler> msgHandlerList;

    public MSFMsgPushHandlerUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msgHandlerList = new CopyOnWriteArrayList<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(MSF_MSG_PUSH_MONITOR_DISPATCH_THREAD);
        baseHandlerThread.start();
        this.dispatcherHandler = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMSFConnectSuccess$3(FromServiceMsg fromServiceMsg) {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onMSFConnectSuccess(fromServiceMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMSFServiceInit$0() {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onMSFServiceInit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMSFStartConnect$2(FromServiceMsg fromServiceMsg) {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onMSFStartConnect(fromServiceMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleRegisterMSFService$1() {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onRegisterMSFService();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleRegisterProxyRsp$5() {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onRegisterProxyRsp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSendRegisterProxyReq$4() {
        Iterator<IMsgPushMonitorHandler> it = this.msgHandlerList.iterator();
        while (it.hasNext()) {
            IMsgPushMonitorHandler next = it.next();
            if (next != null) {
                next.onSendRegisterProxyReq();
            }
        }
    }

    public void handleMSFConnectSuccess(final FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fromServiceMsg);
            return;
        }
        QLog.d(TAG, 1, "handleMSFConnectSuccess, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.u
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleMSFConnectSuccess$3(fromServiceMsg);
            }
        });
    }

    public void handleMSFServiceInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "handleMSFServiceInit, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.s
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleMSFServiceInit$0();
            }
        });
    }

    public void handleMSFStartConnect(final FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg);
            return;
        }
        QLog.d(TAG, 1, "handleMSFStartConnect, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.v
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleMSFStartConnect$2(fromServiceMsg);
            }
        });
    }

    public void handleRegisterMSFService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "handleRegisterMSFService, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.r
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleRegisterMSFService$1();
            }
        });
    }

    public void handleRegisterProxyRsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "handleRegisterProxyRsp, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.q
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleRegisterProxyRsp$5();
            }
        });
    }

    public void handleSendRegisterProxyReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "handleSendRegisterProxyReq, msgHandlerList.size() = " + this.msgHandlerList.size());
        this.dispatcherHandler.post(new Runnable() { // from class: com.tencent.mobileqq.msf.sdk.t
            @Override // java.lang.Runnable
            public final void run() {
                MSFMsgPushHandlerUtil.this.lambda$handleSendRegisterProxyReq$4();
            }
        });
    }

    public void registerMsgPushMonitorHandler(IMsgPushMonitorHandler iMsgPushMonitorHandler) {
        String hexString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iMsgPushMonitorHandler);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerMsgPushMonitorHandler:");
        if (iMsgPushMonitorHandler == null) {
            hexString = "null";
        } else {
            hexString = Integer.toHexString(iMsgPushMonitorHandler.hashCode());
        }
        sb5.append(hexString);
        QLog.d(TAG, 1, sb5.toString());
        if (iMsgPushMonitorHandler == null) {
            return;
        }
        this.msgHandlerList.addIfAbsent(iMsgPushMonitorHandler);
    }
}
