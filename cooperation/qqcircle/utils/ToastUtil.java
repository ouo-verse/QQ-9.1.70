package cooperation.qqcircle.utils;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ToastUtil {
    private static final long CODE_IN_BLACK = 10023;
    private static final long CODE_NO_UPDATE = 10022;

    ToastUtil() {
    }

    public static void determineShowByCode(long j3, Context context, String str, int i3) {
        determineShowByCode(j3, context, 0, str, i3);
    }

    public static void determineShowByCode(long j3, Context context, int i3, String str, int i16) {
        if (j3 == CODE_NO_UPDATE || j3 == CODE_IN_BLACK) {
            return;
        }
        QQToast.makeText(context, i3, str, i16).show();
    }
}
