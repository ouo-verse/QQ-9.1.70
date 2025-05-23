package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.cues = list;
        int size = list.size();
        this.numCues = size;
        this.cueTimesUs = new long[size * 2];
        for (int i3 = 0; i3 < this.numCues; i3++) {
            WebvttCue webvttCue = list.get(i3);
            int i16 = i3 * 2;
            long[] jArr = this.cueTimesUs;
            jArr[i16] = webvttCue.startTime;
            jArr[i16 + 1] = webvttCue.endTime;
        }
        long[] jArr2 = this.cueTimesUs;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.sortedCueTimesUs = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j3) {
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        WebvttCue webvttCue = null;
        for (int i3 = 0; i3 < this.numCues; i3++) {
            long[] jArr = this.cueTimesUs;
            int i16 = i3 * 2;
            if (jArr[i16] <= j3 && j3 < jArr[i16 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                WebvttCue webvttCue2 = this.cues.get(i3);
                if (webvttCue2.isNormalCue()) {
                    if (webvttCue == null) {
                        webvttCue = webvttCue2;
                    } else if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(webvttCue.text).append((CharSequence) "\n").append(webvttCue2.text);
                    } else {
                        spannableStringBuilder.append((CharSequence) "\n").append(webvttCue2.text);
                    }
                } else {
                    arrayList.add(webvttCue2);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WebvttCue(spannableStringBuilder));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i3) {
        boolean z16;
        boolean z17 = true;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (i3 >= this.sortedCueTimesUs.length) {
            z17 = false;
        }
        Assertions.checkArgument(z17);
        return this.sortedCueTimesUs[i3];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j3) {
        int binarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, j3, false, false);
        if (binarySearchCeil >= this.sortedCueTimesUs.length) {
            return -1;
        }
        return binarySearchCeil;
    }
}
