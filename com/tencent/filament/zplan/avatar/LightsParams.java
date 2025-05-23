package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/avatar/LightsParams;", "", "directional", "Lcom/tencent/filament/zplan/avatar/Directional;", "indirectLight", "Lcom/tencent/filament/zplan/avatar/IndirectLight;", "spotLights", "", "Lcom/tencent/filament/zplan/avatar/SpotLight;", "(Lcom/tencent/filament/zplan/avatar/Directional;Lcom/tencent/filament/zplan/avatar/IndirectLight;Ljava/util/List;)V", "getDirectional", "()Lcom/tencent/filament/zplan/avatar/Directional;", "setDirectional", "(Lcom/tencent/filament/zplan/avatar/Directional;)V", "getIndirectLight", "()Lcom/tencent/filament/zplan/avatar/IndirectLight;", "setIndirectLight", "(Lcom/tencent/filament/zplan/avatar/IndirectLight;)V", "getSpotLights", "()Ljava/util/List;", "setSpotLights", "(Ljava/util/List;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class LightsParams {

    @Nullable
    private Directional directional;

    @Nullable
    private IndirectLight indirectLight;

    @NotNull
    private List<SpotLight> spotLights;

    public LightsParams(@Nullable Directional directional, @Nullable IndirectLight indirectLight, @NotNull List<SpotLight> spotLights) {
        Intrinsics.checkNotNullParameter(spotLights, "spotLights");
        this.directional = directional;
        this.indirectLight = indirectLight;
        this.spotLights = spotLights;
    }

    @Nullable
    public final Directional getDirectional() {
        return this.directional;
    }

    @Nullable
    public final IndirectLight getIndirectLight() {
        return this.indirectLight;
    }

    @NotNull
    public final List<SpotLight> getSpotLights() {
        return this.spotLights;
    }

    public final void setDirectional(@Nullable Directional directional) {
        this.directional = directional;
    }

    public final void setIndirectLight(@Nullable IndirectLight indirectLight) {
        this.indirectLight = indirectLight;
    }

    public final void setSpotLights(@NotNull List<SpotLight> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.spotLights = list;
    }

    public /* synthetic */ LightsParams(Directional directional, IndirectLight indirectLight, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(directional, indirectLight, (i3 & 4) != 0 ? new ArrayList() : list);
    }
}
