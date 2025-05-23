package com.tencent.mobileqq.service.discussion;

import QQService.DiscussRespHeader;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import QQService.RespSetDiscussAttr;
import QQService.RespSetDiscussFlag;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.service.discussion.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8574a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f286097a;

        /* renamed from: b, reason: collision with root package name */
        public Object f286098b;

        /* renamed from: c, reason: collision with root package name */
        public Object f286099c;

        public C8574a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object a(boolean z16, Object obj, Object obj2) {
        C8574a c8574a = new C8574a();
        c8574a.f286097a = z16;
        c8574a.f286098b = obj;
        c8574a.f286099c = obj2;
        return c8574a;
    }

    private <T> T c(byte[] bArr, String str, T t16) {
        if (bArr == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }

    private Object d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespAddDiscussMember) c(fromServiceMsg.getWupBuffer(), "RespAddDiscussMember", new RespAddDiscussMember());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---addDisMember or respheader is null!");
        return null;
    }

    private Object e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespChangeDiscussName) c(fromServiceMsg.getWupBuffer(), "RespChangeDiscussName", new RespChangeDiscussName());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        return null;
    }

    private Object f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespCreateDiscuss) c(fromServiceMsg.getWupBuffer(), "RespCreateDiscuss", new RespCreateDiscuss());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionReceiver", 2, "<<---createDiscussResp or respheader is null!");
            return null;
        }
        return null;
    }

    private Object g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespGetDiscussInfo) c(fromServiceMsg.getWupBuffer(), "RespGetDiscussInfo", new RespGetDiscussInfo());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
        return null;
    }

    private Object h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespGetDiscussInteRemark) c(fromServiceMsg.getWupBuffer(), "RespGetDiscussInteRemark", new RespGetDiscussInteRemark());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---discussInfo or respHeader is null!");
        return null;
    }

    private Object i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespJoinDiscuss) c(fromServiceMsg.getWupBuffer(), "RespJoinDiscuss", new RespJoinDiscuss());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---decodeRespJoinDiscuss or respheader is null!");
        return null;
    }

    private Object j(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespQuitDiscuss) c(fromServiceMsg.getWupBuffer(), "RespQuitDiscuss", new RespQuitDiscuss());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---discussQuitResp or respheader is null");
        return null;
    }

    private Object k(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespSetDiscussAttr) c(fromServiceMsg.getWupBuffer(), "RespSetDiscussAttr", new RespSetDiscussAttr());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---discussAttr or respheader is null!");
        return null;
    }

    private Object l(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Object obj = (RespSetDiscussFlag) c(fromServiceMsg.getWupBuffer(), "RespSetDiscussFlag", new RespSetDiscussFlag());
        DiscussRespHeader discussRespHeader = (DiscussRespHeader) c(fromServiceMsg.getWupBuffer(), "DiscussRespHeader", new DiscussRespHeader());
        if (obj != null && discussRespHeader != null) {
            if (fromServiceMsg.getResultCode() == 1000 && discussRespHeader.Result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return a(z16, discussRespHeader, obj);
        }
        QLog.w("DiscussionReceiver", 2, "<<---discussFlagResp or respheader is null");
        return null;
    }

    public Object b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionReceiver", 2, "~~~decode cmd: " + serviceCmd);
        }
        if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(serviceCmd)) {
            return d(toServiceMsg, fromServiceMsg);
        }
        if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(serviceCmd)) {
            return e(toServiceMsg, fromServiceMsg);
        }
        if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(serviceCmd)) {
            return f(toServiceMsg, fromServiceMsg);
        }
        if (!"OidbSvc.0x58a".equalsIgnoreCase(serviceCmd)) {
            if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(serviceCmd)) {
                return g(toServiceMsg, fromServiceMsg);
            }
            if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(serviceCmd)) {
                return j(toServiceMsg, fromServiceMsg);
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(serviceCmd)) {
                return k(toServiceMsg, fromServiceMsg);
            }
            if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(serviceCmd)) {
                return l(toServiceMsg, fromServiceMsg);
            }
            if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(serviceCmd)) {
                return h(toServiceMsg, fromServiceMsg);
            }
            if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(serviceCmd)) {
                return i(toServiceMsg, fromServiceMsg);
            }
            QLog.w("DiscussionReceiver", 2, "~~~unknow cmd: " + serviceCmd);
            return null;
        }
        return null;
    }
}
