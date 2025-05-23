package com.tencent.state.square.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/media/VideoInfo;", "", "()V", "format", "getFormat", "()Ljava/lang/Object;", "setFormat", "(Ljava/lang/Object;)V", "frameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "height", "getHeight", "setHeight", "mime", "", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "width", "getWidth", "setWidth", "toString", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VideoInfo {
    private int height;
    private int width;
    private String mime = "";
    private int frameRate = 15;
    private Object format = new Object();

    public final Object getFormat() {
        return this.format;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMime() {
        return this.mime;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setFormat(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.format = obj;
    }

    public final void setFrameRate(int i3) {
        this.frameRate = i3;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setMime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mime = str;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public String toString() {
        return "VideoInfo(mime=" + this.mime + ", width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + ')';
    }
}
