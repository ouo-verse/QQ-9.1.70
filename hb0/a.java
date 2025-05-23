package hb0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static boolean a(String str) {
        if (TextUtils.equals(str, "bottom_icon_click")) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.equals(str, "cold_boot_normal") || TextUtils.equals(str, "cold_boot_red_point") || TextUtils.equals(str, "cold_boot_friend_tab") || TextUtils.equals(str, "cold_boot_unknown")) {
            return true;
        }
        return false;
    }
}
