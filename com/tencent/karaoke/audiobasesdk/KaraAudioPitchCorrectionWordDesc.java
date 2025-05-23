package com.tencent.karaoke.audiobasesdk;

/* loaded from: classes7.dex */
public class KaraAudioPitchCorrectionWordDesc {
    public boolean mActiveFlag;
    public boolean mCorrectFlag;
    public int mCorrectNoteBeginMs;
    public int mCorrectNoteDurationMs;
    public int mCorrectNoteEndMs;
    public float mCorrectNoteHigh;
    public int mOriginNoteBeginMs;
    public int mOriginNoteDurationMs;
    public int mOriginNoteEndMs;
    public float mOriginNoteHigh;
    public String mWordString;

    public int getmCorrectNoteBeginMs() {
        return this.mCorrectNoteBeginMs;
    }

    public int getmCorrectNoteDurationMs() {
        return this.mCorrectNoteDurationMs;
    }

    public int getmCorrectNoteEndMs() {
        return this.mCorrectNoteEndMs;
    }

    public float getmCorrectNoteHigh() {
        return this.mCorrectNoteHigh;
    }

    public int getmOriginNoteBeginMs() {
        return this.mOriginNoteBeginMs;
    }

    public int getmOriginNoteDurationMs() {
        return this.mOriginNoteDurationMs;
    }

    public int getmOriginNoteEndMs() {
        return this.mOriginNoteEndMs;
    }

    public float getmOriginNoteHigh() {
        return this.mOriginNoteHigh;
    }

    public String getmWordString() {
        return this.mWordString;
    }

    public boolean ismActiveFlag() {
        return this.mActiveFlag;
    }

    public boolean ismCorrectFlag() {
        return this.mCorrectFlag;
    }

    public void setmActiveFlag(boolean z16) {
        this.mActiveFlag = z16;
    }

    public void setmCorrectFlag(boolean z16) {
        this.mCorrectFlag = z16;
    }

    public void setmCorrectNoteBeginMs(int i3) {
        this.mCorrectNoteBeginMs = i3;
    }

    public void setmCorrectNoteDurationMs(int i3) {
        this.mCorrectNoteDurationMs = i3;
    }

    public void setmCorrectNoteEndMs(int i3) {
        this.mCorrectNoteEndMs = i3;
    }

    public void setmCorrectNoteHigh(float f16) {
        this.mCorrectNoteHigh = f16;
    }

    public void setmOriginNoteBeginMs(int i3) {
        this.mOriginNoteBeginMs = i3;
    }

    public void setmOriginNoteDurationMs(int i3) {
        this.mOriginNoteDurationMs = i3;
    }

    public void setmOriginNoteEndMs(int i3) {
        this.mOriginNoteEndMs = i3;
    }

    public void setmOriginNoteHigh(float f16) {
        this.mOriginNoteHigh = f16;
    }

    public void setmWordString(String str) {
        this.mWordString = str;
    }

    public String toString() {
        return "KaraAudioPitchCorrectionWordDesc{mWordString='" + this.mWordString + "', mActiveFlag=" + this.mActiveFlag + ", mCorrectFlag=" + this.mCorrectFlag + ", mOriginNoteBeginMs=" + this.mOriginNoteBeginMs + ", mOriginNoteDurationMs=" + this.mOriginNoteDurationMs + ", mOriginNoteHigh=" + this.mOriginNoteHigh + ", mCorrectNoteBeginMs=" + this.mCorrectNoteBeginMs + ", mCorrectNoteDurationMs=" + this.mCorrectNoteDurationMs + ", mCorrectNoteHigh=" + this.mCorrectNoteHigh + ", mOriginNoteEndMs=" + this.mOriginNoteEndMs + ", mCorrectNoteEndMs=" + this.mCorrectNoteEndMs + '}';
    }
}
