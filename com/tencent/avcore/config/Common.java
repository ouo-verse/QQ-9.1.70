package com.tencent.avcore.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Common {
    static IPatchRedirector $redirector_ = null;
    public static final String AV_ENGINE_VERSION = "V2.9.0304.001";
    public static final String AV_SHARP_VERSION = "6.0.0";
    public static final String CONFIG_INFO = "ConfigInfo";
    public static final int EM_DEVICE_ANDROID = 201;
    public static final String FILE_NAME = "VideoConfigInfo";
    public static final String SHARP_CONFIG_PAYLOAD_FILE_NAME;
    public static final String SHARP_CONFIG_TYPE_CLEAR = "0";
    public static final String SHARP_CONFIG_TYPE_PAYLOAD = "1";
    public static final String SHARP_CONFIG_TYPE_URL = "2";
    private static final String TAG = "Common";
    public static final ConcurrentHashMap<String, byte[]> mBuffer;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13474);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SHARP_CONFIG_PAYLOAD_FILE_NAME = "SharpConfigPayload_" + DeviceInfoMonitor.getModel();
        mBuffer = new ConcurrentHashMap<>();
    }

    public Common() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void deleteFile(Context context, String str) {
        try {
            mBuffer.remove(str);
            context.deleteFile(str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String getVersion(Context context) {
        if (context == null) {
            return AV_SHARP_VERSION;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName.trim())) {
                return AV_SHARP_VERSION;
            }
            return packageInfo.versionName.trim();
        } catch (Exception e16) {
            e16.printStackTrace();
            return AV_SHARP_VERSION;
        }
    }

    public static int intPow(int i3, int i16) {
        if (i16 < 0) {
            return 0;
        }
        int i17 = 1;
        while (i16 > 0) {
            i17 *= i3;
            i16--;
        }
        return i17;
    }

    public static byte[] readFile(Context context, String str) {
        StringBuilder sb5;
        ConcurrentHashMap<String, byte[]> concurrentHashMap = mBuffer;
        byte[] bArr = concurrentHashMap.get(str);
        if (bArr == null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream openFileInput = context.openFileInput(str);
                    try {
                        int available = openFileInput.available();
                        if (available <= 0) {
                            openFileInput.close();
                            try {
                                openFileInput.close();
                            } catch (IOException e16) {
                                if (AVCoreLog.isDevelopLevel()) {
                                    AVCoreLog.e(TAG, "readFile, IOException, fileName[" + str + "]", e16);
                                }
                            }
                            return null;
                        }
                        bArr = new byte[available];
                        openFileInput.read(bArr);
                        concurrentHashMap.put(str, bArr);
                        try {
                            openFileInput.close();
                        } catch (IOException e17) {
                            e = e17;
                            if (AVCoreLog.isDevelopLevel()) {
                                sb5 = new StringBuilder();
                                sb5.append("readFile, IOException, fileName[");
                                sb5.append(str);
                                sb5.append("]");
                                AVCoreLog.e(TAG, sb5.toString(), e);
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        fileInputStream = openFileInput;
                        if (AVCoreLog.isColorLevel()) {
                            AVCoreLog.e(TAG, "readFile, Exception, fileName[" + str + "]", e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e = e19;
                                if (AVCoreLog.isDevelopLevel()) {
                                    sb5 = new StringBuilder();
                                    sb5.append("readFile, IOException, fileName[");
                                    sb5.append(str);
                                    sb5.append("]");
                                    AVCoreLog.e(TAG, sb5.toString(), e);
                                }
                            }
                        }
                        return bArr;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = openFileInput;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e26) {
                                if (AVCoreLog.isDevelopLevel()) {
                                    AVCoreLog.e(TAG, "readFile, IOException, fileName[" + str + "]", e26);
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Exception e27) {
                    e = e27;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r11 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r6.append(r4);
        r6.append("]");
        com.tencent.avcore.util.AVCoreLog.e(com.tencent.avcore.config.Common.TAG, r6.toString(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r11 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void writeFile(Context context, String str, byte[] bArr) {
        boolean z16;
        StringBuilder sb5;
        boolean z17 = true;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                mBuffer.put(str, bArr);
                fileOutputStream = context.openFileOutput(str, 0);
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (IOException e16) {
                    e = e16;
                    if (AVCoreLog.isDevelopLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("writeFile, IOException, fileName[");
                        sb5.append(str);
                        sb5.append("], bytes[");
                    }
                }
            } catch (Exception e17) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("writeFile, Exception, fileName[");
                sb6.append(str);
                sb6.append("], bytes[");
                if (bArr != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb6.append(z16);
                sb6.append("]");
                AVCoreLog.e(TAG, sb6.toString(), e17);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (AVCoreLog.isDevelopLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("writeFile, IOException, fileName[");
                            sb5.append(str);
                            sb5.append("], bytes[");
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e19) {
                    if (AVCoreLog.isDevelopLevel()) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("writeFile, IOException, fileName[");
                        sb7.append(str);
                        sb7.append("], bytes[");
                        if (bArr == null) {
                            z17 = false;
                        }
                        sb7.append(z17);
                        sb7.append("]");
                        AVCoreLog.e(TAG, sb7.toString(), e19);
                    }
                }
            }
            throw th5;
        }
    }
}
