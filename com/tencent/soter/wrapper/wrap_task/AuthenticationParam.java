package com.tencent.soter.wrapper.wrap_task;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricCanceller;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback;
import com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintCanceller;
import com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintStateCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapGetChallengeStr;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadSignature;

/* loaded from: classes25.dex */
public class AuthenticationParam {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MicroMsg.AuthenticationParam";
    private int mBiometricType;
    private String mChallenge;
    private Context mContext;
    private SoterFingerprintCanceller mFingerprintCanceller;
    private IWrapGetChallengeStr mIWrapGetChallengeStr;
    private IWrapUploadSignature mIWrapUploadSignature;
    private String mPromptButton;
    private String mPromptDescription;
    private String mPromptSubTitle;
    private String mPromptTitle;
    private int mScene;
    private SoterBiometricCanceller mSoterBiometricCanceller;
    private SoterBiometricStateCallback mSoterBiometricStateCallback;
    private SoterFingerprintStateCallback mSoterFingerprintStateCallback;
    private boolean mUseBiometricPrompt;

    /* loaded from: classes25.dex */
    public static class AuthenticationParamBuilder {
        static IPatchRedirector $redirector_;
        private AuthenticationParam mParam;

        public AuthenticationParamBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mParam = new AuthenticationParam(null);
            }
        }

        public AuthenticationParam build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (AuthenticationParam) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.mParam;
        }

        public AuthenticationParamBuilder setBiometricType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                this.mParam.mBiometricType = i3;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }

        public AuthenticationParamBuilder setContext(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.mParam.mContext = context;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }

        @Deprecated
        public AuthenticationParamBuilder setFingerprintCanceller(SoterFingerprintCanceller soterFingerprintCanceller) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.mParam.mFingerprintCanceller = soterFingerprintCanceller;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) soterFingerprintCanceller);
        }

        public AuthenticationParamBuilder setIWrapGetChallengeStr(IWrapGetChallengeStr iWrapGetChallengeStr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.mParam.mIWrapGetChallengeStr = iWrapGetChallengeStr;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iWrapGetChallengeStr);
        }

        public AuthenticationParamBuilder setIWrapUploadSignature(IWrapUploadSignature iWrapUploadSignature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.mParam.mIWrapUploadSignature = iWrapUploadSignature;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) iWrapUploadSignature);
        }

        public AuthenticationParamBuilder setPrefilledChallenge(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.mParam.mChallenge = str;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }

        public AuthenticationParamBuilder setPromptButton(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                this.mParam.mPromptButton = str;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }

        public AuthenticationParamBuilder setPromptDescription(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                this.mParam.mPromptDescription = str;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }

        public AuthenticationParamBuilder setPromptSubTitle(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                this.mParam.mPromptSubTitle = str;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }

        public AuthenticationParamBuilder setPromptTitle(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                this.mParam.mPromptTitle = str;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }

        public AuthenticationParamBuilder setScene(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mParam.mScene = i3;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }

        public AuthenticationParamBuilder setSoterBiometricCanceller(SoterBiometricCanceller soterBiometricCanceller) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                this.mParam.mSoterBiometricCanceller = soterBiometricCanceller;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) soterBiometricCanceller);
        }

        public AuthenticationParamBuilder setSoterBiometricStateCallback(SoterBiometricStateCallback soterBiometricStateCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                this.mParam.mSoterBiometricStateCallback = soterBiometricStateCallback;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) soterBiometricStateCallback);
        }

        @Deprecated
        public AuthenticationParamBuilder setSoterFingerprintStateCallback(SoterFingerprintStateCallback soterFingerprintStateCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.mParam.mSoterFingerprintStateCallback = soterFingerprintStateCallback;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) soterFingerprintStateCallback);
        }

        public AuthenticationParamBuilder setUseBiometricPrompt(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                this.mParam.mUseBiometricPrompt = z16;
                return this;
            }
            return (AuthenticationParamBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
    }

    /* synthetic */ AuthenticationParam(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) anonymousClass1);
    }

    public int getBiometricType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mBiometricType;
    }

    public String getChallenge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mChallenge;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mContext;
    }

    public SoterFingerprintCanceller getFingerprintCanceller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SoterFingerprintCanceller) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mFingerprintCanceller;
    }

    public IWrapGetChallengeStr getIWrapGetChallengeStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IWrapGetChallengeStr) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mIWrapGetChallengeStr;
    }

    public IWrapUploadSignature getIWrapUploadSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IWrapUploadSignature) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mIWrapUploadSignature;
    }

    public String getPromptButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mPromptButton;
    }

    public String getPromptDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mPromptDescription;
    }

    public String getPromptSubTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mPromptSubTitle;
    }

    public String getPromptTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mPromptTitle;
    }

    public int getScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mScene;
    }

    public SoterBiometricCanceller getSoterBiometricCanceller() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SoterBiometricCanceller) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mSoterBiometricCanceller;
    }

    public SoterBiometricStateCallback getSoterBiometricStateCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SoterBiometricStateCallback) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mSoterBiometricStateCallback;
    }

    public SoterFingerprintStateCallback getSoterFingerprintStateCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SoterFingerprintStateCallback) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mSoterFingerprintStateCallback;
    }

    public boolean getUseBiometricPrompt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mUseBiometricPrompt;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.mChallenge + "', mIWrapGetChallengeStr=" + this.mIWrapGetChallengeStr + ", mIWrapUploadSignature=" + this.mIWrapUploadSignature + ", mContext=" + this.mContext + ", mBiometricType=" + this.mBiometricType + '}';
    }

    AuthenticationParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
