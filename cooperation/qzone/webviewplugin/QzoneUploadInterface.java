package cooperation.qzone.webviewplugin;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneUploadInterface {
    public static final String JS_UPLOAD_TAG = "js-upload: ";
    private static final String TAG = "js-upload: QzoneWebUploadInterface";
    public static final String UPLOAD_TEMP_DIR = "uploader";
    public static final int UPLOAD_TEMP_SPACE_THRESHOLD = 5;
    public static final String UPLOAD_TEMP_SUFFIX = ".qtmp";
    private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
    private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
    private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";

    private static File getExternalFilesDir(Context context) {
        File file = new File(VFSAssistantUtils.getSDKPrivatePath("uploader"));
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static int getInternalAvailableSize() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (int) ((((statFs.getAvailableBlocks() * 1.0d) * statFs.getBlockSize()) / 1024.0d) / 1024.0d);
    }

    public static int getSdCardAvailableSize() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (int) ((((statFs.getAvailableBlocks() * 1.0d) * statFs.getBlockSize()) / 1024.0d) / 1024.0d);
    }

    public static final String getTempFileAbsolutePath(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(8);
        sb5.append(str);
        sb5.append(File.separator);
        sb5.append(str2);
        sb5.append(".qtmp");
        return sb5.toString();
    }

    protected static boolean saveByteBufferToLocalFile(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        QLog.d(TAG, 1, "fos close " + e16);
                    }
                    return true;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    QLog.d(TAG, 1, "save bytes to local file " + e);
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e18) {
                        QLog.d(TAG, 1, "fos close " + e18);
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e19) {
                            QLog.d(TAG, 1, "fos close " + e19);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String toLocal(Context context, String str) {
        String replace = str.replace(WEB_BASE64_PREFIX_JPG, "").replace(WEB_BASE64_PREFIX_JPEG, "").replace(WEB_BASE64_PREFIX_PNG, "");
        String tempFilePath = getTempFilePath(context, UUID.randomUUID().toString());
        if (TextUtils.isEmpty(tempFilePath)) {
            QLog.e(TAG, 1, "getTempFilePath return null !");
            return null;
        }
        try {
            boolean saveByteBufferToLocalFile = saveByteBufferToLocalFile(Base64.decode(replace.getBytes(), 2), tempFilePath);
            QLog.d(TAG, 1, "saveByteBufferToLocalFile ret:" + saveByteBufferToLocalFile);
            if (saveByteBufferToLocalFile) {
                return tempFilePath;
            }
            return null;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "Base64.decode Exception: " + e16.toString());
            return null;
        }
    }

    public static String getTempFilePath(Context context, String str) {
        File dir;
        File externalFilesDir;
        if (str == null) {
            return null;
        }
        if ("mounted".equals(Environment.getExternalStorageState()) && getSdCardAvailableSize() > 5 && (externalFilesDir = getExternalFilesDir(context)) != null) {
            return getTempFileAbsolutePath(externalFilesDir.getAbsolutePath(), str);
        }
        if (getInternalAvailableSize() <= 5 || (dir = context.getDir("uploader", 0)) == null) {
            return null;
        }
        return getTempFileAbsolutePath(dir.getAbsolutePath(), str);
    }
}
