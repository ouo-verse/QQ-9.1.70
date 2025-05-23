package com.tencent.state.square.data;

import com.tencent.ams.dsdk.core.DKEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b=\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b\u00a8\u0006A"}, d2 = {"Lcom/tencent/state/square/data/SquareDeviceInfo;", "", "()V", "brand", "", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "cpuCore", "getCpuCore", "setCpuCore", "cpuCoreCount", "getCpuCoreCount", "setCpuCoreCount", "cpuFreq", "getCpuFreq", "setCpuFreq", "cpuName", "getCpuName", "setCpuName", "device", "getDevice", "setDevice", "displayDensity", "getDisplayDensity", "setDisplayDensity", "displayHeight", "getDisplayHeight", "setDisplayHeight", "displayWidth", "getDisplayWidth", "setDisplayWidth", "glesVersion", "getGlesVersion", "setGlesVersion", "gpuName", "getGpuName", "setGpuName", "instrumentationSet", "getInstrumentationSet", "setInstrumentationSet", "isArm64", "setArm64", "manufacturer", "getManufacturer", "setManufacturer", "model", "getModel", "setModel", DKEngine.GlobalKey.OS_NAME, "getOsName", "setOsName", "osVersion", "getOsVersion", "setOsVersion", "ramSize", "getRamSize", "setRamSize", "systemUiVersion", "getSystemUiVersion", "setSystemUiVersion", "udid", "getUdid", "setUdid", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareDeviceInfo {

    @NotNull
    private String glesVersion = "";

    @NotNull
    private String osName = "";

    @NotNull
    private String osVersion = "";

    @NotNull
    private String systemUiVersion = "";

    @NotNull
    private String manufacturer = "";

    @NotNull
    private String instrumentationSet = "";

    @NotNull
    private String cpuCore = "";

    @NotNull
    private String cpuName = "";

    @NotNull
    private String isArm64 = "";

    @NotNull
    private String gpuName = "";

    @NotNull
    private String model = "";

    @NotNull
    private String udid = "";

    @NotNull
    private String brand = "";

    @NotNull
    private String device = "";

    @NotNull
    private String ramSize = "";

    @NotNull
    private String displayWidth = "";

    @NotNull
    private String displayHeight = "";

    @NotNull
    private String displayDensity = "";

    @NotNull
    private String cpuCoreCount = "";

    @NotNull
    private String cpuFreq = "";

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @NotNull
    public final String getCpuCore() {
        return this.cpuCore;
    }

    @NotNull
    public final String getCpuCoreCount() {
        return this.cpuCoreCount;
    }

    @NotNull
    public final String getCpuFreq() {
        return this.cpuFreq;
    }

    @NotNull
    public final String getCpuName() {
        return this.cpuName;
    }

    @NotNull
    public final String getDevice() {
        return this.device;
    }

    @NotNull
    public final String getDisplayDensity() {
        return this.displayDensity;
    }

    @NotNull
    public final String getDisplayHeight() {
        return this.displayHeight;
    }

    @NotNull
    public final String getDisplayWidth() {
        return this.displayWidth;
    }

    @NotNull
    public final String getGlesVersion() {
        return this.glesVersion;
    }

    @NotNull
    public final String getGpuName() {
        return this.gpuName;
    }

    @NotNull
    public final String getInstrumentationSet() {
        return this.instrumentationSet;
    }

    @NotNull
    public final String getManufacturer() {
        return this.manufacturer;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getOsName() {
        return this.osName;
    }

    @NotNull
    public final String getOsVersion() {
        return this.osVersion;
    }

    @NotNull
    public final String getRamSize() {
        return this.ramSize;
    }

    @NotNull
    public final String getSystemUiVersion() {
        return this.systemUiVersion;
    }

    @NotNull
    public final String getUdid() {
        return this.udid;
    }

    @NotNull
    /* renamed from: isArm64, reason: from getter */
    public final String getIsArm64() {
        return this.isArm64;
    }

    public final void setArm64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isArm64 = str;
    }

    public final void setBrand(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brand = str;
    }

    public final void setCpuCore(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpuCore = str;
    }

    public final void setCpuCoreCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpuCoreCount = str;
    }

    public final void setCpuFreq(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpuFreq = str;
    }

    public final void setCpuName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpuName = str;
    }

    public final void setDevice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.device = str;
    }

    public final void setDisplayDensity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayDensity = str;
    }

    public final void setDisplayHeight(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayHeight = str;
    }

    public final void setDisplayWidth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayWidth = str;
    }

    public final void setGlesVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.glesVersion = str;
    }

    public final void setGpuName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gpuName = str;
    }

    public final void setInstrumentationSet(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.instrumentationSet = str;
    }

    public final void setManufacturer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manufacturer = str;
    }

    public final void setModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.model = str;
    }

    public final void setOsName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.osName = str;
    }

    public final void setOsVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.osVersion = str;
    }

    public final void setRamSize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ramSize = str;
    }

    public final void setSystemUiVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.systemUiVersion = str;
    }

    public final void setUdid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.udid = str;
    }
}
