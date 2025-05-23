package androidx.recyclerview.widget;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Landroidx/recyclerview/widget/ItemPreloadConfigManager;", "", "()V", "RFW_PRELOAD_CONFIG", "", "TAG", "preloadConfig", "Landroidx/recyclerview/widget/ItemPreloadConfig;", "getPreloadConfig", "()Landroidx/recyclerview/widget/ItemPreloadConfig;", "preloadConfig$delegate", "Lkotlin/Lazy;", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ItemPreloadConfigManager {

    @NotNull
    public static final ItemPreloadConfigManager INSTANCE = new ItemPreloadConfigManager();
    private static final String RFW_PRELOAD_CONFIG = "RFW_ITEM_PRELOAD_CONFIG";
    private static final String TAG = "ItemPreloadConfigManager";

    /* renamed from: preloadConfig$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy preloadConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ItemPreloadConfig>() { // from class: androidx.recyclerview.widget.ItemPreloadConfigManager$preloadConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ItemPreloadConfig invoke() {
                String configValue = RFWConfig.getConfigValue("RFW_ITEM_PRELOAD_CONFIG", "");
                String str = configValue != null ? configValue : "";
                Intrinsics.checkNotNullExpressionValue(str, "RFWConfig.getConfigValue\u2026PRELOAD_CONFIG, \"\") ?: \"\"");
                if (str.length() > 0) {
                    try {
                        Object fromJson = new Gson().fromJson(str, (Class<Object>) ItemPreloadConfig.class);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(configSt\u2026reloadConfig::class.java)");
                        return (ItemPreloadConfig) fromJson;
                    } catch (JsonSyntaxException e16) {
                        RFWLog.e("ItemPreloadConfigManager", RFWLog.USR, e16);
                    }
                }
                return new ItemPreloadConfig(false, false, 0.0f, false, 0, 0.0f, false, 127, null);
            }
        });
        preloadConfig = lazy;
    }

    ItemPreloadConfigManager() {
    }

    @NotNull
    public final ItemPreloadConfig getPreloadConfig() {
        return (ItemPreloadConfig) preloadConfig.getValue();
    }
}
