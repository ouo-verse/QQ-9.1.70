package com.tencent.tavcut.core.render.builder.light.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/CustomRenderConfig;", "", "()V", "enableFastSoftDecode", "", "getEnableFastSoftDecode", "()Z", "setEnableFastSoftDecode", "(Z)V", "enableNeedPaintingFlush", "getEnableNeedPaintingFlush", "setEnableNeedPaintingFlush", "softDecodeThreadCount", "", "getSoftDecodeThreadCount", "()I", "setSoftDecodeThreadCount", "(I)V", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CustomRenderConfig {
    private boolean enableFastSoftDecode;
    private int softDecodeThreadCount = -1;
    private boolean enableNeedPaintingFlush = true;

    public final boolean getEnableFastSoftDecode() {
        return this.enableFastSoftDecode;
    }

    public final boolean getEnableNeedPaintingFlush() {
        return this.enableNeedPaintingFlush;
    }

    public final int getSoftDecodeThreadCount() {
        return this.softDecodeThreadCount;
    }

    public final void setEnableFastSoftDecode(boolean z16) {
        this.enableFastSoftDecode = z16;
    }

    public final void setEnableNeedPaintingFlush(boolean z16) {
        this.enableNeedPaintingFlush = z16;
    }

    public final void setSoftDecodeThreadCount(int i3) {
        this.softDecodeThreadCount = i3;
    }
}
