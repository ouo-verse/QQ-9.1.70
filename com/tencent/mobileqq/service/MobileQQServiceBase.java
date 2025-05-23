package com.tencent.mobileqq.service;

import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class MobileQQServiceBase {
    static IPatchRedirector $redirector_ = null;
    public static final String REQ_PB_PROTOCOL_FLAG = "req_pb_protocol_flag";
    public static final String SERVICE_ID = "mobileqq.service";
    public static final String TAG = "MobileQQServiceBase";
    private static final String TIME_KEY = "sendtimekey";
    public static volatile int seq;
    protected ConcurrentHashMap<String, BaseProtocolCoder> coderMap;
    private volatile boolean isDoCoderInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_SET_CARE_BAR_ENABLE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            seq = 0;
        }
    }

    public MobileQQServiceBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isDoCoderInit = false;
            this.coderMap = new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleRequest$0(ToServiceMsg toServiceMsg) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        MqqInjectorManager.instance().handleSendTimeForSendMsgPb(toServiceMsg, serviceCmd);
        try {
            realHandleRequest(toServiceMsg, getServlet());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "handleRequest Exception. cmd = " + serviceCmd, e16);
            }
            FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), serviceCmd);
            fromServiceMsg.setMsgFail();
            handleResponse(false, toServiceMsg, fromServiceMsg, e16);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleRequest OutOfMemoryError. cmd = " + serviceCmd);
            }
            FromServiceMsg fromServiceMsg2 = new FromServiceMsg(toServiceMsg.getUin(), serviceCmd);
            fromServiceMsg2.setMsgFail();
            handleResponse(false, toServiceMsg, fromServiceMsg2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addCoder(BaseProtocolCoder baseProtocolCoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseProtocolCoder)).booleanValue();
        }
        String[] cmdHeaderPrefix = baseProtocolCoder.cmdHeaderPrefix();
        if (cmdHeaderPrefix == null || cmdHeaderPrefix.length == 0) {
            return false;
        }
        for (String str : cmdHeaderPrefix) {
            this.coderMap.put(str, baseProtocolCoder);
        }
        return true;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            destroyCoder();
        }
    }

    protected void destroyCoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ConcurrentHashMap<String, BaseProtocolCoder> concurrentHashMap = this.coderMap;
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                BaseProtocolCoder baseProtocolCoder = this.coderMap.get(it.next());
                if (baseProtocolCoder != null) {
                    try {
                        baseProtocolCoder.destroy();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "bpc destroy error " + e16, e16);
                        }
                    }
                }
            }
            this.coderMap.clear();
        }
        this.isDoCoderInit = false;
    }

    public void dispatchToHandler(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        AppInterface appInterface = getAppInterface();
        Set<String> b16 = a.b(getAppInterface(), fromServiceMsg.getServiceCmd());
        if (b16 != null && !b16.isEmpty()) {
            Iterator<String> it = b16.iterator();
            while (it.hasNext()) {
                BusinessHandler businessHandler = appInterface.getBusinessHandler(it.next());
                if (businessHandler != null) {
                    try {
                        businessHandler.onReceive(toServiceMsg, fromServiceMsg, obj);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, businessHandler.getClass().getSimpleName() + " onReceive error", e16);
                        }
                    }
                }
            }
        }
    }

    public abstract AppInterface getAppInterface();

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String[]> getCompatibleCmd2HandlerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    protected abstract Class<? extends MSFServlet> getServlet();

    /* JADX INFO: Access modifiers changed from: protected */
    public UniPacket getUniPacketClient(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UniPacket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
        }
        return new UniPacket(true);
    }

    public void handleNoProtocolCoder(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) toServiceMsg);
        }
    }

    public void handleRequest(final ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null) {
            QLog.d(TAG, 1, "handleRequest, request null");
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.service.c
            @Override // java.lang.Runnable
            public final void run() {
                MobileQQServiceBase.this.lambda$handleRequest$0(toServiceMsg);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    public void handleResponse(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        int i3;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), toServiceMsg, fromServiceMsg, exc);
            return;
        }
        if (toServiceMsg == null) {
            return;
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
        boolean isPBPushCmd = isPBPushCmd(fromServiceMsg.getServiceCmd());
        if (!booleanValue && !isPBPushCmd) {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[RES] cmd:" + fromServiceMsg.getServiceCmd() + ", success:" + z16 + ", bPbResp:" + z17 + ", app seq:" + fromServiceMsg.getAppSeq() + ", result:" + fromServiceMsg.getResultCode() + ", duration: " + (System.currentTimeMillis() - toServiceMsg.extraData.getLong(TIME_KEY)) + "ms", exc);
        }
        Object obj = null;
        if (z17) {
            if (z16 && fromServiceMsg.getWupBuffer() != null && (length = fromServiceMsg.getWupBuffer().length - (i3 = fromServiceMsg.extraData.getInt("pb_msg_offset", 4))) > 0) {
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), i3, length);
                fromServiceMsg.putWupBuffer(bArr);
                obj = fromServiceMsg.getWupBuffer();
            }
            dispatchToHandler(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        BaseProtocolCoder lookupCoder = lookupCoder(fromServiceMsg.getServiceCmd());
        if (lookupCoder == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "bpc null");
                return;
            }
            return;
        }
        if (z16) {
            try {
                lookupCoder.decodeRespMsg(toServiceMsg, fromServiceMsg);
                obj = lookupCoder.decode(toServiceMsg, fromServiceMsg);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16, new Object[0]);
                }
            }
        }
        dispatchToHandler(toServiceMsg, fromServiceMsg, obj);
    }

    protected synchronized void initCoders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public boolean isPBPushCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    public BaseProtocolCoder lookupCoder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BaseProtocolCoder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (!this.isDoCoderInit) {
            synchronized (this) {
                if (!this.isDoCoderInit) {
                    initCoders();
                }
            }
        }
        int indexOf = str.indexOf(46);
        if (indexOf <= 1) {
            return null;
        }
        return this.coderMap.get(str.substring(0, indexOf));
    }

    public void realHandleRequest(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        BaseProtocolCoder lookupCoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg, (Object) cls);
            return;
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
        AppInterface appInterface = getAppInterface();
        boolean z16 = false;
        boolean z17 = true;
        if (booleanValue) {
            if (toServiceMsg.getWupBuffer() != null) {
                long length = toServiceMsg.getWupBuffer().length;
                int i3 = (int) length;
                byte[] bArr = new byte[i3 + 4];
                PkgTools.DWord2Byte(bArr, 0, length + 4);
                PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
                toServiceMsg.putWupBuffer(bArr);
                lookupCoder = null;
                z17 = false;
                z16 = true;
            } else {
                lookupCoder = null;
                z17 = false;
            }
        } else {
            lookupCoder = lookupCoder(toServiceMsg.getServiceCmd());
            if (lookupCoder != null) {
                UniPacket uniPacketClient = getUniPacketClient(toServiceMsg);
                uniPacketClient.setEncodeName("utf-8");
                int i16 = seq;
                seq = i16 + 1;
                uniPacketClient.setRequestId(i16);
                if (lookupCoder.enableBinaryProtocol()) {
                    byte[] encodeReqMsg = lookupCoder.encodeReqMsg(toServiceMsg);
                    if (encodeReqMsg != null) {
                        toServiceMsg.putWupBuffer(encodeReqMsg);
                        z16 = true;
                    }
                } else if (lookupCoder.encodeReqMsg(toServiceMsg, uniPacketClient)) {
                    toServiceMsg.putWupBuffer(uniPacketClient.encode());
                    z17 = false;
                    z16 = true;
                }
            } else {
                handleNoProtocolCoder(toServiceMsg);
            }
            z17 = false;
        }
        if (z16) {
            toServiceMsg.extraData.putLong(TIME_KEY, System.currentTimeMillis());
            NewIntent newIntent = new NewIntent(appInterface.getApplication(), cls);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            appInterface.startServlet(newIntent);
            return;
        }
        if (booleanValue || (lookupCoder != null && !z17)) {
            dispatchToHandler(toServiceMsg, new FromServiceMsg(appInterface.getAccount(), toServiceMsg.getServiceCmd()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void setCodersInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.isDoCoderInit = true;
        }
    }
}
