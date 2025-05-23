package com.google.android.exoplayer2.source;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CompositeSequenceableLoader implements SequenceableLoader {
    protected final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            z16 = false;
            for (SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                if (nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (nextLoadPositionUs2 == nextLoadPositionUs || z17) {
                    z16 |= sequenceableLoader.continueLoading(j3);
                }
            }
            z18 |= z16;
        } while (z16);
        return z18;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long j3 = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                j3 = Math.min(j3, bufferedPositionUs);
            }
        }
        if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long j3 = Long.MAX_VALUE;
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                j3 = Math.min(j3, nextLoadPositionUs);
            }
        }
        if (j3 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j3) {
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            sequenceableLoader.reevaluateBuffer(j3);
        }
    }
}
