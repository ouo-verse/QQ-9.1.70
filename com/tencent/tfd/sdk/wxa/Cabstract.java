package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.abstract, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cabstract {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f375745a;

    public Cabstract(String str) {
        this.f375745a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cinstanceof a(byte[] bArr) {
        byte[] bArr2;
        HttpURLConnection httpURLConnection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Cinstanceof) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        Ccontinue ccontinue = new Ccontinue();
        int a16 = ccontinue.a(this.f375745a, bArr);
        if (a16 != 0) {
            return new Cinstanceof(a16, new byte[0]);
        }
        AtomicReference atomicReference = new AtomicReference();
        HttpURLConnection httpURLConnection2 = ccontinue.f375753a;
        int i3 = -4000;
        if (httpURLConnection2 != null && ccontinue.f375754b) {
            try {
                InputStream inputStream = httpURLConnection2.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                i3 = 0;
            } catch (IOException e16) {
                e16.printStackTrace();
                i3 = -4056;
                bArr2 = null;
                atomicReference.set(bArr2);
                httpURLConnection = ccontinue.f375753a;
                if (httpURLConnection != null) {
                }
                if (i3 != 0) {
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                bArr2 = null;
                atomicReference.set(bArr2);
                httpURLConnection = ccontinue.f375753a;
                if (httpURLConnection != null) {
                }
                if (i3 != 0) {
                }
            }
            atomicReference.set(bArr2);
            httpURLConnection = ccontinue.f375753a;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                ccontinue.f375753a = null;
            }
        }
        if (i3 != 0) {
            return new Cinstanceof(i3, new byte[0]);
        }
        return new Cinstanceof(i3, (byte[]) atomicReference.get());
    }
}
