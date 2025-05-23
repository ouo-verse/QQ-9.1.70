package com.tencent.filament.zplan.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/data/AIBinary;", "", "fps", "", "oneFrameBytes", "aiData", "", "(II[B)V", "getAiData", "()[B", "setAiData", "([B)V", "getFps", "()I", "setFps", "(I)V", "getOneFrameBytes", "setOneFrameBytes", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AIBinary {

    @NotNull
    private byte[] aiData;
    private int fps;
    private int oneFrameBytes;

    public AIBinary(int i3, int i16, @NotNull byte[] aiData) {
        Intrinsics.checkNotNullParameter(aiData, "aiData");
        this.fps = i3;
        this.oneFrameBytes = i16;
        this.aiData = aiData;
    }

    @NotNull
    public final byte[] getAiData() {
        return this.aiData;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getOneFrameBytes() {
        return this.oneFrameBytes;
    }

    public final void setAiData(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.aiData = bArr;
    }

    public final void setFps(int i3) {
        this.fps = i3;
    }

    public final void setOneFrameBytes(int i3) {
        this.oneFrameBytes = i3;
    }
}
