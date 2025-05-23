package androidx.fragment.app;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Landroidx/fragment/app/ArgusConfigManager;", "", "()V", "RFW_ARGUS_CONFIG", "", "TAG", "strategyConfig", "Landroidx/fragment/app/ArgusStrategyConfig;", "getStrategyConfig", "()Landroidx/fragment/app/ArgusStrategyConfig;", "strategyConfig$delegate", "Lkotlin/Lazy;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ArgusConfigManager {

    @NotNull
    public static final ArgusConfigManager INSTANCE = new ArgusConfigManager();
    private static final String RFW_ARGUS_CONFIG = "RFW_ARGUS_STRATEGY_CONFIG";
    private static final String TAG = "ArgusConfigManager";

    /* renamed from: strategyConfig$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy strategyConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArgusStrategyConfig>() { // from class: androidx.fragment.app.ArgusConfigManager$strategyConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArgusStrategyConfig invoke() {
                String configValue = RFWConfig.getConfigValue("RFW_ARGUS_STRATEGY_CONFIG", "");
                String str = configValue != null ? configValue : "";
                Intrinsics.checkNotNullExpressionValue(str, "RFWConfig.getConfigValue\u2026W_ARGUS_CONFIG, \"\") ?: \"\"");
                if (str.length() > 0) {
                    try {
                        Object fromJson = new Gson().fromJson(str, (Class<Object>) ArgusStrategyConfig.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(configSt\u2026rategyConfig::class.java)");
                        return (ArgusStrategyConfig) fromJson;
                    } catch (JsonSyntaxException e16) {
                        RFWLog.e("ArgusConfigManager", RFWLog.USR, e16);
                    }
                }
                return new ArgusStrategyConfig(0L, 0L, 0L, 7, null);
            }
        });
        strategyConfig = lazy;
    }

    ArgusConfigManager() {
    }

    @NotNull
    public final ArgusStrategyConfig getStrategyConfig() {
        return (ArgusStrategyConfig) strategyConfig.getValue();
    }
}
