package com.tencent.mobileqq.vas.toggle;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_Toggle.yml", version = 1)
    public static a f310992a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f310993b;

    static {
        ArrayList arrayList = new ArrayList();
        f310993b = arrayList;
        arrayList.add(d.class);
        a();
    }

    @QAutoInitMethod
    static void a() {
        f310992a = (a) com.tencent.mobileqq.qroute.utils.b.a(f310993b);
    }
}
