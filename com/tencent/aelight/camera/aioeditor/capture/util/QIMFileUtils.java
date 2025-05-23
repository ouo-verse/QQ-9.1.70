package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMFileUtils {
    public static File a() {
        return BaseApplication.getContext().getCacheDir();
    }

    public static String b(File file, String str) {
        File file2 = new File(file + File.separator + str);
        if (file2.exists()) {
            byte[] fileToBytes = FileUtils.fileToBytes(file2);
            if (fileToBytes == null || fileToBytes.length <= 0) {
                return null;
            }
            try {
                return new String(fileToBytes, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                if (!QLog.isDevelopLevel()) {
                    return null;
                }
                e16.printStackTrace();
                return null;
            }
        }
        return "";
    }

    public static void d(final File file, final String str, final String str2) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils.1
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getPath());
                String str3 = File.separator;
                sb5.append(str3);
                FileUtils.writeFile(sb5.toString(), str, str2);
                if (QLog.isColorLevel()) {
                    QLog.i("QIMFileUtils", 2, "paster config save to file " + file.getPath() + str3 + str);
                }
            }
        });
    }

    public static String c(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = BaseApplication.getContext().getAssets().open(str);
                String h16 = k.h(inputStream);
                if (inputStream == null) {
                    return h16;
                }
                try {
                    inputStream.close();
                    return h16;
                } catch (Exception e16) {
                    if (!QLog.isColorLevel()) {
                        return h16;
                    }
                    e16.printStackTrace();
                    return h16;
                }
            } catch (IOException e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            e18.printStackTrace();
                        }
                    }
                }
                return "";
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        e19.printStackTrace();
                    }
                }
            }
            throw th5;
        }
    }
}
