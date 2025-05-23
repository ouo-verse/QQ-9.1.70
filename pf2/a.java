package pf2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lpf2/a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i3 = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra != -1 && intExtra2 != -1) {
            i3 = (int) ((intExtra / intExtra2) * 100);
        }
        QLog.i("BatteryInfoImpl", 1, "getBatteryPercentage " + i3);
        return i3;
    }
}
