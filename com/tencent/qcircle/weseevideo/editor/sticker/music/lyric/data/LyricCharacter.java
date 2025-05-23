package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LyricCharacter {
    public final long mDuration;
    public final int mEnd;
    public final int mStart;
    public final long mStartTime;

    public LyricCharacter(long j3, long j16, int i3, int i16) {
        this.mStartTime = j3;
        this.mDuration = j16;
        this.mStart = i3;
        this.mEnd = i16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("LyricCharacter -> ");
        sb5.append("mStartTime:" + this.mStartTime);
        sb5.append(", mDuration:" + this.mDuration);
        sb5.append(", mStart:" + this.mStart);
        sb5.append(", mEnd:" + this.mEnd);
        return sb5.toString();
    }
}
