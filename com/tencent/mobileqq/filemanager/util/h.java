package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {
    public static boolean a(AppRuntime appRuntime, String str, boolean z16) {
        return e(appRuntime).decodeBool(str + appRuntime.getCurrentUin(), z16);
    }

    public static int b(AppRuntime appRuntime, String str, int i3) {
        return e(appRuntime).decodeInt(str + appRuntime.getCurrentUin(), i3);
    }

    public static String c(AppRuntime appRuntime, String str, String str2) {
        return e(appRuntime).decodeString(str + appRuntime.getCurrentUin(), str2);
    }

    private static boolean d(Object obj) {
        if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                if (it.next() instanceof String) {
                    return true;
                }
            }
        }
        if (obj instanceof HashSet) {
            Iterator it5 = ((HashSet) obj).iterator();
            while (it5.hasNext()) {
                if (it5.next() instanceof String) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static synchronized MMKVOptionEntity e(AppRuntime appRuntime) {
        synchronized (h.class) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQ_FILE);
            String currentUin = appRuntime.getCurrentUin();
            if (from.decodeBool("file_config_migrate_flag_" + currentUin, false)) {
                return from;
            }
            QLog.d("FileDataStorageUtil", 1, "migrateSpToMmkv start");
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, ?> all = appRuntime.getApplicationContext().getSharedPreferences("file_config_" + currentUin, 0).getAll();
            if (all != null && all.size() > 0) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        if (value instanceof Boolean) {
                            from.encodeBool(key + currentUin, ((Boolean) value).booleanValue());
                        } else if (value instanceof Integer) {
                            from.encodeInt(key + currentUin, ((Integer) value).intValue());
                        } else if (value instanceof Long) {
                            from.encodeLong(key + currentUin, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            from.encodeFloat(key + currentUin, ((Float) value).floatValue());
                        } else if (value instanceof Double) {
                            from.encodeDouble(key + currentUin, ((Double) value).doubleValue());
                        } else if (value instanceof String) {
                            from.encodeString(key + currentUin, (String) value);
                        } else if (d(value)) {
                            from.encodeStringSet(key + currentUin, (Set) value);
                        } else {
                            QLog.e("FileDataStorageUtil", 1, "migrate unknown type: " + value.getClass());
                        }
                    }
                }
            }
            from.encodeBool("file_config_migrate_flag_" + currentUin, true);
            QLog.d("FileDataStorageUtil", 1, "migrateSpToMmkv done, cost: " + (System.currentTimeMillis() - currentTimeMillis));
            return from;
        }
    }

    public static void f(AppRuntime appRuntime, String str, boolean z16) {
        e(appRuntime).encodeBool(str + appRuntime.getCurrentUin(), z16);
    }

    public static void g(AppRuntime appRuntime, String str, int i3) {
        e(appRuntime).encodeInt(str + appRuntime.getCurrentUin(), i3);
    }

    public static void h(AppRuntime appRuntime, String str, String str2) {
        e(appRuntime).encodeString(str + appRuntime.getCurrentUin(), str2);
    }
}
