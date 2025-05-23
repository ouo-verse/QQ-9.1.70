package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/avatar/Manipulator;", "", "mode", "", "freeFlight", "Lcom/tencent/filament/zplan/avatar/FreeFlight;", "orbit", "Lcom/tencent/filament/zplan/avatar/Orbit;", "(Ljava/lang/String;Lcom/tencent/filament/zplan/avatar/FreeFlight;Lcom/tencent/filament/zplan/avatar/Orbit;)V", "getFreeFlight", "()Lcom/tencent/filament/zplan/avatar/FreeFlight;", "setFreeFlight", "(Lcom/tencent/filament/zplan/avatar/FreeFlight;)V", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "getOrbit", "()Lcom/tencent/filament/zplan/avatar/Orbit;", "setOrbit", "(Lcom/tencent/filament/zplan/avatar/Orbit;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Manipulator {

    @NotNull
    private FreeFlight freeFlight;

    @NotNull
    private String mode;

    @NotNull
    private Orbit orbit;

    public Manipulator() {
        this(null, null, null, 7, null);
    }

    @NotNull
    public final FreeFlight getFreeFlight() {
        return this.freeFlight;
    }

    @NotNull
    public final String getMode() {
        return this.mode;
    }

    @NotNull
    public final Orbit getOrbit() {
        return this.orbit;
    }

    public final void setFreeFlight(@NotNull FreeFlight freeFlight) {
        Intrinsics.checkNotNullParameter(freeFlight, "<set-?>");
        this.freeFlight = freeFlight;
    }

    public final void setMode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mode = str;
    }

    public final void setOrbit(@NotNull Orbit orbit) {
        Intrinsics.checkNotNullParameter(orbit, "<set-?>");
        this.orbit = orbit;
    }

    public Manipulator(@NotNull String mode, @NotNull FreeFlight freeFlight, @NotNull Orbit orbit) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(freeFlight, "freeFlight");
        Intrinsics.checkNotNullParameter(orbit, "orbit");
        this.mode = mode;
        this.freeFlight = freeFlight;
        this.orbit = orbit;
    }

    public /* synthetic */ Manipulator(String str, FreeFlight freeFlight, Orbit orbit, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ManipulatorMode.ORBIT : str, (i3 & 2) != 0 ? new FreeFlight(0.0f, 0, 0.0f, 0.0f, null, 0.0f, 63, null) : freeFlight, (i3 & 4) != 0 ? new Orbit(null, 1, null) : orbit);
    }
}
