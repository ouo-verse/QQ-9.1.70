package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    private static class Api23Impl {
        Api23Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(DeviceInfoUtil.PERMISSION_READ_PHONE)
        @DoNotInline
        static String getDeviceId(TelephonyManager telephonyManager, int i3) {
            return DeviceInfoMonitor.getDeviceId(telephonyManager, i3);
        }
    }

    /* compiled from: P */
    @RequiresApi(26)
    /* loaded from: classes.dex */
    private static class Api26Impl {
        Api26Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(DeviceInfoUtil.PERMISSION_READ_PHONE)
        @DoNotInline
        static String getImei(TelephonyManager telephonyManager) {
            return DeviceInfoMonitor.getImei(telephonyManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        Api30Impl() {
        }

        @DoNotInline
        static int getSubscriptionId(TelephonyManager telephonyManager) {
            int subscriptionId;
            subscriptionId = telephonyManager.getSubscriptionId();
            return subscriptionId;
        }
    }

    TelephonyManagerCompat() {
    }

    @Nullable
    @RequiresPermission(DeviceInfoUtil.PERMISSION_READ_PHONE)
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImei(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId != Integer.MAX_VALUE && subscriptionId != -1) {
            return Api23Impl.getDeviceId(telephonyManager, SubscriptionManagerCompat.getSlotIndex(subscriptionId));
        }
        return DeviceInfoMonitor.getDeviceId(telephonyManager);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId(telephonyManager);
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, new Object[0]);
            if (num != null && num.intValue() != -1) {
                return num.intValue();
            }
            return Integer.MAX_VALUE;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
