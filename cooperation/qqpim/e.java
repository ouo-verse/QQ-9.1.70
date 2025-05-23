package cooperation.qqpim;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e {
    public static void a(Context context, QQPimTipsInfo qQPimTipsInfo) {
        if (qQPimTipsInfo == null) {
            d.c(context, "QQPIM_TIPS_CLICK", System.currentTimeMillis());
            return;
        }
        d.d(context, "QQPIM_TIPS_CLICK" + qQPimTipsInfo.f390793d, qQPimTipsInfo.f390794e + ";" + qQPimTipsInfo.f390796h + ";" + System.currentTimeMillis());
    }

    public static void b(Context context, QQPimTipsInfo qQPimTipsInfo) {
        if (qQPimTipsInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(d.b(context, "QQPIM_TIPS_CLICK" + qQPimTipsInfo.f390793d))) {
            return;
        }
        int i3 = qQPimTipsInfo.f390793d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 4) {
                    qQPimTipsInfo.f390795f = (byte) 0;
                    return;
                }
                return;
            }
            qQPimTipsInfo.f390795f = (byte) 0;
            return;
        }
        qQPimTipsInfo.f390795f = (byte) 0;
    }
}
