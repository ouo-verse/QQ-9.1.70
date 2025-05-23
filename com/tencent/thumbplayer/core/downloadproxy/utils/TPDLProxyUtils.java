package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPDLProxyUtils {
    private static final String FILE_NAME = "TPDLProxyUtils";
    private static String sAppVer;
    private static String sDeviceModel;

    public static String byteArrayToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, StandardCharsets.UTF_8);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "byteArrayToString failed, error:" + th5);
            return "";
        }
    }

    public static String generateMd5(String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            for (byte b16 : MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())) {
                sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
            }
        } catch (NoSuchAlgorithmException unused) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get md5");
        }
        return sb5.toString();
    }

    public static String getAppVer(Context context) {
        if (!TextUtils.isEmpty(sAppVer)) {
            return sAppVer;
        }
        if (context == null) {
            return "";
        }
        try {
            String str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            sAppVer = str;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getCurrentStackTrace(String str, int i3) {
        String str2 = str + "\n";
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length != 0) {
                int min = Math.min(i3, stackTrace.length);
                for (int i16 = 0; i16 < min; i16++) {
                    str2 = str2 + stackTrace[i16] + "\n";
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static synchronized String getDeviceModel() {
        String str;
        synchronized (TPDLProxyUtils.class) {
            if (!TextUtils.isEmpty(sDeviceModel)) {
                sDeviceModel = DeviceInfoMonitor.getModel();
            }
            str = sDeviceModel;
        }
        return str;
    }

    public static String getExceptionCallStack(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append(stackTraceElement.toString());
            sb5.append(System.lineSeparator());
        }
        return sb5.toString();
    }

    public static boolean getJSONBooleanValue(JSONObject jSONObject, String str, boolean z16) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (Throwable unused) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get json boolean value error");
            }
        }
        return z16;
    }

    public static int getJSONIntValue(JSONObject jSONObject, String str, int i3) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (Throwable unused) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get json int value error");
            }
        }
        return i3;
    }

    public static String getJSONStringValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Throwable unused) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get json string value error");
            }
        }
        return str2;
    }

    public static int getMapIntValue(Map<String, Object> map, String str, int i3) {
        if (map != null && map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        return i3;
    }

    public static String getMapStringValue(Map<String, Object> map, String str, String str2) {
        if (map != null && map.containsKey(str)) {
            return (String) map.get(str);
        }
        return str2;
    }

    public static int getNetWorkState(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (NetworkMonitor.getType(activeNetworkInfo) != 1 && NetworkMonitor.getType(activeNetworkInfo) != 9) {
                    if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                        return 2;
                    }
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNetWorkState network type:" + NetworkMonitor.getType(activeNetworkInfo));
                }
                return 1;
            }
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNetWorkState failed, error:" + th5);
        }
        return 0;
    }

    public static String losePackageCheck(int i3) {
        String str;
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "ping -c " + i3 + " www.qq.com").getInputStream()));
            str = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains(" packet loss")) {
                        str2 = readLine.substring(10 + readLine.indexOf("received, "), readLine.indexOf("%") + 1);
                    }
                    if (readLine.contains("avg")) {
                        int indexOf = readLine.indexOf("/", 20);
                        str = readLine.substring(indexOf + 1, readLine.indexOf(".", indexOf));
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th.printStackTrace();
                    return str2 + ";" + str;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            str = "";
        }
        return str2 + ";" + str;
    }

    public static int objectToInt(Object obj, int i3) {
        if (obj == null) {
            return i3;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to int failed, error:" + th5);
            return i3;
        }
    }

    public static long objectToLong(Object obj, long j3) {
        if (obj == null) {
            return j3;
        }
        try {
            return ((Long) obj).longValue();
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to long failed, error:" + th5);
            return j3;
        }
    }

    public static String serialize(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(obj);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("ISO-8859-1");
            try {
                objectOutputStream.close();
            } catch (Throwable th7) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string  objectOutputStream close, error:" + th7);
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th8) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string byteArrayOutputStream close, error:" + th8);
            }
            return byteArrayOutputStream2;
        } catch (Throwable th9) {
            th = th9;
            objectOutputStream2 = objectOutputStream;
            try {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize obj, error:" + th);
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Throwable th10) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string  objectOutputStream close, error:" + th10);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return "";
                } catch (Throwable th11) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "obj serialize to string byteArrayOutputStream close, error:" + th11);
                    return "";
                }
            } finally {
            }
        }
    }

    public static Object serializeToObject(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th5) {
                th = th5;
                objectInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            objectInputStream = null;
            byteArrayInputStream = null;
        }
        try {
            Object readObject = objectInputStream.readObject();
            try {
                objectInputStream.close();
            } catch (Throwable th7) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj objectInputStream close, error:" + th7);
            }
            try {
                byteArrayInputStream.close();
            } catch (Throwable th8) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj byteArrayInputStream close, error:" + th8);
            }
            return readObject;
        } catch (Throwable th9) {
            th = th9;
            try {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj , error:" + th);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable th10) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj objectInputStream close, error:" + th10);
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th11) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "serialize to obj byteArrayInputStream close, error:" + th11);
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static synchronized void setDeviceModel(String str) {
        synchronized (TPDLProxyUtils.class) {
            sDeviceModel = str;
        }
    }

    public static int stringToInt(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            try {
                return Integer.parseInt(str);
            } catch (Throwable th5) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "string to int failed, str: " + str + ", error:" + th5);
                return i3;
            }
        } catch (NumberFormatException unused) {
            return (int) Double.parseDouble(str);
        }
    }

    public static long stringToLong(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th5) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "string to int failed, error:" + th5);
            return j3;
        }
    }
}
