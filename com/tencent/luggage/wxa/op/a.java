package com.tencent.luggage.wxa.op;

import com.tencent.luggage.wxa.np.g;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.i;
import com.tencent.luggage.wxa.np.j;
import com.tencent.luggage.wxa.np.k;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends c {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.luggage.wxa.op.c, com.tencent.luggage.wxa.op.b
    public h a() {
        com.tencent.luggage.wxa.np.e.c("Soter.CertSoterCore", "soter: start generate ask", new Object[0]);
        if (e()) {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.f137060b);
                keyPairGenerator.initialize(com.tencent.luggage.wxa.mp.a.a(g.b().a() + ".addcounter.auto_signed_when_get_pubkey_attk", 16).b(KeyPropertiesCompact.DIGEST_SHA256).c(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).a());
                long a16 = i.a();
                keyPairGenerator.generateKeyPair();
                com.tencent.luggage.wxa.np.e.c("Soter.CertSoterCore", "soter: generate successfully. cost: %d ms", Long.valueOf(i.a(a16)));
                j.c();
                return new h(0);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: generateAppGlobalSecureKey " + e16.toString(), new Object[0]);
                com.tencent.luggage.wxa.np.e.a("Soter.CertSoterCore", e16, "soter: generateAppGlobalSecureKey error");
                com.tencent.luggage.wxa.np.f.a(103, "CertSoter: generateAppGlobalSecureKey.", e16);
                return new h(4, e16.toString());
            } catch (OutOfMemoryError e17) {
                com.tencent.luggage.wxa.np.e.a("Soter.CertSoterCore", e17, "soter: out of memory when generate ASK!! maybe no attk inside");
                j.b();
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
        }
        return new h(2);
    }

    @Override // com.tencent.luggage.wxa.op.c, com.tencent.luggage.wxa.op.b
    public k b() {
        com.tencent.luggage.wxa.np.e.c("Soter.CertSoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (e()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.f137060b);
                keyStore.load(null);
                try {
                    Certificate[] certificateChain = keyStore.getCertificateChain(g.b().a());
                    if (certificateChain != null) {
                        j.c();
                        return new k(certificateChain);
                    }
                    com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: key can not be retrieved", new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "CertSoter: getAppGlobalSecureKeyModel. keyStore.getCertificateChain is null");
                    return null;
                } catch (ClassCastException e16) {
                    com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: cast error: " + e16.toString(), new Object[0]);
                    com.tencent.luggage.wxa.np.f.a(103, "CertSoter: getAppGlobalSecureKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                com.tencent.luggage.wxa.np.e.a("Soter.CertSoterCore", e17, "soter: error when get ask");
                com.tencent.luggage.wxa.np.f.a(103, "CertSoter: getAppGlobalSecureKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                com.tencent.luggage.wxa.np.e.a("Soter.CertSoterCore", e18, "soter: out of memory when getting ask!! maybe no attk inside");
                j.b();
            }
        } else {
            com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: not support soter", new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.c
    public Signature e(String str) {
        com.tencent.luggage.wxa.np.e.a("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
        if (i.a(str)) {
            com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature signature = Signature.getInstance("SHA256withRSA/PSS");
        KeyStore keyStore = KeyStore.getInstance(this.f137060b);
        keyStore.load(null);
        Key key = keyStore.getKey(str, null);
        if (key != null) {
            signature.initSign((PrivateKey) key);
            return signature;
        }
        com.tencent.luggage.wxa.np.e.b("Soter.CertSoterCore", "soter: entry not exists", new Object[0]);
        return null;
    }
}
