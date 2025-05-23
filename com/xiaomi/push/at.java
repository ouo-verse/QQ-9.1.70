package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes28.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f388205a;

    /* renamed from: b, reason: collision with root package name */
    private static String f388206b;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f388205a = simpleDateFormat;
        f388206b = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_push_stat");
        gjVar.a("push_sdk_stat_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(bn.b(context).d());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f("");
        gjVar.c("push_stat");
        return gjVar;
    }
}
