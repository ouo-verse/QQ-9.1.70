package com.huawei.hms.health;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class aaca {
    private static int aab = -1;
    private static final aaba[] aaba;
    private static final List<Integer> aabb = Arrays.asList(0, 1, 2);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class aaba {
        private int aab;
        private String aaba;
        private boolean aabb;
        private String aabc;
        private String aabd;

        /* synthetic */ aaba(int i3, String str, boolean z16, String str2, String str3, aab aabVar) {
            this.aab = i3;
            this.aaba = str;
            this.aabb = z16;
            this.aabc = str2;
            this.aabd = str3;
        }
    }

    static {
        boolean z16 = false;
        aab aabVar = null;
        String str = null;
        aaba = new aaba[]{new aaba(0, "handset", false, "default", null, null), new aaba(1, "pad", false, "tablet", null, null), new aaba(2, "watch", true, "watch", "watch", null), new aaba(3, "kidwatch", false, "kidwatch", 0 == true ? 1 : 0, null), new aaba(4, "tv", true, "tv", "television", null), new aaba(5, "mobiletv", z16, "mobiletv", 0 == true ? 1 : 0, aabVar), new aaba(6, "glass", z16, str, 0 == true ? 1 : 0, aabVar), new aaba(7, "earphone", z16, str, 0 == true ? 1 : 0, aabVar), new aaba(8, "car", z16, "car", "automotive", aabVar)};
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r7 != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0134, code lost:
    
        if (r9 != 0) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int aab(Context context) {
        int i3;
        int i16;
        String str = "";
        if (aab != -1) {
            StringBuilder aab2 = com.huawei.hms.health.aab.aab("get deviceType from cache: ");
            aab2.append(aab);
            aabz.aabb("DeviceTypeTool", aab2.toString());
        } else if (context == null) {
            aabz.aab("DeviceTypeTool", "context is null.");
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                aabz.aab("DeviceTypeTool", "packageManager is null.");
                i3 = -1;
            } else {
                FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
                int length = systemAvailableFeatures.length;
                i3 = -1;
                int i17 = 0;
                while (true) {
                    if (i17 >= length) {
                        break;
                    }
                    FeatureInfo featureInfo = systemAvailableFeatures[i17];
                    String str2 = featureInfo.name;
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("com.huawei.software.features.")) {
                        String substring = str2.substring(29);
                        for (aaba aabaVar : aaba) {
                            if (substring.equals(aabaVar.aaba)) {
                                i3 = aabaVar.aab;
                                if (!aabaVar.aabb) {
                                    break;
                                }
                            }
                        }
                        if (i3 != -1) {
                            StringBuilder aab3 = com.huawei.hms.health.aab.aab("Huawei Feature is found: ");
                            aab3.append(featureInfo.name);
                            aabz.aabb("DeviceTypeTool", aab3.toString());
                            break;
                        }
                    }
                    i17++;
                }
                if (i3 == -1) {
                    i3 = -1;
                }
                try {
                    Object invoke = SystemProperties.class.getDeclaredMethod("get", String.class, String.class).invoke(SystemProperties.class, "ro.build.characteristics", "");
                    if (invoke instanceof String) {
                        Objects.toString(invoke);
                        str = (String) invoke;
                    }
                } catch (Exception unused) {
                    aabz.aaba("DeviceTypeTool", "An exception occurred while reading SystemProperties: ro.build.characteristics");
                }
                if (TextUtils.isEmpty(str)) {
                    i16 = -1;
                } else {
                    List asList = Arrays.asList(str.split(",", 10));
                    Objects.toString(asList);
                    String str3 = null;
                    i16 = -1;
                    for (aaba aabaVar2 : aaba) {
                        if (asList.contains(aabaVar2.aabc)) {
                            i16 = aabaVar2.aab;
                            str3 = aabaVar2.aabc;
                            if (!aabaVar2.aabb) {
                                break;
                            }
                        }
                    }
                    if (i16 != -1) {
                        aabz.aabb("DeviceTypeTool", "System property is found: " + str3);
                    }
                }
                if (i16 != -1) {
                    i3 = i16;
                }
                int length2 = systemAvailableFeatures.length;
                int i18 = -1;
                int i19 = 0;
                while (true) {
                    if (i19 >= length2) {
                        break;
                    }
                    FeatureInfo featureInfo2 = systemAvailableFeatures[i19];
                    String str4 = featureInfo2.name;
                    if (!TextUtils.isEmpty(str4) && str4.startsWith("android.hardware.type.")) {
                        String substring2 = str4.substring(22);
                        aaba[] aabaVarArr = aaba;
                        int length3 = aabaVarArr.length;
                        int i26 = 0;
                        while (true) {
                            if (i26 >= length3) {
                                break;
                            }
                            aaba aabaVar3 = aabaVarArr[i26];
                            if (substring2.equals(aabaVar3.aabd)) {
                                i18 = aabaVar3.aab;
                                break;
                            }
                            i26++;
                        }
                        if (i18 != -1) {
                            StringBuilder aab4 = com.huawei.hms.health.aab.aab("Android Feature is found: ");
                            aab4.append(featureInfo2.name);
                            aabz.aabb("DeviceTypeTool", aab4.toString());
                            break;
                        }
                    }
                    i19++;
                }
                if (i18 != -1) {
                    i3 = i18;
                }
            }
            if (i3 != -1) {
                aab = i3;
            }
            StringBuilder aab5 = com.huawei.hms.health.aab.aab("Final DeviceType: ");
            aab5.append(aab);
            aabz.aabb("DeviceTypeTool", aab5.toString());
            return i3;
        }
        return aab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aaba(Context context) {
        int aab2 = aab(context);
        if (!aabb.contains(Integer.valueOf(aab2)) && aab2 != -1) {
            return false;
        }
        return true;
    }

    public static int aabb(Context context) {
        return aab(context);
    }
}
