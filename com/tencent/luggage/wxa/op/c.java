package com.tencent.luggage.wxa.op;

import android.content.Context;
import com.tencent.luggage.wxa.np.g;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.i;
import com.tencent.luggage.wxa.np.j;
import com.tencent.luggage.wxa.np.k;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.soter.core.model.ConstantsSoter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends b implements com.tencent.luggage.wxa.np.b {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f137059c = false;

    /* renamed from: b, reason: collision with root package name */
    public String f137060b;

    public c(String str) {
        this.f137060b = str;
    }

    public static void g() {
        try {
            try {
                try {
                    Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod(VRReportDefine$ReportKey.INSTALL, new Class[0]);
                    method.setAccessible(true);
                    method.invoke(null, new Object[0]);
                } catch (ClassNotFoundException unused) {
                    com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: no SoterProvider found", new Object[0]);
                } catch (IllegalAccessException unused2) {
                    com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: cannot access", new Object[0]);
                }
            } catch (NoSuchMethodException unused3) {
                com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: function not found", new Object[0]);
            } catch (InvocationTargetException unused4) {
                com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: InvocationTargetException", new Object[0]);
            }
        } finally {
            f137059c = true;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public com.tencent.luggage.wxa.pp.c a(String str, String str2) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public k b() {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
        if (e()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f137060b);
                keyStore.load(null);
                try {
                    Key key = keyStore.getKey(g.b().a(), "from_soter_ui".toCharArray());
                    if (key != null) {
                        j.c();
                        return b.a(key.getEncoded());
                    }
                    com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAppGlobalSecureKeyModel. keyStore.getKey is null");
                    return null;
                } catch (ClassCastException e16) {
                    com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e16.toString(), new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAppGlobalSecureKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e17, "soter: error when get ask");
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAppGlobalSecureKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e18, "soter: out of memory when getting ask!! maybe no attk inside");
                j.b();
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean c() {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.f137060b);
            keyStore.load(null);
            return keyStore.getCertificate(g.b().a()) != null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e16.toString(), new Object[0]);
            com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: hasAppGlobalSecureKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean d() {
        return c() && b() != null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean e() {
        if (!f137059c) {
            g();
        }
        if (j.a()) {
            com.tencent.luggage.wxa.np.e.e("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
            return false;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith(ConstantsSoter.SOTER_PROVIDER_NAME)) {
                com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: found soter provider", new Object[0]);
                return true;
            }
        }
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
        return false;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h f() {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
        if (e()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f137060b);
                keyStore.load(null);
                keyStore.deleteEntry(g.b().a());
                return new h(0);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + e16.toString(), new Object[0]);
                return new h(5, e16.toString());
            }
        }
        com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        return new h(2);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public byte[] a(long j3) {
        return new byte[0];
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean d(String str) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(this.f137060b);
            keyStore.load(null);
            return keyStore.getCertificate(str) != null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e16.toString(), new Object[0]);
            com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: hasAuthKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean a(Context context) {
        g();
        return true;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h a() {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
        if (e()) {
            try {
                KeyStore.getInstance(this.f137060b).load(null);
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", ConstantsSoter.SOTER_PROVIDER_NAME);
                keyPairGenerator.initialize(com.tencent.luggage.wxa.mp.a.a(g.b().a() + ".addcounter.auto_signed_when_get_pubkey_attk", 4).b(KeyPropertiesCompact.DIGEST_SHA256).c(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                long a16 = i.a();
                keyPairGenerator.generateKeyPair();
                com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: generate global successfully. cost: %d ms", Long.valueOf(i.a(a16)));
                j.c();
                return new h(0);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + e16.toString(), new Object[0]);
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e16, "soter: generateAppGlobalSecureKey error");
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: generateAppGlobalSecureKey.", e16);
                return new h(4, e16.toString());
            } catch (OutOfMemoryError e17) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e17, "soter: out of memory when generate ASK!! maybe no attk inside");
                j.b();
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        }
        return new h(2);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public k c(String str) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        if (e()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f137060b);
                keyStore.load(null);
                try {
                    Key key = keyStore.getKey(str, "from_soter_ui".toCharArray());
                    j.c();
                    if (key != null) {
                        return b.a(key.getEncoded());
                    }
                    com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthKeyModel. keyStore.getKey is null");
                    return null;
                } catch (ClassCastException e16) {
                    com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e16.toString(), new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e17, "soter: error in get auth key model");
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e18, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                j.b();
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.f137060b, new Object[0]);
        }
        return null;
    }

    public Signature e(String str) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature signature = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore keyStore = KeyStore.getInstance(this.f137060b);
        keyStore.load(null);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(str, null);
        if (privateKeyEntry != null) {
            signature.initSign(privateKeyEntry.getPrivateKey());
            return signature;
        }
        com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h b(String str, boolean z16) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new h(1, "no authKeyName");
        }
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: start remove key: " + str, new Object[0]);
        if (e()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f137060b);
                keyStore.load(null);
                keyStore.deleteEntry(str);
                if (z16) {
                    com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
                    if (c()) {
                        f();
                    }
                }
                return new h(0);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + e16.toString(), new Object[0]);
                return new h(7, e16.toString());
            }
        }
        com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        return new h(2);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h a(String str) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new h(1, "no authKeyName");
        }
        if (e()) {
            try {
                try {
                    if (!c()) {
                        return new h(3, "app secure key not exist");
                    }
                    KeyStore.getInstance(this.f137060b).load(null);
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.f137060b);
                    try {
                        keyPairGenerator.initialize(com.tencent.luggage.wxa.mp.a.a(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", g.b().a()), 4).b(KeyPropertiesCompact.DIGEST_SHA256).a(true).c(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                        long a16 = i.a();
                        keyPairGenerator.generateKeyPair();
                        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: generate auth successfully, cost: %d ms", Long.valueOf(i.a(a16)));
                        j.c();
                        return new h(0);
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + e16.toString(), new Object[0]);
                        com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: generateAuthKey.", e16);
                        return new h(6, e16.toString());
                    }
                } catch (OutOfMemoryError e17) {
                    com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e17, "soter: out of memory when generate AuthKey!! maybe no attk inside");
                    j.b();
                }
            } catch (Exception e18) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + e18.toString(), new Object[0]);
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: generateAuthKey.", e18);
                return new h(6, e18.toString());
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        }
        return new h(2);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public Signature b(String str) {
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        if (e()) {
            try {
                j.c();
                return e(str);
            } catch (OutOfMemoryError e16) {
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e16, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                j.b();
                return null;
            } catch (InvalidKeyException e17) {
                e = e17;
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthInitAndSign.", e);
                return null;
            } catch (UnrecoverableEntryException e18) {
                e = e18;
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthInitAndSign.", e);
                return null;
            } catch (Exception e19) {
                com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + e19.toString(), new Object[0]);
                com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e19, "soter: exception when getSignatureResult");
                com.tencent.luggage.wxa.np.f.a(103, "BeforeTreble: getAuthInitAndSign.", e19);
                return null;
            }
        }
        com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.f137060b, new Object[0]);
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean a(String str, boolean z16) {
        com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", str, Boolean.valueOf(z16)), new Object[0]);
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            e(str);
            com.tencent.luggage.wxa.np.e.c("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
            j.c();
            return true;
        } catch (InvalidKeyException | UnrecoverableEntryException unused) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
            if (z16) {
                b(str, false);
            }
            return false;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", e16.toString());
            com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e16, "soter: occurs other exceptions");
            return false;
        } catch (OutOfMemoryError e17) {
            com.tencent.luggage.wxa.np.e.a("Soter.SoterCoreBeforeTreble", e17, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            j.b();
            return false;
        }
    }
}
