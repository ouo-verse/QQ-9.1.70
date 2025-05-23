package com.tencent.mobileqq.vas.image;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_DynamicSo.yml", version = 1)
    public static j f309589a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f309590b;

    static {
        ArrayList arrayList = new ArrayList();
        f309590b = arrayList;
        arrayList.add(g.class);
        a();
    }

    @QAutoInitMethod
    static void a() {
        f309589a = (j) com.tencent.mobileqq.qroute.utils.b.a(f309590b);
    }
}
