package com.tencent.mobileqq.wink.editor.export;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "width", "b", "d", "height", "", "c", "J", "()J", "duration", "bitRate", "frameRate", "<init>", "(IIJJI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.export.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class VideoInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long bitRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int frameRate;

    public VideoInfo(int i3, int i16, long j3, long j16, int i17) {
        this.width = i3;
        this.height = i16;
        this.duration = j3;
        this.bitRate = j16;
        this.frameRate = i17;
    }

    /* renamed from: a, reason: from getter */
    public final long getBitRate() {
        return this.bitRate;
    }

    /* renamed from: b, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: c, reason: from getter */
    public final int getFrameRate() {
        return this.frameRate;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: e, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) other;
        if (this.width == videoInfo.width && this.height == videoInfo.height && this.duration == videoInfo.duration && this.bitRate == videoInfo.bitRate && this.frameRate == videoInfo.frameRate) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.width * 31) + this.height) * 31) + androidx.fragment.app.a.a(this.duration)) * 31) + androidx.fragment.app.a.a(this.bitRate)) * 31) + this.frameRate;
    }

    @NotNull
    public String toString() {
        return "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", bitRate=" + this.bitRate + ", frameRate=" + this.frameRate + ")";
    }
}
