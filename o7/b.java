package o7;

import android.text.TextUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f422176a = "_qzonegif";

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(f422176a);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || str.endsWith(f422176a);
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END);
    }
}
