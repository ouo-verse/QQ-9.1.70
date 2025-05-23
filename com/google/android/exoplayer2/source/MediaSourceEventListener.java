package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface MediaSourceEventListener {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EventDispatcher {

        @Nullable
        private final Handler handler;

        @Nullable
        private final MediaSourceEventListener listener;
        private final long mediaTimeOffsetMs;

        public EventDispatcher(@Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            this(handler, mediaSourceEventListener, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long adjustMediaTime(long j3) {
            long usToMs = C.usToMs(j3);
            if (usToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }

        public EventDispatcher copyWithMediaTimeOffsetMs(long j3) {
            return new EventDispatcher(this.handler, this.listener, j3);
        }

        public void downstreamFormatChanged(final int i3, final Format format, final int i16, final Object obj, final long j3) {
            Handler handler;
            if (this.listener != null && (handler = this.handler) != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.6
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onDownstreamFormatChanged(i3, format, i16, obj, EventDispatcher.this.adjustMediaTime(j3));
                    }
                });
            }
        }

        public void loadCanceled(DataSpec dataSpec, int i3, long j3, long j16, long j17) {
            loadCanceled(dataSpec, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j3, j16, j17);
        }

        public void loadCompleted(DataSpec dataSpec, int i3, long j3, long j16, long j17) {
            loadCompleted(dataSpec, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j3, j16, j17);
        }

        public void loadError(DataSpec dataSpec, int i3, long j3, long j16, long j17, IOException iOException, boolean z16) {
            loadError(dataSpec, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j3, j16, j17, iOException, z16);
        }

        public void loadStarted(DataSpec dataSpec, int i3, long j3) {
            loadStarted(dataSpec, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j3);
        }

        public void upstreamDiscarded(final int i3, final long j3, final long j16) {
            Handler handler;
            if (this.listener != null && (handler = this.handler) != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.5
                    @Override // java.lang.Runnable
                    public void run() {
                        EventDispatcher.this.listener.onUpstreamDiscarded(i3, EventDispatcher.this.adjustMediaTime(j3), EventDispatcher.this.adjustMediaTime(j16));
                    }
                });
            }
        }

        public EventDispatcher(@Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener, long j3) {
            this.handler = mediaSourceEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = mediaSourceEventListener;
            this.mediaTimeOffsetMs = j3;
        }

        public void loadCanceled(final DataSpec dataSpec, final int i3, final int i16, final Format format, final int i17, final Object obj, final long j3, final long j16, final long j17, final long j18, final long j19) {
            Handler handler;
            if (this.listener == null || (handler = this.handler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.3
                @Override // java.lang.Runnable
                public void run() {
                    EventDispatcher.this.listener.onLoadCanceled(dataSpec, i3, i16, format, i17, obj, EventDispatcher.this.adjustMediaTime(j3), EventDispatcher.this.adjustMediaTime(j16), j17, j18, j19);
                }
            });
        }

        public void loadCompleted(final DataSpec dataSpec, final int i3, final int i16, final Format format, final int i17, final Object obj, final long j3, final long j16, final long j17, final long j18, final long j19) {
            Handler handler;
            if (this.listener == null || (handler = this.handler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    EventDispatcher.this.listener.onLoadCompleted(dataSpec, i3, i16, format, i17, obj, EventDispatcher.this.adjustMediaTime(j3), EventDispatcher.this.adjustMediaTime(j16), j17, j18, j19);
                }
            });
        }

        public void loadError(final DataSpec dataSpec, final int i3, final int i16, final Format format, final int i17, final Object obj, final long j3, final long j16, final long j17, final long j18, final long j19, final IOException iOException, final boolean z16) {
            Handler handler;
            if (this.listener == null || (handler = this.handler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.4
                @Override // java.lang.Runnable
                public void run() {
                    EventDispatcher.this.listener.onLoadError(dataSpec, i3, i16, format, i17, obj, EventDispatcher.this.adjustMediaTime(j3), EventDispatcher.this.adjustMediaTime(j16), j17, j18, j19, iOException, z16);
                }
            });
        }

        public void loadStarted(final DataSpec dataSpec, final int i3, final int i16, final Format format, final int i17, final Object obj, final long j3, final long j16, final long j17) {
            Handler handler;
            if (this.listener == null || (handler = this.handler) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    EventDispatcher.this.listener.onLoadStarted(dataSpec, i3, i16, format, i17, obj, EventDispatcher.this.adjustMediaTime(j3), EventDispatcher.this.adjustMediaTime(j16), j17);
                }
            });
        }
    }

    void onDownstreamFormatChanged(int i3, Format format, int i16, Object obj, long j3);

    void onLoadCanceled(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19);

    void onLoadCompleted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19);

    void onLoadError(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16);

    void onLoadStarted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17);

    void onUpstreamDiscarded(int i3, long j3, long j16);
}
