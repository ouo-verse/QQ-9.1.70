package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SQLiteCursorCompat {
    SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(@NonNull SQLiteCursor sQLiteCursor, boolean z16) {
        if (Build.VERSION.SDK_INT >= 28) {
            sQLiteCursor.setFillWindowForwardOnly(z16);
        }
    }
}
