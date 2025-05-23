package com.tencent.richframework.thread.defend;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/thread/defend/ExceptionDefenderConfigManager;", "", "Lcom/tencent/richframework/thread/defend/ExceptionDefenderConfig;", "config$delegate", "Lkotlin/Lazy;", "getConfig", "()Lcom/tencent/richframework/thread/defend/ExceptionDefenderConfig;", DownloadInfo.spKey_Config, "<init>", "()V", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ExceptionDefenderConfigManager {

    @NotNull
    public static final ExceptionDefenderConfigManager INSTANCE = new ExceptionDefenderConfigManager();

    /* renamed from: config$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy config;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ExceptionDefenderConfig>() { // from class: com.tencent.richframework.thread.defend.ExceptionDefenderConfigManager$config$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ExceptionDefenderConfig invoke() {
                List emptyList;
                String configValue = RFWConfig.getConfigValue("RFW_EXCEPTION_DEFENDER_CONFIG", "");
                String str = configValue != null ? configValue : "";
                Intrinsics.checkNotNullExpressionValue(str, "RFWConfig.getConfigValue\u2026EFENDER_CONFIG, \"\") ?: \"\"");
                if (str.length() > 0) {
                    try {
                        Object fromJson = new Gson().fromJson(str, (Class<Object>) ExceptionDefenderConfig.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(configSt\u2026fenderConfig::class.java)");
                        return (ExceptionDefenderConfig) fromJson;
                    } catch (JsonSyntaxException e16) {
                        RFWLog.e("ExceptionDefenderConfigManager", RFWLog.USR, e16);
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new ExceptionDefenderConfig(false, 0L, emptyList, 3, null);
            }
        });
        config = lazy;
    }

    ExceptionDefenderConfigManager() {
    }

    @NotNull
    public final ExceptionDefenderConfig getConfig() {
        return (ExceptionDefenderConfig) config.getValue();
    }
}
