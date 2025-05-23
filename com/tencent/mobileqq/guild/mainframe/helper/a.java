package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f227419a;

    public static int a(Context context) {
        return b();
    }

    public static int b() {
        return com.tencent.mobileqq.guild.widget.b.b();
    }

    public static int c(Context context) {
        if (f227419a == 0) {
            f227419a = QQGuildUIUtil.p(context).f185860a;
        }
        return (f227419a - (context.getResources().getDimensionPixelSize(R.dimen.cgy) + context.getResources().getDimensionPixelSize(R.dimen.cgu))) - x.c(context, 0.0f);
    }

    public static void d(int i3) {
        f227419a = i3;
    }
}
