package com.tencent.mobileqq.wink.edit.manager;

import androidx.annotation.NonNull;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes21.dex */
public class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z16, String str, AEEditorDownloadResBean aEEditorDownloadResBean) {
        if (!z16) {
            b(str, aEEditorDownloadResBean.getId());
        } else {
            FileUtils.deleteFile(d(str, aEEditorDownloadResBean.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(str3);
        String sb6 = sb5.toString();
        if (FileUtils.fileExists(sb6)) {
            FileUtils.deleteDirectory(sb6);
        }
    }

    @NonNull
    public static String c(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str2);
        sb5.append(str4);
        sb5.append(str3);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str2);
        sb5.append(str3);
        return sb5.toString() + str2 + ".zip";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str, @NonNull AEEditorDownloadResBean aEEditorDownloadResBean) {
        return new File(c(str, aEEditorDownloadResBean.getId(), aEEditorDownloadResBean.getMd5())).exists();
    }

    static boolean f(String str, String str2, String str3, String str4) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().replaceAll("\\p{C}", "").equals(str2)) {
                        w53.b.a(str4, "begin rename zip folder---from: " + file2.getName() + ", to: " + str3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str);
                        sb5.append(file2.getName());
                        return FileUtils.rename(sb5.toString(), str + str3);
                    }
                }
                w53.b.c(str4, "reNameFile--NOT found folder named " + str2);
            }
        } else {
            w53.b.c(str4, "reNameFile--toDir not exists or not a directory: " + file);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str, String str2) {
        InputStream inputStream = null;
        try {
            inputStream = com.tencent.mobileqq.wink.b.c().getAssets().open(str);
            String h16 = com.tencent.biz.common.util.k.h(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return h16;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return h16;
                }
            }
            return h16;
        } catch (Throwable th5) {
            try {
                w53.b.d(str2, "readAssetsFileContent---read assets json exception: fileName=" + str, th5);
                th5.printStackTrace();
                return "";
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String str, String str2, String str3, String str4, String str5) {
        if (i(str, str2, str3, str4, str5)) {
            return true;
        }
        return j(str, str2, str3, str4, str5);
    }

    static boolean i(String str, String str2, String str3, String str4, String str5) {
        try {
            ZipUtils.unZipFile(new File(str), str2);
            return f(str2, str3, str4, str5);
        } catch (Exception e16) {
            w53.b.d(str5, "unZipHasPackage--exception ", e16);
            return false;
        }
    }

    static boolean j(String str, String str2, String str3, String str4, String str5) {
        File file = new File(str2 + str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipUtils.unZipFile(new File(str), str2 + str3 + "/");
        } catch (Exception e16) {
            w53.b.d(str5, "unZipNoPackage-- exception ", e16);
        }
        w53.b.c(str5, "unZipNoPackage-- zipPath: " + str2 + str3);
        return f(str2, str3, str4, str5);
    }
}
