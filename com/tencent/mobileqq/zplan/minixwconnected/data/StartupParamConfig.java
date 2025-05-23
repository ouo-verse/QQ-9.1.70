package com.tencent.mobileqq.zplan.minixwconnected.data;

import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.StartupConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/data/StartupParamConfig;", "", "", "b", "a", "Lcom/tencent/sqshow/utils/featureswitch/model/m;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/sqshow/utils/featureswitch/model/m;", "startupConfig", "", "c", "()D", "phoneMemory", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class StartupParamConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final StartupParamConfig f334482a = new StartupParamConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy startupConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy phoneMemory;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<StartupConfig>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.data.StartupParamConfig$startupConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StartupConfig invoke() {
                return ZPlanQQMC.INSTANCE.getXWConnectStartupConfig();
            }
        });
        startupConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Double>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.data.StartupParamConfig$phoneMemory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(Math.ceil(t74.c.b() / 1024.0d));
            }
        });
        phoneMemory = lazy2;
    }

    StartupParamConfig() {
    }

    private final double c() {
        return ((Number) phoneMemory.getValue()).doubleValue();
    }

    private final StartupConfig d() {
        return (StartupConfig) startupConfig.getValue();
    }

    public final int a() {
        if (c() <= d().getCharacterMemoryThreshold()) {
            return d().getMinCharacters();
        }
        return d().getMaxCharacters();
    }

    public final int b() {
        if (c() <= d().getFpsMemoryThreshold()) {
            return d().getMinFps();
        }
        return d().getMaxFps();
    }
}
