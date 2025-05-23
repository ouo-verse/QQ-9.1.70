package hv;

import android.os.Build;
import com.tencent.av.network.api.INetworkAccelerationControlApi;
import com.tencent.av.utils.af;
import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Integer> f406389a;

    static {
        HashMap hashMap = new HashMap();
        f406389a = hashMap;
        hashMap.put(1, 0);
        hashMap.put(2, 1);
    }

    public static boolean a(SocketInfo socketInfo, SocketInfo socketInfo2) {
        if (socketInfo == null && socketInfo2 == null) {
            return true;
        }
        if (socketInfo == null || socketInfo2 == null) {
            return false;
        }
        if (socketInfo.destIP.equalsIgnoreCase(socketInfo2.destIP) && socketInfo.destPort == socketInfo2.destPort && socketInfo.f77483fd == socketInfo2.f77483fd) {
            return true;
        }
        return false;
    }

    public static int b(int i3) {
        return f406389a.get(Integer.valueOf(i3)).intValue();
    }

    public static INetworkAccelerationControlApi c() {
        return (INetworkAccelerationControlApi) QRoute.api(INetworkAccelerationControlApi.class);
    }

    public static boolean d() {
        if (!af.a().booleanValue()) {
            return false;
        }
        if (!g() && !e()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean e() {
        Field field;
        int i3;
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR) && Build.VERSION.SDK_INT >= 31) {
            if (!f()) {
                QLog.d("NetworkAccelerationUtil", 1, "magic cang lan switch close");
                return false;
            }
            try {
                Field[] declaredFields = Class.forName("com.hihonor.android.os.Build$VERSION").getDeclaredFields();
                int length = declaredFields.length;
                int i16 = 0;
                while (true) {
                    if (i16 < length) {
                        field = declaredFields[i16];
                        if (field.getName().equals("MAGIC_SDK_INT")) {
                            field.setAccessible(true);
                            break;
                        }
                        i16++;
                    } else {
                        field = null;
                        break;
                    }
                }
                if (field == null) {
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport cacheField null");
                    return false;
                }
                try {
                    field.setAccessible(true);
                    i3 = ((Integer) field.get(null)).intValue();
                } catch (ClassCastException unused) {
                    QLog.d("NetworkAccelerationUtil", 1, "ClassCastException");
                    i3 = 0;
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                    if (i3 >= 35) {
                    }
                } catch (IllegalAccessException unused2) {
                    QLog.d("NetworkAccelerationUtil", 1, "IllegalAccessException");
                    i3 = 0;
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                    if (i3 >= 35) {
                    }
                } catch (IllegalArgumentException unused3) {
                    QLog.d("NetworkAccelerationUtil", 1, "IllegalArgumentException");
                    i3 = 0;
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                    if (i3 >= 35) {
                    }
                } catch (SecurityException unused4) {
                    QLog.d("NetworkAccelerationUtil", 1, "SecurityException");
                    i3 = 0;
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                    if (i3 >= 35) {
                    }
                } catch (Exception e16) {
                    QLog.d("NetworkAccelerationUtil", 1, "not above exception " + e16);
                    i3 = 0;
                    QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                    if (i3 >= 35) {
                    }
                }
                QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport version:=" + i3);
                if (i3 >= 35) {
                    return false;
                }
                return true;
            } catch (ClassNotFoundException unused5) {
                QLog.d("NetworkAccelerationUtil", 1, "isMAGICSupport ClassNotFoundException");
            }
        }
        return false;
    }

    private static boolean f() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("key_magic_cang_lan_switch", true);
    }

    private static boolean g() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO") && Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return false;
    }
}
