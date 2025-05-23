package com.tencent.soter.core.fingerprint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreUtil;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
@SuppressLint({"NewApi"})
@Deprecated
/* loaded from: classes25.dex */
final class FingerprintManagerCompatApi23 {
    static IPatchRedirector $redirector_ = null;
    public static final String FINGERPRINT_SERVICE = "fingerprint";
    private static final String TAG = "Soter.FingerprintManagerCompatApi23";

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class AuthenticationCallback {
        static IPatchRedirector $redirector_;

        public AuthenticationCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void onAuthenticationError(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
            }
        }

        public void onAuthenticationFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
            }
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResultInternal);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class AuthenticationResultInternal {
        static IPatchRedirector $redirector_;
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cryptoObject);
            } else {
                this.mCryptoObject = cryptoObject;
            }
        }

        public CryptoObject getCryptoObject() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CryptoObject) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mCryptoObject;
        }
    }

    FingerprintManagerCompatApi23() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i3, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                fingerprintManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i3, wrapCallback(authenticationCallback), handler);
            } else {
                SLogger.e(TAG, "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
        }
    }

    private static int checkSelfPermission(Context context, String str) {
        if (context == null) {
            SLogger.e(TAG, "soter: check self permission: context is null", new Object[0]);
            return -1;
        }
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.e(TAG, "soter: requested permission is null or nil", new Object[0]);
            return -1;
        }
        return context.checkSelfPermission(str);
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            return false;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                return fingerprintManager.hasEnrolledFingerprints();
            }
            SLogger.e(TAG, "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            SLogger.e(TAG, "soter: permission check failed: isHardwareDetected", new Object[0]);
            return false;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                return fingerprintManager.isHardwareDetected();
            }
            SLogger.e(TAG, "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new CryptoObject(cryptoObject.getMac());
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this);
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                } else {
                    SLogger.d(FingerprintManagerCompatApi23.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    SLogger.d(FingerprintManagerCompatApi23.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationFailed();
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                } else {
                    SLogger.d(FingerprintManagerCompatApi23.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                } else {
                    SLogger.d(FingerprintManagerCompatApi23.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.unwrapCryptoObject(authenticationResult.getCryptoObject())));
                }
            }
        };
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FingerprintManager.CryptoObject(cryptoObject.getMac());
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class CryptoObject {
        static IPatchRedirector $redirector_;
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) signature);
                return;
            }
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public Cipher getCipher() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Cipher) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mCipher;
        }

        public Mac getMac() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Mac) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.mMac;
        }

        public Signature getSignature() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Signature) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.mSignature;
        }

        public CryptoObject(Cipher cipher) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cipher);
                return;
            }
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mac);
                return;
            }
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }
}
