package com.tencent.dlsdk.yybutil.apkchannel;

import com.tencent.dlsdk.yybutil.apkchannel.v1.c;
import com.tencent.dlsdk.yybutil.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.dlsdk.yybutil.apkchannel.v2.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        C1025a b16 = b(str);
        if (b16 == null) {
            return null;
        }
        return b16.f100548a.getProperty("channelId");
    }

    private static C1025a b(String str) {
        byte[] b16;
        try {
            b16 = b.a(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused) {
            b16 = com.tencent.dlsdk.yybutil.apkchannel.v1.a.b(str);
        }
        C1025a c1025a = null;
        if (b16 == null) {
            return null;
        }
        C1025a c1025a2 = new C1025a(c1025a);
        try {
            c1025a2.a(b16);
            return c1025a2;
        } catch (ProtocolException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.dlsdk.yybutil.apkchannel.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1025a {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        private static final c f100547c;

        /* renamed from: a, reason: collision with root package name */
        Properties f100548a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f100549b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19514);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100547c = new c(38650);
            }
        }

        C1025a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f100548a = new Properties();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        void a(byte[] bArr) {
            if (bArr == null) {
                System.out.println("WARNING:[YYBComment]decode|data=null|exit");
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            c cVar = f100547c;
            int length = cVar.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (cVar.equals(new c(bArr2))) {
                if (bArr.length - length <= 2) {
                    System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b16 = new c(bArr3).b();
                if ((bArr.length - length) - 2 < b16) {
                    System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
                    return;
                }
                byte[] bArr4 = new byte[b16];
                wrap.get(bArr4);
                this.f100548a.load(new InputStreamReader(new ByteArrayInputStream(bArr4), "UTF-8"));
                int length2 = ((bArr.length - length) - b16) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f100549b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            System.out.println("ERROR:[YYBComment]decode|unknow protocol|exit");
            throw new ProtocolException("[YYBComment] unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "YYBComment [p=" + this.f100548a + ", otherData=" + Arrays.toString(this.f100549b) + "]";
        }

        /* synthetic */ C1025a(C1025a c1025a) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) c1025a);
        }
    }
}
