package com.google.android.exoplayer2.source;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TrackGroupArray {
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    private int hashCode;
    public final int length;
    private final TrackGroup[] trackGroups;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.length == trackGroupArray.length && Arrays.equals(this.trackGroups, trackGroupArray.trackGroups)) {
            return true;
        }
        return false;
    }

    public TrackGroup get(int i3) {
        return this.trackGroups[i3];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (this.trackGroups[i3] == trackGroup) {
                return i3;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }
}
