package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.core.model.SoterErrCode;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.core.sotercore.CertSoterCore;
import com.tencent.soter.core.sotercore.SoterCoreBase;
import com.tencent.soter.core.sotercore.SoterCoreBeforeTreble;
import com.tencent.soter.core.sotercore.SoterCoreTreble;
import com.tencent.soter.core.sotercore.SoterCoreTrebleServiceListener;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.io.IOException;
import java.security.InvalidKeyException;
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
public class SoterCore implements ConstantsSoter, SoterErrCode {
    static IPatchRedirector $redirector_ = null;
    private static SoterCoreBase IMPL = null;
    public static final int IS_NOT_TREBLE = 0;
    public static final int IS_TREBLE = 1;
    private static final int RAW_LENGTH_PREFIX = 4;
    private static final String TAG = "Soter.SoterCore";
    private static SoterCoreTrebleServiceListener serviceListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SLogger.i(TAG, "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
        SoterCoreBase providerSoterCore = getProviderSoterCore();
        IMPL = providerSoterCore;
        boolean z16 = true;
        Object[] objArr = new Object[1];
        if (providerSoterCore != null) {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        SLogger.i(TAG, "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", objArr);
    }

    public SoterCore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SoterSignatureResult convertFromBytesToSignatureResult(byte[] bArr) {
        if (SoterCoreUtil.isNullOrNil(bArr)) {
            SLogger.e(TAG, "origin is null or nil. abort", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            SLogger.e(TAG, "soter: length not correct 1", new Object[0]);
            return null;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i3 = toInt(bArr2);
        SLogger.d("Soter", "parsed raw length: " + i3, new Object[0]);
        if (i3 > 1048576) {
            SLogger.e(TAG, "soter: too large signature result!", new Object[0]);
            return null;
        }
        byte[] bArr3 = new byte[i3];
        int i16 = i3 + 4;
        if (bArr.length <= i16) {
            SLogger.e(TAG, "soter: length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, bArr3, 0, i3);
        SoterSignatureResult convertFromJson = SoterSignatureResult.convertFromJson(new String(bArr3));
        int length = bArr.length - i16;
        SLogger.d(TAG, "soter: signature length: " + length, new Object[0]);
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, i16, bArr4, 0, length);
        if (convertFromJson != null) {
            convertFromJson.setSignature(Base64.encodeToString(bArr4, 2));
        }
        return convertFromJson;
    }

    public static byte[] finishSign(long j3) throws Exception {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: finishSign IMPL is null, not support soter", new Object[0]);
            return new byte[0];
        }
        return soterCoreBase.finishSign(j3);
    }

    public static SoterCoreResult generateAppGlobalSecureKey() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return new SoterCoreResult(2);
        }
        return soterCoreBase.generateAppGlobalSecureKey();
    }

    public static SoterCoreResult generateAuthKey(String str) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
            return new SoterCoreResult(2);
        }
        return soterCoreBase.generateAuthKey(str);
    }

    public static String generateRemoteCheckRequestParam() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<deviceinfo>");
        sb5.append("<MANUFACTURER name=\"");
        sb5.append(Build.MANUFACTURER);
        sb5.append("\">");
        sb5.append("<MODEL name=\"");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("\">");
        sb5.append("<VERSION_RELEASE name=\"");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append("\">");
        sb5.append("<VERSION_INCREMENTAL name=\"");
        sb5.append(Build.VERSION.INCREMENTAL);
        sb5.append("\">");
        sb5.append("<DISPLAY name=\"");
        sb5.append(Build.DISPLAY);
        sb5.append("\">");
        sb5.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        SLogger.d(TAG, "soter: getFingerprint  " + sb5.toString(), new Object[0]);
        return sb5.toString();
    }

    public static SoterPubKeyModel getAppGlobalSecureKeyModel() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return soterCoreBase.getAppGlobalSecureKeyModel();
    }

    public static Signature getAuthInitAndSign(String str) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return soterCoreBase.getAuthInitAndSign(str);
    }

    public static SoterPubKeyModel getAuthKeyModel(String str) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return soterCoreBase.getAuthKeyModel(str);
    }

    public static SoterCoreBase getImpl() {
        return IMPL;
    }

    public static SoterCoreBase getProviderSoterCore() {
        Provider[] providers;
        SoterCoreBeforeTreble.setUp();
        if (SoterDelegate.isTriggeredOOM() || (providers = Security.getProviders()) == null) {
            return null;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith(ConstantsSoter.SOTER_PROVIDER_NAME)) {
                if (name.split("\\.").length > 1) {
                    return new CertSoterCore(name);
                }
                return new SoterCoreBeforeTreble(name);
            }
        }
        return null;
    }

    public static int getSoterCoreType() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            return 0;
        }
        if (soterCoreBase instanceof SoterCoreTreble) {
            SLogger.d(TAG, "getSoterCoreType is TREBLE", new Object[0]);
            return 1;
        }
        SLogger.d(TAG, "getSoterCoreType is not TREBLE", new Object[0]);
        return 0;
    }

    public static boolean hasAppGlobalSecureKey() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return soterCoreBase.hasAppGlobalSecureKey();
    }

    public static boolean hasAuthKey(String str) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return soterCoreBase.hasAuthKey(str);
    }

    private static Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: initAuthKeySignature IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return soterCoreBase.initAuthKeySignature(str);
    }

    public static SoterSessionResult initSigh(String str, String str2) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: initSigh IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return soterCoreBase.initSigh(str, str2);
    }

    public static boolean isAppGlobalSecureKeyValid() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return soterCoreBase.isAppGlobalSecureKeyValid();
    }

    public static boolean isAuthKeyValid(String str, boolean z16) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return soterCoreBase.isAuthKeyValid(str, z16);
    }

    public static boolean isCurrentBiometricFrozen(Context context, int i3) {
        if (!BiometricManagerCompat.from(context, Integer.valueOf(i3)).isCurrentFailTimeAvailable() && !BiometricManagerCompat.from(context, Integer.valueOf(i3)).isCurrentTweenTimeAvailable(context)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean isCurrentFingerprintFrozen(Context context) {
        if (!BiometricManagerCompat.from(context, 1).isCurrentFailTimeAvailable() && !BiometricManagerCompat.from(context, 1).isCurrentTweenTimeAvailable(context)) {
            return true;
        }
        return false;
    }

    public static boolean isNativeSupportSoter() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
            return false;
        }
        boolean isNativeSupportSoter = soterCoreBase.isNativeSupportSoter();
        SLogger.e(TAG, "soter: isNativeSupportSoter return[" + isNativeSupportSoter + "]", new Object[0]);
        return isNativeSupportSoter;
    }

    public static boolean isSupportBiometric(Context context, int i3) {
        boolean isHardwareDetected = BiometricManagerCompat.from(context, Integer.valueOf(i3)).isHardwareDetected();
        SLogger.e(TAG, "soter: isSupportBiometric type[" + i3 + "] return[" + isHardwareDetected + "]", new Object[0]);
        return isHardwareDetected;
    }

    @Deprecated
    public static boolean isSupportFingerprint(Context context) {
        boolean isHardwareDetected = BiometricManagerCompat.from(context, 1).isHardwareDetected();
        SLogger.e(TAG, "soter: isSupportFingerprint return[" + isHardwareDetected + "]", new Object[0]);
        return isHardwareDetected;
    }

    public static boolean isSystemHasBiometric(Context context, int i3) {
        return BiometricManagerCompat.from(context, Integer.valueOf(i3)).hasEnrolledBiometric();
    }

    @Deprecated
    public static boolean isSystemHasFingerprint(Context context) {
        return BiometricManagerCompat.from(context, 1).hasEnrolledBiometric();
    }

    public static boolean isTrebleServiceConnected() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: isTrebleServiceConnected IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return soterCoreBase.isTrebleServiceConnected();
    }

    public static void releaseTrebleServiceConnection() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: releaseServiceConnection IMPL is null, not support soter", new Object[0]);
        } else {
            soterCoreBase.triggerTrebleServiceConnecting();
        }
    }

    public static SoterCoreResult removeAppGlobalSecureKey() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return new SoterCoreResult(2);
        }
        return soterCoreBase.removeAppGlobalSecureKey();
    }

    public static SoterCoreResult removeAuthKey(String str, boolean z16) {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
            return new SoterCoreResult(2);
        }
        return soterCoreBase.removeAuthKey(str, z16);
    }

    private static SoterPubKeyModel retrieveJsonFromExportedData(byte[] bArr) {
        if (bArr == null) {
            SLogger.e(TAG, "soter: raw data is null", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            SLogger.e(TAG, "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i3 = toInt(bArr2);
        SLogger.d(TAG, "soter: parsed raw length: " + i3, new Object[0]);
        if (i3 > 1048576) {
            SLogger.e(TAG, "soter: too large json result!", new Object[0]);
            return null;
        }
        byte[] bArr3 = new byte[i3];
        int i16 = i3 + 4;
        if (bArr.length <= i16) {
            SLogger.e(TAG, "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, bArr3, 0, i3);
        String str = new String(bArr3);
        SLogger.d(TAG, "soter: to convert json: " + str, new Object[0]);
        SoterPubKeyModel soterPubKeyModel = new SoterPubKeyModel(str, "");
        int length = bArr.length - i16;
        SLogger.d(TAG, "soter: signature length: " + length, new Object[0]);
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, i16, bArr4, 0, length);
        soterPubKeyModel.setSignature(Base64.encodeToString(bArr4, 2));
        return soterPubKeyModel;
    }

    public static void setTrebleServiceListener(SoterCoreTrebleServiceListener soterCoreTrebleServiceListener) {
        serviceListener = soterCoreTrebleServiceListener;
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: setTrebleServiceListener IMPL is null, not support soter", new Object[0]);
        } else {
            soterCoreBase.setTrebleServiceListener(soterCoreTrebleServiceListener);
        }
    }

    public static void setUp() {
        SoterCoreBeforeTreble.setUp();
    }

    private static int toInt(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            i3 += (bArr[i16] & 255) << (i16 * 8);
        }
        return i3;
    }

    public static void triggerTrebleServiceConnecting() {
        SoterCoreBase soterCoreBase = IMPL;
        if (soterCoreBase == null) {
            SLogger.e(TAG, "soter: triggerConnecting IMPL is null, not support soter", new Object[0]);
        } else {
            soterCoreBase.triggerTrebleServiceConnecting();
        }
    }

    public static void tryToInitSoterBeforeTreble() {
        if (IMPL == null) {
            SLogger.i(TAG, "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
            SoterCoreBase providerSoterCore = getProviderSoterCore();
            IMPL = providerSoterCore;
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (providerSoterCore != null) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            SLogger.i(TAG, "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", objArr);
        }
    }

    public static synchronized void tryToInitSoterTreble(Context context) {
        synchronized (SoterCore.class) {
            if (IMPL == null) {
                SLogger.i(TAG, "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
                if (!SoterCoreTreble.isInitializing()) {
                    SoterCoreTreble soterCoreTreble = new SoterCoreTreble();
                    IMPL = soterCoreTreble;
                    soterCoreTreble.setTrebleServiceListener(serviceListener);
                    if (!IMPL.initSoter(context)) {
                        IMPL = null;
                        SLogger.i(TAG, "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
                    }
                } else {
                    SLogger.i(TAG, "soter: treble is initializing", new Object[0]);
                }
            }
        }
    }
}
