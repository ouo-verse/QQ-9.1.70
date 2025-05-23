package com.tencent.qqmini.sdk.core.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WxapkgUnpacker {
    private static final String TAG = "WxapkgUnpacker";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
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

    public static File createFileFromInputStream(Context context, InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        File file;
        FileOutputStream fileOutputStream2 = null;
        try {
            file = new File(context.getFilesDir().getPath() + "/tmp" + str);
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException unused) {
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
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
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return file;
        } catch (IOException unused2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static File getWxapkgFileInAssets(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        return createFileFromInputStream(context, inputStream, str);
    }

    private static boolean unPacker(String str, String str2, String str3, boolean z16) {
        RandomAccessFile randomAccessFile;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                str2 = new File(str2).getAbsolutePath() + "Tmp";
            } else {
                str3 = new File(str3).getAbsolutePath();
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (randomAccessFile.readByte() == -66) {
                    randomAccessFile.seek(14L);
                    int readInt = randomAccessFile.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i3 = 0; i3 < readInt; i3++) {
                        int readInt2 = randomAccessFile.readInt();
                        byte[] bArr = new byte[readInt2];
                        randomAccessFile.read(bArr, 0, readInt2);
                        String absolutePath = new File(new String(bArr, 0, readInt2)).getAbsolutePath();
                        if (!TextUtils.isEmpty(str3)) {
                            if (!absolutePath.startsWith(str3)) {
                                if (z16) {
                                    if (!str3.startsWith(absolutePath) && !str3.endsWith(absolutePath)) {
                                        absolutePath = str3 + "Tmp" + File.separator + absolutePath;
                                    }
                                    absolutePath = str3 + "Tmp";
                                } else {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused2) {
                                    }
                                    return false;
                                }
                            } else {
                                absolutePath = absolutePath.replaceFirst(str3, str3 + "Tmp");
                            }
                        }
                        arrayList.add(new WxapkgFile(absolutePath, randomAccessFile.readInt(), randomAccessFile.readInt()));
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        WxapkgFile wxapkgFile = (WxapkgFile) it.next();
                        File file = new File(str2, wxapkgFile.name);
                        randomAccessFile.seek(wxapkgFile.start);
                        int i16 = wxapkgFile.length;
                        byte[] bArr2 = new byte[i16];
                        randomAccessFile.read(bArr2, 0, i16);
                        write(file, bArr2);
                    }
                    try {
                        randomAccessFile.close();
                        return true;
                    } catch (Exception unused3) {
                        return true;
                    }
                }
                throw new RuntimeException("File type error");
            } catch (Exception unused4) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused5) {
                    }
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    private static boolean unpackAtomically(String str, String str2, String str3, boolean z16) {
        if (!new File(str).exists()) {
            QMLog.e(TAG, "unpackAtomically fail !zipFile.exists() ");
            return false;
        }
        String absolutePath = new File(str2, str3).getAbsolutePath();
        String str4 = absolutePath + "Tmp";
        FileUtils.delete(str4, false);
        if (!unPacker(str, str2, str3, z16)) {
            QMLog.e(TAG, "unpackAtomically unPacker fail");
            return false;
        }
        File file = new File(str4);
        if (!file.exists()) {
            QMLog.e(TAG, "unpackAtomically !uniqueFolderTmpFile.exists()");
            return false;
        }
        File file2 = new File(absolutePath);
        FileUtils.delete(absolutePath, false);
        if (!FileUtils.renameFile(file, file2)) {
            QMLog.e(TAG, "unpackAtomically !FileUtils.renameFile(uniqueFolderTmpFile, uniqueFolderFile)");
            return false;
        }
        if (!file2.exists()) {
            QMLog.e(TAG, "unpackAtomically !uniqueFolderFile.exists()");
            return false;
        }
        FileUtils.delete(str, true);
        return true;
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

    public static synchronized boolean unpackSync(String str, String str2, String str3) {
        boolean unpackSync;
        synchronized (WxapkgUnpacker.class) {
            unpackSync = unpackSync(str, str2, str3, false);
        }
        return unpackSync;
    }

    public static synchronized boolean unpackSync(String str, String str2, String str3, boolean z16) {
        synchronized (WxapkgUnpacker.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (new File(str2, str3).exists()) {
                    return true;
                }
                return unpackAtomically(str, str2, str3, z16);
            }
            QMLog.e(TAG, "wxapkgPath is null ");
            return false;
        }
    }
}
