package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.ui.ComponentAdapter;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static dk0.d f262594a;

    public static void a() {
        fk0.d.c().f(b());
        fk0.b.d(BaseApplicationImpl.getApplication());
    }

    public static dk0.d b() {
        if (f262594a == null) {
            f262594a = new ComponentAdapter();
        }
        return f262594a;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("web.kandian.qq.com") || str.contains("webtest.kandian.qq.com");
    }

    public static boolean e(String str) {
        return false;
    }

    public static String c(String str) {
        return str;
    }
}
