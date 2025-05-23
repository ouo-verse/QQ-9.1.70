package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.msf.service.protocol.security.q;
import com.tencent.msf.service.protocol.security.r;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f247442b = "MSF.C.AuthCoder";

    /* renamed from: c, reason: collision with root package name */
    public static final String f247443c = "test";

    /* renamed from: d, reason: collision with root package name */
    public static final String f247444d = "cmdstr";

    /* renamed from: e, reason: collision with root package name */
    public static final String f247445e = "123";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247446f = "RequestHeader";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247447g = "RequestVerifyPic";

    /* renamed from: h, reason: collision with root package name */
    public static final String f247448h = "RespondVerifyPic";

    /* renamed from: i, reason: collision with root package name */
    public static final String f247449i = "RequestRefreshVPic";

    /* renamed from: j, reason: collision with root package name */
    public static final String f247450j = "RespondRefreshVPic";

    /* renamed from: k, reason: collision with root package name */
    public static final String f247451k = "RespondAuth";

    /* renamed from: l, reason: collision with root package name */
    public static final String f247452l = "RespondHeader";

    /* renamed from: m, reason: collision with root package name */
    public static final String f247453m = "RequestCustomSig";

    /* renamed from: n, reason: collision with root package name */
    public static final String f247454n = "RespondCustomSig";

    /* renamed from: o, reason: collision with root package name */
    public static final int f247455o = 0;

    /* renamed from: a, reason: collision with root package name */
    b f247456a;

    public e(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f247456a = bVar;
        }
    }

    public byte[] a(int i3, String str, VerifyCodeInfo verifyCodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, verifyCodeInfo);
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("test");
        uniPacket.setFuncName(f247444d);
        String i16 = this.f247456a.i(str);
        uniPacket.put(f247446f, new com.tencent.msf.service.protocol.security.d(1, 2, verifyCodeInfo.wupSeq, verifyCodeInfo.svrSeqNo, i16 == null ? str : i16, i3, String.valueOf(i3), f247445e, 0));
        uniPacket.put(f247449i, new com.tencent.msf.service.protocol.security.g(1, 1));
        uniPacket.setRequestId(verifyCodeInfo.wupSeq);
        return uniPacket.encode();
    }

    public byte[] a(int i3, String str, String str2, VerifyCodeInfo verifyCodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, verifyCodeInfo);
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("test");
        uniPacket.setFuncName(f247444d);
        String i16 = this.f247456a.i(str);
        uniPacket.put(f247446f, new com.tencent.msf.service.protocol.security.d(1, 1, verifyCodeInfo.wupSeq, verifyCodeInfo.svrSeqNo, i16 == null ? str : i16, i3, String.valueOf(i3), f247445e, 0));
        uniPacket.put(f247447g, new com.tencent.msf.service.protocol.security.h(verifyCodeInfo.vpicSid, str2));
        uniPacket.setRequestId(verifyCodeInfo.wupSeq);
        return uniPacket.encode();
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, UniPacket uniPacket, com.tencent.msf.service.protocol.security.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, uniPacket, kVar);
            return;
        }
        u.a(fromServiceMsg);
        VerifyCodeInfo verifyCodeInfo = new VerifyCodeInfo();
        verifyCodeInfo.ssoSeq = fromServiceMsg.getRequestSsoSeq();
        verifyCodeInfo.wupSeq = uniPacket.getRequestId();
        int i3 = kVar.f336665b;
        if (i3 == 0) {
            com.tencent.msf.service.protocol.security.i iVar = (com.tencent.msf.service.protocol.security.i) uniPacket.getByClass(f247451k, new com.tencent.msf.service.protocol.security.i());
            verifyCodeInfo.vpicSid = iVar.f336659c;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = iVar.f336657a;
            verifyCodeInfo.verifyNote = iVar.f336658b;
        } else if (i3 == 12) {
            com.tencent.msf.service.protocol.security.i iVar2 = (com.tencent.msf.service.protocol.security.i) uniPacket.getByClass(f247451k, new com.tencent.msf.service.protocol.security.i());
            verifyCodeInfo.vpicSid = iVar2.f336659c;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = iVar2.f336657a;
            verifyCodeInfo.verifyNote = iVar2.f336658b;
        } else if (i3 == 1) {
            com.tencent.msf.service.protocol.security.n nVar = (com.tencent.msf.service.protocol.security.n) uniPacket.getByClass(f247448h, new com.tencent.msf.service.protocol.security.n());
            verifyCodeInfo.vpicSid = nVar.f336694b;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = nVar.f336693a;
            verifyCodeInfo.verifyNote = "";
        } else if (i3 == 2) {
            com.tencent.msf.service.protocol.security.m mVar = (com.tencent.msf.service.protocol.security.m) uniPacket.getByClass(f247450j, new com.tencent.msf.service.protocol.security.m());
            verifyCodeInfo.vpicSid = mVar.f336684c;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = mVar.f336682a;
            verifyCodeInfo.verifyNote = mVar.f336683b;
        } else if (i3 == 13) {
            p pVar = (p) uniPacket.getByClass("ResponseNameExchangeUin", new p());
            verifyCodeInfo.vpicSid = pVar.f336711c;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = pVar.f336709a;
            verifyCodeInfo.verifyNote = pVar.f336710b;
        } else if (i3 == 14) {
            com.tencent.msf.service.protocol.security.o oVar = (com.tencent.msf.service.protocol.security.o) uniPacket.getByClass("ResponseAuthWlogin", new com.tencent.msf.service.protocol.security.o());
            byte[] bArr = oVar.f336705d;
            verifyCodeInfo.vpicSid = oVar.f336704c;
            verifyCodeInfo.svrSeqNo = kVar.f336668e;
            verifyCodeInfo.verifyimage = oVar.f336702a;
            verifyCodeInfo.verifyNote = oVar.f336703b;
        }
        VerifyCodeInfo.putVerifyCodeInfo(fromServiceMsg, verifyCodeInfo);
        if (QLog.isColorLevel()) {
            QLog.d(f247442b, 2, "rece loginVerifyCode seq:" + fromServiceMsg.getRequestSsoSeq() + " uin:" + fromServiceMsg.getUin() + " cmd:" + fromServiceMsg.getServiceCmd() + " svrseqNo:" + verifyCodeInfo.svrSeqNo + " vipsid:" + verifyCodeInfo.vpicSid + " wupSeq:" + verifyCodeInfo.wupSeq);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247442b, 2, "add " + toServiceMsg + " to mutilActionQueue.");
        }
    }

    public void a(UniPacket uniPacket, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uniPacket, (Object) aVar);
            return;
        }
        if (uniPacket == null || aVar == null) {
            return;
        }
        RespondCustomSig respondCustomSig = (RespondCustomSig) uniPacket.getByClass(f247454n, new RespondCustomSig());
        if (respondCustomSig != null) {
            for (int i3 = 0; i3 < respondCustomSig.SigList.size(); i3++) {
                CustomSigContent customSigContent = respondCustomSig.SigList.get(i3);
                if (customSigContent.ulSigType == 1) {
                    aVar.i(customSigContent.SigContent);
                }
            }
        }
        q qVar = (q) uniPacket.getByClass("UserMainAccount", new q());
        if (qVar != null) {
            if (qVar.f336715a == 2) {
                aVar.h(qVar.f336717c);
            } else {
                aVar.h(aVar.z().getBytes());
            }
        }
        r rVar = (r) uniPacket.getByClass("UserSimpleInfo", new r());
        if (rVar != null) {
            aVar.c(rVar.f336719a);
            aVar.a(rVar.f336720b);
            aVar.d(rVar.f336721c);
            aVar.j(rVar.f336722d);
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, com.tencent.msf.service.protocol.security.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, kVar);
            return;
        }
        if (kVar == null) {
            return;
        }
        a remove = this.f247456a.f247397c.remove(kVar.f336667d);
        if (remove == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f247442b, 2, "can not find account " + fromServiceMsg.getUin() + " info.");
                return;
            }
            return;
        }
        QLog.d(f247442b, 1, MD5.toMD5(fromServiceMsg.getUin()) + " login succ.");
        remove.b(com.tencent.mobileqq.msf.service.n.b(toServiceMsg));
        this.f247456a.a(remove);
        if (a(toServiceMsg, kVar, remove)) {
            long currentTimeMillis = System.currentTimeMillis();
            remove.a(true);
            remove.a(currentTimeMillis);
            QLog.d(f247442b, 1, Thread.currentThread().getName() + " decodeLoginSuccResp setKey " + MsfSdkUtils.getShortUin(remove.z()));
            this.f247456a.f247395a.setAccountKey(remove.z(), 0, new byte[0], remove.b(), remove.c(), remove.g(), remove.h(), remove.v(), remove.k(), new byte[0], null);
            this.f247456a.o(remove.z());
            t.a(remove.z(), false);
            try {
                this.f247456a.f247395a.getWtLoginCenter().a(remove, true);
            } catch (Throwable th5) {
                QLog.d(f247442b, 1, MD5.toMD5(fromServiceMsg.getUin()) + " set key to wt error " + th5, th5);
            }
        } else {
            QLog.d(f247442b, 1, MD5.toMD5(fromServiceMsg.getUin()) + "decode login failed.");
        }
        com.tencent.mobileqq.msf.core.e.b().a(fromServiceMsg.getAppId(), fromServiceMsg.getUin());
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_SIMPLEACCOUNT, remove.w().toStoreString());
        this.f247456a.f247395a.addRespToQuque(toServiceMsg, fromServiceMsg);
    }

    private static boolean a(ToServiceMsg toServiceMsg, com.tencent.msf.service.protocol.security.k kVar, a aVar) {
        Cryptor cryptor = new Cryptor();
        if (aVar == null) {
            return false;
        }
        aVar.e(kVar.f336671h);
        aVar.c(kVar.f336670g);
        byte[] decrypt = cryptor.decrypt(kVar.f336671h, aVar.v());
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[decrypt.length - 16];
        a(bArr, 0, decrypt, 16);
        a(bArr2, 0, decrypt, 16, decrypt.length - 16);
        aVar.b(bArr2);
        byte[] decrypt2 = cryptor.decrypt(kVar.f336670g, bArr);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decrypt2);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            try {
                byte[] bArr3 = new byte[dataInputStream.readInt() - 4];
                dataInputStream.read(bArr3);
                aVar.f(bArr3);
                byte[] bArr4 = new byte[4];
                dataInputStream.read(bArr4);
                if (kVar.f336669f != 10) {
                    int length = decrypt2.length;
                    int i3 = kVar.f336673j;
                    if (i3 == 0) {
                        i3 = 24;
                    }
                    dataInputStream.read(new byte[i3]);
                }
                byte[] bArr5 = new byte[16];
                a(bArr5, 0, bArr4, 4);
                aVar.g(bArr5);
                aVar.b(com.tencent.mobileqq.msf.service.n.b(toServiceMsg));
                byteArrayInputStream.close();
            } catch (IOException unused) {
                byteArrayInputStream.close();
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
            dataInputStream.close();
        } catch (Exception unused3) {
        }
        return true;
    }

    public static void a(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }

    public static void a(byte[] bArr, int i3, byte[] bArr2, int i16) {
        System.arraycopy(bArr2, 0, bArr, i3, i16);
    }

    public static void a(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        System.arraycopy(bArr2, i16, bArr, i3, i17);
    }

    public byte[] a(int i3, String str, int i16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, Integer.valueOf(i16), hashMap);
        }
        this.f247456a.a(str);
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("test");
        uniPacket.setFuncName(f247444d);
        uniPacket.put(f247446f, new com.tencent.msf.service.protocol.security.d(1, i16, MsfService.getCore().getNextSeq(), 1, str, i3, String.valueOf(i3), f247445e, 0));
        if (hashMap != null) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                uniPacket.put(entry.getKey(), entry.getValue());
            }
        }
        return uniPacket.encode();
    }

    public byte[] a(int i3, String str, byte[] bArr, int i16, int i17, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, bArr, Integer.valueOf(i16), Integer.valueOf(i17), bArr2);
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setServantName("test");
        uniPacket.setFuncName(f247444d);
        this.f247456a.a(str);
        a aVar = this.f247456a.f247397c.get(str);
        uniPacket.put(f247446f, new com.tencent.msf.service.protocol.security.d(1, 14, MsfService.getCore().getNextSeq(), aVar.f(), str, i3, String.valueOf(i3), f247445e, 0));
        byte[] a16 = a(str, bArr);
        byte[] a17 = a(a16, str, bArr, i16);
        aVar.k(a16);
        byte[] d16 = this.f247456a.d();
        if (d16 == null) {
            d16 = new byte[0];
        }
        uniPacket.put("RequestAuthWlogin", new com.tencent.msf.service.protocol.security.b(a17, 1, 0, d16, i17, bArr2));
        com.tencent.msf.service.protocol.security.c cVar = new com.tencent.msf.service.protocol.security.c();
        cVar.f336634a = ((int) (System.currentTimeMillis() / 1000)) + this.f247456a.f();
        uniPacket.put("RequestGetServerTime", cVar);
        return uniPacket.encode();
    }

    private byte[] a(String str, byte[] bArr) {
        byte[] bArr2 = new byte[24];
        short length = (short) bArr.length;
        if (length > 16) {
            length = 16;
        }
        byte[] bArr3 = new byte[8];
        a(bArr3, 4, Long.valueOf(str).longValue());
        a(bArr2, 0, bArr, length);
        a(bArr2, 16, bArr3, 8);
        return MD5.toMD5Byte(bArr2);
    }

    private byte[] a(byte[] bArr, String str, byte[] bArr2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bArr3 = null;
        try {
            try {
                dataOutputStream.writeShort(1);
                dataOutputStream.writeInt(new Random().nextInt() >>> 1);
                dataOutputStream.writeInt(1);
                dataOutputStream.writeInt(i3);
                dataOutputStream.writeInt(1);
                dataOutputStream.writeLong(Long.parseLong(str));
                dataOutputStream.writeInt(((int) (System.currentTimeMillis() / 1000)) + this.f247456a.f());
                dataOutputStream.writeInt(0);
                dataOutputStream.writeByte(0);
                dataOutputStream.write(bArr2);
                dataOutputStream.write(new byte[16]);
                dataOutputStream.writeShort(0);
                dataOutputStream.flush();
                bArr3 = byteArrayOutputStream.toByteArray();
                byte[] encrypt = new Cryptor().encrypt(bArr3, bArr);
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                    return encrypt;
                } catch (Exception unused) {
                    return encrypt;
                }
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f247442b, 2, "createA1 error " + e16, e16);
            }
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused3) {
            }
            return bArr3;
        }
    }
}
