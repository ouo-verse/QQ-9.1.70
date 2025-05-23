package com.tencent.tavsticker.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class FileIoUtils {
    FileIoUtils() {
        throw new UnsupportedOperationException("you can't instantiate FileIoUtils");
    }

    private static boolean createOrExistsFile(File file) {
        boolean z16;
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                z16 = parentFile.mkdirs();
            } else {
                z16 = true;
            }
            if (!z16) {
                return false;
            }
            return file.createNewFile();
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean writeFileFromBytesByStream(String str, byte[] bArr, boolean z16) {
        return writeFileFromBytesByStream(getFileByPath(str), bArr, z16);
    }

    public static boolean writeFileFromBytesByStream(File file, byte[] bArr, boolean z16) {
        if (bArr == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z16));
                try {
                    bufferedOutputStream2.write(bArr);
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return true;
                    }
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }
}
