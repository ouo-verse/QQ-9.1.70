package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface SeekMap {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            if (this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            sb5.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = ", " + this.second;
            }
            sb5.append(str);
            sb5.append("]");
            return sb5.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public Unseekable(long j3) {
            this(j3, 0L);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long j3) {
            return this.startSeekPoints;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j3, long j16) {
            this.durationUs = j3;
            this.startSeekPoints = new SeekPoints(j16 == 0 ? SeekPoint.START : new SeekPoint(0L, j16));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j3);

    boolean isSeekable();
}
