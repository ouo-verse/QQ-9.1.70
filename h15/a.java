package h15;

import android.os.Bundle;
import android.view.View;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag();
        if (!(tag instanceof Bundle)) {
            return false;
        }
        return ((Bundle) tag).getBoolean("data_key_status_bar_color", false);
    }
}
