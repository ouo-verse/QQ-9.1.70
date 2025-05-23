package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$MsgHead;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f315152a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f315152a = "PBSerialization-L";
        }
    }

    public static b a(byte[] bArr) {
        a aVar = new a();
        if (bArr.length < a.f315143f) {
            QLog.w(f315152a, 1, "buffer length is short than 16!");
            return null;
        }
        aVar.c(bArr);
        if (bArr.length < aVar.b()) {
            QLog.w(f315152a, 1, "buffer length is short!");
            return null;
        }
        int b16 = (aVar.b() - aVar.a()) - a.f315143f;
        int a16 = aVar.a();
        byte[] bArr2 = new byte[b16];
        byte[] bArr3 = new byte[a16];
        System.arraycopy(bArr, a.f315143f, bArr2, 0, b16);
        System.arraycopy(bArr, a.f315143f + b16, bArr3, 0, a16);
        WeiyunPB$MsgHead weiyunPB$MsgHead = new WeiyunPB$MsgHead();
        try {
            weiyunPB$MsgHead.mergeFrom(bArr2);
            return new b(weiyunPB$MsgHead, bArr3);
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.e(f315152a, 1, "throw InvalidProtocolBufferException.");
            return null;
        }
    }

    public static byte[] b(b bVar) {
        byte[] byteArray = bVar.c().toByteArray();
        byte[] b16 = bVar.b();
        int length = a.f315143f + byteArray.length + b16.length;
        a aVar = new a();
        aVar.d(b16.length);
        aVar.e(length);
        byte[] f16 = aVar.f();
        byte[] bArr = new byte[length];
        System.arraycopy(f16, 0, bArr, 0, f16.length);
        System.arraycopy(byteArray, 0, bArr, f16.length, byteArray.length);
        System.arraycopy(b16, 0, bArr, f16.length + byteArray.length, b16.length);
        return bArr;
    }
}
