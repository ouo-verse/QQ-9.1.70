package com.tencent.tavcut.core.render.font;

import com.tencent.hippy.qq.utils.HippyReporter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.Config;
import org.light.FontAsset;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/core/render/font/FontCacheManager;", "", "()V", "registeredFontMap", "", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "registerFont", "fontFamily", "fontStyle", "fontPath", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class FontCacheManager {
    public static final FontCacheManager INSTANCE = new FontCacheManager();
    private static final Map<String, String> registeredFontMap = new LinkedHashMap();

    FontCacheManager() {
    }

    public final void clearCache() {
        registeredFontMap.clear();
    }

    public final void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
        Intrinsics.checkParameterIsNotNull(fontFamily, "fontFamily");
        Intrinsics.checkParameterIsNotNull(fontStyle, "fontStyle");
        Intrinsics.checkParameterIsNotNull(fontPath, "fontPath");
        String str = fontFamily + '-' + fontStyle;
        Map<String, String> map = registeredFontMap;
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, fontPath);
        Config.registerFont(new FontAsset(fontFamily, fontStyle), fontPath);
    }
}
