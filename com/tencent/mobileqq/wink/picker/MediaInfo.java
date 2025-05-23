package com.tencent.mobileqq.wink.picker;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0011H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\t\u00104\u001a\u00020\u0007H\u00d6\u0001J\t\u00105\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "Ljava/io/Serializable;", "mediaType", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "albumId", "", "width", "", "height", "localMediaPath", "qZoneMediaId", "qZoneMediaThumbUrl", "qZoneMediaThumbWidth", "qZoneMediaThumbHeight", "qZoneMediaDownloadUrl", "qZoneMediaSloc", "duration", "", "(Lcom/tencent/mobileqq/wink/picker/MediaType;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;J)V", "getAlbumId", "()Ljava/lang/String;", "getDuration", "()J", "getHeight", "()I", "getLocalMediaPath", "getMediaType", "()Lcom/tencent/mobileqq/wink/picker/MediaType;", "getQZoneMediaDownloadUrl", "getQZoneMediaId", "getQZoneMediaSloc", "getQZoneMediaThumbHeight", "getQZoneMediaThumbUrl", "getQZoneMediaThumbWidth", "getWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MediaInfo implements Serializable {

    @NotNull
    private final String albumId;
    private final long duration;
    private final int height;

    @NotNull
    private final String localMediaPath;

    @NotNull
    private final MediaType mediaType;

    @NotNull
    private final String qZoneMediaDownloadUrl;

    @NotNull
    private final String qZoneMediaId;

    @NotNull
    private final String qZoneMediaSloc;
    private final int qZoneMediaThumbHeight;

    @NotNull
    private final String qZoneMediaThumbUrl;
    private final int qZoneMediaThumbWidth;
    private final int width;

    public MediaInfo(@NotNull MediaType mediaType, @NotNull String albumId, int i3, int i16, @NotNull String localMediaPath, @NotNull String qZoneMediaId, @NotNull String qZoneMediaThumbUrl, int i17, int i18, @NotNull String qZoneMediaDownloadUrl, @NotNull String qZoneMediaSloc, long j3) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(localMediaPath, "localMediaPath");
        Intrinsics.checkNotNullParameter(qZoneMediaId, "qZoneMediaId");
        Intrinsics.checkNotNullParameter(qZoneMediaThumbUrl, "qZoneMediaThumbUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaDownloadUrl, "qZoneMediaDownloadUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaSloc, "qZoneMediaSloc");
        this.mediaType = mediaType;
        this.albumId = albumId;
        this.width = i3;
        this.height = i16;
        this.localMediaPath = localMediaPath;
        this.qZoneMediaId = qZoneMediaId;
        this.qZoneMediaThumbUrl = qZoneMediaThumbUrl;
        this.qZoneMediaThumbWidth = i17;
        this.qZoneMediaThumbHeight = i18;
        this.qZoneMediaDownloadUrl = qZoneMediaDownloadUrl;
        this.qZoneMediaSloc = qZoneMediaSloc;
        this.duration = j3;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getQZoneMediaDownloadUrl() {
        return this.qZoneMediaDownloadUrl;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getQZoneMediaSloc() {
        return this.qZoneMediaSloc;
    }

    /* renamed from: component12, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getLocalMediaPath() {
        return this.localMediaPath;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getQZoneMediaId() {
        return this.qZoneMediaId;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getQZoneMediaThumbUrl() {
        return this.qZoneMediaThumbUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final int getQZoneMediaThumbWidth() {
        return this.qZoneMediaThumbWidth;
    }

    /* renamed from: component9, reason: from getter */
    public final int getQZoneMediaThumbHeight() {
        return this.qZoneMediaThumbHeight;
    }

    @NotNull
    public final MediaInfo copy(@NotNull MediaType mediaType, @NotNull String albumId, int width, int height, @NotNull String localMediaPath, @NotNull String qZoneMediaId, @NotNull String qZoneMediaThumbUrl, int qZoneMediaThumbWidth, int qZoneMediaThumbHeight, @NotNull String qZoneMediaDownloadUrl, @NotNull String qZoneMediaSloc, long duration) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(localMediaPath, "localMediaPath");
        Intrinsics.checkNotNullParameter(qZoneMediaId, "qZoneMediaId");
        Intrinsics.checkNotNullParameter(qZoneMediaThumbUrl, "qZoneMediaThumbUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaDownloadUrl, "qZoneMediaDownloadUrl");
        Intrinsics.checkNotNullParameter(qZoneMediaSloc, "qZoneMediaSloc");
        return new MediaInfo(mediaType, albumId, width, height, localMediaPath, qZoneMediaId, qZoneMediaThumbUrl, qZoneMediaThumbWidth, qZoneMediaThumbHeight, qZoneMediaDownloadUrl, qZoneMediaSloc, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if (this.mediaType == mediaInfo.mediaType && Intrinsics.areEqual(this.albumId, mediaInfo.albumId) && this.width == mediaInfo.width && this.height == mediaInfo.height && Intrinsics.areEqual(this.localMediaPath, mediaInfo.localMediaPath) && Intrinsics.areEqual(this.qZoneMediaId, mediaInfo.qZoneMediaId) && Intrinsics.areEqual(this.qZoneMediaThumbUrl, mediaInfo.qZoneMediaThumbUrl) && this.qZoneMediaThumbWidth == mediaInfo.qZoneMediaThumbWidth && this.qZoneMediaThumbHeight == mediaInfo.qZoneMediaThumbHeight && Intrinsics.areEqual(this.qZoneMediaDownloadUrl, mediaInfo.qZoneMediaDownloadUrl) && Intrinsics.areEqual(this.qZoneMediaSloc, mediaInfo.qZoneMediaSloc) && this.duration == mediaInfo.duration) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAlbumId() {
        return this.albumId;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getLocalMediaPath() {
        return this.localMediaPath;
    }

    @NotNull
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    @NotNull
    public final String getQZoneMediaDownloadUrl() {
        return this.qZoneMediaDownloadUrl;
    }

    @NotNull
    public final String getQZoneMediaId() {
        return this.qZoneMediaId;
    }

    @NotNull
    public final String getQZoneMediaSloc() {
        return this.qZoneMediaSloc;
    }

    public final int getQZoneMediaThumbHeight() {
        return this.qZoneMediaThumbHeight;
    }

    @NotNull
    public final String getQZoneMediaThumbUrl() {
        return this.qZoneMediaThumbUrl;
    }

    public final int getQZoneMediaThumbWidth() {
        return this.qZoneMediaThumbWidth;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.mediaType.hashCode() * 31) + this.albumId.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.localMediaPath.hashCode()) * 31) + this.qZoneMediaId.hashCode()) * 31) + this.qZoneMediaThumbUrl.hashCode()) * 31) + this.qZoneMediaThumbWidth) * 31) + this.qZoneMediaThumbHeight) * 31) + this.qZoneMediaDownloadUrl.hashCode()) * 31) + this.qZoneMediaSloc.hashCode()) * 31) + androidx.fragment.app.a.a(this.duration);
    }

    @NotNull
    public String toString() {
        return "MediaInfo(mediaType=" + this.mediaType + ", albumId=" + this.albumId + ", width=" + this.width + ", height=" + this.height + ", localMediaPath=" + this.localMediaPath + ", qZoneMediaId=" + this.qZoneMediaId + ", qZoneMediaThumbUrl=" + this.qZoneMediaThumbUrl + ", qZoneMediaThumbWidth=" + this.qZoneMediaThumbWidth + ", qZoneMediaThumbHeight=" + this.qZoneMediaThumbHeight + ", qZoneMediaDownloadUrl=" + this.qZoneMediaDownloadUrl + ", qZoneMediaSloc=" + this.qZoneMediaSloc + ", duration=" + this.duration + ")";
    }

    public /* synthetic */ MediaInfo(MediaType mediaType, String str, int i3, int i16, String str2, String str3, String str4, int i17, int i18, String str5, String str6, long j3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaType, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? 0 : i3, (i19 & 8) != 0 ? 0 : i16, (i19 & 16) != 0 ? "" : str2, (i19 & 32) != 0 ? "" : str3, (i19 & 64) != 0 ? "" : str4, (i19 & 128) != 0 ? 0 : i17, (i19 & 256) == 0 ? i18 : 0, (i19 & 512) != 0 ? "" : str5, (i19 & 1024) == 0 ? str6 : "", (i19 & 2048) != 0 ? 0L : j3);
    }
}
