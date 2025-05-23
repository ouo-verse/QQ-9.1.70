package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ku {

    /* renamed from: a, reason: collision with root package name */
    private static final int f149085a = 4096;

    public static final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                a(byteArrayOutputStream);
            }
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        if (listFiles.length == 0) {
                            file.delete();
                            stack.pop();
                        } else {
                            for (File file2 : listFiles) {
                                if (file2.isDirectory()) {
                                    stack.push(file2.getAbsolutePath());
                                } else {
                                    file2.delete();
                                }
                            }
                        }
                    }
                } else {
                    file.delete();
                    stack.pop();
                }
            } else {
                stack.pop();
            }
        }
        return true;
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
            do {
                int read = inputStream.read(bArr, 0, RFixConstants.MD5_FILE_BUF_LENGTH);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } while (byteArrayOutputStream.size() < 102400);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                a(byteArrayOutputStream);
            }
        }
    }

    public static final InputStream b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(new File(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final long a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return -1L;
        }
        try {
            byte[] bArr = new byte[4096];
            long j3 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return j3;
                }
                outputStream.write(bArr, 0, read);
                j3 += read;
            }
        } catch (IOException unused) {
            return -1L;
        }
    }

    private static int a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return a(bArr, new File(str));
    }

    public static int a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        if (bArr != null && bArr.length != 0 && !file.isDirectory()) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                int length = bArr.length;
                a(fileOutputStream);
                return length;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                a(fileOutputStream2);
                return 0;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                a(fileOutputStream2);
                throw th;
            }
        }
        return 0;
    }

    private static boolean c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream.available() > 0) {
                    return true;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception unused) {
            return false;
        }
    }

    public static final InputStream a(File file) {
        try {
            if (file.exists() && file.isFile() && file.canRead()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    private static boolean a(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.renameTo(new File(str2));
        }
        return false;
    }

    public static void a(Bitmap... bitmapArr) {
        if (bitmapArr != null) {
            for (Bitmap bitmap : bitmapArr) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    private static void a(byte[] bArr, OutputStream outputStream) {
        if (bArr == null || bArr.length == 0 || outputStream == null) {
            return;
        }
        try {
            outputStream.write(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }
}
