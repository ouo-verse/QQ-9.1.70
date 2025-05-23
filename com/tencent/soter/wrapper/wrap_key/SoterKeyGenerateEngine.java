package com.tencent.soter.wrapper.wrap_key;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_task.SoterTaskThread;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterKeyGenerateEngine {
    static IPatchRedirector $redirector_ = null;
    private static final int FLAG_GEN_ASK = 1;
    private static final int FLAG_GEN_AUTH_KEY = 2;
    private static final String TAG = "Soter.SoterKeyGenerateEngine";
    private String mAuthKeyName;
    private ISoterKeyGenerateCallback mCallback;
    private int mGenKeyFlag;
    private boolean mIsCallbacked;
    private boolean mShouldDeleteAndReGenAskIfExists;
    private boolean mShouldDeleteAndReGenAuthKeyIfExists;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SoterKeyGenerateEngineBuilder {
        static IPatchRedirector $redirector_;
        private String mAuthKeyName;
        private ISoterKeyGenerateCallback mCallback;
        private int mGenKeyFlag;
        private boolean mShouldDeleteAndReGenAskIfExists;
        private boolean mShouldDeleteAndReGenAuthKeyIfExists;

        public SoterKeyGenerateEngineBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mGenKeyFlag = 0;
            this.mAuthKeyName = "";
            this.mShouldDeleteAndReGenAskIfExists = false;
            this.mShouldDeleteAndReGenAuthKeyIfExists = false;
            this.mCallback = null;
        }

        public SoterKeyGenerateEngine build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (SoterKeyGenerateEngine) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new SoterKeyGenerateEngine(this.mGenKeyFlag, this.mAuthKeyName, this.mShouldDeleteAndReGenAskIfExists, this.mShouldDeleteAndReGenAuthKeyIfExists, this.mCallback, null);
        }

        public SoterKeyGenerateEngineBuilder markGenAppSecureKey(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoterKeyGenerateEngineBuilder) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.mGenKeyFlag |= 1;
            this.mShouldDeleteAndReGenAskIfExists = z16;
            return this;
        }

        public SoterKeyGenerateEngineBuilder markGenAuthKey(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SoterKeyGenerateEngineBuilder) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
            }
            this.mAuthKeyName = str;
            this.mShouldDeleteAndReGenAuthKeyIfExists = z16;
            this.mGenKeyFlag |= 2;
            return this;
        }

        public SoterKeyGenerateEngineBuilder setKeyGenCallback(ISoterKeyGenerateCallback iSoterKeyGenerateCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (SoterKeyGenerateEngineBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iSoterKeyGenerateCallback);
            }
            this.mCallback = iSoterKeyGenerateCallback;
            return this;
        }
    }

    /* synthetic */ SoterKeyGenerateEngine(int i3, String str, boolean z16, boolean z17, ISoterKeyGenerateCallback iSoterKeyGenerateCallback, AnonymousClass1 anonymousClass1) {
        this(i3, str, z16, z17, iSoterKeyGenerateCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Boolean.valueOf(z17), iSoterKeyGenerateCallback, anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(SoterCoreResult soterCoreResult) {
        ISoterKeyGenerateCallback iSoterKeyGenerateCallback = this.mCallback;
        if (iSoterKeyGenerateCallback != null && !this.mIsCallbacked) {
            if (soterCoreResult != null) {
                if (soterCoreResult.isSuccess()) {
                    this.mCallback.onSuccess();
                } else {
                    this.mCallback.onError(soterCoreResult.errCode, soterCoreResult.errMsg);
                }
            } else {
                iSoterKeyGenerateCallback.onError(-1, "unknown");
            }
        }
        this.mIsCallbacked = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SoterProcessKeyPreparationResult checkParams() {
        int i3 = this.mGenKeyFlag;
        if ((i3 & 1) != 1) {
            if ((i3 & 2) == 2) {
                if (SoterCoreUtil.isNullOrNil(this.mAuthKeyName)) {
                    SLogger.e(TAG, "soter: not pass auth key name", new Object[0]);
                    return new SoterProcessKeyPreparationResult(1, "auth key name not specified");
                }
            } else {
                SLogger.e(TAG, "soter: not specified purpose", new Object[0]);
                return new SoterProcessKeyPreparationResult(1001, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
            }
        }
        return new SoterProcessKeyPreparationResult(0);
    }

    public void generate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_key.SoterKeyGenerateEngine.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterKeyGenerateEngine.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SoterProcessKeyPreparationResult checkParams = SoterKeyGenerateEngine.this.checkParams();
                        if (!checkParams.isSuccess()) {
                            SoterKeyGenerateEngine.this.callback(checkParams);
                            return;
                        }
                        if (!SoterCore.isNativeSupportSoter()) {
                            SLogger.w(SoterKeyGenerateEngine.TAG, "soter: native not support soter", new Object[0]);
                            SoterKeyGenerateEngine.this.callback(new SoterProcessKeyPreparationResult(2));
                            return;
                        }
                        if ((SoterKeyGenerateEngine.this.mGenKeyFlag & 1) == 1) {
                            SLogger.d(SoterKeyGenerateEngine.TAG, "soter: require generate ask. start gen", new Object[0]);
                            if (SoterKeyGenerateEngine.this.mShouldDeleteAndReGenAskIfExists && SoterCore.hasAppGlobalSecureKey()) {
                                SLogger.d(SoterKeyGenerateEngine.TAG, "soter: request regen ask. remove former one", new Object[0]);
                                SoterCoreResult removeAppGlobalSecureKey = SoterCore.removeAppGlobalSecureKey();
                                if (!removeAppGlobalSecureKey.isSuccess()) {
                                    SLogger.w(SoterKeyGenerateEngine.TAG, "soter: remove ask failed: %s", removeAppGlobalSecureKey.errMsg);
                                    SoterKeyGenerateEngine.this.callback(removeAppGlobalSecureKey);
                                    return;
                                }
                            }
                            SoterCoreResult generateAppGlobalSecureKey = SoterCore.generateAppGlobalSecureKey();
                            if (!generateAppGlobalSecureKey.isSuccess()) {
                                SLogger.w(SoterKeyGenerateEngine.TAG, "soter: generate ask failed: %s", generateAppGlobalSecureKey.errMsg);
                                SoterCore.removeAppGlobalSecureKey();
                                SoterKeyGenerateEngine.this.callback(generateAppGlobalSecureKey);
                                return;
                            }
                            SLogger.i(SoterKeyGenerateEngine.TAG, "soter: generate ask success!", new Object[0]);
                            SoterKeyGenerateEngine.this.callback(generateAppGlobalSecureKey);
                        }
                        if ((SoterKeyGenerateEngine.this.mGenKeyFlag & 2) == 2) {
                            SLogger.d(SoterKeyGenerateEngine.TAG, "soter: require generate auth key. start gen: %s", SoterKeyGenerateEngine.this.mAuthKeyName);
                            if (!SoterCore.isAppGlobalSecureKeyValid()) {
                                SLogger.w(SoterKeyGenerateEngine.TAG, "soter: no ask.", new Object[0]);
                                SoterKeyGenerateEngine.this.callback(new SoterProcessKeyPreparationResult(3, "ASK not exists when generate auth key"));
                                return;
                            }
                            if (SoterKeyGenerateEngine.this.mShouldDeleteAndReGenAuthKeyIfExists && SoterCore.hasAuthKey(SoterKeyGenerateEngine.this.mAuthKeyName)) {
                                SLogger.d(SoterKeyGenerateEngine.TAG, "soter: request regen auth key. remove former one", new Object[0]);
                                SoterCoreResult removeAuthKey = SoterCore.removeAuthKey(SoterKeyGenerateEngine.this.mAuthKeyName, false);
                                if (!removeAuthKey.isSuccess()) {
                                    SLogger.w(SoterKeyGenerateEngine.TAG, "soter: remove auth key %s, failed: %s", SoterKeyGenerateEngine.this.mAuthKeyName, removeAuthKey.errMsg);
                                    SoterKeyGenerateEngine.this.callback(removeAuthKey);
                                    return;
                                }
                            }
                            SoterCoreResult generateAuthKey = SoterCore.generateAuthKey(SoterKeyGenerateEngine.this.mAuthKeyName);
                            if (!generateAuthKey.isSuccess()) {
                                SLogger.w(SoterKeyGenerateEngine.TAG, "soter: generate auth key %s failed: %s", SoterKeyGenerateEngine.this.mAuthKeyName, generateAuthKey.errMsg);
                                SoterCore.removeAuthKey(SoterKeyGenerateEngine.this.mAuthKeyName, true);
                                SoterKeyGenerateEngine.this.callback(generateAuthKey);
                                return;
                            } else {
                                SLogger.i(SoterKeyGenerateEngine.TAG, "soter: generate auth key success!", new Object[0]);
                                SoterKeyGenerateEngine.this.callback(generateAuthKey);
                                return;
                            }
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    SoterKeyGenerateEngine(int i3, String str, boolean z16, boolean z17, ISoterKeyGenerateCallback iSoterKeyGenerateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Boolean.valueOf(z17), iSoterKeyGenerateCallback);
            return;
        }
        this.mIsCallbacked = false;
        this.mGenKeyFlag = i3;
        this.mAuthKeyName = str;
        this.mShouldDeleteAndReGenAskIfExists = z16;
        this.mShouldDeleteAndReGenAuthKeyIfExists = z17;
        this.mCallback = iSoterKeyGenerateCallback;
    }
}
