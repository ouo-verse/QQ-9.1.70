package com.tencent.zplan.common.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J \u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/zplan/common/utils/c;", "", "Ljava/io/File;", "f", "", "", "path", "", tl.h.F, "fromPath", "toPath", "b", "c", "src", "dst", "logEnabled", "a", "g", "dirStr", "e", "filePath", "d", "j", "url", "", "i", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f385288a = new c();

    c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean a(@Nullable File src, @NotNull File dst, boolean logEnabled) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(dst, "dst");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (dst.exists()) {
                    dst.delete();
                }
                if (dst.getParentFile() != null && !dst.getParentFile().exists()) {
                    dst.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((File) dst);
                try {
                    dst = new BufferedInputStream(new FileInputStream(src));
                    try {
                        try {
                            bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            bufferedInputStream2 = dst;
                            if (logEnabled) {
                                Log.e("FileUtil", "copyFile error, ", e);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e17);
                                    }
                                }
                            }
                            if (bufferedInputStream2 == null) {
                                return false;
                            }
                            try {
                                bufferedInputStream2.close();
                                return false;
                            } catch (IOException e18) {
                                e = e18;
                                if (!logEnabled) {
                                    return false;
                                }
                                Log.e("FileUtil", "copyFile error, ", e);
                                return false;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e19) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e19);
                                    }
                                }
                            }
                            if (dst != 0) {
                                try {
                                    dst.close();
                                } catch (IOException e26) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e26);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (OutOfMemoryError unused) {
                        try {
                            bArr = new byte[4096];
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            fileOutputStream = fileOutputStream2;
                            bufferedInputStream = dst;
                            if (logEnabled) {
                                Log.e("FileUtil", "copyFile error, ", e);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e28) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e28);
                                    }
                                }
                            }
                            if (bufferedInputStream == null) {
                                return false;
                            }
                            try {
                                bufferedInputStream.close();
                                return false;
                            } catch (IOException e29) {
                                e = e29;
                                if (!logEnabled) {
                                    return false;
                                }
                                Log.e("FileUtil", "copyFile error, ", e);
                                return false;
                            }
                        }
                    }
                    while (true) {
                        int read = dst.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                            fileOutputStream2.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException e36) {
                                if (logEnabled) {
                                    Log.e("FileUtil", "copyFile error, ", e36);
                                }
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        dst.close();
                    } catch (IOException e37) {
                        if (logEnabled) {
                            Log.e("FileUtil", "copyFile error, ", e37);
                        }
                    }
                    return true;
                } catch (IOException e38) {
                    e = e38;
                    dst = 0;
                } catch (OutOfMemoryError e39) {
                    e = e39;
                    dst = 0;
                } catch (Throwable th6) {
                    th = th6;
                    dst = 0;
                }
            } catch (IOException e46) {
                e = e46;
                bufferedInputStream2 = null;
            } catch (OutOfMemoryError e47) {
                e = e47;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                dst = 0;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public final boolean b(@Nullable String fromPath, @Nullable String toPath) {
        File file = new File(fromPath);
        if (file.exists()) {
            try {
                return a(file, c(toPath), true);
            } catch (IOException unused) {
                Log.d("FileUtil", "copy fail error ");
            }
        }
        return false;
    }

    @NotNull
    public final File c(@Nullable String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public final void d(@Nullable String filePath) {
        if (!h(filePath)) {
            try {
                c(filePath);
            } catch (IOException e16) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("FileUtil", 1, "createFileIfNotExits", e16);
                }
            }
        }
    }

    public final void e(@Nullable String dirStr) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        if (dirStr != null) {
            int length = dirStr.length() - 1;
            int i16 = 0;
            boolean z19 = false;
            while (i16 <= length) {
                if (!z19) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) dirStr.charAt(i3), 32) <= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z19) {
                    if (!z18) {
                        z19 = true;
                    } else {
                        i16++;
                    }
                } else if (!z18) {
                    break;
                } else {
                    length--;
                }
            }
            if (dirStr.subSequence(i16, length + 1).toString().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                File file = new File(dirStr);
                if (!file.exists()) {
                    return;
                }
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (true ^ z17) {
                        int length2 = listFiles.length;
                        for (int i17 = 0; i17 < length2; i17++) {
                            File file2 = listFiles[i17];
                            Intrinsics.checkNotNullExpressionValue(file2, "childDirList[i]");
                            if (file2.isDirectory()) {
                                File file3 = listFiles[i17];
                                Intrinsics.checkNotNullExpressionValue(file3, "childDirList[i]");
                                e(file3.getAbsolutePath());
                            } else {
                                listFiles[i17].delete();
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    public final void f(@NotNull File f16) {
        File[] listFiles;
        boolean z16;
        Intrinsics.checkNotNullParameter(f16, "f");
        if (f16.isDirectory() && (listFiles = f16.listFiles()) != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (File file : listFiles) {
                    f(file);
                }
            }
        }
        f16.delete();
    }

    public final boolean g(@Nullable String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        File file = new File(path);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public final boolean h(@Nullable String path) {
        if (path == null) {
            return false;
        }
        return new File(path).exists();
    }

    public final long i(@Nullable String url) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(url);
            if (!file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                long available = fileInputStream2.available();
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return available;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0L;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final boolean j(@Nullable String fromPath, @Nullable String toPath) {
        if (fromPath == null || toPath == null) {
            return false;
        }
        File file = new File(fromPath);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(toPath));
    }
}
