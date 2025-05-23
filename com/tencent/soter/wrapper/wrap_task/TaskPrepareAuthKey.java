package com.tencent.soter.wrapper.wrap_task;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback;
import com.tencent.soter.wrapper.wrap_key.SoterKeyGenerateEngine;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadKeyNet;

/* loaded from: classes25.dex */
public class TaskPrepareAuthKey extends BaseSoterPrepareKeyTask {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.TaskPrepareAuthKey";
    private IWrapUploadKeyNet mASKNetWrapper;
    private String mAuthKeyName;
    private IWrapUploadKeyNet mAuthKeyNetWrapper;
    private boolean mIsAutoDeleteWhenAlreadyGenerated;
    private boolean mIsAutoPrepareASKWhenNotFound;
    private int mScene;

    public TaskPrepareAuthKey(int i3, IWrapUploadKeyNet iWrapUploadKeyNet, IWrapUploadKeyNet iWrapUploadKeyNet2, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), iWrapUploadKeyNet, iWrapUploadKeyNet2, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.mAuthKeyName = null;
        this.mScene = i3;
        this.mAuthKeyNetWrapper = iWrapUploadKeyNet;
        this.mIsAutoDeleteWhenAlreadyGenerated = z16;
        this.mIsAutoPrepareASKWhenNotFound = z17;
        this.mASKNetWrapper = iWrapUploadKeyNet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateAuthKey() {
        markKeyStatus(this.mAuthKeyName, 1);
        new SoterKeyGenerateEngine.SoterKeyGenerateEngineBuilder().markGenAuthKey(this.mAuthKeyName, this.mIsAutoDeleteWhenAlreadyGenerated).setKeyGenCallback(new ISoterKeyGenerateCallback() { // from class: com.tencent.soter.wrapper.wrap_task.TaskPrepareAuthKey.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskPrepareAuthKey.this);
                }
            }

            @Override // com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback
            public void onError(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                    return;
                }
                SLogger.w(TaskPrepareAuthKey.TAG, "soter: auth key %s generate failed. errcode: %d, errmsg: %s", TaskPrepareAuthKey.this.mAuthKeyName, Integer.valueOf(i3), str);
                TaskPrepareAuthKey taskPrepareAuthKey = TaskPrepareAuthKey.this;
                taskPrepareAuthKey.markKeyStatus(taskPrepareAuthKey.mAuthKeyName, 0);
                TaskPrepareAuthKey.this.callback(new SoterProcessKeyPreparationResult(i3, str));
            }

            @Override // com.tencent.soter.wrapper.wrap_key.ISoterKeyGenerateCallback
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                SLogger.i(TaskPrepareAuthKey.TAG, "soter: auth key generate successfully. start upload", new Object[0]);
                if (TaskPrepareAuthKey.this.mAuthKeyNetWrapper != null) {
                    TaskPrepareAuthKey taskPrepareAuthKey = TaskPrepareAuthKey.this;
                    taskPrepareAuthKey.markKeyStatus(taskPrepareAuthKey.mAuthKeyName, 2);
                } else {
                    TaskPrepareAuthKey taskPrepareAuthKey2 = TaskPrepareAuthKey.this;
                    taskPrepareAuthKey2.markKeyStatus(taskPrepareAuthKey2.mAuthKeyName, 0);
                }
                TaskPrepareAuthKey.this.startUploadAuthKeyAfterGenerate();
            }
        }).build().generate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadAuthKeyAfterGenerate() {
        SoterPubKeyModel authKeyModel = SoterCore.getAuthKeyModel(this.mAuthKeyName);
        if (authKeyModel == null) {
            SLogger.e(TAG, "soter: auth key model is null even after generation. fatal error", new Object[0]);
            SoterCore.removeAuthKey(this.mAuthKeyName, false);
            callback(new SoterProcessKeyPreparationResult(1006, "auth key model is null even after generation."));
            return;
        }
        IWrapUploadKeyNet iWrapUploadKeyNet = this.mAuthKeyNetWrapper;
        if (iWrapUploadKeyNet != null) {
            iWrapUploadKeyNet.setRequest(new IWrapUploadKeyNet.UploadRequest(authKeyModel.getSignature(), authKeyModel.getRawJson()));
            this.mAuthKeyNetWrapper.setCallback(new ISoterNetCallback<IWrapUploadKeyNet.UploadResult>(authKeyModel) { // from class: com.tencent.soter.wrapper.wrap_task.TaskPrepareAuthKey.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ SoterPubKeyModel val$authKeyModel;

                {
                    this.val$authKeyModel = authKeyModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskPrepareAuthKey.this, (Object) authKeyModel);
                    }
                }

                @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetCallback
                public void onNetEnd(IWrapUploadKeyNet.UploadResult uploadResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadResult);
                        return;
                    }
                    TaskPrepareAuthKey taskPrepareAuthKey = TaskPrepareAuthKey.this;
                    taskPrepareAuthKey.markKeyStatus(taskPrepareAuthKey.mAuthKeyName, 0);
                    boolean z16 = uploadResult.mIsUploadAndVerifiedSuccess;
                    SLogger.i(TaskPrepareAuthKey.TAG, "soter: auth key upload result: %b", Boolean.valueOf(z16));
                    if (!z16) {
                        SoterCore.removeAuthKey(TaskPrepareAuthKey.this.mAuthKeyName, false);
                        TaskPrepareAuthKey taskPrepareAuthKey2 = TaskPrepareAuthKey.this;
                        taskPrepareAuthKey2.callback(new SoterProcessKeyPreparationResult(1004, String.format("upload auth key: %s failed", taskPrepareAuthKey2.mAuthKeyName)));
                        return;
                    }
                    TaskPrepareAuthKey.this.callback(new SoterProcessKeyPreparationResult(0, this.val$authKeyModel));
                }
            });
            this.mAuthKeyNetWrapper.execute();
        } else {
            SLogger.d(TAG, "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(0, "treat as normal because you do not provide the net wrapper", authKeyModel));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void execute() {
        if (!SoterCore.isAppGlobalSecureKeyValid() && this.mIsAutoPrepareASKWhenNotFound) {
            SLogger.d(TAG, "soter: ask not found, but required to generate it. start generate", new Object[0]);
            SoterWrapperApi.prepareAppSecureKey(new SoterProcessCallback<SoterProcessKeyPreparationResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskPrepareAuthKey.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskPrepareAuthKey.this);
                    }
                }

                @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                public void onResult(@NonNull SoterProcessKeyPreparationResult soterProcessKeyPreparationResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) soterProcessKeyPreparationResult);
                        return;
                    }
                    SLogger.d(TaskPrepareAuthKey.TAG, "soter: prepare ask end: %s", soterProcessKeyPreparationResult.toString());
                    if (soterProcessKeyPreparationResult.errCode == 0) {
                        TaskPrepareAuthKey.this.generateAuthKey();
                    } else {
                        TaskPrepareAuthKey.this.callback(soterProcessKeyPreparationResult);
                    }
                }
            }, false, this.mASKNetWrapper);
        } else {
            generateAuthKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean isSingleInstance() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void onRemovedFromTaskPoolActively() {
        SLogger.w(TAG, "soter: cancelled prepare authkey: %s", this.mAuthKeyName);
        SoterCore.removeAuthKey(this.mAuthKeyName, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    @SuppressLint({"DefaultLocale"})
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
        String str = SoterDataCenter.getInstance().getAuthKeyNames().get(this.mScene, "");
        this.mAuthKeyName = str;
        if (SoterCoreUtil.isNullOrNil(str)) {
            SLogger.w(TAG, "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.mScene))));
            return true;
        }
        boolean isAppGlobalSecureKeyValid = SoterCore.isAppGlobalSecureKeyValid();
        if (!isAppGlobalSecureKeyValid && SoterCore.hasAuthKey(this.mAuthKeyName)) {
            SLogger.w(TAG, "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
            SoterCore.removeAuthKey(this.mAuthKeyName, false);
        }
        if (!isAppGlobalSecureKeyValid && !this.mIsAutoPrepareASKWhenNotFound) {
            SLogger.w(TAG, "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(3));
            return true;
        }
        if (SoterCore.hasAuthKey(this.mAuthKeyName) && !SoterCore.isAuthKeyValid(this.mAuthKeyName, true)) {
            SLogger.w(TAG, "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
            return false;
        }
        if (SoterCore.hasAuthKey(this.mAuthKeyName) && !this.mIsAutoDeleteWhenAlreadyGenerated) {
            SLogger.i(TAG, "soter: already has key. do not need generate again", new Object[0]);
            callback(new SoterProcessKeyPreparationResult(0, SoterCore.getAuthKeyModel(this.mAuthKeyName)));
            return true;
        }
        if (this.mAuthKeyNetWrapper == null) {
            SLogger.w(TAG, "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
        }
        return false;
    }
}
