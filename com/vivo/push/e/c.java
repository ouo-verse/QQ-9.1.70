package com.vivo.push.e;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.vivo.push.util.u;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private PrivateKey f387656a = null;

    /* renamed from: b, reason: collision with root package name */
    private PublicKey f387657b = null;

    /* renamed from: c, reason: collision with root package name */
    private KeyStore f387658c;

    /* renamed from: d, reason: collision with root package name */
    private X500Principal f387659d;

    /* renamed from: e, reason: collision with root package name */
    private Context f387660e;

    public c(Context context) {
        this.f387660e = context;
        a(context);
    }

    private synchronized void a(Context context) {
        try {
            b();
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "init error" + e16.getMessage());
        }
    }

    private void b(Context context) {
        try {
            if (context == null) {
                u.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 999);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f387659d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", SignUtils.KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "generateRSAKeyPairSign error" + e16.getMessage());
        }
    }

    private PrivateKey c(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = this.f387656a;
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e16.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            u.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry d16 = d(context);
        if (d16 instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) d16).getPrivateKey();
            this.f387656a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private KeyStore.Entry d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        try {
            if (context == null) {
                u.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                b(context);
            }
            return this.f387658c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e16) {
            b(context);
            KeyStore.Entry entry = this.f387658c.getEntry("PushRsaKeyAlias", null);
            e16.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e16.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.e.a
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || c(this.f387660e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey c16 = c(this.f387660e);
            Signature signature = Signature.getInstance(SignUtils.SIGNATURE_SHA256withRSA);
            signature.initSign(c16);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            u.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "signClientSDK error" + e16.getMessage());
            return null;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f387658c == null) {
                b();
            }
            return this.f387658c.containsAlias(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "getPrivateKeySigin error" + e16.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.e.a
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance(SignUtils.SIGNATURE_SHA256withRSA);
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "verifyClientSDK error" + e16.getMessage());
            return false;
        }
    }

    private void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance(SignUtils.KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            this.f387658c = keyStore;
            keyStore.load(null);
            this.f387659d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "initKeyStore error" + e16.getMessage());
        }
    }

    @Override // com.vivo.push.e.a
    public final PublicKey a() {
        try {
            PublicKey publicKey = this.f387657b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry d16 = d(this.f387660e);
            if (!(d16 instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) d16).getCertificate().getPublicKey();
            this.f387657b = publicKey2;
            return publicKey2;
        } catch (Exception e16) {
            e16.printStackTrace();
            u.a("RsaSecurity", "getPublicKeySign error" + e16.getMessage());
            return null;
        }
    }
}
