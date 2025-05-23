package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.am;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileUtilImpl implements IFileUtil {
    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String combinPath(String str, String str2) {
        return am.a(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean copyFile(File file, File file2) {
        return am.b(file, file2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean deleteFile(File file) {
        return am.c(file);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public void deleteSubFile(File file) {
        am.e(file);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean fileExistsAndNotEmpty(String str) {
        return am.f(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String filesizeToString(long j3) {
        return am.g(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public Bitmap getBitmapByPath(String str) {
        return am.i(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String getExtension(String str) {
        return am.j(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String getFileDirectoryOf(String str) {
        return am.k(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public FileInfo getFileInfo(File file) {
        return am.l(file);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String getFileNameNoEx(String str) {
        return am.m(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public long getFileSize(String str) {
        return am.n(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public ArrayList<FileInfo> getFiles(String str, boolean z16, int i3) {
        return am.o(str, z16, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String getThumbnailPath(Context context) {
        return am.p(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean isFileExists(String str) {
        return am.q(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean moveFile(File file, File file2) throws Exception {
        return am.r(file, file2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean writeBitmapToFile(Bitmap bitmap, String str) throws IOException {
        return am.u(bitmap, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean deleteFile(String str) {
        return am.d(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public String filesizeToString(long j3, int i3) {
        return am.h(j3, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileUtil
    public boolean writeBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) throws IOException {
        return am.v(bitmap, str, compressFormat);
    }
}
