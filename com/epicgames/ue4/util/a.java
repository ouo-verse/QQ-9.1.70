package com.epicgames.ue4.util;

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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/epicgames/ue4/util/a;", "", "", "path", "Ljava/io/File;", "c", "", "e", "fromPath", "toPath", "b", "d", "src", "dst", "logEnabled", "a", "<init>", "()V", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f32597a = new a();

    a() {
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
        Intrinsics.checkParameterIsNotNull(dst, "dst");
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

    public final boolean b(@NotNull String fromPath, @NotNull String toPath) {
        Intrinsics.checkParameterIsNotNull(fromPath, "fromPath");
        Intrinsics.checkParameterIsNotNull(toPath, "toPath");
        File file = new File(fromPath);
        if (file.exists()) {
            try {
                return a(file, d(toPath), true);
            } catch (IOException unused) {
                Log.d("FileUtil", "copy fail error ");
            }
        }
        return false;
    }

    @NotNull
    public final File c(@NotNull String path) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "path");
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
        }
        return file;
    }

    @NotNull
    public final File d(@NotNull String path) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "path");
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

    public final boolean e(@Nullable String path) {
        if (path == null) {
            return false;
        }
        return new File(path).exists();
    }
}
