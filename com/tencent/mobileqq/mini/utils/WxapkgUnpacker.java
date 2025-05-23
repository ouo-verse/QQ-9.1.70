package com.tencent.mobileqq.mini.utils;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WxapkgUnpacker {
    private static final String TAG = "WxapkgUnpacker";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class WxapkgFile {
        int length;
        String name;
        int start;

        public WxapkgFile(String str, int i3, int i16) {
            this.name = str;
            this.start = i3;
            this.length = i16;
        }

        public String toString() {
            return "WxapkgFile{name='" + this.name + "', start=" + this.start + ", length=" + this.length + '}';
        }
    }

    private static boolean Unpacker(String str, String str2, String str3, boolean z16) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            str2 = new File(str2).getAbsolutePath() + "Tmp";
        } else {
            str3 = new File(str3).getAbsolutePath();
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    if (randomAccessFile2.readByte() == -66) {
                        randomAccessFile2.seek(14L);
                        int readInt = randomAccessFile2.readInt();
                        ArrayList arrayList = new ArrayList(readInt);
                        for (int i3 = 0; i3 < readInt; i3++) {
                            int readInt2 = randomAccessFile2.readInt();
                            byte[] bArr = new byte[readInt2];
                            randomAccessFile2.read(bArr, 0, readInt2);
                            String absolutePath = new File(new String(bArr, 0, readInt2)).getAbsolutePath();
                            if (!TextUtils.isEmpty(str3)) {
                                if (absolutePath.startsWith(str3)) {
                                    absolutePath = absolutePath.replaceFirst(str3, str3 + "Tmp");
                                } else if (z16) {
                                    if (!str3.startsWith(absolutePath) && !str3.endsWith(absolutePath)) {
                                        absolutePath = str3 + "Tmp" + File.separator + absolutePath;
                                    }
                                    absolutePath = str3 + "Tmp";
                                } else {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused) {
                                    }
                                    return false;
                                }
                            }
                            arrayList.add(new WxapkgFile(absolutePath, randomAccessFile2.readInt(), randomAccessFile2.readInt()));
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            WxapkgFile wxapkgFile = (WxapkgFile) it.next();
                            File file = new File(str2, wxapkgFile.name);
                            randomAccessFile2.seek(wxapkgFile.start);
                            int i16 = wxapkgFile.length;
                            byte[] bArr2 = new byte[i16];
                            randomAccessFile2.read(bArr2, 0, i16);
                            write(file, bArr2);
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused2) {
                        }
                        return true;
                    }
                    throw new RuntimeException("File type error");
                } catch (Exception e16) {
                    e = e16;
                    randomAccessFile = randomAccessFile2;
                    QLog.e(TAG, 1, "Unpacker exception ", e);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static File getWxapkgFileInAssets(String str) {
        InputStream inputStream;
        try {
            inputStream = BaseApplication.getContext().getAssets().open(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            inputStream = null;
        }
        if (inputStream != null) {
            return createFileFromInputStream(inputStream, str);
        }
        return null;
    }

    public static synchronized boolean unpackSync(String str, String str2) {
        boolean unpackSync;
        synchronized (WxapkgUnpacker.class) {
            unpackSync = unpackSync(str, str2, "");
        }
        return unpackSync;
    }

    private static void write(File file, byte[] bArr) throws IOException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new RuntimeException("Create folder fail:" + file.getParentFile().getAbsolutePath());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
        } finally {
            fileOutputStream.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File createFileFromInputStream(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        File file;
        ?? r06 = 0;
        try {
            try {
                file = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/tmp" + str);
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                return file;
            } catch (IOException e18) {
                e = e18;
                QLog.e(TAG, 1, "createFileFromInputStream error." + e);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = str;
            if (r06 != 0) {
                try {
                    r06.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static synchronized boolean unpackSync(String str, String str2, String str3) {
        boolean unpackSync;
        synchronized (WxapkgUnpacker.class) {
            unpackSync = unpackSync(str, str2, str3, false);
        }
        return unpackSync;
    }

    private static boolean unpackAtomically(String str, String str2, String str3, boolean z16) {
        QLog.e(TAG, 1, "unpackAtomically wxapkgPath:", str, " outDirPath:", str2, " uniqueFolderSubPath:", str3, " isMiniGame:", Boolean.valueOf(z16));
        if (!new File(str).exists()) {
            QLog.e(TAG, 1, "unpackAtomically fail !zipFile.exists() ");
            return false;
        }
        String absolutePath = new File(str2, str3).getAbsolutePath();
        String str4 = absolutePath + "Tmp";
        FileUtils.delete(str4, false);
        if (!Unpacker(str, str2, str3, z16)) {
            QLog.e(TAG, 1, "unpackAtomically Unpacker fail");
            return false;
        }
        File file = new File(str4);
        if (!file.exists()) {
            QLog.e(TAG, 1, "unpackAtomically !uniqueFolderTmpFile.exists()");
            return false;
        }
        File file2 = new File(absolutePath);
        FileUtils.delete(absolutePath, false);
        if (!FileUtils.renameFile(file, file2)) {
            QLog.e(TAG, 1, "unpackAtomically !FileUtils.renameFile(uniqueFolderTmpFile, uniqueFolderFile)");
            return false;
        }
        if (!file2.exists()) {
            QLog.e(TAG, 1, "unpackAtomically !uniqueFolderFile.exists()");
            return false;
        }
        FileUtils.delete(str, true);
        return true;
    }

    public static synchronized boolean unpackSync(String str, String str2, String str3, boolean z16) {
        synchronized (WxapkgUnpacker.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (new File(str2, str3).exists()) {
                    return true;
                }
                return unpackAtomically(str, str2, str3, z16);
            }
            return false;
        }
    }
}
