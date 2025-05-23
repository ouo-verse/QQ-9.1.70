package com.tencent.mobileqq.qqmatrix;

import com.tencent.mobileqq.injector.d;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQMatrix/Inject_AppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b f274127a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f274128b;

    static {
        ArrayList arrayList = new ArrayList();
        f274128b = arrayList;
        arrayList.add(d.class);
    }

    private static void a() {
        if (f274127a == null) {
            b();
        }
    }

    @QAutoInitMethod
    static void b() {
        f274127a = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f274128b);
    }

    public static String c() {
        a();
        com.tencent.mobileqq.inject.b bVar = f274127a;
        if (bVar == null) {
            QLog.w("MatrixSetting", 1, "inject failed, call reportVersionName");
            return "";
        }
        return bVar.getReportVersionName();
    }
}
