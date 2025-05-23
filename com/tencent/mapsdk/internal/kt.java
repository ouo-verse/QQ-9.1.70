package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149078a = 1024;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149079b = 1048576;

    /* renamed from: c, reason: collision with root package name */
    public static final int f149080c = 1073741824;

    /* renamed from: d, reason: collision with root package name */
    public static File f149081d = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f149082e = "FileUtil";

    /* renamed from: f, reason: collision with root package name */
    private static final lo f149083f = new lo();

    public static File a(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        return file2;
    }

    public static File b(File file, String str) {
        File file2 = null;
        if (file != null && !TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf != -1) {
                String substring = str.substring(lastIndexOf + 1);
                File file3 = new File(file, str.substring(0, lastIndexOf));
                str = substring;
                file = file3;
            }
            if (!file.exists() && !file.mkdirs()) {
                if (Log.isLoggable(f149082e, 6)) {
                    Log.e(f149082e, "create file failed with mkdirs failed:" + file.getAbsolutePath());
                }
                return null;
            }
            file2 = new File(file, str);
            try {
                if (!file2.exists() && !file2.createNewFile() && Log.isLoggable(f149082e, 6)) {
                    Log.e(f149082e, "create file failed:" + file2.getAbsolutePath());
                }
            } catch (IOException e16) {
                if (Log.isLoggable(f149082e, 6)) {
                    Log.e(f149082e, "create file failed.", e16);
                }
            }
        }
        return file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static byte[] c(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (file != 0) {
            ?? exists = file.exists();
            try {
                try {
                    if (exists != 0) {
                        try {
                            exists = new FileInputStream((File) file);
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            byteArrayOutputStream = null;
                            exists = 0;
                        } catch (IOException e17) {
                            e = e17;
                            byteArrayOutputStream = null;
                            exists = 0;
                        } catch (Throwable th5) {
                            exists = 0;
                            th = th5;
                            file = 0;
                        }
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            byteArrayOutputStream = null;
                        } catch (IOException e19) {
                            e = e19;
                            byteArrayOutputStream = null;
                        } catch (Throwable th6) {
                            th = th6;
                            file = 0;
                            if (file != 0) {
                                try {
                                    file.flush();
                                    file.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            if (exists != 0) {
                                try {
                                    exists.close();
                                    throw th;
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = exists.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.flush();
                                byteArrayOutputStream.close();
                            } catch (IOException e28) {
                                e28.printStackTrace();
                            }
                            try {
                                exists.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                            }
                            return byteArray;
                        } catch (FileNotFoundException e36) {
                            e = e36;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                } catch (IOException e37) {
                                    e37.printStackTrace();
                                }
                            }
                            if (exists != 0) {
                                exists.close();
                            }
                            return null;
                        } catch (IOException e38) {
                            e = e38;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.flush();
                                    byteArrayOutputStream.close();
                                } catch (IOException e39) {
                                    e39.printStackTrace();
                                }
                            }
                            if (exists != 0) {
                                exists.close();
                            }
                            return null;
                        }
                    }
                } catch (IOException e46) {
                    e46.printStackTrace();
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static List<String> d(File file) {
        BufferedReader bufferedReader;
        Closeable closeable = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                if (exists != 0) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedReader = null;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedReader = null;
                    } catch (Throwable th5) {
                        th = th5;
                        ku.a(closeable);
                        throw th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                arrayList.add(readLine);
                            } else {
                                ku.a(bufferedReader);
                                return arrayList;
                            }
                        }
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        e.printStackTrace();
                        ku.a(bufferedReader);
                        return null;
                    } catch (IOException e19) {
                        e = e19;
                        e.printStackTrace();
                        ku.a(bufferedReader);
                        return null;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = exists;
            }
        }
        return null;
    }

    public static File e(File file) {
        if (file == null) {
            return null;
        }
        File parentFile = file.getParentFile();
        StringBuilder sb5 = new StringBuilder();
        lo loVar = f149083f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(System.currentTimeMillis());
        sb5.append(loVar.a(sb6.toString()));
        sb5.append(".tmp");
        return b(parentFile, sb5.toString());
    }

    public static long f(File file) {
        return a(file, (FileFilter) null);
    }

    private static File g(File file) {
        return a(file.getParentFile(), file.getName());
    }

    private static boolean h(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean a(String str) {
        return a(new File(str));
    }

    public static File[] e(File file, final String str) {
        return (file == null || !file.isDirectory()) ? new File[0] : file.listFiles(new FileFilter() { // from class: com.tencent.mapsdk.internal.kt.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return Pattern.compile(str).matcher(file2.getName()).matches();
            }
        });
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable, java.io.BufferedReader] */
    public static String a(File file, int i3) {
        Closeable closeable = null;
        if (file != null && file.exists()) {
            ?? r16 = -1;
            try {
                if (i3 != -1) {
                    try {
                        r16 = new BufferedReader(new FileReader(file));
                        int i16 = 0;
                        while (true) {
                            try {
                                String readLine = r16.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i16 == i3) {
                                    ku.a((Closeable) r16);
                                    return readLine;
                                }
                                i16++;
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                e.printStackTrace();
                                ku.a((Closeable) r16);
                                return null;
                            } catch (IOException e17) {
                                e = e17;
                                e.printStackTrace();
                                ku.a((Closeable) r16);
                                return null;
                            }
                        }
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        r16 = 0;
                    } catch (IOException e19) {
                        e = e19;
                        r16 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        ku.a(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = r16;
            }
        }
        return null;
    }

    public static int d(File file, String str) {
        if (file == null || !file.exists()) {
            return -1;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                int i3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            ku.a(bufferedReader2);
                            break;
                        }
                        if (readLine.startsWith(str)) {
                            ku.a(bufferedReader2);
                            return i3;
                        }
                        i3++;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        ku.a(bufferedReader);
                        return -1;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        ku.a(bufferedReader);
                        return -1;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        ku.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
            return -1;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0040 -> B:18:0x0043). Please report as a decompilation issue!!! */
    public static boolean a(File file, byte[] bArr) {
        boolean z16 = false;
        if (file == null || bArr == null || !a(file)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    z16 = true;
                } catch (FileNotFoundException e18) {
                    e = e18;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z16;
                } catch (IOException e19) {
                    e = e19;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e27) {
                e = e27;
            } catch (IOException e28) {
                e = e28;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean b(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(file);
        boolean z16 = false;
        while (!stack.isEmpty()) {
            File file2 = (File) stack.peek();
            if (file2.isFile()) {
                z16 = file2.delete();
                stack.pop();
            } else if (file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    z16 = file2.delete();
                    stack.pop();
                } else {
                    for (File file3 : listFiles) {
                        stack.push(file3);
                    }
                }
            }
        }
        return z16;
    }

    public static void c(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!file.exists()) {
            a(file);
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write((str + "\r\n").getBytes());
                    ku.a(randomAccessFile2);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    ku.a(randomAccessFile);
                } catch (IOException e17) {
                    e = e17;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    ku.a(randomAccessFile);
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    ku.a(randomAccessFile);
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(File file, int i3, String str) {
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || i3 == -1) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                try {
                    file = e(file);
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        int i16 = 0;
                        long j3 = 0;
                        while (true) {
                            try {
                                String readLine = randomAccessFile3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i16 == i3) {
                                    j3 = randomAccessFile3.getFilePointer() - "\r\n".getBytes().length;
                                } else if (i16 > i3) {
                                    randomAccessFile.write(readLine.getBytes("ISO-8859-1"));
                                }
                                i16++;
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                b(file);
                            } catch (IOException e17) {
                                e = e17;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                b(file);
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile2 = randomAccessFile3;
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                b(file);
                                throw th;
                            }
                        }
                        randomAccessFile3.seek(j3);
                        randomAccessFile3.write((str + "\r\n").getBytes());
                        randomAccessFile.seek(0L);
                        while (true) {
                            String readLine2 = randomAccessFile.readLine();
                            if (readLine2 == null) {
                                break;
                            } else {
                                randomAccessFile3.write(readLine2.getBytes("ISO-8859-1"));
                            }
                        }
                        ku.a(randomAccessFile3);
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        randomAccessFile = null;
                    } catch (IOException e19) {
                        e = e19;
                        randomAccessFile = null;
                    } catch (Throwable th6) {
                        th = th6;
                        randomAccessFile = null;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    file = null;
                    randomAccessFile = null;
                } catch (IOException e27) {
                    e = e27;
                    file = null;
                    randomAccessFile = null;
                } catch (Throwable th7) {
                    th = th7;
                    file = null;
                    randomAccessFile = null;
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                file = null;
                randomAccessFile = null;
            } catch (IOException e29) {
                e = e29;
                file = null;
                randomAccessFile = null;
            } catch (Throwable th8) {
                th = th8;
                file = null;
                randomAccessFile = null;
            }
            ku.a(randomAccessFile);
            b(file);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static void b(File file, byte[] bArr) {
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (!file.exists()) {
            a(file);
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile2.seek(randomAccessFile2.length());
                    randomAccessFile2.write(bArr);
                    ku.a(randomAccessFile2);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    ku.a(randomAccessFile);
                } catch (IOException e17) {
                    e = e17;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    ku.a(randomAccessFile);
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    ku.a(randomAccessFile);
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void b(File file, int i3) {
        File file2;
        RandomAccessFile randomAccessFile;
        if (!file.exists() || i3 == -1) {
            return;
        }
        boolean z16 = false;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                try {
                    file2 = e(file);
                    try {
                        randomAccessFile = new RandomAccessFile(file2, "rw");
                        int i16 = 0;
                        while (true) {
                            try {
                                String readLine = randomAccessFile3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i16 != i3) {
                                    randomAccessFile.write(readLine.getBytes("ISO-8859-1"));
                                    randomAccessFile.write("\r\n".getBytes());
                                } else {
                                    z16 = true;
                                }
                                i16++;
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (!z16) {
                                    b(file2);
                                    return;
                                }
                                b(file);
                                a(file2, file);
                            } catch (IOException e17) {
                                e = e17;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (!z16) {
                                    b(file2);
                                    return;
                                }
                                b(file);
                                a(file2, file);
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile2 = randomAccessFile3;
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (z16) {
                                    b(file);
                                    a(file2, file);
                                } else {
                                    b(file2);
                                }
                                throw th;
                            }
                        }
                        ku.a(randomAccessFile3);
                        ku.a(randomAccessFile);
                        if (!z16) {
                            b(file2);
                            return;
                        }
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        randomAccessFile = null;
                    } catch (IOException e19) {
                        e = e19;
                        randomAccessFile = null;
                    } catch (Throwable th6) {
                        th = th6;
                        randomAccessFile = null;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    file2 = null;
                    randomAccessFile = null;
                } catch (IOException e27) {
                    e = e27;
                    file2 = null;
                    randomAccessFile = null;
                } catch (Throwable th7) {
                    th = th7;
                    file2 = null;
                    randomAccessFile = null;
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                file2 = null;
                randomAccessFile = null;
            } catch (IOException e29) {
                e = e29;
                file2 = null;
                randomAccessFile = null;
            } catch (Throwable th8) {
                th = th8;
                file2 = null;
                randomAccessFile = null;
            }
            b(file);
            a(file2, file);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static boolean a(File file, File file2) {
        if (file == null || !file.exists()) {
            return false;
        }
        b(file2);
        return file.renameTo(file2);
    }

    private static boolean a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            f(file2);
        }
        return file.renameTo(new File(str2));
    }

    public static long a(File file, FileFilter fileFilter) {
        File[] listFiles;
        long j3 = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (file.isDirectory() && (listFiles = file.listFiles(fileFilter)) != null) {
            for (File file2 : listFiles) {
                j3 += a(file2, fileFilter);
            }
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return j3;
        }
        long length = file.length();
        File file3 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        file.renameTo(file3);
        file3.delete();
        return length;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String packageName = context.getPackageName();
            if (packageName != null && packageName.length() != 0) {
                return packageName.length() > 255 ? packageName.substring(0, 254) : packageName;
            }
            return "";
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void b(File file, int i3, String str) {
        File file2;
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || i3 == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        boolean z16 = false;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "rw");
                try {
                    file2 = e(file);
                    try {
                        randomAccessFile = new RandomAccessFile(file2, "rw");
                        int i16 = 0;
                        while (true) {
                            try {
                                String readLine = randomAccessFile3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i16 != i3) {
                                    randomAccessFile.write(readLine.getBytes("ISO-8859-1"));
                                    randomAccessFile.write("\r\n".getBytes());
                                } else {
                                    randomAccessFile.write((str + "\r\n").getBytes());
                                    z16 = true;
                                }
                                i16++;
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (!z16) {
                                    b(file2);
                                    return;
                                }
                                b(file);
                                a(file2, file);
                            } catch (IOException e17) {
                                e = e17;
                                randomAccessFile2 = randomAccessFile3;
                                e.printStackTrace();
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (!z16) {
                                    b(file2);
                                    return;
                                }
                                b(file);
                                a(file2, file);
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile2 = randomAccessFile3;
                                ku.a(randomAccessFile2);
                                ku.a(randomAccessFile);
                                if (z16) {
                                    b(file);
                                    a(file2, file);
                                } else {
                                    b(file2);
                                }
                                throw th;
                            }
                        }
                        ku.a(randomAccessFile3);
                        ku.a(randomAccessFile);
                        if (!z16) {
                            b(file2);
                            return;
                        }
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        randomAccessFile = null;
                    } catch (IOException e19) {
                        e = e19;
                        randomAccessFile = null;
                    } catch (Throwable th6) {
                        th = th6;
                        randomAccessFile = null;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    file2 = null;
                    randomAccessFile = null;
                } catch (IOException e27) {
                    e = e27;
                    file2 = null;
                    randomAccessFile = null;
                } catch (Throwable th7) {
                    th = th7;
                    file2 = null;
                    randomAccessFile = null;
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                file2 = null;
                randomAccessFile = null;
            } catch (IOException e29) {
                e = e29;
                file2 = null;
                randomAccessFile = null;
            } catch (Throwable th8) {
                th = th8;
                file2 = null;
                randomAccessFile = null;
            }
            b(file);
            a(file2, file);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.contains("../")) {
            trim = trim.replaceAll("\\.\\./", "");
        }
        while (trim.startsWith(File.separator)) {
            trim = trim.substring(1);
        }
        while (trim.endsWith(File.separator)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        return trim;
    }

    public static void b(File file, File file2) {
        Path path;
        Path path2;
        if (!file2.exists()) {
            a(file2.getParentFile(), file2.getName());
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    b(file3, new File(file2, file.getName()));
                }
                return;
            }
            return;
        }
        File file4 = new File(file2, file.getName());
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                path = file.toPath();
                path2 = file4.toPath();
                Files.copy(path, path2, new CopyOption[0]);
                return;
            } catch (IOException e16) {
                e16.printStackTrace();
                return;
            }
        }
        a(file4, c(file));
    }

    private static File[] b(File file, FileFilter fileFilter) {
        File[] fileArr = new File[0];
        return (file != null && file.isDirectory()) ? file.listFiles(fileFilter) : fileArr;
    }
}
