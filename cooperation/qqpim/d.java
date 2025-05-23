package cooperation.qqpim;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {
    public static long a(Context context, String str) {
        return context.getSharedPreferences("QQPIM_SETTING", 0).getLong(str, 0L);
    }

    public static String b(Context context, String str) {
        return context.getSharedPreferences("QQPIM_SETTING", 0).getString(str, "");
    }

    public static void c(Context context, String str, long j3) {
        context.getSharedPreferences("QQPIM_SETTING", 0).edit().putLong(str, j3).commit();
    }

    public static void d(Context context, String str, String str2) {
        if (str2 == null) {
            return;
        }
        context.getSharedPreferences("QQPIM_SETTING", 0).edit().putString(str, str2).commit();
    }
}
