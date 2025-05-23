package com.tencent.bugly.common.reporter.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/bugly/common/reporter/data/FileInfo;", "", "filePath", "", "delWhenSuccess", "", "delWhenFail", "(Ljava/lang/String;ZZ)V", "getDelWhenFail", "()Z", "getDelWhenSuccess", "getFilePath", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final /* data */ class FileInfo {
    private final boolean delWhenFail;
    private final boolean delWhenSuccess;

    @NotNull
    private final String filePath;

    public FileInfo(@NotNull String filePath, boolean z16, boolean z17) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        this.filePath = filePath;
        this.delWhenSuccess = z16;
        this.delWhenFail = z17;
    }

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fileInfo.filePath;
        }
        if ((i3 & 2) != 0) {
            z16 = fileInfo.delWhenSuccess;
        }
        if ((i3 & 4) != 0) {
            z17 = fileInfo.delWhenFail;
        }
        return fileInfo.copy(str, z16, z17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDelWhenSuccess() {
        return this.delWhenSuccess;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getDelWhenFail() {
        return this.delWhenFail;
    }

    @NotNull
    public final FileInfo copy(@NotNull String filePath, boolean delWhenSuccess, boolean delWhenFail) {
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        return new FileInfo(filePath, delWhenSuccess, delWhenFail);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (this != other) {
            if (other instanceof FileInfo) {
                FileInfo fileInfo = (FileInfo) other;
                if (Intrinsics.areEqual(this.filePath, fileInfo.filePath)) {
                    if (this.delWhenSuccess == fileInfo.delWhenSuccess) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.delWhenFail == fileInfo.delWhenFail) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean getDelWhenFail() {
        return this.delWhenFail;
    }

    public final boolean getDelWhenSuccess() {
        return this.delWhenSuccess;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.filePath;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.delWhenSuccess;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.delWhenFail;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "FileInfo(filePath=" + this.filePath + ", delWhenSuccess=" + this.delWhenSuccess + ", delWhenFail=" + this.delWhenFail + ")";
    }
}
