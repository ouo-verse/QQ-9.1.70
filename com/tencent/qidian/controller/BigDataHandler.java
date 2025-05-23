package com.tencent.qidian.controller;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_head$Head;
import tencent.im.msg.im_msg_head$HttpConnHead;
import tencent.im.msg.im_msg_head$LoginSig;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BigDataHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    public com.tencent.qidian.controller.a C;

    /* renamed from: d, reason: collision with root package name */
    private Object f342820d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f342821e;

    /* renamed from: f, reason: collision with root package name */
    private List<c> f342822f;

    /* renamed from: h, reason: collision with root package name */
    private BigDataGetIpHandler f342823h;

    /* renamed from: i, reason: collision with root package name */
    private IHttpEngineService f342824i;

    /* renamed from: m, reason: collision with root package name */
    public QQAppInterface f342825m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BigDataHandler.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qidian.controller.a
        public void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            super.e(z16);
            if (z16) {
                BigDataHandler.this.K2();
            } else {
                BigDataHandler.this.J2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b implements INetEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f342827d;

        /* renamed from: e, reason: collision with root package name */
        private int f342828e;

        /* renamed from: f, reason: collision with root package name */
        private Object f342829f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<BigDataHandler> f342830h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f342831i;

        public b(int i3, BigDataHandler bigDataHandler, byte[] bArr, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bigDataHandler, bArr, Integer.valueOf(i16), obj);
                return;
            }
            this.f342830h = null;
            this.f342831i = null;
            this.f342827d = i3;
            this.f342828e = i16;
            this.f342829f = obj;
            this.f342830h = new WeakReference<>(bigDataHandler);
            this.f342831i = bArr;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
            }
            BigDataHandler bigDataHandler = this.f342830h.get();
            if (bigDataHandler == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
                    return;
                }
                return;
            }
            int i3 = 0;
            if (netResp != null && netResp.mResult == 0) {
                try {
                    byte[] bArr = netResp.mRespData;
                    int length = bArr.length;
                    if (bArr[0] == 40 && bArr[length - 1] == 41) {
                        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                        dataInputStream.readByte();
                        int readInt = dataInputStream.readInt();
                        int readInt2 = dataInputStream.readInt();
                        if (readInt <= length && readInt2 <= length) {
                            if (QLog.isColorLevel()) {
                                QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + readInt + " | bodyLen=" + readInt2);
                            }
                            if (readInt > 0) {
                                byte[] bArr2 = new byte[readInt];
                                dataInputStream.read(bArr2);
                                im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
                                im_msg_head_head.mergeFrom(bArr2);
                                i3 = im_msg_head_head.msg_httpconn_head.get().uint32_error_code.get();
                            }
                            if (readInt2 > 0 && i3 == 0) {
                                byte[] bArr3 = new byte[readInt2];
                                dataInputStream.read(bArr3);
                                bigDataHandler.H2(this.f342827d, true, new Cryptor().decrypt(bArr3, this.f342831i), this.f342828e, this.f342829f);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i3);
                            }
                            bigDataHandler.H2(this.f342827d, false, null, this.f342828e, this.f342829f);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + readInt + ", bodyLen=" + readInt2);
                        }
                        bigDataHandler.H2(this.f342827d, false, null, this.f342828e, this.f342829f);
                        return;
                    }
                    String obj = bArr.toString();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("unexpected body data, len=" + length + ", data=");
                    if (obj.length() > 20) {
                        obj = obj.substring(0, 20);
                    }
                    sb5.append(obj);
                    String sb6 = sb5.toString();
                    if (QLog.isColorLevel()) {
                        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + netResp + " | mResult=" + sb6);
                    }
                    bigDataHandler.H2(this.f342827d, false, null, this.f342828e, this.f342829f);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + e16.getMessage());
                    }
                    bigDataHandler.H2(this.f342827d, false, null, this.f342828e, this.f342829f);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("BigDataDownloadListener$onResp | resp = ");
                sb7.append(netResp);
                sb7.append(" | mResult=");
                if (netResp != null) {
                    i3 = netResp.mResult;
                }
                sb7.append(i3);
                QLog.d("BigDataHandler", 2, sb7.toString());
            }
            bigDataHandler.H2(this.f342827d, false, null, this.f342828e, this.f342829f);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        MessageMicro<?> f342832a;

        /* renamed from: b, reason: collision with root package name */
        int f342833b;

        /* renamed from: c, reason: collision with root package name */
        int f342834c;

        /* renamed from: d, reason: collision with root package name */
        Object f342835d;

        public c(int i3, MessageMicro<?> messageMicro, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), messageMicro, Integer.valueOf(i16), obj);
                return;
            }
            this.f342833b = i3;
            this.f342832a = messageMicro;
            this.f342834c = i16;
            this.f342835d = obj;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f342833b;
        }

        public MessageMicro<?> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MessageMicro) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f342832a;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f342834c;
        }

        public Object d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f342835d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BigDataHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f342820d = new Object();
        this.f342821e = new AtomicInteger();
        this.f342822f = null;
        this.f342823h = null;
        this.C = new a();
        this.f342825m = qQAppInterface;
        this.f342822f = new ArrayList();
        this.f342823h = (BigDataGetIpHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER);
        qQAppInterface.addObserver(this.C);
        this.f342824i = (IHttpEngineService) qQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    }

    private void G2(int i3, MessageMicro<?> messageMicro, boolean z16, int i16, Object obj) {
        int I2 = I2(i3, messageMicro, z16, i16, obj);
        if (I2 == 1) {
            QLog.d("BigDataHandler", 1, "We will wait getIPList call back to do bigData Req" + i3);
            if (!z16) {
                synchronized (this.f342820d) {
                    this.f342822f.add(new c(i3, messageMicro, i16, obj));
                }
                return;
            }
            return;
        }
        if (I2 != 0) {
            QLog.d("BigDataHandler", 1, "USER command get key error status: " + I2);
            H2(i3, false, null, i16, obj);
            return;
        }
        try {
            long parseLong = Long.parseLong(this.f342825m.getCurrentAccountUin());
            byte[] encrypt = new Cryptor().encrypt(messageMicro.toByteArray(), this.f342823h.getSrvKey());
            String str = AppSetting.f99551k;
            String str2 = new String();
            for (int i17 = 0; i17 < str.length(); i17++) {
                if (str.charAt(i17) != '.') {
                    str2 = str2.concat(Character.toString(str.charAt(i17)));
                }
            }
            im_msg_head$LoginSig im_msg_head_loginsig = new im_msg_head$LoginSig();
            im_msg_head_loginsig.uint32_type.set(22);
            im_msg_head_loginsig.bytes_sig.set(ByteStringMicro.copyFrom(this.f342823h.getSrvSig()));
            im_msg_head$HttpConnHead im_msg_head_httpconnhead = new im_msg_head$HttpConnHead();
            im_msg_head_httpconnhead.uint64_uin.set(parseLong);
            im_msg_head_httpconnhead.uint32_command.set(1791);
            im_msg_head_httpconnhead.uint32_sub_command.set(i16);
            im_msg_head_httpconnhead.uint32_seq.set(this.f342821e.incrementAndGet());
            im_msg_head_httpconnhead.uint32_version.set(Integer.parseInt(str2));
            im_msg_head_httpconnhead.uint32_flag.set(1);
            im_msg_head_httpconnhead.uint32_compress_type.set(0);
            im_msg_head_httpconnhead.uint32_error_code.set(0);
            im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
            im_msg_head_head.uint32_head_type.set(4);
            im_msg_head_head.msg_login_sig.set(im_msg_head_loginsig);
            im_msg_head_head.msg_httpconn_head.set(im_msg_head_httpconnhead);
            byte[] byteArray = im_msg_head_head.toByteArray();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.write(40);
                dataOutputStream.writeInt(byteArray.length);
                dataOutputStream.writeInt(encrypt.length);
                dataOutputStream.write(byteArray);
                dataOutputStream.write(encrypt);
                dataOutputStream.write(41);
                dataOutputStream.flush();
                String str3 = this.f342823h.E2() + "cgi-bin/httpconn";
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.setUserData(obj);
                httpNetReq.mSendData = byteArray2;
                httpNetReq.mCallback = new b(i3, this, this.f342823h.getSrvKey(), i16, obj);
                httpNetReq.mReqUrl = str3;
                httpNetReq.mHttpMethod = 1;
                httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
                IHttpEngineService iHttpEngineService = this.f342824i;
                if (iHttpEngineService != null) {
                    iHttpEngineService.sendReq(httpNetReq);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BigDataHandler", 2, e16.getMessage());
                }
                H2(i3, false, null, i16, obj);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("BigDataHandler", 2, i3 + " uin case long fail");
            }
            H2(i3, false, null, i16, obj);
        }
    }

    private int I2(int i3, MessageMicro<?> messageMicro, boolean z16, int i16, Object obj) {
        String E2 = this.f342823h.E2();
        if (this.f342823h.getSrvKey() == null) {
            if (z16) {
                return 2;
            }
            if (this.f342823h.D2(i3, messageMicro, i16, obj)) {
                return 1;
            }
            return 3;
        }
        if (this.f342823h.getSrvSig() == null) {
            if (z16) {
                return 4;
            }
            if (this.f342823h.D2(i3, messageMicro, i16, obj)) {
                return 1;
            }
            return 5;
        }
        if (E2 != null && E2.length() != 0) {
            return 0;
        }
        if (z16) {
            return 6;
        }
        if (this.f342823h.D2(i3, messageMicro, i16, obj)) {
            return 1;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        if (this.f342822f != null) {
            synchronized (this.f342820d) {
                for (c cVar : this.f342822f) {
                    H2(cVar.a(), false, null, cVar.c(), cVar.d());
                }
                this.f342822f.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        if (this.f342822f != null) {
            synchronized (this.f342820d) {
                for (c cVar : this.f342822f) {
                    G2(cVar.a(), cVar.b(), true, cVar.c(), cVar.d());
                }
                this.f342822f.clear();
            }
        }
    }

    public void F2(int i3, MessageMicro<?> messageMicro, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), messageMicro, Integer.valueOf(i16), obj);
        } else {
            G2(i3, messageMicro, false, i16, obj);
        }
    }

    protected abstract void H2(int i3, boolean z16, byte[] bArr, int i16, Object obj);

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        QQAppInterface qQAppInterface = this.f342825m;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.C);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected BigDataHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        this.f342820d = new Object();
        this.f342821e = new AtomicInteger();
        this.f342822f = null;
        this.f342823h = null;
        this.C = new a();
        this.f342822f = new ArrayList();
        this.f342823h = (BigDataGetIpHandler) this.f342825m.getBusinessHandler(BusinessHandlerFactory.BIG_DATA_GET_IP_HANDLER);
        this.f342825m.addObserver(this.C);
        this.f342824i = (IHttpEngineService) this.f342825m.getRuntimeService(IHttpEngineService.class, "all");
    }
}
