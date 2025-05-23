package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* loaded from: classes2.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    private int pendingChildPrepareCount;
    public final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices = new IdentityHashMap<>();
    private TrackGroupArray trackGroups;

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.periods = mediaPeriodArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        return this.compositeSequenceableLoader.continueLoading(j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            mediaPeriod.discardBuffer(j3, z16);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j3, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        int i3 = this.pendingChildPrepareCount - 1;
        this.pendingChildPrepareCount = i3;
        if (i3 > 0) {
            return;
        }
        int i16 = 0;
        for (MediaPeriod mediaPeriod2 : this.periods) {
            i16 += mediaPeriod2.getTrackGroups().length;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i16];
        int i17 = 0;
        for (MediaPeriod mediaPeriod3 : this.periods) {
            TrackGroupArray trackGroups = mediaPeriod3.getTrackGroups();
            int i18 = trackGroups.length;
            int i19 = 0;
            while (i19 < i18) {
                trackGroupArr[i17] = trackGroups.get(i19);
                i19++;
                i17++;
            }
        }
        this.trackGroups = new TrackGroupArray(trackGroupArr);
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        this.callback = callback;
        MediaPeriod[] mediaPeriodArr = this.periods;
        this.pendingChildPrepareCount = mediaPeriodArr.length;
        for (MediaPeriod mediaPeriod : mediaPeriodArr) {
            mediaPeriod.prepare(this, j3);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        long readDiscontinuity = this.periods[0].readDiscontinuity();
        int i3 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i3 < mediaPeriodArr.length) {
                if (mediaPeriodArr[i3].readDiscontinuity() == -9223372036854775807L) {
                    i3++;
                } else {
                    throw new IllegalStateException("Child reported discontinuity");
                }
            } else {
                if (readDiscontinuity != -9223372036854775807L) {
                    for (MediaPeriod mediaPeriod : this.enabledPeriods) {
                        if (mediaPeriod != this.periods[0] && mediaPeriod.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return readDiscontinuity;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
        this.compositeSequenceableLoader.reevaluateBuffer(j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j3) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j3);
        int i3 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i3 < mediaPeriodArr.length) {
                if (mediaPeriodArr[i3].seekToUs(seekToUs) == seekToUs) {
                    i3++;
                } else {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            } else {
                return seekToUs;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        boolean z16;
        SampleStream sampleStream;
        int intValue;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr2[i3];
            if (sampleStream2 == null) {
                intValue = -1;
            } else {
                intValue = this.streamPeriodIndices.get(sampleStream2).intValue();
            }
            iArr[i3] = intValue;
            iArr2[i3] = -1;
            TrackSelection trackSelection = trackSelectionArr[i3];
            if (trackSelection != null) {
                TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i16 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i16 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i16].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i3] = i16;
                        break;
                    }
                    i16++;
                }
            }
        }
        this.streamPeriodIndices.clear();
        int length = trackSelectionArr.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr.length];
        TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j16 = j3;
        int i17 = 0;
        while (i17 < this.periods.length) {
            for (int i18 = 0; i18 < trackSelectionArr.length; i18++) {
                TrackSelection trackSelection2 = null;
                if (iArr[i18] == i17) {
                    sampleStream = sampleStreamArr2[i18];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i18] = sampleStream;
                if (iArr2[i18] == i17) {
                    trackSelection2 = trackSelectionArr[i18];
                }
                trackSelectionArr2[i18] = trackSelection2;
            }
            int i19 = i17;
            TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
            ArrayList arrayList2 = arrayList;
            long selectTracks = this.periods[i17].selectTracks(trackSelectionArr2, zArr, sampleStreamArr4, zArr2, j16);
            if (i19 == 0) {
                j16 = selectTracks;
            } else if (selectTracks != j16) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z17 = false;
            for (int i26 = 0; i26 < trackSelectionArr.length; i26++) {
                boolean z18 = true;
                if (iArr2[i26] == i19) {
                    if (sampleStreamArr4[i26] != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Assertions.checkState(z16);
                    sampleStreamArr3[i26] = sampleStreamArr4[i26];
                    this.streamPeriodIndices.put(sampleStreamArr4[i26], Integer.valueOf(i19));
                    z17 = true;
                } else if (iArr[i26] == i19) {
                    if (sampleStreamArr4[i26] != null) {
                        z18 = false;
                    }
                    Assertions.checkState(z18);
                }
            }
            if (z17) {
                arrayList2.add(this.periods[i19]);
            }
            i17 = i19 + 1;
            arrayList = arrayList2;
            trackSelectionArr2 = trackSelectionArr3;
            sampleStreamArr2 = sampleStreamArr;
        }
        SampleStream[] sampleStreamArr5 = sampleStreamArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr5, 0, length);
        MediaPeriod[] mediaPeriodArr2 = new MediaPeriod[arrayList3.size()];
        this.enabledPeriods = mediaPeriodArr2;
        arrayList3.toArray(mediaPeriodArr2);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j16;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.trackGroups == null) {
            return;
        }
        this.callback.onContinueLoadingRequested(this);
    }
}
