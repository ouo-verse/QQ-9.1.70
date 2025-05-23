package com.tencent.turingcam;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingface.sdk.mfa.TNative$aa;
import common.config.service.QzoneConfig;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ORjG3 implements Callable<bUA8L> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final afk8T f381973a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f381974b;

    /* renamed from: c, reason: collision with root package name */
    public final bUA8L f381975c;

    public ORjG3(afk8T afk8t, bUA8L bua8l, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, afk8t, bua8l, Boolean.valueOf(z16));
            return;
        }
        this.f381973a = afk8t;
        this.f381975c = bua8l;
        this.f381974b = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(afk8T afk8t, MtmV0 mtmV0, bUA8L bua8l, String str) {
        Context context;
        Context context2;
        HashMap<String, String> hashMap;
        String str2;
        byte[] bytes;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, this, afk8t, mtmV0, bua8l, str);
        }
        kwCJn kwcjn = new kwCJn();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        if (!this.f381974b) {
            hashMap = new HashMap<>();
            StringBuilder a16 = tmnyR.a("");
            a16.append(WT9z5.f382088a);
            hashMap.put("1", a16.toString());
            hashMap.put("3003", String.valueOf(currentTimeMillis));
            hashMap.put(QzoneConfig.DefaultValue.DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME, bua8l.f382159b);
            context2 = context;
        } else {
            context2 = context;
            HashMap<String, String> a17 = cPR64.a(context, afk8t.f382130a, mtmV0, afk8t.f382131b, kwcjn, true);
            a17.put("3001", String.valueOf(bua8l.f382158a));
            a17.put("3004", str);
            a17.put("4", kwcjn.a());
            hashMap = a17;
        }
        if (afk8t.f382131b) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("3002", str2);
        try {
            SparseArray<Object> m91_FC6D5B0A7013DB60 = TNative$aa.m91_FC6D5B0A7013DB60(new SparseArray(), context2, hashMap);
            int b16 = SWw7W.b(m91_FC6D5B0A7013DB60);
            if (b16 != 0) {
                Log.i("TuringDebug", "g : " + b16);
                return new byte[0];
            }
            boolean z16 = this.f381974b;
            byte[] a18 = SWw7W.a(m91_FC6D5B0A7013DB60);
            byte[] bArr2 = null;
            if (!z16) {
                bArr = ByteBuffer.allocate(8).putLong(currentTimeMillis).array();
                byte[] bArr3 = p0hgx.f382336b;
                bytes = new byte[bArr3.length + 8];
                System.arraycopy(bArr3, 0, bytes, 0, bArr3.length);
                System.arraycopy(bArr, 0, bytes, bArr3.length, 8);
            } else {
                if (z16) {
                    bytes = Ckq8l.a(16).getBytes("UTF-8");
                    PublicKey publicKey = DX7Nf.f381783a;
                    try {
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(1, DX7Nf.f381783a);
                        bArr = cipher.doFinal(bytes);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                }
                if (bArr2 != null) {
                    return new byte[0];
                }
                return bArr2;
            }
            byte[] bArr4 = new byte[a18.length + 1];
            bArr4[0] = 2;
            System.arraycopy(a18, 0, bArr4, 1, a18.length);
            byte[] a19 = Bp8QH.a(bArr4);
            if (a19 != null) {
                byte[] a26 = Zbb4B.a(a19, bytes);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.reset();
                byteArrayOutputStream.write(z16 ? 1 : 0);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(a26);
                bArr2 = byteArrayOutputStream.toByteArray();
            }
            if (bArr2 != null) {
            }
        } catch (Throwable th5) {
            Log.w("TuringDebug", th5);
            return new byte[0];
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.turingcam.bUA8L, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    public bUA8L call() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        MtmV0 mtmV0 = new MtmV0();
        try {
            mtmV0.f381952b = 0;
            if (this.f381974b) {
                str = Ckq8l.a(32);
            } else {
                str = null;
            }
            mtmV0.f381955e = System.currentTimeMillis();
            byte[] a16 = a(this.f381973a, mtmV0, this.f381975c, str);
            mtmV0.f381956f = System.currentTimeMillis();
            mtmV0.f381953c = a16.length;
            bUA8L bua8l = new bUA8L(0, "v3:" + Base64.encodeToString(a16, 2), System.currentTimeMillis(), 0L, 0, str);
            if (this.f381974b && !TextUtils.isEmpty(str)) {
                tLlmS.a(0L, str);
                return bua8l;
            }
            return bua8l;
        } catch (Throwable unused) {
            return new bUA8L(-10015);
        }
    }
}
