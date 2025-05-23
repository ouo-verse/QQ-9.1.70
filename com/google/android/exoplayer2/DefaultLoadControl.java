package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 30000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    private final DefaultAllocator allocator;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final PriorityTaskManager priorityTaskManager;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    private void reset(boolean z16) {
        this.targetBufferSize = 0;
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null && this.isBuffering) {
            priorityTaskManager.remove(0);
        }
        this.isBuffering = false;
        if (z16) {
            this.allocator.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateTargetBufferSize(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i3 = 0;
        for (int i16 = 0; i16 < rendererArr.length; i16++) {
            if (trackSelectionArray.get(i16) != null) {
                i3 += Util.getDefaultBufferSize(rendererArr[i16].getTrackType());
            }
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        reset(false);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        reset(true);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int i3 = this.targetBufferBytesOverwrite;
        if (i3 == -1) {
            i3 = calculateTargetBufferSize(rendererArr, trackSelectionArray);
        }
        this.targetBufferSize = i3;
        this.allocator.setTargetBufferSize(i3);
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return false;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long j3, float f16) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (this.allocator.getTotalBytesAllocated() >= this.targetBufferSize) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z19 = this.isBuffering;
        if (this.prioritizeTimeOverSizeThresholds) {
            if (j3 >= this.minBufferUs && (j3 > this.maxBufferUs || !z19 || z16)) {
                z18 = false;
            }
            this.isBuffering = z18;
        } else {
            if (z16 || (j3 >= this.minBufferUs && (j3 > this.maxBufferUs || !z19))) {
                z18 = false;
            }
            this.isBuffering = z18;
        }
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager != null && (z17 = this.isBuffering) != z19) {
            if (z17) {
                priorityTaskManager.add(0);
            } else {
                priorityTaskManager.remove(0);
            }
        }
        return this.isBuffering;
    }

    @Override // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long j3, float f16, boolean z16) {
        long j16;
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j3, f16);
        if (z16) {
            j16 = this.bufferForPlaybackAfterRebufferUs;
        } else {
            j16 = this.bufferForPlaybackUs;
        }
        if (j16 > 0 && playoutDurationForMediaDuration < j16 && (this.prioritizeTimeOverSizeThresholds || this.allocator.getTotalBytesAllocated() < this.targetBufferSize)) {
            return false;
        }
        return true;
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, 30000, 2500, 5000, -1, true);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        this(defaultAllocator, i3, i16, i17, i18, i19, z16, null);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i3, int i16, int i17, int i18, int i19, boolean z16, PriorityTaskManager priorityTaskManager) {
        this.allocator = defaultAllocator;
        this.minBufferUs = i3 * 1000;
        this.maxBufferUs = i16 * 1000;
        this.bufferForPlaybackUs = i17 * 1000;
        this.bufferForPlaybackAfterRebufferUs = i18 * 1000;
        this.targetBufferBytesOverwrite = i19;
        this.prioritizeTimeOverSizeThresholds = z16;
        this.priorityTaskManager = priorityTaskManager;
    }
}
