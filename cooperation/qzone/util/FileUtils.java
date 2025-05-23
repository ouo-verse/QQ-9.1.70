package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FileUtils {
    public static final int CPY_BUFFER_SIZE = 4096;
    public static final String TAG = "FileUtils";
    public static final int ZIP_BUFFER_SIZE = 4096;
    public static final String ZIP_FILE_EXT = ".zip";

    private static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            cArr2[i3] = cArr[(b16 >>> 4) & 15];
            i3 = i16 + 1;
            cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr2);
    }

    public static boolean copyFile(File file, File file2) {
        FileInputStream fileInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (-1 != read) {
                            bufferedOutputStream2.write(bArr, 0, read);
                        } else {
                            bufferedOutputStream2.flush();
                            DataUtils.closeDataObject(bufferedOutputStream2);
                            DataUtils.closeDataObject(fileInputStream);
                            return true;
                        }
                    }
                } catch (IOException unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    DataUtils.closeDataObject(bufferedOutputStream);
                    DataUtils.closeDataObject(fileInputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    DataUtils.closeDataObject(bufferedOutputStream);
                    DataUtils.closeDataObject(fileInputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException unused3) {
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    public static boolean deleteFile(File file) {
        if (file != null) {
            if (file.isFile()) {
                if (!file.delete()) {
                    file.deleteOnExit();
                    return false;
                }
                return true;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        deleteFile(file2);
                    }
                }
                return file.delete();
            }
        }
        return false;
    }

    public static void doZip(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) throws IOException {
        String str2;
        if (zipOutputStream != null && file != null) {
            if (file.exists()) {
                if (TextUtils.isEmpty(str)) {
                    str2 = file.getName();
                } else {
                    str2 = str + File.separator + file.getName();
                }
                if (file.isFile()) {
                    BufferedInputStream bufferedInputStream = null;
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str2));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                                if (-1 != read) {
                                    zipOutputStream.write(bArr, 0, read);
                                } else {
                                    DataUtils.closeDataObject(bufferedInputStream2);
                                    return;
                                }
                            }
                        } catch (IOException e16) {
                            e = e16;
                            bufferedInputStream = bufferedInputStream2;
                            DataUtils.closeDataObject(bufferedInputStream);
                            throw e;
                        }
                    } catch (IOException e17) {
                        e = e17;
                    }
                } else if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        doZip(zipOutputStream, file2, str2, bArr);
                    }
                }
            } else {
                throw new FileNotFoundException("Target File is missing");
            }
        } else {
            throw new IOException("I/O Object got NullPointerException");
        }
    }

    private static String encodeFile(String str, boolean z16) {
        byte[] bArr;
        String str2 = "";
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                InputStream inputStream = null;
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                        if (z16) {
                            inputStream = new GZIPInputStream(bufferedInputStream);
                        } else {
                            inputStream = bufferedInputStream;
                        }
                        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                        try {
                            bArr = new byte[16384];
                        } catch (OutOfMemoryError unused) {
                            bArr = new byte[4096];
                        }
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        str2 = byteArrayToHex(messageDigest.digest());
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("FileUtils", 2, "encode-Exception:", e16);
                        }
                    }
                    return str2;
                } finally {
                    DataUtils.closeDataObject(inputStream);
                }
            }
            QLog.w("FileUtils", 2, "encode-File does not exist or is not file:" + str);
        }
        return "";
    }

    public static long getFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            return file.length();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static String getWebFileSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 == -1) {
            return "";
        }
        return str.substring(lastIndexOf2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0036: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:55), block:B:27:0x0036 */
    public static String readStringFromFile(File file) throws IOException {
        String str;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e16) {
                e = e16;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                DataUtils.closeDataObject(str2);
                throw th;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\n");
                }
                str2 = sb5.toString();
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                DataUtils.closeDataObject(bufferedReader);
                return str2;
            }
            DataUtils.closeDataObject(bufferedReader);
            return str2;
        } catch (Throwable th6) {
            th = th6;
            str2 = str;
        }
    }

    public static String sourceFileMd5(String str, boolean z16) {
        String encodeFile = encodeFile(str, z16);
        if (encodeFile != null) {
            return encodeFile.toLowerCase();
        }
        return "";
    }

    public static boolean unzip(File file, File file2) {
        QZipInputStream qZipInputStream;
        if (file == null || file.length() < 1 || !file.canRead()) {
            return false;
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        byte[] bArr = new byte[8192];
        BufferedOutputStream bufferedOutputStream = null;
        try {
            qZipInputStream = new QZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (true) {
                try {
                    ZipEntry nextEntry = qZipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            if (nextEntry.isDirectory()) {
                                new File(file2, name).mkdirs();
                            } else {
                                File file3 = new File(file2, name);
                                file3.getParentFile().mkdirs();
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file3));
                                while (true) {
                                    try {
                                        int read = qZipInputStream.read(bArr, 0, 8192);
                                        if (-1 == read) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    } catch (IOException unused) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                        DataUtils.closeDataObject(bufferedOutputStream);
                                        DataUtils.closeDataObject(qZipInputStream);
                                        return false;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        DataUtils.closeDataObject(bufferedOutputStream);
                                        DataUtils.closeDataObject(qZipInputStream);
                                        throw th;
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream2.close();
                                bufferedOutputStream = bufferedOutputStream2;
                            }
                        }
                    } else {
                        qZipInputStream.closeEntry();
                        qZipInputStream.close();
                        DataUtils.closeDataObject(bufferedOutputStream);
                        DataUtils.closeDataObject(qZipInputStream);
                        return true;
                    }
                } catch (IOException unused2) {
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        } catch (IOException unused3) {
            qZipInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            qZipInputStream = null;
        }
    }

    public static List<File> unzipFiles(File file, File file2, Set<String> set) {
        QZipInputStream qZipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        if (file == null || file.length() < 1 || !file.canRead()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!file2.exists()) {
            file2.mkdirs();
        }
        byte[] bArr = new byte[8192];
        try {
            qZipInputStream = new QZipInputStream(new FileInputStream(file));
        } catch (IOException unused) {
            qZipInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            qZipInputStream = null;
        }
        while (true) {
            try {
                ZipEntry nextEntry = qZipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (set.contains(name) && !name.contains("../")) {
                    if (nextEntry.isDirectory()) {
                        File file3 = new File(file2, name);
                        file3.mkdirs();
                        arrayList.add(file3);
                    } else {
                        File file4 = new File(file2, name);
                        file4.getParentFile().mkdirs();
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file4));
                        while (true) {
                            try {
                                int read = qZipInputStream.read(bArr, 0, 8192);
                                if (-1 == read) {
                                    break;
                                }
                                bufferedOutputStream2.write(bArr, 0, read);
                            } catch (IOException unused2) {
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedOutputStream = bufferedOutputStream2;
                                DataUtils.closeDataObject(bufferedOutputStream);
                                DataUtils.closeDataObject(qZipInputStream);
                                throw th;
                            }
                        }
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                        arrayList.add(file4);
                        bufferedOutputStream = bufferedOutputStream2;
                    }
                }
            } catch (IOException unused3) {
            } catch (Throwable th7) {
                th = th7;
            }
            DataUtils.closeDataObject(bufferedOutputStream);
            DataUtils.closeDataObject(qZipInputStream);
            return arrayList;
        }
        qZipInputStream.closeEntry();
        qZipInputStream.close();
        DataUtils.closeDataObject(bufferedOutputStream);
        DataUtils.closeDataObject(qZipInputStream);
        return arrayList;
    }

    public static boolean zip(File[] fileArr, File file) {
        byte[] bArr;
        ZipOutputStream zipOutputStream;
        if (fileArr == null || fileArr.length < 1 || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file, false)));
        } catch (IOException unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            for (File file2 : fileArr) {
                doZip(zipOutputStream, file2, null, bArr);
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
            DataUtils.closeDataObject(zipOutputStream);
            return true;
        } catch (IOException unused2) {
            zipOutputStream2 = zipOutputStream;
            DataUtils.closeDataObject(zipOutputStream2);
            return false;
        } catch (Throwable th6) {
            th = th6;
            zipOutputStream2 = zipOutputStream;
            DataUtils.closeDataObject(zipOutputStream2);
            throw th;
        }
    }

    public static boolean zip(File file, File file2) {
        return zip(new File[]{file}, file2);
    }
}
