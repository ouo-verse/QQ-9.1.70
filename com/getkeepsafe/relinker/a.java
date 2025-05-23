package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.getkeepsafe.relinker.b;
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

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements b.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.getkeepsafe.relinker.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0223a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f32853a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f32854b;

        public C0223a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f32853a = zipFile;
            this.f32854b = zipEntry;
        }
    }

    private void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long c(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    private C0223a d(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i3;
        String[] e16 = e(context);
        int length = e16.length;
        int i16 = 0;
        ZipFile zipFile = null;
        int i17 = 0;
        while (i17 < length) {
            String str2 = e16[i17];
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
                            reLinkerInstance.i("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C0223a(zipFile, entry);
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

    private String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return new String[]{applicationInfo.sourceDir};
    }

    @Override // com.getkeepsafe.relinker.b.a
    public void a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) {
        C0223a d16;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long c16;
        C0223a c0223a = null;
        Closeable closeable = null;
        try {
            d16 = d(context, strArr, str, reLinkerInstance);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (d16 != null) {
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    if (i3 < 5) {
                        reLinkerInstance.i("Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = d16.f32853a.getInputStream(d16.f32854b);
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                    } catch (FileNotFoundException unused) {
                                        fileOutputStream = null;
                                    } catch (IOException unused2) {
                                        fileOutputStream = null;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileOutputStream = null;
                                    }
                                } catch (FileNotFoundException unused3) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (IOException unused4) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (Throwable th7) {
                                    th = th7;
                                    fileOutputStream = null;
                                }
                                try {
                                    c16 = c(inputStream, fileOutputStream);
                                    fileOutputStream.getFD().sync();
                                } catch (FileNotFoundException unused5) {
                                    b(inputStream);
                                    b(fileOutputStream);
                                    i3 = i16;
                                } catch (IOException unused6) {
                                    b(inputStream);
                                    b(fileOutputStream);
                                    i3 = i16;
                                } catch (Throwable th8) {
                                    th = th8;
                                    closeable = inputStream;
                                    b(closeable);
                                    b(fileOutputStream);
                                    throw th;
                                }
                                if (c16 != file.length()) {
                                    b(inputStream);
                                    b(fileOutputStream);
                                } else {
                                    b(inputStream);
                                    b(fileOutputStream);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    try {
                                        ZipFile zipFile = d16.f32853a;
                                        if (zipFile != null) {
                                            zipFile.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused7) {
                                        return;
                                    }
                                }
                            }
                        } catch (IOException unused8) {
                        }
                        i3 = i16;
                    } else {
                        reLinkerInstance.h("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile2 = d16.f32853a;
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
            } else {
                throw new MissingLibraryException(str);
            }
        } catch (Throwable th9) {
            th = th9;
            c0223a = d16;
            if (c0223a != null) {
                try {
                    ZipFile zipFile3 = c0223a.f32853a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }
}
