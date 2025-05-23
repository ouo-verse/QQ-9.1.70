package com.tencent.biz.richframework.network.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SdCardUtil {
    private static String[] SPECIAL_MODEL = {"MI 2", "MI 3", "X9007"};
    private static final String TAG = "SdCardUtil";

    public static long getAvailableExternalMemorySize(Context context) {
        Iterator<String> it = getExternalStorages(context).iterator();
        long j3 = 0;
        while (it.hasNext()) {
            try {
                StatFs statFs = new StatFs(it.next());
                j3 += statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
        }
        return j3;
    }

    public static long getAvailableInternalMemorySize() {
        IllegalArgumentException e16;
        long j3;
        long j16 = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j3 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e17) {
            e16 = e17;
            j3 = 0;
        }
        try {
            try {
                j16 = ((Long) SystemProperties.class.getMethod("getLong", String.class, Long.TYPE).invoke(null, "sys.memory.threshold.low", 0L)).longValue();
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            return j3 - Math.min(j3, j16);
        } catch (IllegalArgumentException e19) {
            e16 = e19;
            e16.printStackTrace();
            return j3;
        }
    }

    private static List<String> getExternalStorages(Context context) {
        boolean z16 = true;
        List<String> storagePathList = getStoragePathList(context, true);
        if (isExternalStorageEmulated() && !isSpecialModel()) {
            Iterator<String> it = storagePathList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().toLowerCase().contains("emulated")) {
                        it.remove();
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                storagePathList.remove(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
        }
        return storagePathList;
    }

    public static String getSdCardDirectory() {
        if (sdCardExists()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    public static ArrayList<String> getStorageDirectories() {
        String absolutePath;
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            try {
                if (hasStorageCard() && (absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath()) != null) {
                    arrayList.add(absolutePath);
                }
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/mounts"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains("vfat") || readLine.contains("exfat") || readLine.contains("/mnt") || readLine.contains("fuse")) {
                            String[] split = readLine.split("\\s+");
                            if (split[1].equals(Environment.getExternalStorageDirectory().getPath())) {
                                if (!includedInList(arrayList, split[1])) {
                                    arrayList.add(split[1]);
                                }
                            } else if (readLine.contains("/dev/block/vold") && !readLine.contains("/mnt/secure") && !readLine.contains("/mnt/asec") && !readLine.contains("/mnt/obb") && !readLine.contains("/dev/mapper") && !readLine.contains("tmpfs") && !includedInList(arrayList, split[1])) {
                                arrayList.add(split[1]);
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        return arrayList;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                trimLastSlash(arrayList);
                try {
                    bufferedReader2.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return arrayList;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }

    public static List<String> getStoragePathList(Context context, boolean z16) {
        ArrayList arrayList = new ArrayList();
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService(QQPermissionConstants.Permission.STORAGE_GROUP);
            Object[] objArr = (Object[]) storageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
            if (objArr != null && objArr.length > 0) {
                Method declaredMethod = objArr[0].getClass().getDeclaredMethod("getPath", new Class[0]);
                Method method = storageManager.getClass().getMethod("getVolumeState", String.class);
                for (Object obj : objArr) {
                    String str = (String) declaredMethod.invoke(obj, new Object[0]);
                    if (str != null) {
                        String str2 = (String) method.invoke(storageManager, str);
                        if (z16 && "mounted".equals(str2)) {
                            arrayList.add(str);
                        } else if (!z16 && !"mounted".equals(str2) && str.contains("sd")) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return getStorageDirectories();
        }
    }

    public static long getTotalExternalMemorySize(Context context) {
        Iterator<String> it = getExternalStorages(context).iterator();
        long j3 = 0;
        while (it.hasNext()) {
            try {
                StatFs statFs = new StatFs(it.next());
                j3 += statFs.getBlockCount() * statFs.getBlockSize();
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
        }
        return j3;
    }

    public static long getTotalInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static boolean hasStorageCard() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    static boolean includedInList(ArrayList<String> arrayList, String str) {
        boolean z16;
        Iterator<String> it = arrayList.iterator();
        do {
            z16 = false;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (str.equals(next)) {
                return true;
            }
            try {
                String canonicalPath = new File(next).getCanonicalPath();
                String canonicalPath2 = new File(str).getCanonicalPath();
                if (canonicalPath != null && canonicalPath2 != null) {
                    z16 = canonicalPath.equals(canonicalPath2);
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } while (!z16);
        return z16;
    }

    public static boolean isExternalStorageEmulated() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageEmulated", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static boolean isSpecialModel() {
        String model = DeviceInfoMonitor.getModel();
        int i3 = 0;
        while (true) {
            String[] strArr = SPECIAL_MODEL;
            if (i3 >= strArr.length) {
                return false;
            }
            if (model != null && model.contains(strArr[i3])) {
                return true;
            }
            i3++;
        }
    }

    public static boolean sdCardExists() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    static void trimLastSlash(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                while (arrayList.get(i3).endsWith("/")) {
                    arrayList.set(i3, arrayList.get(i3).substring(0, arrayList.get(i3).length() - 1));
                }
            }
        }
    }
}
