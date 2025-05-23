package com.tencent.mobileqq.activity.shortvideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.shortvideo.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7209a {

        /* renamed from: a, reason: collision with root package name */
        public String f186311a;

        /* renamed from: b, reason: collision with root package name */
        public String f186312b;

        /* renamed from: c, reason: collision with root package name */
        public String f186313c;
    }

    @NonNull
    private static String a(File file) {
        File[] listFiles;
        File file2 = new File(file.getAbsolutePath() + File.separator + "audio_data_cache");
        if (file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
            return listFiles[0].getAbsolutePath();
        }
        return null;
    }

    public static C7209a b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                C7209a c7209a = new C7209a();
                if (file.exists() && file.isDirectory()) {
                    String c16 = c(file);
                    String a16 = a(file);
                    if (TextUtils.isEmpty(c16)) {
                        return null;
                    }
                    c7209a.f186311a = c16;
                    c7209a.f186312b = a16;
                    c7209a.f186313c = str;
                    return c7209a;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("EncodeVideoUtil", 2, "getVideoInfoByPath error", e16);
                }
            }
        }
        return null;
    }

    private static String c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".mp4")) {
                    return file2.getAbsolutePath();
                }
            }
            return null;
        }
        return null;
    }
}
