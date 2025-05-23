package com.tencent.zplan.record.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/zplan/record/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "setEnableFilament", "(Z)V", "enableFilament", "getEnableAA", "setEnableAA", "enableAA", "c", "setDisableGlassesMetallic", "disableGlassesMetallic", "<init>", "(ZZZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.record.model.d, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class RenderSwitches {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableFilament;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enableAA;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean disableGlassesMetallic;

    public RenderSwitches() {
        this(false, false, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDisableGlassesMetallic() {
        return this.disableGlassesMetallic;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableFilament() {
        return this.enableFilament;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RenderSwitches) {
                RenderSwitches renderSwitches = (RenderSwitches) other;
                if (this.enableFilament != renderSwitches.enableFilament || this.enableAA != renderSwitches.enableAA || this.disableGlassesMetallic != renderSwitches.disableGlassesMetallic) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.enableFilament;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.enableAA;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.disableGlassesMetallic;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "RenderSwitches(enableFilament=" + this.enableFilament + ", enableAA=" + this.enableAA + ", disableGlassesMetallic=" + this.disableGlassesMetallic + ")";
    }

    public RenderSwitches(boolean z16, boolean z17, boolean z18) {
        this.enableFilament = z16;
        this.enableAA = z17;
        this.disableGlassesMetallic = z18;
    }

    public /* synthetic */ RenderSwitches(boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18);
    }
}
