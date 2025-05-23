package org.extra.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.extra.relinker.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a implements c.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: org.extra.relinker.a$a, reason: collision with other inner class name */
    /* loaded from: classes29.dex */
    public static class C10937a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f423556a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f423557b;

        public C10937a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f423556a = zipFile;
            this.f423557b = zipEntry;
        }
    }

    private String[] a(Context context) {
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

    private C10937a a(Context context, String[] strArr, String str, d dVar) {
        int i3;
        String[] a16 = a(context);
        int length = a16.length;
        int i16 = 0;
        ZipFile zipFile = null;
        int i17 = 0;
        while (i17 < length) {
            String str2 = a16[i17];
            int i18 = i16;
            while (true) {
                int i19 = i18 + 1;
                i3 = 5;
                if (i18 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i18 = i19;
                }
            }
            if (zipFile != null) {
                int i26 = i16;
                while (true) {
                    int i27 = i26 + 1;
                    if (i26 < i3) {
                        int length2 = strArr.length;
                        int i28 = i16;
                        while (i28 < length2) {
                            String str3 = RFixConstants.SO_PATH + File.separatorChar + strArr[i28] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i16] = str3;
                            objArr[1] = str2;
                            dVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C10937a(zipFile, entry);
                            }
                            i28++;
                            i16 = 0;
                        }
                        i26 = i27;
                        i3 = 5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i17++;
            i16 = 0;
        }
        return null;
    }

    @Override // org.extra.relinker.c.a
    public void a(Context context, String[] strArr, String str, File file, d dVar) {
        C10937a a16;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        C10937a c10937a = null;
        r0 = null;
        Closeable closeable = null;
        try {
            a16 = a(context, strArr, str, dVar);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (a16 == null) {
                throw new b(str);
            }
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                if (i3 < 5) {
                    dVar.a("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = a16.f423556a.getInputStream(a16.f423557b);
                            } catch (FileNotFoundException unused) {
                                inputStream = null;
                            } catch (IOException unused2) {
                                inputStream = null;
                            } catch (Throwable th6) {
                                th = th6;
                                inputStream = null;
                            }
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
                                            ZipFile zipFile = a16.f423556a;
                                            if (zipFile != null) {
                                                zipFile.close();
                                                return;
                                            }
                                            return;
                                        } catch (IOException unused3) {
                                            return;
                                        }
                                    }
                                } catch (FileNotFoundException unused4) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i3 = i16;
                                } catch (IOException unused5) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i3 = i16;
                                } catch (Throwable th7) {
                                    th = th7;
                                    closeable = fileOutputStream;
                                    a(inputStream);
                                    a(closeable);
                                    throw th;
                                }
                            } catch (FileNotFoundException unused6) {
                                fileOutputStream = null;
                                a(inputStream);
                                a(fileOutputStream);
                                i3 = i16;
                            } catch (IOException unused7) {
                                fileOutputStream = null;
                                a(inputStream);
                                a(fileOutputStream);
                                i3 = i16;
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        }
                    } catch (IOException unused8) {
                    }
                    i3 = i16;
                } else {
                    dVar.a("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile2 = a16.f423556a;
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
            c10937a = a16;
            if (c10937a != null) {
                try {
                    ZipFile zipFile3 = c10937a.f423556a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }

    private long a(InputStream inputStream, OutputStream outputStream) {
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

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
