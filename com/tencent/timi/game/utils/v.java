package com.tencent.timi.game.utils;

import android.content.res.Resources;
import android.view.View;

/* compiled from: P */
/* loaded from: classes26.dex */
public class v {
    public static void a(View view) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility & (-257) & (-5) & (-3) & (-513) & (-4097);
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
    }

    public static boolean b(Resources resources) {
        if (resources.getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static void c(View view) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i3 = systemUiVisibility | 256 | 4 | 1024 | 2 | 512 | 4096;
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
    }
}
