package com.tencent.state.utils;

import com.google.gson.annotations.SerializedName;
import com.tencent.state.square.data.SquareDeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/utils/SquareDeviceFilter;", "", "model", "", "systemUiVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getSystemUiVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isMatch", "deviceInfo", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareDeviceFilter {

    @SerializedName("model")
    private final String model;

    @SerializedName("system_ui_version")
    private final String systemUiVersion;

    public SquareDeviceFilter(String model, String systemUiVersion) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(systemUiVersion, "systemUiVersion");
        this.model = model;
        this.systemUiVersion = systemUiVersion;
    }

    /* renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSystemUiVersion() {
        return this.systemUiVersion;
    }

    public final SquareDeviceFilter copy(String model, String systemUiVersion) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(systemUiVersion, "systemUiVersion");
        return new SquareDeviceFilter(model, systemUiVersion);
    }

    public final String getModel() {
        return this.model;
    }

    public final String getSystemUiVersion() {
        return this.systemUiVersion;
    }

    public int hashCode() {
        String str = this.model;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.systemUiVersion;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isMatch(SquareDeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        if (this.model.length() == 0) {
            if (this.systemUiVersion.length() == 0) {
                return false;
            }
        }
        if ((this.model.length() > 0) && (!Intrinsics.areEqual(this.model, deviceInfo.getModel()))) {
            return false;
        }
        return ((this.systemUiVersion.length() > 0) && (Intrinsics.areEqual(this.systemUiVersion, deviceInfo.getSystemUiVersion()) ^ true)) ? false : true;
    }

    public String toString() {
        return "SquareDeviceFilter(model=" + this.model + ", systemUiVersion=" + this.systemUiVersion + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareDeviceFilter)) {
            return false;
        }
        SquareDeviceFilter squareDeviceFilter = (SquareDeviceFilter) other;
        return Intrinsics.areEqual(this.model, squareDeviceFilter.model) && Intrinsics.areEqual(this.systemUiVersion, squareDeviceFilter.systemUiVersion);
    }

    public static /* synthetic */ SquareDeviceFilter copy$default(SquareDeviceFilter squareDeviceFilter, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareDeviceFilter.model;
        }
        if ((i3 & 2) != 0) {
            str2 = squareDeviceFilter.systemUiVersion;
        }
        return squareDeviceFilter.copy(str, str2);
    }
}
