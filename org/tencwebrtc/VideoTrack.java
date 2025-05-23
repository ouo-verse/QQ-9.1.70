package org.tencwebrtc;

import java.util.IdentityHashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoTrack extends MediaStreamTrack {
    private final IdentityHashMap<VideoSink, Long> sinks;

    public VideoTrack(long j3) {
        super(j3);
        this.sinks = new IdentityHashMap<>();
    }

    private static native void nativeAddSink(long j3, long j16);

    private static native void nativeFreeSink(long j3);

    private static native void nativeRemoveSink(long j3, long j16);

    private static native long nativeWrapSink(VideoSink videoSink);

    public void addSink(VideoSink videoSink) {
        if (videoSink != null) {
            if (!this.sinks.containsKey(videoSink)) {
                long nativeWrapSink = nativeWrapSink(videoSink);
                this.sinks.put(videoSink, Long.valueOf(nativeWrapSink));
                nativeAddSink(getNativeMediaStreamTrack(), nativeWrapSink);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The VideoSink is not allowed to be null");
    }

    @Override // org.tencwebrtc.MediaStreamTrack
    public void dispose() {
        Iterator<Long> it = this.sinks.values().iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            nativeRemoveSink(getNativeMediaStreamTrack(), longValue);
            nativeFreeSink(longValue);
        }
        this.sinks.clear();
        super.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeVideoTrack() {
        return getNativeMediaStreamTrack();
    }

    public void removeSink(VideoSink videoSink) {
        Long remove = this.sinks.remove(videoSink);
        if (remove != null) {
            nativeRemoveSink(getNativeMediaStreamTrack(), remove.longValue());
            nativeFreeSink(remove.longValue());
        }
    }
}
