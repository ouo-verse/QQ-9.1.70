package com.tencent.av.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v {
    public static String a() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ImageUtil", 2, "[image early] getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/qav/image_early/";
    }

    public static String b() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ImageUtil", 2, "[video early] getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/qav/video_early/";
    }

    public static boolean c(String str) {
        return new File(a(), str).exists();
    }

    public static void d(QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.earlydownload.handler.l lVar;
        if (QLog.isColorLevel()) {
            QLog.i("ImageUtil", 2, "[image early] trigger early download");
        }
        IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
        if (iEarlyDownloadService != null && (lVar = (com.tencent.mobileqq.earlydownload.handler.l) iEarlyDownloadService.getEarlyHandler("qq.android.qav.image2")) != null) {
            lVar.I(false);
        }
    }
}
