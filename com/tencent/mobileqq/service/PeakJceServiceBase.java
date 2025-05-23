package com.tencent.mobileqq.service;

import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

/* loaded from: classes18.dex */
public abstract class PeakJceServiceBase {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static volatile int f286070d;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, UniPacket> f286071e;

    /* renamed from: a, reason: collision with root package name */
    private DecimalFormat f286072a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, BaseProtocolCoder> f286073b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f286074c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f286070d = 0;
            f286071e = new HashMap<>();
        }
    }

    public PeakJceServiceBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286072a = new DecimalFormat("0.00");
            this.f286074c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(BaseProtocolCoder baseProtocolCoder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseProtocolCoder)).booleanValue();
        }
        String[] cmdHeaderPrefix = baseProtocolCoder.cmdHeaderPrefix();
        if (cmdHeaderPrefix == null || cmdHeaderPrefix.length == 0) {
            return false;
        }
        for (String str : cmdHeaderPrefix) {
            this.f286073b.put(str, baseProtocolCoder);
        }
        return true;
    }

    public abstract AppInterface b();

    public UniPacket c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (UniPacket) iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
        }
        if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            String string = toServiceMsg.extraData.getString("filepath");
            UniPacket uniPacket = f286071e.get(string);
            if (uniPacket == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PeakJceServiceBase", 2, "no saved packet, new one " + string);
                }
                uniPacket = new PttUniPacket(true);
                f286071e.clear();
                f286071e.put(string, uniPacket);
            } else if (QLog.isColorLevel()) {
                QLog.d("PeakJceServiceBase", 2, "got last packet, reuse it " + string);
            }
            Short valueOf = Short.valueOf(toServiceMsg.extraData.getShort("PackSeq"));
            short o16 = com.tencent.mobileqq.streamtransfile.b.o(string);
            if (valueOf.shortValue() <= o16) {
                f286071e.remove(string);
                if (QLog.isColorLevel()) {
                    QLog.d("PeakJceServiceBase", 2, "last stream, remove " + ((int) o16) + ", " + valueOf);
                }
            }
            return uniPacket;
        }
        return new UniPacket(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) cls);
            return;
        }
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PeakJceServiceBase", 2, "handleRequest request is null. ");
            }
        } else {
            Runnable runnable = new Runnable(toServiceMsg, cls) { // from class: com.tencent.mobileqq.service.PeakJceServiceBase.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ToServiceMsg f286075d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Class f286076e;

                {
                    this.f286075d = toServiceMsg;
                    this.f286076e = cls;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PeakJceServiceBase.this, toServiceMsg, cls);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String serviceCmd = this.f286075d.getServiceCmd();
                    if (QLog.isColorLevel()) {
                        QLog.d("PeakJceServiceBase", 2, "req cmd: " + serviceCmd);
                    }
                    if (BaseConstants.CMD_MSG_PBSENDMSG.equalsIgnoreCase(serviceCmd)) {
                        long j3 = this.f286075d.extraData.getLong("msg_send_time", 0L);
                        if (j3 != 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.f286075d.extraData.putLong("msg_request_time", currentTimeMillis);
                            this.f286075d.extraData.putLong("msg_send_to_request_cost", currentTimeMillis - j3);
                        }
                    }
                    try {
                        PeakJceServiceBase.this.i(this.f286075d, this.f286076e);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("PeakJceServiceBase", 2, "handleRequest Exception. cmd = " + serviceCmd, e16);
                        }
                        FromServiceMsg fromServiceMsg = new FromServiceMsg(this.f286075d.getUin(), serviceCmd);
                        fromServiceMsg.setMsgFail();
                        PeakJceServiceBase.this.e(false, this.f286075d, fromServiceMsg, e16);
                    } catch (OutOfMemoryError unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PeakJceServiceBase", 2, "handleRequest OutOfMemoryError. cmd = " + serviceCmd);
                        }
                        FromServiceMsg fromServiceMsg2 = new FromServiceMsg(this.f286075d.getUin(), serviceCmd);
                        fromServiceMsg2.setMsgFail();
                        PeakJceServiceBase.this.e(false, this.f286075d, fromServiceMsg2, null);
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ThreadManagerV2.post(runnable, 10, null, false);
            } else {
                runnable.run();
            }
        }
    }

    public void e(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        String[] strArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), toServiceMsg, fromServiceMsg, exc);
            return;
        }
        if (toServiceMsg == null) {
            return;
        }
        AppInterface b16 = b();
        float currentTimeMillis = ((float) (System.currentTimeMillis() - toServiceMsg.extraData.getLong("sendtimekey"))) / 1000.0f;
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PeakJceServiceBase", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + " app seq:" + fromServiceMsg.getAppSeq() + " during " + this.f286072a.format(currentTimeMillis) + "sec.");
            }
        } else if (exc != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            exc.printStackTrace(new PrintStream(byteArrayOutputStream));
            String str = new String(byteArrayOutputStream.toByteArray());
            if (QLog.isColorLevel()) {
                QLog.d("PeakJceServiceBase", 2, "[NOT SEND]cmd=" + fromServiceMsg.getServiceCmd() + ", " + str);
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("PeakJceServiceBase", 2, "[RES]cmd=" + fromServiceMsg.getServiceCmd() + ",CODE=" + fromServiceMsg.getResultCode() + " during " + this.f286072a.format(currentTimeMillis) + "sec.");
        }
        BaseProtocolCoder h16 = h(fromServiceMsg.getServiceCmd());
        Object obj = null;
        if (z16) {
            try {
                if (h16 != null) {
                    h16.decodeRespMsg(toServiceMsg, fromServiceMsg);
                    obj = h16.decode(toServiceMsg, fromServiceMsg);
                } else if (QLog.isColorLevel()) {
                    QLog.d("PeakJceServiceBase", 2, "bpc null");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("PeakJceServiceBase", 2, "", e16);
                }
            }
        }
        f(fromServiceMsg);
        if (h16 != null && (strArr = com.tencent.mobileqq.app.f.b().get(fromServiceMsg.getServiceCmd())) != null && strArr.length > 0) {
            for (String str2 : strArr) {
                BusinessHandler businessHandler = b16.getBusinessHandler(str2);
                if (businessHandler != null) {
                    try {
                        businessHandler.onReceive(toServiceMsg, fromServiceMsg, obj);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.w("PeakJceServiceBase", 2, businessHandler.getClass().getSimpleName() + " onReceive error,", e17);
                        }
                    }
                }
            }
        }
    }

    protected void f(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.f286073b == null) {
                this.f286073b = new ConcurrentHashMap<>();
            }
        }
    }

    public BaseProtocolCoder h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BaseProtocolCoder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (!this.f286074c) {
            synchronized (this) {
                if (!this.f286074c) {
                    g();
                }
            }
        }
        int indexOf = str.indexOf(46);
        if (indexOf <= 1) {
            return null;
        }
        return this.f286073b.get(str.substring(0, indexOf));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void i(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) cls);
            return;
        }
        AppInterface b16 = b();
        String serviceCmd = toServiceMsg.getServiceCmd();
        BaseProtocolCoder h16 = h(serviceCmd);
        if (h16 != null) {
            UniPacket c16 = c(toServiceMsg);
            c16.setEncodeName("utf-8");
            int i3 = f286070d;
            f286070d = i3 + 1;
            c16.setRequestId(i3);
            z16 = true;
            if (h16.enableBinaryProtocol()) {
                byte[] encodeReqMsg = h16.encodeReqMsg(toServiceMsg);
                if (encodeReqMsg != null) {
                    toServiceMsg.putWupBuffer(encodeReqMsg);
                }
            } else if (h16.encodeReqMsg(toServiceMsg, c16)) {
                toServiceMsg.putWupBuffer(c16.encode());
            }
            if (!z16) {
                NewIntent newIntent = new NewIntent(b16.getApplication(), cls);
                newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                b16.startServlet(newIntent);
                toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
                return;
            }
            if (h16 != null) {
                FromServiceMsg fromServiceMsg = new FromServiceMsg(b16.getCurrentAccountUin(), serviceCmd);
                String[] strArr = com.tencent.mobileqq.app.f.b().get(serviceCmd);
                if (strArr != null && strArr.length > 0) {
                    for (String str : strArr) {
                        BusinessHandler businessHandler = b16.getBusinessHandler(str);
                        if (businessHandler != null) {
                            try {
                                businessHandler.onReceive(toServiceMsg, fromServiceMsg, null);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.w("PeakJceServiceBase", 2, businessHandler.getClass().getSimpleName() + " onReceive error,", e16);
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f286074c = true;
        }
    }
}
