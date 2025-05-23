package gq1;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    public static int a(Context context) {
        if (AppSetting.t(context) && e.a() == SplitViewState.STATE_FLAT) {
            return (int) (x.f(context).f185860a * e.g());
        }
        return x.f(context).f185860a;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        return Math.min((a(context) * 9) / 16, c(context) / 2);
    }

    private static int c(Context context) {
        return x.f(context).f185861b;
    }
}
