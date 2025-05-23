package com.tencent.zplan.resource.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/resource/data/ZPlanUEResInfo;", "Ljava/io/Serializable;", "relativePath", "", "fullUrl", "localFilePath", "md5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFullUrl", "()Ljava/lang/String;", "getLocalFilePath", "getMd5", "getRelativePath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class ZPlanUEResInfo implements Serializable {

    @NotNull
    private final String fullUrl;

    @NotNull
    private final String localFilePath;

    @Nullable
    private final String md5;

    @NotNull
    private final String relativePath;

    public ZPlanUEResInfo(@NotNull String relativePath, @NotNull String fullUrl, @NotNull String localFilePath, @Nullable String str) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        this.relativePath = relativePath;
        this.fullUrl = fullUrl;
        this.localFilePath = localFilePath;
        this.md5 = str;
    }

    public static /* synthetic */ ZPlanUEResInfo copy$default(ZPlanUEResInfo zPlanUEResInfo, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanUEResInfo.relativePath;
        }
        if ((i3 & 2) != 0) {
            str2 = zPlanUEResInfo.fullUrl;
        }
        if ((i3 & 4) != 0) {
            str3 = zPlanUEResInfo.localFilePath;
        }
        if ((i3 & 8) != 0) {
            str4 = zPlanUEResInfo.md5;
        }
        return zPlanUEResInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRelativePath() {
        return this.relativePath;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFullUrl() {
        return this.fullUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final ZPlanUEResInfo copy(@NotNull String relativePath, @NotNull String fullUrl, @NotNull String localFilePath, @Nullable String md5) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(fullUrl, "fullUrl");
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        return new ZPlanUEResInfo(relativePath, fullUrl, localFilePath, md5);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanUEResInfo) {
                ZPlanUEResInfo zPlanUEResInfo = (ZPlanUEResInfo) other;
                if (!Intrinsics.areEqual(this.relativePath, zPlanUEResInfo.relativePath) || !Intrinsics.areEqual(this.fullUrl, zPlanUEResInfo.fullUrl) || !Intrinsics.areEqual(this.localFilePath, zPlanUEResInfo.localFilePath) || !Intrinsics.areEqual(this.md5, zPlanUEResInfo.md5)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getFullUrl() {
        return this.fullUrl;
    }

    @NotNull
    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getRelativePath() {
        return this.relativePath;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.relativePath;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.fullUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.localFilePath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.md5;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "ZPlanUEResInfo(relativePath=" + this.relativePath + ", fullUrl=" + this.fullUrl + ", localFilePath=" + this.localFilePath + ", md5=" + this.md5 + ")";
    }

    public /* synthetic */ ZPlanUEResInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : str4);
    }
}
