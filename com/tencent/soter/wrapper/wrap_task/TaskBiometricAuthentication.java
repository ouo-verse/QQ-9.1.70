package com.tencent.soter.wrapper.wrap_task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricCanceller;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.RemoveASKStrategy;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapGetChallengeStr;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadSignature;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TaskBiometricAuthentication extends BaseSoterTask implements AuthCancellationCallable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.TaskBiometricAuthentication";
    private String mAuthKeyName;
    private AuthenticationCallbackImpl mAuthenticationCallbackIml;
    private SoterBiometricCanceller mBiometricCancelSignal;
    private SoterBiometricStateCallback mBiometricStateCallback;
    private int mBiometricType;
    private String mChallenge;
    private WeakReference<Context> mContextWeakReference;
    private SoterSignatureResult mFinalResult;
    private IWrapGetChallengeStr mGetChallengeStrWrapper;
    private boolean mIsAuthenticationAlreadyCancelled;
    private String mPromptButton;
    private String mPromptDescription;
    private String mPromptSubTitle;
    private String mPromptTitle;
    private int mScene;
    private boolean mShouldOperateCompatWhenDone;
    private boolean mShouldOperateCompatWhenHint;
    private IWrapUploadSignature mUploadSignatureWrapper;
    private boolean mUseBiometricPrompt;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class AuthenticationCallbackImpl extends BiometricManagerCompat.AuthenticationCallback {
        static IPatchRedirector $redirector_ = null;
        private static final long MAGIC_CANCELLATION_WAIT = 1000;
        private Signature mSignatureToAuth;
        private long session;

        /* synthetic */ AuthenticationCallbackImpl(TaskBiometricAuthentication taskBiometricAuthentication, Signature signature, AnonymousClass1 anonymousClass1) {
            this(signature);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, this, taskBiometricAuthentication, signature, anonymousClass1);
        }

        @SuppressLint({"NewApi"})
        private void authenticationMaybeContinue() {
            if (TaskBiometricAuthentication.this.mShouldOperateCompatWhenHint) {
                SLogger.i(TaskBiometricAuthentication.TAG, "soter: should compat lower android version logic.", new Object[0]);
                TaskBiometricAuthentication.this.mBiometricCancelSignal.asyncCancelBiometricAuthenticationInnerImp(false);
                SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            TaskBiometricAuthentication.this.mBiometricCancelSignal.refreshCancellationSignal();
                        }
                    }
                });
                SoterTaskThread.getInstance().postToWorkerDelayed(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            AuthenticationCallbackImpl authenticationCallbackImpl = AuthenticationCallbackImpl.this;
                            TaskBiometricAuthentication.this.performStartBiometricLogic(authenticationCallbackImpl.mSignatureToAuth);
                        }
                    }
                }, 1000L);
            }
            if (TaskBiometricAuthentication.this.mBiometricType == 2) {
                SLogger.i(TaskBiometricAuthentication.TAG, "soter: should compat faceid logic.", new Object[0]);
                TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1017, "faceid not match"));
            }
        }

        @SuppressLint({"NewApi"})
        private void authenticationShouldComplete() {
            if (TaskBiometricAuthentication.this.mShouldOperateCompatWhenDone || TaskBiometricAuthentication.this.mBiometricType == 2) {
                TaskBiometricAuthentication.this.mBiometricCancelSignal.asyncCancelBiometricAuthenticationInnerImp(false);
                TaskBiometricAuthentication.this.mIsAuthenticationAlreadyCancelled = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String charSequenceToStringNullAsNil(CharSequence charSequence) {
            if (charSequence == null) {
                return "unknown error";
            }
            return charSequence.toString();
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public void onAuthenticationCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            SLogger.i(TaskBiometricAuthentication.TAG, "soter: called onAuthenticationCancelled", new Object[0]);
            if (TaskBiometricAuthentication.this.mIsAuthenticationAlreadyCancelled) {
                SLogger.v(TaskBiometricAuthentication.TAG, "soter: during ignore cancel period", new Object[0]);
                return;
            }
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                        TaskBiometricAuthentication.this.mBiometricStateCallback.onAuthenticationCancelled();
                    }
                }
            });
            TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1020, "user cancelled authentication"));
            authenticationShouldComplete();
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public void onAuthenticationError(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                return;
            }
            SLogger.e(TaskBiometricAuthentication.TAG, "soter: on authentication fatal error: %d, %s", Integer.valueOf(i3), charSequence);
            SoterTaskThread.getInstance().postToMainThread(new Runnable(i3, charSequence) { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$errMsgId;
                final /* synthetic */ CharSequence val$errString;

                {
                    this.val$errMsgId = i3;
                    this.val$errString = charSequence;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AuthenticationCallbackImpl.this, Integer.valueOf(i3), charSequence);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                        TaskBiometricAuthentication.this.mBiometricStateCallback.onAuthenticationError(this.val$errMsgId, this.val$errString);
                    }
                }
            });
            if (i3 == 10308) {
                TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1022, charSequenceToStringNullAsNil(charSequence)));
            } else if (i3 == 10309) {
                TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1022, charSequenceToStringNullAsNil(charSequence)));
            } else if (i3 == 10310) {
                TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1029, charSequenceToStringNullAsNil(charSequence)));
            } else {
                TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1017, charSequenceToStringNullAsNil(charSequence)));
            }
            authenticationShouldComplete();
            SReporter.reportError(401, "on authentication fatal error: " + i3 + " " + ((Object) charSequence));
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public void onAuthenticationFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            SLogger.w(TaskBiometricAuthentication.TAG, "soter: authentication failed once", new Object[0]);
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                        TaskBiometricAuthentication.this.mBiometricStateCallback.onAuthenticationFailed();
                    }
                }
            });
            authenticationMaybeContinue();
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
            } else {
                SLogger.w(TaskBiometricAuthentication.TAG, "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i3), charSequence);
                SoterTaskThread.getInstance().postToMainThread(new Runnable(i3, charSequence) { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$helpMsgId;
                    final /* synthetic */ CharSequence val$helpString;

                    {
                        this.val$helpMsgId = i3;
                        this.val$helpString = charSequence;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AuthenticationCallbackImpl.this, Integer.valueOf(i3), charSequence);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                            TaskBiometricAuthentication.this.mBiometricStateCallback.onAuthenticationHelp(this.val$helpMsgId, AuthenticationCallbackImpl.this.charSequenceToStringNullAsNil(this.val$helpString));
                        }
                    }
                });
            }
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult authenticationResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                return;
            }
            SLogger.i(TaskBiometricAuthentication.TAG, "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                        TaskBiometricAuthentication.this.mBiometricStateCallback.onAuthenticationSucceed();
                    }
                }
            });
            SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.AuthenticationCallbackImpl.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AuthenticationCallbackImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!SoterCoreUtil.isNullOrNil(TaskBiometricAuthentication.this.mChallenge)) {
                        if (SoterCore.getSoterCoreType() == 1) {
                            AuthenticationCallbackImpl authenticationCallbackImpl = AuthenticationCallbackImpl.this;
                            TaskBiometricAuthentication.this.executeWhenAuthenticatedWithSession(authenticationCallbackImpl.mSignatureToAuth, AuthenticationCallbackImpl.this.session);
                            return;
                        }
                        try {
                            AuthenticationCallbackImpl.this.mSignatureToAuth.update(TaskBiometricAuthentication.this.mChallenge.getBytes(Charset.forName("UTF-8")));
                        } catch (Exception e16) {
                            SLogger.e(TaskBiometricAuthentication.TAG, "soter: exception in update", new Object[0]);
                            SLogger.printErrStackTrace(TaskBiometricAuthentication.TAG, e16, "soter: exception in update");
                            SReporter.reportError(200, "TaskBiometric, update signature failed: onAuthenticationSucceeded().", e16);
                            SLogger.e(TaskBiometricAuthentication.TAG, "soter: remove the auth key: %s", TaskBiometricAuthentication.this.mAuthKeyName);
                            SoterCore.removeAuthKey(TaskBiometricAuthentication.this.mAuthKeyName, false);
                            TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1027, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            AuthenticationCallbackImpl authenticationCallbackImpl2 = AuthenticationCallbackImpl.this;
                            TaskBiometricAuthentication.this.executeWhenAuthenticated(authenticationCallbackImpl2.mSignatureToAuth);
                            return;
                        } catch (Exception e17) {
                            SLogger.e(TaskBiometricAuthentication.TAG, "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            SLogger.printErrStackTrace(TaskBiometricAuthentication.TAG, e17, "soter: exception when execute");
                            AuthenticationCallbackImpl.this.onAuthenticationError(-1000, "execute failed");
                            return;
                        }
                    }
                    SLogger.e(TaskBiometricAuthentication.TAG, "soter: challenge is null. should not happen here", new Object[0]);
                    AuthenticationCallbackImpl.this.onAuthenticationError(-1000, "challenge is null");
                }
            });
            authenticationShouldComplete();
        }

        AuthenticationCallbackImpl(@NonNull Signature signature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mSignatureToAuth = signature;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskBiometricAuthentication.this, (Object) signature);
            }
        }
    }

    public TaskBiometricAuthentication(AuthenticationParam authenticationParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authenticationParam);
            return;
        }
        this.mScene = -1;
        this.mAuthKeyName = null;
        this.mChallenge = null;
        this.mGetChallengeStrWrapper = null;
        this.mUploadSignatureWrapper = null;
        this.mContextWeakReference = null;
        this.mBiometricCancelSignal = null;
        this.mBiometricStateCallback = null;
        this.mFinalResult = null;
        this.mAuthenticationCallbackIml = null;
        this.mShouldOperateCompatWhenHint = false;
        this.mShouldOperateCompatWhenDone = false;
        this.mIsAuthenticationAlreadyCancelled = false;
        if (authenticationParam != null) {
            this.mScene = authenticationParam.getScene();
            this.mGetChallengeStrWrapper = authenticationParam.getIWrapGetChallengeStr();
            this.mUploadSignatureWrapper = authenticationParam.getIWrapUploadSignature();
            this.mContextWeakReference = new WeakReference<>(authenticationParam.getContext());
            this.mBiometricStateCallback = authenticationParam.getSoterBiometricStateCallback();
            this.mBiometricCancelSignal = authenticationParam.getSoterBiometricCanceller();
            this.mBiometricType = authenticationParam.getBiometricType();
            this.mChallenge = authenticationParam.getChallenge();
            this.mPromptTitle = authenticationParam.getPromptTitle();
            this.mPromptSubTitle = authenticationParam.getPromptSubTitle();
            this.mPromptDescription = authenticationParam.getPromptDescription();
            this.mPromptButton = authenticationParam.getPromptButton();
            this.mUseBiometricPrompt = authenticationParam.getUseBiometricPrompt();
            return;
        }
        throw new IllegalArgumentException("param is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeWhenAuthenticated(@NonNull Signature signature) {
        try {
            this.mFinalResult = SoterCore.convertFromBytesToSignatureResult(signature.sign());
            if (this.mUploadSignatureWrapper != null) {
                uploadSignature();
            } else {
                SLogger.i(TAG, "soter: no upload wrapper, return directly", new Object[0]);
                callback(new SoterProcessAuthenticationResult(0, this.mFinalResult));
            }
        } catch (SignatureException e16) {
            SLogger.e(TAG, "soter: sign failed due to exception: %s", e16.getMessage());
            SLogger.printErrStackTrace(TAG, e16, "soter: sign failed due to exception");
            SReporter.reportError(200, "TaskBiometric, sign failed: executeWhenAuthenticated().", e16);
            callback(new SoterProcessAuthenticationResult(1018, "sign failed even after user authenticated the key."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeWhenAuthenticatedWithSession(@NonNull Signature signature, long j3) {
        try {
            this.mFinalResult = SoterCore.convertFromBytesToSignatureResult(SoterCore.finishSign(j3));
            if (this.mUploadSignatureWrapper != null) {
                uploadSignature();
            } else {
                SLogger.i(TAG, "soter: no upload wrapper, return directly", new Object[0]);
                callback(new SoterProcessAuthenticationResult(0, this.mFinalResult));
            }
        } catch (Exception e16) {
            SLogger.e(TAG, "soter: finish sign failed due to exception: %s", e16.getMessage());
            SLogger.printErrStackTrace(TAG, e16, "soter: sign failed due to exception");
            SReporter.reportError(200, "TaskBiometric, sign failed: executeWhenAuthenticatedWithSession().", e16);
            callback(new SoterProcessAuthenticationResult(1018, "sign failed even after user authenticated the key."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void performStartBiometricLogic(Signature signature) {
        CancellationSignal cancellationSignal;
        if (isFinished()) {
            SLogger.w(TAG, "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = this.mContextWeakReference.get();
        if (context == null) {
            SLogger.w(TAG, "soter: context instance released in startAuthenticate", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1011));
            return;
        }
        try {
            SLogger.v(TAG, "soter: performing start", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("prompt_title", this.mPromptTitle);
            bundle.putString("prompt_subtitle", this.mPromptSubTitle);
            bundle.putString("prompt_description", this.mPromptDescription);
            bundle.putString("prompt_button", this.mPromptButton);
            bundle.putBoolean("use_biometric_prompt", this.mUseBiometricPrompt);
            BiometricManagerCompat from = BiometricManagerCompat.from(context, Integer.valueOf(this.mBiometricType));
            BiometricManagerCompat.CryptoObject cryptoObject = new BiometricManagerCompat.CryptoObject(signature);
            SoterBiometricCanceller soterBiometricCanceller = this.mBiometricCancelSignal;
            if (soterBiometricCanceller != null) {
                cancellationSignal = soterBiometricCanceller.getSignalObj();
            } else {
                cancellationSignal = null;
            }
            from.authenticate(cryptoObject, 0, cancellationSignal, this.mAuthenticationCallbackIml, null, bundle);
        } catch (Exception e16) {
            String message = e16.getMessage();
            SLogger.e(TAG, "soter: caused exception when authenticating: %s", message);
            SLogger.printErrStackTrace(TAG, e16, "soter: caused exception when authenticating");
            SReporter.reportError(200, "TaskBiometric, start authentication failed: performStartBiometricLogic().", e16);
            callback(new SoterProcessAuthenticationResult(1015, String.format("start authentication failed due to %s", message)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public void startAuthenticate() {
        Signature signature = null;
        byte b16 = 0;
        byte b17 = 0;
        if (SoterCore.getSoterCoreType() == 1) {
            SoterSessionResult initSigh = SoterCore.initSigh(this.mAuthKeyName, this.mChallenge);
            if (initSigh == null) {
                SLogger.w(TAG, "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                callback(new SoterProcessAuthenticationResult(1007));
                return;
            } else {
                if (initSigh.resultCode != 0) {
                    SLogger.w(TAG, "soter: error occurred when init sign resultCode error", new Object[0]);
                    callback(new SoterProcessAuthenticationResult(1007));
                    return;
                }
                SLogger.d(TAG, "soter: session is %d", Long.valueOf(initSigh.session));
                AuthenticationCallbackImpl authenticationCallbackImpl = new AuthenticationCallbackImpl(this, signature, b17 == true ? 1 : 0);
                this.mAuthenticationCallbackIml = authenticationCallbackImpl;
                authenticationCallbackImpl.session = initSigh.session;
                performStartBiometricLogic(null);
                SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskBiometricAuthentication.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                            TaskBiometricAuthentication.this.mBiometricStateCallback.onStartAuthentication();
                        }
                    }
                });
                return;
            }
        }
        Signature authInitAndSign = SoterCore.getAuthInitAndSign(this.mAuthKeyName);
        if (authInitAndSign == null) {
            SLogger.w(TAG, "soter: error occurred when init sign", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1007));
        } else {
            this.mAuthenticationCallbackIml = new AuthenticationCallbackImpl(this, authInitAndSign, b16 == true ? 1 : 0);
            performStartBiometricLogic(authInitAndSign);
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskBiometricAuthentication.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (TaskBiometricAuthentication.this.mBiometricStateCallback != null) {
                        TaskBiometricAuthentication.this.mBiometricStateCallback.onStartAuthentication();
                    }
                }
            });
        }
    }

    private void uploadSignature() {
        SoterSignatureResult soterSignatureResult = this.mFinalResult;
        if (soterSignatureResult == null) {
            callback(new SoterProcessAuthenticationResult(1018, "sign failed even after user authenticated the key."));
            return;
        }
        this.mUploadSignatureWrapper.setRequest(new IWrapUploadSignature.UploadSignatureRequest(soterSignatureResult.getSignature(), this.mFinalResult.getJsonValue(), this.mFinalResult.getSaltLen()));
        this.mUploadSignatureWrapper.setCallback(new ISoterNetCallback<IWrapUploadSignature.UploadSignatureResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskBiometricAuthentication.this);
                }
            }

            @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetCallback
            public void onNetEnd(IWrapUploadSignature.UploadSignatureResult uploadSignatureResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadSignatureResult);
                    return;
                }
                if (uploadSignatureResult != null && uploadSignatureResult.isVerified) {
                    SLogger.i(TaskBiometricAuthentication.TAG, "soter: upload and verify succeed", new Object[0]);
                    TaskBiometricAuthentication taskBiometricAuthentication = TaskBiometricAuthentication.this;
                    taskBiometricAuthentication.callback(new SoterProcessAuthenticationResult(0, taskBiometricAuthentication.mFinalResult));
                } else {
                    SLogger.w(TaskBiometricAuthentication.TAG, "soter: upload or verify failed", new Object[0]);
                    TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1019));
                }
            }
        });
        this.mUploadSignatureWrapper.execute();
    }

    @Override // com.tencent.soter.wrapper.wrap_task.AuthCancellationCallable
    public void callCancellationInternal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SLogger.i(TAG, "soter: called from cancellation signal", new Object[0]);
        AuthenticationCallbackImpl authenticationCallbackImpl = this.mAuthenticationCallbackIml;
        if (authenticationCallbackImpl != null) {
            authenticationCallbackImpl.onAuthenticationCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    @RequiresApi(api = 16)
    public void execute() {
        if (SoterCoreUtil.isNullOrNil(this.mChallenge)) {
            SLogger.i(TAG, "soter: not provide the challenge. we will do the job", new Object[0]);
            this.mGetChallengeStrWrapper.setRequest(new IWrapGetChallengeStr.GetChallengeRequest());
            this.mGetChallengeStrWrapper.setCallback(new ISoterNetCallback<IWrapGetChallengeStr.GetChallengeResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskBiometricAuthentication.this);
                    }
                }

                @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetCallback
                public void onNetEnd(IWrapGetChallengeStr.GetChallengeResult getChallengeResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) getChallengeResult);
                        return;
                    }
                    if (getChallengeResult != null && !SoterCoreUtil.isNullOrNil(getChallengeResult.challenge)) {
                        TaskBiometricAuthentication.this.mChallenge = getChallengeResult.challenge;
                        TaskBiometricAuthentication.this.startAuthenticate();
                    } else {
                        SLogger.w(TaskBiometricAuthentication.TAG, "soter: get challenge failed", new Object[0]);
                        TaskBiometricAuthentication.this.callback(new SoterProcessAuthenticationResult(1014));
                    }
                }
            });
            this.mGetChallengeStrWrapper.execute();
            return;
        }
        SLogger.i(TAG, "soter: already provided the challenge. directly authenticate", new Object[0]);
        startAuthenticate();
    }

    @Override // com.tencent.soter.wrapper.wrap_task.AuthCancellationCallable
    public boolean isCancelled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsAuthenticationAlreadyCancelled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean isSingleInstance() {
        return true;
    }

    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    void onExecuteCallback(SoterProcessResultBase soterProcessResultBase) {
        if ((soterProcessResultBase.getErrCode() == 1018 || soterProcessResultBase.getErrCode() == 1007 || soterProcessResultBase.getErrCode() == 1015) && RemoveASKStrategy.shouldRemoveAllKey(getClass(), soterProcessResultBase)) {
            SLogger.i(TAG, "soter: same error happen too much, delete ask", new Object[0]);
            SoterWrapperApi.clearAllKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    @RequiresApi(api = 16)
    public void onRemovedFromTaskPoolActively() {
        SoterBiometricCanceller soterBiometricCanceller = this.mBiometricCancelSignal;
        if (soterBiometricCanceller != null) {
            soterBiometricCanceller.asyncCancelBiometricAuthentication();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    @SuppressLint({"DefaultLocale", "NewApi"})
    public boolean preExecute() {
        if (!SoterDataCenter.getInstance().isInit()) {
            SLogger.w(TAG, "soter: not initialized yet", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1008));
            return true;
        }
        if (!SoterDataCenter.getInstance().isSupportSoter()) {
            SLogger.w(TAG, "soter: not support soter", new Object[0]);
            callback(new SoterProcessAuthenticationResult(2));
            return true;
        }
        String str = SoterDataCenter.getInstance().getAuthKeyNames().get(this.mScene, "");
        this.mAuthKeyName = str;
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.w(TAG, "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.mScene))));
            return true;
        }
        if (!SoterCore.hasAuthKey(this.mAuthKeyName)) {
            SLogger.w(TAG, "soter: auth key %s not exists. need re-generate", this.mAuthKeyName);
            callback(new SoterProcessAuthenticationResult(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", Integer.valueOf(this.mScene))));
            return true;
        }
        if (this.mGetChallengeStrWrapper == null && SoterCoreUtil.isNullOrNil(this.mChallenge)) {
            SLogger.w(TAG, "soter: challenge wrapper is null!", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
            return true;
        }
        Context context = this.mContextWeakReference.get();
        if (context == null) {
            SLogger.w(TAG, "soter: context instance released in preExecute", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1011));
            return true;
        }
        if (!BiometricManagerCompat.from(context, Integer.valueOf(this.mBiometricType)).hasEnrolledBiometric()) {
            SLogger.w(TAG, "soter: user has not enrolled any biometric in system.", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1013));
            return true;
        }
        if (SoterCore.isCurrentBiometricFrozen(context, this.mBiometricType)) {
            SLogger.w(TAG, "soter: biometric sensor frozen", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1021, "Too many failed times"));
            return true;
        }
        if (this.mBiometricCancelSignal == null) {
            SLogger.w(TAG, "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
            this.mBiometricCancelSignal = new SoterBiometricCanceller();
            return false;
        }
        if (this.mUploadSignatureWrapper == null) {
            SLogger.w(TAG, "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
        }
        return false;
    }
}
