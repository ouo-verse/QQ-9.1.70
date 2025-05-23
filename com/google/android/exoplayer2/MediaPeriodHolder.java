package com.google.android.exoplayer2;

import android.util.Log;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    public MediaPeriodHolder next;
    private TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    public long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    private final TrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j3, TrackSelector trackSelector, Allocator allocator, MediaSource mediaSource, Object obj, MediaPeriodInfo mediaPeriodInfo) {
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.rendererPositionOffsetUs = j3 - mediaPeriodInfo.startPositionUs;
        this.trackSelector = trackSelector;
        this.mediaSource = mediaSource;
        this.uid = Assertions.checkNotNull(obj);
        this.info = mediaPeriodInfo;
        this.sampleStreams = new SampleStream[rendererCapabilitiesArr.length];
        this.mayRetainStreamFlags = new boolean[rendererCapabilitiesArr.length];
        MediaPeriod createPeriod = mediaSource.createPeriod(mediaPeriodInfo.f32937id, allocator);
        if (mediaPeriodInfo.endPositionUs != Long.MIN_VALUE) {
            ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(createPeriod, true);
            clippingMediaPeriod.setClipping(0L, mediaPeriodInfo.endPositionUs);
            createPeriod = clippingMediaPeriod;
        }
        this.mediaPeriod = createPeriod;
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i3 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i3].getTrackType() == 5 && this.trackSelectorResult.renderersEnabled[i3]) {
                    sampleStreamArr[i3] = new EmptySampleStream();
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void disableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        int i3 = 0;
        while (true) {
            boolean[] zArr = trackSelectorResult.renderersEnabled;
            if (i3 < zArr.length) {
                boolean z16 = zArr[i3];
                TrackSelection trackSelection = trackSelectorResult.selections.get(i3);
                if (z16 && trackSelection != null) {
                    trackSelection.disable();
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i3 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i3].getTrackType() == 5) {
                    sampleStreamArr[i3] = null;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void enableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult) {
        int i3 = 0;
        while (true) {
            boolean[] zArr = trackSelectorResult.renderersEnabled;
            if (i3 < zArr.length) {
                boolean z16 = zArr[i3];
                TrackSelection trackSelection = trackSelectorResult.selections.get(i3);
                if (z16 && trackSelection != null) {
                    trackSelection.enable();
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void updatePeriodTrackSelectorResult(TrackSelectorResult trackSelectorResult) {
        TrackSelectorResult trackSelectorResult2 = this.periodTrackSelectorResult;
        if (trackSelectorResult2 != null) {
            disableTrackSelectionsInResult(trackSelectorResult2);
        }
        this.periodTrackSelectorResult = trackSelectorResult;
        if (trackSelectorResult != null) {
            enableTrackSelectionsInResult(trackSelectorResult);
        }
    }

    public long applyTrackSelection(long j3, boolean z16) {
        return applyTrackSelection(j3, z16, new boolean[this.rendererCapabilities.length]);
    }

    public void continueLoading(long j3) {
        this.mediaPeriod.continueLoading(toPeriodTime(j3));
    }

    public long getBufferedPositionUs(boolean z16) {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE && z16) {
            return this.info.durationUs;
        }
        return bufferedPositionUs;
    }

    public long getDurationUs() {
        return this.info.durationUs;
    }

    public long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0L;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public TrackSelectorResult handlePrepared(float f16) throws ExoPlaybackException {
        this.prepared = true;
        selectTracks(f16);
        long applyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        long j3 = this.rendererPositionOffsetUs;
        MediaPeriodInfo mediaPeriodInfo = this.info;
        this.rendererPositionOffsetUs = j3 + (mediaPeriodInfo.startPositionUs - applyTrackSelection);
        this.info = mediaPeriodInfo.copyWithStartPositionUs(applyTrackSelection);
        return this.trackSelectorResult;
    }

    public boolean isFullyBuffered() {
        if (this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE)) {
            return true;
        }
        return false;
    }

    public void reevaluateBuffer(long j3) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j3));
        }
    }

    public void release() {
        updatePeriodTrackSelectorResult(null);
        try {
            if (this.info.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (RuntimeException e16) {
            Log.e(TAG, "Period release failed.", e16);
        }
    }

    public boolean selectTracks(float f16) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.mediaPeriod.getTrackGroups());
        if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = selectTracks;
        for (TrackSelection trackSelection : selectTracks.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f16);
            }
        }
        return true;
    }

    public long toPeriodTime(long j3) {
        return j3 - getRendererOffset();
    }

    public long toRendererTime(long j3) {
        return j3 + getRendererOffset();
    }

    public long applyTrackSelection(long j3, boolean z16, boolean[] zArr) {
        TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        int i3 = 0;
        while (true) {
            boolean z17 = true;
            if (i3 >= trackSelectionArray.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z16 || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i3)) {
                z17 = false;
            }
            zArr2[i3] = z17;
            i3++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j3);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i16 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i16 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i16] != null) {
                Assertions.checkState(this.trackSelectorResult.renderersEnabled[i16]);
                if (this.rendererCapabilities[i16].getTrackType() != 5) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i16) == null);
            }
            i16++;
        }
    }
}
