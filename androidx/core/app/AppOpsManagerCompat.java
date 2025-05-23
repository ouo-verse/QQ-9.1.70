package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    AppOpsManagerCompat() {
    }

    public static int noteOp(@NonNull Context context, @NonNull String str, int i3, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i3, str2);
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String str, int i3, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i3, str2);
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
    }

    @Nullable
    public static String permissionToOp(@NonNull String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
