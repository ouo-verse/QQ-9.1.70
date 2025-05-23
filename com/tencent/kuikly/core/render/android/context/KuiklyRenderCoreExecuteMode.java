package com.tencent.kuikly.core.render.android.context;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "", "mode", "", "(Ljava/lang/String;II)V", "getMode", "()I", "JVM", "JS", "DEX", "SO", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public enum KuiklyRenderCoreExecuteMode {
    JVM(0),
    JS(2),
    DEX(3),
    SO(4);

    private final int mode;

    KuiklyRenderCoreExecuteMode(int i3) {
        this.mode = i3;
    }

    public final int getMode() {
        return this.mode;
    }
}
