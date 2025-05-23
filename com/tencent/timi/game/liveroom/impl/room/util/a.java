package com.tencent.timi.game.liveroom.impl.room.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qqlive.utils.QQLiveFolderScreenUtil;
import com.tencent.qqlive.common.screen.ScreenUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return b(context, ScreenUtils.getScreenWidth(context), ScreenUtils.getScreenHeight(context));
    }

    public static boolean b(Context context, int i3, int i16) {
        if (context == null || i3 == 0 || i16 == 0) {
            return false;
        }
        return QQLiveFolderScreenUtil.isFolderScreenOpenModeByWH(context, i3, i16);
    }

    public static boolean c(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return b(context, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
