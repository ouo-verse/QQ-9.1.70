package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    public static PowerManager.WakeLock f30081a;

    @SuppressLint({"Wakelock"})
    public static void a(Context context) {
        PowerManager.WakeLock wakeLock = f30081a;
        if (wakeLock != null && wakeLock.isHeld()) {
            f30081a.release();
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "WakeLocker");
        f30081a = newWakeLock;
        newWakeLock.acquire(5000L);
    }

    public static void a() {
        PowerManager.WakeLock wakeLock = f30081a;
        if (wakeLock != null && wakeLock.isHeld()) {
            f30081a.release();
        }
        f30081a = null;
    }
}
