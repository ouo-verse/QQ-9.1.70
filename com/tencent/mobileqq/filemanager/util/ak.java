package com.tencent.mobileqq.filemanager.util;

import android.content.ContentValues;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.tencent.image.Utils;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ak {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements MediaScannerConnection.OnScanCompletedListener {
        a() {
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            if (QLog.isDebugVersion()) {
                QLog.i("FilePathUtil<FileAssistant>", 1, "MediaScannerConnection Scanned:\n" + str + ":\nuri=" + uri);
            }
        }
    }

    public static String a(String str) {
        Uri uri = null;
        if (!f() || !FileUtils.fileExistsAndNotEmpty(str)) {
            return null;
        }
        String M0 = QQFileManagerUtilImpl.M0(str);
        String str2 = "";
        try {
            if (M0.indexOf(46) < 0) {
                if (Utils.isHeifFile(str)) {
                    str2 = ".heif";
                } else {
                    str2 = "." + FileUtils.estimateFileType(str);
                }
                M0 = M0 + str2;
            }
        } catch (Exception unused) {
            QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
        }
        int T0 = QQFileManagerUtilImpl.T0(M0);
        QLog.d("FilePathUtil<FileAssistant>", 1, "copyImageFileToMediaStorage filePath: " + str + " ,fileName:" + M0 + " ,fileType:" + T0);
        if (T0 != 2 && T0 != 0) {
            QLog.w("FilePathUtil<FileAssistant>", 1, "unsupport type:" + T0 + "\uff0cextension:" + q.j(str) + "\uff0cfilePath:" + str);
            return null;
        }
        BaseApplication context = BaseApplication.getContext();
        String mimeType = MimeTypesTools.getMimeType(context, M0);
        int imageDegree = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getImageDegree(str);
        File d16 = d(str, str2);
        if (d16 == null) {
            QLog.d("FilePathUtil<FileAssistant>", 1, "newFile == null");
            return null;
        }
        QLog.d("FilePathUtil<FileAssistant>", 1, "copyImageFileToMediaStorage newFile.path: " + d16.getAbsolutePath());
        String M02 = QQFileManagerUtilImpl.M0(d16.getAbsolutePath());
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", M02);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, M02);
        contentValues.put("description", M02);
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, mimeType);
        String absolutePath = d16.getAbsolutePath();
        contentValues.put("_data", absolutePath);
        if (T0 == 0) {
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("orientation", Integer.valueOf(imageDegree));
            if (Build.VERSION.SDK_INT >= 29) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Environment.DIRECTORY_PICTURES);
                String str3 = File.separator;
                sb5.append(str3);
                sb5.append("QQ");
                contentValues.put("relative_path", sb5.toString());
                QLog.d("FilePathUtil<FileAssistant>", 1, "image >= Q : " + Environment.DIRECTORY_PICTURES + str3 + "QQ");
            } else if (b(d16) == null) {
                QLog.d("FilePathUtil<FileAssistant>", 1, "image createNewFile(newFile) == null");
                return null;
            }
            uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else if (T0 == 2) {
            if (Build.VERSION.SDK_INT >= 29) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(Environment.DIRECTORY_PICTURES);
                String str4 = File.separator;
                sb6.append(str4);
                sb6.append("QQ");
                contentValues.put("relative_path", sb6.toString());
                QLog.d("FilePathUtil<FileAssistant>", 1, "video >= Q : " + Environment.DIRECTORY_PICTURES + str4 + "QQ");
            } else if (b(d16) == null) {
                QLog.d("FilePathUtil<FileAssistant>", 1, "video createNewFile(newFile) == null");
                return null;
            }
            long duration = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getDuration(str);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("duration", Long.valueOf(duration));
            uri = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        if (QQFileUtilsImpl.c(context, str, uri)) {
            MediaScannerConnection.scanFile(context, new String[]{d16.getAbsolutePath()}, new String[]{mimeType}, new a());
        }
        return absolutePath;
    }

    private static File b(File file) {
        try {
            file.createNewFile();
            return file;
        } catch (IOException e16) {
            QLog.e("FilePathUtil<FileAssistant>", 1, e16, new Object[0]);
            return null;
        }
    }

    public static boolean c(String str) {
        return FileUtils.fileExistsAndNotEmpty(e(str));
    }

    private static File d(String str, String str2) {
        String M0 = QQFileManagerUtilImpl.M0(str);
        QQFileManagerUtilImpl.T0(M0);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/QQ/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(QQFileManagerUtilImpl.y2(file.getAbsolutePath() + "/" + M0 + str2));
    }

    private static boolean f() {
        if (MobileQQ.sMobileQQ.getBaseContext().checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && MobileQQ.sMobileQQ.getBaseContext().checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    public static String g(String str) {
        if (!f() || !FileUtils.fileExistsAndNotEmpty(str)) {
            return null;
        }
        String M0 = QQFileManagerUtilImpl.M0(str);
        String str2 = "";
        try {
            if (M0.indexOf(46) < 0) {
                str2 = "." + FileUtils.estimateFileType(str);
                M0 = M0 + str2;
            }
        } catch (Exception unused) {
            QLog.e("FilePathUtil<FileAssistant>", 1, "copyMediaFileToMediaStorage: get file ext error");
        }
        int T0 = QQFileManagerUtilImpl.T0(M0);
        if (T0 != 2 && T0 != 0) {
            QLog.w("FilePathUtil<FileAssistant>", 1, "unSupport type:" + T0 + "\uff0cextension:" + q.j(str) + "\uff0cfilePath:" + str);
            return null;
        }
        BaseApplication context = BaseApplication.getContext();
        String mimeType = MimeTypesTools.getMimeType(context, M0);
        int imageDegree = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getImageDegree(str);
        File d16 = d(str, str2);
        if (d16 == null) {
            return null;
        }
        String M02 = QQFileManagerUtilImpl.M0(d16.getAbsolutePath());
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", M02);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, M02);
        contentValues.put("description", M02);
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, mimeType);
        if (new File(str).renameTo(d16)) {
            QLog.i("FilePathUtil<FileAssistant>", 1, "rename :" + str + " to:" + d16.getAbsolutePath());
        }
        String absolutePath = d16.getAbsolutePath();
        contentValues.put("_data", absolutePath);
        if (T0 == 0) {
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("orientation", Integer.valueOf(imageDegree));
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + File.separator + "QQ");
            } else if (b(d16) == null) {
                return null;
            }
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else if (T0 == 2) {
            if (Build.VERSION.SDK_INT >= 29) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Environment.DIRECTORY_PICTURES);
                String str3 = File.separator;
                sb5.append(str3);
                sb5.append("QQ");
                contentValues.put("relative_path", sb5.toString());
                QLog.d("FilePathUtil<FileAssistant>", 1, "renameImageFileToMediaStorage video >= Q : " + Environment.DIRECTORY_PICTURES + str3 + "QQ");
            } else if (b(d16) == null) {
                QLog.d("FilePathUtil<FileAssistant>", 1, "renameImageFileToMediaStorage video createNewFile(newFile) == null");
                return null;
            }
            long duration = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getDuration(absolutePath);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("duration", Long.valueOf(duration));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        return absolutePath;
    }

    public static String e(String str) {
        return str;
    }
}
