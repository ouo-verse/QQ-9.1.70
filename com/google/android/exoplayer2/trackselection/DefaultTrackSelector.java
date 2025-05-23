package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultTrackSelector extends MappingTrackSelector {
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = new int[0];
    private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    private final TrackSelection.Factory adaptiveTrackSelectionFactory;
    private final AtomicReference<Parameters> paramsReference;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AudioConfigurationTuple {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i3, int i16, String str) {
            this.channelCount = i3;
            this.sampleRate = i16;
            this.mimeType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioConfigurationTuple.class != obj.getClass()) {
                return false;
            }
            AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
            if (this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = ((this.channelCount * 31) + this.sampleRate) * 31;
            String str = this.mimeType;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final int defaultSelectionFlagScore;
        private final int matchLanguageScore;
        private final Parameters parameters;
        private final int sampleRate;
        private final int withinRendererCapabilitiesScore;

        public AudioTrackScore(Format format, Parameters parameters, int i3) {
            this.parameters = parameters;
            this.withinRendererCapabilitiesScore = DefaultTrackSelector.isSupported(i3, false) ? 1 : 0;
            this.matchLanguageScore = DefaultTrackSelector.formatHasLanguage(format, parameters.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) != 0 ? 1 : 0;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioTrackScore.class != obj.getClass()) {
                return false;
            }
            AudioTrackScore audioTrackScore = (AudioTrackScore) obj;
            if (this.withinRendererCapabilitiesScore == audioTrackScore.withinRendererCapabilitiesScore && this.matchLanguageScore == audioTrackScore.matchLanguageScore && this.defaultSelectionFlagScore == audioTrackScore.defaultSelectionFlagScore && this.channelCount == audioTrackScore.channelCount && this.sampleRate == audioTrackScore.sampleRate && this.bitrate == audioTrackScore.bitrate) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.withinRendererCapabilitiesScore * 31) + this.matchLanguageScore) * 31) + this.defaultSelectionFlagScore) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull AudioTrackScore audioTrackScore) {
            int compareInts;
            int i3 = this.withinRendererCapabilitiesScore;
            int i16 = audioTrackScore.withinRendererCapabilitiesScore;
            if (i3 != i16) {
                return DefaultTrackSelector.compareInts(i3, i16);
            }
            int i17 = this.matchLanguageScore;
            int i18 = audioTrackScore.matchLanguageScore;
            if (i17 != i18) {
                return DefaultTrackSelector.compareInts(i17, i18);
            }
            int i19 = this.defaultSelectionFlagScore;
            int i26 = audioTrackScore.defaultSelectionFlagScore;
            if (i19 != i26) {
                return DefaultTrackSelector.compareInts(i19, i26);
            }
            if (this.parameters.forceLowestBitrate) {
                return DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
            }
            int i27 = i3 != 1 ? -1 : 1;
            int i28 = this.channelCount;
            int i29 = audioTrackScore.channelCount;
            if (i28 != i29) {
                compareInts = DefaultTrackSelector.compareInts(i28, i29);
            } else {
                int i36 = this.sampleRate;
                int i37 = audioTrackScore.sampleRate;
                compareInts = i36 != i37 ? DefaultTrackSelector.compareInts(i36, i37) : DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
            }
            return i27 * compareInts;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Parameters {
        public static final Parameters DEFAULT = new Parameters();
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final int disabledTextTrackSelectionFlags;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceLowestBitrate;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final String preferredAudioLanguage;
        public final String preferredTextLanguage;
        public final boolean selectUndeterminedTextLanguage;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (this.selectUndeterminedTextLanguage == parameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == parameters.disabledTextTrackSelectionFlags && this.forceLowestBitrate == parameters.forceLowestBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((this.selectUndeterminedTextLanguage ? 1 : 0) * 31) + this.disabledTextTrackSelectionFlags) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxVideoBitrate) * 31) + this.preferredAudioLanguage.hashCode()) * 31) + this.preferredTextLanguage.hashCode();
        }

        Parameters() {
            this(null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        Parameters(String str, String str2, boolean z16, int i3, boolean z17, boolean z18, boolean z19, int i16, int i17, int i18, boolean z26, boolean z27, int i19, int i26, boolean z28) {
            this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
            this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
            this.selectUndeterminedTextLanguage = z16;
            this.disabledTextTrackSelectionFlags = i3;
            this.forceLowestBitrate = z17;
            this.allowMixedMimeAdaptiveness = z18;
            this.allowNonSeamlessAdaptiveness = z19;
            this.maxVideoWidth = i16;
            this.maxVideoHeight = i17;
            this.maxVideoBitrate = i18;
            this.exceedVideoConstraintsIfNecessary = z26;
            this.exceedRendererCapabilitiesIfNecessary = z27;
            this.viewportWidth = i19;
            this.viewportHeight = i26;
            this.viewportOrientationMayChange = z28;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ParametersBuilder {
        private boolean allowMixedMimeAdaptiveness;
        private boolean allowNonSeamlessAdaptiveness;
        private int disabledTextTrackSelectionFlags;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceLowestBitrate;
        private int maxVideoBitrate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private String preferredAudioLanguage;
        private String preferredTextLanguage;
        private boolean selectUndeterminedTextLanguage;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        public Parameters build() {
            return new Parameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.allowMixedMimeAdaptiveness, this.allowNonSeamlessAdaptiveness, this.maxVideoWidth, this.maxVideoHeight, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.exceedRendererCapabilitiesIfNecessary, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange);
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public ParametersBuilder setAllowMixedMimeAdaptiveness(boolean z16) {
            this.allowMixedMimeAdaptiveness = z16;
            return this;
        }

        public ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean z16) {
            this.allowNonSeamlessAdaptiveness = z16;
            return this;
        }

        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i3) {
            this.disabledTextTrackSelectionFlags = i3;
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z16) {
            this.exceedRendererCapabilitiesIfNecessary = z16;
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z16) {
            this.exceedVideoConstraintsIfNecessary = z16;
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z16) {
            this.forceLowestBitrate = z16;
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int i3) {
            this.maxVideoBitrate = i3;
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int i3, int i16) {
            this.maxVideoWidth = i3;
            this.maxVideoHeight = i16;
            return this;
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public ParametersBuilder setPreferredAudioLanguage(String str) {
            this.preferredAudioLanguage = str;
            return this;
        }

        public ParametersBuilder setPreferredTextLanguage(String str) {
            this.preferredTextLanguage = str;
            return this;
        }

        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z16) {
            this.selectUndeterminedTextLanguage = z16;
            return this;
        }

        public ParametersBuilder setViewportSize(int i3, int i16, boolean z16) {
            this.viewportWidth = i3;
            this.viewportHeight = i16;
            this.viewportOrientationMayChange = z16;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z16) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return setViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z16);
        }

        public ParametersBuilder() {
            this(Parameters.DEFAULT);
        }

        ParametersBuilder(Parameters parameters) {
            this.preferredAudioLanguage = parameters.preferredAudioLanguage;
            this.preferredTextLanguage = parameters.preferredTextLanguage;
            this.selectUndeterminedTextLanguage = parameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = parameters.disabledTextTrackSelectionFlags;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.allowMixedMimeAdaptiveness = parameters.allowMixedMimeAdaptiveness;
            this.allowNonSeamlessAdaptiveness = parameters.allowNonSeamlessAdaptiveness;
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
        }
    }

    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
    }

    private static int compareFormatValues(int i3, int i16) {
        if (i3 == -1) {
            if (i16 != -1) {
                return -1;
            }
            return 0;
        }
        if (i16 == -1) {
            return 1;
        }
        return i3 - i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareInts(int i3, int i16) {
        if (i3 > i16) {
            return 1;
        }
        if (i16 > i3) {
            return -1;
        }
        return 0;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i3, String str, int i16, int i17, int i18, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i3, i16, i17, i18)) {
                list.remove(size);
            }
        }
    }

    protected static boolean formatHasLanguage(Format format, String str) {
        if (str != null && TextUtils.equals(str, Util.normalizeLanguageCode(format.language))) {
            return true;
        }
        return false;
    }

    protected static boolean formatHasNoLanguage(Format format) {
        if (!TextUtils.isEmpty(format.language) && !formatHasLanguage(format, C.LANGUAGE_UNDETERMINED)) {
            return false;
        }
        return true;
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i3 = 0;
        for (int i16 = 0; i16 < trackGroup.length; i16++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i16), iArr[i16], audioConfigurationTuple)) {
                i3++;
            }
        }
        return i3;
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z16) {
        String str;
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        int i3 = 0;
        AudioConfigurationTuple audioConfigurationTuple = null;
        for (int i16 = 0; i16 < trackGroup.length; i16++) {
            Format format = trackGroup.getFormat(i16);
            int i17 = format.channelCount;
            int i18 = format.sampleRate;
            if (z16) {
                str = null;
            } else {
                str = format.sampleMimeType;
            }
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(i17, i18, str);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i3) {
                i3 = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i3 > 1) {
            int[] iArr2 = new int[i3];
            int i19 = 0;
            for (int i26 = 0; i26 < trackGroup.length; i26++) {
                if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i26), iArr[i26], audioConfigurationTuple)) {
                    iArr2[i19] = i26;
                    i19++;
                }
            }
            return iArr2;
        }
        return NO_TRACKS;
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i3, String str, int i16, int i17, int i18, List<Integer> list) {
        int i19 = 0;
        for (int i26 = 0; i26 < list.size(); i26++) {
            int intValue = list.get(i26).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i3, i16, i17, i18)) {
                i19++;
            }
        }
        return i19;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z16, int i3, int i16, int i17, int i18, int i19, int i26, boolean z17) {
        String str;
        int adaptiveVideoTrackCountForMimeType;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i19, i26, z17);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z16) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i27 = 0;
            for (int i28 = 0; i28 < viewportFilteredTrackIndices.size(); i28++) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i28).intValue()).sampleMimeType;
                if (hashSet.add(str3) && (adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i3, str3, i16, i17, i18, viewportFilteredTrackIndices)) > i27) {
                    i27 = adaptiveVideoTrackCountForMimeType;
                    str2 = str3;
                }
            }
            str = str2;
        } else {
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i3, str, i16, i17, i18, viewportFilteredTrackIndices);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        return Util.toArray(viewportFilteredTrackIndices);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (r1 != r3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Point getMaxVideoSizeInViewport(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        if (z16) {
            boolean z18 = true;
            if (i17 > i18) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (i3 <= i16) {
                z18 = false;
            }
        }
        i16 = i3;
        i3 = i16;
        int i19 = i17 * i3;
        int i26 = i18 * i16;
        if (i19 >= i26) {
            return new Point(i16, Util.ceilDivide(i26, i17));
        }
        return new Point(Util.ceilDivide(i19, i18), i3);
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i3, int i16, boolean z16) {
        int i17;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i18 = 0; i18 < trackGroup.length; i18++) {
            arrayList.add(Integer.valueOf(i18));
        }
        if (i3 != Integer.MAX_VALUE && i16 != Integer.MAX_VALUE) {
            int i19 = Integer.MAX_VALUE;
            for (int i26 = 0; i26 < trackGroup.length; i26++) {
                Format format = trackGroup.getFormat(i26);
                int i27 = format.width;
                if (i27 > 0 && (i17 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z16, i3, i16, i27, i17);
                    int i28 = format.width;
                    int i29 = format.height;
                    int i36 = i28 * i29;
                    if (i28 >= ((int) (maxVideoSizeInViewport.x * 0.98f)) && i29 >= ((int) (maxVideoSizeInViewport.y * 0.98f)) && i36 < i19) {
                        i19 = i36;
                    }
                }
            }
            if (i19 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i19) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean isSupported(int i3, boolean z16) {
        int i16 = i3 & 7;
        if (i16 != 4 && (!z16 || i16 != 3)) {
            return false;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i3, AudioConfigurationTuple audioConfigurationTuple) {
        if (!isSupported(i3, false) || format.channelCount != audioConfigurationTuple.channelCount || format.sampleRate != audioConfigurationTuple.sampleRate) {
            return false;
        }
        String str = audioConfigurationTuple.mimeType;
        if (str != null && !TextUtils.equals(str, format.sampleMimeType)) {
            return false;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i3, int i16, int i17, int i18, int i19) {
        if (!isSupported(i3, false) || (i3 & i16) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i26 = format.width;
        if (i26 != -1 && i26 > i17) {
            return false;
        }
        int i27 = format.height;
        if (i27 != -1 && i27 > i18) {
            return false;
        }
        int i28 = format.bitrate;
        if (i28 != -1 && i28 > i19) {
            return false;
        }
        return true;
    }

    private static TrackSelection selectAdaptiveVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i3;
        boolean z16;
        if (parameters.allowNonSeamlessAdaptiveness) {
            i3 = 24;
        } else {
            i3 = 16;
        }
        if (parameters.allowMixedMimeAdaptiveness && (rendererCapabilities.supportsMixedMimeTypeAdaptation() & i3) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (int i16 = 0; i16 < trackGroupArray.length; i16++) {
            TrackGroup trackGroup = trackGroupArray.get(i16);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i16], z16, i3, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return factory.createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        if (compareFormatValues(r2.bitrate, r10) < 0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TrackSelection selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        boolean z16;
        int i3;
        boolean z17;
        int compareFormatValues;
        int i16;
        int i17;
        int i18;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int i19 = -1;
        int i26 = -1;
        int i27 = -1;
        int i28 = 0;
        TrackGroup trackGroup = null;
        int i29 = 0;
        int i36 = 0;
        while (i28 < trackGroupArray2.length) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i28);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            int[] iArr2 = iArr[i28];
            int i37 = 0;
            while (i37 < trackGroup2.length) {
                if (isSupported(iArr2[i37], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i37);
                    boolean z18 = true;
                    if (viewportFilteredTrackIndices.contains(Integer.valueOf(i37)) && (((i16 = format.width) == i19 || i16 <= parameters.maxVideoWidth) && (((i17 = format.height) == i19 || i17 <= parameters.maxVideoHeight) && ((i18 = format.bitrate) == i19 || i18 <= parameters.maxVideoBitrate)))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 || parameters.exceedVideoConstraintsIfNecessary) {
                        if (z16) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        boolean isSupported = isSupported(iArr2[i37], false);
                        if (isSupported) {
                            i3 += 1000;
                        }
                        if (i3 > i36) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i3 == i36) {
                            if (!parameters.forceLowestBitrate) {
                                int pixelCount = format.getPixelCount();
                                if (pixelCount != i26) {
                                    compareFormatValues = compareFormatValues(pixelCount, i26);
                                } else {
                                    compareFormatValues = compareFormatValues(format.bitrate, i27);
                                }
                                if (isSupported) {
                                }
                                z18 = false;
                                z17 = z18;
                            }
                        }
                        if (z17) {
                            i27 = format.bitrate;
                            i26 = format.getPixelCount();
                            trackGroup = trackGroup2;
                            i29 = i37;
                            i36 = i3;
                        }
                    }
                }
                i37++;
                i19 = -1;
            }
            i28++;
            trackGroupArray2 = trackGroupArray;
            i19 = -1;
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i29);
    }

    public Parameters getParameters() {
        return this.paramsReference.get();
    }

    protected TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i3 = -1;
        int i16 = -1;
        AudioTrackScore audioTrackScore = null;
        for (int i17 = 0; i17 < trackGroupArray.length; i17++) {
            TrackGroup trackGroup = trackGroupArray.get(i17);
            int[] iArr2 = iArr[i17];
            for (int i18 = 0; i18 < trackGroup.length; i18++) {
                if (isSupported(iArr2[i18], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i18), parameters, iArr2[i18]);
                    if (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0) {
                        i3 = i17;
                        i16 = i18;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray.get(i3);
        if (!parameters.forceLowestBitrate && factory != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i3], parameters.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                return factory.createTrackSelection(trackGroup2, adaptiveAudioTracks);
            }
        }
        return new FixedTrackSelection(trackGroup2, i16);
    }

    protected TrackSelection selectOtherTrack(int i3, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        boolean z16;
        TrackGroup trackGroup = null;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < trackGroupArray.length; i18++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i18);
            int[] iArr2 = iArr[i18];
            for (int i19 = 0; i19 < trackGroup2.length; i19++) {
                if (isSupported(iArr2[i19], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i26 = 1;
                    if ((trackGroup2.getFormat(i19).selectionFlags & 1) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        i26 = 2;
                    }
                    if (isSupported(iArr2[i19], false)) {
                        i26 += 1000;
                    }
                    if (i26 > i17) {
                        trackGroup = trackGroup2;
                        i16 = i19;
                        i17 = i26;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        byte b16;
        byte b17;
        int i3;
        int i16 = 0;
        int i17 = 0;
        TrackGroup trackGroup = null;
        for (int i18 = 0; i18 < trackGroupArray.length; i18++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i18);
            int[] iArr2 = iArr[i18];
            for (int i19 = 0; i19 < trackGroup2.length; i19++) {
                if (isSupported(iArr2[i19], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i19);
                    int i26 = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
                    int i27 = 1;
                    if ((i26 & 1) != 0) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    if ((i26 & 2) != 0) {
                        b17 = true;
                    } else {
                        b17 = false;
                    }
                    boolean formatHasLanguage = formatHasLanguage(format, parameters.preferredTextLanguage);
                    if (!formatHasLanguage && (!parameters.selectUndeterminedTextLanguage || !formatHasNoLanguage(format))) {
                        if (b16 != false) {
                            i27 = 3;
                        } else if (b17 != false) {
                            if (formatHasLanguage(format, parameters.preferredAudioLanguage)) {
                                i27 = 2;
                            }
                        }
                    } else {
                        if (b16 != false) {
                            i3 = 8;
                        } else if (b17 == false) {
                            i3 = 6;
                        } else {
                            i3 = 4;
                        }
                        i27 = i3 + (formatHasLanguage ? 1 : 0);
                    }
                    if (isSupported(iArr2[i19], false)) {
                        i27 += 1000;
                    }
                    if (i27 > i17) {
                        trackGroup = trackGroup2;
                        i16 = i19;
                        i17 = i27;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i16);
    }

    @Override // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    protected TrackSelection[] selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray[] trackGroupArrayArr, int[][][] iArr) throws ExoPlaybackException {
        TrackSelection.Factory factory;
        int length = rendererCapabilitiesArr.length;
        TrackSelection[] trackSelectionArr = new TrackSelection[length];
        Parameters parameters = this.paramsReference.get();
        boolean z16 = false;
        int i3 = 0;
        boolean z17 = false;
        while (true) {
            boolean z18 = true;
            if (i3 >= length) {
                break;
            }
            if (2 == rendererCapabilitiesArr[i3].getTrackType()) {
                if (!z16) {
                    TrackSelection selectVideoTrack = selectVideoTrack(rendererCapabilitiesArr[i3], trackGroupArrayArr[i3], iArr[i3], parameters, this.adaptiveTrackSelectionFactory);
                    trackSelectionArr[i3] = selectVideoTrack;
                    if (selectVideoTrack != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                if (trackGroupArrayArr[i3].length <= 0) {
                    z18 = false;
                }
                z17 |= z18;
            }
            i3++;
        }
        boolean z19 = false;
        boolean z26 = false;
        for (int i16 = 0; i16 < length; i16++) {
            int trackType = rendererCapabilitiesArr[i16].getTrackType();
            if (trackType != 1) {
                if (trackType != 2) {
                    if (trackType != 3) {
                        trackSelectionArr[i16] = selectOtherTrack(rendererCapabilitiesArr[i16].getTrackType(), trackGroupArrayArr[i16], iArr[i16], parameters);
                    } else if (!z26) {
                        TrackSelection selectTextTrack = selectTextTrack(trackGroupArrayArr[i16], iArr[i16], parameters);
                        trackSelectionArr[i16] = selectTextTrack;
                        if (selectTextTrack != null) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                    }
                }
            } else if (!z19) {
                TrackGroupArray trackGroupArray = trackGroupArrayArr[i16];
                int[][] iArr2 = iArr[i16];
                if (z17) {
                    factory = null;
                } else {
                    factory = this.adaptiveTrackSelectionFactory;
                }
                TrackSelection selectAudioTrack = selectAudioTrack(trackGroupArray, iArr2, parameters, factory);
                trackSelectionArr[i16] = selectAudioTrack;
                if (selectAudioTrack != null) {
                    z19 = true;
                } else {
                    z19 = false;
                }
            }
        }
        return trackSelectionArr;
    }

    protected TrackSelection selectVideoTrack(RendererCapabilities rendererCapabilities, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackSelection trackSelection;
        if (!parameters.forceLowestBitrate && factory != null) {
            trackSelection = selectAdaptiveVideoTrack(rendererCapabilities, trackGroupArray, iArr, parameters, factory);
        } else {
            trackSelection = null;
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, parameters);
        }
        return trackSelection;
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.paramsReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.paramsReference = new AtomicReference<>(Parameters.DEFAULT);
    }
}
