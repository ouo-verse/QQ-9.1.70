package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplanservice/download/FetchBootResourcesOptions;", "", "enablePlanarShadow", "", "enablePlanarReflection", "useZPlanMaterial", "enableOpenglLocalShaderBinary", "enableBloom", "enableParticleSystem", "enablePelvisOffset", "enableKawaiiSystem", "(ZZZZZZZZ)V", "getEnableBloom", "()Z", "getEnableKawaiiSystem", "getEnableOpenglLocalShaderBinary", "getEnableParticleSystem", "getEnablePelvisOffset", "getEnablePlanarReflection", "getEnablePlanarShadow", "getUseZPlanMaterial", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FetchBootResourcesOptions {
    private final boolean enableBloom;
    private final boolean enableKawaiiSystem;
    private final boolean enableOpenglLocalShaderBinary;
    private final boolean enableParticleSystem;
    private final boolean enablePelvisOffset;
    private final boolean enablePlanarReflection;
    private final boolean enablePlanarShadow;
    private final boolean useZPlanMaterial;

    public FetchBootResourcesOptions() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    public final boolean getEnableBloom() {
        return this.enableBloom;
    }

    public final boolean getEnableKawaiiSystem() {
        return this.enableKawaiiSystem;
    }

    public final boolean getEnableOpenglLocalShaderBinary() {
        return this.enableOpenglLocalShaderBinary;
    }

    public final boolean getEnableParticleSystem() {
        return this.enableParticleSystem;
    }

    public final boolean getEnablePelvisOffset() {
        return this.enablePelvisOffset;
    }

    public final boolean getEnablePlanarReflection() {
        return this.enablePlanarReflection;
    }

    public final boolean getEnablePlanarShadow() {
        return this.enablePlanarShadow;
    }

    public final boolean getUseZPlanMaterial() {
        return this.useZPlanMaterial;
    }

    public FetchBootResourcesOptions(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29) {
        this.enablePlanarShadow = z16;
        this.enablePlanarReflection = z17;
        this.useZPlanMaterial = z18;
        this.enableOpenglLocalShaderBinary = z19;
        this.enableBloom = z26;
        this.enableParticleSystem = z27;
        this.enablePelvisOffset = z28;
        this.enableKawaiiSystem = z29;
    }

    public /* synthetic */ FetchBootResourcesOptions(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? true : z18, (i3 & 8) != 0 ? false : z19, (i3 & 16) != 0 ? false : z26, (i3 & 32) != 0 ? false : z27, (i3 & 64) == 0 ? z28 : false, (i3 & 128) == 0 ? z29 : true);
    }
}
