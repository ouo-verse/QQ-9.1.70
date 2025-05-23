package com.tencent.mqq.shared_file_accessor;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.ref.SoftReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class Utils {
    private static final int BUF_SIZE = 12288;
    private static final String LOG_TAG = "Utils";
    private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save";
    private static final Uri SAVE_CMD_URI = Uri.parse(CP_URI_BASE);
    static String sCurrentProcessName = "";
    static boolean sIsSameProcessAsCP = false;
    private static SoftReference<ByteArrayOutputStream> mBuffer = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class StackInfo {
        final String clazz;
        final String method;
        final String stack;

        StackInfo(String str, String str2, String str3) {
            this.clazz = str;
            this.method = str2;
            this.stack = str3;
        }
    }

    private static ByteArrayOutputStream ensureBuffer() {
        ByteArrayOutputStream byteArrayOutputStream;
        SoftReference<ByteArrayOutputStream> softReference = mBuffer;
        if (softReference != null && (byteArrayOutputStream = softReference.get()) != null) {
            return byteArrayOutputStream;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(12288);
            mBuffer = new SoftReference<>(byteArrayOutputStream2);
            return byteArrayOutputStream2;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackInfo getMiniStackInfo() {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        String str = "";
        String str2 = str;
        int i3 = 0;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (!className.contains("SPStatInspector") && !className.startsWith("com.tencent.mqq.shared_file_accessor.") && !className.startsWith("android.") && !className.startsWith("java.") && !className.startsWith("com.android.") && !className.startsWith("org.chromium.") && !className.startsWith("dalvik.")) {
                i3++;
                if (i3 >= 8) {
                    break;
                }
                if (!z16) {
                    str = stackTraceElement.getClassName();
                    str2 = stackTraceElement.getMethodName();
                    z16 = true;
                }
                sb5.append(stackTraceElement.toString());
                sb5.append(",");
                sb5.append("\n");
            }
        }
        return new StackInfo(str, str2, sb5.toString());
    }

    private static String getProcessName(Context context) {
        String str;
        FileReader fileReader;
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            QLog.w("Utils", 1, "getRunningProcesses fail");
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/proc/" + myPid + "/cmdline");
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    char[] cArr = new char[512];
                    fileReader.read(cArr);
                    int i3 = 0;
                    while (i3 < 512 && cArr[i3] != 0) {
                        i3++;
                    }
                    str = new String(cArr).substring(0, i3);
                    fileReader.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileReader2 = fileReader;
                    try {
                        QLog.w("Utils", 1, "getProcessNameCmdLine fail", th);
                        if (fileReader2 != null) {
                            fileReader2.close();
                        }
                        return str;
                    } catch (Throwable th7) {
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th7;
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences getSystemSp(Context context, String str, int i3) {
        return SharedPreferencesProxyManager.getInstance().adapter.getSystemSharedPreferences(str, i3);
    }

    public static void initCurrentProcessName(Context context) {
        String str = sCurrentProcessName;
        if ((str == null || str.length() == 0) && context != null) {
            String processName = getProcessName(context);
            sCurrentProcessName = processName;
            if (TextUtils.isEmpty(processName)) {
                QLog.w("Utils", 1, "getProcessName fail");
                return;
            }
            QLog.i("Utils", 1, "current process name: " + sCurrentProcessName);
            sIsSameProcessAsCP = TextUtils.equals(context.getPackageName(), sCurrentProcessName);
        }
    }

    public static Serializable loadData(String str) {
        FileInputStream fileInputStream;
        Serializable serializable;
        File file;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream);
                try {
                    serializable = (Serializable) objectInputStream2.readObject();
                } catch (FileNotFoundException unused) {
                    serializable = null;
                } catch (StreamCorruptedException unused2) {
                    serializable = null;
                } catch (IOException unused3) {
                    serializable = null;
                } catch (ClassNotFoundException unused4) {
                    serializable = null;
                } catch (Throwable unused5) {
                    serializable = null;
                }
                try {
                    objectInputStream2.close();
                    fileInputStream.close();
                    file = new File(str);
                } catch (FileNotFoundException unused6) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    file = new File(str);
                    file.delete();
                    return serializable;
                } catch (StreamCorruptedException unused9) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused10) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused11) {
                        }
                    }
                    file = new File(str);
                    file.delete();
                    return serializable;
                } catch (IOException unused12) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused13) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused14) {
                        }
                    }
                    file = new File(str);
                    file.delete();
                    return serializable;
                } catch (ClassNotFoundException unused15) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused16) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused17) {
                        }
                    }
                    file = new File(str);
                    file.delete();
                    return serializable;
                } catch (Throwable unused18) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused19) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused20) {
                        }
                    }
                    file = new File(str);
                    file.delete();
                    return serializable;
                }
            } catch (FileNotFoundException unused21) {
                serializable = null;
            } catch (StreamCorruptedException unused22) {
                serializable = null;
            } catch (IOException unused23) {
                serializable = null;
            } catch (ClassNotFoundException unused24) {
                serializable = null;
            } catch (Throwable unused25) {
                serializable = null;
            }
        } catch (FileNotFoundException unused26) {
            fileInputStream = null;
            serializable = null;
        } catch (StreamCorruptedException unused27) {
            fileInputStream = null;
            serializable = null;
        } catch (IOException unused28) {
            fileInputStream = null;
            serializable = null;
        } catch (ClassNotFoundException unused29) {
            fileInputStream = null;
            serializable = null;
        } catch (Throwable unused30) {
            fileInputStream = null;
            serializable = null;
        }
        file.delete();
        return serializable;
    }

    public static void notifySave(Context context) {
        if (context == null) {
            return;
        }
        context.getContentResolver().update(SAVE_CMD_URI, new ContentValues(0), null, null);
    }

    private static final void onGetSystemSpException(Exception exc) {
        exc.printStackTrace();
        if (SharedPreferencesProxyManager.sSystemSpExceptionMsg == null) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append(exc.getMessage());
            sb5.append(Log.getStackTraceString(exc));
            SharedPreferencesProxyManager.sSystemSpExceptionMsg = sb5.toString();
        }
    }

    static boolean readGivenLenOrFail(byte[] bArr, int i3, int i16, InputStream inputStream) {
        if (i16 == 0) {
            return true;
        }
        int i17 = 0;
        int i18 = 0;
        while (i16 > 0 && i17 >= 0) {
            try {
                i17 = inputStream.read(bArr, i3 + i18, i16);
                i16 -= i17;
                i18 += i17;
            } catch (IOException unused) {
                return false;
            }
        }
        if (i16 == 0) {
            return true;
        }
        return false;
    }

    public static boolean renameFile(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0042, code lost:
    
        if (r4 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean saveData(Serializable serializable, String str) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream ensureBuffer = ensureBuffer();
        if (ensureBuffer == null) {
            return false;
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            ensureBuffer.reset();
            objectOutputStream = new ObjectOutputStream(ensureBuffer);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream = new FileOutputStream(str);
            } catch (FileNotFoundException unused) {
                fileOutputStream = null;
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (OutOfMemoryError unused3) {
                fileOutputStream = null;
            } catch (Throwable unused4) {
                fileOutputStream = null;
            }
        } catch (FileNotFoundException unused5) {
            fileOutputStream = null;
        } catch (IOException unused6) {
            fileOutputStream = null;
        } catch (OutOfMemoryError unused7) {
            fileOutputStream = null;
        } catch (Throwable unused8) {
            fileOutputStream = null;
        }
        try {
            ensureBuffer.writeTo(fileOutputStream);
            ensureBuffer.flush();
            ensureBuffer.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException unused9) {
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused10) {
                }
            }
        } catch (IOException unused11) {
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused12) {
                }
            }
        } catch (OutOfMemoryError unused13) {
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused14) {
                }
            }
        } catch (Throwable unused15) {
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused16) {
                }
            }
        }
    }

    public static void initCurrentProcessName(Context context, String str) {
        String str2 = sCurrentProcessName;
        if ((str2 == null || str2.length() == 0) && context != null) {
            sCurrentProcessName = str;
            if (TextUtils.isEmpty(str)) {
                QLog.w("Utils", 1, "getProcessName fail");
                return;
            }
            QLog.i("Utils", 1, "current process name: " + sCurrentProcessName);
            sIsSameProcessAsCP = TextUtils.equals(context.getPackageName(), sCurrentProcessName);
        }
    }
}
