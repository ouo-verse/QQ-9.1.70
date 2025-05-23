package com.tencent.hippy.qq.update.patch;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.tool.MD5;
import com.tencent.hippy.qq.update.tool.QarFile;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes7.dex */
public class PatchUtil {
    private static final String DST_TEMP_QAR_FILE_NAME = "dst_temp.qar";
    private static final String SRC_TEMP_QAR_FILE_NAME = "src_temp.qar";
    private static final String TAG = "HippyDiffUtil";

    /* loaded from: classes7.dex */
    public enum DiffResultCodes {
        SUCCESS,
        UNKNOWN,
        PARAMETERS_ERROR,
        CREATE_DST_DIR_FAILED,
        DELETE_TEMP_FILE_FAILED,
        CREATE_QAR_FILE_FAILED,
        PATCH_FAILED,
        MD5_FAILED,
        CONVERT_ZIP_FILE_FAILED,
        UNZIP_FULL_PKG_FAILED
    }

    public static DiffResultCodes patch(String str, String str2, String str3, String str4) {
        DiffResultCodes preparePatch = preparePatch(str, str2, str3, str4);
        DiffResultCodes diffResultCodes = DiffResultCodes.SUCCESS;
        if (preparePatch != diffResultCodes) {
            return preparePatch;
        }
        File file = new File(str2);
        File file2 = new File(file.getParent(), SRC_TEMP_QAR_FILE_NAME);
        File file3 = new File(file.getParent(), DST_TEMP_QAR_FILE_NAME);
        File file4 = new File(str);
        QarFile qarFile = new QarFile();
        if (!qarFile.createQar(file4.getAbsolutePath(), file2.getAbsolutePath())) {
            QLog.e(TAG, 1, "[patch] create qar file of old version failed.");
            return DiffResultCodes.CREATE_QAR_FILE_FAILED;
        }
        if (!BspatchUtil.a(file2.getAbsolutePath(), str3, file3.getAbsolutePath())) {
            QLog.e(TAG, 1, "[patch] patch failed.");
            return DiffResultCodes.PATCH_FAILED;
        }
        if (!str4.equals(MD5.getFileMd5(file3.getAbsolutePath()))) {
            QLog.e(TAG, 1, "[patch] md5 not correct.");
            return DiffResultCodes.MD5_FAILED;
        }
        if (file.exists() && !file.delete()) {
            return DiffResultCodes.DELETE_TEMP_FILE_FAILED;
        }
        if (!qarFile.restoreQar(file3.getAbsolutePath(), file.getAbsolutePath())) {
            QLog.e(TAG, 1, "[patch] convert to zip file failed.");
            return DiffResultCodes.CONVERT_ZIP_FILE_FAILED;
        }
        file2.delete();
        file3.delete();
        return diffResultCodes;
    }

    private static DiffResultCodes preparePatch(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            File file = new File(str2);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                QLog.e(TAG, 1, "[patch] mkdirs error.");
                return DiffResultCodes.CREATE_DST_DIR_FAILED;
            }
            File file2 = new File(file.getParent(), SRC_TEMP_QAR_FILE_NAME);
            File file3 = new File(file.getParent(), DST_TEMP_QAR_FILE_NAME);
            if (file2.exists() && !file2.delete()) {
                QLog.e(TAG, 1, "[patch] delete oldTempQarFile failed.");
                return DiffResultCodes.DELETE_TEMP_FILE_FAILED;
            }
            if (file3.exists() && !file3.delete()) {
                QLog.e(TAG, 1, "[patch] delete newTempQarFile failed.");
                return DiffResultCodes.DELETE_TEMP_FILE_FAILED;
            }
            return DiffResultCodes.SUCCESS;
        }
        return DiffResultCodes.PARAMETERS_ERROR;
    }
}
