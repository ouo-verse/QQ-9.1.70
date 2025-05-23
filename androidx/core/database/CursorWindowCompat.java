package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CursorWindowCompat {
    CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j3) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CursorWindow(str, j3);
        }
        return new CursorWindow(str);
    }
}
