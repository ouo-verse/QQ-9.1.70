package com.tencent.minibox.loader.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/minibox/loader/core/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "installPath", "b", "apkFilePath", "dexPath", "d", "libPath", "e", "odexPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.minibox.loader.core.f, reason: from toString */
/* loaded from: classes9.dex */
public final /* data */ class PluginPathConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String installPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String apkFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dexPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String libPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String odexPath;

    public PluginPathConfig(@NotNull String installPath, @NotNull String apkFilePath, @NotNull String dexPath, @NotNull String libPath, @NotNull String odexPath) {
        Intrinsics.checkParameterIsNotNull(installPath, "installPath");
        Intrinsics.checkParameterIsNotNull(apkFilePath, "apkFilePath");
        Intrinsics.checkParameterIsNotNull(dexPath, "dexPath");
        Intrinsics.checkParameterIsNotNull(libPath, "libPath");
        Intrinsics.checkParameterIsNotNull(odexPath, "odexPath");
        this.installPath = installPath;
        this.apkFilePath = apkFilePath;
        this.dexPath = dexPath;
        this.libPath = libPath;
        this.odexPath = odexPath;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getApkFilePath() {
        return this.apkFilePath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDexPath() {
        return this.dexPath;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getInstallPath() {
        return this.installPath;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getLibPath() {
        return this.libPath;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOdexPath() {
        return this.odexPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PluginPathConfig) {
                PluginPathConfig pluginPathConfig = (PluginPathConfig) other;
                if (!Intrinsics.areEqual(this.installPath, pluginPathConfig.installPath) || !Intrinsics.areEqual(this.apkFilePath, pluginPathConfig.apkFilePath) || !Intrinsics.areEqual(this.dexPath, pluginPathConfig.dexPath) || !Intrinsics.areEqual(this.libPath, pluginPathConfig.libPath) || !Intrinsics.areEqual(this.odexPath, pluginPathConfig.odexPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.installPath;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str2 = this.apkFilePath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.dexPath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str4 = this.libPath;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str5 = this.odexPath;
        if (str5 != null) {
            i19 = str5.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "PluginPathConfig(installPath=" + this.installPath + ", apkFilePath=" + this.apkFilePath + ", dexPath=" + this.dexPath + ", libPath=" + this.libPath + ", odexPath=" + this.odexPath + ")";
    }
}
