package com.tencent.richframework.gallery.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "", "mediaId", "", "(Ljava/lang/String;)V", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", "fileState", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "getFileState", "()Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "setFileState", "(Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;)V", "getMediaId", "()Ljava/lang/String;", "progressPercent", "", "getProgressPercent", "()F", "setProgressPercent", "(F)V", "FileState", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerFileDownloadState {
    private long fileSize;

    @Nullable
    private FileState fileState;

    @NotNull
    private final String mediaId;
    private float progressPercent;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "NO_NEED_DOWNLOAD", "DOWNLOADING", "DOWNLOAD_FAILED", "DOWNLOAD_SUCCESS", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum FileState {
        UNKNOWN,
        NO_NEED_DOWNLOAD,
        DOWNLOADING,
        DOWNLOAD_FAILED,
        DOWNLOAD_SUCCESS
    }

    public RFWLayerFileDownloadState(@NotNull String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        this.mediaId = mediaId;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final FileState getFileState() {
        return this.fileState;
    }

    @NotNull
    public final String getMediaId() {
        return this.mediaId;
    }

    public final float getProgressPercent() {
        return this.progressPercent;
    }

    public final void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public final void setFileState(@Nullable FileState fileState) {
        this.fileState = fileState;
    }

    public final void setProgressPercent(float f16) {
        this.progressPercent = f16;
    }
}
