package com.tencent.icgame.game.liveroom.impl.room.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return b(context, ut0.b.b(), ut0.b.a());
    }

    public static boolean b(Context context, int i3, int i16) {
        if (context == null || i3 == 0 || i16 == 0) {
            return false;
        }
        return t42.e.a(context, i3, i16);
    }

    public static boolean c(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return b(context, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
