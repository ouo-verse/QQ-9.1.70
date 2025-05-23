package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bo {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQLocation/Inject_AppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b f306635a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f306636b;

    static {
        ArrayList arrayList = new ArrayList();
        f306636b = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
    }

    private static void a() {
        if (f306635a == null) {
            b();
        }
    }

    @QAutoInitMethod
    static void b() {
        f306635a = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f306636b);
    }

    public static boolean c() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306635a;
        if (bVar == null) {
            QLog.w("LocationAppSetting", 1, "inject failed, call isDebugVersion");
            return false;
        }
        return bVar.isDebugVersion();
    }

    public static boolean d() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306635a;
        if (bVar == null) {
            QLog.w("LocationAppSetting", 1, "inject failed, call isPublicVersion");
            return false;
        }
        return bVar.isPublicVersion();
    }
}
