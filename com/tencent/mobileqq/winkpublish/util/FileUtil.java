package com.tencent.mobileqq.winkpublish.util;

import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FileUtil {
    public static final String TAG = UploadConstants.TAG + "FileUtil";

    public static boolean saveFileToQqAlbum(String str, String str2, String str3) {
        if (str == null) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                QLog.e(TAG, 1, "srcFile not exists, SaveFileToQqAlbum failed.");
                return false;
            }
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file2.exists()) {
                File file3 = new File(str2 + File.separator + str3);
                FileUtils.copyFile(file, file3);
                RFWApplication.getApplication().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file3)));
            } else {
                QLog.e(TAG, 1, "mkdirs failed, SaveFileToQqAlbum failed.");
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saveFileToQqAlbum failed:", th5);
            return false;
        }
    }
}
