package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DeviceUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String DEVICE_ID_FILE = "DEVICE_ID";
    public static String sDeviceId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDeviceId = "";
        }
    }

    public DeviceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static File createDir(File file, String str) {
        if (file != null && str != null && str.length() != 0) {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return file2;
        }
        return null;
    }

    public static String getDeviceId(Context context) {
        if (!TextUtils.isEmpty(sDeviceId)) {
            return sDeviceId;
        }
        try {
            File file = new File(getExternalFilesDir(context, null).getAbsolutePath() + "/now/", "DEVICE_ID");
            if (file.exists()) {
                sDeviceId = readDeviceIdFromFile(file);
            } else {
                sDeviceId = UUID.randomUUID().toString();
                file.createNewFile();
                writeDeviceIdToFile(file, sDeviceId);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return sDeviceId;
    }

    public static int getDeviceIdHash(Context context) {
        return getDeviceId(context).hashCode() & Integer.MAX_VALUE;
    }

    public static File getExternalFilesDir(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        if (str == null) {
            return createDir(getSDcardDir(context), "/Android/data/" + context.getPackageName() + "/files");
        }
        return createDir(getSDcardDir(context), "/Android/data/" + context.getPackageName() + "/files/" + str);
    }

    public static File getSDcardDir(Context context) {
        File externalFilesDir;
        if (context != null) {
            try {
                externalFilesDir = context.getExternalFilesDir(null);
            } catch (Exception e16) {
                e16.printStackTrace();
                File file = new File("/mnt/sdcard");
                if (file.exists()) {
                    return file;
                }
                File file2 = new File("/storage/sdcard0");
                if (!file2.exists()) {
                    return null;
                }
                return file2;
            }
        } else {
            externalFilesDir = null;
        }
        if (externalFilesDir == null) {
            return Environment.getExternalStorageDirectory();
        }
        return externalFilesDir;
    }

    private static String readDeviceIdFromFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void writeDeviceIdToFile(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
}
