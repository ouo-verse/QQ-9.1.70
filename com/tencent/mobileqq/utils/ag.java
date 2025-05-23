package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f307402a = {"libc++_shared.so", "libxplatform.so"};

    public static String a(String str) {
        return "/qlink-lib/";
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(Context context, String str, String str2, Set<String> set) {
        Throwable th5;
        QZipInputStream qZipInputStream;
        IOException iOException;
        StringBuilder sb5;
        Throwable th6;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        String name;
        String str3;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            QZipInputStream qZipInputStream2 = new QZipInputStream(new BufferedInputStream(context.getAssets().open(str)));
            BufferedOutputStream bufferedOutputStream = null;
            while (true) {
                try {
                    ZipEntry nextEntry = qZipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        try {
                            try {
                                name = nextEntry.getName();
                                QLog.d("DependSoFixHelper", 1, "strEntry: " + name);
                            } catch (Exception e16) {
                                e = e16;
                            }
                            if (!TextUtils.isEmpty(name) && !name.contains("../")) {
                                try {
                                } catch (Exception e17) {
                                    e = e17;
                                    fileOutputStream2 = null;
                                    QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e);
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (IOException e18) {
                                            QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e18);
                                        }
                                    }
                                    if (fileOutputStream2 == null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e19) {
                                            QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e19);
                                        }
                                    }
                                }
                                if (set.contains(name)) {
                                    File file2 = new File(str2 + name);
                                    if (file2.exists()) {
                                        QLog.i("DependSoFixHelper", 1, "success unzip4Asset " + file2.getAbsolutePath() + " already exist");
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e26) {
                                                str3 = "unzip4Asset error: " + e26;
                                                QLog.e("DependSoFixHelper", 1, str3);
                                            }
                                        }
                                    } else {
                                        byte[] bArr = new byte[4096];
                                        fileOutputStream2 = new FileOutputStream(file2);
                                        try {
                                            try {
                                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2, 4096);
                                                while (true) {
                                                    try {
                                                        int read = qZipInputStream2.read(bArr, 0, 4096);
                                                        if (read == -1) {
                                                            break;
                                                        } else {
                                                            bufferedOutputStream2.write(bArr, 0, read);
                                                        }
                                                    } catch (Exception e27) {
                                                        e = e27;
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e);
                                                        if (bufferedOutputStream != null) {
                                                        }
                                                        if (fileOutputStream2 == null) {
                                                        }
                                                    } catch (Throwable th7) {
                                                        th6 = th7;
                                                        fileOutputStream = fileOutputStream2;
                                                        bufferedOutputStream = bufferedOutputStream2;
                                                        if (bufferedOutputStream != null) {
                                                            try {
                                                                bufferedOutputStream.close();
                                                            } catch (IOException e28) {
                                                                QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e28);
                                                            }
                                                        }
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                                throw th6;
                                                            } catch (IOException e29) {
                                                                QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e29);
                                                                throw th6;
                                                            }
                                                        }
                                                        throw th6;
                                                    }
                                                }
                                                bufferedOutputStream2.flush();
                                                fileOutputStream2.flush();
                                                QLog.i("DependSoFixHelper", 1, "success unzip4Asset " + name + " to " + file2.getAbsolutePath() + ", exist = " + file2.exists());
                                                try {
                                                    bufferedOutputStream2.close();
                                                } catch (IOException e36) {
                                                    QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e36);
                                                }
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e37) {
                                                    QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e37);
                                                }
                                                bufferedOutputStream = bufferedOutputStream2;
                                            } catch (Exception e38) {
                                                e = e38;
                                            }
                                        } catch (Throwable th8) {
                                            th6 = th8;
                                            fileOutputStream = fileOutputStream2;
                                        }
                                    }
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e39) {
                                    str3 = "unzip4Asset error: " + e39;
                                    QLog.e("DependSoFixHelper", 1, str3);
                                }
                            }
                        } catch (Throwable th9) {
                            th6 = th9;
                            fileOutputStream = null;
                        }
                    } else {
                        try {
                            qZipInputStream2.close();
                            return;
                        } catch (IOException e46) {
                            iOException = e46;
                            sb5 = new StringBuilder();
                            sb5.append("unzip4Asset error: ");
                            sb5.append(iOException);
                            QLog.e("DependSoFixHelper", 1, sb5.toString());
                            return;
                        }
                    }
                } catch (Exception e47) {
                    e = e47;
                    qZipInputStream = qZipInputStream2;
                    try {
                        QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e);
                        if (qZipInputStream != null) {
                            try {
                                qZipInputStream.close();
                                return;
                            } catch (IOException e48) {
                                iOException = e48;
                                sb5 = new StringBuilder();
                                sb5.append("unzip4Asset error: ");
                                sb5.append(iOException);
                                QLog.e("DependSoFixHelper", 1, sb5.toString());
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th10) {
                        th5 = th10;
                        if (qZipInputStream == null) {
                            try {
                                qZipInputStream.close();
                                throw th5;
                            } catch (IOException e49) {
                                QLog.e("DependSoFixHelper", 1, "unzip4Asset error: " + e49);
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Throwable th11) {
                    th5 = th11;
                    qZipInputStream = qZipInputStream2;
                    if (qZipInputStream == null) {
                    }
                }
            }
        } catch (Exception e56) {
            e = e56;
            qZipInputStream = null;
        } catch (Throwable th12) {
            th5 = th12;
            qZipInputStream = null;
        }
    }

    private static boolean c(Context context, String str) {
        String str2 = AppSetting.l() + "_64";
        String str3 = "key_so_" + str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("QLINK_SO_SP", 4);
        String string = sharedPreferences.getString(str3, "");
        boolean z16 = !TextUtils.equals(str2, string);
        if (QLog.isColorLevel()) {
            QLog.w("DependSoFixHelper", 2, "needUpdateSo, libName[" + str + "], nowVersion[" + string + "], revision[" + str2 + "], needUpdate[" + z16 + "]");
        }
        if (z16) {
            if (TextUtils.equals("0_64", str2)) {
                sharedPreferences.edit().putString(str3, "-1_64").apply();
            } else {
                sharedPreferences.edit().putString(str3, str2).apply();
            }
        }
        return z16;
    }

    public static void d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.w("DependSoFixHelper", 1, "syncDoUnzipWork() start ");
        if (context == null) {
            context = BaseApplication.getContext();
        }
        String str = SoLoadCore.getAppWorkPath(context) + "/qlink-lib/";
        HashSet hashSet = new HashSet(Arrays.asList(f307402a));
        Iterator it = hashSet.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            File file = new File(str + str2);
            if (!file.exists()) {
                z16 = true;
            }
            if (c(context, str2)) {
                if (file.exists()) {
                    file.delete();
                }
                z16 = true;
            }
        }
        if (!z16) {
            QLog.d("DependSoFixHelper", 1, "unzip4Asset: soFile.exists()");
            return;
        }
        b(context, "qlink_64_deps.zip", str, hashSet);
        b(context, "libc++_shared.zip", str, hashSet);
        QLog.w("DependSoFixHelper", 1, "syncDoUnzipWork() spend total time = " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
