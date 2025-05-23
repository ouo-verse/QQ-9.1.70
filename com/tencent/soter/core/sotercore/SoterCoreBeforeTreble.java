package com.tencent.soter.core.sotercore;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.soter.core.keystore.KeyGenParameterSpecCompatBuilder;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreData;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.core.model.SoterErrCode;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterCoreBeforeTreble extends SoterCoreBase implements ConstantsSoter, SoterErrCode {
    static IPatchRedirector $redirector_ = null;
    private static final String MAGIC_SOTER_PWD = "from_soter_ui";
    private static final String TAG = "Soter.SoterCoreBeforeTreble";
    private static boolean isAlreadyCheckedSetUp;
    protected String providerName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17503);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            isAlreadyCheckedSetUp = false;
        }
    }

    public SoterCoreBeforeTreble(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.providerName = str;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static void setUp() {
        try {
            try {
                try {
                    Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod(VRReportDefine$ReportKey.INSTALL, new Class[0]);
                    method.setAccessible(true);
                    method.invoke(null, new Object[0]);
                } catch (ClassNotFoundException unused) {
                    SLogger.i(TAG, "soter: no SoterProvider found", new Object[0]);
                } catch (IllegalAccessException unused2) {
                    SLogger.i(TAG, "soter: cannot access", new Object[0]);
                }
            } catch (NoSuchMethodException unused3) {
                SLogger.i(TAG, "soter: function not found", new Object[0]);
            } catch (InvocationTargetException unused4) {
                SLogger.i(TAG, "soter: InvocationTargetException", new Object[0]);
            }
        } finally {
            isAlreadyCheckedSetUp = true;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public byte[] finishSign(long j3) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        return new byte[0];
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        SLogger.i(TAG, "soter: start generate ask", new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyStore.getInstance(this.providerName).load(null);
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", ConstantsSoter.SOTER_PROVIDER_NAME);
                keyPairGenerator.initialize(KeyGenParameterSpecCompatBuilder.newInstance(SoterCoreData.getInstance().getAskName() + ".addcounter.auto_signed_when_get_pubkey_attk", 4).setDigests(KeyPropertiesCompact.DIGEST_SHA256).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).build());
                long currentTicks = SoterCoreUtil.getCurrentTicks();
                keyPairGenerator.generateKeyPair();
                SLogger.i(TAG, "soter: generate global successfully. cost: %d ms", Long.valueOf(SoterCoreUtil.ticksToNowInMs(currentTicks)));
                SoterDelegate.reset();
                return new SoterCoreResult(0);
            } catch (Exception e16) {
                SLogger.e(TAG, "soter: generateAppGlobalSecureKey " + e16.toString(), new Object[0]);
                SLogger.printErrStackTrace(TAG, e16, "soter: generateAppGlobalSecureKey error");
                SReporter.reportError(103, "BeforeTreble: generateAppGlobalSecureKey.", e16);
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

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAuthKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return new SoterCoreResult(1, "no authKeyName");
        }
        if (isNativeSupportSoter()) {
            try {
                try {
                    if (!hasAppGlobalSecureKey()) {
                        return new SoterCoreResult(3, "app secure key not exist");
                    }
                    KeyStore.getInstance(this.providerName).load(null);
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.providerName);
                    try {
                        keyPairGenerator.initialize(KeyGenParameterSpecCompatBuilder.newInstance(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", SoterCoreData.getInstance().getAskName()), 4).setDigests(KeyPropertiesCompact.DIGEST_SHA256).setUserAuthenticationRequired(true).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).build());
                        long currentTicks = SoterCoreUtil.getCurrentTicks();
                        keyPairGenerator.generateKeyPair();
                        SLogger.i(TAG, "soter: generate auth successfully, cost: %d ms", Long.valueOf(SoterCoreUtil.ticksToNowInMs(currentTicks)));
                        SoterDelegate.reset();
                        return new SoterCoreResult(0);
                    } catch (Exception e16) {
                        SLogger.e(TAG, "soter: cause exception. maybe reflection exception: " + e16.toString(), new Object[0]);
                        SReporter.reportError(103, "BeforeTreble: generateAuthKey.", e16);
                        return new SoterCoreResult(6, e16.toString());
                    }
                } catch (OutOfMemoryError e17) {
                    SLogger.printErrStackTrace(TAG, e17, "soter: out of memory when generate AuthKey!! maybe no attk inside");
                    SoterDelegate.onTriggerOOM();
                }
            } catch (Exception e18) {
                SLogger.e(TAG, "soter: generate auth key failed: " + e18.toString(), new Object[0]);
                SReporter.reportError(103, "BeforeTreble: generateAuthKey.", e18);
                return new SoterCoreResult(6, e18.toString());
            }
        } else {
            SLogger.e(TAG, "soter: not support soter", new Object[0]);
        }
        return new SoterCoreResult(2);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAppGlobalSecureKeyModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SoterPubKeyModel) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        SLogger.i(TAG, "soter: start get app global secure key pub", new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.providerName);
                keyStore.load(null);
                try {
                    Key key = keyStore.getKey(SoterCoreData.getInstance().getAskName(), MAGIC_SOTER_PWD.toCharArray());
                    if (key != null) {
                        SoterDelegate.reset();
                        return SoterCoreBase.retrieveJsonFromExportedData(key.getEncoded());
                    }
                    SLogger.e(TAG, "soter: key can not be retrieved", new Object[0]);
                    SReporter.reportError(103, "BeforeTreble: getAppGlobalSecureKeyModel. keyStore.getKey is null");
                    return null;
                } catch (ClassCastException e16) {
                    SLogger.e(TAG, "soter: cast error: " + e16.toString(), new Object[0]);
                    SReporter.reportError(103, "BeforeTreble: getAppGlobalSecureKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                SLogger.printErrStackTrace(TAG, e17, "soter: error when get ask");
                SReporter.reportError(103, "BeforeTreble: getAppGlobalSecureKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                SLogger.printErrStackTrace(TAG, e18, "soter: out of memory when getting ask!! maybe no attk inside");
                SoterDelegate.onTriggerOOM();
            }
        } else {
            SLogger.e(TAG, "soter: not support soter", new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature getAuthInitAndSign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Signature) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        if (isNativeSupportSoter()) {
            try {
                SoterDelegate.reset();
                return initAuthKeySignature(str);
            } catch (OutOfMemoryError e16) {
                SLogger.printErrStackTrace(TAG, e16, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                SoterDelegate.onTriggerOOM();
                return null;
            } catch (InvalidKeyException e17) {
                e = e17;
                SLogger.e(TAG, "soter: key invalid. Advice remove the key", new Object[0]);
                SReporter.reportError(103, "BeforeTreble: getAuthInitAndSign.", e);
                return null;
            } catch (UnrecoverableEntryException e18) {
                e = e18;
                SLogger.e(TAG, "soter: key invalid. Advice remove the key", new Object[0]);
                SReporter.reportError(103, "BeforeTreble: getAuthInitAndSign.", e);
                return null;
            } catch (Exception e19) {
                SLogger.e(TAG, "soter: exception when getSignatureResult: " + e19.toString(), new Object[0]);
                SLogger.printErrStackTrace(TAG, e19, "soter: exception when getSignatureResult");
                SReporter.reportError(103, "BeforeTreble: getAuthInitAndSign.", e19);
                return null;
            }
        }
        SLogger.e(TAG, "soter: not support soter" + this.providerName, new Object[0]);
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAuthKeyModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SoterPubKeyModel) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        if (isNativeSupportSoter()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.providerName);
                keyStore.load(null);
                try {
                    Key key = keyStore.getKey(str, MAGIC_SOTER_PWD.toCharArray());
                    SoterDelegate.reset();
                    if (key != null) {
                        return SoterCoreBase.retrieveJsonFromExportedData(key.getEncoded());
                    }
                    SLogger.e(TAG, "soter: key can not be retrieved", new Object[0]);
                    SReporter.reportError(103, "BeforeTreble: getAuthKeyModel. keyStore.getKey is null");
                    return null;
                } catch (ClassCastException e16) {
                    SLogger.e(TAG, "soter: cast error: " + e16.toString(), new Object[0]);
                    SReporter.reportError(103, "BeforeTreble: getAuthKeyModel.", e16);
                    return null;
                }
            } catch (Exception e17) {
                SLogger.printErrStackTrace(TAG, e17, "soter: error in get auth key model");
                SReporter.reportError(103, "BeforeTreble: getAuthKeyModel.", e17);
            } catch (OutOfMemoryError e18) {
                SLogger.printErrStackTrace(TAG, e18, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                SoterDelegate.onTriggerOOM();
            }
        } else {
            SLogger.e(TAG, "soter: not support soter " + this.providerName, new Object[0]);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(this.providerName);
            keyStore.load(null);
            if (keyStore.getCertificate(SoterCoreData.getInstance().getAskName()) == null) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            SLogger.e(TAG, "soter: hasAppGlobalSecureKey exception: " + e16.toString(), new Object[0]);
            SReporter.reportError(103, "BeforeTreble: hasAppGlobalSecureKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAuthKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(this.providerName);
            keyStore.load(null);
            if (keyStore.getCertificate(str) == null) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            SLogger.e(TAG, "soter: hasAppGlobalSecureKey exception: " + e16.toString(), new Object[0]);
            SReporter.reportError(103, "BeforeTreble: hasAuthKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Signature) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature signature = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore keyStore = KeyStore.getInstance(this.providerName);
        keyStore.load(null);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(str, null);
        if (privateKeyEntry != null) {
            signature.initSign(privateKeyEntry.getPrivateKey());
            return signature;
        }
        SLogger.e(TAG, "soter: entry not exists", new Object[0]);
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterSessionResult initSigh(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SoterSessionResult) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean initSoter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        setUp();
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAppGlobalSecureKeyValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (hasAppGlobalSecureKey() && getAppGlobalSecureKeyModel() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAuthKeyValid(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        SLogger.i(TAG, String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", str, Boolean.valueOf(z16)), new Object[0]);
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: checking key valid: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            initAuthKeySignature(str);
            SLogger.i(TAG, "soter: key valid", new Object[0]);
            SoterDelegate.reset();
            return true;
        } catch (Exception e16) {
            SLogger.e(TAG, "soter: occurs other exceptions: %s", e16.toString());
            SLogger.printErrStackTrace(TAG, e16, "soter: occurs other exceptions");
            return false;
        } catch (OutOfMemoryError e17) {
            SLogger.printErrStackTrace(TAG, e17, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            SoterDelegate.onTriggerOOM();
            return false;
        } catch (InvalidKeyException | UnrecoverableEntryException unused) {
            SLogger.e(TAG, "soter: key invalid.", new Object[0]);
            if (z16) {
                removeAuthKey(str, false);
            }
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isNativeSupportSoter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!isAlreadyCheckedSetUp) {
            setUp();
        }
        if (SoterDelegate.isTriggeredOOM()) {
            SLogger.w(TAG, "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            SLogger.e(TAG, "soter: no provider supported", new Object[0]);
            return false;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith(ConstantsSoter.SOTER_PROVIDER_NAME)) {
                SLogger.i(TAG, "soter: found soter provider", new Object[0]);
                return true;
            }
        }
        SLogger.i(TAG, "soter: soter provider not found", new Object[0]);
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        SLogger.i(TAG, "soter: start remove app global secure key", new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.providerName);
                keyStore.load(null);
                keyStore.deleteEntry(SoterCoreData.getInstance().getAskName());
                return new SoterCoreResult(0);
            } catch (Exception e16) {
                SLogger.e(TAG, "soter: removeAppGlobalSecureKey " + e16.toString(), new Object[0]);
                return new SoterCoreResult(5, e16.toString());
            }
        }
        SLogger.e(TAG, "soter: not support soter", new Object[0]);
        return new SoterCoreResult(2);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAuthKey(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: auth key name is null or nil. abort.", new Object[0]);
            return new SoterCoreResult(1, "no authKeyName");
        }
        SLogger.i(TAG, "soter: start remove key: " + str, new Object[0]);
        if (isNativeSupportSoter()) {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.providerName);
                keyStore.load(null);
                keyStore.deleteEntry(str);
                if (z16) {
                    SLogger.i(TAG, "soter: auto delete ask", new Object[0]);
                    if (hasAppGlobalSecureKey()) {
                        removeAppGlobalSecureKey();
                    }
                }
                return new SoterCoreResult(0);
            } catch (Exception e16) {
                SLogger.e(TAG, "soter: removeAuthKey " + e16.toString(), new Object[0]);
                return new SoterCoreResult(7, e16.toString());
            }
        }
        SLogger.e(TAG, "soter: not support soter", new Object[0]);
        return new SoterCoreResult(2);
    }
}
