package lq3;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qmmkv.QMMKV;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static SharedPreferences a(Context context, String str) {
        if (str == null || str.length() == 0) {
            str = "sdk_preference";
        }
        if (!b(context)) {
            QMMKV.migrateToSpAdapter(context, str, "common_mmkv_configurations");
            c(context);
        }
        return QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
    }

    private static boolean b(Context context) {
        return QMMKV.from(context, "common_mmkv_configurations").decodeBool("opensdk_preference_has_migrate", false);
    }

    private static void c(Context context) {
        QMMKV.from(context, "common_mmkv_configurations").encodeBool("opensdk_preference_has_migrate", true);
    }
}
