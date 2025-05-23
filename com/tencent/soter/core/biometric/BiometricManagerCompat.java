package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.biometric.FaceidManagerProxy;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BiometricManagerCompat {
    static IPatchRedirector $redirector_ = null;
    static final Map<Integer, IBiometricManager> IMPL_PROVIDER;
    private static final String TAG = "Soter.BiometricManagerCompat";
    private Integer mBiometricType;
    private Context mContext;

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

        public void onAuthenticationCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
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

    /* compiled from: P */
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

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class FaceidManagerImpl implements IBiometricManager {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "Soter.BiometricManagerCompat.Faceid";

        public FaceidManagerImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void informTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            SLogger.w(TAG, "soter: too many fail callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                SLogger.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                return false;
            }
            if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    SLogger.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                return false;
            }
            if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                SLogger.v(TAG, "soter: failure time available", new Object[0]);
                return false;
            }
            informTooManyTrial(authenticationCallback);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject cryptoObject) {
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

        private static FaceidManagerProxy.AuthenticationCallback wrapCallback(Context context, AuthenticationCallback authenticationCallback) {
            return new FaceidManagerProxy.AuthenticationCallback(context) { // from class: com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl.1
                static IPatchRedirector $redirector_;
                private boolean mMarkPermanentlyCallbacked;
                final /* synthetic */ Context val$context;

                {
                    this.val$context = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this, (Object) context);
                    } else {
                        this.mMarkPermanentlyCallbacked = false;
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationError(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] entered.", Integer.valueOf(i3), charSequence);
                    if (this.mMarkPermanentlyCallbacked) {
                        SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", Integer.valueOf(i3), charSequence);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i3 == 5) {
                        SLogger.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", Integer.valueOf(i3), charSequence);
                        AuthenticationCallback.this.onAuthenticationCancelled();
                    } else {
                        if (i3 == 7) {
                            SLogger.i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", Integer.valueOf(i3), charSequence);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.val$context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                                SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
                            }
                            AuthenticationCallback.this.onAuthenticationError(10308, "Too many failed times");
                            return;
                        }
                        SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", Integer.valueOf(i3), charSequence);
                        AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationFailed() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                        return;
                    }
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.shouldInformTooManyTrial(this, this.val$context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                        SoterBiometricAntiBruteForceStrategy.addFailTime(this.val$context);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context)) {
                            SLogger.w(FaceidManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                            SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
                            FaceidManagerImpl.informTooManyTrial(this);
                            return;
                        }
                    }
                    AuthenticationCallback.this.onAuthenticationFailed();
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", Integer.valueOf(i3), charSequence);
                    System.currentTimeMillis();
                    if (!this.mMarkPermanentlyCallbacked && !FaceidManagerImpl.shouldInformTooManyTrial(this, this.val$context)) {
                        AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback
                public void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult authenticationResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                        return;
                    }
                    SLogger.d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.shouldInformTooManyTrial(this, this.val$context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(this.val$context);
                        }
                        AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerImpl.unwrapCryptoObject(authenticationResult.getCryptoObject())));
                    }
                }
            };
        }

        private static FaceidManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FaceidManagerProxy.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FaceidManagerProxy.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new FaceidManagerProxy.CryptoObject(cryptoObject.getMac());
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, context, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler, bundle);
            } else {
                FaceidManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i3, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            }
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            return FaceidManagerProxy.getBiometricName(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            return FaceidManagerProxy.hasEnrolledFaceids(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            return FaceidManagerProxy.isHardwareDetected(context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class FingerprintManagerImpl implements IBiometricManager {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";

        public FingerprintManagerImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void informTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            SLogger.w(TAG, "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean shouldInformTooManyTrial(FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                SLogger.v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                return false;
            }
            if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    SLogger.v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                return false;
            }
            if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                SLogger.v(TAG, "soter: failure time available", new Object[0]);
                return false;
            }
            informTooManyTrial(authenticationCallback);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(FingerprintManagerProxy.CryptoObject cryptoObject) {
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

        private static FingerprintManagerProxy.AuthenticationCallback wrapCallback(Context context, AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerProxy.AuthenticationCallback(context) { // from class: com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl.1
                static IPatchRedirector $redirector_;
                private boolean mMarkPermanentlyCallbacked;
                final /* synthetic */ Context val$context;

                {
                    this.val$context = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallback.this, (Object) context);
                    } else {
                        this.mMarkPermanentlyCallbacked = false;
                    }
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationError(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationError", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i3 != 5 && i3 != 10) {
                        if (i3 != 7 && i3 != 9) {
                            AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                            return;
                        }
                        SLogger.i(FingerprintManagerImpl.TAG, "soter: system call too many trial.", new Object[0]);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context) && !SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.val$context) && !SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
                        }
                        this.mMarkPermanentlyCallbacked = false;
                        if (i3 == 7) {
                            onAuthenticationError(10308, "Too many failed times");
                            return;
                        } else {
                            onAuthenticationError(10309, "Too many failed times");
                            return;
                        }
                    }
                    SLogger.i(FingerprintManagerImpl.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                    AuthenticationCallback.this.onAuthenticationCancelled();
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationFailed() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                        return;
                    }
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, this.val$context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.addFailTime(this.val$context);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context)) {
                                SLogger.w(FingerprintManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                                SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
                                FingerprintManagerImpl.informTooManyTrial(this);
                                return;
                            }
                        }
                        AuthenticationCallback.this.onAuthenticationFailed();
                    }
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationHelp", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, this.val$context)) {
                        AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal authenticationResultInternal) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResultInternal);
                        return;
                    }
                    SLogger.d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !FingerprintManagerImpl.shouldInformTooManyTrial(this, this.val$context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(this.val$context);
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerImpl.unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
                    }
                }
            };
        }

        private static FingerprintManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerProxy.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerProxy.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new FingerprintManagerProxy.CryptoObject(cryptoObject.getMac());
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, context, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler, bundle);
            } else {
                FingerprintManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i3, cancellationSignal, wrapCallback(context, authenticationCallback), handler, bundle);
            }
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            return "fingerprint";
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            return FingerprintManagerProxy.hasEnrolledFingerprints(context);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            return FingerprintManagerProxy.isHardwareDetected(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface IBiometricManager {
        void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle);

        String getBiometricName(Context context);

        boolean hasEnrolledBiometric(Context context);

        boolean isHardwareDetected(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class LegacyFingerprintManagerImpl implements IBiometricManager {
        static IPatchRedirector $redirector_;

        public LegacyFingerprintManagerImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, context, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler, bundle);
            }
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public String getBiometricName(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            return null;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean hasEnrolledBiometric(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
        public boolean isHardwareDetected(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            SReporter.reportError(200, "LegacyFingerprintManagerImpl.isHardwareDetected return false");
            return false;
        }
    }

    static {
        IBiometricManager legacyFingerprintManagerImpl;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16286);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        HashMap hashMap = new HashMap();
        IMPL_PROVIDER = hashMap;
        if (SoterCore.isNativeSupportSoter()) {
            legacyFingerprintManagerImpl = new FingerprintManagerImpl();
        } else {
            legacyFingerprintManagerImpl = new LegacyFingerprintManagerImpl();
        }
        hashMap.put(1, legacyFingerprintManagerImpl);
        if (SoterCore.isNativeSupportSoter() && isNativeSupportFaceid()) {
            hashMap.put(2, new FaceidManagerImpl());
        }
    }

    BiometricManagerCompat(Context context, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
        } else {
            this.mContext = context;
            this.mBiometricType = num;
        }
    }

    public static BiometricManagerCompat from(Context context, Integer num) {
        return new BiometricManagerCompat(context, num);
    }

    public static boolean isNativeSupportFaceid() {
        try {
            Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void authenticate(CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler, bundle);
            return;
        }
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            authenticationCallback.onAuthenticationCancelled();
        }
        iBiometricManager.authenticate(this.mContext, cryptoObject, i3, cancellationSignal, authenticationCallback, handler, bundle);
    }

    public String getBiometricName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return null;
        }
        return iBiometricManager.getBiometricName(this.mContext);
    }

    public boolean hasEnrolledBiometric() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return false;
        }
        return iBiometricManager.hasEnrolledBiometric(this.mContext);
    }

    public boolean isCurrentFailTimeAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
    }

    public boolean isCurrentTweenTimeAvailable(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).booleanValue();
        }
        return SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
    }

    public boolean isHardwareDetected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        IBiometricManager iBiometricManager = IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            SLogger.i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            return false;
        }
        return iBiometricManager.isHardwareDetected(this.mContext);
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
