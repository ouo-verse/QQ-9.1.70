package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplan/avatar/IndirectLight;", "", "path", "", "intensity", "", "(Ljava/lang/String;F)V", "getIntensity", "()F", "setIntensity", "(F)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class IndirectLight {
    private float intensity;

    @NotNull
    private String path;

    public IndirectLight() {
        this(null, 0.0f, 3, 0 == true ? 1 : 0);
    }

    public final float getIntensity() {
        return this.intensity;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final void setIntensity(float f16) {
        this.intensity = f16;
    }

    public final void setPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public IndirectLight(@NotNull String path, float f16) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.intensity = f16;
    }

    public /* synthetic */ IndirectLight(String str, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 6000.0f : f16);
    }
}
