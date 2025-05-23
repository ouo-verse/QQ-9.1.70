package com.tencent.soter.core.sotercore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreData;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.core.model.SoterPubKeyModel;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CertSoterCore extends SoterCoreBeforeTreble {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.CertSoterCore";

    public CertSoterCore(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBeforeTreble, com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SLogger.i(TAG, "soter: start generate ask", new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.providerName);
                keyPairGenerator.initialize(KeyGenParameterSpecCompatBuilder.newInstance(SoterCoreData.getInstance().getAskName() + ".addcounter.auto_signed_when_get_pubkey_attk", 16).setDigests(KeyPropertiesCompact.DIGEST_SHA256).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).build());
                long currentTicks = SoterCoreUtil.getCurrentTicks();
                keyPairGenerator.generateKeyPair();
                SLogger.i(TAG, "soter: generate successfully. cost: %d ms", Long.valueOf(SoterCoreUtil.ticksToNowInMs(currentTicks)));
                SoterDelegate.reset();
                return new SoterCoreResult(0);
            } catch (Exception e16) {
                SLogger.e(TAG, "soter: generateAppGlobalSecureKey " + e16.toString(), new Object[0]);
                SLogger.printErrStackTrace(TAG, e16, "soter: generateAppGlobalSecureKey error");
                SReporter.reportError(103, "CertSoter: generateAppGlobalSecureKey.", e16);
                return new SoterCoreResult(4, e16.toString());
            } catch (OutOfMemoryError e17) {
                SLogger.printErrStackTrace(TAG, e17, "soter: out of memory when generate ASK!! maybe no attk inside");
                SoterDelegate.onTriggerOOM();
            }
        } else {
            SLogger.e(TAG, "soter: not support soter", new Object[0]);
        }
        return new SoterCoreResult(2);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBeforeTreble, com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAppGlobalSecureKeyModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SoterPubKeyModel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        SLogger.i(TAG, "soter: start get app global secure key pub", new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.providerName);
                keyStore.load(null);
                try {
                    Certificate[] certificateChain = keyStore.getCertificateChain(SoterCoreData.getInstance().getAskName());
                    if (certificateChain != null) {
                        SoterDelegate.reset();
                        return new SoterPubKeyModel(certificateChain);
                    }
                    SLogger.e(TAG, "soter: key can not be retrieved", new Object[0]);
                    SReporter.reportError(103, "CertSoter: getAppGlobalSecureKeyModel. keyStore.getCertificateChain is null");
                    return null;
                } catch (ClassCastException e16) {
                    SLogger.e(TAG, "soter: cast error: " + e16.toString(), new Object[0]);
                    SReporter.reportError(103, "CertSoter: getAppGlobalSecureKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                SLogger.printErrStackTrace(TAG, e17, "soter: error when get ask");
                SReporter.reportError(103, "CertSoter: getAppGlobalSecureKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                SLogger.printErrStackTrace(TAG, e18, "soter: out of memory when getting ask!! maybe no attk inside");
                SoterDelegate.onTriggerOOM();
            }
        } else {
            SLogger.e(TAG, "soter: not support soter", new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBeforeTreble, com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Signature) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        SLogger.d("Monday", "CertSoterCore initAuthKeySignature", new Object[0]);
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature signature = Signature.getInstance("SHA256withRSA/PSS");
        KeyStore keyStore = KeyStore.getInstance(this.providerName);
        keyStore.load(null);
        Key key = keyStore.getKey(str, null);
        if (key != null) {
            signature.initSign((PrivateKey) key);
            return signature;
        }
        SLogger.e(TAG, "soter: entry not exists", new Object[0]);
        return null;
    }
}
