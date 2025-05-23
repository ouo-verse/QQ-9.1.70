package com.tencent.mobileqq.startup.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ap extends NtTask {
    static IPatchRedirector $redirector_;

    public ap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean a(@NonNull Context context) {
        if (1 == MobileQQ.sProcessId) {
            try {
                return !new File(context.getFilesDir().getAbsolutePath() + "/mmkv/common_mmkv_configurations").exists();
            } catch (Throwable th5) {
                QLog.e("qmmkv_MMKVInitTask", 1, th5.getMessage(), th5);
                return false;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        boolean a16 = a(context);
        QMMKV.initializeInternal(context, new QMMKVFile());
        if (a16) {
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_UIN_UID_MAP).encodeBool("flag_Migrate_MMKForUinUid", true);
        }
        MMKV.setLoadOnNecessaryEnable(true);
        MMKV.setSharedLockFirstWhenReload(true);
        QLog.d("qmmkv_MMKVInitTask", 1, "sharedLockFirst:true, loadOnNecessary:true, isNewlyInstalled:" + a16);
    }
}
