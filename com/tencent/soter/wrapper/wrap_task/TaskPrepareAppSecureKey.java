package com.tencent.soter.wrapper.wrap_task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreData;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback;
import com.tencent.soter.wrapper.wrap_key.SoterKeyGenerateEngine;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadKeyNet;

/* loaded from: classes25.dex */
public class TaskPrepareAppSecureKey extends BaseSoterPrepareKeyTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.TaskPrepareAppSecureKey";
    private IWrapUploadKeyNet mAppSecureKeyNetWrapper;
    private boolean mIsAutoDeleteWhenAlreadyGenerated;

    public TaskPrepareAppSecureKey(IWrapUploadKeyNet iWrapUploadKeyNet, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iWrapUploadKeyNet, Boolean.valueOf(z16));
        } else {
            this.mAppSecureKeyNetWrapper = iWrapUploadKeyNet;
            this.mIsAutoDeleteWhenAlreadyGenerated = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadASKAfterGenerate() {
        SoterPubKeyModel appGlobalSecureKeyModel = SoterCore.getAppGlobalSecureKeyModel();
        if (appGlobalSecureKeyModel == null) {
            SLogger.e(TAG, "soter: ask model is null even after generation. fatal error", new Object[0]);
            SoterCore.removeAppGlobalSecureKey();
            callback(new SoterProcessKeyPreparationResult(3, "ask model is null even after generation."));
            return;
        }
        IWrapUploadKeyNet iWrapUploadKeyNet = this.mAppSecureKeyNetWrapper;
        if (iWrapUploadKeyNet != null) {
            iWrapUploadKeyNet.setRequest(new IWrapUploadKeyNet.UploadRequest(appGlobalSecureKeyModel.getSignature(), appGlobalSecureKeyModel.getRawJson()));
            this.mAppSecureKeyNetWrapper.setCallback(new ISoterNetCallback<IWrapUploadKeyNet.UploadResult>(appGlobalSecureKeyModel) { // from class: com.tencent.soter.wrapper.wrap_task.TaskPrepareAppSecureKey.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SoterPubKeyModel val$askModel;

                {
                    this.val$askModel = appGlobalSecureKeyModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskPrepareAppSecureKey.this, (Object) appGlobalSecureKeyModel);
                    }
                }

                @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetCallback
                public void onNetEnd(IWrapUploadKeyNet.UploadResult uploadResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadResult);
                        return;
                    }
                    TaskPrepareAppSecureKey.this.markKeyStatus(SoterCoreData.getInstance().getAskName(), 0);
                    boolean z16 = uploadResult.mIsUploadAndVerifiedSuccess;
                    SLogger.i(TaskPrepareAppSecureKey.TAG, "soter: ask upload result: %b", Boolean.valueOf(z16));
                    if (z16) {
                        TaskPrepareAppSecureKey.this.callback(new SoterProcessKeyPreparationResult(0, this.val$askModel));
                    } else {
                        SoterCore.removeAppGlobalSecureKey();
                        TaskPrepareAppSecureKey.this.callback(new SoterProcessKeyPreparationResult(1003, "upload app secure key failed"));
                    }
                }
            });
            this.mAppSecureKeyNetWrapper.execute();
        } else {
            SLogger.d(TAG, "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(0, "treat as normal because you do not provide the net wrapper", appGlobalSecureKeyModel));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void execute() {
        markKeyStatus(SoterCoreData.getInstance().getAskName(), 1);
        new SoterKeyGenerateEngine.SoterKeyGenerateEngineBuilder().markGenAppSecureKey(this.mIsAutoDeleteWhenAlreadyGenerated).setKeyGenCallback(new ISoterKeyGenerateCallback() { // from class: com.tencent.soter.wrapper.wrap_task.TaskPrepareAppSecureKey.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskPrepareAppSecureKey.this);
                }
            }

            @Override // com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback
            public void onError(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                SLogger.w(TaskPrepareAppSecureKey.TAG, "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i3), str);
                TaskPrepareAppSecureKey.this.markKeyStatus(SoterCoreData.getInstance().getAskName(), 0);
                TaskPrepareAppSecureKey.this.callback(new SoterProcessKeyPreparationResult(i3, str));
            }

            @Override // com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                SLogger.i(TaskPrepareAppSecureKey.TAG, "soter: app secure key generate successfully. start upload ask", new Object[0]);
                if (TaskPrepareAppSecureKey.this.mAppSecureKeyNetWrapper != null) {
                    TaskPrepareAppSecureKey.this.markKeyStatus(SoterCoreData.getInstance().getAskName(), 2);
                } else {
                    TaskPrepareAppSecureKey.this.markKeyStatus(SoterCoreData.getInstance().getAskName(), 0);
                }
                TaskPrepareAppSecureKey.this.startUploadASKAfterGenerate();
            }
        }).build().generate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean isSingleInstance() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void onRemovedFromTaskPoolActively() {
        SLogger.w(TAG, "soter: cancelled prepare ask", new Object[0]);
        SoterCore.removeAppGlobalSecureKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean preExecute() {
        if (!SoterDataCenter.getInstance().isInit()) {
            SLogger.w(TAG, "soter: not initialized yet", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(1008));
            return true;
        }
        if (!SoterDataCenter.getInstance().isSupportSoter()) {
            SLogger.w(TAG, "soter: not support soter", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(2));
            return true;
        }
        if (SoterCore.isAppGlobalSecureKeyValid() && !this.mIsAutoDeleteWhenAlreadyGenerated) {
            SLogger.i(TAG, "soter: already has ask. do not need generate again", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(0, SoterCore.getAppGlobalSecureKeyModel()));
            return true;
        }
        if (this.mAppSecureKeyNetWrapper == null) {
            SLogger.w(TAG, "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
        }
        return false;
    }
}
