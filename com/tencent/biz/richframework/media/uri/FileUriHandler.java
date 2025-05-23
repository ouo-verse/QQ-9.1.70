package com.tencent.biz.richframework.media.uri;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.util.RFWMimeUtil;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileUriHandler {
    public static final String DOWNLOAD_ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();

    public static String getDownloadDestPath(String str, String str2) {
        makeDownloadFolderDir(str);
        String str3 = "File_" + System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(DOWNLOAD_ROOT_PATH);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str);
        sb5.append(str4);
        sb5.append(str3);
        sb5.append(getExtension(str2));
        return sb5.toString();
    }

    private static String getExtension(String str) {
        String fileExtensionFromFilePath = RFWFileUtils.getFileExtensionFromFilePath(str);
        if (!TextUtils.isEmpty(fileExtensionFromFilePath)) {
            return "." + fileExtensionFromFilePath;
        }
        return "";
    }

    @RequiresApi(api = 29)
    public static UriWrapper getMediaUri(Context context, File file, String str, boolean z16) {
        Uri uri;
        Uri uri2;
        String mimeByMimeTool = RFWMimeUtil.getMimeByMimeTool(file.getPath());
        if (TextUtils.isEmpty(mimeByMimeTool)) {
            mimeByMimeTool = "application/octet-stream";
        }
        long currentTimeMillis = System.currentTimeMillis();
        Pair<String, String> generateSaveFileName = RFWSaveUtil.generateSaveFileName(file, z16, "File_", currentTimeMillis, DOWNLOAD_ROOT_PATH, str, RFWFileUtils.getFileExtensionFromFilePath(file.getPath()));
        String str2 = (String) generateSaveFileName.first;
        String str3 = (String) generateSaveFileName.second;
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str2);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str2);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, mimeByMimeTool);
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.DIRECTORY_DOWNLOADS);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str);
        sb5.append(str4);
        contentValues.put("relative_path", sb5.toString());
        try {
            ContentResolver contentResolver = context.getContentResolver();
            uri2 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
            uri = contentResolver.insert(uri2, contentValues);
        } catch (Exception e16) {
            RFWLog.fatal("FileUriHandler", RFWLog.USR, e16);
            uri = null;
        }
        UriWrapper uriWrapper = new UriWrapper();
        uriWrapper.uri = uri;
        uriWrapper.newMediaPath = str3;
        uriWrapper.mimeType = mimeByMimeTool;
        return uriWrapper;
    }

    private static void makeDownloadFolderDir(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        File file = new File(DOWNLOAD_ROOT_PATH, str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
