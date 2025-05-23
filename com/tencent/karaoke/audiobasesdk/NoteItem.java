package com.tencent.karaoke.audiobasesdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NoteItem {
    public static final int INVALID_GROVE_VALUE = -1;
    public static final int MAX_GROVE_VALUE = 100;
    public static final int MAX_VOICE_PITCH_VALUE = 90;
    public int duration;
    public int endTime;
    public int height;
    public int startTime;

    public int getEndTime() {
        return this.startTime + this.duration;
    }

    public boolean isSame(int i3) {
        if (Math.abs(this.height - i3) < 11 && this.height > 0 && i3 > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("startTime = %d ; endTime = %d ; duration = %d ; height = %d;", Integer.valueOf(this.startTime), Integer.valueOf(this.endTime), Integer.valueOf(this.duration), Integer.valueOf(this.height));
    }
}
