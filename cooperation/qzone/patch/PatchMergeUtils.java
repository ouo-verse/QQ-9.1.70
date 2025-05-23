package cooperation.qzone.patch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

/* loaded from: classes38.dex */
public class PatchMergeUtils {
    private static void writeZipEntry(JarOutputStream jarOutputStream, ZipEntry zipEntry, InputStream inputStream) {
        try {
            jarOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    jarOutputStream.closeEntry();
                    return;
                }
                jarOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean MergeApk(String str, String str2, String str3) {
        JarFile jarFile;
        JarFile jarFile2;
        JarOutputStream jarOutputStream;
        JarOutputStream jarOutputStream2 = null;
        try {
            jarOutputStream = new JarOutputStream(new FileOutputStream(str3));
            try {
                jarFile = new JarFile(new File(str));
                try {
                    jarFile2 = new JarFile(new File(str2));
                } catch (Exception e16) {
                    e = e16;
                    jarFile2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    jarFile2 = null;
                }
            } catch (Exception e17) {
                e = e17;
                jarFile = null;
                jarFile2 = null;
            } catch (Throwable th6) {
                th = th6;
                jarFile = null;
                jarFile2 = null;
            }
        } catch (Exception e18) {
            e = e18;
            jarFile = null;
            jarFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            jarFile = null;
            jarFile2 = null;
        }
        try {
            HashSet hashSet = new HashSet();
            Enumeration<JarEntry> entries = jarFile2.entries();
            int i3 = 1;
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (nextElement.getName().startsWith("classes") && nextElement.getName().endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                    ZipEntry zipEntry = new ZipEntry(getDexName(i3));
                    InputStream inputStream = jarFile2.getInputStream(new ZipEntry(nextElement.getName()));
                    writeZipEntry(jarOutputStream, zipEntry, inputStream);
                    inputStream.close();
                    i3++;
                } else {
                    hashSet.add(nextElement.getName());
                    ZipEntry zipEntry2 = new ZipEntry(nextElement.getName());
                    InputStream inputStream2 = jarFile2.getInputStream(new ZipEntry(nextElement.getName()));
                    writeZipEntry(jarOutputStream, zipEntry2, inputStream2);
                    inputStream2.close();
                }
            }
            Enumeration<JarEntry> entries2 = jarFile.entries();
            while (entries2.hasMoreElements()) {
                JarEntry nextElement2 = entries2.nextElement();
                if (nextElement2.getName().startsWith("classes") && nextElement2.getName().endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                    ZipEntry zipEntry3 = new ZipEntry(getDexName(i3));
                    InputStream inputStream3 = jarFile.getInputStream(new ZipEntry(nextElement2.getName()));
                    writeZipEntry(jarOutputStream, zipEntry3, inputStream3);
                    inputStream3.close();
                    i3++;
                } else if (!hashSet.contains(nextElement2.getName())) {
                    ZipEntry zipEntry4 = new ZipEntry(nextElement2.getName());
                    InputStream inputStream4 = jarFile.getInputStream(new ZipEntry(nextElement2.getName()));
                    writeZipEntry(jarOutputStream, zipEntry4, inputStream4);
                    inputStream4.close();
                } else {
                    System.out.println("the same entry name, ignored: " + nextElement2.getName());
                }
            }
            try {
                jarOutputStream.close();
            } catch (Exception unused) {
            }
            try {
                jarFile.close();
            } catch (Exception unused2) {
            }
            try {
                jarFile2.close();
            } catch (Exception unused3) {
            }
            return true;
        } catch (Exception e19) {
            e = e19;
            jarOutputStream2 = jarOutputStream;
            try {
                e.printStackTrace();
                if (jarOutputStream2 != null) {
                    try {
                        jarOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Exception unused5) {
                    }
                }
                if (jarFile2 == null) {
                    return false;
                }
                try {
                    jarFile2.close();
                    return false;
                } catch (Exception unused6) {
                    return false;
                }
            } catch (Throwable th8) {
                th = th8;
                if (jarOutputStream2 != null) {
                    try {
                        jarOutputStream2.close();
                    } catch (Exception unused7) {
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Exception unused8) {
                    }
                }
                if (jarFile2 == null) {
                    try {
                        jarFile2.close();
                        throw th;
                    } catch (Exception unused9) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            jarOutputStream2 = jarOutputStream;
            if (jarOutputStream2 != null) {
            }
            if (jarFile != null) {
            }
            if (jarFile2 == null) {
            }
        }
    }

    public static String getDexName(int i3) {
        if (i3 == 1) {
            return "classes.dex";
        }
        return "classes" + i3 + QZonePatchService.PATCH_SUFFIX_DEX;
    }
}
