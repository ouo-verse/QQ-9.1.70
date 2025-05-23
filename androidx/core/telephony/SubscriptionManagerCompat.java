package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static class Api29Impl {
        Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int i3) {
            int slotIndex;
            slotIndex = SubscriptionManager.getSlotIndex(i3);
            return slotIndex;
        }
    }

    SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i3) {
        if (i3 == -1) {
            return -1;
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 29) {
            return Api29Impl.getSlotIndex(i3);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                if (i16 >= 26) {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i3));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
