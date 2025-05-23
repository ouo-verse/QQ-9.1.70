package com.google.android.exoplayer2.text.ttml;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TtmlSubtitle implements Subtitle {
    private final long[] eventTimesUs;
    private final Map<String, TtmlStyle> globalStyles;
    private final Map<String, TtmlRegion> regionMap;
    private final TtmlNode root;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        Map<String, TtmlStyle> emptyMap;
        this.root = ttmlNode;
        this.regionMap = map2;
        if (map != null) {
            emptyMap = Collections.unmodifiableMap(map);
        } else {
            emptyMap = Collections.emptyMap();
        }
        this.globalStyles = emptyMap;
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j3) {
        return this.root.getCues(j3, this.globalStyles, this.regionMap);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i3) {
        return this.eventTimesUs[i3];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    Map<String, TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j3) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j3, false, false);
        if (binarySearchCeil >= this.eventTimesUs.length) {
            return -1;
        }
        return binarySearchCeil;
    }

    TtmlNode getRoot() {
        return this.root;
    }
}
