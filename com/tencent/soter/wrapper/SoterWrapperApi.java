package com.tencent.soter.wrapper;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_core.SoterProcessErrCode;
import com.tencent.soter.wrapper.wrap_net.IWrapUploadKeyNet;
import com.tencent.soter.wrapper.wrap_task.AuthenticationParam;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tencent.soter.wrapper.wrap_task.SoterTaskManager;
import com.tencent.soter.wrapper.wrap_task.SoterTaskThread;
import com.tencent.soter.wrapper.wrap_task.TaskAuthentication;
import com.tencent.soter.wrapper.wrap_task.TaskBiometricAuthentication;
import com.tencent.soter.wrapper.wrap_task.TaskInit;
import com.tencent.soter.wrapper.wrap_task.TaskPrepareAppSecureKey;
import com.tencent.soter.wrapper.wrap_task.TaskPrepareAuthKey;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterWrapperApi implements SoterProcessErrCode {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Soter.SoterWrapperApi";

    public SoterWrapperApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearAllKey() {
        SparseArray<String> authKeyNames = SoterDataCenter.getInstance().getAuthKeyNames();
        int size = authKeyNames.size();
        for (int i3 = 0; i3 < size; i3++) {
            SoterCore.removeAuthKey(authKeyNames.valueAt(i3), false);
        }
        SoterCore.removeAppGlobalSecureKey();
    }

    @RequiresApi(api = 14)
    public static void detectAppForeground(Application application) {
        application.registerActivityLifecycleCallbacks(new AppForegroundDetector());
    }

    public static void ensureConnection() {
        if (isInitialized() && !SoterCore.isTrebleServiceConnected()) {
            SoterCore.triggerTrebleServiceConnecting();
        }
    }

    public static int getSupportType() {
        return SoterDataCenter.getInstance().getSupportType();
    }

    public static void init(Context context, SoterProcessCallback<SoterProcessNoExtResult> soterProcessCallback, @NonNull InitializeParam initializeParam) {
        SoterTaskThread.getInstance().postToWorker(new Runnable(context, initializeParam, soterProcessCallback) { // from class: com.tencent.soter.wrapper.SoterWrapperApi.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ SoterProcessCallback val$callback;
            final /* synthetic */ Context val$context;
            final /* synthetic */ InitializeParam val$param;

            {
                this.val$context = context;
                this.val$param = initializeParam;
                this.val$callback = soterProcessCallback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, initializeParam, soterProcessCallback);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TaskInit taskInit = new TaskInit(this.val$context, this.val$param);
                taskInit.setTaskCallback(this.val$callback);
                if (!SoterTaskManager.getInstance().addToTask(taskInit, new SoterProcessNoExtResult())) {
                    SLogger.e(SoterWrapperApi.TAG, "soter: add init task failed.", new Object[0]);
                }
            }
        });
    }

    public static boolean isInitialized() {
        return SoterDataCenter.getInstance().isInit();
    }

    public static boolean isSupportSoter() {
        if (SoterDataCenter.getInstance().isInit() && SoterDataCenter.getInstance().isSupportSoter()) {
            return true;
        }
        return false;
    }

    public static void prepareAppSecureKey(SoterProcessCallback<SoterProcessKeyPreparationResult> soterProcessCallback, boolean z16, IWrapUploadKeyNet iWrapUploadKeyNet) {
        SLogger.i(TAG, "soter: starting prepare ask key. ", new Object[0]);
        TaskPrepareAppSecureKey taskPrepareAppSecureKey = new TaskPrepareAppSecureKey(iWrapUploadKeyNet, z16);
        taskPrepareAppSecureKey.setTaskCallback(soterProcessCallback);
        if (!SoterTaskManager.getInstance().addToTask(taskPrepareAppSecureKey, new SoterProcessKeyPreparationResult())) {
            SLogger.d(TAG, "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
    }

    public static void prepareAuthKey(SoterProcessCallback<SoterProcessKeyPreparationResult> soterProcessCallback, boolean z16, boolean z17, int i3, IWrapUploadKeyNet iWrapUploadKeyNet, IWrapUploadKeyNet iWrapUploadKeyNet2) {
        SLogger.i(TAG, "soter: starting prepare auth key: %d", Integer.valueOf(i3));
        TaskPrepareAuthKey taskPrepareAuthKey = new TaskPrepareAuthKey(i3, iWrapUploadKeyNet, iWrapUploadKeyNet2, z16, z17);
        taskPrepareAuthKey.setTaskCallback(soterProcessCallback);
        if (!SoterTaskManager.getInstance().addToTask(taskPrepareAuthKey, new SoterProcessKeyPreparationResult())) {
            SLogger.d(TAG, "soter: add prepareAuthKey task failed.", new Object[0]);
        }
    }

    public static void release() {
        tryStopAllSoterTask();
        SoterDataCenter.getInstance().clearStatus();
    }

    public static boolean removeAuthKeyByScene(int i3) {
        boolean isInit = SoterDataCenter.getInstance().isInit();
        String str = SoterDataCenter.getInstance().getAuthKeyNames().get(i3);
        if (isInit && !SoterCoreUtil.isNullOrNil(str)) {
            if (SoterCore.removeAuthKey(str, false).errCode != 0) {
                return false;
            }
            return true;
        }
        if (!isInit) {
            SLogger.w(TAG, "soter: not initialized yet", new Object[0]);
            return false;
        }
        SLogger.w(TAG, "soter: scene not registered in init. please make sure", new Object[0]);
        return false;
    }

    public static void requestAuthorizeAndSign(SoterProcessCallback<SoterProcessAuthenticationResult> soterProcessCallback, @NonNull AuthenticationParam authenticationParam) {
        SLogger.i(TAG, "soter: request authorize provide challenge. scene: %d", Integer.valueOf(authenticationParam.getScene()));
        if (authenticationParam.getBiometricType() != 1 && authenticationParam.getBiometricType() != 2) {
            TaskAuthentication taskAuthentication = new TaskAuthentication(authenticationParam);
            taskAuthentication.setTaskCallback(soterProcessCallback);
            if (!SoterTaskManager.getInstance().addToTask(taskAuthentication, new SoterProcessAuthenticationResult())) {
                SLogger.d(TAG, "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
                return;
            }
            return;
        }
        TaskBiometricAuthentication taskBiometricAuthentication = new TaskBiometricAuthentication(authenticationParam);
        taskBiometricAuthentication.setTaskCallback(soterProcessCallback);
        if (!SoterTaskManager.getInstance().addToTask(taskBiometricAuthentication, new SoterProcessAuthenticationResult())) {
            SLogger.d(TAG, "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
        }
    }

    public static void tryStopAllSoterTask() {
        SoterTaskManager.getInstance().cancelAllTask();
    }
}
