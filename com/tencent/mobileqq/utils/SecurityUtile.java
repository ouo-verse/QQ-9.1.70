package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SecurityUtile {
    private static final String KEY_FILE = "kc";
    private static final long MIN_INTERVAL_TO_REPORT_SO_FAIL = 5000;
    private static final int RANDOM_KEY_LENGTH = 9;
    private static final String TAG = "SecurityUtile";
    private static boolean loadSo;
    private static volatile char[] codeKey = {0, 1, 0, 1};
    private static byte[] codeEmosmKey = {0, 1, 0, 1};
    private static int codeEmosmKeyLen = 4;
    private static volatile int codeKeyLen = 0;
    private static long mLastTimestampReportSoFail = 0;

    static {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int msfLoadSo = com.tencent.qphone.base.util.StringUtils.msfLoadSo(TAG, "DBEncryptV2");
            boolean loadResult = com.tencent.qphone.base.util.StringUtils.getLoadResult(msfLoadSo);
            loadSo = loadResult;
            QLog.e(TAG, 1, "loadso ", Boolean.valueOf(loadResult), ", resultCode:", Integer.valueOf(msfLoadSo), " cost:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "SecurityUtile load so fail, ", th5);
        }
    }

    public static String decode(String str) {
        return encode(str);
    }

    public static String encode(String str) {
        return encode(str, true);
    }

    public static native char[] encrypt(char[] cArr, char[] cArr2, int i3);

    public static native byte[] encryptByte(byte[] bArr, char[] cArr, int i3);

    public static char[] getKey() {
        if (codeKeyLen == 0 || codeKey.length == 4) {
            setKey(BaseApplication.getContext());
        }
        return Arrays.copyOf(codeKey, codeKey.length);
    }

    private static boolean isKeyFileExists(Context context) {
        if (context.getFileStreamPath(KEY_FILE) != null && context.getFileStreamPath(KEY_FILE).exists()) {
            return true;
        }
        return false;
    }

    private static void printEncodeButNotEncrypt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - mLastTimestampReportSoFail > 5000) {
            QLog.e(TAG, 2, "SecurityUtile encode, loadSo:", Boolean.valueOf(loadSo));
            mLastTimestampReportSoFail = currentTimeMillis;
        }
    }

    private static String readKeyCodeFile(Context context) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                fileInputStream = context.openFileInput(KEY_FILE);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                return new String(bArr, "UTF-8");
            } catch (IOException e16) {
                throw e16;
            }
        } catch (Throwable th5) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0019, code lost:
    
        if (r1.length() < com.tencent.mobileqq.utils.SecurityUtile.codeKey.length) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083 A[Catch: all -> 0x00c1, LOOP:0: B:26:0x007f->B:28:0x0083, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0004, B:32:0x000c, B:39:0x0012, B:9:0x0052, B:11:0x00b4, B:12:0x00bf, B:16:0x005b, B:18:0x006c, B:21:0x0093, B:24:0x0098, B:25:0x0075, B:28:0x0083, B:30:0x008f, B:34:0x001b, B:37:0x0029, B:7:0x0046), top: B:3:0x0004, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setKey(Context context) {
        String str;
        int i3;
        synchronized (KEY_FILE) {
            if (isKeyFileExists(context)) {
                try {
                    str = readKeyCodeFile(context);
                    if (str != null) {
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            QLog.e(TAG, 1, "read key Exception " + e.getMessage());
                            if (str != null) {
                            }
                            str = context.getSharedPreferences("mobileQQ", 0).getString(AppConstants.Preferences.SECURITY_KEY, null);
                            if (str != null) {
                            }
                            StringBuilder sb5 = new StringBuilder();
                            Random random = new Random();
                            while (i3 < 9) {
                            }
                            str = sb5.toString();
                            try {
                                writeKeyCodeFile(context, str);
                            } catch (IOException e17) {
                                QLog.e(TAG, 1, "write key Exception " + e17.getMessage());
                            }
                            codeKey = str.toCharArray();
                            codeKeyLen = codeKey.length;
                        }
                    }
                    LockMethodProxy.sleep(200L);
                    str = readKeyCodeFile(context);
                } catch (Exception e18) {
                    e = e18;
                    str = null;
                }
            } else {
                QLog.e(TAG, 1, "isKeyFileExists = false");
                str = null;
            }
            if (str != null || str.length() < codeKey.length) {
                str = context.getSharedPreferences("mobileQQ", 0).getString(AppConstants.Preferences.SECURITY_KEY, null);
                if (str != null || str.length() < codeKey.length) {
                    StringBuilder sb52 = new StringBuilder();
                    Random random2 = new Random();
                    for (i3 = 0; i3 < 9; i3++) {
                        sb52.append(random2.nextInt(10));
                    }
                    str = sb52.toString();
                }
                writeKeyCodeFile(context, str);
            }
            codeKey = str.toCharArray();
            codeKeyLen = codeKey.length;
        }
    }

    private static void writeKeyCodeFile(Context context, String str) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput(KEY_FILE, 0);
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.close();
            } catch (IOException e16) {
                throw e16;
            }
        } catch (Throwable th5) {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th5;
        }
    }

    public static byte[] xorInLimit(byte[] bArr, int i3) {
        if (bArr != null) {
            for (int i16 = 0; i16 < i3; i16++) {
                bArr[i16] = (byte) (bArr[i16] ^ codeEmosmKey[i16 % codeEmosmKeyLen]);
            }
        }
        return bArr;
    }

    public static String decode(String str, boolean z16) {
        return encode(str, z16);
    }

    public static String encode(String str, boolean z16) {
        if (str != null) {
            try {
                if (loadSo) {
                    if (codeKeyLen == 0 || codeKey.length == 4) {
                        setKey(BaseApplication.getContext());
                    }
                    return new String(encrypt(str.toCharArray(), codeKey, codeKeyLen));
                }
            } catch (UnsatisfiedLinkError e16) {
                if (z16) {
                    CaughtExceptionReportProxy.e(e16, "encode str error");
                }
                QLog.e(TAG, 1, "encode str error", e16);
                return null;
            }
        }
        if (QLog.isColorLevel() && !loadSo) {
            printEncodeButNotEncrypt();
        }
        return str;
    }

    public static void xorInLimit(byte[] bArr, int i3, int i16, long j3, int i17) {
        if (bArr != null) {
            long j16 = i17;
            if (j3 >= j16) {
                return;
            }
            int i18 = (int) (j16 - j3);
            if (i18 <= i16) {
                i16 = i18;
            }
            for (int i19 = 0; i19 < i16; i19++) {
                int i26 = i19 + i3;
                bArr[i26] = (byte) (bArr[i26] ^ codeEmosmKey[(int) ((i19 + j3) % codeEmosmKeyLen)]);
            }
        }
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr != null) {
            try {
                if (loadSo) {
                    if (codeKeyLen == 0 || codeKey.length == 4) {
                        setKey(BaseApplication.getContext());
                    }
                    return encryptByte(bArr, codeKey, codeKeyLen);
                }
            } catch (UnsatisfiedLinkError e16) {
                CaughtExceptionReportProxy.e(e16, "encode byte error");
                QLog.e(TAG, 1, "encode byte error", e16);
                return null;
            }
        }
        if (QLog.isColorLevel() && !loadSo) {
            printEncodeButNotEncrypt();
        }
        return bArr;
    }
}
