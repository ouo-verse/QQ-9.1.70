package com.tencent.mobileqq.vas.util;

import android.content.Context;
import android.os.Environment;
import com.tencent.open.base.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasFileUtils {
    protected static final String EXT_SDCARD_PATH = "/mnt/sdcard-ext";

    /* JADX WARN: Removed duplicated region for block: B:67:0x011d A[Catch: IOException -> 0x0119, TRY_LEAVE, TryCatch #0 {IOException -> 0x0119, blocks: (B:74:0x0115, B:67:0x011d), top: B:73:0x0115 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyAssets(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        InputStream open;
        if (!hasSDCard()) {
            f.c("FileUtils", "noSDCard state");
            return;
        }
        try {
            String[] list = context.getResources().getAssets().list(str);
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (String str3 : list) {
                InputStream inputStream = null;
                try {
                    if (!str3.contains(".")) {
                        if (str.length() == 0) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str2);
                            String str4 = File.separator;
                            sb5.append(str4);
                            sb5.append(str3);
                            sb5.append(str4);
                            copyAssets(context, str3, sb5.toString());
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str);
                            String str5 = File.separator;
                            sb6.append(str5);
                            sb6.append(str3);
                            copyAssets(context, sb6.toString(), str2 + str5 + str3 + str5);
                        }
                    } else {
                        File file2 = new File(file, str3);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (str.length() != 0) {
                            open = context.getAssets().open(str + "/" + str3);
                        } else {
                            open = context.getAssets().open(str3);
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                        }
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = open.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                            }
                            open.close();
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            e = e18;
                            inputStream = open;
                            try {
                                f.d("AppStore", "copy accets file error!", e);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                        return;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream = open;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e27) {
                    e = e27;
                    fileOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    fileOutputStream = null;
                }
            }
        } catch (IOException e28) {
            f.d("AppStore", "get accets file error!", e28);
        }
    }

    public static boolean hasSDCard() {
        if (Environment.getExternalStorageState().equals("mounted") || new File(EXT_SDCARD_PATH).isDirectory()) {
            return true;
        }
        return false;
    }
}
