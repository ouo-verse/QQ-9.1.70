package com.tencent.mobileqq.zplan.avatar.image.easterEgg;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.open.base.l;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/easterEgg/a;", "", "", "zipDirPath", "b", "zipFromDirPath", "zipFileName", "a", "Ljava/io/File;", "unZipToDir", "unZipFromFile", "", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f331822a = new a();

    a() {
    }

    public final String a(String zipFromDirPath, String zipFileName) {
        Intrinsics.checkNotNullParameter(zipFromDirPath, "zipFromDirPath");
        Intrinsics.checkNotNullParameter(zipFileName, "zipFileName");
        QLog.i("ZPlanAvatarEasterEggPortraitCompressUtils", 1, "[compressPackage] dirPath:" + zipFromDirPath + ", zipFileName:" + zipFileName);
        String i3 = ZPlanAvatarEasterEggPortraitCacheManager.f331820a.i("zip/");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(zipFileName);
        String sb6 = sb5.toString();
        try {
            l.d(zipFromDirPath, sb6);
            return sb6;
        } catch (Throwable th5) {
            QLog.e("ZPlanAvatarShpImageCompressUtils", 1, "compress file error", th5);
            return "";
        }
    }

    public final String b(String zipDirPath) {
        Intrinsics.checkNotNullParameter(zipDirPath, "zipDirPath");
        QLog.i("ZPlanAvatarEasterEggPortraitCompressUtils", 1, "zipDirPath:" + zipDirPath);
        boolean z16 = false;
        if (zipDirPath.length() == 0) {
            return null;
        }
        File file = new File(zipDirPath);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length == 0) {
                z16 = true;
            }
            if (!z16) {
                return a(zipDirPath, System.currentTimeMillis() + ".zip");
            }
        }
        QLog.e("ZPlanAvatarEasterEggPortraitCompressUtils", 1, "zipDirPath:" + zipDirPath + " invalid");
        return null;
    }

    public final void c(File unZipToDir, File unZipFromFile) {
        Intrinsics.checkNotNullParameter(unZipToDir, "unZipToDir");
        Intrinsics.checkNotNullParameter(unZipFromFile, "unZipFromFile");
        QLog.i("ZPlanAvatarEasterEggPortraitCompressUtils", 1, "[unzipEasterEggPortraits] zipPath:" + unZipFromFile.getAbsolutePath());
        if (unZipFromFile.exists()) {
            try {
                ZipUtils.unZipFolder(unZipFromFile.getAbsolutePath(), unZipToDir.getAbsolutePath());
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
