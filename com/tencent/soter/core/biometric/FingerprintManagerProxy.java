package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreUtil;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
/* loaded from: classes25.dex */
final class FingerprintManagerProxy {
    static IPatchRedirector $redirector_ = null;
    public static final String FINGERPRINT_SERVICE = "fingerprint";
    private static final String TAG = "Soter.FingerprintManagerProxy";
    public static boolean sCLOSE_API31;

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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16425);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCLOSE_API31 = false;
        }
    }

    FingerprintManagerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i3, Object obj, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        boolean z16 = bundle.getBoolean("use_biometric_prompt");
        int i16 = Build.VERSION.SDK_INT;
        SLogger.i(TAG, "use_biometric_prompt: %s, sdk_version: %s", Boolean.valueOf(z16), Integer.valueOf(i16));
        if (z16 && i16 >= 28) {
            authenticateApi28(context, cryptoObject, i3, obj, authenticationCallback, handler, bundle);
        } else {
            authenticateLegacy(context, cryptoObject, i3, obj, authenticationCallback, handler);
        }
    }

    @SuppressLint({"MissingPermission"})
    private static void authenticateApi28(Context context, CryptoObject cryptoObject, int i3, Object obj, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        Executor mainExecutor;
        BiometricPrompt build;
        Executor mainExecutor2;
        if (checkSelfPermission(context, "android.permission.USE_BIOMETRIC") != 0) {
            SLogger.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            return;
        }
        BiometricPrompt.Builder builder = new BiometricPrompt.Builder(context);
        builder.setDeviceCredentialAllowed(false);
        if (Build.VERSION.SDK_INT >= 30) {
            builder.setAllowedAuthenticators(15);
        }
        builder.setTitle(bundle.getString("prompt_title"));
        builder.setSubtitle(bundle.getString("prompt_subtitle"));
        builder.setDescription(bundle.getString("prompt_description"));
        String string = bundle.getString("prompt_button");
        if (TextUtils.isEmpty(string)) {
            string = context.getString(17039360);
        }
        mainExecutor = context.getMainExecutor();
        builder.setNegativeButton(string, mainExecutor, new DialogInterface.OnClickListener() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                } else {
                    AuthenticationCallback.this.onAuthenticationError(ConstantsSoter.ERR_NEGATIVE_BUTTON, "click negative button");
                }
            }
        });
        build = builder.build();
        mainExecutor2 = context.getMainExecutor();
        build.authenticate((CancellationSignal) obj, mainExecutor2, wrapCallback2(authenticationCallback));
    }

    @SuppressLint({"MissingPermission"})
    private static void authenticateLegacy(Context context, CryptoObject cryptoObject, int i3, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
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
            SLogger.e(TAG, "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
            return false;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                return fingerprintManager.hasEnrolledFingerprints();
            }
            SLogger.e(TAG, "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException unused) {
            SLogger.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
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
                boolean isHardwareDetected = fingerprintManager.isHardwareDetected();
                if (!isHardwareDetected) {
                    SReporter.reportError(104, "FingerprintManager.isHardwareDetected return false");
                }
                return isHardwareDetected;
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
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.2
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
                    SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationFailed();
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                } else {
                    SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                }
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                } else {
                    SLogger.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.unwrapCryptoObject(authenticationResult.getCryptoObject())));
                }
            }
        };
    }

    private static BiometricPrompt.AuthenticationCallback wrapCallback2(AuthenticationCallback authenticationCallback) {
        return new BiometricPrompt.AuthenticationCallback() { // from class: com.tencent.soter.core.biometric.FingerprintManagerProxy.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this);
                }
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                } else {
                    AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                }
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationFailed() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                } else {
                    AuthenticationCallback.this.onAuthenticationFailed();
                }
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                } else {
                    AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                }
            }

            @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                BiometricPrompt.CryptoObject cryptoObject;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                    return;
                }
                AuthenticationCallback authenticationCallback2 = AuthenticationCallback.this;
                cryptoObject = authenticationResult.getCryptoObject();
                authenticationCallback2.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.unwrapCryptoObject(cryptoObject)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
        Cipher cipher;
        Signature signature;
        Mac mac;
        Mac mac2;
        Signature signature2;
        Cipher cipher2;
        if (cryptoObject == null) {
            return null;
        }
        cipher = cryptoObject.getCipher();
        if (cipher != null) {
            cipher2 = cryptoObject.getCipher();
            return new CryptoObject(cipher2);
        }
        signature = cryptoObject.getSignature();
        if (signature != null) {
            signature2 = cryptoObject.getSignature();
            return new CryptoObject(signature2);
        }
        mac = cryptoObject.getMac();
        if (mac == null) {
            return null;
        }
        mac2 = cryptoObject.getMac();
        return new CryptoObject(mac2);
    }
}
