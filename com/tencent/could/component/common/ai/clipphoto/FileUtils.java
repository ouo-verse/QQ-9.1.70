package com.tencent.could.component.common.ai.clipphoto;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int ANDROID_R = 30;
    private static final String TAG = "FileUtils";
    public static Uri uri;

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static File createImageFile(Context context, boolean z16) {
        String str;
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            if (z16) {
                str = "txc_ocr_" + format + "_crop.jpg";
            } else {
                str = "txc_ocr_" + format + ".jpg";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getAppRootDirPath(context));
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("capture");
            File file = new File(sb5.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            if (Build.VERSION.SDK_INT >= 30) {
                File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + str2 + str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", file2.getAbsolutePath());
                contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
                contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
                uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                return file2;
            }
            return new File(file.getAbsolutePath() + str2 + str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    public static File getAppRootDirPath(Context context) {
        return context.getExternalFilesDir(null).getAbsoluteFile();
    }
}
