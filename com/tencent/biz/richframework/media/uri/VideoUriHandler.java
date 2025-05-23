package com.tencent.biz.richframework.media.uri;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.media.MediaType;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoUriHandler implements IMediaUriHandler {
    private static final String MIME_TYPE_VIDEO_PREFIX = "video" + File.separator;
    public static final String VIDEO_ALBUM_ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath();

    @Override // com.tencent.biz.richframework.media.uri.IMediaUriHandler
    public UriWrapper getMediaUri(Context context, FileType fileType, File file, String str, boolean z16) {
        String str2;
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = File.separator + str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Pair<String, String> generateSaveFileName = RFWSaveUtil.generateSaveFileName(file, z16, "Video_", currentTimeMillis, VIDEO_ALBUM_ROOT_PATH, str2, fileType.getTypeInfo().getFileExtension());
        String str3 = (String) generateSaveFileName.first;
        String str4 = (String) generateSaveFileName.second;
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str3);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str3);
        contentValues.put("description", str3);
        contentValues.put("_size", Long.valueOf(file.length()));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, MIME_TYPE_VIDEO_PREFIX + fileType.getTypeInfo().getMIMEType());
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        if (Build.VERSION.SDK_INT < 29) {
            contentValues.put("_data", str4);
        } else {
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES + str2 + File.separator);
        }
        try {
            uri = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception e16) {
            RFWLog.fatal("VideoUriHandler", RFWLog.USR, e16);
            uri = null;
        }
        UriWrapper uriWrapper = new UriWrapper();
        uriWrapper.uri = uri;
        uriWrapper.newMediaPath = str4;
        uriWrapper.mimeType = MIME_TYPE_VIDEO_PREFIX + fileType.getTypeInfo().getMIMEType();
        return uriWrapper;
    }

    @Override // com.tencent.biz.richframework.media.uri.IMediaUriHandler
    public boolean isTarget(MediaType mediaType) {
        if (mediaType == MediaType.VIDEO) {
            return true;
        }
        return false;
    }
}
