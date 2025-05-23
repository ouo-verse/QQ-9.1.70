package com.tencent.rdelivery.reshub.report;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Properties;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0006\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/GlobalParamsHolder;", "", "Ljava/util/Properties;", "a", "Lkotlin/Lazy;", "()Ljava/util/Properties;", "params", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class GlobalParamsHolder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy params;

    /* renamed from: b, reason: collision with root package name */
    public static final GlobalParamsHolder f364562b = new GlobalParamsHolder();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Properties>() { // from class: com.tencent.rdelivery.reshub.report.GlobalParamsHolder$params$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Properties invoke() {
                Properties properties = new Properties();
                com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
                if (jVar.S()) {
                    g.a(properties, "dev_id", jVar.w().getDeviceId());
                    g.a(properties, "host_app_ver", jVar.w().getAppVersion());
                }
                g.a(properties, "dev_type", jVar.h().b());
                g.a(properties, "sys_ver", jVar.h().getSystemVersion());
                g.a(properties, "dev_manu", jVar.h().a());
                g.a(properties, HiAnalyticsConstant.BI_KEY_SDK_VER, "1.8.18-RC02");
                g.a(properties, "sdk_ver_num", 1806L);
                properties.put("sys_id", "ResHub");
                return properties;
            }
        });
        params = lazy;
    }

    GlobalParamsHolder() {
    }

    @NotNull
    public final Properties a() {
        return (Properties) params.getValue();
    }
}
