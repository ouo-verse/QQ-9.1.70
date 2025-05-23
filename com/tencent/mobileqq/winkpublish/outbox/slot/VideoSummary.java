package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u000fH\u00c6\u0003J\t\u0010$\u001a\u00020\u000fH\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\tH\u00c6\u0003J\t\u0010)\u001a\u00020\tH\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0006H\u00d6\u0001J\t\u00101\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0018\"\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;", "", "localPath", "", "vid", "width", "", "height", "bitrate", "", "duration", BasicAnimation.KeyPath.ROTATION, "fileSize", "mimeType", "isHDR", "", "isHEVC", "(Ljava/lang/String;Ljava/lang/String;IIJJIJLjava/lang/String;ZZ)V", "getBitrate", "()J", "getDuration", "getFileSize", "getHeight", "()I", "()Z", "setHDR", "(Z)V", "setHEVC", "getLocalPath", "()Ljava/lang/String;", "getMimeType", "getRotation", "getVid", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class VideoSummary {
    private final long bitrate;
    private final long duration;
    private final long fileSize;
    private final int height;
    private boolean isHDR;
    private boolean isHEVC;
    private final String localPath;
    private final String mimeType;
    private final int rotation;
    private final String vid;
    private final int width;

    public VideoSummary(String localPath, String vid, int i3, int i16, long j3, long j16, int i17, long j17, String mimeType, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.localPath = localPath;
        this.vid = vid;
        this.width = i3;
        this.height = i16;
        this.bitrate = j3;
        this.duration = j16;
        this.rotation = i17;
        this.fileSize = j17;
        this.mimeType = mimeType;
        this.isHDR = z16;
        this.isHEVC = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsHDR() {
        return this.isHDR;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsHEVC() {
        return this.isHEVC;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component6, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRotation() {
        return this.rotation;
    }

    /* renamed from: component8, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final VideoSummary copy(String localPath, String vid, int width, int height, long bitrate, long duration, int rotation, long fileSize, String mimeType, boolean isHDR, boolean isHEVC) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new VideoSummary(localPath, vid, width, height, bitrate, duration, rotation, fileSize, mimeType, isHDR, isHEVC);
    }

    public final long getBitrate() {
        return this.bitrate;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final String getVid() {
        return this.vid;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.localPath.hashCode() * 31) + this.vid.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + d.a(this.bitrate)) * 31) + d.a(this.duration)) * 31) + this.rotation) * 31) + d.a(this.fileSize)) * 31) + this.mimeType.hashCode()) * 31;
        boolean z16 = this.isHDR;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isHEVC;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isHDR() {
        return this.isHDR;
    }

    public final boolean isHEVC() {
        return this.isHEVC;
    }

    public final void setHDR(boolean z16) {
        this.isHDR = z16;
    }

    public final void setHEVC(boolean z16) {
        this.isHEVC = z16;
    }

    public String toString() {
        return "VideoSummary(localPath=" + this.localPath + ", vid=" + this.vid + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", duration=" + this.duration + ", rotation=" + this.rotation + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", isHDR=" + this.isHDR + ", isHEVC=" + this.isHEVC + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSummary)) {
            return false;
        }
        VideoSummary videoSummary = (VideoSummary) other;
        return Intrinsics.areEqual(this.localPath, videoSummary.localPath) && Intrinsics.areEqual(this.vid, videoSummary.vid) && this.width == videoSummary.width && this.height == videoSummary.height && this.bitrate == videoSummary.bitrate && this.duration == videoSummary.duration && this.rotation == videoSummary.rotation && this.fileSize == videoSummary.fileSize && Intrinsics.areEqual(this.mimeType, videoSummary.mimeType) && this.isHDR == videoSummary.isHDR && this.isHEVC == videoSummary.isHEVC;
    }

    public /* synthetic */ VideoSummary(String str, String str2, int i3, int i16, long j3, long j16, int i17, long j17, String str3, boolean z16, boolean z17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, i16, j3, j16, i17, j17, str3, (i18 & 512) != 0 ? false : z16, (i18 & 1024) != 0 ? false : z17);
    }
}
