package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes12.dex */
public class q {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a implements Comparator<FileInfo> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            if (fileInfo.m()) {
                if (!fileInfo2.m()) {
                    return -1;
                }
            } else if (fileInfo2.m()) {
                return 1;
            }
            if (fileInfo.e() > fileInfo2.e()) {
                return -1;
            }
            if (fileInfo.e() != fileInfo2.e()) {
                return 1;
            }
            return 0;
        }
    }

    public static String a(String str, String str2) {
        return i().combinPath(str, str2);
    }

    public static boolean b(File file, File file2) {
        return i().copyFile(file, file2);
    }

    public static boolean c(File file) {
        return i().deleteFile(file);
    }

    public static boolean d(String str) {
        return i().deleteFile(str);
    }

    public static void e(File file) {
        i().deleteSubFile(file);
    }

    public static boolean f(String str) {
        return i().fileExistsAndNotEmpty(str);
    }

    public static String g(long j3) {
        return i().filesizeToString(j3);
    }

    public static String h(long j3, int i3) {
        return i().filesizeToString(j3, i3);
    }

    public static IFileUtil i() {
        return (IFileUtil) QRoute.api(IFileUtil.class);
    }

    public static String j(String str) {
        return i().getExtension(str);
    }

    public static String k(String str) {
        return i().getFileDirectoryOf(str);
    }

    public static FileInfo l(File file) {
        return i().getFileInfo(file);
    }

    public static long m(String str) {
        return i().getFileSize(str);
    }

    public static ArrayList<FileInfo> n(String str, boolean z16, int i3) {
        return i().getFiles(str, z16, i3);
    }

    public static String o(Context context) {
        return i().getThumbnailPath(context);
    }

    public static boolean p(String str) {
        return i().isFileExists(str);
    }

    public static boolean q(Bitmap bitmap, String str) throws IOException {
        return i().writeBitmapToFile(bitmap, str);
    }
}
