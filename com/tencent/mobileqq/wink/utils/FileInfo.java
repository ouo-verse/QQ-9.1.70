package com.tencent.mobileqq.wink.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "", "b", "J", "c", "()J", "modifiedData", "fileSize", "<init>", "(Ljava/lang/String;JJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.utils.k, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class FileInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String filePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long modifiedData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long fileSize;

    public FileInfo() {
        this(null, 0L, 0L, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: b, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: c, reason: from getter */
    public final long getModifiedData() {
        return this.modifiedData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) other;
        if (Intrinsics.areEqual(this.filePath, fileInfo.filePath) && this.modifiedData == fileInfo.modifiedData && this.fileSize == fileInfo.fileSize) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.filePath.hashCode() * 31) + androidx.fragment.app.a.a(this.modifiedData)) * 31) + androidx.fragment.app.a.a(this.fileSize);
    }

    @NotNull
    public String toString() {
        return "FileInfo(filePath=" + this.filePath + ", modifiedData=" + this.modifiedData + ", fileSize=" + this.fileSize + ")";
    }

    public FileInfo(@NotNull String filePath, long j3, long j16) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.modifiedData = j3;
        this.fileSize = j16;
    }

    public /* synthetic */ FileInfo(String str, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16);
    }
}
