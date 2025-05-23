package m0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(String str) {
        if (!TextUtils.equals(str, "mr_data_line") && !TextUtils.equals(str, "mr_data_line_ipad") && !TextUtils.equals(str, "mr_data_line_phone")) {
            return false;
        }
        return true;
    }
}
