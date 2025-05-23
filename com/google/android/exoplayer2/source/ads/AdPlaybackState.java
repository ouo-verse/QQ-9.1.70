package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.support.annotation.CheckResult;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    /* loaded from: classes2.dex */
    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        @CheckResult
        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i3) {
            int length = jArr.length;
            int max = Math.max(i3, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        @CheckResult
        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i3) {
            int length = iArr.length;
            int max = Math.max(i3, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i3) {
            int i16;
            int i17 = i3 + 1;
            while (true) {
                int[] iArr = this.states;
                if (i17 >= iArr.length || (i16 = iArr[i17]) == 0 || i16 == 1) {
                    break;
                }
                i17++;
            }
            return i17;
        }

        public boolean hasUnplayedAds() {
            if (this.count != -1 && getFirstAdIndexToPlay() >= this.count) {
                return false;
            }
            return true;
        }

        @CheckResult
        public AdGroup withAdCount(int i3) {
            boolean z16;
            if (this.count == -1 && this.states.length <= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            Assertions.checkArgument(z16);
            return new AdGroup(i3, copyStatesWithSpaceForAdCount(this.states, i3), (Uri[]) Arrays.copyOf(this.uris, i3), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i3));
        }

        @CheckResult
        public AdGroup withAdDurationsUs(long[] jArr) {
            boolean z16;
            if (this.count != -1 && jArr.length > this.uris.length) {
                z16 = false;
            } else {
                z16 = true;
            }
            Assertions.checkArgument(z16);
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        @CheckResult
        public AdGroup withAdState(int i3, int i16) {
            boolean z16;
            int i17 = this.count;
            boolean z17 = false;
            if (i17 != -1 && i16 >= i17) {
                z16 = false;
            } else {
                z16 = true;
            }
            Assertions.checkArgument(z16);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i16 + 1);
            int i18 = copyStatesWithSpaceForAdCount[i16];
            if (i18 == 0 || i18 == 1 || i18 == i3) {
                z17 = true;
            }
            Assertions.checkArgument(z17);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i16] = i3;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAdUri(Uri uri, int i3) {
            boolean z16;
            int i16 = this.count;
            boolean z17 = false;
            if (i16 != -1 && i3 >= i16) {
                z16 = false;
            } else {
                z16 = true;
            }
            Assertions.checkArgument(z16);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i3 + 1);
            if (copyStatesWithSpaceForAdCount[i3] == 0) {
                z17 = true;
            }
            Assertions.checkArgument(z17);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i3] = uri;
            copyStatesWithSpaceForAdCount[i3] = 1;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = copyOf[i3];
                if (i16 == 1 || i16 == 0) {
                    copyOf[i3] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        AdGroup(int i3, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i3;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface AdState {
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.adGroups[i3] = new AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = -9223372036854775807L;
    }

    public int getAdGroupIndexAfterPositionUs(long j3) {
        int i3 = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i3 >= jArr.length) {
                break;
            }
            long j16 = jArr[i3];
            if (j16 == Long.MIN_VALUE || (j3 < j16 && this.adGroups[i3].hasUnplayedAds())) {
                break;
            }
            i3++;
        }
        if (i3 >= this.adGroupTimesUs.length) {
            return -1;
        }
        return i3;
    }

    public int getAdGroupIndexForPositionUs(long j3) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0) {
            long j16 = this.adGroupTimesUs[length];
            if (j16 != Long.MIN_VALUE && j16 <= j3) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    @CheckResult
    public AdPlaybackState withAdCount(int i3, int i16) {
        boolean z16;
        if (i16 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i3].count == i16) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = this.adGroups[i3].withAdCount(i16);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        for (int i3 = 0; i3 < this.adGroupCount; i3++) {
            adGroupArr2[i3] = adGroupArr2[i3].withAdDurationsUs(jArr[i3]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdLoadError(int i3, int i16) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdState(4, i16);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdResumePositionUs(long j3) {
        if (this.adResumePositionUs == j3) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, j3, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withAdUri(int i3, int i16, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdUri(uri, i16);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withContentDurationUs(long j3) {
        if (this.contentDurationUs == j3) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j3);
    }

    @CheckResult
    public AdPlaybackState withPlayedAd(int i3, int i16) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAdState(3, i16);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public AdPlaybackState withSkippedAdGroup(int i3) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i3] = adGroupArr2[i3].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long j3, long j16) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j3;
        this.contentDurationUs = j16;
    }
}
