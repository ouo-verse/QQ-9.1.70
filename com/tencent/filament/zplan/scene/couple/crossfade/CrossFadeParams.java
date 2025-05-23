package com.tencent.filament.zplan.scene.couple.crossfade;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010 \u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R*\u0010 \u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/crossfade/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "getLastAnimateNowInterval", "()D", "lastAnimateNowInterval", "b", "duration", "c", "Z", "()Z", "e", "(Z)V", "needRemoveFromItems", "d", "f", "needRemoveToItems", "", "Lcom/tencent/filament/zplan/scene/couple/config/Location;", "[D", "()[D", "setFinalLocation", "([D)V", "finalLocation", "<init>", "(DDZZ[D)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.couple.crossfade.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class CrossFadeParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final double lastAnimateNowInterval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final double duration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needRemoveFromItems;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needRemoveToItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private double[] finalLocation;

    public CrossFadeParams(double d16, double d17, boolean z16, boolean z17, @Nullable double[] dArr) {
        this.lastAnimateNowInterval = d16;
        this.duration = d17;
        this.needRemoveFromItems = z16;
        this.needRemoveToItems = z17;
        this.finalLocation = dArr;
    }

    /* renamed from: a, reason: from getter */
    public final double getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final double[] getFinalLocation() {
        return this.finalLocation;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedRemoveFromItems() {
        return this.needRemoveFromItems;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNeedRemoveToItems() {
        return this.needRemoveToItems;
    }

    public final void e(boolean z16) {
        this.needRemoveFromItems = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CrossFadeParams) {
                CrossFadeParams crossFadeParams = (CrossFadeParams) other;
                if (Double.compare(this.lastAnimateNowInterval, crossFadeParams.lastAnimateNowInterval) != 0 || Double.compare(this.duration, crossFadeParams.duration) != 0 || this.needRemoveFromItems != crossFadeParams.needRemoveFromItems || this.needRemoveToItems != crossFadeParams.needRemoveToItems || !Intrinsics.areEqual(this.finalLocation, crossFadeParams.finalLocation)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(boolean z16) {
        this.needRemoveToItems = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        long doubleToLongBits = Double.doubleToLongBits(this.lastAnimateNowInterval);
        long doubleToLongBits2 = Double.doubleToLongBits(this.duration);
        int i16 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 31;
        boolean z16 = this.needRemoveFromItems;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.needRemoveToItems;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        int i26 = (i19 + i17) * 31;
        double[] dArr = this.finalLocation;
        if (dArr != null) {
            i3 = Arrays.hashCode(dArr);
        } else {
            i3 = 0;
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "CrossFadeParams(lastAnimateNowInterval=" + this.lastAnimateNowInterval + ", duration=" + this.duration + ", needRemoveFromItems=" + this.needRemoveFromItems + ", needRemoveToItems=" + this.needRemoveToItems + ", finalLocation=" + Arrays.toString(this.finalLocation) + ")";
    }

    public /* synthetic */ CrossFadeParams(double d16, double d17, boolean z16, boolean z17, double[] dArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(d16, d17, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : dArr);
    }
}
