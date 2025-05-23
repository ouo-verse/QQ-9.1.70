package com.google.android.exoplayer2.ext.mediaplayer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class VideoMeta {
    public static final int OPEN_ENDED = -1;
    public final long duration;
    public long endPosition = -1;
    public long startPosition;
    public final String uri;

    public VideoMeta(String str, long j3) {
        this.uri = str;
        this.duration = j3;
    }
}
