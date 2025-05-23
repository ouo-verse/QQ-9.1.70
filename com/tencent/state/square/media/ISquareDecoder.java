package com.tencent.state.square.media;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0005H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/media/ISquareDecoder;", "", "isInvalid", "", "pause", "", "release", "reset", "resume", "setListener", "listener", "Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "setLoopCount", "loopCount", "", "setLoopDecode", "isLoopDecode", "start", "source", "Lcom/tencent/state/square/media/MediaSource;", "stop", "Listener", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareDecoder {
    boolean isInvalid();

    void pause();

    void release();

    void reset();

    void resume();

    void setListener(Listener listener);

    void setLoopCount(int loopCount);

    void setLoopDecode(boolean isLoopDecode);

    void start(MediaSource source);

    void stop();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/media/ISquareDecoder$Listener;", "", "onDecodeError", "", "code", "", "message", "", "onlyReport", "", "onDecodeFirstFrame", "onDecodeLoop", "onDecodeLoopStart", "onDecodeReleased", "onDecodeStart", "onDecodeStop", "from", "Lcom/tencent/state/square/media/StopFrom;", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface Listener {
        void onDecodeError(int code, String message, boolean onlyReport);

        void onDecodeFirstFrame();

        void onDecodeLoop();

        void onDecodeLoopStart();

        void onDecodeReleased();

        void onDecodeStart();

        void onDecodeStop(StopFrom from);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onDecodeError$default(Listener listener, int i3, String str, boolean z16, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        str = "";
                    }
                    if ((i16 & 4) != 0) {
                        z16 = false;
                    }
                    listener.onDecodeError(i3, str, z16);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDecodeError");
            }
        }
    }
}
