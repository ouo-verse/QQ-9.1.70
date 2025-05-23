package com.tencent.ilink.dev.ota;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IlinkOtaInterface {
    private static String mCaPath;

    private static int CopyAssets(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            new File(str2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return 1;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    private static boolean FileExistInAssets(String str, Context context) {
        try {
            return Arrays.asList(context.getResources().getAssets().list("")).contains(str);
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static native int cancelCheckUpdate(String str);

    public static native int checkUpdate(long j3, String str, String str2, int i3, int i16, int i17, long j16, int i18);

    public static int init(Context context) {
        String saveCertPemFile = saveCertPemFile(context);
        mCaPath = saveCertPemFile;
        if (saveCertPemFile == null) {
            return -1;
        }
        init(saveCertPemFile);
        return 0;
    }

    public static native void init(String str);

    private static String saveCertPemFile(Context context) {
        if (context != null && FileExistInAssets("cacert.pem", context)) {
            String str = context.getApplicationInfo().dataDir + "/cacert.pem";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (CopyAssets(context, "cacert.pem", str) == 1) {
                return str;
            }
        }
        return null;
    }

    public static void setCallBack(IlinkOtaCallback ilinkOtaCallback) {
        IlinkOtaCallbackInterface.callback = ilinkOtaCallback;
    }

    public static native int startDownload(String str, String str2, int i3, String str3);

    public static native int stopAllDownloadTask();

    public static native int stopDownloadTask(String str);

    public static native void uninit();
}
