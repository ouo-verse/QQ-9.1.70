package cooperation.qzone;

import android.app.Activity;
import android.os.Build;
import android.util.ArrayMap;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LeakUtil {
    public static final String TAG = "LeakUtil";

    public static void fixOnPauseListenersLeak(Activity activity) {
        if (Build.VERSION.SDK_INT < 28 && activity != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                if (invoke == null) {
                    return;
                }
                Field declaredField = cls.getDeclaredField("mOnPauseListeners");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj instanceof ArrayMap) {
                    ((ArrayMap) obj).remove(activity);
                }
            } catch (Exception e16) {
                QLog.d(TAG, 4, "fixOnPauseListenersLeak", e16);
            }
        }
    }

    public static void removeLeakOn_SpenGestureManager(Activity activity) {
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "removeLeakOn_SpenGestureManager samsung device");
            }
            try {
                Field declaredField = Class.forName("com.samsung.android.smartclip.SpenGestureManager").getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(null, null);
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
            } catch (NoSuchFieldException e18) {
                e18.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
