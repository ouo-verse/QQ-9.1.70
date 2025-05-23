package com.huawei.hms.health;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.json.JsonSanitizer;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.utils.UIUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacu {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class aab {
        static final /* synthetic */ int[] aab;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            aab = iArr;
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aab[TimeUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Intent aab(int i3, AuthAccount authAccount) {
        HealthKitAuthResult healthKitAuthResult = new HealthKitAuthResult();
        healthKitAuthResult.setAuthAccount(authAccount);
        healthKitAuthResult.setStatus(new Status(i3));
        Intent intent = new Intent();
        try {
            intent.putExtra("HEALTHKIT_AUTH_RESULT", healthKitAuthResult.toJson());
        } catch (JSONException unused) {
            aabz.aab("util", "JSONException");
        }
        return intent;
    }

    public static void aaba(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(str2)) {
            throw new SecurityException(String.valueOf(50011));
        }
    }

    public static boolean aabb(String str) {
        return str == null || str.length() <= 10000;
    }

    public static boolean aabc(String str) {
        return aab(str, 1, 1000);
    }

    public static String aabd(String str) {
        String str2;
        if (str != null && str.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1)));
                byte[] bArr = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                    }
                }
            } catch (IOException unused) {
                str2 = "compressGzip catch IOException.";
                aabz.aabc("util", str2);
                aabz.aabc("util", "return default Gzipped value.");
                return "";
            } catch (Exception unused2) {
                str2 = "compressGzip catch basic exception.";
                aabz.aabc("util", str2);
                aabz.aabc("util", "return default Gzipped value.");
                return "";
            } catch (Throwable unused3) {
                str2 = "catch Throwable";
                aabz.aabc("util", str2);
                aabz.aabc("util", "return default Gzipped value.");
                return "";
            }
        } else {
            return str;
        }
    }

    public static String aab(Object obj) {
        String str = null;
        if (obj == null) {
            aabz.aab("util", "toJson --> object is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = new GsonBuilder().serializeSpecialFloatingPointValues().disableHtmlEscaping().enableComplexMapKeySerialization().setLenient().create().toJson(obj);
        } catch (JsonSyntaxException unused) {
            aabz.aab("util", "toJson --> JsonSyntaxException.");
        }
        com.huawei.hms.health.aab.aab("toJson(Object object), time = ").append(System.currentTimeMillis() - currentTimeMillis);
        return str;
    }

    public static boolean aaba(long j3) {
        return j3 >= 1388505600000L && j3 <= 4102415999000L;
    }

    public static boolean aabb(Context context) {
        boolean z16;
        if (aaba(context)) {
            return true;
        }
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            aabz.aabc("util", "mPowerManager is null");
            z16 = false;
        } else {
            z16 = !powerManager.isInteractive();
        }
        return z16;
    }

    public static String aab(String str, String str2) {
        return str + "." + str2;
    }

    private static boolean aaba(Context context) {
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager != null) {
            return Build.VERSION.SDK_INT >= 28 ? keyguardManager.isKeyguardLocked() : keyguardManager.inKeyguardRestrictedInputMode();
        }
        aabz.aabc("util", "mKeyguardManager is null");
        return false;
    }

    public static String aab(String str, Object... objArr) {
        try {
            return String.format(str, objArr);
        } catch (Exception unused) {
            aabz.aabc("util", "strFormat exception");
            return str;
        }
    }

    public static boolean aaba(String str) {
        return str != null && str.length() != 0 && str.length() >= 1 && str.length() <= 300;
    }

    private static String aab(byte[] bArr) {
        String hexString;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = bArr[i3];
            if ((b16 & 255) < 16) {
                StringBuilder aab2 = com.huawei.hms.health.aab.aab("0");
                aab2.append(Integer.toHexString(bArr[i3] & 255));
                hexString = aab2.toString();
            } else {
                hexString = Integer.toHexString(b16 & 255);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    public static void aab(long j3, long j16, TimeUnit timeUnit) {
        int i3 = aab.aab[timeUnit.ordinal()];
        if (i3 == 1) {
            if (j16 - j3 >= 2678400000L) {
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.QUERY_TIME_EXCEED_LIMIT));
            }
        } else if (i3 == 2 && j16 - j3 >= 2678400000000000L) {
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.QUERY_TIME_EXCEED_LIMIT));
        }
    }

    public static void aab(Intent intent, String str) {
        if (intent == null) {
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
        }
        aaba(!TextUtils.isEmpty(intent.getPackage()) ? intent.getPackage() : intent.getComponent() != null ? intent.getComponent().getPackageName() : "", str);
    }

    public static boolean aab(long j3) {
        return j3 >= 1388505600000000000L && j3 <= 4102415999000000000L;
    }

    public static boolean aab(long j3, long j16) {
        return System.currentTimeMillis() - j3 > j16;
    }

    public static boolean aab(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            String processName = UIUtil.getProcessName(context, Process.myPid());
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                    StringBuilder aab2 = com.huawei.hms.health.aab.aab("appProcess.importance is ");
                    aab2.append(runningAppProcessInfo.importance);
                    aabz.aabb("util", aab2.toString());
                    boolean z16 = runningAppProcessInfo.importance <= 200;
                    aabz.aabb("util", "isForeground is " + z16);
                    return !z16;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean aab(String str) {
        return aab(str, 1, 980);
    }

    public static boolean aab(String str, int i3, int i16) {
        return str != null && str.length() != 0 && str.length() >= i3 && str.length() <= i16;
    }

    public static boolean aab(List list) {
        return list != null && list.size() >= 0 && list.size() <= 30;
    }

    public static boolean aab(Context context, String str, String str2) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        byte[] byteArray;
        String str3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            aabz.aab("util", "packageName is null or context is null");
        } else {
            try {
                packageManager = context.getPackageManager();
            } catch (PackageManager.NameNotFoundException e16) {
                StringBuilder aab2 = com.huawei.hms.health.aab.aab("PackageManager.NameNotFoundException : ");
                aab2.append(e16.getMessage());
                aabz.aab("util", aab2.toString(), Boolean.TRUE);
            } catch (Exception e17) {
                StringBuilder aab3 = com.huawei.hms.health.aab.aab("Exception : ");
                aab3.append(e17.getMessage());
                aabz.aab("util", aab3.toString(), Boolean.TRUE);
            }
            if (packageManager != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str2, 64)) != null) {
                byteArray = packageInfo.signatures[0].toByteArray();
                str3 = "";
                if (byteArray != null && byteArray.length > 0) {
                    try {
                        str3 = aab(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(byteArray));
                    } catch (NoSuchAlgorithmException e18) {
                        StringBuilder aab4 = com.huawei.hms.health.aab.aab("NoSuchAlgorithmException");
                        aab4.append(e18.getMessage());
                        aabz.aab("util", aab4.toString());
                    }
                }
                return str.equalsIgnoreCase(str3);
            }
        }
        byteArray = new byte[0];
        str3 = "";
        if (byteArray != null) {
            str3 = aab(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(byteArray));
        }
        return str.equalsIgnoreCase(str3);
    }

    public static <T> T aab(String str, Type type) {
        boolean z16;
        T t16 = null;
        if (str == null) {
            aabz.aab("util", "fromJson --> json is null");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                try {
                    new JSONObject(str);
                } catch (JSONException unused) {
                    z16 = false;
                }
            } catch (JSONException unused2) {
                new JSONArray(str);
            }
            z16 = true;
        } catch (JsonSyntaxException unused3) {
            StringBuilder aab2 = com.huawei.hms.health.aab.aab("fromJson --> JsonSyntaxException.");
            aab2.append(type.toString());
            aabz.aab("util", aab2.toString());
        }
        if (!z16) {
            return null;
        }
        t16 = (T) new Gson().fromJson(TextUtils.isEmpty(str) ? "" : new StringBuffer(JsonSanitizer.u(str)).toString(), type);
        com.huawei.hms.health.aab.aab("fromJson(String json, Class<T> classOfT), time = ").append(System.currentTimeMillis() - currentTimeMillis);
        return t16;
    }

    public static <T> List<T> aab(String str, Class<T> cls) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    new JSONObject(str);
                } catch (JSONException unused) {
                    new JSONArray(str);
                }
                z16 = true;
            } catch (JSONException unused2) {
                z16 = false;
            }
            if (z16) {
                ArrayList arrayList = new ArrayList();
                try {
                    JsonArray asJsonArray = new JsonParser().parse(TextUtils.isEmpty(str) ? "" : new StringBuffer(JsonSanitizer.u(str)).toString()).getAsJsonArray();
                    if (asJsonArray != null) {
                        Iterator<JsonElement> it = asJsonArray.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new Gson().fromJson(it.next(), (Class) cls));
                        }
                    }
                } catch (JsonSyntaxException | IllegalStateException unused3) {
                    aabz.aab("util", "getListFromJSON Error, Json syntax is wrong");
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public static <T> void aab(Parcel parcel, List<T> list, Parcelable.Creator<T> creator) {
        int size = list.size();
        int readInt = parcel.readInt();
        int i3 = 0;
        if (readInt > 300000) {
            readInt = 300000;
        }
        while (true) {
            T t16 = null;
            if (i3 >= size || i3 >= readInt) {
                break;
            }
            if (parcel.readInt() != 0) {
                t16 = creator.createFromParcel(parcel);
            }
            list.set(i3, t16);
            i3++;
        }
        while (i3 < readInt) {
            list.add(parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
            i3++;
        }
        while (i3 < size) {
            list.remove(readInt);
            i3++;
        }
    }
}
