package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class FaceManager {
    static IPatchRedirector $redirector_ = null;
    public static final int FACE_ACQUIRED_BRIGHT = 1112;
    public static final int FACE_ACQUIRED_DARK = 1110;
    public static final int FACE_ACQUIRED_DOWN = 1116;
    public static final int FACE_ACQUIRED_FAR_FACE = 1106;
    public static final int FACE_ACQUIRED_GOOD = 1101;
    public static final int FACE_ACQUIRED_HACKER = 1111;
    public static final int FACE_ACQUIRED_IMAGER_DIRTY = 1103;
    public static final int FACE_ACQUIRED_INSUFFICIENT = 1102;
    public static final int FACE_ACQUIRED_LEFT = 1113;
    public static final int FACE_ACQUIRED_MOUTH_OCCLUSION = 1119;
    public static final int FACE_ACQUIRED_MULTI_FACE = 1121;
    public static final int FACE_ACQUIRED_NEAR_FACE = 1107;
    public static final int FACE_ACQUIRED_NOSE_OCCLUSION = 1120;
    public static final int FACE_ACQUIRED_NO_FACE = 1108;
    public static final int FACE_ACQUIRED_NO_FOCUS = 1118;
    public static final int FACE_ACQUIRED_RIGHT = 1114;
    public static final int FACE_ACQUIRED_SHIFTING = 1109;
    public static final int FACE_ACQUIRED_TOO_FAST = 1105;
    public static final int FACE_ACQUIRED_TOO_SLOW = 1104;
    public static final int FACE_ACQUIRED_UP = 1115;
    public static final int FACE_ERROR_CAMERA_UNAVAILABLE = 8;
    public static final int FACE_ERROR_CANCELED = 5;
    public static final int FACE_ERROR_HW_UNAVAILABLE = 1;
    public static final int FACE_ERROR_LOCKOUT = 7;
    public static final int FACE_ERROR_TIMEOUT = 3;
    public static final int FACE_ERROR_UNABLE_TO_PROCESS = 2;
    public static final int FACE_ERROR_VENDOR_BASE = 1000;
    public static final int FACE_WITH_EYES_CLOSED = 1117;
    private static final String TAG = "Soter.FaceManager";

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

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class AuthenticationResult {
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

    public FaceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void authenticate(CryptoObject cryptoObject, CancellationSignal cancellationSignal, int i3, AuthenticationCallback authenticationCallback, Handler handler);

    public abstract String getBiometricName(Context context);

    public abstract boolean hasEnrolledFaces();

    public abstract boolean isHardwareDetected();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class CryptoObject {
        static IPatchRedirector $redirector_;
        private final Object mCrypto;

        public CryptoObject(Signature signature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mCrypto = signature;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) signature);
            }
        }

        public Cipher getCipher() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Cipher) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            Object obj = this.mCrypto;
            if (obj instanceof Cipher) {
                return (Cipher) obj;
            }
            return null;
        }

        public Mac getMac() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Mac) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            Object obj = this.mCrypto;
            if (obj instanceof Mac) {
                return (Mac) obj;
            }
            return null;
        }

        public Signature getSignature() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Signature) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            Object obj = this.mCrypto;
            if (obj instanceof Signature) {
                return (Signature) obj;
            }
            return null;
        }

        public CryptoObject(Cipher cipher) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mCrypto = cipher;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cipher);
            }
        }

        public CryptoObject(Mac mac) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.mCrypto = mac;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mac);
            }
        }
    }
}
