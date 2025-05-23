package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TrackSelectorResult {
    public final TrackGroupArray groups;
    public final Object info;
    public final RendererConfiguration[] rendererConfigurations;
    public final boolean[] renderersEnabled;
    public final TrackSelectionArray selections;

    public TrackSelectorResult(TrackGroupArray trackGroupArray, boolean[] zArr, TrackSelectionArray trackSelectionArray, Object obj, RendererConfiguration[] rendererConfigurationArr) {
        this.groups = trackGroupArray;
        this.renderersEnabled = zArr;
        this.selections = trackSelectionArray;
        this.info = obj;
        this.rendererConfigurations = rendererConfigurationArr;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i3 = 0; i3 < this.selections.length; i3++) {
            if (!isEquivalent(trackSelectorResult, i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult, int i3) {
        return trackSelectorResult != null && this.renderersEnabled[i3] == trackSelectorResult.renderersEnabled[i3] && Util.areEqual(this.selections.get(i3), trackSelectorResult.selections.get(i3)) && Util.areEqual(this.rendererConfigurations[i3], trackSelectorResult.rendererConfigurations[i3]);
    }
}
