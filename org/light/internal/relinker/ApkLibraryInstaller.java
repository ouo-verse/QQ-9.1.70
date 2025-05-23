package org.light.internal.relinker;

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
import org.light.device.LightDeviceProperty;
import org.light.internal.relinker.ReLinker;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ZipFileInZipEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInZipEntry(ZipFile zipFile, ZipEntry zipEntry) {
            this.zipFile = zipFile;
            this.zipEntry = zipEntry;
        }
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    private ZipFileInZipEntry findAPKWithLibrary(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i3;
        String[] sourceDirectories = sourceDirectories(context);
        int length = sourceDirectories.length;
        int i16 = 0;
        ZipFile zipFile = null;
        int i17 = 0;
        while (i17 < length) {
            String str2 = sourceDirectories[i17];
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
                            reLinkerInstance.log("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new ZipFileInZipEntry(zipFile, entry);
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

    private String[] sourceDirectories(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (LightDeviceProperty.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null && strArr.length != 0) {
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
            return strArr2;
        }
        return new String[]{applicationInfo.sourceDir};
    }

    @Override // org.light.internal.relinker.ReLinker.LibraryInstaller
    public void installLibrary(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) {
        ZipFileInZipEntry findAPKWithLibrary;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long copy;
        ZipFileInZipEntry zipFileInZipEntry = null;
        Closeable closeable = null;
        try {
            findAPKWithLibrary = findAPKWithLibrary(context, strArr, str, reLinkerInstance);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (findAPKWithLibrary != null) {
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    if (i3 < 5) {
                        reLinkerInstance.log("Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = findAPKWithLibrary.zipFile.getInputStream(findAPKWithLibrary.zipEntry);
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
                                    copy = copy(inputStream, fileOutputStream);
                                    fileOutputStream.getFD().sync();
                                } catch (FileNotFoundException unused5) {
                                    closeSilently(inputStream);
                                    closeSilently(fileOutputStream);
                                    i3 = i16;
                                } catch (IOException unused6) {
                                    closeSilently(inputStream);
                                    closeSilently(fileOutputStream);
                                    i3 = i16;
                                } catch (Throwable th8) {
                                    th = th8;
                                    closeable = inputStream;
                                    closeSilently(closeable);
                                    closeSilently(fileOutputStream);
                                    throw th;
                                }
                                if (copy != file.length()) {
                                    closeSilently(inputStream);
                                    closeSilently(fileOutputStream);
                                } else {
                                    closeSilently(inputStream);
                                    closeSilently(fileOutputStream);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    try {
                                        ZipFile zipFile = findAPKWithLibrary.zipFile;
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
                        reLinkerInstance.log("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile2 = findAPKWithLibrary.zipFile;
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
            zipFileInZipEntry = findAPKWithLibrary;
            if (zipFileInZipEntry != null) {
                try {
                    ZipFile zipFile3 = zipFileInZipEntry.zipFile;
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
