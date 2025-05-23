package com.tencent.mobileqq.util;

import android.content.Context;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ct {
    private static File a(Context context, InputStream inputStream, String str, String str2) throws IOException {
        File file;
        FileOutputStream fileOutputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                byte[] bArr = new byte[8192];
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(str, str2);
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            QLog.e("SystemDragUtils", 1, "createTemporalFileFrom exception", e);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return file;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException e18) {
                e = e18;
                file = null;
            }
            return file;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, Uri uri, String str, String str2) {
        InputStream inputStream;
        String str3 = null;
        str3 = null;
        str3 = null;
        InputStream inputStream2 = null;
        str3 = null;
        if (uri.getAuthority() != null) {
            try {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e17) {
                QLog.e("SystemDragUtils", 1, "getPathFromInputStreamUri exception", e17);
            }
            try {
                try {
                    str3 = a(context, inputStream, str, str2).getPath();
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e18) {
                            QLog.e("SystemDragUtils", 1, "getPathFromInputStreamUri exception", e18);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                return str3;
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return str3;
    }
}
