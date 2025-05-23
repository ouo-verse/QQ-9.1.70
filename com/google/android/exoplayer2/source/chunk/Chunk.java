package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Chunk implements Loader.Loadable {
    protected final DataSource dataSource;
    public final DataSpec dataSpec;
    public final long endTimeUs;
    public final long startTimeUs;
    public final Format trackFormat;
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int type;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i3, Format format, int i16, Object obj, long j3, long j16) {
        this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSpec = (DataSpec) Assertions.checkNotNull(dataSpec);
        this.type = i3;
        this.trackFormat = format;
        this.trackSelectionReason = i16;
        this.trackSelectionData = obj;
        this.startTimeUs = j3;
        this.endTimeUs = j16;
    }

    public abstract long bytesLoaded();

    public final long getDurationUs() {
        return this.endTimeUs - this.startTimeUs;
    }
}
