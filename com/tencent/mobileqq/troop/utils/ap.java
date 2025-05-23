package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ap {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, URLDrawable uRLDrawable) {
        FileInputStream fileInputStream;
        String str;
        OutputStream outputStream = null;
        try {
            ContentValues contentValues = new ContentValues();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uRLDrawable.getURL().toString());
            if (fileExtensionFromUrl != null) {
                str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            } else {
                str = null;
            }
            if (str != null) {
                contentValues.put(JobDbManager.COL_UP_MIME_TYPE, str);
            }
            Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert == null) {
                QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] uri = null");
                return false;
            }
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
            try {
                if (openOutputStream == null) {
                    QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] outputStream = null");
                    if (openOutputStream != null) {
                        try {
                            openOutputStream.close();
                        } catch (Exception e16) {
                            QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] close exception = " + e16);
                        }
                    }
                    return false;
                }
                File fileInLocal = uRLDrawable.getFileInLocal();
                if (fileInLocal != null) {
                    fileInputStream = new FileInputStream(fileInLocal);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read != -1) {
                                openOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Exception e17) {
                                    QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] close exception = " + e17);
                                }
                            }
                        }
                        openOutputStream.close();
                        fileInputStream.close();
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = openOutputStream;
                        th = th;
                        try {
                            QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] exception = " + th);
                            if (outputStream != null) {
                                try {
                                } catch (Exception e18) {
                                    return false;
                                }
                            }
                            return false;
                        } finally {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e182) {
                                    QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] close exception = " + e182);
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        }
                    }
                }
                QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] file == null");
                try {
                    openOutputStream.close();
                } catch (Exception e19) {
                    QLog.e("TroopImageSaveUtils", 1, "[savePic2SystemMedia] close exception = " + e19);
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }
}
