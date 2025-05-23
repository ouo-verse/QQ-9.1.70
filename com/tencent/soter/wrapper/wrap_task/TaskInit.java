package com.tencent.soter.wrapper.wrap_task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Process;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.ISoterLogger;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreData;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_core.SoterDataCenter;
import com.tencent.soter.wrapper.wrap_net.ISoterNetCallback;
import com.tencent.soter.wrapper.wrap_net.IWrapGetSupportNet;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TaskInit extends BaseSoterTask {
    static IPatchRedirector $redirector_ = null;
    private static final String DEVICE_INFO;
    private static final String DEVICE_INFO_DIGEST;
    private static final int MAX_CUSTOM_KEY_LEN = 24;
    private static final int MAX_SALT_STR_LEN = 16;
    private static final String SOTER_STATUS_SHARED_PREFERENCE_NAME = "soter_status";
    private static final String SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME;
    private static final String SOTER_TRIGGERED_OOM_FLAG_PREFERENCE_NAME;
    private static final String TAG = "Soter.TaskInit";
    private String customAskName;
    private String distinguishSalt;
    private IWrapGetSupportNet getSupportNetWrapper;
    private boolean isNativeSupport;
    private int[] scenes;
    private SoterDelegate.ISoterDelegate wrapperDelegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20001);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        String generateRemoteCheckRequestParam = SoterCore.generateRemoteCheckRequestParam();
        DEVICE_INFO = generateRemoteCheckRequestParam;
        String messageDigest = SoterCoreUtil.getMessageDigest(generateRemoteCheckRequestParam.getBytes(Charset.forName("UTF-8")));
        DEVICE_INFO_DIGEST = messageDigest;
        SOTER_TRIGGERED_OOM_FLAG_PREFERENCE_NAME = "soter_triggered_oom" + messageDigest;
        SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME = "soter_triggered_oom_count" + messageDigest;
    }

    public TaskInit(Context context, @NonNull InitializeParam initializeParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) initializeParam);
            return;
        }
        this.isNativeSupport = false;
        this.distinguishSalt = "";
        this.customAskName = "";
        this.wrapperDelegate = new SoterDelegate.ISoterDelegate() { // from class: com.tencent.soter.wrapper.wrap_task.TaskInit.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TaskInit.this);
                }
            }

            @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
            public boolean isTriggeredOOM() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 3, (Object) this)).booleanValue();
                }
                SharedPreferences statusSharedPreference = SoterDataCenter.getInstance().getStatusSharedPreference();
                if (statusSharedPreference != null) {
                    int i3 = statusSharedPreference.getInt(TaskInit.SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME, 0);
                    SLogger.i(TaskInit.TAG, "soter: is triggered OOM: %d", Integer.valueOf(i3));
                    if (i3 >= 10) {
                        return true;
                    }
                }
                return false;
            }

            @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
            @SuppressLint({"ApplySharedPref"})
            public void onTriggeredOOM() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SLogger.w(TaskInit.TAG, "soter: on trigger OOM, using wrapper implement", new Object[0]);
                SharedPreferences statusSharedPreference = SoterDataCenter.getInstance().getStatusSharedPreference();
                if (statusSharedPreference != null) {
                    SharedPreferences.Editor edit = statusSharedPreference.edit();
                    edit.putInt(TaskInit.SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME, statusSharedPreference.getInt(TaskInit.SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME, 0) + 1);
                    edit.commit();
                }
            }

            @Override // com.tencent.soter.core.model.SoterDelegate.ISoterDelegate
            public void reset() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                SLogger.i(TaskInit.TAG, "soter: SoterDelegate reset", new Object[0]);
                SharedPreferences statusSharedPreference = SoterDataCenter.getInstance().getStatusSharedPreference();
                if (statusSharedPreference != null) {
                    statusSharedPreference.edit().putInt(TaskInit.SOTER_TRIGGERED_OOM_COUNT_PREFERENCE_NAME, 0).apply();
                }
            }
        };
        ISoterLogger soterLogger = initializeParam.getSoterLogger();
        if (soterLogger != null) {
            SLogger.setLogImp(soterLogger);
        }
        if (initializeParam.getSoterReporter() != null) {
            SReporter.setReporterImp(initializeParam.getSoterReporter());
        }
        HandlerThread customTaskHandlerThread = initializeParam.getCustomTaskHandlerThread();
        if (customTaskHandlerThread != null) {
            SoterTaskThread.getInstance().setTaskHandlerThread(customTaskHandlerThread);
        }
        SoterDataCenter.getInstance().setStatusSharedPreference(context.getSharedPreferences(SOTER_STATUS_SHARED_PREFERENCE_NAME, 0));
        SoterDelegate.setImplement(this.wrapperDelegate);
        SoterCore.tryToInitSoterBeforeTreble();
        SoterCore.tryToInitSoterTreble(context);
        SoterCore.setUp();
        if (!SoterCore.isNativeSupportSoter() || (!SoterCore.isSupportFingerprint(context) && !SoterCore.isSupportBiometric(context, 2))) {
            z16 = false;
        }
        this.isNativeSupport = z16;
        this.getSupportNetWrapper = initializeParam.getGetSupportNetWrapper();
        this.scenes = initializeParam.getScenes();
        this.distinguishSalt = initializeParam.getDistinguishSalt();
        this.customAskName = initializeParam.getCustomAppSecureKeyName();
    }

    private String getCompatDistinguishSalt(@NonNull String str) {
        String messageDigest = SoterCoreUtil.getMessageDigest(str.getBytes(Charset.forName("UTF-8")));
        if (!SoterCoreUtil.isNullOrNil(messageDigest) && messageDigest.length() >= 16) {
            return messageDigest.substring(0, 16);
        }
        Log.e(TAG, "soter: not valid md5 implement!!");
        return null;
    }

    private boolean isKeyStatusInvalid(int i3) {
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAbnormalKeys() {
        try {
            SharedPreferences statusSharedPreference = SoterDataCenter.getInstance().getStatusSharedPreference();
            int i3 = statusSharedPreference.getInt(SoterCoreData.getInstance().getAskName(), -1);
            SLogger.d(TAG, "soter: ask status: %d", Integer.valueOf(i3));
            if (isKeyStatusInvalid(i3) && SoterCore.hasAppGlobalSecureKey()) {
                SLogger.i(TAG, "invalid ask, remove all key", new Object[0]);
                SoterCore.removeAppGlobalSecureKey();
                for (int i16 : this.scenes) {
                    SoterCore.removeAuthKey(SoterDataCenter.getInstance().getAuthKeyNames().get(i16, ""), false);
                }
                return;
            }
            for (int i17 : this.scenes) {
                String str = SoterDataCenter.getInstance().getAuthKeyNames().get(i17, "");
                if (!SoterCoreUtil.isNullOrNil(str)) {
                    int i18 = statusSharedPreference.getInt(str, 0);
                    SLogger.d(TAG, "soter: %s status: %d", str, Integer.valueOf(i18));
                    if (isKeyStatusInvalid(i18) && SoterCore.hasAuthKey(str)) {
                        SLogger.i(TAG, "remove invalid ask: %s", str);
                        SoterCore.removeAuthKey(str, false);
                    }
                }
            }
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: removeAbnormalKeys failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void execute() {
        if (this.isNativeSupport) {
            IWrapGetSupportNet iWrapGetSupportNet = this.getSupportNetWrapper;
            if (iWrapGetSupportNet == null) {
                SoterDataCenter.getInstance().setSupportSoter(true);
                SoterDataCenter.getInstance().setInit(true);
                callback(new SoterProcessNoExtResult(0));
                return;
            } else {
                iWrapGetSupportNet.setRequest(new IWrapGetSupportNet.GetSupportRequest(DEVICE_INFO));
                this.getSupportNetWrapper.setCallback(new ISoterNetCallback<IWrapGetSupportNet.GetSupportResult>() { // from class: com.tencent.soter.wrapper.wrap_task.TaskInit.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskInit.this);
                        }
                    }

                    @Override // com.tencent.soter.wrapper.wrap_net.ISoterNetCallback
                    public void onNetEnd(IWrapGetSupportNet.GetSupportResult getSupportResult) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) getSupportResult);
                            return;
                        }
                        if (getSupportResult != null) {
                            SLogger.i(TaskInit.TAG, "soter: got support tag from backend: %b", Boolean.valueOf(getSupportResult.isSupport));
                            synchronized (SoterDataCenter.class) {
                                SoterDataCenter.getInstance().setSupportSoter(getSupportResult.isSupport);
                                SoterDataCenter.getInstance().setInit(true);
                                SoterDataCenter.getInstance().setSupportType(getSupportResult.supportType);
                            }
                            TaskInit.this.callback(new SoterProcessNoExtResult(0));
                            return;
                        }
                        SLogger.w(TaskInit.TAG, "soter: not return data from remote", new Object[0]);
                        synchronized (SoterDataCenter.class) {
                            SoterDataCenter.getInstance().setSupportSoter(false);
                            SoterDataCenter.getInstance().setInit(true);
                        }
                        TaskInit.this.callback(new SoterProcessNoExtResult(1002));
                    }
                });
                this.getSupportNetWrapper.execute();
                return;
            }
        }
        SLogger.w(TAG, "soter: TaskInit check isNativeSupport[" + this.isNativeSupport + "]", new Object[0]);
        callback(new SoterProcessNoExtResult(2));
        synchronized (SoterDataCenter.class) {
            SoterDataCenter.getInstance().setSupportSoter(false);
            SoterDataCenter.getInstance().setInit(true);
        }
    }

    @SuppressLint({"DefaultLocale"})
    protected void generateAuthKeyNames(String str, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) iArr);
            return;
        }
        for (int i3 : iArr) {
            SoterDataCenter.getInstance().getAuthKeyNames().put(i3, String.format("%suid%d_%s_scene%d", ConstantsSoter.SOTER_COMMON_KEYNAME_PREFIX, Integer.valueOf(Process.myUid()), SoterCoreUtil.nullAsNil(str), Integer.valueOf(i3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean isSingleInstance() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public boolean preExecute() {
        if (SoterDataCenter.getInstance().isSupportSoter()) {
            SLogger.e(TAG, "soter: duplicate initialize soter", new Object[0]);
            callback(new SoterProcessNoExtResult(1028, "soter already have initialized"));
            return true;
        }
        if (SoterCoreUtil.isNullOrNil(this.scenes)) {
            SLogger.e(TAG, "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            callback(new SoterProcessNoExtResult(1024, "no business scene provided"));
            return true;
        }
        if (SoterCoreUtil.nullAsNil(this.distinguishSalt).length() > 16) {
            SLogger.w(TAG, "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String compatDistinguishSalt = getCompatDistinguishSalt(this.distinguishSalt);
            if (SoterCoreUtil.isNullOrNil(compatDistinguishSalt)) {
                SLogger.w(TAG, "soter: saltlen compat failed!!", new Object[0]);
                callback(new SoterProcessNoExtResult(1025, "the account salt length is too long"));
                return true;
            }
            this.distinguishSalt = compatDistinguishSalt;
        }
        if (!SoterCoreUtil.isNullOrNil(this.customAskName) && this.customAskName.length() > 24) {
            SLogger.e(TAG, "soter: the passed ask name is too long (larger than 24).", new Object[0]);
            callback(new SoterProcessNoExtResult(1026, "the passed ask name is too long (larger than 24)"));
            return true;
        }
        if (this.getSupportNetWrapper == null) {
            SLogger.w(TAG, "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
        }
        if (!SoterCoreUtil.isNullOrNil(this.customAskName)) {
            SLogger.i(TAG, "soter: provided valid ASK name", new Object[0]);
            SoterCoreData.getInstance().setAskName(this.customAskName);
        }
        SoterTaskThread.getInstance().postToWorker(new Runnable() { // from class: com.tencent.soter.wrapper.wrap_task.TaskInit.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TaskInit.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TaskInit taskInit = TaskInit.this;
                taskInit.generateAuthKeyNames(taskInit.distinguishSalt, TaskInit.this.scenes);
                TaskInit.this.removeAbnormalKeys();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    public void onRemovedFromTaskPoolActively() {
    }

    @Override // com.tencent.soter.wrapper.wrap_task.BaseSoterTask
    void onExecuteCallback(SoterProcessResultBase soterProcessResultBase) {
    }
}
