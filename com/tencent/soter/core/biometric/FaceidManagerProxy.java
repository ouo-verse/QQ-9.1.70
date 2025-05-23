package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
/* loaded from: classes25.dex */
final class FaceidManagerProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
    private static final String TAG = "Soter.FaceidManagerProxy";

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

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
            }
        }
    }

    /* loaded from: classes25.dex */
    public static final class AuthenticationResult {
        static IPatchRedirector $redirector_;
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
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

    FaceidManagerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i3, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                faceManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i3, wrapCallback(authenticationCallback), handler);
            } else {
                SLogger.e(TAG, "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
            }
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
        }
    }

    public static String getBiometricName(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                return faceManager.getBiometricName(context);
            }
            SLogger.e(TAG, "soter: faceid manager is null! no biometric name returned.", new Object[0]);
            return null;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return null;
        }
    }

    private static FaceManager getFaceManager(Context context) {
        try {
            return (FaceManager) Class.forName(FACEMANAGER_FACTORY_CLASS_NAME).getDeclaredMethod("getFaceManager", Context.class).invoke(null, context);
        } catch (Exception e16) {
            SLogger.e(TAG, "soter: FaceManager init failed, maybe not support." + e16.toString(), new Object[0]);
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean hasEnrolledFaceids(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                return faceManager.hasEnrolledFaces();
            }
            SLogger.e(TAG, "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                boolean isHardwareDetected = faceManager.isHardwareDetected();
                if (!isHardwareDetected) {
                    SReporter.reportError(104, "FaceManager.isHardwareDetected return false");
                }
                return isHardwareDetected;
            }
            SLogger.e(TAG, "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (Exception unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(FaceManager.CryptoObject cryptoObject) {
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

    private static FaceManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new FaceManager.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FaceidManagerProxy.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this);
                }
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationError(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                } else {
                    SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                }
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationFailed();
                }
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                } else {
                    SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                }
            }

            @Override // com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FaceManager.AuthenticationResult authenticationResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                } else {
                    SLogger.d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerProxy.unwrapCryptoObject(authenticationResult.getCryptoObject())));
                }
            }
        };
    }

    private static FaceManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FaceManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FaceManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() == null) {
            return null;
        }
        return new FaceManager.CryptoObject(cryptoObject.getMac());
    }

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
