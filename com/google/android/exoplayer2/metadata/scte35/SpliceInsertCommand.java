package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand[] newArray(int i3) {
            return new SpliceInsertCommand[i3];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        ComponentSplice(int i3, long j3, long j16) {
            this.componentTag = i3;
            this.componentSplicePts = j3;
            this.componentSplicePlaybackPositionUs = j16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j3, TimestampAdjuster timestampAdjuster) {
        boolean z16;
        List list;
        boolean z17;
        boolean z18;
        long j16;
        boolean z19;
        long j17;
        int i3;
        int i16;
        int i17;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        long j18;
        boolean z37;
        long j19;
        boolean z38;
        long j26;
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        List emptyList = Collections.emptyList();
        if (!z16) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if ((readUnsignedByte & 128) != 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if ((readUnsignedByte & 64) != 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if ((readUnsignedByte & 32) != 0) {
                z29 = true;
            } else {
                z29 = false;
            }
            if ((readUnsignedByte & 16) != 0) {
                z36 = true;
            } else {
                z36 = false;
            }
            if (z28 && !z36) {
                j18 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j3);
            } else {
                j18 = -9223372036854775807L;
            }
            if (!z28) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList = new ArrayList(readUnsignedByte2);
                for (int i18 = 0; i18 < readUnsignedByte2; i18++) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if (!z36) {
                        j26 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j3);
                    } else {
                        j26 = -9223372036854775807L;
                    }
                    arrayList.add(new ComponentSplice(readUnsignedByte3, j26, timestampAdjuster.adjustTsTimestamp(j26)));
                }
                emptyList = arrayList;
            }
            if (z29) {
                long readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                if ((128 & readUnsignedByte4) != 0) {
                    z38 = true;
                } else {
                    z38 = false;
                }
                j19 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                z37 = z38;
            } else {
                z37 = false;
                j19 = -9223372036854775807L;
            }
            i3 = parsableByteArray.readUnsignedShort();
            z26 = z28;
            i16 = parsableByteArray.readUnsignedByte();
            i17 = parsableByteArray.readUnsignedByte();
            list = emptyList;
            long j27 = j18;
            z19 = z37;
            j17 = j19;
            z18 = z36;
            z17 = z27;
            j16 = j27;
        } else {
            list = emptyList;
            z17 = false;
            z18 = false;
            j16 = -9223372036854775807L;
            z19 = false;
            j17 = -9223372036854775807L;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            z26 = false;
        }
        return new SpliceInsertCommand(readUnsignedInt, z16, z17, z26, z18, j16, timestampAdjuster.adjustTsTimestamp(j16), list, z19, j17, i3, i16, i17);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i16 = 0; i16 < size; i16++) {
            this.componentSpliceList.get(i16).writeToParcel(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }

    SpliceInsertCommand(long j3, boolean z16, boolean z17, boolean z18, boolean z19, long j16, long j17, List<ComponentSplice> list, boolean z26, long j18, int i3, int i16, int i17) {
        this.spliceEventId = j3;
        this.spliceEventCancelIndicator = z16;
        this.outOfNetworkIndicator = z17;
        this.programSpliceFlag = z18;
        this.spliceImmediateFlag = z19;
        this.programSplicePts = j16;
        this.programSplicePlaybackPositionUs = j17;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z26;
        this.breakDurationUs = j18;
        this.uniqueProgramId = i3;
        this.availNum = i16;
        this.availsExpected = i17;
    }

    SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
