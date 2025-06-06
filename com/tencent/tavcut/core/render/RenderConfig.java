package com.tencent.tavcut.core.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tavcut/core/render/RenderConfig;", "", "()V", "renderAssetDir", "", "getRenderAssetDir", "()Ljava/lang/String;", "setRenderAssetDir", "(Ljava/lang/String;)V", "renderType", "", "getRenderType", "()I", "setRenderType", "(I)V", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class RenderConfig {
    public static final RenderConfig INSTANCE = new RenderConfig();

    @NotNull
    private static String renderAssetDir = "";
    private static int renderType;

    RenderConfig() {
    }

    @NotNull
    public final String getRenderAssetDir() {
        return renderAssetDir;
    }

    public final int getRenderType() {
        return renderType;
    }

    public final void setRenderAssetDir(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        renderAssetDir = str;
    }

    public final void setRenderType(int i3) {
        renderType = i3;
    }
}
