package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class UserManagerCompat {
    UserManagerCompat() {
    }

    public static boolean isUserUnlocked(@NonNull Context context) {
        boolean isUserUnlocked;
        if (Build.VERSION.SDK_INT >= 24) {
            isUserUnlocked = ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
            return isUserUnlocked;
        }
        return true;
    }
}
