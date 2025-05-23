package com.tencent.luggage.wxa.v7;

import android.app.Application;
import android.content.Context;
import com.tencent.ilink.BuildConfig;
import com.tencent.luggage.wxa.j4.m;
import com.tencent.luggage.wxa.q7.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f143304a = new f();

    public final void a(Context context, boolean z16) {
        Application application;
        e eVar;
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        Application application2 = application;
        z.b(application2);
        z.a(application2.getResources());
        com.tencent.luggage.wxa.tn.e.f141561c = "ff21ec7a35922aa90e584b2bb63d1a39c25df3b8";
        com.tencent.luggage.wxa.tn.e.f141559a = false;
        com.tencent.luggage.wxa.tn.e.f141565g = r.a();
        com.tencent.luggage.wxa.tn.e.f141563e = 671103283;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z17 = true;
        String format = String.format("0x%08X", Arrays.copyOf(new Object[]{Integer.valueOf(com.tencent.luggage.wxa.tn.e.f141563e)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        com.tencent.luggage.wxa.tn.e.f141562d = format;
        com.tencent.luggage.wxa.tn.e.f141560b = "#143";
        m.a(m.f130853a, false, null, application2, null, 11, null);
        String processName = z.a(context);
        w.d("Luggage.WXA.ProcessStartupFactory", "initialize: context.packageName = [%s], processName = [%s]", context.getPackageName(), processName);
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        if (processName.length() != 0) {
            z17 = false;
        }
        if (!z17 && !Intrinsics.areEqual(processName, context.getPackageName())) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ":wxa_container", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, (Object) null);
                if (contains$default2) {
                    eVar = c.f143292b;
                } else {
                    eVar = b.f143291a;
                }
            } else {
                eVar = g.f143305b;
            }
        } else {
            eVar = d.f143293b;
        }
        w.d("Luggage.WXA.ProcessStartupFactory", "initialize --START-- processName:" + processName + ", startup:" + eVar);
        long a16 = w0.a();
        if (eVar instanceof d) {
            ((d) eVar).a(context, z16);
        } else {
            eVar.a(context);
        }
        w.d("Luggage.WXA.ProcessStartupFactory", "initialize --END-- processName:" + processName + ", startup:" + eVar.getClass().getSimpleName() + ", cost:" + w0.e(a16) + "ms");
    }
}
