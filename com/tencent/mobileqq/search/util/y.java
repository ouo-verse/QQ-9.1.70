package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.util.TokenResUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f285094a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f285095b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Boolean f285096c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Boolean f285097d;

    public static boolean a() {
        if (f285096c != null) {
            return f285096c.booleanValue();
        }
        f285096c = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("search_is_optimize_ui", false));
        return f285096c.booleanValue();
    }

    public static boolean b() {
        if (f285095b != null) {
            return f285095b.booleanValue();
        }
        f285095b = Boolean.valueOf(((IQQSearchApi) QRoute.api(IQQSearchApi.class)).isOptSearch());
        return f285095b.booleanValue();
    }

    public static boolean c() {
        if (f285097d != null) {
            return f285097d.booleanValue();
        }
        f285097d = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("search_is_qidian_fix", true));
        return f285097d.booleanValue();
    }

    public static boolean d() {
        if (f285094a != null) {
            return f285094a.booleanValue();
        }
        f285094a = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("search_hide_create_group"));
        return f285094a.booleanValue();
    }

    public static boolean e() {
        return TokenResUtils.useNewSearch();
    }

    public static void f() {
        f285094a = null;
        f285095b = null;
        f285096c = null;
    }
}
