package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/avatar/Exposure;", "", "aperture", "", "sensitivity", "", "shutterSpeed", "(IDD)V", "getAperture", "()I", "setAperture", "(I)V", "getSensitivity", "()D", "setSensitivity", "(D)V", "getShutterSpeed", "setShutterSpeed", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Exposure {
    private int aperture;
    private double sensitivity;
    private double shutterSpeed;

    public Exposure() {
        this(0, 0.0d, 0.0d, 7, null);
    }

    public final int getAperture() {
        return this.aperture;
    }

    public final double getSensitivity() {
        return this.sensitivity;
    }

    public final double getShutterSpeed() {
        return this.shutterSpeed;
    }

    public final void setAperture(int i3) {
        this.aperture = i3;
    }

    public final void setSensitivity(double d16) {
        this.sensitivity = d16;
    }

    public final void setShutterSpeed(double d16) {
        this.shutterSpeed = d16;
    }

    public Exposure(int i3, double d16, double d17) {
        this.aperture = i3;
        this.sensitivity = d16;
        this.shutterSpeed = d17;
    }

    public /* synthetic */ Exposure(int i3, double d16, double d17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 16 : i3, (i16 & 2) != 0 ? 100.0d : d16, (i16 & 4) != 0 ? 0.008d : d17);
    }
}
