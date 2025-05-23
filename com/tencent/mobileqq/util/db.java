package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class db {
    public static void a(Context context, String str, boolean z16, boolean z17) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", z16);
        intent.putExtra("hide_more_button", z17);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    public static void c(Activity activity, String str, boolean z16, int i3) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", z16);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_BROWSER, i3);
    }
}
