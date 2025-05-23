package com.tencent.mobileqq.ar.arengine;

import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class af {
    @TargetApi(18)
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized void b(@NonNull String str) {
        synchronized (af.class) {
            if (!FileUtils.fileExists(str)) {
                try {
                    FileUtils.createFile(str);
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AREngine_ARResouceDir", 2, "createFileIfNotExits", e16);
                    }
                }
            }
        }
    }

    public static String c(ArCloudConfigInfo arCloudConfigInfo) {
        try {
            ArModelResource arModelResource = arCloudConfigInfo.F;
            if (arModelResource == null) {
                return "";
            }
            return arCloudConfigInfo.E.f198413i + arModelResource.f198421e + File.separator + arModelResource.f198424i;
        } catch (Exception e16) {
            QLog.i("AREngine_ARResouceDir", 2, "get3DModelLuaFilePath error " + e16.getMessage());
            return "";
        }
    }

    public static String d(ArCloudConfigInfo arCloudConfigInfo) {
        try {
            ArModelResource arModelResource = arCloudConfigInfo.F;
            if (arModelResource == null) {
                return "";
            }
            String str = arModelResource.f198421e;
            if (TextUtils.isEmpty(arModelResource.f198423h)) {
                return "";
            }
            return arCloudConfigInfo.E.f198413i + str + File.separator + arCloudConfigInfo.F.f198423h;
        } catch (Exception e16) {
            QLog.i("AREngine_ARResouceDir", 2, "get3DModelMusicFilePath error " + e16.getMessage());
            return "";
        }
    }

    public static String e(ArCloudConfigInfo arCloudConfigInfo) {
        try {
            ArModelResource arModelResource = arCloudConfigInfo.F;
            if (arModelResource == null) {
                return "";
            }
            return arCloudConfigInfo.E.f198413i + arModelResource.f198421e + File.separator;
        } catch (Exception e16) {
            QLog.i("AREngine_ARResouceDir", 2, "get3DModelUnzipDir error " + e16.getMessage());
            return "";
        }
    }

    public static String f() {
        return j() + "ar_relationship/";
    }

    public static String g(String str) {
        return j() + "ar_cloud_transfer/" + str + File.separator;
    }

    public static String h(ArCloudConfigInfo arCloudConfigInfo) {
        return arCloudConfigInfo.E.f198413i + arCloudConfigInfo.F.f198424i + File.separator;
    }

    public static String i(ArCloudConfigInfo arCloudConfigInfo) {
        try {
            return arCloudConfigInfo.E.f198413i + arCloudConfigInfo.D.get(0).f198430i + "_model.zip";
        } catch (Exception e16) {
            QLog.i("AREngine_ARResouceDir", 2, "getVideoFilePath error " + e16.getMessage());
            return "";
        }
    }

    public static String j() {
        String str;
        if (a()) {
            str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_ARResouceDir", 2, "no_sdcard");
            }
            float availableInnernalMemorySize = FileUtils.getAvailableInnernalMemorySize();
            if (availableInnernalMemorySize < 1.572864E7f && QLog.isColorLevel()) {
                QLog.i("AREngine_ARResouceDir", 2, "inner memory avail may not enough : " + availableInnernalMemorySize);
            }
            str = BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath() + File.separator;
        }
        QLog.d("AREngine_ARResouceDir", 1, "initArResourceFilePath rootPath:=" + str);
        return str;
    }
}
