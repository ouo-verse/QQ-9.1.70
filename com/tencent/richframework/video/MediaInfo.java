package com.tencent.richframework.video;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/richframework/video/MediaInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "videoCodec", "Ljava/lang/String;", "getVideoCodec", "()Ljava/lang/String;", "setVideoCodec", "(Ljava/lang/String;)V", "videoWidth", "I", "getVideoWidth", "()I", "videoHeight", "getVideoHeight", "", "videoBitRate", "J", "getVideoBitRate", "()J", "<init>", "(Ljava/lang/String;IIJ)V", "video-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class MediaInfo {
    private final long videoBitRate;

    @Nullable
    private String videoCodec;
    private final int videoHeight;
    private final int videoWidth;

    public MediaInfo() {
        this(null, 0, 0, 0L, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MediaInfo) {
                MediaInfo mediaInfo = (MediaInfo) other;
                if (!Intrinsics.areEqual(this.videoCodec, mediaInfo.videoCodec) || this.videoWidth != mediaInfo.videoWidth || this.videoHeight != mediaInfo.videoHeight || this.videoBitRate != mediaInfo.videoBitRate) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getVideoCodec() {
        return this.videoCodec;
    }

    public int hashCode() {
        int i3;
        String str = this.videoCodec;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (((((i3 * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + androidx.fragment.app.a.a(this.videoBitRate);
    }

    @NotNull
    public String toString() {
        return "MediaInfo(videoCodec=" + this.videoCodec + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitRate=" + this.videoBitRate + ")";
    }

    public MediaInfo(@Nullable String str, int i3, int i16, long j3) {
        this.videoCodec = str;
        this.videoWidth = i3;
        this.videoHeight = i16;
        this.videoBitRate = j3;
    }

    public /* synthetic */ MediaInfo(String str, int i3, int i16, long j3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) == 0 ? i16 : 0, (i17 & 8) != 0 ? 0L : j3);
    }
}
