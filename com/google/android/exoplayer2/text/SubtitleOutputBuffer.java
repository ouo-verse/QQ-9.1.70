package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j3) {
        return this.subtitle.getCues(j3 - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i3) {
        return this.subtitle.getEventTime(i3) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.subtitle.getEventTimeCount();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j3) {
        return this.subtitle.getNextEventTimeIndex(j3 - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public abstract void release();

    public void setContent(long j3, Subtitle subtitle, long j16) {
        this.timeUs = j3;
        this.subtitle = subtitle;
        if (j16 != Long.MAX_VALUE) {
            j3 = j16;
        }
        this.subsampleOffsetUs = j3;
    }
}
