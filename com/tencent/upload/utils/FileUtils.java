package com.tencent.upload.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.upload.common.UploadGlobalConfig;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_TYPE_APNG = "apng";
    public static final String FILE_TYPE_BMP = "bmp";
    public static final String FILE_TYPE_GIF = "gif";
    public static final String FILE_TYPE_JPEG = "jpg";
    public static final String FILE_TYPE_PNG = "png";
    public static final String FILE_TYPE_SHARPP = "sharpp";
    public static final String FILE_TYPE_WEBP = "webp";
    public static final String UPLOAD_TEMP_DIR = "uploader";
    public static final String UPLOAD_TEMP_FILE_SEPERATOR = "_";
    public static final int UPLOAD_TEMP_SPACE_THRESHOLD = 5;
    public static final String UPLOAD_TEMP_SUFFIX = ".qtmp";
    private static final String tag;
    public static String unKnownFileTypeMark;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class UploaderMD5 {
        static IPatchRedirector $redirector_ = null;
        public static final int FAKE_FILE_MD5 = 0;
        public static final int REAL_FILE_MD5 = 1;
        public static final int REAL_SHA = 2;
        int type;
        String value;

        public UploaderMD5(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.type = i3;
                this.value = str;
            }
        }

        public int getType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public String getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.value;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            tag = FileUtils.class.getSimpleName();
            unKnownFileTypeMark = "unknown_";
        }
    }

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearUploadDir(Context context, long j3, long j16) {
        File externalFilesDir = getExternalFilesDir(context);
        if (externalFilesDir != null && getCacheDirUsedSpace(externalFilesDir) >= j3) {
            deleteDir(externalFilesDir);
        }
        File dir = context.getDir("uploader", 0);
        if (dir != null && getCacheDirUsedSpace(dir) >= j16) {
            deleteDir(dir);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[Catch: IllegalArgumentException -> 0x009f, TRY_LEAVE, TryCatch #10 {IllegalArgumentException -> 0x009f, blocks: (B:28:0x008c, B:30:0x0092), top: B:27:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007d A[Catch: IOException -> 0x0079, TRY_LEAVE, TryCatch #0 {IOException -> 0x0079, blocks: (B:58:0x0075, B:51:0x007d), top: B:57:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0066 A[Catch: IOException -> 0x0062, TRY_LEAVE, TryCatch #13 {IOException -> 0x0062, blocks: (B:68:0x005e, B:63:0x0066), top: B:67:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b5 A[Catch: IOException -> 0x00b1, TRY_LEAVE, TryCatch #6 {IOException -> 0x00b1, blocks: (B:91:0x00ad, B:84:0x00b5), top: B:90:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(String str, String str2) {
        ?? r95;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        int i3;
        ?? r96;
        ?? file;
        boolean z16 = true;
        if (str != null && str.equals(str2)) {
            return true;
        }
        FileInputStream fileInputStream2 = null;
        boolean z17 = false;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e16) {
                e = e16;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (IOException e17) {
                e = e17;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r95 = 0;
                if (fileInputStream2 != null) {
                }
                if (r95 != 0) {
                }
                throw th;
            }
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (FileNotFoundException e18) {
                e = e18;
                fileOutputStream = null;
            } catch (IOException e19) {
                e = e19;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                str = null;
                fileInputStream2 = fileInputStream;
                r95 = str;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e26) {
                        UploadLog.w(tag, "copyFile()", e26);
                        throw th;
                    }
                }
                if (r95 != 0) {
                    r95.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[10240];
                i3 = 0;
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        i3 += read;
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        UploadLog.w(tag, "copyFile()", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e28) {
                                e = e28;
                                UploadLog.w(tag, "copyFile()", e);
                                z16 = false;
                                file = new File(str2);
                                if (file.exists()) {
                                }
                                z16 = z17;
                                r96 = file;
                                if (!z16) {
                                    r96.delete();
                                }
                                return z16;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        z16 = false;
                        file = new File(str2);
                        if (file.exists()) {
                        }
                        z16 = z17;
                        r96 = file;
                        if (!z16) {
                        }
                        return z16;
                    } catch (IOException e29) {
                        e = e29;
                        UploadLog.w(tag, "copyFile()", e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e36) {
                                e = e36;
                                UploadLog.w(tag, "copyFile()", e);
                                z16 = false;
                                file = new File(str2);
                                if (file.exists()) {
                                }
                                z16 = z17;
                                r96 = file;
                                if (!z16) {
                                }
                                return z16;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        z16 = false;
                        file = new File(str2);
                        if (file.exists()) {
                        }
                        z16 = z17;
                        r96 = file;
                        if (!z16) {
                        }
                        return z16;
                    }
                }
                fileOutputStream.flush();
                try {
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (IOException e37) {
                    UploadLog.w(tag, "copyFile()", e37);
                }
            } catch (FileNotFoundException e38) {
                e = e38;
                i3 = 0;
                UploadLog.w(tag, "copyFile()", e);
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                z16 = false;
                file = new File(str2);
                if (file.exists()) {
                }
                z16 = z17;
                r96 = file;
                if (!z16) {
                }
                return z16;
            } catch (IOException e39) {
                e = e39;
                i3 = 0;
                UploadLog.w(tag, "copyFile()", e);
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                z16 = false;
                file = new File(str2);
                if (file.exists()) {
                }
                z16 = z17;
                r96 = file;
                if (!z16) {
                }
                return z16;
            }
            try {
                file = new File(str2);
            } catch (IllegalArgumentException unused) {
            }
            try {
                if (file.exists()) {
                    if (file.length() == i3) {
                        z17 = z16;
                    }
                }
                z16 = z17;
                r96 = file;
            } catch (IllegalArgumentException unused2) {
                fileInputStream2 = file;
                r96 = fileInputStream2;
                if (!z16) {
                }
                return z16;
            }
            if (!z16 && r96 != 0) {
                r96.delete();
            }
            return z16;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static void deleteAllFile(File file) throws IOException {
        if (file != null && file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    deleteAllFile(file2);
                }
            }
            file.delete();
        }
    }

    public static final void deleteClosedTempFile(String str) {
        if (str != null && str.endsWith(".qtmp")) {
            File file = new File(str);
            if (file.exists() && !file.renameTo(file.getAbsoluteFile())) {
                return;
            }
            file.delete();
        }
    }

    private static void deleteDir(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                new File(file, str).delete();
            }
        }
    }

    public static final void deleteTempFile(String str) {
        if (str != null && str.endsWith(".qtmp")) {
            new File(str).delete();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        r1.close();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
    
        if (r1 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String estimateFileType(String str) {
        String str2;
        FileInputStream fileInputStream;
        str2 = "";
        FileInputStream fileInputStream2 = null;
        fileInputStream2 = null;
        fileInputStream2 = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream3 = new FileInputStream(str);
                    try {
                        byte[] bArr = new byte[2];
                        int read = fileInputStream3.read(bArr);
                        str2 = read != -1 ? estimateFileType(bArr) : "";
                        fileInputStream3.close();
                        fileInputStream3.close();
                        fileInputStream2 = read;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileInputStream2 = fileInputStream3;
                        e.printStackTrace();
                        fileInputStream = fileInputStream2;
                    } catch (IOException e17) {
                        e = e17;
                        fileInputStream2 = fileInputStream3;
                        e.printStackTrace();
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream3;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                } catch (IOException e19) {
                    e = e19;
                }
            } catch (IOException unused2) {
            }
            return str2;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean fileExistsAndNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static final long getCacheDirUsedSpace(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null) {
            return 0L;
        }
        int i3 = 0;
        for (String str : list) {
            if (str != null) {
                i3 = (int) (i3 + new File(file, str).length());
            }
        }
        return i3;
    }

    private static final String getCachePathByPrefix(File file, String str) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null) {
            return null;
        }
        for (String str2 : list) {
            if (str2 != null && str2.startsWith(str) && str2.endsWith(".qtmp")) {
                File file2 = new File(file, str2);
                if (file2.length() != 0 && file2.isFile()) {
                    StringBuilder sb5 = new StringBuilder(3);
                    sb5.append(file.getAbsolutePath());
                    sb5.append(File.separator);
                    sb5.append(str2);
                    return sb5.toString();
                }
            }
        }
        return null;
    }

    public static String getDefaultPrivatePath(Context context, String str) {
        File file;
        try {
            file = Environment.getExternalStorageDirectory();
        } catch (Exception unused) {
            file = null;
        }
        if (file == null || !file.exists() || context == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(11);
        sb5.append(file.getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("Android");
        sb5.append(str2);
        sb5.append("data");
        sb5.append(str2);
        sb5.append(context.getPackageName());
        sb5.append(str2);
        sb5.append("files");
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }

    private static File getExternalFilesDir(Context context) {
        File file;
        String sDKPrivatePath = UploadGlobalConfig.getUploadEnv().getSDKPrivatePath("uploader");
        if (TextUtils.isEmpty(sDKPrivatePath)) {
            UploadLog.w(tag, "dirPath is empty");
            sDKPrivatePath = getDefaultPrivatePath(context, "uploader");
        }
        try {
            file = new File(sDKPrivatePath);
        } catch (Exception e16) {
            UploadLog.e(tag, e16.toString());
            file = null;
        }
        if (file == null) {
            UploadLog.w(tag, "uploadDir == null");
            return null;
        }
        if (!file.isDirectory() && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    public static long getFileLength(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            return file.length();
        } catch (Exception e16) {
            UploadLog.e(tag, "getFileLength() ", e16);
            return 0L;
        }
    }

    public static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String getFileNameFromPath(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) == -1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String getFilePathByPrefix(Context context, String str, String str2) {
        File dir;
        String cachePathByPrefix;
        File externalFilesDir;
        String cachePathByPrefix2;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        String tempFilePerfix = getTempFilePerfix(str2.hashCode(), str.hashCode());
        if ("mounted".equals(Environment.getExternalStorageState()) && getSdCardAvailableSize() > 5 && (externalFilesDir = getExternalFilesDir(context)) != null && (cachePathByPrefix2 = getCachePathByPrefix(externalFilesDir, tempFilePerfix)) != null) {
            return cachePathByPrefix2;
        }
        if (getInternalAvailableSize() <= 5 || (dir = context.getDir("uploader", 0)) == null || (cachePathByPrefix = getCachePathByPrefix(dir, tempFilePerfix)) == null) {
            return null;
        }
        return cachePathByPrefix;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:33:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileSha1(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        String hexString = StringUtils.toHexString(messageDigest.digest());
                        try {
                            fileInputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        return hexString;
                    } catch (Exception e17) {
                        e = e17;
                        UploadLog.e("FileUtils", "getFileSha1->NoSuchAlgorithmException###", e);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        UploadLog.e("FileUtils", "getFileSha1->OutOfMemoryError###", e);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileInputStream = null;
                } catch (OutOfMemoryError e26) {
                    e = e26;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream3 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream3 = fileInputStream2;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e28) {
            e28.printStackTrace();
        }
    }

    public static int getInternalAvailableSize() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (int) ((((statFs.getAvailableBlocks() * 1.0d) * statFs.getBlockSize()) / 1024.0d) / 1024.0d);
    }

    public static String getMd5(byte[] bArr) {
        return getMessageDigest(bArr, KeyPropertiesCompact.DIGEST_MD5);
    }

    private static String getMd5ByFile(File file) {
        return getMessageDigestByFile(file, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static UploaderMD5 getMd5ByFile_FAKE(File file) {
        return new UploaderMD5(0, getMd5ByFile(file));
    }

    public static String getMd5ByFile_REAL(File file) {
        return getMessageDigestByFile_REAL(file, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static ArrayList<String> getMd5BySize(File file, int i3) {
        return getMessageDigestBySize(file, i3, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static String getMessageDigest(byte[] bArr, String str) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(bArr);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        if (r3 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getMessageDigestByFile(File file, String str) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return "";
        }
        long length = file.length();
        if (length > 100) {
            long j3 = length / 5;
            byte[] bArr = new byte[32];
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException unused) {
            } catch (IOException unused2) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileInputStream.skip(j3);
                for (int i3 = 0; i3 < 4; i3++) {
                    fileInputStream.read(bArr, i3 * 8, 8);
                    fileInputStream.skip(j3 - 8);
                }
                String hexString = StringUtils.toHexString(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                return hexString;
            } catch (FileNotFoundException unused4) {
                fileInputStream2 = fileInputStream;
            } catch (IOException unused5) {
                fileInputStream2 = fileInputStream;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } else {
            return getMessageDigestByFile_REAL(file, str);
        }
    }

    public static String getMessageDigestByFile_REAL(File file, String str) {
        if (file == null || !file.exists()) {
            return "";
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    messageDigest.reset();
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        }
                        String hexString = StringUtils.toHexString(messageDigest.digest());
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e16) {
                            UploadLog.e(tag, e16.toString());
                        }
                        return hexString;
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        bufferedInputStream = bufferedInputStream2;
                        UploadLog.e(tag, e.toString());
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return "";
                    } catch (IOException e18) {
                        e = e18;
                        bufferedInputStream = bufferedInputStream2;
                        UploadLog.e(tag, e.toString());
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return "";
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        bufferedInputStream = bufferedInputStream2;
                        UploadLog.e(tag, e.toString());
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return "";
                    } catch (NoSuchAlgorithmException e26) {
                        e = e26;
                        bufferedInputStream = bufferedInputStream2;
                        UploadLog.e(tag, e.toString());
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e27) {
                                UploadLog.e(tag, e27.toString());
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                } catch (IOException e29) {
                    e = e29;
                } catch (OutOfMemoryError e36) {
                    e = e36;
                } catch (NoSuchAlgorithmException e37) {
                    e = e37;
                }
            } catch (IOException e38) {
                UploadLog.e(tag, e38.toString());
                return "";
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static ArrayList<String> getMessageDigestBySize(File file, int i3, String str) {
        if (file != null && file.exists()) {
            ArrayList<String> arrayList = new ArrayList<>();
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(str);
                        messageDigest.reset();
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                        try {
                            long length = file.length();
                            int i16 = 0;
                            while (i16 != length) {
                                byte[] bArr = new byte[i3];
                                int i17 = i3;
                                do {
                                    int read = bufferedInputStream2.read(bArr, 0, i17);
                                    if (read != -1) {
                                        i17 -= read;
                                        i16 += read;
                                        messageDigest.update(bArr, 0, read);
                                    }
                                    arrayList.add(StringUtils.toHexString(messageDigest.digest()));
                                } while (i17 != 0);
                                arrayList.add(StringUtils.toHexString(messageDigest.digest()));
                            }
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e16) {
                                UploadLog.e(tag, e16.toString());
                            }
                            return arrayList;
                        } catch (FileNotFoundException e17) {
                            e = e17;
                            bufferedInputStream = bufferedInputStream2;
                            UploadLog.e(tag, e.toString());
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return new ArrayList<>();
                        } catch (IOException e18) {
                            e = e18;
                            bufferedInputStream = bufferedInputStream2;
                            UploadLog.e(tag, e.toString());
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return new ArrayList<>();
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            bufferedInputStream = bufferedInputStream2;
                            UploadLog.e(tag, e.toString());
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return new ArrayList<>();
                        } catch (NoSuchAlgorithmException e26) {
                            e = e26;
                            bufferedInputStream = bufferedInputStream2;
                            UploadLog.e(tag, e.toString());
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return new ArrayList<>();
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e27) {
                                    UploadLog.e(tag, e27.toString());
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e28) {
                        e = e28;
                    } catch (IOException e29) {
                        e = e29;
                    } catch (OutOfMemoryError e36) {
                        e = e36;
                    } catch (NoSuchAlgorithmException e37) {
                        e = e37;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e38) {
                UploadLog.e(tag, e38.toString());
            }
        } else {
            return new ArrayList<>();
        }
    }

    public static String getSHA(byte[] bArr) {
        return getMessageDigest(bArr, KeyPropertiesCompact.DIGEST_SHA1);
    }

    private static String getSHAByFile(File file) {
        return getMessageDigestByFile(file, KeyPropertiesCompact.DIGEST_SHA1);
    }

    public static UploaderMD5 getSHAByFile_FAKE(File file) {
        return new UploaderMD5(2, getSHAByFile(file));
    }

    public static String getSHAByFile_REAL(File file) {
        return getMessageDigestByFile_REAL(file, KeyPropertiesCompact.DIGEST_SHA1);
    }

    public static int getSdCardAvailableSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (int) ((((statFs.getAvailableBlocks() * 1.0d) * statFs.getBlockSize()) / 1024.0d) / 1024.0d);
        } catch (Exception e16) {
            UploadLog.e(tag, e16.toString());
            return 0;
        }
    }

    public static final String getTempFileAbsolutePath(String str, int i3, int i16, int i17) {
        StringBuilder sb5 = new StringBuilder(8);
        sb5.append(str);
        sb5.append(File.separator);
        sb5.append(i3);
        sb5.append("_");
        sb5.append(i16);
        sb5.append("_");
        sb5.append(i17);
        sb5.append(".qtmp");
        return sb5.toString();
    }

    public static String getTempFilePath(Context context, String str, String str2, int i3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int hashCode = str2.hashCode();
        int hashCode2 = str.hashCode();
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        String str3 = tag;
        UploadLog.d(str3, "mounted:" + equals);
        if (equals) {
            int sdCardAvailableSize = getSdCardAvailableSize();
            if (sdCardAvailableSize > 5) {
                File externalFilesDir = getExternalFilesDir(context);
                if (externalFilesDir != null) {
                    return getTempFileAbsolutePath(externalFilesDir.getAbsolutePath(), hashCode, hashCode2, i3);
                }
                UploadLog.w(str3, "externalCacheDir == null");
            } else {
                UploadLog.w(str3, "not enough sdCardAvailableSize:" + sdCardAvailableSize);
            }
        }
        int internalAvailableSize = getInternalAvailableSize();
        if (internalAvailableSize > 5) {
            File dir = context.getDir("uploader", 0);
            if (dir != null) {
                return getTempFileAbsolutePath(dir.getAbsolutePath(), hashCode, hashCode2, i3);
            }
            UploadLog.w(str3, "internalFilesDir == null");
        } else {
            UploadLog.w(str3, "not enough internalAvailableSize:" + internalAvailableSize);
        }
        return null;
    }

    public static final String getTempFilePerfix(int i3, int i16) {
        StringBuilder sb5 = new StringBuilder(3);
        sb5.append(i3);
        sb5.append("_");
        sb5.append(i16);
        return sb5.toString();
    }

    public static final boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static final boolean isValidTempFile(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).length() > 0) {
            return true;
        }
        return false;
    }

    public static byte[] toByteArray(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr, 0, 8192);
                            if (-1 == read) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        throw e;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e19) {
                e = e19;
            }
        } else {
            throw new FileNotFoundException(str);
        }
    }

    public static String estimateFileType(byte[] bArr) {
        String str = "";
        if (bArr != null && bArr.length >= 2) {
            for (byte b16 : bArr) {
                str = str + Integer.toString(b16 & 255);
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt == 6677) {
                return "bmp";
            }
            if (parseInt == 7173) {
                return "gif";
            }
            if (parseInt == 7784) {
                return "midi";
            }
            if (parseInt == 7790) {
                return "exe";
            }
            if (parseInt == 8075) {
                return "zip";
            }
            if (parseInt == 8273) {
                return "webp";
            }
            if (parseInt == 8297) {
                return "rar";
            }
            if (parseInt == 13780) {
                return "png";
            }
            if (parseInt == 255216) {
                return "jpg";
            }
            return unKnownFileTypeMark + str;
        }
        return unKnownFileTypeMark + "";
    }

    public static String getFileSha1(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                messageDigest.update(bArr, 0, bArr.length);
                return StringUtils.toHexString(messageDigest.digest());
            } catch (Exception e16) {
                UploadLog.e("FileUtils", "getFileSha1->NoSuchAlgorithmException###", e16);
            } catch (OutOfMemoryError e17) {
                UploadLog.e("FileUtils", "getFileSha1->OutOfMemoryError###", e17);
            }
        }
        return null;
    }
}
