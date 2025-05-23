package com.tencent.soter.core.sotercore;

import android.content.Context;
import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SoterCoreBase {
    static IPatchRedirector $redirector_ = null;
    protected static final int RAW_LENGTH_PREFIX = 4;
    protected static final String TAG = "Soter.SoterCoreBase";

    public SoterCoreBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static SoterPubKeyModel retrieveJsonFromExportedData(byte[] bArr) {
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
        if (bArr.length < i16) {
            SLogger.e(TAG, "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, bArr3, 0, i3);
        String str = new String(bArr3);
        SLogger.d(TAG, "soter: to convert json: " + str, new Object[0]);
        SoterPubKeyModel soterPubKeyModel = new SoterPubKeyModel(str, "");
        int length = bArr.length - i16;
        SLogger.d(TAG, "soter: signature length: " + length, new Object[0]);
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i16, bArr4, 0, length);
            soterPubKeyModel.setSignature(Base64.encodeToString(bArr4, 2));
        }
        return soterPubKeyModel;
    }

    protected static int toInt(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            i3 += (bArr[i16] & 255) << (i16 * 8);
        }
        return i3;
    }

    public abstract byte[] finishSign(long j3) throws Exception;

    public abstract SoterCoreResult generateAppGlobalSecureKey();

    public abstract SoterCoreResult generateAuthKey(String str);

    public abstract SoterPubKeyModel getAppGlobalSecureKeyModel();

    public abstract Signature getAuthInitAndSign(String str);

    public abstract SoterPubKeyModel getAuthKeyModel(String str);

    public abstract boolean hasAppGlobalSecureKey();

    public abstract boolean hasAuthKey(String str);

    public abstract Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException;

    public abstract SoterSessionResult initSigh(String str, String str2);

    public abstract boolean initSoter(Context context);

    public abstract boolean isAppGlobalSecureKeyValid();

    public abstract boolean isAuthKeyValid(String str, boolean z16);

    public abstract boolean isNativeSupportSoter();

    public boolean isTrebleServiceConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    public void releaseTrebleServiceConnection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public abstract SoterCoreResult removeAppGlobalSecureKey();

    public abstract SoterCoreResult removeAuthKey(String str, boolean z16);

    public void setTrebleServiceListener(SoterCoreTrebleServiceListener soterCoreTrebleServiceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) soterCoreTrebleServiceListener);
        }
    }

    public void triggerTrebleServiceConnecting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void updateExtraParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
