package com.tencent.zplan.luabridge.plugins.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/data/LoadingExtData;", "Ljava/io/Serializable;", "totalSize", "", "currentDownload", "speed", "tips1", "", "tips2", "(DDDLjava/lang/String;Ljava/lang/String;)V", "getCurrentDownload", "()D", "setCurrentDownload", "(D)V", "getSpeed", "setSpeed", "getTips1", "()Ljava/lang/String;", "setTips1", "(Ljava/lang/String;)V", "getTips2", "setTips2", "getTotalSize", "setTotalSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class LoadingExtData implements Serializable {
    private double currentDownload;
    private double speed;

    @NotNull
    private String tips1;

    @NotNull
    private String tips2;
    private double totalSize;

    public LoadingExtData() {
        this(0.0d, 0.0d, 0.0d, null, null, 31, null);
    }

    public static /* synthetic */ LoadingExtData copy$default(LoadingExtData loadingExtData, double d16, double d17, double d18, String str, String str2, int i3, Object obj) {
        double d19;
        double d26;
        double d27;
        String str3;
        String str4;
        if ((i3 & 1) != 0) {
            d19 = loadingExtData.totalSize;
        } else {
            d19 = d16;
        }
        if ((i3 & 2) != 0) {
            d26 = loadingExtData.currentDownload;
        } else {
            d26 = d17;
        }
        if ((i3 & 4) != 0) {
            d27 = loadingExtData.speed;
        } else {
            d27 = d18;
        }
        if ((i3 & 8) != 0) {
            str3 = loadingExtData.tips1;
        } else {
            str3 = str;
        }
        if ((i3 & 16) != 0) {
            str4 = loadingExtData.tips2;
        } else {
            str4 = str2;
        }
        return loadingExtData.copy(d19, d26, d27, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final double getTotalSize() {
        return this.totalSize;
    }

    /* renamed from: component2, reason: from getter */
    public final double getCurrentDownload() {
        return this.currentDownload;
    }

    /* renamed from: component3, reason: from getter */
    public final double getSpeed() {
        return this.speed;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getTips1() {
        return this.tips1;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getTips2() {
        return this.tips2;
    }

    @NotNull
    public final LoadingExtData copy(double totalSize, double currentDownload, double speed, @NotNull String tips1, @NotNull String tips2) {
        Intrinsics.checkNotNullParameter(tips1, "tips1");
        Intrinsics.checkNotNullParameter(tips2, "tips2");
        return new LoadingExtData(totalSize, currentDownload, speed, tips1, tips2);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LoadingExtData) {
                LoadingExtData loadingExtData = (LoadingExtData) other;
                if (Double.compare(this.totalSize, loadingExtData.totalSize) != 0 || Double.compare(this.currentDownload, loadingExtData.currentDownload) != 0 || Double.compare(this.speed, loadingExtData.speed) != 0 || !Intrinsics.areEqual(this.tips1, loadingExtData.tips1) || !Intrinsics.areEqual(this.tips2, loadingExtData.tips2)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final double getCurrentDownload() {
        return this.currentDownload;
    }

    public final double getSpeed() {
        return this.speed;
    }

    @NotNull
    public final String getTips1() {
        return this.tips1;
    }

    @NotNull
    public final String getTips2() {
        return this.tips2;
    }

    public final double getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        int i3;
        long doubleToLongBits = Double.doubleToLongBits(this.totalSize);
        long doubleToLongBits2 = Double.doubleToLongBits(this.currentDownload);
        int i16 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        long doubleToLongBits3 = Double.doubleToLongBits(this.speed);
        int i17 = (i16 + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3))) * 31;
        String str = this.tips1;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        String str2 = this.tips2;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i19 + i18;
    }

    public final void setCurrentDownload(double d16) {
        this.currentDownload = d16;
    }

    public final void setSpeed(double d16) {
        this.speed = d16;
    }

    public final void setTips1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tips1 = str;
    }

    public final void setTips2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tips2 = str;
    }

    public final void setTotalSize(double d16) {
        this.totalSize = d16;
    }

    @NotNull
    public String toString() {
        return "LoadingExtData(totalSize=" + this.totalSize + ", currentDownload=" + this.currentDownload + ", speed=" + this.speed + ", tips1=" + this.tips1 + ", tips2=" + this.tips2 + ")";
    }

    public LoadingExtData(double d16, double d17, double d18, @NotNull String tips1, @NotNull String tips2) {
        Intrinsics.checkNotNullParameter(tips1, "tips1");
        Intrinsics.checkNotNullParameter(tips2, "tips2");
        this.totalSize = d16;
        this.currentDownload = d17;
        this.speed = d18;
        this.tips1 = tips1;
        this.tips2 = tips2;
    }

    public /* synthetic */ LoadingExtData(double d16, double d17, double d18, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) != 0 ? 0.0d : d17, (i3 & 4) == 0 ? d18 : 0.0d, (i3 & 8) != 0 ? "" : str, (i3 & 16) == 0 ? str2 : "");
    }
}
