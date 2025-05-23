package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;
    private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides = new SparseArray<>();
    private final SparseBooleanArray rendererDisabledFlags = new SparseBooleanArray();
    private int tunnelingAudioSessionId = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SelectionOverride {
        public final TrackSelection.Factory factory;
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(TrackSelection.Factory factory, int i3, int... iArr) {
            this.factory = factory;
            this.groupIndex = i3;
            this.tracks = iArr;
            this.length = iArr.length;
        }

        public boolean containsTrack(int i3) {
            for (int i16 : this.tracks) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }

        public TrackSelection createTrackSelection(TrackGroupArray trackGroupArray) {
            return this.factory.createTrackSelection(trackGroupArray.get(this.groupIndex), this.tracks);
        }
    }

    private boolean[] determineEnabledRenderers(RendererCapabilities[] rendererCapabilitiesArr, TrackSelection[] trackSelectionArr) {
        boolean z16;
        int length = trackSelectionArr.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            if (!this.rendererDisabledFlags.get(i3) && (rendererCapabilitiesArr[i3].getTrackType() == 5 || trackSelectionArr[i3] != null)) {
                z16 = true;
            } else {
                z16 = false;
            }
            zArr[i3] = z16;
        }
        return zArr;
    }

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i3 = 0;
        for (int i16 = 0; i16 < rendererCapabilitiesArr.length; i16++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i16];
            for (int i17 = 0; i17 < trackGroup.length; i17++) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i17)) & 7;
                if (supportsFormat > i3) {
                    if (supportsFormat == 4) {
                        return i16;
                    }
                    length = i16;
                    i3 = supportsFormat;
                }
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            iArr[i3] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i3));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = rendererCapabilitiesArr[i3].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    private static void maybeConfigureRenderersForTunneling(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i3) {
        boolean z16;
        if (i3 == 0) {
            return;
        }
        boolean z17 = false;
        int i16 = -1;
        int i17 = -1;
        for (int i18 = 0; i18 < rendererCapabilitiesArr.length; i18++) {
            int trackType = rendererCapabilitiesArr[i18].getTrackType();
            TrackSelection trackSelection = trackSelectionArr[i18];
            if ((trackType == 1 || trackType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i18], trackGroupArrayArr[i18], trackSelection)) {
                if (trackType == 1) {
                    if (i17 == -1) {
                        i17 = i18;
                    } else {
                        z16 = false;
                        break;
                    }
                } else {
                    if (i16 != -1) {
                        z16 = false;
                        break;
                    }
                    i16 = i18;
                }
            }
        }
        z16 = true;
        if (i17 != -1 && i16 != -1) {
            z17 = true;
        }
        if (z16 & z17) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(i3);
            rendererConfigurationArr[i17] = rendererConfiguration;
            rendererConfigurationArr[i16] = rendererConfiguration;
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i3 = 0; i3 < trackSelection.length(); i3++) {
            if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i3)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    public final void clearSelectionOverride(int i3, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i3);
        if (map != null && map.containsKey(trackGroupArray)) {
            map.remove(trackGroupArray);
            if (map.isEmpty()) {
                this.selectionOverrides.remove(i3);
            }
            invalidate();
        }
    }

    public final void clearSelectionOverrides(int i3) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i3);
        if (map == null || map.isEmpty()) {
            return;
        }
        this.selectionOverrides.remove(i3);
        invalidate();
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final boolean getRendererDisabled(int i3) {
        return this.rendererDisabledFlags.get(i3);
    }

    public final SelectionOverride getSelectionOverride(int i3, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i3);
        if (map != null) {
            return map.get(trackGroupArray);
        }
        return null;
    }

    public final boolean hasSelectionOverride(int i3, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i3);
        if (map != null && map.containsKey(trackGroupArray)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector
    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        RendererConfiguration rendererConfiguration;
        int[] formatSupport;
        int[] iArr = new int[rendererCapabilitiesArr.length + 1];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length];
        int[][][] iArr2 = new int[rendererCapabilitiesArr.length + 1][];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = trackGroupArray.length;
            trackGroupArr[i3] = new TrackGroup[i16];
            iArr2[i3] = new int[i16];
        }
        int[] mixedMimeTypeAdaptationSupport = getMixedMimeTypeAdaptationSupport(rendererCapabilitiesArr);
        for (int i17 = 0; i17 < trackGroupArray.length; i17++) {
            TrackGroup trackGroup = trackGroupArray.get(i17);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            if (findRenderer == rendererCapabilitiesArr.length) {
                formatSupport = new int[trackGroup.length];
            } else {
                formatSupport = getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            }
            int i18 = iArr[findRenderer];
            trackGroupArr[findRenderer][i18] = trackGroup;
            iArr2[findRenderer][i18] = formatSupport;
            iArr[findRenderer] = i18 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr3 = new int[rendererCapabilitiesArr.length];
        for (int i19 = 0; i19 < rendererCapabilitiesArr.length; i19++) {
            int i26 = iArr[i19];
            trackGroupArrayArr[i19] = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[i19], i26));
            iArr2[i19] = (int[][]) Arrays.copyOf(iArr2[i19], i26);
            iArr3[i19] = rendererCapabilitiesArr[i19].getTrackType();
        }
        TrackGroupArray trackGroupArray2 = new TrackGroupArray((TrackGroup[]) Arrays.copyOf(trackGroupArr[rendererCapabilitiesArr.length], iArr[rendererCapabilitiesArr.length]));
        TrackSelection[] selectTracks = selectTracks(rendererCapabilitiesArr, trackGroupArrayArr, iArr2);
        int i27 = 0;
        while (true) {
            TrackSelection trackSelection = null;
            if (i27 >= rendererCapabilitiesArr.length) {
                break;
            }
            if (this.rendererDisabledFlags.get(i27)) {
                selectTracks[i27] = null;
            } else {
                TrackGroupArray trackGroupArray3 = trackGroupArrayArr[i27];
                if (hasSelectionOverride(i27, trackGroupArray3)) {
                    SelectionOverride selectionOverride = this.selectionOverrides.get(i27).get(trackGroupArray3);
                    if (selectionOverride != null) {
                        trackSelection = selectionOverride.createTrackSelection(trackGroupArray3);
                    }
                    selectTracks[i27] = trackSelection;
                }
            }
            i27++;
        }
        boolean[] determineEnabledRenderers = determineEnabledRenderers(rendererCapabilitiesArr, selectTracks);
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr3, trackGroupArrayArr, mixedMimeTypeAdaptationSupport, iArr2, trackGroupArray2);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCapabilitiesArr.length];
        for (int i28 = 0; i28 < rendererCapabilitiesArr.length; i28++) {
            if (determineEnabledRenderers[i28]) {
                rendererConfiguration = RendererConfiguration.DEFAULT;
            } else {
                rendererConfiguration = null;
            }
            rendererConfigurationArr[i28] = rendererConfiguration;
        }
        maybeConfigureRenderersForTunneling(rendererCapabilitiesArr, trackGroupArrayArr, iArr2, rendererConfigurationArr, selectTracks, this.tunnelingAudioSessionId);
        return new TrackSelectorResult(trackGroupArray, determineEnabledRenderers, new TrackSelectionArray(selectTracks), mappedTrackInfo, rendererConfigurationArr);
    }

    protected abstract TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException;

    public final void setRendererDisabled(int i3, boolean z16) {
        if (this.rendererDisabledFlags.get(i3) == z16) {
            return;
        }
        this.rendererDisabledFlags.put(i3, z16);
        invalidate();
    }

    public final void setSelectionOverride(int i3, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        Map<TrackGroupArray, SelectionOverride> map = this.selectionOverrides.get(i3);
        if (map == null) {
            map = new HashMap<>();
            this.selectionOverrides.put(i3, map);
        }
        if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
            return;
        }
        map.put(trackGroupArray, selectionOverride);
        invalidate();
    }

    public void setTunnelingAudioSessionId(int i3) {
        if (this.tunnelingAudioSessionId != i3) {
            this.tunnelingAudioSessionId = i3;
            invalidate();
        }
    }

    public final void clearSelectionOverrides() {
        if (this.selectionOverrides.size() == 0) {
            return;
        }
        this.selectionOverrides.clear();
        invalidate();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        private final int[][][] formatSupport;
        public final int length;
        private final int[] mixedMimeTypeAdaptiveSupport;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray[] trackGroups;
        private final TrackGroupArray unassociatedTrackGroups;

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.trackGroups = trackGroupArrayArr;
            this.formatSupport = iArr3;
            this.mixedMimeTypeAdaptiveSupport = iArr2;
            this.unassociatedTrackGroups = trackGroupArray;
            this.length = trackGroupArrayArr.length;
        }

        public int getAdaptiveSupport(int i3, int i16, boolean z16) {
            int i17 = this.trackGroups[i3].get(i16).length;
            int[] iArr = new int[i17];
            int i18 = 0;
            for (int i19 = 0; i19 < i17; i19++) {
                int trackFormatSupport = getTrackFormatSupport(i3, i16, i19);
                if (trackFormatSupport == 4 || (z16 && trackFormatSupport == 3)) {
                    iArr[i18] = i19;
                    i18++;
                }
            }
            return getAdaptiveSupport(i3, i16, Arrays.copyOf(iArr, i18));
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
        
            r1 = r1 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getRendererSupport(int i3) {
            int i16;
            int[][] iArr = this.formatSupport[i3];
            int i17 = 0;
            int i18 = 0;
            while (i17 < iArr.length) {
                int i19 = 0;
                while (true) {
                    int[] iArr2 = iArr[i17];
                    if (i19 < iArr2.length) {
                        int i26 = iArr2[i19] & 7;
                        if (i26 != 3) {
                            if (i26 == 4) {
                                return 3;
                            }
                            i16 = 1;
                        } else {
                            i16 = 2;
                        }
                        i18 = Math.max(i18, i16);
                        i19++;
                    }
                }
            }
            return i18;
        }

        public int getTrackFormatSupport(int i3, int i16, int i17) {
            return this.formatSupport[i3][i16][i17] & 7;
        }

        public TrackGroupArray getTrackGroups(int i3) {
            return this.trackGroups[i3];
        }

        public int getTrackTypeRendererSupport(int i3) {
            int i16 = 0;
            for (int i17 = 0; i17 < this.length; i17++) {
                if (this.rendererTrackTypes[i17] == i3) {
                    i16 = Math.max(i16, getRendererSupport(i17));
                }
            }
            return i16;
        }

        public TrackGroupArray getUnassociatedTrackGroups() {
            return this.unassociatedTrackGroups;
        }

        public int getAdaptiveSupport(int i3, int i16, int[] iArr) {
            int i17 = 0;
            int i18 = 16;
            String str = null;
            boolean z16 = false;
            int i19 = 0;
            while (i17 < iArr.length) {
                String str2 = this.trackGroups[i3].get(i16).getFormat(iArr[i17]).sampleMimeType;
                int i26 = i19 + 1;
                if (i19 == 0) {
                    str = str2;
                } else {
                    z16 |= !Util.areEqual(str, str2);
                }
                i18 = Math.min(i18, this.formatSupport[i3][i16][i17] & 24);
                i17++;
                i19 = i26;
            }
            return z16 ? Math.min(i18, this.mixedMimeTypeAdaptiveSupport[i3]) : i18;
        }
    }
}
