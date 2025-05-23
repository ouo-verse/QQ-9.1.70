package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileUtil extends QRouteApi {
    String combinPath(String str, String str2);

    boolean copyFile(File file, File file2);

    boolean deleteFile(File file);

    boolean deleteFile(String str);

    void deleteSubFile(File file);

    boolean fileExistsAndNotEmpty(String str);

    String filesizeToString(long j3);

    String filesizeToString(long j3, int i3);

    Bitmap getBitmapByPath(String str);

    String getExtension(String str);

    String getFileDirectoryOf(String str);

    FileInfo getFileInfo(File file);

    String getFileNameNoEx(String str);

    long getFileSize(String str);

    ArrayList<FileInfo> getFiles(String str, boolean z16, int i3);

    String getThumbnailPath(Context context);

    boolean isFileExists(String str);

    boolean moveFile(File file, File file2) throws Exception;

    boolean writeBitmapToFile(Bitmap bitmap, String str) throws IOException;

    boolean writeBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) throws IOException;
}
