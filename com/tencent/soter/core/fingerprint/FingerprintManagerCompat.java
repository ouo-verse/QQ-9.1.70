package com.tencent.soter.core.fingerprint;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23;
import com.tencent.soter.core.model.SLogger;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class FingerprintManagerCompat {
    static IPatchRedirector $redirector_ = null;
    static final FingerprintManagerCompatImpl IMPL;
    private static final String TAG = "Soter.FingerprintManagerCompat";
    private Context mContext;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        static IPatchRedirector $redirector_;

        public Api23FingerprintManagerCompatImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean checkBruteForce(FingerprintManagerCompatApi23.AuthenticationCallback authenticationCallback, Context context) {
            if (SoterAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                SLogger.v(FingerprintManagerCompat.TAG, "soter: using system anti brute force strategy", new Object[0]);
                return false;
            }
            if (SoterAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    SLogger.v(FingerprintManagerCompat.TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterAntiBruteForceStrategy.unFreeze(context);
                }
                return false;
            }
            if (SoterAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                SLogger.v(FingerprintManagerCompat.TAG, "soter: failure time available", new Object[0]);
                return false;
            }
            informTooManyTrial(authenticationCallback);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void informTooManyTrial(FingerprintManagerCompatApi23.AuthenticationCallback authenticationCallback) {
            SLogger.w(FingerprintManagerCompat.TAG, "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
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

        private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(Context context, AuthenticationCallback authenticationCallback) {
            return new FingerprintManagerCompatApi23.AuthenticationCallback(context) { // from class: com.tencent.soter.core.fingerprint.FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.1
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

                @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationError(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FingerprintManagerCompat.TAG, "soter: basic onAuthenticationError", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i3 == 5) {
                        SLogger.i(FingerprintManagerCompat.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                        AuthenticationCallback.this.onAuthenticationCancelled();
                    } else {
                        if (i3 == 7) {
                            SLogger.i(FingerprintManagerCompat.TAG, "soter: system call too many trial.", new Object[0]);
                            if (!SoterAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context) && !SoterAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.val$context) && !SoterAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                                SoterAntiBruteForceStrategy.freeze(this.val$context);
                            }
                            this.mMarkPermanentlyCallbacked = false;
                            onAuthenticationError(10308, "Too many failed times");
                            return;
                        }
                        AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationFailed() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                        return;
                    }
                    SLogger.d(FingerprintManagerCompat.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !Api23FingerprintManagerCompatImpl.checkBruteForce(this, this.val$context)) {
                        if (!SoterAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterAntiBruteForceStrategy.addFailTime(this.val$context);
                            if (!SoterAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context)) {
                                SLogger.w(FingerprintManagerCompat.TAG, "soter: too many fail trials", new Object[0]);
                                SoterAntiBruteForceStrategy.freeze(this.val$context);
                                Api23FingerprintManagerCompatImpl.informTooManyTrial(this);
                                return;
                            }
                        }
                        AuthenticationCallback.this.onAuthenticationFailed();
                    }
                }

                @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
                        return;
                    }
                    SLogger.d(FingerprintManagerCompat.TAG, "soter: basic onAuthenticationHelp", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !Api23FingerprintManagerCompatImpl.checkBruteForce(this, this.val$context)) {
                        AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
                    }
                }

                @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback
                public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal authenticationResultInternal) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResultInternal);
                        return;
                    }
                    SLogger.d(FingerprintManagerCompat.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (!this.mMarkPermanentlyCallbacked && !Api23FingerprintManagerCompatImpl.checkBruteForce(this, this.val$context)) {
                        if (!SoterAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterAntiBruteForceStrategy.unFreeze(this.val$context);
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(Api23FingerprintManagerCompatImpl.unwrapCryptoObject(authenticationResultInternal.getCryptoObject())));
                    }
                }
            };
        }

        private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() == null) {
                return null;
            }
            return new FingerprintManagerCompatApi23.CryptoObject(cryptoObject.getMac());
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, context, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler);
            } else {
                FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject(cryptoObject), i3, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            }
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }
    }

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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface FingerprintManagerCompatImpl {
        void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        static IPatchRedirector $redirector_;

        public LegacyFingerprintManagerCompatImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public void authenticate(Context context, CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, context, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler);
            }
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean hasEnrolledFingerprints(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.FingerprintManagerCompatImpl
        public boolean isHardwareDetected(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else if (SoterCore.isNativeSupportSoter()) {
            IMPL = new Api23FingerprintManagerCompatImpl();
        } else {
            IMPL = new LegacyFingerprintManagerCompatImpl();
        }
    }

    FingerprintManagerCompat(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
        }
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    public void authenticate(CryptoObject cryptoObject, int i3, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cryptoObject, Integer.valueOf(i3), cancellationSignal, authenticationCallback, handler);
        } else {
            IMPL.authenticate(this.mContext, cryptoObject, i3, cancellationSignal, authenticationCallback, handler);
        }
    }

    public boolean hasEnrolledFingerprints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isCurrentFailTimeAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return SoterAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
    }

    public boolean isCurrentTweenTimeAvailable(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).booleanValue();
        }
        return SoterAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
    }

    public boolean isHardwareDetected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return IMPL.isHardwareDetected(this.mContext);
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
