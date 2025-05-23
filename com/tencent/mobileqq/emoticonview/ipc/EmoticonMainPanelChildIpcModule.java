package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class EmoticonMainPanelChildIpcModule extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String NAME = "module_emoticon_child_mainpanel";
    public static final String OTHER_PROCESS_CALLBACK = "other_process_callback";
    public static final String OTHER_RIGISTER_CALLBACK = "other_rigister_callback";
    public static final String PARAMTER_FOUR = "paramter_four";
    public static final String PARAMTER_ONE = "paramter_one";
    public static final String PARAMTER_THREE = "paramter_three";
    public static final String PARAMTER_TWO = "paramter_two";
    public static final String PROCESS_NAME = "process_name";
    public static final String TAG = "EmoticonMainPanelChildIpcModule";
    public static EmoticonMainPanelChildIpcModule mInstance;
    public String processName;

    public EmoticonMainPanelChildIpcModule() {
        super(NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized EmoticonMainPanelChildIpcModule getInstance() {
        EmoticonMainPanelChildIpcModule emoticonMainPanelChildIpcModule;
        synchronized (EmoticonMainPanelChildIpcModule.class) {
            if (mInstance == null) {
                synchronized (EmoticonMainPanelChildIpcModule.class) {
                    if (mInstance == null) {
                        mInstance = new EmoticonMainPanelChildIpcModule();
                    }
                }
            }
            emoticonMainPanelChildIpcModule = mInstance;
        }
        return emoticonMainPanelChildIpcModule;
    }

    private EIPCResult otherProcessCallBack(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (bundle == null) {
            return EIPCResult.createExceptionResult(new RuntimeException("params is null."));
        }
        bundle.setClassLoader(EmoticonPackage.class.getClassLoader());
        String string = bundle.getString(NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "name: ", string);
        }
        if ("emojilistener_loadend".equals(string)) {
            b.b().j((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO), bundle.getBundle(PARAMTER_THREE));
        } else if ("emojilistener_emoticonjson".equals(string)) {
            b.b().c((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO));
        } else if ("emojilistener_emoticoncover".equals(string)) {
            b.b().notifyEmoticonCoverListener((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO), bundle.getInt(PARAMTER_THREE), bundle.getInt(PARAMTER_FOUR));
        } else if ("emojilistener_packagestart".equals(string)) {
            b.b().notifyPackageStart((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE));
        } else if ("emojilistener_packagemoved".equals(string)) {
            b.b().h(bundle.getInt(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO));
        } else if ("emojilistener_packagedeleted".equals(string)) {
            b.b().g((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE));
        } else if ("emojilistener_packageadded".equals(string)) {
            b.b().e((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), null);
        } else if ("emojilistener_packageadded_one".equals(string)) {
            b.b().d((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE));
        } else if ("emojilistener_packagefail".equals(string)) {
            b.b().notifyPackageFail((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO), bundle.getInt(PARAMTER_THREE), null);
        } else if ("emojilistener_packagesucc".equals(string)) {
            b.b().l((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE));
        } else if ("emojilistener_package_progress".equals(string)) {
            b.b().notifyPackageProgress((EmoticonPackage) bundle.getSerializable(PARAMTER_ONE), bundle.getInt(PARAMTER_TWO), bundle.getInt(PARAMTER_THREE));
        } else if ("emojilistener_destory".equals(string)) {
            b.b().m();
        }
        return EIPCResult.createSuccessResult(null);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (OTHER_PROCESS_CALLBACK.equals(str)) {
            return otherProcessCallBack(waitAppRuntime, str, bundle, i3);
        }
        return EIPCResult.createExceptionResult(new RuntimeException("no match call."));
    }
}
