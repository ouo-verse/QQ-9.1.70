package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FolderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f306951a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Runnable f306952b = new Runnable() { // from class: com.tencent.mobileqq.utils.FolderUtils.1
        @Override // java.lang.Runnable
        public void run() {
            FolderUtils.a(BaseApplication.getContext(), true);
        }
    };

    public static boolean a(final Context context, boolean z16) {
        File cacheDir;
        boolean z17;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
            } else {
                cacheDir = BaseApplication.getContext().getCacheDir();
            }
            File file = new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE);
            if (file.exists()) {
                return true;
            }
            try {
                try {
                    z17 = file.mkdirs();
                } catch (Throwable th5) {
                    th = th5;
                    z17 = false;
                }
                try {
                    if (!f306951a) {
                        f306951a = true;
                    }
                    if (!z17 && (!FileUtils.checkTencentFolderExist() || !FileUtils.checkMobileQQFolderExist() || !FileUtils.checkDiskCacheExist())) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.FolderUtils.2
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(context, R.string.f170271kw, 1).show();
                            }
                        });
                    }
                    if (z16 && (z17 || f306951a)) {
                        b(z17);
                        if (!z17) {
                            f306951a = false;
                        }
                    }
                    return z17;
                } catch (Throwable th6) {
                    th = th6;
                    if (!z17 && (!FileUtils.checkTencentFolderExist() || !FileUtils.checkMobileQQFolderExist() || !FileUtils.checkDiskCacheExist())) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.FolderUtils.2
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(context, R.string.f170271kw, 1).show();
                            }
                        });
                    }
                    if (z16 && (z17 || f306951a)) {
                        b(z17);
                        if (!z17) {
                            f306951a = false;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused) {
                if (!FileUtils.checkTencentFolderExist() || !FileUtils.checkMobileQQFolderExist() || !FileUtils.checkDiskCacheExist()) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.FolderUtils.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(context, R.string.f170271kw, 1).show();
                        }
                    });
                }
                if (!z16 || !f306951a) {
                    return false;
                }
                b(false);
                f306951a = false;
                return false;
            }
        } catch (NullPointerException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FileCopy", 2, "checkFolder exception!", e16);
            }
            return false;
        }
    }

    public static void b(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("PicReporter", 2, "device busy " + z16);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Pic.Mkdir.DeviceBusy", z16, 0L, 0L, null, "");
    }
}
