package com.tencent.mobileqq.z1.download.diffpatch;

import androidx.fragment.app.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapFullDownloadInfo;", "Ljava/io/Serializable;", "downloadUrl", "", "saveFileName", "fullDownloadSize", "", "fullDownloadVersion", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFullDownloadSize", "()J", "getFullDownloadVersion", "getSaveFileName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZPlanMapFullDownloadInfo implements Serializable {

    @NotNull
    private final String downloadUrl;
    private final long fullDownloadSize;

    @NotNull
    private final String fullDownloadVersion;

    @NotNull
    private final String saveFileName;

    public ZPlanMapFullDownloadInfo(@NotNull String downloadUrl, @NotNull String saveFileName, long j3, @NotNull String fullDownloadVersion) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(saveFileName, "saveFileName");
        Intrinsics.checkNotNullParameter(fullDownloadVersion, "fullDownloadVersion");
        this.downloadUrl = downloadUrl;
        this.saveFileName = saveFileName;
        this.fullDownloadSize = j3;
        this.fullDownloadVersion = fullDownloadVersion;
    }

    public static /* synthetic */ ZPlanMapFullDownloadInfo copy$default(ZPlanMapFullDownloadInfo zPlanMapFullDownloadInfo, String str, String str2, long j3, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanMapFullDownloadInfo.downloadUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = zPlanMapFullDownloadInfo.saveFileName;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            j3 = zPlanMapFullDownloadInfo.fullDownloadSize;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            str3 = zPlanMapFullDownloadInfo.fullDownloadVersion;
        }
        return zPlanMapFullDownloadInfo.copy(str, str4, j16, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSaveFileName() {
        return this.saveFileName;
    }

    /* renamed from: component3, reason: from getter */
    public final long getFullDownloadSize() {
        return this.fullDownloadSize;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFullDownloadVersion() {
        return this.fullDownloadVersion;
    }

    @NotNull
    public final ZPlanMapFullDownloadInfo copy(@NotNull String downloadUrl, @NotNull String saveFileName, long fullDownloadSize, @NotNull String fullDownloadVersion) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(saveFileName, "saveFileName");
        Intrinsics.checkNotNullParameter(fullDownloadVersion, "fullDownloadVersion");
        return new ZPlanMapFullDownloadInfo(downloadUrl, saveFileName, fullDownloadSize, fullDownloadVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanMapFullDownloadInfo)) {
            return false;
        }
        ZPlanMapFullDownloadInfo zPlanMapFullDownloadInfo = (ZPlanMapFullDownloadInfo) other;
        if (Intrinsics.areEqual(this.downloadUrl, zPlanMapFullDownloadInfo.downloadUrl) && Intrinsics.areEqual(this.saveFileName, zPlanMapFullDownloadInfo.saveFileName) && this.fullDownloadSize == zPlanMapFullDownloadInfo.fullDownloadSize && Intrinsics.areEqual(this.fullDownloadVersion, zPlanMapFullDownloadInfo.fullDownloadVersion)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final long getFullDownloadSize() {
        return this.fullDownloadSize;
    }

    @NotNull
    public final String getFullDownloadVersion() {
        return this.fullDownloadVersion;
    }

    @NotNull
    public final String getSaveFileName() {
        return this.saveFileName;
    }

    public int hashCode() {
        return (((((this.downloadUrl.hashCode() * 31) + this.saveFileName.hashCode()) * 31) + a.a(this.fullDownloadSize)) * 31) + this.fullDownloadVersion.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanMapFullDownloadInfo(downloadUrl=" + this.downloadUrl + ", saveFileName=" + this.saveFileName + ", fullDownloadSize=" + this.fullDownloadSize + ", fullDownloadVersion=" + this.fullDownloadVersion + ')';
    }
}
