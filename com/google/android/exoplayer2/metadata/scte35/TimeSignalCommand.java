package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand[] newArray(int i3) {
            return new TimeSignalCommand[i3];
        }
    };
    public final long playbackPositionUs;
    public final long ptsTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSignalCommand parseFromSection(ParsableByteArray parsableByteArray, long j3, TimestampAdjuster timestampAdjuster) {
        long parseSpliceTime = parseSpliceTime(parsableByteArray, j3);
        return new TimeSignalCommand(parseSpliceTime, timestampAdjuster.adjustTsTimestamp(parseSpliceTime));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long parseSpliceTime(ParsableByteArray parsableByteArray, long j3) {
        long readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((128 & readUnsignedByte) != 0) {
            return 8589934591L & ((((readUnsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j3);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }

    TimeSignalCommand(long j3, long j16) {
        this.ptsTime = j3;
        this.playbackPositionUs = j16;
    }
}
