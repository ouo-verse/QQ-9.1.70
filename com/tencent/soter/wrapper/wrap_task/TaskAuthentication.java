package com.tencent.soter.wrapper.wrap_task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.fingerprint.FingerprintManagerCompat;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.RemoveASKStrategy;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintCanceller;
import com.tencent.soter.wrapper.wrap_fingerprint.SoterFingerprintStateCallback;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapGetChallengeStr;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadSignature;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class TaskAuthentication extends BaseSoterTask implements AuthCancellationCallable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.TaskAuthentication";
    private String mAuthKeyName;
    private AuthenticationCallbackImpl mAuthenticationCallbackIml;
    private String mChallenge;
    private WeakReference<Context> mContextWeakReference;
    private SoterSignatureResult mFinalResult;
    private SoterFingerprintCanceller mFingerprintCancelSignal;
    private SoterFingerprintStateCallback mFingerprintStateCallback;
    private IWrapGetChallengeStr mGetChallengeStrWrapper;
    private boolean mIsAuthenticationAlreadyCancelled;
    private int mScene;
    private boolean mShouldOperateCompatWhenDone;
    private boolean mShouldOperateCompatWhenHint;
    private IWrapUploadSignature mUploadSignatureWrapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class AuthenticationCallbackImpl extends FingerprintManagerCompat.AuthenticationCallback {
        static IPatchRedirector $redirector_ = null;
        private static final long MAGIC_CANCELLATION_WAIT = 1000;
        private Signature mSignatureToAuth;
        private long session;

        /* synthetic */ AuthenticationCallbackImpl(TaskAuthentication taskAuthentication, Signature signature, AnonymousClass1 anonymousClass1) {
            this(signature);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, this, taskAuthentication, signature, anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String charSequenceToStringNullAsNil(CharSequence charSequence) {
            if (charSequence == null) {
                return "unknown error";
            }
            return charSequence.toString();
        }

        @SuppressLint({"NewApi"})
        private void compatLogicWhenDone() {
            if (TaskAuthentication.this.mShouldOperateCompatWhenDone) {
                TaskAuthentication.this.mFingerprintCancelSignal.asyncCancelFingerprintAuthenticationInnerImp(false);
                TaskAuthentication.this.mIsAuthenticationAlreadyCancelled = true;
            }
        }

        @SuppressLint({"NewApi"})
        private void compatLogicWhenFail() {
            if (TaskAuthentication.this.mShouldOperateCompatWhenHint) {
                SLogger.i(TaskAuthentication.TAG, "soter: should compat lower android version logic.", new Object[0]);
                TaskAuthentication.this.mFingerprintCancelSignal.asyncCancelFingerprintAuthenticationInnerImp(false);
                SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.7
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
                            TaskAuthentication.this.mFingerprintCancelSignal.refreshCancellationSignal();
                        }
                    }
                });
                SoterTaskThread.getInstance().postToWorkerDelayed(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.8
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
                            TaskAuthentication.this.performStartFingerprintLogic(authenticationCallbackImpl.mSignatureToAuth);
                        }
                    }
                }, 1000L);
            }
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.AuthenticationCallback
        public void onAuthenticationCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            SLogger.i(TaskAuthentication.TAG, "soter: called onAuthenticationCancelled", new Object[0]);
            if (TaskAuthentication.this.mIsAuthenticationAlreadyCancelled) {
                SLogger.v(TaskAuthentication.TAG, "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.onAuthenticationCancelled();
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.6
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
                    } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                        TaskAuthentication.this.mFingerprintStateCallback.onAuthenticationCancelled();
                    }
                }
            });
            TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1020, "user cancelled authentication"));
            compatLogicWhenDone();
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.AuthenticationCallback
        public void onAuthenticationError(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) charSequence);
                return;
            }
            SLogger.e(TaskAuthentication.TAG, "soter: on authentication fatal error: %d, %s", Integer.valueOf(i3), charSequence);
            if (i3 != 10308) {
                SoterTaskThread.getInstance().postToMainThread(new Runnable(i3, charSequence) { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.1
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
                        } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                            TaskAuthentication.this.mFingerprintStateCallback.onAuthenticationError(this.val$errMsgId, this.val$errString);
                        }
                    }
                });
                TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1016, charSequenceToStringNullAsNil(charSequence)));
            } else {
                TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1021, charSequenceToStringNullAsNil(charSequence)));
            }
            compatLogicWhenDone();
            SReporter.reportError(401, "on authentication fatal error: " + i3 + " " + ((Object) charSequence));
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.AuthenticationCallback
        public void onAuthenticationFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            super.onAuthenticationFailed();
            SLogger.w(TaskAuthentication.TAG, "soter: authentication failed once", new Object[0]);
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.5
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
                    } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                        TaskAuthentication.this.mFingerprintStateCallback.onAuthenticationFailed();
                    }
                }
            });
            compatLogicWhenFail();
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.AuthenticationCallback
        public void onAuthenticationHelp(int i3, CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) charSequence);
            } else {
                SLogger.w(TaskAuthentication.TAG, "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i3), charSequence);
                SoterTaskThread.getInstance().postToMainThread(new Runnable(i3, charSequence) { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.2
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
                        } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                            TaskAuthentication.this.mFingerprintStateCallback.onAuthenticationHelp(this.val$helpMsgId, AuthenticationCallbackImpl.this.charSequenceToStringNullAsNil(this.val$helpString));
                        }
                    }
                });
            }
        }

        @Override // com.tencent.soter.core.fingerprint.FingerprintManagerCompat.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) authenticationResult);
                return;
            }
            SLogger.i(TaskAuthentication.TAG, "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.3
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
                    if (!SoterCoreUtil.isNullOrNil(TaskAuthentication.this.mChallenge)) {
                        if (SoterCore.getSoterCoreType() == 1) {
                            AuthenticationCallbackImpl authenticationCallbackImpl = AuthenticationCallbackImpl.this;
                            TaskAuthentication.this.executeWhenAuthenticatedWithSession(authenticationCallbackImpl.mSignatureToAuth, AuthenticationCallbackImpl.this.session);
                            return;
                        }
                        try {
                            AuthenticationCallbackImpl.this.mSignatureToAuth.update(TaskAuthentication.this.mChallenge.getBytes(Charset.forName("UTF-8")));
                        } catch (SignatureException e16) {
                            SLogger.e(TaskAuthentication.TAG, "soter: exception in update", new Object[0]);
                            SLogger.printErrStackTrace(TaskAuthentication.TAG, e16, "soter: exception in update");
                            SReporter.reportError(200, "TaskAuthentication, update signature fail: onAuthenticationSucceeded().", e16);
                            SLogger.e(TaskAuthentication.TAG, "soter: remove the auth key: %s", TaskAuthentication.this.mAuthKeyName);
                            SoterCore.removeAuthKey(TaskAuthentication.this.mAuthKeyName, false);
                            TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1027, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            AuthenticationCallbackImpl authenticationCallbackImpl2 = AuthenticationCallbackImpl.this;
                            TaskAuthentication.this.executeWhenAuthenticated(authenticationCallbackImpl2.mSignatureToAuth);
                            return;
                        } catch (Exception e17) {
                            SLogger.e(TaskAuthentication.TAG, "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            SLogger.printErrStackTrace(TaskAuthentication.TAG, e17, "soter: exception when execute");
                            AuthenticationCallbackImpl.this.onAuthenticationError(-1000, "execute failed");
                            return;
                        }
                    }
                    SLogger.e(TaskAuthentication.TAG, "soter: challenge is null. should not happen here", new Object[0]);
                    AuthenticationCallbackImpl.this.onAuthenticationError(-1000, "challenge is null");
                }
            });
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.AuthenticationCallbackImpl.4
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
                    } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                        TaskAuthentication.this.mFingerprintStateCallback.onAuthenticationSucceed();
                    }
                }
            });
            compatLogicWhenDone();
        }

        AuthenticationCallbackImpl(@NonNull Signature signature) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mSignatureToAuth = signature;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskAuthentication.this, (Object) signature);
            }
        }
    }

    public TaskAuthentication(AuthenticationParam authenticationParam) {
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
        this.mFingerprintCancelSignal = null;
        this.mFingerprintStateCallback = null;
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
            this.mFingerprintStateCallback = authenticationParam.getSoterFingerprintStateCallback();
            this.mFingerprintCancelSignal = authenticationParam.getFingerprintCanceller();
            this.mChallenge = authenticationParam.getChallenge();
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
            SReporter.reportError(200, "TaskAuthentication, sign fail: executeWhenAuthenticated().", e16);
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
            SReporter.reportError(200, "TaskAuthentication, sign fail: executeWhenAuthenticatedWithSession().", e16);
            callback(new SoterProcessAuthenticationResult(1018, "sign failed even after user authenticated the key."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void performStartFingerprintLogic(Signature signature) {
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
            FingerprintManagerCompat from = FingerprintManagerCompat.from(context);
            FingerprintManagerCompat.CryptoObject cryptoObject = new FingerprintManagerCompat.CryptoObject(signature);
            SoterFingerprintCanceller soterFingerprintCanceller = this.mFingerprintCancelSignal;
            if (soterFingerprintCanceller != null) {
                cancellationSignal = soterFingerprintCanceller.getSignalObj();
            } else {
                cancellationSignal = null;
            }
            from.authenticate(cryptoObject, 0, cancellationSignal, this.mAuthenticationCallbackIml, null);
        } catch (Exception e16) {
            String message = e16.getMessage();
            SLogger.e(TAG, "soter: caused exception when authenticating: %s", message);
            SLogger.printErrStackTrace(TAG, e16, "soter: caused exception when authenticating");
            SReporter.reportError(200, "TaskAuthentication, start authentication fail: performStartFingerprintLogic().", e16);
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
                performStartFingerprintLogic(null);
                SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskAuthentication.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                            TaskAuthentication.this.mFingerprintStateCallback.onStartAuthentication();
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
            performStartFingerprintLogic(authInitAndSign);
            SoterTaskThread.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskAuthentication.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (TaskAuthentication.this.mFingerprintStateCallback != null) {
                        TaskAuthentication.this.mFingerprintStateCallback.onStartAuthentication();
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
        this.mUploadSignatureWrapper.setCallback(new ISoterNetCallback<IWrapUploadSignature.UploadSignatureResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskAuthentication.this);
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
                    SLogger.i(TaskAuthentication.TAG, "soter: upload and verify succeed", new Object[0]);
                    TaskAuthentication taskAuthentication = TaskAuthentication.this;
                    taskAuthentication.callback(new SoterProcessAuthenticationResult(0, taskAuthentication.mFinalResult));
                } else {
                    SLogger.w(TaskAuthentication.TAG, "soter: upload or verify failed", new Object[0]);
                    TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1019));
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
            this.mGetChallengeStrWrapper.setCallback(new ISoterNetCallback<IWrapGetChallengeStr.GetChallengeResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskAuthentication.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskAuthentication.this);
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
                        TaskAuthentication.this.mChallenge = getChallengeResult.challenge;
                        TaskAuthentication.this.startAuthenticate();
                    } else {
                        SLogger.w(TaskAuthentication.TAG, "soter: get challenge failed", new Object[0]);
                        TaskAuthentication.this.callback(new SoterProcessAuthenticationResult(1014));
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
        SoterFingerprintCanceller soterFingerprintCanceller = this.mFingerprintCancelSignal;
        if (soterFingerprintCanceller != null) {
            soterFingerprintCanceller.asyncCancelFingerprintAuthentication();
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
        if (!FingerprintManagerCompat.from(context).hasEnrolledFingerprints()) {
            SLogger.w(TAG, "soter: user has not enrolled any fingerprint in system.", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1012));
            return true;
        }
        if (SoterCore.isCurrentFingerprintFrozen(context)) {
            SLogger.w(TAG, "soter: fingerprint sensor frozen", new Object[0]);
            callback(new SoterProcessAuthenticationResult(1021, "Too many failed times"));
            return true;
        }
        if (this.mFingerprintCancelSignal == null) {
            SLogger.w(TAG, "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
            this.mFingerprintCancelSignal = new SoterFingerprintCanceller();
            return false;
        }
        if (this.mUploadSignatureWrapper == null) {
            SLogger.w(TAG, "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
        }
        return false;
    }
}
