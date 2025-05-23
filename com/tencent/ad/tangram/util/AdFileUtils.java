package com.tencent.ad.tangram.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFileUtils {
    private static final String GDT_DIR = "gdt";
    private static final String TAG = "AdFileUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0052 -> B:13:0x0061). Please report as a decompilation issue!!! */
    @Nullable
    public static String read(@Nullable File file) {
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        str = null;
        str = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                try {
                } catch (IOException e16) {
                    AdLog.e(TAG, "read error :", e16);
                    exists = exists;
                }
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (IOException e18) {
                        e = e18;
                        fileInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e19) {
                                AdLog.e(TAG, "read error :", e19);
                            }
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                        String str2 = new String(bArr, "utf-8");
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            AdLog.e(TAG, "read error :", e26);
                        }
                        str = str2;
                        exists = fileInputStream;
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        AdLog.e(TAG, "read error :", e);
                        exists = fileInputStream;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            exists = fileInputStream;
                        }
                        return str;
                    } catch (IOException e28) {
                        e = e28;
                        AdLog.e(TAG, "read error :", e);
                        exists = fileInputStream;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            exists = fileInputStream;
                        }
                        return str;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = exists;
            }
        }
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0048 -> B:13:0x0057). Please report as a decompilation issue!!! */
    public static void write(@Nullable File file, @NonNull String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
            } catch (IOException e16) {
                AdLog.e(TAG, "write error :", e16);
            }
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str.getBytes("UTF-8"));
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        fileOutputStream2.close();
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        AdLog.e(TAG, "write error :", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        AdLog.e(TAG, "write error :", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                AdLog.e(TAG, "write error :", e19);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }
}
