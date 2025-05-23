package com.tencent.jalpha.common;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Utils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Utils";

    public Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean fileIsExists(String str) {
        try {
            if (new File(str).exists()) {
                Logger.v("Utils", str + "--------->file have exist");
                return true;
            }
            Logger.v("Utils", str + "---------->file not exists");
            return false;
        } catch (Exception e16) {
            Logger.v("Utils", "--------->fileIsExists exception");
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #4 {IOException -> 0x0084, blocks: (B:40:0x007c, B:35:0x0081), top: B:39:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAssetsFiles(Context context, String str) {
        ?? r75;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        String str2 = context.getFilesDir() + "/" + str;
        if (!fileIsExists(str2)) {
            ?? assets = context.getAssets();
            InputStream inputStream = null;
            try {
                try {
                    assets = assets.open(str);
                    try {
                        int available = assets.available();
                        Logger.v("Utils", "*********length = ********" + available);
                        bArr = new byte[available];
                        assets.read(bArr);
                        fileOutputStream = context.openFileOutput(str, 0);
                    } catch (IOException e16) {
                        e = e16;
                        fileOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        context = null;
                        inputStream = assets;
                        r75 = context;
                        if (inputStream != null) {
                        }
                        if (r75 != 0) {
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = null;
                    assets = 0;
                } catch (Throwable th6) {
                    th = th6;
                    r75 = 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            throw th;
                        }
                    }
                    if (r75 != 0) {
                        r75.close();
                    }
                    throw th;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    try {
                        assets.close();
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                } catch (IOException e18) {
                    e = e18;
                    e.printStackTrace();
                    if (assets != 0) {
                        try {
                            assets.close();
                        } catch (IOException unused3) {
                            return null;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return str2;
    }
}
