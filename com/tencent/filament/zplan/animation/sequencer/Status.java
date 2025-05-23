package com.tencent.filament.zplan.animation.sequencer;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/Status;", "", "gltfPath", "", "index", "", "time", "", "(Ljava/lang/String;ID)V", "getGltfPath", "()Ljava/lang/String;", "getIndex", "()I", "getTime", "()D", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Status {

    @Nullable
    private final String gltfPath;
    private final int index;
    private final double time;

    public Status() {
        this(null, 0, 0.0d, 7, null);
    }

    @Nullable
    public final String getGltfPath() {
        return this.gltfPath;
    }

    public final int getIndex() {
        return this.index;
    }

    public final double getTime() {
        return this.time;
    }

    public Status(@Nullable String str, int i3, double d16) {
        this.gltfPath = str;
        this.index = i3;
        this.time = d16;
    }

    public /* synthetic */ Status(String str, int i3, double d16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? Integer.MAX_VALUE : i3, (i16 & 4) != 0 ? 0.0d : d16);
    }
}
