package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ActivityManagerCompat {
    ActivityManagerCompat() {
    }

    public static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
