package com.tencent.av.business.handler;

import android.util.Log;
import com.tencent.av.common$ErrorInfo;
import com.tencent.av.utils.at;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MessageHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    static volatile long f73265d = 1;

    /* renamed from: e, reason: collision with root package name */
    static volatile HashMap<Long, b> f73266e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    static Object f73267f = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f73268a;

        /* renamed from: b, reason: collision with root package name */
        Class<?> f73269b;

        /* renamed from: c, reason: collision with root package name */
        Class<?> f73270c;

        a() {
        }

        void a(String str, long j3) {
            if (this.f73270c == null || this.f73269b == null) {
                Log.d(str, "check ClassInfo, seq[" + j3 + "], " + this.f73268a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class b<T1 extends MessageMicro, T2 extends MessageMicro> {
        public abstract void a(long j3, boolean z16, T1 t16, T2 t26, Object obj);

        /* JADX WARN: Multi-variable type inference failed */
        protected final void b(long j3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
            a E2 = MessageHandler.E2(this);
            E2.a("QAVMessageHandler", j3);
            Class<?> cls = E2.f73269b;
            if (cls != null && E2.f73270c != null) {
                try {
                    MessageMicro messageMicro = (MessageMicro) cls.newInstance();
                    MessageMicro messageMicro2 = (MessageMicro) E2.f73270c.newInstance();
                    byte[] wupBuffer = toServiceMsg.getWupBuffer();
                    if (wupBuffer != null && wupBuffer.length > 4) {
                        messageMicro.mergeFrom(wupBuffer, 4, wupBuffer.length - 4);
                    }
                    messageMicro2.mergeFrom(fromServiceMsg.getWupBuffer());
                    a(j3, fromServiceMsg.isSuccess(), messageMicro, messageMicro2, obj);
                } catch (Exception e16) {
                    QLog.w("QAVMessageHandler", 1, "onSendMsgRsp, Exception, seq[" + j3 + "]", e16);
                }
            }
        }
    }

    public MessageHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a E2(b bVar) {
        String str;
        Class<?> cls;
        Type genericSuperclass = bVar.getClass().getGenericSuperclass();
        Class<?> cls2 = null;
        if (genericSuperclass != null) {
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                if (actualTypeArguments != null) {
                    if (actualTypeArguments.length == 2) {
                        cls2 = (Class) actualTypeArguments[0];
                        cls = (Class) actualTypeArguments[1];
                        str = "reqType[" + cls2 + "]rspType[" + cls + "]";
                        if ((cls2 == null && cls != null) || !e.j()) {
                            a aVar = new a();
                            aVar.f73268a = str;
                            aVar.f73269b = cls2;
                            aVar.f73270c = cls;
                            return aVar;
                        }
                        throw new IllegalArgumentException("QAVMessageHandler get getClassInfo\u5931\u8d25, " + str);
                    }
                    str = "ActualTypeArguments\u957f\u5ea6\u4e3a" + actualTypeArguments.length;
                } else {
                    str = "getActualTypeArguments\u4e3a\u7a7a";
                }
            } else {
                str = "type[" + genericSuperclass.getClass().getName() + "]";
            }
        } else {
            str = "genericInterfaces\u4e3a\u7a7a";
        }
        cls = null;
        if (cls2 == null) {
        }
        throw new IllegalArgumentException("QAVMessageHandler get getClassInfo\u5931\u8d25, " + str);
    }

    public static int F2(common$ErrorInfo common_errorinfo) {
        if (common_errorinfo.has() && common_errorinfo.uint32_errcode.has()) {
            return common_errorinfo.uint32_errcode.get();
        }
        return -99;
    }

    public static String G2(common$ErrorInfo common_errorinfo) {
        if (common_errorinfo.has() && common_errorinfo.bytes_errmsg.has()) {
            return common_errorinfo.bytes_errmsg.get().toStringUtf8();
        }
        return "";
    }

    static b H2(long j3) {
        b bVar;
        synchronized (f73267f) {
            bVar = f73266e.get(Long.valueOf(j3));
            f73266e.remove(Long.valueOf(j3));
        }
        return bVar;
    }

    public static void I2(long j3, AppInterface appInterface, String str, MessageMicro messageMicro, b bVar) {
        MessageHandler messageHandler = (MessageHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.QAV_HANDLER);
        ToServiceMsg toServiceMsg = new ToServiceMsg("", appInterface.getCurrentAccountUin(), str);
        at.h(toServiceMsg.getAttributes(), j3);
        long genMsgSeq = genMsgSeq();
        toServiceMsg.getAttributes().put("msgSeq_for_callback", Long.valueOf(genMsgSeq));
        J2(genMsgSeq, bVar);
        toServiceMsg.putWupBuffer(messageMicro.toByteArray());
        messageHandler.sendPbReq(toServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.w("QAVMessageHandler", 1, "sendMsg, msgListener[" + bVar + "], msgSeq_for_callback[" + genMsgSeq + "], seq[" + j3 + "]");
        }
    }

    static void J2(long j3, b bVar) {
        synchronized (f73267f) {
            f73266e.put(Long.valueOf(j3), bVar);
        }
    }

    static synchronized long genMsgSeq() {
        long j3;
        synchronized (MessageHandler.class) {
            f73265d++;
            j3 = f73265d;
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return bs.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        long d16 = at.d(toServiceMsg.getAttributes());
        Object attribute = toServiceMsg.getAttribute("msgSeq_for_callback");
        if (attribute instanceof Integer) {
            j3 = ((Integer) attribute).intValue();
        } else if (attribute instanceof Long) {
            j3 = ((Long) attribute).longValue();
        } else {
            j3 = 0;
        }
        b H2 = H2(j3);
        if (QLog.isColorLevel()) {
            QLog.w("QAVMessageHandler", 1, "onReceive, cmd[" + serviceCmd + "], req_cmd[" + toServiceMsg.getServiceCmd() + "], isSuccess[" + fromServiceMsg.isSuccess() + "], RequestSsoSeq[" + toServiceMsg.getRequestSsoSeq() + "], ResultCode[" + fromServiceMsg.getResultCode() + "], RequestSsoSeq[" + fromServiceMsg.getRequestSsoSeq() + "], msgSeq_for_callback[" + j3 + "], msgListener[" + H2 + "], seq[" + d16 + "]");
        }
        if (H2 != null) {
            H2.b(d16, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        QLog.w("QAVMessageHandler", 1, "onReceive, \u6ca1\u6709MsgListener\uff0c cmd[" + serviceCmd + "], seq[" + d16 + "]");
    }
}
