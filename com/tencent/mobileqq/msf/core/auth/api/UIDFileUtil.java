package com.tencent.mobileqq.msf.core.auth.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UIDFileUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String SEPARATOR = "###";
    private static final String TAG = "UIDFileUtil";
    private static final String UID_DIC = "/uid/";

    public UIDFileUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized String getUIDFromFile(String str) {
        synchronized (UIDFileUtil.class) {
            try {
                File uIDStorageDic = getUIDStorageDic();
                if (!uIDStorageDic.exists()) {
                    return "";
                }
                String[] list = uIDStorageDic.list();
                if (list == null) {
                    return "";
                }
                for (String str2 : list) {
                    if (str2.startsWith(str + SEPARATOR)) {
                        QLog.d(TAG, 1, "getUIDFromFile fileName = " + str2);
                        return str2.split(SEPARATOR)[1];
                    }
                }
                return "";
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return "";
            }
        }
    }

    private static File getUIDStorageDic() {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + UID_DIC);
    }

    public static synchronized boolean putUIDToFile(String str, String str2) {
        synchronized (UIDFileUtil.class) {
            File uIDStorageDic = getUIDStorageDic();
            if (!uIDStorageDic.exists()) {
                uIDStorageDic.mkdirs();
            }
            if (!uIDStorageDic.exists()) {
                return false;
            }
            File file = new File(uIDStorageDic, str + SEPARATOR + str2);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                    return false;
                }
            }
            return true;
        }
    }
}
