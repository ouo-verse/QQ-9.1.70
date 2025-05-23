package i;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.mobileqq.qqbattery.feature.g;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f406965a = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public c<Integer> f406966a;

        /* renamed from: b, reason: collision with root package name */
        public c<Integer> f406967b;
    }

    public static int a(Context context) {
        boolean z16;
        a aVar = f406965a;
        c<Integer> cVar = aVar.f406966a;
        if (cVar != null) {
            if (SystemClock.uptimeMillis() - cVar.f406970c >= cVar.f406969b) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return aVar.f406966a.f406968a.intValue();
            }
        }
        Intent b16 = b(context);
        int i3 = -1;
        if (b16 != null) {
            int intExtra = b16.getIntExtra("level", -1);
            int intExtra2 = b16.getIntExtra("scale", -1);
            if (intExtra2 > 0) {
                i3 = (intExtra * 100) / intExtra2;
            }
        }
        Integer valueOf = Integer.valueOf(i3);
        aVar.f406966a = new c<>(valueOf, 60000L);
        return valueOf.intValue();
    }

    public static Intent b(Context context) {
        try {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e16) {
            StringBuilder a16 = g.a("get ACTION_BATTERY_CHANGED failed: ");
            a16.append(e16.getMessage());
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_BatteryCanaryUtil", a16.toString(), new Object[0]);
            return null;
        }
    }

    public static boolean c(Context context) {
        int intExtra;
        Intent b16 = b(context);
        if (b16 == null || ((intExtra = b16.getIntExtra("status", -1)) != 2 && intExtra != 5)) {
            return false;
        }
        return true;
    }

    public static boolean d(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isInteractive();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
