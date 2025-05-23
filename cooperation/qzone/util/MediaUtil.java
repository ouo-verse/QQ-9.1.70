package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MediaUtil {
    private static final String SCENE_ID = "qzone_save_media_to_album";
    private static final String TAG = "MediaUtil";

    public static String getCameraPath(String str) {
        return QZoneFilePath.DCIM_CAMERA_PATH + File.separator + str;
    }

    private static Activity getRealActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        if (activity instanceof BasePluginActivity) {
            return ((BasePluginActivity) activity).getOutActivity();
        }
        return activity;
    }

    public static boolean saveBitmapToSystemAlbumJpg(Activity activity, final Bitmap bitmap, final int i3, final String str) {
        if (activity != null ? QZonePermission.requestStoragePermission(activity, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.util.MediaUtil.2
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                MediaUtil.saveBitmapToSystemAlbumJpg(bitmap, i3, str);
            }
        }, "qzone_save_media_to_album") : true) {
            return saveBitmapToSystemAlbumJpg(bitmap, i3, str);
        }
        return false;
    }

    public static boolean saveFileToQqAlbum(Activity activity, final String str, final String str2, final String str3) {
        if (activity != null ? QZonePermission.requestStoragePermission(activity, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.util.MediaUtil.3
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                MediaUtil.saveFileToQqAlbum(str, str2, str3);
            }
        }, "qzone_save_media_to_album") : true) {
            return saveFileToQqAlbum(str, str2, str3);
        }
        return false;
    }

    public static boolean saveFileToSystemAlbum(Activity activity, final String str, final String str2) {
        if (activity != null ? QZonePermission.requestStoragePermission(activity, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.util.MediaUtil.1
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                MediaUtil.saveFileToSystemAlbum(str, str2);
            }
        }, "qzone_save_media_to_album") : true) {
            return saveFileToSystemAlbum(str, str2);
        }
        return false;
    }

    public static void scanFile(Context context, File file) {
        if (file == null) {
            QZLog.d(TAG, 1, "savePicture onScanFail: file is null");
        } else if (file.exists()) {
            scanFile(context, new String[]{file.getAbsolutePath()});
        } else {
            QZLog.d(TAG, 1, "savePicture onScanFail: file is not exists");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean saveBitmapToSystemAlbumJpg(Bitmap bitmap, int i3, String str) {
        File file = new File(QZoneFilePath.DCIM_CAMERA_PATH + File.separator + str);
        if (file.exists() || bitmap == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream2);
                    scanFile(MobileQQ.sMobileQQ, file);
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e(TAG, 1, "saveBitmapToSystemAlbumJpg failed:", e);
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException unused2) {
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

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
                scanFile(MobileQQ.sMobileQQ, file3);
            } else {
                QLog.e(TAG, 1, "mkdirs failed, SaveFileToQqAlbum failed.");
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saveFileToQqAlbum failed:", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean saveFileToSystemAlbum(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(QZoneFilePath.DCIM_CAMERA_PATH + File.separator + str2);
            FileUtils.copyFile(file, file2);
            scanFile(MobileQQ.sMobileQQ, file2);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saveFileToSystemAlbum failed:", th5);
            return false;
        }
    }

    public static void scanFile(Context context, String str) {
        scanFile(context, new String[]{str});
    }

    public static void scanFile(Context context, String[] strArr) {
        QZLog.d(TAG, 1, "savePicture onScanStart: " + Arrays.toString(strArr));
        MediaScannerConnection.scanFile(context, strArr, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: cooperation.qzone.util.MediaUtil.4
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                QZLog.d(MediaUtil.TAG, 1, "savePicture onScanCompleted: " + str);
            }
        });
    }
}
