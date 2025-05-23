package androidx.core.app;

import android.app.Service;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface StopForegroundFlags {
    }

    ServiceCompat() {
    }

    public static void stopForeground(@NonNull Service service, int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            service.stopForeground(i3);
            return;
        }
        boolean z16 = true;
        if ((i3 & 1) == 0) {
            z16 = false;
        }
        service.stopForeground(z16);
    }
}
