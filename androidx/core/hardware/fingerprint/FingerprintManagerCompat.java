package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class FingerprintManagerCompat {
    private final Context mContext;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context context) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i3 > 23 && context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    @RequiresApi(23)
    static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject cryptoObject) {
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

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: androidx.core.hardware.fingerprint.FingerprintManagerCompat.1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i3, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i3, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i3, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(authenticationResult.getCryptoObject())));
            }
        };
    }

    @RequiresApi(23)
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

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i3, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        android.os.CancellationSignal cancellationSignal2;
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null) {
            if (cancellationSignal != null) {
                cancellationSignal2 = (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject();
            } else {
                cancellationSignal2 = null;
            }
            fingerprintManagerOrNull.authenticate(wrapCryptoObject(cryptoObject), cancellationSignal2, i3, wrapCallback(authenticationCallback), handler);
        }
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null && fingerprintManagerOrNull.hasEnrolledFingerprints()) {
            return true;
        }
        return false;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null && fingerprintManagerOrNull.isHardwareDetected()) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationError(int i3, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
        }
    }
}
