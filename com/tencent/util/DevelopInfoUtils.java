package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DevelopInfoUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_BRANCH_NAME = "feature/_8.4.17_ExtendFriend";
    private static final String LOCAL_BRANCH_NAME_PATH = "/sdcard/Android/data/com.tencent.mobileqq/cache/QQBranchName.txt";
    public static final String TAG = "DevelopInfoUtils";
    private static AtomicBoolean hasChecklocalBranchName;
    private static String s_localBranchName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            hasChecklocalBranchName = new AtomicBoolean(false);
            s_localBranchName = AppSetting.getBranchName();
        }
    }

    public DevelopInfoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getBranchName(boolean z16) {
        if (!z16) {
            return s_localBranchName;
        }
        if (z16 && !AppSetting.isPublicVersion()) {
            synchronized (hasChecklocalBranchName) {
                if (hasChecklocalBranchName.compareAndSet(false, true) && s_localBranchName == DEFAULT_BRANCH_NAME) {
                    try {
                        File file = new File(LOCAL_BRANCH_NAME_PATH);
                        if (file.exists()) {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                            String readLine = bufferedReader.readLine();
                            if (!StringUtil.isEmpty(readLine)) {
                                s_localBranchName = readLine;
                                QLog.i(TAG, 2, "read LOCAL_BRANCH_NAME_PATH file success, s_localBranchName is " + s_localBranchName);
                            }
                            bufferedReader.close();
                        }
                    } catch (Throwable th5) {
                        QLog.i(TAG, 1, "read LOCAL_BRANCH_NAME_PATH file failed", th5);
                    }
                }
            }
        }
        return s_localBranchName;
    }
}
