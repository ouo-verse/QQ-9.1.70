package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        return message.isAsynchronous();
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z16) {
        message.setAsynchronous(z16);
    }
}
