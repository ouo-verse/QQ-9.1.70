package com.tencent.avbiz;

import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVBizModuleFactory {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private static final HashMap<String, IModule> sModuleMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37788);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = AVBizModuleFactory.class.getSimpleName();
            sModuleMap = new HashMap<>();
        }
    }

    public AVBizModuleFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static IModule createModuleByName(String str) {
        String processName = AVBizUtils.getProcessName();
        if (!Constants.Business.DEFAULT.equals(str) && !Constants.Business.DEFAULT_CAMERA.equals(str) && !Constants.Business.DEFAULT_AUDIO.equals(str)) {
            if ("com.tencent.mobileqq".equals(processName)) {
                return new AVBizQQProcessModule(str);
            }
            AVBizClientQIPCModule aVBizClientQIPCModule = new AVBizClientQIPCModule(str, processName);
            QIPCClientHelper.getInstance().getClient().registerModule(aVBizClientQIPCModule);
            return aVBizClientQIPCModule;
        }
        return new DefaultModule(str, processName);
    }

    public static synchronized IModule getModuleByName(String str) {
        synchronized (AVBizModuleFactory.class) {
            if (!AVBizUtils.isValid(str)) {
                QLog.e(TAG, 1, "getModuleByName invalid business name[" + str + "]");
                return new FakeModule(str);
            }
            HashMap<String, IModule> hashMap = sModuleMap;
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, createModuleByName(str));
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "create module[" + str + "]");
                }
            }
            return hashMap.get(str);
        }
    }

    public static synchronized void removeModuleByName(String str) {
        synchronized (AVBizModuleFactory.class) {
            HashMap<String, IModule> hashMap = sModuleMap;
            if (hashMap.containsKey(str)) {
                IModule iModule = hashMap.get(str);
                if (!"com.tencent.mobileqq".equals(AVBizUtils.getProcessName())) {
                    if (iModule instanceof AVBizClientQIPCModule) {
                        QIPCClientHelper.getInstance().getClient().unRegisterModule((AVBizClientQIPCModule) iModule);
                    } else {
                        QLog.e(TAG, 1, "removeModuleByName, invalid process[" + AVBizUtils.getProcessName() + "]");
                    }
                }
                hashMap.remove(str);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "unRegisterModule[" + str + "]");
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "module not register[" + str + "]");
            }
        }
    }
}
