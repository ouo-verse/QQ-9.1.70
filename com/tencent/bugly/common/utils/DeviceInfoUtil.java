package com.tencent.bugly.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.util.AbiUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceInfoUtil {
    public static final String PERMISSION_READ_PHONE = "android.permission.READ_PHONE_STATE";
    private static final String TAG = "DeviceInfoUtil";
    private static final HashMap<String, Boolean> permissionCache = new HashMap<>();

    public static String getCpuAbiByLibDir(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null || (applicationInfo = context.getApplicationInfo()) == null) {
            return "fail";
        }
        String str = applicationInfo.nativeLibraryDir;
        if (TextUtils.isEmpty(str)) {
            return "fail";
        }
        if (str.endsWith(AbiUtil.ARM)) {
            return "armeabi-v7a";
        }
        if (str.endsWith(ResourceAttributes.HostArchValues.ARM64)) {
            return "arm64-v8a";
        }
        if (str.endsWith(ResourceAttributes.HostArchValues.X86)) {
            return ResourceAttributes.HostArchValues.X86;
        }
        if (!str.endsWith("x86_64")) {
            return "fail";
        }
        return "x86_64";
    }

    public static long getRamTotalSize() {
        BufferedReader bufferedReader;
        Throwable th5;
        String readLine;
        long j3 = 0;
        try {
            File file = new File("/proc", "meminfo");
            if (file.exists() && file.canRead()) {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    do {
                        try {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                            break;
                        } catch (Throwable th6) {
                            th5 = th6;
                            try {
                                Logger.f365497g.c(TAG, th5);
                                return 0L;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th7) {
                                        Logger.f365497g.c(TAG, th7);
                                    }
                                }
                            }
                        }
                    } while (!readLine.startsWith("MemTotal:"));
                    break;
                    bufferedReader.close();
                } catch (Throwable th8) {
                    Logger.f365497g.c(TAG, th8);
                }
                j3 = Long.parseLong(readLine.split("\\s+")[1]) * 1024;
                return j3;
            }
            return 0L;
        } catch (Throwable th9) {
            bufferedReader = null;
            th5 = th9;
        }
    }

    public static boolean hasPermission(Context context, String str) {
        return hasPermissions(context, new String[]{str});
    }

    public static boolean hasPermissions(Context context, String[] strArr) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 >= length) {
                    return true;
                }
                String str = strArr[i3];
                HashMap<String, Boolean> hashMap = permissionCache;
                Boolean bool = hashMap.get(str);
                if (bool != null) {
                    if (!bool.booleanValue()) {
                        return false;
                    }
                } else {
                    if (packageManager.checkPermission(str, context.getPackageName()) != 0) {
                        z16 = false;
                    }
                    hashMap.put(str, Boolean.valueOf(z16));
                    if (!z16) {
                        return false;
                    }
                }
                i3++;
            }
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return false;
        }
    }
}
