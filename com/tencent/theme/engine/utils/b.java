package com.tencent.theme.engine.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[Catch: Exception -> 0x00ae, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ae, blocks: (B:59:0x00aa, B:52:0x00b2), top: B:58:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.theme.engine.utils.a] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.tencent.theme.engine.utils.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        FileInputStream fileInputStream;
        ?? r56;
        ?? r65;
        int length;
        ByteArrayOutputStream byteArrayOutputStream = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                try {
                    length = (int) file.length();
                    r56 = new ByteArrayOutputStream(length);
                } catch (Exception e16) {
                    e = e16;
                    r56 = 0;
                    r65 = 0;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    r56 = 0;
                    r65 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    if (byteArrayOutputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                try {
                    r65 = new FileInputStream(file);
                    ?? r75 = 4096;
                    try {
                        try {
                            try {
                                if (length < 4096) {
                                    r75 = a.b().a(4096);
                                } else {
                                    r75 = a.b().a(12288);
                                }
                            } catch (OutOfMemoryError e18) {
                                e = e18;
                                m.d("FileUtils", 1, "readFileContent OutOfMemoryError", e);
                                if (r56 != 0) {
                                    r56.close();
                                }
                                if (r65 != 0) {
                                    r65.close();
                                }
                                return bArr;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            m.d("FileUtils", 1, "readFileContent", e);
                            if (r56 != 0) {
                                r56.close();
                            }
                            if (r65 != 0) {
                                r65.close();
                            }
                            return bArr;
                        }
                    } catch (OutOfMemoryError unused) {
                        r75 = a.b().a(r75);
                    }
                    int i3 = 0;
                    while (i3 < length) {
                        int read = r65.read(r75);
                        r56.write(r75, 0, read);
                        i3 += read;
                    }
                    a.b().c(r75);
                    bArr = r56.toByteArray();
                    r56.close();
                    r65.close();
                } catch (Exception e26) {
                    e = e26;
                    r65 = 0;
                } catch (OutOfMemoryError e27) {
                    e = e27;
                    r65 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    byteArrayOutputStream = r56;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e28) {
                            m.d("FileUtils", 1, "readFileContent", e28);
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e29) {
                m.d("FileUtils", 1, "readFileContent", e29);
            }
            return bArr;
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
