package com.tencent.luggage.wxa.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.luggage.wxa.b.c;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements c.a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6024a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f121800a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f121801b;

        public C6024a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f121800a = zipFile;
            this.f121801b = zipEntry;
        }
    }

    public final String[] a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    public final C6024a a(Context context, String[] strArr, String str, d dVar) {
        String[] a16 = a(context);
        int length = a16.length;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i16 >= length) {
                return null;
            }
            String str2 = a16[i16];
            int i17 = i3;
            while (true) {
                int i18 = i17 + 1;
                if (i17 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i17 = i18;
                }
            }
            if (zipFile != null) {
                int i19 = i3;
                while (true) {
                    int i26 = i19 + 1;
                    if (i19 < 5) {
                        int length2 = strArr.length;
                        int i27 = i3;
                        while (i27 < length2) {
                            String str3 = RFixConstants.SO_PATH + File.separatorChar + strArr[i27] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i3] = str3;
                            objArr[1] = str2;
                            dVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C6024a(zipFile, entry);
                            }
                            i27++;
                            i3 = 0;
                        }
                        i19 = i26;
                        i3 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i16++;
            i3 = 0;
        }
    }

    public final String[] a(Context context, String str) {
        Pattern compile = Pattern.compile(RFixConstants.SO_PATH + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : a(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // com.tencent.luggage.wxa.b.c.a
    public void a(Context context, String[] strArr, String str, File file, d dVar) {
        String[] strArr2;
        Throwable th5;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C6024a c6024a = null;
        r0 = null;
        Closeable closeable = null;
        try {
            C6024a a16 = a(context, strArr, str, dVar);
            try {
                if (a16 == null) {
                    try {
                        strArr2 = a(context, str);
                    } catch (Exception e16) {
                        strArr2 = new String[]{e16.toString()};
                    }
                    throw new b(str, strArr, strArr2);
                }
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    if (i3 < 5) {
                        dVar.a("Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = a16.f121800a.getInputStream(a16.f121801b);
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            long a17 = a(inputStream, fileOutputStream);
                                            fileOutputStream.getFD().sync();
                                            if (a17 != file.length()) {
                                                a(inputStream);
                                                a(fileOutputStream);
                                            } else {
                                                a(inputStream);
                                                a(fileOutputStream);
                                                file.setReadable(true, false);
                                                file.setExecutable(true, false);
                                                file.setWritable(true);
                                                try {
                                                    ZipFile zipFile = a16.f121800a;
                                                    if (zipFile != null) {
                                                        zipFile.close();
                                                        return;
                                                    }
                                                    return;
                                                } catch (IOException unused) {
                                                    return;
                                                }
                                            }
                                        } catch (FileNotFoundException unused2) {
                                            a(inputStream);
                                            a(fileOutputStream);
                                            i3 = i16;
                                        } catch (IOException unused3) {
                                            a(inputStream);
                                            a(fileOutputStream);
                                            i3 = i16;
                                        } catch (Throwable th6) {
                                            th5 = th6;
                                            closeable = fileOutputStream;
                                            a(inputStream);
                                            a(closeable);
                                            throw th5;
                                        }
                                    } catch (FileNotFoundException unused4) {
                                        fileOutputStream = null;
                                        a(inputStream);
                                        a(fileOutputStream);
                                        i3 = i16;
                                    } catch (IOException unused5) {
                                        fileOutputStream = null;
                                        a(inputStream);
                                        a(fileOutputStream);
                                        i3 = i16;
                                    } catch (Throwable th7) {
                                        th5 = th7;
                                    }
                                } catch (FileNotFoundException unused6) {
                                    inputStream = null;
                                } catch (IOException unused7) {
                                    inputStream = null;
                                } catch (Throwable th8) {
                                    th5 = th8;
                                    inputStream = null;
                                }
                            }
                        } catch (IOException unused8) {
                        }
                        i3 = i16;
                    } else {
                        dVar.a("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile2 = a16.f121800a;
                            if (zipFile2 != null) {
                                zipFile2.close();
                                return;
                            }
                            return;
                        } catch (IOException unused9) {
                            return;
                        }
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                c6024a = a16;
                if (c6024a != null) {
                    try {
                        ZipFile zipFile3 = c6024a.f121800a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    public final long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }

    public final void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
