package com.tencent.raft.codegenmeta.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FileUtils";

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<Pair<String, String>> analyzeIndexFile(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length == 2) {
                        arrayList.add(new Pair(split[0], str2 + File.separator + split[1]));
                    }
                }
                bufferedReader.close();
                inputStreamReader.close();
            }
        } catch (Exception e16) {
            RLog.d("FileUtils", "analyzeIndexFile error: " + e16);
        }
        return arrayList;
    }

    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return true;
            }
            for (String str : list) {
                if (!deleteFile(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.nio.channels.spi.AbstractInterruptibleChannel, java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x007d -> B:9:0x0080). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void writeToIndexFile(String e16, String str, String str2, String str3) {
        Throwable th5;
        File file;
        FileLock fileLock = null;
        try {
        } catch (IOException e17) {
            e16 = e17;
            e16.printStackTrace();
        }
        try {
            try {
                file = new File((String) e16);
                e16 = new FileOutputStream(file, true).getChannel();
            } catch (IOException e18) {
                e = e18;
                e16 = 0;
            } catch (Throwable th6) {
                th5 = th6;
                e16 = 0;
                if (fileLock != null) {
                }
                if (e16 == 0) {
                }
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(randomAccessFile.length());
                e16 = randomAccessFile.getChannel();
                fileLock = e16.lock();
                e16.write(ByteBuffer.wrap((str + ":" + str2.replace(str3, "") + "\n").getBytes()));
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                e16.close();
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                if (e16 != 0) {
                    e16.close();
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException e28) {
                    e28.printStackTrace();
                }
            }
            if (e16 == 0) {
                try {
                    e16.close();
                    throw th5;
                } catch (IOException e29) {
                    e29.printStackTrace();
                    throw th5;
                }
            }
            throw th5;
        }
    }
}
