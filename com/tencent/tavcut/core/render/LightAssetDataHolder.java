package com.tencent.tavcut.core.render;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00072\u0006\u0010\u000b\u001a\u00020\u0005J2\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0007R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/LightAssetDataHolder;", "", "()V", "allAssetData", "", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "clearAssetData", "", "getAssetData", "templatePath", "setAssetData", "assetData", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class LightAssetDataHolder {
    private final Map<String, HashMap<String, String>> allAssetData = new LinkedHashMap();

    public final void clearAssetData() {
        this.allAssetData.clear();
    }

    @Nullable
    public final HashMap<String, String> getAssetData(@NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        return this.allAssetData.get(templatePath);
    }

    public final void setAssetData(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        if (this.allAssetData.get(templatePath) == null) {
            this.allAssetData.put(templatePath, new HashMap<>());
        }
        HashMap<String, String> hashMap = this.allAssetData.get(templatePath);
        if (hashMap != null) {
            hashMap.putAll(assetData);
        }
    }
}
