package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MenuCompat {
    MenuCompat() {
    }

    @SuppressLint({"NewApi"})
    public static void setGroupDividerEnabled(Menu menu, boolean z16) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z16);
        } else if (Build.VERSION.SDK_INT >= 28) {
            menu.setGroupDividerEnabled(z16);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i3) {
        menuItem.setShowAsAction(i3);
    }
}
