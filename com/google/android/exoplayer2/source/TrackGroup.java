package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TrackGroup {
    private final Format[] formats;
    private int hashCode;
    public final int length;

    public TrackGroup(Format... formatArr) {
        boolean z16;
        if (formatArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats)) {
            return true;
        }
        return false;
    }

    public Format getFormat(int i3) {
        return this.formats[i3];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public int indexOf(Format format) {
        int i3 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i3 < formatArr.length) {
                if (format == formatArr[i3]) {
                    return i3;
                }
                i3++;
            } else {
                return -1;
            }
        }
    }
}
