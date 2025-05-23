package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class ResultReceiverCompat {
    ResultReceiverCompat() {
    }

    @SuppressLint({"RestrictedApi"})
    public static void callOnResultReceive(@NonNull ResultReceiver resultReceiver, int i3, Bundle bundle) {
        resultReceiver.onReceiveResult(i3, bundle);
    }

    public static Handler getHandler(@NonNull ResultReceiver resultReceiver) {
        return resultReceiver.mHandler;
    }
}
