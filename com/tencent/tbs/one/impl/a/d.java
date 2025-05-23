package com.tencent.tbs.one.impl.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            g.c("Failed to close %s", closeable, e16);
        }
    }

    private static int b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i3;
            }
            outputStream.write(bArr, 0, read);
            i3 += read;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void d(File file) {
        if (!file.mkdirs()) {
            g.c("Failed to create directory %s", file.getAbsolutePath());
        }
    }

    public static void e(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                g.c("Failed to create non-exist directory %s", file.getAbsolutePath());
            }
        } else if (!file.isDirectory()) {
            if (!file.delete() || !file.mkdirs()) {
                g.c("Failed to create namesake directory %s", file.getAbsolutePath());
            }
        }
    }

    public static boolean a(File file) {
        try {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a(file2, true);
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e16) {
            g.c("recursivelyClearDirectory failed, directory is %s,exception is %s", file.getAbsolutePath(), Log.getStackTraceString(e16));
            return false;
        }
    }

    public static void b(File file, File file2) throws IOException {
        if (file.renameTo(file2)) {
            return;
        }
        c(file, file2);
        a(file, false);
    }

    private static void c(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IOException("Failed to create directory " + file2.getAbsolutePath());
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    c(file3, new File(file2, file3.getName()));
                }
                return;
            }
            return;
        }
        if (file.canRead()) {
            a(file, file2);
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/android_asset/")) {
            return str.substring(15);
        }
        if (str.startsWith("file:///android_asset/")) {
            return str.substring(22);
        }
        return null;
    }

    public static boolean a(File file, boolean z16) {
        File[] listFiles;
        if (!z16) {
            try {
                if (!file.exists()) {
                    return true;
                }
            } catch (Exception e16) {
                g.c("recursivelyDeleteFile failed,current file is %s,exception is %s", file.getAbsolutePath(), Log.getStackTraceString(e16));
                return false;
            }
        }
        if ((z16 && !file.isDirectory()) || file.isFile()) {
            return file.delete();
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2, z16);
            }
        }
        return file.delete();
    }

    public static void b(File file) {
        try {
            if (file.createNewFile()) {
                return;
            }
            g.c("Failed to create file %s, file already exists", file.getAbsolutePath());
        } catch (IOException e16) {
            g.c("Failed to create file %s", file.getAbsolutePath(), e16);
        }
    }

    public static void c(File file) {
        if (a(file, false)) {
            return;
        }
        g.c("Failed to delete file %s", file.getAbsolutePath());
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    @NonNull
    public static String a(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return new String(byteArrayOutputStream.toByteArray(), str);
    }

    public static String a(InputStream inputStream, String str, File file) throws IOException {
        i iVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file2 = new File(file.getPath() + ".tmp");
        i iVar2 = null;
        try {
            iVar = new i(new OutputStream[]{byteArrayOutputStream, new FileOutputStream(file2)});
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            a(inputStream, iVar);
            a(iVar);
            if (file2.renameTo(file)) {
                return new String(byteArrayOutputStream.toByteArray(), str);
            }
            throw new IOException();
        } catch (Throwable th6) {
            th = th6;
            iVar2 = iVar;
            a(iVar2);
            throw th;
        }
    }

    public static void a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file2).getChannel();
            fileChannel2.transferFrom(channel, 0L, channel.size());
            a(channel);
            a(fileChannel2);
        } catch (Throwable th6) {
            th = th6;
            FileChannel fileChannel3 = fileChannel2;
            fileChannel2 = channel;
            fileChannel = fileChannel3;
            a(fileChannel2);
            a(fileChannel);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(InputStream inputStream, File file, File file2) throws IOException {
        ZipOutputStream zipOutputStream;
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            if (file2 != null) {
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = null;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    a(zipInputStream);
                    a(zipOutputStream);
                    throw th;
                }
            } else {
                zipOutputStream = null;
            }
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            File file3 = new File(file, name);
                            if (nextEntry.isDirectory()) {
                                if (!file3.exists() && !file3.mkdirs()) {
                                    throw new IOException("Failed to create directory " + file3.getAbsolutePath());
                                }
                            } else {
                                File parentFile = file3.getParentFile();
                                if (!parentFile.exists() && !parentFile.mkdirs()) {
                                    throw new IOException("Failed to create directory " + parentFile.getAbsolutePath());
                                }
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file3));
                                try {
                                    b(zipInputStream, bufferedOutputStream2);
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Throwable th6) {
                                    th = th6;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    if (bufferedOutputStream != null) {
                                    }
                                    a(zipInputStream);
                                    a(zipOutputStream);
                                    throw th;
                                }
                            }
                            zipInputStream.closeEntry();
                        } else {
                            throw new IOException("Unsafe zip file extraction path found" + name);
                        }
                    } else {
                        g.a("FileUtils unzipStream  last  entry", new Object[0]);
                        do {
                        } while (inputStream.read(new byte[8192]) != -1);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        a(zipInputStream);
                        a(zipOutputStream);
                        return;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            zipOutputStream = null;
            zipInputStream = null;
        }
    }

    public static void a(String str, String str2, File file) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileOutputStream.write(str.getBytes(str2));
            a(fileOutputStream);
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("/android_asset/") || str.startsWith("file:///android_asset/");
    }

    public static InputStream a(Context context, String str, String str2) throws IOException {
        if (a(str2)) {
            return context.getResources().getAssets().open(b(str2));
        }
        if (new File(str2).isAbsolute()) {
            return new FileInputStream(str2);
        }
        String absolutePath = new File(str, str2).getAbsolutePath();
        if (a(absolutePath)) {
            return context.getResources().getAssets().open(b(absolutePath));
        }
        return new FileInputStream(absolutePath);
    }

    public static void a(Context context, String str, String str2, boolean z16) throws IOException {
        FileOutputStream fileOutputStream;
        String[] list = context.getAssets().list(str);
        if (list != null && list.length != 0) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (String str3 : list) {
                a(context, str + "/" + str3, str2 + "/" + str3, z16);
            }
            return;
        }
        if (new File(str2).exists() && !z16) {
            return;
        }
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
            } catch (FileNotFoundException unused) {
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                c(open, fileOutputStream);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            } catch (FileNotFoundException unused2) {
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = open;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }
}
