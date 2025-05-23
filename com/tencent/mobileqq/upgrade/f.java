package com.tencent.mobileqq.upgrade;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, String str2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s", str, str2));
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config"), str + str2);
            if (file.exists()) {
                try {
                    z16 = file.delete();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fail! fileName=%s uin=%s", str, str2), e16);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UpgradeConfigManager", 2, String.format("deleteUpgradeConfig fileName=%s uin=%s result=%s", str, str2, Boolean.valueOf(z16)));
                }
                return z16;
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    public static String b(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            bArr = FileUtils.fileToBytes(new File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config"), str + str2));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception e17) {
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            e17.printStackTrace();
            return null;
        }
    }

    public static void c(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            FileUtils.writeFile(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config").getAbsolutePath() + "/", str + str2, str3);
            if (QLog.isColorLevel()) {
                QLog.i("UpgradeConfigManager", 2, "save Config to file finish.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeConfigManager", 2, "save Config to file failed\uff0ccontent is empty----" + str);
        }
    }
}
